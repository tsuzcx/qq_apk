package com.tencent.mobileqq.kandian.base.image;

import com.tencent.qphone.base.util.QLog;

public class Reference<T>
{
  public static final String a;
  private T b;
  private int c;
  private final Releaser<T> d;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("zimage.");
    localStringBuilder.append(Reference.class.getSimpleName());
    a = localStringBuilder.toString();
  }
  
  public Reference(T paramT, Releaser<T> paramReleaser)
  {
    this.b = paramT;
    this.d = paramReleaser;
    this.c = 1;
  }
  
  public T a()
  {
    try
    {
      Object localObject1 = this.b;
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public void b()
  {
    try
    {
      this.c += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c()
  {
    try
    {
      this.c -= 1;
      if (this.c == 0)
      {
        QLog.isColorLevel();
        if (this.b != null)
        {
          this.d.a(this.b);
          this.b = null;
        }
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.Reference
 * JD-Core Version:    0.7.0.1
 */