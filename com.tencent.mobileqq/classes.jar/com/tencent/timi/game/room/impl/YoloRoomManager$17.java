package com.tencent.timi.game.room.impl;

import android.text.TextUtils;
import com.tencent.timi.game.env.Env;
import com.tencent.timi.game.room.api.DoYoloRoomCmdResultListsner;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.IResultListener;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCmdRsp;

class YoloRoomManager$17
  implements DoYoloRoomCmdResultListsner
{
  YoloRoomManager$17(YoloRoomManager paramYoloRoomManager, IResultListener paramIResultListener) {}
  
  public void a(int paramInt, String paramString, long paramLong, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (paramInt == 9200104)
      {
        paramString = "当前本队人员段位不符合要求";
      }
      else if ((paramInt != 9200117) && (paramInt != 9200118))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("修改失败，请稍后重试");
        if (Env.b())
        {
          paramString = new StringBuilder();
          paramString.append("(");
          paramString.append(paramInt);
          paramString.append(")");
          paramString = paramString.toString();
        }
        else
        {
          paramString = "";
        }
        ((StringBuilder)localObject).append(paramString);
        paramString = ((StringBuilder)localObject).toString();
      }
      else
      {
        paramString = "人数超出该模式限制";
      }
    }
    CustomToastView.a(paramString);
    Object localObject = this.a;
    if (localObject != null) {
      ((IResultListener)localObject).a(paramInt, paramString);
    }
  }
  
  public void a(YoloRoomOuterClass.YoloRoomCmdRsp paramYoloRoomCmdRsp, long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {
      YoloRoomManager.f(this.b);
    }
    IResultListener localIResultListener = this.a;
    if (localIResultListener != null) {
      localIResultListener.a(paramYoloRoomCmdRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomManager.17
 * JD-Core Version:    0.7.0.1
 */