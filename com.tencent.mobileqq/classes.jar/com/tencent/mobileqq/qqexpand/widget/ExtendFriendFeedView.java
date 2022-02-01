package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.qqexpand.utils.ExpandResourceUtil;
import com.tencent.mobileqq.qqexpand.utils.GradientDrawableUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class ExtendFriendFeedView
  extends FrameLayout
  implements View.OnTouchListener
{
  public static ColorFilter a = new PorterDuffColorFilter(536870912, PorterDuff.Mode.SRC_ATOP);
  private static final int[] b = { -13900833, -37464, -12331403, -5544982 };
  private static Bitmap c;
  private static final Map<String, WeakReference<Bitmap>> d = new HashMap();
  private int e;
  private int f;
  private Paint g;
  private Bitmap h;
  private RectF i;
  private final float j;
  private GradientDrawable k;
  private boolean l;
  private int m = 0;
  
  public ExtendFriendFeedView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExtendFriendFeedView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExtendFriendFeedView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(1912995850, this, true);
    this.j = AIOUtils.b(4.0F, getResources());
  }
  
  private Bitmap a(String paramString)
  {
    String[] arrayOfString = ExpandResourceUtil.c;
    String str2 = null;
    Object localObject2 = null;
    Object localObject1 = str2;
    if (arrayOfString != null)
    {
      localObject1 = str2;
      if (arrayOfString.length <= 0) {}
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          break label244;
        }
        n = paramString.lastIndexOf('=');
        if (n < 0) {
          break label244;
        }
        paramString = paramString.substring(n + 1);
        if (TextUtils.isEmpty(paramString)) {
          break label244;
        }
        n = paramString.toUpperCase().charAt(0) % arrayOfString.length;
        if (n == -1) {
          str2 = ExpandResourceUtil.a("expand_feed_bg_default.png");
        } else {
          str2 = ExpandResourceUtil.a(arrayOfString[n]);
        }
        paramString = (WeakReference)d.get(str2);
        if (paramString != null) {
          paramString = (Bitmap)paramString.get();
        } else {
          paramString = null;
        }
        if (paramString != null)
        {
          localObject1 = paramString;
          localObject2 = paramString;
        }
        try
        {
          if (!paramString.isRecycled()) {
            break;
          }
          localObject1 = paramString;
          localObject2 = new BitmapFactory.Options();
          localObject1 = paramString;
          ((BitmapFactory.Options)localObject2).inPreferredConfig = Bitmap.Config.RGB_565;
          localObject1 = paramString;
          ((BitmapFactory.Options)localObject2).inSampleSize = 2;
          localObject1 = paramString;
          localObject2 = ExpandResourceUtil.a(str2, (BitmapFactory.Options)localObject2);
          localObject1 = localObject2;
          d.put(str2, new WeakReference(localObject2));
        }
        catch (Exception localException2)
        {
          paramString = (String)localObject1;
          localObject1 = localException2;
        }
        QLog.e("ExtendFriendFeedView", 1, "getRandomFeedBackground fail.", localException1);
      }
      catch (Exception localException1)
      {
        paramString = (String)localObject2;
      }
      String str1 = paramString;
      return str1;
      label244:
      int n = -1;
    }
    return localObject2;
  }
  
  private GradientDrawable a(int paramInt)
  {
    Object localObject = b;
    paramInt = localObject[(paramInt % localObject.length)];
    localObject = this.k;
    if (localObject == null)
    {
      float f1 = this.j;
      this.k = GradientDrawableUtils.a(paramInt, 0.0F, 0.0F, f1, f1);
    }
    else
    {
      ((GradientDrawable)localObject).setColor(paramInt);
    }
    return this.k;
  }
  
  private void a()
  {
    if (this.g == null)
    {
      this.g = new Paint(1);
      this.g.setStyle(Paint.Style.FILL);
      this.g.setAntiAlias(true);
    }
    if ((this.e > 0) && (this.f > 0))
    {
      Object localObject = this.h;
      if ((localObject == null) || (((Bitmap)localObject).isRecycled()))
      {
        if (c == null)
        {
          c = Bitmap.createBitmap(10, 10, Bitmap.Config.RGB_565);
          new Canvas(c).drawColor(-1);
        }
        this.h = c;
      }
      int i2 = this.h.getWidth();
      int n = this.h.getHeight();
      int i1 = this.e;
      float f2 = i1;
      float f1 = i2;
      float f3 = f2 / f1;
      i2 = this.f;
      f2 = i2;
      float f4 = n;
      f2 /= f4;
      if (f3 > f2)
      {
        f2 = (f4 * f3 - i2) / 2.0F;
        f1 = 0.0F;
      }
      else
      {
        f1 = (f1 * f2 - i1) / 2.0F;
        f3 = f2;
        f2 = 0.0F;
      }
      localObject = new Matrix();
      ((Matrix)localObject).setScale(f3, f3);
      ((Matrix)localObject).postTranslate(-f1, -f2);
      BitmapShader localBitmapShader = new BitmapShader(this.h, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      localBitmapShader.setLocalMatrix((Matrix)localObject);
      this.g.setShader(localBitmapShader);
      if (this.i == null) {
        this.i = new RectF();
      }
      this.i.set(0.0F, this.m, this.e, this.f);
      if (this.k != null)
      {
        n = AIOUtils.b(5.0F, getResources());
        localObject = this.k;
        i1 = this.f;
        ((GradientDrawable)localObject).setBounds(0, i1 - n, this.e, i1);
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    Object localObject = this.i;
    if (localObject != null)
    {
      Paint localPaint = this.g;
      if (localPaint != null)
      {
        float f1 = this.j;
        paramCanvas.drawRoundRect((RectF)localObject, f1, f1, localPaint);
      }
    }
    localObject = this.k;
    if (localObject != null) {
      ((GradientDrawable)localObject).draw(paramCanvas);
    }
    super.dispatchDraw(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.e = paramInt1;
    this.f = paramInt2;
    a();
    invalidate();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int n = paramMotionEvent.getAction();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (n != 0) {
      if (n != 1)
      {
        bool1 = bool2;
        if (n == 2) {}
      }
      else
      {
        bool1 = false;
      }
    }
    if (this.l != bool1)
    {
      this.l = bool1;
      if (bool1) {
        this.g.setColorFilter(a);
      } else {
        this.g.setColorFilter(null);
      }
      invalidate();
    }
    return false;
  }
  
  public void setFeedBgParams(int paramInt1, String paramString, int paramInt2)
  {
    setFeedBgParams(paramInt1, paramString, paramInt2, true);
  }
  
  public void setFeedBgParams(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    this.m = paramInt2;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFeedBgParams feedPosition:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" itemPaddingTop:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("  getPaddingTop:");
      localStringBuilder.append(getPaddingTop());
      QLog.d("ExtendFriendFeedView", 0, localStringBuilder.toString());
    }
    setPadding(getPaddingLeft(), paramInt2, getPaddingRight(), getPaddingBottom());
    this.h = a(paramString);
    if (paramBoolean) {
      this.k = a(paramInt1);
    } else {
      this.k = null;
    }
    a();
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.ExtendFriendFeedView
 * JD-Core Version:    0.7.0.1
 */