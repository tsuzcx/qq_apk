package com.tencent.timi.game.team.impl.operate;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomDoOpService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.widget.CommonDialog;
import com.tencent.timi.game.ui.widget.CommonDialog.Builder;
import com.tencent.timi.game.utils.NoDoubleClickUtils;

class TeamActionBtnView$3
  implements View.OnClickListener
{
  TeamActionBtnView$3(TeamActionBtnView paramTeamActionBtnView, boolean paramBoolean, int paramInt1, String paramString, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    if (!NoDoubleClickUtils.a()) {
      if (this.a)
      {
        ((IRoomService)ServiceCenter.a(IRoomService.class)).b(TeamActionBtnView.b(this.e)).b(new TeamActionBtnView.3.1(this));
      }
      else
      {
        String str;
        if (this.b == 2) {
          str = "五人排位模式";
        } else {
          str = this.c;
        }
        CommonDialog.Builder localBuilder = new CommonDialog.Builder(TimiGameActivityManager.a()).a("");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("需要满");
        localStringBuilder.append(this.d);
        localStringBuilder.append("人才能在王者内开局哦，当前人数不足是否要继续?");
        localBuilder.c(localStringBuilder.toString()).d("开始游戏").a(new TeamActionBtnView.3.3(this)).e("再等等").b(new TeamActionBtnView.3.2(this)).a(false).a().show();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.operate.TeamActionBtnView.3
 * JD-Core Version:    0.7.0.1
 */