package com.tencent.mobileqq.vas.adv.qzone.api.impl;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mobileqq.vas.adv.base.VasAdvBizCallback;
import com.tencent.mobileqq.vas.adv.base.service.VasAdvService;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport.Companion;
import com.tencent.mobileqq.vas.adv.base.support.app.VasAdvAppInterface.DefaultImpls;
import com.tencent.mobileqq.vas.adv.common.pb.adv_report.MobileAdvReportReq;
import com.tencent.mobileqq.vas.adv.common.pb.adv_report.MobileAdvReportRsp;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get.VacAdvReq;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get.VacAdvRsp;
import com.tencent.mobileqq.vas.adv.qzone.api.IVasQZoneApi;
import com.tencent.mobileqq.vas.adv.qzone.callback.VasAdMetaCallback;
import com.tencent.mobileqq.vas.adv.qzone.data.VasAdMetaParam;
import com.tencent.mobileqq.vas.adv.qzone.data.VasAdMetaReportParam;
import com.tencent.mobileqq.vas.adv.qzone.logic.AdVideoViewController;
import com.tencent.mobileqq.vas.adv.qzone.logic.AlbumRecommendAdvController;
import com.tencent.mobileqq.vas.adv.qzone.logic.IAdVideoViewController;
import com.tencent.mobileqq.vas.adv.qzone.logic.IAlbumRecommendAdvController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/qzone/api/impl/VasQZoneApiImpl;", "Lcom/tencent/mobileqq/vas/adv/qzone/api/IVasQZoneApi;", "()V", "currentCallback", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/vas/adv/qzone/callback/VasAdMetaCallback;", "reportedCache", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "addReportId", "", "id", "containsReportId", "", "createAdVideoViewController", "Lcom/tencent/mobileqq/vas/adv/qzone/logic/IAdVideoViewController;", "context", "Landroid/content/Context;", "createAlbumAdvViewController", "Lcom/tencent/mobileqq/vas/adv/qzone/logic/IAlbumRecommendAdvController;", "viewGroup", "Landroid/view/ViewGroup;", "executeRunnable", "runnable", "Ljava/lang/Runnable;", "getReportIdSet", "getReportRunnable", "param", "Lcom/tencent/mobileqq/vas/adv/qzone/data/VasAdMetaReportParam;", "innerCallback", "Lcom/tencent/mobileqq/vas/adv/base/VasAdvBizCallback;", "Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$MobileAdvReportRsp;", "getRequestAdvBizCallback", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacAdvRsp;", "callback", "getRequestAdvRunnable", "Lcom/tencent/mobileqq/vas/adv/qzone/data/VasAdMetaParam;", "reportAd", "req", "Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$MobileAdvReportReq;", "reportAdvAsync", "requestAd", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacAdvReq;", "requestAdvAsync", "Companion", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasQZoneApiImpl
  implements IVasQZoneApi
{
  public static final VasQZoneApiImpl.Companion Companion = new VasQZoneApiImpl.Companion(null);
  private static final String TAG = "VasQZoneApiImpl";
  private WeakReference<VasAdMetaCallback> currentCallback;
  private final HashSet<String> reportedCache = new HashSet();
  
  private final void executeRunnable(Runnable paramRunnable)
  {
    VasAdvAppInterface.DefaultImpls.a(VasAdvSupport.a.a(), paramRunnable, true, false, 4, null);
  }
  
  private final Runnable getReportRunnable(VasAdMetaReportParam paramVasAdMetaReportParam, VasAdvBizCallback<adv_report.MobileAdvReportRsp> paramVasAdvBizCallback)
  {
    return (Runnable)new VasQZoneApiImpl.getReportRunnable.1(this, paramVasAdMetaReportParam, paramVasAdvBizCallback);
  }
  
  private final VasAdvBizCallback<vac_adv_get.VacAdvRsp> getRequestAdvBizCallback(VasAdMetaCallback paramVasAdMetaCallback)
  {
    return (VasAdvBizCallback)new VasQZoneApiImpl.getRequestAdvBizCallback.1(this, paramVasAdMetaCallback);
  }
  
  private final Runnable getRequestAdvRunnable(VasAdMetaParam paramVasAdMetaParam, VasAdMetaCallback paramVasAdMetaCallback, VasAdvBizCallback<vac_adv_get.VacAdvRsp> paramVasAdvBizCallback)
  {
    return (Runnable)new VasQZoneApiImpl.getRequestAdvRunnable.1(this, paramVasAdMetaParam, paramVasAdMetaCallback, paramVasAdvBizCallback);
  }
  
  private final void reportAd(adv_report.MobileAdvReportReq paramMobileAdvReportReq, VasAdvBizCallback<adv_report.MobileAdvReportRsp> paramVasAdvBizCallback)
  {
    VasAdvService.a.a(paramMobileAdvReportReq, paramVasAdvBizCallback);
  }
  
  private final void requestAd(vac_adv_get.VacAdvReq paramVacAdvReq, VasAdvBizCallback<vac_adv_get.VacAdvRsp> paramVasAdvBizCallback)
  {
    VasAdvService.a.a(paramVacAdvReq, paramVasAdvBizCallback);
  }
  
  public void addReportId(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "id");
    this.reportedCache.add(paramString);
  }
  
  public boolean containsReportId(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "id");
    return this.reportedCache.contains(paramString);
  }
  
  @NotNull
  public IAdVideoViewController createAdVideoViewController(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return (IAdVideoViewController)new AdVideoViewController(paramContext);
  }
  
  @NotNull
  public IAlbumRecommendAdvController createAlbumAdvViewController(@NotNull Context paramContext, @NotNull ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "viewGroup");
    return (IAlbumRecommendAdvController)new AlbumRecommendAdvController(paramContext, paramViewGroup);
  }
  
  @NotNull
  public HashSet<String> getReportIdSet()
  {
    return this.reportedCache;
  }
  
  public void reportAdvAsync(@NotNull VasAdMetaReportParam paramVasAdMetaReportParam)
  {
    Intrinsics.checkParameterIsNotNull(paramVasAdMetaReportParam, "param");
    if (CollectionsKt.contains((Iterable)this.reportedCache, paramVasAdMetaReportParam.getSubscribeId()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportAdSync fail, ");
      localStringBuilder.append(paramVasAdMetaReportParam.getSubscribeId());
      localStringBuilder.append(" has reported");
      QLog.w("VasQZoneApiImpl", 1, localStringBuilder.toString());
      return;
    }
    executeRunnable(getReportRunnable(paramVasAdMetaReportParam, (VasAdvBizCallback)new VasQZoneApiImpl.reportAdvAsync.innerCallback.1()));
  }
  
  public void requestAdvAsync(@NotNull VasAdMetaParam paramVasAdMetaParam, @NotNull VasAdMetaCallback paramVasAdMetaCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramVasAdMetaParam, "param");
    Intrinsics.checkParameterIsNotNull(paramVasAdMetaCallback, "callback");
    this.currentCallback = new WeakReference(paramVasAdMetaCallback);
    executeRunnable(getRequestAdvRunnable(paramVasAdMetaParam, paramVasAdMetaCallback, getRequestAdvBizCallback(paramVasAdMetaCallback)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.qzone.api.impl.VasQZoneApiImpl
 * JD-Core Version:    0.7.0.1
 */