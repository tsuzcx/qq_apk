package com.tencent.mobileqq.surfaceviewaction.gl;

import android.view.MotionEvent;
import com.tencent.mobileqq.surfaceviewaction.BaseNode;
import com.tencent.mobileqq.surfaceviewaction.ILayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Layer
  extends Node
  implements ILayer<Node>, Node.Clickable
{
  public List<BaseNode> b = new ArrayList();
  
  public Layer(SpriteGLView paramSpriteGLView)
  {
    this.a = paramSpriteGLView;
  }
  
  public <N extends BaseNode> N a(String paramString)
  {
    int i = 0;
    while (i < this.b.size())
    {
      Node localNode = (Node)this.b.get(i);
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
  
  public List<BaseNode> a()
  {
    return this.b;
  }
  
  public void a()
  {
    super.a();
    int i = 0;
    while (i < this.b.size())
    {
      ((Node)this.b.get(i)).a();
      i += 1;
    }
    this.b.clear();
  }
  
  public void a(Node paramNode)
  {
    if (paramNode.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionILayer == null)
    {
      this.b.add(paramNode);
      paramNode.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionILayer = this;
      return;
    }
    new RuntimeException("the node had another parent");
  }
  
  public boolean a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    Object[] arrayOfObject = this.b.toArray();
    int i = arrayOfObject.length - 1;
    while (i >= 0)
    {
      if (((arrayOfObject[i] instanceof Node.Clickable)) && (((Node.Clickable)arrayOfObject[i]).a(paramMotionEvent, paramInt1, paramInt2))) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  protected void aC_()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      BaseNode localBaseNode = (BaseNode)localIterator.next();
      if ((localBaseNode instanceof Sprite)) {
        ((Sprite)localBaseNode).aC_();
      }
    }
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
    int i = 0;
    while (i < this.b.size())
    {
      ((Node)this.b.get(i)).c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.Layer
 * JD-Core Version:    0.7.0.1
 */