package cooperation.qzone;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.ProcessUtils;

public class SharpPDec
{
  public static final int CLOSE_SHARPP = 0;
  private static String LIB_NAME;
  private static final int NOT_INIT = -1;
  public static final int NOT_SUPPORT_SHARPP = 0;
  public static final int OPEN_SHARPP = 1;
  private static final int REQUIRED_VERSION = 12;
  public static final int SUPPORT_SHARPP = 1;
  private static final String TAG = "SharpPDec";
  private static long sLastLoadTime;
  private static int sRetryWaitTime;
  private static int sVersion = -1;
  
  static
  {
    LIB_NAME = "TcHevcDec";
    sRetryWaitTime = -1;
    try
    {
      SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getApplication(), "c++_shared");
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.w("SharpPDec", 1, "loadSoByName, load libc++_shared.so failed:", localThrowable);
    }
  }
  
  private native int GetVersion();
  
  /* Error */
  public static int getVersion()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 30	cooperation/qzone/SharpPDec:sVersion	I
    //   6: bipush 12
    //   8: if_icmpge +18 -> 26
    //   11: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   14: getstatic 75	cooperation/qzone/SharpPDec:sLastLoadTime	J
    //   17: lsub
    //   18: getstatic 36	cooperation/qzone/SharpPDec:sRetryWaitTime	I
    //   21: i2l
    //   22: lcmp
    //   23: ifge +12 -> 35
    //   26: getstatic 30	cooperation/qzone/SharpPDec:sVersion	I
    //   29: istore_0
    //   30: ldc 2
    //   32: monitorexit
    //   33: iload_0
    //   34: ireturn
    //   35: iconst_0
    //   36: putstatic 30	cooperation/qzone/SharpPDec:sVersion	I
    //   39: invokestatic 79	cooperation/qzone/SharpPDec:loadLibrary	()Z
    //   42: ifne +66 -> 108
    //   45: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   48: putstatic 75	cooperation/qzone/SharpPDec:sLastLoadTime	J
    //   51: getstatic 36	cooperation/qzone/SharpPDec:sRetryWaitTime	I
    //   54: iconst_m1
    //   55: if_icmpne +46 -> 101
    //   58: invokestatic 85	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   61: ldc 87
    //   63: ldc 89
    //   65: sipush 3000
    //   68: invokevirtual 93	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;I)I
    //   71: putstatic 36	cooperation/qzone/SharpPDec:sRetryWaitTime	I
    //   74: ldc 20
    //   76: iconst_1
    //   77: new 95	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   84: ldc 98
    //   86: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: getstatic 36	cooperation/qzone/SharpPDec:sRetryWaitTime	I
    //   92: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   95: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 113	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: getstatic 30	cooperation/qzone/SharpPDec:sVersion	I
    //   104: istore_0
    //   105: goto -75 -> 30
    //   108: new 2	cooperation/qzone/SharpPDec
    //   111: dup
    //   112: invokespecial 114	cooperation/qzone/SharpPDec:<init>	()V
    //   115: invokespecial 116	cooperation/qzone/SharpPDec:GetVersion	()I
    //   118: putstatic 30	cooperation/qzone/SharpPDec:sVersion	I
    //   121: ldc 20
    //   123: iconst_1
    //   124: new 95	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   131: ldc 118
    //   133: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: getstatic 30	cooperation/qzone/SharpPDec:sVersion	I
    //   139: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   142: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 113	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   148: getstatic 30	cooperation/qzone/SharpPDec:sVersion	I
    //   151: istore_0
    //   152: goto -122 -> 30
    //   155: astore_1
    //   156: ldc 20
    //   158: iconst_1
    //   159: aload_1
    //   160: iconst_0
    //   161: anewarray 4	java/lang/Object
    //   164: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   167: goto -19 -> 148
    //   170: astore_1
    //   171: ldc 2
    //   173: monitorexit
    //   174: aload_1
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   29	123	0	i	int
    //   155	5	1	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   170	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   35	101	155	java/lang/UnsatisfiedLinkError
    //   101	105	155	java/lang/UnsatisfiedLinkError
    //   108	148	155	java/lang/UnsatisfiedLinkError
    //   3	26	170	finally
    //   26	30	170	finally
    //   35	101	170	finally
    //   101	105	170	finally
    //   108	148	170	finally
    //   148	152	170	finally
    //   156	167	170	finally
  }
  
  public static int isSupportSharpP(Context paramContext)
  {
    int j = 0;
    int i = 1;
    String str = "";
    do
    {
      try
      {
        paramContext = ProcessUtils.getCurProcessName(paramContext);
        if (ProcessUtils.isQzoneLive(paramContext))
        {
          QLog.i("SharpPDec", 1, "cooperation.SharpPDec:QzoneLive process,return 0.");
          i = j;
          return i;
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          QLog.w("SharpPDec", 1, "isSupportSharpP: getCurProcessName failed");
          paramContext = str;
        }
      }
      finally {}
      j = getVersion();
    } while (j >= 12);
    for (;;)
    {
      i = 0;
    }
  }
  
  public static boolean loadLibrary()
  {
    label38:
    for (;;)
    {
      try
      {
        boolean bool = AVSoUtils.a();
        QLog.e("SharpPDec", 2, "load library exception:", localUnsatisfiedLinkError1);
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
      {
        try
        {
          QLog.i("SharpPDec", 4, "cooperation.SharpPDec--load from qq original: load success ? " + bool);
          if (!bool) {}
          return bool;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
        {
          break label38;
        }
        localUnsatisfiedLinkError1 = localUnsatisfiedLinkError1;
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.SharpPDec
 * JD-Core Version:    0.7.0.1
 */