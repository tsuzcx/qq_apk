package com.tencent.mobileqq.util.privacy.handler;

import com.tencent.mobileqq.data.entitymanager.Provider;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/util/privacy/handler/JSPackageInfoHandlerProvider;", "Lcom/tencent/mobileqq/data/entitymanager/Provider;", "", "Lcom/tencent/mobileqq/util/privacy/handler/IJSPackageInfoHandler;", "()V", "get", "QQCommon_release"}, k=1, mv={1, 1, 16})
public final class JSPackageInfoHandlerProvider
  implements Provider<List<? extends IJSPackageInfoHandler>>
{
  @NotNull
  public List<IJSPackageInfoHandler> a()
  {
    return (List)CollectionsKt.arrayListOf(new IJSPackageInfoHandler[] { (IJSPackageInfoHandler)new IsAppInstallHandler(), (IJSPackageInfoHandler)new CheckAppInstallHandler(), (IJSPackageInfoHandler)new CheckAppInstalledBatchHandler(), (IJSPackageInfoHandler)new IsAppInstalledBatchHandler(), (IJSPackageInfoHandler)new GetAppVersionCodeBatchHandler() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.privacy.handler.JSPackageInfoHandlerProvider
 * JD-Core Version:    0.7.0.1
 */