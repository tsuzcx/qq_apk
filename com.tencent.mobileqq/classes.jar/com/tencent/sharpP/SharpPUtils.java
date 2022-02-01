package com.tencent.sharpP;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class SharpPUtils
{
  public static final String SHARPP_POSTFIX = "sharpp";
  public static final byte[] SHARPP_PRECODE = { 83, 72, 65, 82, 80, 80 };
  public static final String TAG = "SharpPUtils";
  
  /* Error */
  public static void checkNotSharppCacheFileIfNessary(java.io.File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +220 -> 221
    //   4: aload_1
    //   5: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +4 -> 12
    //   11: return
    //   12: aload_0
    //   13: invokestatic 40	com/tencent/sharpP/SharpPUtils:isSharpP	(Ljava/io/File;)Z
    //   16: ifeq +205 -> 221
    //   19: aload_1
    //   20: invokestatic 43	com/tencent/sharpP/SharpPUtils:isSharpP	(Ljava/lang/String;)Z
    //   23: ifeq +4 -> 27
    //   26: return
    //   27: invokestatic 49	com/tencent/component/media/image/ImageKey:obtain	()Lcom/tencent/component/media/image/ImageKey;
    //   30: astore_2
    //   31: aload_2
    //   32: aload_0
    //   33: invokevirtual 55	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   36: putfield 58	com/tencent/component/media/image/ImageKey:filePath	Ljava/lang/String;
    //   39: aload_2
    //   40: aload_1
    //   41: putfield 61	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   44: aload_0
    //   45: invokevirtual 65	java/io/File:exists	()Z
    //   48: ifeq +107 -> 155
    //   51: aload_0
    //   52: invokestatic 40	com/tencent/sharpP/SharpPUtils:isSharpP	(Ljava/io/File;)Z
    //   55: ifeq +100 -> 155
    //   58: invokestatic 71	com/tencent/component/media/image/ImageLoader:getInstance	()Lcom/tencent/component/media/image/ImageLoader;
    //   61: aload_2
    //   62: getfield 61	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   65: invokevirtual 75	com/tencent/component/media/image/ImageLoader:removeImageFile	(Ljava/lang/String;)V
    //   68: invokestatic 81	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   71: astore_1
    //   72: new 83	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   79: astore_3
    //   80: aload_3
    //   81: ldc 86
    //   83: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload_3
    //   88: aload_0
    //   89: invokevirtual 93	java/io/File:getName	()Ljava/lang/String;
    //   92: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload_1
    //   97: ldc 13
    //   99: iconst_1
    //   100: anewarray 4	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: aload_3
    //   106: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: aastore
    //   110: invokeinterface 102 3 0
    //   115: aload_0
    //   116: invokevirtual 65	java/io/File:exists	()Z
    //   119: ifeq +36 -> 155
    //   122: new 83	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   129: astore_1
    //   130: aload_1
    //   131: ldc 104
    //   133: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload_1
    //   138: aload_0
    //   139: invokevirtual 93	java/io/File:getName	()Ljava/lang/String;
    //   142: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: ldc 13
    //   148: aload_1
    //   149: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 110	com/tencent/component/media/utils/ImageManagerLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: aload_2
    //   156: invokevirtual 113	com/tencent/component/media/image/ImageKey:recycle	()V
    //   159: return
    //   160: astore_0
    //   161: goto +54 -> 215
    //   164: astore_0
    //   165: invokestatic 81	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   168: astore_1
    //   169: new 83	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   176: astore_3
    //   177: aload_3
    //   178: ldc 115
    //   180: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_3
    //   185: aload_0
    //   186: invokestatic 121	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   189: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload_1
    //   194: ldc 13
    //   196: iconst_1
    //   197: anewarray 4	java/lang/Object
    //   200: dup
    //   201: iconst_0
    //   202: aload_3
    //   203: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: aastore
    //   207: invokeinterface 102 3 0
    //   212: goto -57 -> 155
    //   215: aload_2
    //   216: invokevirtual 113	com/tencent/component/media/image/ImageKey:recycle	()V
    //   219: aload_0
    //   220: athrow
    //   221: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	paramFile	java.io.File
    //   0	222	1	paramString	String
    //   30	186	2	localImageKey	com.tencent.component.media.image.ImageKey
    //   79	124	3	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   31	155	160	finally
    //   165	212	160	finally
    //   31	155	164	java/lang/Throwable
  }
  
  public static Bitmap decodeSharpP(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      paramString = new SharpPDecoderHelper(paramString);
      if (paramString.parseHeader() == 0)
      {
        SharpPDecoderWrapper.SharpPFeatureWrapper localSharpPFeatureWrapper = paramString.getFeatureInfo();
        return paramString.decodeSharpP(localSharpPFeatureWrapper.getWidth(), localSharpPFeatureWrapper.getHeight(), Bitmap.Config.ARGB_8888);
      }
      return null;
    }
    ImageManagerEnv.getLogger().e("SharpPUtils", new Object[] { "------decodeSharpP:path is null" });
    return null;
  }
  
  public static Bitmap decodeSharppPro(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      paramString = new SharpPDecoderHelper(paramString);
      if (paramString.parseHeader() == 0)
      {
        SharpPDecoderWrapper.SharpPFeatureWrapper localSharpPFeatureWrapper = paramString.getFeatureInfo();
        if (isJpg(paramString.getMimeType())) {
          return paramString.decodeSharpP2JPG(localSharpPFeatureWrapper.getWidth(), localSharpPFeatureWrapper.getHeight(), Bitmap.Config.RGB_565);
        }
        return paramString.decodeSharpP2PNG(localSharpPFeatureWrapper.getWidth(), localSharpPFeatureWrapper.getHeight(), Bitmap.Config.ARGB_8888);
      }
      return null;
    }
    ImageManagerEnv.getLogger().e("SharpPUtils", new Object[] { "------decodeSharppPro:path is null" });
    return null;
  }
  
  /* Error */
  public static void deleteSharppCacheFileIfNessary(java.io.File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +230 -> 231
    //   4: aload_1
    //   5: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +4 -> 12
    //   11: return
    //   12: invokestatic 49	com/tencent/component/media/image/ImageKey:obtain	()Lcom/tencent/component/media/image/ImageKey;
    //   15: astore_2
    //   16: aload_2
    //   17: aload_0
    //   18: invokevirtual 55	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   21: putfield 58	com/tencent/component/media/image/ImageKey:filePath	Ljava/lang/String;
    //   24: aload_2
    //   25: aload_1
    //   26: putfield 61	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   29: aload_0
    //   30: invokevirtual 65	java/io/File:exists	()Z
    //   33: ifeq +132 -> 165
    //   36: invokestatic 182	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   39: invokevirtual 185	com/tencent/component/media/ImageManagerEnv:isSupportSharpp	()Z
    //   42: ifne +123 -> 165
    //   45: aload_0
    //   46: invokestatic 40	com/tencent/sharpP/SharpPUtils:isSharpP	(Ljava/io/File;)Z
    //   49: ifeq +116 -> 165
    //   52: invokestatic 182	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   55: ldc 187
    //   57: aload_1
    //   58: aload_0
    //   59: invokevirtual 190	java/io/File:length	()J
    //   62: iconst_0
    //   63: lconst_0
    //   64: iconst_5
    //   65: invokevirtual 194	com/tencent/component/media/ImageManagerEnv:reportImageDecodingRes	(Ljava/lang/String;Ljava/lang/String;JZJI)V
    //   68: invokestatic 71	com/tencent/component/media/image/ImageLoader:getInstance	()Lcom/tencent/component/media/image/ImageLoader;
    //   71: aload_2
    //   72: getfield 61	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   75: invokevirtual 75	com/tencent/component/media/image/ImageLoader:removeImageFile	(Ljava/lang/String;)V
    //   78: invokestatic 81	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   81: astore_1
    //   82: new 83	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   89: astore_3
    //   90: aload_3
    //   91: ldc 196
    //   93: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload_3
    //   98: aload_0
    //   99: invokevirtual 93	java/io/File:getName	()Ljava/lang/String;
    //   102: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload_1
    //   107: ldc 13
    //   109: iconst_1
    //   110: anewarray 4	java/lang/Object
    //   113: dup
    //   114: iconst_0
    //   115: aload_3
    //   116: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: aastore
    //   120: invokeinterface 102 3 0
    //   125: aload_0
    //   126: invokevirtual 65	java/io/File:exists	()Z
    //   129: ifeq +36 -> 165
    //   132: new 83	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   139: astore_1
    //   140: aload_1
    //   141: ldc 104
    //   143: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload_1
    //   148: aload_0
    //   149: invokevirtual 93	java/io/File:getName	()Ljava/lang/String;
    //   152: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: ldc 13
    //   158: aload_1
    //   159: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 110	com/tencent/component/media/utils/ImageManagerLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: aload_2
    //   166: invokevirtual 113	com/tencent/component/media/image/ImageKey:recycle	()V
    //   169: return
    //   170: astore_0
    //   171: goto +54 -> 225
    //   174: astore_0
    //   175: invokestatic 81	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   178: astore_1
    //   179: new 83	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   186: astore_3
    //   187: aload_3
    //   188: ldc 115
    //   190: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload_3
    //   195: aload_0
    //   196: invokestatic 121	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   199: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload_1
    //   204: ldc 13
    //   206: iconst_1
    //   207: anewarray 4	java/lang/Object
    //   210: dup
    //   211: iconst_0
    //   212: aload_3
    //   213: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: aastore
    //   217: invokeinterface 102 3 0
    //   222: goto -57 -> 165
    //   225: aload_2
    //   226: invokevirtual 113	com/tencent/component/media/image/ImageKey:recycle	()V
    //   229: aload_0
    //   230: athrow
    //   231: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	paramFile	java.io.File
    //   0	232	1	paramString	String
    //   15	211	2	localImageKey	com.tencent.component.media.image.ImageKey
    //   89	124	3	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   16	165	170	finally
    //   175	222	170	finally
    //   16	165	174	java/lang/Throwable
  }
  
  public static Map<String, String> getArguments(String paramString)
  {
    localHashMap = new HashMap();
    try
    {
      paramString = paramString.split("&");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramString[i].split("=");
        if ((arrayOfString != null) && (arrayOfString.length == 2)) {
          localHashMap.put(arrayOfString[0], URLDecoder.decode(arrayOfString[1]));
        }
        i += 1;
      }
      return localHashMap;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static Map<String, String> getArgumentsFromURL(String paramString)
  {
    if (paramString != null)
    {
      int i = paramString.indexOf("?");
      if (-1 != i)
      {
        paramString = getArguments(paramString.substring(i + 1));
        break label32;
      }
    }
    paramString = null;
    label32:
    Object localObject = paramString;
    if (paramString == null) {
      localObject = new HashMap();
    }
    return localObject;
  }
  
  public static String getWebpUrl(String paramString)
  {
    String str = paramString;
    if (isSharpP(paramString))
    {
      if (Build.VERSION.SDK_INT >= 14) {
        return paramString.replace("t=6", "t=5");
      }
      str = paramString.replace("t=6", "");
    }
    return str;
  }
  
  public static boolean isJpg(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return "image/jpg".equals(paramString);
    }
    return false;
  }
  
  /* Error */
  public static boolean isSharpP(java.io.File paramFile)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_1
    //   4: aload_0
    //   5: ifnull +155 -> 160
    //   8: aconst_null
    //   9: astore 5
    //   11: aconst_null
    //   12: astore 6
    //   14: aconst_null
    //   15: astore_3
    //   16: new 268	java/io/BufferedInputStream
    //   19: dup
    //   20: new 270	java/io/FileInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 273	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   28: bipush 10
    //   30: invokespecial 276	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   33: astore_0
    //   34: bipush 6
    //   36: newarray byte
    //   38: astore_3
    //   39: aload_0
    //   40: aload_3
    //   41: iconst_0
    //   42: aload_3
    //   43: arraylength
    //   44: invokevirtual 280	java/io/BufferedInputStream:read	([BII)I
    //   47: iconst_m1
    //   48: if_icmpeq +11 -> 59
    //   51: aload_3
    //   52: getstatic 22	com/tencent/sharpP/SharpPUtils:SHARPP_PRECODE	[B
    //   55: invokestatic 285	java/util/Arrays:equals	([B[B)Z
    //   58: istore_1
    //   59: iload_1
    //   60: istore_2
    //   61: aload_0
    //   62: invokevirtual 288	java/io/BufferedInputStream:close	()V
    //   65: iload_1
    //   66: ireturn
    //   67: astore_0
    //   68: aload_0
    //   69: invokevirtual 289	java/io/IOException:printStackTrace	()V
    //   72: iload_2
    //   73: ireturn
    //   74: astore 4
    //   76: aload_0
    //   77: astore_3
    //   78: aload 4
    //   80: astore_0
    //   81: goto +61 -> 142
    //   84: astore 4
    //   86: goto +17 -> 103
    //   89: astore 4
    //   91: goto +34 -> 125
    //   94: astore_0
    //   95: goto +47 -> 142
    //   98: astore 4
    //   100: aload 5
    //   102: astore_0
    //   103: aload_0
    //   104: astore_3
    //   105: aload 4
    //   107: invokevirtual 289	java/io/IOException:printStackTrace	()V
    //   110: aload_0
    //   111: ifnull +49 -> 160
    //   114: aload_0
    //   115: invokevirtual 288	java/io/BufferedInputStream:close	()V
    //   118: iconst_0
    //   119: ireturn
    //   120: astore 4
    //   122: aload 6
    //   124: astore_0
    //   125: aload_0
    //   126: astore_3
    //   127: aload 4
    //   129: invokevirtual 290	java/io/FileNotFoundException:printStackTrace	()V
    //   132: aload_0
    //   133: ifnull +27 -> 160
    //   136: aload_0
    //   137: invokevirtual 288	java/io/BufferedInputStream:close	()V
    //   140: iconst_0
    //   141: ireturn
    //   142: aload_3
    //   143: ifnull +15 -> 158
    //   146: aload_3
    //   147: invokevirtual 288	java/io/BufferedInputStream:close	()V
    //   150: goto +8 -> 158
    //   153: astore_3
    //   154: aload_3
    //   155: invokevirtual 289	java/io/IOException:printStackTrace	()V
    //   158: aload_0
    //   159: athrow
    //   160: iconst_0
    //   161: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramFile	java.io.File
    //   3	63	1	bool1	boolean
    //   1	72	2	bool2	boolean
    //   15	132	3	localObject1	Object
    //   153	2	3	localIOException1	java.io.IOException
    //   74	5	4	localObject2	Object
    //   84	1	4	localIOException2	java.io.IOException
    //   89	1	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   98	8	4	localIOException3	java.io.IOException
    //   120	8	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   9	92	5	localObject3	Object
    //   12	111	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   61	65	67	java/io/IOException
    //   114	118	67	java/io/IOException
    //   136	140	67	java/io/IOException
    //   34	39	74	finally
    //   39	59	74	finally
    //   34	39	84	java/io/IOException
    //   39	59	84	java/io/IOException
    //   34	39	89	java/io/FileNotFoundException
    //   39	59	89	java/io/FileNotFoundException
    //   16	34	94	finally
    //   105	110	94	finally
    //   127	132	94	finally
    //   16	34	98	java/io/IOException
    //   16	34	120	java/io/FileNotFoundException
    //   146	150	153	java/io/IOException
  }
  
  public static boolean isSharpP(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      String str = (String)getArgumentsFromURL(paramString).get("t");
      if ((str != null) && (str.equals("6"))) {
        return true;
      }
      return (str == null) && (paramString.lastIndexOf("&t=6#sce") > 0);
    }
    ImageManagerEnv.getLogger().e("SharpPUtils", new Object[] { "------isSharpP:url is null" });
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.sharpP.SharpPUtils
 * JD-Core Version:    0.7.0.1
 */