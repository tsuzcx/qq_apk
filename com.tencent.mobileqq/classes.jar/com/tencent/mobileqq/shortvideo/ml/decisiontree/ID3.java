package com.tencent.mobileqq.shortvideo.ml.decisiontree;

import aicn;
import aico;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ID3
{
  public static ID3.ChiSquareTest a;
  public static ID3.ImpurityFunction a;
  public static ID3.ChiSquareTest b;
  public static ID3.ImpurityFunction b;
  public static ID3.ChiSquareTest c = new ID3.ChiSquareTest(7.82D);
  public static ID3.ChiSquareTest d = new ID3.ChiSquareTest(0.0D);
  public Node a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqShortvideoMlDecisiontreeID3$ImpurityFunction = new aicn();
    jdField_b_of_type_ComTencentMobileqqShortvideoMlDecisiontreeID3$ImpurityFunction = new aico();
    jdField_a_of_type_ComTencentMobileqqShortvideoMlDecisiontreeID3$ChiSquareTest = new ID3.ChiSquareTest(16.27D);
    jdField_b_of_type_ComTencentMobileqqShortvideoMlDecisiontreeID3$ChiSquareTest = new ID3.ChiSquareTest(11.34D);
  }
  
  public static Node a(List paramList, ID3.ImpurityFunction paramImpurityFunction)
  {
    paramList = new Node(null, paramList);
    a(paramList, paramImpurityFunction, d, 0);
    return paramList;
  }
  
  static void a(Node paramNode, ID3.ImpurityFunction paramImpurityFunction, ID3.ChiSquareTest paramChiSquareTest, int paramInt)
  {
    paramNode.jdField_a_of_type_JavaUtilList.size();
    int i = ((Instance)paramNode.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_ArrayOfInt.length;
    i = Instance.jdField_a_of_type_Int;
    Object localObject1 = (int[][])Array.newInstance(Integer.TYPE, new int[] { i, 2 });
    int k = 0;
    int m = 0;
    i = 0;
    if (i < paramNode.jdField_a_of_type_JavaUtilList.size())
    {
      if (((Instance)paramNode.jdField_a_of_type_JavaUtilList.get(i)).b == 1) {
        k += 1;
      }
      for (;;)
      {
        i += 1;
        break;
        m += 1;
      }
    }
    double d1 = -100000.0D;
    int j = -1;
    i = 0;
    Object localObject2;
    Object localObject3;
    if (i < paramNode.b)
    {
      int n = Instance.jdField_a_of_type_Int;
      localObject2 = (int[][])Array.newInstance(Integer.TYPE, new int[] { n, 2 });
      localObject3 = paramNode.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Instance localInstance = (Instance)((Iterator)localObject3).next();
        if (localInstance.b == 1)
        {
          localInstance = localObject2[localInstance.jdField_a_of_type_ArrayOfInt[i]];
          localInstance[1] += 1;
        }
        else
        {
          localInstance = localObject2[localInstance.jdField_a_of_type_ArrayOfInt[i]];
          localInstance[0] += 1;
        }
      }
      double d2 = paramImpurityFunction.a(k, m);
      n = 0;
      while (n < Instance.jdField_a_of_type_Int)
      {
        d2 -= 1.0D * (localObject2[n][0] + localObject2[n][1]) / (k + m) * paramImpurityFunction.a(localObject2[n][0], localObject2[n][1]);
        n += 1;
      }
      if (d2 <= d1) {
        break label633;
      }
      j = 0;
      while (j < Instance.jdField_a_of_type_Int)
      {
        localObject1[j][0] = localObject2[j][0];
        localObject1[j][1] = localObject2[j][1];
        j += 1;
      }
      j = i;
      d1 = d2;
    }
    label633:
    for (;;)
    {
      i += 1;
      break;
      if ((d1 > 1.0E-010D) && (paramChiSquareTest.a((int[][])localObject1)))
      {
        paramNode.jdField_a_of_type_Int = j;
        localObject1 = new ArrayList();
        i = 0;
        while (i < Instance.jdField_a_of_type_Int)
        {
          ((ArrayList)localObject1).add(new ArrayList());
          i += 1;
        }
        localObject2 = paramNode.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Instance)((Iterator)localObject2).next();
          ((ArrayList)((ArrayList)localObject1).get(localObject3.jdField_a_of_type_ArrayOfInt[j])).add(localObject3);
        }
        i = 0;
        while (i < Instance.jdField_a_of_type_Int)
        {
          if (((j != 16) || (i != 2)) || (((ArrayList)((ArrayList)localObject1).get(i)).size() > 0))
          {
            paramNode.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoMlDecisiontreeNode[i] = new Node(paramNode, (List)((ArrayList)localObject1).get(i));
            a(paramNode.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoMlDecisiontreeNode[i], paramImpurityFunction, paramChiSquareTest, paramInt + 1);
          }
          i += 1;
        }
      }
      return;
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMlDecisiontreeNode = a(paramList, jdField_a_of_type_ComTencentMobileqqShortvideoMlDecisiontreeID3$ImpurityFunction);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ml.decisiontree.ID3
 * JD-Core Version:    0.7.0.1
 */