package com.tencent.mobileqq.identification;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQIdentiferActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.ytcommon.util.YTCommonInterface;
import dov.com.qq.im.ae.download.old.AEOldShortVideoResManager;
import dov.com.qq.im.ae.download.old.AEOldShortVideoResManager.SVConfigItem;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class IdentificationActivityHelper
  implements Handler.Callback, EIPCResultCallback
{
  public static boolean a;
  public int a;
  private QQIdentiferActivity jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferActivity;
  private IdentificationBaseModel jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationBaseModel;
  private String jdField_a_of_type_JavaLangString;
  public AtomicBoolean a;
  public MqqHandler a;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  @RequiresApi(api=18)
  public IdentificationActivityHelper(QQIdentiferActivity paramQQIdentiferActivity, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferActivity = paramQQIdentiferActivity;
    this.jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationBaseModel = IdentificationBaseModel.a(paramInt, paramQQIdentiferActivity.getIntent(), paramQQIdentiferActivity);
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static int a()
  {
    return SharedPreUtils.c();
  }
  
  /* Error */
  private static HashMap<String, Integer> a(File paramFile)
  {
    // Byte code:
    //   0: new 80	java/util/HashMap
    //   3: dup
    //   4: invokespecial 81	java/util/HashMap:<init>	()V
    //   7: astore_3
    //   8: new 83	java/io/BufferedReader
    //   11: dup
    //   12: new 85	java/io/FileReader
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 88	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   20: invokespecial 91	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   23: astore_1
    //   24: aload_1
    //   25: astore_0
    //   26: aload_1
    //   27: invokevirtual 95	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   30: astore_2
    //   31: aload_2
    //   32: ifnull +53 -> 85
    //   35: aload_1
    //   36: astore_0
    //   37: aload_2
    //   38: ldc 97
    //   40: invokevirtual 103	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   43: astore_2
    //   44: aload_2
    //   45: ifnull +30 -> 75
    //   48: aload_1
    //   49: astore_0
    //   50: aload_2
    //   51: arraylength
    //   52: iconst_2
    //   53: if_icmpne +22 -> 75
    //   56: aload_1
    //   57: astore_0
    //   58: aload_3
    //   59: aload_2
    //   60: iconst_0
    //   61: aaload
    //   62: aload_2
    //   63: iconst_1
    //   64: aaload
    //   65: invokestatic 109	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   68: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   71: invokevirtual 117	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   74: pop
    //   75: aload_1
    //   76: astore_0
    //   77: aload_1
    //   78: invokevirtual 95	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   81: astore_2
    //   82: goto -51 -> 31
    //   85: aload_1
    //   86: ifnull +7 -> 93
    //   89: aload_1
    //   90: invokevirtual 120	java/io/BufferedReader:close	()V
    //   93: aload_3
    //   94: areturn
    //   95: astore_0
    //   96: aload_0
    //   97: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   100: aload_3
    //   101: areturn
    //   102: astore_2
    //   103: aconst_null
    //   104: astore_1
    //   105: aload_1
    //   106: astore_0
    //   107: aload_2
    //   108: invokevirtual 124	java/lang/Exception:printStackTrace	()V
    //   111: aload_1
    //   112: astore_0
    //   113: ldc 126
    //   115: iconst_1
    //   116: new 128	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   123: ldc 131
    //   125: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_2
    //   129: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: aload_1
    //   139: ifnull -46 -> 93
    //   142: aload_1
    //   143: invokevirtual 120	java/io/BufferedReader:close	()V
    //   146: aload_3
    //   147: areturn
    //   148: astore_0
    //   149: aload_0
    //   150: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   153: aload_3
    //   154: areturn
    //   155: astore_1
    //   156: aconst_null
    //   157: astore_0
    //   158: aload_0
    //   159: ifnull +7 -> 166
    //   162: aload_0
    //   163: invokevirtual 120	java/io/BufferedReader:close	()V
    //   166: aload_1
    //   167: athrow
    //   168: astore_0
    //   169: aload_0
    //   170: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   173: goto -7 -> 166
    //   176: astore_1
    //   177: goto -19 -> 158
    //   180: astore_2
    //   181: goto -76 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	paramFile	File
    //   23	120	1	localBufferedReader	java.io.BufferedReader
    //   155	12	1	localObject1	Object
    //   176	1	1	localObject2	Object
    //   30	52	2	localObject3	Object
    //   102	27	2	localException1	java.lang.Exception
    //   180	1	2	localException2	java.lang.Exception
    //   7	147	3	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   89	93	95	java/io/IOException
    //   8	24	102	java/lang/Exception
    //   142	146	148	java/io/IOException
    //   8	24	155	finally
    //   162	166	168	java/io/IOException
    //   26	31	176	finally
    //   37	44	176	finally
    //   50	56	176	finally
    //   58	75	176	finally
    //   77	82	176	finally
    //   107	111	176	finally
    //   113	138	176	finally
    //   26	31	180	java/lang/Exception
    //   37	44	180	java/lang/Exception
    //   50	56	180	java/lang/Exception
    //   58	75	180	java/lang/Exception
    //   77	82	180	java/lang/Exception
  }
  
  private void a(Runnable paramRunnable)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramRunnable.run();
      return;
    }
    new Handler(Looper.getMainLooper()).post(paramRunnable);
  }
  
  private void a(Map<String, File> paramMap, File paramFile)
  {
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles();
      if (paramFile != null)
      {
        int j = paramFile.length;
        int i = 0;
        while (i < j)
        {
          a(paramMap, paramFile[i]);
          i += 1;
        }
      }
    }
    else
    {
      paramMap.put(paramFile.getName(), paramFile);
    }
  }
  
  public static boolean a()
  {
    String str = SharedPreUtils.b();
    QLog.d("qq_Identification.Helper", 1, "preResDownload resPath = " + str);
    if ((!TextUtils.isEmpty(str)) && (!a("new_qq_android_native_short_new_other_", SharedPreUtils.b())) && (b())) {
      return false;
    }
    SharedPreUtils.c("");
    SharedPreUtils.b(0);
    SharedPreUtils.c(0);
    QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_res_download", null, null);
    return true;
  }
  
  private static boolean a(String paramString, int paramInt)
  {
    Object localObject1 = AEOldShortVideoResManager.a();
    Object localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = new ArrayList();
      AEOldShortVideoResManager.a((String)localObject1, (List)localObject2);
      if (((List)localObject2).size() > 0)
      {
        localObject1 = ((List)localObject2).iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (AEOldShortVideoResManager.SVConfigItem)((Iterator)localObject1).next();
        } while (!((AEOldShortVideoResManager.SVConfigItem)localObject2).name.startsWith(paramString));
      }
    }
    for (int i = ((AEOldShortVideoResManager.SVConfigItem)localObject2).versionCode;; i = -1)
    {
      QLog.d("qq_Identification.Helper", 1, new Object[] { "newVersion is ", Integer.valueOf(i), " localVersion is ", Integer.valueOf(paramInt), " res is ", paramString });
      return paramInt < i;
    }
  }
  
  public static int b()
  {
    return 32;
  }
  
  private static boolean b()
  {
    int i = a();
    int j = b();
    QLog.d("qq_Identification.Helper", 1, new Object[] { "current download bits is : ", Integer.valueOf(i), " app setting so bits is : ", Integer.valueOf(j) });
    return i == j;
  }
  
  private void d()
  {
    SharedPreUtils.c("");
    SharedPreUtils.b(0);
    SharedPreUtils.c(0);
    a(this);
  }
  
  private void e()
  {
    AEOldShortVideoResManager.a("", 0);
  }
  
  public String a()
  {
    return SharedPreUtils.b();
  }
  
  public void a()
  {
    String str = a();
    Object localObject = str + "identification/so";
    File localFile1 = new File((String)localObject, "libYTPoseDetect.so");
    File localFile2 = new File((String)localObject, "libYTFaceTracker.so");
    File localFile3 = new File((String)localObject, "libYTAGReflectLiveCheck.so");
    localObject = new File((String)localObject, "libopencv_tinyworld.so");
    if ((!localFile1.exists()) || (!localFile2.exists()) || (!localFile3.exists()) || (!((File)localObject).exists()))
    {
      QLog.d("qq_Identification.Helper", 1, "no res,need download");
      a(this);
      return;
    }
    if (!a(str))
    {
      QLog.d("qq_Identification.Helper", 1, new Object[] { "check so files error, path is ", str });
      d();
      return;
    }
    if (a("new_qq_android_native_short_new_other_", SharedPreUtils.b()))
    {
      QLog.d("qq_Identification.Helper", 1, "need update local res");
      d();
      return;
    }
    if (SharedPreUtils.b() < 7)
    {
      QLog.d("qq_Identification.Helper", 1, new Object[] { "local version : ", Integer.valueOf(SharedPreUtils.b()), " min version : ", Integer.valueOf(7) });
      e();
      d();
      return;
    }
    if (!b())
    {
      QLog.d("qq_Identification.Helper", 1, "so bits not match, need update local res");
      d();
      return;
    }
    QLog.d("qq_Identification.Helper", 1, new Object[] { "preCheck is pass, so version is ", Integer.valueOf(SharedPreUtils.b()), " current bits is : ", Integer.valueOf(b()) });
    this.jdField_a_of_type_JavaLangString = str;
    b();
  }
  
  public void a(EIPCResultCallback paramEIPCResultCallback)
  {
    QLog.d("qq_Identification.Helper", 1, "start dowloadRes");
    QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_res_download", null, paramEIPCResultCallback);
  }
  
  public boolean a(String paramString)
  {
    Object localObject1 = new File(paramString + "identification/");
    paramString = new File((File)localObject1, "identification_res_desct.txt");
    if (!paramString.exists())
    {
      QLog.d("qq_Identification.Helper", 1, "checkResValid identification_res_desct.txt not exist");
      return false;
    }
    Object localObject2 = a(paramString);
    if (((HashMap)localObject2).isEmpty())
    {
      QLog.d("qq_Identification.Helper", 1, "checkResValid fileConfigData.isEmpty");
      return false;
    }
    paramString = new HashMap();
    a(paramString, (File)localObject1);
    localObject1 = ((HashMap)localObject2).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (Map.Entry)((Iterator)localObject1).next();
      localObject2 = (String)((Map.Entry)localObject3).getKey();
      int i = ((Integer)((Map.Entry)localObject3).getValue()).intValue();
      localObject3 = (File)paramString.get(localObject2);
      if ((localObject3 == null) || (!((File)localObject3).exists()))
      {
        QLog.d("qq_Identification.Helper", 1, "check file valid failed,file not exist,name = " + (String)localObject2);
        return false;
      }
      if (i != ((File)localObject3).length())
      {
        QLog.d("qq_Identification.Helper", 1, "check file valid failed,file size is wrong,name = " + (String)localObject2);
        return false;
      }
    }
    return true;
  }
  
  public void b()
  {
    QLog.d("qq_Identification.Helper", 1, new Object[] { "start init youtu sdk, mIsLoadSo is ", Boolean.valueOf(jdField_a_of_type_Boolean) });
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationBaseModel.a(IdentificationBaseModel.b);
      jdField_a_of_type_Boolean &= this.jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationBaseModel.a(this.jdField_a_of_type_JavaLangString + "identification/so/", IdentificationBaseModel.a);
    }
    int i;
    if (jdField_a_of_type_Boolean)
    {
      i = YTCommonInterface.initAuthForQQ(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferActivity);
      QLog.d("qq_Identification.Helper", 1, new Object[] { "yt init result is : ", Integer.valueOf(i) });
      if (i == 0) {}
    }
    for (;;)
    {
      QLog.d("qq_Identification.Helper", 1, "initYoutuSdk result: " + i);
      Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(2);
      localMessage.arg1 = i;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      YtLogger.setLoggerListener(new IdentificationActivityHelper.1(this));
      return;
      i = this.jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationBaseModel.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferActivity, this.jdField_a_of_type_JavaLangString);
      QLog.d("qq_Identification.Helper", 1, new Object[] { "initFaceResMode result is ", Integer.valueOf(i) });
      continue;
      i = 2;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationBaseModel.a();
  }
  
  @TargetApi(18)
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2 = true;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      if (QLog.isColorLevel()) {
        QLog.d("qq_Identification.Helper", 2, "dowloadRes result: " + paramMessage.arg1);
      }
      if (paramMessage.arg1 == 0)
      {
        this.jdField_a_of_type_JavaLangString = a();
        bool1 = a(this.jdField_a_of_type_JavaLangString);
        QLog.d("qq_Identification.Helper", 1, new Object[] { "checkResValid : ", Boolean.valueOf(bool1) });
        if (!bool1)
        {
          a(new IdentificationActivityHelper.2(this));
          return false;
        }
        b();
        return false;
      }
      a(new IdentificationActivityHelper.3(this));
      return false;
    }
    if (paramMessage.arg1 == 0)
    {
      bool1 = true;
      QLog.d("qq_Identification.Helper", 1, new Object[] { "initResultNotify : ", Boolean.valueOf(bool1) });
      if (paramMessage.arg1 == 0)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        this.jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationBaseModel.a(true, this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferActivity);
      }
      if (paramMessage.arg1 != 0) {
        break label238;
      }
    }
    label238:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      a(new IdentificationActivityHelper.4(this, bool1));
      return false;
      bool1 = false;
      break;
    }
  }
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1);
    if (paramEIPCResult.isSuccess()) {}
    for (localMessage.arg1 = 0;; localMessage.arg1 = 1)
    {
      localMessage.sendToTarget();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.identification.IdentificationActivityHelper
 * JD-Core Version:    0.7.0.1
 */