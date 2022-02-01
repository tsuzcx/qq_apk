package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class IntegerLiteralTypeConstructor
  implements TypeConstructor
{
  public static final IntegerLiteralTypeConstructor.Companion Companion = new IntegerLiteralTypeConstructor.Companion(null);
  private final ModuleDescriptor module;
  @NotNull
  private final Set<KotlinType> possibleTypes;
  private final Lazy supertypes$delegate = LazyKt.lazy((Function0)new IntegerLiteralTypeConstructor.supertypes.2(this));
  private final SimpleType type = KotlinTypeFactory.integerLiteralType(Annotations.Companion.getEMPTY(), this, false);
  private final long value;
  
  private IntegerLiteralTypeConstructor(long paramLong, ModuleDescriptor paramModuleDescriptor, Set<? extends KotlinType> paramSet)
  {
    this.value = paramLong;
    this.module = paramModuleDescriptor;
    this.possibleTypes = paramSet;
  }
  
  private final List<KotlinType> getSupertypes()
  {
    return (List)this.supertypes$delegate.getValue();
  }
  
  private final boolean isContainsOnlyUnsignedTypes()
  {
    Object localObject = (Iterable)PrimitiveTypeUtilKt.getAllSignedLiteralTypes(this.module);
    boolean bool1 = localObject instanceof Collection;
    boolean bool2 = true;
    if ((bool1) && (((Collection)localObject).isEmpty())) {
      return true;
    }
    localObject = ((Iterable)localObject).iterator();
    KotlinType localKotlinType;
    do
    {
      bool1 = bool2;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localKotlinType = (KotlinType)((Iterator)localObject).next();
    } while ((this.possibleTypes.contains(localKotlinType) ^ true));
    bool1 = false;
    return bool1;
  }
  
  private final String valueToString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[');
    localStringBuilder.append(CollectionsKt.joinToString$default((Iterable)this.possibleTypes, (CharSequence)",", null, null, 0, null, (Function1)IntegerLiteralTypeConstructor.valueToString.1.INSTANCE, 30, null));
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public final boolean checkConstructor(@NotNull TypeConstructor paramTypeConstructor)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructor, "constructor");
    Object localObject = (Iterable)this.possibleTypes;
    boolean bool1 = localObject instanceof Collection;
    boolean bool2 = false;
    if ((bool1) && (((Collection)localObject).isEmpty())) {
      return false;
    }
    localObject = ((Iterable)localObject).iterator();
    do
    {
      bool1 = bool2;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
    } while (!Intrinsics.areEqual(((KotlinType)((Iterator)localObject).next()).getConstructor(), paramTypeConstructor));
    bool1 = true;
    return bool1;
  }
  
  @NotNull
  public KotlinBuiltIns getBuiltIns()
  {
    return this.module.getBuiltIns();
  }
  
  @Nullable
  public ClassifierDescriptor getDeclarationDescriptor()
  {
    return null;
  }
  
  @NotNull
  public List<TypeParameterDescriptor> getParameters()
  {
    return CollectionsKt.emptyList();
  }
  
  @NotNull
  public final Set<KotlinType> getPossibleTypes()
  {
    return this.possibleTypes;
  }
  
  @NotNull
  public Collection<KotlinType> getSupertypes()
  {
    return (Collection)getSupertypes();
  }
  
  public boolean isDenotable()
  {
    return false;
  }
  
  @NotNull
  public TypeConstructor refine(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    return (TypeConstructor)this;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IntegerLiteralType");
    localStringBuilder.append(valueToString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor
 * JD-Core Version:    0.7.0.1
 */