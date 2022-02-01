package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder.Request;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder.Result;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder.Result.ClassFileContent;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class LazyJavaPackageScope$classes$1
  extends Lambda
  implements Function1<LazyJavaPackageScope.FindClassRequest, ClassDescriptor>
{
  LazyJavaPackageScope$classes$1(LazyJavaPackageScope paramLazyJavaPackageScope, LazyJavaResolverContext paramLazyJavaResolverContext)
  {
    super(1);
  }
  
  @Nullable
  public final ClassDescriptor invoke(@NotNull LazyJavaPackageScope.FindClassRequest paramFindClassRequest)
  {
    Intrinsics.checkParameterIsNotNull(paramFindClassRequest, "request");
    ClassId localClassId2 = new ClassId(this.this$0.getOwnerDescriptor().getFqName(), paramFindClassRequest.getName());
    Object localObject1;
    if (paramFindClassRequest.getJavaClass() != null) {
      localObject1 = this.$c.getComponents().getKotlinClassFinder().findKotlinClassOrContent(paramFindClassRequest.getJavaClass());
    } else {
      localObject1 = this.$c.getComponents().getKotlinClassFinder().findKotlinClassOrContent(localClassId2);
    }
    if (localObject1 != null) {
      localObject2 = ((KotlinClassFinder.Result)localObject1).toKotlinJvmBinaryClass();
    } else {
      localObject2 = null;
    }
    ClassId localClassId1;
    if (localObject2 != null) {
      localClassId1 = ((KotlinJvmBinaryClass)localObject2).getClassId();
    } else {
      localClassId1 = null;
    }
    if ((localClassId1 != null) && ((localClassId1.isNestedClass()) || (localClassId1.isLocal()))) {
      return null;
    }
    Object localObject2 = LazyJavaPackageScope.access$resolveKotlinBinaryClass(this.this$0, (KotlinJvmBinaryClass)localObject2);
    if ((localObject2 instanceof LazyJavaPackageScope.KotlinClassLookupResult.Found)) {
      return ((LazyJavaPackageScope.KotlinClassLookupResult.Found)localObject2).getDescriptor();
    }
    if ((localObject2 instanceof LazyJavaPackageScope.KotlinClassLookupResult.SyntheticClass)) {
      return null;
    }
    if ((localObject2 instanceof LazyJavaPackageScope.KotlinClassLookupResult.NotFound))
    {
      paramFindClassRequest = paramFindClassRequest.getJavaClass();
      if (paramFindClassRequest == null) {
        for (;;)
        {
          localObject2 = this.$c.getComponents().getFinder();
          if (localObject1 != null)
          {
            paramFindClassRequest = (LazyJavaPackageScope.FindClassRequest)localObject1;
            if (!(localObject1 instanceof KotlinClassFinder.Result.ClassFileContent)) {
              paramFindClassRequest = null;
            }
            paramFindClassRequest = (KotlinClassFinder.Result.ClassFileContent)paramFindClassRequest;
            if (paramFindClassRequest != null)
            {
              paramFindClassRequest = paramFindClassRequest.getContent();
              break label229;
            }
          }
          paramFindClassRequest = null;
          label229:
          paramFindClassRequest = ((JavaClassFinder)localObject2).findClass(new JavaClassFinder.Request(localClassId2, paramFindClassRequest, null, 4, null));
        }
      }
      if (paramFindClassRequest != null) {
        localObject1 = paramFindClassRequest.getLightClassOriginKind();
      } else {
        localObject1 = null;
      }
      if (localObject1 != LightClassOriginKind.BINARY)
      {
        if (paramFindClassRequest != null) {
          localObject1 = paramFindClassRequest.getFqName();
        } else {
          localObject1 = null;
        }
        if ((localObject1 != null) && (!((FqName)localObject1).isRoot()) && (!(Intrinsics.areEqual(((FqName)localObject1).parent(), this.this$0.getOwnerDescriptor().getFqName()) ^ true)))
        {
          paramFindClassRequest = new LazyJavaClassDescriptor(this.$c, (DeclarationDescriptor)this.this$0.getOwnerDescriptor(), paramFindClassRequest, null, 8, null);
          this.$c.getComponents().getJavaClassesTracker().reportClass((JavaClassDescriptor)paramFindClassRequest);
        }
        else
        {
          paramFindClassRequest = null;
        }
        return (ClassDescriptor)paramFindClassRequest;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Couldn't find kotlin binary class for light class created by kotlin binary file\n");
      ((StringBuilder)localObject1).append("JavaClass: ");
      ((StringBuilder)localObject1).append(paramFindClassRequest);
      ((StringBuilder)localObject1).append('\n');
      ((StringBuilder)localObject1).append("ClassId: ");
      ((StringBuilder)localObject1).append(localClassId2);
      ((StringBuilder)localObject1).append('\n');
      ((StringBuilder)localObject1).append("findKotlinClass(JavaClass) = ");
      ((StringBuilder)localObject1).append(KotlinClassFinderKt.findKotlinClass(this.$c.getComponents().getKotlinClassFinder(), paramFindClassRequest));
      ((StringBuilder)localObject1).append('\n');
      ((StringBuilder)localObject1).append("findKotlinClass(ClassId) = ");
      ((StringBuilder)localObject1).append(KotlinClassFinderKt.findKotlinClass(this.$c.getComponents().getKotlinClassFinder(), localClassId2));
      ((StringBuilder)localObject1).append('\n');
      throw ((Throwable)new IllegalStateException(((StringBuilder)localObject1).toString()));
    }
    paramFindClassRequest = new NoWhenBranchMatchedException();
    for (;;)
    {
      throw paramFindClassRequest;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.classes.1
 * JD-Core Version:    0.7.0.1
 */