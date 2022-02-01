package com.tencent.mobileqq.richmedia.segment;

import bavp;
import bavq;
import bdwd;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class VideoSend$3
  implements Runnable
{
  public VideoSend$3(bavq parambavq, bdwd parambdwd) {}
  
  public void run()
  {
    this.this$0.a = this.a;
    if (QLog.isColorLevel()) {
      QLog.d("VideoSend", 2, "processor is ready,addToSendQuene , mWaitForSubmitToProcessorInfos " + this.this$0.b.size());
    }
    Iterator localIterator = this.this$0.b.iterator();
    while (localIterator.hasNext())
    {
      bavp localbavp = (bavp)localIterator.next();
      this.this$0.a.e(localbavp);
    }
    this.this$0.b.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.segment.VideoSend.3
 * JD-Core Version:    0.7.0.1
 */