package com.tencent.qqlive.module.videoreport.dtreport.time.app;

import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.utils.JsonUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class AppForegroundSession$3
  implements Runnable
{
  AppForegroundSession$3(String paramString) {}
  
  public void run()
  {
    Object localObject1 = AppHeartBeatSpUtils.getLastHeartBeatMap();
    if (localObject1 == null) {
      return;
    }
    Object localObject2;
    Object localObject3;
    if (((Map)localObject1).containsKey(this.val$curSessionId))
    {
      localObject2 = new HashMap();
      localObject3 = this.val$curSessionId;
      ((Map)localObject2).put(localObject3, ((Map)localObject1).remove(localObject3));
      AppHeartBeatSpUtils.saveSessionLastHeartBeat((Map)localObject2);
    }
    else
    {
      AppHeartBeatSpUtils.clearSessionHeartBeat();
    }
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject1).next();
      localObject2 = (String)((Map.Entry)localObject3).getKey();
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject3 = String.valueOf(((Map.Entry)localObject3).getValue());
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject3 = JsonUtils.getMapForJson((String)localObject3);
          if ((localObject3 != null) && (!((String)localObject2).equals(this.val$curSessionId))) {
            AppForegroundSession.access$100((Map)localObject3);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.time.app.AppForegroundSession.3
 * JD-Core Version:    0.7.0.1
 */