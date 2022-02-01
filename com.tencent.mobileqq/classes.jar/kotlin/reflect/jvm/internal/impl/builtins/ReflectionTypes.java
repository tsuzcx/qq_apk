package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;

public final class ReflectionTypes
{
  public static final ReflectionTypes.Companion Companion = new ReflectionTypes.Companion(null);
  @NotNull
  private final ReflectionTypes.ClassLookup kClass$delegate;
  @NotNull
  private final ReflectionTypes.ClassLookup kMutableProperty0$delegate;
  @NotNull
  private final ReflectionTypes.ClassLookup kMutableProperty1$delegate;
  @NotNull
  private final ReflectionTypes.ClassLookup kMutableProperty2$delegate;
  @NotNull
  private final ReflectionTypes.ClassLookup kProperty$delegate;
  @NotNull
  private final ReflectionTypes.ClassLookup kProperty0$delegate;
  @NotNull
  private final ReflectionTypes.ClassLookup kProperty1$delegate;
  @NotNull
  private final ReflectionTypes.ClassLookup kProperty2$delegate;
  private final Lazy kotlinReflectScope$delegate;
  private final NotFoundClasses notFoundClasses;
  
  public ReflectionTypes(@NotNull ModuleDescriptor paramModuleDescriptor, @NotNull NotFoundClasses paramNotFoundClasses)
  {
    this.notFoundClasses = paramNotFoundClasses;
    this.kotlinReflectScope$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0)new ReflectionTypes.kotlinReflectScope.2(paramModuleDescriptor));
    this.kClass$delegate = new ReflectionTypes.ClassLookup(1);
    this.kProperty$delegate = new ReflectionTypes.ClassLookup(1);
    this.kProperty0$delegate = new ReflectionTypes.ClassLookup(1);
    this.kProperty1$delegate = new ReflectionTypes.ClassLookup(2);
    this.kProperty2$delegate = new ReflectionTypes.ClassLookup(3);
    this.kMutableProperty0$delegate = new ReflectionTypes.ClassLookup(1);
    this.kMutableProperty1$delegate = new ReflectionTypes.ClassLookup(2);
    this.kMutableProperty2$delegate = new ReflectionTypes.ClassLookup(3);
  }
  
  private final ClassDescriptor find(String paramString, int paramInt)
  {
    Name localName = Name.identifier(paramString);
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(className)");
    ClassifierDescriptor localClassifierDescriptor = getKotlinReflectScope().getContributedClassifier(localName, (LookupLocation)NoLookupLocation.FROM_REFLECTION);
    paramString = localClassifierDescriptor;
    if (!(localClassifierDescriptor instanceof ClassDescriptor)) {
      paramString = null;
    }
    paramString = (ClassDescriptor)paramString;
    if (paramString != null) {
      return paramString;
    }
    return this.notFoundClasses.getClass(new ClassId(ReflectionTypesKt.getKOTLIN_REFLECT_FQ_NAME(), localName), CollectionsKt.listOf(Integer.valueOf(paramInt)));
  }
  
  private final MemberScope getKotlinReflectScope()
  {
    return (MemberScope)this.kotlinReflectScope$delegate.getValue();
  }
  
  @NotNull
  public final ClassDescriptor getKClass()
  {
    return this.kClass$delegate.getValue(this, $$delegatedProperties[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes
 * JD-Core Version:    0.7.0.1
 */