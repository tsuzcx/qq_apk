package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.os.Bundle;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJStatisticCollectorReport;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyWebRenderEngine$1
  implements ReadInJoyWebRenderStateMachineScheduler.StateMachine
{
  ReadInJoyWebRenderEngine$1(ReadInJoyWebRenderEngine paramReadInJoyWebRenderEngine) {}
  
  public int a(Bundle paramBundle)
  {
    int j = this.a.a;
    long l = System.currentTimeMillis();
    int i;
    switch (this.a.a)
    {
    default: 
      i = -1;
      break;
    case 11: 
      i = this.a.k(paramBundle);
      break;
    case 10: 
      i = this.a.j(paramBundle);
      break;
    case 9: 
      i = this.a.i(paramBundle);
      break;
    case 8: 
      i = this.a.h(paramBundle);
      break;
    case 7: 
      i = this.a.g(paramBundle);
      break;
    case 6: 
      i = this.a.f(paramBundle);
      break;
    case 5: 
      i = this.a.e(paramBundle);
      break;
    case 4: 
      i = this.a.d(paramBundle);
      break;
    case 3: 
      i = this.a.c(paramBundle);
      break;
    case 2: 
      i = this.a.b(paramBundle);
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder("native_render CreateLoop:step[");
      paramBundle.append(j);
      paramBundle.append("] -> step[");
      paramBundle.append(this.a.a);
      paramBundle.append("] cost[");
      paramBundle.append(System.currentTimeMillis() - l);
      paramBundle.append("ms]");
      paramBundle.append(" timestamps[");
      paramBundle.append(System.currentTimeMillis());
      paramBundle.append("]");
      QLog.i("viola.ReadInJoyWebRenderEngine", 1, paramBundle.toString());
    }
    RIJStatisticCollectorReport.a(ReadInJoyUtils.b(), true, j, System.currentTimeMillis() - l);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyWebRenderEngine.1
 * JD-Core Version:    0.7.0.1
 */