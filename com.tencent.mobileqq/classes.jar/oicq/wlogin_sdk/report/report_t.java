package oicq.wlogin_sdk.report;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import oicq.wlogin_sdk.tools.util;

public class report_t
  implements Serializable
{
  public static String FILE_NAME = "report_data";
  private static final long serialVersionUID = 1L;
  
  public static void delete_file(Context paramContext)
  {
    try
    {
      paramContext.deleteFile(FILE_NAME);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static Reporter read_fromfile(Context paramContext)
  {
    BufferedInputStream localBufferedInputStream;
    Reporter localReporter;
    label63:
    try
    {
      paramContext = new File(FILE_NAME);
    }
    finally {}
    try
    {
      paramContext = new FileInputStream(paramContext);
      localBufferedInputStream = new BufferedInputStream(paramContext);
      localReporter = (Reporter)new ObjectInputStream(localBufferedInputStream).readObject();
      localBufferedInputStream.close();
      paramContext.close();
      return localReporter;
    }
    catch (Exception paramContext)
    {
      break label63;
    }
    paramContext = new StringBuilder();
    paramContext.append("read ");
    paramContext.append(FILE_NAME);
    paramContext.append("failed");
    util.LOGI(paramContext.toString());
    return null;
  }
  
  /* Error */
  public static int write_tofile(Reporter paramReporter, Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 86	java/io/ByteArrayOutputStream
    //   6: dup
    //   7: sipush 8192
    //   10: invokespecial 89	java/io/ByteArrayOutputStream:<init>	(I)V
    //   13: astore_2
    //   14: new 91	java/io/ObjectOutputStream
    //   17: dup
    //   18: aload_2
    //   19: invokespecial 94	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore_3
    //   23: aload_3
    //   24: aload_0
    //   25: invokevirtual 98	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   28: aload_3
    //   29: invokevirtual 101	java/io/ObjectOutputStream:flush	()V
    //   32: aload_3
    //   33: invokevirtual 102	java/io/ObjectOutputStream:close	()V
    //   36: aload_1
    //   37: getstatic 24	oicq/wlogin_sdk/report/report_t:FILE_NAME	Ljava/lang/String;
    //   40: iconst_0
    //   41: invokevirtual 106	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   44: astore_0
    //   45: aload_2
    //   46: aload_0
    //   47: invokevirtual 109	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   50: aload_2
    //   51: invokevirtual 110	java/io/ByteArrayOutputStream:flush	()V
    //   54: aload_2
    //   55: invokevirtual 111	java/io/ByteArrayOutputStream:close	()V
    //   58: aload_0
    //   59: invokevirtual 114	java/io/FileOutputStream:close	()V
    //   62: ldc 2
    //   64: monitorexit
    //   65: iconst_0
    //   66: ireturn
    //   67: astore_0
    //   68: goto +19 -> 87
    //   71: astore_0
    //   72: aload_0
    //   73: invokevirtual 118	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   76: invokevirtual 119	java/lang/Object:toString	()Ljava/lang/String;
    //   79: invokestatic 82	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;)V
    //   82: ldc 2
    //   84: monitorexit
    //   85: iconst_m1
    //   86: ireturn
    //   87: ldc 2
    //   89: monitorexit
    //   90: aload_0
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	paramReporter	Reporter
    //   0	92	1	paramContext	Context
    //   13	42	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   22	11	3	localObjectOutputStream	java.io.ObjectOutputStream
    // Exception table:
    //   from	to	target	type
    //   3	62	67	finally
    //   72	82	67	finally
    //   3	62	71	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.report.report_t
 * JD-Core Version:    0.7.0.1
 */