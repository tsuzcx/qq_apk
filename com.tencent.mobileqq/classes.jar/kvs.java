import android.content.Context;
import com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;

public class kvs
  implements Runnable
{
  public kvs(VideoCoverView paramVideoCoverView, Context paramContext) {}
  
  public void run()
  {
    try
    {
      TVK_SDKMgr.installPlugin(this.jdField_a_of_type_AndroidContentContext, new kvt(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("VideoCoverView", 2, "installSDK t==" + localThrowable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kvs
 * JD-Core Version:    0.7.0.1
 */