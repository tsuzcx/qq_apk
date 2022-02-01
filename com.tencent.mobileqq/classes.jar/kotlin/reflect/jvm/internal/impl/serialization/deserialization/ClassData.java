package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ClassData
{
  @NotNull
  private final ProtoBuf.Class classProto;
  @NotNull
  private final BinaryVersion metadataVersion;
  @NotNull
  private final NameResolver nameResolver;
  @NotNull
  private final SourceElement sourceElement;
  
  public ClassData(@NotNull NameResolver paramNameResolver, @NotNull ProtoBuf.Class paramClass, @NotNull BinaryVersion paramBinaryVersion, @NotNull SourceElement paramSourceElement)
  {
    this.nameResolver = paramNameResolver;
    this.classProto = paramClass;
    this.metadataVersion = paramBinaryVersion;
    this.sourceElement = paramSourceElement;
  }
  
  @NotNull
  public final NameResolver component1()
  {
    return this.nameResolver;
  }
  
  @NotNull
  public final ProtoBuf.Class component2()
  {
    return this.classProto;
  }
  
  @NotNull
  public final BinaryVersion component3()
  {
    return this.metadataVersion;
  }
  
  @NotNull
  public final SourceElement component4()
  {
    return this.sourceElement;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ClassData))
      {
        paramObject = (ClassData)paramObject;
        if ((Intrinsics.areEqual(this.nameResolver, paramObject.nameResolver)) && (Intrinsics.areEqual(this.classProto, paramObject.classProto)) && (Intrinsics.areEqual(this.metadataVersion, paramObject.metadataVersion)) && (Intrinsics.areEqual(this.sourceElement, paramObject.sourceElement))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    Object localObject = this.nameResolver;
    int m = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.classProto;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.metadataVersion;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.sourceElement;
    if (localObject != null) {
      m = localObject.hashCode();
    }
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ClassData(nameResolver=");
    localStringBuilder.append(this.nameResolver);
    localStringBuilder.append(", classProto=");
    localStringBuilder.append(this.classProto);
    localStringBuilder.append(", metadataVersion=");
    localStringBuilder.append(this.metadataVersion);
    localStringBuilder.append(", sourceElement=");
    localStringBuilder.append(this.sourceElement);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassData
 * JD-Core Version:    0.7.0.1
 */