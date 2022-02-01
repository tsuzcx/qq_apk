package com.tencent.timi.game.team.impl.operate;

import android.app.Activity;
import android.content.Context;
import com.tencent.timi.game.ui.widget.CommonDialog;
import com.tencent.timi.game.ui.widget.CommonDialog.Builder;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.IResultListener;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomJoinGameCmdRsp;

class TeamActionBtnView$1$1
  implements IResultListener<YoloRoomOuterClass.YoloRoomJoinGameCmdRsp>
{
  TeamActionBtnView$1$1(TeamActionBtnView.1 param1) {}
  
  public void a(int paramInt, String paramString)
  {
    if (!TeamActionBtnView.a(this.a.a, paramInt, paramString, "guest joinGame"))
    {
      Object localObject2 = null;
      int i = 1;
      Object localObject1;
      if (paramInt == 9200118)
      {
        paramString = "游戏队伍已经满员了，换个车队玩游戏吧";
        paramInt = i;
      }
      else if (paramInt == 9200120)
      {
        paramString = "游戏队伍已经开始游戏了，换个车队玩游戏吧";
        paramInt = i;
      }
      else if (paramInt == 9200121)
      {
        paramString = "由于王者队伍变更了游戏模式，暂时无法加入。我们为你推荐了其他车队噢!";
        paramInt = i;
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("加入游戏失败, ");
        ((StringBuilder)localObject1).append(paramString);
        CustomToastView.a(((StringBuilder)localObject1).toString());
        paramString = null;
        paramInt = 0;
      }
      if (paramInt != 0)
      {
        Context localContext = this.a.a.getContext();
        localObject1 = localObject2;
        if (localContext != null)
        {
          localObject1 = localObject2;
          if ((localContext instanceof Activity)) {
            localObject1 = (Activity)localContext;
          }
        }
        if ((localObject1 != null) && (!((Activity)localObject1).isFinishing()))
        {
          new CommonDialog.Builder((Context)localObject1).c(paramString).d("去看看").a(new TeamActionBtnView.1.1.2(this)).e("取消").b(new TeamActionBtnView.1.1.1(this)).a().show();
          return;
        }
        CustomToastView.a(paramString);
      }
    }
  }
  
  public void a(YoloRoomOuterClass.YoloRoomJoinGameCmdRsp paramYoloRoomJoinGameCmdRsp) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.operate.TeamActionBtnView.1.1
 * JD-Core Version:    0.7.0.1
 */