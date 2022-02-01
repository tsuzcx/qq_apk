package com.tencent.mobileqq.microapp.sdk;

import android.text.TextUtils;
import org.json.JSONObject;

final class MiniAppController$2
  implements Runnable
{
  MiniAppController$2(String paramString) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(this.val$actionData);
        String str = ((JSONObject)localObject2).optString("appId");
        Object localObject1 = ((JSONObject)localObject2).optString("entryPath");
        localObject2 = ((JSONObject)localObject2).optString("entryPathInConfig");
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(str)) {
            MiniAppController.access$000(str, (String)localObject1);
          }
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.sdk.MiniAppController.2
 * JD-Core Version:    0.7.0.1
 */