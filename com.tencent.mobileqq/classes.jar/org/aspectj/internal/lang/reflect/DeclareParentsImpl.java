package org.aspectj.internal.lang.reflect;

import java.lang.reflect.Type;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.DeclareParents;
import org.aspectj.lang.reflect.TypePattern;

public class DeclareParentsImpl
  implements DeclareParents
{
  private AjType<?> declaringType;
  private String firstMissingTypeName;
  private boolean isExtends;
  private Type[] parents;
  private boolean parentsError = false;
  private String parentsString;
  private TypePattern targetTypesPattern;
  
  public DeclareParentsImpl(String paramString1, String paramString2, boolean paramBoolean, AjType<?> paramAjType)
  {
    this.targetTypesPattern = new TypePatternImpl(paramString1);
    this.isExtends = paramBoolean;
    this.declaringType = paramAjType;
    this.parentsString = paramString2;
    try
    {
      this.parents = StringToType.commaSeparatedListToTypeArray(paramString2, paramAjType.getJavaClass());
      return;
    }
    catch (ClassNotFoundException paramString1)
    {
      this.parentsError = true;
      this.firstMissingTypeName = paramString1.getMessage();
    }
  }
  
  public AjType getDeclaringType()
  {
    return this.declaringType;
  }
  
  public Type[] getParentTypes()
  {
    if (!this.parentsError) {
      return this.parents;
    }
    throw new ClassNotFoundException(this.firstMissingTypeName);
  }
  
  public TypePattern getTargetTypesPattern()
  {
    return this.targetTypesPattern;
  }
  
  public boolean isExtends()
  {
    return this.isExtends;
  }
  
  public boolean isImplements()
  {
    return this.isExtends ^ true;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("declare parents : ");
    localStringBuffer.append(getTargetTypesPattern().asString());
    String str;
    if (isExtends()) {
      str = " extends ";
    } else {
      str = " implements ";
    }
    localStringBuffer.append(str);
    localStringBuffer.append(this.parentsString);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.internal.lang.reflect.DeclareParentsImpl
 * JD-Core Version:    0.7.0.1
 */