package com.tencent.timi.game.component.chat.message;

import android.view.View;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.room.api.IRoomCommonConf;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.team.impl.main.TeamUtil;
import com.tencent.timi.game.ui.NoUnderlineClickSpan;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/component/chat/message/TextMessageItemView$handleHelperMsg$1$1", "Lcom/tencent/timi/game/ui/NoUnderlineClickSpan;", "onClick", "", "widget", "Landroid/view/View;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TextMessageItemView$handleHelperMsg$$inlined$apply$lambda$1
  extends NoUnderlineClickSpan
{
  TextMessageItemView$handleHelperMsg$$inlined$apply$lambda$1(TextMessageItemView paramTextMessageItemView) {}
  
  public void onClick(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "widget");
    Object localObject = ServiceCenter.a(IRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService(IRoomService::class.java)");
    if (!NoDoubleClickUtils.b("handleShareClick", ((IRoomService)localObject).c().b() * 1000L))
    {
      localObject = (IReportService)ServiceCenter.a(IReportService.class);
      paramView = (Object)paramView;
      ConcurrentHashMap localConcurrentHashMap = TeamUtil.a(TextMessageItemView.a(this.a));
      Intrinsics.checkExpressionValueIsNotNull(localConcurrentHashMap, "TeamUtil.getCommonRoomInfoReportParam(roomId)");
      ((IReportService)localObject).a("clck", paramView, (Map)localConcurrentHashMap);
      TextMessageItemView.Companion.a(TextMessageItemView.a);
      return;
    }
    CustomToastView.a("说话太快了，休息一下吧");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.TextMessageItemView.handleHelperMsg..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */