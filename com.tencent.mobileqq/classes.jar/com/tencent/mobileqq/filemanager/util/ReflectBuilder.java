package com.tencent.mobileqq.filemanager.util;

import android.text.TextUtils;
import java.lang.reflect.Method;

public class ReflectBuilder<T>
{
  private int jdField_a_of_type_Int = 12288;
  private Class<?> jdField_a_of_type_JavaLangClass;
  private Object jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private Class<?>[] jdField_a_of_type_ArrayOfJavaLangClass;
  private Object[] jdField_a_of_type_ArrayOfJavaLangObject;
  
  public ReflectBuilder<T> a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public ReflectBuilder<T> a(Class<?> paramClass, Object paramObject)
  {
    this.jdField_a_of_type_JavaLangClass = paramClass;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    return this;
  }
  
  public ReflectBuilder<T> a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public ReflectBuilder<T> a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public ReflectBuilder<T> a(Class<?>... paramVarArgs)
  {
    this.jdField_a_of_type_ArrayOfJavaLangClass = new Class[paramVarArgs.length];
    System.arraycopy(paramVarArgs, 0, this.jdField_a_of_type_ArrayOfJavaLangClass, 0, paramVarArgs.length);
    return this;
  }
  
  public ReflectBuilder<T> a(Object... paramVarArgs)
  {
    this.jdField_a_of_type_ArrayOfJavaLangObject = new Object[paramVarArgs.length];
    System.arraycopy(paramVarArgs, 0, this.jdField_a_of_type_ArrayOfJavaLangObject, 0, paramVarArgs.length);
    return this;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Int != 8192) || (this.jdField_a_of_type_JavaLangClass == null) || (this.jdField_a_of_type_JavaLangObject == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      throw new ReflectBuilder.WrongParamException();
    }
    if (this.jdField_a_of_type_ArrayOfJavaLangClass.length != this.jdField_a_of_type_ArrayOfJavaLangObject.length) {
      throw new ReflectBuilder.WrongParamException();
    }
    Method localMethod = this.jdField_a_of_type_JavaLangClass.getDeclaredMethod(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfJavaLangClass);
    if (this.jdField_a_of_type_Boolean) {
      localMethod.setAccessible(true);
    }
    localMethod.invoke(this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_ArrayOfJavaLangObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.ReflectBuilder
 * JD-Core Version:    0.7.0.1
 */