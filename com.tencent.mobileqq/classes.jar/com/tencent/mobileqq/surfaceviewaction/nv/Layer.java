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
  public List<BaseNode> s = new ArrayList();
  
  public Layer(SpriteNativeView paramSpriteNativeView)
  {
    this.t = paramSpriteNativeView;
  }
  
  public <N extends BaseNode> N a(String paramString)
  {
    int i = 0;
    while (i < this.s.size())
    {
      Node localNode = (Node)this.s.get(i);
      if (paramString.equals(localNode.a)) {
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
    return this.s;
  }
  
  public void a(Node paramNode)
  {
    if (paramNode.m == null)
    {
      this.s.add(paramNode);
      paramNode.m = this;
      paramNode.l();
      return;
    }
    new RuntimeException("the node had another parent");
  }
  
  public void f()
  {
    super.f();
    int i = 0;
    while (i < this.s.size())
    {
      ((Node)this.s.get(i)).f();
      i += 1;
    }
    this.s.clear();
  }
  
  public void g()
  {
    Iterator localIterator = this.s.iterator();
    while (localIterator.hasNext()) {
      ((BaseNode)localIterator.next()).g();
    }
  }
  
  public void h()
  {
    Iterator localIterator = this.s.iterator();
    while (localIterator.hasNext()) {
      ((BaseNode)localIterator.next()).h();
    }
  }
  
  public boolean k()
  {
    boolean bool = super.k();
    int i = 0;
    while (i < this.s.size())
    {
      bool |= ((Node)this.s.get(i)).k();
      i += 1;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.nv.Layer
 * JD-Core Version:    0.7.0.1
 */