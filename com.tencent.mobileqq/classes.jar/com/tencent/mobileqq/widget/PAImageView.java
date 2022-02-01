package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.tencent.image.URLDrawable;
import com.tencent.util.VersionUtils;

public class PAImageView
  extends AnyScaleTypeImageView
{
  float jdField_a_of_type_Float = 10.0F;
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private BitmapShader jdField_a_of_type_AndroidGraphicsBitmapShader;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  Path jdField_a_of_type_AndroidGraphicsPath;
  RectF jdField_a_of_type_AndroidGraphicsRectF;
  private boolean jdField_a_of_type_Boolean = false;
  float[] jdField_a_of_type_ArrayOfFloat;
  private int b;
  private int jdField_c_of_type_Int;
  private Paint jdField_c_of_type_AndroidGraphicsPaint;
  
  public PAImageView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public PAImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PAImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    f();
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, paramFloat1, paramFloat2);
    this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_ArrayOfFloat, Path.Direction.CW);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      super.draw(paramCanvas);
      return;
    }
    this.jdField_a_of_type_Int = getWidth();
    this.b = getHeight();
    if ((this.jdField_a_of_type_Int > 0) && (this.b > 0))
    {
      i = this.jdField_c_of_type_Int;
      if (i == 1)
      {
        i = paramCanvas.getSaveCount();
        paramCanvas.save();
        super.draw(paramCanvas);
        paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
        paramCanvas.restoreToCount(i);
        return;
      }
      if (i == 2)
      {
        localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
        if ((localObject != null) && ((((Bitmap)localObject).getWidth() != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() != this.b)))
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = null;
          this.jdField_a_of_type_AndroidGraphicsBitmapShader = null;
        }
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {}
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_Int, this.b, Bitmap.Config.RGB_565);
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      label169:
      label190:
      label214:
      break label169;
    }
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_Int, this.b, Bitmap.Config.RGB_565);
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      break label190;
    }
    URLDrawable.clearMemoryCache();
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_Int, this.b, Bitmap.Config.RGB_565);
    }
    catch (OutOfMemoryError localOutOfMemoryError3)
    {
      float f;
      break label214;
    }
    Object localObject = this.jdField_a_of_type_AndroidGraphicsCanvas;
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
      this.jdField_c_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsBitmapShader);
    }
    super.draw(this.jdField_a_of_type_AndroidGraphicsCanvas);
    localObject = new RectF(0.0F, 0.0F, this.jdField_a_of_type_Int, this.b + this.jdField_a_of_type_Float * 2.0F);
    int i = paramCanvas.save();
    f = this.jdField_a_of_type_Float;
    paramCanvas.drawRoundRect((RectF)localObject, f, f, this.jdField_c_of_type_AndroidGraphicsPaint);
    paramCanvas.restoreToCount(i);
    return;
    super.draw(paramCanvas);
  }
  
  @TargetApi(11)
  public void f()
  {
    if (VersionUtils.e()) {
      this.jdField_c_of_type_Int = 2;
    } else {
      this.jdField_c_of_type_Int = 2;
    }
    int i = this.jdField_c_of_type_Int;
    if (i == 1)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        setLayerType(2, null);
      }
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16777216);
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
      this.jdField_a_of_type_ArrayOfFloat = new float[8];
      return;
    }
    if (i == 2)
    {
      this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_c_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (this.jdField_c_of_type_Int == 1)) {
      a(getWidth(), getHeight());
    }
  }
  
  public void setUseRadiusRound(boolean paramBoolean, float paramFloat)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Float = paramFloat;
    float[] arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
    if (arrayOfFloat != null)
    {
      arrayOfFloat[3] = paramFloat;
      arrayOfFloat[2] = paramFloat;
      arrayOfFloat[1] = paramFloat;
      arrayOfFloat[0] = paramFloat;
      arrayOfFloat[7] = 0.0F;
      arrayOfFloat[6] = 0.0F;
      arrayOfFloat[5] = 0.0F;
      arrayOfFloat[4] = 0.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PAImageView
 * JD-Core Version:    0.7.0.1
 */