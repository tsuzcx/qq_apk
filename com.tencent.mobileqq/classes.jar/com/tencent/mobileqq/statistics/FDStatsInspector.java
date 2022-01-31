package com.tencent.mobileqq.statistics;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class FDStatsInspector
{
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private String[] jdField_a_of_type_ArrayOfJavaLangString = { "socket", "pipe", "anon_inode", "/dev/null", "/dev/ashmem" };
  
  public void a()
  {
    long l = System.currentTimeMillis();
    Object localObject1 = this.jdField_a_of_type_JavaUtilHashMap.values();
    Object localObject2 = new ArrayList();
    Object localObject3 = new ArrayList();
    Iterator localIterator = ((Collection)localObject1).iterator();
    if (localIterator.hasNext())
    {
      FDStatsInspector.InspectObj localInspectObj = (FDStatsInspector.InspectObj)localIterator.next();
      localObject1 = " ing";
      if ((!localInspectObj.jdField_a_of_type_Boolean) && (l - localInspectObj.jdField_a_of_type_Long > 3600000L))
      {
        ((List)localObject3).add(localInspectObj);
        localObject1 = " remove";
      }
      for (;;)
      {
        QLog.d("FDStatsInspector", 1, "inspect " + localInspectObj.jdField_a_of_type_JavaLangString + " : " + localInspectObj.jdField_a_of_type_Int + (String)localObject1);
        break;
        if (localInspectObj.jdField_a_of_type_Boolean)
        {
          ((List)localObject2).add(localInspectObj);
          localObject1 = " suspicious";
        }
      }
    }
    localObject1 = ((List)localObject3).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (FDStatsInspector.InspectObj)((Iterator)localObject1).next();
      this.jdField_a_of_type_JavaUtilHashMap.remove(localObject3);
    }
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FDStatsInspector.InspectObj)((Iterator)localObject1).next();
      QLog.d("FDStatsInspector", 1, "suspicious " + ((FDStatsInspector.InspectObj)localObject2).jdField_a_of_type_JavaLangString + " : " + ((FDStatsInspector.InspectObj)localObject2).jdField_a_of_type_Int);
    }
  }
  
  public void a(FDStatsTree.ResultObj paramResultObj)
  {
    if (paramResultObj.jdField_a_of_type_Int < 2) {}
    Object localObject;
    label51:
    do
    {
      return;
      localObject = this.jdField_a_of_type_ArrayOfJavaLangString;
      int j = localObject.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label51;
        }
        CharSequence localCharSequence = localObject[i];
        if (paramResultObj.jdField_a_of_type_JavaLangString.contains(localCharSequence)) {
          break;
        }
        i += 1;
      }
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramResultObj.jdField_a_of_type_JavaLangString)) {
        break;
      }
      localObject = (FDStatsInspector.InspectObj)this.jdField_a_of_type_JavaUtilHashMap.get(paramResultObj.jdField_a_of_type_JavaLangString);
      if (paramResultObj.jdField_a_of_type_Int - ((FDStatsInspector.InspectObj)localObject).jdField_a_of_type_Int > 3) {
        ((FDStatsInspector.InspectObj)localObject).jdField_a_of_type_Boolean = true;
      }
    } while (System.currentTimeMillis() - ((FDStatsInspector.InspectObj)localObject).jdField_a_of_type_Long <= 3600000L);
    ((FDStatsInspector.InspectObj)localObject).jdField_a_of_type_Boolean = true;
    return;
    this.jdField_a_of_type_JavaUtilHashMap.put(paramResultObj.jdField_a_of_type_JavaLangString, new FDStatsInspector.InspectObj(paramResultObj));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.FDStatsInspector
 * JD-Core Version:    0.7.0.1
 */