package com.tencent.mobileqq.kandian.biz.pts.view;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ImageCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase;
import com.tencent.mobileqq.kandian.biz.common.widget.NativeReadInjoyImageView;
import com.tencent.mobileqq.kandian.biz.framework.api.IRIJSmartCropUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class ReadInjoyImageView
  extends ImageBase
{
  protected NativeReadInjoyImageView a;
  private Drawable b = new ColorDrawable(Color.parseColor("#E9E9E9"));
  
  public ReadInjoyImageView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = new NativeReadInjoyImageView(paramVafContext.getContext());
  }
  
  private boolean a()
  {
    if (this.mSrc == null) {
      return false;
    }
    int i = this.a.getComMeasuredWidth();
    int j = this.a.getComMeasuredHeight();
    if ((i > 0) && (j > 0))
    {
      this.mSrc = ((IRIJSmartCropUtils)QRoute.api(IRIJSmartCropUtils.class)).getSmartCropURL(this.mSrc, i, j);
      return true;
    }
    return false;
  }
  
  public int getComMeasuredHeight()
  {
    return this.a.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.a.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.a;
  }
  
  public void loadImage(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadImage: path is ");
    localStringBuilder.append(paramString);
    QLog.d("ReadInjoyImageView", 2, localStringBuilder.toString());
    if ((paramString != null) && (!paramString.equals("-1"))) {
      if ((!paramString.startsWith("http")) && (!paramString.startsWith("pubaccount")))
      {
        paramString = ImageCommon.getDrawableResourceId(paramString);
        if (paramString != null) {
          QLog.d("ReadInjoyImageView", 2, "loadImage: cant find in offline dir, try to load from resources");
        }
      }
    }
    try
    {
      paramString = this.a.getResources().getDrawable(paramString.intValue());
      this.a.setImageDrawable(paramString);
      return;
    }
    catch (Resources.NotFoundException paramString)
    {
      label106:
      break label106;
    }
    QLog.d("ReadInjoyImageView", 2, "loadImage: cant find in resources dir, do nothing");
    return;
    this.a.setImageSrc("");
    this.a.setImagePlaceHolder(this.b);
    return;
    this.a.setImagePlaceHolder(this.b);
    if (a()) {
      this.a.setImageSrc(paramString);
    }
  }
  
  protected void onComDraw(Canvas paramCanvas)
  {
    if ((this.mSrc != null) && (!this.mSrc.equals(this.a.getPath())))
    {
      a();
      this.a.setImageSrc(this.mSrc);
    }
    super.onComDraw(paramCanvas);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.a.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.a.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    this.a.setScaleType((ImageView.ScaleType)ImageBase.IMAGE_SCALE_TYPE.get(this.mScaleType, ImageView.ScaleType.CENTER_CROP));
    this.a.setCorner(this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
    loadImage(this.mSrc);
    refresh();
  }
  
  public void reset()
  {
    super.reset();
    this.a.setImageSrc(null);
    this.mSrc = null;
  }
  
  public void setBitmap(Bitmap paramBitmap, boolean paramBoolean)
  {
    this.a.setImageBitmap(paramBitmap);
  }
  
  public void setImageDrawable(Drawable paramDrawable, boolean paramBoolean)
  {
    this.a.setImageDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyImageView
 * JD-Core Version:    0.7.0.1
 */