package com.tencent.timi.game.liveroom.impl.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView.StateChangedListener;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.datareport.api.ILiveReportService.DefaultImpls;
import com.tencent.timi.game.liveroom.impl.report.TGReportUtil;
import com.tencent.timi.game.router.ServiceCenter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/widget/AudienceInputBoxView;", "Lcom/tencent/timi/game/liveroom/impl/widget/AnchorInputBoxView;", "ctx", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "curRoomId", "", "forbidExpose", "", "getForbidExpose", "()Z", "setForbidExpose", "(Z)V", "bindForceExpose", "", "bindReport", "roomId", "extraInfo", "Lcom/tencent/timi/game/api/live/LiveRoomExtraInfo;", "setRoomId", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AudienceInputBoxView
  extends AnchorInputBoxView
{
  private boolean a;
  private long c;
  
  @JvmOverloads
  public AudienceInputBoxView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public AudienceInputBoxView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public AudienceInputBoxView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(long paramLong, @Nullable LiveRoomExtraInfo paramLiveRoomExtraInfo)
  {
    paramLiveRoomExtraInfo = TGReportUtil.a.a(paramLong, paramLiveRoomExtraInfo);
    ILiveReportService localILiveReportService = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
    if (paramLiveRoomExtraInfo != null)
    {
      localILiveReportService.a(this, "pg_qqlive_audience", (Map)paramLiveRoomExtraInfo);
      paramLiveRoomExtraInfo = getSendBtn();
      if (paramLiveRoomExtraInfo != null)
      {
        ILiveReportService.DefaultImpls.b((ILiveReportService)ServiceCenter.a(ILiveReportService.class), paramLiveRoomExtraInfo, false, "send", "em_qqlive_send_message", null, 18, null);
        VideoReport.setEventDynamicParams(paramLiveRoomExtraInfo, (IDynamicParams)new AudienceInputBoxView.bindReport..inlined.apply.lambda.1(this));
      }
      paramLiveRoomExtraInfo = getEmojiBtn();
      if (paramLiveRoomExtraInfo != null) {
        ILiveReportService.DefaultImpls.a((ILiveReportService)ServiceCenter.a(ILiveReportService.class), paramLiveRoomExtraInfo, false, null, "em_qqlive_emoji_entrance", MapsKt.mutableMapOf(new Pair[] { TuplesKt.to("zengzhi_moduleid", "em_qqlive_inputbar") }), 6, null);
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
  }
  
  public final boolean getForbidExpose()
  {
    return this.a;
  }
  
  public void k()
  {
    a((TimiBaseInputView.StateChangedListener)new AudienceInputBoxView.bindForceExpose.1(this));
  }
  
  public final void setForbidExpose(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public final void setRoomId(long paramLong)
  {
    this.c = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.widget.AudienceInputBoxView
 * JD-Core Version:    0.7.0.1
 */