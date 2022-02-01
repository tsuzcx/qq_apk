package org.jbox2d.collision.broadphase;

import org.jbox2d.collision.AABB;

public class DynamicTreeNode
{
  public final AABB aabb = new AABB();
  protected DynamicTreeNode child1;
  protected DynamicTreeNode child2;
  protected int height;
  protected final int id;
  protected boolean leaf;
  protected DynamicTreeNode parent;
  public Object userData;
  
  protected DynamicTreeNode(int paramInt)
  {
    this.id = paramInt;
  }
  
  public Object getUserData()
  {
    return this.userData;
  }
  
  public final boolean isLeaf()
  {
    return this.child1 == null;
  }
  
  public void setUserData(Object paramObject)
  {
    this.userData = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.collision.broadphase.DynamicTreeNode
 * JD-Core Version:    0.7.0.1
 */