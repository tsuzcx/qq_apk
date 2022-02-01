package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JvmPackagePartSource
  implements DeserializedContainerSource
{
  @NotNull
  private final JvmClassName className;
  @Nullable
  private final JvmClassName facadeClassName;
  @Nullable
  private final IncompatibleVersionErrorData<JvmMetadataVersion> incompatibility;
  private final boolean isPreReleaseInvisible;
  @Nullable
  private final KotlinJvmBinaryClass knownJvmBinaryClass;
  @NotNull
  private final String moduleName;
  
  public JvmPackagePartSource(@NotNull KotlinJvmBinaryClass paramKotlinJvmBinaryClass, @NotNull ProtoBuf.Package paramPackage, @NotNull NameResolver paramNameResolver, @Nullable IncompatibleVersionErrorData<JvmMetadataVersion> paramIncompatibleVersionErrorData, boolean paramBoolean)
  {
    this(localJvmClassName, (JvmClassName)localObject1, paramPackage, paramNameResolver, paramIncompatibleVersionErrorData, paramBoolean, paramKotlinJvmBinaryClass);
  }
  
  public JvmPackagePartSource(@NotNull JvmClassName paramJvmClassName1, @Nullable JvmClassName paramJvmClassName2, @NotNull ProtoBuf.Package paramPackage, @NotNull NameResolver paramNameResolver, @Nullable IncompatibleVersionErrorData<JvmMetadataVersion> paramIncompatibleVersionErrorData, boolean paramBoolean, @Nullable KotlinJvmBinaryClass paramKotlinJvmBinaryClass)
  {
    this.className = paramJvmClassName1;
    this.facadeClassName = paramJvmClassName2;
    this.incompatibility = paramIncompatibleVersionErrorData;
    this.isPreReleaseInvisible = paramBoolean;
    this.knownJvmBinaryClass = paramKotlinJvmBinaryClass;
    paramJvmClassName1 = (GeneratedMessageLite.ExtendableMessage)paramPackage;
    paramJvmClassName2 = JvmProtoBuf.packageModuleName;
    Intrinsics.checkExpressionValueIsNotNull(paramJvmClassName2, "JvmProtoBuf.packageModuleName");
    paramJvmClassName1 = (Integer)ProtoBufUtilKt.getExtensionOrNull(paramJvmClassName1, paramJvmClassName2);
    if (paramJvmClassName1 != null)
    {
      paramJvmClassName1 = paramNameResolver.getString(((Number)paramJvmClassName1).intValue());
      if (paramJvmClassName1 != null) {}
    }
    else
    {
      paramJvmClassName1 = "main";
    }
    this.moduleName = paramJvmClassName1;
  }
  
  @NotNull
  public final ClassId getClassId()
  {
    return new ClassId(this.className.getPackageFqName(), getSimpleName());
  }
  
  @NotNull
  public SourceFile getContainingFile()
  {
    SourceFile localSourceFile = SourceFile.NO_SOURCE_FILE;
    Intrinsics.checkExpressionValueIsNotNull(localSourceFile, "SourceFile.NO_SOURCE_FILE");
    return localSourceFile;
  }
  
  @Nullable
  public final JvmClassName getFacadeClassName()
  {
    return this.facadeClassName;
  }
  
  @Nullable
  public final KotlinJvmBinaryClass getKnownJvmBinaryClass()
  {
    return this.knownJvmBinaryClass;
  }
  
  @NotNull
  public String getPresentableString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Class '");
    localStringBuilder.append(getClassId().asSingleFqName().asString());
    localStringBuilder.append('\'');
    return localStringBuilder.toString();
  }
  
  @NotNull
  public final Name getSimpleName()
  {
    Object localObject = this.className.getInternalName();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "className.internalName");
    localObject = Name.identifier(StringsKt.substringAfterLast$default((String)localObject, '/', null, 2, null));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Name.identifier(classNam….substringAfterLast('/'))");
    return localObject;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append(": ");
    localStringBuilder.append(this.className);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource
 * JD-Core Version:    0.7.0.1
 */