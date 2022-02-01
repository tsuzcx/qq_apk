package com.tencent.mobileqq.richstatus.comment.utils;

import java.lang.reflect.Array;
import mqq.util.WeakReference;

public final class SimpleWeakObjectPool<T>
{
  private int jdField_a_of_type_Int = -1;
  private WeakReference<T>[] jdField_a_of_type_ArrayOfMqqUtilWeakReference;
  
  public SimpleWeakObjectPool()
  {
    this(16);
  }
  
  public SimpleWeakObjectPool(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfMqqUtilWeakReference = ((WeakReference[])Array.newInstance(WeakReference.class, paramInt));
  }
  
  public T a()
  {
    try
    {
      if ((this.jdField_a_of_type_Int != -1) && (this.jdField_a_of_type_Int <= this.jdField_a_of_type_ArrayOfMqqUtilWeakReference.length))
      {
        Object localObject1 = this.jdField_a_of_type_ArrayOfMqqUtilWeakReference[this.jdField_a_of_type_Int].get();
        this.jdField_a_of_type_ArrayOfMqqUtilWeakReference[this.jdField_a_of_type_Int] = null;
        this.jdField_a_of_type_Int -= 1;
        return localObject1;
      }
      return null;
    }
    finally {}
  }
  
  public boolean a(T paramT)
  {
    try
    {
      if (this.jdField_a_of_type_Int != -1)
      {
        int i = this.jdField_a_of_type_Int;
        int j = this.jdField_a_of_type_ArrayOfMqqUtilWeakReference.length;
        if (i >= j - 1) {
          return false;
        }
      }
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_ArrayOfMqqUtilWeakReference[this.jdField_a_of_type_Int] = new WeakReference(paramT);
      return true;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.comment.utils.SimpleWeakObjectPool
 * JD-Core Version:    0.7.0.1
 */