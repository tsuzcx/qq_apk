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
    int i = 7;
    VImage2 localVImage2 = getComponent();
    if (localVImage2 != null) {
      i = localVImage2.getScaleRadioForBlur();
    }
    return i;
  }
  
  private boolean hasSetBorderRadius()
  {
    Object localObject = getComponent();
    if (localObject == null) {}
    Style localStyle;
    do
    {
      do
      {
        return false;
        localObject = ((VComponent)localObject).getDomObject();
      } while (localObject == null);
      localStyle = ((DomObject)localObject).getStyle();
    } while ((!isValidRadius(localStyle, "borderRadius", (DomObject)localObject)) && (!isValidRadius(localStyle, "borderTopLeftRadius", (DomObject)localObject)) && (!isValidRadius(localStyle, "borderTopRightRadius", (DomObject)localObject)) && (!isValidRadius(localStyle, "borderBottomLeftRadius", (DomObject)localObject)) && (!isValidRadius(localStyle, "borderBottomRightRadius", (DomObject)localObject)));
    return true;
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
    if ((paramDrawable == null) || ((paramString != null) && (!paramString.equals(this.mUrl))))
    {
      ViolaLogUtils.d("VImageView2", "not the same drawable");
      return true;
    }
    return false;
  }
  
  private boolean isNeedBorderRadius()
  {
    return this.borderRadius != 0.0F;
  }
  
  private boolean isNeedFading()
  {
    long l = System.currentTimeMillis() - this.mImageStartTs;
    ViolaLogUtils.d("VImageView2", "ts: " + l);
    return (this.mDoAlphaAnim) && (l > 100L) && (this.isNeedFading);
  }
  
  private boolean isValidRadius(Style paramStyle, String paramString, DomObject paramDomObject)
  {
    if ((paramDomObject == null) || (paramStyle == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return false;
      paramStyle = ViolaUtils.getString(paramStyle.get(paramString), null);
    } while ((paramStyle == null) || (FlexConvertUtils.getFloatByViewport(paramStyle, paramDomObject.getViewPortWidth()) <= 0.0F));
    return true;
  }
  
  private void resetBorderRadii()
  {
    int i = 0;
    while (i < this.borderRadii.length)
    {
      this.borderRadii[i] = 0.0F;
      i += 1;
    }
  }
  
  private void setCornerRadius(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof ImageDrawable))
    {
      paramDrawable = (ImageDrawable)paramDrawable;
      if (isBorderRadiiEmpty()) {
        break label28;
      }
      paramDrawable.setCornerRadii(this.borderRadii);
    }
    label28:
    while (!isNeedBorderRadius()) {
      return;
    }
    paramDrawable.setCornerRadius(this.borderRadius);
  }
  
  private void setDrawableWithFadingIfNeed(Drawable paramDrawable)
  {
    if (isNeedFading())
    {
      paramDrawable = new TransitionDrawable(new Drawable[] { FAKE_PLACE_HOLDER, paramDrawable });
      access$101(this, paramDrawable);
      paramDrawable.startTransition(this.fadingDuration);
      return;
    }
    access$201(this, paramDrawable);
  }
  
  private void setImageDirectly(Drawable paramDrawable)
  {
    if (!ImageDrawable.isMainThread())
    {
      ViolaSDKManager.getInstance().postOnUiThread(new VImageView2.2(this, paramDrawable));
      return;
    }
    setDrawableWithFadingIfNeed(paramDrawable);
  }
  
  public void bindComponent(VImage2 paramVImage2)
  {
    this.mImageRef = new WeakReference(paramVImage2);
  }
  
  public VImage2 getComponent()
  {
    if (this.mImageRef != null) {
      return (VImage2)this.mImageRef.get();
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
    if ((localVImage2 == null) || (localVImage2.getDomObject() == null)) {
      return super.getScaleType();
    }
    Object localObject = localVImage2.getDomObject().getAttributes().get("resize");
    if (((localObject instanceof String)) && (!TextUtils.isEmpty(localObject.toString()))) {
      return localVImage2.getResizeMode((String)localObject);
    }
    return super.getScaleType();
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
    this.borderRadii[6] = paramFloat;
    this.borderRadii[7] = paramFloat;
  }
  
  public void setBottomRightBorderRadius(float paramFloat)
  {
    this.borderRadii[4] = paramFloat;
    this.borderRadii[5] = paramFloat;
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
    int j = 1;
    VImage2 localVImage2 = getComponent();
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if ((localVImage2 == null) || (localVImage2.getDomObject() == null) || (localLayoutParams == null)) {
      return;
    }
    float f1;
    int i;
    float f2;
    float f5;
    float f4;
    float f3;
    int k;
    if (this.borderWidth > 0.1F)
    {
      f1 = (float)(this.borderWidth / 1.5D);
      Style localStyle = localVImage2.getDomObject().getStyle();
      i = localVImage2.getDomObject().getViewPortWidth();
      f2 = localStyle.getPaddingLeft(i);
      f5 = localStyle.getPaddingTop(i);
      f4 = localStyle.getPaddingRight(i);
      f3 = localStyle.getPaddingBottom(i);
      if (!ViolaUtils.isUiThread()) {
        ViolaSDKManager.getInstance().postOnUiThread(new VImageView2.1(this, f2, f1, f5, f4, f3));
      }
    }
    else
    {
      k = localVImage2.getBlurRadius();
      if ((k <= 0) || (paramDrawable == null) || (paramDrawable.getIntrinsicWidth() <= 0) || (paramDrawable.getIntrinsicHeight() <= 0)) {
        break label308;
      }
      i = 1;
      label172:
      if ((getComponent() == null) || (!getComponent().isGif())) {
        break label314;
      }
    }
    boolean bool;
    for (;;)
    {
      bool = hasSetBorderRadius();
      if (j == 0) {
        break label320;
      }
      setImageDirectly(paramDrawable);
      return;
      if (!Float.isNaN(f2))
      {
        f2 += f1;
        label217:
        i = Math.round(f2);
        if (Float.isNaN(f5)) {
          break label298;
        }
        f2 = f5 + f1;
        label236:
        k = Math.round(f2);
        if (Float.isNaN(f4)) {
          break label303;
        }
      }
      label298:
      label303:
      for (f2 = f4 + f1;; f2 = f1)
      {
        int m = Math.round(f2);
        f2 = f1;
        if (!Float.isNaN(f3)) {
          f2 = f1 + f3;
        }
        setPadding(i, k, m, Math.round(f2));
        break;
        f2 = f1;
        break label217;
        f2 = f1;
        break label236;
      }
      label308:
      i = 0;
      break label172;
      label314:
      j = 0;
    }
    label320:
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
  
  public void setNeedFading(boolean paramBoolean)
  {
    this.isNeedFading = paramBoolean;
  }
  
  public void setTopLeftBorderRadius(float paramFloat)
  {
    this.borderRadii[0] = paramFloat;
    this.borderRadii[1] = paramFloat;
  }
  
  public void setTopRightBorderRadius(float paramFloat)
  {
    this.borderRadii[2] = paramFloat;
    this.borderRadii[3] = paramFloat;
  }
  
  public void setUrl(String paramString)
  {
    this.mUrl = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.view.image.VImageView2
 * JD-Core Version:    0.7.0.1
 */