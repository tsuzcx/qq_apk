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
    while (i < paramInt)
    {
      HongbaoCaidanRainView.Node localNode = new HongbaoCaidanRainView.Node(null);
      localNode.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilRandom.nextInt(this.jdField_a_of_type_Int);
      localNode.jdField_a_of_type_Float = this.jdField_a_of_type_JavaUtilRandom.nextInt(360);
      float f1 = this.jdField_a_of_type_JavaUtilRandom.nextFloat();
      float f2 = this.jdField_b_of_type_Float;
      double d1 = this.jdField_a_of_type_JavaUtilRandom.nextFloat();
      int k = -1;
      if (d1 > 0.5D) {
        j = 1;
      } else {
        j = -1;
      }
      localNode.d = (f1 * f2 * j);
      Object localObject = this.jdField_c_of_type_JavaUtilList;
      localNode.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)((List)localObject).get(this.jdField_a_of_type_JavaUtilRandom.nextInt(((List)localObject).size())));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("addNode n.bitmap = ");
        ((StringBuilder)localObject).append(localNode.jdField_a_of_type_AndroidGraphicsBitmap);
        QLog.d("HongbaoCaidanRainView", 2, ((StringBuilder)localObject).toString());
      }
      localNode.e = (this.jdField_b_of_type_Int * 1.0F / localNode.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * (this.jdField_a_of_type_JavaUtilRandom.nextFloat() * this.jdField_a_of_type_Float + 1.0F));
      localNode.jdField_c_of_type_Float = (this.jdField_a_of_type_JavaUtilRandom.nextFloat() * this.e + this.jdField_c_of_type_Float);
      f1 = this.jdField_a_of_type_JavaUtilRandom.nextFloat();
      f2 = this.d;
      int j = k;
      if (this.jdField_a_of_type_JavaUtilRandom.nextFloat() > 0.5D) {
        j = 1;
      }
      localNode.jdField_b_of_type_Float = (f1 * f2 * j);
      localNode.jdField_b_of_type_Int = ((int)(-localNode.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * localNode.e));
      this.jdField_a_of_type_JavaUtilList.add(localNode);
      i += 1;
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start(), Bitmap=");
      localStringBuilder.append(paramVarArgs);
      QLog.d("HongbaoCaidanRainView", 2, localStringBuilder.toString());
    }
    ThreadManager.postImmediately(new HongbaoCaidanRainView.2(this, paramVarArgs), null, true);
  }
  
  public void a(String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start(), paths=");
      localStringBuilder.append(paramVarArgs);
      QLog.d("HongbaoCaidanRainView", 2, localStringBuilder.toString());
    }
    ThreadManager.postImmediately(new HongbaoCaidanRainView.1(this, paramVarArgs), null, true);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      if (!this.jdField_a_of_type_Boolean) {
        return;
      }
      super.onDraw(paramCanvas);
      long l = System.currentTimeMillis();
      if ((l - this.jdField_a_of_type_Long < 1300L) && (l - this.jdField_b_of_type_Long > 40L))
      {
        a(1);
        this.jdField_b_of_type_Long = l;
      }
      double d1 = l - this.jdField_c_of_type_Long;
      Double.isNaN(d1);
      float f = (float)(d1 * 1.0D / 1000.0D);
      this.jdField_c_of_type_Long = l;
      int k = this.jdField_a_of_type_JavaUtilList.size();
      int j = 0;
      int i = 0;
      HongbaoCaidanRainView.Node localNode;
      while (i < k)
      {
        localNode = (HongbaoCaidanRainView.Node)this.jdField_a_of_type_JavaUtilList.get(i);
        localNode.jdField_b_of_type_Int = ((int)(localNode.jdField_b_of_type_Int + localNode.jdField_c_of_type_Float * f));
        if (localNode.jdField_b_of_type_Int > this.jdField_c_of_type_Int)
        {
          this.jdField_b_of_type_JavaUtilList.add(localNode);
        }
        else
        {
          localNode.jdField_a_of_type_Int = ((int)(localNode.jdField_a_of_type_Int + localNode.jdField_b_of_type_Float * f));
          localNode.jdField_a_of_type_Float += localNode.d * f;
        }
        i += 1;
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
  }
  
  public void setPause(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.portal.HongbaoCaidanRainView
 * JD-Core Version:    0.7.0.1
 */