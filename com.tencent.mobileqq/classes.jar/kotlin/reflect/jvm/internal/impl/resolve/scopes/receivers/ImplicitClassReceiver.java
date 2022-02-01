package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ImplicitClassReceiver
  implements ImplicitReceiver, ThisClassReceiver
{
  @NotNull
  private final ClassDescriptor classDescriptor;
  @NotNull
  private final ClassDescriptor declarationDescriptor;
  private final ImplicitClassReceiver original;
  
  public ImplicitClassReceiver(@NotNull ClassDescriptor paramClassDescriptor, @Nullable ImplicitClassReceiver paramImplicitClassReceiver)
  {
    this.classDescriptor = paramClassDescriptor;
    if (paramImplicitClassReceiver != null) {
      paramClassDescriptor = paramImplicitClassReceiver;
    } else {
      paramClassDescriptor = this;
    }
    this.original = paramClassDescriptor;
    this.declarationDescriptor = this.classDescriptor;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    ClassDescriptor localClassDescriptor = this.classDescriptor;
    boolean bool = paramObject instanceof ImplicitClassReceiver;
    Object localObject = null;
    if (!bool) {
      paramObject = null;
    }
    ImplicitClassReceiver localImplicitClassReceiver = (ImplicitClassReceiver)paramObject;
    paramObject = localObject;
    if (localImplicitClassReceiver != null) {
      paramObject = localImplicitClassReceiver.classDescriptor;
    }
    return Intrinsics.areEqual(localClassDescriptor, paramObject);
  }
  
  @NotNull
  public final ClassDescriptor getClassDescriptor()
  {
    return this.classDescriptor;
  }
  
  @NotNull
  public SimpleType getType()
  {
    SimpleType localSimpleType = this.classDescriptor.getDefaultType();
    Intrinsics.checkExpressionValueIsNotNull(localSimpleType, "classDescriptor.defaultType");
    return localSimpleType;
  }
  
  public int hashCode()
  {
    return this.classDescriptor.hashCode();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Class{");
    localStringBuilder.append(getType());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitClassReceiver
 * JD-Core Version:    0.7.0.1
 */