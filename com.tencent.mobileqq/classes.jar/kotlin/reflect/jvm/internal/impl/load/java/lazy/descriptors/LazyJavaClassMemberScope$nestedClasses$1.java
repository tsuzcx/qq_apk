package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder.Request;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class LazyJavaClassMemberScope$nestedClasses$1
  extends Lambda
  implements Function1<Name, ClassDescriptorBase>
{
  LazyJavaClassMemberScope$nestedClasses$1(LazyJavaClassMemberScope paramLazyJavaClassMemberScope, LazyJavaResolverContext paramLazyJavaResolverContext)
  {
    super(1);
  }
  
  @Nullable
  public final ClassDescriptorBase invoke(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    boolean bool = ((Set)LazyJavaClassMemberScope.access$getNestedClassIndex$p(this.this$0).invoke()).contains(paramName);
    Object localObject1 = null;
    if (!bool)
    {
      localObject2 = (JavaField)((Map)LazyJavaClassMemberScope.access$getEnumEntryIndex$p(this.this$0).invoke()).get(paramName);
      if (localObject2 != null)
      {
        localObject1 = this.$c.getStorageManager().createLazyValue((Function0)new LazyJavaClassMemberScope.nestedClasses.1.enumMemberNames.1(this));
        localObject1 = EnumEntrySyntheticClassDescriptor.create(this.$c.getStorageManager(), this.this$0.getOwnerDescriptor(), paramName, (NotNullLazyValue)localObject1, LazyJavaAnnotationsKt.resolveAnnotations(this.$c, (JavaAnnotationOwner)localObject2), (SourceElement)this.$c.getComponents().getSourceElementFactory().source((JavaElement)localObject2));
      }
      return (ClassDescriptorBase)localObject1;
    }
    localObject1 = this.$c.getComponents().getFinder();
    Object localObject2 = DescriptorUtilsKt.getClassId((ClassifierDescriptor)this.this$0.getOwnerDescriptor());
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    paramName = ((ClassId)localObject2).createNestedClassId(paramName);
    Intrinsics.checkExpressionValueIsNotNull(paramName, "ownerDescriptor.classId!…createNestedClassId(name)");
    paramName = ((JavaClassFinder)localObject1).findClass(new JavaClassFinder.Request(paramName, null, LazyJavaClassMemberScope.access$getJClass$p(this.this$0), 2, null));
    if (paramName != null)
    {
      paramName = new LazyJavaClassDescriptor(this.$c, (DeclarationDescriptor)this.this$0.getOwnerDescriptor(), paramName, null, 8, null);
      this.$c.getComponents().getJavaClassesTracker().reportClass((JavaClassDescriptor)paramName);
    }
    else
    {
      paramName = null;
    }
    return (ClassDescriptorBase)paramName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.nestedClasses.1
 * JD-Core Version:    0.7.0.1
 */