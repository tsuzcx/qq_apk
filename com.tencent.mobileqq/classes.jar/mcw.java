import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.SeekBar;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAppJumpManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class mcw
  extends Handler
{
  public mcw(VideoFeedsPlayManager paramVideoFeedsPlayManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case -1: 
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "mUiHandler.postDelayed() innerChangePlayButton(SHOW_LOADING_BTN) mIsNeedShowLoading = " + VideoFeedsPlayManager.b(this.a));
        }
      } while (!VideoFeedsPlayManager.b(this.a));
      this.a.b(1);
      return;
    }
    Object localObject = new WeakReference(VideoFeedsPlayManager.a(this.a));
    paramMessage = new WeakReference(VideoFeedsPlayManager.a(this.a));
    long l1 = VideoFeedsPlayManager.a(this.a).b();
    int i;
    long l2;
    long l3;
    if (l1 >= 30000L)
    {
      i = 500;
      localObject = (VideoPlayerWrapper)((WeakReference)localObject).get();
      paramMessage = (VideoFeedsPlayManager.VideoPlayParam)paramMessage.get();
      if ((localObject != null) && (((VideoPlayerWrapper)localObject).a()) && (!VideoFeedsPlayManager.c(this.a)))
      {
        l1 = ((VideoPlayerWrapper)localObject).a();
        l2 = ((VideoPlayerWrapper)localObject).b();
        l3 = ((VideoPlayerWrapper)localObject).b();
        if ((paramMessage != null) && (paramMessage.jdField_a_of_type_AndroidWidgetSeekBar != null) && (paramMessage.jdField_a_of_type_AndroidWidgetTextView != null) && (paramMessage.c != null))
        {
          if (l3 != 0L) {
            break label375;
          }
          paramMessage.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
          paramMessage.b.setProgress(0);
        }
      }
    }
    for (;;)
    {
      if (l2 > 0L) {
        VideoFeedsHelper.a(paramMessage.c, l2);
      }
      if ((VideoFeedsPlayManager.a(this.a) != null) && (paramMessage != null)) {
        VideoFeedsPlayManager.a(this.a).a(0, paramMessage.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, ((VideoPlayerWrapper)localObject).a(false), l3);
      }
      if ((VideoFeedsPlayManager.a(this.a) != null) && (paramMessage != null)) {
        VideoFeedsPlayManager.a(this.a).a(l1 / 1000L);
      }
      VideoFeedsPlayManager.a(this.a).sendEmptyMessageDelayed(-2, i);
      return;
      if ((l1 >= 10000L) && (l1 <= 30000L))
      {
        i = 200;
        break;
      }
      i = 100;
      break;
      label375:
      if (l1 != 0L)
      {
        paramMessage.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)((float)l1 * 100.0F / (float)l3 + 0.5D));
        paramMessage.b.setProgress((int)((float)l1 * 100.0F / (float)l3 + 0.5D));
        VideoFeedsHelper.a(paramMessage.jdField_a_of_type_AndroidWidgetTextView, l1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mcw
 * JD-Core Version:    0.7.0.1
 */