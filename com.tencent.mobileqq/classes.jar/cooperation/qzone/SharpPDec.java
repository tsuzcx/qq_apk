package cooperation.qzone;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.handler.QavSoDownloadHandler;
import com.tencent.mobileqq.earlydownload.xmldata.QavSoData;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.ProcessUtils;
import java.io.File;

public class SharpPDec
{
  private static int jdField_a_of_type_Int = -1;
  private static long jdField_a_of_type_Long;
  private static String jdField_a_of_type_JavaLangString = "TcHevcDec";
  private static int b = -1;
  
  private native int GetVersion();
  
  public static int a(Context paramContext)
  {
    int j = 0;
    int i = 1;
    do
    {
      try
      {
        String str = ProcessUtils.a(paramContext);
        if (ProcessUtils.f(str)) {
          QLog.i("SharpPDec", 1, "cooperation.SharpPDec:QzoneLive process,return 0.");
        }
        for (i = j;; i = j)
        {
          return i;
          if (((!ProcessUtils.b(str)) && (!ProcessUtils.e(str))) || (QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneSharppGate", 1) != 0)) {
            break;
          }
          QLog.i("SharpPDec", 1, "cooperation.SharpPDec------sharpp gate is closed.");
        }
        j = b(paramContext);
      }
      finally {}
    } while (j >= 12);
    for (;;)
    {
      i = 0;
    }
  }
  
  private static void a()
  {
    Object localObject2 = BaseApplicationImpl.getContext();
    Object localObject1 = new File(UpdateAvSo.a() + "/lib" + jdField_a_of_type_JavaLangString + ".so");
    if (((File)localObject1).exists())
    {
      ((File)localObject1).delete();
      QLog.d("SharpPDec", 4, "sharpP--delete the corrupted so.");
    }
    localObject1 = "";
    try
    {
      localObject2 = ProcessUtils.a((Context)localObject2);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool;
        QLog.w("SharpPDec", 1, "restoreSo --getCurProcessName failed,catch an exception:", localException);
      }
      label191:
      QLog.e("SharpPDec", 4, "sharpP--reDownload so：earlyHandler is null,reDownload failed.");
      label199:
      QLog.e("SharpPDec", 4, "sharpP--reDownload so：maybe earlyMgr is null,reDownload failed.");
    }
    bool = ProcessUtils.g((String)localObject1);
    QLog.d("SharpPDec", 4, "sharpP--" + (String)localObject1 + ",isQQ:" + bool);
    if (bool)
    {
      localObject1 = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface)))
      {
        localObject1 = (EarlyDownloadManager)((QQAppInterface)localObject1).getManager(76);
        if (localObject1 == null) {
          break label199;
        }
        localObject1 = ((EarlyDownloadManager)localObject1).a(QavSoDownloadHandler.e());
        if (localObject1 == null) {
          break label191;
        }
        ((EarlyHandler)localObject1).a(false);
        QLog.d("SharpPDec", 4, "sharpP--reDownload so");
      }
    }
    return;
  }
  
  private static boolean a()
  {
    String str2 = LocalMultiProcConfig.getString("Qz_setting", "sharpPSoMD5AndLength", "");
    String str1 = UpdateAvSo.a() + "/lib" + jdField_a_of_type_JavaLangString + ".so";
    Object localObject = new File(str1);
    if (!((File)localObject).exists())
    {
      QLog.w("SharpPDec", 1, "soFile is not exist.");
      return false;
    }
    QavSoData localQavSoData = (QavSoData)EarlyDataFactory.a(QavSoData.class);
    long l = ((File)localObject).length();
    localObject = "";
    if (localQavSoData != null) {
      localObject = localQavSoData.m_TcHevcDec + "_" + l;
    }
    if (a(str2, (String)localObject, l)) {
      return true;
    }
    QLog.d("SharpPDec", 2, "try previousVerMd5AndLength");
    if (a(LocalMultiProcConfig.getString("Qz_setting", "sharpPSoMD5AndLength_previous", ""), (String)localObject, l)) {
      return true;
    }
    String str3 = MD5Utils.a(str1);
    StringBuilder localStringBuilder = new StringBuilder().append("sharpP so md5Str:").append(str3).append(",m_TcHevcDec:");
    if (localQavSoData != null) {}
    for (str1 = localQavSoData.m_TcHevcDec;; str1 = "null")
    {
      QLog.d("SharpPDec", 2, str1);
      if ((TextUtils.isEmpty(str3)) || (localQavSoData == null) || (!str3.equalsIgnoreCase(localQavSoData.m_TcHevcDec))) {
        break;
      }
      LocalMultiProcConfig.putString("Qz_setting", "sharpPSoMD5AndLength", (String)localObject);
      LocalMultiProcConfig.putString("Qz_setting", "sharpPSoMD5AndLength_previous", str2);
      return true;
    }
    QLog.e("SharpPDec", 4, "sharpP-- so is corrupted.");
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = false;
    String str = jdField_a_of_type_JavaLangString;
    boolean bool1 = bool2;
    try
    {
      if (UpdateAvSo.a(paramContext, str))
      {
        bool1 = bool2;
        if (a()) {}
      }
      else
      {
        bool1 = bool2;
        a();
        return false;
      }
      bool1 = bool2;
      bool2 = UpdateAvSo.a(paramContext, str, true);
      bool1 = bool2;
      QLog.i("SharpPDec", 4, "cooperation.SharpPDec--load from qq original: load success ? " + bool2);
      bool1 = bool2;
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      for (;;)
      {
        QLog.e("SharpPDec", 2, "load library exception:", paramContext);
      }
    }
    if (!bool1) {
      return bool1;
    }
    return bool1;
  }
  
  private static boolean a(String paramString1, String paramString2, long paramLong)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      QLog.d("SharpPDec", 2, "savedMd5AndLength: " + paramString1 + " ,md5AndLength: " + paramString2);
      if (paramString1.equalsIgnoreCase(paramString2)) {
        return true;
      }
      int i = paramString1.lastIndexOf("_");
      if (i >= 0) {
        try
        {
          if (Long.parseLong(paramString1.substring(i + 1)) == paramLong)
          {
            QLog.i("SharpPDec", 1, "md5 check failed,but file length check success. check passed");
            return true;
          }
        }
        catch (Throwable paramString2)
        {
          QLog.w("SharpPDec", 1, "parse file length error: savedMd5AndLength=" + paramString1, paramString2);
        }
      }
    }
    return false;
  }
  
  /* Error */
  public static int b(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 13	cooperation/qzone/SharpPDec:jdField_a_of_type_Int	I
    //   6: bipush 12
    //   8: if_icmpge +18 -> 26
    //   11: invokestatic 282	java/lang/System:currentTimeMillis	()J
    //   14: getstatic 284	cooperation/qzone/SharpPDec:jdField_a_of_type_Long	J
    //   17: lsub
    //   18: getstatic 19	cooperation/qzone/SharpPDec:b	I
    //   21: i2l
    //   22: lcmp
    //   23: ifge +12 -> 35
    //   26: getstatic 13	cooperation/qzone/SharpPDec:jdField_a_of_type_Int	I
    //   29: istore_1
    //   30: ldc 2
    //   32: monitorexit
    //   33: iload_1
    //   34: ireturn
    //   35: iconst_0
    //   36: putstatic 13	cooperation/qzone/SharpPDec:jdField_a_of_type_Int	I
    //   39: aload_0
    //   40: invokestatic 286	cooperation/qzone/SharpPDec:a	(Landroid/content/Context;)Z
    //   43: ifne +68 -> 111
    //   46: invokestatic 282	java/lang/System:currentTimeMillis	()J
    //   49: putstatic 284	cooperation/qzone/SharpPDec:jdField_a_of_type_Long	J
    //   52: getstatic 19	cooperation/qzone/SharpPDec:b	I
    //   55: iconst_m1
    //   56: if_icmpne +48 -> 104
    //   59: invokestatic 56	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   62: ldc 58
    //   64: ldc_w 288
    //   67: sipush 3000
    //   70: invokevirtual 64	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;I)I
    //   73: putstatic 19	cooperation/qzone/SharpPDec:b	I
    //   76: ldc 37
    //   78: iconst_1
    //   79: new 80	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   86: ldc_w 290
    //   89: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: getstatic 19	cooperation/qzone/SharpPDec:b	I
    //   95: invokevirtual 293	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   98: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 45	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: getstatic 13	cooperation/qzone/SharpPDec:jdField_a_of_type_Int	I
    //   107: istore_1
    //   108: goto -78 -> 30
    //   111: new 2	cooperation/qzone/SharpPDec
    //   114: dup
    //   115: invokespecial 294	cooperation/qzone/SharpPDec:<init>	()V
    //   118: invokespecial 296	cooperation/qzone/SharpPDec:GetVersion	()I
    //   121: putstatic 13	cooperation/qzone/SharpPDec:jdField_a_of_type_Int	I
    //   124: ldc 37
    //   126: iconst_1
    //   127: new 80	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   134: ldc_w 298
    //   137: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: getstatic 13	cooperation/qzone/SharpPDec:jdField_a_of_type_Int	I
    //   143: invokevirtual 293	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   146: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 45	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: getstatic 13	cooperation/qzone/SharpPDec:jdField_a_of_type_Int	I
    //   155: istore_1
    //   156: goto -126 -> 30
    //   159: astore_0
    //   160: ldc 37
    //   162: iconst_1
    //   163: aload_0
    //   164: iconst_0
    //   165: anewarray 4	java/lang/Object
    //   168: invokestatic 301	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   171: goto -19 -> 152
    //   174: astore_0
    //   175: ldc 2
    //   177: monitorexit
    //   178: aload_0
    //   179: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	paramContext	Context
    //   29	127	1	i	int
    // Exception table:
    //   from	to	target	type
    //   35	104	159	java/lang/UnsatisfiedLinkError
    //   104	108	159	java/lang/UnsatisfiedLinkError
    //   111	152	159	java/lang/UnsatisfiedLinkError
    //   3	26	174	finally
    //   26	30	174	finally
    //   35	104	174	finally
    //   104	108	174	finally
    //   111	152	174	finally
    //   152	156	174	finally
    //   160	171	174	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.SharpPDec
 * JD-Core Version:    0.7.0.1
 */