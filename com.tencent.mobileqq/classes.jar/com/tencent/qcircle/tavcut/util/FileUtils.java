package com.tencent.qcircle.tavcut.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtils
{
  public static String readFile(InputStream paramInputStream)
  {
    try
    {
      paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
      StringBuilder localStringBuilder = new StringBuilder();
      for (;;)
      {
        String str = paramInputStream.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str);
      }
      paramInputStream = localStringBuilder.toString();
      return paramInputStream;
    }
    catch (Exception paramInputStream)
    {
      paramInputStream.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public static String readStringFromAsset(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 46
    //   2: astore 4
    //   4: aload_0
    //   5: ifnonnull +6 -> 11
    //   8: ldc 46
    //   10: areturn
    //   11: aconst_null
    //   12: astore_3
    //   13: aconst_null
    //   14: astore_2
    //   15: aload_0
    //   16: invokevirtual 52	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   19: aload_1
    //   20: invokevirtual 58	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   23: astore_0
    //   24: aload_0
    //   25: astore_2
    //   26: aload_0
    //   27: astore_3
    //   28: aload_0
    //   29: invokestatic 60	com/tencent/qcircle/tavcut/util/FileUtils:readFile	(Ljava/io/InputStream;)Ljava/lang/String;
    //   32: astore_1
    //   33: aload_1
    //   34: astore_2
    //   35: aload_0
    //   36: ifnull +46 -> 82
    //   39: aload_1
    //   40: astore_2
    //   41: aload_0
    //   42: invokevirtual 65	java/io/InputStream:close	()V
    //   45: aload_1
    //   46: areturn
    //   47: astore_0
    //   48: aload_0
    //   49: invokevirtual 40	java/lang/Exception:printStackTrace	()V
    //   52: aload_2
    //   53: areturn
    //   54: astore_0
    //   55: goto +29 -> 84
    //   58: astore_0
    //   59: aload_3
    //   60: astore_2
    //   61: aload_0
    //   62: invokevirtual 66	java/io/IOException:printStackTrace	()V
    //   65: aload 4
    //   67: astore_2
    //   68: aload_3
    //   69: ifnull +13 -> 82
    //   72: aload 4
    //   74: astore_2
    //   75: aload_3
    //   76: invokevirtual 65	java/io/InputStream:close	()V
    //   79: aload 4
    //   81: astore_2
    //   82: aload_2
    //   83: areturn
    //   84: aload_2
    //   85: ifnull +15 -> 100
    //   88: aload_2
    //   89: invokevirtual 65	java/io/InputStream:close	()V
    //   92: goto +8 -> 100
    //   95: astore_1
    //   96: aload_1
    //   97: invokevirtual 40	java/lang/Exception:printStackTrace	()V
    //   100: aload_0
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramContext	android.content.Context
    //   0	102	1	paramString	String
    //   14	75	2	localObject	Object
    //   12	64	3	localContext	android.content.Context
    //   2	78	4	str	String
    // Exception table:
    //   from	to	target	type
    //   41	45	47	java/lang/Exception
    //   75	79	47	java/lang/Exception
    //   15	24	54	finally
    //   28	33	54	finally
    //   61	65	54	finally
    //   15	24	58	java/io/IOException
    //   28	33	58	java/io/IOException
    //   88	92	95	java/lang/Exception
  }
  
  /* Error */
  public static String readStringFromFile(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_1
    //   4: new 70	java/io/FileInputStream
    //   7: dup
    //   8: new 72	java/io/File
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 75	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: invokespecial 78	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   19: astore_0
    //   20: aload_0
    //   21: invokestatic 60	com/tencent/qcircle/tavcut/util/FileUtils:readFile	(Ljava/io/InputStream;)Ljava/lang/String;
    //   24: astore_1
    //   25: aload_0
    //   26: invokevirtual 65	java/io/InputStream:close	()V
    //   29: aload_1
    //   30: areturn
    //   31: astore_0
    //   32: aload_0
    //   33: invokevirtual 40	java/lang/Exception:printStackTrace	()V
    //   36: aload_1
    //   37: areturn
    //   38: astore_2
    //   39: aload_0
    //   40: astore_1
    //   41: goto +39 -> 80
    //   44: astore_2
    //   45: goto +10 -> 55
    //   48: astore_2
    //   49: goto +31 -> 80
    //   52: astore_2
    //   53: aload_3
    //   54: astore_0
    //   55: aload_0
    //   56: astore_1
    //   57: aload_2
    //   58: invokevirtual 66	java/io/IOException:printStackTrace	()V
    //   61: aload_0
    //   62: ifnull +15 -> 77
    //   65: aload_0
    //   66: invokevirtual 65	java/io/InputStream:close	()V
    //   69: goto +8 -> 77
    //   72: astore_0
    //   73: aload_0
    //   74: invokevirtual 40	java/lang/Exception:printStackTrace	()V
    //   77: ldc 46
    //   79: areturn
    //   80: aload_1
    //   81: ifnull +15 -> 96
    //   84: aload_1
    //   85: invokevirtual 65	java/io/InputStream:close	()V
    //   88: goto +8 -> 96
    //   91: astore_0
    //   92: aload_0
    //   93: invokevirtual 40	java/lang/Exception:printStackTrace	()V
    //   96: aload_2
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	paramString	String
    //   3	82	1	str	String
    //   38	1	2	localObject1	Object
    //   44	1	2	localIOException1	java.io.IOException
    //   48	1	2	localObject2	Object
    //   52	45	2	localIOException2	java.io.IOException
    //   1	53	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   25	29	31	java/lang/Exception
    //   20	25	38	finally
    //   20	25	44	java/io/IOException
    //   4	20	48	finally
    //   57	61	48	finally
    //   4	20	52	java/io/IOException
    //   65	69	72	java/lang/Exception
    //   84	88	91	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.util.FileUtils
 * JD-Core Version:    0.7.0.1
 */