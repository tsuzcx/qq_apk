package com.tencent.mobileqq.gallery.view;

import agqq;
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
import aqmb;
import aqmi;
import aqng;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class GalleryUrlImageView
  extends GalleryBaseAdapter.URLImageView2
{
  private int jdField_a_of_type_Int;
  private aqmb jdField_a_of_type_Aqmb;
  public aqmi a;
  private boolean b;
  
  public GalleryUrlImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GalleryUrlImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public Bitmap a(Rect paramRect, Matrix paramMatrix, int paramInt1, int paramInt2)
  {
    Object localObject = new Rect(0, 0, paramInt1, paramInt2);
    ((Rect)localObject).offset(-paramRect.left, -paramRect.top);
    localObject = new RectF((Rect)localObject);
    Matrix localMatrix = new Matrix();
    paramMatrix.invert(localMatrix);
    paramMatrix = new RectF();
    localMatrix.mapRect(paramMatrix, (RectF)localObject);
    paramMatrix.intersect(0.0F, 0.0F, paramRect.width(), paramRect.height());
    if (QLog.isColorLevel()) {
      QLog.i("getRegionBmp", 2, String.format("getRegionBmp dstScreenRectFInImg=%s rawImgRect=%s", new Object[] { paramMatrix, paramRect }));
    }
    float f = paramMatrix.width() / paramMatrix.height();
    int j = (int)(paramInt1 / f);
    int k = agqq.a(1280, 1280, paramInt1, j);
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
  
  public boolean a()
  {
    return this.b;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public Drawable getDrawable()
  {
    return super.getDrawable();
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFialed(paramURLDrawable, paramThrowable);
    paramURLDrawable = paramURLDrawable.getURL().getRef();
    if (((paramURLDrawable == null) || (!paramURLDrawable.equals("DISPLAY"))) && (this.jdField_a_of_type_Aqmb != null)) {
      this.jdField_a_of_type_Aqmb.a(this.jdField_a_of_type_Int, false);
    }
  }
  
  @TargetApi(11)
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    String str = paramURLDrawable.getURL().getRef();
    if ((str != null) && (str.equals("NOSAMPLE")))
    {
      this.jdField_a_of_type_Boolean = true;
      super.onLoadSuccessed(paramURLDrawable);
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Aqmb != null) {
        this.jdField_a_of_type_Aqmb.a(this.jdField_a_of_type_Int, true);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aqmb != null) {
        this.jdField_a_of_type_Aqmb.a(this.jdField_a_of_type_Int, paramURLDrawable);
      }
      return;
      super.onLoadSuccessed(paramURLDrawable);
      if (((str == null) || (!str.equals("DISPLAY"))) && (this.jdField_a_of_type_Aqmb != null)) {
        this.jdField_a_of_type_Aqmb.a(this.jdField_a_of_type_Int, true);
      }
      if (this.jdField_a_of_type_Aqmi != null)
      {
        if (this.jdField_a_of_type_Aqmi.jdField_a_of_type_Int == -2) {
          this.jdField_a_of_type_Aqmi.jdField_a_of_type_Int = paramURLDrawable.getExifOrientation();
        }
        aqng.a(this, paramURLDrawable, this.jdField_a_of_type_Aqmi.jdField_a_of_type_Int);
      }
    }
  }
  
  public void setDecodingDrawble(URLDrawable paramURLDrawable)
  {
    super.setDecodingDrawble(paramURLDrawable);
  }
  
  public void setGalleryImageListener(aqmb paramaqmb)
  {
    this.jdField_a_of_type_Aqmb = paramaqmb;
  }
  
  public void setIgnoreLayout(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setImageInfo(aqmi paramaqmi)
  {
    this.jdField_a_of_type_Aqmi = paramaqmi;
  }
  
  public void setOriginalImage(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setPosition(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.view.GalleryUrlImageView
 * JD-Core Version:    0.7.0.1
 */