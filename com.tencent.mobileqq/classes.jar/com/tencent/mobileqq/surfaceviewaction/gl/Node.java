package com.tencent.mobileqq.surfaceviewaction.gl;

import com.tencent.mobileqq.surfaceviewaction.action.Action;
import java.util.ArrayList;
import java.util.List;

public class Node
{
  public float a;
  public Frame a;
  public Layer a;
  protected SpriteGLView a;
  public String a;
  public float b;
  public int b;
  protected List b;
  public boolean b;
  public float c;
  public float d;
  public float e = 1.0F;
  public float f;
  
  public Node()
  {
    this.jdField_b_of_type_Int = 255;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  public float a()
  {
    float f1 = 1.0F;
    for (Layer localLayer = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLayer; localLayer != null; localLayer = localLayer.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLayer) {
      f1 *= localLayer.e;
    }
    return f1;
  }
  
  public Point a()
  {
    float f2 = this.c;
    float f1 = this.d;
    for (Layer localLayer = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLayer; localLayer != null; localLayer = localLayer.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLayer)
    {
      f2 += localLayer.c;
      f1 += localLayer.d;
    }
    return new Point(f2, f1);
  }
  
  public void a(Action... paramVarArgs)
  {
    int i = 0;
    while (i < paramVarArgs.length)
    {
      Action localAction = paramVarArgs[i];
      localAction.a();
      this.jdField_b_of_type_JavaUtilList.add(localAction);
      i += 1;
    }
  }
  
  public void b()
  {
    this.jdField_b_of_type_JavaUtilList.clear();
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    paramInt1 = 0;
    if (paramInt1 < this.jdField_b_of_type_JavaUtilList.size())
    {
      paramArrayOfFloat = (Action)this.jdField_b_of_type_JavaUtilList.get(paramInt1);
      if (paramArrayOfFloat.a())
      {
        if ((paramArrayOfFloat.d & 0x1) != 0)
        {
          this.c = paramArrayOfFloat.jdField_a_of_type_Float;
          this.d = paramArrayOfFloat.jdField_b_of_type_Float;
        }
        if ((paramArrayOfFloat.d & 0x2) != 0) {
          this.e = paramArrayOfFloat.c;
        }
        if ((paramArrayOfFloat.d & 0x4) != 0) {
          this.jdField_b_of_type_Int = paramArrayOfFloat.jdField_a_of_type_Int;
        }
        if ((paramArrayOfFloat.d & 0x8) != 0) {
          this.f = paramArrayOfFloat.jdField_b_of_type_Int;
        }
      }
      paramInt2 = paramInt1;
      if (paramArrayOfFloat.jdField_b_of_type_Boolean)
      {
        if (!paramArrayOfFloat.jdField_a_of_type_Boolean) {
          break label157;
        }
        paramArrayOfFloat.a();
      }
      for (paramInt2 = paramInt1;; paramInt2 = paramInt1 - 1)
      {
        paramInt1 = paramInt2 + 1;
        break;
        label157:
        this.jdField_b_of_type_JavaUtilList.remove(paramInt1);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrame != null) && (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView != null))
    {
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.c() * this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrame.jdField_a_of_type_Int / 1000;
      paramInt1 = paramInt2;
      if (paramInt2 > 0) {
        paramInt1 = paramInt2 - 1;
      }
      if (paramInt1 < this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrame.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlFrame$FrameData.length)
      {
        this.c = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrame.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlFrame$FrameData[paramInt1].jdField_a_of_type_Float;
        this.d = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrame.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlFrame$FrameData[paramInt1].jdField_b_of_type_Float;
      }
    }
  }
  
  public void d()
  {
    int i = 0;
    while (i < this.jdField_b_of_type_JavaUtilList.size())
    {
      ((Action)this.jdField_b_of_type_JavaUtilList.get(i)).c();
      i += 1;
    }
  }
  
  public void e()
  {
    int i = 0;
    while (i < this.jdField_b_of_type_JavaUtilList.size())
    {
      ((Action)this.jdField_b_of_type_JavaUtilList.get(i)).d();
      i += 1;
    }
  }
  
  public int e_()
  {
    float f1 = 1.0F;
    for (Layer localLayer = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLayer; localLayer != null; localLayer = localLayer.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLayer) {
      f1 *= localLayer.jdField_b_of_type_Int / 255.0F;
    }
    return (int)(f1 * 255.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.Node
 * JD-Core Version:    0.7.0.1
 */