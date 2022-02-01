package com.tencent.mobileqq.statistics;

import java.util.ArrayList;
import java.util.List;

public class FDStatsTree
{
  FDStatsTree.TreeNode a = new FDStatsTree.TreeNode(this.b, '&');
  int b = 0;
  List<FDStatsTree.ResultObj> c = new ArrayList();
  
  public FDStatsTree()
  {
    this.b += 1;
  }
  
  public void a(String paramString)
  {
    Object localObject = this.a;
    int i = 0;
    while (i < paramString.length())
    {
      char c1 = paramString.charAt(i);
      FDStatsTree.TreeNode localTreeNode = ((FDStatsTree.TreeNode)localObject).a(c1);
      if (localTreeNode == null)
      {
        localTreeNode = new FDStatsTree.TreeNode(this.b, c1);
        this.b += 1;
        ((FDStatsTree.TreeNode)localObject).a(localTreeNode);
        localObject = localTreeNode;
      }
      else
      {
        localTreeNode.a();
        localObject = localTreeNode;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.FDStatsTree
 * JD-Core Version:    0.7.0.1
 */