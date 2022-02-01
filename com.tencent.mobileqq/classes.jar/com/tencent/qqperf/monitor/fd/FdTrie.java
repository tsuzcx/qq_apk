package com.tencent.qqperf.monitor.fd;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class FdTrie
{
  static final List<String> jdField_a_of_type_JavaUtilList = new FdTrie.1(10);
  private FdNode jdField_a_of_type_ComTencentQqperfMonitorFdFdNode = new FdNode();
  private HashMap<FdNode, String> jdField_a_of_type_JavaUtilHashMap = new HashMap(100);
  private HashMap<FdNode, String> b = new HashMap(jdField_a_of_type_JavaUtilList.size());
  
  static String a(String paramString)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((paramString != null) && (paramString.contains(str))) {
        return str;
      }
    }
    return null;
  }
  
  private static List<String> a(String paramString)
  {
    paramString = paramString.split("/");
    ArrayList localArrayList = new ArrayList(paramString.length);
    localArrayList.addAll(Arrays.asList(paramString));
    return localArrayList;
  }
  
  private void a(FdNode paramFdNode, String paramString)
  {
    if (paramFdNode == null) {
      return;
    }
    Object localObject = a(paramString);
    if (localObject != null) {
      this.b.put(paramFdNode, localObject);
    }
    int j = 1;
    localObject = paramFdNode.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    FdNode localFdNode;
    do
    {
      i = j;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localFdNode = (FdNode)((Iterator)localObject).next();
    } while ((localFdNode == null) || (localFdNode.a()));
    int i = 0;
    if ((i != 0) && (!paramFdNode.jdField_a_of_type_JavaUtilHashMap.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramFdNode, paramString);
      return;
    }
    localObject = paramFdNode.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      localFdNode = (FdNode)((Iterator)localObject).next();
      if (localFdNode != null)
      {
        if (paramString != null)
        {
          paramFdNode = new StringBuilder();
          paramFdNode.append(paramString);
          paramFdNode.append("/");
          paramFdNode.append(localFdNode.jdField_a_of_type_JavaLangString);
          paramFdNode = paramFdNode.toString();
        }
        else
        {
          paramFdNode = localFdNode.jdField_a_of_type_JavaLangString;
        }
        a(localFdNode, paramFdNode);
      }
    }
  }
  
  private void b(FdNode paramFdNode, String paramString)
  {
    Iterator localIterator = a(paramString).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramString = paramFdNode.a(str);
      if (paramString != null)
      {
        paramString.jdField_a_of_type_Int += 1;
        paramFdNode = paramString;
      }
      else
      {
        paramString = new FdNode(str);
        paramString.jdField_a_of_type_Int = 1;
        paramFdNode.jdField_a_of_type_JavaUtilHashMap.put(paramString.jdField_a_of_type_JavaLangString, paramString);
        paramFdNode = paramString;
      }
    }
  }
  
  public HashMap<FdNode, String> a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_ComTencentQqperfMonitorFdFdNode, null);
  }
  
  public void a(@NonNull String paramString)
  {
    b(this.jdField_a_of_type_ComTencentQqperfMonitorFdFdNode, paramString);
  }
  
  public HashMap<FdNode, String> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.fd.FdTrie
 * JD-Core Version:    0.7.0.1
 */