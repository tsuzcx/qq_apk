package org.jbox2d.collision.broadphase;

public class DynamicTree$TreeNodeStack
{
  private int position;
  private int size;
  private DynamicTreeNode[] stack;
  
  public DynamicTree$TreeNodeStack(DynamicTree paramDynamicTree, int paramInt)
  {
    this.stack = new DynamicTreeNode[paramInt];
    this.position = 0;
    this.size = paramInt;
  }
  
  public int getCount()
  {
    return this.position;
  }
  
  public DynamicTreeNode pop()
  {
    DynamicTreeNode[] arrayOfDynamicTreeNode = this.stack;
    int i = this.position - 1;
    this.position = i;
    return arrayOfDynamicTreeNode[i];
  }
  
  public void push(DynamicTreeNode paramDynamicTreeNode)
  {
    int i = this.position;
    int j = this.size;
    if (i == j)
    {
      arrayOfDynamicTreeNode1 = this.stack;
      this.stack = new DynamicTreeNode[j * 2];
      DynamicTreeNode[] arrayOfDynamicTreeNode2 = this.stack;
      this.size = arrayOfDynamicTreeNode2.length;
      System.arraycopy(arrayOfDynamicTreeNode1, 0, arrayOfDynamicTreeNode2, 0, arrayOfDynamicTreeNode1.length);
    }
    DynamicTreeNode[] arrayOfDynamicTreeNode1 = this.stack;
    i = this.position;
    this.position = (i + 1);
    arrayOfDynamicTreeNode1[i] = paramDynamicTreeNode;
  }
  
  public void reset()
  {
    this.position = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.collision.broadphase.DynamicTree.TreeNodeStack
 * JD-Core Version:    0.7.0.1
 */