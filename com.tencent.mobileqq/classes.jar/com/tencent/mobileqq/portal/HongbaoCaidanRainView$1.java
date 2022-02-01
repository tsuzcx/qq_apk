package com.tencent.mobileqq.portal;

import android.graphics.BitmapFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class HongbaoCaidanRainView$1
  implements Runnable
{
  HongbaoCaidanRainView$1(HongbaoCaidanRainView paramHongbaoCaidanRainView, String[] paramArrayOfString) {}
  
  public void run()
  {
    HongbaoCaidanRainView.a(this.this$0).clear();
    Object localObject1 = this.a;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      try
      {
        localObject2 = BitmapFactory.decodeFile((String)localObject2);
        if (localObject2 != null) {
          HongbaoCaidanRainView.a(this.this$0).add(localObject2);
        }
      }
      catch (Throwable localThrowable)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("start, throwable t=");
        localStringBuilder.append(localThrowable.getMessage());
        QLog.d("HongbaoCaidanRainView", 1, localStringBuilder.toString());
        if (QLog.isColorLevel()) {
          localThrowable.printStackTrace();
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("start, OutOfMemoryError oom=");
        localStringBuilder.append(localOutOfMemoryError.getMessage());
        QLog.d("HongbaoCaidanRainView", 1, localStringBuilder.toString());
        if (QLog.isColorLevel()) {
          localOutOfMemoryError.printStackTrace();
        }
      }
      i += 1;
    }
    if (HongbaoCaidanRainView.a(this.this$0).size() > 0)
    {
      HongbaoCaidanRainView.a(this.this$0, System.currentTimeMillis());
      localObject1 = this.this$0;
      HongbaoCaidanRainView.b((HongbaoCaidanRainView)localObject1, HongbaoCaidanRainView.a((HongbaoCaidanRainView)localObject1));
      HongbaoCaidanRainView.a(this.this$0, true);
      HongbaoCaidanRainView.b(this.this$0, false);
      this.this$0.postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.portal.HongbaoCaidanRainView.1
 * JD-Core Version:    0.7.0.1
 */