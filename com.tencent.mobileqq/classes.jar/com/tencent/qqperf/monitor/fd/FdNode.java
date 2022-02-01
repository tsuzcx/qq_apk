package com.tencent.qqperf.monitor.fd;

import java.util.HashMap;

class FdNode
  implements Comparable<FdNode>
{
  public int a;
  public String a;
  public HashMap<String, FdNode> a;
  
  public FdNode()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
    this.jdField_a_of_type_Int = 0;
  }
  
  public FdNode(String paramString)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a(FdNode paramFdNode)
  {
    return paramFdNode.jdField_a_of_type_Int - this.jdField_a_of_type_Int;
  }
  
  public FdNode a(String paramString)
  {
    return (FdNode)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap.isEmpty();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass())) {
      return ((FdNode)paramObject).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString);
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if (str == null) {
      return 0;
    }
    return str.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("FdNode{");
    localStringBuilder.append("text='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", appearTimes=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.fd.FdNode
 * JD-Core Version:    0.7.0.1
 */