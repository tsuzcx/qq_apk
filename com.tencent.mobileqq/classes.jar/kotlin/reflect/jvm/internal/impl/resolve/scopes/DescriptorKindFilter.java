package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DescriptorKindFilter
{
  @JvmField
  @NotNull
  public static final DescriptorKindFilter ALL;
  private static final int ALL_KINDS_MASK;
  @JvmField
  @NotNull
  public static final DescriptorKindFilter CALLABLES;
  private static final int CALLABLES_MASK;
  @JvmField
  @NotNull
  public static final DescriptorKindFilter CLASSIFIERS;
  private static final int CLASSIFIERS_MASK;
  public static final DescriptorKindFilter.Companion Companion = new DescriptorKindFilter.Companion(null);
  private static final List<DescriptorKindFilter.Companion.MaskToName> DEBUG_MASK_BIT_NAMES;
  private static final List<DescriptorKindFilter.Companion.MaskToName> DEBUG_PREDEFINED_FILTERS_MASK_NAMES;
  @JvmField
  @NotNull
  public static final DescriptorKindFilter FUNCTIONS;
  private static final int FUNCTIONS_MASK;
  @JvmField
  @NotNull
  public static final DescriptorKindFilter NON_SINGLETON_CLASSIFIERS;
  private static final int NON_SINGLETON_CLASSIFIERS_MASK;
  @JvmField
  @NotNull
  public static final DescriptorKindFilter PACKAGES;
  private static final int PACKAGES_MASK;
  @JvmField
  @NotNull
  public static final DescriptorKindFilter SINGLETON_CLASSIFIERS;
  private static final int SINGLETON_CLASSIFIERS_MASK;
  @JvmField
  @NotNull
  public static final DescriptorKindFilter TYPE_ALIASES;
  private static final int TYPE_ALIASES_MASK;
  @JvmField
  @NotNull
  public static final DescriptorKindFilter VALUES;
  private static final int VALUES_MASK;
  @JvmField
  @NotNull
  public static final DescriptorKindFilter VARIABLES;
  private static final int VARIABLES_MASK;
  private static int nextMaskValue = 1;
  @NotNull
  private final List<DescriptorKindExclude> excludes;
  private final int kindMask;
  
  static
  {
    NON_SINGLETON_CLASSIFIERS_MASK = DescriptorKindFilter.Companion.access$nextMask(Companion);
    SINGLETON_CLASSIFIERS_MASK = DescriptorKindFilter.Companion.access$nextMask(Companion);
    TYPE_ALIASES_MASK = DescriptorKindFilter.Companion.access$nextMask(Companion);
    PACKAGES_MASK = DescriptorKindFilter.Companion.access$nextMask(Companion);
    FUNCTIONS_MASK = DescriptorKindFilter.Companion.access$nextMask(Companion);
    VARIABLES_MASK = DescriptorKindFilter.Companion.access$nextMask(Companion);
    ALL_KINDS_MASK = DescriptorKindFilter.Companion.access$nextMask(Companion) - 1;
    int j = NON_SINGLETON_CLASSIFIERS_MASK;
    int i = SINGLETON_CLASSIFIERS_MASK;
    CLASSIFIERS_MASK = j | i | TYPE_ALIASES_MASK;
    j = FUNCTIONS_MASK;
    int k = VARIABLES_MASK;
    VALUES_MASK = i | j | k;
    CALLABLES_MASK = j | k;
    ALL = new DescriptorKindFilter(ALL_KINDS_MASK, null, 2, null);
    CALLABLES = new DescriptorKindFilter(CALLABLES_MASK, null, 2, null);
    NON_SINGLETON_CLASSIFIERS = new DescriptorKindFilter(NON_SINGLETON_CLASSIFIERS_MASK, null, 2, null);
    SINGLETON_CLASSIFIERS = new DescriptorKindFilter(SINGLETON_CLASSIFIERS_MASK, null, 2, null);
    TYPE_ALIASES = new DescriptorKindFilter(TYPE_ALIASES_MASK, null, 2, null);
    CLASSIFIERS = new DescriptorKindFilter(CLASSIFIERS_MASK, null, 2, null);
    PACKAGES = new DescriptorKindFilter(PACKAGES_MASK, null, 2, null);
    FUNCTIONS = new DescriptorKindFilter(FUNCTIONS_MASK, null, 2, null);
    VARIABLES = new DescriptorKindFilter(VARIABLES_MASK, null, 2, null);
    VALUES = new DescriptorKindFilter(VALUES_MASK, null, 2, null);
    Object localObject1 = Companion;
    localObject1 = DescriptorKindFilter.class.getFields();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "T::class.java.fields");
    Object localObject2 = (Collection)new ArrayList();
    j = localObject1.length;
    i = 0;
    while (i < j)
    {
      localObject3 = localObject1[i];
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "it");
      if (Modifier.isStatic(((Field)localObject3).getModifiers())) {
        ((Collection)localObject2).add(localObject3);
      }
      i += 1;
    }
    localObject1 = (Iterable)localObject2;
    Object localObject3 = (Collection)new ArrayList();
    Object localObject4 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      Field localField = (Field)((Iterator)localObject4).next();
      localObject2 = localField.get(null);
      localObject1 = localObject2;
      if (!(localObject2 instanceof DescriptorKindFilter)) {
        localObject1 = null;
      }
      localObject1 = (DescriptorKindFilter)localObject1;
      if (localObject1 != null)
      {
        i = ((DescriptorKindFilter)localObject1).kindMask;
        Intrinsics.checkExpressionValueIsNotNull(localField, "field");
        localObject1 = localField.getName();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "field.name");
        localObject1 = new DescriptorKindFilter.Companion.MaskToName(i, (String)localObject1);
      }
      else
      {
        localObject1 = null;
      }
      if (localObject1 != null) {
        ((Collection)localObject3).add(localObject1);
      }
    }
    DEBUG_PREDEFINED_FILTERS_MASK_NAMES = CollectionsKt.toList((Iterable)localObject3);
    localObject1 = Companion;
    localObject1 = DescriptorKindFilter.class.getFields();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "T::class.java.fields");
    localObject2 = (Collection)new ArrayList();
    j = localObject1.length;
    i = 0;
    while (i < j)
    {
      localObject3 = localObject1[i];
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "it");
      if (Modifier.isStatic(((Field)localObject3).getModifiers())) {
        ((Collection)localObject2).add(localObject3);
      }
      i += 1;
    }
    localObject2 = (Iterable)localObject2;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      localObject4 = (Field)localObject3;
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "it");
      if (Intrinsics.areEqual(((Field)localObject4).getType(), Integer.TYPE)) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject1 = (Iterable)localObject1;
    localObject2 = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = (Field)((Iterator)localObject3).next();
      localObject4 = ((Field)localObject1).get(null);
      if (localObject4 != null)
      {
        j = ((Integer)localObject4).intValue();
        if (j == (-j & j)) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "field");
          localObject1 = ((Field)localObject1).getName();
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "field.name");
          localObject1 = new DescriptorKindFilter.Companion.MaskToName(j, (String)localObject1);
        }
        else
        {
          localObject1 = null;
        }
        if (localObject1 != null) {
          ((Collection)localObject2).add(localObject1);
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
      }
    }
    DEBUG_MASK_BIT_NAMES = CollectionsKt.toList((Iterable)localObject2);
  }
  
  public DescriptorKindFilter(int paramInt, @NotNull List<? extends DescriptorKindExclude> paramList)
  {
    this.excludes = paramList;
    paramList = ((Iterable)this.excludes).iterator();
    while (paramList.hasNext()) {
      paramInt &= (((DescriptorKindExclude)paramList.next()).getFullyExcludedDescriptorKinds() ^ 0xFFFFFFFF);
    }
    this.kindMask = paramInt;
  }
  
  public final boolean acceptsKinds(int paramInt)
  {
    return (paramInt & this.kindMask) != 0;
  }
  
  @NotNull
  public final List<DescriptorKindExclude> getExcludes()
  {
    return this.excludes;
  }
  
  public final int getKindMask()
  {
    return this.kindMask;
  }
  
  @Nullable
  public final DescriptorKindFilter restrictedToKindsOrNull(int paramInt)
  {
    paramInt &= this.kindMask;
    if (paramInt == 0) {
      return null;
    }
    return new DescriptorKindFilter(paramInt, this.excludes);
  }
  
  @NotNull
  public String toString()
  {
    Object localObject2 = ((Iterable)DEBUG_PREDEFINED_FILTERS_MASK_NAMES).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      int i;
      if (((DescriptorKindFilter.Companion.MaskToName)localObject1).getMask() == this.kindMask) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        break label58;
      }
    }
    Object localObject1 = null;
    label58:
    localObject1 = (DescriptorKindFilter.Companion.MaskToName)localObject1;
    if (localObject1 != null) {
      localObject1 = ((DescriptorKindFilter.Companion.MaskToName)localObject1).getName();
    } else {
      localObject1 = null;
    }
    if (localObject1 == null)
    {
      localObject1 = (Iterable)DEBUG_MASK_BIT_NAMES;
      localObject2 = (Collection)new ArrayList();
      Iterator localIterator = ((Iterable)localObject1).iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (DescriptorKindFilter.Companion.MaskToName)localIterator.next();
        if (acceptsKinds(((DescriptorKindFilter.Companion.MaskToName)localObject1).getMask())) {
          localObject1 = ((DescriptorKindFilter.Companion.MaskToName)localObject1).getName();
        } else {
          localObject1 = null;
        }
        if (localObject1 != null) {
          ((Collection)localObject2).add(localObject1);
        }
      }
      localObject1 = CollectionsKt.joinToString$default((Iterable)localObject2, (CharSequence)" | ", null, null, 0, null, null, 62, null);
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("DescriptorKindFilter(");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(", ");
    ((StringBuilder)localObject2).append(this.excludes);
    ((StringBuilder)localObject2).append(')');
    return ((StringBuilder)localObject2).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter
 * JD-Core Version:    0.7.0.1
 */