package com.tencent.mobileqq.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopAppInfo;
import com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.TroopFansInfo.IdolItem;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class TroopInfoManager
  extends Observable
  implements Manager
{
  protected LruCache<String, String> a;
  protected QQAppInterface a;
  protected ConcurrentHashMap<Long, TroopAppInfo> a;
  public boolean a;
  protected ConcurrentHashMap<String, ArrayList<Long>> b;
  private boolean b;
  protected ConcurrentHashMap<String, TroopFansInfo.IdolItem> c;
  private boolean c;
  protected ConcurrentHashMap<Long, TroopFeedsDataManager> d;
  protected ConcurrentHashMap<String, MessageInfo> e;
  
  /* Error */
  public TroopInfoManager(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 26	java/util/Observable:<init>	()V
    //   4: aload_0
    //   5: iconst_0
    //   6: putfield 28	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_Boolean	Z
    //   9: aload_0
    //   10: new 30	java/util/concurrent/ConcurrentHashMap
    //   13: dup
    //   14: invokespecial 31	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   17: putfield 33	com/tencent/mobileqq/model/TroopInfoManager:e	Ljava/util/concurrent/ConcurrentHashMap;
    //   20: aload_0
    //   21: aload_1
    //   22: putfield 35	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   25: aload_0
    //   26: getfield 37	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   29: ifnonnull +25 -> 54
    //   32: aload_0
    //   33: monitorenter
    //   34: aload_0
    //   35: getfield 37	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   38: ifnonnull +14 -> 52
    //   41: aload_0
    //   42: new 30	java/util/concurrent/ConcurrentHashMap
    //   45: dup
    //   46: invokespecial 31	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   49: putfield 37	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_0
    //   55: getfield 39	com/tencent/mobileqq/model/TroopInfoManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   58: ifnonnull +25 -> 83
    //   61: aload_0
    //   62: monitorenter
    //   63: aload_0
    //   64: getfield 39	com/tencent/mobileqq/model/TroopInfoManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   67: ifnonnull +14 -> 81
    //   70: aload_0
    //   71: new 30	java/util/concurrent/ConcurrentHashMap
    //   74: dup
    //   75: invokespecial 31	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   78: putfield 39	com/tencent/mobileqq/model/TroopInfoManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_0
    //   84: getfield 41	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   87: ifnonnull +27 -> 114
    //   90: aload_0
    //   91: monitorenter
    //   92: aload_0
    //   93: getfield 41	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   96: ifnonnull +16 -> 112
    //   99: aload_0
    //   100: new 43	android/support/v4/util/LruCache
    //   103: dup
    //   104: bipush 10
    //   106: invokespecial 46	android/support/v4/util/LruCache:<init>	(I)V
    //   109: putfield 41	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   112: aload_0
    //   113: monitorexit
    //   114: aload_0
    //   115: getfield 48	com/tencent/mobileqq/model/TroopInfoManager:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   118: ifnonnull +25 -> 143
    //   121: aload_0
    //   122: monitorenter
    //   123: aload_0
    //   124: getfield 48	com/tencent/mobileqq/model/TroopInfoManager:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   127: ifnonnull +14 -> 141
    //   130: aload_0
    //   131: new 30	java/util/concurrent/ConcurrentHashMap
    //   134: dup
    //   135: invokespecial 31	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   138: putfield 48	com/tencent/mobileqq/model/TroopInfoManager:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   141: aload_0
    //   142: monitorexit
    //   143: invokestatic 52	com/tencent/mobileqq/data/troop/TroopInfoCheckUtil:a	()V
    //   146: return
    //   147: astore_1
    //   148: aload_0
    //   149: monitorexit
    //   150: aload_1
    //   151: athrow
    //   152: astore_1
    //   153: aload_0
    //   154: monitorexit
    //   155: aload_1
    //   156: athrow
    //   157: astore_1
    //   158: aload_0
    //   159: monitorexit
    //   160: aload_1
    //   161: athrow
    //   162: astore_1
    //   163: aload_0
    //   164: monitorexit
    //   165: aload_1
    //   166: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	TroopInfoManager
    //   0	167	1	paramQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   34	52	147	finally
    //   52	54	147	finally
    //   148	150	147	finally
    //   63	81	152	finally
    //   81	83	152	finally
    //   153	155	152	finally
    //   92	112	157	finally
    //   112	114	157	finally
    //   158	160	157	finally
    //   123	141	162	finally
    //   141	143	162	finally
    //   163	165	162	finally
  }
  
  public TroopFansInfo.IdolItem a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (TroopFansInfo.IdolItem)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return null;
  }
  
  public MessageInfo a(String paramString)
  {
    return (MessageInfo)this.e.get(paramString);
  }
  
  public MessageInfo a(String paramString, MessageInfo paramMessageInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopInfoManager_At_Me_DISC", 2, "messageInfoMap: update__:" + paramString + " " + paramMessageInfo.a() + " " + paramMessageInfo.a() + " " + paramMessageInfo.a());
    }
    MessageInfo localMessageInfo2 = (MessageInfo)this.e.get(paramString);
    MessageInfo localMessageInfo1 = localMessageInfo2;
    if (paramMessageInfo != null)
    {
      if (paramMessageInfo.a()) {
        break label99;
      }
      localMessageInfo1 = localMessageInfo2;
    }
    label99:
    do
    {
      do
      {
        return localMessageInfo1;
        if (localMessageInfo2 != null) {
          break;
        }
        paramMessageInfo = new MessageInfo(paramMessageInfo);
        this.e.put(paramString, paramMessageInfo);
        localMessageInfo1 = paramMessageInfo;
      } while (!QLog.isColorLevel());
      QLog.d("TroopInfoManager_At_Me_DISC", 2, "messageInfoMap: put:" + paramString);
      return paramMessageInfo;
      localMessageInfo2.a(paramMessageInfo);
      localMessageInfo1 = localMessageInfo2;
    } while (!QLog.isColorLevel());
    QLog.d("TroopInfoManager_At_Me_DISC", 2, "messageInfoMap: update:" + paramString);
    return localMessageInfo2;
  }
  
  public TroopFeedsDataManager a(Long paramLong, boolean paramBoolean)
  {
    if (this.d == null) {
      this.d = new ConcurrentHashMap();
    }
    TroopFeedsDataManager localTroopFeedsDataManager2 = (TroopFeedsDataManager)this.d.get(paramLong);
    TroopFeedsDataManager localTroopFeedsDataManager1 = localTroopFeedsDataManager2;
    if (localTroopFeedsDataManager2 == null)
    {
      localTroopFeedsDataManager1 = localTroopFeedsDataManager2;
      if (paramBoolean)
      {
        localTroopFeedsDataManager1 = new TroopFeedsDataManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong);
        this.d.put(paramLong, localTroopFeedsDataManager1);
      }
    }
    return localTroopFeedsDataManager1;
  }
  
  public ArrayList<Long> a(String paramString)
  {
    return (ArrayList)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public ArrayList<TroopAppInfo> a(ArrayList<Long> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject = (Long)paramArrayList.next();
        localObject = (TroopAppInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext = paramString2;
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext = paramString2 + "_" + paramString1;
    }
    localEditor.putBoolean(paramContext, paramBoolean);
    localEditor.apply();
  }
  
  public void a(Long paramLong)
  {
    if (this.d == null) {
      return;
    }
    this.d.remove(paramLong);
  }
  
  public void a(Long paramLong, TroopAppInfo paramTroopAppInfo)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramLong, paramTroopAppInfo);
  }
  
  public void a(String paramString, TroopFansInfo.IdolItem paramIdolItem)
  {
    if ((paramIdolItem != null) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramIdolItem);
    }
  }
  
  public void a(String paramString, ArrayList<Long> paramArrayList)
  {
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramArrayList);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, Base64Util.encodeToString(paramArrayOfByte, 2));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public byte[] a(String paramString)
  {
    paramString = (String)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = Base64Util.decode(paramString, 0);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public MessageInfo b(String paramString)
  {
    return (MessageInfo)this.e.remove(paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void onDestroy()
  {
    if (this.d != null)
    {
      Iterator localIterator = this.d.values().iterator();
      while (localIterator.hasNext())
      {
        TroopFeedsDataManager localTroopFeedsDataManager = (TroopFeedsDataManager)localIterator.next();
        if (localTroopFeedsDataManager != null) {
          localTroopFeedsDataManager.deleteObservers();
        }
      }
      this.d.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.TroopInfoManager
 * JD-Core Version:    0.7.0.1
 */