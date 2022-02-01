package com.tencent.timi.game.app;

import com.tencent.timi.game.utils.NetEventManager;
import com.yolo.esports.download.common.HalleyDownloaderProxy;
import java.util.LinkedList;
import java.util.List;

public class TimiGameApp
{
  private static volatile TimiGameApp b;
  private List<ISingletonLifeCycle> a = new LinkedList();
  
  private TimiGameApp()
  {
    this.a.add(NetEventManager.a());
    this.a.add(HalleyDownloaderProxy.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.app.TimiGameApp
 * JD-Core Version:    0.7.0.1
 */