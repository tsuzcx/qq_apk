package com.tencent.mobileqq.emosm.web.module;

import amma;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.emosm.web.MessengerService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

class CmShowModule$13
  implements Runnable
{
  CmShowModule$13(CmShowModule paramCmShowModule, String paramString, Bundle paramBundle, MessengerService paramMessengerService, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      Object localObject = new JSONObject(this.val$gameListJson).getJSONArray("gameList");
      ArrayList localArrayList = new ArrayList();
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          localArrayList.add(Integer.valueOf(((JSONArray)localObject).getInt(i)));
          i += 1;
        }
        localObject = new CmShowModule.13.1(this);
        amma localamma = (amma)this.val$qqApp.getManager(QQManagerFactory.APOLLO_GAME_MANAGER);
        localamma.a = new WeakReference(localObject);
        localamma.a("android.web", "apollo_aio_game.add_games_to_user_gamepanel", localArrayList);
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.module.CmShowModule.13
 * JD-Core Version:    0.7.0.1
 */