package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass;
import kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.load.java.JavaVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.InnerClassesScopeWrapper;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaClassDescriptor
  extends ClassDescriptorBase
  implements JavaClassDescriptor
{
  public static final LazyJavaClassDescriptor.Companion Companion = new LazyJavaClassDescriptor.Companion(null);
  private static final Set<String> PUBLIC_METHOD_NAMES_IN_OBJECT = SetsKt.setOf(new String[] { "equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString" });
  private final ClassDescriptor additionalSupertypeClassDescriptor;
  @NotNull
  private final Annotations annotations;
  private final LazyJavaResolverContext c;
  private final NotNullLazyValue<List<TypeParameterDescriptor>> declaredParameters;
  private final InnerClassesScopeWrapper innerClassesScope;
  private final boolean isInner;
  @NotNull
  private final JavaClass jClass;
  private final ClassKind kind;
  private final Modality modality;
  @NotNull
  private final LazyJavaResolverContext outerContext;
  private final ScopesHolderForClass<LazyJavaClassMemberScope> scopeHolder;
  private final LazyJavaStaticClassScope staticScope;
  private final LazyJavaClassDescriptor.LazyJavaClassTypeConstructor typeConstructor;
  private final LazyJavaClassMemberScope unsubstitutedMemberScope;
  private final Visibility visibility;
  
  public LazyJavaClassDescriptor(@NotNull LazyJavaResolverContext paramLazyJavaResolverContext, @NotNull DeclarationDescriptor paramDeclarationDescriptor, @NotNull JavaClass paramJavaClass, @Nullable ClassDescriptor paramClassDescriptor)
  {
    super(paramLazyJavaResolverContext.getStorageManager(), paramDeclarationDescriptor, paramJavaClass.getName(), (SourceElement)paramLazyJavaResolverContext.getComponents().getSourceElementFactory().source((JavaElement)paramJavaClass), false);
    this.outerContext = paramLazyJavaResolverContext;
    this.jClass = paramJavaClass;
    this.additionalSupertypeClassDescriptor = paramClassDescriptor;
    this.c = ContextKt.childForClassOrPackage$default(this.outerContext, (ClassOrPackageFragmentDescriptor)this, (JavaTypeParameterListOwner)this.jClass, 0, 4, null);
    paramLazyJavaResolverContext = this.c.getComponents().getJavaResolverCache();
    paramJavaClass = this.jClass;
    paramDeclarationDescriptor = (ClassDescriptor)this;
    paramLazyJavaResolverContext.recordClass(paramJavaClass, paramDeclarationDescriptor);
    int i;
    if (this.jClass.getLightClassOriginKind() == null) {
      i = 1;
    } else {
      i = 0;
    }
    if ((_Assertions.ENABLED) && (i == 0))
    {
      paramLazyJavaResolverContext = new StringBuilder();
      paramLazyJavaResolverContext.append("Creating LazyJavaClassDescriptor for light class ");
      paramLazyJavaResolverContext.append(this.jClass);
      throw ((Throwable)new AssertionError(paramLazyJavaResolverContext.toString()));
    }
    if (this.jClass.isAnnotationType()) {
      paramLazyJavaResolverContext = ClassKind.ANNOTATION_CLASS;
    } else if (this.jClass.isInterface()) {
      paramLazyJavaResolverContext = ClassKind.INTERFACE;
    } else if (this.jClass.isEnum()) {
      paramLazyJavaResolverContext = ClassKind.ENUM_CLASS;
    } else {
      paramLazyJavaResolverContext = ClassKind.CLASS;
    }
    this.kind = paramLazyJavaResolverContext;
    boolean bool;
    if ((!this.jClass.isAnnotationType()) && (!this.jClass.isEnum()))
    {
      paramLazyJavaResolverContext = Modality.Companion;
      if ((!this.jClass.isAbstract()) && (!this.jClass.isInterface())) {
        bool = false;
      } else {
        bool = true;
      }
      paramLazyJavaResolverContext = paramLazyJavaResolverContext.convertFromFlags(bool, this.jClass.isFinal() ^ true);
    }
    else
    {
      paramLazyJavaResolverContext = Modality.FINAL;
    }
    this.modality = paramLazyJavaResolverContext;
    this.visibility = this.jClass.getVisibility();
    if ((this.jClass.getOuterClass() != null) && (!this.jClass.isStatic())) {
      bool = true;
    } else {
      bool = false;
    }
    this.isInner = bool;
    this.typeConstructor = new LazyJavaClassDescriptor.LazyJavaClassTypeConstructor(this);
    paramLazyJavaResolverContext = this.c;
    paramJavaClass = this.jClass;
    if (this.additionalSupertypeClassDescriptor != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.unsubstitutedMemberScope = new LazyJavaClassMemberScope(paramLazyJavaResolverContext, paramDeclarationDescriptor, paramJavaClass, bool, null, 16, null);
    this.scopeHolder = ScopesHolderForClass.Companion.create(paramDeclarationDescriptor, this.c.getStorageManager(), this.c.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner(), (Function1)new LazyJavaClassDescriptor.scopeHolder.1(this));
    this.innerClassesScope = new InnerClassesScopeWrapper((MemberScope)this.unsubstitutedMemberScope);
    this.staticScope = new LazyJavaStaticClassScope(this.c, this.jClass, this);
    this.annotations = LazyJavaAnnotationsKt.resolveAnnotations(this.c, (JavaAnnotationOwner)this.jClass);
    this.declaredParameters = this.c.getStorageManager().createLazyValue((Function0)new LazyJavaClassDescriptor.declaredParameters.1(this));
  }
  
  @NotNull
  public final LazyJavaClassDescriptor copy$descriptors_jvm(@NotNull JavaResolverCache paramJavaResolverCache, @Nullable ClassDescriptor paramClassDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramJavaResolverCache, "javaResolverCache");
    Object localObject = this.c;
    paramJavaResolverCache = ContextKt.replaceComponents((LazyJavaResolverContext)localObject, ((LazyJavaResolverContext)localObject).getComponents().replace(paramJavaResolverCache));
    localObject = getContainingDeclaration();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "containingDeclaration");
    return new LazyJavaClassDescriptor(paramJavaResolverCache, (DeclarationDescriptor)localObject, this.jClass, paramClassDescriptor);
  }
  
  @NotNull
  public Annotations getAnnotations()
  {
    return this.annotations;
  }
  
  @Nullable
  public ClassDescriptor getCompanionObjectDescriptor()
  {
    return null;
  }
  
  @NotNull
  public List<ClassConstructorDescriptor> getConstructors()
  {
    return (List)this.unsubstitutedMemberScope.getConstructors$descriptors_jvm().invoke();
  }
  
  @NotNull
  public List<TypeParameterDescriptor> getDeclaredTypeParameters()
  {
    return (List)this.declaredParameters.invoke();
  }
  
  @NotNull
  public final JavaClass getJClass()
  {
    return this.jClass;
  }
  
  @NotNull
  public ClassKind getKind()
  {
    return this.kind;
  }
  
  @NotNull
  public Modality getModality()
  {
    return this.modality;
  }
  
  @NotNull
  public Collection<ClassDescriptor> getSealedSubclasses()
  {
    return (Collection)CollectionsKt.emptyList();
  }
  
  @NotNull
  public MemberScope getStaticScope()
  {
    return (MemberScope)this.staticScope;
  }
  
  @NotNull
  public TypeConstructor getTypeConstructor()
  {
    return (TypeConstructor)this.typeConstructor;
  }
  
  @NotNull
  public MemberScope getUnsubstitutedInnerClassesScope()
  {
    return (MemberScope)this.innerClassesScope;
  }
  
  @NotNull
  public LazyJavaClassMemberScope getUnsubstitutedMemberScope()
  {
    MemberScope localMemberScope = super.getUnsubstitutedMemberScope();
    if (localMemberScope != null) {
      return (LazyJavaClassMemberScope)localMemberScope;
    }
    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.load.java.lazy.descriptors.LazyJavaClassMemberScope");
  }
  
  @NotNull
  protected LazyJavaClassMemberScope getUnsubstitutedMemberScope(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    return (LazyJavaClassMemberScope)this.scopeHolder.getScope(paramKotlinTypeRefiner);
  }
  
  @Nullable
  public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor()
  {
    return null;
  }
  
  @NotNull
  public Visibility getVisibility()
  {
    Visibility localVisibility;
    if ((Intrinsics.areEqual(this.visibility, Visibilities.PRIVATE)) && (this.jClass.getOuterClass() == null)) {
      localVisibility = JavaVisibilities.PACKAGE_VISIBILITY;
    } else {
      localVisibility = this.visibility;
    }
    Intrinsics.checkExpressionValueIsNotNull(localVisibility, "if (visibility == Visibi…ISIBILITY else visibility");
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
  
  public boolean isInline()
  {
    return false;
  }
  
  public boolean isInner()
  {
    return this.isInner;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Lazy Java class ");
    localStringBuilder.append(DescriptorUtilsKt.getFqNameUnsafe((DeclarationDescriptor)this));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor
 * JD-Core Version:    0.7.0.1
 */