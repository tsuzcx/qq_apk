package org.aspectj.internal.lang.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.AjTypeSystem;
import org.aspectj.lang.reflect.InterTypeMethodDeclaration;

public class InterTypeMethodDeclarationImpl
  extends InterTypeDeclarationImpl
  implements InterTypeMethodDeclaration
{
  private Method baseMethod;
  private AjType<?>[] exceptionTypes;
  private Type[] genericParameterTypes;
  private Type genericReturnType;
  private String name;
  private int parameterAdjustmentFactor = 1;
  private AjType<?>[] parameterTypes;
  private AjType<?> returnType;
  
  public InterTypeMethodDeclarationImpl(AjType<?> paramAjType, String paramString1, int paramInt, String paramString2, Method paramMethod)
  {
    super(paramAjType, paramString1, paramInt);
    this.name = paramString2;
    this.baseMethod = paramMethod;
  }
  
  public InterTypeMethodDeclarationImpl(AjType<?> paramAjType1, AjType<?> paramAjType2, Method paramMethod, int paramInt)
  {
    super(paramAjType1, paramAjType2, paramInt);
    this.parameterAdjustmentFactor = 0;
    this.name = paramMethod.getName();
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
    int i = this.parameterAdjustmentFactor;
    AjType[] arrayOfAjType = new AjType[j - i];
    while (i < arrayOfType.length)
    {
      if ((arrayOfType[i] instanceof Class)) {
        arrayOfAjType[(i - this.parameterAdjustmentFactor)] = AjTypeSystem.getAjType((Class)arrayOfType[i]);
      } else {
        arrayOfAjType[(i - this.parameterAdjustmentFactor)] = arrayOfType[i];
      }
      i += 1;
    }
    return arrayOfAjType;
  }
  
  public Type getGenericReturnType()
  {
    Type localType = this.baseMethod.getGenericReturnType();
    Object localObject = localType;
    if ((localType instanceof Class)) {
      localObject = AjTypeSystem.getAjType((Class)localType);
    }
    return localObject;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public AjType<?>[] getParameterTypes()
  {
    Class[] arrayOfClass = this.baseMethod.getParameterTypes();
    int j = arrayOfClass.length;
    int i = this.parameterAdjustmentFactor;
    AjType[] arrayOfAjType = new AjType[j - i];
    while (i < arrayOfClass.length)
    {
      arrayOfAjType[(i - this.parameterAdjustmentFactor)] = AjTypeSystem.getAjType(arrayOfClass[i]);
      i += 1;
    }
    return arrayOfAjType;
  }
  
  public AjType<?> getReturnType()
  {
    return AjTypeSystem.getAjType(this.baseMethod.getReturnType());
  }
  
  public TypeVariable<Method>[] getTypeParameters()
  {
    return this.baseMethod.getTypeParameters();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(Modifier.toString(getModifiers()));
    localStringBuffer.append(" ");
    localStringBuffer.append(getReturnType().toString());
    localStringBuffer.append(" ");
    localStringBuffer.append(this.targetTypeName);
    localStringBuffer.append(".");
    localStringBuffer.append(getName());
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
 * Qualified Name:     org.aspectj.internal.lang.reflect.InterTypeMethodDeclarationImpl
 * JD-Core Version:    0.7.0.1
 */