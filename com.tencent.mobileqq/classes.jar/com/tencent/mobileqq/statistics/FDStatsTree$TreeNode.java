package com.tencent.mobileqq.statistics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FDStatsTree$TreeNode
{
  public int a;
  public char b;
  public int c;
  public List<TreeNode> d = new ArrayList();
  
  public FDStatsTree$TreeNode(int paramInt, char paramChar)
  {
    this.a = paramInt;
    this.b = paramChar;
    this.c = 1;
  }
  
  public TreeNode a(char paramChar)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      TreeNode localTreeNode = (TreeNode)localIterator.next();
      if (localTreeNode.b == paramChar) {
        return localTreeNode;
      }
    }
    return null;
  }
  
  public void a()
  {
    this.c += 1;
  }
  
  public void a(TreeNode paramTreeNode)
  {
    this.d.add(paramTreeNode);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" ");
    localStringBuilder.append("char: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ");
    localStringBuilder.append("cnt: ");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.FDStatsTree.TreeNode
 * JD-Core Version:    0.7.0.1
 */