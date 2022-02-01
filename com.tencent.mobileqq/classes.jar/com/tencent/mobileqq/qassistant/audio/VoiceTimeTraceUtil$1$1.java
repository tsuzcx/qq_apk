package com.tencent.mobileqq.qassistant.audio;

import com.tencent.mobileqq.qassistant.util.CommandUtils;
import java.util.List;
import java.util.Map;

class VoiceTimeTraceUtil$1$1
  implements Runnable
{
  VoiceTimeTraceUtil$1$1(VoiceTimeTraceUtil.1 param1) {}
  
  public void run()
  {
    try
    {
      this.a.a.clear();
      this.a.a.add(VoiceTimeTraceUtil.a(this.a.this$0).get("ZIP"));
      CommandUtils.b(this.a.a, this.a.b);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.audio.VoiceTimeTraceUtil.1.1
 * JD-Core Version:    0.7.0.1
 */