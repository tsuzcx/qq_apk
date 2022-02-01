package com.tencent.mobileqq.profile;

import android.os.Parcel;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ProfileShoppingPhotoInfo
  extends Entity
{
  public static final int FOLLOW_TYPE_CANCEL_CARE = 3;
  public static final int FOLLOW_TYPE_NORMAL_CARE = 1;
  public static final int FOLLOW_TYPE_NOT_CARE = 2;
  public static final String TAG = "ProfileShoppingPhotoInfo";
  private static Object mLock = new Object();
  public static LRULinkedHashMap<String, ProfileShoppingPhotoInfo> photoWinCache = new LRULinkedHashMap(20);
  public int accountFlag;
  public String bindShoppingNo;
  public int certifiedGrade = 0;
  public int followType;
  public byte[] picByteData;
  public int seqNo;
  public String shopName;
  @unique
  public String uin;
  
  public static byte[] converPhoto2RawData(List<ShoppingPhotoItemInfo> paramList)
  {
    Object localObject = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ShoppingPhotoItemInfo localShoppingPhotoItemInfo = (ShoppingPhotoItemInfo)paramList.next();
      if (localShoppingPhotoItemInfo != null) {
        ((List)localObject).add(localShoppingPhotoItemInfo.a());
      }
    }
    paramList = Parcel.obtain();
    paramList.setDataPosition(0);
    paramList.writeList((List)localObject);
    localObject = paramList.marshall();
    paramList.recycle();
    return localObject;
  }
  
  public static ProfileShoppingPhotoInfo getPhotoInfo(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileShoppingPhotoInfo", 2, "func getPhotoInfo begins");
    }
    synchronized (mLock)
    {
      ProfileShoppingPhotoInfo localProfileShoppingPhotoInfo = (ProfileShoppingPhotoInfo)photoWinCache.get(paramString);
      if (localProfileShoppingPhotoInfo != null)
      {
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("func getPhotoInfo ends, in cache.");
          paramQQAppInterface.append(localProfileShoppingPhotoInfo.getPrintInfo());
          QLog.d("ProfileShoppingPhotoInfo", 2, paramQQAppInterface.toString());
        }
        return localProfileShoppingPhotoInfo;
      }
      paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      ??? = (ProfileShoppingPhotoInfo)paramQQAppInterface.find(ProfileShoppingPhotoInfo.class, paramString);
      paramQQAppInterface.close();
      paramQQAppInterface = mLock;
      if ((??? != null) && (paramString != null)) {}
      try
      {
        photoWinCache.put(paramString, ???);
        if (QLog.isColorLevel())
        {
          if (??? != null) {
            paramQQAppInterface = ((ProfileShoppingPhotoInfo)???).getPrintInfo();
          } else {
            paramQQAppInterface = "";
          }
          paramString = new StringBuilder();
          paramString.append("func getPhotoInfo ends, read from db.");
          paramString.append(paramQQAppInterface);
          QLog.d("ProfileShoppingPhotoInfo", 2, paramString.toString());
        }
        return ???;
      }
      finally {}
    }
  }
  
  public static List<ShoppingPhotoItemInfo> parseShoppingPhotoJson(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("config_arr");
      if (paramString != null)
      {
        if (paramString.length() == 0) {
          return localArrayList;
        }
        int k = paramString.length();
        int i = 0;
        while (i < k)
        {
          localObject = paramString.getJSONObject(i);
          if (1 == ((JSONObject)localObject).getInt("type"))
          {
            localObject = ((JSONObject)localObject).getJSONArray("config");
            if ((localObject != null) && (((JSONArray)localObject).length() > 0))
            {
              int m = ((JSONArray)localObject).length();
              int j = 0;
              while (j < m)
              {
                ShoppingPhotoItemInfo localShoppingPhotoItemInfo = new ShoppingPhotoItemInfo();
                localShoppingPhotoItemInfo.b = ((JSONArray)localObject).getJSONObject(j).getString("url");
                localShoppingPhotoItemInfo.a = ((JSONArray)localObject).getJSONObject(j).getJSONArray("pic_url").getString(0);
                localArrayList.add(localShoppingPhotoItemInfo);
                j += 1;
              }
            }
          }
          i += 1;
        }
      }
      return localArrayList;
    }
    catch (Exception paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parse json err:");
        ((StringBuilder)localObject).append(paramString.getMessage());
        QLog.w("ProfileShoppingPhotoInfo", 2, ((StringBuilder)localObject).toString());
      }
    }
    return localArrayList;
  }
  
  public static void savePhotoInfo2DB(ProfileShoppingPhotoInfo paramProfileShoppingPhotoInfo, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("func savePhotoInfo2DB begins, photoInfo:");
      ((StringBuilder)localObject).append(paramProfileShoppingPhotoInfo);
      QLog.d("ProfileShoppingPhotoInfo", 2, ((StringBuilder)localObject).toString());
    }
    if (paramProfileShoppingPhotoInfo == null) {
      return;
    }
    Object localObject = mLock;
    if (paramProfileShoppingPhotoInfo != null) {}
    try
    {
      if (paramProfileShoppingPhotoInfo.uin != null) {
        photoWinCache.put(paramProfileShoppingPhotoInfo.uin, paramProfileShoppingPhotoInfo);
      }
      paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      if (paramProfileShoppingPhotoInfo.getStatus() == 1000) {
        paramQQAppInterface.persist(paramProfileShoppingPhotoInfo);
      } else {
        paramQQAppInterface.update(paramProfileShoppingPhotoInfo);
      }
      paramQQAppInterface.close();
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("func savePhotoInfo2DB ends.");
        paramQQAppInterface.append(paramProfileShoppingPhotoInfo.getPrintInfo());
        QLog.d("ProfileShoppingPhotoInfo", 2, paramQQAppInterface.toString());
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public List<ShoppingPhotoItemInfo> getPhotoFromRawData()
  {
    // Byte code:
    //   0: new 54	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 55	java/util/ArrayList:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 255	com/tencent/mobileqq/profile/ProfileShoppingPhotoInfo:picByteData	[B
    //   12: ifnonnull +5 -> 17
    //   15: aload_2
    //   16: areturn
    //   17: invokestatic 87	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   20: astore_1
    //   21: aload_1
    //   22: aload_0
    //   23: getfield 255	com/tencent/mobileqq/profile/ProfileShoppingPhotoInfo:picByteData	[B
    //   26: iconst_0
    //   27: aload_0
    //   28: getfield 255	com/tencent/mobileqq/profile/ProfileShoppingPhotoInfo:picByteData	[B
    //   31: arraylength
    //   32: invokevirtual 259	android/os/Parcel:unmarshall	([BII)V
    //   35: aload_1
    //   36: iconst_0
    //   37: invokevirtual 90	android/os/Parcel:setDataPosition	(I)V
    //   40: aload_1
    //   41: aload_0
    //   42: invokevirtual 263	java/lang/Object:getClass	()Ljava/lang/Class;
    //   45: invokevirtual 269	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   48: invokevirtual 273	android/os/Parcel:readArrayList	(Ljava/lang/ClassLoader;)Ljava/util/ArrayList;
    //   51: astore_3
    //   52: aload_3
    //   53: ifnull +70 -> 123
    //   56: aload_3
    //   57: invokeinterface 276 1 0
    //   62: ifne +6 -> 68
    //   65: goto +58 -> 123
    //   68: aload_3
    //   69: invokeinterface 61 1 0
    //   74: astore_3
    //   75: aload_3
    //   76: invokeinterface 67 1 0
    //   81: ifeq +98 -> 179
    //   84: aload_3
    //   85: invokeinterface 71 1 0
    //   90: checkcast 278	java/lang/String
    //   93: astore 4
    //   95: new 73	com/tencent/mobileqq/profile/ShoppingPhotoItemInfo
    //   98: dup
    //   99: invokespecial 204	com/tencent/mobileqq/profile/ShoppingPhotoItemInfo:<init>	()V
    //   102: astore 5
    //   104: aload 5
    //   106: aload 4
    //   108: invokevirtual 280	com/tencent/mobileqq/profile/ShoppingPhotoItemInfo:a	(Ljava/lang/String;)V
    //   111: aload_2
    //   112: aload 5
    //   114: invokeinterface 81 2 0
    //   119: pop
    //   120: goto -45 -> 75
    //   123: aload_1
    //   124: invokevirtual 101	android/os/Parcel:recycle	()V
    //   127: aload_2
    //   128: areturn
    //   129: astore_2
    //   130: goto +55 -> 185
    //   133: astore_3
    //   134: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   137: ifeq +42 -> 179
    //   140: new 122	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   147: astore 4
    //   149: aload 4
    //   151: ldc_w 282
    //   154: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload 4
    //   160: aload_3
    //   161: invokevirtual 225	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   164: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: ldc 15
    //   170: iconst_2
    //   171: aload 4
    //   173: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 228	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   179: aload_1
    //   180: invokevirtual 101	android/os/Parcel:recycle	()V
    //   183: aload_2
    //   184: areturn
    //   185: aload_1
    //   186: invokevirtual 101	android/os/Parcel:recycle	()V
    //   189: goto +5 -> 194
    //   192: aload_2
    //   193: athrow
    //   194: goto -2 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	ProfileShoppingPhotoInfo
    //   20	166	1	localParcel	Parcel
    //   7	121	2	localArrayList	ArrayList
    //   129	64	2	localList	List<ShoppingPhotoItemInfo>
    //   51	34	3	localObject1	Object
    //   133	28	3	localException	Exception
    //   93	79	4	localObject2	Object
    //   102	11	5	localShoppingPhotoItemInfo	ShoppingPhotoItemInfo
    // Exception table:
    //   from	to	target	type
    //   21	52	129	finally
    //   56	65	129	finally
    //   68	75	129	finally
    //   75	120	129	finally
    //   134	179	129	finally
    //   21	52	133	java/lang/Exception
    //   56	65	133	java/lang/Exception
    //   68	75	133	java/lang/Exception
    //   75	120	133	java/lang/Exception
  }
  
  public String getPrintInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/n Info->[uin]:");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(",[seqNo]:");
    localStringBuilder.append(this.seqNo);
    localStringBuilder.append(",[followType]:");
    localStringBuilder.append(this.followType);
    localStringBuilder.append(",[accountFlag]:");
    localStringBuilder.append(this.accountFlag);
    localStringBuilder.append(",[shopName]:");
    localStringBuilder.append(this.shopName);
    localStringBuilder.append(",[bindShoppingNo]:");
    localStringBuilder.append(this.bindShoppingNo);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo
 * JD-Core Version:    0.7.0.1
 */