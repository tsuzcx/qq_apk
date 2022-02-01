package kotlin.jvm.internal;

import java.util.List;
import kotlin.SinceKotlin;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

public class ReflectionFactory
{
  private static final String KOTLIN_JVM_FUNCTIONS = "kotlin.jvm.functions.";
  
  public KClass createKotlinClass(Class paramClass)
  {
    return new ClassReference(paramClass);
  }
  
  public KClass createKotlinClass(Class paramClass, String paramString)
  {
    return new ClassReference(paramClass);
  }
  
  public KFunction function(FunctionReference paramFunctionReference)
  {
    return paramFunctionReference;
  }
  
  public KClass getOrCreateKotlinClass(Class paramClass)
  {
    return new ClassReference(paramClass);
  }
  
  public KClass getOrCreateKotlinClass(Class paramClass, String paramString)
  {
    return new ClassReference(paramClass);
  }
  
  public KDeclarationContainer getOrCreateKotlinPackage(Class paramClass, String paramString)
  {
    return new PackageReference(paramClass, paramString);
  }
  
  public KMutableProperty0 mutableProperty0(MutablePropertyReference0 paramMutablePropertyReference0)
  {
    return paramMutablePropertyReference0;
  }
  
  public KMutableProperty1 mutableProperty1(MutablePropertyReference1 paramMutablePropertyReference1)
  {
    return paramMutablePropertyReference1;
  }
  
  public KMutableProperty2 mutableProperty2(MutablePropertyReference2 paramMutablePropertyReference2)
  {
    return paramMutablePropertyReference2;
  }
  
  public KProperty0 property0(PropertyReference0 paramPropertyReference0)
  {
    return paramPropertyReference0;
  }
  
  public KProperty1 property1(PropertyReference1 paramPropertyReference1)
  {
    return paramPropertyReference1;
  }
  
  public KProperty2 property2(PropertyReference2 paramPropertyReference2)
  {
    return paramPropertyReference2;
  }
  
  @SinceKotlin(version="1.3")
  public String renderLambdaToString(FunctionBase paramFunctionBase)
  {
    String str = paramFunctionBase.getClass().getGenericInterfaces()[0].toString();
    paramFunctionBase = str;
    if (str.startsWith("kotlin.jvm.functions.")) {
      paramFunctionBase = str.substring("kotlin.jvm.functions.".length());
    }
    return paramFunctionBase;
  }
  
  @SinceKotlin(version="1.1")
  public String renderLambdaToString(Lambda paramLambda)
  {
    return renderLambdaToString(paramLambda);
  }
  
  @SinceKotlin(version="1.4")
  public KType typeOf(KClassifier paramKClassifier, List<KTypeProjection> paramList, boolean paramBoolean)
  {
    return new TypeReference(paramKClassifier, paramList, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.jvm.internal.ReflectionFactory
 * JD-Core Version:    0.7.0.1
 */