package com.tencent.mobileqq.emoticon;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JobQueue;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
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
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.IndividuationConfigInfo;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
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
  private static final String jdField_a_of_type_JavaLangString = EmojiManager.class.getSimpleName();
  public static boolean a;
  public static int b;
  private static String jdField_b_of_type_JavaLangString = "json_";
  public static boolean b;
  public static int c;
  public static int d;
  private static int g = 0;
  private static int h = 1;
  public JobQueue a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  PngFrameManager jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager = null;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new EmojiManager.1(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
  LRULinkedHashMap<String, ArrayList<String>> jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(20);
  public HashMap<String, String> a;
  Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  public ConcurrentHashMap<String, TaskStatus> a;
  DownloadListener jdField_b_of_type_ComTencentMobileqqVipDownloadListener = new EmojiManager.2(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
  public DownloadListener c;
  public boolean c;
  public boolean d;
  int e;
  public boolean e;
  int f = 0;
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Int = 60000;
    jdField_b_of_type_Boolean = false;
    jdField_c_of_type_Int = 1;
    jdField_d_of_type_Int = jdField_c_of_type_Int + 1;
    jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager = null;
  }
  
  public EmojiManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_e_of_type_Int = 3000000;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentImageJobQueue = new JobQueue(3);
    this.jdField_c_of_type_ComTencentMobileqqVipDownloadListener = new EmojiManager.3(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager = ((PngFrameManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PNG_FRAME_DRAWABLE_MANAGER));
    jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager = EmojiListenerManager.a();
  }
  
  private Bundle a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, int paramInt6, int paramInt7, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, EmoticonPackage paramEmoticonPackage)
  {
    int i;
    int j;
    int k;
    int m;
    int n;
    if (paramInt2 == -1)
    {
      i = paramInt2;
      j = paramInt4;
      k = paramInt6;
      switch (paramInt1)
      {
      default: 
        k = paramInt6;
        j = paramInt4;
        i = paramInt2;
      case 2: 
        paramInt1 = i;
        m = j;
        n = k;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "getPackageStatus| query result in DB or not DB, epId:" + paramString + ",result=" + i + " status=" + j + " progress=" + k);
          paramInt4 = k;
          paramInt2 = j;
          paramInt1 = i;
        }
        break;
      }
    }
    for (;;)
    {
      paramInt6 = paramInt2;
      paramInt2 = paramInt1;
      if (paramInt1 == -1)
      {
        paramInt2 = 0;
        paramInt6 = 0;
        paramInt4 = 0;
      }
      paramEmoticonPackage = new Bundle();
      paramEmoticonPackage.putString("id", paramString);
      paramEmoticonPackage.putInt("result", paramInt2);
      paramEmoticonPackage.putInt("status", paramInt6);
      paramEmoticonPackage.putInt("pluginStatus", paramInt5);
      paramEmoticonPackage.putLong("pluginSize", paramLong);
      paramEmoticonPackage.putInt("progress", paramInt4);
      paramEmoticonPackage.putInt("dEmojiId", paramInt7);
      paramEmoticonPackage.putInt("flag", paramInt3);
      paramEmoticonPackage.putStringArrayList("srcList", paramArrayList1);
      paramEmoticonPackage.putStringArrayList("urlParamsList", paramArrayList2);
      return paramEmoticonPackage;
      i = paramInt2;
      j = paramInt4;
      k = paramInt6;
      if (paramEmoticonPackage == null) {
        break;
      }
      i = paramInt2;
      j = paramInt4;
      k = paramInt6;
      if (paramEmoticonPackage.status != 2) {
        break;
      }
      if (a(paramString)) {
        if (EmoticonUtils.isEmoticonPkgUpdateBitSet(paramEmoticonPackage.updateFlag))
        {
          paramInt2 = 4;
          paramInt1 = 0;
        }
      }
      for (;;)
      {
        i = 0;
        j = paramInt2;
        k = paramInt1;
        break;
        paramInt1 = 100;
        paramInt2 = 3;
        continue;
        paramInt2 = 0;
        paramInt1 = 0;
      }
      i = paramInt2;
      j = paramInt4;
      k = paramInt6;
      if (paramEmoticonPackage == null) {
        break;
      }
      i = paramInt2;
      j = paramInt4;
      k = paramInt6;
      if (paramEmoticonPackage.status != 2) {
        break;
      }
      if (b(paramString)) {
        if (EmoticonUtils.isEmoticonPkgUpdateBitSet(paramEmoticonPackage.updateFlag))
        {
          paramInt2 = 4;
          paramInt1 = 0;
        }
      }
      for (;;)
      {
        i = 0;
        j = paramInt2;
        k = paramInt1;
        break;
        paramInt1 = 100;
        paramInt2 = 3;
        continue;
        paramInt2 = 0;
        paramInt1 = 0;
      }
      i = paramInt2;
      j = paramInt4;
      k = paramInt6;
      if (paramEmoticonPackage == null) {
        break;
      }
      i = paramInt2;
      j = paramInt4;
      k = paramInt6;
      if (paramEmoticonPackage.status != 2) {
        break;
      }
      if (a(paramString, Boolean.valueOf(true)))
      {
        paramInt2 = 100;
        paramInt1 = 3;
      }
      for (;;)
      {
        i = 0;
        j = paramInt1;
        k = paramInt2;
        break;
        paramInt1 = 0;
        paramInt2 = 0;
      }
      i = paramInt2;
      j = paramInt4;
      k = paramInt6;
      if (paramEmoticonPackage == null) {
        break;
      }
      i = paramInt2;
      j = paramInt4;
      k = paramInt6;
      if (paramEmoticonPackage.status != 2) {
        break;
      }
      if (b(paramString, true, true))
      {
        paramInt2 = 100;
        paramInt1 = 3;
      }
      for (;;)
      {
        i = 0;
        j = paramInt1;
        k = paramInt2;
        break;
        paramInt1 = 0;
        paramInt2 = 0;
      }
      paramInt1 = paramInt2;
      m = paramInt4;
      n = paramInt6;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getPackageStatus| query result in running... result=" + paramInt2 + " status=" + paramInt4 + " progress=" + paramInt6);
        n = paramInt6;
        m = paramInt4;
        paramInt1 = paramInt2;
      }
      paramInt4 = n;
      paramInt2 = m;
    }
  }
  
  /* Error */
  private Emoticon a(Emoticon paramEmoticon)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 261	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   4: astore_3
    //   5: aload_0
    //   6: getfield 73	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9: getstatic 264	com/tencent/mobileqq/app/QQManagerFactory:EMOTICON_MANAGER	I
    //   12: invokevirtual 142	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   15: checkcast 266	com/tencent/mobileqq/model/EmoticonManager
    //   18: astore 4
    //   20: aload 4
    //   22: aload_3
    //   23: invokevirtual 269	com/tencent/mobileqq/model/EmoticonManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/EmoticonPackage;
    //   26: astore 5
    //   28: aload 4
    //   30: aload_3
    //   31: aload_1
    //   32: getfield 272	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   35: invokevirtual 275	com/tencent/mobileqq/model/EmoticonManager:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/Emoticon;
    //   38: astore_2
    //   39: aload 5
    //   41: ifnull +7 -> 48
    //   44: aload_2
    //   45: ifnonnull +124 -> 169
    //   48: new 4	java/lang/Object
    //   51: dup
    //   52: invokespecial 71	java/lang/Object:<init>	()V
    //   55: astore_2
    //   56: new 277	com/tencent/mobileqq/emoticon/EmojiManager$7
    //   59: dup
    //   60: aload_0
    //   61: aload_3
    //   62: aload_2
    //   63: invokespecial 280	com/tencent/mobileqq/emoticon/EmojiManager$7:<init>	(Lcom/tencent/mobileqq/emoticon/EmojiManager;Ljava/lang/String;Ljava/lang/Object;)V
    //   66: astore 5
    //   68: invokestatic 149	com/tencent/mobileqq/emoticon/EmojiListenerManager:a	()Lcom/tencent/mobileqq/emoticon/EmojiListenerManager;
    //   71: aload 5
    //   73: invokevirtual 283	com/tencent/mobileqq/emoticon/EmojiListenerManager:a	(Lcom/tencent/mobileqq/emoticon/EmotionJsonDownloadListener;)V
    //   76: aload_0
    //   77: aload_3
    //   78: getstatic 58	com/tencent/mobileqq/emoticon/EmojiManager:jdField_c_of_type_Int	I
    //   81: invokevirtual 285	com/tencent/mobileqq/emoticon/EmojiManager:a	(Ljava/lang/String;I)V
    //   84: aload_2
    //   85: monitorenter
    //   86: aload_2
    //   87: ldc2_w 286
    //   90: invokevirtual 291	java/lang/Object:wait	(J)V
    //   93: aload_2
    //   94: monitorexit
    //   95: invokestatic 149	com/tencent/mobileqq/emoticon/EmojiListenerManager:a	()Lcom/tencent/mobileqq/emoticon/EmojiListenerManager;
    //   98: aload 5
    //   100: invokevirtual 293	com/tencent/mobileqq/emoticon/EmojiListenerManager:b	(Lcom/tencent/mobileqq/emoticon/EmotionJsonDownloadListener;)V
    //   103: aload 4
    //   105: aload_3
    //   106: invokevirtual 269	com/tencent/mobileqq/model/EmoticonManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/EmoticonPackage;
    //   109: astore 5
    //   111: aload 4
    //   113: aload_3
    //   114: aload_1
    //   115: getfield 272	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   118: invokevirtual 275	com/tencent/mobileqq/model/EmoticonManager:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/Emoticon;
    //   121: astore_2
    //   122: aload 5
    //   124: ifnull +9 -> 133
    //   127: aload_2
    //   128: astore_1
    //   129: aload_2
    //   130: ifnonnull +41 -> 171
    //   133: getstatic 41	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   136: iconst_1
    //   137: new 158	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   144: ldc_w 295
    //   147: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_3
    //   151: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   160: aconst_null
    //   161: astore_2
    //   162: aload_2
    //   163: areturn
    //   164: astore_1
    //   165: aload_2
    //   166: monitorexit
    //   167: aload_1
    //   168: athrow
    //   169: aload_2
    //   170: astore_1
    //   171: aload_1
    //   172: getfield 300	com/tencent/mobileqq/data/Emoticon:jobType	I
    //   175: ifeq +21 -> 196
    //   178: aload_1
    //   179: getfield 300	com/tencent/mobileqq/data/Emoticon:jobType	I
    //   182: iconst_2
    //   183: if_icmpeq +13 -> 196
    //   186: aload_1
    //   187: astore_2
    //   188: aload_1
    //   189: getfield 300	com/tencent/mobileqq/data/Emoticon:jobType	I
    //   192: iconst_4
    //   193: if_icmpne -31 -> 162
    //   196: aload_1
    //   197: astore_2
    //   198: aload_1
    //   199: invokevirtual 303	com/tencent/mobileqq/data/Emoticon:hasEncryptKey	()Z
    //   202: ifne -40 -> 162
    //   205: new 305	java/util/ArrayList
    //   208: dup
    //   209: iconst_1
    //   210: invokespecial 306	java/util/ArrayList:<init>	(I)V
    //   213: astore_2
    //   214: aload_2
    //   215: aload_1
    //   216: invokevirtual 310	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   219: pop
    //   220: new 312	com/tencent/mobileqq/emoticon/ReqInfo
    //   223: dup
    //   224: invokespecial 313	com/tencent/mobileqq/emoticon/ReqInfo:<init>	()V
    //   227: astore 4
    //   229: aload_0
    //   230: aload_3
    //   231: aload_2
    //   232: aload 4
    //   234: invokevirtual 316	com/tencent/mobileqq/emoticon/EmojiManager:a	(Ljava/lang/String;Ljava/util/ArrayList;Lcom/tencent/mobileqq/emoticon/ReqInfo;)V
    //   237: aload_1
    //   238: astore_2
    //   239: aload 4
    //   241: getfield 317	com/tencent/mobileqq/emoticon/ReqInfo:jdField_a_of_type_Boolean	Z
    //   244: ifne -82 -> 162
    //   247: getstatic 41	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   250: iconst_1
    //   251: new 158	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   258: ldc_w 319
    //   261: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload_3
    //   265: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: ldc_w 321
    //   271: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload_1
    //   275: getfield 272	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   278: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: aconst_null
    //   288: areturn
    //   289: astore 6
    //   291: goto -198 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	this	EmojiManager
    //   0	294	1	paramEmoticon	Emoticon
    //   38	201	2	localObject1	Object
    //   4	261	3	str	String
    //   18	222	4	localObject2	Object
    //   26	97	5	localObject3	Object
    //   289	1	6	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   86	93	164	finally
    //   93	95	164	finally
    //   165	167	164	finally
    //   86	93	289	java/lang/InterruptedException
  }
  
  public static TaskStatus a(AppRuntime paramAppRuntime, String paramString)
  {
    if (paramAppRuntime != null)
    {
      paramAppRuntime = (EmojiManager)paramAppRuntime.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER);
      if (paramAppRuntime != null) {
        return (TaskStatus)paramAppRuntime.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      }
    }
    return null;
  }
  
  public static void a(int paramInt)
  {
    if (paramInt <= 0) {}
    String str;
    do
    {
      return;
      str = "";
      StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
      int i = Math.min(paramInt, arrayOfStackTraceElement.length);
      paramInt = 2;
      while (paramInt < i)
      {
        Object localObject = arrayOfStackTraceElement[paramInt];
        localObject = ((StackTraceElement)localObject).getClassName() + "." + ((StackTraceElement)localObject).getMethodName();
        str = str + " " + (String)localObject;
        paramInt += 1;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("Q.emoji.EmoDown", 4, "epId illegal,stacktrace:" + str);
  }
  
  private void a(EmoticonPackage arg1, List<String> paramList, Map<String, File> paramMap, Bundle paramBundle, Emoticon paramEmoticon, String[] paramArrayOfString)
  {
    boolean bool;
    if (???.rscType == 1)
    {
      if (!PngFrameUtil.a(EmoticonUtils.pngFramePath.replace("[epId]", paramEmoticon.epId))) {
        break label154;
      }
      bool = true;
    }
    for (;;)
    {
      if (!bool)
      {
        paramList.add(paramArrayOfString[0]);
        paramMap.put(paramArrayOfString[0], new File(paramArrayOfString[1]));
        if (???.rscType != 1) {
          break label101;
        }
        paramBundle.putInt(paramArrayOfString[0], 16);
      }
      label101:
      while (???.jobType == 1)
      {
        return;
        bool = FileUtils.a(paramArrayOfString[1]);
        break;
      }
      paramBundle.putInt(paramArrayOfString[0], 7);
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        this.jdField_a_of_type_JavaUtilMap.put(paramArrayOfString[0], paramEmoticon.encryptKey);
        return;
      }
      label154:
      bool = false;
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("emoResID", paramString2);
    localHashMap.put("emoPackageID", paramString1);
    localHashMap.put("result", paramInt + "");
    paramString1 = StatisticCollector.getInstance(BaseApplication.getContext());
    paramString2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramString1.collectPerformance(paramString2, "NewAudioEmoticonVoiceDownload", bool, 0L, 0L, localHashMap, null);
      return;
    }
  }
  
  private void a(List<String> paramList, Map<String, File> paramMap, Bundle paramBundle, int paramInt, Emoticon paramEmoticon)
  {
    if ((paramInt & 0x1) == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo AIO preview static.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt);
      }
      String[] arrayOfString = b(paramEmoticon);
      if (!FileUtils.a(arrayOfString[1]))
      {
        paramList.add(arrayOfString[0]);
        paramMap.put(arrayOfString[0], new File(arrayOfString[1]));
        paramList = arrayOfString[0];
        if (paramEmoticon.jobType != 1) {
          break label147;
        }
      }
    }
    label147:
    for (paramInt = 15;; paramInt = 8)
    {
      paramBundle.putInt(paramList, paramInt);
      return;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 4) || (paramInt == 2);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 2) && (paramInt2 == 1)) {}
    while (((paramInt1 == 3) && (paramInt2 == 3)) || ((paramInt1 == 4) && (paramInt2 == 5)) || ((paramInt1 == 5) && (paramInt2 == 4)) || ((paramInt1 == 1) && (paramInt2 == 0))) {
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3, File paramFile)
  {
    paramFile = FileUtils.a(paramFile);
    int j;
    int i;
    if (paramFile != null)
    {
      paramFile = paramFile.split("&");
      j = paramFile.length;
      i = 0;
      if (i < j)
      {
        String str = paramFile[i];
        if (new File(paramString3 + paramString2 + File.separator + str).exists()) {}
      }
    }
    label234:
    do
    {
      do
      {
        return false;
        i += 1;
        break;
        paramString2 = new File(paramString3 + "audio" + File.separator + "audio.ini");
      } while (!paramString2.exists());
      paramString2 = FileUtils.a(paramString2);
      if (paramString2 != null)
      {
        paramString2 = paramString2.split("&");
        j = paramString2.length;
        i = 0;
        for (;;)
        {
          if (i >= j) {
            break label234;
          }
          paramFile = paramString2[i];
          if (!new File(paramString3 + "audio" + File.separator + paramFile).exists()) {
            break;
          }
          i += 1;
        }
      }
    } while (!a(paramString1, h));
    return e(paramString1);
  }
  
  public static String[] a(String paramString1, String paramString2, boolean paramBoolean)
  {
    String str;
    if (paramBoolean)
    {
      str = EmoticonUtils.smallEmoticonThumbUrl.replace("[epId]", paramString1).replace("[eId]", paramString2);
      paramString1 = EmoticonUtils.emoticonPreviewPath.replace("[epId]", paramString1).replace("[eId]", paramString2);
    }
    for (paramString2 = str;; paramString2 = str)
    {
      return new String[] { paramString2, paramString1 };
      str = EmoticonUtils.emoticonPreviewUrl.replace("[eIdSub]", paramString2.substring(0, 2)).replace("[eId]", paramString2);
      paramString1 = EmoticonUtils.emoticonPreviewPath.replace("[epId]", paramString1).replace("[eId]", paramString2);
    }
  }
  
  private void b(List<String> paramList, Map<String, File> paramMap, Bundle paramBundle, int paramInt, Emoticon paramEmoticon)
  {
    if ((paramEmoticon.isSound) && ((paramInt & 0x8) == 8))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo sound.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt);
      }
      String[] arrayOfString = a(paramEmoticon);
      if (!FileUtils.a(arrayOfString[1]))
      {
        paramList.add(arrayOfString[0]);
        paramMap.put(arrayOfString[0], new File(arrayOfString[1]));
        paramBundle.putInt(arrayOfString[0], 9);
        if (paramEmoticon.isNewSoundEmoticon()) {
          paramBundle.putString(arrayOfString[0] + "emoticonId", paramEmoticon.eId);
        }
      }
    }
  }
  
  private boolean c(Emoticon paramEmoticon, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramInt & 0x2) == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon| Emoticon download emo imgPreview.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis() + ",jobType:" + paramEmoticon.jobType);
      }
      Object localObject = c(paramEmoticon);
      bool1 = bool2;
      if (!FileUtils.a(localObject[1]))
      {
        localObject = new DownloadTask(localObject[0], new File(localObject[1]));
        ((DownloadTask)localObject).n = true;
        ((DownloadTask)localObject).jdField_e_of_type_Int = jdField_b_of_type_Int;
        paramInt = DownloaderFactory.a((DownloadTask)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (paramInt == 0) {
          break label294;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 1, "task preview down fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId);
        VasReportUtils.a("emotionType", "emotionActionAIO", "3", paramEmoticon.epId, paramEmoticon.eId, NetworkUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()) + "", paramInt + "", "", "", "");
        bool1 = true;
      }
    }
    label294:
    do
    {
      return bool1;
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "ret:" + paramInt);
    return false;
  }
  
  private boolean d(Emoticon paramEmoticon)
  {
    if (Utils.a())
    {
      if (Utils.b() < 1048576L)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "sdcard check, sdcard full .return.");
        VasReportUtils.a("emotionType", "emotionActionAIO", "1", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
        return true;
      }
    }
    else
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "sdcard check, has sdcard FALSE .return.");
      VasReportUtils.a("emotionType", "emotionActionAIO", "2", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
      return true;
    }
    return false;
  }
  
  private boolean d(Emoticon paramEmoticon, int paramInt)
  {
    File localFile = null;
    boolean bool2 = false;
    boolean bool1;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((paramInt & 0x4) != 4)
    {
      bool1 = bool2;
      if ((paramInt & 0x20) != 32) {}
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon| Emoticon download emo gif.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
      }
      if (paramEmoticon.jobType == 1) {
        break label1079;
      }
      if ((paramInt & 0x20) != 32) {
        break label1074;
      }
      paramInt = 2;
      localObject1 = a(paramEmoticon, paramInt);
      localObject2 = new ReqInfo();
      if ((paramEmoticon.jobType == 3) || (!TextUtils.isEmpty(paramEmoticon.encryptKey))) {
        break label280;
      }
      localObject3 = new ArrayList();
      ((ArrayList)localObject3).add(paramEmoticon);
      a(paramEmoticon.epId, (ArrayList)localObject3, (ReqInfo)localObject2);
      if (!TextUtils.isEmpty(paramEmoticon.encryptKey)) {
        break label280;
      }
      QLog.i(jdField_a_of_type_JavaLangString, 1, "Emoticon don't have encryptKey,epId=" + paramEmoticon.epId + ", eid=" + paramEmoticon.eId + " type=" + 4);
      VasReportUtils.a("emotionType", "emotionActionAIO", "4", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
      bool1 = true;
    }
    return bool1;
    for (;;)
    {
      label280:
      if (localObject1 == null) {
        return true;
      }
      boolean bool3 = FileUtils.a(localObject1[1]);
      if (!bool3)
      {
        localFile = new File(localObject1[1]);
        localObject1 = new DownloadTask(localObject1[0], localFile);
        ((DownloadTask)localObject1).n = true;
        ((DownloadTask)localObject1).jdField_e_of_type_Int = jdField_b_of_type_Int;
        paramInt = DownloaderFactory.a((DownloadTask)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (paramInt != 0)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "task gif down fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId + ":ret = " + paramInt);
          VasReportUtils.a("emotionType", "emotionActionAIO", "5", paramEmoticon.epId, paramEmoticon.eId, NetworkUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()) + "", paramInt + "", "", "", "");
          return true;
        }
      }
      for (;;)
      {
        bool1 = bool2;
        if (bool3) {
          break;
        }
        bool1 = bool2;
        if (paramEmoticon.jobType == 1) {
          break;
        }
        for (;;)
        {
          try
          {
            localObject2 = FileUtils.a(localFile);
            localObject3 = localFile.getAbsolutePath();
            localFile.delete();
            if (localObject2 == null)
            {
              QLog.e(jdField_a_of_type_JavaLangString, 1, "task gif 2 fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId);
              VasReportUtils.a("emotionType", "emotionActionAIO", "6", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
              return true;
            }
            if (paramEmoticon.jobType != 3)
            {
              paramInt = EmosmUtils.a((byte[])localObject2, paramEmoticon.encryptKey, (String)localObject3);
              if (paramInt != 0)
              {
                if (QLog.isColorLevel()) {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "onProgress download encrypt exception, url=" + ((DownloadTask)localObject1).c);
                }
                if ((Utils.a()) && (Utils.b() > 1048576L)) {
                  FileUtils.a(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "err" + File.separator + String.valueOf(paramEmoticon.epId) + "_" + paramEmoticon.encryptKey + "_" + localFile.getName()), (byte[])localObject2, false);
                }
                QLog.e(jdField_a_of_type_JavaLangString, 1, "task gif save fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId + ";emosmCode = " + paramInt);
                VasReportUtils.a("emotionType", "emotionActionAIO", "7", paramEmoticon.epId, paramEmoticon.eId, "", paramInt + "", "", "", "");
                return true;
              }
            }
            else
            {
              if (paramEmoticon.jobType != 3) {
                break label1063;
              }
              paramInt = EmosmUtils.a((byte[])localObject2, (String)localObject3);
              continue;
            }
            bool1 = bool2;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "onProgress| Emotiocon encode resource done.result=" + paramInt + " time:" + System.currentTimeMillis() + " url=" + ((DownloadTask)localObject1).c);
            return false;
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "onProgress Emotiocon encode resource fail .EXCEPTION:" + localThrowable.toString() + " time:" + System.currentTimeMillis() + " url=" + ((DownloadTask)localObject1).c);
            }
            VasReportUtils.a("emotionType", "emotionActionAIO", "8", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
            return true;
          }
          label1063:
          paramInt = 0;
        }
        localObject1 = null;
      }
      label1074:
      paramInt = 0;
      break;
      label1079:
      localObject1 = null;
    }
  }
  
  private boolean e(Emoticon paramEmoticon, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramInt & 0x1) == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon| Emoticon download emo AIO preview static.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt);
      }
      Object localObject = b(paramEmoticon);
      bool1 = bool2;
      if (!FileUtils.a(localObject[1]))
      {
        localObject = new DownloadTask(localObject[0], new File(localObject[1]));
        ((DownloadTask)localObject).n = true;
        ((DownloadTask)localObject).jdField_e_of_type_Int = jdField_b_of_type_Int;
        paramInt = DownloaderFactory.a((DownloadTask)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        bool1 = bool2;
        if (paramInt != 0)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "task aio static down fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId + ";ret = " + paramInt);
          VasReportUtils.a("emotionType", "emotionActionAIO", "9", paramEmoticon.epId, paramEmoticon.eId, NetworkUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()) + "", paramInt + "", "", "", "");
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean f(Emoticon paramEmoticon, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramEmoticon.isSound)
    {
      bool1 = bool2;
      if ((paramInt & 0x8) == 8)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon| Emoticon download emo sound.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
        }
        Object localObject = a(paramEmoticon);
        bool1 = bool2;
        if (!FileUtils.a(localObject[1]))
        {
          localObject = new DownloadTask(localObject[0], new File(localObject[1]));
          ((DownloadTask)localObject).n = true;
          ((DownloadTask)localObject).jdField_e_of_type_Int = jdField_b_of_type_Int;
          paramInt = DownloaderFactory.a((DownloadTask)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (paramInt == 0) {
            break label327;
          }
          QLog.e(jdField_a_of_type_JavaLangString, 1, "task sound down fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId + ";ret = " + paramInt);
          VasReportUtils.a("emotionType", "emotionActionAIO", "10", paramEmoticon.epId, paramEmoticon.eId, NetworkUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()) + "", paramInt + "", "", "", "");
          if (paramEmoticon.isNewSoundEmoticon()) {
            a(paramEmoticon.epId, paramEmoticon.eId, ((DownloadTask)localObject).jdField_a_of_type_Int);
          }
          bool1 = false;
        }
      }
    }
    label327:
    do
    {
      return bool1;
      bool1 = bool2;
    } while (!paramEmoticon.isNewSoundEmoticon());
    a(paramEmoticon.epId, paramEmoticon.eId, 0);
    return true;
  }
  
  private boolean g(String paramString)
  {
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
          break label222;
        }
        ??? = new File(EmoticonUtils.H5MagicFileListPath.replace("[epId]", paramString));
        boolean bool = ((File)???).exists();
        if (!bool) {
          return false;
        }
      }
      ??? = new JSONObject(FileUtils.b((File)???));
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, error=" + MsfSdkUtils.getStackTraceString(paramString));
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
          label222:
          if (??? != null)
          {
            paramString = ((ArrayList)???).iterator();
            while (paramString.hasNext())
            {
              ??? = new File((String)paramString.next());
              if ((??? != null) && (!((File)???).exists()))
              {
                if (QLog.isColorLevel()) {
                  QLog.e(jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, file miss: " + ???);
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
      QLog.e(jdField_a_of_type_JavaLangString, 1, "collectEmoji fail to download Emoticon");
      return -1;
    }
    return MarketFaceItemBuilder.a(null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticon, null);
  }
  
  int a(EmoticonPackage paramEmoticonPackage, ArrayList<Emoticon> paramArrayList, List<String> paramList, Map<String, File> paramMap, Bundle paramBundle, int paramInt)
  {
    int i = 0;
    while (i < paramArrayList.size())
    {
      Emoticon localEmoticon = (Emoticon)paramArrayList.get(i);
      Object localObject;
      if ((paramInt & 0x2) == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo imgPreview.pid=" + localEmoticon.epId + " eid=" + localEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
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
        }
      }
      label385:
      for (int j = 15;; j = 6)
      {
        paramBundle.putInt((String)localObject, j);
        if (((paramInt & 0x4) != 4) && ((paramInt & 0x20) != 32)) {
          break label410;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo gif.pid=" + localEmoticon.epId + " eid=" + localEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
        }
        localObject = null;
        if (paramEmoticonPackage.jobType != 1)
        {
          if (!localEmoticon.hasEncryptKey()) {
            break;
          }
          j = paramEmoticonPackage.rscType;
          if ((paramInt & 0x20) == 32) {
            j = 2;
          }
          localObject = a(localEmoticon, j);
        }
        if (localObject != null) {
          break label396;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| fail Emoticon download emo gif.pid=" + localEmoticon.epId + " eid=" + localEmoticon.eId);
        }
        return 11030;
      }
      return 11009;
      label396:
      a(paramEmoticonPackage, paramList, paramMap, paramBundle, localEmoticon, (String[])localObject);
      label410:
      a(paramList, paramMap, paramBundle, paramInt, localEmoticon);
      b(paramList, paramMap, paramBundle, paramInt, localEmoticon);
      i += 1;
    }
    return 0;
  }
  
  int a(EmoticonPackage paramEmoticonPackage, ArrayList<Emoticon> paramArrayList, List<String> paramList, Map<String, File> paramMap, Bundle paramBundle, int paramInt, boolean paramBoolean)
  {
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (Emoticon)paramArrayList.get(i);
      if ((paramInt & 0x2) == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo imgPreview.pid=" + ((Emoticon)localObject).epId + " eid=" + ((Emoticon)localObject).eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
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
          QLog.d(jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo gif.pid=" + ((Emoticon)localObject).epId + " eid=" + ((Emoticon)localObject).eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
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
  
  int a(File paramFile, EmoticonPackage paramEmoticonPackage, boolean paramBoolean, List<String> paramList, Map<String, File> paramMap, Bundle paramBundle, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    ReqInfo localReqInfo = new ReqInfo();
    byte[] arrayOfByte = null;
    if (paramFile != null) {}
    label521:
    for (;;)
    {
      try
      {
        if (paramFile.exists())
        {
          arrayOfByte = FileUtils.a(paramFile);
          if (paramEmoticonPackage.jobType == 4)
          {
            paramFile = EmotionJsonUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, jdField_c_of_type_Int, arrayOfByte, localArrayList);
            if (paramEmoticonPackage.isAPNG != 2) {
              break label521;
            }
            paramInt |= 0x20;
            if (paramFile == null) {
              continue;
            }
            QLog.e(jdField_a_of_type_JavaLangString, 1, "addEmotionsTask| parse json error");
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
        QLog.e(jdField_a_of_type_JavaLangString, 1, "OutOfMemoryError e = " + paramFile.getMessage());
        arrayOfByte = null;
        continue;
        paramFile = EmotionJsonUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, jdField_c_of_type_Int, arrayOfByte, localArrayList, localReqInfo);
        continue;
        if ((!TextUtils.isEmpty(paramEmoticonPackage.minQQVersion)) && (!IndividuationConfigInfo.a(paramEmoticonPackage.minQQVersion, "8.5.5")))
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "unavailable in current version, min version=" + paramEmoticonPackage.minQQVersion);
          return 11011;
        }
        paramBundle.putBoolean("isUpdate", paramBoolean);
        paramBundle.putSerializable("emoticonList", localArrayList);
        if ((!localReqInfo.jdField_a_of_type_Boolean) && (paramEmoticonPackage.jobType != 4))
        {
          int i = 0;
          localReqInfo.jdField_a_of_type_JavaLangString = null;
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| fetchEncryptKeys count=" + i);
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
            QLog.d(jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| fetchEncryptKeys count=" + j + " encryptKeysSuccess=" + localReqInfo.jdField_a_of_type_Boolean);
          }
          if (!localReqInfo.jdField_a_of_type_Boolean)
          {
            QLog.e(jdField_a_of_type_JavaLangString, 1, "addEmoticonsTask| fetchEncryptKeys fail epId=" + paramEmoticonPackage.epId + " encryptGetKeySeq=" + localReqInfo.jdField_a_of_type_JavaLangString + " encryptKeysResultCode" + localReqInfo.jdField_a_of_type_Int);
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
    paramBundle = a().c(str, -1);
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
    Object localObject = a().a(str, -1);
    paramBundle = (Bundle)localObject;
    if (localObject != null)
    {
      paramBundle = (Bundle)localObject;
      if (!a(i, ((EmoticonPackage)localObject).jobType))
      {
        a().a((EmoticonPackage)localObject);
        paramBundle = null;
      }
    }
    localObject = paramBundle;
    if (paramBundle == null)
    {
      localObject = new EmoticonPackage();
      ((EmoticonPackage)localObject).epId = str;
      ((EmoticonPackage)localObject).wordingId = -1L;
      if (i != 2) {
        break label416;
      }
      ((EmoticonPackage)localObject).jobType = 1;
    }
    for (;;)
    {
      ((EmoticonPackage)localObject).isMagicFaceDownloading = false;
      if (i == 4) {
        ((EmoticonPackage)localObject).jobType = 5;
      }
      a((EmoticonPackage)localObject, true, j);
      localBundle.putInt("result", 0);
      localBundle.putString("messge", "");
      localBundle.putInt("sceneType", j);
      return localBundle;
      label416:
      if (i == 3) {
        ((EmoticonPackage)localObject).jobType = 3;
      } else if (i == 4) {
        ((EmoticonPackage)localObject).jobType = 5;
      } else if (i == 5) {
        ((EmoticonPackage)localObject).jobType = 4;
      } else {
        ((EmoticonPackage)localObject).jobType = 0;
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
    int m = -1;
    int i = 0;
    int n = 0;
    int i1 = 0;
    EmoticonPackage localEmoticonPackage = a().c(paramString, paramInt2);
    paramInt2 = i;
    if (localEmoticonPackage != null) {
      if (!localEmoticonPackage.valid) {
        break label133;
      }
    }
    label133:
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      if (paramInt1 == 2) {
        paramInt2 = 1;
      }
      TaskStatus localTaskStatus = (TaskStatus)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      int k = m;
      int j = n;
      i = i1;
      if (localTaskStatus != null)
      {
        k = m;
        j = n;
        i = i1;
        if (!localTaskStatus.a())
        {
          k = 0;
          i = (int)localTaskStatus.a();
          j = 2;
        }
      }
      return a(paramString, paramInt1, k, paramInt2, j, 0, 0L, i, -1, null, null, localEmoticonPackage);
    }
  }
  
  public EmoticonManager a()
  {
    return (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER);
  }
  
  DownloaderInterface a()
  {
    return ((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
  }
  
  void a(Bundle paramBundle, Object paramObject, boolean paramBoolean, int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    boolean bool1 = paramBundle.getBoolean("newPkgAdd", false);
    boolean bool2 = paramBundle.getBoolean("isUpdate", false);
    boolean bool3 = paramBundle.getBoolean("wifiAutoDownload", true);
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramBundle.getSerializable("emoticonPackage");
    if (localEmoticonPackage == null) {
      return;
    }
    int i;
    if ((localEmoticonPackage.jobType == 3) || (localEmoticonPackage.jobType == 5))
    {
      i = 1;
      label69:
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onDone:epId=" + localEmoticonPackage.epId + " task:" + paramObject + " localVersion=" + localEmoticonPackage.localVersion + ",latestVersion=" + localEmoticonPackage.latestVersion + ",updateFlag=" + localEmoticonPackage.updateFlag);
      }
      if (!paramBoolean) {}
    }
    else
    {
      for (;;)
      {
        try
        {
          paramInt2 = EmosmUtils.a(paramInt1);
          QLog.e(jdField_a_of_type_JavaLangString, 1, "handleEmoticonPackageDownloaded : download error ,reportCode = " + paramInt1);
          jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(localEmoticonPackage, paramInt2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          VasReportUtils.a("emotionType", "emotionActionDownload", "11", localEmoticonPackage.epId, "", "", paramInt1 + "", "", "", "");
          a(localEmoticonPackage, paramInt2, 0L, paramString);
          if (!bool1) {
            break;
          }
          if (localEmoticonPackage.type != 1) {
            break label322;
          }
          paramInt1 = 5;
          EmoticonManager.c(String.valueOf(paramInt2), paramInt1);
          return;
        }
        catch (Exception paramBundle)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "handleEmoticonPackageDownloaded failed", paramBundle);
          return;
        }
        i = 0;
        break label69;
        label322:
        paramInt1 = 4;
      }
    }
    if ((bool2) && (i == 0))
    {
      paramBundle = (ArrayList)paramBundle.getSerializable("emoticonList");
      if ((paramBundle != null) && (paramBundle.size() > 0))
      {
        a().a(localEmoticonPackage.epId, paramBundle);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "update package:" + localEmoticonPackage.epId + ",newEmoticons:" + paramBundle.size());
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
        break label603;
      }
      paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      Object localObject = paramObject.query(EmoticonPackage.class, true, "childEpId=?", new String[] { localEmoticonPackage.epId }, null, null, null, null);
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
    paramObject.close();
    label603:
    if (bool1) {}
    try
    {
      paramBundle.h(localEmoticonPackage.epId, paramInt2);
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
    paramEmoticonPackage.jdField_e_of_type_Long = this.jdField_e_of_type_Int;
    paramEmoticonPackage.n = true;
    a().a(paramEmoticonPackage, this.jdField_b_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt, long paramLong, String paramString)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "download emoji report actionResult=" + paramInt + ",epId=" + paramEmoticonPackage.epId + ",downloadTime=" + paramLong);
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
      QLog.d(jdField_a_of_type_JavaLangString, 2, "package download epId:" + paramEmoticonPackage.epId);
    }
    if ((paramEmoticonPackage == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "ep or mApp = null");
      return;
    }
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "netUnSupport epId=" + paramEmoticonPackage.epId);
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
    label251:
    Object localObject2;
    label270:
    label372:
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
        ((DownloadTask)localObject2).n = true;
        if (localArrayList.size() != 0) {
          break label998;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| urlList is empty");
        }
        ((DownloadTask)localObject2).a(localBundle);
        ((DownloadTask)localObject2).a(3);
        paramDownloadListener.onDone((DownloadTask)localObject2);
        if (paramEmoticonPackage.jobType != 5) {
          break label1029;
        }
        b(paramEmoticonPackage, paramBoolean1);
      }
    }
    else
    {
      if (paramEmoticonPackage.jobType == 5)
      {
        ((VasExtensionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a.a(paramEmoticonPackage, paramBoolean1, paramBoolean2);
        return;
      }
      localObject2 = "vipEmoticonKey_" + paramEmoticonPackage.epId;
      localObject1 = EmosmUtils.a(paramEmoticonPackage.epId);
      if (paramEmoticonPackage.jobType == 4) {
        localObject1 = EmoticonUtils.smallEmoticonJsonUrl.replace("[epId]", paramEmoticonPackage.epId);
      }
      localFile = new File(EmoticonUtils.emoticonJsonFilePath.replace("[epId]", paramEmoticonPackage.epId));
      localObject1 = new DownloadTask((String)localObject1, localFile);
      TaskStatus localTaskStatus = new TaskStatus(paramEmoticonPackage.epId, (DownloadTask)localObject1);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(jdField_b_of_type_JavaLangString + paramEmoticonPackage.epId, localTaskStatus);
      ((DownloadTask)localObject1).g = jdField_b_of_type_Boolean;
      ((DownloadTask)localObject1).j = true;
      ((DownloadTask)localObject1).n = true;
      paramInt = DownloaderFactory.a((DownloadTask)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(jdField_b_of_type_JavaLangString + paramEmoticonPackage.epId);
      jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(paramEmoticonPackage, paramInt);
      if (paramInt != 0)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "json download faile : resultCode = " + paramInt);
        paramInt = EmosmUtils.a(paramInt);
        jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(paramEmoticonPackage, paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        VasReportUtils.a("emotionType", "emotionActionDownload", "3", paramEmoticonPackage.epId, "", NetworkUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()) + "", paramInt + "", "", "", "");
        return;
      }
      paramBoolean2 = EmoticonUtils.emoticonPkgNeedUpdate(paramEmoticonPackage);
      if (((paramEmoticonPackage.jobType == 0) || (paramEmoticonPackage.jobType == 4)) && (!paramBoolean2)) {
        a(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
      }
      b(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
      if (paramEmoticonPackage.isAPNG == 2)
      {
        paramInt = 42;
        label822:
        if (paramEmoticonPackage.jobType != 5) {
          break label959;
        }
        paramInt = 6;
      }
    }
    label1029:
    label1038:
    for (;;)
    {
      paramInt = a(localFile, paramEmoticonPackage, paramBoolean2, localArrayList, localHashMap, localBundle, paramInt);
      if (paramInt != 0)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "handleEmotionPackage|addEmotionsTask fail : resultCode = " + paramInt);
        jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(paramEmoticonPackage, paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        VasReportUtils.a("emotionType", "emotionActionDownload", "5", paramEmoticonPackage.epId, "", "", paramInt + "", "", "", "");
        return;
        paramInt = 14;
        break label822;
        label959:
        if (paramEmoticonPackage.jobType != 3) {
          break label1038;
        }
        paramInt |= 0x1;
        continue;
        if (paramEmoticonPackage.jobType != 5) {
          break label270;
        }
        f(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
        break label270;
        label998:
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| startDownload");
        }
        a().a((DownloadTask)localObject2, paramDownloadListener, localBundle);
        break label372;
        break;
      }
      localObject1 = localObject2;
      break label251;
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
    label136:
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
          break label136;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 2, "pullEmoticonPackage task exist epId = " + paramEmoticonPackage.epId);
        return;
        if (paramInt == 1) {
          paramEmoticonPackage.kandian = true;
        }
      }
      if (localTaskStatus == null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "pullEmoticonPackage jsonTask exist epId = " + paramEmoticonPackage.epId);
    return;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "try to pullEmoticonPackage ep:" + paramEmoticonPackage.epId);
    }
    if (!EmosmUtils.a(paramEmoticonPackage.epId))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "ep.epId=" + paramEmoticonPackage.epId + " isNumeral false.");
      VasReportUtils.a("emotionType", "emotionActionDownload", "1", paramEmoticonPackage.epId, "", "", "", "", "", "");
      return;
    }
    if (!paramEmoticonPackage.isMagicFaceDownloading) {
      if ((paramEmoticonPackage.status != 2) || (!EmoticonUtils.isEmoticonPkgUpdateBitSet(paramEmoticonPackage.updateFlag))) {
        break label416;
      }
    }
    for (;;)
    {
      paramEmoticonPackage.valid = true;
      a().a(paramEmoticonPackage);
      localObject = new File(AppConstants.SDCARD_EMOTICON_SAVE);
      if (!((File)localObject).exists())
      {
        boolean bool = ((File)localObject).mkdirs();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "mkdirs success:" + bool);
        }
      }
      ThreadManager.excute(new EmojiManager.5(this, paramEmoticonPackage, paramBoolean1, paramBoolean2, paramInt), 128, null, true);
      return;
      label416:
      paramEmoticonPackage.status = 0;
    }
  }
  
  /* Error */
  void a(DownloadTask paramDownloadTask)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: invokevirtual 1219	com/tencent/mobileqq/vip/DownloadTask:a	()Landroid/os/Bundle;
    //   9: ldc_w 943
    //   12: invokevirtual 947	android/os/Bundle:getSerializable	(Ljava/lang/String;)Ljava/io/Serializable;
    //   15: checkcast 221	com/tencent/mobileqq/data/EmoticonPackage
    //   18: astore 6
    //   20: aload_1
    //   21: getfield 1220	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   24: aload_1
    //   25: getfield 643	com/tencent/mobileqq/vip/DownloadTask:c	Ljava/lang/String;
    //   28: invokeinterface 1221 2 0
    //   33: checkcast 394	java/io/File
    //   36: astore 7
    //   38: aload_0
    //   39: getfield 78	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   42: aload_1
    //   43: getfield 643	com/tencent/mobileqq/vip/DownloadTask:c	Ljava/lang/String;
    //   46: invokeinterface 1222 2 0
    //   51: ifeq +603 -> 654
    //   54: aload_0
    //   55: getfield 78	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   58: astore 4
    //   60: aload 4
    //   62: monitorenter
    //   63: aload_0
    //   64: getfield 78	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   67: aload_1
    //   68: getfield 643	com/tencent/mobileqq/vip/DownloadTask:c	Ljava/lang/String;
    //   71: invokeinterface 1221 2 0
    //   76: checkcast 382	java/lang/String
    //   79: astore_3
    //   80: aload_0
    //   81: getfield 78	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   84: aload_1
    //   85: getfield 643	com/tencent/mobileqq/vip/DownloadTask:c	Ljava/lang/String;
    //   88: invokeinterface 1223 2 0
    //   93: pop
    //   94: aload 4
    //   96: monitorexit
    //   97: aload 7
    //   99: ifnull +546 -> 645
    //   102: aload 7
    //   104: invokestatic 624	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;)[B
    //   107: astore 5
    //   109: aload 7
    //   111: invokevirtual 627	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   114: astore 4
    //   116: aload 7
    //   118: invokevirtual 630	java/io/File:delete	()Z
    //   121: pop
    //   122: goto +537 -> 659
    //   125: aload_1
    //   126: iconst_1
    //   127: putfield 1224	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Boolean	Z
    //   130: getstatic 41	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   133: iconst_1
    //   134: ldc_w 1226
    //   137: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: getstatic 62	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager	Lcom/tencent/mobileqq/emoticon/EmojiListenerManager;
    //   143: aload 6
    //   145: sipush 11013
    //   148: aload_0
    //   149: getfield 73	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   152: invokevirtual 950	com/tencent/mobileqq/emoticon/EmojiListenerManager:a	(Lcom/tencent/mobileqq/data/EmoticonPackage;ILcom/tencent/mobileqq/app/QQAppInterface;)V
    //   155: ldc_w 556
    //   158: ldc_w 813
    //   161: ldc_w 634
    //   164: aload 6
    //   166: getfield 814	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   169: ldc_w 336
    //   172: ldc_w 336
    //   175: ldc_w 336
    //   178: ldc_w 336
    //   181: ldc_w 336
    //   184: ldc_w 336
    //   187: invokestatic 573	com/tencent/mobileqq/vas/VasReportUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   190: return
    //   191: astore_3
    //   192: aload_3
    //   193: invokevirtual 683	java/lang/Throwable:printStackTrace	()V
    //   196: getstatic 41	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   199: iconst_2
    //   200: new 158	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   207: ldc_w 1228
    //   210: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_3
    //   214: invokevirtual 686	java/lang/Throwable:toString	()Ljava/lang/String;
    //   217: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: ldc_w 523
    //   223: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokestatic 529	java/lang/System:currentTimeMillis	()J
    //   229: invokevirtual 532	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   232: ldc_w 680
    //   235: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload_1
    //   239: getfield 643	com/tencent/mobileqq/vip/DownloadTask:c	Ljava/lang/String;
    //   242: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: aload_1
    //   252: iconst_1
    //   253: putfield 1224	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Boolean	Z
    //   256: getstatic 62	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager	Lcom/tencent/mobileqq/emoticon/EmojiListenerManager;
    //   259: aload 6
    //   261: sipush 11020
    //   264: aload_0
    //   265: getfield 73	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   268: invokevirtual 950	com/tencent/mobileqq/emoticon/EmojiListenerManager:a	(Lcom/tencent/mobileqq/data/EmoticonPackage;ILcom/tencent/mobileqq/app/QQAppInterface;)V
    //   271: ldc_w 556
    //   274: ldc_w 813
    //   277: ldc_w 696
    //   280: aload 6
    //   282: getfield 814	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   285: ldc_w 336
    //   288: ldc_w 336
    //   291: ldc_w 336
    //   294: ldc_w 336
    //   297: ldc_w 336
    //   300: ldc_w 336
    //   303: invokestatic 573	com/tencent/mobileqq/vas/VasReportUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   306: return
    //   307: astore_3
    //   308: aload 4
    //   310: monitorexit
    //   311: aload_3
    //   312: athrow
    //   313: aload 6
    //   315: getfield 407	com/tencent/mobileqq/data/EmoticonPackage:jobType	I
    //   318: iconst_4
    //   319: if_icmpeq +73 -> 392
    //   322: aload_3
    //   323: ifnonnull +69 -> 392
    //   326: aload_1
    //   327: iconst_1
    //   328: putfield 1224	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Boolean	Z
    //   331: getstatic 41	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   334: iconst_1
    //   335: ldc_w 1230
    //   338: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: getstatic 62	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager	Lcom/tencent/mobileqq/emoticon/EmojiListenerManager;
    //   344: aload 6
    //   346: sipush 11009
    //   349: aload_0
    //   350: getfield 73	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   353: invokevirtual 950	com/tencent/mobileqq/emoticon/EmojiListenerManager:a	(Lcom/tencent/mobileqq/data/EmoticonPackage;ILcom/tencent/mobileqq/app/QQAppInterface;)V
    //   356: ldc_w 556
    //   359: ldc_w 813
    //   362: ldc_w 673
    //   365: aload 6
    //   367: getfield 814	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   370: ldc_w 336
    //   373: ldc_w 336
    //   376: ldc_w 336
    //   379: ldc_w 336
    //   382: ldc_w 336
    //   385: ldc_w 336
    //   388: invokestatic 573	com/tencent/mobileqq/vas/VasReportUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   391: return
    //   392: aload 6
    //   394: getfield 407	com/tencent/mobileqq/data/EmoticonPackage:jobType	I
    //   397: iconst_4
    //   398: if_icmpne +235 -> 633
    //   401: aload 5
    //   403: aload 4
    //   405: invokestatic 676	com/tencent/mobileqq/emosm/EmosmUtils:a	([BLjava/lang/String;)I
    //   408: istore_2
    //   409: iload_2
    //   410: ifeq +164 -> 574
    //   413: getstatic 41	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   416: iconst_2
    //   417: new 158	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   424: ldc_w 1232
    //   427: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: aload_1
    //   431: getfield 643	com/tencent/mobileqq/vip/DownloadTask:c	Ljava/lang/String;
    //   434: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   440: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   443: ldc_w 556
    //   446: ldc_w 813
    //   449: ldc_w 688
    //   452: aload 6
    //   454: getfield 814	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   457: ldc_w 336
    //   460: ldc_w 336
    //   463: new 158	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   470: iload_2
    //   471: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   474: ldc_w 336
    //   477: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: ldc_w 336
    //   486: ldc_w 336
    //   489: ldc_w 336
    //   492: invokestatic 573	com/tencent/mobileqq/vas/VasReportUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   495: invokestatic 580	com/tencent/mobileqq/util/Utils:a	()Z
    //   498: ifeq +76 -> 574
    //   501: invokestatic 582	com/tencent/mobileqq/util/Utils:b	()J
    //   504: ldc2_w 583
    //   507: lcmp
    //   508: ifle +66 -> 574
    //   511: new 158	java/lang/StringBuilder
    //   514: dup
    //   515: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   518: getstatic 648	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH	Ljava/lang/String;
    //   521: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: ldc_w 650
    //   527: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: getstatic 476	java/io/File:separator	Ljava/lang/String;
    //   533: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: aload 6
    //   538: getfield 814	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   541: invokestatic 653	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   544: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: ldc_w 655
    //   550: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: aload 7
    //   555: invokevirtual 658	java/io/File:getName	()Ljava/lang/String;
    //   558: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: invokestatic 664	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   567: aload 5
    //   569: iconst_0
    //   570: invokestatic 667	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;[BZ)Z
    //   573: pop
    //   574: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   577: ifeq -573 -> 4
    //   580: getstatic 41	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   583: iconst_2
    //   584: new 158	java/lang/StringBuilder
    //   587: dup
    //   588: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   591: ldc_w 1234
    //   594: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: iload_2
    //   598: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   601: ldc_w 523
    //   604: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: invokestatic 529	java/lang/System:currentTimeMillis	()J
    //   610: invokevirtual 532	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   613: ldc_w 680
    //   616: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: aload_1
    //   620: getfield 643	com/tencent/mobileqq/vip/DownloadTask:c	Ljava/lang/String;
    //   623: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   629: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   632: return
    //   633: aload 5
    //   635: aload_3
    //   636: aload 4
    //   638: invokestatic 639	com/tencent/mobileqq/emosm/EmosmUtils:a	([BLjava/lang/String;Ljava/lang/String;)I
    //   641: istore_2
    //   642: goto -233 -> 409
    //   645: aconst_null
    //   646: astore 4
    //   648: aconst_null
    //   649: astore 5
    //   651: goto +8 -> 659
    //   654: aconst_null
    //   655: astore_3
    //   656: goto -559 -> 97
    //   659: aload 5
    //   661: ifnull -536 -> 125
    //   664: aload 4
    //   666: ifnonnull -353 -> 313
    //   669: goto -544 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	672	0	this	EmojiManager
    //   0	672	1	paramDownloadTask	DownloadTask
    //   408	234	2	i	int
    //   79	1	3	str1	String
    //   191	23	3	localThrowable	Throwable
    //   307	329	3	str2	String
    //   655	1	3	localObject1	Object
    //   107	553	5	arrayOfByte	byte[]
    //   18	519	6	localEmoticonPackage	EmoticonPackage
    //   36	518	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   38	63	191	java/lang/Throwable
    //   102	122	191	java/lang/Throwable
    //   125	190	191	java/lang/Throwable
    //   311	313	191	java/lang/Throwable
    //   313	322	191	java/lang/Throwable
    //   326	391	191	java/lang/Throwable
    //   392	409	191	java/lang/Throwable
    //   413	574	191	java/lang/Throwable
    //   574	632	191	java/lang/Throwable
    //   633	642	191	java/lang/Throwable
    //   63	97	307	finally
    //   308	311	307	finally
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
    this.jdField_a_of_type_ComTencentImageJobQueue.excuteOnNetThread(new EmojiManager.4(this, paramBoolean, paramString, paramInt2, paramInt1, paramBundle), true);
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
        FileUtils.a(EmoticonUtils.H5MagicFileListPath.replace("[epId]", paramString1), ((JSONObject)localObject).toString());
        return;
      }
      catch (JSONException paramString1)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "", paramString1);
        return;
      }
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "emotionDownloadListener | onDoneFile h5 magic, childFiles is null");
  }
  
  public void a(String paramString, ArrayList<Emoticon> paramArrayList)
  {
    int i = EmosmUtils.a(paramString);
    if ((paramArrayList == null) || (paramArrayList.size() == 0) || (i == -1)) {
      return;
    }
    int j = this.f;
    this.f = (j + 1);
    paramString = Integer.toString(j);
    ((EmoticonHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM)).a(i, paramArrayList, paramString);
  }
  
  public void a(String paramString, ArrayList<Emoticon> paramArrayList, ReqInfo paramReqInfo)
  {
    int i = EmosmUtils.a(paramString);
    if ((paramArrayList == null) || (paramArrayList.size() == 0) || (paramReqInfo == null) || (i == -1)) {
      return;
    }
    paramString = new Object();
    EmoticonHandler localEmoticonHandler = (EmoticonHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM);
    localEmoticonHandler.a(new EmojiManager.6(this, localEmoticonHandler, paramReqInfo, paramString));
    int j = this.f;
    this.f = (j + 1);
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
  
  void a(List<String> paramList, Map<String, File> paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
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
      QLog.d(jdField_a_of_type_JavaLangString, 2, "canPlayH5Magic isPlay = " + bool3 + ";isDPCSupport = " + bool4);
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
    localPicEmoticonInfo.type = 6;
    localPicEmoticonInfo.isAPNG = paramEmoticon.isAPNG;
    paramEmoticon = a(paramEmoticon);
    if (paramEmoticon == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "sendEmojiToAio fail to download Emoticon");
      return false;
    }
    localPicEmoticonInfo.emoticon = paramEmoticon;
    MarketFaceItemBuilder.a = localPicEmoticonInfo;
    return true;
  }
  
  public boolean a(Emoticon paramEmoticon, int paramInt)
  {
    if (paramEmoticon == null) {}
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon|taskvalue:" + paramInt + "，epid:" + paramEmoticon.epId + "，eid=" + paramEmoticon.eId);
      }
    } while ((d(paramEmoticon)) || (c(paramEmoticon, paramInt)) || (d(paramEmoticon, paramInt)) || (e(paramEmoticon, paramInt)));
    return f(paramEmoticon, paramInt);
  }
  
  public boolean a(String paramString)
  {
    boolean bool = d(paramString);
    a(paramString, bool);
    return bool;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    String str3 = EmoticonUtils.emoticonPackageFolderPath.replace("[epId]", paramString);
    String str1;
    int i;
    if (paramInt == h)
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
        QLog.i(jdField_a_of_type_JavaLangString, 2, "videoConfigPath ==" + str1);
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
    if (paramInt == g)
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
      localObject = (ArrayList)a().a(paramString);
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          localObject = (Emoticon)((Iterator)localObject).next();
          if (localObject == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, one of encrypts is null!" + paramString);
            }
            return false;
          }
          if ((((Emoticon)localObject).jobType == 4) && ((((Emoticon)localObject).encryptKey == null) || (((Emoticon)localObject).encryptKey.length() == 0)))
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, encrypt isn't exist.epId=" + paramString + " eId=" + ((Emoticon)localObject).eId);
            }
            return false;
          }
          if (!new File(EmoticonUtils.emoticonPreviewPath.replace("[epId]", paramString).replace("[eId]", ((Emoticon)localObject).eId)).exists())
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, emo img preview do not be exist! epId=" + paramString + " eId=" + ((Emoticon)localObject).eId);
            }
            return false;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, emoticons do not be exist.epId=" + paramString);
        }
        return false;
      }
    }
    Object localObject = new File(EmoticonUtils.H5MagicRootPath.replace("[epId]", paramString));
    if ((localObject != null) && (!((File)localObject).exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, no root path: " + localObject);
      }
      return false;
    }
    return g(paramString);
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
    return new String[] { EmoticonUtils.emoticonSoundUrl.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId), EmoticonUtils.emoticonSoundPath.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId) };
  }
  
  String[] a(Emoticon paramEmoticon, int paramInt)
  {
    if (paramEmoticon.jobType == 3)
    {
      str1 = EmoticonUtils.smallGifUrl.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      if (paramInt != 2) {}
    }
    boolean bool;
    for (String str1 = EmoticonUtils.smallApngUrl.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);; str1 = EmoticonUtils.emoticonPNGZIPUrl.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId))
    {
      str2 = EmoticonUtils.emoticonEncryptPath.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      if (paramInt == 2) {
        str2 = EmoticonUtils.emoticonAPNGPath.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
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
      str2 = EmoticonUtils.emoticonEncryptExtensionApngUrl.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId);
      if (bool)
      {
        str1 = String.valueOf(paramEmoticon.extensionWidth);
        label265:
        str2 = str2.replace("[width]", str1);
        if (!bool) {
          break label313;
        }
      }
      label313:
      for (str1 = String.valueOf(paramEmoticon.extensionHeight);; str1 = "200")
      {
        str1 = str2.replace("[height]", str1);
        break;
        str1 = "200";
        break label265;
      }
    }
    String str2 = EmoticonUtils.emoticonEncryptExtensionUrl.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId);
    if (bool)
    {
      str1 = String.valueOf(paramEmoticon.extensionWidth);
      label364:
      str2 = str2.replace("[width]", str1);
      if (!bool) {
        break label412;
      }
    }
    label412:
    for (str1 = String.valueOf(paramEmoticon.extensionHeight);; str1 = "200")
    {
      str1 = str2.replace("[height]", str1);
      break;
      str1 = "200";
      break label364;
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
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| handle h5magic chiled emotion and childEpId = " + paramEmoticonPackage.childEpId);
    }
    if (paramBoolean)
    {
      localObject = (EmoticonHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM);
      if (localObject != null) {
        ((EmoticonHandler)localObject).a(paramEmoticonPackage.childEpId, 0);
      }
    }
    EmoticonPackage localEmoticonPackage = a().c(paramEmoticonPackage.childEpId, 0);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| old childEp = " + localEmoticonPackage);
    }
    Object localObject = localEmoticonPackage;
    if (localEmoticonPackage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| childEpId = " + paramEmoticonPackage.childEpId);
      }
      localObject = new EmoticonPackage();
      ((EmoticonPackage)localObject).epId = paramEmoticonPackage.childEpId;
      ((EmoticonPackage)localObject).wordingId = -1L;
      ((EmoticonPackage)localObject).jobType = 5;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| auto download childEp = " + localObject);
    }
    a((EmoticonPackage)localObject, paramBoolean);
  }
  
  void b(DownloadTask paramDownloadTask)
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
        FileUtils.a(((File)localObject).getAbsolutePath(), EmoticonUtils.emoticonPackageFolderPath.replace("[epId]", localEmoticonPackage.epId), false);
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
      FileUtils.a(((File)localObject).getAbsolutePath(), EmoticonUtils.pngFramePath.replace("[epId]", localIOException1.epId), false);
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
  
  void b(List<String> paramList, Map<String, File> paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
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
    return ((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCNames.h5magic_support.name());
  }
  
  /* Error */
  public boolean b(Emoticon paramEmoticon)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 73	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: getstatic 1508	com/tencent/mobileqq/app/QQManagerFactory:FAVROAMING_DB_MANAGER	I
    //   7: invokevirtual 142	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10: checkcast 1510	com/tencent/mobileqq/emosm/favroaming/FavroamingDBManager
    //   13: astore 5
    //   15: aload 5
    //   17: invokevirtual 1513	com/tencent/mobileqq/emosm/favroaming/FavroamingDBManager:a	()Ljava/util/List;
    //   20: astore 4
    //   22: aload_0
    //   23: getfield 73	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   26: getstatic 264	com/tencent/mobileqq/app/QQManagerFactory:EMOTICON_MANAGER	I
    //   29: invokevirtual 142	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   32: checkcast 266	com/tencent/mobileqq/model/EmoticonManager
    //   35: aload_1
    //   36: getfield 261	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   39: invokevirtual 269	com/tencent/mobileqq/model/EmoticonManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/EmoticonPackage;
    //   42: ifnonnull +14 -> 56
    //   45: aload_0
    //   46: aload_1
    //   47: getfield 261	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   50: getstatic 58	com/tencent/mobileqq/emoticon/EmojiManager:jdField_c_of_type_Int	I
    //   53: invokevirtual 285	com/tencent/mobileqq/emoticon/EmojiManager:a	(Ljava/lang/String;I)V
    //   56: aload 4
    //   58: astore_3
    //   59: aload_0
    //   60: getfield 92	com/tencent/mobileqq/emoticon/EmojiManager:jdField_c_of_type_Boolean	Z
    //   63: ifne +122 -> 185
    //   66: aload 4
    //   68: ifnull +16 -> 84
    //   71: aload 4
    //   73: astore_3
    //   74: aload 4
    //   76: invokeinterface 1515 1 0
    //   81: ifeq +104 -> 185
    //   84: aload_0
    //   85: iconst_1
    //   86: putfield 92	com/tencent/mobileqq/emoticon/EmojiManager:jdField_c_of_type_Boolean	Z
    //   89: invokestatic 1516	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   92: invokestatic 1099	com/tencent/mobileqq/utils/NetworkUtil:d	(Landroid/content/Context;)Z
    //   95: ifne +5 -> 100
    //   98: iconst_0
    //   99: ireturn
    //   100: aload_0
    //   101: getfield 73	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   104: getstatic 1519	com/tencent/mobileqq/app/QQManagerFactory:FAV_ROAMING_MANAGER	I
    //   107: invokevirtual 142	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   110: checkcast 1521	com/tencent/mobileqq/emosm/favroaming/FavroamingManager
    //   113: astore 6
    //   115: aload 4
    //   117: astore_3
    //   118: aload 6
    //   120: invokevirtual 1522	com/tencent/mobileqq/emosm/favroaming/FavroamingManager:a	()Z
    //   123: ifeq +62 -> 185
    //   126: new 4	java/lang/Object
    //   129: dup
    //   130: invokespecial 71	java/lang/Object:<init>	()V
    //   133: astore_3
    //   134: new 1524	com/tencent/mobileqq/emoticon/EmojiManager$8
    //   137: dup
    //   138: aload_0
    //   139: aload_3
    //   140: invokespecial 1527	com/tencent/mobileqq/emoticon/EmojiManager$8:<init>	(Lcom/tencent/mobileqq/emoticon/EmojiManager;Ljava/lang/Object;)V
    //   143: astore 4
    //   145: aload_0
    //   146: getfield 73	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   149: aload 4
    //   151: invokevirtual 1531	com/tencent/mobileqq/app/QQAppInterface:addObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   154: aload 6
    //   156: invokevirtual 1533	com/tencent/mobileqq/emosm/favroaming/FavroamingManager:c	()V
    //   159: aload_3
    //   160: monitorenter
    //   161: aload_3
    //   162: ldc2_w 286
    //   165: invokevirtual 291	java/lang/Object:wait	(J)V
    //   168: aload_3
    //   169: monitorexit
    //   170: aload_0
    //   171: getfield 73	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   174: aload 4
    //   176: invokevirtual 1536	com/tencent/mobileqq/app/QQAppInterface:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   179: aload 5
    //   181: invokevirtual 1513	com/tencent/mobileqq/emosm/favroaming/FavroamingDBManager:a	()Ljava/util/List;
    //   184: astore_3
    //   185: aload_3
    //   186: ifnull -88 -> 98
    //   189: iconst_0
    //   190: istore_2
    //   191: iload_2
    //   192: aload_3
    //   193: invokeinterface 1031 1 0
    //   198: if_icmpge -100 -> 98
    //   201: aload_3
    //   202: iload_2
    //   203: invokeinterface 1537 2 0
    //   208: checkcast 1539	com/tencent/mobileqq/data/CustomEmotionData
    //   211: astore 4
    //   213: aload 4
    //   215: getfield 1542	com/tencent/mobileqq/data/CustomEmotionData:isMarkFace	Z
    //   218: ifeq +54 -> 272
    //   221: aload 4
    //   223: getfield 1545	com/tencent/mobileqq/data/CustomEmotionData:emoPath	Ljava/lang/String;
    //   226: aload_1
    //   227: getfield 261	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   230: invokevirtual 1462	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   233: ifeq +39 -> 272
    //   236: aload 4
    //   238: getfield 1546	com/tencent/mobileqq/data/CustomEmotionData:eId	Ljava/lang/String;
    //   241: aload_1
    //   242: getfield 272	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   245: invokevirtual 1462	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   248: ifeq +24 -> 272
    //   251: ldc_w 1548
    //   254: aload 4
    //   256: getfield 1551	com/tencent/mobileqq/data/CustomEmotionData:RomaingType	Ljava/lang/String;
    //   259: invokevirtual 1462	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   262: ifne -164 -> 98
    //   265: iconst_1
    //   266: ireturn
    //   267: astore_1
    //   268: aload_3
    //   269: monitorexit
    //   270: aload_1
    //   271: athrow
    //   272: iload_2
    //   273: iconst_1
    //   274: iadd
    //   275: istore_2
    //   276: goto -85 -> 191
    //   279: astore 6
    //   281: goto -113 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	this	EmojiManager
    //   0	284	1	paramEmoticon	Emoticon
    //   190	86	2	i	int
    //   58	211	3	localObject1	Object
    //   20	235	4	localObject2	Object
    //   13	167	5	localFavroamingDBManager	com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager
    //   113	42	6	localFavroamingManager	com.tencent.mobileqq.emosm.favroaming.FavroamingManager
    //   279	1	6	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   161	168	267	finally
    //   168	170	267	finally
    //   268	270	267	finally
    //   161	168	279	java/lang/InterruptedException
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
        localObject1 = EmoticonUtils.emoticonAIOPreviewPath.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      }
      bool1 = FileUtil.a((String)localObject1);
    }
    for (;;)
    {
      if ((bool1) && ((paramInt & 0x4) == 4)) {
        if (paramEmoticon.jobType != 1) {
          localObject1 = EmoticonUtils.emoticonEncryptPath.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
        }
      }
      for (boolean bool2 = FileUtil.a((String)localObject1);; bool2 = bool1)
      {
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if ((paramInt & 0x2) == 2) {
            bool1 = FileUtil.a(EmoticonUtils.emoticonPreviewPath.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId));
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
              bool2 = FileUtil.a(EmoticonUtils.emoticonSoundPath.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId));
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
        return FileUtil.a(EmoticonUtils.emoticonAPNGPath.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId));
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
              QLog.d(jdField_a_of_type_JavaLangString, 2, "one of encrypts is null!" + paramString);
            }
            return false;
          }
          if ((paramBoolean.jobType == 2) && ((paramBoolean.encryptKey == null) || (paramBoolean.encryptKey.length() == 0)))
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "encrypt isn't exist.epId=" + paramString + " eId=" + paramBoolean.eId);
            }
            return false;
          }
          if (!new File(EmoticonUtils.emoticonPreviewPath.replace("[epId]", paramString).replace("[eId]", paramBoolean.eId)).exists())
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "emo img preview do not be exist! epId=" + paramString + " eId=" + paramBoolean.eId);
            }
            return false;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "emoticons do not be exist.epId=" + paramString);
        }
        return false;
      }
    }
    String str2 = MagicfaceResLoader.a();
    String str3 = EmoticonUtils.emoticonPackageFolderPath.replace("[epId]", paramString);
    String str1 = str3 + str2 + File.separator + "video.ini";
    File localFile = new File(str1);
    paramBoolean = localFile;
    if (!localFile.exists())
    {
      str2 = "big";
      str1 = str3 + "big" + File.separator + "video.ini";
      localFile = new File(str1);
      paramBoolean = localFile;
      if (!localFile.exists()) {
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "videoConfigPath ==" + str1);
    }
    return a(paramString, str2, str3, paramBoolean);
  }
  
  public boolean b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool1 = true;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isH5MagicFacePackageIntact, epId = " + paramString + ", needKey = " + paramBoolean1 + ", needCheckChild = " + paramBoolean2);
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    boolean bool2 = a(paramString, paramBoolean1);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isH5MagicFacePackageIntact, result = " + bool2);
    }
    EmoticonPackage localEmoticonPackage = a().a(paramString);
    if (localEmoticonPackage != null) {
      if ((paramBoolean2) && (!TextUtils.isEmpty(localEmoticonPackage.childEpId)))
      {
        paramBoolean1 = a(localEmoticonPackage.childEpId, paramBoolean1);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "isH5MagicFacePackageIntact, childEpId = " + localEmoticonPackage.childEpId + ", childResult = " + paramBoolean1);
        }
        a(localEmoticonPackage.childEpId, paramBoolean1);
        if ((bool2) && (paramBoolean1))
        {
          paramBoolean1 = bool1;
          label217:
          a(paramString, paramBoolean1);
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isH5MagicFacePackageIntact, epId=" + paramString + ", result=" + paramBoolean1);
      }
      return paramBoolean1;
      paramBoolean1 = false;
      break label217;
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
      str = EmoticonUtils.emoticonAIOPreviewExtensionUrl.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId);
      if (bool)
      {
        localObject = String.valueOf(paramEmoticon.extensionWidth);
        str = str.replace("[width]", (CharSequence)localObject);
        if (!bool) {
          break label135;
        }
        localObject = String.valueOf(paramEmoticon.extensionHeight);
        label81:
        localObject = str.replace("[height]", (CharSequence)localObject);
        paramEmoticon = EmoticonUtils.emoticonAIOPreviewPath.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      }
    }
    for (;;)
    {
      return new String[] { localObject, paramEmoticon };
      localObject = "200";
      break;
      label135:
      localObject = "200";
      break label81;
      str = null;
      paramEmoticon = (Emoticon)localObject;
      localObject = str;
    }
  }
  
  void c(List<String> paramList, Map<String, File> paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (!a(paramEmoticonPackage.epId, h))
    {
      String str = EmosmUtils.a(paramEmoticonPackage.epId, 1);
      paramEmoticonPackage = EmoticonUtils.magicFaceZipPath.replace("[epId]", paramEmoticonPackage.epId);
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
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkSmallEmoticonPackageIntact, cover_pkg_thumb isn't exist." + (String)localObject);
      }
      return false;
    }
    localObject = EmosmUtils.a(3, paramString);
    if (!new File((String)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkSmallEmoticonPackageIntact, cover_pkg_color isn't exist." + (String)localObject);
      }
      return false;
    }
    localObject = EmosmUtils.a(4, paramString);
    if (!new File((String)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkSmallEmoticonPackageIntact, cover_pkg_gray isn't exist." + (String)localObject);
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
            QLog.d(jdField_a_of_type_JavaLangString, 2, "one of encrypts is null!" + paramString);
          }
          return false;
        }
        if (!new File(EmoticonUtils.emoticonPreviewPath.replace("[epId]", paramString).replace("[eId]", localEmoticon.eId)).exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "checkSmallEmoticonPackageIntact, emo img preview do not be exist! epId=" + paramString + " eId=" + localEmoticon.eId);
          }
          return false;
        }
        localObject = a().a(paramString, -1);
        if ((localObject != null) && (((EmoticonPackage)localObject).isAPNG == 2)) {}
        for (localObject = EmoticonUtils.emoticonAPNGPath.replace("[epId]", paramString).replace("[eId]", localEmoticon.eId); !new File((String)localObject).exists(); localObject = EmoticonUtils.emoticonEncryptPath.replace("[epId]", paramString).replace("[eId]", localEmoticon.eId))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "checkSmallEmoticonPackageIntact, emo img encrypt file do not be exist! epId=" + paramString + " eId=" + localEmoticon.eId);
          }
          return false;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "checkSmallEmoticonPackageIntact, emoticons do not be exist.epId=" + paramString);
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
  
  void d(List<String> paramList, Map<String, File> paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (!a(paramEmoticonPackage.epId, g))
    {
      String str = EmosmUtils.a(paramEmoticonPackage.epId, 0);
      paramEmoticonPackage = EmoticonUtils.magicFaceZipPath.replace("[epId]", paramEmoticonPackage.epId);
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
        QLog.d(jdField_a_of_type_JavaLangString, 2, "cover_pkg_thumb isn't exist." + (String)localObject);
        return false;
        localObject = EmosmUtils.a(3, paramString);
        if (new File((String)localObject).exists()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "cover_pkg_color isn't exist." + (String)localObject);
      return false;
      localObject = EmosmUtils.a(4, paramString);
      if (new File((String)localObject).exists()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "cover_pkg_gray isn't exist." + (String)localObject);
    return false;
    Object localObject = (ArrayList)a().a(paramString, true);
    EmoticonPackage localEmoticonPackage;
    if (localObject != null)
    {
      localEmoticonPackage = a().a(paramString, -1);
      if (localEmoticonPackage == null) {
        break label615;
      }
    }
    label578:
    label615:
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
            QLog.d(jdField_a_of_type_JavaLangString, 2, "one of encrypts is null!" + paramString);
            return false;
          }
          if ((localEmoticon.jobType == 0) && ((localEmoticon.encryptKey == null) || (localEmoticon.encryptKey.length() == 0)))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "encrypt isn't exist.epId=" + paramString + " eId=" + localEmoticon.eId);
            return false;
          }
          if (!new File(EmoticonUtils.emoticonPreviewPath.replace("[epId]", paramString).replace("[eId]", localEmoticon.eId)).exists())
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "emo img preview do not be exist! epId=" + paramString + " eId=" + localEmoticon.eId);
            return false;
          }
          if (1 == i) {
            return PngFrameUtil.a(EmoticonUtils.pngFramePath.replace("[epId]", paramString));
          }
          if ((localEmoticonPackage != null) && (localEmoticonPackage.isAPNG == 2)) {}
          for (localObject = EmoticonUtils.emoticonAPNGPath.replace("[epId]", paramString).replace("[eId]", localEmoticon.eId);; localObject = EmoticonUtils.emoticonEncryptPath.replace("[epId]", paramString).replace("[eId]", localEmoticon.eId))
          {
            if (new File((String)localObject).exists()) {
              break label578;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "emo img encrypt file do not be exist! epId=" + paramString + " eId=" + localEmoticon.eId);
            return false;
          }
          continue;
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "emoticons do not be exist.epId=" + paramString);
          }
        }
      }
      return true;
    }
  }
  
  void e(List<String> paramList, Map<String, File> paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage|add magic task ");
    }
    c(paramList, paramMap, paramEmoticonPackage, paramBundle);
    d(paramList, paramMap, paramEmoticonPackage, paramBundle);
  }
  
  protected boolean e(String paramString)
  {
    Object localObject = a().a(paramString);
    if (localObject != null) {}
    for (int i = ((EmoticonPackage)localObject).rscType;; i = 0)
    {
      if (1 == i) {
        return PngFrameUtil.a(EmoticonUtils.pngFramePath.replace("[epId]", paramString));
      }
      localObject = (ArrayList)a().a(paramString);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0) && (!new File(EmoticonUtils.emoticonEncryptPath.replace("[epId]", paramString).replace("[eId]", ((Emoticon)((ArrayList)localObject).get(0)).eId)).exists()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "emo img encrypt file do not be exist! epId=" + paramString + " eId=" + ((Emoticon)((ArrayList)localObject).get(0)).eId);
        }
        return false;
      }
      return true;
    }
  }
  
  void f(List<String> paramList, Map<String, File> paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage|add h5magic task ");
    }
    if (!b(paramEmoticonPackage.epId, true, false))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| add h5 zip url");
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
  
  public boolean f(String paramString)
  {
    return new File(EmoticonUtils.emoticonPackageFolderPath.replace("[epId]", paramString) + "audio" + File.separator + "audio.ini").exists();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "clear History. uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + " app=" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmojiManager
 * JD-Core Version:    0.7.0.1
 */