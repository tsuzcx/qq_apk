package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.Kind;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProtoContainer$Class
  extends ProtoContainer
{
  @NotNull
  private final ClassId classId;
  @NotNull
  private final ProtoBuf.Class classProto;
  private final boolean isInner;
  @NotNull
  private final ProtoBuf.Class.Kind kind;
  @Nullable
  private final Class outerClass;
  
  public ProtoContainer$Class(@NotNull ProtoBuf.Class paramClass, @NotNull NameResolver paramNameResolver, @NotNull TypeTable paramTypeTable, @Nullable SourceElement paramSourceElement, @Nullable Class paramClass1)
  {
    super(paramNameResolver, paramTypeTable, paramSourceElement, null);
    this.classProto = paramClass;
    this.outerClass = paramClass1;
    this.classId = NameResolverUtilKt.getClassId(paramNameResolver, this.classProto.getFqName());
    paramClass = (ProtoBuf.Class.Kind)Flags.CLASS_KIND.get(this.classProto.getFlags());
    if (paramClass == null) {
      paramClass = ProtoBuf.Class.Kind.CLASS;
    }
    this.kind = paramClass;
    paramClass = Flags.IS_INNER.get(this.classProto.getFlags());
    Intrinsics.checkExpressionValueIsNotNull(paramClass, "Flags.IS_INNER.get(classProto.flags)");
    this.isInner = paramClass.booleanValue();
  }
  
  @NotNull
  public FqName debugFqName()
  {
    FqName localFqName = this.classId.asSingleFqName();
    Intrinsics.checkExpressionValueIsNotNull(localFqName, "classId.asSingleFqName()");
    return localFqName;
  }
  
  @NotNull
  public final ClassId getClassId()
  {
    return this.classId;
  }
  
  @NotNull
  public final ProtoBuf.Class getClassProto()
  {
    return this.classProto;
  }
  
  @NotNull
  public final ProtoBuf.Class.Kind getKind()
  {
    return this.kind;
  }
  
  @Nullable
  public final Class getOuterClass()
  {
    return this.outerClass;
  }
  
  public final boolean isInner()
  {
    return this.isInner;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Class
 * JD-Core Version:    0.7.0.1
 */