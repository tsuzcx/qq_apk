package com.tencent.timi.game.gift.impl.timi;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityForTool;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/gift/impl/timi/TimiGiftPanelFragment$Companion;", "", "()V", "EXT_APP_ID", "", "EXT_BUS_ID", "EXT_GAME_ID", "EXT_GAME_TYPE", "EXT_PROGRAMME_ID", "EXT_RECEIVER_HEAD", "EXT_RECEIVER_NICK", "EXT_RECEIVER_UIN", "EXT_ROOM_ID", "EXT_SENDER_HEAD", "EXT_SENDER_NICK", "EXT_SENDER_UIN", "EXT_SOURCE", "EXT_TRACE_DETAIL", "REQUEST_CODE", "", "TAG", "start", "", "ctx", "Landroid/content/Context;", "busId", "roomId", "", "senderUin", "senderNick", "senderHead", "receiverUin", "receiverNick", "receiverHead", "source", "gameType", "programmeId", "appId", "traceDetail", "gameId", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiGiftPanelFragment$Companion
{
  public final void a(@NotNull Context paramContext, int paramInt, long paramLong1, long paramLong2, @NotNull String paramString1, @NotNull String paramString2, long paramLong3, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @NotNull String paramString6, @NotNull String paramString7, @NotNull String paramString8, @Nullable String paramString9, @NotNull String paramString10)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "ctx");
    Intrinsics.checkParameterIsNotNull(paramString1, "senderNick");
    Intrinsics.checkParameterIsNotNull(paramString2, "senderHead");
    Intrinsics.checkParameterIsNotNull(paramString3, "receiverNick");
    Intrinsics.checkParameterIsNotNull(paramString4, "receiverHead");
    Intrinsics.checkParameterIsNotNull(paramString5, "source");
    Intrinsics.checkParameterIsNotNull(paramString6, "gameType");
    Intrinsics.checkParameterIsNotNull(paramString7, "programmeId");
    Intrinsics.checkParameterIsNotNull(paramString8, "appId");
    Intrinsics.checkParameterIsNotNull(paramString10, "gameId");
    Intent localIntent = new Intent();
    localIntent.putExtra("extra_business_id", paramInt);
    localIntent.putExtra("extra_room_id", paramLong1);
    localIntent.putExtra("extra_sender_uin", paramLong2);
    localIntent.putExtra("extra_sender_nick", paramString1);
    localIntent.putExtra("extra_sender_head", paramString2);
    localIntent.putExtra("extra_receiver_uin", paramLong3);
    localIntent.putExtra("extra_receiver_nick", paramString3);
    localIntent.putExtra("extra_receiver_head", paramString4);
    localIntent.putExtra("extra_source", paramString5);
    localIntent.putExtra("extra_game_type", paramString6);
    localIntent.putExtra("extra_programme_id", paramString7);
    localIntent.putExtra("extra_app_id", paramString8);
    localIntent.putExtra("extra_trace_detail", paramString9);
    localIntent.putExtra("extra_game_id", paramString10);
    paramInt = 1;
    localIntent.putExtra("public_fragment_window_feature", 1);
    if (MobileQQ.sProcessId != 7) {
      paramInt = 0;
    }
    if (paramInt != 0) {
      paramString1 = QPublicTransFragmentActivityForTool.class;
    } else {
      paramString1 = QPublicTransFragmentActivity.class;
    }
    QPublicFragmentActivity.Launcher.a(paramContext, localIntent, paramString1, TimiGiftPanelFragment.class, 4369);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.timi.TimiGiftPanelFragment.Companion
 * JD-Core Version:    0.7.0.1
 */