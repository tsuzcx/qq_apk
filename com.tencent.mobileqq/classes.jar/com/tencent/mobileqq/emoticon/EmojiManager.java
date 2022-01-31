package com.tencent.mobileqq.emoticon;

import accw;
import accx;
import accy;
import accz;
import acda;
import acdb;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.magicface.model.MagicfaceResLoader;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.IndividuationConfigInfo;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EmojiManager
  implements Manager
{
  public static int a;
  public static long a;
  public static EmojiListenerManager a;
  public static boolean a;
  public static int b;
  private static String jdField_b_of_type_JavaLangString = "json_";
  public static int c;
  private static int f;
  private static int g = 1;
  public QQAppInterface a;
  PngFrameManager jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager = null;
  public DownloadListener a;
  LRULinkedHashMap jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(20);
  public String a;
  public HashMap a;
  Map jdField_a_of_type_JavaUtilMap = new HashMap();
  public ConcurrentHashMap a;
  DownloadListener jdField_b_of_type_ComTencentMobileqqVipDownloadListener = new accx(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
  public boolean b;
  public DownloadListener c;
  public boolean c;
  public int d = 3000000;
  public boolean d;
  int e = 0;
  
  static
  {
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = jdField_b_of_type_Int + 1;
  }
  
  public EmojiManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_JavaLangString = EmojiManager.class.getSimpleName();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new accw(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
    this.jdField_c_of_type_ComTencentMobileqqVipDownloadListener = new accy(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager = ((PngFrameManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(82));
    jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager = EmojiListenerManager.a();
  }
  
  /* Error */
  private Emoticon a(Emoticon paramEmoticon)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 122	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   4: astore_3
    //   5: aload_0
    //   6: getfield 44	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9: bipush 13
    //   11: invokevirtual 105	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   14: checkcast 124	com/tencent/mobileqq/model/EmoticonManager
    //   17: astore 4
    //   19: aload 4
    //   21: aload_3
    //   22: invokevirtual 127	com/tencent/mobileqq/model/EmoticonManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/EmoticonPackage;
    //   25: astore 5
    //   27: aload 4
    //   29: aload_3
    //   30: aload_1
    //   31: getfield 130	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   34: invokevirtual 133	com/tencent/mobileqq/model/EmoticonManager:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/Emoticon;
    //   37: astore_2
    //   38: aload 5
    //   40: ifnull +7 -> 47
    //   43: aload_2
    //   44: ifnonnull +124 -> 168
    //   47: new 4	java/lang/Object
    //   50: dup
    //   51: invokespecial 42	java/lang/Object:<init>	()V
    //   54: astore_2
    //   55: new 135	acdc
    //   58: dup
    //   59: aload_0
    //   60: aload_3
    //   61: aload_2
    //   62: invokespecial 138	acdc:<init>	(Lcom/tencent/mobileqq/emoticon/EmojiManager;Ljava/lang/String;Ljava/lang/Object;)V
    //   65: astore 5
    //   67: invokestatic 112	com/tencent/mobileqq/emoticon/EmojiListenerManager:a	()Lcom/tencent/mobileqq/emoticon/EmojiListenerManager;
    //   70: aload 5
    //   72: invokevirtual 141	com/tencent/mobileqq/emoticon/EmojiListenerManager:a	(Lcom/tencent/mobileqq/emoticon/EmotionJsonDownloadListener;)V
    //   75: aload_0
    //   76: aload_3
    //   77: getstatic 31	com/tencent/mobileqq/emoticon/EmojiManager:jdField_b_of_type_Int	I
    //   80: invokevirtual 144	com/tencent/mobileqq/emoticon/EmojiManager:a	(Ljava/lang/String;I)V
    //   83: aload_2
    //   84: monitorenter
    //   85: aload_2
    //   86: ldc2_w 145
    //   89: invokevirtual 150	java/lang/Object:wait	(J)V
    //   92: aload_2
    //   93: monitorexit
    //   94: invokestatic 112	com/tencent/mobileqq/emoticon/EmojiListenerManager:a	()Lcom/tencent/mobileqq/emoticon/EmojiListenerManager;
    //   97: aload 5
    //   99: invokevirtual 152	com/tencent/mobileqq/emoticon/EmojiListenerManager:b	(Lcom/tencent/mobileqq/emoticon/EmotionJsonDownloadListener;)V
    //   102: aload 4
    //   104: aload_3
    //   105: invokevirtual 127	com/tencent/mobileqq/model/EmoticonManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/EmoticonPackage;
    //   108: astore 5
    //   110: aload 4
    //   112: aload_3
    //   113: aload_1
    //   114: getfield 130	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   117: invokevirtual 133	com/tencent/mobileqq/model/EmoticonManager:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/Emoticon;
    //   120: astore_2
    //   121: aload 5
    //   123: ifnull +9 -> 132
    //   126: aload_2
    //   127: astore_1
    //   128: aload_2
    //   129: ifnonnull +41 -> 170
    //   132: aload_0
    //   133: getfield 52	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   136: iconst_1
    //   137: new 154	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   144: ldc 157
    //   146: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_3
    //   150: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aconst_null
    //   160: astore_2
    //   161: aload_2
    //   162: areturn
    //   163: astore_1
    //   164: aload_2
    //   165: monitorexit
    //   166: aload_1
    //   167: athrow
    //   168: aload_2
    //   169: astore_1
    //   170: aload_1
    //   171: getfield 172	com/tencent/mobileqq/data/Emoticon:jobType	I
    //   174: ifeq +21 -> 195
    //   177: aload_1
    //   178: getfield 172	com/tencent/mobileqq/data/Emoticon:jobType	I
    //   181: iconst_2
    //   182: if_icmpeq +13 -> 195
    //   185: aload_1
    //   186: astore_2
    //   187: aload_1
    //   188: getfield 172	com/tencent/mobileqq/data/Emoticon:jobType	I
    //   191: iconst_4
    //   192: if_icmpne -31 -> 161
    //   195: aload_1
    //   196: astore_2
    //   197: aload_1
    //   198: invokevirtual 176	com/tencent/mobileqq/data/Emoticon:hasEncryptKey	()Z
    //   201: ifne -40 -> 161
    //   204: new 178	java/util/ArrayList
    //   207: dup
    //   208: iconst_1
    //   209: invokespecial 179	java/util/ArrayList:<init>	(I)V
    //   212: astore_2
    //   213: aload_2
    //   214: aload_1
    //   215: invokevirtual 183	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   218: pop
    //   219: new 185	com/tencent/mobileqq/emoticon/ReqInfo
    //   222: dup
    //   223: invokespecial 186	com/tencent/mobileqq/emoticon/ReqInfo:<init>	()V
    //   226: astore 4
    //   228: aload_0
    //   229: aload_3
    //   230: aload_2
    //   231: aload 4
    //   233: invokevirtual 189	com/tencent/mobileqq/emoticon/EmojiManager:a	(Ljava/lang/String;Ljava/util/ArrayList;Lcom/tencent/mobileqq/emoticon/ReqInfo;)V
    //   236: aload_1
    //   237: astore_2
    //   238: aload 4
    //   240: getfield 191	com/tencent/mobileqq/emoticon/ReqInfo:jdField_a_of_type_Boolean	Z
    //   243: ifne -82 -> 161
    //   246: aload_0
    //   247: getfield 52	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   250: iconst_1
    //   251: new 154	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   258: ldc 193
    //   260: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload_3
    //   264: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: ldc 195
    //   269: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload_1
    //   273: getfield 130	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   276: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   285: aconst_null
    //   286: areturn
    //   287: astore 6
    //   289: goto -197 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	this	EmojiManager
    //   0	292	1	paramEmoticon	Emoticon
    //   37	201	2	localObject1	Object
    //   4	260	3	str	String
    //   17	222	4	localObject2	Object
    //   25	97	5	localObject3	Object
    //   287	1	6	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   85	92	163	finally
    //   92	94	163	finally
    //   164	166	163	finally
    //   85	92	287	java/lang/InterruptedException
  }
  
  public static TaskStatus a(AppRuntime paramAppRuntime, String paramString)
  {
    if (paramAppRuntime != null)
    {
      paramAppRuntime = (EmojiManager)paramAppRuntime.getManager(42);
      if (paramAppRuntime != null) {
        return (TaskStatus)paramAppRuntime.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      }
    }
    return null;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 4) || (paramInt == 2);
  }
  
  public static String[] a(String paramString1, String paramString2, boolean paramBoolean)
  {
    String str;
    if (paramBoolean)
    {
      str = EmoticonUtils.d.replace("[epId]", paramString1).replace("[eId]", paramString2);
      paramString1 = EmoticonUtils.p.replace("[epId]", paramString1).replace("[eId]", paramString2);
    }
    for (paramString2 = str;; paramString2 = str)
    {
      return new String[] { paramString2, paramString1 };
      str = EmoticonUtils.g.replace("[eIdSub]", paramString2.substring(0, 2)).replace("[eId]", paramString2);
      paramString1 = EmoticonUtils.p.replace("[epId]", paramString1).replace("[eId]", paramString2);
    }
  }
  
  public float a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return -1.0F;
    }
    paramString = (TaskStatus)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (paramString != null) {
      return paramString.a();
    }
    return -1.0F;
  }
  
  public int a(Emoticon paramEmoticon)
  {
    paramEmoticon = a(paramEmoticon);
    if (paramEmoticon == null)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "collectEmoji fail to download Emoticon");
      return -1;
    }
    return MarketFaceItemBuilder.a(null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticon, null);
  }
  
  int a(EmoticonPackage paramEmoticonPackage, ArrayList paramArrayList, List paramList, Map paramMap, Bundle paramBundle, int paramInt)
  {
    int i = 0;
    Emoticon localEmoticon;
    int j;
    if (i < paramArrayList.size())
    {
      localEmoticon = (Emoticon)paramArrayList.get(i);
      if ((paramInt & 0x2) == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo imgPreview.pid=" + localEmoticon.epId + " eid=" + localEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
        }
        localObject = c(localEmoticon);
        if (!FileUtils.a(localObject[1]))
        {
          paramList.add(localObject[0]);
          paramMap.put(localObject[0], new File(localObject[1]));
          localObject = localObject[0];
          if (localEmoticon.jobType != 1) {
            break label385;
          }
          j = 15;
          label177:
          paramBundle.putInt((String)localObject, j);
        }
      }
      if (((paramInt & 0x4) == 4) || ((paramInt & 0x20) == 32))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo gif.pid=" + localEmoticon.epId + " eid=" + localEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
        }
        if (paramEmoticonPackage.jobType == 1) {
          break label871;
        }
        if (localEmoticon.hasEncryptKey())
        {
          j = paramEmoticonPackage.rscType;
          if ((paramInt & 0x20) == 32) {
            j = 2;
          }
        }
      }
    }
    label385:
    label429:
    label862:
    label871:
    for (Object localObject = a(localEmoticon, j);; localObject = null)
    {
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| fail Emoticon download emo gif.pid=" + localEmoticon.epId + " eid=" + localEmoticon.eId);
        }
        return 11030;
        j = 6;
        break label177;
        return 11009;
      }
      boolean bool = false;
      if (paramEmoticonPackage.rscType == 1)
      {
        if (PngFrameUtil.a(EmoticonUtils.z.replace("[epId]", localEmoticon.epId))) {
          bool = true;
        }
        if (!bool)
        {
          paramList.add(localObject[0]);
          paramMap.put(localObject[0], new File(localObject[1]));
          if (paramEmoticonPackage.rscType != 1) {
            break label803;
          }
          paramBundle.putInt(localObject[0], 16);
        }
        label487:
        if ((paramInt & 0x1) == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo AIO preview static.pid=" + localEmoticon.epId + " eid=" + localEmoticon.eId + " type=" + paramInt);
          }
          localObject = b(localEmoticon);
          if (!FileUtils.a(localObject[1]))
          {
            paramList.add(localObject[0]);
            paramMap.put(localObject[0], new File(localObject[1]));
            localObject = localObject[0];
            if (localEmoticon.jobType != 1) {
              break label862;
            }
          }
        }
      }
      for (j = 15;; j = 8) {
        for (;;)
        {
          paramBundle.putInt((String)localObject, j);
          if ((localEmoticon.isSound) && ((paramInt & 0x8) == 8))
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo sound.pid=" + localEmoticon.epId + " eid=" + localEmoticon.eId + " type=" + paramInt);
            }
            localObject = a(localEmoticon);
            if (!FileUtils.a(localObject[1]))
            {
              paramList.add(localObject[0]);
              paramMap.put(localObject[0], new File(localObject[1]));
              paramBundle.putInt(localObject[0], 9);
            }
          }
          i += 1;
          break;
          bool = FileUtils.a(localObject[1]);
          break label429;
          if (paramEmoticonPackage.jobType == 1) {
            break label487;
          }
          paramBundle.putInt(localObject[0], 7);
          synchronized (this.jdField_a_of_type_JavaUtilMap)
          {
            this.jdField_a_of_type_JavaUtilMap.put(localObject[0], localEmoticon.encryptKey);
          }
        }
      }
      return 0;
    }
  }
  
  int a(EmoticonPackage paramEmoticonPackage, ArrayList paramArrayList, List paramList, Map paramMap, Bundle paramBundle, int paramInt, boolean paramBoolean)
  {
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (Emoticon)paramArrayList.get(i);
      if ((paramInt & 0x2) == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo imgPreview.pid=" + ((Emoticon)localObject).epId + " eid=" + ((Emoticon)localObject).eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
        }
        String[] arrayOfString = c((Emoticon)localObject);
        if ((!FileUtils.a(arrayOfString[1])) || (paramBoolean))
        {
          paramList.add(arrayOfString[0]);
          paramMap.put(arrayOfString[0], new File(arrayOfString[1]));
          paramBundle.putInt(arrayOfString[0], 6);
        }
      }
      if (((paramInt & 0x4) == 4) || ((paramInt & 0x20) == 32))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo gif.pid=" + ((Emoticon)localObject).epId + " eid=" + ((Emoticon)localObject).eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
        }
        localObject = a((Emoticon)localObject, paramEmoticonPackage.rscType);
        if ((!FileUtils.a(localObject[1])) || (paramBoolean)) {
          paramList.add(localObject[0]);
        }
        paramMap.put(localObject[0], new File(localObject[1]));
        paramBundle.putInt(localObject[0], 7);
      }
      i += 1;
    }
    return 0;
  }
  
  int a(File paramFile, EmoticonPackage paramEmoticonPackage, boolean paramBoolean, List paramList, Map paramMap, Bundle paramBundle, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    ReqInfo localReqInfo = new ReqInfo();
    byte[] arrayOfByte = null;
    if (paramFile != null) {}
    label527:
    for (;;)
    {
      try
      {
        if (paramFile.exists())
        {
          arrayOfByte = FileUtils.a(paramFile);
          if (paramEmoticonPackage.jobType == 4)
          {
            paramFile = EmotionJsonUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, jdField_b_of_type_Int, arrayOfByte, localArrayList);
            if (paramEmoticonPackage.isAPNG != 2) {
              break label527;
            }
            paramInt |= 0x20;
            if (paramFile == null) {
              continue;
            }
            QLog.e(this.jdField_a_of_type_JavaLangString, 1, "addEmotionsTask| parse json error");
            VasReportUtils.a("emotionType", "emotionActionDownload", "4", paramEmoticonPackage.epId, "", "", paramFile, "", "", "");
            return 11008;
          }
        }
        else
        {
          arrayOfByte = null;
          continue;
        }
      }
      catch (OutOfMemoryError paramFile)
      {
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "OutOfMemoryError e = " + paramFile.getMessage());
        arrayOfByte = null;
        continue;
        paramFile = EmotionJsonUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, jdField_b_of_type_Int, arrayOfByte, localArrayList, localReqInfo);
        continue;
        if ((!TextUtils.isEmpty(paramEmoticonPackage.minQQVersion)) && (!IndividuationConfigInfo.a(paramEmoticonPackage.minQQVersion, "7.6.3")))
        {
          QLog.e(this.jdField_a_of_type_JavaLangString, 1, "unavailable in current version, min version=" + paramEmoticonPackage.minQQVersion);
          return 11011;
        }
        paramBundle.putBoolean("isUpdate", paramBoolean);
        paramBundle.putSerializable("emoticonList", localArrayList);
        if ((!localReqInfo.jdField_a_of_type_Boolean) && (paramEmoticonPackage.jobType != 4))
        {
          int i = 0;
          localReqInfo.jdField_a_of_type_JavaLangString = null;
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| fetchEncryptKeys count=" + i);
          }
          a(paramEmoticonPackage.epId, localArrayList, localReqInfo);
          int j = i + 1;
          if (!localReqInfo.jdField_a_of_type_Boolean)
          {
            i = j;
            if (j < 3) {
              continue;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| fetchEncryptKeys count=" + j + " encryptKeysSuccess=" + localReqInfo.jdField_a_of_type_Boolean);
          }
          if (!localReqInfo.jdField_a_of_type_Boolean)
          {
            QLog.e(this.jdField_a_of_type_JavaLangString, 1, "addEmoticonsTask| fetchEncryptKeys fail epId=" + paramEmoticonPackage.epId + " encryptGetKeySeq=" + localReqInfo.jdField_a_of_type_JavaLangString + " encryptKeysResultCode" + localReqInfo.jdField_a_of_type_Int);
            return 11009;
          }
        }
        if (paramEmoticonPackage.jobType == 4) {
          return a(paramEmoticonPackage, localArrayList, paramList, paramMap, paramBundle, paramInt, paramBoolean);
        }
        return a(paramEmoticonPackage, localArrayList, paramList, paramMap, paramBundle, paramInt);
      }
    }
  }
  
  public Bundle a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (ArrayList)a().a(paramInt);
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
        if (localEmoticonPackage.jobType == 0) {
          localArrayList.add(a(localEmoticonPackage.epId, 1, paramInt));
        } else if (localEmoticonPackage.jobType == 3) {
          localArrayList.add(a(localEmoticonPackage.epId, 3, paramInt));
        } else if (localEmoticonPackage.jobType == 5) {
          localArrayList.add(a(localEmoticonPackage.epId, 4, paramInt));
        } else if (localEmoticonPackage.jobType == 4) {
          localArrayList.add(a(localEmoticonPackage.epId, 5, paramInt));
        }
      }
    }
    localObject = new Bundle();
    ((Bundle)localObject).putParcelableArrayList("pkgStatusList", localArrayList);
    return localObject;
  }
  
  public Bundle a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    String str = String.valueOf(paramBundle.getInt("id"));
    int i = paramBundle.getInt("businessType");
    int j = paramBundle.getInt("sceneType");
    if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str) != null)
    {
      localBundle.putInt("result", 0);
      localBundle.putString("messge", "");
      localBundle.putInt("sceneType", j);
      return localBundle;
    }
    paramBundle = a().b(str, -1);
    if ((paramBundle != null) && (paramBundle.status != 0))
    {
      switch (paramBundle.status)
      {
      default: 
        i = 1;
      }
      for (;;)
      {
        if ((paramBundle != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_updatepkg_detail", 0, 0, paramBundle.epId, "" + paramBundle.localVersion, "" + paramBundle.latestVersion, "");
        }
        localBundle.putInt("result", i);
        localBundle.putString("messge", "");
        localBundle.putInt("sceneType", j);
        return localBundle;
        a(paramBundle, true, j);
        i = 0;
        continue;
        i = 4;
      }
    }
    EmoticonPackage localEmoticonPackage = a().a(str, -1);
    paramBundle = localEmoticonPackage;
    if (localEmoticonPackage == null)
    {
      paramBundle = new EmoticonPackage();
      paramBundle.epId = str;
      paramBundle.wordingId = -1L;
      if (i != 2) {
        break label380;
      }
      paramBundle.jobType = 1;
    }
    for (;;)
    {
      paramBundle.isMagicFaceDownloading = false;
      if (i == 4) {
        paramBundle.jobType = 5;
      }
      a(paramBundle, true, j);
      localBundle.putInt("result", 0);
      localBundle.putString("messge", "");
      localBundle.putInt("sceneType", j);
      return localBundle;
      label380:
      if (i == 3) {
        paramBundle.jobType = 3;
      } else if (i == 4) {
        paramBundle.jobType = 5;
      } else if (i == 5) {
        paramBundle.jobType = 4;
      } else {
        paramBundle.jobType = 0;
      }
    }
  }
  
  public Bundle a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return null;
    }
    paramString = (TaskStatus)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (paramString != null)
    {
      Bundle localBundle = paramString.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramString.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localBundle != null)
      {
        paramString = (EmoticonPackage)localBundle.getSerializable("emoticonPackage");
        if (paramString != null) {
          jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(paramString, 11007, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
    }
    paramString = new Bundle();
    paramString.putInt("result", 0);
    paramString.putString("messge", "");
    paramString.putInt("sceneType", paramInt);
    return paramString;
  }
  
  Bundle a(String paramString, int paramInt1, int paramInt2)
  {
    int i = 0;
    Object localObject = a().b(paramString, paramInt2);
    paramInt2 = i;
    if (localObject != null)
    {
      if (((EmoticonPackage)localObject).valid) {
        paramInt2 = 1;
      }
    }
    else {
      if (paramInt1 != 2) {
        break label770;
      }
    }
    label770:
    for (int i3 = 1;; i3 = paramInt2)
    {
      TaskStatus localTaskStatus = (TaskStatus)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      int n;
      int k;
      int m;
      if ((localTaskStatus != null) && (!localTaskStatus.a()))
      {
        n = 0;
        k = (int)localTaskStatus.a();
        m = 2;
      }
      for (;;)
      {
        int j;
        label147:
        int i2;
        int i1;
        if (n == -1)
        {
          paramInt2 = k;
          i = m;
          j = n;
          switch (paramInt1)
          {
          default: 
            j = n;
            i = m;
            paramInt2 = k;
          case 2: 
            i2 = paramInt2;
            i1 = i;
            paramInt1 = j;
            if (QLog.isColorLevel())
            {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "getPackageStatus| query result in DB or not DB, epId:" + paramString + ",result=" + j + " status=" + i + " progress=" + paramInt2);
              paramInt1 = j;
              i1 = i;
              i2 = paramInt2;
            }
            break;
          }
        }
        for (;;)
        {
          paramInt2 = paramInt1;
          if (paramInt1 == -1)
          {
            paramInt2 = 0;
            i1 = 0;
            i2 = 0;
          }
          localObject = new Bundle();
          ((Bundle)localObject).putString("id", paramString);
          ((Bundle)localObject).putInt("result", paramInt2);
          ((Bundle)localObject).putInt("status", i1);
          ((Bundle)localObject).putInt("pluginStatus", 0);
          ((Bundle)localObject).putLong("pluginSize", 0L);
          ((Bundle)localObject).putInt("progress", i2);
          ((Bundle)localObject).putInt("dEmojiId", -1);
          ((Bundle)localObject).putInt("flag", i3);
          ((Bundle)localObject).putStringArrayList("srcList", null);
          ((Bundle)localObject).putStringArrayList("urlParamsList", null);
          return localObject;
          paramInt2 = 0;
          break;
          paramInt2 = k;
          i = m;
          j = n;
          if (localObject == null) {
            break label147;
          }
          paramInt2 = k;
          i = m;
          j = n;
          if (((EmoticonPackage)localObject).status != 2) {
            break label147;
          }
          if (a(paramString))
          {
            if (EmoticonUtils.a(((EmoticonPackage)localObject).updateFlag))
            {
              j = 0;
              i = 4;
              paramInt2 = 0;
              break label147;
            }
            j = 0;
            paramInt2 = 100;
            i = 3;
            break label147;
          }
          j = 0;
          i = 0;
          paramInt2 = 0;
          break label147;
          paramInt2 = k;
          i = m;
          j = n;
          if (localObject == null) {
            break label147;
          }
          paramInt2 = k;
          i = m;
          j = n;
          if (((EmoticonPackage)localObject).status != 2) {
            break label147;
          }
          if (b(paramString))
          {
            if (EmoticonUtils.a(((EmoticonPackage)localObject).updateFlag))
            {
              j = 0;
              i = 4;
              paramInt2 = 0;
              break label147;
            }
            j = 0;
            paramInt2 = 100;
            i = 3;
            break label147;
          }
          j = 0;
          i = 0;
          paramInt2 = 0;
          break label147;
          paramInt2 = k;
          i = m;
          j = n;
          if (localObject == null) {
            break label147;
          }
          paramInt2 = k;
          i = m;
          j = n;
          if (((EmoticonPackage)localObject).status != 2) {
            break label147;
          }
          if (a(paramString, Boolean.valueOf(true)))
          {
            j = 0;
            paramInt2 = 100;
            i = 3;
            break label147;
          }
          j = 0;
          i = 0;
          paramInt2 = 0;
          break label147;
          paramInt2 = k;
          i = m;
          j = n;
          if (localObject == null) {
            break label147;
          }
          paramInt2 = k;
          i = m;
          j = n;
          if (((EmoticonPackage)localObject).status != 2) {
            break label147;
          }
          if (b(paramString, true, true))
          {
            j = 0;
            paramInt2 = 100;
            i = 3;
            break label147;
          }
          j = 0;
          i = 0;
          paramInt2 = 0;
          break label147;
          i2 = k;
          i1 = m;
          paramInt1 = n;
          if (QLog.isColorLevel())
          {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "getPackageStatus| query result in running... result=" + n + " status=" + m + " progress=" + k);
            i2 = k;
            i1 = m;
            paramInt1 = n;
          }
        }
        k = 0;
        m = 0;
        n = -1;
      }
    }
  }
  
  public EmoticonManager a()
  {
    return (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
  }
  
  public DownloaderInterface a()
  {
    return ((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46)).a(1);
  }
  
  public void a(Bundle paramBundle, Object paramObject, boolean paramBoolean, int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    boolean bool1 = paramBundle.getBoolean("newPkgAdd", false);
    boolean bool2 = paramBundle.getBoolean("isUpdate", false);
    boolean bool3 = paramBundle.getBoolean("wifiAutoDownload", true);
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramBundle.getSerializable("emoticonPackage");
    if (localEmoticonPackage == null) {
      return;
    }
    if ((localEmoticonPackage.jobType == 3) || (localEmoticonPackage.jobType == 5)) {}
    for (int i = 1;; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onDone:epId=" + localEmoticonPackage.epId + " task:" + paramObject + " localVersion=" + localEmoticonPackage.localVersion + ",latestVersion=" + localEmoticonPackage.latestVersion + ",updateFlag=" + localEmoticonPackage.updateFlag);
      }
      if (!paramBoolean) {
        break;
      }
      try
      {
        paramInt2 = EmosmUtils.a(paramInt1);
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "handleEmoticonPackageDownloaded : download error ,reportCode = " + paramInt1);
        jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(localEmoticonPackage, paramInt2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        VasReportUtils.a("emotionType", "emotionActionDownload", "11", localEmoticonPackage.epId, "", "", paramInt1 + "", "", "", "");
        a(localEmoticonPackage, paramInt2, 0L, paramString);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "handleEmoticonPackageDownloaded failed", paramBundle);
        return;
      }
    }
    if ((bool2) && (i == 0))
    {
      paramBundle = (ArrayList)paramBundle.getSerializable("emoticonList");
      if ((paramBundle != null) && (paramBundle.size() > 0))
      {
        a().a(localEmoticonPackage.epId, paramBundle);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "update package:" + localEmoticonPackage.epId + ",newEmoticons:" + paramBundle.size());
        }
      }
    }
    for (;;)
    {
      localEmoticonPackage.updateFlag &= 0xFFFFFFFE;
      localEmoticonPackage.status = 2;
      localEmoticonPackage.valid = true;
      paramBundle = a();
      paramBundle.a(localEmoticonPackage);
      if (localEmoticonPackage.jobType != 5) {
        break label575;
      }
      paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      Object localObject = paramObject.a(EmoticonPackage.class, true, "childEpId=?", new String[] { localEmoticonPackage.epId }, null, null, null, null);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        b(((EmoticonPackage)((Iterator)localObject).next()).epId, true, true);
      }
      if (localEmoticonPackage.latestVersion > localEmoticonPackage.localVersion) {
        localEmoticonPackage.localVersion = localEmoticonPackage.latestVersion;
      }
      localEmoticonPackage.hasReadUpdatePage = false;
    }
    paramObject.a();
    label575:
    if (bool1) {}
    try
    {
      paramBundle.c(localEmoticonPackage.epId, paramInt2);
      jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(localEmoticonPackage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!bool3) {
        localEmoticonPackage.extraFlags |= 0x2;
      }
      jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.d(localEmoticonPackage);
      a(localEmoticonPackage, 0, paramLong, paramString);
      return;
    }
    finally {}
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("emoticonPackage", paramEmoticonPackage);
    a(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
    b(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
    paramEmoticonPackage = new DownloadTask(localArrayList, localHashMap, "vipEmoticonKey_cover_" + paramEmoticonPackage.epId);
    paramEmoticonPackage.e = this.d;
    paramEmoticonPackage.l = true;
    a().a(paramEmoticonPackage, this.jdField_b_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt, long paramLong, String paramString)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "download emoji report actionResult=" + paramInt + ",epId=" + paramEmoticonPackage.epId + ",downloadTime=" + paramLong);
    }
    int i = 0;
    if (paramInt != 0) {
      i = 1;
    }
    paramInt = NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "EMOJI_DOWN", "actEmoPackage", 0, i, paramEmoticonPackage.epId + "", paramInt + "", paramString, String.valueOf(paramLong));
      return;
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, DownloadListener paramDownloadListener, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "package download epId:" + paramEmoticonPackage.epId);
    }
    if ((paramEmoticonPackage == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "ep or mApp = null");
      return;
    }
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "netUnSupport epId=" + paramEmoticonPackage.epId);
      jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(paramEmoticonPackage, 11003, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      VasReportUtils.a("emotionType", "emotionActionDownload", "2", paramEmoticonPackage.epId, "", "", "", "", "", "");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    Bundle localBundle = new Bundle();
    localBundle.putInt("businessType", paramInt);
    localBundle.putSerializable("emoticonPackage", paramEmoticonPackage);
    localBundle.putBoolean("newPkgAdd", paramBoolean1);
    localBundle.putBoolean("wifiAutoDownload", paramBoolean2);
    Object localObject1;
    label254:
    Object localObject2;
    label273:
    label376:
    File localFile;
    if ((paramEmoticonPackage.jobType == 3) && (paramEmoticonPackage.isMagicFaceDownloading))
    {
      localObject1 = "vipEmoticonKey_auto_" + paramEmoticonPackage.epId;
      if (paramEmoticonPackage.jobType == 3)
      {
        e(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
        localObject2 = new DownloadTask(localArrayList, localHashMap, (String)localObject1);
        if (!((String)localObject1).contains("auto")) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramEmoticonPackage.epId, new TaskStatus(paramEmoticonPackage.epId, (DownloadTask)localObject2));
        }
        ((DownloadTask)localObject2).l = true;
        if (localArrayList.size() != 0) {
          break label994;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| urlList is empty");
        }
        ((DownloadTask)localObject2).a(localBundle);
        ((DownloadTask)localObject2).a(3);
        paramDownloadListener.onDone((DownloadTask)localObject2);
        if (paramEmoticonPackage.jobType != 5) {
          break label1026;
        }
        b(paramEmoticonPackage, paramBoolean1);
      }
    }
    else
    {
      if (paramEmoticonPackage.jobType == 5)
      {
        ((VasExtensionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234)).a.a(paramEmoticonPackage, paramBoolean1, paramBoolean2);
        return;
      }
      localObject2 = "vipEmoticonKey_" + paramEmoticonPackage.epId;
      localObject1 = EmosmUtils.a(paramEmoticonPackage.epId);
      if (paramEmoticonPackage.jobType == 4) {
        localObject1 = EmoticonUtils.c.replace("[epId]", paramEmoticonPackage.epId);
      }
      localFile = new File(EmoticonUtils.r.replace("[epId]", paramEmoticonPackage.epId));
      localObject1 = new DownloadTask((String)localObject1, localFile);
      TaskStatus localTaskStatus = new TaskStatus(paramEmoticonPackage.epId, (DownloadTask)localObject1);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(jdField_b_of_type_JavaLangString + paramEmoticonPackage.epId, localTaskStatus);
      ((DownloadTask)localObject1).h = true;
      ((DownloadTask)localObject1).l = true;
      paramInt = DownloaderFactory.a((DownloadTask)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(jdField_b_of_type_JavaLangString + paramEmoticonPackage.epId);
      jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(paramEmoticonPackage, paramInt);
      if (paramInt != 0)
      {
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "json download faile : resultCode = " + paramInt);
        paramInt = EmosmUtils.a(paramInt);
        jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(paramEmoticonPackage, paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        VasReportUtils.a("emotionType", "emotionActionDownload", "3", paramEmoticonPackage.epId, "", NetworkUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()) + "", paramInt + "", "", "", "");
        return;
      }
      paramBoolean2 = EmoticonUtils.a(paramEmoticonPackage);
      if (((paramEmoticonPackage.jobType == 0) || (paramEmoticonPackage.jobType == 4)) && (!paramBoolean2)) {
        a(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
      }
      b(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
      if (paramEmoticonPackage.isAPNG == 2)
      {
        paramInt = 42;
        label817:
        if (paramEmoticonPackage.jobType != 5) {
          break label955;
        }
        paramInt = 6;
      }
    }
    label1026:
    label1035:
    for (;;)
    {
      paramInt = a(localFile, paramEmoticonPackage, paramBoolean2, localArrayList, localHashMap, localBundle, paramInt);
      if (paramInt != 0)
      {
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "handleEmotionPackage|addEmotionsTask fail : resultCode = " + paramInt);
        jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(paramEmoticonPackage, paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        VasReportUtils.a("emotionType", "emotionActionDownload", "5", paramEmoticonPackage.epId, "", "", paramInt + "", "", "", "");
        return;
        paramInt = 14;
        break label817;
        label955:
        if (paramEmoticonPackage.jobType != 3) {
          break label1035;
        }
        paramInt |= 0x1;
        continue;
        if (paramEmoticonPackage.jobType != 5) {
          break label273;
        }
        f(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
        break label273;
        label994:
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| startDownload");
        }
        a().a((DownloadTask)localObject2, paramDownloadListener, localBundle);
        break label376;
        break;
      }
      localObject1 = localObject2;
      break label254;
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, boolean paramBoolean)
  {
    a(paramEmoticonPackage, paramBoolean, true, 0);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, boolean paramBoolean, int paramInt)
  {
    a(paramEmoticonPackage, paramBoolean, true, paramInt);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((paramEmoticonPackage == null) || (paramEmoticonPackage.epId == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    Object localObject;
    label137:
    do
    {
      return;
      if (paramInt == 0) {
        paramEmoticonPackage.aio = true;
      }
      TaskStatus localTaskStatus;
      for (;;)
      {
        localObject = (TaskStatus)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramEmoticonPackage.epId);
        localTaskStatus = (TaskStatus)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(jdField_b_of_type_JavaLangString + paramEmoticonPackage.epId);
        if (localObject == null) {
          break label137;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "pullEmoticonPackage task exist epId = " + paramEmoticonPackage.epId);
        return;
        if (paramInt == 1) {
          paramEmoticonPackage.kandian = true;
        }
      }
      if (localTaskStatus == null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(this.jdField_a_of_type_JavaLangString, 2, "pullEmoticonPackage jsonTask exist epId = " + paramEmoticonPackage.epId);
    return;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "try to pullEmoticonPackage ep:" + paramEmoticonPackage.epId);
    }
    if (!EmosmUtils.a(paramEmoticonPackage.epId))
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "ep.epId=" + paramEmoticonPackage.epId + " isNumeral false.");
      VasReportUtils.a("emotionType", "emotionActionDownload", "1", paramEmoticonPackage.epId, "", "", "", "", "", "");
      return;
    }
    if (!paramEmoticonPackage.isMagicFaceDownloading) {
      if ((paramEmoticonPackage.status != 2) || (!EmoticonUtils.a(paramEmoticonPackage.updateFlag))) {
        break label419;
      }
    }
    for (;;)
    {
      paramEmoticonPackage.valid = true;
      a().a(paramEmoticonPackage);
      localObject = new File(AppConstants.br);
      if (!((File)localObject).exists())
      {
        boolean bool = ((File)localObject).mkdirs();
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "mkdirs success:" + bool);
        }
      }
      ThreadManager.post(new acda(this, paramEmoticonPackage, paramBoolean1, paramBoolean2, paramInt), 5, null, true);
      return;
      label419:
      paramEmoticonPackage.status = 0;
    }
  }
  
  /* Error */
  public void a(DownloadTask paramDownloadTask)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: invokevirtual 897	com/tencent/mobileqq/vip/DownloadTask:a	()Landroid/os/Bundle;
    //   9: ldc_w 536
    //   12: invokevirtual 540	android/os/Bundle:getSerializable	(Ljava/lang/String;)Ljava/io/Serializable;
    //   15: checkcast 314	com/tencent/mobileqq/data/EmoticonPackage
    //   18: astore 6
    //   20: aload_1
    //   21: getfield 898	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   24: aload_1
    //   25: getfield 899	com/tencent/mobileqq/vip/DownloadTask:c	Ljava/lang/String;
    //   28: invokeinterface 900 2 0
    //   33: checkcast 296	java/io/File
    //   36: astore 7
    //   38: aload_0
    //   39: getfield 57	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   42: aload_1
    //   43: getfield 899	com/tencent/mobileqq/vip/DownloadTask:c	Ljava/lang/String;
    //   46: invokeinterface 903 2 0
    //   51: ifeq +605 -> 656
    //   54: aload_0
    //   55: getfield 57	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   58: astore 4
    //   60: aload 4
    //   62: monitorenter
    //   63: aload_0
    //   64: getfield 57	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   67: aload_1
    //   68: getfield 899	com/tencent/mobileqq/vip/DownloadTask:c	Ljava/lang/String;
    //   71: invokeinterface 900 2 0
    //   76: checkcast 215	java/lang/String
    //   79: astore_3
    //   80: aload_0
    //   81: getfield 57	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   84: aload_1
    //   85: getfield 899	com/tencent/mobileqq/vip/DownloadTask:c	Ljava/lang/String;
    //   88: invokeinterface 904 2 0
    //   93: pop
    //   94: aload 4
    //   96: monitorexit
    //   97: aload 7
    //   99: ifnull +548 -> 647
    //   102: aload 7
    //   104: invokestatic 354	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;)[B
    //   107: astore 5
    //   109: aload 7
    //   111: invokevirtual 907	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   114: astore 4
    //   116: aload 7
    //   118: invokevirtual 910	java/io/File:delete	()Z
    //   121: pop
    //   122: goto +539 -> 661
    //   125: aload_1
    //   126: iconst_1
    //   127: putfield 911	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Boolean	Z
    //   130: aload_0
    //   131: getfield 52	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   134: iconst_1
    //   135: ldc_w 913
    //   138: invokestatic 169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: getstatic 114	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager	Lcom/tencent/mobileqq/emoticon/EmojiListenerManager;
    //   144: aload 6
    //   146: sipush 11013
    //   149: aload_0
    //   150: getfield 44	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   153: invokevirtual 543	com/tencent/mobileqq/emoticon/EmojiListenerManager:a	(Lcom/tencent/mobileqq/data/EmoticonPackage;ILcom/tencent/mobileqq/app/QQAppInterface;)V
    //   156: ldc_w 366
    //   159: ldc_w 368
    //   162: ldc_w 915
    //   165: aload 6
    //   167: getfield 371	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   170: ldc_w 373
    //   173: ldc_w 373
    //   176: ldc_w 373
    //   179: ldc_w 373
    //   182: ldc_w 373
    //   185: ldc_w 373
    //   188: invokestatic 378	com/tencent/mobileqq/vas/VasReportUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   191: return
    //   192: astore_3
    //   193: aload_3
    //   194: invokevirtual 918	java/lang/Throwable:printStackTrace	()V
    //   197: aload_0
    //   198: getfield 52	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   201: iconst_2
    //   202: new 154	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   209: ldc_w 920
    //   212: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload_3
    //   216: invokevirtual 921	java/lang/Throwable:toString	()Ljava/lang/String;
    //   219: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: ldc_w 272
    //   225: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokestatic 278	java/lang/System:currentTimeMillis	()J
    //   231: invokevirtual 281	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   234: ldc_w 923
    //   237: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload_1
    //   241: getfield 899	com/tencent/mobileqq/vip/DownloadTask:c	Ljava/lang/String;
    //   244: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: aload_1
    //   254: iconst_1
    //   255: putfield 911	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Boolean	Z
    //   258: getstatic 114	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager	Lcom/tencent/mobileqq/emoticon/EmojiListenerManager;
    //   261: aload 6
    //   263: sipush 11020
    //   266: aload_0
    //   267: getfield 44	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   270: invokevirtual 543	com/tencent/mobileqq/emoticon/EmojiListenerManager:a	(Lcom/tencent/mobileqq/data/EmoticonPackage;ILcom/tencent/mobileqq/app/QQAppInterface;)V
    //   273: ldc_w 366
    //   276: ldc_w 368
    //   279: ldc_w 925
    //   282: aload 6
    //   284: getfield 371	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   287: ldc_w 373
    //   290: ldc_w 373
    //   293: ldc_w 373
    //   296: ldc_w 373
    //   299: ldc_w 373
    //   302: ldc_w 373
    //   305: invokestatic 378	com/tencent/mobileqq/vas/VasReportUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   308: return
    //   309: astore_3
    //   310: aload 4
    //   312: monitorexit
    //   313: aload_3
    //   314: athrow
    //   315: aload 6
    //   317: getfield 315	com/tencent/mobileqq/data/EmoticonPackage:jobType	I
    //   320: iconst_4
    //   321: if_icmpeq +74 -> 395
    //   324: aload_3
    //   325: ifnonnull +70 -> 395
    //   328: aload_1
    //   329: iconst_1
    //   330: putfield 911	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Boolean	Z
    //   333: aload_0
    //   334: getfield 52	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   337: iconst_1
    //   338: ldc_w 927
    //   341: invokestatic 169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   344: getstatic 114	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager	Lcom/tencent/mobileqq/emoticon/EmojiListenerManager;
    //   347: aload 6
    //   349: sipush 11009
    //   352: aload_0
    //   353: getfield 44	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   356: invokevirtual 543	com/tencent/mobileqq/emoticon/EmojiListenerManager:a	(Lcom/tencent/mobileqq/data/EmoticonPackage;ILcom/tencent/mobileqq/app/QQAppInterface;)V
    //   359: ldc_w 366
    //   362: ldc_w 368
    //   365: ldc_w 929
    //   368: aload 6
    //   370: getfield 371	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   373: ldc_w 373
    //   376: ldc_w 373
    //   379: ldc_w 373
    //   382: ldc_w 373
    //   385: ldc_w 373
    //   388: ldc_w 373
    //   391: invokestatic 378	com/tencent/mobileqq/vas/VasReportUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   394: return
    //   395: aload 6
    //   397: getfield 315	com/tencent/mobileqq/data/EmoticonPackage:jobType	I
    //   400: iconst_4
    //   401: if_icmpne +234 -> 635
    //   404: aload 5
    //   406: aload 4
    //   408: invokestatic 932	com/tencent/mobileqq/emosm/EmosmUtils:a	([BLjava/lang/String;)I
    //   411: istore_2
    //   412: iload_2
    //   413: ifeq +162 -> 575
    //   416: aload_0
    //   417: getfield 52	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   420: iconst_2
    //   421: new 154	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   428: ldc_w 934
    //   431: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload_1
    //   435: getfield 899	com/tencent/mobileqq/vip/DownloadTask:c	Ljava/lang/String;
    //   438: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   447: ldc_w 366
    //   450: ldc_w 368
    //   453: ldc_w 936
    //   456: aload 6
    //   458: getfield 371	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   461: ldc_w 373
    //   464: ldc_w 373
    //   467: new 154	java/lang/StringBuilder
    //   470: dup
    //   471: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   474: iload_2
    //   475: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   478: ldc_w 373
    //   481: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   487: ldc_w 373
    //   490: ldc_w 373
    //   493: ldc_w 373
    //   496: invokestatic 378	com/tencent/mobileqq/vas/VasReportUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   499: invokestatic 939	com/tencent/mobileqq/util/Utils:a	()Z
    //   502: ifeq +73 -> 575
    //   505: invokestatic 941	com/tencent/mobileqq/util/Utils:b	()J
    //   508: ldc2_w 942
    //   511: lcmp
    //   512: ifle +63 -> 575
    //   515: new 154	java/lang/StringBuilder
    //   518: dup
    //   519: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   522: getstatic 946	com/tencent/mobileqq/app/AppConstants:aJ	Ljava/lang/String;
    //   525: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: ldc_w 948
    //   531: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: getstatic 951	java/io/File:separator	Ljava/lang/String;
    //   537: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: aload 6
    //   542: getfield 371	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   545: invokestatic 954	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   548: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: ldc_w 956
    //   554: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: aload 7
    //   559: invokevirtual 959	java/io/File:getName	()Ljava/lang/String;
    //   562: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: aload 5
    //   570: iconst_0
    //   571: invokestatic 962	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;[BZ)Z
    //   574: pop
    //   575: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   578: ifeq -574 -> 4
    //   581: aload_0
    //   582: getfield 52	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   585: iconst_2
    //   586: new 154	java/lang/StringBuilder
    //   589: dup
    //   590: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   593: ldc_w 964
    //   596: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: iload_2
    //   600: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   603: ldc_w 272
    //   606: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: invokestatic 278	java/lang/System:currentTimeMillis	()J
    //   612: invokevirtual 281	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   615: ldc_w 923
    //   618: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: aload_1
    //   622: getfield 899	com/tencent/mobileqq/vip/DownloadTask:c	Ljava/lang/String;
    //   625: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   631: invokestatic 283	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   634: return
    //   635: aload 5
    //   637: aload_3
    //   638: aload 4
    //   640: invokestatic 967	com/tencent/mobileqq/emosm/EmosmUtils:a	([BLjava/lang/String;Ljava/lang/String;)I
    //   643: istore_2
    //   644: goto -232 -> 412
    //   647: aconst_null
    //   648: astore 4
    //   650: aconst_null
    //   651: astore 5
    //   653: goto +8 -> 661
    //   656: aconst_null
    //   657: astore_3
    //   658: goto -561 -> 97
    //   661: aload 5
    //   663: ifnull -538 -> 125
    //   666: aload 4
    //   668: ifnonnull -353 -> 315
    //   671: goto -546 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	674	0	this	EmojiManager
    //   0	674	1	paramDownloadTask	DownloadTask
    //   411	233	2	i	int
    //   79	1	3	str1	String
    //   192	24	3	localThrowable	Throwable
    //   309	329	3	str2	String
    //   657	1	3	localObject1	Object
    //   107	555	5	arrayOfByte	byte[]
    //   18	523	6	localEmoticonPackage	EmoticonPackage
    //   36	522	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   38	63	192	java/lang/Throwable
    //   102	122	192	java/lang/Throwable
    //   125	191	192	java/lang/Throwable
    //   313	315	192	java/lang/Throwable
    //   315	324	192	java/lang/Throwable
    //   328	394	192	java/lang/Throwable
    //   395	412	192	java/lang/Throwable
    //   416	575	192	java/lang/Throwable
    //   575	634	192	java/lang/Throwable
    //   635	644	192	java/lang/Throwable
    //   63	97	309	finally
    //   310	313	309	finally
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return;
      paramString = (TaskStatus)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    } while (paramString == null);
    paramString.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(String paramString, int paramInt)
  {
    a(paramString, paramInt, null, false, 0);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1, null, false, paramInt2);
  }
  
  public void a(String paramString, int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    a(paramString, paramInt, paramBundle, paramBoolean, 0);
  }
  
  public void a(String paramString, int paramInt1, Bundle paramBundle, boolean paramBoolean, int paramInt2)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    ThreadManager.post(new accz(this, paramBoolean, paramString, paramInt2, paramInt1, paramBundle), 5, null, true);
  }
  
  public void a(String paramString1, String arg2)
  {
    Object localObject = FileUtils.a(???);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
      synchronized (this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap)
      {
        this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(paramString1, localObject);
        ??? = new JSONArray();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          str = (String)((Iterator)localObject).next();
          if (!TextUtils.isEmpty(str)) {
            ???.put(str);
          }
        }
      }
    }
    while (!QLog.isColorLevel()) {
      try
      {
        String str;
        localObject = new JSONObject();
        ((JSONObject)localObject).put("fileList", ???);
        FileUtils.a(EmoticonUtils.x.replace("[epId]", paramString1), ((JSONObject)localObject).toString());
        return;
      }
      catch (JSONException paramString1)
      {
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "", paramString1);
        return;
      }
    }
    QLog.e(this.jdField_a_of_type_JavaLangString, 2, "emotionDownloadListener | onDoneFile h5 magic, childFiles is null");
  }
  
  public void a(String paramString, ArrayList paramArrayList)
  {
    int i = EmosmUtils.a(paramString);
    if ((paramArrayList == null) || (paramArrayList.size() == 0) || (i == -1)) {
      return;
    }
    int j = this.e;
    this.e = (j + 1);
    paramString = Integer.toString(j);
    ((EmoticonHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).a(i, paramArrayList, paramString);
  }
  
  public void a(String paramString, ArrayList paramArrayList, ReqInfo paramReqInfo)
  {
    int i = EmosmUtils.a(paramString);
    if ((paramArrayList == null) || (paramArrayList.size() == 0) || (paramReqInfo == null) || (i == -1)) {
      return;
    }
    paramString = new Object();
    EmoticonHandler localEmoticonHandler = (EmoticonHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12);
    localEmoticonHandler.a(new acdb(this, localEmoticonHandler, paramReqInfo, paramString));
    int j = this.e;
    this.e = (j + 1);
    String str = Integer.toString(j);
    paramReqInfo.jdField_a_of_type_JavaLangString = str;
    paramReqInfo.jdField_a_of_type_Int = 11022;
    localEmoticonHandler.a(i, paramArrayList, str);
    try
    {
      try
      {
        paramString.wait(35000L);
        return;
      }
      finally {}
      return;
    }
    catch (InterruptedException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  void a(String paramString, boolean paramBoolean)
  {
    paramString = a().a(paramString);
    if (paramString != null)
    {
      if (!paramBoolean) {
        break label39;
      }
      if (paramString.status != 2)
      {
        paramString.status = 2;
        a().a(paramString);
      }
    }
    label39:
    while (paramString.status == 0) {
      return;
    }
    paramString.status = 0;
    a().a(paramString);
  }
  
  void a(List paramList, Map paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    String str1 = paramEmoticonPackage.epId;
    int j;
    int i;
    if (paramEmoticonPackage.jobType == 2)
    {
      str1 = paramEmoticonPackage.kinId;
      j = 13;
      i = 14;
    }
    for (;;)
    {
      String str2 = EmosmUtils.b(j, str1);
      String str3 = EmosmUtils.a(3, paramEmoticonPackage.epId);
      if (!FileUtils.a(str3))
      {
        paramList.add(str2);
        paramMap.put(str2, new File(str3));
        paramBundle.putInt(str2, 3);
      }
      str1 = EmosmUtils.b(i, str1);
      paramEmoticonPackage = EmosmUtils.a(4, paramEmoticonPackage.epId);
      if (!FileUtils.a(paramEmoticonPackage))
      {
        paramList.add(str1);
        paramMap.put(str1, new File(paramEmoticonPackage));
        paramBundle.putInt(str1, 4);
      }
      return;
      if (paramEmoticonPackage.jobType == 4)
      {
        str1 = paramEmoticonPackage.epId;
        j = 17;
        i = 18;
      }
      else
      {
        j = 3;
        i = 4;
      }
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("h5magic_sp_name", 4).getBoolean("h5magic_sp_isplay_key", false);
    boolean bool4 = b();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "canPlayH5Magic isPlay = " + bool3 + ";isDPCSupport = " + bool4);
    }
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (bool4) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean a(Emoticon paramEmoticon)
  {
    PicEmoticonInfo localPicEmoticonInfo = new PicEmoticonInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localPicEmoticonInfo.jdField_c_of_type_Int = 6;
    localPicEmoticonInfo.jdField_b_of_type_Boolean = paramEmoticon.isAPNG;
    paramEmoticon = a(paramEmoticon);
    if (paramEmoticon == null)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "sendEmojiToAio fail to download Emoticon");
      return false;
    }
    localPicEmoticonInfo.a = paramEmoticon;
    MarketFaceItemBuilder.a = localPicEmoticonInfo;
    return true;
  }
  
  public boolean a(Emoticon paramEmoticon, int paramInt)
  {
    File localFile = null;
    if (paramEmoticon == null) {}
    label2086:
    label2091:
    label2095:
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon|taskvalue:" + paramInt + "，epid:" + paramEmoticon.epId + "，eid=" + paramEmoticon.eId);
      }
      if (Utils.a())
      {
        if (Utils.b() < 1048576L)
        {
          QLog.d(this.jdField_a_of_type_JavaLangString, 1, "sdcard check, sdcard full .return.");
          VasReportUtils.a("emotionType", "emotionActionAIO", "1", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
          return false;
        }
      }
      else
      {
        QLog.d(this.jdField_a_of_type_JavaLangString, 1, "sdcard check, has sdcard FALSE .return.");
        VasReportUtils.a("emotionType", "emotionActionAIO", "2", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
        return false;
      }
      Object localObject1;
      int i;
      if ((paramInt & 0x2) == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon| Emoticon download emo imgPreview.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis() + ",jobType:" + paramEmoticon.jobType);
        }
        localObject1 = c(paramEmoticon);
        if (!FileUtils.a(localObject1[1]))
        {
          localObject1 = new DownloadTask(localObject1[0], new File(localObject1[1]));
          ((DownloadTask)localObject1).l = true;
          i = DownloaderFactory.a((DownloadTask)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (i != 0)
          {
            QLog.e(this.jdField_a_of_type_JavaLangString, 1, "task preview down fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId);
            VasReportUtils.a("emotionType", "emotionActionAIO", "3", paramEmoticon.epId, paramEmoticon.eId, NetworkUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()) + "", i + "", "", "", "");
            return false;
          }
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "ret:" + i);
          }
        }
      }
      Object localObject2;
      Object localObject3;
      if (((paramInt & 0x4) == 4) || ((paramInt & 0x20) == 32))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon| Emoticon download emo gif.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
        }
        if (paramEmoticon.jobType == 1) {
          break label2091;
        }
        if ((paramInt & 0x20) != 32) {
          break label2086;
        }
        i = 2;
        localObject1 = a(paramEmoticon, i);
        localObject2 = new ReqInfo();
        if ((paramEmoticon.jobType != 3) && (TextUtils.isEmpty(paramEmoticon.encryptKey)))
        {
          localObject3 = new ArrayList();
          ((ArrayList)localObject3).add(paramEmoticon);
          a(paramEmoticon.epId, (ArrayList)localObject3, (ReqInfo)localObject2);
          if (TextUtils.isEmpty(paramEmoticon.encryptKey))
          {
            QLog.i(this.jdField_a_of_type_JavaLangString, 1, "Emoticon don't have encryptKey,epId=" + paramEmoticon.epId + ", eid=" + paramEmoticon.eId + " type=" + 4);
            VasReportUtils.a("emotionType", "emotionActionAIO", "4", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
            return false;
          }
        }
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label2095;
        }
        boolean bool = FileUtils.a(localObject1[1]);
        if (!bool)
        {
          localFile = new File(localObject1[1]);
          localObject1 = new DownloadTask(localObject1[0], localFile);
          ((DownloadTask)localObject1).l = true;
          i = DownloaderFactory.a((DownloadTask)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (i != 0)
          {
            QLog.e(this.jdField_a_of_type_JavaLangString, 1, "task gif down fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId + ":ret = " + i);
            VasReportUtils.a("emotionType", "emotionActionAIO", "5", paramEmoticon.epId, paramEmoticon.eId, NetworkUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()) + "", i + "", "", "", "");
            return false;
          }
        }
        for (;;)
        {
          if ((!bool) && (paramEmoticon.jobType != 1))
          {
            try
            {
              localObject2 = FileUtils.a(localFile);
              localObject3 = localFile.getAbsolutePath();
              localFile.delete();
              if (localObject2 == null)
              {
                QLog.e(this.jdField_a_of_type_JavaLangString, 1, "task gif 2 fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId);
                VasReportUtils.a("emotionType", "emotionActionAIO", "6", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
                return false;
              }
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
              if (QLog.isColorLevel()) {
                QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onProgress Emotiocon encode resource fail .EXCEPTION:" + localThrowable.toString() + " time:" + System.currentTimeMillis() + " url=" + ((DownloadTask)localObject1).c);
              }
              VasReportUtils.a("emotionType", "emotionActionAIO", "8", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
              return false;
            }
            if (paramEmoticon.jobType != 3) {
              i = EmosmUtils.a((byte[])localObject2, paramEmoticon.encryptKey, (String)localObject3);
            }
          }
          for (;;)
          {
            if (i != 0)
            {
              if (QLog.isColorLevel()) {
                QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onProgress download encrypt exception, url=" + ((DownloadTask)localObject1).c);
              }
              if ((Utils.a()) && (Utils.b() > 1048576L)) {
                FileUtils.a(AppConstants.aJ + "err" + File.separator + String.valueOf(paramEmoticon.epId) + "_" + paramEmoticon.encryptKey + "_" + localThrowable.getName(), (byte[])localObject2, false);
              }
              QLog.e(this.jdField_a_of_type_JavaLangString, 1, "task gif save fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId + ";emosmCode = " + i);
              VasReportUtils.a("emotionType", "emotionActionAIO", "7", paramEmoticon.epId, paramEmoticon.eId, "", i + "", "", "", "");
              return false;
              if (paramEmoticon.jobType == 3) {
                i = EmosmUtils.a((byte[])localObject2, (String)localObject3);
              }
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onProgress| Emotiocon encode resource done.result=" + i + " time:" + System.currentTimeMillis() + " url=" + ((DownloadTask)localObject1).c);
              }
              if ((paramInt & 0x1) == 1)
              {
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon| Emoticon download emo AIO preview static.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt);
                }
                localObject1 = b(paramEmoticon);
                if (!FileUtils.a(localObject1[1]))
                {
                  localObject1 = new DownloadTask(localObject1[0], new File(localObject1[1]));
                  ((DownloadTask)localObject1).l = true;
                  i = DownloaderFactory.a((DownloadTask)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                  if (i != 0)
                  {
                    QLog.e(this.jdField_a_of_type_JavaLangString, 1, "task aio static down fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId + ";ret = " + i);
                    VasReportUtils.a("emotionType", "emotionActionAIO", "9", paramEmoticon.epId, paramEmoticon.eId, NetworkUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()) + "", i + "", "", "", "");
                    return false;
                  }
                }
              }
              if ((paramEmoticon.isSound) && ((paramInt & 0x8) == 8))
              {
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon| Emoticon download emo sound.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
                }
                localObject1 = a(paramEmoticon);
                if (!FileUtils.a(localObject1[1]))
                {
                  localObject1 = new DownloadTask(localObject1[0], new File(localObject1[1]));
                  ((DownloadTask)localObject1).l = true;
                  paramInt = DownloaderFactory.a((DownloadTask)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                  if (paramInt != 0)
                  {
                    QLog.e(this.jdField_a_of_type_JavaLangString, 1, "task sound down fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId + ";ret = " + paramInt);
                    VasReportUtils.a("emotionType", "emotionActionAIO", "10", paramEmoticon.epId, paramEmoticon.eId, NetworkUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()) + "", paramInt + "", "", "", "");
                    return false;
                  }
                }
              }
              return true;
            }
            i = 0;
          }
          localObject1 = null;
        }
        i = 0;
        break;
        localObject1 = null;
      }
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool = d(paramString);
    a(paramString, bool);
    return bool;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    String str3 = EmoticonUtils.n.replace("[epId]", paramString);
    String str1;
    int i;
    if (paramInt == g)
    {
      String str2 = MagicfaceResLoader.a();
      str1 = str3 + str2 + File.separator + "video.ini";
      File localFile = new File(str1);
      paramString = localFile;
      if (!localFile.exists())
      {
        str2 = "big";
        str1 = str3 + "big" + File.separator + "video.ini";
        localFile = new File(str1);
        paramString = localFile;
        if (!localFile.exists()) {
          return false;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "videoConfigPath ==" + str1);
      }
      paramString = FileUtils.a(paramString).split("&");
      i = paramString.length;
      paramInt = 0;
      while (paramInt < i)
      {
        str1 = paramString[paramInt];
        if (!new File(str3 + str2 + File.separator + str1).exists()) {
          return false;
        }
        paramInt += 1;
      }
    }
    if (paramInt == f)
    {
      paramString = new File(str3 + "audio" + File.separator + "audio.ini");
      if (!paramString.exists()) {
        return false;
      }
      paramString = FileUtils.a(paramString).split("&");
      i = paramString.length;
      paramInt = 0;
      while (paramInt < i)
      {
        str1 = paramString[paramInt];
        if (!new File(str3 + "audio" + File.separator + str1).exists()) {
          return false;
        }
        paramInt += 1;
      }
    }
    return true;
  }
  
  public boolean a(String paramString, Boolean paramBoolean)
  {
    boolean bool = b(paramString, paramBoolean);
    a(paramString, bool);
    return bool;
  }
  
  boolean a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ??? = (ArrayList)a().a(paramString);
      if (??? != null)
      {
        ??? = ((ArrayList)???).iterator();
        if (((Iterator)???).hasNext())
        {
          ??? = (Emoticon)((Iterator)???).next();
          if (??? == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, one of encrypts is null!" + paramString);
            }
            return false;
          }
          if ((((Emoticon)???).jobType == 4) && ((((Emoticon)???).encryptKey == null) || (((Emoticon)???).encryptKey.length() == 0)))
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, encrypt isn't exist.epId=" + paramString + " eId=" + ((Emoticon)???).eId);
            }
            return false;
          }
          if (!new File(EmoticonUtils.p.replace("[epId]", paramString).replace("[eId]", ((Emoticon)???).eId)).exists())
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, emo img preview do not be exist! epId=" + paramString + " eId=" + ((Emoticon)???).eId);
            }
            return false;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, emoticons do not be exist.epId=" + paramString);
        }
        return false;
      }
    }
    ??? = new File(EmoticonUtils.v.replace("[epId]", paramString));
    if ((??? != null) && (!((File)???).exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, no root path: " + ???);
      }
      return false;
    }
    ??? = null;
    try
    {
      synchronized (this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap)
      {
        if (this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.containsKey(paramString)) {
          ??? = (ArrayList)this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(paramString);
        }
        ??? = ???;
        if (??? != null) {
          break label578;
        }
        ??? = new File(EmoticonUtils.x.replace("[epId]", paramString));
        paramBoolean = ((File)???).exists();
        if (!paramBoolean) {
          return false;
        }
      }
      ??? = new JSONObject(FileUtils.b((File)???));
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, error=" + MsfSdkUtils.getStackTraceString(paramString));
      }
      return false;
    }
    ??? = new ArrayList();
    ??? = ((JSONObject)???).getJSONArray("fileList");
    int j = ((JSONArray)???).length();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        String str = ((JSONArray)???).getString(i);
        if (!TextUtils.isEmpty(str)) {
          ((ArrayList)???).add(str);
        }
      }
      else
      {
        synchronized (this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap)
        {
          this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(paramString, ???);
          label578:
          if (??? != null)
          {
            paramString = ((ArrayList)???).iterator();
            while (paramString.hasNext())
            {
              ??? = new File((String)paramString.next());
              if ((??? != null) && (!((File)???).exists()))
              {
                if (QLog.isColorLevel()) {
                  QLog.e(this.jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, file miss: " + ???);
                }
                return false;
              }
            }
          }
        }
        return true;
      }
      i += 1;
    }
  }
  
  public boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (a().a(paramString) != null) {}
    for (int i = 1;; i = 0) {
      return (i != 0) && (b(paramString, paramBoolean1, paramBoolean2));
    }
  }
  
  String[] a(Emoticon paramEmoticon)
  {
    return new String[] { EmoticonUtils.e.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId), EmoticonUtils.o.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId) };
  }
  
  String[] a(Emoticon paramEmoticon, int paramInt)
  {
    if (paramEmoticon.jobType == 3)
    {
      str1 = EmoticonUtils.jdField_a_of_type_JavaLangString.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      if (paramInt != 2) {}
    }
    boolean bool;
    for (String str1 = EmoticonUtils.jdField_b_of_type_JavaLangString.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);; str1 = EmoticonUtils.f.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId))
    {
      str2 = EmoticonUtils.s.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      if (paramInt == 2) {
        str2 = EmoticonUtils.t.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      }
      paramEmoticon = str2;
      if (1 == paramInt)
      {
        paramEmoticon = str2;
        if (!TextUtils.isEmpty(str2)) {
          paramEmoticon = str2 + ".zip";
        }
      }
      return new String[] { str1, paramEmoticon };
      bool = c(paramEmoticon);
      if (1 != paramInt) {
        break;
      }
    }
    if (paramInt == 2)
    {
      str2 = EmoticonUtils.i.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId);
      if (bool)
      {
        str1 = String.valueOf(paramEmoticon.extensionWidth);
        label253:
        str2 = str2.replace("[width]", str1);
        if (!bool) {
          break label301;
        }
      }
      label301:
      for (str1 = String.valueOf(paramEmoticon.extensionHeight);; str1 = "200")
      {
        str1 = str2.replace("[height]", str1);
        break;
        str1 = "200";
        break label253;
      }
    }
    String str2 = EmoticonUtils.h.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId);
    if (bool)
    {
      str1 = String.valueOf(paramEmoticon.extensionWidth);
      label350:
      str2 = str2.replace("[width]", str1);
      if (!bool) {
        break label398;
      }
    }
    label398:
    for (str1 = String.valueOf(paramEmoticon.extensionHeight);; str1 = "200")
    {
      str1 = str2.replace("[height]", str1);
      break;
      str1 = "200";
      break label350;
    }
  }
  
  public Bundle b(Bundle paramBundle)
  {
    int i = 1;
    int j;
    int k;
    if (paramBundle == null)
    {
      j = -1;
      paramBundle = "";
      i = 0;
      k = 0;
    }
    Object localObject;
    for (;;)
    {
      localObject = new Bundle();
      if (i == 0) {
        break;
      }
      paramBundle = a(paramBundle, j, k);
      ((Bundle)localObject).putInt("result", paramBundle.getInt("result"));
      ((Bundle)localObject).putString("messge", "");
      ((Bundle)localObject).putInt("id", -1);
      ((Bundle)localObject).putInt("status", paramBundle.getInt("status"));
      ((Bundle)localObject).putInt("pluginStatus", paramBundle.getInt("pluginStatus"));
      ((Bundle)localObject).putLong("pluginSize", paramBundle.getLong("pluginSize"));
      ((Bundle)localObject).putInt("progress", paramBundle.getInt("progress"));
      ((Bundle)localObject).putInt("dynamicEmojiId", paramBundle.getInt("dEmojiId"));
      ((Bundle)localObject).putStringArrayList("dynamicEmojiList", paramBundle.getStringArrayList("srcList"));
      ((Bundle)localObject).putStringArrayList("urlParamsList", paramBundle.getStringArrayList("urlParamsList"));
      return localObject;
      localObject = paramBundle.getString("id");
      int m = paramBundle.getInt("businessType");
      int n = paramBundle.getInt("sceneType");
      if (((String)localObject).length() == 0)
      {
        i = 0;
        k = n;
        j = m;
        paramBundle = (Bundle)localObject;
      }
      else
      {
        k = n;
        j = m;
        paramBundle = (Bundle)localObject;
        if (EmosmUtils.a((String)localObject) == -1)
        {
          i = 0;
          k = n;
          j = m;
          paramBundle = (Bundle)localObject;
        }
      }
    }
    ((Bundle)localObject).putInt("result", 0);
    ((Bundle)localObject).putString("messge", "");
    ((Bundle)localObject).putInt("id", -1);
    ((Bundle)localObject).putInt("status", 0);
    ((Bundle)localObject).putInt("pluginStatus", 0);
    ((Bundle)localObject).putLong("pluginSize", 0L);
    ((Bundle)localObject).putInt("progress", 0);
    ((Bundle)localObject).putInt("dynamicEmojiId", -1);
    ((Bundle)localObject).putStringArrayList("dynamicEmojiList", null);
    ((Bundle)localObject).putStringArrayList("urlParamsList", null);
    return localObject;
  }
  
  void b(EmoticonPackage paramEmoticonPackage, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramEmoticonPackage.childEpId)) || ("0".equals(paramEmoticonPackage.childEpId)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| handle h5magic chiled emotion and childEpId = " + paramEmoticonPackage.childEpId);
    }
    if (paramBoolean)
    {
      localObject = (EmoticonHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12);
      if (localObject != null) {
        ((EmoticonHandler)localObject).a(paramEmoticonPackage.childEpId, 0);
      }
    }
    EmoticonPackage localEmoticonPackage = a().b(paramEmoticonPackage.childEpId, 0);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| old childEp = " + localEmoticonPackage);
    }
    Object localObject = localEmoticonPackage;
    if (localEmoticonPackage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| childEpId = " + paramEmoticonPackage.childEpId);
      }
      localObject = new EmoticonPackage();
      ((EmoticonPackage)localObject).epId = paramEmoticonPackage.childEpId;
      ((EmoticonPackage)localObject).wordingId = -1L;
      ((EmoticonPackage)localObject).jobType = 5;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| auto download childEp = " + localObject);
    }
    a((EmoticonPackage)localObject, paramBoolean);
  }
  
  public void b(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null) {
      return;
    }
    Object localObject = paramDownloadTask.a();
    int i = ((Bundle)localObject).getInt(paramDownloadTask.c);
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    localObject = (File)paramDownloadTask.jdField_a_of_type_JavaUtilMap.get(paramDownloadTask.c);
    switch (i)
    {
    default: 
      return;
    case 2: 
      jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(localEmoticonPackage, 2, 0, 0);
      return;
    case 21: 
      try
      {
        FileUtils.a(((File)localObject).getAbsolutePath(), EmoticonUtils.n.replace("[epId]", localEmoticonPackage.epId), false);
        ((File)localObject).delete();
        return;
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          paramDownloadTask.jdField_a_of_type_Boolean = true;
          localIOException1.printStackTrace();
        }
      }
    }
    try
    {
      FileUtils.a(((File)localObject).getAbsolutePath(), EmoticonUtils.z.replace("[epId]", localIOException1.epId), false);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager.b(localIOException1.epId);
      ((File)localObject).delete();
      return;
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        paramDownloadTask.jdField_a_of_type_Boolean = true;
        localIOException2.printStackTrace();
      }
    }
  }
  
  void b(List paramList, Map paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (paramEmoticonPackage.jobType == 4) {}
    for (int i = 19;; i = 2)
    {
      if (paramEmoticonPackage.jobType == 2) {}
      for (String str = paramEmoticonPackage.kinId;; str = paramEmoticonPackage.epId)
      {
        str = EmosmUtils.b(i, str);
        paramEmoticonPackage = EmosmUtils.a(2, paramEmoticonPackage.epId);
        if (!FileUtils.a(paramEmoticonPackage))
        {
          paramList.add(str);
          paramMap.put(str, new File(paramEmoticonPackage));
          paramBundle.putInt(str, 2);
        }
        return;
      }
    }
  }
  
  public boolean b()
  {
    return DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.h5magic_support.name());
  }
  
  /* Error */
  public boolean b(Emoticon paramEmoticon)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: sipush 148
    //   7: invokevirtual 105	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10: checkcast 1303	com/tencent/mobileqq/emosm/favroaming/FavroamingDBManager
    //   13: astore 5
    //   15: aload 5
    //   17: invokevirtual 1306	com/tencent/mobileqq/emosm/favroaming/FavroamingDBManager:a	()Ljava/util/List;
    //   20: astore 4
    //   22: aload_0
    //   23: getfield 44	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   26: bipush 13
    //   28: invokevirtual 105	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   31: checkcast 124	com/tencent/mobileqq/model/EmoticonManager
    //   34: aload_1
    //   35: getfield 122	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   38: invokevirtual 127	com/tencent/mobileqq/model/EmoticonManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/EmoticonPackage;
    //   41: ifnonnull +14 -> 55
    //   44: aload_0
    //   45: aload_1
    //   46: getfield 122	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   49: getstatic 31	com/tencent/mobileqq/emoticon/EmojiManager:jdField_b_of_type_Int	I
    //   52: invokevirtual 144	com/tencent/mobileqq/emoticon/EmojiManager:a	(Ljava/lang/String;I)V
    //   55: aload 4
    //   57: astore_3
    //   58: aload_0
    //   59: getfield 1307	com/tencent/mobileqq/emoticon/EmojiManager:jdField_b_of_type_Boolean	Z
    //   62: ifne +121 -> 183
    //   65: aload 4
    //   67: ifnull +16 -> 83
    //   70: aload 4
    //   72: astore_3
    //   73: aload 4
    //   75: invokeinterface 1309 1 0
    //   80: ifeq +103 -> 183
    //   83: aload_0
    //   84: iconst_1
    //   85: putfield 1307	com/tencent/mobileqq/emoticon/EmojiManager:jdField_b_of_type_Boolean	Z
    //   88: invokestatic 1312	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   91: invokestatic 758	com/tencent/mobileqq/utils/NetworkUtil:d	(Landroid/content/Context;)Z
    //   94: ifne +5 -> 99
    //   97: iconst_0
    //   98: ireturn
    //   99: aload_0
    //   100: getfield 44	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   103: bipush 102
    //   105: invokevirtual 105	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   108: checkcast 1314	com/tencent/mobileqq/emosm/favroaming/FavroamingManager
    //   111: astore 6
    //   113: aload 4
    //   115: astore_3
    //   116: aload 6
    //   118: invokevirtual 1315	com/tencent/mobileqq/emosm/favroaming/FavroamingManager:a	()Z
    //   121: ifeq +62 -> 183
    //   124: new 4	java/lang/Object
    //   127: dup
    //   128: invokespecial 42	java/lang/Object:<init>	()V
    //   131: astore_3
    //   132: new 1317	acdd
    //   135: dup
    //   136: aload_0
    //   137: aload_3
    //   138: invokespecial 1320	acdd:<init>	(Lcom/tencent/mobileqq/emoticon/EmojiManager;Ljava/lang/Object;)V
    //   141: astore 4
    //   143: aload_0
    //   144: getfield 44	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   147: aload 4
    //   149: invokevirtual 1324	com/tencent/mobileqq/app/QQAppInterface:addObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   152: aload 6
    //   154: invokevirtual 1326	com/tencent/mobileqq/emosm/favroaming/FavroamingManager:b	()V
    //   157: aload_3
    //   158: monitorenter
    //   159: aload_3
    //   160: ldc2_w 145
    //   163: invokevirtual 150	java/lang/Object:wait	(J)V
    //   166: aload_3
    //   167: monitorexit
    //   168: aload_0
    //   169: getfield 44	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   172: aload 4
    //   174: invokevirtual 1329	com/tencent/mobileqq/app/QQAppInterface:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   177: aload 5
    //   179: invokevirtual 1306	com/tencent/mobileqq/emosm/favroaming/FavroamingDBManager:a	()Ljava/util/List;
    //   182: astore_3
    //   183: aload_3
    //   184: ifnull -87 -> 97
    //   187: iconst_0
    //   188: istore_2
    //   189: iload_2
    //   190: aload_3
    //   191: invokeinterface 674 1 0
    //   196: if_icmpge -99 -> 97
    //   199: aload_3
    //   200: iload_2
    //   201: invokeinterface 1330 2 0
    //   206: checkcast 1332	com/tencent/mobileqq/data/CustomEmotionData
    //   209: astore 4
    //   211: aload 4
    //   213: getfield 1335	com/tencent/mobileqq/data/CustomEmotionData:isMarkFace	Z
    //   216: ifeq +54 -> 270
    //   219: aload 4
    //   221: getfield 1338	com/tencent/mobileqq/data/CustomEmotionData:emoPath	Ljava/lang/String;
    //   224: aload_1
    //   225: getfield 122	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   228: invokevirtual 1263	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   231: ifeq +39 -> 270
    //   234: aload 4
    //   236: getfield 1339	com/tencent/mobileqq/data/CustomEmotionData:eId	Ljava/lang/String;
    //   239: aload_1
    //   240: getfield 130	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   243: invokevirtual 1263	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   246: ifeq +24 -> 270
    //   249: ldc_w 1341
    //   252: aload 4
    //   254: getfield 1344	com/tencent/mobileqq/data/CustomEmotionData:RomaingType	Ljava/lang/String;
    //   257: invokevirtual 1263	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   260: ifne -163 -> 97
    //   263: iconst_1
    //   264: ireturn
    //   265: astore_1
    //   266: aload_3
    //   267: monitorexit
    //   268: aload_1
    //   269: athrow
    //   270: iload_2
    //   271: iconst_1
    //   272: iadd
    //   273: istore_2
    //   274: goto -85 -> 189
    //   277: astore 6
    //   279: goto -113 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	this	EmojiManager
    //   0	282	1	paramEmoticon	Emoticon
    //   188	86	2	i	int
    //   57	210	3	localObject1	Object
    //   20	233	4	localObject2	Object
    //   13	165	5	localFavroamingDBManager	com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager
    //   111	42	6	localFavroamingManager	com.tencent.mobileqq.emosm.favroaming.FavroamingManager
    //   277	1	6	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   159	166	265	finally
    //   166	168	265	finally
    //   266	268	265	finally
    //   159	166	277	java/lang/InterruptedException
  }
  
  public boolean b(Emoticon paramEmoticon, int paramInt)
  {
    boolean bool1;
    if (paramEmoticon == null)
    {
      bool1 = true;
      return bool1;
    }
    Object localObject2 = null;
    Object localObject1 = null;
    if ((paramInt & 0x1) == 1)
    {
      if (paramEmoticon.jobType != 1) {
        localObject1 = EmoticonUtils.q.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      }
      bool1 = FileUtil.a((String)localObject1);
    }
    for (;;)
    {
      if ((bool1) && ((paramInt & 0x4) == 4)) {
        if (paramEmoticon.jobType != 1) {
          localObject1 = EmoticonUtils.s.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
        }
      }
      for (boolean bool2 = FileUtil.a((String)localObject1);; bool2 = bool1)
      {
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if ((paramInt & 0x2) == 2) {
            bool1 = FileUtil.a(EmoticonUtils.p.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId));
          }
        }
        bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if (paramEmoticon.isSound)
          {
            bool2 = bool1;
            if ((paramInt & 0x8) == 8) {
              bool2 = FileUtil.a(EmoticonUtils.o.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId));
            }
          }
        }
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        bool1 = bool2;
        if ((paramInt & 0x20) != 32) {
          break;
        }
        return FileUtil.a(EmoticonUtils.t.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId));
      }
      bool1 = true;
      localObject1 = localObject2;
    }
  }
  
  public boolean b(String paramString)
  {
    boolean bool = c(paramString);
    a(paramString, bool);
    return bool;
  }
  
  boolean b(String paramString, Boolean paramBoolean)
  {
    if (paramString == null) {
      return false;
    }
    if (paramBoolean.booleanValue())
    {
      paramBoolean = (ArrayList)a().a(paramString);
      if (paramBoolean != null)
      {
        paramBoolean = paramBoolean.iterator();
        if (paramBoolean.hasNext())
        {
          paramBoolean = (Emoticon)paramBoolean.next();
          if (paramBoolean == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "one of encrypts is null!" + paramString);
            }
            return false;
          }
          if ((paramBoolean.jobType == 2) && ((paramBoolean.encryptKey == null) || (paramBoolean.encryptKey.length() == 0)))
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "encrypt isn't exist.epId=" + paramString + " eId=" + paramBoolean.eId);
            }
            return false;
          }
          if (!new File(EmoticonUtils.p.replace("[epId]", paramString).replace("[eId]", paramBoolean.eId)).exists())
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "emo img preview do not be exist! epId=" + paramString + " eId=" + paramBoolean.eId);
            }
            return false;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "emoticons do not be exist.epId=" + paramString);
        }
        return false;
      }
    }
    String str1 = MagicfaceResLoader.a();
    String str3 = EmoticonUtils.n.replace("[epId]", paramString);
    String str2 = str3 + str1 + File.separator + "video.ini";
    File localFile = new File(str2);
    paramBoolean = localFile;
    if (!localFile.exists())
    {
      str1 = "big";
      str2 = str3 + "big" + File.separator + "video.ini";
      localFile = new File(str2);
      paramBoolean = localFile;
      if (!localFile.exists()) {
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "videoConfigPath ==" + str2);
    }
    paramBoolean = FileUtils.a(paramBoolean);
    int j;
    if (paramBoolean != null)
    {
      paramBoolean = paramBoolean.split("&");
      j = paramBoolean.length;
      i = 0;
      while (i < j)
      {
        str2 = paramBoolean[i];
        if (!new File(str3 + str1 + File.separator + str2).exists()) {
          return false;
        }
        i += 1;
      }
    }
    paramBoolean = new File(str3 + "audio" + File.separator + "audio.ini");
    if (!paramBoolean.exists()) {
      return false;
    }
    paramBoolean = FileUtils.a(paramBoolean);
    if (paramBoolean != null)
    {
      paramBoolean = paramBoolean.split("&");
      j = paramBoolean.length;
      i = 0;
      while (i < j)
      {
        str1 = paramBoolean[i];
        if (!new File(str3 + "audio" + File.separator + str1).exists()) {
          return false;
        }
        i += 1;
      }
    }
    if (!a(paramString, g)) {
      return false;
    }
    paramBoolean = a().a(paramString);
    if (paramBoolean != null) {}
    for (int i = paramBoolean.rscType;; i = 0)
    {
      if (1 == i) {
        return PngFrameUtil.a(EmoticonUtils.z.replace("[epId]", paramString));
      }
      paramBoolean = (ArrayList)a().a(paramString);
      if ((paramBoolean != null) && (paramBoolean.size() > 0) && (!new File(EmoticonUtils.s.replace("[epId]", paramString).replace("[eId]", ((Emoticon)paramBoolean.get(0)).eId)).exists()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "emo img encrypt file do not be exist! epId=" + paramString + " eId=" + ((Emoticon)paramBoolean.get(0)).eId);
        }
        return false;
      }
      return true;
    }
  }
  
  public boolean b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool1 = true;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "isH5MagicFacePackageIntact, epId = " + paramString + ", needKey = " + paramBoolean1 + ", needCheckChild = " + paramBoolean2);
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    boolean bool2 = a(paramString, paramBoolean1);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "isH5MagicFacePackageIntact, result = " + bool2);
    }
    EmoticonPackage localEmoticonPackage = a().a(paramString);
    if (localEmoticonPackage != null) {
      if ((paramBoolean2) && (!TextUtils.isEmpty(localEmoticonPackage.childEpId)))
      {
        paramBoolean1 = a(localEmoticonPackage.childEpId, paramBoolean1);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "isH5MagicFacePackageIntact, childEpId = " + localEmoticonPackage.childEpId + ", childResult = " + paramBoolean1);
        }
        a(localEmoticonPackage.childEpId, paramBoolean1);
        if ((bool2) && (paramBoolean1))
        {
          paramBoolean1 = bool1;
          label220:
          a(paramString, paramBoolean1);
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "isH5MagicFacePackageIntact, epId=" + paramString + ", result=" + paramBoolean1);
      }
      return paramBoolean1;
      paramBoolean1 = false;
      break label220;
      paramBoolean1 = true;
      break;
      paramBoolean1 = bool2;
    }
  }
  
  String[] b(Emoticon paramEmoticon)
  {
    Object localObject = null;
    String str;
    if (paramEmoticon.jobType != 1)
    {
      boolean bool = c(paramEmoticon);
      str = EmoticonUtils.j.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId);
      if (bool)
      {
        localObject = String.valueOf(paramEmoticon.extensionWidth);
        str = str.replace("[width]", (CharSequence)localObject);
        if (!bool) {
          break label131;
        }
        localObject = String.valueOf(paramEmoticon.extensionHeight);
        label79:
        localObject = str.replace("[height]", (CharSequence)localObject);
        paramEmoticon = EmoticonUtils.q.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      }
    }
    for (;;)
    {
      return new String[] { localObject, paramEmoticon };
      localObject = "200";
      break;
      label131:
      localObject = "200";
      break label79;
      str = null;
      paramEmoticon = (Emoticon)localObject;
      localObject = str;
    }
  }
  
  void c(List paramList, Map paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (!a(paramEmoticonPackage.epId, g))
    {
      String str = EmosmUtils.a(paramEmoticonPackage.epId, 1);
      paramEmoticonPackage = EmoticonUtils.y.replace("[epId]", paramEmoticonPackage.epId);
      if (!FileUtils.a(paramEmoticonPackage))
      {
        paramList.add(str);
        paramMap.put(str, new File(paramEmoticonPackage));
        paramBundle.putInt(str, 21);
      }
    }
  }
  
  public boolean c()
  {
    if (jdField_a_of_type_Int == 4) {
      if (System.currentTimeMillis() - jdField_a_of_type_Long > 15000L)
      {
        jdField_a_of_type_Int = 0;
        jdField_a_of_type_Boolean = false;
      }
    }
    do
    {
      return true;
      return false;
      jdField_a_of_type_Int += 1;
    } while ((jdField_a_of_type_Int != 4) || (jdField_a_of_type_Boolean));
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Long = System.currentTimeMillis();
    return true;
  }
  
  public boolean c(Emoticon paramEmoticon)
  {
    return (paramEmoticon != null) && (paramEmoticon.extensionWidth != 0) && (paramEmoticon.extensionHeight != 0);
  }
  
  public boolean c(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    Object localObject = EmosmUtils.a(2, paramString);
    if (!new File((String)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkSmallEmoticonPackageIntact, cover_pkg_thumb isn't exist." + (String)localObject);
      }
      return false;
    }
    localObject = EmosmUtils.a(3, paramString);
    if (!new File((String)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkSmallEmoticonPackageIntact, cover_pkg_color isn't exist." + (String)localObject);
      }
      return false;
    }
    localObject = EmosmUtils.a(4, paramString);
    if (!new File((String)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkSmallEmoticonPackageIntact, cover_pkg_gray isn't exist." + (String)localObject);
      }
      return false;
    }
    localObject = (ArrayList)a().a(paramString);
    if (localObject != null)
    {
      Iterator localIterator = ((ArrayList)localObject).iterator();
      while (localIterator.hasNext())
      {
        Emoticon localEmoticon = (Emoticon)localIterator.next();
        if (localEmoticon == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "one of encrypts is null!" + paramString);
          }
          return false;
        }
        if (!new File(EmoticonUtils.p.replace("[epId]", paramString).replace("[eId]", localEmoticon.eId)).exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkSmallEmoticonPackageIntact, emo img preview do not be exist! epId=" + paramString + " eId=" + localEmoticon.eId);
          }
          return false;
        }
        localObject = a().a(paramString, -1);
        if ((localObject != null) && (((EmoticonPackage)localObject).isAPNG == 2)) {}
        for (localObject = EmoticonUtils.t.replace("[epId]", paramString).replace("[eId]", localEmoticon.eId); !new File((String)localObject).exists(); localObject = EmoticonUtils.s.replace("[epId]", paramString).replace("[eId]", localEmoticon.eId))
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkSmallEmoticonPackageIntact, emo img encrypt file do not be exist! epId=" + paramString + " eId=" + localEmoticon.eId);
          }
          return false;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkSmallEmoticonPackageIntact, emoticons do not be exist.epId=" + paramString);
    }
    return true;
  }
  
  String[] c(Emoticon paramEmoticon)
  {
    String str1 = paramEmoticon.epId;
    String str2 = paramEmoticon.eId;
    if (paramEmoticon.jobType == 3) {}
    for (boolean bool = true;; bool = false) {
      return a(str1, str2, bool);
    }
  }
  
  void d(List paramList, Map paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (!a(paramEmoticonPackage.epId, f))
    {
      String str = EmosmUtils.a(paramEmoticonPackage.epId, 0);
      paramEmoticonPackage = EmoticonUtils.y.replace("[epId]", paramEmoticonPackage.epId);
      if (!FileUtils.a(paramEmoticonPackage))
      {
        paramList.add(str);
        paramMap.put(str, new File(paramEmoticonPackage));
        paramBundle.putInt(str, 21);
      }
    }
  }
  
  public boolean d(String paramString)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        do
        {
          return false;
          localObject = EmosmUtils.a(2, paramString);
          if (new File((String)localObject).exists()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "cover_pkg_thumb isn't exist." + (String)localObject);
        return false;
        localObject = EmosmUtils.a(3, paramString);
        if (new File((String)localObject).exists()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "cover_pkg_color isn't exist." + (String)localObject);
      return false;
      localObject = EmosmUtils.a(4, paramString);
      if (new File((String)localObject).exists()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "cover_pkg_gray isn't exist." + (String)localObject);
    return false;
    Object localObject = (ArrayList)a().a(paramString, true);
    EmoticonPackage localEmoticonPackage;
    if (localObject != null)
    {
      localEmoticonPackage = a().a(paramString, -1);
      if (localEmoticonPackage == null) {
        break label616;
      }
    }
    label578:
    label616:
    for (int i = localEmoticonPackage.rscType;; i = 0)
    {
      Iterator localIterator = ((ArrayList)localObject).iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Emoticon localEmoticon = (Emoticon)localIterator.next();
          if (localEmoticon == null)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "one of encrypts is null!" + paramString);
            return false;
          }
          if ((localEmoticon.jobType == 0) && ((localEmoticon.encryptKey == null) || (localEmoticon.encryptKey.length() == 0)))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "encrypt isn't exist.epId=" + paramString + " eId=" + localEmoticon.eId);
            return false;
          }
          if (!new File(EmoticonUtils.p.replace("[epId]", paramString).replace("[eId]", localEmoticon.eId)).exists())
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "emo img preview do not be exist! epId=" + paramString + " eId=" + localEmoticon.eId);
            return false;
          }
          if (1 == i) {
            return PngFrameUtil.a(EmoticonUtils.z.replace("[epId]", paramString));
          }
          if ((localEmoticonPackage != null) && (localEmoticonPackage.isAPNG == 2)) {}
          for (localObject = EmoticonUtils.t.replace("[epId]", paramString).replace("[eId]", localEmoticon.eId);; localObject = EmoticonUtils.s.replace("[epId]", paramString).replace("[eId]", localEmoticon.eId))
          {
            if (new File((String)localObject).exists()) {
              break label578;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "emo img encrypt file do not be exist! epId=" + paramString + " eId=" + localEmoticon.eId);
            return false;
          }
          continue;
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "emoticons do not be exist.epId=" + paramString);
          }
        }
      }
      return true;
    }
  }
  
  void e(List paramList, Map paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage|add magic task ");
    }
    c(paramList, paramMap, paramEmoticonPackage, paramBundle);
    d(paramList, paramMap, paramEmoticonPackage, paramBundle);
  }
  
  public boolean e(String paramString)
  {
    return new File(EmoticonUtils.n.replace("[epId]", paramString) + "audio" + File.separator + "audio.ini").exists();
  }
  
  void f(List paramList, Map paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage|add h5magic task ");
    }
    if (!b(paramEmoticonPackage.epId, true, false))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| add h5 zip url");
      }
      String str = EmosmUtils.b(paramEmoticonPackage.epId);
      paramEmoticonPackage = EmosmUtils.c(paramEmoticonPackage.epId);
      if (paramEmoticonPackage != null)
      {
        paramList.add(str);
        paramMap.put(str, new File(paramEmoticonPackage));
        paramBundle.putInt(str, 20);
      }
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "clear History. uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + " app=" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    }
    jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a();
    if (a() != null) {
      a().a();
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmojiManager
 * JD-Core Version:    0.7.0.1
 */