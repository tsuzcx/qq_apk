import android.media.AudioManager;
import android.os.Handler;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment;
import com.tencent.qphone.base.util.QLog;

public class kup
  implements Runnable
{
  public kup(VideoCoverFragment paramVideoCoverFragment, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (VideoCoverFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment) == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!VideoCoverFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment)) {
            break;
          }
          VideoCoverFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment).setStreamVolume(3, this.jdField_a_of_type_Int, 0);
        } while (!QLog.isColorLevel());
        QLog.d("VideoCoverFragment", 2, "is broken by user click");
        return;
        if (!PublicAccountAdvertisementActivity.a) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("VideoCoverFragment", 2, "is broken by user slip");
      return;
      int i = VideoCoverFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment).getStreamVolume(3);
      if (QLog.isColorLevel()) {
        QLog.d("VideoCoverFragment", 2, "change volume is " + i);
      }
      if (i < this.jdField_a_of_type_Int)
      {
        VideoCoverFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment).adjustStreamVolume(3, 1, 0);
        VideoCoverFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment).postDelayed(this, this.b);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoCoverFragment", 2, "smoothAdjustVolume() mTargetMusicVolume = " + this.jdField_a_of_type_Int + ", SET mIsSmoothRaiseFinished = true, FINISHED");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kup
 * JD-Core Version:    0.7.0.1
 */