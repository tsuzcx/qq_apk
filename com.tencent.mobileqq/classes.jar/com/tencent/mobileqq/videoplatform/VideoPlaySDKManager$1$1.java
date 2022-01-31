package com.tencent.mobileqq.videoplatform;

import bbvt;
import bbvu;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class VideoPlaySDKManager$1$1
  implements Runnable
{
  public VideoPlaySDKManager$1$1(bbvu parambbvu) {}
  
  public void run()
  {
    bbvt.a(this.a.jdField_a_of_type_Bbvt, this.a.jdField_a_of_type_AndroidAppActivity);
    ThreadManager.getUIHandler().post(new VideoPlaySDKManager.1.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.VideoPlaySDKManager.1.1
 * JD-Core Version:    0.7.0.1
 */