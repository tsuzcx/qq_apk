package com.tencent.mobileqq.emoticonview.anisticker;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.view.View;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class AniStickerSvgDrawable
  extends Drawable
  implements Animatable, Runnable
{
  private static float gradientWidth;
  private static long lastUpdateTime;
  private static float totalTranslation;
  private Bitmap backgroundBitmap;
  private Canvas backgroundCanvas;
  private Shader backgroundGradient;
  private float colorAlpha;
  ArrayList<Object> commands = new ArrayList();
  private float crossfadeAlpha = 1.0F;
  private int currentColor = -1;
  int height;
  HashMap<Object, Paint> paints = new HashMap();
  private LinearGradient placeholderGradient;
  private Matrix placeholderMatrix;
  private boolean running;
  private boolean supportGradualChange = false;
  int width;
  
  private void startRenderAnim()
  {
    if ((this.supportGradualChange) && (!isRunning())) {
      start();
    }
  }
  
  public void addCommand(Object paramObject)
  {
    this.commands.add(paramObject);
  }
  
  public void addCommand(Object paramObject, Paint paramPaint)
  {
    this.commands.add(paramObject);
    this.paints.put(paramObject, new Paint(paramPaint));
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = this.currentColor;
    if (i != -1) {
      setupGradient(i, this.colorAlpha);
    }
    Rect localRect = getBounds();
    float f1 = Math.max(localRect.width() / this.width, localRect.height() / this.height);
    paramCanvas.save();
    paramCanvas.translate(localRect.left, localRect.top);
    paramCanvas.scale(f1, f1);
    int j = this.commands.size();
    i = 0;
    while (i < j)
    {
      Object localObject1 = this.commands.get(i);
      if ((localObject1 instanceof Matrix))
      {
        paramCanvas.save();
        paramCanvas.concat((Matrix)localObject1);
      }
      else if (localObject1 == null)
      {
        paramCanvas.restore();
      }
      else
      {
        Paint localPaint = (Paint)this.paints.get(localObject1);
        int k = localPaint.getAlpha();
        localPaint.setAlpha((int)(this.crossfadeAlpha * k));
        localPaint.setColor(this.currentColor);
        localPaint.setStyle(Paint.Style.FILL);
        if ((localObject1 instanceof Path))
        {
          try
          {
            paramCanvas.drawPath((Path)localObject1, localPaint);
          }
          catch (Exception localException)
          {
            QLog.e("AniStickerSvgDrawable", 1, localException, new Object[0]);
          }
        }
        else if ((localException instanceof Rect))
        {
          paramCanvas.drawRect((Rect)localException, localPaint);
        }
        else if ((localException instanceof RectF))
        {
          paramCanvas.drawRect((RectF)localException, localPaint);
        }
        else
        {
          Object localObject2;
          if ((localException instanceof AniStickerSvgDrawable.Line))
          {
            localObject2 = (AniStickerSvgDrawable.Line)localException;
            paramCanvas.drawLine(((AniStickerSvgDrawable.Line)localObject2).x1, ((AniStickerSvgDrawable.Line)localObject2).y1, ((AniStickerSvgDrawable.Line)localObject2).x2, ((AniStickerSvgDrawable.Line)localObject2).y2, localPaint);
          }
          else if ((localObject2 instanceof AniStickerSvgDrawable.Circle))
          {
            localObject2 = (AniStickerSvgDrawable.Circle)localObject2;
            paramCanvas.drawCircle(((AniStickerSvgDrawable.Circle)localObject2).x1, ((AniStickerSvgDrawable.Circle)localObject2).y1, ((AniStickerSvgDrawable.Circle)localObject2).rad, localPaint);
          }
          else if ((localObject2 instanceof AniStickerSvgDrawable.Oval))
          {
            paramCanvas.drawOval(((AniStickerSvgDrawable.Oval)localObject2).rect, localPaint);
          }
          else if ((localObject2 instanceof AniStickerSvgDrawable.RoundRect))
          {
            localObject2 = (AniStickerSvgDrawable.RoundRect)localObject2;
            paramCanvas.drawRoundRect(((AniStickerSvgDrawable.RoundRect)localObject2).rect, ((AniStickerSvgDrawable.RoundRect)localObject2).rx, ((AniStickerSvgDrawable.RoundRect)localObject2).rx, localPaint);
          }
        }
        localPaint.setAlpha(k);
      }
      i += 1;
    }
    paramCanvas.restore();
    if (this.placeholderGradient != null)
    {
      long l3 = SystemClock.elapsedRealtime();
      long l2 = Math.abs(lastUpdateTime - l3);
      long l1 = l2;
      if (l2 > 17L) {
        l1 = 16L;
      }
      lastUpdateTime = l3;
      float f2;
      float f3;
      for (totalTranslation += (float)l1 * gradientWidth / 1800.0F;; totalTranslation = f2 - f3)
      {
        f2 = totalTranslation;
        f3 = gradientWidth;
        if (f2 < f3 / 2.0F) {
          break;
        }
      }
      this.placeholderMatrix.reset();
      this.placeholderMatrix.postTranslate(totalTranslation - localRect.left, 0.0F);
      paramCanvas = this.placeholderMatrix;
      f1 = 1.0F / f1;
      paramCanvas.postScale(f1, f1);
      this.placeholderGradient.setLocalMatrix(this.placeholderMatrix);
    }
    startRenderAnim();
  }
  
  public int getIntrinsicHeight()
  {
    return this.height;
  }
  
  public int getIntrinsicWidth()
  {
    return this.width;
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public boolean isRunning()
  {
    return this.running;
  }
  
  public void run()
  {
    if ((isRunning()) && ((getCallback() instanceof View)))
    {
      ((View)getCallback()).invalidate();
      scheduleSelf(this, SystemClock.uptimeMillis());
    }
  }
  
  public void setAlpha(int paramInt)
  {
    this.crossfadeAlpha = (paramInt / 255.0F);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void setSupportGradientAnim(boolean paramBoolean)
  {
    this.supportGradualChange = paramBoolean;
  }
  
  public void setSvgResCommand(AniStickerSvgDrawable.SvgResCommand paramSvgResCommand)
  {
    if (paramSvgResCommand.commands != null)
    {
      if (paramSvgResCommand.paints == null) {
        return;
      }
      this.commands = new ArrayList(paramSvgResCommand.commands);
      this.paints = new HashMap(paramSvgResCommand.paints);
    }
  }
  
  public void setupGradient(int paramInt, float paramFloat)
  {
    if (this.currentColor != paramInt)
    {
      this.colorAlpha = paramFloat;
      this.currentColor = paramInt;
      gradientWidth = ViewUtils.getScreenWidth() * 2;
      float f2 = ViewUtils.dip2px(180.0F) / gradientWidth;
      paramInt = Color.argb((int)(Color.alpha(paramInt) / 2 * this.colorAlpha), Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt));
      paramFloat = (1.0F - f2) / 2.0F;
      float f1 = gradientWidth;
      f2 /= 2.0F;
      Object localObject = Shader.TileMode.REPEAT;
      this.placeholderGradient = new LinearGradient(0.0F, 0.0F, f1, 0.0F, new int[] { 0, 0, paramInt, 0, 0 }, new float[] { 0.0F, paramFloat - f2, paramFloat, paramFloat + f2, 1.0F }, (Shader.TileMode)localObject);
      if (Build.VERSION.SDK_INT >= 28)
      {
        paramFloat = gradientWidth;
        localObject = Shader.TileMode.REPEAT;
        this.backgroundGradient = new LinearGradient(0.0F, 0.0F, paramFloat, 0.0F, new int[] { paramInt, paramInt }, null, (Shader.TileMode)localObject);
      }
      else
      {
        if (this.backgroundBitmap == null)
        {
          this.backgroundBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
          this.backgroundCanvas = new Canvas(this.backgroundBitmap);
        }
        this.backgroundCanvas.drawColor(paramInt);
        this.backgroundGradient = new BitmapShader(this.backgroundBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      }
      this.placeholderMatrix = new Matrix();
      this.placeholderGradient.setLocalMatrix(this.placeholderMatrix);
      localObject = this.paints.values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Paint)((Iterator)localObject).next()).setShader(new ComposeShader(this.placeholderGradient, this.backgroundGradient, PorterDuff.Mode.ADD));
      }
    }
  }
  
  public void start()
  {
    if (!isRunning())
    {
      this.running = true;
      scheduleSelf(this, SystemClock.uptimeMillis());
    }
  }
  
  public void stop()
  {
    if (isRunning()) {
      unscheduleSelf(this);
    }
  }
  
  public void unscheduleSelf(Runnable paramRunnable)
  {
    this.running = false;
    super.unscheduleSelf(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.anisticker.AniStickerSvgDrawable
 * JD-Core Version:    0.7.0.1
 */