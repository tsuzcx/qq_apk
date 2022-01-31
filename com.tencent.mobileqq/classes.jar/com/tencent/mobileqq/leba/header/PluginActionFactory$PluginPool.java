package com.tencent.mobileqq.leba.header;

import android.content.Context;
import com.tencent.mobileqq.leba.model.pluginactions.PluginAction;
import java.util.HashMap;
import java.util.Map;

public class PluginActionFactory$PluginPool
{
  private Map a = new HashMap();
  
  public PluginAction a(int paramInt)
  {
    return (PluginAction)this.a.get(Integer.valueOf(paramInt));
  }
  
  public PluginAction a(int paramInt, Context paramContext)
  {
    PluginAction localPluginAction = a(paramInt);
    Object localObject = localPluginAction;
    if (localPluginAction == null)
    {
      paramContext = PluginActionFactory.a(paramInt, paramContext);
      localObject = paramContext;
      if (paramContext != null)
      {
        a(paramInt, paramContext);
        localObject = paramContext;
      }
    }
    return localObject;
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(int paramInt, PluginAction paramPluginAction)
  {
    this.a.put(Integer.valueOf(paramInt), paramPluginAction);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.leba.header.PluginActionFactory.PluginPool
 * JD-Core Version:    0.7.0.1
 */