package cooperation.qzone;

import com.tencent.av.utils.AVSoUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

public class SharpPDec
{
  private static String LIB_NAME = "TcHevcDec";
  private static final int NOT_INIT = -1;
  private static final int REQUIRED_VERSION = 12;
  private static final String TAG = "SharpPDec";
  private static long sLastLoadTime = 0L;
  private static int sRetryWaitTime = -1;
  private static int sVersion = -1;
  
  static
  {
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
  
  public static int getVersion()
  {
    try
    {
      if (sVersion < 12)
      {
        long l1 = System.currentTimeMillis();
        long l2 = sLastLoadTime;
        i = sRetryWaitTime;
        if (l1 - l2 >= i)
        {
          try
          {
            sVersion = 0;
            if (!loadLibrary())
            {
              sLastLoadTime = System.currentTimeMillis();
              if (sRetryWaitTime == -1)
              {
                sRetryWaitTime = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneSharppLoadSoRetryWaitTime", 3000);
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("sRetryWaitTime(ms):");
                localStringBuilder.append(sRetryWaitTime);
                QLog.i("SharpPDec", 1, localStringBuilder.toString());
              }
              i = sVersion;
              return i;
            }
            sVersion = new SharpPDec().GetVersion();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("cooperation.SharpPDec------version:");
            localStringBuilder.append(sVersion);
            QLog.i("SharpPDec", 1, localStringBuilder.toString());
          }
          catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
          {
            QLog.e("SharpPDec", 1, localUnsatisfiedLinkError, new Object[0]);
          }
          i = sVersion;
          return i;
        }
      }
      int i = sVersion;
      return i;
    }
    finally {}
  }
  
  /* Error */
  public static int isSupportSharpP(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 122
    //   5: astore 4
    //   7: aload_0
    //   8: invokestatic 128	cooperation/qzone/util/ProcessUtils:getCurProcessName	(Landroid/content/Context;)Ljava/lang/String;
    //   11: astore_0
    //   12: goto +14 -> 26
    //   15: ldc 16
    //   17: iconst_1
    //   18: ldc 130
    //   20: invokestatic 132	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: aload 4
    //   25: astore_0
    //   26: aload_0
    //   27: invokestatic 136	cooperation/qzone/util/ProcessUtils:isQzoneLive	(Ljava/lang/String;)Z
    //   30: istore_3
    //   31: iconst_0
    //   32: istore_1
    //   33: iload_3
    //   34: ifeq +16 -> 50
    //   37: ldc 16
    //   39: iconst_1
    //   40: ldc 138
    //   42: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: ldc 2
    //   47: monitorexit
    //   48: iconst_0
    //   49: ireturn
    //   50: invokestatic 140	cooperation/qzone/SharpPDec:getVersion	()I
    //   53: istore_2
    //   54: iload_2
    //   55: bipush 12
    //   57: if_icmplt +5 -> 62
    //   60: iconst_1
    //   61: istore_1
    //   62: ldc 2
    //   64: monitorexit
    //   65: iload_1
    //   66: ireturn
    //   67: astore_0
    //   68: ldc 2
    //   70: monitorexit
    //   71: aload_0
    //   72: athrow
    //   73: astore_0
    //   74: goto -59 -> 15
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	paramContext	android.content.Context
    //   32	34	1	i	int
    //   53	5	2	j	int
    //   30	4	3	bool	boolean
    //   5	19	4	str	String
    // Exception table:
    //   from	to	target	type
    //   7	12	67	finally
    //   15	23	67	finally
    //   26	31	67	finally
    //   37	45	67	finally
    //   50	54	67	finally
    //   7	12	73	java/lang/Exception
  }
  
  public static boolean loadLibrary()
  {
    boolean bool;
    try
    {
      bool = AVSoUtils.a();
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cooperation.SharpPDec--load from qq original: load success ? ");
        localStringBuilder.append(bool);
        QLog.i("SharpPDec", 4, localStringBuilder.toString());
        return bool;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError1) {}
      QLog.e("SharpPDec", 2, "load library exception:", localUnsatisfiedLinkError2);
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
    {
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.SharpPDec
 * JD-Core Version:    0.7.0.1
 */