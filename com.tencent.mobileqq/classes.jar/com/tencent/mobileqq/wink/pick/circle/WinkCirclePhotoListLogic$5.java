package com.tencent.mobileqq.wink.pick.circle;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class WinkCirclePhotoListLogic$5
  implements Runnable
{
  WinkCirclePhotoListLogic$5(WinkCirclePhotoListLogic paramWinkCirclePhotoListLogic, ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("serialCompressVideos---begin, need compress count=");
    localStringBuilder.append(this.a.size());
    AEQLog.b("WinkCirclePhotoListLogic", localStringBuilder.toString());
    WinkCirclePhotoListLogic.a(this.this$0, false);
    WinkCirclePhotoListLogic.a(this.this$0, this.a, this.b, this.c);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("serialCompressVideos---end, canceled=");
    localStringBuilder.append(WinkCirclePhotoListLogic.a(this.this$0));
    AEQLog.b("WinkCirclePhotoListLogic", localStringBuilder.toString());
    if ((!WinkCirclePhotoListLogic.a(this.this$0)) && (!WinkCirclePhotoListLogic.b(this.this$0))) {
      ThreadManager.getUIHandler().post(new WinkCirclePhotoListLogic.5.1(this));
    } else {
      ThreadManager.getUIHandler().post(new WinkCirclePhotoListLogic.5.2(this));
    }
    WinkCirclePhotoListLogic.b(this.this$0, false);
    WinkCirclePhotoListLogic.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.WinkCirclePhotoListLogic.5
 * JD-Core Version:    0.7.0.1
 */