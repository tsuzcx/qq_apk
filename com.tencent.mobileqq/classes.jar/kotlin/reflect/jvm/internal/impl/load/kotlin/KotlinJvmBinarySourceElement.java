package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class KotlinJvmBinarySourceElement
  implements DeserializedContainerSource
{
  @NotNull
  private final KotlinJvmBinaryClass binaryClass;
  @Nullable
  private final IncompatibleVersionErrorData<JvmMetadataVersion> incompatibility;
  private final boolean isPreReleaseInvisible;
  
  public KotlinJvmBinarySourceElement(@NotNull KotlinJvmBinaryClass paramKotlinJvmBinaryClass, @Nullable IncompatibleVersionErrorData<JvmMetadataVersion> paramIncompatibleVersionErrorData, boolean paramBoolean)
  {
    this.binaryClass = paramKotlinJvmBinaryClass;
    this.incompatibility = paramIncompatibleVersionErrorData;
    this.isPreReleaseInvisible = paramBoolean;
  }
  
  @NotNull
  public final KotlinJvmBinaryClass getBinaryClass()
  {
    return this.binaryClass;
  }
  
  @NotNull
  public SourceFile getContainingFile()
  {
    SourceFile localSourceFile = SourceFile.NO_SOURCE_FILE;
    Intrinsics.checkExpressionValueIsNotNull(localSourceFile, "SourceFile.NO_SOURCE_FILE");
    return localSourceFile;
  }
  
  @NotNull
  public String getPresentableString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Class '");
    localStringBuilder.append(this.binaryClass.getClassId().asSingleFqName().asString());
    localStringBuilder.append('\'');
    return localStringBuilder.toString();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append(": ");
    localStringBuilder.append(this.binaryClass);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinarySourceElement
 * JD-Core Version:    0.7.0.1
 */