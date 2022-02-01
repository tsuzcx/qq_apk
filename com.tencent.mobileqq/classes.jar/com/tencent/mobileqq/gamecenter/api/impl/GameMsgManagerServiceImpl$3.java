package com.tencent.mobileqq.gamecenter.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.gamecenter.config.GameMsgTabConfig;
import mqq.app.MobileQQ;

class GameMsgManagerServiceImpl$3
  implements Runnable
{
  GameMsgManagerServiceImpl$3(GameMsgManagerServiceImpl paramGameMsgManagerServiceImpl, String paramString) {}
  
  public void run()
  {
    GameMsgManagerServiceImpl.access$1502(this.this$0, GameMsgTabConfig.a(this.a));
    SharedPreferences localSharedPreferences = GameMsgManagerServiceImpl.access$400(this.this$0).getApplication().getSharedPreferences("game_center_sp", 0);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(GameMsgManagerServiceImpl.access$400(this.this$0).getCurrentAccountUin());
    ((StringBuilder)localObject).append("sp_key_tab_config");
    localObject = ((StringBuilder)localObject).toString();
    localSharedPreferences.edit().putString((String)localObject, this.a).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.api.impl.GameMsgManagerServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */