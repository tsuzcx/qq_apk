package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope.Companion;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class IntersectionTypeConstructor
  implements TypeConstructor
{
  private final int hashCode;
  private final LinkedHashSet<KotlinType> intersectedTypes;
  
  public IntersectionTypeConstructor(@NotNull Collection<? extends KotlinType> paramCollection)
  {
    boolean bool = paramCollection.isEmpty();
    if ((_Assertions.ENABLED) && (!(bool ^ true))) {
      throw ((Throwable)new AssertionError("Attempt to create an empty intersection"));
    }
    this.intersectedTypes = new LinkedHashSet(paramCollection);
    this.hashCode = this.intersectedTypes.hashCode();
  }
  
  private final String makeDebugNameForIntersectionType(Iterable<? extends KotlinType> paramIterable)
  {
    return CollectionsKt.joinToString$default((Iterable)CollectionsKt.sortedWith(paramIterable, (Comparator)new IntersectionTypeConstructor.makeDebugNameForIntersectionType..inlined.sortedBy.1()), (CharSequence)" & ", (CharSequence)"{", (CharSequence)"}", 0, null, null, 56, null);
  }
  
  @NotNull
  public final MemberScope createScopeForKotlinType()
  {
    TypeIntersectionScope.Companion localCompanion = TypeIntersectionScope.Companion;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("member scope for intersection type ");
    localStringBuilder.append(this);
    return localCompanion.create(localStringBuilder.toString(), (Collection)this.intersectedTypes);
  }
  
  @NotNull
  public final SimpleType createType()
  {
    return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(Annotations.Companion.getEMPTY(), (TypeConstructor)this, CollectionsKt.emptyList(), false, createScopeForKotlinType(), (Function1)new IntersectionTypeConstructor.createType.1(this));
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((IntersectionTypeConstructor)this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof IntersectionTypeConstructor)) {
      return false;
    }
    return Intrinsics.areEqual(this.intersectedTypes, ((IntersectionTypeConstructor)paramObject).intersectedTypes);
  }
  
  @NotNull
  public KotlinBuiltIns getBuiltIns()
  {
    KotlinBuiltIns localKotlinBuiltIns = ((KotlinType)this.intersectedTypes.iterator().next()).getConstructor().getBuiltIns();
    Intrinsics.checkExpressionValueIsNotNull(localKotlinBuiltIns, "intersectedTypes.iterato…xt().constructor.builtIns");
    return localKotlinBuiltIns;
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
  public Collection<KotlinType> getSupertypes()
  {
    return (Collection)this.intersectedTypes;
  }
  
  public int hashCode()
  {
    return this.hashCode;
  }
  
  public boolean isDenotable()
  {
    return false;
  }
  
  @NotNull
  public IntersectionTypeConstructor refine(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    Object localObject = (Iterable)this.intersectedTypes;
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(((KotlinType)((Iterator)localObject).next()).refine(paramKotlinTypeRefiner));
    }
    return new IntersectionTypeConstructor((Collection)localCollection);
  }
  
  @NotNull
  public String toString()
  {
    return makeDebugNameForIntersectionType((Iterable)this.intersectedTypes);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor
 * JD-Core Version:    0.7.0.1
 */