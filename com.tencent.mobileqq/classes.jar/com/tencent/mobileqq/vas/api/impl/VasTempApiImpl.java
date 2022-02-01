package com.tencent.mobileqq.vas.api.impl;

import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEDownloadCallBack;
import com.tencent.aelight.camera.download.api.IAEResDownload;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasTempApi;
import com.tencent.mobileqq.vas.ui.PagViewProxy;
import com.tencent.mobileqq.vas.ui.PagViewProxy.Companion;
import com.tencent.mobileqq.vas.util.VasSoUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/api/impl/VasTempApiImpl;", "Lcom/tencent/mobileqq/vas/api/IVasTempApi;", "()V", "initPagSo", "", "requestPagDownload", "", "block", "Lkotlin/Function0;", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasTempApiImpl
  implements IVasTempApi
{
  public static final VasTempApiImpl.Companion Companion = new VasTempApiImpl.Companion(null);
  private static final String PAG_SO_NAME = "liblibpag.so";
  
  public boolean initPagSo()
  {
    if (!((IAEResUtil)QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.LIGHT_RES_BASE_PACKAGE))
    {
      QLog.i(PagViewProxy.d.a(), 1, "Pag_so库,未下载完成");
      return false;
    }
    int i = VasSoUtils.a(((IAEResUtil)QRoute.api(IAEResUtil.class)).getFinalUnzipFilePath(), "liblibpag.so");
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return false;
        }
        QLog.e(PagViewProxy.d.a(), 1, "初始化Pag_so库,加载异常");
        return false;
      }
      QLog.e(PagViewProxy.d.a(), 1, "初始化Pag_so库,不存在");
      return false;
    }
    QLog.i(PagViewProxy.d.a(), 1, "初始化Pag_so库,完成");
    return true;
  }
  
  public void requestPagDownload(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    try
    {
      if (((IAEResUtil)QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.LIGHT_RES_BASE_PACKAGE))
      {
        QLog.i(PagViewProxy.d.a(), 1, "already download");
        paramFunction0.invoke();
        return;
      }
      ((IAEResDownload)QRoute.api(IAEResDownload.class)).requestDownload(AEResInfo.LIGHT_RES_BASE_PACKAGE, (IAEDownloadCallBack)new VasTempApiImpl.requestPagDownload.1(paramFunction0), false);
      return;
    }
    catch (Throwable paramFunction0)
    {
      QLog.e(PagViewProxy.d.a(), 1, paramFunction0, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.impl.VasTempApiImpl
 * JD-Core Version:    0.7.0.1
 */