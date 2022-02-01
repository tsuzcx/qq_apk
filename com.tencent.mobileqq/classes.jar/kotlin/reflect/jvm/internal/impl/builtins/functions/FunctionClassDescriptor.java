package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FunctionClassDescriptor
  extends AbstractClassDescriptor
{
  public static final FunctionClassDescriptor.Companion Companion = new FunctionClassDescriptor.Companion(null);
  private static final ClassId functionClassId = new ClassId(KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME, Name.identifier("Function"));
  private static final ClassId kFunctionClassId = new ClassId(ReflectionTypesKt.getKOTLIN_REFLECT_FQ_NAME(), Name.identifier("KFunction"));
  private final int arity;
  private final PackageFragmentDescriptor containingDeclaration;
  @NotNull
  private final FunctionClassDescriptor.Kind functionKind;
  private final FunctionClassScope memberScope;
  private final List<TypeParameterDescriptor> parameters;
  private final StorageManager storageManager;
  private final FunctionClassDescriptor.FunctionTypeConstructor typeConstructor;
  
  public FunctionClassDescriptor(@NotNull StorageManager paramStorageManager, @NotNull PackageFragmentDescriptor paramPackageFragmentDescriptor, @NotNull FunctionClassDescriptor.Kind paramKind, int paramInt)
  {
    super(paramStorageManager, paramKind.numberedClassName(paramInt));
    this.storageManager = paramStorageManager;
    this.containingDeclaration = paramPackageFragmentDescriptor;
    this.functionKind = paramKind;
    this.arity = paramInt;
    this.typeConstructor = new FunctionClassDescriptor.FunctionTypeConstructor(this);
    this.memberScope = new FunctionClassScope(this.storageManager, this);
    paramStorageManager = new ArrayList();
    paramPackageFragmentDescriptor = new FunctionClassDescriptor.1(this, paramStorageManager);
    Object localObject = (Iterable)new IntRange(1, this.arity);
    paramKind = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramInt = ((IntIterator)localObject).nextInt();
      Variance localVariance = Variance.IN_VARIANCE;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append('P');
      localStringBuilder.append(paramInt);
      paramPackageFragmentDescriptor.invoke(localVariance, localStringBuilder.toString());
      paramKind.add(Unit.INSTANCE);
    }
    paramKind = (List)paramKind;
    paramPackageFragmentDescriptor.invoke(Variance.OUT_VARIANCE, "R");
    this.parameters = CollectionsKt.toList((Iterable)paramStorageManager);
  }
  
  @NotNull
  public Annotations getAnnotations()
  {
    return Annotations.Companion.getEMPTY();
  }
  
  public final int getArity()
  {
    return this.arity;
  }
  
  @Nullable
  public Void getCompanionObjectDescriptor()
  {
    return null;
  }
  
  @NotNull
  public List<ClassConstructorDescriptor> getConstructors()
  {
    return CollectionsKt.emptyList();
  }
  
  @NotNull
  public PackageFragmentDescriptor getContainingDeclaration()
  {
    return this.containingDeclaration;
  }
  
  @NotNull
  public List<TypeParameterDescriptor> getDeclaredTypeParameters()
  {
    return this.parameters;
  }
  
  @NotNull
  public final FunctionClassDescriptor.Kind getFunctionKind()
  {
    return this.functionKind;
  }
  
  @NotNull
  public ClassKind getKind()
  {
    return ClassKind.INTERFACE;
  }
  
  @NotNull
  public Modality getModality()
  {
    return Modality.ABSTRACT;
  }
  
  @NotNull
  public List<ClassDescriptor> getSealedSubclasses()
  {
    return CollectionsKt.emptyList();
  }
  
  @NotNull
  public SourceElement getSource()
  {
    SourceElement localSourceElement = SourceElement.NO_SOURCE;
    Intrinsics.checkExpressionValueIsNotNull(localSourceElement, "SourceElement.NO_SOURCE");
    return localSourceElement;
  }
  
  @NotNull
  public MemberScope.Empty getStaticScope()
  {
    return MemberScope.Empty.INSTANCE;
  }
  
  @NotNull
  public TypeConstructor getTypeConstructor()
  {
    return (TypeConstructor)this.typeConstructor;
  }
  
  @NotNull
  protected FunctionClassScope getUnsubstitutedMemberScope(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    return this.memberScope;
  }
  
  @Nullable
  public Void getUnsubstitutedPrimaryConstructor()
  {
    return null;
  }
  
  @NotNull
  public Visibility getVisibility()
  {
    Visibility localVisibility = Visibilities.PUBLIC;
    Intrinsics.checkExpressionValueIsNotNull(localVisibility, "Visibilities.PUBLIC");
    return localVisibility;
  }
  
  public boolean isActual()
  {
    return false;
  }
  
  public boolean isCompanionObject()
  {
    return false;
  }
  
  public boolean isData()
  {
    return false;
  }
  
  public boolean isExpect()
  {
    return false;
  }
  
  public boolean isExternal()
  {
    return false;
  }
  
  public boolean isInline()
  {
    return false;
  }
  
  public boolean isInner()
  {
    return false;
  }
  
  @NotNull
  public String toString()
  {
    String str = getName().asString();
    Intrinsics.checkExpressionValueIsNotNull(str, "name.asString()");
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor
 * JD-Core Version:    0.7.0.1
 */