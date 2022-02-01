package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProtoContainer$Package
  extends ProtoContainer
{
  @NotNull
  private final FqName fqName;
  
  public ProtoContainer$Package(@NotNull FqName paramFqName, @NotNull NameResolver paramNameResolver, @NotNull TypeTable paramTypeTable, @Nullable SourceElement paramSourceElement)
  {
    super(paramNameResolver, paramTypeTable, paramSourceElement, null);
    this.fqName = paramFqName;
  }
  
  @NotNull
  public FqName debugFqName()
  {
    return this.fqName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Package
 * JD-Core Version:    0.7.0.1
 */