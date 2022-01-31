package com.tencent.plato;

import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

final class PlatoAppManager$4
  implements Runnable
{
  PlatoAppManager$4(String paramString1, String paramString2) {}
  
  public void run()
  {
    PlatoLoadEvent localPlatoLoadEvent = PlatoLoadEvent.createBundlerLoadEvent(0, this.val$bid, this.val$filePath);
    Dispatchers.get().dispatch(localPlatoLoadEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.plato.PlatoAppManager.4
 * JD-Core Version:    0.7.0.1
 */