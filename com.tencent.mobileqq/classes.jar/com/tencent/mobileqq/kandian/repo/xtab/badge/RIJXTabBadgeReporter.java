package com.tencent.mobileqq.kandian.repo.xtab.badge;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import com.tencent.mobileqq.kandian.repo.tab.RIJXTabRedDotInfo;
import com.tencent.mobileqq.kandian.repo.xtab.api.impl.RIJXTabConfigHandler;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/xtab/badge/RIJXTabBadgeReporter;", "", "()V", "FADE_WAY", "", "FOLDER_STATUS", "REDDOT_TYPE", "RED_DOT_FADE_WAY_EXPIRED", "", "RED_DOT_FADE_WAY_USER_ACTION", "SP_KEY_GUIDE_BADGE_EXPOSURE_PREFIX", "TAG", "operationBitmapMap", "", "buildCommonParams", "Lcom/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport$ReportR5Builder;", "info", "Lcom/tencent/mobileqq/kandian/repo/tab/RIJXTabRedDotInfo;", "get80aXTabBadgeStatus", "getOperationBitmap", "channelId", "report64eRealTimeAction", "", "action", "report80aOnChannelChanged", "enter", "", "currentChannelId", "channelStayTime", "", "badgeInfo", "reportClick", "reportDismiss", "type", "reportExposure", "reportGuideBadgeClick", "reportGuideBadgeDismiss", "reportGuideBadgeExposure", "resetOperationBitmap", "set80aCommonParams", "attrs", "", "Ltencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList;", "set80aParamsOnEnterChannel", "set80aParamsOnExitChannel", "opBitmap", "setOperationBitmap", "operationBitFlag", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabBadgeReporter
{
  public static final RIJXTabBadgeReporter a = new RIJXTabBadgeReporter();
  private static final Map<Integer, Integer> b = (Map)new HashMap();
  
  @JvmStatic
  public static final void a(int paramInt)
  {
    Object localObject1 = RIJSPUtils.a(RIJQQAppInterfaceUtil.e(), true, false);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("kandian_guide_badge_exposure_");
    ((StringBuilder)localObject2).append(paramInt);
    localObject2 = ((StringBuilder)localObject2).toString();
    if (!((SharedPreferences)localObject1).getBoolean((String)localObject2, false))
    {
      PublicAccountReportUtils.a("0X800BBE3", new RIJTransMergeKanDianReport.ReportR5Builder().addKandianModeNew().addChannelId(paramInt).build());
      localObject1 = ((SharedPreferences)localObject1).edit();
      ((SharedPreferences.Editor)localObject1).putBoolean((String)localObject2, true);
      ((SharedPreferences.Editor)localObject1).apply();
    }
  }
  
  private final void a(int paramInt, RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
  {
    Object localObject = (List)new ArrayList();
    try
    {
      ReportInfo localReportInfo = new ReportInfo();
      localReportInfo.mOperation = paramInt;
      localReportInfo.mSourceArticleId = Long.parseLong(paramRIJXTabRedDotInfo.getArticleIds());
      localReportInfo.mAlgorithmId = Integer.parseInt(paramRIJXTabRedDotInfo.getAlgorithmIds());
      localReportInfo.mStrategyId = Integer.parseInt(paramRIJXTabRedDotInfo.getStrategyIds());
      localReportInfo.mUin = RIJQQAppInterfaceUtil.c();
      localReportInfo.mFolderStatus = Integer.parseInt(paramRIJXTabRedDotInfo.getFolderStatus());
      localReportInfo.mChannelId = paramRIJXTabRedDotInfo.getChannelId();
      localReportInfo.mOpSource = 19;
      ((List)localObject).add(localReportInfo);
      UserOperationModule.getInstance().request0x64eKandianActionReport((List)localObject, ReadinjoyReportUtils.i());
      return;
    }
    catch (Throwable localThrowable)
    {
      label118:
      break label118;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("report64eRealTimeAction failed--> action:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" info:");
    ((StringBuilder)localObject).append(paramRIJXTabRedDotInfo);
    QLog.e("RIJXTabBadgeReporter", 2, ((StringBuilder)localObject).toString());
  }
  
  @JvmStatic
  public static final void a(@NotNull RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJXTabRedDotInfo, "info");
    if (paramRIJXTabRedDotInfo.getExposureTime() != -1L) {
      return;
    }
    PublicAccountReportUtils.a("0X800B982", c(paramRIJXTabRedDotInfo).build());
    a.a(20, paramRIJXTabRedDotInfo);
    RIJXTabBadgeStore.a.a(paramRIJXTabRedDotInfo.getChannelId());
  }
  
  @JvmStatic
  public static final void a(@NotNull RIJXTabRedDotInfo paramRIJXTabRedDotInfo, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJXTabRedDotInfo, "info");
    PublicAccountReportUtils.a("0X800B984", c(paramRIJXTabRedDotInfo).addInt("reddot_fade_way", paramInt).build());
  }
  
  private final void a(List<oidb_cmd0x80a.AttributeList> paramList, int paramInt, long paramLong)
  {
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(5);
    localAttributeList.att_name.set("Time");
    localAttributeList.att_value.set(String.valueOf(paramLong));
    paramList.add(localAttributeList);
    localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(6);
    localAttributeList.att_name.set("OperationBitmap");
    localAttributeList.att_value.set(String.valueOf(paramInt));
    paramList.add(localAttributeList);
  }
  
  private final void a(List<oidb_cmd0x80a.AttributeList> paramList, int paramInt, RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
  {
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(1);
    localAttributeList.att_name.set("channelID");
    localAttributeList.att_value.set(String.valueOf(paramInt));
    paramList.add(localAttributeList);
    if (paramRIJXTabRedDotInfo != null)
    {
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(2);
      localAttributeList.att_name.set("FolderStatus");
      PBStringField localPBStringField = localAttributeList.att_value;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramRIJXTabRedDotInfo.getFolderStatus());
      localStringBuilder.append("");
      localPBStringField.set(localStringBuilder.toString());
      paramList.add(localAttributeList);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(3);
      localAttributeList.att_name.set("StrategyID");
      localPBStringField = localAttributeList.att_value;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramRIJXTabRedDotInfo.getStrategyIds());
      localStringBuilder.append("");
      localPBStringField.set(localStringBuilder.toString());
      paramList.add(localAttributeList);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(4);
      localAttributeList.att_name.set("AlgorithmID");
      localPBStringField = localAttributeList.att_value;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramRIJXTabRedDotInfo.getAlgorithmIds());
      localStringBuilder.append("");
      localPBStringField.set(localStringBuilder.toString());
      paramList.add(localAttributeList);
    }
  }
  
  private final void a(List<oidb_cmd0x80a.AttributeList> paramList, RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
  {
    if (paramRIJXTabRedDotInfo != null)
    {
      long l = (NetConnInfoCenter.getServerTimeMillis() - paramRIJXTabRedDotInfo.getExposureTime()) / 1000;
      paramRIJXTabRedDotInfo = new oidb_cmd0x80a.AttributeList();
      paramRIJXTabRedDotInfo.att_id.set(5);
      paramRIJXTabRedDotInfo.att_name.set("costtime");
      paramRIJXTabRedDotInfo.att_value.set(String.valueOf(l));
      paramList.add(paramRIJXTabRedDotInfo);
    }
  }
  
  @JvmStatic
  public static final void b(int paramInt)
  {
    PublicAccountReportUtils.a("0X800BBE4", new RIJTransMergeKanDianReport.ReportR5Builder().addKandianModeNew().addChannelId(paramInt).build());
  }
  
  @JvmStatic
  public static final void b(@NotNull RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJXTabRedDotInfo, "info");
    PublicAccountReportUtils.a("0X800B983", c(paramRIJXTabRedDotInfo).build());
    a.a(21, paramRIJXTabRedDotInfo);
  }
  
  @JvmStatic
  private static final RIJTransMergeKanDianReport.ReportR5Builder c(RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder().addKandianModeNew().addChannelId(paramRIJXTabRedDotInfo.getChannelId()).addString("folder_status", paramRIJXTabRedDotInfo.getFolderStatus());
    if (paramRIJXTabRedDotInfo.getChannelId() == TabChannelCoverInfo.TYPE_CHANNEL_XTAB_FRIEND_CONFIG)
    {
      int i = RIJXTabBadgeShowLevel.a();
      if (i != 1)
      {
        if (i == 2) {
          localReportR5Builder.addInt("reddot_type", 2);
        }
      }
      else {
        localReportR5Builder.addInt("reddot_type", 1);
      }
    }
    Intrinsics.checkExpressionValueIsNotNull(localReportR5Builder, "builder");
    return localReportR5Builder;
  }
  
  @JvmStatic
  public static final void c(int paramInt)
  {
    PublicAccountReportUtils.a("0X800BBE5", new RIJTransMergeKanDianReport.ReportR5Builder().addKandianModeNew().addChannelId(paramInt).build());
  }
  
  private final int d(int paramInt)
  {
    Integer localInteger = (Integer)b.get(Integer.valueOf(paramInt));
    if (localInteger != null) {
      return localInteger.intValue();
    }
    return 0;
  }
  
  public final void a()
  {
    b.clear();
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    Integer localInteger = (Integer)b.get(Integer.valueOf(paramInt1));
    int i;
    if (localInteger != null) {
      i = localInteger.intValue();
    } else {
      i = 0;
    }
    b.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2 | i));
  }
  
  public final void a(boolean paramBoolean, int paramInt, long paramLong, @Nullable RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
  {
    int i;
    if (paramBoolean) {
      i = 42;
    } else {
      i = 43;
    }
    List localList = (List)new ArrayList();
    a(localList, paramInt, paramRIJXTabRedDotInfo);
    if (paramBoolean) {
      a(localList, paramRIJXTabRedDotInfo);
    } else {
      a(localList, d(paramInt), paramLong);
    }
    ReadinjoyReportUtils.a(i, localList);
  }
  
  @NotNull
  public final String b()
  {
    if (!RIJXTabConfigHandler.INSTANCE.isXTabMode()) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = ((Iterable)RIJXTabConfigHandler.INSTANCE.getTabList()).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (TabChannelCoverInfo)localIterator.next();
      localStringBuilder.append(((TabChannelCoverInfo)localObject).mChannelCoverId);
      localStringBuilder.append(":");
      localObject = RIJXTabBadgeStore.b(((TabChannelCoverInfo)localObject).mChannelCoverId);
      if (localObject != null)
      {
        if (((RIJXTabRedDotInfo)localObject).isBig()) {
          localObject = "2";
        } else {
          localObject = "1";
        }
      }
      else {
        localObject = "0";
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("_");
    }
    return StringsKt.removeSuffix((CharSequence)localStringBuilder, (CharSequence)"_").toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.xtab.badge.RIJXTabBadgeReporter
 * JD-Core Version:    0.7.0.1
 */