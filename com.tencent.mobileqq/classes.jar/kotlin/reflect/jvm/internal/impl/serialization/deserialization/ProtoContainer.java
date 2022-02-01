package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ProtoContainer
{
  @NotNull
  private final NameResolver nameResolver;
  @Nullable
  private final SourceElement source;
  @NotNull
  private final TypeTable typeTable;
  
  private ProtoContainer(NameResolver paramNameResolver, TypeTable paramTypeTable, SourceElement paramSourceElement)
  {
    this.nameResolver = paramNameResolver;
    this.typeTable = paramTypeTable;
    this.source = paramSourceElement;
  }
  
  @NotNull
  public abstract FqName debugFqName();
  
  @NotNull
  public final NameResolver getNameResolver()
  {
    return this.nameResolver;
  }
  
  @Nullable
  public final SourceElement getSource()
  {
    return this.source;
  }
  
  @NotNull
  public final TypeTable getTypeTable()
  {
    return this.typeTable;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append(": ");
    localStringBuilder.append(debugFqName());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer
 * JD-Core Version:    0.7.0.1
 */