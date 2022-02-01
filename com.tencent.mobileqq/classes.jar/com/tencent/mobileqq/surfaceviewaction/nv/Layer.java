package com.tencent.mobileqq.surfaceviewaction.nv;

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
  
  public Layer(SpriteNativeView paramSpriteNativeView)
  {
    this.a = paramSpriteNativeView;
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
      paramNode.d();
      return;
    }
    new RuntimeException("the node had another parent");
  }
  
  public void b()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((BaseNode)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((BaseNode)localIterator.next()).c();
    }
  }
  
  public boolean c()
  {
    boolean bool = super.c();
    int i = 0;
    while (i < this.b.size())
    {
      bool |= ((Node)this.b.get(i)).c();
      i += 1;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.nv.Layer
 * JD-Core Version:    0.7.0.1
 */