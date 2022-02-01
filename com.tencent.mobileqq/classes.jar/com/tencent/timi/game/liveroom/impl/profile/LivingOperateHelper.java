package com.tencent.timi.game.liveroom.impl.profile;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.supervision.IQQLiveBanChat;
import com.tencent.mobileqq.qqlive.api.supervision.IQQLiveModuleKickOut;
import com.tencent.mobileqq.qqlive.api.supervision.IQQLiveModuleReport;
import com.tencent.mobileqq.qqlive.callback.supervision.KickOutUserCallback;
import com.tencent.mobileqq.qqlive.callback.supervision.ReportCallback;
import com.tencent.mobileqq.qqlive.callback.supervision.SetBanChatCallback;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.component.qqlive.api.TgLiveAnchorUserInfo;
import com.tencent.timi.game.liveroom.impl.inscription.LivingInscriptionReportHelper;
import com.tencent.timi.game.liveroom.impl.inscription.LivingInscriptionReportHelper.Companion;
import com.tencent.timi.game.liveroom.impl.profile.operate.ProfileOperateDialog.ItemClickListener;
import com.tencent.timi.game.liveroom.impl.report.TGReportAudienceParamsManager;
import com.tencent.timi.game.liveroom.impl.report.TGReportAudienceParamsManager.Companion;
import com.tencent.timi.game.liveroom.impl.report.TGReportUtil;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.SystemUiFlagUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/profile/LivingOperateHelper;", "", "()V", "TAG", "", "acquireAuchorUid", "", "roomId", "acquireMyUid", "addToBlackList", "", "anchorUid", "targetUserUid", "reasonId", "", "targetUserName", "createReportParam", "Lcom/tencent/timi/game/liveroom/impl/profile/LivingProfileReportInfo;", "liveUserInfo", "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "reportSource", "context", "Landroid/content/Context;", "doReport", "reporterUid", "reporteeUid", "reason", "forbiddenSpeech", "isAnchor", "", "anchorId", "isAnchorSelf", "isOpenAnchorProfile", "openAnchorProfileDialog", "blurBlackgroundView", "Landroid/view/View;", "reprotInfo", "openAudienceProfileDialog", "openAudienceProfileDialogByAnchor", "openProfileDialog", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LivingOperateHelper
{
  public static final LivingOperateHelper a = new LivingOperateHelper();
  private static final String b = "LivingOperateHelper";
  
  private final LivingProfileReportInfo a(LiveUserInfo paramLiveUserInfo, long paramLong, int paramInt, Context paramContext)
  {
    Map localMap = (Map)new LinkedHashMap();
    localMap.put("qqlive_inf_module_user_id", String.valueOf(paramLiveUserInfo.uid));
    localMap.put("qqlive_inf_module_source", String.valueOf(paramInt));
    String str2 = LivingInscriptionReportHelper.a.a().a(paramLong);
    boolean bool = b(paramLong);
    String str1 = "1";
    if (bool)
    {
      if (!a(paramLong, paramLiveUserInfo)) {
        str1 = "0";
      }
      localMap.put("qqlive_is_archor_inf_module", str1);
      return new LivingProfileReportInfo("pg_qqlive_anchorlive", "em_qqlive_inf_module", localMap, str2, (Map)TGReportUtil.a.a());
    }
    if (a(paramLong, paramLiveUserInfo)) {
      paramLiveUserInfo = "1";
    } else {
      paramLiveUserInfo = "0";
    }
    localMap.put("qqlive_is_archor_inf_module", paramLiveUserInfo);
    if (!SystemUiFlagUtil.a(paramContext.getResources())) {
      str1 = "0";
    }
    localMap.put("qqlive_screen_orientation", str1);
    return new LivingProfileReportInfo("pg_qqlive_audience", "em_qqlive_inf_module", localMap, str2, TGReportAudienceParamsManager.a.a().a());
  }
  
  private final void a(long paramLong1, long paramLong2, long paramLong3, int paramInt, String paramString)
  {
    Object localObject = ServiceCenter.a(ITgLiveRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…eRoomService::class.java)");
    localObject = ((ITgLiveRoomService)localObject).d();
    if (localObject != null) {
      localObject = ((IQQLiveSDK)localObject).getBanChatModule();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((IQQLiveBanChat)localObject).banChat(paramLong1, paramLong2, paramLong3, paramInt, (SetBanChatCallback)new LivingOperateHelper.forbiddenSpeech.1(paramString));
    }
  }
  
  private final void a(long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2)
  {
    paramString2 = ServiceCenter.a(ITgLiveRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(paramString2, "ServiceCenter.getService…eRoomService::class.java)");
    paramString2 = ((ITgLiveRoomService)paramString2).d();
    if (paramString2 != null) {
      paramString2 = paramString2.getReportModule();
    } else {
      paramString2 = null;
    }
    if (paramString2 != null) {
      paramString2.report(paramLong1, paramLong2, paramLong3, paramString1, (ReportCallback)new LivingOperateHelper.doReport.1());
    }
  }
  
  private final void a(View paramView, Context paramContext, LiveUserInfo paramLiveUserInfo, long paramLong, LivingProfileReportInfo paramLivingProfileReportInfo)
  {
    paramView = new LivingAnchorProfileDialog(paramLiveUserInfo, paramContext, paramView, paramLong, paramLivingProfileReportInfo);
    paramView.a((ProfileOperateDialog.ItemClickListener)new LivingOperateHelper.openAnchorProfileDialog.operateListener.1(paramLong, paramLiveUserInfo));
    paramView.show();
  }
  
  private final boolean a(long paramLong, LiveUserInfo paramLiveUserInfo)
  {
    return c(paramLong) == paramLiveUserInfo.uid;
  }
  
  private final void b(long paramLong1, long paramLong2, long paramLong3, int paramInt, String paramString)
  {
    Object localObject = ServiceCenter.a(ITgLiveRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…eRoomService::class.java)");
    localObject = ((ITgLiveRoomService)localObject).d();
    if (localObject != null) {
      localObject = ((IQQLiveSDK)localObject).getKickOutModule();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((IQQLiveModuleKickOut)localObject).kickOutUser(paramLong1, paramLong2, paramLong3, paramInt, (KickOutUserCallback)new LivingOperateHelper.addToBlackList.1(paramString));
    }
  }
  
  private final void b(View paramView, Context paramContext, LiveUserInfo paramLiveUserInfo, long paramLong, LivingProfileReportInfo paramLivingProfileReportInfo)
  {
    paramView = new LivingAudienceProfileDialog(paramContext, false, paramLiveUserInfo, paramView, paramLong, paramLivingProfileReportInfo);
    paramView.a((ProfileOperateDialog.ItemClickListener)new LivingOperateHelper.openAudienceProfileDialog.operateListener.1(paramLong, paramLiveUserInfo));
    paramView.show();
  }
  
  private final boolean b(long paramLong)
  {
    return c(paramLong) == a();
  }
  
  private final long c(long paramLong)
  {
    Object localObject = (ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class);
    if (localObject != null)
    {
      localObject = ((ITgLiveRoomService)localObject).i(paramLong);
      if (localObject != null) {
        return ((TgLiveAnchorUserInfo)localObject).getAnchorUid();
      }
    }
    return 0L;
  }
  
  private final void c(View paramView, Context paramContext, LiveUserInfo paramLiveUserInfo, long paramLong, LivingProfileReportInfo paramLivingProfileReportInfo)
  {
    paramView = new LivingAudienceProfileDialog(paramContext, true, paramLiveUserInfo, paramView, paramLong, paramLivingProfileReportInfo);
    paramView.a((ProfileOperateDialog.ItemClickListener)new LivingOperateHelper.openAudienceProfileDialogByAnchor.operateListener.1(paramLong, c(paramLong), paramLiveUserInfo));
    paramView.show();
  }
  
  public final long a()
  {
    Object localObject = (ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class);
    if (localObject != null)
    {
      localObject = ((ITgLiveRoomService)localObject).f();
      if (localObject != null) {
        return ((LiveUserInfo)localObject).uid;
      }
    }
    return 0L;
  }
  
  public final void a(@Nullable View paramView, @NotNull Context paramContext, long paramLong, @NotNull LiveUserInfo paramLiveUserInfo, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramLiveUserInfo, "liveUserInfo");
    LivingProfileReportInfo localLivingProfileReportInfo = a(paramLiveUserInfo, paramLong, paramInt, paramContext);
    if (b(paramLong))
    {
      c(paramView, paramContext, paramLiveUserInfo, paramLong, localLivingProfileReportInfo);
      return;
    }
    if (a(paramLong, paramLiveUserInfo))
    {
      a(paramView, paramContext, paramLiveUserInfo, paramLong, localLivingProfileReportInfo);
      return;
    }
    b(paramView, paramContext, paramLiveUserInfo, paramLong, localLivingProfileReportInfo);
  }
  
  public final boolean a(long paramLong)
  {
    return paramLong == a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.profile.LivingOperateHelper
 * JD-Core Version:    0.7.0.1
 */