package com.tencent.open.agent;

import android.content.Intent;
import com.tencent.qqconnect.wtlogin.IEventListener;

class AgentActivity$1
  implements IEventListener
{
  AgentActivity$1(AgentActivity paramAgentActivity) {}
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramInt == 1)
    {
      AgentActivity.access$008(this.a);
      return;
    }
    if (paramInt == 2)
    {
      AgentActivity.access$102(this.a, true);
      AgentActivity.access$010(this.a);
      this.a.finish();
      return;
    }
    if (paramInt == 3)
    {
      AgentActivity.access$200(this.a, 0, (Intent)paramObject);
      AgentActivity.access$008(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.AgentActivity.1
 * JD-Core Version:    0.7.0.1
 */