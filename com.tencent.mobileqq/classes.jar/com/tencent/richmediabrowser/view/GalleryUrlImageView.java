package com.tencent.richmediabrowser.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.image.URLDrawable;
import com.tencent.richmediabrowser.listener.IGalleryImageListener;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import java.net.URL;

public class GalleryUrlImageView
  extends BrowserBaseAdapter.URLImageView2
{
  private IGalleryImageListener imageListener;
  private boolean isOriginalImage = false;
  public RichMediaBrowserInfo mImageInfo;
  private int mPosition;
  
  public GalleryUrlImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GalleryUrlImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static int getInSampleSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = 1;
    int i = paramInt4;
    paramInt4 = paramInt3;
    paramInt3 = j;
    if ((paramInt4 > paramInt2) || (i > paramInt1))
    {
      j = Math.round(paramInt4 / paramInt2);
      int k = Math.round(i / paramInt1);
      if (j > k) {}
      for (;;)
      {
        if (j < 2) {
          return paramInt3;
        }
        i /= 2;
        paramInt4 /= 2;
        paramInt3 *= 2;
        break;
        j = k;
      }
    }
    return paramInt3;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public Drawable getDrawable()
  {
    return super.getDrawable();
  }
  
  public Bitmap getRegionBmp(Rect paramRect, Matrix paramMatrix, int paramInt1, int paramInt2)
  {
    Object localObject = new Rect(0, 0, paramInt1, paramInt2);
    ((Rect)localObject).offset(-paramRect.left, -paramRect.top);
    localObject = new RectF((Rect)localObject);
    Matrix localMatrix = new Matrix();
    paramMatrix.invert(localMatrix);
    paramMatrix = new RectF();
    localMatrix.mapRect(paramMatrix, (RectF)localObject);
    paramMatrix.intersect(0.0F, 0.0F, paramRect.width(), paramRect.height());
    float f = paramMatrix.width() / paramMatrix.height();
    int j = (int)(paramInt1 / f);
    int k = getInSampleSize(1280, 1280, paramInt1, j);
    int i = j;
    paramInt2 = paramInt1;
    if (k > 1)
    {
      paramInt2 = paramInt1 / k;
      i = j / k;
    }
    paramRect = Bitmap.createBitmap(paramInt2, i, Bitmap.Config.ARGB_8888);
    localObject = new Canvas(paramRect);
    localMatrix = new Matrix();
    f = paramInt2 / paramMatrix.width();
    localMatrix.postTranslate(-paramMatrix.left, -paramMatrix.top);
    localMatrix.postScale(f, f);
    ((Canvas)localObject).setMatrix(localMatrix);
    draw((Canvas)localObject);
    return paramRect;
  }
  
  public boolean isOriginalImage()
  {
    return this.isOriginalImage;
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFialed(paramURLDrawable, paramThrowable);
    paramURLDrawable = paramURLDrawable.getURL().getRef();
    if (((paramURLDrawable == null) || (!paramURLDrawable.equals("DISPLAY"))) && (this.imageListener != null)) {
      this.imageListener.onLoadSuccessed(this.mPosition, false);
    }
  }
  
  @TargetApi(11)
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    String str = paramURLDrawable.getURL().getRef();
    if ((str != null) && (str.equals("NOSAMPLE")))
    {
      this.ignoreLayout = true;
      super.onLoadSuccessed(paramURLDrawable);
      this.ignoreLayout = false;
      if (this.imageListener != null) {
        this.imageListener.onLoadSuccessed(this.mPosition, true);
      }
    }
    for (;;)
    {
      if (this.imageListener != null) {
        this.imageListener.onLoadDrawable(this.mPosition, paramURLDrawable);
      }
      return;
      super.onLoadSuccessed(paramURLDrawable);
      if (((str == null) || (!str.equals("DISPLAY"))) && (this.imageListener != null)) {
        this.imageListener.onLoadSuccessed(this.mPosition, true);
      }
      if (this.mImageInfo != null)
      {
        if (this.mImageInfo.orientation == -2) {
          this.mImageInfo.orientation = paramURLDrawable.getExifOrientation();
        }
        BrowserBasePresenter.updateRotation(this, paramURLDrawable, this.mImageInfo.orientation);
      }
    }
  }
  
  public void setDecodingDrawble(URLDrawable paramURLDrawable)
  {
    super.setDecodingDrawble(paramURLDrawable);
  }
  
  public void setGalleryImageListener(IGalleryImageListener paramIGalleryImageListener)
  {
    this.imageListener = paramIGalleryImageListener;
  }
  
  public void setIgnoreLayout(boolean paramBoolean)
  {
    this.ignoreLayout = paramBoolean;
  }
  
  public void setImageInfo(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    this.mImageInfo = paramRichMediaBrowserInfo;
  }
  
  public void setOriginalImage(boolean paramBoolean)
  {
    this.isOriginalImage = paramBoolean;
  }
  
  public void setPosition(int paramInt)
  {
    this.mPosition = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.GalleryUrlImageView
 * JD-Core Version:    0.7.0.1
 */