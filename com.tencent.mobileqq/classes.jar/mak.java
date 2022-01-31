import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.ADVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.BaseItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.BaseVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.VideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsListView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsListView.ListViewEventListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Set;

public class mak
  extends Handler
{
  public mak(VideoFeedsAdapter paramVideoFeedsAdapter, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "mUIHandler handleMessage() msg.what = " + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
    }
    do
    {
      for (;;)
      {
        return;
        VideoFeedsAdapter.a(this.a).sendEmptyMessageDelayed(0, 3000L);
        if (VideoFeedsAdapter.a(this.a) != null)
        {
          if (VideoFeedsAdapter.a(this.a).a() > VideoFeedsAdapter.a(this.a).b()) {}
          for (long l = VideoFeedsAdapter.a(this.a).a();; l = VideoFeedsAdapter.a(this.a).b())
          {
            l = 3000L - (System.currentTimeMillis() - l);
            if (l <= 0L) {
              break;
            }
            VideoFeedsAdapter.a(this.a).removeMessages(0);
            VideoFeedsAdapter.a(this.a).sendEmptyMessageDelayed(0, l);
            return;
          }
          VideoFeedsAdapter.a(this.a);
          return;
          VideoFeedsAdapter.a(this.a).a(VideoFeedsAdapter.a(this.a).a, false);
          if ((VideoFeedsAdapter.a(this.a) != null) && (VideoFeedsAdapter.a(this.a).size() > 1))
          {
            VideoFeedsAdapter.a(this.a).a(VideoFeedsAdapter.a(this.a).b, VideoFeedsAdapter.a(this.a));
            return;
            if (VideoFeedsAdapter.b(this.a))
            {
              VideoFeedsAdapter.a(this.a).sendEmptyMessage(3);
              VideoFeedsAdapter.a(this.a).sendEmptyMessageDelayed(2, 50L);
            }
            VideoFeedsAdapter.a(this.a).a();
            return;
            VideoFeedsAdapter.a(this.a).d();
            return;
            if ((VideoFeedsAdapter.a(this.a) instanceof VideoFeedsAdapter.VideoItemHolder))
            {
              paramMessage = (VideoFeedsAdapter.VideoItemHolder)VideoFeedsAdapter.a(this.a);
              if ((paramMessage.a != null) && (paramMessage.a.a != null) && (paramMessage.a.a.c) && (paramMessage.a.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
              {
                localObject = paramMessage.a.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.h;
                if (!VideoFeedsAdapter.a(this.a).contains(localObject))
                {
                  VideoFeedsAdapter.a(this.a).add(localObject);
                  localObject = NativeAdUtils.a(paramMessage.a.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
                  if (paramMessage.a.a.a(VideoFeedsAdapter.a(this.a)))
                  {
                    NativeAdUtils.a(null, VideoFeedsAdapter.a(this.a), NativeAdUtils.b, NativeAdUtils.n, (AdvertisementInfo)localObject, paramMessage.a.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo, 0L);
                    return;
                  }
                  NativeAdUtils.a(null, VideoFeedsAdapter.a(this.a), NativeAdUtils.b, NativeAdUtils.m, (AdvertisementInfo)localObject, paramMessage.a.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo, 0L);
                  return;
                  paramMessage = (String)paramMessage.obj;
                  if (!TextUtils.isEmpty(paramMessage))
                  {
                    int j = VideoFeedsAdapter.a(this.a).getChildCount();
                    int i = 0;
                    while (i < j)
                    {
                      localObject = VideoFeedsAdapter.a(this.a).getChildAt(i).getTag();
                      if ((localObject instanceof VideoFeedsAdapter.BaseItemHolder))
                      {
                        int k = ((VideoFeedsAdapter.BaseItemHolder)localObject).b;
                        VideoInfo localVideoInfo = (VideoInfo)this.a.getItem(k);
                        if ((localVideoInfo != null) && (paramMessage.equals(localVideoInfo.jdField_a_of_type_JavaLangString)))
                        {
                          VideoFeedsAdapter.a(this.a).c();
                          this.a.a.a(localObject);
                          return;
                        }
                      }
                      i += 1;
                    }
                  }
                }
              }
            }
          }
        }
      }
    } while ((VideoFeedsAdapter.a(this.a) == null) || (VideoFeedsAdapter.a(this.a) == null) || (!VideoFeedsAdapter.a(this.a).c()) || (!(VideoFeedsAdapter.a(this.a) instanceof VideoFeedsAdapter.ADVideoItemHolder)));
    paramMessage = (VideoFeedsAdapter.ADVideoItemHolder)VideoFeedsAdapter.a(this.a);
    paramMessage.d.setVisibility(0);
    paramMessage.d.getParent().requestDisallowInterceptTouchEvent(true);
    if ((VideoFeedsAdapter.a(this.a).a != null) && (VideoFeedsAdapter.a(this.a).a.a != null) && (VideoFeedsAdapter.a(this.a) != null))
    {
      paramMessage.d.setText(VideoFeedsAdapter.a(this.a, VideoFeedsAdapter.a(this.a).a.a, VideoFeedsAdapter.a(this.a).getResources()));
      paramMessage.d.setOnClickListener(this.a);
      paramMessage.d.setTag(VideoFeedsAdapter.a(this.a));
    }
    Object localObject = new AlphaAnimation(0.0F, 1.0F);
    ((Animation)localObject).setDuration(300L);
    ((Animation)localObject).setFillAfter(false);
    paramMessage.d.startAnimation((Animation)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mak
 * JD-Core Version:    0.7.0.1
 */