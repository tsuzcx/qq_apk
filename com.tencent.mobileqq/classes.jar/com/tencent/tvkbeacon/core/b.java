package com.tencent.tvkbeacon.core;

import android.content.Context;
import com.tencent.tvkbeacon.core.a.g;
import com.tencent.tvkbeacon.core.b.h;
import com.tencent.tvkbeacon.core.c.c;
import java.util.Map;

public class b
{
  private boolean firstStrategyQueryFinishedCalled = true;
  public Context mContext;
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public void onAppFirstRun() {}
  
  public void onFirstStrategyQueryFinished() {}
  
  public void onModuleStarted() {}
  
  public void onModuleStrategyUpdated(int paramInt, Map<String, String> paramMap) {}
  
  public void onSDKInit(Context paramContext) {}
  
  public void onStrategyQueryFinished()
  {
    if (this.firstStrategyQueryFinishedCalled)
    {
      onFirstStrategyQueryFinished();
      if ((!h.a(this.mContext).a()) || (!g.a(this.mContext).a("sig_1")) || (!h.a(this.mContext).b())) {
        break label62;
      }
      onModuleStarted();
    }
    for (;;)
    {
      this.firstStrategyQueryFinishedCalled = false;
      return;
      label62:
      c.c("[strategy] get lock failed, on call module started", new Object[0]);
    }
  }
  
  public void onStrategyQueryStarted() {}
  
  public void onStrategyUpdated(com.tencent.tvkbeacon.core.strategy.b paramb) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.b
 * JD-Core Version:    0.7.0.1
 */