package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryPackageSourceElement;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaPackageFragment
  extends PackageFragmentDescriptorImpl
{
  @NotNull
  private final Annotations annotations;
  @NotNull
  private final NotNullLazyValue binaryClasses$delegate;
  private final LazyJavaResolverContext c;
  private final JavaPackage jPackage;
  private final NotNullLazyValue partToFacade$delegate;
  private final JvmPackageScope scope;
  private final NotNullLazyValue<List<FqName>> subPackages;
  
  public LazyJavaPackageFragment(@NotNull LazyJavaResolverContext paramLazyJavaResolverContext, @NotNull JavaPackage paramJavaPackage)
  {
    super(paramLazyJavaResolverContext.getModule(), paramJavaPackage.getFqName());
    this.jPackage = paramJavaPackage;
    this.c = ContextKt.childForClassOrPackage$default(paramLazyJavaResolverContext, (ClassOrPackageFragmentDescriptor)this, null, 0, 6, null);
    this.binaryClasses$delegate = this.c.getStorageManager().createLazyValue((Function0)new LazyJavaPackageFragment.binaryClasses.2(this));
    this.scope = new JvmPackageScope(this.c, this.jPackage, this);
    this.subPackages = this.c.getStorageManager().createRecursionTolerantLazyValue((Function0)new LazyJavaPackageFragment.subPackages.1(this), CollectionsKt.emptyList());
    if (this.c.getComponents().getAnnotationTypeQualifierResolver().getDisabled()) {
      paramLazyJavaResolverContext = Annotations.Companion.getEMPTY();
    } else {
      paramLazyJavaResolverContext = LazyJavaAnnotationsKt.resolveAnnotations(this.c, (JavaAnnotationOwner)this.jPackage);
    }
    this.annotations = paramLazyJavaResolverContext;
    this.partToFacade$delegate = this.c.getStorageManager().createLazyValue((Function0)new LazyJavaPackageFragment.partToFacade.2(this));
  }
  
  @Nullable
  public final ClassDescriptor findClassifierByJavaClass$descriptors_jvm(@NotNull JavaClass paramJavaClass)
  {
    Intrinsics.checkParameterIsNotNull(paramJavaClass, "jClass");
    return this.scope.getJavaScope$descriptors_jvm().findClassifierByJavaClass$descriptors_jvm(paramJavaClass);
  }
  
  @NotNull
  public Annotations getAnnotations()
  {
    return this.annotations;
  }
  
  @NotNull
  public final Map<String, KotlinJvmBinaryClass> getBinaryClasses$descriptors_jvm()
  {
    return (Map)StorageKt.getValue(this.binaryClasses$delegate, this, $$delegatedProperties[0]);
  }
  
  @NotNull
  public JvmPackageScope getMemberScope()
  {
    return this.scope;
  }
  
  @NotNull
  public SourceElement getSource()
  {
    return (SourceElement)new KotlinJvmBinaryPackageSourceElement(this);
  }
  
  @NotNull
  public final List<FqName> getSubPackageFqNames$descriptors_jvm()
  {
    return (List)this.subPackages.invoke();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Lazy Java package fragment: ");
    localStringBuilder.append(getFqName());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment
 * JD-Core Version:    0.7.0.1
 */