package com.tencent.mobileqq.kandian.base.image.imageloader;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageDownListener;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.api.IBitmapCallback;
import com.tencent.mobileqq.kandian.base.image.api.ICloseableBitmap;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig;
import com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptMonitor;
import com.tencent.mobileqq.kandian.base.view.widget.ZImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;

public class DrawableController
  implements IBitmapCallback
{
  static int jdField_a_of_type_Int;
  static int b;
  public Drawable a;
  IPublicAccountImageDownListener jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageDownListener;
  ImageRequest jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest;
  public ICloseableBitmap a;
  ZImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetZImageView;
  private String jdField_a_of_type_JavaLangString = "zimage.DrawableController";
  private boolean jdField_a_of_type_Boolean = true;
  
  public DrawableController(Drawable paramDrawable, ZImageView paramZImageView)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetZImageView = paramZImageView;
    paramDrawable = new StringBuilder();
    paramDrawable.append(this.jdField_a_of_type_JavaLangString);
    paramDrawable.append(".v");
    paramDrawable.append(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetZImageView.hashCode());
    this.jdField_a_of_type_JavaLangString = paramDrawable.toString();
  }
  
  private void a(ICloseableBitmap paramICloseableBitmap, boolean paramBoolean)
  {
    ICloseableBitmap localICloseableBitmap = this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageApiICloseableBitmap;
    if (localICloseableBitmap != null) {
      localICloseableBitmap.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageApiICloseableBitmap = paramICloseableBitmap;
    paramICloseableBitmap = new ZBitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageApiICloseableBitmap.a());
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetZImageView.setImageDrawable(paramICloseableBitmap, paramBoolean);
  }
  
  private boolean a(ICloseableBitmap paramICloseableBitmap)
  {
    ICloseableBitmap localICloseableBitmap = this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageApiICloseableBitmap;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (localICloseableBitmap != null)
    {
      bool1 = bool2;
      if (paramICloseableBitmap != null)
      {
        bool1 = bool2;
        if (localICloseableBitmap.a() == paramICloseableBitmap.a())
        {
          bool1 = bool2;
          if ((this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetZImageView.getDrawable() instanceof BitmapDrawable))
          {
            if (((BitmapDrawable)this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetZImageView.getDrawable()).getBitmap() != this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageApiICloseableBitmap.a()) {
              return true;
            }
            bool1 = false;
          }
        }
      }
    }
    return bool1;
  }
  
  public ImageRequest a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest;
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest != null) {
      a("setPlaceHolder");
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetZImageView.setImageDrawable(paramDrawable);
  }
  
  public void a(IPublicAccountImageDownListener paramIPublicAccountImageDownListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageDownListener = paramIPublicAccountImageDownListener;
  }
  
  public void a(ImageRequest paramImageRequest)
  {
    TraceUtils.traceBegin("DrawableController.setImageRequest");
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetZImageView.isRound()) {
      paramImageRequest.c = 1;
    }
    jdField_a_of_type_Int += 1;
    a("resetUrl");
    ICloseableBitmap localICloseableBitmap = ((IImageManager)QRoute.api(IImageManager.class)).getBitmap(paramImageRequest);
    if (localICloseableBitmap == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest = paramImageRequest;
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetZImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      ((IRIJImageOptMonitor)QRoute.api(IRIJImageOptMonitor.class)).addMonitor(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest);
      ((IImageManager)QRoute.api(IImageManager.class)).loadImage(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest, this);
    }
    else
    {
      b += 1;
      RIJImageOptReport.b(1, paramImageRequest);
      a(paramImageRequest, localICloseableBitmap, false, "setImageRequest");
    }
    TraceUtils.traceEnd();
  }
  
  public void a(ImageRequest paramImageRequest, int paramInt)
  {
    IPublicAccountImageDownListener localIPublicAccountImageDownListener = this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageDownListener;
    if (localIPublicAccountImageDownListener != null) {
      localIPublicAccountImageDownListener.a(paramImageRequest.jdField_a_of_type_JavaNetURL, paramInt);
    }
  }
  
  public void a(ImageRequest paramImageRequest, ICloseableBitmap paramICloseableBitmap)
  {
    if ((paramImageRequest.equals(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest)) && (paramICloseableBitmap.a() != null))
    {
      if ((paramICloseableBitmap instanceof CloseableBitmap))
      {
        a(paramImageRequest, (CloseableBitmap)paramICloseableBitmap, true, "onSuccess");
        return;
      }
      QLog.e("zimage.DrawableController", 1, "onSuccess error for bitmap is not CloseableBitmap");
      return;
    }
    paramICloseableBitmap.a();
  }
  
  void a(ImageRequest paramImageRequest, ICloseableBitmap paramICloseableBitmap, boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest = paramImageRequest;
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("attachImage ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramICloseableBitmap);
      localStringBuilder.append(" total:");
      localStringBuilder.append(jdField_a_of_type_Int);
      localStringBuilder.append(" cache:");
      localStringBuilder.append(b);
      Utils.a(str, localStringBuilder.toString());
    }
    if ((!a()) || (a(paramICloseableBitmap))) {
      a(paramICloseableBitmap, paramBoolean);
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest;
    if (paramString != null)
    {
      paramString.e = 0;
      RIJImageOptReport.a(paramString, true, "attached");
    }
    paramString = this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageDownListener;
    if (paramString != null) {
      paramString.a(paramImageRequest.jdField_a_of_type_JavaNetURL, paramICloseableBitmap);
    }
  }
  
  public void a(ImageRequest paramImageRequest, Throwable paramThrowable)
  {
    IPublicAccountImageDownListener localIPublicAccountImageDownListener = this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageDownListener;
    if (localIPublicAccountImageDownListener != null) {
      localIPublicAccountImageDownListener.a(paramImageRequest.jdField_a_of_type_JavaNetURL, paramThrowable);
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest;
    if (localObject != null) {
      ((ImageRequest)localObject).jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("detachFromWindow ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest);
      localStringBuilder.append(" ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageApiICloseableBitmap);
      Utils.a((String)localObject, localStringBuilder.toString());
    }
    if (!a())
    {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetZImageView.getDrawable() != null) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetZImageView.getDrawable() instanceof ZBitmapDrawable))) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetZImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageApiICloseableBitmap;
      if (paramString != null)
      {
        paramString.a();
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageApiICloseableBitmap = null;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest != null)
    {
      ((IImageManager)QRoute.api(IImageManager.class)).cancelRequest(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest, "reset");
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  boolean a()
  {
    return (((IRIJImageOptConfig)QRoute.api(IRIJImageOptConfig.class)).isBitmapOpt()) && (Utils.a());
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("attachToWindow ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest);
      Utils.a(str, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.imageloader.DrawableController
 * JD-Core Version:    0.7.0.1
 */