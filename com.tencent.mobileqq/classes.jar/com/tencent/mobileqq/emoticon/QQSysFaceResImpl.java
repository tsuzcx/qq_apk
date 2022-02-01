package com.tencent.mobileqq.emoticon;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.jsonconverter.JSONConverter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QQSysFaceResImpl
  extends QQSysAndEmojiResInfo
  implements QQSysAndEmojiResReloader.IResReloadListener
{
  private static final String CATEGORY_NAME = "sysface";
  private static final String QZONE_CHI_GUA = "/吃瓜";
  public static final String TAG = "QQSysFaceResInfo";
  private int mMaxLocalId;
  private int mMaxServerId;
  
  public String getDescription(int paramInt)
  {
    String str2 = "";
    String str1 = str2;
    if (this.mConfigItemMap != null)
    {
      str1 = str2;
      if (this.mConfigItemMap.containsKey(Integer.valueOf(paramInt))) {
        str1 = ((QQSysAndEmojiResInfo.QQEmoConfigItem)this.mConfigItemMap.get(Integer.valueOf(paramInt))).QDes;
      }
    }
    return str1;
  }
  
  public Drawable getDrawable(int paramInt)
  {
    int i = QQSysFaceUtil.convertToServer(paramInt);
    for (;;)
    {
      try
      {
        localURL1 = new URL("qqsys_emoji", "host_qqsys_static", String.format("s%d.png", new Object[] { Integer.valueOf(i) }));
        localURL2 = localURL1;
        localURL2 = localURL1;
      }
      catch (MalformedURLException localMalformedURLException1)
      {
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("QQSysFaceResInfo", 2, "getDrawable url:" + localURL1.toString());
            localURL2 = localURL1;
          }
          return getUrlDrawable(localURL2, null, false, String.valueOf(paramInt));
        }
        catch (MalformedURLException localMalformedURLException2)
        {
          URL localURL1;
          URL localURL2;
          break label90;
        }
        localMalformedURLException1 = localMalformedURLException1;
        localURL1 = null;
      }
      label90:
      if (QLog.isColorLevel())
      {
        QLog.d("QQSysFaceResInfo", 2, "getDrawable ,", localMalformedURLException1);
        localURL2 = localURL1;
      }
    }
  }
  
  public String getEMCode(int paramInt)
  {
    if ((this.mConfigItemMap != null) && (this.mConfigItemMap.containsKey(Integer.valueOf(paramInt)))) {
      return ((QQSysAndEmojiResInfo.QQEmoConfigItem)this.mConfigItemMap.get(Integer.valueOf(paramInt))).EMCode;
    }
    return null;
  }
  
  /* Error */
  public Drawable getGifDrawable(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: iload_1
    //   4: invokestatic 63	com/tencent/mobileqq/emoticon/QQSysFaceUtil:convertToServer	(I)I
    //   7: istore_2
    //   8: new 65	java/net/URL
    //   11: dup
    //   12: ldc 67
    //   14: ldc 124
    //   16: ldc 126
    //   18: iconst_1
    //   19: anewarray 73	java/lang/Object
    //   22: dup
    //   23: iconst_0
    //   24: iload_2
    //   25: invokestatic 38	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   28: aastore
    //   29: invokestatic 79	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   32: invokespecial 82	java/net/URL:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   35: astore_3
    //   36: aload_3
    //   37: astore 4
    //   39: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq +34 -> 76
    //   45: ldc 16
    //   47: iconst_2
    //   48: new 90	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   55: ldc 128
    //   57: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload_3
    //   61: invokevirtual 101	java/net/URL:toString	()Ljava/lang/String;
    //   64: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   73: aload_3
    //   74: astore 4
    //   76: aload 6
    //   78: astore_3
    //   79: iload_1
    //   80: getstatic 133	com/tencent/mobileqq/text/EmotcationConstants:VALID_SYS_EMOTCATION_COUNT	I
    //   83: if_icmpge +8 -> 91
    //   86: iload_1
    //   87: invokestatic 136	com/tencent/mobileqq/emoticon/QQSysFaceUtil:getFaceDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   90: astore_3
    //   91: aload_0
    //   92: aload 4
    //   94: aload_3
    //   95: iconst_1
    //   96: iload_1
    //   97: invokestatic 138	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   100: invokevirtual 112	com/tencent/mobileqq/emoticon/QQSysFaceResImpl:getUrlDrawable	(Ljava/net/URL;Landroid/graphics/drawable/Drawable;ZLjava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   103: areturn
    //   104: astore 5
    //   106: aconst_null
    //   107: astore_3
    //   108: aload_3
    //   109: astore 4
    //   111: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   114: ifeq -38 -> 76
    //   117: ldc 16
    //   119: iconst_2
    //   120: ldc 140
    //   122: aload 5
    //   124: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   127: aload_3
    //   128: astore 4
    //   130: goto -54 -> 76
    //   133: astore 5
    //   135: goto -27 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	QQSysFaceResImpl
    //   0	138	1	paramInt	int
    //   7	18	2	i	int
    //   35	93	3	localObject1	Object
    //   37	92	4	localObject2	Object
    //   104	19	5	localMalformedURLException1	MalformedURLException
    //   133	1	5	localMalformedURLException2	MalformedURLException
    //   1	76	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   8	36	104	java/net/MalformedURLException
    //   39	73	133	java/net/MalformedURLException
  }
  
  public int getMaxLocalId()
  {
    return this.mMaxLocalId;
  }
  
  public int getMaxServerId()
  {
    return this.mMaxServerId;
  }
  
  public int getServerId(int paramInt)
  {
    int j = -1;
    int i = j;
    if (this.mConfigItemMap != null)
    {
      i = j;
      if (this.mConfigItemMap.containsKey(Integer.valueOf(paramInt))) {
        i = Integer.parseInt(((QQSysAndEmojiResInfo.QQEmoConfigItem)this.mConfigItemMap.get(Integer.valueOf(paramInt))).QSid);
      }
    }
    return i;
  }
  
  public boolean isCMEmoji(int paramInt)
  {
    if ((this.mConfigItemMap != null) && (this.mConfigItemMap.containsKey(Integer.valueOf(paramInt)))) {
      return "1".equals(((QQSysAndEmojiResInfo.QQEmoConfigItem)this.mConfigItemMap.get(Integer.valueOf(paramInt))).isCMEmoji);
    }
    return false;
  }
  
  public boolean isResReady(int paramInt)
  {
    boolean bool = false;
    String str = QQSysAndEmojiResMgr.getFullResPath(2, String.format("/s%d.png", new Object[] { Integer.valueOf(paramInt) }));
    if (!TextUtils.isEmpty(str)) {
      bool = new File(str).exists();
    }
    return bool;
  }
  
  public boolean isStaticFace(int paramInt)
  {
    if ((this.mConfigItemMap != null) && (this.mConfigItemMap.containsKey(Integer.valueOf(paramInt)))) {
      return "1".equals(((QQSysAndEmojiResInfo.QQEmoConfigItem)this.mConfigItemMap.get(Integer.valueOf(paramInt))).isStatic);
    }
    return com.tencent.mobileqq.text.EmotcationConstants.STATIC_SYS_EMOTCATION_RESOURCE[paramInt] == com.tencent.mobileqq.text.EmotcationConstants.STATIC_SYS_EMO_GIF_RES[paramInt];
  }
  
  public void parseConfigData()
  {
    Object localObject1 = getFaceConfigJson();
    if (localObject1 != null)
    {
      JSONArray localJSONArray = ((JSONObject)localObject1).optJSONArray("sysface");
      if (localJSONArray != null)
      {
        if (this.mConfigItemMap == null) {
          this.mConfigItemMap = new HashMap();
        }
        if (this.mOrderList == null) {
          this.mOrderList = new ArrayList();
        }
        if (this.mServerToLocalMap == null) {
          this.mServerToLocalMap = new HashMap();
        }
        if (this.mDesToEMCodeMap == null) {
          this.mDesToEMCodeMap = new HashMap();
        }
        if (this.mEMCodeToLocalMap == null) {
          this.mEMCodeToLocalMap = new HashMap();
        }
        this.mConfigItemMap.clear();
        this.mOrderList.clear();
        this.mServerToLocalMap.clear();
        this.mDesToEMCodeMap.clear();
        this.mEMCodeToLocalMap.clear();
        long l = System.currentTimeMillis();
        int i = 0;
        QQSysAndEmojiResInfo.QQEmoConfigItem localQQEmoConfigItem;
        for (;;)
        {
          if (i >= localJSONArray.length()) {
            break label441;
          }
          localObject1 = null;
          try
          {
            localObject2 = localJSONArray.getJSONObject(i);
            localObject1 = localObject2;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              Object localObject2;
              localJSONException.printStackTrace();
            }
          }
          localQQEmoConfigItem = (QQSysAndEmojiResInfo.QQEmoConfigItem)JSONConverter.a((JSONObject)localObject1, QQSysAndEmojiResInfo.QQEmoConfigItem.class);
          try
          {
            int j = Integer.parseInt(localQQEmoConfigItem.AQLid);
            int k = Integer.parseInt(localQQEmoConfigItem.QSid);
            if (!TextUtils.isEmpty(localQQEmoConfigItem.EMCode))
            {
              String str = "[em]e" + localQQEmoConfigItem.EMCode + "[/em]";
              localObject2 = localQQEmoConfigItem.QDes;
              localObject1 = localObject2;
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                localObject1 = localObject2;
                if (((String)localObject2).equals("/吃瓜")) {
                  localObject1 = "/chigua";
                }
              }
              this.mDesToEMCodeMap.put(localObject1, str);
              this.mEMCodeToLocalMap.put(str, Integer.valueOf(j));
            }
            this.mConfigItemMap.put(Integer.valueOf(j), localQQEmoConfigItem);
            this.mServerToLocalMap.put(Integer.valueOf(k), Integer.valueOf(j));
            if (!isEmoticonHide(localQQEmoConfigItem)) {
              this.mOrderList.add(Integer.valueOf(j));
            }
            if (j > this.mMaxLocalId) {
              this.mMaxLocalId = j;
            }
            if (k > this.mMaxServerId) {
              this.mMaxServerId = k;
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            for (;;)
            {
              QLog.d("QQSysFaceResInfo", 1, new Object[] { "error occur in sysface AQLid:", localQQEmoConfigItem.AQLid });
            }
          }
          i += 1;
        }
        label441:
        if (QLog.isColorLevel()) {
          QLog.d("QQSysFaceResInfo", 2, new Object[] { "sysface configItem:", Integer.valueOf(this.mConfigItemMap.size()), ", orderlist:", Integer.valueOf(this.mOrderList.size()), ", maxLid:", Integer.valueOf(this.mMaxLocalId), ", maxSid:", Integer.valueOf(this.mMaxServerId), ", costTime = [", Long.valueOf(System.currentTimeMillis() - l), "]" });
        }
      }
    }
  }
  
  public void preLoadURLDrawable()
  {
    if (this.mConfigItemMap == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.mConfigItemMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        if ((localInteger.intValue() >= 260) && (!"-1".equals(((QQSysAndEmojiResInfo.QQEmoConfigItem)this.mConfigItemMap.get(localInteger)).QSid))) {
          ((URLDrawable)getDrawable(localInteger.intValue())).downloadImediatly();
        }
      }
    }
  }
  
  public void reportEmoClick(int paramInt1, int paramInt2)
  {
    int i = getServerId(paramInt1);
    paramInt1 = i;
    if (i == 0) {
      paramInt1 = 1000;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A7A2", "0X800A7A2", paramInt1, 0, String.valueOf(paramInt2), "", "", "");
  }
  
  public void setReloadController()
  {
    this.mResReloader = new QQSysAndEmojiResReloader(this);
  }
  
  public void startReloadDrawable(int paramInt)
  {
    reloadDrawable(getDrawable(paramInt), paramInt);
    reloadDrawable(getGifDrawable(paramInt), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.QQSysFaceResImpl
 * JD-Core Version:    0.7.0.1
 */