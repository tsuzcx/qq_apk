package com.tencent.mobileqq.portal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import auqy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HongbaoCaidanRainView
  extends View
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 1000;
  private long jdField_a_of_type_Long;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private List<auqy> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Random jdField_a_of_type_JavaUtilRandom = new Random(System.currentTimeMillis());
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private List<auqy> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float = 10.0F;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private List<Bitmap> jdField_c_of_type_JavaUtilList = new ArrayList(5);
  private float d = 1.0F;
  private float e;
  
  public HongbaoCaidanRainView(Context paramContext)
  {
    super(paramContext);
  }
  
  public HongbaoCaidanRainView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HongbaoCaidanRainView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_c_of_type_JavaUtilList.size() == 0) {
      return;
    }
    int i = 0;
    label16:
    auqy localauqy;
    float f1;
    float f2;
    if (i < paramInt)
    {
      localauqy = new auqy(null);
      localauqy.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilRandom.nextInt(this.jdField_a_of_type_Int);
      localauqy.jdField_a_of_type_Float = this.jdField_a_of_type_JavaUtilRandom.nextInt(360);
      f1 = this.jdField_a_of_type_JavaUtilRandom.nextFloat();
      f2 = this.jdField_b_of_type_Float;
      if (this.jdField_a_of_type_JavaUtilRandom.nextFloat() <= 0.5D) {
        break label285;
      }
      j = 1;
      label95:
      localauqy.d = (j * (f2 * f1));
      localauqy.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)this.jdField_c_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilRandom.nextInt(this.jdField_c_of_type_JavaUtilList.size())));
      localauqy.e = (this.jdField_b_of_type_Int * 1.0F / localauqy.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * (this.jdField_a_of_type_JavaUtilRandom.nextFloat() * this.jdField_a_of_type_Float + 1.0F));
      localauqy.jdField_c_of_type_Float = (this.jdField_a_of_type_JavaUtilRandom.nextFloat() * this.e + this.jdField_c_of_type_Float);
      f1 = this.jdField_a_of_type_JavaUtilRandom.nextFloat();
      f2 = this.d;
      if (this.jdField_a_of_type_JavaUtilRandom.nextFloat() <= 0.5D) {
        break label291;
      }
    }
    label285:
    label291:
    for (int j = 1;; j = -1)
    {
      localauqy.jdField_b_of_type_Float = (j * (f2 * f1));
      localauqy.jdField_b_of_type_Int = ((int)(-localauqy.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * localauqy.e));
      this.jdField_a_of_type_JavaUtilList.add(localauqy);
      i += 1;
      break label16;
      break;
      j = -1;
      break label95;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = 0;
    if ((this.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    super.onDraw(paramCanvas);
    long l = System.currentTimeMillis();
    if ((l - this.jdField_a_of_type_Long < 1300L) && (l - this.jdField_b_of_type_Long > 40L))
    {
      a(1);
      this.jdField_b_of_type_Long = l;
    }
    float f = (float)((l - this.jdField_c_of_type_Long) * 1.0D / 1000.0D);
    this.jdField_c_of_type_Long = l;
    int k = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    auqy localauqy;
    if (i < k)
    {
      localauqy = (auqy)this.jdField_a_of_type_JavaUtilList.get(i);
      localauqy.jdField_b_of_type_Int = ((int)(localauqy.jdField_b_of_type_Int + localauqy.jdField_c_of_type_Float * f));
      if (localauqy.jdField_b_of_type_Int > this.jdField_c_of_type_Int) {
        this.jdField_b_of_type_JavaUtilList.add(localauqy);
      }
      for (;;)
      {
        i += 1;
        break;
        localauqy.jdField_a_of_type_Int = ((int)(localauqy.jdField_a_of_type_Int + localauqy.jdField_b_of_type_Float * f));
        localauqy.jdField_a_of_type_Float += localauqy.d * f;
      }
    }
    this.jdField_a_of_type_JavaUtilList.removeAll(this.jdField_b_of_type_JavaUtilList);
    this.jdField_b_of_type_JavaUtilList.clear();
    k = this.jdField_a_of_type_JavaUtilList.size();
    i = j;
    if (k == 0)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    while (i < k)
    {
      localauqy = (auqy)this.jdField_a_of_type_JavaUtilList.get(i);
      this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
      this.jdField_a_of_type_AndroidGraphicsMatrix.setTranslate(-localauqy.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / 2, -localauqy.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / 2);
      this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(localauqy.jdField_a_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsMatrix.preScale(localauqy.e, localauqy.e);
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(localauqy.jdField_a_of_type_Int, localauqy.jdField_b_of_type_Int);
      paramCanvas.drawBitmap(localauqy.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, null);
      i += 1;
    }
    invalidate();
  }
  
  public void setPause(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.portal.HongbaoCaidanRainView
 * JD-Core Version:    0.7.0.1
 */