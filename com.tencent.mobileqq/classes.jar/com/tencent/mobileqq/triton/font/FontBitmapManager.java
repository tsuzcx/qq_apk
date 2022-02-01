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
    int j = 1;
    int i = 0;
    if (paramInt1 == 1) {
      i = 2;
    }
    while (paramInt2 == 1)
    {
      paramInt1 = j;
      if (i == 2) {
        paramInt1 = 3;
      }
      return paramInt1;
      if (paramInt1 == 2) {
        i = 2;
      }
    }
    return i;
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
    if (paramBoolean) {
      localPaint.setStyle(Paint.Style.FILL);
    }
    for (;;)
    {
      paramFloat1 = -localPaint.ascent();
      paramInt1 = (int)(localPaint.measureText(paramString2) + 0.5F);
      paramInt2 = (int)(localPaint.descent() + paramFloat1 + 0.5F);
      if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
        break;
      }
      paramString1 = new FontBitmap();
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      new Canvas(localBitmap).drawText(paramString2, 0.0F, paramFloat1, localPaint);
      paramString1.bitmap = localBitmap;
      paramString1.ascent = localPaint.ascent();
      paramString1.descent = localPaint.descent();
      return paramString1;
      localPaint.setStyle(Paint.Style.STROKE);
      if (paramFloat2 > 0.0F) {
        localPaint.setStrokeWidth(paramFloat2);
      }
    }
  }
  
  public int getTextLineHeight(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if ((TextUtils.isEmpty(paramString4)) || (TextUtils.isEmpty(paramString3)))
    {
      Logger.e("FontBitmapManager", "getTextLineHeight: invalid parameters, text:" + paramString4 + ", fontFamily:" + paramString3);
      return 0;
    }
    int i;
    int j;
    if ("normal".equals(paramString1))
    {
      i = 0;
      if (!"normal".equals(paramString2)) {
        break label193;
      }
      j = 0;
    }
    for (;;)
    {
      paramString1 = new Paint(1);
      paramString1.setTypeface(typefaceFromW3CFontParameters(i, j, paramString3));
      paramString1.setTextSize(paramInt);
      paramString2 = new Rect();
      paramString1.getTextBounds(paramString4, 0, paramString4.length(), paramString2);
      return paramString2.height();
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
      Logger.w("FontBitmapManager", "getTextLineHeight: invalid font style " + paramString1);
      i = 0;
      break;
      label193:
      if ("bold".equals(paramString2))
      {
        j = 1;
      }
      else
      {
        Logger.w("FontBitmapManager", "getTextLineHeight: invalid font weight " + paramString2);
        j = 0;
      }
    }
  }
  
  @Deprecated
  public void init(Context paramContext)
  {
    paramContext = paramContext.getApplicationContext();
    String str = "/data/data/" + paramContext.getPackageName() + "/cache";
    JNICaller.TTEngine.nativeFontManagerInit(paramContext.getAssets(), str);
  }
  
  public String loadFont(@NonNull File paramFile)
  {
    String str2 = null;
    String str1 = str2;
    if (paramFile.exists()) {}
    try
    {
      localTypeface = Typeface.createFromFile(paramFile);
      str1 = str2;
      if (localTypeface != null)
      {
        str1 = str2;
        if (localTypeface != Typeface.DEFAULT)
        {
          str2 = FontFileReader.getFamilyName(paramFile.getAbsolutePath());
          str1 = str2;
          if (TextUtils.isEmpty(str2)) {
            str1 = paramFile.getName().replaceFirst("\\..*$", "").replaceAll("\\s", "_");
          }
          this.loadedTypefaceMap.put(str1, localTypeface);
        }
      }
      return str1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.e("FontBitmapManager", "loadFont: ", localException);
        Typeface localTypeface = null;
      }
    }
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
    if (paramBoolean) {
      localPaint.setStyle(Paint.Style.FILL);
    }
    for (;;)
    {
      return localPaint.measureText(paramString2);
      localPaint.setStyle(Paint.Style.STROKE);
      if (paramFloat2 > 0.0F) {
        localPaint.setStrokeWidth(paramFloat2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.font.FontBitmapManager
 * JD-Core Version:    0.7.0.1
 */