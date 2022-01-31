import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager.VideoPlayParam;
import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;
import java.util.TimerTask;
import mqq.os.MqqHandler;

class mpp
  extends TimerTask
{
  mpp(mpo parammpo, WeakReference paramWeakReference1, WeakReference paramWeakReference2) {}
  
  public void run()
  {
    VideoPlayerWrapper localVideoPlayerWrapper = (VideoPlayerWrapper)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    FastWebVideoFeedsPlayManager.VideoPlayParam localVideoPlayParam = (FastWebVideoFeedsPlayManager.VideoPlayParam)this.b.get();
    if ((localVideoPlayerWrapper != null) && (localVideoPlayerWrapper.a()) && (!FastWebVideoFeedsPlayManager.d(this.jdField_a_of_type_Mpo.a)))
    {
      long l1 = localVideoPlayerWrapper.a();
      long l2 = localVideoPlayerWrapper.b();
      long l3 = localVideoPlayerWrapper.b();
      ThreadManager.getUIHandler().post(new mpq(this, localVideoPlayParam, l3, l1, l2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mpp
 * JD-Core Version:    0.7.0.1
 */