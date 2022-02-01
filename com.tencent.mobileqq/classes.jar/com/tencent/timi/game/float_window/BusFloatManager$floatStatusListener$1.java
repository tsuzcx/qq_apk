package com.tencent.timi.game.float_window;

import com.tencent.timi.game.float_window.impl.YesFloatWindowManager;
import com.tencent.timi.game.float_window.impl.YesFloatWindowManager.Companion;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.Logger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/float_window/BusFloatManager$floatStatusListener$1", "Lcom/tencent/timi/game/float_window/IFloatWindowStatusListener;", "onWindowDismiss", "", "onWindowHide", "onWindowPause", "onWindowPlay", "onWindowShow", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class BusFloatManager$floatStatusListener$1
  implements IFloatWindowStatusListener
{
  public void a() {}
  
  public void b()
  {
    Logger.a(YesFloatWindowManager.a.a(), "onWindowHide");
  }
  
  public void c()
  {
    Logger.a(YesFloatWindowManager.a.a(), "onWindowShow");
  }
  
  public void d()
  {
    Logger.a(YesFloatWindowManager.a.a(), "onWindowDismiss");
    Object localObject2 = BusFloatManager.a(this.a);
    Object localObject1 = (Map)new LinkedHashMap();
    localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      if (((Boolean)localEntry.getValue()).booleanValue()) {
        ((Map)localObject1).put(localEntry.getKey(), localEntry.getValue());
      }
    }
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      ((IFloatWindowService)ServiceCenter.a(IFloatWindowService.class)).b(((String)((Map.Entry)localObject2).getKey()).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.float_window.BusFloatManager.floatStatusListener.1
 * JD-Core Version:    0.7.0.1
 */