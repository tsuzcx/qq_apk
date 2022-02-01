package com.tencent.mobileqq.kandian.base.view.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageDownListener;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.RIJImageTypeOptHelper;
import com.tencent.mobileqq.kandian.base.image.imageloader.DrawableController;
import com.tencent.mobileqq.kandian.base.image.imageloader.RIJImageOptReport;
import com.tencent.mobileqq.kandian.base.image.imageloader.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import java.net.URL;

public class ZImageView
  extends ImageView
{
  static int FADE_DURATION = 300;
  private boolean hasSetAlphaBgDrawable;
  private boolean isRound;
  private ValueAnimator mAlphaAnimator;
  private Drawable mBackgroundDrawableTemp;
  public DrawableController mController;
  private URL mUrl;
  private Drawable sColorDrawable = new ColorDrawable(-1);
  private boolean startAplhaOnce;
  private String tag;
  
  public ZImageView(Context paramContext)
  {
    super(paramContext);
    paramContext = new StringBuilder();
    paramContext.append("zimage.ZImageView.v");
    paramContext.append(hashCode());
    this.tag = paramContext.toString();
    this.mBackgroundDrawableTemp = null;
    this.hasSetAlphaBgDrawable = false;
    this.startAplhaOnce = false;
    init();
  }
  
  public ZImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = new StringBuilder();
    paramContext.append("zimage.ZImageView.v");
    paramContext.append(hashCode());
    this.tag = paramContext.toString();
    this.mBackgroundDrawableTemp = null;
    this.hasSetAlphaBgDrawable = false;
    this.startAplhaOnce = false;
    init();
  }
  
  public ZImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new StringBuilder();
    paramContext.append("zimage.ZImageView.v");
    paramContext.append(hashCode());
    this.tag = paramContext.toString();
    this.mBackgroundDrawableTemp = null;
    this.hasSetAlphaBgDrawable = false;
    this.startAplhaOnce = false;
    init();
  }
  
  private void init()
  {
    this.mController = new DrawableController(this.sColorDrawable, this);
    this.mAlphaAnimator = ValueAnimator.ofInt(new int[] { 0, 255 });
    this.mAlphaAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    this.mAlphaAnimator.setDuration(FADE_DURATION);
    this.mAlphaAnimator.addListener(new ZImageView.1(this));
    this.mAlphaAnimator.addUpdateListener(new ZImageView.2(this));
  }
  
  private void resetBgDrawable()
  {
    if (this.hasSetAlphaBgDrawable)
    {
      setBackgroundDrawable(this.mBackgroundDrawableTemp);
      this.hasSetAlphaBgDrawable = false;
      if (QLog.isColorLevel()) {
        Utils.a(this.tag, "cancel alpha bg drawable !");
      }
    }
  }
  
  private void setBgDrawable()
  {
    if ((!this.hasSetAlphaBgDrawable) && (this.mController.a != this.sColorDrawable))
    {
      this.mBackgroundDrawableTemp = getBackground();
      setBackgroundDrawable(this.mController.a);
      this.hasSetAlphaBgDrawable = true;
      if (QLog.isColorLevel()) {
        Utils.a(this.tag, "set alpha bg drawable !");
      }
    }
  }
  
  public void doAlphaAnimationInNextDraw()
  {
    this.startAplhaOnce = true;
    this.mAlphaAnimator.cancel();
  }
  
  @Deprecated
  public boolean isRound()
  {
    return this.isRound;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (QLog.isColorLevel())
    {
      Object localObject = getParent();
      if (localObject != null) {
        localObject = localObject.getClass().getName();
      } else {
        localObject = null;
      }
      String str = this.tag;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAttachedToWindow, parent: ");
      localStringBuilder.append((String)localObject);
      Utils.a(str, localStringBuilder.toString());
    }
    this.mController.b("onAttachedToWindow");
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (QLog.isColorLevel()) {
      Utils.a(this.tag, "onDetachedFromWindow");
    }
    this.mController.a("onDetachedFromWindow");
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mUrl != null)
    {
      if (QLog.isColorLevel()) {
        Utils.a(this.tag, "onDraw dispatch load image");
      }
      ImageRequest localImageRequest = new ImageRequest();
      RIJImageTypeOptHelper.a.a(localImageRequest, this.mUrl.toString());
      localImageRequest.jdField_a_of_type_Int = getWidth();
      localImageRequest.b = getHeight();
      this.mController.a(localImageRequest);
      this.mUrl = null;
    }
    super.onDraw(paramCanvas);
  }
  
  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    if (QLog.isColorLevel()) {
      Utils.a(this.tag, "onFinishTemporaryDetach");
    }
    this.mController.b("onFinishTemporaryDetach");
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    if (QLog.isColorLevel())
    {
      Object localObject = getParent();
      if (localObject != null) {
        localObject = localObject.getClass().getName();
      } else {
        localObject = null;
      }
      String str = this.tag;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStartTemporaryDetach, parent: ");
      localStringBuilder.append((String)localObject);
      Utils.a(str, localStringBuilder.toString());
    }
    this.mController.a("onStartTemporaryDetach");
  }
  
  public ZImageView setImage(URL paramURL)
  {
    TraceUtils.traceBegin("ZImageView.setImage");
    if (paramURL == null)
    {
      TraceUtils.traceEnd();
      return this;
    }
    Object localObject = this.mUrl;
    if ((localObject != null) && (((URL)localObject).getPath().equals(paramURL.getPath()))) {
      QLog.d("ZImageView", 2, "setImage | same");
    }
    this.mUrl = null;
    if (QLog.isColorLevel())
    {
      boolean bool = false;
      if (Build.VERSION.SDK_INT >= 19) {
        bool = isAttachedToWindow();
      }
      localObject = this.tag;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setImage ");
      localStringBuilder.append(paramURL);
      localStringBuilder.append(" width ");
      localStringBuilder.append(getWidth());
      localStringBuilder.append(" isAttach ");
      localStringBuilder.append(bool);
      Utils.a((String)localObject, localStringBuilder.toString());
    }
    if (getWidth() > 0)
    {
      TraceUtils.traceBegin("ZImageView.newImageRequest");
      localObject = new ImageRequest();
      RIJImageTypeOptHelper.a.a((ImageRequest)localObject, paramURL.toString());
      ((ImageRequest)localObject).jdField_a_of_type_Int = getWidth();
      ((ImageRequest)localObject).b = getHeight();
      RIJImageOptReport.a(1, (ImageRequest)localObject);
      this.mController.a((ImageRequest)localObject);
      TraceUtils.traceEnd();
    }
    else
    {
      this.mUrl = paramURL;
    }
    TraceUtils.traceEnd();
    return this;
  }
  
  public void setImageDrawable(@Nullable Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
  }
  
  public void setImageDrawable(Drawable paramDrawable, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mAlphaAnimator.cancel();
      setBgDrawable();
      setImageDrawable(paramDrawable);
      this.mAlphaAnimator.start();
      return;
    }
    setImageDrawable(paramDrawable);
  }
  
  public ZImageView setImageForImageCollection(ImageRequest paramImageRequest, IPublicAccountImageDownListener paramIPublicAccountImageDownListener)
  {
    if (paramImageRequest != null)
    {
      if (paramImageRequest.jdField_a_of_type_JavaNetURL == null) {
        return this;
      }
      RIJImageTypeOptHelper.a.a(paramImageRequest, paramImageRequest.jdField_a_of_type_JavaNetURL.toString());
      if (paramIPublicAccountImageDownListener != null) {
        this.mController.a(paramIPublicAccountImageDownListener);
      }
      this.mUrl = null;
      if (QLog.isColorLevel())
      {
        paramIPublicAccountImageDownListener = this.tag;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setImageForImageCollection url = ");
        localStringBuilder.append(paramImageRequest.jdField_a_of_type_JavaNetURL);
        localStringBuilder.append(" reqWidth = ");
        localStringBuilder.append(paramImageRequest.jdField_a_of_type_Int);
        localStringBuilder.append(" reqHeight = ");
        localStringBuilder.append(paramImageRequest.b);
        QLog.d(paramIPublicAccountImageDownListener, 2, localStringBuilder.toString());
      }
      this.mController.a(paramImageRequest);
    }
    return this;
  }
  
  public ZImageView setImagePlaceHolder(Drawable paramDrawable)
  {
    this.mUrl = null;
    this.mController.a(paramDrawable);
    return this;
  }
  
  public void setPublicAccountImageDownListener(IPublicAccountImageDownListener paramIPublicAccountImageDownListener)
  {
    if (paramIPublicAccountImageDownListener != null) {
      this.mController.a(paramIPublicAccountImageDownListener);
    }
  }
  
  @Deprecated
  public void setRound(boolean paramBoolean)
  {
    this.isRound = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ZImageView
 * JD-Core Version:    0.7.0.1
 */