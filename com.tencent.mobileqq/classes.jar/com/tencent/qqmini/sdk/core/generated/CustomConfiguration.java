package com.tencent.qqmini.sdk.core.generated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class CustomConfiguration
{
  public static final Boolean FLUTTER_ENABLED = Boolean.valueOf(false);
  public static final Map MINI_PROCESS_1;
  public static final Map MINI_PROCESS_2;
  public static final List MINI_PROCESS_LIST = new ArrayList();
  
  static
  {
    MINI_PROCESS_1 = new HashMap();
    MINI_PROCESS_2 = new HashMap();
    MINI_PROCESS_1.put("name", "mini6");
    MINI_PROCESS_1.put("processType", "MINI_GAME");
    MINI_PROCESS_1.put("ui", "com.tencent.mobileqq.minigame.ui.GameActivity1");
    MINI_PROCESS_1.put("receiver", "com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver1");
    MINI_PROCESS_LIST.add(MINI_PROCESS_1);
    MINI_PROCESS_2.put("name", "mini7");
    MINI_PROCESS_2.put("processType", "MINI_APP");
    MINI_PROCESS_2.put("ui", "com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI3");
    MINI_PROCESS_2.put("receiver", "com.tencent.mobileqq.mini.app.AppBrandTaskPreloadReceiver7");
    MINI_PROCESS_LIST.add(MINI_PROCESS_2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.generated.CustomConfiguration
 * JD-Core Version:    0.7.0.1
 */