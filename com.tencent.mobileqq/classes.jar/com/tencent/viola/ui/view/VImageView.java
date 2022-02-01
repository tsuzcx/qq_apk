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
    if (this.blurRadius > 0) {}
    VImage localVImage;
    do
    {
      this.mHandler.postDelayed(this.mRunnable, 5000L);
      do
      {
        return;
      } while ((!this.enableBitmapAutoManage) || (this.isBitmapReleased));
      this.isBitmapReleased = true;
      localVImage = getComponent();
    } while (localVImage == null);
    localVImage.autoReleaseImage();
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
    if (this.mWeakReference != null) {
      return (VImage)this.mWeakReference.get();
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
    Bitmap localBitmap = null;
    if ((getDrawable() instanceof ImageDrawable)) {
      localBitmap = ((ImageDrawable)getDrawable()).getBitmap();
    }
    while ((localBitmap != null) && (localBitmap.isRecycled()))
    {
      return true;
      if ((getDrawable() instanceof BitmapDrawable)) {
        localBitmap = ((BitmapDrawable)getDrawable()).getBitmap();
      }
    }
    return false;
  }
  
  public void onAttachedToWindow()
  {
    if (isBitmapRecycled())
    {
      this.isBitmapReleased = true;
      autoRecoverImage();
    }
    super.onAttachedToWindow();
  }
  
  public void onDetachedFromWindow()
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
  
  public void onWindowVisibilityChanged(int paramInt)
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
    this.borderRadii[6] = this.bottomLeftBorderRadius;
    this.borderRadii[7] = this.bottomLeftBorderRadius;
  }
  
  public void setBottomRightBorderRadius(@NonNull float paramFloat)
  {
    this.bottomRightBorderRadius = paramFloat;
    this.borderRadii[4] = this.bottomRightBorderRadius;
    this.borderRadii[5] = this.bottomRightBorderRadius;
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
    if ((getLayoutParams() != null) && (this.borderWidth > 0.1F)) {}
    try
    {
      float f1 = (float)(this.borderWidth / 1.5D);
      float f2 = getComponent().getDomObject().getStyle().getPaddingLeft(getComponent().getDomObject().getViewPortWidth());
      float f5 = getComponent().getDomObject().getStyle().getPaddingTop(getComponent().getDomObject().getViewPortWidth());
      float f4 = getComponent().getDomObject().getStyle().getPaddingRight(getComponent().getDomObject().getViewPortWidth());
      float f3 = getComponent().getDomObject().getStyle().getPaddingBottom(getComponent().getDomObject().getViewPortWidth());
      int i;
      label169:
      int j;
      if (!Float.isNaN(f2))
      {
        f2 += f1;
        i = Math.round(f2);
        if (Float.isNaN(f5)) {
          break label236;
        }
        f2 = f5 + f1;
        j = Math.round(f2);
        if (Float.isNaN(f4)) {
          break label242;
        }
      }
      label236:
      label242:
      for (f2 = f4 + f1;; f2 = f1)
      {
        int k = Math.round(f2);
        f2 = f1;
        if (!Float.isNaN(f3)) {
          f2 = f1 + f3;
        }
        setPadding(i, j, k, Math.round(f2));
        return;
        f2 = f1;
        break;
        f2 = f1;
        break label169;
      }
      return;
    }
    catch (Exception paramDrawable) {}
  }
  
  public void setImageResource(int paramInt)
  {
    setImageDrawable(getResources().getDrawable(paramInt));
  }
  
  public void setTopLeftBorderRadius(@NonNull float paramFloat)
  {
    this.topLeftBorderRadius = paramFloat;
    this.borderRadii[0] = this.topLeftBorderRadius;
    this.borderRadii[1] = this.topLeftBorderRadius;
  }
  
  public void setTopRightBorderRadius(@NonNull float paramFloat)
  {
    this.topRightBorderRadius = paramFloat;
    this.borderRadii[2] = this.topRightBorderRadius;
    this.borderRadii[3] = this.topRightBorderRadius;
  }
  
  public void setUrl(String paramString)
  {
    this.mUrl = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.view.VImageView
 * JD-Core Version:    0.7.0.1
 */