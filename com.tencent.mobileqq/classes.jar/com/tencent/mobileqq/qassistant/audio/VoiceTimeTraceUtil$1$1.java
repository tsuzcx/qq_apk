package com.tencent.mobileqq.qassistant.audio;

import bajl;
import bamr;
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
      this.a.jdField_a_of_type_JavaUtilList.clear();
      this.a.jdField_a_of_type_JavaUtilList.add(bajl.a(this.a.this$0).get("ZIP"));
      bamr.b(this.a.jdField_a_of_type_JavaUtilList, this.a.jdField_a_of_type_AndroidAppActivity);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.audio.VoiceTimeTraceUtil.1.1
 * JD-Core Version:    0.7.0.1
 */