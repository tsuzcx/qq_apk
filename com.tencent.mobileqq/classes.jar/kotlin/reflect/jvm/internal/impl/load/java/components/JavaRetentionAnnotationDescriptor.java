package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

public final class JavaRetentionAnnotationDescriptor
  extends JavaAnnotationDescriptor
{
  @NotNull
  private final NotNullLazyValue allValueArguments$delegate;
  
  public JavaRetentionAnnotationDescriptor(@NotNull JavaAnnotation paramJavaAnnotation, @NotNull LazyJavaResolverContext paramLazyJavaResolverContext)
  {
    super(paramLazyJavaResolverContext, paramJavaAnnotation, localFqName);
    this.allValueArguments$delegate = paramLazyJavaResolverContext.getStorageManager().createLazyValue((Function0)new JavaRetentionAnnotationDescriptor.allValueArguments.2(this));
  }
  
  @NotNull
  public Map<Name, ConstantValue<?>> getAllValueArguments()
  {
    return (Map)StorageKt.getValue(this.allValueArguments$delegate, this, $$delegatedProperties[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.components.JavaRetentionAnnotationDescriptor
 * JD-Core Version:    0.7.0.1
 */