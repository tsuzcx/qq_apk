package com.tencent.mobileqq.kandian.biz.ugc.editvideo;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class PublishVideoHelper$1$1
  implements Runnable
{
  PublishVideoHelper$1$1(PublishVideoHelper.1 param1, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.a)
    {
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
      int i;
      if (this.a == 0) {
        i = 2;
      } else {
        i = 1;
      }
      String str;
      if (this.a == 0) {
        str = "视频上传成功";
      } else {
        str = "视频上传失败";
      }
      QQToast.makeText(localBaseApplicationImpl, i, str, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.editvideo.PublishVideoHelper.1.1
 * JD-Core Version:    0.7.0.1
 */