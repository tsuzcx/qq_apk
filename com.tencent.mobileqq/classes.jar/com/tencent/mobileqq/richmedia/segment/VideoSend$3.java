package com.tencent.mobileqq.richmedia.segment;

import axtf;
import axtg;
import baqf;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class VideoSend$3
  implements Runnable
{
  public VideoSend$3(axtg paramaxtg, baqf parambaqf) {}
  
  public void run()
  {
    this.this$0.a = this.a;
    if (QLog.isColorLevel()) {
      QLog.d("VideoSend", 2, "processor is ready,addToSendQuene , mWaitForSubmitToProcessorInfos " + this.this$0.b.size());
    }
    Iterator localIterator = this.this$0.b.iterator();
    while (localIterator.hasNext())
    {
      axtf localaxtf = (axtf)localIterator.next();
      this.this$0.a.e(localaxtf);
    }
    this.this$0.b.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.segment.VideoSend.3
 * JD-Core Version:    0.7.0.1
 */