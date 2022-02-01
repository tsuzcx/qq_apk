package com.tencent.mobileqq.vas.util;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class VasSoUtils
{
  /* Error */
  public static int a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 15	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 16	java/lang/StringBuilder:<init>	()V
    //   10: astore_3
    //   11: aload_3
    //   12: aload_0
    //   13: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload_3
    //   18: getstatic 26	java/io/File:separator	Ljava/lang/String;
    //   21: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload_3
    //   26: aload_1
    //   27: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: new 22	java/io/File
    //   34: dup
    //   35: aload_3
    //   36: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokespecial 33	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: astore_3
    //   43: aload_3
    //   44: invokevirtual 37	java/io/File:exists	()Z
    //   47: istore_2
    //   48: iload_2
    //   49: ifne +8 -> 57
    //   52: ldc 2
    //   54: monitorexit
    //   55: iconst_1
    //   56: ireturn
    //   57: new 15	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 16	java/lang/StringBuilder:<init>	()V
    //   64: astore 4
    //   66: aload 4
    //   68: aload_0
    //   69: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload 4
    //   75: getstatic 26	java/io/File:separator	Ljava/lang/String;
    //   78: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 4
    //   84: aload_1
    //   85: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 4
    //   91: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 42	java/lang/System:load	(Ljava/lang/String;)V
    //   97: ldc 2
    //   99: monitorexit
    //   100: iconst_0
    //   101: ireturn
    //   102: astore_0
    //   103: new 15	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 16	java/lang/StringBuilder:<init>	()V
    //   110: astore_1
    //   111: aload_1
    //   112: ldc 44
    //   114: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload_1
    //   119: aload_0
    //   120: invokevirtual 47	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   123: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: ldc 49
    //   129: iconst_1
    //   130: aload_1
    //   131: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 55	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: aload_3
    //   138: invokevirtual 58	java/io/File:delete	()Z
    //   141: pop
    //   142: ldc 2
    //   144: monitorexit
    //   145: iconst_2
    //   146: ireturn
    //   147: astore_0
    //   148: ldc 2
    //   150: monitorexit
    //   151: aload_0
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramString1	String
    //   0	153	1	paramString2	String
    //   47	2	2	bool	boolean
    //   10	128	3	localObject	Object
    //   64	26	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   57	97	102	java/lang/Throwable
    //   3	48	147	finally
    //   57	97	147	finally
    //   103	142	147	finally
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("vas_so");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (!new File(paramString1).exists())
      {
        QLog.e("VasSoUtils", 1, "unCompressSo fail src file not exists");
        return false;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("unzip_temp/");
      localObject = ((StringBuilder)localObject).toString();
      try
      {
        FileUtils.uncompressZip(paramString1, (String)localObject, false);
        paramString1 = new StringBuilder();
        paramString1.append((String)localObject);
        paramString1.append(paramString3);
        paramString1 = new File(paramString1.toString());
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("unCompressSo tempfile = ");
          ((StringBuilder)localObject).append(paramString1.getAbsolutePath());
          QLog.d("VasSoUtils", 2, ((StringBuilder)localObject).toString());
        }
        if (!paramString1.exists())
        {
          QLog.e("VasSoUtils", 1, "unCompressSo fail so file not exists");
          return false;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append(File.separator);
        ((StringBuilder)localObject).append(paramString3);
        paramString2 = ((StringBuilder)localObject).toString();
        paramString3 = new File(paramString2);
        boolean bool;
        if (paramString3.exists())
        {
          bool = paramString3.delete();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("unCompressSo so already exists, delete old so result = ");
          ((StringBuilder)localObject).append(bool);
          QLog.d("VasSoUtils", 1, ((StringBuilder)localObject).toString());
        }
        else
        {
          bool = true;
        }
        if (bool)
        {
          bool = paramString1.renameTo(paramString3);
          paramString1 = new StringBuilder();
          paramString1.append("unCompressSo rename temp so to real path result = ");
          paramString1.append(bool);
          paramString1.append("realpath = ");
          paramString1.append(paramString2);
          QLog.d("VasSoUtils", 1, paramString1.toString());
          return bool;
        }
        return false;
      }
      catch (IOException paramString1)
      {
        QLog.e("VasSoUtils", 1, "unCompressSo IOException: ", paramString1);
        return false;
      }
    }
    paramString3 = new StringBuilder();
    paramString3.append("unCompressSo fail zipPath = ");
    paramString3.append(paramString1);
    paramString3.append(" dstPath = ");
    paramString3.append(paramString2);
    QLog.e("VasSoUtils", 1, paramString3.toString());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.util.VasSoUtils
 * JD-Core Version:    0.7.0.1
 */