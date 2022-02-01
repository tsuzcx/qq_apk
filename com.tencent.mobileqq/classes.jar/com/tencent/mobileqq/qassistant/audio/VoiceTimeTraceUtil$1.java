package com.tencent.mobileqq.qassistant.audio;

import android.app.Activity;
import bajl;
import bakl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class VoiceTimeTraceUtil$1
  implements Runnable
{
  public VoiceTimeTraceUtil$1(bajl parambajl, List paramList, Activity paramActivity) {}
  
  public void run()
  {
    this.jdField_a_of_type_JavaUtilList.addAll(bajl.a(this.this$0).values());
    String str = bakl.b() + "snapshot.zip";
    bakl.a("VoiceTimeTraceUtil", "create trace zip: " + str);
    FileUtils.zipFiles(this.jdField_a_of_type_JavaUtilList, str);
    this.this$0.a("ZIP", str);
    ThreadManager.getUIHandler().post(new VoiceTimeTraceUtil.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.audio.VoiceTimeTraceUtil.1
 * JD-Core Version:    0.7.0.1
 */