package org.aspectj.internal.lang.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.AjTypeSystem;
import org.aspectj.lang.reflect.InterTypeConstructorDeclaration;

public class InterTypeConstructorDeclarationImpl
  extends InterTypeDeclarationImpl
  implements InterTypeConstructorDeclaration
{
  private Method baseMethod;
  
  public InterTypeConstructorDeclarationImpl(AjType<?> paramAjType, String paramString, int paramInt, Method paramMethod)
  {
    super(paramAjType, paramString, paramInt);
    this.baseMethod = paramMethod;
  }
  
  public AjType<?>[] getExceptionTypes()
  {
    Class[] arrayOfClass = this.baseMethod.getExceptionTypes();
    AjType[] arrayOfAjType = new AjType[arrayOfClass.length];
    int i = 0;
    while (i < arrayOfClass.length)
    {
      arrayOfAjType[i] = AjTypeSystem.getAjType(arrayOfClass[i]);
      i += 1;
    }
    return arrayOfAjType;
  }
  
  public Type[] getGenericParameterTypes()
  {
    Type[] arrayOfType = this.baseMethod.getGenericParameterTypes();
    int j = arrayOfType.length;
    int i = 1;
    AjType[] arrayOfAjType = new AjType[j - 1];
    while (i < arrayOfType.length)
    {
      if ((arrayOfType[i] instanceof Class)) {
        arrayOfAjType[(i - 1)] = AjTypeSystem.getAjType((Class)arrayOfType[i]);
      } else {
        arrayOfAjType[(i - 1)] = arrayOfType[i];
      }
      i += 1;
    }
    return arrayOfAjType;
  }
  
  public AjType<?>[] getParameterTypes()
  {
    Class[] arrayOfClass = this.baseMethod.getParameterTypes();
    int j = arrayOfClass.length;
    int i = 1;
    AjType[] arrayOfAjType = new AjType[j - 1];
    while (i < arrayOfClass.length)
    {
      arrayOfAjType[(i - 1)] = AjTypeSystem.getAjType(arrayOfClass[i]);
      i += 1;
    }
    return arrayOfAjType;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(Modifier.toString(getModifiers()));
    localStringBuffer.append(" ");
    localStringBuffer.append(this.targetTypeName);
    localStringBuffer.append(".new");
    localStringBuffer.append("(");
    AjType[] arrayOfAjType = getParameterTypes();
    int i = 0;
    while (i < arrayOfAjType.length - 1)
    {
      localStringBuffer.append(arrayOfAjType[i].toString());
      localStringBuffer.append(", ");
      i += 1;
    }
    if (arrayOfAjType.length > 0) {
      localStringBuffer.append(arrayOfAjType[(arrayOfAjType.length - 1)].toString());
    }
    localStringBuffer.append(")");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.internal.lang.reflect.InterTypeConstructorDeclarationImpl
 * JD-Core Version:    0.7.0.1
 */