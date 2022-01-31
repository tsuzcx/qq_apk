package com.tencent.mobileqq.portal;

import agra;
import agrb;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
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
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private Random jdField_a_of_type_JavaUtilRandom = new Random(System.currentTimeMillis());
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float = 10.0F;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private List jdField_c_of_type_JavaUtilList = new ArrayList(5);
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
    agrb localagrb;
    float f1;
    float f2;
    if (i < paramInt)
    {
      localagrb = new agrb(null);
      localagrb.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilRandom.nextInt(this.jdField_a_of_type_Int);
      localagrb.jdField_a_of_type_Float = this.jdField_a_of_type_JavaUtilRandom.nextInt(360);
      f1 = this.jdField_a_of_type_JavaUtilRandom.nextFloat();
      f2 = this.jdField_b_of_type_Float;
      if (this.jdField_a_of_type_JavaUtilRandom.nextFloat() <= 0.5D) {
        break label285;
      }
      j = 1;
      label95:
      localagrb.d = (j * (f2 * f1));
      localagrb.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)this.jdField_c_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilRandom.nextInt(this.jdField_c_of_type_JavaUtilList.size())));
      localagrb.e = (this.jdField_b_of_type_Int * 1.0F / localagrb.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * (this.jdField_a_of_type_JavaUtilRandom.nextFloat() * this.jdField_a_of_type_Float + 1.0F));
      localagrb.jdField_c_of_type_Float = (this.jdField_a_of_type_JavaUtilRandom.nextFloat() * this.e + this.jdField_c_of_type_Float);
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
      localagrb.jdField_b_of_type_Float = (j * (f2 * f1));
      localagrb.jdField_b_of_type_Int = ((int)(-localagrb.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * localagrb.e));
      this.jdField_a_of_type_JavaUtilList.add(localagrb);
      i += 1;
      break label16;
      break;
      j = -1;
      break label95;
    }
  }
  
  @TargetApi(11)
  public void a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt3)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_Float = paramFloat2;
    this.jdField_c_of_type_Float = paramFloat3;
    this.e = paramFloat5;
    this.jdField_c_of_type_Int = paramInt3;
    this.d = paramFloat4;
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(2, null);
    }
  }
  
  public void a(String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HongbaoCaidanRainView", 2, "start(), paths=" + paramVarArgs);
    }
    ThreadManager.postImmediately(new agra(this, paramVarArgs), null, true);
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
    agrb localagrb;
    if (i < k)
    {
      localagrb = (agrb)this.jdField_a_of_type_JavaUtilList.get(i);
      localagrb.jdField_b_of_type_Int = ((int)(localagrb.jdField_b_of_type_Int + localagrb.jdField_c_of_type_Float * f));
      if (localagrb.jdField_b_of_type_Int > this.jdField_c_of_type_Int) {
        this.jdField_b_of_type_JavaUtilList.add(localagrb);
      }
      for (;;)
      {
        i += 1;
        break;
        localagrb.jdField_a_of_type_Int = ((int)(localagrb.jdField_a_of_type_Int + localagrb.jdField_b_of_type_Float * f));
        localagrb.jdField_a_of_type_Float += localagrb.d * f;
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
      localagrb = (agrb)this.jdField_a_of_type_JavaUtilList.get(i);
      this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
      this.jdField_a_of_type_AndroidGraphicsMatrix.setTranslate(-localagrb.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / 2, -localagrb.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / 2);
      this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(localagrb.jdField_a_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsMatrix.preScale(localagrb.e, localagrb.e);
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(localagrb.jdField_a_of_type_Int, localagrb.jdField_b_of_type_Int);
      paramCanvas.drawBitmap(localagrb.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, null);
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