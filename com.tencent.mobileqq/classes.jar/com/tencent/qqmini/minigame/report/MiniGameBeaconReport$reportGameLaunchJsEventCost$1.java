package com.tencent.qqmini.minigame.report;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class MiniGameBeaconReport$reportGameLaunchJsEventCost$1
  implements Runnable
{
  MiniGameBeaconReport$reportGameLaunchJsEventCost$1(Map paramMap, String paramString) {}
  
  public final void run()
  {
    Object localObject = this.a;
    Map localMap = (Map)new HashMap();
    localObject = ((Iterable)((Map)localObject).entrySet()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localMap.put(localEntry.getKey(), String.valueOf(((Number)localEntry.getValue()).longValue()));
    }
    ((Map)localMap).put("appid", this.b);
    MiniGameBeaconReport.report("game_launch_js_event", localMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.report.MiniGameBeaconReport.reportGameLaunchJsEventCost.1
 * JD-Core Version:    0.7.0.1
 */