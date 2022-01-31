import android.media.AudioManager;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment;
import com.tencent.qphone.base.util.QLog;

public class ktt
  implements Runnable
{
  public ktt(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("volumeTrace", 2, ",music system is thread " + PublicAccountAdvertisementActivity.a(this.a).a);
    }
    PublicAccountAdvertisementActivity.a(this.a).setStreamVolume(3, PublicAccountAdvertisementActivity.a(this.a).a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ktt
 * JD-Core Version:    0.7.0.1
 */