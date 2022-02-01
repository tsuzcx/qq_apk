package com.tencent.mobileqq.kandian.glue.report;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.RIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.feeds.entity.RedPntInfoForReport;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.UserActionCollector;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.push.RIJLockScreenPushReport;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoyRefreshManager;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinManager;
import com.tencent.mobileqq.kandian.biz.skin.RefreshData;
import com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPagerController;
import com.tencent.mobileqq.kandian.biz.xtab.badge.RIJXTabBadgeShowLevel;
import com.tencent.mobileqq.kandian.biz.xtab.badge.RIJXTabBadgeStore;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.UserOptInfo;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.feeds.preload.FeedsPreloadManager;
import com.tencent.mobileqq.kandian.repo.reddot.KandianMsgBoxRedPntInfo;
import com.tencent.mobileqq.kandian.repo.xtab.api.IRIJXTabConfigHandler;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.math.BigInteger;
import kotlin.Pair;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class RIJKanDianTabReport
{
  public static int a;
  public static long a;
  
  private static int a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (paramRedTypeInfo == null) {
      return 1;
    }
    if (paramRedTypeInfo.red_type.get() == 5) {
      return 3;
    }
    return 2;
  }
  
  public static int a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        int i = new JSONObject(paramString).optInt("jumpType", 0);
        return i;
      }
      catch (JSONException paramString)
      {
        QLog.e("RIJKanDianTabReport", 1, "getReportLoadModeFromLockScreenMsg: ", paramString);
      }
    }
    return -1;
  }
  
  public static String a(String paramString)
  {
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = new BigInteger(paramString);
          QLog.d("RIJKanDianTabReport", 2, new Object[] { "convertArticleID bigInteger long value = ", Long.valueOf(paramString.longValue()) });
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(paramString.longValue());
          paramString = localStringBuilder.toString();
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        QLog.d("RIJKanDianTabReport", 1, new Object[] { "convertArticleID e = ", paramString.toString() });
        return "0";
      }
      paramString = "0";
    }
  }
  
  private static Pair<Integer, Long> a(int paramInt)
  {
    Integer localInteger = Integer.valueOf(0);
    if (paramInt == 1) {
      return new Pair(localInteger, Long.valueOf(0L));
    }
    if (RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.jdField_a_of_type_Long == 0L) {
      return new Pair(Integer.valueOf(1), Long.valueOf(NetConnInfoCenter.getServerTime() - RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.jdField_b_of_type_Long));
    }
    return new Pair(localInteger, Long.valueOf(NetConnInfoCenter.getServerTime() - RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.jdField_a_of_type_Long));
  }
  
  public static void a()
  {
    if (!RIJXTabFrameUtils.INSTANCE.isNowInKanDianTab()) {
      a(false);
    }
  }
  
  public static void a(int paramInt1, long paramLong, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    int i;
    if (((IRIJXTabConfigHandler)QRoute.api(IRIJXTabConfigHandler.class)).isXTabMode()) {
      i = 7;
    } else {
      i = 2;
    }
    if ((paramInt1 != 9) && (paramInt1 != 6))
    {
      if (paramInt1 == 13) {
        paramInt1 = 6;
      } else {
        paramInt1 = i;
      }
    }
    else {
      paramInt1 = 5;
    }
    ReadinjoyReportUtils.a(paramInt1, paramBoolean, paramLong, RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.jdField_a_of_type_Int, paramInt2, true, paramInt3);
  }
  
  public static void a(long paramLong)
  {
    if (paramLong > 0L) {
      ThreadManager.executeOnSubThread(new RIJKanDianTabReport.5(paramLong));
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.executeOnSubThread(new RIJKanDianTabReport.2(paramQQAppInterface));
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt, Intent paramIntent)
  {
    RIJKanDianFolderStatus.updateKandianFolderStatus(paramQQAppInterface);
    if (paramInt == 5)
    {
      try
      {
        a(paramQQAppInterface, false);
      }
      catch (JSONException paramIntent)
      {
        QLog.e("RIJKanDianTabReport", 1, paramIntent, new Object[0]);
      }
    }
    else if (paramInt == 6)
    {
      RIJLockScreenPushReport.a();
    }
    else if (paramInt == 13)
    {
      if (paramIntent != null) {
        paramIntent = paramIntent.getStringExtra("folder_status");
      } else {
        paramIntent = null;
      }
      if (!TextUtils.isEmpty(paramIntent)) {
        RIJKanDianFolderStatus.updateMergeKandianFolderStatus(Integer.parseInt(paramIntent));
      } else {
        RIJKanDianFolderStatus.updateMergeKandianFolderStatus(-1);
      }
    }
    paramIntent = (KandianMergeManager)paramQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    if (paramIntent != null)
    {
      paramIntent.d(false);
      paramIntent.h();
      QLog.d("RIJKanDianTabReport", 1, "[doReportForEnterTab] KandianMergeManager#setReaded");
    }
    ReadinjoyReportUtils.a(paramQQAppInterface, false);
    ReadinjoySPEventReport.a().a.a(true);
    paramIntent = RIJKanDianFolderStatus.getFolderStatus(0);
    if ((!TextUtils.equals("1", paramIntent)) && (!TextUtils.equals("0", paramIntent)))
    {
      if (paramInt == 13) {
        paramInt = UserActionCollector.f;
      } else {
        paramInt = UserActionCollector.e;
      }
    }
    else {
      paramInt = UserActionCollector.d;
    }
    UserActionCollector.a().a(paramInt, 1);
    long l = NetConnInfoCenter.getServerTimeMillis();
    paramInt = RIJAppSetting.a();
    int i = RIJKanDianFolderStatus.reportFolderStatus;
    ReadInJoyGlobalReporter.a().a(paramQQAppInterface, l, paramInt, i);
    ThreadManager.executeOnSubThread(new RIJKanDianTabReport.3(paramQQAppInterface, l, paramInt, i));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ReadInJoyBaseFragment paramReadInJoyBaseFragment)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ReadinjoyReportUtils.a(false);
    Object localObject = (ReadInJoySkinManager)paramQQAppInterface.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
    if ((((ReadInJoySkinManager)localObject).a() == 1) && (!TextUtils.isEmpty(((ReadInJoySkinManager)localObject).a()))) {
      localObject = ((ReadInJoySkinManager)localObject).a();
    } else {
      localObject = "0";
    }
    RefreshData localRefreshData = ReadInJoyRefreshManager.b(BaseApplicationImpl.getContext(), 0);
    int i = a(((KandianMergeManager)paramQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a());
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
    for (;;)
    {
      try
      {
        localObject = localReportR5Builder.addKandianMode().addKandianModeNew().addSkinId((String)localObject);
        if (i == 1) {
          break label245;
        }
        bool = true;
        localObject = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).addReddot(bool);
        if (jdField_a_of_type_Int != 0) {
          break label250;
        }
        bool = true;
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).addButtonState(bool);
        if (paramReadInJoyBaseFragment != null)
        {
          i = paramReadInJoyBaseFragment.b();
          localReportR5Builder.addChannelId(i);
          if (i == 0)
          {
            if ((localRefreshData == null) || (!localRefreshData.isAD)) {
              break label255;
            }
            i = 1;
            localReportR5Builder.addInt("ad_page", i);
          }
        }
      }
      catch (JSONException paramReadInJoyBaseFragment)
      {
        QLog.e("RIJKanDianTabReport", 1, paramReadInJoyBaseFragment, new Object[0]);
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(paramQQAppInterface, "CliOper", "", "", "0X80081C5", "0X80081C5", 0, 1, "1", null, null, localReportR5Builder.build(), false);
      return;
      label245:
      boolean bool = false;
      continue;
      label250:
      bool = false;
      continue;
      label255:
      i = 0;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (!RIJShowKanDianTabSp.c()) {
      return;
    }
    a(paramQQAppInterface);
    ThreadManager.executeOnSubThread(new RIJKanDianTabReport.1(paramRedTypeInfo, paramQQAppInterface));
  }
  
  public static void a(@Nullable QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void a(@Nullable QQAppInterface paramQQAppInterface, boolean paramBoolean, int paramInt, @Nullable Intent paramIntent)
  {
    if (paramQQAppInterface == null)
    {
      QLog.d("RIJKanDianTabReport", 1, "[doReportForTabChangeBeforeUI] app is null ");
      return;
    }
    if (paramBoolean)
    {
      a(paramQQAppInterface, paramInt, paramIntent);
      return;
    }
    UserActionCollector.a().c();
    ReadInJoyGlobalReporter.a().a();
    ThreadManager.executeOnSubThread(new RIJKanDianTabReport.4(paramQQAppInterface));
  }
  
  public static void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (paramTabChannelCoverInfo == null) {
      return;
    }
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
    localReportR5Builder.addChannelId(paramTabChannelCoverInfo.mChannelCoverId).addKandianModeNew().addFolderStatus();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate((QQAppInterface)ReadInJoyUtils.a(), "dc01160", "", "", "0X800B7A1", "0X800B7A1", 1, 1, "", "", "", localReportR5Builder.build(), false);
  }
  
  public static void a(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (RIJQQAppInterfaceUtil.a() != null)
        {
          if (!RIJShowKanDianTabSp.c()) {
            return;
          }
          Object localObject1 = (KandianMergeManager)RIJQQAppInterfaceUtil.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
          JSONObject localJSONObject = RIJTransMergeKanDianReport.a();
          if ((!((KandianMergeManager)localObject1).a()) && (!((KandianMergeManager)localObject1).i()))
          {
            i = 1;
          }
          else
          {
            if (((KandianMergeManager)localObject1).e() <= 0) {
              break label347;
            }
            i = 3;
          }
          if (i != 3) {
            break label352;
          }
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(((KandianMergeManager)localObject1).e());
          ((StringBuilder)localObject2).append("");
          localObject1 = ((StringBuilder)localObject2).toString();
          int j = i;
          localObject2 = localObject1;
          if (i != 3)
          {
            j = i;
            localObject2 = localObject1;
            if (RIJXTabBadgeStore.a(TabChannelCoverInfo.TYPE_CHANNEL_XTAB_FRIEND_CONFIG) != null)
            {
              j = i;
              localObject2 = localObject1;
              if (RIJXTabBadgeShowLevel.a() == 2)
              {
                localObject2 = "1";
                j = 3;
              }
            }
          }
          localJSONObject.put("tab_status", j);
          localJSONObject.put("kandian_mode_new", VideoReporter.a());
          if (j == 3) {
            localJSONObject.put("reddot_num", localObject2);
          }
          a(true, localJSONObject);
          i = jdField_a_of_type_Int;
          j = 0;
          if (i != 0) {
            break label358;
          }
          i = 0;
          localJSONObject.put("button_state", i);
          localJSONObject.put("os", 1);
          localJSONObject.put("version", VideoReporter.jdField_a_of_type_JavaLangString);
          i = j;
          if (RIJXTabFrameUtils.INSTANCE.isNowInKanDianTab()) {
            i = 1;
          }
          localJSONObject.put("isInKandian", i);
          RIJMsgReport.a.a(localJSONObject);
          if (ReadInJoyChannelViewPagerController.a != null) {
            localJSONObject.put("channel_id", ReadInJoyChannelViewPagerController.a.mChannelCoverId);
          }
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", null, "0X80081C3", "0X80081C3", 0, 1, null, a(RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.c), RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.jdField_b_of_type_JavaLangString, localJSONObject.toString(), false);
        }
        else
        {
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      label347:
      int i = 2;
      continue;
      label352:
      String str = "0";
      continue;
      label358:
      i = 1;
    }
  }
  
  public static void a(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject1 = (QQAppInterface)RIJQQAppInterfaceUtil.a();
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = ((QQAppInterface)localObject1).getMessageFacade();
    localObject1 = null;
    if (localObject2 != null)
    {
      Object localObject3 = ((QQMessageFacade)localObject2).b(AppConstants.KANDIAN_MERGE_UIN, 7220);
      if (localObject3 == null) {
        return;
      }
      if ((localObject3 instanceof MessageForStructing))
      {
        localObject2 = (MessageForStructing)localObject3;
        localObject1 = localObject2;
        if (((MessageForStructing)localObject2).structingMsg == null)
        {
          ((MessageForStructing)localObject2).parse();
          localObject1 = localObject2;
        }
      }
      if ((paramBoolean ^ true | ((MessageRecord)localObject3).isread ^ true))
      {
        localObject2 = ((MessageRecord)localObject3).senderuin;
        try
        {
          localObject3 = new JSONObject(((MessageRecord)localObject3).extStr);
          if (((JSONObject)localObject3).has("kdUin")) {
            localObject2 = ((JSONObject)localObject3).getString("kdUin");
          }
          paramJSONObject.put("feeds_source", localObject2);
          if ((localObject1 != null) && (((MessageForStructing)localObject1).structingMsg != null))
          {
            paramJSONObject.put("load_mode", a(((MessageForStructing)localObject1).structingMsg.mExtraData));
            paramJSONObject.put("push_type", b(((MessageForStructing)localObject1).structingMsg.mExtraData));
            return;
          }
        }
        catch (Exception paramJSONObject)
        {
          paramJSONObject.printStackTrace();
        }
      }
    }
  }
  
  public static int b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        int i = new JSONObject(paramString).optInt("contentType", 0);
        return i;
      }
      catch (JSONException paramString)
      {
        QLog.e("RIJKanDianTabReport", 1, "getReportPushTypeFromeLockScreenMsg: ", paramString);
      }
    }
    return -1;
  }
  
  private static void b(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (paramRedTypeInfo != null) {
      try
      {
        paramRedTypeInfo = RIJTransMergeKanDianReport.a();
        paramRedTypeInfo.put("kandian_mode", RIJAppSetting.a());
        paramRedTypeInfo.put("tab_source", RIJTransMergeKanDianReport.a());
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", null, "0X80081C6", "0X80081C6", 0, 1, null, null, null, paramRedTypeInfo.toString(), false);
        return;
      }
      catch (Exception paramRedTypeInfo)
      {
        paramRedTypeInfo.printStackTrace();
      }
    }
  }
  
  private static void b(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, QQAppInterface paramQQAppInterface)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("folder_status", RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.jdField_a_of_type_Int);
        localJSONObject.put("algorithm_id", RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.jdField_a_of_type_JavaLangString);
        localJSONObject.put("strategy_id", RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.jdField_b_of_type_JavaLangString);
        localJSONObject.put("time", System.currentTimeMillis());
        if (RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.jdField_a_of_type_Int == 6)
        {
          localJSONObject.put("id", paramString1);
          localJSONObject.put("social_uin", paramString2);
        }
        boolean bool = RIJTransMergeKanDianReport.a();
        int j = 0;
        if (bool)
        {
          i = 1;
          localJSONObject.put("message_status", i);
          i = j;
          if (ReadInJoyHelper.x(BaseApplicationImpl.getApplication().getRuntime()) == 1) {
            i = 1;
          }
          localJSONObject.put("reddot_style", i);
          localJSONObject.put("tab_status", paramInt);
          localJSONObject.put("kandian_mode_new", VideoReporter.a());
          if (paramInt == 3) {
            localJSONObject.put("reddot_num", paramString3);
          }
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", paramString4, "0X80091DC", "0X80091DC", 0, 0, "0", a(RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.c), RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.jdField_b_of_type_JavaLangString, localJSONObject.toString(), false);
          if (ReadInJoyHelper.m()) {
            RIJFrameworkReportManager.a(20, a(RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.c), RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.jdField_b_of_type_JavaLangString, RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.jdField_a_of_type_JavaLangString, paramString4, RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.jdField_a_of_type_Int);
          }
          ((KandianMergeManager)paramQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).b();
          if (RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.jdField_a_of_type_Int == 6)
          {
            QLog.d("RIJKanDianTabReport", 1, "feedsPreload, social num red point, do not preload.");
            return;
          }
          QLog.d("RIJKanDianTabReport", 1, "feedsPreload, small red point exposed.");
          FeedsPreloadManager.a().a(true);
          return;
        }
      }
      catch (JSONException paramString1)
      {
        QLog.d("RIJKanDianTabReport", 1, "red point expose, e = ", paramString1);
        return;
      }
      int i = 0;
    }
  }
  
  private static boolean b()
  {
    if (RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.jdField_a_of_type_Int == 1) {
      return true;
    }
    RIJKanDianFolderStatus.updateReportSessionId(String.valueOf(System.currentTimeMillis()));
    jdField_a_of_type_Long = System.currentTimeMillis() / 1000L;
    return false;
  }
  
  private static String d(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.extInt == 5)
    {
      paramQQAppInterface = ((KandianMergeManager)paramQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a();
      if (paramQQAppInterface != null) {
        return String.valueOf(paramQQAppInterface.mMsgType);
      }
    }
    return "";
  }
  
  private static String e(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.extInt == 5)
    {
      paramQQAppInterface = ((KandianMergeManager)paramQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a();
      if (paramQQAppInterface != null) {
        return String.valueOf(paramQQAppInterface.mUin);
      }
    }
    return "";
  }
  
  private static String f(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    String str3 = "";
    paramMessageRecord.extLong ^= 0x1;
    String str1 = str3;
    String str2;
    try
    {
      if (!TextUtils.isEmpty(paramMessageRecord.extStr))
      {
        str1 = str3;
        localObject = new JSONObject(paramMessageRecord.extStr);
      }
      else
      {
        str1 = str3;
        localObject = new JSONObject();
      }
      str1 = str3;
      ((JSONObject)localObject).put("sp_last_kadnian_red_pnt_exposure_time_key", NetConnInfoCenter.getServerTime());
      str1 = str3;
      paramMessageRecord.extStr = ((JSONObject)localObject).toString();
      str1 = str3;
      str3 = paramMessageRecord.senderuin;
      str1 = str3;
      JSONObject localJSONObject = new JSONObject(paramMessageRecord.extStr);
      str1 = str3;
      Object localObject = str3;
      if (localJSONObject.has("kdUin"))
      {
        str1 = str3;
        localObject = localJSONObject.getString("kdUin");
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      str2 = str1;
    }
    paramQQAppInterface.getMessageFacade().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, "extLong", Integer.valueOf(paramMessageRecord.extLong));
    paramQQAppInterface.getMessageFacade().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, "extStr", paramMessageRecord.extStr);
    RIJKanDianFolderStatus.updateKandianFolderStatus(paramQQAppInterface, paramMessageRecord);
    return str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.RIJKanDianTabReport
 * JD-Core Version:    0.7.0.1
 */