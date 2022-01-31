package com.tencent.mobileqq.statistics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FDStatsTree$TreeNode
{
  public char a;
  public int a;
  public List a;
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
  
  public boolean a(String paramString, List paramList)
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() != 0) {
        break label75;
      }
      if (this.b <= 1) {
        break label73;
      }
      paramList.add(new FDStatsTree.ResultObj(paramString, this.b));
    }
    label156:
    label157:
    for (;;)
    {
      return true;
      paramString = paramString + this.jdField_a_of_type_Char;
      break;
      label73:
      return false;
      label75:
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        if (!((TreeNode)localIterator.next()).a(paramString, paramList)) {
          break label156;
        }
        i = 1;
      }
      for (;;)
      {
        break;
        if (i != 0) {
          break label157;
        }
        if (this.b > 1)
        {
          paramList.add(new FDStatsTree.ResultObj(paramString, this.b));
          return true;
        }
        return false;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id: ").append(this.jdField_a_of_type_Int).append(" ");
    localStringBuilder.append("char: ").append(this.jdField_a_of_type_Char).append(" ");
    localStringBuilder.append("cnt: ").append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.FDStatsTree.TreeNode
 * JD-Core Version:    0.7.0.1
 */