package org.junit.runners.model;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.List;

class NoGenericTypeParametersValidator
{
  private final Method method;
  
  NoGenericTypeParametersValidator(Method paramMethod)
  {
    this.method = paramMethod;
  }
  
  private void validateNoTypeParameterOnGenericArrayType(GenericArrayType paramGenericArrayType, List<Throwable> paramList)
  {
    validateNoTypeParameterOnType(paramGenericArrayType.getGenericComponentType(), paramList);
  }
  
  private void validateNoTypeParameterOnParameterizedType(ParameterizedType paramParameterizedType, List<Throwable> paramList)
  {
    paramParameterizedType = paramParameterizedType.getActualTypeArguments();
    int j = paramParameterizedType.length;
    int i = 0;
    while (i < j)
    {
      validateNoTypeParameterOnType(paramParameterizedType[i], paramList);
      i += 1;
    }
  }
  
  private void validateNoTypeParameterOnType(Type paramType, List<Throwable> paramList)
  {
    if ((paramType instanceof TypeVariable)) {
      paramList.add(new Exception("Method " + this.method.getName() + "() contains unresolved type variable " + paramType));
    }
    do
    {
      return;
      if ((paramType instanceof ParameterizedType))
      {
        validateNoTypeParameterOnParameterizedType((ParameterizedType)paramType, paramList);
        return;
      }
      if ((paramType instanceof WildcardType))
      {
        validateNoTypeParameterOnWildcardType((WildcardType)paramType, paramList);
        return;
      }
    } while (!(paramType instanceof GenericArrayType));
    validateNoTypeParameterOnGenericArrayType((GenericArrayType)paramType, paramList);
  }
  
  private void validateNoTypeParameterOnWildcardType(WildcardType paramWildcardType, List<Throwable> paramList)
  {
    int j = 0;
    Type[] arrayOfType = paramWildcardType.getUpperBounds();
    int k = arrayOfType.length;
    int i = 0;
    while (i < k)
    {
      validateNoTypeParameterOnType(arrayOfType[i], paramList);
      i += 1;
    }
    paramWildcardType = paramWildcardType.getLowerBounds();
    k = paramWildcardType.length;
    i = j;
    while (i < k)
    {
      validateNoTypeParameterOnType(paramWildcardType[i], paramList);
      i += 1;
    }
  }
  
  void validate(List<Throwable> paramList)
  {
    Type[] arrayOfType = this.method.getGenericParameterTypes();
    int j = arrayOfType.length;
    int i = 0;
    while (i < j)
    {
      validateNoTypeParameterOnType(arrayOfType[i], paramList);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.junit.runners.model.NoGenericTypeParametersValidator
 * JD-Core Version:    0.7.0.1
 */