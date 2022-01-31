package com.tencent.mobileqq.statistics.battery;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class HighFrequencyDetector
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  
  public HighFrequencyDetector(int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public static String a(List paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramList != null) && (paramList.size() > 0))
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH点mm分ss");
      int i = paramList.size();
      localStringBuilder.ensureCapacity((((HighFrequencyDetector.Action)paramList.get(0)).jdField_a_of_type_JavaLangObject.toString().length() + 20) * i);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        HighFrequencyDetector.Action localAction = (HighFrequencyDetector.Action)paramList.next();
        localStringBuilder.append("[").append(localSimpleDateFormat.format(new Date(localAction.jdField_a_of_type_Long))).append(":").append(localAction.jdField_a_of_type_JavaLangObject.toString()).append("]");
      }
    }
    return localStringBuilder.toString();
  }
  
  public List a(Object arg1)
  {
    Object localObject1 = new HighFrequencyDetector.Action();
    ((HighFrequencyDetector.Action)localObject1).jdField_a_of_type_Long = System.currentTimeMillis();
    ((HighFrequencyDetector.Action)localObject1).jdField_a_of_type_JavaLangObject = ???;
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.addLast(localObject1);
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() < this.jdField_a_of_type_Int) {
        return null;
      }
      HighFrequencyDetector.Action localAction = (HighFrequencyDetector.Action)this.jdField_a_of_type_JavaUtilLinkedList.getFirst();
      if (((HighFrequencyDetector.Action)localObject1).jdField_a_of_type_Long - localAction.jdField_a_of_type_Long < this.jdField_a_of_type_Long)
      {
        localObject1 = new ArrayList(this.jdField_a_of_type_JavaUtilLinkedList);
        return localObject1;
      }
    }
    this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
    return null;
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.battery.HighFrequencyDetector
 * JD-Core Version:    0.7.0.1
 */