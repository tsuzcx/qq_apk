package fr.arnaudguyon.xmltojsonlib;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;

public class FileReader
{
  public static String readFileFromAsset(@NonNull Context paramContext, @NonNull String paramString)
  {
    try
    {
      paramContext = paramContext.getAssets().open(paramString);
      paramString = readFileFromInputStream(paramContext);
      paramContext.close();
      return paramString;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public static String readFileFromInputStream(@NonNull InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 41	java/io/InputStreamReader
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 44	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   8: astore_0
    //   9: new 46	java/io/BufferedReader
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 49	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   17: astore_1
    //   18: new 51	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   25: astore_2
    //   26: aload_1
    //   27: invokevirtual 56	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   30: astore_3
    //   31: aload_3
    //   32: ifnull +23 -> 55
    //   35: aload_2
    //   36: aload_3
    //   37: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: goto -15 -> 26
    //   44: astore_2
    //   45: aload_1
    //   46: invokevirtual 61	java/io/BufferedReader:close	()V
    //   49: aload_0
    //   50: invokevirtual 62	java/io/InputStreamReader:close	()V
    //   53: aconst_null
    //   54: areturn
    //   55: aload_2
    //   56: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: astore_2
    //   60: aload_1
    //   61: invokevirtual 61	java/io/BufferedReader:close	()V
    //   64: aload_0
    //   65: invokevirtual 62	java/io/InputStreamReader:close	()V
    //   68: aload_2
    //   69: areturn
    //   70: astore_0
    //   71: aload_2
    //   72: areturn
    //   73: astore_2
    //   74: aload_1
    //   75: invokevirtual 61	java/io/BufferedReader:close	()V
    //   78: aload_0
    //   79: invokevirtual 62	java/io/InputStreamReader:close	()V
    //   82: aload_2
    //   83: athrow
    //   84: astore_1
    //   85: goto -21 -> 64
    //   88: astore_1
    //   89: goto -40 -> 49
    //   92: astore_0
    //   93: goto -40 -> 53
    //   96: astore_1
    //   97: goto -19 -> 78
    //   100: astore_0
    //   101: goto -19 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	paramInputStream	InputStream
    //   17	58	1	localBufferedReader	java.io.BufferedReader
    //   84	1	1	localIOException1	IOException
    //   88	1	1	localIOException2	IOException
    //   96	1	1	localIOException3	IOException
    //   25	11	2	localStringBuilder	java.lang.StringBuilder
    //   44	12	2	localIOException4	IOException
    //   59	13	2	str1	String
    //   73	10	2	localObject	Object
    //   30	7	3	str2	String
    // Exception table:
    //   from	to	target	type
    //   26	31	44	java/io/IOException
    //   35	41	44	java/io/IOException
    //   55	60	44	java/io/IOException
    //   64	68	70	java/io/IOException
    //   26	31	73	finally
    //   35	41	73	finally
    //   55	60	73	finally
    //   60	64	84	java/io/IOException
    //   45	49	88	java/io/IOException
    //   49	53	92	java/io/IOException
    //   74	78	96	java/io/IOException
    //   78	82	100	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     fr.arnaudguyon.xmltojsonlib.FileReader
 * JD-Core Version:    0.7.0.1
 */