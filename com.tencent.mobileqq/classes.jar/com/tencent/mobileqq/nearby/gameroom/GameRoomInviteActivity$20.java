package com.tencent.mobileqq.nearby.gameroom;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

class GameRoomInviteActivity$20
  implements Runnable
{
  GameRoomInviteActivity$20(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void run()
  {
    Object localObject2 = (TicketManager)this.this$0.app.getManager(2);
    Object localObject1 = this.this$0.app.getCurrentAccountUin();
    String str = ((TicketManager)localObject2).getSkey(this.this$0.app.getCurrentAccountUin());
    localObject2 = new Bundle();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(TroopUtils.a(str));
    ((Bundle)localObject2).putString("bkn", localStringBuilder.toString());
    ((Bundle)localObject2).putString("ver", "8.7.0");
    ((Bundle)localObject2).putString("src", "1");
    ((Bundle)localObject2).putString("platform", "android");
    ((Bundle)localObject2).putString("uin", this.this$0.app.getCurrentAccountUin());
    ((Bundle)localObject2).putString("count", "8");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin=o");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(";skey=");
    localStringBuilder.append(str);
    ((Bundle)localObject2).putString("Cookie", localStringBuilder.toString());
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("BUNDLE", localObject2);
    this.this$0.app.getApplication();
    ((HashMap)localObject1).put("CONTEXT", MobileQQ.getContext());
    new HttpWebCgiAsyncTask("https://nearby.qq.com/cgi-bin/werewolf/get_friend_board_list", "GET", this.this$0.onGetRecommendData, 0, null, true).execute(new HashMap[] { localObject1 });
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("get feed from server start: ");
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      QLog.d("GameRoomInviteActivity", 2, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.20
 * JD-Core Version:    0.7.0.1
 */