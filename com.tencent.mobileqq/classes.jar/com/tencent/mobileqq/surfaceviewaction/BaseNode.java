package com.tencent.mobileqq.surfaceviewaction;

import com.tencent.mobileqq.surfaceviewaction.action.Action;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseNode
{
  public float a;
  public int a;
  public Frame a;
  public ILayer a;
  public String a;
  protected List<Action> a;
  public boolean a;
  public float b;
  public int b;
  public float c;
  public int c;
  public float d;
  public int d;
  public float e;
  protected int e;
  public float f;
  protected int f;
  public float g = 0.0F;
  
  public BaseNode()
  {
    this.jdField_e_of_type_Float = 1.0F;
    this.jdField_f_of_type_Float = 1.0F;
    this.jdField_a_of_type_Int = 255;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public float a()
  {
    return this.jdField_e_of_type_Float;
  }
  
  public abstract ISpriteView a();
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(float paramFloat)
  {
    this.jdField_c_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void a(Frame paramFrame)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrame = paramFrame;
  }
  
  public void a(Point paramPoint)
  {
    float f1 = this.jdField_c_of_type_Float;
    float f2 = this.jdField_d_of_type_Float;
    int i = this.jdField_b_of_type_Int;
    if (i != 1)
    {
      if (i == 2) {
        f1 += this.jdField_e_of_type_Int / this.jdField_f_of_type_Float / 2.0F;
      }
    }
    else {
      f1 = this.jdField_e_of_type_Int / this.jdField_f_of_type_Float - f1;
    }
    i = this.jdField_c_of_type_Int;
    if (i != 0)
    {
      if (i == 2) {
        f2 += this.jdField_f_of_type_Int / this.jdField_f_of_type_Float / 2.0F;
      }
    }
    else {
      f2 = this.jdField_f_of_type_Int / this.jdField_f_of_type_Float - f2;
    }
    for (BaseNode localBaseNode = (BaseNode)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionILayer; localBaseNode != null; localBaseNode = (BaseNode)localBaseNode.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionILayer)
    {
      f1 += localBaseNode.jdField_c_of_type_Float;
      f2 += localBaseNode.jdField_d_of_type_Float;
    }
    paramPoint.jdField_a_of_type_Float = f1;
    paramPoint.jdField_b_of_type_Float = f2;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(Action... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Action localAction = paramVarArgs[i];
      localAction.a();
      this.jdField_a_of_type_JavaUtilList.add(localAction);
      i += 1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public float b()
  {
    BaseNode localBaseNode = (BaseNode)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionILayer;
    float f1 = 1.0F;
    while (localBaseNode != null)
    {
      f1 *= localBaseNode.jdField_e_of_type_Float;
      localBaseNode = (BaseNode)localBaseNode.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionILayer;
    }
    return f1;
  }
  
  public int b()
  {
    BaseNode localBaseNode = (BaseNode)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionILayer;
    float f1 = 1.0F;
    while (localBaseNode != null)
    {
      f1 *= localBaseNode.jdField_a_of_type_Int / 255.0F;
      localBaseNode = (BaseNode)localBaseNode.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionILayer;
    }
    return (int)(f1 * 255.0F);
  }
  
  public void b()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((Action)this.jdField_a_of_type_JavaUtilList.get(i)).c();
      i += 1;
    }
  }
  
  public void b(float paramFloat)
  {
    this.jdField_d_of_type_Float = paramFloat;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected boolean b()
  {
    int i = 0;
    boolean bool1 = false;
    int j;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      Action localAction = (Action)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localAction.a())
      {
        if ((localAction.jdField_d_of_type_Int & 0x1) != 0)
        {
          this.jdField_c_of_type_Float = localAction.jdField_a_of_type_Float;
          this.jdField_d_of_type_Float = localAction.jdField_b_of_type_Float;
        }
        if ((localAction.jdField_d_of_type_Int & 0x2) != 0) {
          this.jdField_e_of_type_Float = localAction.jdField_c_of_type_Float;
        }
        if ((localAction.jdField_d_of_type_Int & 0x4) != 0) {
          this.jdField_a_of_type_Int = localAction.jdField_a_of_type_Int;
        }
        if ((localAction.jdField_d_of_type_Int & 0x8) != 0) {
          this.g = localAction.jdField_b_of_type_Int;
        }
        bool1 = true;
      }
      j = i;
      if (localAction.jdField_b_of_type_Boolean) {
        if (localAction.jdField_a_of_type_Boolean)
        {
          localAction.a();
          j = i;
        }
        else
        {
          this.jdField_a_of_type_JavaUtilList.remove(i);
          j = i - 1;
        }
      }
      i = j + 1;
    }
    boolean bool2 = bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrame != null)
    {
      bool2 = bool1;
      if (a() != null)
      {
        j = a().c() * this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrame.jdField_a_of_type_Int / 1000;
        i = j;
        if (j > 0) {
          i = j - 1;
        }
        bool2 = bool1;
        if (i < this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrame.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionFrame$FrameData.length)
        {
          this.jdField_c_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrame.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionFrame$FrameData[i].jdField_a_of_type_Float;
          this.jdField_d_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrame.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionFrame$FrameData[i].jdField_b_of_type_Float;
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  public void c()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((Action)this.jdField_a_of_type_JavaUtilList.get(i)).d();
      i += 1;
    }
  }
  
  public void c(float paramFloat)
  {
    this.jdField_e_of_type_Float = paramFloat;
  }
  
  public void c(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void d(float paramFloat)
  {
    this.g = paramFloat;
  }
  
  public void d(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void e(float paramFloat)
  {
    this.jdField_f_of_type_Float = paramFloat;
  }
  
  public int g_()
  {
    return this.jdField_d_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.BaseNode
 * JD-Core Version:    0.7.0.1
 */