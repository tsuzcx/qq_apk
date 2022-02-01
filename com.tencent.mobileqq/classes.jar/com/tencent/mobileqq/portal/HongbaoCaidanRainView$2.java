package com.tencent.mobileqq.portal;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class HongbaoCaidanRainView$2
  implements Runnable
{
  HongbaoCaidanRainView$2(HongbaoCaidanRainView paramHongbaoCaidanRainView, Bitmap[] paramArrayOfBitmap) {}
  
  public void run()
  {
    HongbaoCaidanRainView.a(this.this$0).clear();
    Object localObject1 = this.a;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("start(), bitmap =");
        localStringBuilder.append(localObject2);
        QLog.d("HongbaoCaidanRainView", 2, localStringBuilder.toString());
      }
      HongbaoCaidanRainView.a(this.this$0).add(localObject2);
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("start(), mBitmapList.size() =");
      ((StringBuilder)localObject1).append(HongbaoCaidanRainView.a(this.this$0).size());
      QLog.d("HongbaoCaidanRainView", 2, ((StringBuilder)localObject1).toString());
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
 * Qualified Name:     com.tencent.mobileqq.portal.HongbaoCaidanRainView.2
 * JD-Core Version:    0.7.0.1
 */