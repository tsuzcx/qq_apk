package org.aspectj.internal.lang.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import org.aspectj.lang.annotation.AdviceName;
import org.aspectj.lang.reflect.Advice;
import org.aspectj.lang.reflect.AdviceKind;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.AjTypeSystem;
import org.aspectj.lang.reflect.PointcutExpression;

public class AdviceImpl
  implements Advice
{
  private static final String AJC_INTERNAL = "org.aspectj.runtime.internal";
  private final Method adviceMethod;
  private AjType[] exceptionTypes;
  private Type[] genericParameterTypes;
  private boolean hasExtraParam = false;
  private final AdviceKind kind;
  private AjType[] parameterTypes;
  private PointcutExpression pointcutExpression;
  
  protected AdviceImpl(Method paramMethod, String paramString, AdviceKind paramAdviceKind)
  {
    this.kind = paramAdviceKind;
    this.adviceMethod = paramMethod;
    this.pointcutExpression = new PointcutExpressionImpl(paramString);
  }
  
  protected AdviceImpl(Method paramMethod, String paramString1, AdviceKind paramAdviceKind, String paramString2)
  {
    this(paramMethod, paramString1, paramAdviceKind);
    this.hasExtraParam = true;
  }
  
  public AjType getDeclaringType()
  {
    return AjTypeSystem.getAjType(this.adviceMethod.getDeclaringClass());
  }
  
  public AjType<?>[] getExceptionTypes()
  {
    if (this.exceptionTypes == null)
    {
      Class[] arrayOfClass = this.adviceMethod.getExceptionTypes();
      this.exceptionTypes = new AjType[arrayOfClass.length];
      int i = 0;
      while (i < arrayOfClass.length)
      {
        this.exceptionTypes[i] = AjTypeSystem.getAjType(arrayOfClass[i]);
        i += 1;
      }
    }
    return this.exceptionTypes;
  }
  
  public Type[] getGenericParameterTypes()
  {
    if (this.genericParameterTypes == null)
    {
      Type[] arrayOfType = this.adviceMethod.getGenericParameterTypes();
      int n = arrayOfType.length;
      int m = 0;
      int i = 0;
      Object localObject;
      int k;
      for (int j = 0; i < n; j = k)
      {
        localObject = arrayOfType[i];
        k = j;
        if ((localObject instanceof Class))
        {
          k = j;
          if (((Class)localObject).getPackage().getName().equals("org.aspectj.runtime.internal")) {
            k = j + 1;
          }
        }
        i += 1;
      }
      this.genericParameterTypes = new Type[arrayOfType.length - j];
      i = m;
      for (;;)
      {
        localObject = this.genericParameterTypes;
        if (i >= localObject.length) {
          break;
        }
        if ((arrayOfType[i] instanceof Class)) {
          localObject[i] = AjTypeSystem.getAjType((Class)arrayOfType[i]);
        } else {
          localObject[i] = arrayOfType[i];
        }
        i += 1;
      }
    }
    return this.genericParameterTypes;
  }
  
  public AdviceKind getKind()
  {
    return this.kind;
  }
  
  public String getName()
  {
    String str = this.adviceMethod.getName();
    Object localObject = str;
    if (str.startsWith("ajc$"))
    {
      localObject = (AdviceName)this.adviceMethod.getAnnotation(AdviceName.class);
      if (localObject != null) {
        return ((AdviceName)localObject).value();
      }
      localObject = "";
    }
    return localObject;
  }
  
  public AjType<?>[] getParameterTypes()
  {
    if (this.parameterTypes == null)
    {
      Class[] arrayOfClass = this.adviceMethod.getParameterTypes();
      int n = arrayOfClass.length;
      int m = 0;
      int i = 0;
      int k;
      for (int j = 0; i < n; j = k)
      {
        k = j;
        if (arrayOfClass[i].getPackage().getName().equals("org.aspectj.runtime.internal")) {
          k = j + 1;
        }
        i += 1;
      }
      this.parameterTypes = new AjType[arrayOfClass.length - j];
      i = m;
      for (;;)
      {
        AjType[] arrayOfAjType = this.parameterTypes;
        if (i >= arrayOfAjType.length) {
          break;
        }
        arrayOfAjType[i] = AjTypeSystem.getAjType(arrayOfClass[i]);
        i += 1;
      }
    }
    return this.parameterTypes;
  }
  
  public PointcutExpression getPointcutExpression()
  {
    return this.pointcutExpression;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (getName().length() > 0)
    {
      localStringBuffer.append("@AdviceName(\"");
      localStringBuffer.append(getName());
      localStringBuffer.append("\") ");
    }
    if (getKind() == AdviceKind.AROUND)
    {
      localStringBuffer.append(this.adviceMethod.getGenericReturnType().toString());
      localStringBuffer.append(" ");
    }
    int i = AdviceImpl.1.$SwitchMap$org$aspectj$lang$reflect$AdviceKind[getKind().ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i == 5) {
              localStringBuffer.append("before(");
            }
          }
          else {
            localStringBuffer.append("around(");
          }
        }
        else {
          localStringBuffer.append("after(");
        }
      }
      else {
        localStringBuffer.append("after(");
      }
    }
    else {
      localStringBuffer.append("after(");
    }
    AjType[] arrayOfAjType = getParameterTypes();
    int j = arrayOfAjType.length;
    i = j;
    if (this.hasExtraParam) {
      i = j - 1;
    }
    int k = 0;
    j = 0;
    while (j < i)
    {
      localStringBuffer.append(arrayOfAjType[j].getName());
      int m = j + 1;
      j = m;
      if (m < i)
      {
        localStringBuffer.append(",");
        j = m;
      }
    }
    localStringBuffer.append(") ");
    j = AdviceImpl.1.$SwitchMap$org$aspectj$lang$reflect$AdviceKind[getKind().ordinal()];
    if (j != 2)
    {
      if (j != 3) {
        break label375;
      }
    }
    else
    {
      localStringBuffer.append("returning");
      if (this.hasExtraParam)
      {
        localStringBuffer.append("(");
        localStringBuffer.append(arrayOfAjType[(i - 1)].getName());
        localStringBuffer.append(") ");
      }
    }
    localStringBuffer.append("throwing");
    if (this.hasExtraParam)
    {
      localStringBuffer.append("(");
      localStringBuffer.append(arrayOfAjType[(i - 1)].getName());
      localStringBuffer.append(") ");
    }
    label375:
    arrayOfAjType = getExceptionTypes();
    if (arrayOfAjType.length > 0)
    {
      localStringBuffer.append("throws ");
      i = k;
      while (i < arrayOfAjType.length)
      {
        localStringBuffer.append(arrayOfAjType[i].getName());
        j = i + 1;
        i = j;
        if (j < arrayOfAjType.length)
        {
          localStringBuffer.append(",");
          i = j;
        }
      }
      localStringBuffer.append(" ");
    }
    localStringBuffer.append(": ");
    localStringBuffer.append(getPointcutExpression().asString());
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.internal.lang.reflect.AdviceImpl
 * JD-Core Version:    0.7.0.1
 */