package com.tencent.mobileqq.kandian.biz.xtab.badge;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.account.api.IUserOperationModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.kandian.repo.tab.RIJXTabRedDotInfo;
import com.tencent.mobileqq.kandian.repo.xtab.api.IRIJXTabConfigHandler;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/xtab/badge/RIJXTabBadgeReporter;", "", "()V", "FADE_WAY", "", "FOLDER_STATUS", "REDDOT_TYPE", "RED_DOT_FADE_WAY_EXPIRED", "", "RED_DOT_FADE_WAY_USER_ACTION", "SP_KEY_GUIDE_BADGE_EXPOSURE_PREFIX", "TAG", "operationBitmapMap", "", "buildCommonParams", "Lcom/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport$ReportR5Builder;", "info", "Lcom/tencent/mobileqq/kandian/repo/tab/RIJXTabRedDotInfo;", "get80aXTabBadgeStatus", "getOperationBitmap", "channelId", "report64eRealTimeAction", "", "action", "report80aOnChannelChanged", "enter", "", "currentChannelId", "channelStayTime", "", "badgeInfo", "reportClick", "reportDismiss", "type", "reportExposure", "reportGuideBadgeClick", "reportGuideBadgeDismiss", "reportGuideBadgeExposure", "resetOperationBitmap", "set80aCommonParams", "attrs", "", "Ltencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList;", "set80aParamsOnEnterChannel", "set80aParamsOnExitChannel", "opBitmap", "setOperationBitmap", "operationBitFlag", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabBadgeReporter
{
  public static final RIJXTabBadgeReporter a;
  private static final Map<Integer, Integer> a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizXtabBadgeRIJXTabBadgeReporter = new RIJXTabBadgeReporter();
    jdField_a_of_type_JavaUtilMap = (Map)new HashMap();
  }
  
  private final int a(int paramInt)
  {
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if (localInteger != null) {
      return localInteger.intValue();
    }
    return 0;
  }
  
  @JvmStatic
  private static final RIJTransMergeKanDianReport.ReportR5Builder a(RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
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
  public static final void a(int paramInt)
  {
    Object localObject1 = RIJSPUtils.a(RIJQQAppInterfaceUtil.a(), true, false);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("kandian_guide_badge_exposure_");
    ((StringBuilder)localObject2).append(paramInt);
    localObject2 = ((StringBuilder)localObject2).toString();
    if (!((SharedPreferences)localObject1).getBoolean((String)localObject2, false))
    {
      RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder().addKandianModeNew().addChannelId(paramInt);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800BBE3", localReportR5Builder.build());
      localObject1 = ((SharedPreferences)localObject1).edit();
      ((SharedPreferences.Editor)localObject1).putBoolean((String)localObject2, true);
      ((SharedPreferences.Editor)localObject1).apply();
    }
  }
  
  private final void a(int paramInt, RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
  {
    Object localObject1 = (List)new ArrayList();
    try
    {
      Object localObject2 = new ReportInfo();
      ((ReportInfo)localObject2).mOperation = paramInt;
      ((ReportInfo)localObject2).mSourceArticleId = Long.parseLong(paramRIJXTabRedDotInfo.getArticleIds());
      ((ReportInfo)localObject2).mAlgorithmId = Integer.parseInt(paramRIJXTabRedDotInfo.getAlgorithmIds());
      ((ReportInfo)localObject2).mStrategyId = Integer.parseInt(paramRIJXTabRedDotInfo.getStrategyIds());
      ((ReportInfo)localObject2).mUin = RIJQQAppInterfaceUtil.a();
      ((ReportInfo)localObject2).mFolderStatus = Integer.parseInt(paramRIJXTabRedDotInfo.getFolderStatus());
      ((ReportInfo)localObject2).mChannelId = paramRIJXTabRedDotInfo.getChannelId();
      ((ReportInfo)localObject2).mOpSource = 19;
      ((List)localObject1).add(localObject2);
      localObject2 = QRoute.api(IUserOperationModule.class);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "QRoute.api(IUserOperationModule::class.java)");
      ((IUserOperationModule)localObject2).request0x64eKandianActionReport((List)localObject1, RIJKanDianFolderStatus.reportFolderStatus);
      return;
    }
    catch (Throwable localThrowable)
    {
      label138:
      break label138;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("report64eRealTimeAction failed--> action:");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(" info:");
    ((StringBuilder)localObject1).append(paramRIJXTabRedDotInfo);
    QLog.e("RIJXTabBadgeReporter", 2, ((StringBuilder)localObject1).toString());
  }
  
  @JvmStatic
  public static final void a(@NotNull RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJXTabRedDotInfo, "info");
    if (paramRIJXTabRedDotInfo.getExposureTime() != -1L) {
      return;
    }
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = a(paramRIJXTabRedDotInfo);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800B982", localReportR5Builder.build());
    jdField_a_of_type_ComTencentMobileqqKandianBizXtabBadgeRIJXTabBadgeReporter.a(20, paramRIJXTabRedDotInfo);
    RIJXTabBadgeStore.a.a(paramRIJXTabRedDotInfo.getChannelId());
  }
  
  @JvmStatic
  public static final void a(@NotNull RIJXTabRedDotInfo paramRIJXTabRedDotInfo, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJXTabRedDotInfo, "info");
    paramRIJXTabRedDotInfo = a(paramRIJXTabRedDotInfo).addInt("reddot_fade_way", paramInt);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800B984", paramRIJXTabRedDotInfo.build());
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
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder().addKandianModeNew().addChannelId(paramInt);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800BBE4", localReportR5Builder.build());
  }
  
  @JvmStatic
  public static final void b(@NotNull RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJXTabRedDotInfo, "info");
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = a(paramRIJXTabRedDotInfo);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800B983", localReportR5Builder.build());
    jdField_a_of_type_ComTencentMobileqqKandianBizXtabBadgeRIJXTabBadgeReporter.a(21, paramRIJXTabRedDotInfo);
  }
  
  @JvmStatic
  public static final void c(int paramInt)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder().addKandianModeNew().addChannelId(paramInt);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800BBE5", localReportR5Builder.build());
  }
  
  @NotNull
  public final String a()
  {
    if (!((IRIJXTabConfigHandler)QRoute.api(IRIJXTabConfigHandler.class)).isXTabMode()) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = ((Iterable)((IRIJXTabConfigHandler)QRoute.api(IRIJXTabConfigHandler.class)).getTabList()).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (TabChannelCoverInfo)localIterator.next();
      localStringBuilder.append(((TabChannelCoverInfo)localObject).mChannelCoverId);
      localStringBuilder.append(":");
      localObject = RIJXTabBadgeStore.a(((TabChannelCoverInfo)localObject).mChannelCoverId);
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
  
  public final void a()
  {
    jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
    int i;
    if (localInteger != null) {
      i = localInteger.intValue();
    } else {
      i = 0;
    }
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2 | i));
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
      a(localList, a(paramInt), paramLong);
    }
    ReadinjoyReportUtils.a(i, localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.badge.RIJXTabBadgeReporter
 * JD-Core Version:    0.7.0.1
 */