package com.tencent.util;

public class Thrower<T>
{
  private long jdField_a_of_type_Long = 0L;
  private Thrower.Action<T> jdField_a_of_type_ComTencentUtilThrower$Action;
  private long b;
  
  private Thrower(Thrower.Action<T> paramAction)
  {
    this.jdField_a_of_type_ComTencentUtilThrower$Action = paramAction;
  }
  
  public static <T> Thrower<T> a(Thrower.Action<T> paramAction)
  {
    return new Thrower(paramAction);
  }
  
  public Thrower<T> a(long paramLong)
  {
    this.b = paramLong;
    return this;
  }
  
  public Thrower<T> a(T paramT)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long > this.b)
    {
      this.jdField_a_of_type_Long = l;
      Thrower.Action localAction = this.jdField_a_of_type_ComTencentUtilThrower$Action;
      if (localAction != null) {
        localAction.a(paramT);
      }
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.Thrower
 * JD-Core Version:    0.7.0.1
 */