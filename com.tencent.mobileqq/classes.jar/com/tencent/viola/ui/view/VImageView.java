package com.tencent.viola.ui.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.component.VImage;
import com.tencent.viola.ui.component.VImage.Measurable;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.Style;
import com.tencent.viola.ui.view.image.ImageDrawable;
import java.lang.ref.WeakReference;

public class VImageView
  extends ImageView
  implements VImage.Measurable, IVView<VImage>
{
  public static final String TAG = "VImageView";
  private int blurRadius = 0;
  public float[] borderRadii = new float[8];
  public float borderRadius;
  private float borderWidth;
  private float bottomLeftBorderRadius;
  private float bottomRightBorderRadius;
  protected boolean enableBitmapAutoManage = true;
  private boolean gif;
  protected boolean isBitmapReleased = false;
  private int mAlphaAnimDuration = 300;
  private ValueAnimator mAlphaAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private boolean mIsAnimStart = false;
  private Runnable mRunnable = new VImageView.1(this);
  private String mUrl;
  WeakReference<VImage> mWeakReference;
  private float topLeftBorderRadius;
  private float topRightBorderRadius;
  
  public VImageView(Context paramContext)
  {
    super(paramContext);
    this.mAlphaAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    this.mAlphaAnimator.setDuration(this.mAlphaAnimDuration);
    this.mAlphaAnimator.addListener(new VImageView.2(this));
    this.mAlphaAnimator.addUpdateListener(new VImageView.3(this));
  }
  
  private void doFastBlur(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    ViolaSDKManager.getInstance().postOnThreadPool(new VImageView.4(this, paramDrawable, paramInt1, paramInt2));
  }
  
  private boolean hasSetBorderRadius()
  {
    if (getComponent() != null) {
      return getComponent().isSetBorderRadius();
    }
    return false;
  }
  
  public void autoRecoverImage()
  {
    if (this.blurRadius > 0) {
      this.mHandler.removeCallbacks(this.mRunnable);
    }
    if ((this.enableBitmapAutoManage) && (this.isBitmapReleased))
    {
      VImage localVImage = getComponent();
      if (localVImage != null) {
        localVImage.autoRecoverImage();
      }
      this.isBitmapReleased = false;
    }
  }
  
  public void autoReleaseImage()
  {
    if (this.blurRadius > 0)
    {
      this.mHandler.postDelayed(this.mRunnable, 5000L);
      return;
    }
    if ((this.enableBitmapAutoManage) && (!this.isBitmapReleased))
    {
      this.isBitmapReleased = true;
      VImage localVImage = getComponent();
      if (localVImage != null) {
        localVImage.autoReleaseImage();
      }
    }
  }
  
  public void bindComponent(VImage paramVImage)
  {
    this.mWeakReference = new WeakReference(paramVImage);
  }
  
  public void callSuperOnAttachWindow()
  {
    super.onAttachedToWindow();
  }
  
  public void callSuperOnWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
  }
  
  public void dispatchWindowVisibilityChanged(int paramInt)
  {
    super.dispatchWindowVisibilityChanged(paramInt);
  }
  
  public VImage getComponent()
  {
    WeakReference localWeakReference = this.mWeakReference;
    if (localWeakReference != null) {
      return (VImage)localWeakReference.get();
    }
    return null;
  }
  
  public int getNaturalHeight()
  {
    Object localObject = getDrawable();
    if (localObject != null)
    {
      if ((localObject instanceof ImageDrawable)) {
        return ((ImageDrawable)localObject).getBitmapHeight();
      }
      if ((localObject instanceof BitmapDrawable))
      {
        localObject = ((BitmapDrawable)localObject).getBitmap();
        if (localObject != null) {
          return ((Bitmap)localObject).getHeight();
        }
      }
    }
    return -1;
  }
  
  public int getNaturalWidth()
  {
    Object localObject = getDrawable();
    if (localObject != null)
    {
      if ((localObject instanceof ImageDrawable)) {
        return ((ImageDrawable)localObject).getBitmapWidth();
      }
      if ((localObject instanceof BitmapDrawable))
      {
        localObject = ((BitmapDrawable)localObject).getBitmap();
        if (localObject != null) {
          return ((Bitmap)localObject).getWidth();
        }
      }
    }
    return -1;
  }
  
  public boolean isBitmapRecycled()
  {
    Bitmap localBitmap;
    if ((getDrawable() instanceof ImageDrawable)) {
      localBitmap = ((ImageDrawable)getDrawable()).getBitmap();
    } else if ((getDrawable() instanceof BitmapDrawable)) {
      localBitmap = ((BitmapDrawable)getDrawable()).getBitmap();
    } else {
      localBitmap = null;
    }
    return (localBitmap != null) && (localBitmap.isRecycled());
  }
  
  protected void onAttachedToWindow()
  {
    if (isBitmapRecycled())
    {
      this.isBitmapReleased = true;
      autoRecoverImage();
    }
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    if (paramInt == 0)
    {
      if (isBitmapRecycled())
      {
        this.isBitmapReleased = true;
        autoRecoverImage();
      }
      autoRecoverImage();
      return;
    }
    autoReleaseImage();
  }
  
  public void reset()
  {
    this.isBitmapReleased = false;
    this.enableBitmapAutoManage = true;
    this.mUrl = null;
  }
  
  public void setAlphaAnimDuration(int paramInt)
  {
    this.mAlphaAnimDuration = paramInt;
    this.mAlphaAnimator.setDuration(this.mAlphaAnimDuration);
  }
  
  public void setBlurRadius(int paramInt)
  {
    this.blurRadius = paramInt;
  }
  
  public void setBorderRadius(@NonNull float paramFloat)
  {
    this.borderRadius = paramFloat;
  }
  
  public void setBorderWidth(@NonNull float paramFloat)
  {
    this.borderWidth = paramFloat;
  }
  
  public void setBottomLeftBorderRadius(@NonNull float paramFloat)
  {
    this.bottomLeftBorderRadius = paramFloat;
    float[] arrayOfFloat = this.borderRadii;
    paramFloat = this.bottomLeftBorderRadius;
    arrayOfFloat[6] = paramFloat;
    arrayOfFloat[7] = paramFloat;
  }
  
  public void setBottomRightBorderRadius(@NonNull float paramFloat)
  {
    this.bottomRightBorderRadius = paramFloat;
    float[] arrayOfFloat = this.borderRadii;
    paramFloat = this.bottomRightBorderRadius;
    arrayOfFloat[4] = paramFloat;
    arrayOfFloat[5] = paramFloat;
  }
  
  public void setEnableBitmapAutoManage(boolean paramBoolean)
  {
    this.enableBitmapAutoManage = paramBoolean;
  }
  
  public void setImageBitmap(@Nullable Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      setImageDrawable(new BitmapDrawable(getResources(), paramBitmap));
      return;
    }
    setImageDrawable(null);
  }
  
  public void setImageDrawable(@Nullable Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      access$101(this, null);
      return;
    }
    setImageDrawable(paramDrawable, false);
  }
  
  public void setImageDrawable(@Nullable Drawable paramDrawable, boolean paramBoolean)
  {
    this.gif = paramBoolean;
    float f1;
    if (getLayoutParams() != null)
    {
      f1 = this.borderWidth;
      if (f1 > 0.1F)
      {
        double d = f1;
        Double.isNaN(d);
        f1 = (float)(d / 1.5D);
      }
    }
    for (;;)
    {
      try
      {
        f2 = getComponent().getDomObject().getStyle().getPaddingLeft(getComponent().getDomObject().getViewPortWidth());
        float f5 = getComponent().getDomObject().getStyle().getPaddingTop(getComponent().getDomObject().getViewPortWidth());
        float f4 = getComponent().getDomObject().getStyle().getPaddingRight(getComponent().getDomObject().getViewPortWidth());
        float f3 = getComponent().getDomObject().getStyle().getPaddingBottom(getComponent().getDomObject().getViewPortWidth());
        if (!Float.isNaN(f2))
        {
          f2 += f1;
          int i = Math.round(f2);
          if (Float.isNaN(f5)) {
            break label263;
          }
          f2 = f5 + f1;
          int j = Math.round(f2);
          if (Float.isNaN(f4)) {
            break label270;
          }
          f2 = f4 + f1;
          int k = Math.round(f2);
          f2 = f1;
          if (!Float.isNaN(f3)) {
            f2 = f1 + f3;
          }
          setPadding(i, j, k, Math.round(f2));
          return;
        }
      }
      catch (Exception paramDrawable)
      {
        return;
      }
      float f2 = f1;
      continue;
      label263:
      f2 = f1;
      continue;
      label270:
      f2 = f1;
    }
  }
  
  public void setImageResource(int paramInt)
  {
    setImageDrawable(getResources().getDrawable(paramInt));
  }
  
  public void setTopLeftBorderRadius(@NonNull float paramFloat)
  {
    this.topLeftBorderRadius = paramFloat;
    float[] arrayOfFloat = this.borderRadii;
    paramFloat = this.topLeftBorderRadius;
    arrayOfFloat[0] = paramFloat;
    arrayOfFloat[1] = paramFloat;
  }
  
  public void setTopRightBorderRadius(@NonNull float paramFloat)
  {
    this.topRightBorderRadius = paramFloat;
    float[] arrayOfFloat = this.borderRadii;
    paramFloat = this.topRightBorderRadius;
    arrayOfFloat[2] = paramFloat;
    arrayOfFloat[3] = paramFloat;
  }
  
  public void setUrl(String paramString)
  {
    this.mUrl = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.VImageView
 * JD-Core Version:    0.7.0.1
 */