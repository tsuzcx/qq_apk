package com.tencent.mobileqq.kandian.base.image;

import com.tencent.mobileqq.kandian.base.image.imageloader.RIJImageOptReport;
import com.tencent.qphone.base.util.QLog;

final class RIJImageOptMonitor$1
  implements Runnable
{
  RIJImageOptMonitor$1(ImageRequest paramImageRequest) {}
  
  public void run()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((ImageRequest)localObject).h > 0L) && ((this.a.o == 0L) || ((!this.a.d) && (this.a.q != 0))))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("image load too slow: ");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("RIJImageOptMonitor", 1, ((StringBuilder)localObject).toString());
      RIJImageOptReport.a(this.a);
      RIJImageOptMonitor.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.RIJImageOptMonitor.1
 * JD-Core Version:    0.7.0.1
 */