package com.tencent.mobileqq.config.business;

import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class MsfUdpConfigProcessor$onUpdate$1
  implements Runnable
{
  MsfUdpConfigProcessor$onUpdate$1(AppRuntime paramAppRuntime, NewIntent paramNewIntent) {}
  
  public final void run()
  {
    this.a.startServlet(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.MsfUdpConfigProcessor.onUpdate.1
 * JD-Core Version:    0.7.0.1
 */