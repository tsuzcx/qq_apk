package com.tencent.timi.game.expand.hall.api;

import android.view.View;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.datareport.api.IReportService.DefaultImpls;
import com.tencent.timi.game.room.api.GuildShequnParams;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.router.ServiceCenter;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/expand/hall/api/HallReportHelper;", "", "launchParam", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "(Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;)V", "getLaunchParam", "()Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "mReportParamMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "bindElementInfo", "", "view", "Landroid/view/View;", "elementId", "bindPageInfo", "getAuthAcceptEleId", "getAuthDenyEleId", "getAuthToGetSmobaInfoEleId", "getBindSmobaAccountEleId", "getBindSmobaDialogCancelEleId", "getBindSmobaDialogConfirmEleId", "getGotoCreateAccountEleId", "getGuildParams", "", "getGuildShequnParamsInfo", "Lcom/tencent/timi/game/room/api/GuildShequnParams;", "getInputBoxMicId", "getInputBoxSpeakerId", "getMicCardSeatEleId", "getMicCardUserHeadEleId", "getNoticeEleId", "getPageId", "getParams", "getRichParams", "getSettingEleId", "getSmobaAuthHintEleId", "getSmobaAuthViewCloseEleId", "getSwitchAccountConfirmEleId", "getSwitchAccountPanelCloseEleId", "setRoomId", "roomId", "", "setRoomType", "roomType", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class HallReportHelper
{
  private HashMap<String, String> a;
  @NotNull
  private final ExpandHallLaunchParam b;
  
  public HallReportHelper(@NotNull ExpandHallLaunchParam paramExpandHallLaunchParam)
  {
    this.b = paramExpandHallLaunchParam;
    this.a = new HashMap();
  }
  
  @NotNull
  public final String a()
  {
    if (this.b.a != 2) {
      return "pg_kl_smoba_cpdd";
    }
    return "pg_sgrp_smoba_cpdd";
  }
  
  public final void a(int paramInt)
  {
    ((Map)this.a).put("yes_room_type", String.valueOf(paramInt));
  }
  
  public final void a(long paramLong)
  {
    ((Map)this.a).put("yes_room_id", String.valueOf(paramLong));
  }
  
  public final void a(@NotNull View paramView, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramString, "elementId");
    IReportService.DefaultImpls.a((IReportService)ServiceCenter.a(IReportService.class), paramView, false, null, paramString, (Map)s(), 6, null);
  }
  
  public final void a(@NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "view");
    ((IReportService)ServiceCenter.a(IReportService.class)).a(paramObject, a());
  }
  
  @NotNull
  public final String b()
  {
    return "em_yes_notice";
  }
  
  @NotNull
  public final String c()
  {
    return "em_yes_config";
  }
  
  @NotNull
  public final String d()
  {
    return "em_yes_config_panel_rolebind";
  }
  
  @NotNull
  public final String e()
  {
    return "em_yes_config_panel_data_authorize";
  }
  
  @NotNull
  public final String f()
  {
    return "em_yes_data_authorize_win_cancel";
  }
  
  @NotNull
  public final String g()
  {
    return "em_yes_data_authorize_win_confirm";
  }
  
  @NotNull
  public final String h()
  {
    return "em_yes_data_authorize";
  }
  
  @NotNull
  public final String i()
  {
    return "em_yes_data_authorize_panel_close";
  }
  
  @NotNull
  public final String j()
  {
    return "em_yes_rolebind_win_confirm";
  }
  
  @NotNull
  public final String k()
  {
    return "em_yes_rolebind_win_cancel";
  }
  
  @NotNull
  public final String l()
  {
    return "em_yes_rolebind_win_gamelaunch";
  }
  
  @NotNull
  public final String m()
  {
    return "em_yes_rolebind_panel_close";
  }
  
  @NotNull
  public final String n()
  {
    return "em_yes_rolebind_panel_confirm";
  }
  
  @NotNull
  public final String o()
  {
    return "em_yes_mic_user_head";
  }
  
  @NotNull
  public final String p()
  {
    return "em_yes_mic_seat";
  }
  
  @NotNull
  public final String q()
  {
    return "em_yes_mic";
  }
  
  @NotNull
  public final String r()
  {
    return "em_yes_voice";
  }
  
  @NotNull
  public final HashMap<String, String> s()
  {
    HashMap localHashMap = new HashMap((Map)this.a);
    if (this.b.a == 2) {
      localHashMap.putAll(t());
    }
    return localHashMap;
  }
  
  @NotNull
  public final Map<String, String> t()
  {
    HashMap localHashMap = new HashMap();
    if (this.b.a == 2)
    {
      Map localMap = (Map)localHashMap;
      localMap.put("qq_group_num", String.valueOf(this.b.c));
      localMap.put("sgrp_channel_num", this.b.f.toString());
      localMap.put("sgrp_channel_name", this.b.d.toString());
    }
    return (Map)localHashMap;
  }
  
  @Nullable
  public final GuildShequnParams u()
  {
    Object localObject = (GuildShequnParams)null;
    if (this.b.a == 2)
    {
      localObject = this.b.f;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "launchParam.channelId");
      localObject = StringsKt.toLongOrNull((String)localObject);
      long l;
      if (localObject != null) {
        l = ((Long)localObject).longValue();
      } else {
        l = 0L;
      }
      localObject = new GuildShequnParams(this.b.c, l, this.b.d);
    }
    return localObject;
  }
  
  @NotNull
  public final Map<String, String> v()
  {
    Object localObject = (String)this.a.get("yes_room_id");
    if (localObject != null)
    {
      localObject = StringsKt.toLongOrNull((String)localObject);
      if (localObject != null)
      {
        long l = ((Long)localObject).longValue();
        localObject = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(l);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "data");
        l = ((IRoomGetDataService)localObject).f();
        localObject = new HashMap();
        ((HashMap)localObject).putAll((Map)this.a);
        Map localMap = (Map)localObject;
        localMap.put("yes_room_owner", String.valueOf(l));
        ((HashMap)localObject).putAll(t());
        return localMap;
      }
    }
    return (Map)this.a;
  }
  
  @NotNull
  public final ExpandHallLaunchParam w()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.api.HallReportHelper
 * JD-Core Version:    0.7.0.1
 */