package com.tencent.mobileqq.shortvideo.redbag;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import org.json.JSONException;
import org.json.JSONObject;

class RedBagVideoManager$1
  extends BroadcastReceiver
{
  RedBagVideoManager$1(RedBagVideoManager paramRedBagVideoManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    for (;;)
    {
      return;
      paramContext = paramIntent.getStringExtra("event");
      if (paramContext != null)
      {
        paramIntent = paramIntent.getStringExtra("data");
        if ((paramIntent != null) && (paramContext.equals("ShortVideoHongbaoInfoUpdate"))) {
          try
          {
            paramContext = new JSONObject(paramIntent);
            paramIntent = paramContext.optString("shortVideoId");
            boolean bool = paramContext.optBoolean("isPaid");
            if ((RedBagVideoManager.a(this.a) != null) && (RedBagVideoManager.a(this.a).h != 1) && (bool) && (RedBagVideoManager.a(this.a).c.equals(paramIntent)))
            {
              new RedBagVideoManager.UpdateTask(this.a).execute(new String[0]);
              return;
            }
          }
          catch (JSONException paramContext) {}
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.1
 * JD-Core Version:    0.7.0.1
 */