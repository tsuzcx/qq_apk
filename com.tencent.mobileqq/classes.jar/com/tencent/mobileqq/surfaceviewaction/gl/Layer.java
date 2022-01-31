package com.tencent.mobileqq.surfaceviewaction.gl;

import ailh;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.List;

public class Layer
  extends Node
  implements ailh
{
  public List a;
  
  public Layer(SpriteGLView paramSpriteGLView)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = paramSpriteGLView;
  }
  
  public Node a(String paramString)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      Node localNode = (Node)this.jdField_a_of_type_JavaUtilList.get(i);
      if (paramString.equals(localNode.jdField_a_of_type_JavaLangString)) {
        return localNode;
      }
      if ((localNode instanceof Layer)) {
        return ((Layer)localNode).a(paramString);
      }
      i += 1;
    }
    return null;
  }
  
  public void a(Node paramNode)
  {
    if (paramNode.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLayer == null)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramNode);
      paramNode.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLayer = this;
      return;
    }
    new RuntimeException("the node had another parent");
  }
  
  public boolean a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (((this.jdField_a_of_type_JavaUtilList.get(i) instanceof ailh)) && (((ailh)this.jdField_a_of_type_JavaUtilList.get(i)).a(paramMotionEvent, paramInt1, paramInt2))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public void b()
  {
    super.b();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((Node)this.jdField_a_of_type_JavaUtilList.get(i)).b();
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((Node)this.jdField_a_of_type_JavaUtilList.get(i)).c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.Layer
 * JD-Core Version:    0.7.0.1
 */