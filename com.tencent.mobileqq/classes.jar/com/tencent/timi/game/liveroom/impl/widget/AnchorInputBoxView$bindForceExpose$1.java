package com.tencent.timi.game.liveroom.impl.widget;

import android.view.View;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView.StateChangedListener;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.router.ServiceCenter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.MessageOuterClass.MsgContent;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/widget/AnchorInputBoxView$bindForceExpose$1", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView$StateChangedListener;", "onAt", "", "text", "", "content", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "timiBaseInputView", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView;", "onStateChanged", "state", "", "onText", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorInputBoxView$bindForceExpose$1
  implements TimiBaseInputView.StateChangedListener
{
  public void a(int paramInt)
  {
    ILiveReportService localILiveReportService;
    View localView;
    if ((this.a.getPreState() != 1) && (paramInt == 1))
    {
      localILiveReportService = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
      localView = AnchorInputBoxView.e(this.a);
      if (localView != null)
      {
        localILiveReportService.a("imp_end", (Object)localView, (Map)new LinkedHashMap());
        localILiveReportService = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
        localView = AnchorInputBoxView.g(this.a);
        if (localView != null)
        {
          localILiveReportService.a("imp_end", (Object)localView, (Map)new LinkedHashMap());
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
    }
    if ((this.a.getPreState() == 1) && (paramInt != 1))
    {
      localILiveReportService = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
      localView = AnchorInputBoxView.e(this.a);
      if (localView != null)
      {
        localILiveReportService.a("imp", (Object)localView, (Map)new LinkedHashMap());
        localILiveReportService = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
        localView = AnchorInputBoxView.g(this.a);
        if (localView != null)
        {
          localILiveReportService.a("imp", (Object)localView, (Map)new LinkedHashMap());
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
    }
  }
  
  public void a(@NotNull String paramString, @NotNull TimiBaseInputView paramTimiBaseInputView)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    Intrinsics.checkParameterIsNotNull(paramTimiBaseInputView, "timiBaseInputView");
  }
  
  public void a(@NotNull String paramString, @NotNull MessageOuterClass.MsgContent paramMsgContent, @NotNull TimiBaseInputView paramTimiBaseInputView)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    Intrinsics.checkParameterIsNotNull(paramMsgContent, "content");
    Intrinsics.checkParameterIsNotNull(paramTimiBaseInputView, "timiBaseInputView");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.widget.AnchorInputBoxView.bindForceExpose.1
 * JD-Core Version:    0.7.0.1
 */