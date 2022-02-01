package com.tencent.mtt.hippy.dom.node;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mtt.hippy.adapter.font.HippyFontScaleAdapter;
import com.tencent.mtt.hippy.utils.ContextHolder;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TypeFaceUtil
{
  private static final String[] EXTENSIONS = { "", "_bold", "_italic", "_bold_italic" };
  private static final String FONTS_PATH = "fonts/";
  private static final String[] FONT_EXTENSIONS = { ".ttf", ".otf" };
  private static final String TAG = "TypeFaceUtil";
  private static final Map<String, Typeface> mFontCache = new HashMap();
  
  public static Typeface addTypeface(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    paramString1 = (Typeface)mFontCache.get(localObject);
    if (paramString1 != null) {
      return paramString1;
    }
    try
    {
      paramString2 = Typeface.createFromFile(paramString2);
      paramString1 = paramString2;
    }
    catch (RuntimeException paramString2)
    {
      paramString2.printStackTrace();
    }
    if (paramString1 != null) {
      mFontCache.put(localObject, paramString1);
    }
    return paramString1;
  }
  
  public static Typeface addTypefaceWithBase64(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    Typeface localTypeface = (Typeface)mFontCache.get(localObject);
    if (localTypeface != null) {
      return localTypeface;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    localObject = getFontPath(ContextHolder.getAppContext(), (String)localObject);
    paramString2 = getRealTTFBase64(paramString2);
    deleteFontFile((String)localObject);
    saveFontFile((String)localObject, paramString2);
    paramString1 = addTypeface(paramString1, (String)localObject, 0);
    deleteFontFile((String)localObject);
    return paramString1;
  }
  
  public static void apply(Paint paramPaint, int paramInt1, int paramInt2, String paramString, HippyFontScaleAdapter paramHippyFontScaleAdapter)
  {
    Typeface localTypeface = paramPaint.getTypeface();
    int k = 0;
    int j;
    if (localTypeface == null) {
      j = 0;
    } else {
      j = localTypeface.getStyle();
    }
    int i;
    if (paramInt2 != 1)
    {
      i = k;
      if ((j & 0x1) != 0)
      {
        i = k;
        if (paramInt2 != -1) {}
      }
    }
    else
    {
      i = 1;
    }
    if (paramInt1 != 2)
    {
      paramInt2 = i;
      if ((0x2 & j) != 0)
      {
        paramInt2 = i;
        if (paramInt1 != -1) {}
      }
    }
    else
    {
      paramInt2 = i | 0x2;
    }
    if (paramString != null)
    {
      paramString = getTypeface(paramString, paramInt2, paramHippyFontScaleAdapter);
    }
    else
    {
      paramString = localTypeface;
      if (localTypeface != null) {
        paramString = Typeface.create(localTypeface, paramInt2);
      }
    }
    if (paramString != null)
    {
      paramPaint.setTypeface(paramString);
      return;
    }
    paramPaint.setTypeface(Typeface.defaultFromStyle(paramInt2));
  }
  
  public static boolean checkFontExist(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(paramInt);
    paramString = localStringBuilder.toString();
    return (Typeface)mFontCache.get(paramString) != null;
  }
  
  private static Typeface createTypeface(String paramString, int paramInt, HippyFontScaleAdapter paramHippyFontScaleAdapter)
  {
    String str = EXTENSIONS[paramInt];
    String[] arrayOfString = FONT_EXTENSIONS;
    int j = arrayOfString.length;
    Object localObject1 = null;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = arrayOfString[i];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fonts/");
      localStringBuilder.append(paramString);
      localStringBuilder.append(str);
      localStringBuilder.append((String)localObject2);
      localObject2 = localStringBuilder.toString();
      try
      {
        localObject2 = Typeface.createFromAsset(ContextHolder.getAppContext().getAssets(), (String)localObject2);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("createTypeface: ");
        localStringBuilder.append(localException.getMessage());
        LogUtils.e("TypeFaceUtil", localStringBuilder.toString());
      }
      i += 1;
    }
    Object localObject3 = localObject1;
    if (localObject1 == null)
    {
      localObject3 = localObject1;
      if (paramHippyFontScaleAdapter != null)
      {
        paramHippyFontScaleAdapter = paramHippyFontScaleAdapter.getCustomFontFilePath(paramString, paramInt);
        localObject3 = localObject1;
        if (!TextUtils.isEmpty(paramHippyFontScaleAdapter)) {
          try
          {
            localObject3 = Typeface.createFromFile(paramHippyFontScaleAdapter);
          }
          catch (Exception paramHippyFontScaleAdapter)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("createTypeface: ");
            ((StringBuilder)localObject3).append(paramHippyFontScaleAdapter.getMessage());
            LogUtils.e("TypeFaceUtil", ((StringBuilder)localObject3).toString());
            localObject3 = localObject1;
          }
        }
      }
    }
    paramHippyFontScaleAdapter = (HippyFontScaleAdapter)localObject3;
    if (localObject3 == null) {
      paramHippyFontScaleAdapter = Typeface.create(paramString, paramInt);
    }
    return paramHippyFontScaleAdapter;
  }
  
  private static void deleteFontFile(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = new File(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  private static String getFontPath(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getCacheDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append(".ttf");
    return localStringBuilder.toString();
  }
  
  private static byte[] getRealTTFBase64(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("原始字库数据 base64Str：");
    ((StringBuilder)localObject).append(paramString);
    LogUtils.d("TypeFaceUtil", ((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = paramString.indexOf("base64,");
    localObject = paramString;
    if (i > 0) {
      localObject = paramString.substring(i + 7);
    }
    return Base64.decode((String)localObject, 0);
  }
  
  public static Typeface getTypeface(String paramString, int paramInt, HippyFontScaleAdapter paramHippyFontScaleAdapter)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(paramInt);
    String str = ((StringBuilder)localObject).toString();
    Typeface localTypeface = (Typeface)mFontCache.get(str);
    localObject = localTypeface;
    if (localTypeface == null) {
      localObject = createTypeface(paramString, paramInt, paramHippyFontScaleAdapter);
    }
    if (localObject != null) {
      mFontCache.put(str, localObject);
    }
    return localObject;
  }
  
  /* Error */
  private static void saveFontFile(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 178	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 180	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aconst_null
    //   10: astore_3
    //   11: aconst_null
    //   12: astore 4
    //   14: aconst_null
    //   15: astore_0
    //   16: new 226	java/io/BufferedOutputStream
    //   19: dup
    //   20: new 228	java/io/FileOutputStream
    //   23: dup
    //   24: aload_2
    //   25: invokespecial 231	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   28: invokespecial 234	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: astore_2
    //   32: aload_2
    //   33: aload_1
    //   34: invokevirtual 238	java/io/BufferedOutputStream:write	([B)V
    //   37: aload_2
    //   38: invokevirtual 241	java/io/BufferedOutputStream:flush	()V
    //   41: aload_2
    //   42: invokevirtual 244	java/io/BufferedOutputStream:close	()V
    //   45: return
    //   46: astore_0
    //   47: aload_2
    //   48: astore_1
    //   49: goto +70 -> 119
    //   52: astore_0
    //   53: aload_2
    //   54: astore_1
    //   55: aload_0
    //   56: astore_2
    //   57: goto +22 -> 79
    //   60: astore_0
    //   61: aload_2
    //   62: astore_1
    //   63: aload_0
    //   64: astore_2
    //   65: goto +33 -> 98
    //   68: astore_2
    //   69: aload_0
    //   70: astore_1
    //   71: aload_2
    //   72: astore_0
    //   73: goto +46 -> 119
    //   76: astore_2
    //   77: aload_3
    //   78: astore_1
    //   79: aload_1
    //   80: astore_0
    //   81: aload_2
    //   82: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   85: aload_1
    //   86: ifnull +32 -> 118
    //   89: aload_1
    //   90: invokevirtual 244	java/io/BufferedOutputStream:close	()V
    //   93: return
    //   94: astore_2
    //   95: aload 4
    //   97: astore_1
    //   98: aload_1
    //   99: astore_0
    //   100: aload_2
    //   101: invokevirtual 246	java/io/FileNotFoundException:printStackTrace	()V
    //   104: aload_1
    //   105: ifnull +13 -> 118
    //   108: aload_1
    //   109: invokevirtual 244	java/io/BufferedOutputStream:close	()V
    //   112: return
    //   113: astore_0
    //   114: aload_0
    //   115: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   118: return
    //   119: aload_1
    //   120: ifnull +15 -> 135
    //   123: aload_1
    //   124: invokevirtual 244	java/io/BufferedOutputStream:close	()V
    //   127: goto +8 -> 135
    //   130: astore_1
    //   131: aload_1
    //   132: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   135: aload_0
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	paramString	String
    //   0	137	1	paramArrayOfByte	byte[]
    //   8	57	2	localObject1	Object
    //   68	4	2	localObject2	Object
    //   76	6	2	localIOException	java.io.IOException
    //   94	7	2	localFileNotFoundException	java.io.FileNotFoundException
    //   10	68	3	localObject3	Object
    //   12	84	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   32	41	46	finally
    //   32	41	52	java/io/IOException
    //   32	41	60	java/io/FileNotFoundException
    //   16	32	68	finally
    //   81	85	68	finally
    //   100	104	68	finally
    //   16	32	76	java/io/IOException
    //   16	32	94	java/io/FileNotFoundException
    //   41	45	113	java/io/IOException
    //   89	93	113	java/io/IOException
    //   108	112	113	java/io/IOException
    //   123	127	130	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.node.TypeFaceUtil
 * JD-Core Version:    0.7.0.1
 */