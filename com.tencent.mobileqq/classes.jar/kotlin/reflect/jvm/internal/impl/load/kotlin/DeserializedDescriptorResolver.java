package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Set;
import kotlin.Pair;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPackageMemberScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DeserializedDescriptorResolver
{
  public static final DeserializedDescriptorResolver.Companion Companion = new DeserializedDescriptorResolver.Companion(null);
  private static final JvmMetadataVersion KOTLIN_1_1_EAP_METADATA_VERSION = new JvmMetadataVersion(new int[] { 1, 1, 2 });
  private static final JvmMetadataVersion KOTLIN_1_3_M1_METADATA_VERSION = new JvmMetadataVersion(new int[] { 1, 1, 11 });
  @NotNull
  private static final JvmMetadataVersion KOTLIN_1_3_RC_METADATA_VERSION = new JvmMetadataVersion(new int[] { 1, 1, 13 });
  @NotNull
  private static final Set<KotlinClassHeader.Kind> KOTLIN_CLASS = SetsKt.setOf(KotlinClassHeader.Kind.CLASS);
  private static final Set<KotlinClassHeader.Kind> KOTLIN_FILE_FACADE_OR_MULTIFILE_CLASS_PART = SetsKt.setOf(new KotlinClassHeader.Kind[] { KotlinClassHeader.Kind.FILE_FACADE, KotlinClassHeader.Kind.MULTIFILE_CLASS_PART });
  @NotNull
  public DeserializationComponents components;
  
  private final IncompatibleVersionErrorData<JvmMetadataVersion> getIncompatibility(@NotNull KotlinJvmBinaryClass paramKotlinJvmBinaryClass)
  {
    if ((!getSkipMetadataVersionCheck()) && (!paramKotlinJvmBinaryClass.getClassHeader().getMetadataVersion().isCompatible())) {
      return new IncompatibleVersionErrorData((BinaryVersion)paramKotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), (BinaryVersion)JvmMetadataVersion.INSTANCE, paramKotlinJvmBinaryClass.getLocation(), paramKotlinJvmBinaryClass.getClassId());
    }
    return null;
  }
  
  private final boolean getSkipMetadataVersionCheck()
  {
    DeserializationComponents localDeserializationComponents = this.components;
    if (localDeserializationComponents == null) {
      Intrinsics.throwUninitializedPropertyAccessException("components");
    }
    return localDeserializationComponents.getConfiguration().getSkipMetadataVersionCheck();
  }
  
  private final boolean isCompiledWith13M1(@NotNull KotlinJvmBinaryClass paramKotlinJvmBinaryClass)
  {
    DeserializationComponents localDeserializationComponents = this.components;
    if (localDeserializationComponents == null) {
      Intrinsics.throwUninitializedPropertyAccessException("components");
    }
    return (!localDeserializationComponents.getConfiguration().getSkipMetadataVersionCheck()) && (paramKotlinJvmBinaryClass.getClassHeader().isPreRelease()) && (Intrinsics.areEqual(paramKotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), KOTLIN_1_3_M1_METADATA_VERSION));
  }
  
  private final boolean isPreReleaseInvisible(@NotNull KotlinJvmBinaryClass paramKotlinJvmBinaryClass)
  {
    DeserializationComponents localDeserializationComponents = this.components;
    if (localDeserializationComponents == null) {
      Intrinsics.throwUninitializedPropertyAccessException("components");
    }
    return ((localDeserializationComponents.getConfiguration().getReportErrorsOnPreReleaseDependencies()) && ((paramKotlinJvmBinaryClass.getClassHeader().isPreRelease()) || (Intrinsics.areEqual(paramKotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), KOTLIN_1_1_EAP_METADATA_VERSION)))) || (isCompiledWith13M1(paramKotlinJvmBinaryClass));
  }
  
  private final String[] readData(KotlinJvmBinaryClass paramKotlinJvmBinaryClass, Set<? extends KotlinClassHeader.Kind> paramSet)
  {
    KotlinClassHeader localKotlinClassHeader = paramKotlinJvmBinaryClass.getClassHeader();
    paramKotlinJvmBinaryClass = localKotlinClassHeader.getData();
    if (paramKotlinJvmBinaryClass == null) {
      paramKotlinJvmBinaryClass = localKotlinClassHeader.getIncompatibleData();
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramKotlinJvmBinaryClass != null)
    {
      localObject1 = localObject2;
      if (paramSet.contains(localKotlinClassHeader.getKind())) {
        localObject1 = paramKotlinJvmBinaryClass;
      }
    }
    return localObject1;
  }
  
  @Nullable
  public final MemberScope createKotlinPackagePartScope(@NotNull PackageFragmentDescriptor paramPackageFragmentDescriptor, @NotNull KotlinJvmBinaryClass paramKotlinJvmBinaryClass)
  {
    Intrinsics.checkParameterIsNotNull(paramPackageFragmentDescriptor, "descriptor");
    Intrinsics.checkParameterIsNotNull(paramKotlinJvmBinaryClass, "kotlinClass");
    Object localObject1 = readData(paramKotlinJvmBinaryClass, KOTLIN_FILE_FACADE_OR_MULTIFILE_CLASS_PART);
    if (localObject1 != null)
    {
      Object localObject2 = paramKotlinJvmBinaryClass.getClassHeader().getStrings();
      if (localObject2 != null)
      {
        try
        {
          localObject1 = JvmProtoBufUtil.readPackageDataFrom((String[])localObject1, (String[])localObject2);
        }
        catch (Throwable localThrowable) {}catch (InvalidProtocolBufferException localInvalidProtocolBufferException)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Could not read data from ");
          ((StringBuilder)localObject2).append(paramKotlinJvmBinaryClass.getLocation());
          throw ((Throwable)new IllegalStateException(((StringBuilder)localObject2).toString(), (Throwable)localInvalidProtocolBufferException));
        }
        ProtoBuf.Package localPackage;
        if ((!access$getSkipMetadataVersionCheck$p(this)) && (!paramKotlinJvmBinaryClass.getClassHeader().getMetadataVersion().isCompatible()))
        {
          localPackage = null;
          if (localPackage != null)
          {
            localObject2 = (JvmNameResolver)localPackage.component1();
            localPackage = (ProtoBuf.Package)localPackage.component2();
            localObject2 = (NameResolver)localObject2;
            Object localObject3 = new JvmPackagePartSource(paramKotlinJvmBinaryClass, localPackage, (NameResolver)localObject2, getIncompatibility(paramKotlinJvmBinaryClass), isPreReleaseInvisible(paramKotlinJvmBinaryClass));
            paramKotlinJvmBinaryClass = (BinaryVersion)paramKotlinJvmBinaryClass.getClassHeader().getMetadataVersion();
            localObject3 = (DeserializedContainerSource)localObject3;
            DeserializationComponents localDeserializationComponents = this.components;
            if (localDeserializationComponents == null) {
              Intrinsics.throwUninitializedPropertyAccessException("components");
            }
            return (MemberScope)new DeserializedPackageMemberScope(paramPackageFragmentDescriptor, localPackage, (NameResolver)localObject2, paramKotlinJvmBinaryClass, (DeserializedContainerSource)localObject3, localDeserializationComponents, (Function0)DeserializedDescriptorResolver.createKotlinPackagePartScope.2.INSTANCE);
          }
          return null;
        }
        throw localPackage;
      }
    }
    return null;
  }
  
  @NotNull
  public final DeserializationComponents getComponents()
  {
    DeserializationComponents localDeserializationComponents = this.components;
    if (localDeserializationComponents == null) {
      Intrinsics.throwUninitializedPropertyAccessException("components");
    }
    return localDeserializationComponents;
  }
  
  @Nullable
  public final ClassData readClassData$descriptors_jvm(@NotNull KotlinJvmBinaryClass paramKotlinJvmBinaryClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinJvmBinaryClass, "kotlinClass");
    Object localObject1 = readData(paramKotlinJvmBinaryClass, KOTLIN_CLASS);
    if (localObject1 != null)
    {
      Object localObject2 = paramKotlinJvmBinaryClass.getClassHeader().getStrings();
      if (localObject2 != null)
      {
        try
        {
          localObject1 = JvmProtoBufUtil.readClassDataFrom((String[])localObject1, (String[])localObject2);
        }
        catch (Throwable localThrowable) {}catch (InvalidProtocolBufferException localInvalidProtocolBufferException)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Could not read data from ");
          ((StringBuilder)localObject2).append(paramKotlinJvmBinaryClass.getLocation());
          throw ((Throwable)new IllegalStateException(((StringBuilder)localObject2).toString(), (Throwable)localInvalidProtocolBufferException));
        }
        ProtoBuf.Class localClass;
        if ((!access$getSkipMetadataVersionCheck$p(this)) && (!paramKotlinJvmBinaryClass.getClassHeader().getMetadataVersion().isCompatible()))
        {
          localClass = null;
          if (localClass != null)
          {
            localObject2 = (JvmNameResolver)localClass.component1();
            localClass = (ProtoBuf.Class)localClass.component2();
            KotlinJvmBinarySourceElement localKotlinJvmBinarySourceElement = new KotlinJvmBinarySourceElement(paramKotlinJvmBinaryClass, getIncompatibility(paramKotlinJvmBinaryClass), isPreReleaseInvisible(paramKotlinJvmBinaryClass));
            return new ClassData((NameResolver)localObject2, localClass, (BinaryVersion)paramKotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), (SourceElement)localKotlinJvmBinarySourceElement);
          }
          return null;
        }
        throw localClass;
      }
    }
    return null;
  }
  
  @Nullable
  public final ClassDescriptor resolveClass(@NotNull KotlinJvmBinaryClass paramKotlinJvmBinaryClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinJvmBinaryClass, "kotlinClass");
    ClassData localClassData = readClassData$descriptors_jvm(paramKotlinJvmBinaryClass);
    if (localClassData != null)
    {
      DeserializationComponents localDeserializationComponents = this.components;
      if (localDeserializationComponents == null) {
        Intrinsics.throwUninitializedPropertyAccessException("components");
      }
      return localDeserializationComponents.getClassDeserializer().deserializeClass(paramKotlinJvmBinaryClass.getClassId(), localClassData);
    }
    return null;
  }
  
  public final void setComponents(@NotNull DeserializationComponentsForJava paramDeserializationComponentsForJava)
  {
    Intrinsics.checkParameterIsNotNull(paramDeserializationComponentsForJava, "components");
    this.components = paramDeserializationComponentsForJava.getComponents();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver
 * JD-Core Version:    0.7.0.1
 */