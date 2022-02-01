package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface AnnotationDescriptor
{
  @NotNull
  public abstract Map<Name, ConstantValue<?>> getAllValueArguments();
  
  @Nullable
  public abstract FqName getFqName();
  
  @NotNull
  public abstract SourceElement getSource();
  
  @NotNull
  public abstract KotlinType getType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
 * JD-Core Version:    0.7.0.1
 */