package com.tencent.open.model;

import java.util.ArrayList;

public class GetVirtualListResult
{
  public int a;
  public long a;
  public ArrayList<VirtualInfo> a;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("GetVirtualListResult={");
    localStringBuilder.append("errorCode=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",");
    localStringBuilder.append("curVirtualId=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(",");
    localStringBuilder.append("list=");
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null) {
      localObject = ((ArrayList)localObject).toString();
    } else {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.model.GetVirtualListResult
 * JD-Core Version:    0.7.0.1
 */