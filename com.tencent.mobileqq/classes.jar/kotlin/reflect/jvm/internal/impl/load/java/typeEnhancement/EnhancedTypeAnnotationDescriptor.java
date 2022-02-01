package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor.DefaultImpls;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class EnhancedTypeAnnotationDescriptor
  implements AnnotationDescriptor
{
  public static final EnhancedTypeAnnotationDescriptor INSTANCE = new EnhancedTypeAnnotationDescriptor();
  
  private final Void throwError()
  {
    throw ((Throwable)new IllegalStateException("No methods should be called on this descriptor. Only its presence matters".toString()));
  }
  
  @NotNull
  public Map<Name, ConstantValue<?>> getAllValueArguments()
  {
    throwError();
    throw null;
  }
  
  @Nullable
  public FqName getFqName()
  {
    return AnnotationDescriptor.DefaultImpls.getFqName(this);
  }
  
  @NotNull
  public SourceElement getSource()
  {
    throwError();
    throw null;
  }
  
  @NotNull
  public KotlinType getType()
  {
    throwError();
    throw null;
  }
  
  @NotNull
  public String toString()
  {
    return "[EnhancedType]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.EnhancedTypeAnnotationDescriptor
 * JD-Core Version:    0.7.0.1
 */