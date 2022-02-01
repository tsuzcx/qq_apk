package com.tencent.mobileqq.richmedia.segment;

import bavp;
import bavq;
import bdwd;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class VideoSend$2
  implements Runnable
{
  public VideoSend$2(bavq parambavq, bavp parambavp) {}
  
  public void run()
  {
    if (this.this$0.a == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoSend", 2, "addToWaitQuene, info:" + this.a + " mWaitForSubmitToProcessorInfos:" + this.this$0.b.size());
      }
      if (this.a.a())
      {
        this.this$0.b.add(0, this.a);
        return;
      }
      this.this$0.b.add(this.a);
      return;
    }
    this.this$0.a.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.segment.VideoSend.2
 * JD-Core Version:    0.7.0.1
 */