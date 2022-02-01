package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin._Assertions;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class StaticScopeForKotlinEnum
  extends MemberScopeImpl
{
  private final ClassDescriptor containingClass;
  private final NotNullLazyValue functions$delegate;
  
  public StaticScopeForKotlinEnum(@NotNull StorageManager paramStorageManager, @NotNull ClassDescriptor paramClassDescriptor)
  {
    this.containingClass = paramClassDescriptor;
    int i;
    if (this.containingClass.getKind() == ClassKind.ENUM_CLASS) {
      i = 1;
    } else {
      i = 0;
    }
    if ((_Assertions.ENABLED) && (i == 0))
    {
      paramStorageManager = new StringBuilder();
      paramStorageManager.append("Class should be an enum: ");
      paramStorageManager.append(this.containingClass);
      throw ((Throwable)new AssertionError(paramStorageManager.toString()));
    }
    this.functions$delegate = paramStorageManager.createLazyValue((Function0)new StaticScopeForKotlinEnum.functions.2(this));
  }
  
  private final List<SimpleFunctionDescriptor> getFunctions()
  {
    return (List)StorageKt.getValue(this.functions$delegate, this, $$delegatedProperties[0]);
  }
  
  @Nullable
  public Void getContributedClassifier(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "location");
    return null;
  }
  
  @NotNull
  public List<SimpleFunctionDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter paramDescriptorKindFilter, @NotNull Function1<? super Name, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramDescriptorKindFilter, "kindFilter");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "nameFilter");
    return getFunctions();
  }
  
  @NotNull
  public ArrayList<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "location");
    Object localObject1 = (Iterable)getFunctions();
    paramLookupLocation = (Collection)new ArrayList(1);
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (Intrinsics.areEqual(((SimpleFunctionDescriptor)localObject2).getName(), paramName)) {
        paramLookupLocation.add(localObject2);
      }
    }
    return (ArrayList)paramLookupLocation;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.scopes.StaticScopeForKotlinEnum
 * JD-Core Version:    0.7.0.1
 */