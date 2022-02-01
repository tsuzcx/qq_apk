package dov.com.qq.im.capture.music.humrecognition.view;

import biti;
import bonr;
import bpbh;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class BgmRecognitionProviderView$2
  implements Runnable
{
  BgmRecognitionProviderView$2(BgmRecognitionProviderView paramBgmRecognitionProviderView) {}
  
  public void run()
  {
    if (BgmRecognitionProviderView.a(this.this$0) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BgmRecognitionProviderView", 2, "run: invoked. info: mRecognitionPart = " + BgmRecognitionProviderView.a(this.this$0));
      }
      return;
    }
    File localFile = BgmRecognitionProviderView.a(this.this$0).a();
    if ((localFile != null) && (localFile.exists()))
    {
      BgmRecognitionProviderView.a(this.this$0).a(localFile);
      BgmRecognitionProviderView.a(this.this$0).a();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("BgmRecognitionProviderView", 2, "run: invoked. info: Failed to get audioFile. audioFile = " + localFile);
    }
    biti.a().a(2131697512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.music.humrecognition.view.BgmRecognitionProviderView.2
 * JD-Core Version:    0.7.0.1
 */