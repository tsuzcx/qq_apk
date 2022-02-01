package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;

public class CircleBubbleImageView
  extends ChatThumbView
{
  protected int a;
  protected Resources a;
  protected Bitmap a;
  protected BitmapShader a;
  protected Canvas a;
  protected Paint a;
  protected Path a;
  protected int b;
  protected Bitmap b;
  protected Canvas b;
  protected Paint b;
  protected Path b;
  protected int c;
  public boolean c;
  public boolean d = true;
  protected boolean e = false;
  protected boolean f = false;
  
  public CircleBubbleImageView(Context paramContext)
  {
    super(paramContext);
    this.jdField_c_of_type_Int = 1610612736;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidContentResResources = getResources();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_b_of_type_AndroidGraphicsPath = new Path();
  }
  
  private void a(Canvas paramCanvas)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentResResources;
    int i = this.jdField_a_of_type_Int;
    int j = this.jdField_b_of_type_Int;
    j = i / 2;
    Path localPath;
    float f1;
    float f2;
    if (this.jdField_c_of_type_Boolean)
    {
      localPath = this.jdField_a_of_type_AndroidGraphicsPath;
      if (localPath != null)
      {
        localPath.reset();
        localPath.moveTo(i - a(23.0F, (Resources)localObject), a(26.0F, (Resources)localObject));
        f1 = i - a(9.0F, (Resources)localObject);
        f2 = a(23.0F, (Resources)localObject);
        localPath.quadTo(i - a(13.0F, (Resources)localObject), a(28.0F, (Resources)localObject), f1, f2);
        f1 = i - a(19.0F, (Resources)localObject);
        f2 = a(34.0F, (Resources)localObject);
        localPath.quadTo(i - a(10.0F, (Resources)localObject), a(32.0F, (Resources)localObject), f1, f2);
        localPath.close();
        this.jdField_a_of_type_AndroidGraphicsPath = localPath;
      }
    }
    else
    {
      localPath = this.jdField_b_of_type_AndroidGraphicsPath;
      if (localPath != null)
      {
        localPath.reset();
        localPath.moveTo(a(23.0F, (Resources)localObject), a(26.0F, (Resources)localObject));
        f1 = a(9.0F, (Resources)localObject);
        f2 = a(23.0F, (Resources)localObject);
        localPath.quadTo(a(13.0F, (Resources)localObject), a(28.0F, (Resources)localObject), f1, f2);
        f1 = a(19.0F, (Resources)localObject);
        f2 = a(34.0F, (Resources)localObject);
        localPath.quadTo(a(10.0F, (Resources)localObject), a(32.0F, (Resources)localObject), f1, f2);
        localPath.close();
        this.jdField_b_of_type_AndroidGraphicsPath = localPath;
      }
    }
    if (this.jdField_c_of_type_Boolean)
    {
      f1 = j;
      paramCanvas.drawCircle(f1, f1, f1, this.jdField_a_of_type_AndroidGraphicsPaint);
      if (this.d)
      {
        localObject = this.jdField_a_of_type_AndroidGraphicsPath;
        if (localObject != null) {
          paramCanvas.drawPath((Path)localObject, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
      }
    }
    else
    {
      f1 = j;
      paramCanvas.drawCircle(f1, f1, f1, this.jdField_a_of_type_AndroidGraphicsPaint);
      if (this.d)
      {
        localObject = this.jdField_b_of_type_AndroidGraphicsPath;
        if (localObject != null) {
          paramCanvas.drawPath((Path)localObject, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
      }
    }
  }
  
  public int a(float paramFloat, Resources paramResources)
  {
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.jdField_a_of_type_Int = getWidth();
    this.jdField_b_of_type_Int = getHeight();
    int i = this.jdField_a_of_type_Int;
    int j;
    if (i > 0)
    {
      j = this.jdField_b_of_type_Int;
      if ((j > 0) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null)) {}
    }
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    }
    catch (OutOfMemoryError localOutOfMemoryError3)
    {
      try
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, Bitmap.Config.ARGB_4444);
        break label104;
        URLDrawable.clearMemoryCache();
      }
      catch (OutOfMemoryError localOutOfMemoryError3)
      {
        try
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, Bitmap.Config.ARGB_4444);
          label104:
          localObject = this.jdField_a_of_type_AndroidGraphicsCanvas;
          if (localObject != null) {
            ((Canvas)localObject).setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
          }
          localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
          if (localObject == null)
          {
            super.draw(paramCanvas);
            return;
          }
          if (this.jdField_a_of_type_AndroidGraphicsCanvas == null)
          {
            this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas((Bitmap)localObject);
            this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
          }
          if (this.jdField_a_of_type_AndroidGraphicsBitmapShader == null)
          {
            this.jdField_a_of_type_AndroidGraphicsBitmapShader = new BitmapShader(this.jdField_a_of_type_AndroidGraphicsBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            this.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsBitmapShader);
          }
          this.jdField_a_of_type_AndroidGraphicsBitmap.eraseColor(16711680);
          super.draw(this.jdField_a_of_type_AndroidGraphicsCanvas);
          if (this.f) {
            this.jdField_a_of_type_AndroidGraphicsCanvas.drawColor(this.jdField_c_of_type_Int);
          }
          if ((!this.e) || (this.jdField_b_of_type_AndroidGraphicsBitmap != null)) {}
        }
        catch (OutOfMemoryError localOutOfMemoryError3)
        {
          try
          {
            for (;;)
            {
              this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, Bitmap.Config.ARGB_8888);
              label279:
              Object localObject = this.jdField_b_of_type_AndroidGraphicsCanvas;
              if (localObject != null) {
                ((Canvas)localObject).setBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap);
              }
              if (this.e)
              {
                localObject = this.jdField_b_of_type_AndroidGraphicsBitmap;
                if (localObject != null)
                {
                  if (this.jdField_b_of_type_AndroidGraphicsCanvas == null) {
                    this.jdField_b_of_type_AndroidGraphicsCanvas = new Canvas((Bitmap)localObject);
                  }
                  this.jdField_b_of_type_AndroidGraphicsBitmap.eraseColor(0);
                  a(this.jdField_b_of_type_AndroidGraphicsCanvas);
                  paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_b_of_type_AndroidGraphicsPaint);
                  return;
                }
              }
              a(paramCanvas);
              return;
              super.draw(paramCanvas);
              return;
              localOutOfMemoryError1 = localOutOfMemoryError1;
              continue;
              localOutOfMemoryError2 = localOutOfMemoryError2;
            }
            localOutOfMemoryError3 = localOutOfMemoryError3;
          }
          catch (OutOfMemoryError localOutOfMemoryError4)
          {
            break label279;
          }
        }
      }
    }
  }
  
  public void setColorMask(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    if (paramDrawable == getDrawable()) {
      super.setImageDrawable(null);
    }
    super.setImageDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CircleBubbleImageView
 * JD-Core Version:    0.7.0.1
 */