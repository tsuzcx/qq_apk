package com.tencent.mobileqq.kandian.config;

import com.tencent.mobileqq.kandian.config.interface.IRemoteConfigWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/config/RemoteConfig;", "", "()V", "localRepo", "Lcom/tencent/mobileqq/kandian/config/interface/IConfigLocalRepo;", "readerCacheMap", "", "", "registry", "Lcom/tencent/mobileqq/kandian/config/interface/IRemoteConfigRegistry;", "getRegistry", "()Lcom/tencent/mobileqq/kandian/config/interface/IRemoteConfigRegistry;", "registry$delegate", "Lkotlin/Lazy;", "writerCacheMap", "", "Lcom/tencent/mobileqq/kandian/config/interface/IRemoteConfigWriter;", "bindLocalRepo", "", "get", "T", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "getWriterById", "id", "kandian-config"}, k=1, mv={1, 1, 16})
public final class RemoteConfig
{
  public static final RemoteConfig a;
  private static final Map<String, Object> jdField_a_of_type_JavaUtilMap = (Map)new LinkedHashMap();
  private static final Lazy jdField_a_of_type_KotlinLazy;
  private static final Map<Integer, IRemoteConfigWriter> b = (Map)new LinkedHashMap();
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianConfigRemoteConfig = new RemoteConfig();
    jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)RemoteConfig.registry.2.INSTANCE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.config.RemoteConfig
 * JD-Core Version:    0.7.0.1
 */