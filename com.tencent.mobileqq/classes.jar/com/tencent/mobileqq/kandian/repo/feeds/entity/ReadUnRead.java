package com.tencent.mobileqq.kandian.repo.feeds.entity;

import android.support.annotation.NonNull;
import java.util.HashSet;
import java.util.Set;

public class ReadUnRead
{
  public int a;
  public long a;
  public Set<String> a;
  public Set<String> b = new HashSet();
  
  public ReadUnRead()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("time:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("effectTime:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("  ");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilSet);
    localStringBuilder.append("  ");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.ReadUnRead
 * JD-Core Version:    0.7.0.1
 */