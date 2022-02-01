package com.tencent.timi.game.room.impl;

import com.tencent.timi.game.ui.widget.CustomToastView;

class YoloRoomManager$6$1
  implements Runnable
{
  YoloRoomManager$6$1(YoloRoomManager.6 param6, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    int i = this.a;
    Object localObject;
    if (i == -2)
    {
      i = this.b;
      if (i != 1)
      {
        if (i != 3)
        {
          if (i != 4) {
            localObject = "语音功能";
          } else {
            localObject = "直播房间功能";
          }
        }
        else {
          localObject = "语音房间语音功能";
        }
      }
      else {
        localObject = "车队语音功能";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("正在");
      localStringBuilder.append(this.c);
      localStringBuilder.append("，请结束后才能使用");
      localStringBuilder.append((String)localObject);
      CustomToastView.a(localStringBuilder.toString());
      return;
    }
    if (i == -1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("业务所需组件加载失败，请稍后重试：");
      ((StringBuilder)localObject).append(this.c);
      CustomToastView.a(((StringBuilder)localObject).toString());
      return;
    }
    if (i == -3)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("用户权限校验失败，请稍后重试：");
      ((StringBuilder)localObject).append(this.c);
      CustomToastView.a(((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomManager.6.1
 * JD-Core Version:    0.7.0.1
 */