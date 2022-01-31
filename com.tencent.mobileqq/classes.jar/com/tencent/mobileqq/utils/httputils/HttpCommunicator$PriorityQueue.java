package com.tencent.mobileqq.utils.httputils;

import java.util.ArrayList;
import java.util.LinkedList;

public class HttpCommunicator$PriorityQueue
{
  public int a;
  private ArrayList a;
  
  public HttpCommunicator$PriorityQueue()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    int i = 0;
    while (i < 3)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(new LinkedList());
      i += 1;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public HttpMsg a(boolean paramBoolean)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((LinkedList)this.jdField_a_of_type_JavaUtilArrayList.get(i)).size() != 0)
      {
        if (paramBoolean)
        {
          HttpMsg localHttpMsg = (HttpMsg)((LinkedList)this.jdField_a_of_type_JavaUtilArrayList.get(i)).remove(0);
          this.jdField_a_of_type_Int -= 1;
          return localHttpMsg;
        }
        return (HttpMsg)((LinkedList)this.jdField_a_of_type_JavaUtilArrayList.get(i)).get(0);
      }
      i += 1;
    }
    return null;
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((LinkedList)this.jdField_a_of_type_JavaUtilArrayList.get(i)).clear();
      i += 1;
    }
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(HttpMsg paramHttpMsg)
  {
    if (paramHttpMsg == null) {}
    int i;
    do
    {
      return;
      i = paramHttpMsg.b() - 200;
    } while ((i < 0) || (i >= this.jdField_a_of_type_JavaUtilArrayList.size()));
    ((LinkedList)this.jdField_a_of_type_JavaUtilArrayList.get(i)).add(paramHttpMsg);
    this.jdField_a_of_type_Int += 1;
  }
  
  public boolean a(HttpMsg paramHttpMsg)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (((LinkedList)this.jdField_a_of_type_JavaUtilArrayList.get(i)).remove(paramHttpMsg))
        {
          this.jdField_a_of_type_Int -= 1;
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.httputils.HttpCommunicator.PriorityQueue
 * JD-Core Version:    0.7.0.1
 */