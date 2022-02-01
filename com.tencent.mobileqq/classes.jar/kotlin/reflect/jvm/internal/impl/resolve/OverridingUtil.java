package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collection<Lkotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;>;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyAccessorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeCheckerImpl;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner.Default;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class OverridingUtil
{
  public static final OverridingUtil DEFAULT = new OverridingUtil(DEFAULT_TYPE_CONSTRUCTOR_EQUALITY, KotlinTypeRefiner.Default.INSTANCE);
  private static final KotlinTypeChecker.TypeConstructorEquality DEFAULT_TYPE_CONSTRUCTOR_EQUALITY;
  private static final List<ExternalOverridabilityCondition> EXTERNAL_CONDITIONS = CollectionsKt.toList(ServiceLoader.load(ExternalOverridabilityCondition.class, ExternalOverridabilityCondition.class.getClassLoader()));
  private final KotlinTypeChecker.TypeConstructorEquality equalityAxioms;
  private final KotlinTypeRefiner kotlinTypeRefiner;
  
  static
  {
    DEFAULT_TYPE_CONSTRUCTOR_EQUALITY = new OverridingUtil.1();
  }
  
  private OverridingUtil(@NotNull KotlinTypeChecker.TypeConstructorEquality paramTypeConstructorEquality, @NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    this.equalityAxioms = paramTypeConstructorEquality;
    this.kotlinTypeRefiner = paramKotlinTypeRefiner;
  }
  
  private static boolean allHasSameContainingDeclaration(@NotNull Collection<CallableMemberDescriptor> paramCollection)
  {
    if (paramCollection == null) {
      $$$reportNull$$$0(59);
    }
    if (paramCollection.size() < 2) {
      return true;
    }
    return CollectionsKt.all(paramCollection, new OverridingUtil.4(((CallableMemberDescriptor)paramCollection.iterator().next()).getContainingDeclaration()));
  }
  
  private boolean areTypeParametersEquivalent(@NotNull TypeParameterDescriptor paramTypeParameterDescriptor1, @NotNull TypeParameterDescriptor paramTypeParameterDescriptor2, @NotNull KotlinTypeChecker paramKotlinTypeChecker)
  {
    if (paramTypeParameterDescriptor1 == null) {
      $$$reportNull$$$0(45);
    }
    if (paramTypeParameterDescriptor2 == null) {
      $$$reportNull$$$0(46);
    }
    if (paramKotlinTypeChecker == null) {
      $$$reportNull$$$0(47);
    }
    Object localObject = paramTypeParameterDescriptor1.getUpperBounds();
    paramTypeParameterDescriptor1 = new ArrayList(paramTypeParameterDescriptor2.getUpperBounds());
    if (((List)localObject).size() != paramTypeParameterDescriptor1.size()) {
      return false;
    }
    paramTypeParameterDescriptor2 = ((List)localObject).iterator();
    while (paramTypeParameterDescriptor2.hasNext())
    {
      localObject = (KotlinType)paramTypeParameterDescriptor2.next();
      ListIterator localListIterator = paramTypeParameterDescriptor1.listIterator();
      for (;;)
      {
        if (localListIterator.hasNext()) {
          if (areTypesEquivalent((KotlinType)localObject, (KotlinType)localListIterator.next(), paramKotlinTypeChecker))
          {
            localListIterator.remove();
            break;
          }
        }
      }
      return false;
    }
    return true;
  }
  
  private boolean areTypesEquivalent(@NotNull KotlinType paramKotlinType1, @NotNull KotlinType paramKotlinType2, @NotNull KotlinTypeChecker paramKotlinTypeChecker)
  {
    if (paramKotlinType1 == null) {
      $$$reportNull$$$0(42);
    }
    if (paramKotlinType2 == null) {
      $$$reportNull$$$0(43);
    }
    if (paramKotlinTypeChecker == null) {
      $$$reportNull$$$0(44);
    }
    int i;
    if ((KotlinTypeKt.isError(paramKotlinType1)) && (KotlinTypeKt.isError(paramKotlinType2))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return true;
    }
    return paramKotlinTypeChecker.equalTypes(this.kotlinTypeRefiner.refineType(paramKotlinType1), this.kotlinTypeRefiner.refineType(paramKotlinType2));
  }
  
  @Nullable
  private static OverridingUtil.OverrideCompatibilityInfo checkReceiverAndParameterCount(CallableDescriptor paramCallableDescriptor1, CallableDescriptor paramCallableDescriptor2)
  {
    ReceiverParameterDescriptor localReceiverParameterDescriptor = paramCallableDescriptor1.getExtensionReceiverParameter();
    int j = 1;
    int i;
    if (localReceiverParameterDescriptor == null) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramCallableDescriptor2.getExtensionReceiverParameter() != null) {
      j = 0;
    }
    if (i != j) {
      return OverridingUtil.OverrideCompatibilityInfo.incompatible("Receiver presence mismatch");
    }
    if (paramCallableDescriptor1.getValueParameters().size() != paramCallableDescriptor2.getValueParameters().size()) {
      return OverridingUtil.OverrideCompatibilityInfo.incompatible("Value parameter number mismatch");
    }
    return null;
  }
  
  private static void collectOverriddenDeclarations(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor, @NotNull Set<CallableMemberDescriptor> paramSet)
  {
    if (paramCallableMemberDescriptor == null) {
      $$$reportNull$$$0(13);
    }
    if (paramSet == null) {
      $$$reportNull$$$0(14);
    }
    if (paramCallableMemberDescriptor.getKind().isReal())
    {
      paramSet.add(paramCallableMemberDescriptor);
      return;
    }
    if (!paramCallableMemberDescriptor.getOverriddenDescriptors().isEmpty())
    {
      paramCallableMemberDescriptor = paramCallableMemberDescriptor.getOverriddenDescriptors().iterator();
      while (paramCallableMemberDescriptor.hasNext()) {
        collectOverriddenDeclarations((CallableMemberDescriptor)paramCallableMemberDescriptor.next(), paramSet);
      }
      return;
    }
    paramSet = new StringBuilder();
    paramSet.append("No overridden descriptors found for (fake override) ");
    paramSet.append(paramCallableMemberDescriptor);
    paramCallableMemberDescriptor = new IllegalStateException(paramSet.toString());
    for (;;)
    {
      throw paramCallableMemberDescriptor;
    }
  }
  
  private static List<KotlinType> compiledValueParameters(CallableDescriptor paramCallableDescriptor)
  {
    ReceiverParameterDescriptor localReceiverParameterDescriptor = paramCallableDescriptor.getExtensionReceiverParameter();
    ArrayList localArrayList = new ArrayList();
    if (localReceiverParameterDescriptor != null) {
      localArrayList.add(localReceiverParameterDescriptor.getType());
    }
    paramCallableDescriptor = paramCallableDescriptor.getValueParameters().iterator();
    while (paramCallableDescriptor.hasNext()) {
      localArrayList.add(((ValueParameterDescriptor)paramCallableDescriptor.next()).getType());
    }
    return localArrayList;
  }
  
  @Nullable
  private static Visibility computeVisibilityToInherit(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    if (paramCallableMemberDescriptor == null) {
      $$$reportNull$$$0(103);
    }
    Object localObject = paramCallableMemberDescriptor.getOverriddenDescriptors();
    Visibility localVisibility = findMaxVisibility((Collection)localObject);
    if (localVisibility == null) {
      return null;
    }
    if (paramCallableMemberDescriptor.getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE)
    {
      paramCallableMemberDescriptor = ((Collection)localObject).iterator();
      while (paramCallableMemberDescriptor.hasNext())
      {
        localObject = (CallableMemberDescriptor)paramCallableMemberDescriptor.next();
        if ((((CallableMemberDescriptor)localObject).getModality() != Modality.ABSTRACT) && (!((CallableMemberDescriptor)localObject).getVisibility().equals(localVisibility))) {
          return null;
        }
      }
      return localVisibility;
    }
    return localVisibility.normalize();
  }
  
  private static void createAndBindFakeOverride(@NotNull Collection<CallableMemberDescriptor> paramCollection, @NotNull ClassDescriptor paramClassDescriptor, @NotNull OverridingStrategy paramOverridingStrategy)
  {
    if (paramCollection == null) {
      $$$reportNull$$$0(80);
    }
    if (paramClassDescriptor == null) {
      $$$reportNull$$$0(81);
    }
    if (paramOverridingStrategy == null) {
      $$$reportNull$$$0(82);
    }
    Object localObject = filterVisibleFakeOverrides(paramClassDescriptor, paramCollection);
    boolean bool = ((Collection)localObject).isEmpty();
    if (!bool) {
      paramCollection = (Collection<CallableMemberDescriptor>)localObject;
    }
    Modality localModality = determineModalityForFakeOverride(paramCollection, paramClassDescriptor);
    if (bool) {
      localObject = Visibilities.INVISIBLE_FAKE;
    } else {
      localObject = Visibilities.INHERITED;
    }
    paramClassDescriptor = ((CallableMemberDescriptor)selectMostSpecificMember(paramCollection, new OverridingUtil.5())).copy(paramClassDescriptor, localModality, (Visibility)localObject, CallableMemberDescriptor.Kind.FAKE_OVERRIDE, false);
    paramOverridingStrategy.setOverriddenDescriptors(paramClassDescriptor, paramCollection);
    paramOverridingStrategy.addFakeOverride(paramClassDescriptor);
  }
  
  private static void createAndBindFakeOverrides(@NotNull ClassDescriptor paramClassDescriptor, @NotNull Collection<CallableMemberDescriptor> paramCollection, @NotNull OverridingStrategy paramOverridingStrategy)
  {
    if (paramClassDescriptor == null) {
      $$$reportNull$$$0(60);
    }
    if (paramCollection == null) {
      $$$reportNull$$$0(61);
    }
    if (paramOverridingStrategy == null) {
      $$$reportNull$$$0(62);
    }
    if (allHasSameContainingDeclaration(paramCollection))
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        createAndBindFakeOverride(Collections.singleton((CallableMemberDescriptor)paramCollection.next()), paramClassDescriptor, paramOverridingStrategy);
      }
      return;
    }
    paramCollection = new LinkedList(paramCollection);
    while (!paramCollection.isEmpty()) {
      createAndBindFakeOverride(extractMembersOverridableInBothWays(VisibilityUtilKt.findMemberWithMaxVisibility(paramCollection), paramCollection, paramOverridingStrategy), paramClassDescriptor, paramOverridingStrategy);
    }
  }
  
  @NotNull
  private KotlinTypeChecker createTypeChecker(@NotNull List<TypeParameterDescriptor> paramList1, @NotNull List<TypeParameterDescriptor> paramList2)
  {
    if (paramList1 == null) {
      $$$reportNull$$$0(38);
    }
    if (paramList2 == null) {
      $$$reportNull$$$0(39);
    }
    if (paramList1.isEmpty())
    {
      paramList1 = KotlinTypeCheckerImpl.withAxioms(this.equalityAxioms);
      if (paramList1 == null) {
        $$$reportNull$$$0(40);
      }
      return paramList1;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramList1.size())
    {
      localHashMap.put(((TypeParameterDescriptor)paramList1.get(i)).getTypeConstructor(), ((TypeParameterDescriptor)paramList2.get(i)).getTypeConstructor());
      i += 1;
    }
    paramList1 = KotlinTypeCheckerImpl.withAxioms(new OverridingUtil.3(this, localHashMap));
    if (paramList1 == null) {
      $$$reportNull$$$0(41);
    }
    return paramList1;
  }
  
  @NotNull
  public static OverridingUtil createWithEqualityAxioms(@NotNull KotlinTypeChecker.TypeConstructorEquality paramTypeConstructorEquality)
  {
    if (paramTypeConstructorEquality == null) {
      $$$reportNull$$$0(0);
    }
    return new OverridingUtil(paramTypeConstructorEquality, KotlinTypeRefiner.Default.INSTANCE);
  }
  
  @NotNull
  public static OverridingUtil createWithTypeRefiner(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    if (paramKotlinTypeRefiner == null) {
      $$$reportNull$$$0(1);
    }
    return new OverridingUtil(DEFAULT_TYPE_CONSTRUCTOR_EQUALITY, paramKotlinTypeRefiner);
  }
  
  @NotNull
  private static Modality determineModalityForFakeOverride(@NotNull Collection<CallableMemberDescriptor> paramCollection, @NotNull ClassDescriptor paramClassDescriptor)
  {
    if (paramCollection == null) {
      $$$reportNull$$$0(83);
    }
    if (paramClassDescriptor == null) {
      $$$reportNull$$$0(84);
    }
    Iterator localIterator = paramCollection.iterator();
    boolean bool2 = false;
    int j = 0;
    int i = 0;
    while (localIterator.hasNext())
    {
      localObject = (CallableMemberDescriptor)localIterator.next();
      int k = OverridingUtil.9.$SwitchMap$org$jetbrains$kotlin$descriptors$Modality[localObject.getModality().ordinal()];
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 3)
          {
            if (k == 4) {
              i = 1;
            }
          }
          else {
            j = 1;
          }
        }
        else
        {
          paramCollection = new StringBuilder();
          paramCollection.append("Member cannot have SEALED modality: ");
          paramCollection.append(localObject);
          throw new IllegalStateException(paramCollection.toString());
        }
      }
      else
      {
        paramCollection = Modality.FINAL;
        if (paramCollection == null) {
          $$$reportNull$$$0(85);
        }
        return paramCollection;
      }
    }
    boolean bool1 = bool2;
    if (paramClassDescriptor.isExpect())
    {
      bool1 = bool2;
      if (paramClassDescriptor.getModality() != Modality.ABSTRACT)
      {
        bool1 = bool2;
        if (paramClassDescriptor.getModality() != Modality.SEALED) {
          bool1 = true;
        }
      }
    }
    if ((j != 0) && (i == 0))
    {
      paramCollection = Modality.OPEN;
      if (paramCollection == null) {
        $$$reportNull$$$0(86);
      }
      return paramCollection;
    }
    if ((j == 0) && (i != 0))
    {
      if (bool1) {
        paramCollection = paramClassDescriptor.getModality();
      } else {
        paramCollection = Modality.ABSTRACT;
      }
      if (paramCollection == null) {
        $$$reportNull$$$0(87);
      }
      return paramCollection;
    }
    Object localObject = new HashSet();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      ((Set)localObject).addAll(getOverriddenDeclarations((CallableMemberDescriptor)paramCollection.next()));
    }
    return getMinimalModality(filterOutOverridden((Set)localObject), bool1, paramClassDescriptor.getModality());
  }
  
  private Collection<CallableMemberDescriptor> extractAndBindOverridesForMember(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor, @NotNull Collection<? extends CallableMemberDescriptor> paramCollection, @NotNull ClassDescriptor paramClassDescriptor, @NotNull OverridingStrategy paramOverridingStrategy)
  {
    if (paramCallableMemberDescriptor == null) {
      $$$reportNull$$$0(55);
    }
    if (paramCollection == null) {
      $$$reportNull$$$0(56);
    }
    if (paramClassDescriptor == null) {
      $$$reportNull$$$0(57);
    }
    if (paramOverridingStrategy == null) {
      $$$reportNull$$$0(58);
    }
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    SmartSet localSmartSet = SmartSet.create();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      CallableMemberDescriptor localCallableMemberDescriptor = (CallableMemberDescriptor)paramCollection.next();
      OverridingUtil.OverrideCompatibilityInfo.Result localResult = isOverridableBy(localCallableMemberDescriptor, paramCallableMemberDescriptor, paramClassDescriptor).getResult();
      boolean bool = isVisibleForOverride(paramCallableMemberDescriptor, localCallableMemberDescriptor);
      int i = OverridingUtil.9.$SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result[localResult.ordinal()];
      if (i != 1)
      {
        if (i == 2)
        {
          if (bool) {
            paramOverridingStrategy.overrideConflict(localCallableMemberDescriptor, paramCallableMemberDescriptor);
          }
          localArrayList.add(localCallableMemberDescriptor);
        }
      }
      else
      {
        if (bool) {
          localSmartSet.add(localCallableMemberDescriptor);
        }
        localArrayList.add(localCallableMemberDescriptor);
      }
    }
    paramOverridingStrategy.setOverriddenDescriptors(paramCallableMemberDescriptor, localSmartSet);
    return localArrayList;
  }
  
  @NotNull
  public static <H> Collection<H> extractMembersOverridableInBothWays(@NotNull H paramH, @NotNull Collection<H> paramCollection, @NotNull Function1<H, CallableDescriptor> paramFunction1, @NotNull Function1<H, Unit> paramFunction11)
  {
    if (paramH == null) {
      $$$reportNull$$$0(94);
    }
    if (paramCollection == null) {
      $$$reportNull$$$0(95);
    }
    if (paramFunction1 == null) {
      $$$reportNull$$$0(96);
    }
    if (paramFunction11 == null) {
      $$$reportNull$$$0(97);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramH);
    CallableDescriptor localCallableDescriptor = (CallableDescriptor)paramFunction1.invoke(paramH);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Object localObject1 = paramCollection.next();
      Object localObject2 = (CallableDescriptor)paramFunction1.invoke(localObject1);
      if (paramH == localObject1)
      {
        paramCollection.remove();
      }
      else
      {
        localObject2 = getBothWaysOverridability(localCallableDescriptor, (CallableDescriptor)localObject2);
        if (localObject2 == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE)
        {
          localArrayList.add(localObject1);
          paramCollection.remove();
        }
        else if (localObject2 == OverridingUtil.OverrideCompatibilityInfo.Result.CONFLICT)
        {
          paramFunction11.invoke(localObject1);
          paramCollection.remove();
        }
      }
    }
    return localArrayList;
  }
  
  @NotNull
  private static Collection<CallableMemberDescriptor> extractMembersOverridableInBothWays(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor, @NotNull Queue<CallableMemberDescriptor> paramQueue, @NotNull OverridingStrategy paramOverridingStrategy)
  {
    if (paramCallableMemberDescriptor == null) {
      $$$reportNull$$$0(99);
    }
    if (paramQueue == null) {
      $$$reportNull$$$0(100);
    }
    if (paramOverridingStrategy == null) {
      $$$reportNull$$$0(101);
    }
    return extractMembersOverridableInBothWays(paramCallableMemberDescriptor, paramQueue, new OverridingUtil.7(), new OverridingUtil.8(paramOverridingStrategy, paramCallableMemberDescriptor));
  }
  
  @NotNull
  public static <D extends CallableDescriptor> Set<D> filterOutOverridden(@NotNull Set<D> paramSet)
  {
    if (paramSet == null) {
      $$$reportNull$$$0(4);
    }
    boolean bool;
    if ((!paramSet.isEmpty()) && (DescriptorUtilsKt.isTypeRefinementEnabled(DescriptorUtilsKt.getModule((DeclarationDescriptor)paramSet.iterator().next())))) {
      bool = true;
    } else {
      bool = false;
    }
    return filterOverrides(paramSet, bool, null, new OverridingUtil.2());
  }
  
  @NotNull
  public static <D> Set<D> filterOverrides(@NotNull Set<D> paramSet, boolean paramBoolean, @Nullable Function0<?> paramFunction0, @NotNull Function2<? super D, ? super D, Pair<CallableDescriptor, CallableDescriptor>> paramFunction2)
  {
    if (paramSet == null) {
      $$$reportNull$$$0(5);
    }
    if (paramFunction2 == null) {
      $$$reportNull$$$0(6);
    }
    if (paramSet.size() <= 1)
    {
      if (paramSet == null) {
        $$$reportNull$$$0(7);
      }
      return paramSet;
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      Object localObject1 = paramSet.next();
      if (paramFunction0 != null) {
        paramFunction0.invoke();
      }
      Iterator localIterator = localLinkedHashSet.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Object localObject2 = (Pair)paramFunction2.invoke(localObject1, localIterator.next());
          CallableDescriptor localCallableDescriptor = (CallableDescriptor)((Pair)localObject2).component1();
          localObject2 = (CallableDescriptor)((Pair)localObject2).component2();
          if (overrides(localCallableDescriptor, (CallableDescriptor)localObject2, paramBoolean)) {
            localIterator.remove();
          } else if (overrides((CallableDescriptor)localObject2, localCallableDescriptor, paramBoolean)) {
            break;
          }
        }
      }
      localLinkedHashSet.add(localObject1);
    }
    return localLinkedHashSet;
  }
  
  @NotNull
  private static Collection<CallableMemberDescriptor> filterVisibleFakeOverrides(@NotNull ClassDescriptor paramClassDescriptor, @NotNull Collection<CallableMemberDescriptor> paramCollection)
  {
    if (paramClassDescriptor == null) {
      $$$reportNull$$$0(91);
    }
    if (paramCollection == null) {
      $$$reportNull$$$0(92);
    }
    paramClassDescriptor = CollectionsKt.filter(paramCollection, new OverridingUtil.6(paramClassDescriptor));
    if (paramClassDescriptor == null) {
      $$$reportNull$$$0(93);
    }
    return paramClassDescriptor;
  }
  
  @Nullable
  public static Visibility findMaxVisibility(@NotNull Collection<? extends CallableMemberDescriptor> paramCollection)
  {
    if (paramCollection == null) {
      $$$reportNull$$$0(104);
    }
    if (paramCollection.isEmpty()) {
      return Visibilities.DEFAULT_VISIBILITY;
    }
    Iterator localIterator = paramCollection.iterator();
    Object localObject1 = null;
    label31:
    Object localObject2;
    if (localIterator.hasNext())
    {
      localObject2 = ((CallableMemberDescriptor)localIterator.next()).getVisibility();
      if (localObject1 == null) {}
      for (;;)
      {
        localObject1 = localObject2;
        break label31;
        Integer localInteger = Visibilities.compare((Visibility)localObject2, localObject1);
        if (localInteger == null) {
          break;
        }
        if (localInteger.intValue() <= 0) {
          break label31;
        }
      }
    }
    if (localObject1 == null) {
      return null;
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      localObject2 = Visibilities.compare(localObject1, ((CallableMemberDescriptor)paramCollection.next()).getVisibility());
      if ((localObject2 == null) || (((Integer)localObject2).intValue() < 0)) {
        return null;
      }
    }
    return localObject1;
  }
  
  @Nullable
  public static OverridingUtil.OverrideCompatibilityInfo getBasicOverridabilityProblem(@NotNull CallableDescriptor paramCallableDescriptor1, @NotNull CallableDescriptor paramCallableDescriptor2)
  {
    if (paramCallableDescriptor1 == null) {
      $$$reportNull$$$0(36);
    }
    if (paramCallableDescriptor2 == null) {
      $$$reportNull$$$0(37);
    }
    boolean bool1 = paramCallableDescriptor1 instanceof FunctionDescriptor;
    boolean bool2;
    if ((!bool1) || ((paramCallableDescriptor2 instanceof FunctionDescriptor)))
    {
      bool2 = paramCallableDescriptor1 instanceof PropertyDescriptor;
      if ((!bool2) || ((paramCallableDescriptor2 instanceof PropertyDescriptor))) {}
    }
    else
    {
      return OverridingUtil.OverrideCompatibilityInfo.incompatible("Member kind mismatch");
    }
    if ((!bool1) && (!bool2))
    {
      paramCallableDescriptor2 = new StringBuilder();
      paramCallableDescriptor2.append("This type of CallableDescriptor cannot be checked for overridability: ");
      paramCallableDescriptor2.append(paramCallableDescriptor1);
      throw new IllegalArgumentException(paramCallableDescriptor2.toString());
    }
    if (!paramCallableDescriptor1.getName().equals(paramCallableDescriptor2.getName())) {
      return OverridingUtil.OverrideCompatibilityInfo.incompatible("Name mismatch");
    }
    paramCallableDescriptor1 = checkReceiverAndParameterCount(paramCallableDescriptor1, paramCallableDescriptor2);
    if (paramCallableDescriptor1 != null) {
      return paramCallableDescriptor1;
    }
    return null;
  }
  
  @Nullable
  public static OverridingUtil.OverrideCompatibilityInfo.Result getBothWaysOverridability(CallableDescriptor paramCallableDescriptor1, CallableDescriptor paramCallableDescriptor2)
  {
    OverridingUtil.OverrideCompatibilityInfo.Result localResult = DEFAULT.isOverridableBy(paramCallableDescriptor2, paramCallableDescriptor1, null).getResult();
    paramCallableDescriptor1 = DEFAULT.isOverridableBy(paramCallableDescriptor1, paramCallableDescriptor2, null).getResult();
    if ((localResult == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE) && (paramCallableDescriptor1 == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE)) {
      return OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE;
    }
    if ((localResult != OverridingUtil.OverrideCompatibilityInfo.Result.CONFLICT) && (paramCallableDescriptor1 != OverridingUtil.OverrideCompatibilityInfo.Result.CONFLICT)) {
      return OverridingUtil.OverrideCompatibilityInfo.Result.INCOMPATIBLE;
    }
    return OverridingUtil.OverrideCompatibilityInfo.Result.CONFLICT;
  }
  
  @NotNull
  private static Modality getMinimalModality(@NotNull Collection<CallableMemberDescriptor> paramCollection, boolean paramBoolean, @NotNull Modality paramModality)
  {
    if (paramCollection == null) {
      $$$reportNull$$$0(88);
    }
    if (paramModality == null) {
      $$$reportNull$$$0(89);
    }
    Object localObject = Modality.ABSTRACT;
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      paramCollection = (CallableMemberDescriptor)localIterator.next();
      if ((paramBoolean) && (paramCollection.getModality() == Modality.ABSTRACT)) {
        paramCollection = paramModality;
      } else {
        paramCollection = paramCollection.getModality();
      }
      if (paramCollection.compareTo((Enum)localObject) < 0) {
        localObject = paramCollection;
      }
    }
    if (localObject == null) {
      $$$reportNull$$$0(90);
    }
    return localObject;
  }
  
  @NotNull
  public static Set<CallableMemberDescriptor> getOverriddenDeclarations(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    if (paramCallableMemberDescriptor == null) {
      $$$reportNull$$$0(11);
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    collectOverriddenDeclarations(paramCallableMemberDescriptor, localLinkedHashSet);
    return localLinkedHashSet;
  }
  
  private static boolean isAccessorMoreSpecific(@Nullable PropertyAccessorDescriptor paramPropertyAccessorDescriptor1, @Nullable PropertyAccessorDescriptor paramPropertyAccessorDescriptor2)
  {
    if ((paramPropertyAccessorDescriptor1 != null) && (paramPropertyAccessorDescriptor2 != null)) {
      return isVisibilityMoreSpecific(paramPropertyAccessorDescriptor1, paramPropertyAccessorDescriptor2);
    }
    return true;
  }
  
  public static boolean isMoreSpecific(@NotNull CallableDescriptor paramCallableDescriptor1, @NotNull CallableDescriptor paramCallableDescriptor2)
  {
    if (paramCallableDescriptor1 == null) {
      $$$reportNull$$$0(63);
    }
    if (paramCallableDescriptor2 == null) {
      $$$reportNull$$$0(64);
    }
    KotlinType localKotlinType1 = paramCallableDescriptor1.getReturnType();
    KotlinType localKotlinType2 = paramCallableDescriptor2.getReturnType();
    boolean bool1 = isVisibilityMoreSpecific(paramCallableDescriptor1, paramCallableDescriptor2);
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if ((paramCallableDescriptor1 instanceof FunctionDescriptor)) {
      return isReturnTypeMoreSpecific(paramCallableDescriptor1, localKotlinType1, paramCallableDescriptor2, localKotlinType2);
    }
    if ((paramCallableDescriptor1 instanceof PropertyDescriptor))
    {
      PropertyDescriptor localPropertyDescriptor1 = (PropertyDescriptor)paramCallableDescriptor1;
      PropertyDescriptor localPropertyDescriptor2 = (PropertyDescriptor)paramCallableDescriptor2;
      if (!isAccessorMoreSpecific(localPropertyDescriptor1.getSetter(), localPropertyDescriptor2.getSetter())) {
        return false;
      }
      if ((localPropertyDescriptor1.isVar()) && (localPropertyDescriptor2.isVar())) {
        return DEFAULT.createTypeChecker(paramCallableDescriptor1.getTypeParameters(), paramCallableDescriptor2.getTypeParameters()).equalTypes(localKotlinType1, localKotlinType2);
      }
      if (!localPropertyDescriptor1.isVar())
      {
        bool1 = bool2;
        if (localPropertyDescriptor2.isVar()) {}
      }
      else
      {
        bool1 = bool2;
        if (isReturnTypeMoreSpecific(paramCallableDescriptor1, localKotlinType1, paramCallableDescriptor2, localKotlinType2)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    paramCallableDescriptor2 = new StringBuilder();
    paramCallableDescriptor2.append("Unexpected callable: ");
    paramCallableDescriptor2.append(paramCallableDescriptor1.getClass());
    throw new IllegalArgumentException(paramCallableDescriptor2.toString());
  }
  
  private static boolean isMoreSpecificThenAllOf(@NotNull CallableDescriptor paramCallableDescriptor, @NotNull Collection<CallableDescriptor> paramCollection)
  {
    if (paramCallableDescriptor == null) {
      $$$reportNull$$$0(67);
    }
    if (paramCollection == null) {
      $$$reportNull$$$0(68);
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!isMoreSpecific(paramCallableDescriptor, (CallableDescriptor)paramCollection.next())) {
        return false;
      }
    }
    return true;
  }
  
  private static boolean isReturnTypeMoreSpecific(@NotNull CallableDescriptor paramCallableDescriptor1, @NotNull KotlinType paramKotlinType1, @NotNull CallableDescriptor paramCallableDescriptor2, @NotNull KotlinType paramKotlinType2)
  {
    if (paramCallableDescriptor1 == null) {
      $$$reportNull$$$0(69);
    }
    if (paramKotlinType1 == null) {
      $$$reportNull$$$0(70);
    }
    if (paramCallableDescriptor2 == null) {
      $$$reportNull$$$0(71);
    }
    if (paramKotlinType2 == null) {
      $$$reportNull$$$0(72);
    }
    return DEFAULT.createTypeChecker(paramCallableDescriptor1.getTypeParameters(), paramCallableDescriptor2.getTypeParameters()).isSubtypeOf(paramKotlinType1, paramKotlinType2);
  }
  
  private static boolean isVisibilityMoreSpecific(@NotNull DeclarationDescriptorWithVisibility paramDeclarationDescriptorWithVisibility1, @NotNull DeclarationDescriptorWithVisibility paramDeclarationDescriptorWithVisibility2)
  {
    if (paramDeclarationDescriptorWithVisibility1 == null) {
      $$$reportNull$$$0(65);
    }
    if (paramDeclarationDescriptorWithVisibility2 == null) {
      $$$reportNull$$$0(66);
    }
    paramDeclarationDescriptorWithVisibility1 = Visibilities.compare(paramDeclarationDescriptorWithVisibility1.getVisibility(), paramDeclarationDescriptorWithVisibility2.getVisibility());
    return (paramDeclarationDescriptorWithVisibility1 == null) || (paramDeclarationDescriptorWithVisibility1.intValue() >= 0);
  }
  
  public static boolean isVisibleForOverride(@NotNull MemberDescriptor paramMemberDescriptor1, @NotNull MemberDescriptor paramMemberDescriptor2)
  {
    if (paramMemberDescriptor1 == null) {
      $$$reportNull$$$0(53);
    }
    if (paramMemberDescriptor2 == null) {
      $$$reportNull$$$0(54);
    }
    return (!Visibilities.isPrivate(paramMemberDescriptor2.getVisibility())) && (Visibilities.isVisibleIgnoringReceiver(paramMemberDescriptor2, paramMemberDescriptor1));
  }
  
  public static <D extends CallableDescriptor> boolean overrides(@NotNull D paramD1, @NotNull D paramD2, boolean paramBoolean)
  {
    if (paramD1 == null) {
      $$$reportNull$$$0(9);
    }
    if (paramD2 == null) {
      $$$reportNull$$$0(10);
    }
    if ((!paramD1.equals(paramD2)) && (DescriptorEquivalenceForOverrides.INSTANCE.areEquivalent(paramD1.getOriginal(), paramD2.getOriginal(), paramBoolean))) {
      return true;
    }
    paramD2 = paramD2.getOriginal();
    paramD1 = DescriptorUtils.getAllOverriddenDescriptors(paramD1).iterator();
    while (paramD1.hasNext())
    {
      CallableDescriptor localCallableDescriptor = (CallableDescriptor)paramD1.next();
      if (DescriptorEquivalenceForOverrides.INSTANCE.areEquivalent(paramD2, localCallableDescriptor, paramBoolean)) {
        return true;
      }
    }
    return false;
  }
  
  public static void resolveUnknownVisibilityForMember(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor, @Nullable Function1<CallableMemberDescriptor, Unit> paramFunction1)
  {
    if (paramCallableMemberDescriptor == null) {
      $$$reportNull$$$0(102);
    }
    Object localObject1 = paramCallableMemberDescriptor.getOverriddenDescriptors().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (CallableMemberDescriptor)((Iterator)localObject1).next();
      if (((CallableMemberDescriptor)localObject2).getVisibility() == Visibilities.INHERITED) {
        resolveUnknownVisibilityForMember((CallableMemberDescriptor)localObject2, paramFunction1);
      }
    }
    if (paramCallableMemberDescriptor.getVisibility() != Visibilities.INHERITED) {
      return;
    }
    Object localObject2 = computeVisibilityToInherit(paramCallableMemberDescriptor);
    if (localObject2 == null)
    {
      if (paramFunction1 != null) {
        paramFunction1.invoke(paramCallableMemberDescriptor);
      }
      localObject1 = Visibilities.PUBLIC;
    }
    else
    {
      localObject1 = localObject2;
    }
    if ((paramCallableMemberDescriptor instanceof PropertyDescriptorImpl))
    {
      ((PropertyDescriptorImpl)paramCallableMemberDescriptor).setVisibility((Visibility)localObject1);
      localObject1 = ((PropertyDescriptor)paramCallableMemberDescriptor).getAccessors().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        PropertyAccessorDescriptor localPropertyAccessorDescriptor = (PropertyAccessorDescriptor)((Iterator)localObject1).next();
        if (localObject2 == null) {
          paramCallableMemberDescriptor = null;
        } else {
          paramCallableMemberDescriptor = paramFunction1;
        }
        resolveUnknownVisibilityForMember(localPropertyAccessorDescriptor, paramCallableMemberDescriptor);
      }
    }
    if ((paramCallableMemberDescriptor instanceof FunctionDescriptorImpl))
    {
      ((FunctionDescriptorImpl)paramCallableMemberDescriptor).setVisibility((Visibility)localObject1);
      return;
    }
    paramCallableMemberDescriptor = (PropertyAccessorDescriptorImpl)paramCallableMemberDescriptor;
    paramCallableMemberDescriptor.setVisibility((Visibility)localObject1);
    if (localObject1 != paramCallableMemberDescriptor.getCorrespondingProperty().getVisibility()) {
      paramCallableMemberDescriptor.setDefault(false);
    }
  }
  
  @NotNull
  public static <H> H selectMostSpecificMember(@NotNull Collection<H> paramCollection, @NotNull Function1<H, CallableDescriptor> paramFunction1)
  {
    if (paramCollection == null) {
      $$$reportNull$$$0(73);
    }
    if (paramFunction1 == null) {
      $$$reportNull$$$0(74);
    }
    if (paramCollection.size() == 1)
    {
      paramCollection = CollectionsKt.first(paramCollection);
      if (paramCollection == null) {
        $$$reportNull$$$0(75);
      }
      return paramCollection;
    }
    ArrayList localArrayList = new ArrayList(2);
    Object localObject2 = CollectionsKt.map(paramCollection, paramFunction1);
    Object localObject1 = CollectionsKt.first(paramCollection);
    CallableDescriptor localCallableDescriptor1 = (CallableDescriptor)paramFunction1.invoke(localObject1);
    Iterator localIterator = paramCollection.iterator();
    for (paramCollection = localObject1; localIterator.hasNext(); paramCollection = localObject1)
    {
      label87:
      localObject1 = localIterator.next();
      CallableDescriptor localCallableDescriptor2 = (CallableDescriptor)paramFunction1.invoke(localObject1);
      if (isMoreSpecificThenAllOf(localCallableDescriptor2, (Collection)localObject2)) {
        localArrayList.add(localObject1);
      }
      if ((!isMoreSpecific(localCallableDescriptor2, localCallableDescriptor1)) || (isMoreSpecific(localCallableDescriptor1, localCallableDescriptor2))) {
        break label87;
      }
    }
    if (localArrayList.isEmpty())
    {
      if (paramCollection == null) {
        $$$reportNull$$$0(76);
      }
      return paramCollection;
    }
    if (localArrayList.size() == 1)
    {
      paramCollection = CollectionsKt.first(localArrayList);
      if (paramCollection == null) {
        $$$reportNull$$$0(77);
      }
      return paramCollection;
    }
    localObject1 = null;
    localObject2 = localArrayList.iterator();
    do
    {
      paramCollection = localObject1;
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      paramCollection = ((Iterator)localObject2).next();
    } while (FlexibleTypesKt.isFlexible(((CallableDescriptor)paramFunction1.invoke(paramCollection)).getReturnType()));
    if (paramCollection != null)
    {
      if (paramCollection == null) {
        $$$reportNull$$$0(78);
      }
      return paramCollection;
    }
    paramCollection = CollectionsKt.first(localArrayList);
    if (paramCollection == null) {
      $$$reportNull$$$0(79);
    }
    return paramCollection;
  }
  
  public void generateOverridesInFunctionGroup(@NotNull Name paramName, @NotNull Collection<? extends CallableMemberDescriptor> paramCollection1, @NotNull Collection<? extends CallableMemberDescriptor> paramCollection2, @NotNull ClassDescriptor paramClassDescriptor, @NotNull OverridingStrategy paramOverridingStrategy)
  {
    if (paramName == null) {
      $$$reportNull$$$0(48);
    }
    if (paramCollection1 == null) {
      $$$reportNull$$$0(49);
    }
    if (paramCollection2 == null) {
      $$$reportNull$$$0(50);
    }
    if (paramClassDescriptor == null) {
      $$$reportNull$$$0(51);
    }
    if (paramOverridingStrategy == null) {
      $$$reportNull$$$0(52);
    }
    paramName = new LinkedHashSet(paramCollection1);
    paramCollection2 = paramCollection2.iterator();
    while (paramCollection2.hasNext()) {
      paramName.removeAll(extractAndBindOverridesForMember((CallableMemberDescriptor)paramCollection2.next(), paramCollection1, paramClassDescriptor, paramOverridingStrategy));
    }
    createAndBindFakeOverrides(paramClassDescriptor, paramName, paramOverridingStrategy);
  }
  
  @NotNull
  public OverridingUtil.OverrideCompatibilityInfo isOverridableBy(@NotNull CallableDescriptor paramCallableDescriptor1, @NotNull CallableDescriptor paramCallableDescriptor2, @Nullable ClassDescriptor paramClassDescriptor)
  {
    if (paramCallableDescriptor1 == null) {
      $$$reportNull$$$0(15);
    }
    if (paramCallableDescriptor2 == null) {
      $$$reportNull$$$0(16);
    }
    paramCallableDescriptor1 = isOverridableBy(paramCallableDescriptor1, paramCallableDescriptor2, paramClassDescriptor, false);
    if (paramCallableDescriptor1 == null) {
      $$$reportNull$$$0(17);
    }
    return paramCallableDescriptor1;
  }
  
  @NotNull
  public OverridingUtil.OverrideCompatibilityInfo isOverridableBy(@NotNull CallableDescriptor paramCallableDescriptor1, @NotNull CallableDescriptor paramCallableDescriptor2, @Nullable ClassDescriptor paramClassDescriptor, boolean paramBoolean)
  {
    if (paramCallableDescriptor1 == null) {
      $$$reportNull$$$0(18);
    }
    if (paramCallableDescriptor2 == null) {
      $$$reportNull$$$0(19);
    }
    Object localObject1 = isOverridableByWithoutExternalConditions(paramCallableDescriptor1, paramCallableDescriptor2, paramBoolean);
    int i;
    if (((OverridingUtil.OverrideCompatibilityInfo)localObject1).getResult() == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE) {
      i = 1;
    } else {
      i = 0;
    }
    Iterator localIterator = EXTERNAL_CONDITIONS.iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (ExternalOverridabilityCondition)localIterator.next();
      if ((((ExternalOverridabilityCondition)localObject2).getContract() != ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY) && ((i == 0) || (((ExternalOverridabilityCondition)localObject2).getContract() != ExternalOverridabilityCondition.Contract.SUCCESS_ONLY)))
      {
        localObject2 = ((ExternalOverridabilityCondition)localObject2).isOverridable(paramCallableDescriptor1, paramCallableDescriptor2, paramClassDescriptor);
        int j = OverridingUtil.9.$SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[localObject2.ordinal()];
        if (j != 1)
        {
          if (j != 2)
          {
            if (j == 3)
            {
              paramCallableDescriptor1 = OverridingUtil.OverrideCompatibilityInfo.incompatible("External condition");
              if (paramCallableDescriptor1 == null) {
                $$$reportNull$$$0(21);
              }
              return paramCallableDescriptor1;
            }
          }
          else
          {
            paramCallableDescriptor1 = OverridingUtil.OverrideCompatibilityInfo.conflict("External condition failed");
            if (paramCallableDescriptor1 == null) {
              $$$reportNull$$$0(20);
            }
            return paramCallableDescriptor1;
          }
        }
        else {
          i = 1;
        }
      }
    }
    if (i == 0)
    {
      if (localObject1 == null) {
        $$$reportNull$$$0(22);
      }
      return localObject1;
    }
    localIterator = EXTERNAL_CONDITIONS.iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (ExternalOverridabilityCondition)localIterator.next();
      if (((ExternalOverridabilityCondition)localObject1).getContract() == ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY)
      {
        localObject2 = ((ExternalOverridabilityCondition)localObject1).isOverridable(paramCallableDescriptor1, paramCallableDescriptor2, paramClassDescriptor);
        i = OverridingUtil.9.$SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[localObject2.ordinal()];
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3)
            {
              paramCallableDescriptor1 = OverridingUtil.OverrideCompatibilityInfo.incompatible("External condition");
              if (paramCallableDescriptor1 == null) {
                $$$reportNull$$$0(24);
              }
              return paramCallableDescriptor1;
            }
          }
          else
          {
            paramCallableDescriptor1 = OverridingUtil.OverrideCompatibilityInfo.conflict("External condition failed");
            if (paramCallableDescriptor1 == null) {
              $$$reportNull$$$0(23);
            }
            return paramCallableDescriptor1;
          }
        }
        else
        {
          paramCallableDescriptor1 = new StringBuilder();
          paramCallableDescriptor1.append("Contract violation in ");
          paramCallableDescriptor1.append(localObject1.getClass().getName());
          paramCallableDescriptor1.append(" condition. It's not supposed to end with success");
          throw new IllegalStateException(paramCallableDescriptor1.toString());
        }
      }
    }
    paramCallableDescriptor1 = OverridingUtil.OverrideCompatibilityInfo.success();
    if (paramCallableDescriptor1 == null) {
      $$$reportNull$$$0(25);
    }
    return paramCallableDescriptor1;
  }
  
  @NotNull
  public OverridingUtil.OverrideCompatibilityInfo isOverridableByWithoutExternalConditions(@NotNull CallableDescriptor paramCallableDescriptor1, @NotNull CallableDescriptor paramCallableDescriptor2, boolean paramBoolean)
  {
    if (paramCallableDescriptor1 == null) {
      $$$reportNull$$$0(26);
    }
    if (paramCallableDescriptor2 == null) {
      $$$reportNull$$$0(27);
    }
    Object localObject = getBasicOverridabilityProblem(paramCallableDescriptor1, paramCallableDescriptor2);
    if (localObject != null)
    {
      if (localObject == null) {
        $$$reportNull$$$0(28);
      }
      return localObject;
    }
    List localList1 = compiledValueParameters(paramCallableDescriptor1);
    List localList2 = compiledValueParameters(paramCallableDescriptor2);
    List localList3 = paramCallableDescriptor1.getTypeParameters();
    List localList4 = paramCallableDescriptor2.getTypeParameters();
    int k = localList3.size();
    int m = localList4.size();
    int j = 0;
    int i = 0;
    if (k != m)
    {
      while (i < localList1.size())
      {
        if (!KotlinTypeChecker.DEFAULT.equalTypes((KotlinType)localList1.get(i), (KotlinType)localList2.get(i)))
        {
          paramCallableDescriptor1 = OverridingUtil.OverrideCompatibilityInfo.incompatible("Type parameter number mismatch");
          if (paramCallableDescriptor1 == null) {
            $$$reportNull$$$0(29);
          }
          return paramCallableDescriptor1;
        }
        i += 1;
      }
      paramCallableDescriptor1 = OverridingUtil.OverrideCompatibilityInfo.conflict("Type parameter number mismatch");
      if (paramCallableDescriptor1 == null) {
        $$$reportNull$$$0(30);
      }
      return paramCallableDescriptor1;
    }
    localObject = createTypeChecker(localList3, localList4);
    i = 0;
    while (i < localList3.size())
    {
      if (!areTypeParametersEquivalent((TypeParameterDescriptor)localList3.get(i), (TypeParameterDescriptor)localList4.get(i), (KotlinTypeChecker)localObject))
      {
        paramCallableDescriptor1 = OverridingUtil.OverrideCompatibilityInfo.incompatible("Type parameter bounds mismatch");
        if (paramCallableDescriptor1 == null) {
          $$$reportNull$$$0(31);
        }
        return paramCallableDescriptor1;
      }
      i += 1;
    }
    i = 0;
    while (i < localList1.size())
    {
      if (!areTypesEquivalent((KotlinType)localList1.get(i), (KotlinType)localList2.get(i), (KotlinTypeChecker)localObject))
      {
        paramCallableDescriptor1 = OverridingUtil.OverrideCompatibilityInfo.incompatible("Value parameter type mismatch");
        if (paramCallableDescriptor1 == null) {
          $$$reportNull$$$0(32);
        }
        return paramCallableDescriptor1;
      }
      i += 1;
    }
    if (((paramCallableDescriptor1 instanceof FunctionDescriptor)) && ((paramCallableDescriptor2 instanceof FunctionDescriptor)) && (((FunctionDescriptor)paramCallableDescriptor1).isSuspend() != ((FunctionDescriptor)paramCallableDescriptor2).isSuspend()))
    {
      paramCallableDescriptor1 = OverridingUtil.OverrideCompatibilityInfo.conflict("Incompatible suspendability");
      if (paramCallableDescriptor1 == null) {
        $$$reportNull$$$0(33);
      }
      return paramCallableDescriptor1;
    }
    if (paramBoolean)
    {
      paramCallableDescriptor1 = paramCallableDescriptor1.getReturnType();
      paramCallableDescriptor2 = paramCallableDescriptor2.getReturnType();
      if ((paramCallableDescriptor1 != null) && (paramCallableDescriptor2 != null))
      {
        i = j;
        if (KotlinTypeKt.isError(paramCallableDescriptor2))
        {
          i = j;
          if (KotlinTypeKt.isError(paramCallableDescriptor1)) {
            i = 1;
          }
        }
        if ((i == 0) && (!((KotlinTypeChecker)localObject).isSubtypeOf(this.kotlinTypeRefiner.refineType(paramCallableDescriptor2), this.kotlinTypeRefiner.refineType(paramCallableDescriptor1))))
        {
          paramCallableDescriptor1 = OverridingUtil.OverrideCompatibilityInfo.conflict("Return type mismatch");
          if (paramCallableDescriptor1 == null) {
            $$$reportNull$$$0(34);
          }
          return paramCallableDescriptor1;
        }
      }
    }
    paramCallableDescriptor1 = OverridingUtil.OverrideCompatibilityInfo.success();
    if (paramCallableDescriptor1 == null) {
      $$$reportNull$$$0(35);
    }
    return paramCallableDescriptor1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil
 * JD-Core Version:    0.7.0.1
 */