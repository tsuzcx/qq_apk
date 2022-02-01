package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

public final class NonEmptyDeserializedAnnotations
  extends DeserializedAnnotations
{
  public NonEmptyDeserializedAnnotations(@NotNull StorageManager paramStorageManager, @NotNull Function0<? extends List<? extends AnnotationDescriptor>> paramFunction0)
  {
    super(paramStorageManager, paramFunction0);
  }
  
  public boolean isEmpty()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.NonEmptyDeserializedAnnotations
 * JD-Core Version:    0.7.0.1
 */