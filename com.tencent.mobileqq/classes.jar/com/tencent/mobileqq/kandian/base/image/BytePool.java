package com.tencent.mobileqq.kandian.base.image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BytePool
{
  protected static final Comparator<byte[]> a;
  private int jdField_a_of_type_Int = 0;
  private List<byte[]> jdField_a_of_type_JavaUtilList = new ArrayList(64);
  private final int b;
  
  static
  {
    jdField_a_of_type_JavaUtilComparator = new BytePool.1();
  }
  
  public BytePool(int paramInt)
  {
    this.b = paramInt;
  }
  
  private void b()
  {
    try
    {
      while (this.jdField_a_of_type_Int > this.b)
      {
        byte[] arrayOfByte = (byte[])this.jdField_a_of_type_JavaUtilList.get(0);
        this.jdField_a_of_type_JavaUtilList.remove(arrayOfByte);
        this.jdField_a_of_type_Int -= arrayOfByte.length;
      }
      return;
    }
    finally
    {
      localObject = finally;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      try
      {
        if (paramArrayOfByte.length <= this.b)
        {
          int j = Collections.binarySearch(this.jdField_a_of_type_JavaUtilList, paramArrayOfByte, jdField_a_of_type_JavaUtilComparator);
          int i = j;
          if (j < 0) {
            i = -j - 1;
          }
          this.jdField_a_of_type_JavaUtilList.add(i, paramArrayOfByte);
          this.jdField_a_of_type_Int += paramArrayOfByte.length;
          b();
          return;
        }
      }
      finally {}
    }
  }
  
  public byte[] a(int paramInt)
  {
    int i = 0;
    try
    {
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        arrayOfByte = (byte[])this.jdField_a_of_type_JavaUtilList.get(i);
        if (arrayOfByte.length >= paramInt)
        {
          this.jdField_a_of_type_Int -= arrayOfByte.length;
          this.jdField_a_of_type_JavaUtilList.remove(i);
          return arrayOfByte;
        }
        i += 1;
      }
      byte[] arrayOfByte = new byte[paramInt];
      return arrayOfByte;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.BytePool
 * JD-Core Version:    0.7.0.1
 */