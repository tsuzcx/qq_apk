package com.tencent.ttpic.openapi.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.model.TextWMElement;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class WMTextDrawer
{
  protected static final String INT_D = "%d";
  private static final String TAG = WMTextDrawer.class.getSimpleName();
  private static Map<String, Typeface> typefaceCache = new HashMap();
  private WMTextDrawer.AsyncDrawRunnable asyncDrawRunnable;
  private boolean isAsyncDrawFinished = true;
  public String lastDrawText = "";
  
  @TargetApi(17)
  public static Bitmap blurBitmap(Context paramContext, Bitmap paramBitmap, float paramFloat)
  {
    if ((paramContext == null) || (!BitmapUtils.isLegal(paramBitmap))) {
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap);
    paramContext = RenderScript.create(paramContext);
    ScriptIntrinsicBlur localScriptIntrinsicBlur = ScriptIntrinsicBlur.create(paramContext, Element.U8_4(paramContext));
    paramBitmap = Allocation.createFromBitmap(paramContext, paramBitmap);
    Allocation localAllocation = Allocation.createFromBitmap(paramContext, localBitmap);
    localScriptIntrinsicBlur.setRadius(paramFloat);
    localScriptIntrinsicBlur.setInput(paramBitmap);
    localScriptIntrinsicBlur.forEach(localAllocation);
    localAllocation.copyTo(localBitmap);
    paramBitmap.destroy();
    localAllocation.destroy();
    localScriptIntrinsicBlur.destroy();
    paramContext.destroy();
    return localBitmap;
  }
  
  private void drawHorizontalText(TextWMElement paramTextWMElement, Canvas paramCanvas, int paramInt1, int paramInt2, String paramString)
  {
    new WMTextDrawer.TextHorizontalLayout(this, paramTextWMElement, paramInt1, paramInt2, paramString).draw(paramCanvas);
  }
  
  private void drawNormalVerticalText(TextWMElement paramTextWMElement, Canvas paramCanvas, int paramInt1, int paramInt2, String paramString)
  {
    new WMTextDrawer.TextVerticalLayout(this, paramTextWMElement, paramInt1, paramInt2, paramString).draw(paramCanvas);
  }
  
  private void drawRotatedVerticalText(TextWMElement paramTextWMElement, String paramString)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramTextWMElement.height, paramTextWMElement.width, Bitmap.Config.ARGB_8888);
    drawHorizontalText(paramTextWMElement, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight(), paramString);
    if (BitmapUtils.isLegal(paramTextWMElement.getIdleBitmap())) {
      paramTextWMElement.getIdleBitmap().recycle();
    }
    paramTextWMElement.setIdleBitmap(rotateBitmap(localBitmap, paramTextWMElement.rotate));
  }
  
  private void drawVerticalText(TextWMElement paramTextWMElement, Canvas paramCanvas, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramTextWMElement.rotate == 90) || (paramTextWMElement.rotate == -90))
    {
      drawRotatedVerticalText(paramTextWMElement, paramString);
      return;
    }
    drawNormalVerticalText(paramTextWMElement, paramCanvas, paramInt1, paramInt2, paramString);
  }
  
  public static Bitmap fastblur(Bitmap paramBitmap, float paramFloat, int paramInt)
  {
    Object localObject = Bitmap.createScaledBitmap(paramBitmap, Math.round(paramBitmap.getWidth() * paramFloat), Math.round(paramBitmap.getHeight() * paramFloat), false);
    Bitmap localBitmap = ((Bitmap)localObject).copy(((Bitmap)localObject).getConfig(), true);
    if ((localObject != paramBitmap) && (localObject != localBitmap)) {
      ((Bitmap)localObject).recycle();
    }
    if (paramInt < 1) {
      localObject = null;
    }
    do
    {
      return localObject;
      int i = paramInt;
      if (paramFloat < 0.5F) {
        i = (int)(paramInt * paramFloat * 2.0F);
      }
      int i5 = localBitmap.getWidth();
      int i6 = localBitmap.getHeight();
      localObject = new int[i5 * i6];
      localBitmap.getPixels((int[])localObject, 0, i5, 0, 0, i5, i6);
      int i10 = i5 - 1;
      int i7 = i6 - 1;
      paramInt = i5 * i6;
      int i8 = i + i + 1;
      int[] arrayOfInt1 = new int[paramInt];
      int[] arrayOfInt2 = new int[paramInt];
      arrayOfInt2 = new int[paramInt];
      arrayOfInt2 = new int[Math.max(i5, i6)];
      paramInt = i8 + 1 >> 1;
      int j = paramInt * paramInt;
      int[] arrayOfInt3 = new int[j * 256];
      paramInt = 0;
      while (paramInt < j * 256)
      {
        arrayOfInt3[paramInt] = (paramInt / j);
        paramInt += 1;
      }
      int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { i8, 1 });
      int i9 = i + 1;
      int i1 = 0;
      paramInt = 0;
      int n = 0;
      int i2;
      int m;
      int k;
      int i3;
      int[] arrayOfInt4;
      int i4;
      while (n < i6)
      {
        j = 0;
        i2 = -i;
        m = 0;
        k = 0;
        if (i2 <= i)
        {
          i3 = localObject[(Math.min(i10, Math.max(i2, 0)) + paramInt)];
          arrayOfInt4 = arrayOfInt[(i2 + i)];
          arrayOfInt4[0] = ((i3 & 0xFF000000) >>> 24);
          m += (i9 - Math.abs(i2)) * arrayOfInt4[0];
          if (i2 > 0) {
            j += arrayOfInt4[0];
          }
          for (;;)
          {
            i2 += 1;
            break;
            k += arrayOfInt4[0];
          }
        }
        i4 = 0;
        i2 = i;
        i3 = m;
        m = i4;
        while (m < i5)
        {
          arrayOfInt1[paramInt] = arrayOfInt3[i3];
          arrayOfInt4 = arrayOfInt[((i2 - i + i8) % i8)];
          i4 = arrayOfInt4[0];
          if (n == 0) {
            arrayOfInt2[m] = Math.min(m + i + 1, i10);
          }
          arrayOfInt4[0] = ((localObject[(arrayOfInt2[m] + i1)] & 0xFF000000) >>> 24);
          j += arrayOfInt4[0];
          i3 = i3 - k + j;
          i2 = (i2 + 1) % i8;
          arrayOfInt4 = arrayOfInt[(i2 % i8)];
          k = k - i4 + arrayOfInt4[0];
          j -= arrayOfInt4[0];
          paramInt += 1;
          m += 1;
        }
        i1 += i5;
        n += 1;
      }
      paramInt = 0;
      while (paramInt < i5)
      {
        m = 0;
        i1 = -i * i5;
        n = -i;
        j = 0;
        k = 0;
        if (n <= i)
        {
          i2 = Math.max(0, i1) + paramInt;
          arrayOfInt4 = arrayOfInt[(n + i)];
          arrayOfInt4[0] = arrayOfInt1[i2];
          i3 = Math.abs(n);
          i4 = arrayOfInt1[i2];
          if (n > 0) {
            m += arrayOfInt4[0];
          }
          for (;;)
          {
            i2 = i1;
            if (n < i7) {
              i2 = i1 + i5;
            }
            n += 1;
            j = i4 * (i9 - i3) + j;
            i1 = i2;
            break;
            k += arrayOfInt4[0];
          }
        }
        i4 = 0;
        n = paramInt;
        i2 = m;
        m = k;
        i3 = i;
        i1 = j;
        j = i4;
        k = n;
        n = i3;
        while (j < i6)
        {
          localObject[k] = (0xFF000000 & arrayOfInt3[i1] << 24 | 0xFFFFFF & localObject[k]);
          arrayOfInt4 = arrayOfInt[((n - i + i8) % i8)];
          i3 = arrayOfInt4[0];
          if (paramInt == 0) {
            arrayOfInt2[j] = (Math.min(j + i9, i7) * i5);
          }
          arrayOfInt4[0] = arrayOfInt1[(arrayOfInt2[j] + paramInt)];
          i2 += arrayOfInt4[0];
          i1 = i1 - m + i2;
          n = (n + 1) % i8;
          arrayOfInt4 = arrayOfInt[n];
          m = m - i3 + arrayOfInt4[0];
          i2 -= arrayOfInt4[0];
          k += i5;
          j += 1;
        }
        paramInt += 1;
      }
      localBitmap.setPixels((int[])localObject, 0, i5, 0, 0, i5, i6);
      localObject = localBitmap;
    } while (paramFloat == 1.0F);
    localObject = Bitmap.createScaledBitmap(localBitmap, paramBitmap.getWidth(), paramBitmap.getHeight(), false);
    if ((localObject != localBitmap) && (localBitmap != paramBitmap)) {
      localBitmap.recycle();
    }
    return localObject;
  }
  
  public static void putTypeface(@NonNull String paramString, @NonNull Typeface paramTypeface)
  {
    if (typefaceCache != null) {
      typefaceCache.put(paramString, paramTypeface);
    }
  }
  
  private Bitmap rotateBitmap(Bitmap paramBitmap, float paramFloat)
  {
    Object localObject;
    if (paramBitmap == null) {
      localObject = null;
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      localObject = new Matrix();
      ((Matrix)localObject).setRotate(paramFloat);
      localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, (Matrix)localObject, false);
      localObject = localBitmap;
    } while (localBitmap.equals(paramBitmap));
    paramBitmap.recycle();
    return localBitmap;
  }
  
  public void cancelAsyncDrawTask()
  {
    if ((!this.isAsyncDrawFinished) && (this.asyncDrawRunnable != null))
    {
      this.asyncDrawRunnable.isTaskCanceled = true;
      this.isAsyncDrawFinished = true;
    }
  }
  
  public void drawTextToBitmap(TextWMElement paramTextWMElement, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramString != null) && (!TextUtils.isEmpty(paramString))) {
      this.lastDrawText = paramString;
    }
    this.isAsyncDrawFinished = false;
    this.asyncDrawRunnable = new WMTextDrawer.1(this, paramTextWMElement, paramString, paramBoolean1);
    if (paramBoolean2)
    {
      this.asyncDrawRunnable.run();
      return;
    }
    AsyncTask.SERIAL_EXECUTOR.execute(this.asyncDrawRunnable);
  }
  
  public boolean isAsyncDrawFinished()
  {
    return this.isAsyncDrawFinished;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.WMTextDrawer
 * JD-Core Version:    0.7.0.1
 */