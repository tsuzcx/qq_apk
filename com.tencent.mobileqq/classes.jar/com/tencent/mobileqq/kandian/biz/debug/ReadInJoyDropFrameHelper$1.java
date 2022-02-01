package com.tencent.mobileqq.kandian.biz.debug;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class ReadInJoyDropFrameHelper$1
  implements Runnable
{
  public void run()
  {
    Iterator localIterator = ((List)ReadInJoyDropFrameHelper.a(this.this$0).get(Integer.valueOf(ReadInJoyDropFrameHelper.a(this.this$0, this.a)))).iterator();
    while (localIterator.hasNext())
    {
      ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener localOnFeedsFluencyResultListener = (ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateFeedsFluency UI FluencyVal : ");
      localStringBuilder.append(this.b);
      QLog.d("ReadInJoyDropFrameHelper", 2, localStringBuilder.toString());
      localOnFeedsFluencyResultListener.a(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.debug.ReadInJoyDropFrameHelper.1
 * JD-Core Version:    0.7.0.1
 */