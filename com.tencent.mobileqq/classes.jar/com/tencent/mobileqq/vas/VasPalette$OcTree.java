package com.tencent.mobileqq.vas;

import android.graphics.Color;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;

public class VasPalette$OcTree
{
  public SparseArray<List<VasPalette.OcNode>> a;
  VasPalette.OcNode a;
  public List<VasPalette.OcNode> a;
  
  public VasPalette$OcTree()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_ComTencentMobileqqVasVasPalette$OcNode = VasPalette.OcNode.a();
  }
  
  public VasPalette.OcNode a(int paramInt)
  {
    VasPalette.OcNode localOcNode1 = this.jdField_a_of_type_ComTencentMobileqqVasVasPalette$OcNode;
    int m = Color.red(paramInt);
    int n = Color.green(paramInt);
    int i1 = Color.blue(paramInt);
    paramInt = 128;
    byte b = 1;
    while (b <= 8)
    {
      boolean bool = false;
      if ((m & paramInt) == 0) {
        i = 0;
      } else {
        i = 1;
      }
      int j;
      if ((n & paramInt) == 0) {
        j = 0;
      } else {
        j = 1;
      }
      int k;
      if ((i1 & paramInt) == 0) {
        k = 0;
      } else {
        k = 1;
      }
      int i = i * 4 + j * 2 + k;
      if (localOcNode1.jdField_a_of_type_AndroidUtilSparseArray == null) {
        localOcNode1.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
      }
      if (localOcNode1.jdField_a_of_type_AndroidUtilSparseArray.get(i) == null)
      {
        VasPalette.OcNode localOcNode2 = VasPalette.OcNode.a(i, b);
        localOcNode1.jdField_a_of_type_AndroidUtilSparseArray.put(i, localOcNode2);
        if (b == 8) {
          bool = true;
        }
        localOcNode2.jdField_a_of_type_Boolean = bool;
        if (localOcNode2.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_JavaUtilList.add(localOcNode2);
        }
        else
        {
          if (this.jdField_a_of_type_AndroidUtilSparseArray.get(b) == null) {
            this.jdField_a_of_type_AndroidUtilSparseArray.put(b, new ArrayList());
          }
          ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(b)).add(localOcNode2);
        }
      }
      localOcNode1 = (VasPalette.OcNode)localOcNode1.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      if (localOcNode1.jdField_a_of_type_Boolean)
      {
        localOcNode1.jdField_a_of_type_Long += m;
        localOcNode1.b += n;
        localOcNode1.c += i1;
        localOcNode1.jdField_a_of_type_Int += 1;
        return localOcNode1;
      }
      b = (byte)(b + 1);
      paramInt >>= 1;
    }
    return localOcNode1;
  }
  
  public void a()
  {
    int i = 7;
    while ((i > 0) && (((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(i)).isEmpty())) {
      i -= 1;
    }
    Object localObject = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      VasPalette.OcNode localOcNode = (VasPalette.OcNode)((List)localObject).get(((List)localObject).size() - 1);
      ((List)localObject).remove(localOcNode);
      i = 0;
      while (i < 8)
      {
        localObject = (VasPalette.OcNode)localOcNode.jdField_a_of_type_AndroidUtilSparseArray.get(i);
        if (localObject != null)
        {
          localOcNode.jdField_a_of_type_Long += ((VasPalette.OcNode)localObject).jdField_a_of_type_Long;
          localOcNode.b += ((VasPalette.OcNode)localObject).b;
          localOcNode.c += ((VasPalette.OcNode)localObject).c;
          localOcNode.jdField_a_of_type_Int += ((VasPalette.OcNode)localObject).jdField_a_of_type_Int;
          this.jdField_a_of_type_JavaUtilList.remove(localObject);
        }
        i += 1;
      }
      localOcNode.jdField_a_of_type_AndroidUtilSparseArray.clear();
      localOcNode.jdField_a_of_type_AndroidUtilSparseArray = null;
      localOcNode.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaUtilList.add(localOcNode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasPalette.OcTree
 * JD-Core Version:    0.7.0.1
 */