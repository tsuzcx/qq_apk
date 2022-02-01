package com.tencent.mobileqq.vas.adv.qzone.api;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vas.adv.qzone.callback.VasAdMetaCallback;
import com.tencent.mobileqq.vas.adv.qzone.data.VasAdMetaParam;
import com.tencent.mobileqq.vas.adv.qzone.data.VasAdMetaReportParam;
import com.tencent.mobileqq.vas.adv.qzone.logic.IAdVideoViewController;
import com.tencent.mobileqq.vas.adv.qzone.logic.IAlbumRecommendAdvController;
import java.util.HashSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/qzone/api/IVasQZoneApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addReportId", "", "id", "", "containsReportId", "", "createAdVideoViewController", "Lcom/tencent/mobileqq/vas/adv/qzone/logic/IAdVideoViewController;", "context", "Landroid/content/Context;", "createAlbumAdvViewController", "Lcom/tencent/mobileqq/vas/adv/qzone/logic/IAlbumRecommendAdvController;", "viewGroup", "Landroid/view/ViewGroup;", "getReportIdSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "reportAdvAsync", "param", "Lcom/tencent/mobileqq/vas/adv/qzone/data/VasAdMetaReportParam;", "requestAdvAsync", "Lcom/tencent/mobileqq/vas/adv/qzone/data/VasAdMetaParam;", "callback", "Lcom/tencent/mobileqq/vas/adv/qzone/callback/VasAdMetaCallback;", "vas-adv-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVasQZoneApi
  extends QRouteApi
{
  public abstract void addReportId(@NotNull String paramString);
  
  public abstract boolean containsReportId(@NotNull String paramString);
  
  @NotNull
  public abstract IAdVideoViewController createAdVideoViewController(@NotNull Context paramContext);
  
  @NotNull
  public abstract IAlbumRecommendAdvController createAlbumAdvViewController(@NotNull Context paramContext, @NotNull ViewGroup paramViewGroup);
  
  @NotNull
  public abstract HashSet<String> getReportIdSet();
  
  public abstract void reportAdvAsync(@NotNull VasAdMetaReportParam paramVasAdMetaReportParam);
  
  public abstract void requestAdvAsync(@NotNull VasAdMetaParam paramVasAdMetaParam, @NotNull VasAdMetaCallback paramVasAdMetaCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.qzone.api.IVasQZoneApi
 * JD-Core Version:    0.7.0.1
 */