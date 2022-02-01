package com.tencent.mobileqq.emotionintegrate;

import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.qphone.base.util.QLog;

class EmotionDownGIFCallback$1
  implements Runnable
{
  EmotionDownGIFCallback$1(EmotionDownGIFCallback paramEmotionDownGIFCallback, DownCallBack.DownResult paramDownResult) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionDownGIFCallback", 1, "onDownload");
    }
    Object localObject1 = this.a;
    if ((localObject1 != null) && (((DownCallBack.DownResult)localObject1).e != null))
    {
      localObject1 = new PicResult();
      ((PicResult)localObject1).a = this.a.a;
      Object localObject2 = this.a;
      ((PicResult)localObject1).d = localObject2;
      ((PicResult)localObject1).e = ((DownCallBack.DownResult)localObject2).j;
      if (this.a.a != 0)
      {
        if (this.a.d == null)
        {
          localObject2 = new PicInfoInterface.ErrInfo();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.a.b);
          localStringBuilder.append("_");
          localStringBuilder.append(this.a.c);
          ((PicInfoInterface.ErrInfo)localObject2).b = localStringBuilder.toString();
          ((PicInfoInterface.ErrInfo)localObject2).a = "onDownload";
          this.a.d = ((PicInfoInterface.ErrInfo)localObject2);
        }
        ((PicResult)localObject1).b = this.a.d;
      }
      this.this$0.a(this.a.a, (PicResult)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.1
 * JD-Core Version:    0.7.0.1
 */