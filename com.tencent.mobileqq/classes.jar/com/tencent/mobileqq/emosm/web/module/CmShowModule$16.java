package com.tencent.mobileqq.emosm.web.module;

import amma;
import android.os.Bundle;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.emosm.web.MessengerService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

class CmShowModule$16
  implements Runnable
{
  CmShowModule$16(CmShowModule paramCmShowModule, String paramString, Bundle paramBundle, MessengerService paramMessengerService, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      Object localObject2 = new JSONObject(this.val$gameListJson).getJSONArray("gameList");
      Object localObject1 = new ArrayList();
      if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
      {
        int i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          ((ArrayList)localObject1).add(Integer.valueOf(((JSONArray)localObject2).getInt(i)));
          i += 1;
        }
        localObject2 = new CmShowModule.16.1(this);
        amma localamma = (amma)this.val$qqApp.getManager(QQManagerFactory.APOLLO_GAME_MANAGER);
        localamma.a = new WeakReference(localObject2);
        localamma.a("android.web", "apollo_aio_game.del_games_from_user_gamepanel", (ArrayList)localObject1);
        localObject1 = this.val$qqApp.getHandler(Conversation.class);
        ((MqqHandler)localObject1).sendMessage(((MqqHandler)localObject1).obtainMessage(1134054));
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.module.CmShowModule.16
 * JD-Core Version:    0.7.0.1
 */