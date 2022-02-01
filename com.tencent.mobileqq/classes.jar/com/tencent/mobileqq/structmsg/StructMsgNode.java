package com.tencent.mobileqq.structmsg;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StructMsgNode
{
  public int a;
  public StructMsgNode a;
  public String a;
  public List<StructMsgNode> a;
  public Map<String, String> a;
  public String b;
  
  public StructMsgNode(String paramString, Map<String, String> paramMap)
  {
    this.jdField_a_of_type_Int = 1;
    this.b = paramString;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
  
  public int a()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public StructMsgNode a()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return a(localList.indexOf(this) + 1);
    }
    return null;
  }
  
  public StructMsgNode a(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() > paramInt)) {
      return (StructMsgNode)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public String a(String paramString)
  {
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    if (localMap != null) {
      return (String)localMap.get(paramString);
    }
    return null;
  }
  
  public void a(StructMsgNode paramStructMsgNode)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramStructMsgNode);
  }
  
  public boolean a()
  {
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    return (localMap != null) && (localMap.size() > 0);
  }
  
  public StructMsgNode b()
  {
    return a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgNode
 * JD-Core Version:    0.7.0.1
 */