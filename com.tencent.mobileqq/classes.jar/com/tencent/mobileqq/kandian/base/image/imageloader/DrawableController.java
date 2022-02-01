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
  static int a;
  static int b;
  public Drawable c;
  ImageRequest d;
  public ICloseableBitmap e;
  ZImageView f;
  IPublicAccountImageDownListener g;
  private String h = "zimage.DrawableController";
  private boolean i = true;
  
  public DrawableController(Drawable paramDrawable, ZImageView paramZImageView)
  {
    this.c = paramDrawable;
    this.f = paramZImageView;
    paramDrawable = new StringBuilder();
    paramDrawable.append(this.h);
    paramDrawable.append(".v");
    paramDrawable.append(this.f.hashCode());
    this.h = paramDrawable.toString();
  }
  
  private void a(ICloseableBitmap paramICloseableBitmap, boolean paramBoolean)
  {
    ICloseableBitmap localICloseableBitmap = this.e;
    if (localICloseableBitmap != null) {
      localICloseableBitmap.a();
    }
    this.e = paramICloseableBitmap;
    paramICloseableBitmap = new ZBitmapDrawable(this.e.b());
    this.f.setImageDrawable(paramICloseableBitmap, paramBoolean);
  }
  
  private boolean a(ICloseableBitmap paramICloseableBitmap)
  {
    ICloseableBitmap localICloseableBitmap = this.e;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (localICloseableBitmap != null)
    {
      bool1 = bool2;
      if (paramICloseableBitmap != null)
      {
        bool1 = bool2;
        if (localICloseableBitmap.b() == paramICloseableBitmap.b())
        {
          bool1 = bool2;
          if ((this.f.getDrawable() instanceof BitmapDrawable))
          {
            if (((BitmapDrawable)this.f.getDrawable()).getBitmap() != this.e.b()) {
              return true;
            }
            bool1 = false;
          }
        }
      }
    }
    return bool1;
  }
  
  public void a(Drawable paramDrawable)
  {
    this.c = paramDrawable;
    if (this.d != null) {
      a("setPlaceHolder");
    }
    this.f.setImageDrawable(paramDrawable);
  }
  
  public void a(IPublicAccountImageDownListener paramIPublicAccountImageDownListener)
  {
    this.g = paramIPublicAccountImageDownListener;
  }
  
  public void a(ImageRequest paramImageRequest)
  {
    TraceUtils.traceBegin("DrawableController.setImageRequest");
    if (this.f.isRound()) {
      paramImageRequest.g = 1;
    }
    a += 1;
    a("resetUrl");
    ICloseableBitmap localICloseableBitmap = ((IImageManager)QRoute.api(IImageManager.class)).getBitmap(paramImageRequest);
    if (localICloseableBitmap == null)
    {
      this.d = paramImageRequest;
      this.f.setImageDrawable(this.c);
      ((IRIJImageOptMonitor)QRoute.api(IRIJImageOptMonitor.class)).addMonitor(this.d);
      ((IImageManager)QRoute.api(IImageManager.class)).loadImage(this.d, this);
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
    IPublicAccountImageDownListener localIPublicAccountImageDownListener = this.g;
    if (localIPublicAccountImageDownListener != null) {
      localIPublicAccountImageDownListener.a(paramImageRequest.a, paramInt);
    }
  }
  
  public void a(ImageRequest paramImageRequest, ICloseableBitmap paramICloseableBitmap)
  {
    if ((paramImageRequest.equals(this.d)) && (paramICloseableBitmap.b() != null))
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
    this.d = paramImageRequest;
    if (QLog.isColorLevel())
    {
      String str = this.h;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("attachImage ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ");
      localStringBuilder.append(this.d);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramICloseableBitmap);
      localStringBuilder.append(" total:");
      localStringBuilder.append(a);
      localStringBuilder.append(" cache:");
      localStringBuilder.append(b);
      Utils.a(str, localStringBuilder.toString());
    }
    if ((!a()) || (a(paramICloseableBitmap))) {
      a(paramICloseableBitmap, paramBoolean);
    }
    paramString = this.d;
    if (paramString != null)
    {
      paramString.q = 0;
      RIJImageOptReport.a(paramString, true, "attached");
    }
    paramString = this.g;
    if (paramString != null) {
      paramString.a(paramImageRequest.a, paramICloseableBitmap);
    }
  }
  
  public void a(ImageRequest paramImageRequest, Throwable paramThrowable)
  {
    IPublicAccountImageDownListener localIPublicAccountImageDownListener = this.g;
    if (localIPublicAccountImageDownListener != null) {
      localIPublicAccountImageDownListener.a(paramImageRequest.a, paramThrowable);
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = this.d;
    if (localObject != null) {
      ((ImageRequest)localObject).d = true;
    }
    if (QLog.isColorLevel())
    {
      localObject = this.h;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("detachFromWindow ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ");
      localStringBuilder.append(this.d);
      localStringBuilder.append(" ");
      localStringBuilder.append(this.e);
      Utils.a((String)localObject, localStringBuilder.toString());
    }
    if (!a())
    {
      if ((this.i) && (this.f.getDrawable() != null) && ((this.f.getDrawable() instanceof ZBitmapDrawable))) {
        this.f.setImageDrawable(this.c);
      }
      paramString = this.e;
      if (paramString != null)
      {
        paramString.a();
        this.e = null;
      }
    }
    if (this.d != null)
    {
      ((IImageManager)QRoute.api(IImageManager.class)).cancelRequest(this.d, "reset");
      this.d = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  boolean a()
  {
    return (((IRIJImageOptConfig)QRoute.api(IRIJImageOptConfig.class)).isBitmapOpt()) && (Utils.a());
  }
  
  public ImageRequest b()
  {
    return this.d;
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = this.h;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("attachToWindow ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ");
      localStringBuilder.append(this.d);
      Utils.a(str, localStringBuilder.toString());
    }
  }
  
  public IPublicAccountImageDownListener c()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.imageloader.DrawableController
 * JD-Core Version:    0.7.0.1
 */