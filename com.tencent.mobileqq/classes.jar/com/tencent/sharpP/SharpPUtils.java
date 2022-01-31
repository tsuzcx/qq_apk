package com.tencent.sharpP;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.ImageKey;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.utils.ImageManagerLog;
import java.io.File;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class SharpPUtils
{
  public static final byte[] a = { 83, 72, 65, 82, 80, 80 };
  
  public static Bitmap a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      ImageManagerEnv.getLogger().e("SharpPUtils", new Object[] { "------decodeSharpP:path is null" });
    }
    do
    {
      return null;
      paramString = new SharpPDecoderHelper(paramString);
    } while (paramString.a() != 0);
    SharpPDecoderWrapper.SharpPFeatureWrapper localSharpPFeatureWrapper = paramString.a();
    return paramString.a(localSharpPFeatureWrapper.a(), localSharpPFeatureWrapper.b(), Bitmap.Config.ARGB_8888);
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (a(paramString))
    {
      if (Build.VERSION.SDK_INT >= 14) {
        str = paramString.replace("t=6", "t=5");
      }
    }
    else {
      return str;
    }
    return paramString.replace("t=6", "");
  }
  
  public static Map a(String paramString)
  {
    int i = 0;
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        paramString = paramString.split("&");
        int j = paramString.length;
        if (i < j)
        {
          String[] arrayOfString = paramString[i].split("=");
          if ((arrayOfString == null) || (arrayOfString.length != 2)) {
            break label76;
          }
          localHashMap.put(arrayOfString[0], URLDecoder.decode(arrayOfString[1]));
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      return localHashMap;
      label76:
      i += 1;
    }
  }
  
  public static void a(File paramFile, String paramString)
  {
    if ((paramFile == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    ImageKey localImageKey = ImageKey.obtain();
    try
    {
      localImageKey.filePath = paramFile.getAbsolutePath();
      localImageKey.url = paramString;
      if ((paramFile.exists()) && (!ImageManagerEnv.g().isSupportSharpp()) && (a(paramFile)))
      {
        ImageManagerEnv.g().reportImageDecodingRes("image/sharpp", paramString, paramFile.length(), false, 0L, 5);
        ImageLoader.getInstance().removeImageFile(localImageKey.url);
        ImageManagerEnv.getLogger().e("SharpPUtils", new Object[] { "sharpp is not supported,delete sharpp file cache. filename:" + paramFile.getName() });
        if (paramFile.exists()) {
          ImageManagerLog.w("SharpPUtils", "delete sharpp file cache failed. filename:" + paramFile.getName());
        }
      }
      return;
    }
    catch (Throwable paramFile)
    {
      ImageManagerEnv.getLogger().e("SharpPUtils", new Object[] { "catch an exception:" + Log.getStackTraceString(paramFile) });
      return;
    }
    finally
    {
      localImageKey.recycle();
    }
  }
  
  /* Error */
  public static boolean a(File paramFile)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore_1
    //   4: iload_3
    //   5: istore_2
    //   6: aload_0
    //   7: ifnull +75 -> 82
    //   10: new 213	java/io/BufferedInputStream
    //   13: dup
    //   14: new 215	java/io/FileInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 218	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   22: bipush 10
    //   24: invokespecial 221	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   27: astore 4
    //   29: aload 4
    //   31: astore_0
    //   32: bipush 6
    //   34: newarray byte
    //   36: astore 5
    //   38: aload 4
    //   40: astore_0
    //   41: aload 4
    //   43: aload 5
    //   45: iconst_0
    //   46: aload 5
    //   48: arraylength
    //   49: invokevirtual 225	java/io/BufferedInputStream:read	([BII)I
    //   52: iconst_m1
    //   53: if_icmpeq +15 -> 68
    //   56: aload 4
    //   58: astore_0
    //   59: aload 5
    //   61: getstatic 15	com/tencent/sharpP/SharpPUtils:a	[B
    //   64: invokestatic 231	java/util/Arrays:equals	([B[B)Z
    //   67: istore_1
    //   68: iload_1
    //   69: istore_2
    //   70: aload 4
    //   72: ifnull +10 -> 82
    //   75: aload 4
    //   77: invokevirtual 234	java/io/BufferedInputStream:close	()V
    //   80: iload_1
    //   81: istore_2
    //   82: iload_2
    //   83: ireturn
    //   84: astore_0
    //   85: aload_0
    //   86: invokevirtual 235	java/io/IOException:printStackTrace	()V
    //   89: iload_1
    //   90: ireturn
    //   91: astore 5
    //   93: aconst_null
    //   94: astore 4
    //   96: aload 4
    //   98: astore_0
    //   99: aload 5
    //   101: invokevirtual 236	java/io/FileNotFoundException:printStackTrace	()V
    //   104: iload_3
    //   105: istore_2
    //   106: aload 4
    //   108: ifnull -26 -> 82
    //   111: aload 4
    //   113: invokevirtual 234	java/io/BufferedInputStream:close	()V
    //   116: iconst_0
    //   117: ireturn
    //   118: astore_0
    //   119: aload_0
    //   120: invokevirtual 235	java/io/IOException:printStackTrace	()V
    //   123: iconst_0
    //   124: ireturn
    //   125: astore 5
    //   127: aconst_null
    //   128: astore 4
    //   130: aload 4
    //   132: astore_0
    //   133: aload 5
    //   135: invokevirtual 235	java/io/IOException:printStackTrace	()V
    //   138: iload_3
    //   139: istore_2
    //   140: aload 4
    //   142: ifnull -60 -> 82
    //   145: aload 4
    //   147: invokevirtual 234	java/io/BufferedInputStream:close	()V
    //   150: iconst_0
    //   151: ireturn
    //   152: astore_0
    //   153: aload_0
    //   154: invokevirtual 235	java/io/IOException:printStackTrace	()V
    //   157: iconst_0
    //   158: ireturn
    //   159: astore 4
    //   161: aconst_null
    //   162: astore_0
    //   163: aload_0
    //   164: ifnull +7 -> 171
    //   167: aload_0
    //   168: invokevirtual 234	java/io/BufferedInputStream:close	()V
    //   171: aload 4
    //   173: athrow
    //   174: astore_0
    //   175: aload_0
    //   176: invokevirtual 235	java/io/IOException:printStackTrace	()V
    //   179: goto -8 -> 171
    //   182: astore 4
    //   184: goto -21 -> 163
    //   187: astore 5
    //   189: goto -59 -> 130
    //   192: astore 5
    //   194: goto -98 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	paramFile	File
    //   3	87	1	bool1	boolean
    //   5	135	2	bool2	boolean
    //   1	138	3	bool3	boolean
    //   27	119	4	localBufferedInputStream	java.io.BufferedInputStream
    //   159	13	4	localObject1	Object
    //   182	1	4	localObject2	Object
    //   36	24	5	arrayOfByte	byte[]
    //   91	9	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   125	9	5	localIOException1	java.io.IOException
    //   187	1	5	localIOException2	java.io.IOException
    //   192	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   75	80	84	java/io/IOException
    //   10	29	91	java/io/FileNotFoundException
    //   111	116	118	java/io/IOException
    //   10	29	125	java/io/IOException
    //   145	150	152	java/io/IOException
    //   10	29	159	finally
    //   167	171	174	java/io/IOException
    //   32	38	182	finally
    //   41	56	182	finally
    //   59	68	182	finally
    //   99	104	182	finally
    //   133	138	182	finally
    //   32	38	187	java/io/IOException
    //   41	56	187	java/io/IOException
    //   59	68	187	java/io/IOException
    //   32	38	192	java/io/FileNotFoundException
    //   41	56	192	java/io/FileNotFoundException
    //   59	68	192	java/io/FileNotFoundException
  }
  
  public static boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      ImageManagerEnv.getLogger().e("SharpPUtils", new Object[] { "------isSharpP:url is null" });
      return false;
    }
    String str = (String)b(paramString).get("t");
    if ((str != null) && (str.equals("6"))) {
      return true;
    }
    return (str == null) && (paramString.lastIndexOf("&t=6#sce") > 0);
  }
  
  public static Map b(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      int i = paramString.indexOf("?");
      localObject1 = localObject2;
      if (-1 != i) {
        localObject1 = a(paramString.substring(i + 1));
      }
    }
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = new HashMap();
    }
    return paramString;
  }
  
  public static boolean b(String paramString)
  {
    boolean bool = false;
    if (!TextUtils.isEmpty(paramString)) {
      bool = "image/jpg".equals(paramString);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.sharpP.SharpPUtils
 * JD-Core Version:    0.7.0.1
 */