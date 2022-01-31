import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.SeekBar;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAppJumpManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayProgressListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class mea
  extends Handler
{
  public mea(VideoFeedsPlayManager paramVideoFeedsPlayManager, Looper paramLooper)
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
    paramMessage = new WeakReference(VideoFeedsPlayManager.a(this.a));
    Object localObject = new WeakReference(VideoFeedsPlayManager.a(this.a));
    int i;
    long l1;
    long l3;
    label248:
    float f;
    if (VideoFeedsPlayManager.a(this.a).b() >= 30000L)
    {
      i = 500;
      paramMessage = (VideoPlayerWrapper)paramMessage.get();
      localObject = (VideoFeedsPlayManager.VideoPlayParam)((WeakReference)localObject).get();
      if ((paramMessage != null) && (paramMessage.a()) && (!VideoFeedsPlayManager.c(this.a)))
      {
        l1 = paramMessage.a();
        long l2 = paramMessage.b();
        l3 = paramMessage.b();
        if ((localObject != null) && (((VideoFeedsPlayManager.VideoPlayParam)localObject).jdField_a_of_type_AndroidWidgetSeekBar != null) && (((VideoFeedsPlayManager.VideoPlayParam)localObject).jdField_a_of_type_AndroidWidgetTextView != null) && (((VideoFeedsPlayManager.VideoPlayParam)localObject).c != null))
        {
          if (l3 != 0L) {
            break label407;
          }
          ((VideoFeedsPlayManager.VideoPlayParam)localObject).jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
          ((VideoFeedsPlayManager.VideoPlayParam)localObject).b.setProgress(0);
          if (l2 > 0L) {
            VideoFeedsHelper.a(((VideoFeedsPlayManager.VideoPlayParam)localObject).c, l2);
          }
        }
        if ((VideoFeedsPlayManager.a(this.a) != null) && (localObject != null)) {
          VideoFeedsPlayManager.a(this.a).a(0, ((VideoFeedsPlayManager.VideoPlayParam)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo, paramMessage.a(false), l3);
        }
        if ((VideoFeedsPlayManager.a(this.a) != null) && (localObject != null)) {
          VideoFeedsPlayManager.a(this.a).a((float)l1 / 1000.0F);
        }
        f = (float)l1 * 100.0F / (float)l3;
        if (f <= 95.0F) {
          break label487;
        }
        VideoFeedsPlayManager.c(this.a, true);
      }
    }
    for (;;)
    {
      if (VideoFeedsPlayManager.a(this.a) != null) {
        VideoFeedsPlayManager.a(this.a).a(l1);
      }
      VideoFeedsPlayManager.a(this.a).sendEmptyMessageDelayed(-2, i);
      return;
      i = 100;
      break;
      label407:
      if (l1 == 0L) {
        break label248;
      }
      int j = (int)((float)l1 * 100.0F / (float)l3 + 0.5D);
      if (j + 1 >= 100) {
        j = 100;
      }
      for (;;)
      {
        ((VideoFeedsPlayManager.VideoPlayParam)localObject).jdField_a_of_type_AndroidWidgetSeekBar.setProgress(j);
        ((VideoFeedsPlayManager.VideoPlayParam)localObject).b.setProgress(j);
        VideoFeedsHelper.a(((VideoFeedsPlayManager.VideoPlayParam)localObject).jdField_a_of_type_AndroidWidgetTextView, l1);
        break;
        j += 1;
      }
      label487:
      if ((f < 5.0F) && (VideoFeedsPlayManager.d(this.a)))
      {
        VideoFeedsPlayManager.c(this.a, false);
        localObject = new mel(this.a, null);
        ((mel)localObject).a = paramMessage.a(true);
        ((mel)localObject).b = paramMessage.b();
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "mPlayInfoListForReport add detailInfo.totalPlayTime = " + ((mel)localObject).a + ", detailInfo.currentPlayTime = " + ((mel)localObject).b);
        }
        VideoFeedsPlayManager.b(this.a).add(localObject);
        paramMessage.i();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mea
 * JD-Core Version:    0.7.0.1
 */