package kotlin.reflect.jvm.internal;

import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference2;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference2;
import kotlin.jvm.internal.ReflectionFactory;
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
import kotlin.reflect.full.KClassifiers;
import kotlin.reflect.jvm.ReflectLambdaKt;

public class ReflectionFactoryImpl
  extends ReflectionFactory
{
  public static void clearCaches()
  {
    KClassCacheKt.clearKClassCache();
    ModuleByClassLoaderKt.clearModuleByClassLoaderCache();
  }
  
  private static KDeclarationContainerImpl getOwner(CallableReference paramCallableReference)
  {
    paramCallableReference = paramCallableReference.getOwner();
    if ((paramCallableReference instanceof KDeclarationContainerImpl)) {
      return (KDeclarationContainerImpl)paramCallableReference;
    }
    return EmptyContainerForLocal.INSTANCE;
  }
  
  public KClass createKotlinClass(Class paramClass)
  {
    return new KClassImpl(paramClass);
  }
  
  public KClass createKotlinClass(Class paramClass, String paramString)
  {
    return new KClassImpl(paramClass);
  }
  
  public KFunction function(FunctionReference paramFunctionReference)
  {
    return new KFunctionImpl(getOwner(paramFunctionReference), paramFunctionReference.getName(), paramFunctionReference.getSignature(), paramFunctionReference.getBoundReceiver());
  }
  
  public KClass getOrCreateKotlinClass(Class paramClass)
  {
    return KClassCacheKt.getOrCreateKotlinClass(paramClass);
  }
  
  public KClass getOrCreateKotlinClass(Class paramClass, String paramString)
  {
    return KClassCacheKt.getOrCreateKotlinClass(paramClass);
  }
  
  public KDeclarationContainer getOrCreateKotlinPackage(Class paramClass, String paramString)
  {
    return new KPackageImpl(paramClass, paramString);
  }
  
  public KMutableProperty0 mutableProperty0(MutablePropertyReference0 paramMutablePropertyReference0)
  {
    return new KMutableProperty0Impl(getOwner(paramMutablePropertyReference0), paramMutablePropertyReference0.getName(), paramMutablePropertyReference0.getSignature(), paramMutablePropertyReference0.getBoundReceiver());
  }
  
  public KMutableProperty1 mutableProperty1(MutablePropertyReference1 paramMutablePropertyReference1)
  {
    return new KMutableProperty1Impl(getOwner(paramMutablePropertyReference1), paramMutablePropertyReference1.getName(), paramMutablePropertyReference1.getSignature(), paramMutablePropertyReference1.getBoundReceiver());
  }
  
  public KMutableProperty2 mutableProperty2(MutablePropertyReference2 paramMutablePropertyReference2)
  {
    return new KMutableProperty2Impl(getOwner(paramMutablePropertyReference2), paramMutablePropertyReference2.getName(), paramMutablePropertyReference2.getSignature());
  }
  
  public KProperty0 property0(PropertyReference0 paramPropertyReference0)
  {
    return new KProperty0Impl(getOwner(paramPropertyReference0), paramPropertyReference0.getName(), paramPropertyReference0.getSignature(), paramPropertyReference0.getBoundReceiver());
  }
  
  public KProperty1 property1(PropertyReference1 paramPropertyReference1)
  {
    return new KProperty1Impl(getOwner(paramPropertyReference1), paramPropertyReference1.getName(), paramPropertyReference1.getSignature(), paramPropertyReference1.getBoundReceiver());
  }
  
  public KProperty2 property2(PropertyReference2 paramPropertyReference2)
  {
    return new KProperty2Impl(getOwner(paramPropertyReference2), paramPropertyReference2.getName(), paramPropertyReference2.getSignature());
  }
  
  public String renderLambdaToString(FunctionBase paramFunctionBase)
  {
    Object localObject = ReflectLambdaKt.reflect(paramFunctionBase);
    if (localObject != null)
    {
      localObject = UtilKt.asKFunctionImpl(localObject);
      if (localObject != null) {
        return ReflectionObjectRenderer.INSTANCE.renderLambda(((KFunctionImpl)localObject).getDescriptor());
      }
    }
    return super.renderLambdaToString(paramFunctionBase);
  }
  
  public String renderLambdaToString(Lambda paramLambda)
  {
    return renderLambdaToString(paramLambda);
  }
  
  public KType typeOf(KClassifier paramKClassifier, List<KTypeProjection> paramList, boolean paramBoolean)
  {
    return KClassifiers.createType(paramKClassifier, paramList, paramBoolean, Collections.emptyList());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.ReflectionFactoryImpl
 * JD-Core Version:    0.7.0.1
 */