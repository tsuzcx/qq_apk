package com.tencent.mobileqq.kandian.biz.feeds.channelbanner;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelBannerInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/channelbanner/RIJChannelBannerReport;", "", "()V", "avatarCardClickMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/kandian/biz/feeds/channelbanner/RIJChannelBannerReport$R5Builder;", "Lkotlin/collections/HashMap;", "getAvatarCardClickMap", "()Ljava/util/HashMap;", "avatarCardExposureMap", "getAvatarCardExposureMap", "avatarItemClickMap", "getAvatarItemClickMap", "avatarItemExposureMap", "getAvatarItemExposureMap", "getBaseR5Builder", "channelBannerInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/ChannelBannerInfo;", "reportAllData", "", "reportDataImp", "actionName", "r5Builder", "Companion", "R5Builder", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJChannelBannerReport
{
  public static final RIJChannelBannerReport.Companion a;
  @NotNull
  private final HashMap<String, RIJChannelBannerReport.R5Builder> a;
  @NotNull
  private final HashMap<String, RIJChannelBannerReport.R5Builder> b = new HashMap();
  @NotNull
  private final HashMap<String, RIJChannelBannerReport.R5Builder> c = new HashMap();
  @NotNull
  private final HashMap<String, RIJChannelBannerReport.R5Builder> d = new HashMap();
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerReport$Companion = new RIJChannelBannerReport.Companion(null);
  }
  
  public RIJChannelBannerReport()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private final void a(String paramString, RIJChannelBannerReport.R5Builder paramR5Builder)
  {
    paramR5Builder = paramR5Builder.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[reportDataImp], actionName = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", r5 = ");
    localStringBuilder.append(paramR5Builder);
    QLog.i("RIJChannelBannerReport", 1, localStringBuilder.toString());
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramString, paramString, 0, 0, "", "", "", paramR5Builder, false);
  }
  
  @NotNull
  public final RIJChannelBannerReport.R5Builder a(@NotNull ChannelBannerInfo paramChannelBannerInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramChannelBannerInfo, "channelBannerInfo");
    return new RIJChannelBannerReport.R5Builder().a("channel_id", String.valueOf(paramChannelBannerInfo.a())).a(paramChannelBannerInfo.d());
  }
  
  @NotNull
  public final HashMap<String, RIJChannelBannerReport.R5Builder> a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public final void a()
  {
    Map localMap1 = MapsKt.toMutableMap((Map)this.jdField_a_of_type_JavaUtilHashMap);
    Map localMap2 = MapsKt.toMutableMap((Map)this.b);
    Map localMap3 = MapsKt.toMutableMap((Map)this.c);
    Map localMap4 = MapsKt.toMutableMap((Map)this.d);
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.b.clear();
    this.c.clear();
    this.d.clear();
    ThreadManager.executeOnSubThread((Runnable)new RIJChannelBannerReport.reportAllData.1(this, localMap1, localMap2, localMap3, localMap4));
  }
  
  @NotNull
  public final HashMap<String, RIJChannelBannerReport.R5Builder> b()
  {
    return this.b;
  }
  
  @NotNull
  public final HashMap<String, RIJChannelBannerReport.R5Builder> c()
  {
    return this.c;
  }
  
  @NotNull
  public final HashMap<String, RIJChannelBannerReport.R5Builder> d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.channelbanner.RIJChannelBannerReport
 * JD-Core Version:    0.7.0.1
 */