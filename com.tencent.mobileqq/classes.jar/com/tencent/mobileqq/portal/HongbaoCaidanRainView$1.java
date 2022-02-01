package com.tencent.mobileqq.portal;

import android.graphics.BitmapFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class HongbaoCaidanRainView$1
  implements Runnable
{
  public void run()
  {
    HongbaoCaidanRainView.a(this.this$0).clear();
    String[] arrayOfString = this.a;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label156;
      }
      Object localObject = arrayOfString[i];
      try
      {
        localObject = BitmapFactory.decodeFile((String)localObject);
        if (localObject != null) {
          HongbaoCaidanRainView.a(this.this$0).add(localObject);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          QLog.d("HongbaoCaidanRainView", 1, "start, OutOfMemoryError oom=" + localOutOfMemoryError.getMessage());
          if (QLog.isColorLevel()) {
            localOutOfMemoryError.printStackTrace();
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.d("HongbaoCaidanRainView", 1, "start, throwable t=" + localThrowable.getMessage());
          if (QLog.isColorLevel()) {
            localThrowable.printStackTrace();
          }
        }
      }
      i += 1;
    }
    label156:
    if (HongbaoCaidanRainView.a(this.this$0).size() > 0)
    {
      HongbaoCaidanRainView.a(this.this$0, System.currentTimeMillis());
      HongbaoCaidanRainView.b(this.this$0, HongbaoCaidanRainView.a(this.this$0));
      HongbaoCaidanRainView.a(this.this$0, true);
      HongbaoCaidanRainView.b(this.this$0, false);
      this.this$0.postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.HongbaoCaidanRainView.1
 * JD-Core Version:    0.7.0.1
 */