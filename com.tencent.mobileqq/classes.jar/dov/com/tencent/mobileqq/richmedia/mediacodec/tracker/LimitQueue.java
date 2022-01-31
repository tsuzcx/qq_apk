package dov.com.tencent.mobileqq.richmedia.mediacodec.tracker;

import java.util.LinkedList;

public class LimitQueue
{
  private int jdField_a_of_type_Int;
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  
  public LimitQueue(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int <= 0) {
      return 0;
    }
    if (this.jdField_a_of_type_Int % 2 == 0) {
      return this.jdField_a_of_type_Int / 2;
    }
    return (this.jdField_a_of_type_Int - 1) / 2;
  }
  
  public Object a(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
  }
  
  public void a(Object paramObject)
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() >= this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_JavaUtilLinkedList.poll();
    }
    this.jdField_a_of_type_JavaUtilLinkedList.offer(paramObject);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_JavaUtilLinkedList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.tracker.LimitQueue
 * JD-Core Version:    0.7.0.1
 */