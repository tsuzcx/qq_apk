package com.tencent.mobileqq.comment;

public class DanmuDataContext
{
  public int a;
  public long a;
  public boolean a;
  public long b;
  public long c;
  public long d;
  
  public DanmuDataContext(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean)
  {
    this.b = paramLong1;
    this.jdField_a_of_type_Long = paramLong2;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof DanmuDataContext;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (DanmuDataContext)paramObject;
      bool1 = bool2;
      if (paramObject.jdField_a_of_type_Long == this.jdField_a_of_type_Long)
      {
        bool1 = bool2;
        if (paramObject.b == this.b) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.comment.DanmuDataContext
 * JD-Core Version:    0.7.0.1
 */