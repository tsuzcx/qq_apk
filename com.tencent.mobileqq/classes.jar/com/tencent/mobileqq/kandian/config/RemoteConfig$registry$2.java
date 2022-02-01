package com.tencent.mobileqq.kandian.config;

import com.tencent.mobileqq.kandian.config.interface.IRemoteConfigRegistry;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/kandian/config/interface/IRemoteConfigRegistry;", "invoke"}, k=3, mv={1, 1, 16})
final class RemoteConfig$registry$2
  extends Lambda
  implements Function0<IRemoteConfigRegistry>
{
  public static final 2 INSTANCE = new 2();
  
  RemoteConfig$registry$2()
  {
    super(0);
  }
  
  @NotNull
  public final IRemoteConfigRegistry invoke()
  {
    Object localObject = IRemoteConfigRegistry.class.getPackage();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "IRemoteConfigRegistry::class.java.`package`");
    localObject = ((Package)localObject).getName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append('.');
    localStringBuilder.append("RemoteConfigRegistryImpl");
    localObject = Class.forName(localStringBuilder.toString());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Class.forName(\"$packageName.$implClassName\")");
    localObject = JvmClassMappingKt.getKotlinClass((Class)localObject).getObjectInstance();
    if (localObject != null) {
      return (IRemoteConfigRegistry)localObject;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.config.`interface`.IRemoteConfigRegistry");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.config.RemoteConfig.registry.2
 * JD-Core Version:    0.7.0.1
 */