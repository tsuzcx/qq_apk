package com.tencent.timi.game.room.impl.util;

import com.tencent.timi.game.float_window.IFloatView;
import com.tencent.timi.game.float_window.IFloatViewCreator;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.team.api.ITeamService;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.Logger;
import org.jetbrains.annotations.NotNull;

final class YoloRoomFloatViewUtil$2
  implements IFloatViewCreator
{
  YoloRoomFloatViewUtil$2(int paramInt) {}
  
  @NotNull
  public IFloatView a(String paramString)
  {
    int i = this.a;
    IFloatView localIFloatView;
    if (i != 1)
    {
      if (i != 3)
      {
        if (i == 4) {
          CustomToastView.a("待开发：语聊房间悬浮球");
        }
      }
      else {
        CustomToastView.a("待开发：直播房间悬浮球");
      }
      localIFloatView = null;
    }
    else
    {
      localIFloatView = ((ITeamService)ServiceCenter.a(ITeamService.class)).a(Long.parseLong(paramString));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FloatViewCreator#create - ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append(localIFloatView);
    Logger.a("YoloRoomUtil", localStringBuilder.toString());
    return localIFloatView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.util.YoloRoomFloatViewUtil.2
 * JD-Core Version:    0.7.0.1
 */