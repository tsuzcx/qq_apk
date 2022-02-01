package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface KotlinClassFinder
  extends KotlinMetadataFinder
{
  @Nullable
  public abstract KotlinClassFinder.Result findKotlinClassOrContent(@NotNull JavaClass paramJavaClass);
  
  @Nullable
  public abstract KotlinClassFinder.Result findKotlinClassOrContent(@NotNull ClassId paramClassId);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder
 * JD-Core Version:    0.7.0.1
 */