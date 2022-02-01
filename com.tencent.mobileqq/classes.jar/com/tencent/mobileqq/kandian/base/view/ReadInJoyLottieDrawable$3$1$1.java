package com.tencent.mobileqq.kandian.base.view;

import android.graphics.BitmapFactory;
import android.support.v4.util.LruCache;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyLottieDrawable$3$1$1
  implements Runnable
{
  ReadInJoyLottieDrawable$3$1$1(ReadInJoyLottieDrawable.3.1 param1, String paramString) {}
  
  public void run()
  {
    try
    {
      localObject = BitmapFactory.decodeFile(this.a);
      if (localObject == null) {
        break label94;
      }
      ReadInJoyLottieDrawable.b().put(this.a, localObject);
      return;
    }
    catch (Exception localException)
    {
      Object localObject;
      break label60;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label25:
      label60:
      label94:
      break label25;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("loadLottieAnimation oom: ");
    ((StringBuilder)localObject).append(this.a);
    QLog.e("ReadInJoyLottieDrawable", 2, ((StringBuilder)localObject).toString());
    return;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("loadLottieAnimation path: ");
    ((StringBuilder)localObject).append(this.a);
    QLog.e("ReadInJoyLottieDrawable", 2, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.ReadInJoyLottieDrawable.3.1.1
 * JD-Core Version:    0.7.0.1
 */