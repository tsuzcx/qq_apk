package com.tencent.mobileqq.vas;

import akps;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class VasPalette$OcTreeQuantizer
{
  private static final Comparator jdField_a_of_type_JavaUtilComparator = new akps();
  private List jdField_a_of_type_JavaUtilList;
  
  public List a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a(int[] paramArrayOfInt, int paramInt)
  {
    Object localObject = new VasPalette.OcTree();
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      ((VasPalette.OcTree)localObject).a(paramArrayOfInt[i]);
      while (((VasPalette.OcTree)localObject).jdField_a_of_type_JavaUtilList.size() > paramInt) {
        ((VasPalette.OcTree)localObject).a();
      }
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramArrayOfInt = ((VasPalette.OcTree)localObject).jdField_a_of_type_JavaUtilList.iterator();
    while (paramArrayOfInt.hasNext())
    {
      localObject = (VasPalette.OcNode)paramArrayOfInt.next();
      ((VasPalette.OcNode)localObject).jdField_a_of_type_Long = ((int)((float)((VasPalette.OcNode)localObject).jdField_a_of_type_Long / ((VasPalette.OcNode)localObject).jdField_a_of_type_Int));
      ((VasPalette.OcNode)localObject).b = ((int)((float)((VasPalette.OcNode)localObject).b / ((VasPalette.OcNode)localObject).jdField_a_of_type_Int));
      ((VasPalette.OcNode)localObject).c = ((int)((float)((VasPalette.OcNode)localObject).c / ((VasPalette.OcNode)localObject).jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilList.add(localObject);
    }
    Collections.sort(this.jdField_a_of_type_JavaUtilList, jdField_a_of_type_JavaUtilComparator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasPalette.OcTreeQuantizer
 * JD-Core Version:    0.7.0.1
 */