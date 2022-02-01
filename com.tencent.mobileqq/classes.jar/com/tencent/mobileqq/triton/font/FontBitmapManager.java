package com.tencent.mobileqq.triton.font;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.jni.JNICaller.TTEngine;
import com.tencent.mobileqq.triton.utils.TritonKeep;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@TritonKeep
public class FontBitmapManager
{
  private static final String FONT_STYLE_ITALIC = "italic";
  private static final String FONT_STYLE_NORMAL = "normal";
  private static final String FONT_STYLE_OBLIQUE = "oblique";
  private static final String FONT_WEIGHT_BOLD = "bold";
  private static final String FONT_WEIGHT_NORMAL = "normal";
  static final String NAME = "FontBitmapManager";
  private static final String TAG = "FontBitmapManager";
  private final Map<String, Typeface> loadedTypefaceMap = new HashMap();
  
  private int typeFaceStyleFromW3CFont(int paramInt1, int paramInt2)
  {
    int i = 1;
    if (paramInt1 == 1) {}
    while (paramInt1 == 2)
    {
      paramInt1 = 2;
      break;
    }
    paramInt1 = 0;
    if (paramInt2 == 1)
    {
      paramInt2 = i;
      if (paramInt1 == 2) {
        return 3;
      }
    }
    else
    {
      paramInt2 = paramInt1;
    }
    return paramInt2;
  }
  
  private Typeface typefaceFromW3CFontParameters(int paramInt1, int paramInt2, String paramString)
  {
    if ((this.loadedTypefaceMap.containsKey(paramString)) && (this.loadedTypefaceMap.get(paramString) != null)) {
      return (Typeface)this.loadedTypefaceMap.get(paramString);
    }
    return Typeface.create(paramString, typeFaceStyleFromW3CFont(paramInt1, paramInt2));
  }
  
  @TritonKeep
  public FontBitmap createBitmap(int paramInt1, int paramInt2, String paramString1, String paramString2, float paramFloat1, boolean paramBoolean, float paramFloat2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    Paint localPaint = new Paint(1);
    localPaint.setTypeface(typefaceFromW3CFontParameters(paramInt1, paramInt2, paramString1));
    localPaint.setTextSize(paramFloat1);
    if (paramBoolean)
    {
      localPaint.setStyle(Paint.Style.FILL);
    }
    else
    {
      localPaint.setStyle(Paint.Style.STROKE);
      if (paramFloat2 > 0.0F) {
        localPaint.setStrokeWidth(paramFloat2);
      }
    }
    paramFloat1 = -localPaint.ascent();
    paramInt1 = (int)(localPaint.measureText(paramString2) + 0.5F);
    paramInt2 = (int)(localPaint.descent() + paramFloat1 + 0.5F);
    if (paramInt1 > 0)
    {
      if (paramInt2 <= 0) {
        return null;
      }
      paramString1 = new FontBitmap();
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      new Canvas(localBitmap).drawText(paramString2, 0.0F, paramFloat1, localPaint);
      paramString1.bitmap = localBitmap;
      paramString1.ascent = localPaint.ascent();
      paramString1.descent = localPaint.descent();
      return paramString1;
    }
    return null;
  }
  
  public int getTextLineHeight(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if ((!TextUtils.isEmpty(paramString4)) && (!TextUtils.isEmpty(paramString3)))
    {
      if ("normal".equals(paramString1)) {}
      int i;
      for (;;)
      {
        i = 0;
        break;
        if ("italic".equals(paramString1))
        {
          i = 1;
          break;
        }
        if ("oblique".equals(paramString1))
        {
          i = 2;
          break;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getTextLineHeight: invalid font style ");
        localStringBuilder.append(paramString1);
        Logger.w("FontBitmapManager", localStringBuilder.toString());
      }
      if ("normal".equals(paramString2)) {}
      int j;
      for (;;)
      {
        j = 0;
        break;
        if ("bold".equals(paramString2))
        {
          j = 1;
          break;
        }
        paramString1 = new StringBuilder();
        paramString1.append("getTextLineHeight: invalid font weight ");
        paramString1.append(paramString2);
        Logger.w("FontBitmapManager", paramString1.toString());
      }
      paramString1 = new Paint(1);
      paramString1.setTypeface(typefaceFromW3CFontParameters(i, j, paramString3));
      paramString1.setTextSize(paramInt);
      paramString2 = new Rect();
      paramString1.getTextBounds(paramString4, 0, paramString4.length(), paramString2);
      return paramString2.height();
    }
    paramString1 = new StringBuilder();
    paramString1.append("getTextLineHeight: invalid parameters, text:");
    paramString1.append(paramString4);
    paramString1.append(", fontFamily:");
    paramString1.append(paramString3);
    Logger.e("FontBitmapManager", paramString1.toString());
    return 0;
  }
  
  @Deprecated
  public void init(Context paramContext)
  {
    paramContext = paramContext.getApplicationContext();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("/data/data/");
    ((StringBuilder)localObject).append(paramContext.getPackageName());
    ((StringBuilder)localObject).append("/cache");
    localObject = ((StringBuilder)localObject).toString();
    JNICaller.TTEngine.nativeFontManagerInit(paramContext.getAssets(), (String)localObject);
  }
  
  public String loadFont(@NonNull File paramFile)
  {
    boolean bool = paramFile.exists();
    String str3 = null;
    String str1 = str3;
    String str2;
    if (bool)
    {
      Typeface localTypeface;
      try
      {
        localTypeface = Typeface.createFromFile(paramFile);
      }
      catch (Exception localException)
      {
        Logger.e("FontBitmapManager", "loadFont: ", localException);
        localTypeface = null;
      }
      str2 = str3;
      if (localTypeface != null)
      {
        str2 = str3;
        if (localTypeface != Typeface.DEFAULT)
        {
          str3 = FontFileReader.getFamilyName(paramFile.getAbsolutePath());
          str2 = str3;
          if (TextUtils.isEmpty(str3)) {
            str2 = paramFile.getName().replaceFirst("\\..*$", "").replaceAll("\\s", "_");
          }
          this.loadedTypefaceMap.put(str2, localTypeface);
        }
      }
    }
    return str2;
  }
  
  @TritonKeep
  public float measureText(int paramInt1, int paramInt2, String paramString1, String paramString2, float paramFloat1, boolean paramBoolean, float paramFloat2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return 0.0F;
    }
    Paint localPaint = new Paint(1);
    localPaint.setTypeface(typefaceFromW3CFontParameters(paramInt1, paramInt2, paramString1));
    localPaint.setTextSize(paramFloat1);
    if (paramBoolean)
    {
      localPaint.setStyle(Paint.Style.FILL);
    }
    else
    {
      localPaint.setStyle(Paint.Style.STROKE);
      if (paramFloat2 > 0.0F) {
        localPaint.setStrokeWidth(paramFloat2);
      }
    }
    return localPaint.measureText(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.font.FontBitmapManager
 * JD-Core Version:    0.7.0.1
 */