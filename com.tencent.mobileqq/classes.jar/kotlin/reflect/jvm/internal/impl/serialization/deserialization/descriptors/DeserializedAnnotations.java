package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.DefaultImpls;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DeserializedAnnotations
  implements Annotations
{
  private final NotNullLazyValue annotations$delegate;
  
  public DeserializedAnnotations(@NotNull StorageManager paramStorageManager, @NotNull Function0<? extends List<? extends AnnotationDescriptor>> paramFunction0)
  {
    this.annotations$delegate = paramStorageManager.createLazyValue(paramFunction0);
  }
  
  private final List<AnnotationDescriptor> getAnnotations()
  {
    return (List)StorageKt.getValue(this.annotations$delegate, this, $$delegatedProperties[0]);
  }
  
  @Nullable
  public AnnotationDescriptor findAnnotation(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    return Annotations.DefaultImpls.findAnnotation(this, paramFqName);
  }
  
  public boolean hasAnnotation(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    return Annotations.DefaultImpls.hasAnnotation(this, paramFqName);
  }
  
  public boolean isEmpty()
  {
    return getAnnotations().isEmpty();
  }
  
  @NotNull
  public Iterator<AnnotationDescriptor> iterator()
  {
    return getAnnotations().iterator();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations
 * JD-Core Version:    0.7.0.1
 */