package com.tencent.mobileqq.kandian.base.image;

import com.tencent.av.utils.SignalStrengthReport.PingUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Arrays;

final class RIJImageOptMonitor$2
  implements Runnable
{
  RIJImageOptMonitor$2(ImageRequest paramImageRequest) {}
  
  public void run()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((ImageRequest)localObject).a != null))
    {
      localObject = this.a.a.toString();
      String[] arrayOfString = RIJImageOptMonitor.a(this.a.a.getHost());
      int i = SignalStrengthReport.PingUtil.a((String)localObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ping url: ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" ip: ");
      localStringBuilder.append(Arrays.toString(arrayOfString));
      localStringBuilder.append(" time: ");
      localStringBuilder.append(i);
      QLog.d("RIJImageOptMonitor", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.RIJImageOptMonitor.2
 * JD-Core Version:    0.7.0.1
 */