package com.tencent.mtt.hippy.dom.node;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Base64;
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
  private static Map<String, Typeface> mFontCache = new HashMap();
  
  public static Typeface addTypeface(String paramString1, String paramString2, int paramInt)
  {
    String str = paramString1 + paramInt;
    paramString1 = (Typeface)mFontCache.get(str);
    if (paramString1 != null) {
      paramString2 = paramString1;
    }
    do
    {
      return paramString2;
      try
      {
        paramString2 = Typeface.createFromFile(paramString2);
        paramString1 = paramString2;
      }
      catch (RuntimeException paramString2)
      {
        for (;;)
        {
          paramString2.printStackTrace();
        }
      }
      paramString2 = paramString1;
    } while (paramString1 == null);
    mFontCache.put(str, paramString1);
    return paramString1;
  }
  
  public static Typeface addTypefaceWithBase64(String paramString1, String paramString2, int paramInt)
  {
    String str = paramString1 + paramInt;
    Typeface localTypeface = (Typeface)mFontCache.get(str);
    if (localTypeface != null) {
      return localTypeface;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    str = getFontPath(ContextHolder.getAppContext(), str);
    paramString2 = getRealTTFBase64(paramString2);
    deleteFontFile(str);
    saveFontFile(str, paramString2);
    paramString1 = addTypeface(paramString1, str, 0);
    deleteFontFile(str);
    return paramString1;
  }
  
  public static void apply(Paint paramPaint, int paramInt1, int paramInt2, String paramString)
  {
    int k = 0;
    Typeface localTypeface = paramPaint.getTypeface();
    int j;
    if (localTypeface == null)
    {
      j = 0;
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
        if ((j & 0x2) != 0)
        {
          paramInt2 = i;
          if (paramInt1 != -1) {}
        }
      }
      else
      {
        paramInt2 = i | 0x2;
      }
      if (paramString == null) {
        break label104;
      }
      paramString = getTypeface(paramString, paramInt2);
    }
    for (;;)
    {
      if (paramString == null) {
        break label122;
      }
      paramPaint.setTypeface(paramString);
      return;
      j = localTypeface.getStyle();
      break;
      label104:
      paramString = localTypeface;
      if (localTypeface != null) {
        paramString = Typeface.create(localTypeface, paramInt2);
      }
    }
    label122:
    paramPaint.setTypeface(Typeface.defaultFromStyle(paramInt2));
  }
  
  public static boolean checkFontExist(String paramString, int paramInt)
  {
    paramString = paramString + paramInt;
    return (Typeface)mFontCache.get(paramString) != null;
  }
  
  private static Typeface createTypeface(String paramString, int paramInt)
  {
    String str = EXTENSIONS[paramInt];
    String[] arrayOfString = FONT_EXTENSIONS;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfString[i];
      localObject = "fonts/" + paramString + str + (String)localObject;
      try
      {
        localObject = Typeface.createFromAsset(ContextHolder.getAppContext().getAssets(), (String)localObject);
        return localObject;
      }
      catch (RuntimeException localRuntimeException)
      {
        localRuntimeException.printStackTrace();
        i += 1;
      }
    }
    return Typeface.create(paramString, paramInt);
  }
  
  private static boolean deleteFontFile(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while (!paramString.exists());
    return paramString.delete();
  }
  
  private static String getFontPath(Context paramContext, String paramString)
  {
    return paramContext.getCacheDir().getAbsolutePath() + File.separator + paramString + ".ttf";
  }
  
  private static byte[] getRealTTFBase64(String paramString)
  {
    LogUtils.d("TypeFaceUtil", "原始字库数据 base64Str：" + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = paramString.indexOf("base64,");
    String str = paramString;
    if (i > 0) {
      str = paramString.substring("base64,".length() + i);
    }
    return Base64.decode(str, 0);
  }
  
  public static Typeface getTypeface(String paramString, int paramInt)
  {
    String str = paramString + paramInt;
    Typeface localTypeface = (Typeface)mFontCache.get(str);
    Object localObject = localTypeface;
    if (localTypeface == null)
    {
      paramString = createTypeface(paramString, paramInt);
      localObject = paramString;
      if (paramString != null)
      {
        mFontCache.put(str, paramString);
        localObject = paramString;
      }
    }
    return localObject;
  }
  
  /* Error */
  private static void saveFontFile(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 158	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aconst_null
    //   10: astore_2
    //   11: aconst_null
    //   12: astore_3
    //   13: new 213	java/io/BufferedOutputStream
    //   16: dup
    //   17: new 215	java/io/FileOutputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 218	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   25: invokespecial 221	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   28: astore_0
    //   29: aload_0
    //   30: astore_2
    //   31: aload_0
    //   32: aload_1
    //   33: invokevirtual 225	java/io/BufferedOutputStream:write	([B)V
    //   36: aload_0
    //   37: astore_2
    //   38: aload_0
    //   39: invokevirtual 228	java/io/BufferedOutputStream:flush	()V
    //   42: aload_0
    //   43: ifnull +7 -> 50
    //   46: aload_0
    //   47: invokevirtual 231	java/io/BufferedOutputStream:close	()V
    //   50: return
    //   51: astore_0
    //   52: aload_0
    //   53: invokevirtual 232	java/io/IOException:printStackTrace	()V
    //   56: return
    //   57: astore_1
    //   58: aconst_null
    //   59: astore_0
    //   60: aload_0
    //   61: astore_2
    //   62: aload_1
    //   63: invokevirtual 233	java/io/FileNotFoundException:printStackTrace	()V
    //   66: aload_0
    //   67: ifnull -17 -> 50
    //   70: aload_0
    //   71: invokevirtual 231	java/io/BufferedOutputStream:close	()V
    //   74: return
    //   75: astore_0
    //   76: aload_0
    //   77: invokevirtual 232	java/io/IOException:printStackTrace	()V
    //   80: return
    //   81: astore_1
    //   82: aload_3
    //   83: astore_0
    //   84: aload_0
    //   85: astore_2
    //   86: aload_1
    //   87: invokevirtual 232	java/io/IOException:printStackTrace	()V
    //   90: aload_0
    //   91: ifnull -41 -> 50
    //   94: aload_0
    //   95: invokevirtual 231	java/io/BufferedOutputStream:close	()V
    //   98: return
    //   99: astore_0
    //   100: aload_0
    //   101: invokevirtual 232	java/io/IOException:printStackTrace	()V
    //   104: return
    //   105: astore_0
    //   106: aload_2
    //   107: ifnull +7 -> 114
    //   110: aload_2
    //   111: invokevirtual 231	java/io/BufferedOutputStream:close	()V
    //   114: aload_0
    //   115: athrow
    //   116: astore_1
    //   117: aload_1
    //   118: invokevirtual 232	java/io/IOException:printStackTrace	()V
    //   121: goto -7 -> 114
    //   124: astore_0
    //   125: goto -19 -> 106
    //   128: astore_1
    //   129: goto -45 -> 84
    //   132: astore_1
    //   133: goto -73 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramString	String
    //   0	136	1	paramArrayOfByte	byte[]
    //   10	101	2	str	String
    //   12	71	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   46	50	51	java/io/IOException
    //   13	29	57	java/io/FileNotFoundException
    //   70	74	75	java/io/IOException
    //   13	29	81	java/io/IOException
    //   94	98	99	java/io/IOException
    //   13	29	105	finally
    //   86	90	105	finally
    //   110	114	116	java/io/IOException
    //   31	36	124	finally
    //   38	42	124	finally
    //   62	66	124	finally
    //   31	36	128	java/io/IOException
    //   38	42	128	java/io/IOException
    //   31	36	132	java/io/FileNotFoundException
    //   38	42	132	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.node.TypeFaceUtil
 * JD-Core Version:    0.7.0.1
 */