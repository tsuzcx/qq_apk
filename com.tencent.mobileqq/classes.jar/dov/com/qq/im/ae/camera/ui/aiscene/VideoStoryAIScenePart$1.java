package dov.com.qq.im.ae.camera.ui.aiscene;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.videostory.support.VSReporter;

class VideoStoryAIScenePart$1
  extends Handler
{
  VideoStoryAIScenePart$1(VideoStoryAIScenePart paramVideoStoryAIScenePart, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      VSReporter.a("mystatus_shoot", "comp_recomm", 0, 0, new String[0]);
      paramMessage = paramMessage.getData();
      int i = paramMessage.getInt("sceneLvOne");
      paramMessage = paramMessage.getString("sceneName");
      this.a.a(i, paramMessage, true);
      return;
    }
    VSReporter.a("mystatus_shoot", "exp_recomm", 0, 0, new String[0]);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.1
 * JD-Core Version:    0.7.0.1
 */