package dov.com.qq.im.cropvideo;

import android.os.Handler;
import android.os.Message;

class CropVideoActivity$6
  implements Runnable
{
  CropVideoActivity$6(CropVideoActivity paramCropVideoActivity) {}
  
  public void run()
  {
    CropVideoActivity.a(this.this$0, CropVideoActivity.g(this.this$0) + 10);
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.arg1 = CropVideoActivity.g(this.this$0);
    this.this$0.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.cropvideo.CropVideoActivity.6
 * JD-Core Version:    0.7.0.1
 */