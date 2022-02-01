package com.tencent.mobileqq.pic.operator;

import java.util.HashMap;

public class OperatorMap<T extends AbstractPicOperator>
{
  private Class<T> jdField_a_of_type_JavaLangClass;
  HashMap<Integer, Class<? extends T>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public OperatorMap(Class<T> paramClass)
  {
    this.jdField_a_of_type_JavaLangClass = paramClass;
  }
  
  public Class<? extends T> a(int paramInt)
  {
    Class localClass2 = (Class)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    Class localClass1 = localClass2;
    if (localClass2 == null) {
      localClass1 = this.jdField_a_of_type_JavaLangClass;
    }
    return localClass1;
  }
  
  public void a(int paramInt, Class<? extends T> paramClass)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.OperatorMap
 * JD-Core Version:    0.7.0.1
 */