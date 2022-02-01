package com.tencent.mobileqq.statistics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FDStatsTree$TreeNode
{
  public char a;
  public int a;
  public List<TreeNode> a;
  public int b;
  
  public FDStatsTree$TreeNode(int paramInt, char paramChar)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Char = paramChar;
    this.b = 1;
  }
  
  public TreeNode a(char paramChar)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      TreeNode localTreeNode = (TreeNode)localIterator.next();
      if (localTreeNode.jdField_a_of_type_Char == paramChar) {
        return localTreeNode;
      }
    }
    return null;
  }
  
  public void a()
  {
    this.b += 1;
  }
  
  public void a(TreeNode paramTreeNode)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramTreeNode);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" ");
    localStringBuilder.append("char: ");
    localStringBuilder.append(this.jdField_a_of_type_Char);
    localStringBuilder.append(" ");
    localStringBuilder.append("cnt: ");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.FDStatsTree.TreeNode
 * JD-Core Version:    0.7.0.1
 */