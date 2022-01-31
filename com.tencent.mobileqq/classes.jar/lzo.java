import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.VideoUploadController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class lzo
  implements Runnable
{
  public lzo(VideoUploadController paramVideoUploadController) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(VideoUploadController.a(this.a))) && (!TextUtils.isEmpty(VideoUploadController.b(this.a))) && (!VideoUploadController.a(this.a).equals(VideoUploadController.b(this.a))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoUploadController", 2, "clearTempFile(video), origin:" + VideoUploadController.a(this.a) + ", compress:" + VideoUploadController.b(this.a));
      }
      File localFile = new File(VideoUploadController.b(this.a));
      if (localFile.exists()) {
        localFile.delete();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lzo
 * JD-Core Version:    0.7.0.1
 */