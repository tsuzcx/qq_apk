package com.tencent.mobileqq.kandian.biz.feeds.api.impl;

import com.tencent.mobileqq.kandian.biz.atlas.ReadInjoyAtlasReportUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.feeds.api.IRIJChannelStayTimeMonitor;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.ForeBackGround;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.report.ReadInJoyGlobalReporter;
import com.tencent.mobileqq.kandian.repo.feeds.IForeBackGroundCallback;
import com.tencent.mobileqq.kandian.repo.feeds.SelectPositionModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PositionData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.xtab.badge.RIJXTabBadgeReporter;
import com.tencent.mobileqq.kandian.repo.xtab.badge.RIJXTabBadgeStore;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/api/impl/RIJChannelStayTimeMonitor;", "Lcom/tencent/mobileqq/kandian/biz/feeds/api/IRIJChannelStayTimeMonitor;", "()V", "CHANNEL_STAY_TIME", "", "REFRESH_TIME_LIMIT", "", "TAG", "channelEnterTimeMap", "", "", "getChannelEnterTimeMap", "()Ljava/util/Map;", "channelEnterTimeMap$delegate", "Lkotlin/Lazy;", "channelExitTimeMap", "getChannelExitTimeMap", "channelExitTimeMap$delegate", "currentChannel", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/TabChannelCoverInfo;", "currentChannelPos", "foreBackGroundCallback", "Lcom/tencent/mobileqq/kandian/repo/feeds/IForeBackGroundCallback;", "endMonitor", "", "enterChannel", "channelId", "exitChannel", "pos", "channelVersion", "isChannelShow", "", "isLastExitChannelOverTimeLimit", "onAccountChanged", "onChannelChanged", "tabChannelCoverInfo", "curPos", "setChannelCityForLocalChannel", "builder", "Lcom/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport$ReportR5Builder;", "startMonitor", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJChannelStayTimeMonitor
  implements IRIJChannelStayTimeMonitor
{
  private static final String CHANNEL_STAY_TIME = "0X8009733";
  public static final RIJChannelStayTimeMonitor INSTANCE = new RIJChannelStayTimeMonitor();
  private static final long REFRESH_TIME_LIMIT = ReadInJoyHelper.at(ReadInJoyUtils.b());
  private static final String TAG = "RIJChannelStayTimeMonitorImpl";
  private static final Lazy channelEnterTimeMap$delegate;
  private static final Lazy channelExitTimeMap$delegate;
  private static TabChannelCoverInfo currentChannel;
  private static int currentChannelPos = -1;
  private static final IForeBackGroundCallback foreBackGroundCallback = (IForeBackGroundCallback)new RIJChannelStayTimeMonitor.foreBackGroundCallback.1();
  
  static
  {
    channelEnterTimeMap$delegate = LazyKt.lazy((Function0)RIJChannelStayTimeMonitor.channelEnterTimeMap.2.INSTANCE);
    channelExitTimeMap$delegate = LazyKt.lazy((Function0)RIJChannelStayTimeMonitor.channelExitTimeMap.2.INSTANCE);
  }
  
  private final Map<Integer, Long> getChannelEnterTimeMap()
  {
    return (Map)channelEnterTimeMap$delegate.getValue();
  }
  
  private final Map<Integer, Long> getChannelExitTimeMap()
  {
    return (Map)channelExitTimeMap$delegate.getValue();
  }
  
  private final void setChannelCityForLocalChannel(RIJTransMergeKanDianReport.ReportR5Builder paramReportR5Builder, int paramInt)
  {
    if (paramInt != 41695) {
      return;
    }
    Object localObject = ReadInJoyLogicEngine.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyLogicEngine.getInstance()");
    localObject = ((ReadInJoyLogicEngine)localObject).j();
    if (localObject != null)
    {
      localObject = ((SelectPositionModule)localObject).b();
      if (localObject != null)
      {
        paramReportR5Builder.addChannelCity(((PositionData)localObject).city);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setChannelCityForLocalChannel CHANNEL_ID_LOCAL r5Str = ");
        ((StringBuilder)localObject).append(paramReportR5Builder.build());
        QLog.i("RIJChannelStayTimeMonitorImpl", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void endMonitor()
  {
    ReadinjoySPEventReport.ForeBackGround.b(foreBackGroundCallback);
    getChannelEnterTimeMap().clear();
    getChannelExitTimeMap().clear();
  }
  
  public void enterChannel(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enterChannel, channelID = ");
    localStringBuilder.append(paramInt);
    QLog.d("RIJChannelStayTimeMonitorImpl", 2, localStringBuilder.toString());
    if (paramInt == -1) {
      return;
    }
    getChannelEnterTimeMap().put(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()));
    ReadInJoyGlobalReporter.c(paramInt);
    RIJXTabBadgeReporter.a.a(true, paramInt, -1L, RIJXTabBadgeStore.b(paramInt));
  }
  
  public void exitChannel(int paramInt1, int paramInt2, @Nullable String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("exitChannel, channelID = ");
    ((StringBuilder)localObject).append(paramInt1);
    QLog.d("RIJChannelStayTimeMonitorImpl", 2, ((StringBuilder)localObject).toString());
    if (paramInt1 == -1) {
      return;
    }
    localObject = (Long)getChannelEnterTimeMap().remove(Integer.valueOf(paramInt1));
    if (localObject != null)
    {
      long l = ((Long)localObject).longValue();
      l = (System.currentTimeMillis() - l) / 1000;
      paramString = new RIJTransMergeKanDianReport.ReportR5Builder().addFolderStatus().addKandianModeNew().addChannelId(paramInt1).addLocation(paramInt2 + 1).addChannelVersion(paramString);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "r5Builder");
      setChannelCityForLocalChannel(paramString, paramInt1);
      getChannelExitTimeMap().put(Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis()));
      PublicAccountReportUtils.a(null, "", "0X8009733", "0X8009733", 0, 0, String.valueOf(l), "", "", paramString.build(), false);
      ReadInjoyAtlasReportUtils.a(paramInt1);
      RIJXTabBadgeReporter.a.a(false, paramInt1, l, RIJXTabBadgeStore.b(paramInt1));
    }
  }
  
  public boolean isChannelShow(int paramInt)
  {
    return getChannelEnterTimeMap().get(Integer.valueOf(paramInt)) != null;
  }
  
  public boolean isLastExitChannelOverTimeLimit(int paramInt)
  {
    Object localObject = (Long)getChannelExitTimeMap().get(Integer.valueOf(paramInt));
    boolean bool = true;
    if (localObject != null)
    {
      long l = ((Long)localObject).longValue();
      l = System.currentTimeMillis() - l;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refresh_time_limit = ");
      ((StringBuilder)localObject).append(REFRESH_TIME_LIMIT);
      ((StringBuilder)localObject).append(", channelId:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", channelExitTime:");
      ((StringBuilder)localObject).append(l);
      QLog.d("RIJChannelStayTimeMonitorImpl", 2, ((StringBuilder)localObject).toString());
      if (l > REFRESH_TIME_LIMIT) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public void onAccountChanged()
  {
    currentChannel = (TabChannelCoverInfo)null;
    getChannelEnterTimeMap().clear();
    getChannelExitTimeMap().clear();
  }
  
  public void onChannelChanged(@Nullable TabChannelCoverInfo paramTabChannelCoverInfo, int paramInt)
  {
    currentChannel = paramTabChannelCoverInfo;
    currentChannelPos = paramInt;
  }
  
  public void startMonitor()
  {
    ReadinjoySPEventReport.ForeBackGround.a(foreBackGroundCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.api.impl.RIJChannelStayTimeMonitor
 * JD-Core Version:    0.7.0.1
 */