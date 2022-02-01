package kotlin.reflect.jvm.internal;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KPackageImpl;)V", "kotlinClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/ReflectKotlinClass;", "getKotlinClass", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;", "kotlinClass$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "members", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getMembers", "()Ljava/util/Collection;", "members$delegate", "metadata", "Lkotlin/Triple;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmNameResolver;", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMetadataVersion;", "getMetadata", "()Lkotlin/Triple;", "metadata$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "multifileFacade", "Ljava/lang/Class;", "getMultifileFacade", "()Ljava/lang/Class;", "multifileFacade$delegate", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "scope$delegate", "kotlin-reflection"}, k=1, mv={1, 1, 16})
final class KPackageImpl$Data
  extends KDeclarationContainerImpl.Data
{
  private final ReflectProperties.LazySoftVal kotlinClass$delegate = ReflectProperties.lazySoft((Function0)new KPackageImpl.Data.kotlinClass.2(this));
  @NotNull
  private final ReflectProperties.LazySoftVal members$delegate = ReflectProperties.lazySoft((Function0)new KPackageImpl.Data.members.2(this));
  @Nullable
  private final ReflectProperties.LazyVal metadata$delegate = ReflectProperties.lazy((Function0)new KPackageImpl.Data.metadata.2(this));
  @Nullable
  private final ReflectProperties.LazyVal multifileFacade$delegate = ReflectProperties.lazy((Function0)new KPackageImpl.Data.multifileFacade.2(this));
  @NotNull
  private final ReflectProperties.LazySoftVal scope$delegate = ReflectProperties.lazySoft((Function0)new KPackageImpl.Data.scope.2(this));
  
  public KPackageImpl$Data()
  {
    super(localKDeclarationContainerImpl);
  }
  
  private final ReflectKotlinClass getKotlinClass()
  {
    return (ReflectKotlinClass)this.kotlinClass$delegate.getValue(this, $$delegatedProperties[0]);
  }
  
  @NotNull
  public final Collection<KCallableImpl<?>> getMembers()
  {
    return (Collection)this.members$delegate.getValue(this, $$delegatedProperties[4]);
  }
  
  @Nullable
  public final Triple<JvmNameResolver, ProtoBuf.Package, JvmMetadataVersion> getMetadata()
  {
    return (Triple)this.metadata$delegate.getValue(this, $$delegatedProperties[3]);
  }
  
  @Nullable
  public final Class<?> getMultifileFacade()
  {
    return (Class)this.multifileFacade$delegate.getValue(this, $$delegatedProperties[2]);
  }
  
  @NotNull
  public final MemberScope getScope()
  {
    return (MemberScope)this.scope$delegate.getValue(this, $$delegatedProperties[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KPackageImpl.Data
 * JD-Core Version:    0.7.0.1
 */