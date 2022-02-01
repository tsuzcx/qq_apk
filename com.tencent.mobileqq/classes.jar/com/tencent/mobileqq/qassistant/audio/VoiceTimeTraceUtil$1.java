package com.tencent.mobileqq.qassistant.audio;

import android.app.Activity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

class VoiceTimeTraceUtil$1
  implements Runnable
{
  VoiceTimeTraceUtil$1(VoiceTimeTraceUtil paramVoiceTimeTraceUtil, List paramList, Activity paramActivity) {}
  
  public void run()
  {
    this.jdField_a_of_type_JavaUtilList.addAll(VoiceTimeTraceUtil.a(this.this$0).values());
    String str = AssistantUtils.b() + "snapshot.zip";
    AssistantUtils.a("VoiceTimeTraceUtil", "create trace zip: " + str);
    FileUtils.a(this.jdField_a_of_type_JavaUtilList, str);
    this.this$0.a("ZIP", str);
    ThreadManager.getUIHandler().post(new VoiceTimeTraceUtil.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.audio.VoiceTimeTraceUtil.1
 * JD-Core Version:    0.7.0.1
 */