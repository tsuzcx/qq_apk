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
    this.a.addAll(VoiceTimeTraceUtil.a(this.this$0).values());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AssistantUtils.f());
    ((StringBuilder)localObject).append("snapshot.zip");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("create trace zip: ");
    localStringBuilder.append((String)localObject);
    AssistantUtils.a("VoiceTimeTraceUtil", localStringBuilder.toString());
    FileUtils.zipFiles(this.a, (String)localObject);
    this.this$0.a("ZIP", (String)localObject);
    ThreadManager.getUIHandler().post(new VoiceTimeTraceUtil.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.audio.VoiceTimeTraceUtil.1
 * JD-Core Version:    0.7.0.1
 */