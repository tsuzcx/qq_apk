package com.tencent.mobileqq.statistics;

import aifv;
import com.tencent.TMG.utils.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FDStatsTree
{
  int jdField_a_of_type_Int = 0;
  FDStatsTree.TreeNode jdField_a_of_type_ComTencentMobileqqStatisticsFDStatsTree$TreeNode = new FDStatsTree.TreeNode(this.jdField_a_of_type_Int, '&');
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public FDStatsTree()
  {
    this.jdField_a_of_type_Int += 1;
  }
  
  public void a(FDStatsInspector paramFDStatsInspector)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqStatisticsFDStatsTree$TreeNode.a("", this.jdField_a_of_type_JavaUtilList);
    Collections.sort(this.jdField_a_of_type_JavaUtilList, new aifv(this));
    Object localObject = new ArrayList(10);
    int i = 0;
    while ((i < 10) && (i < this.jdField_a_of_type_JavaUtilList.size()))
    {
      ((List)localObject).add(this.jdField_a_of_type_JavaUtilList.get(i));
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList = ((List)localObject);
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FDStatsTree.ResultObj localResultObj = (FDStatsTree.ResultObj)((Iterator)localObject).next();
      QLog.d("FDStatsTree", 0, localResultObj.jdField_a_of_type_JavaLangString + " : " + localResultObj.jdField_a_of_type_Int);
      paramFDStatsInspector.a(localResultObj);
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqStatisticsFDStatsTree$TreeNode;
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      FDStatsTree.TreeNode localTreeNode = ((FDStatsTree.TreeNode)localObject).a(c);
      if (localTreeNode == null)
      {
        localTreeNode = new FDStatsTree.TreeNode(this.jdField_a_of_type_Int, c);
        this.jdField_a_of_type_Int += 1;
        ((FDStatsTree.TreeNode)localObject).a(localTreeNode);
      }
      for (localObject = localTreeNode;; localObject = localTreeNode)
      {
        i += 1;
        break;
        localTreeNode.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.FDStatsTree
 * JD-Core Version:    0.7.0.1
 */