package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "", "jClass", "Ljava/lang/Class;", "parameterNames", "", "", "callMode", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "origin", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "methods", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/List;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;Ljava/util/List;)V", "defaultValues", "", "erasedParameterTypes", "member", "getMember", "()Ljava/lang/Void;", "parameterTypes", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "CallMode", "Origin", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class AnnotationConstructorCaller
  implements Caller
{
  private final AnnotationConstructorCaller.CallMode callMode;
  private final List<Object> defaultValues;
  private final List<Class<?>> erasedParameterTypes;
  private final Class<?> jClass;
  private final List<Method> methods;
  private final List<String> parameterNames;
  @NotNull
  private final List<Type> parameterTypes;
  
  public AnnotationConstructorCaller(@NotNull Class<?> paramClass, @NotNull List<String> paramList, @NotNull AnnotationConstructorCaller.CallMode paramCallMode, @NotNull AnnotationConstructorCaller.Origin paramOrigin, @NotNull List<Method> paramList1)
  {
    this.jClass = paramClass;
    this.parameterNames = paramList;
    this.callMode = paramCallMode;
    this.methods = paramList1;
    paramList = (Iterable)this.methods;
    paramClass = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramList, 10));
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramClass.add(((Method)paramList.next()).getGenericReturnType());
    }
    this.parameterTypes = ((List)paramClass);
    paramClass = (Iterable)this.methods;
    paramCallMode = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramClass, 10));
    paramList1 = paramClass.iterator();
    while (paramList1.hasNext())
    {
      paramClass = ((Method)paramList1.next()).getReturnType();
      Intrinsics.checkExpressionValueIsNotNull(paramClass, "it");
      paramList = ReflectClassUtilKt.getWrapperByPrimitive(paramClass);
      if (paramList != null) {
        paramClass = paramList;
      }
      paramCallMode.add(paramClass);
    }
    this.erasedParameterTypes = ((List)paramCallMode);
    paramList = (Iterable)this.methods;
    paramClass = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramList, 10));
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramClass.add(((Method)paramList.next()).getDefaultValue());
    }
    this.defaultValues = ((List)paramClass);
    if ((this.callMode == AnnotationConstructorCaller.CallMode.POSITIONAL_CALL) && (paramOrigin == AnnotationConstructorCaller.Origin.JAVA))
    {
      if (!(((Collection)CollectionsKt.minus((Iterable)this.parameterNames, "value")).isEmpty() ^ true)) {
        return;
      }
      throw ((Throwable)new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead."));
    }
  }
  
  @Nullable
  public Object call(@NotNull Object[] paramArrayOfObject)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfObject, "args");
    checkArguments(paramArrayOfObject);
    Collection localCollection = (Collection)new ArrayList(paramArrayOfObject.length);
    int k = paramArrayOfObject.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      Object localObject = paramArrayOfObject[j];
      if ((localObject == null) && (this.callMode == AnnotationConstructorCaller.CallMode.CALL_BY_NAME)) {
        localObject = this.defaultValues.get(i);
      } else {
        localObject = AnnotationConstructorCallerKt.access$transformKotlinToJvm(localObject, (Class)this.erasedParameterTypes.get(i));
      }
      if (localObject != null)
      {
        localCollection.add(localObject);
        j += 1;
        i += 1;
      }
      else
      {
        AnnotationConstructorCallerKt.access$throwIllegalArgumentType(i, (String)this.parameterNames.get(i), (Class)this.erasedParameterTypes.get(i));
        throw null;
      }
    }
    paramArrayOfObject = (List)localCollection;
    return AnnotationConstructorCallerKt.createAnnotationInstance(this.jClass, MapsKt.toMap((Iterable)CollectionsKt.zip((Iterable)this.parameterNames, (Iterable)paramArrayOfObject)), this.methods);
  }
  
  public void checkArguments(@NotNull Object[] paramArrayOfObject)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfObject, "args");
    Caller.DefaultImpls.checkArguments(this, paramArrayOfObject);
  }
  
  @Nullable
  public Void getMember()
  {
    return null;
  }
  
  @NotNull
  public List<Type> getParameterTypes()
  {
    return this.parameterTypes;
  }
  
  @NotNull
  public Type getReturnType()
  {
    return (Type)this.jClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller
 * JD-Core Version:    0.7.0.1
 */