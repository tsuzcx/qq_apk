package com.vivo.push.util;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

final class u
  implements d
{
  private static final String a;
  private static final String b;
  private static String c = "SdcardCache";
  private File d;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(".vivo/pushsdk/config");
    a = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("config.txt");
    b = localStringBuilder.toString();
  }
  
  /* Error */
  private static Properties a()
  {
    // Byte code:
    //   0: new 62	java/util/Properties
    //   3: dup
    //   4: invokespecial 63	java/util/Properties:<init>	()V
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_3
    //   11: aconst_null
    //   12: astore_0
    //   13: new 65	java/io/BufferedInputStream
    //   16: dup
    //   17: new 67	java/io/FileInputStream
    //   20: dup
    //   21: getstatic 49	com/vivo/push/util/u:b	Ljava/lang/String;
    //   24: invokespecial 70	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   27: invokespecial 73	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   30: astore_1
    //   31: aload 4
    //   33: aload_1
    //   34: invokevirtual 76	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   37: aload_1
    //   38: invokevirtual 81	java/io/InputStream:close	()V
    //   41: aload 4
    //   43: areturn
    //   44: astore_2
    //   45: aload_1
    //   46: astore_0
    //   47: aload_2
    //   48: astore_1
    //   49: goto +33 -> 82
    //   52: astore_0
    //   53: aload_0
    //   54: astore_2
    //   55: goto +10 -> 65
    //   58: astore_1
    //   59: goto +23 -> 82
    //   62: astore_2
    //   63: aload_3
    //   64: astore_1
    //   65: aload_1
    //   66: astore_0
    //   67: aload_2
    //   68: invokevirtual 84	java/lang/Exception:printStackTrace	()V
    //   71: aload_1
    //   72: ifnull +7 -> 79
    //   75: aload_1
    //   76: invokevirtual 81	java/io/InputStream:close	()V
    //   79: aload 4
    //   81: areturn
    //   82: aload_0
    //   83: ifnull +7 -> 90
    //   86: aload_0
    //   87: invokevirtual 81	java/io/InputStream:close	()V
    //   90: aload_1
    //   91: athrow
    //   92: astore_0
    //   93: aload 4
    //   95: areturn
    //   96: astore_0
    //   97: goto -7 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	35	0	localObject1	Object
    //   52	2	0	localException1	java.lang.Exception
    //   66	21	0	localObject2	Object
    //   92	1	0	localIOException1	IOException
    //   96	1	0	localIOException2	IOException
    //   30	19	1	localObject3	Object
    //   58	1	1	localObject4	Object
    //   64	27	1	localObject5	Object
    //   44	4	2	localObject6	Object
    //   54	1	2	localException2	java.lang.Exception
    //   62	6	2	localException3	java.lang.Exception
    //   10	54	3	localObject7	Object
    //   7	87	4	localProperties	Properties
    // Exception table:
    //   from	to	target	type
    //   31	37	44	finally
    //   31	37	52	java/lang/Exception
    //   13	31	58	finally
    //   67	71	58	finally
    //   13	31	62	java/lang/Exception
    //   37	41	92	java/io/IOException
    //   75	79	92	java/io/IOException
    //   86	90	96	java/io/IOException
  }
  
  public final String a(String paramString1, String paramString2)
  {
    return a().getProperty(paramString1, paramString2);
  }
  
  public final boolean a(Context paramContext)
  {
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      paramContext = new File(a);
      boolean bool1;
      if (!paramContext.exists()) {
        bool1 = paramContext.mkdirs();
      } else {
        bool1 = true;
      }
      boolean bool2 = bool1;
      if (bool1)
      {
        this.d = new File(b);
        bool2 = bool1;
        if (!this.d.exists()) {
          try
          {
            this.d.createNewFile();
            return true;
          }
          catch (IOException paramContext)
          {
            paramContext.printStackTrace();
            bool2 = false;
          }
        }
      }
      return bool2;
    }
    return false;
  }
  
  /* Error */
  public final void b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 87	com/vivo/push/util/u:a	()Ljava/util/Properties;
    //   3: astore 6
    //   5: getstatic 49	com/vivo/push/util/u:b	Ljava/lang/String;
    //   8: astore 7
    //   10: aconst_null
    //   11: astore 4
    //   13: aconst_null
    //   14: astore 5
    //   16: aload 5
    //   18: astore_3
    //   19: aload 6
    //   21: aload_1
    //   22: aload_2
    //   23: invokevirtual 121	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   26: pop
    //   27: aload 5
    //   29: astore_3
    //   30: new 123	java/io/FileOutputStream
    //   33: dup
    //   34: aload 7
    //   36: invokespecial 124	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   39: astore_1
    //   40: aload 6
    //   42: aload_1
    //   43: aconst_null
    //   44: invokevirtual 128	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   47: aload_1
    //   48: invokevirtual 131	java/io/FileOutputStream:flush	()V
    //   51: aload_1
    //   52: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   55: return
    //   56: astore_2
    //   57: aload_1
    //   58: astore_3
    //   59: aload_2
    //   60: astore_1
    //   61: goto +30 -> 91
    //   64: astore_2
    //   65: goto +11 -> 76
    //   68: astore_1
    //   69: goto +22 -> 91
    //   72: astore_2
    //   73: aload 4
    //   75: astore_1
    //   76: aload_1
    //   77: astore_3
    //   78: aload_2
    //   79: invokevirtual 84	java/lang/Exception:printStackTrace	()V
    //   82: aload_1
    //   83: ifnull +7 -> 90
    //   86: aload_1
    //   87: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   90: return
    //   91: aload_3
    //   92: ifnull +7 -> 99
    //   95: aload_3
    //   96: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   99: aload_1
    //   100: athrow
    //   101: astore_1
    //   102: return
    //   103: astore_1
    //   104: return
    //   105: astore_2
    //   106: goto -7 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	u
    //   0	109	1	paramString1	String
    //   0	109	2	paramString2	String
    //   18	78	3	localObject1	Object
    //   11	63	4	localObject2	Object
    //   14	14	5	localObject3	Object
    //   3	38	6	localProperties	Properties
    //   8	27	7	str	String
    // Exception table:
    //   from	to	target	type
    //   40	51	56	finally
    //   40	51	64	java/lang/Exception
    //   19	27	68	finally
    //   30	40	68	finally
    //   78	82	68	finally
    //   19	27	72	java/lang/Exception
    //   30	40	72	java/lang/Exception
    //   51	55	101	java/lang/Exception
    //   86	90	103	java/lang/Exception
    //   95	99	105	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.util.u
 * JD-Core Version:    0.7.0.1
 */