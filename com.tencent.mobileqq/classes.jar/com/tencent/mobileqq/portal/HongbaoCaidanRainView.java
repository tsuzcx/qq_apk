package com.tencent.mobileqq.portal;

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
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 1000;
  private long jdField_a_of_type_Long = 0L;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private List<HongbaoCaidanRainView.Node> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Random jdField_a_of_type_JavaUtilRandom = new Random(System.currentTimeMillis());
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = 0.0F;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = 0L;
  private List<HongbaoCaidanRainView.Node> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float = 10.0F;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long = 0L;
  private List<Bitmap> jdField_c_of_type_JavaUtilList = new ArrayList(5);
  private float d = 1.0F;
  private float e = 0.0F;
  
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
    HongbaoCaidanRainView.Node localNode;
    float f1;
    float f2;
    if (i < paramInt)
    {
      localNode = new HongbaoCaidanRainView.Node(null);
      localNode.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilRandom.nextInt(this.jdField_a_of_type_Int);
      localNode.jdField_a_of_type_Float = this.jdField_a_of_type_JavaUtilRandom.nextInt(360);
      f1 = this.jdField_a_of_type_JavaUtilRandom.nextFloat();
      f2 = this.jdField_b_of_type_Float;
      if (this.jdField_a_of_type_JavaUtilRandom.nextFloat() <= 0.5D) {
        break label320;
      }
      j = 1;
      label95:
      localNode.d = (j * (f2 * f1));
      localNode.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)this.jdField_c_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilRandom.nextInt(this.jdField_c_of_type_JavaUtilList.size())));
      if (QLog.isColorLevel()) {
        QLog.d("HongbaoCaidanRainView", 2, "addNode n.bitmap = " + localNode.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      localNode.e = (this.jdField_b_of_type_Int * 1.0F / localNode.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * (this.jdField_a_of_type_JavaUtilRandom.nextFloat() * this.jdField_a_of_type_Float + 1.0F));
      localNode.jdField_c_of_type_Float = (this.jdField_a_of_type_JavaUtilRandom.nextFloat() * this.e + this.jdField_c_of_type_Float);
      f1 = this.jdField_a_of_type_JavaUtilRandom.nextFloat();
      f2 = this.d;
      if (this.jdField_a_of_type_JavaUtilRandom.nextFloat() <= 0.5D) {
        break label326;
      }
    }
    label320:
    label326:
    for (int j = 1;; j = -1)
    {
      localNode.jdField_b_of_type_Float = (j * (f2 * f1));
      localNode.jdField_b_of_type_Int = ((int)(-localNode.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * localNode.e));
      this.jdField_a_of_type_JavaUtilList.add(localNode);
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
  
  public void a(Bitmap... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HongbaoCaidanRainView", 2, "start(), Bitmap=" + paramVarArgs);
    }
    ThreadManager.postImmediately(new HongbaoCaidanRainView.2(this, paramVarArgs), null, true);
  }
  
  public void a(String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HongbaoCaidanRainView", 2, "start(), paths=" + paramVarArgs);
    }
    ThreadManager.postImmediately(new HongbaoCaidanRainView.1(this, paramVarArgs), null, true);
  }
  
  public void onDraw(Canvas paramCanvas)
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
    HongbaoCaidanRainView.Node localNode;
    if (i < k)
    {
      localNode = (HongbaoCaidanRainView.Node)this.jdField_a_of_type_JavaUtilList.get(i);
      localNode.jdField_b_of_type_Int = ((int)(localNode.jdField_b_of_type_Int + localNode.jdField_c_of_type_Float * f));
      if (localNode.jdField_b_of_type_Int > this.jdField_c_of_type_Int) {
        this.jdField_b_of_type_JavaUtilList.add(localNode);
      }
      for (;;)
      {
        i += 1;
        break;
        localNode.jdField_a_of_type_Int = ((int)(localNode.jdField_a_of_type_Int + localNode.jdField_b_of_type_Float * f));
        localNode.jdField_a_of_type_Float += localNode.d * f;
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
      localNode = (HongbaoCaidanRainView.Node)this.jdField_a_of_type_JavaUtilList.get(i);
      this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
      this.jdField_a_of_type_AndroidGraphicsMatrix.setTranslate(-localNode.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / 2, -localNode.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / 2);
      this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(localNode.jdField_a_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsMatrix.preScale(localNode.e, localNode.e);
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(localNode.jdField_a_of_type_Int, localNode.jdField_b_of_type_Int);
      paramCanvas.drawBitmap(localNode.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.HongbaoCaidanRainView
 * JD-Core Version:    0.7.0.1
 */