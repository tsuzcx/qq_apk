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
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private Bitmap[] jdField_a_of_type_ArrayOfAndroidGraphicsBitmap;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
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
    int i = 0;
    this.jdField_a_of_type_Int = ((int)getResources().getDimension(2131559575));
    this.jdField_b_of_type_Int = ((int)getResources().getDimension(2131559576));
    this.c = ((int)getResources().getDimension(2131559577));
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { this.jdField_b_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int }, null, null));
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setColor(Color.parseColor("#FC9100"));
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.d = 0;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    if ((Build.VERSION.SDK_INT >= 11) && (Build.VERSION.SDK_INT < 18)) {}
    try
    {
      for (;;)
      {
        this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap = new Bitmap[this.jdField_a_of_type_ArrayOfInt.length];
        while (i < this.jdField_a_of_type_ArrayOfInt.length)
        {
          this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i] = BitmapFactory.decodeResource(getResources(), this.jdField_a_of_type_ArrayOfInt[i]);
          i += 1;
        }
        this.jdField_a_of_type_AndroidGraphicsPath = new Path();
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
    int k;
    int i;
    int m;
    int n;
    int i1;
    int i2;
    Bitmap localBitmap;
    if (this.jdField_b_of_type_Long < this.jdField_a_of_type_Long)
    {
      k = getWidth();
      int j = getHeight();
      i = this.c;
      k -= this.c;
      m = (j - this.jdField_a_of_type_Int) / 2;
      n = (this.jdField_a_of_type_Int + j) / 2;
      i1 = (int)((k - i) * this.jdField_b_of_type_Long / this.jdField_a_of_type_Long) + i;
      this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.setBounds(i1, m, k, n);
      this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.draw(paramCanvas);
      j = this.d;
      i = j;
      if (j >= this.jdField_a_of_type_ArrayOfInt.length) {
        i = j % this.jdField_a_of_type_ArrayOfInt.length;
      }
      j = this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i].getWidth();
      i2 = this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i].getHeight();
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, j, i2);
      if (j > k - i1) {
        break label226;
      }
      localBitmap = this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i];
      this.jdField_a_of_type_AndroidGraphicsRectF.set(i1, m, j + i1, n);
      paramCanvas.drawBitmap(localBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRectF, null);
    }
    for (;;)
    {
      this.d += 1;
      return;
      label226:
      localBitmap = Bitmap.createBitmap(this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i], 0, 0, k - i1, i2, null, false);
      this.jdField_a_of_type_AndroidGraphicsRectF.set(i1, m, k, n);
      if ((Build.VERSION.SDK_INT >= 11) && (Build.VERSION.SDK_INT < 18))
      {
        localBitmap = ImageUtil.b(localBitmap, this.jdField_b_of_type_Int, k - i1, i2);
        this.jdField_a_of_type_AndroidGraphicsRectF.set(i1, m, k, n);
        paramCanvas.drawBitmap(localBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRectF, null);
      }
      else
      {
        this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int, Path.Direction.CW);
        paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath, Region.Op.INTERSECT);
        paramCanvas.drawBitmap(localBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ProgressViewYellow
 * JD-Core Version:    0.7.0.1
 */