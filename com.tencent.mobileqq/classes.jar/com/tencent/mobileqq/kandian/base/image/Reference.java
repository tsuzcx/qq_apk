package com.tencent.mobileqq.kandian.base.image;

import com.tencent.qphone.base.util.QLog;

public class Reference<T>
{
  public static final String a;
  private int jdField_a_of_type_Int;
  private final Releaser<T> jdField_a_of_type_ComTencentMobileqqKandianBaseImageReleaser;
  private T jdField_a_of_type_JavaLangObject;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("zimage.");
    localStringBuilder.append(Reference.class.getSimpleName());
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public Reference(T paramT, Releaser<T> paramReleaser)
  {
    this.jdField_a_of_type_JavaLangObject = paramT;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageReleaser = paramReleaser;
    this.jdField_a_of_type_Int = 1;
  }
  
  public T a()
  {
    try
    {
      Object localObject1 = this.jdField_a_of_type_JavaLangObject;
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_Int += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_Int -= 1;
      if (this.jdField_a_of_type_Int == 0)
      {
        QLog.isColorLevel();
        if (this.jdField_a_of_type_JavaLangObject != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageReleaser.a(this.jdField_a_of_type_JavaLangObject);
          this.jdField_a_of_type_JavaLangObject = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.Reference
 * JD-Core Version:    0.7.0.1
 */