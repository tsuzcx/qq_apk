package com.tencent.xaction;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.XAResBusiness;
import com.tencent.mobileqq.vas.util.QQVasUpdateBusinessUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import com.tencent.vas.update.callback.listener.IUpdateListener;
import com.tencent.xaction.openapi.XAApi;
import com.tencent.xaction.openapi.api.IXAGlobal;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/XActionImpl$Companion;", "", "()V", "download", "", "id", "", "callback", "Lkotlin/Function2;", "", "downloadFromUrl", "url", "downloadFromVasUpdate", "init", "preDownload", "response", "tag", "data", "vas-impl_release"}, k=1, mv={1, 1, 16})
public final class XActionImpl$Companion
{
  private final void a(Function2<? super String, ? super String, Unit> paramFunction2, String paramString1, String paramString2)
  {
    if (paramFunction2 != null) {
      paramFunction2 = (Unit)paramFunction2.invoke(paramString1, paramString2);
    }
  }
  
  private final void b()
  {
    Companion localCompanion = (Companion)this;
    localCompanion.a(1, null);
    localCompanion.a(4, null);
  }
  
  @JvmStatic
  public final void a()
  {
    XAApi.e().registerGlobalRule("$DOWNLOAD", new XActionImpl.Companion.init.1());
    ((Companion)this).b();
  }
  
  public final void a(int paramInt, @Nullable Function2<? super String, ? super String, Unit> paramFunction2)
  {
    Object localObject = (XAResBusiness)QQVasUpdateBusinessUtil.a(XAResBusiness.class);
    String str = ((XAResBusiness)localObject).b(paramInt);
    if (new File(((XAResBusiness)localObject).e(str)).exists())
    {
      Companion localCompanion = (Companion)this;
      localObject = ((XAResBusiness)localObject).e(str);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "business.getSavePath(scid)");
      localCompanion.a(paramFunction2, "success", (String)localObject);
      return;
    }
    if (localObject == null) {
      return;
    }
    ((XAResBusiness)localObject).addUpdateListener((IUpdateListener)new XActionImpl.Companion.download.1(paramFunction2, (XAResBusiness)localObject, str));
    ((XAResBusiness)localObject).startDownload(str);
  }
  
  public final void a(@NotNull String paramString, @NotNull Function2<? super String, ? super String, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "callback");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(QQVasUpdateBusiness.a);
    ((StringBuilder)localObject).append("xaresWithUrl/");
    ((StringBuilder)localObject).append(MD5FileUtil.b(paramString));
    ((StringBuilder)localObject).append(".zip");
    localObject = ((StringBuilder)localObject).toString();
    if (new File((String)localObject).exists())
    {
      paramFunction2.invoke("success", localObject);
      return;
    }
    DownloaderInterface localDownloaderInterface = ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).getDownloader(4);
    DownloadTask localDownloadTask = new DownloadTask(paramString, new File((String)localObject));
    localDownloadTask.J = true;
    localDownloadTask.e = 1;
    localDownloadTask.Q = true;
    if (localDownloaderInterface != null) {
      localDownloaderInterface.startDownload(localDownloadTask, (DownloadListener)new XActionImpl.Companion.downloadFromUrl.1(paramFunction2, (String)localObject, paramString), null);
    }
  }
  
  public final void b(@NotNull String paramString, @Nullable Function2<? super String, ? super String, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "id");
    try
    {
      int i = Integer.parseInt(paramString);
      ((Companion)this).a(i, paramFunction2);
      return;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      ((Companion)this).a(paramFunction2, "failed", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.XActionImpl.Companion
 * JD-Core Version:    0.7.0.1
 */