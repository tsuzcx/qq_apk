package com.tencent.mobileqq.portal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.utils.ImageUtil;

public class ProgressViewYellow
  extends View
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 10000L;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private ShapeDrawable jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable;
  private int[] jdField_a_of_type_ArrayOfInt = { 2130845364, 2130845365, 2130845366, 2130845367, 2130845368, 2130845369, 2130845370, 2130845371, 2130845372, 2130845373, 2130845374, 2130845375, 2130845376, 2130845377, 2130845378, 2130845379, 2130845380, 2130845381, 2130845382, 2130845383 };
  private Bitmap[] jdField_a_of_type_ArrayOfAndroidGraphicsBitmap = null;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 0L;
  private int c;
  private int d;
  
  public ProgressViewYellow(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ProgressViewYellow(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ProgressViewYellow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Int = ((int)getResources().getDimension(2131298282));
    this.jdField_b_of_type_Int = ((int)getResources().getDimension(2131298284));
    this.c = ((int)getResources().getDimension(2131298283));
    int j = this.jdField_b_of_type_Int;
    float f = j;
    int i = 0;
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { f, j, j, j, j, j, j, j }, null, null));
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setColor(Color.parseColor("#FC7B31"));
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.d = 0;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    if ((Build.VERSION.SDK_INT < 11) || (Build.VERSION.SDK_INT >= 18)) {
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    }
    try
    {
      this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap = new Bitmap[this.jdField_a_of_type_ArrayOfInt.length];
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i] = BitmapFactory.decodeResource(getResources(), this.jdField_a_of_type_ArrayOfInt[i]);
        i += 1;
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Long = paramLong2;
    this.jdField_b_of_type_Long = (paramLong2 - paramLong1);
    postInvalidate();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.jdField_b_of_type_Long < this.jdField_a_of_type_Long)
    {
      int k = getWidth();
      int j = getHeight();
      int i = this.c;
      k -= i;
      int n = this.jdField_a_of_type_Int;
      int m = (j - n) / 2;
      n = (j + n) / 2;
      int i1 = (int)((k - i) * this.jdField_b_of_type_Long / this.jdField_a_of_type_Long) + i;
      this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.setBounds(i1, m, k, n);
      this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.draw(paramCanvas);
      j = this.d;
      Object localObject1 = this.jdField_a_of_type_ArrayOfInt;
      i = j;
      if (j >= localObject1.length) {
        i = j % localObject1.length;
      }
      j = this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i].getWidth();
      int i2 = this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i].getHeight();
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, j, i2);
      int i3 = k - i1;
      if (j <= i3)
      {
        localObject1 = this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i];
        this.jdField_a_of_type_AndroidGraphicsRectF.set(i1, m, i1 + j, n);
        paramCanvas.drawBitmap((Bitmap)localObject1, null, this.jdField_a_of_type_AndroidGraphicsRectF, null);
      }
      else
      {
        localObject1 = Bitmap.createBitmap(this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i], 0, 0, i3, i2, null, false);
        Object localObject2 = this.jdField_a_of_type_AndroidGraphicsRectF;
        float f1 = i1;
        float f2 = m;
        float f3 = k;
        float f4 = n;
        ((RectF)localObject2).set(f1, f2, f3, f4);
        if ((Build.VERSION.SDK_INT >= 11) && (Build.VERSION.SDK_INT < 18))
        {
          localObject1 = ImageUtil.b((Bitmap)localObject1, this.jdField_b_of_type_Int, i3, i2);
          this.jdField_a_of_type_AndroidGraphicsRectF.set(f1, f2, f3, f4);
          paramCanvas.drawBitmap((Bitmap)localObject1, null, this.jdField_a_of_type_AndroidGraphicsRectF, null);
        }
        else
        {
          localObject2 = this.jdField_a_of_type_AndroidGraphicsPath;
          RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
          i = this.jdField_b_of_type_Int;
          ((Path)localObject2).addRoundRect(localRectF, i, i, Path.Direction.CW);
          paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath, Region.Op.INTERSECT);
          paramCanvas.drawBitmap((Bitmap)localObject1, null, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
      }
      this.d += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ProgressViewYellow
 * JD-Core Version:    0.7.0.1
 */