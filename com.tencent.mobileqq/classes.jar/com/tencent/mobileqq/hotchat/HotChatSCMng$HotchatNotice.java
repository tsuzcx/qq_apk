package com.tencent.mobileqq.hotchat;

import java.util.ArrayList;
import java.util.Iterator;

public class HotChatSCMng$HotchatNotice
{
  int jdField_a_of_type_Int = -1;
  String jdField_a_of_type_JavaLangString;
  ArrayList<HotChatNote> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public void a()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public String toString()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size() * 100;
    int i;
    if (j > 2000)
    {
      i = 2000;
    }
    else
    {
      i = j;
      if (j < 100) {
        i = 100;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder(i);
    localStringBuilder.append("[");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList.size());
    localStringBuilder.append(",");
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      localStringBuilder.append("{");
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        localStringBuilder.append((HotChatNote)localIterator.next());
        localStringBuilder.append(",");
      }
      localStringBuilder.append("}");
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.HotChatSCMng.HotchatNotice
 * JD-Core Version:    0.7.0.1
 */