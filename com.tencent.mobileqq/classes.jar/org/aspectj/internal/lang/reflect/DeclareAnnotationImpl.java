package org.aspectj.internal.lang.reflect;

import java.lang.annotation.Annotation;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.DeclareAnnotation;
import org.aspectj.lang.reflect.DeclareAnnotation.Kind;
import org.aspectj.lang.reflect.SignaturePattern;
import org.aspectj.lang.reflect.TypePattern;

public class DeclareAnnotationImpl
  implements DeclareAnnotation
{
  private String annText;
  private AjType<?> declaringType;
  private DeclareAnnotation.Kind kind;
  private SignaturePattern signaturePattern;
  private Annotation theAnnotation;
  private TypePattern typePattern;
  
  public DeclareAnnotationImpl(AjType<?> paramAjType, String paramString1, String paramString2, Annotation paramAnnotation, String paramString3)
  {
    this.declaringType = paramAjType;
    if (paramString1.equals("at_type"))
    {
      this.kind = DeclareAnnotation.Kind.Type;
    }
    else if (paramString1.equals("at_field"))
    {
      this.kind = DeclareAnnotation.Kind.Field;
    }
    else if (paramString1.equals("at_method"))
    {
      this.kind = DeclareAnnotation.Kind.Method;
    }
    else
    {
      if (!paramString1.equals("at_constructor")) {
        break label132;
      }
      this.kind = DeclareAnnotation.Kind.Constructor;
    }
    if (this.kind == DeclareAnnotation.Kind.Type) {
      this.typePattern = new TypePatternImpl(paramString2);
    } else {
      this.signaturePattern = new SignaturePatternImpl(paramString2);
    }
    this.theAnnotation = paramAnnotation;
    this.annText = paramString3;
    return;
    label132:
    paramAjType = new StringBuilder();
    paramAjType.append("Unknown declare annotation kind: ");
    paramAjType.append(paramString1);
    throw new IllegalStateException(paramAjType.toString());
  }
  
  public Annotation getAnnotation()
  {
    return this.theAnnotation;
  }
  
  public String getAnnotationAsText()
  {
    return this.annText;
  }
  
  public AjType<?> getDeclaringType()
  {
    return this.declaringType;
  }
  
  public DeclareAnnotation.Kind getKind()
  {
    return this.kind;
  }
  
  public SignaturePattern getSignaturePattern()
  {
    return this.signaturePattern;
  }
  
  public TypePattern getTypePattern()
  {
    return this.typePattern;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("declare @");
    int i = DeclareAnnotationImpl.1.$SwitchMap$org$aspectj$lang$reflect$DeclareAnnotation$Kind[getKind().ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4)
          {
            localStringBuffer.append("constructor : ");
            localStringBuffer.append(getSignaturePattern().asString());
          }
        }
        else
        {
          localStringBuffer.append("field : ");
          localStringBuffer.append(getSignaturePattern().asString());
        }
      }
      else
      {
        localStringBuffer.append("method : ");
        localStringBuffer.append(getSignaturePattern().asString());
      }
    }
    else
    {
      localStringBuffer.append("type : ");
      localStringBuffer.append(getTypePattern().asString());
    }
    localStringBuffer.append(" : ");
    localStringBuffer.append(getAnnotationAsText());
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.internal.lang.reflect.DeclareAnnotationImpl
 * JD-Core Version:    0.7.0.1
 */