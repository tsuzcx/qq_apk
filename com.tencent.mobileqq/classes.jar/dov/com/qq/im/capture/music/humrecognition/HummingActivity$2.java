package dov.com.qq.im.capture.music.humrecognition;

import android.os.Handler;
import avrs;
import bfnk;
import bjdz;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import java.io.File;

class HummingActivity$2
  implements Runnable
{
  HummingActivity$2(HummingActivity paramHummingActivity) {}
  
  public void run()
  {
    HummingActivity.a(this.this$0);
    if (HummingActivity.a(this.this$0)) {
      HummingActivity.a(this.this$0).sendEmptyMessage(4);
    }
    do
    {
      return;
      if (HummingActivity.b(this.this$0) >= 5)
      {
        HummingActivity.a(this.this$0).sendEmptyMessage(5);
        return;
      }
    } while (HummingActivity.a(this.this$0).a == null);
    File localFile = new File(HummingActivity.a(this.this$0).a.b());
    if (localFile.exists()) {
      HummingActivity.a(this.this$0).a(localFile);
    }
    HummingActivity.a(this.this$0).a();
    HummingActivity.a(this.this$0).postDelayed(this, 3000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.music.humrecognition.HummingActivity.2
 * JD-Core Version:    0.7.0.1
 */