package com.tencent.viola.ui.view.image;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.component.image.ImageCacheManager.ImageCacheKey;
import com.tencent.viola.ui.component.image.VImage2;
import com.tencent.viola.ui.component.image.VImage2.Measurable;
import com.tencent.viola.ui.dom.Attr;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.Style;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.ui.view.IVView;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import java.lang.ref.WeakReference;

@SuppressLint({"AppCompatCustomView"})
public class VImageView2
  extends ImageView
  implements VImage2.Measurable, IVView<VImage2>
{
  private static final ColorDrawable FAKE_PLACE_HOLDER = new ColorDrawable(0);
  private static final String TAG = "VImageView2";
  private float[] borderRadii = new float[8];
  private float borderRadius;
  private float borderWidth;
  private ImageCacheManager.ImageCacheKey cacheKey;
  private int fadingDuration = 200;
  private boolean isNeedFading = true;
  private boolean mDoAlphaAnim = true;
  WeakReference<VImage2> mImageRef;
  private long mImageStartTs;
  private String mUrl;
  
  public VImageView2(Context paramContext)
  {
    super(paramContext);
  }
  
  private void blurImage(Drawable paramDrawable, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    ImageDrawable.blurImage(paramDrawable, getScaleType(), this.mUrl, paramLayoutParams.width - getPaddingLeft() - getPaddingRight(), paramLayoutParams.height - getPaddingTop() - getPaddingBottom(), paramInt, getScaleRadioForBlur(), new VImageView2.3(this));
  }
  
  private void createRoundImageAndBlur(Drawable paramDrawable, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    ImageDrawable.createRoundImageAndBlur(paramDrawable, getScaleType(), this.mUrl, paramInt, paramLayoutParams.width - getPaddingLeft() - getPaddingRight(), paramLayoutParams.height - getPaddingTop() - getPaddingBottom(), getScaleRadioForBlur(), new VImageView2.5(this));
  }
  
  private void createRoundImageDrawable(Drawable paramDrawable, ViewGroup.LayoutParams paramLayoutParams)
  {
    ImageDrawable.createImageDrawableForRound(paramDrawable, getScaleType(), paramLayoutParams.width - getPaddingLeft() - getPaddingRight(), paramLayoutParams.height - getPaddingTop() - getPaddingBottom(), this.mUrl, new VImageView2.4(this));
  }
  
  private int getScaleRadioForBlur()
  {
    VImage2 localVImage2 = getComponent();
    int i;
    if (localVImage2 != null) {
      i = localVImage2.getScaleRadioForBlur();
    } else {
      i = 7;
    }
    int j = i;
    if (i == 0) {
      j = 1;
    }
    return j;
  }
  
  private boolean hasSetBorderRadius()
  {
    return (isNeedBorderRadius()) || (!isBorderRadiiEmpty());
  }
  
  private boolean isBorderRadiiEmpty()
  {
    float[] arrayOfFloat = this.borderRadii;
    int j = arrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfFloat[i] != 0.0F) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private boolean isDrawableInvalid(Drawable paramDrawable, String paramString)
  {
    if ((paramDrawable != null) && ((paramString == null) || (paramString.equals(this.mUrl)))) {
      return false;
    }
    ViolaLogUtils.d("VImageView2", "not the same drawable");
    return true;
  }
  
  private boolean isNeedBorderRadius()
  {
    return this.borderRadius != 0.0F;
  }
  
  private boolean isNeedFading()
  {
    long l = System.currentTimeMillis() - this.mImageStartTs;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ts: ");
    localStringBuilder.append(l);
    ViolaLogUtils.d("VImageView2", localStringBuilder.toString());
    return (this.mDoAlphaAnim) && (l > 100L) && (this.isNeedFading);
  }
  
  private void resetBorderRadii()
  {
    int i = 0;
    for (;;)
    {
      float[] arrayOfFloat = this.borderRadii;
      if (i >= arrayOfFloat.length) {
        break;
      }
      arrayOfFloat[i] = 0.0F;
      i += 1;
    }
  }
  
  private void setCornerRadius(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof ImageDrawable))
    {
      paramDrawable = (ImageDrawable)paramDrawable;
      if (!isBorderRadiiEmpty())
      {
        paramDrawable.setCornerRadii(this.borderRadii);
        return;
      }
      if (isNeedBorderRadius()) {
        paramDrawable.setCornerRadius(this.borderRadius);
      }
    }
  }
  
  private void setDrawableWithFadingIfNeed(Drawable paramDrawable)
  {
    if (isNeedFading())
    {
      TransitionDrawable localTransitionDrawable = new TransitionDrawable(new Drawable[] { FAKE_PLACE_HOLDER, paramDrawable });
      access$101(this, localTransitionDrawable);
      localTransitionDrawable.startTransition(this.fadingDuration);
    }
    else
    {
      access$201(this, paramDrawable);
    }
    if (getComponent() != null) {
      getComponent().onDrawableLoadFinish(this.mUrl, paramDrawable, this.cacheKey);
    }
  }
  
  private void setImageDirectly(Drawable paramDrawable)
  {
    if (!ImageDrawable.isMainThread())
    {
      ViolaSDKManager.getInstance().postOnUiThread(new VImageView2.1(this, paramDrawable));
      return;
    }
    setDrawableWithFadingIfNeed(paramDrawable);
  }
  
  private void setPaddingForBorderWidth()
  {
    VImage2 localVImage2 = getComponent();
    if (localVImage2 == null) {
      return;
    }
    float f1 = this.borderWidth;
    if (f1 > 0.1F)
    {
      double d = f1;
      Double.isNaN(d);
      f1 = (float)(d / 1.5D);
      Style localStyle = localVImage2.getDomObject().getStyle();
      int i = localVImage2.getDomObject().getViewPortWidth();
      float f2 = localStyle.getPaddingLeft(i);
      float f5 = localStyle.getPaddingTop(i);
      float f4 = localStyle.getPaddingRight(i);
      float f3 = localStyle.getPaddingBottom(i);
      if (!ViolaUtils.isUiThread())
      {
        ViolaSDKManager.getInstance().postOnUiThread(new VImageView2.2(this, f2, f1, f5, f4, f3));
        return;
      }
      if (!Float.isNaN(f2)) {
        f2 += f1;
      } else {
        f2 = f1;
      }
      i = Math.round(f2);
      if (!Float.isNaN(f5)) {
        f2 = f5 + f1;
      } else {
        f2 = f1;
      }
      int j = Math.round(f2);
      if (!Float.isNaN(f4)) {
        f2 = f4 + f1;
      } else {
        f2 = f1;
      }
      int k = Math.round(f2);
      f2 = f1;
      if (!Float.isNaN(f3)) {
        f2 = f1 + f3;
      }
      setPadding(i, j, k, Math.round(f2));
    }
  }
  
  public void bindComponent(VImage2 paramVImage2)
  {
    this.mImageRef = new WeakReference(paramVImage2);
  }
  
  public ImageCacheManager.ImageCacheKey getCacheKey()
  {
    return this.cacheKey;
  }
  
  public VImage2 getComponent()
  {
    WeakReference localWeakReference = this.mImageRef;
    if (localWeakReference != null) {
      return (VImage2)localWeakReference.get();
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
    return getHeight();
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
    return getWidth();
  }
  
  public ImageView.ScaleType getScaleType()
  {
    VImage2 localVImage2 = getComponent();
    if ((localVImage2 != null) && (localVImage2.getDomObject() != null))
    {
      Object localObject = localVImage2.getDomObject().getAttributes().get("resize");
      if (((localObject instanceof String)) && (!TextUtils.isEmpty(localObject.toString()))) {
        return localVImage2.getResizeMode((String)localObject);
      }
      return super.getScaleType();
    }
    return super.getScaleType();
  }
  
  public void initBorderInfo(DomObject paramDomObject)
  {
    if (paramDomObject == null) {
      return;
    }
    Style localStyle = paramDomObject.getStyle();
    int i = paramDomObject.getViewPortWidth();
    float f;
    if (localStyle.containsKey("borderTopLeftRadius"))
    {
      f = FlexConvertUtils.getFloatByViewport(localStyle.get("borderTopLeftRadius"), i);
      paramDomObject = this.borderRadii;
      paramDomObject[0] = f;
      paramDomObject[1] = f;
    }
    if (localStyle.containsKey("borderTopRightRadius"))
    {
      f = FlexConvertUtils.getFloatByViewport(localStyle.get("borderTopRightRadius"), i);
      paramDomObject = this.borderRadii;
      paramDomObject[2] = f;
      paramDomObject[3] = f;
    }
    if (localStyle.containsKey("borderBottomLeftRadius"))
    {
      f = FlexConvertUtils.getFloatByViewport(localStyle.get("borderBottomLeftRadius"), i);
      paramDomObject = this.borderRadii;
      paramDomObject[4] = f;
      paramDomObject[5] = f;
    }
    if (localStyle.containsKey("borderBottomRightRadius"))
    {
      f = FlexConvertUtils.getFloatByViewport(localStyle.get("borderBottomRightRadius"), i);
      paramDomObject = this.borderRadii;
      paramDomObject[6] = f;
      paramDomObject[7] = f;
    }
    if (localStyle.containsKey("borderRadius")) {
      this.borderRadius = FlexConvertUtils.getFloatByViewport(localStyle.get("borderRadius"), i);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (getComponent() != null) {
      getComponent().tryRemoveCache();
    }
  }
  
  public void resetState()
  {
    this.mUrl = null;
    this.borderRadius = 0.0F;
    this.borderWidth = 0.0F;
    this.isNeedFading = true;
    this.fadingDuration = 200;
    resetBorderRadii();
    this.mImageStartTs = 0L;
    this.cacheKey = null;
  }
  
  public void setAlphaAnim(boolean paramBoolean)
  {
    this.mDoAlphaAnim = paramBoolean;
  }
  
  public void setAlphaAnimDuration(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    this.fadingDuration = paramInt;
  }
  
  public void setBorderRadius(float paramFloat)
  {
    this.borderRadius = paramFloat;
  }
  
  public void setBorderWidth(float paramFloat)
  {
    this.borderWidth = paramFloat;
  }
  
  public void setBottomLeftBorderRadius(float paramFloat)
  {
    float[] arrayOfFloat = this.borderRadii;
    arrayOfFloat[6] = paramFloat;
    arrayOfFloat[7] = paramFloat;
  }
  
  public void setBottomRightBorderRadius(float paramFloat)
  {
    float[] arrayOfFloat = this.borderRadii;
    arrayOfFloat[4] = paramFloat;
    arrayOfFloat[5] = paramFloat;
  }
  
  public void setCacheKey(ImageCacheManager.ImageCacheKey paramImageCacheKey)
  {
    if ((this.cacheKey != null) && (getComponent() != null)) {
      getComponent().tryRemoveCache(this.cacheKey);
    }
    this.cacheKey = paramImageCacheKey;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    setImageDrawable(new BitmapDrawable(paramBitmap));
  }
  
  public void setImageDrawable(@Nullable Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      super.setImageDrawable(null);
      return;
    }
    setInternalImageDrawable(paramDrawable);
  }
  
  public void setImageResource(int paramInt)
  {
    setImageDrawable(getResources().getDrawable(paramInt));
  }
  
  public void setImageStartTs(long paramLong)
  {
    this.mImageStartTs = paramLong;
  }
  
  public void setInternalImageDrawable(@Nullable Drawable paramDrawable)
  {
    VImage2 localVImage2 = getComponent();
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if ((localVImage2 != null) && (localVImage2.getDomObject() != null))
    {
      if (localLayoutParams == null) {
        return;
      }
      setPaddingForBorderWidth();
      int k = localVImage2.getBlurRadius();
      int j = 1;
      int i;
      if ((k > 0) && (paramDrawable != null) && (paramDrawable.getIntrinsicWidth() > 0) && (paramDrawable.getIntrinsicHeight() > 0)) {
        i = 1;
      } else {
        i = 0;
      }
      if ((getComponent() == null) || (!getComponent().isGif())) {
        j = 0;
      }
      boolean bool = hasSetBorderRadius();
      if (j != 0)
      {
        setImageDirectly(paramDrawable);
        return;
      }
      if ((i != 0) && (bool))
      {
        createRoundImageAndBlur(paramDrawable, k, localLayoutParams);
        return;
      }
      if (bool)
      {
        createRoundImageDrawable(paramDrawable, localLayoutParams);
        return;
      }
      if (i != 0)
      {
        blurImage(paramDrawable, k, localLayoutParams);
        return;
      }
      setImageDirectly(paramDrawable);
    }
  }
  
  public void setNeedFading(boolean paramBoolean)
  {
    this.isNeedFading = paramBoolean;
  }
  
  public void setTopLeftBorderRadius(float paramFloat)
  {
    float[] arrayOfFloat = this.borderRadii;
    arrayOfFloat[0] = paramFloat;
    arrayOfFloat[1] = paramFloat;
  }
  
  public void setTopRightBorderRadius(float paramFloat)
  {
    float[] arrayOfFloat = this.borderRadii;
    arrayOfFloat[2] = paramFloat;
    arrayOfFloat[3] = paramFloat;
  }
  
  public void setUrl(String paramString)
  {
    this.mUrl = paramString;
  }
  
  public void trySetImage(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    setPaddingForBorderWidth();
    if (getComponent() != null) {
      getComponent().setHasSetPlaceHolder(true);
    }
    super.setImageDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.image.VImageView2
 * JD-Core Version:    0.7.0.1
 */