import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyWebRenderEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyWebRenderStateMachineScheduler.StateMachine;
import com.tencent.qphone.base.util.QLog;

public class los
  implements ReadInJoyWebRenderStateMachineScheduler.StateMachine
{
  public los(ReadInJoyWebRenderEngine paramReadInJoyWebRenderEngine) {}
  
  public int a(Bundle paramBundle)
  {
    int j = this.a.a;
    int i = -1;
    long l = System.currentTimeMillis();
    switch (this.a.a)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("viola.ReadInJoyWebRenderEngine", 1, "native_render CreateLoop:step[" + j + "] -> step[" + this.a.a + "] cost[" + (System.currentTimeMillis() - l) + "ms]" + " timestamps[" + System.currentTimeMillis() + "]");
      }
      ReadInJoyUtils.a(ReadInJoyUtils.a(), true, j, System.currentTimeMillis() - l);
      return i;
      i = this.a.b(paramBundle);
      continue;
      i = this.a.c(paramBundle);
      continue;
      i = this.a.d(paramBundle);
      continue;
      i = this.a.e(paramBundle);
      continue;
      i = this.a.f(paramBundle);
      continue;
      i = this.a.g(paramBundle);
      continue;
      i = this.a.h(paramBundle);
      continue;
      i = this.a.i(paramBundle);
      continue;
      i = this.a.j(paramBundle);
      continue;
      i = this.a.k(paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     los
 * JD-Core Version:    0.7.0.1
 */