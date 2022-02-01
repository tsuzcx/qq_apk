import android.os.Handler;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.3;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.4;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class sko
  extends sfi
{
  private sko(VideoFeedsPlayManager paramVideoFeedsPlayManager) {}
  
  private void a()
  {
    skq localskq = VideoFeedsPlayManager.b(this.a);
    if ((VideoFeedsPlayManager.a(this.a) != null) && (localskq != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "预播放任务 onDownloadFinish title = " + localskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_JavaLangString);
      }
      int i = localskq.b;
      VideoFeedsPlayManager.a(this.a).a(i);
      VideoFeedsPlayManager.a(this.a, i);
    }
  }
  
  private void a(Object paramObject)
  {
    if ((VideoFeedsPlayManager.a(this.a) != null) && (VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Rqa != null)) {
      set.a.a(paramObject, VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Rqa);
    }
  }
  
  private void b()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onPrePlayFinished() vid=");
      if (VideoFeedsPlayManager.b(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) {
        break label97;
      }
    }
    label97:
    for (Object localObject = VideoFeedsPlayManager.b(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;; localObject = null)
    {
      QLog.d("VideoFeedsPlayManager.preplay", 2, (String)localObject);
      localObject = VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.b(this.a));
      if (localObject != null) {
        ((spn)localObject).j();
      }
      if (stw.a.a()) {
        a();
      }
      return;
    }
  }
  
  private void b(Object paramObject)
  {
    if ((VideoFeedsPlayManager.a(this.a) != null) && (VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Rqa != null)) {
      VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Rqa.t = ((Long)paramObject).intValue();
    }
  }
  
  private void b(skq paramskq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_START_BUFFERING");
    }
    if ((paramskq != null) && (paramskq.jdField_a_of_type_Sfg != null)) {
      paramskq.jdField_a_of_type_Sfg.g(paramskq);
    }
    if ((paramskq != null) && (VideoFeedsPlayManager.a(this.a) != null))
    {
      Iterator localIterator = VideoFeedsPlayManager.a(this.a).iterator();
      while (localIterator.hasNext()) {
        ((sks)localIterator.next()).f(VideoFeedsPlayManager.a(this.a));
      }
    }
    if ((paramskq != null) && (paramskq.jdField_a_of_type_Rqa != null)) {
      paramskq.jdField_a_of_type_Rqa.e = SystemClock.uptimeMillis();
    }
    if ((VideoFeedsPlayManager.b(this.a) != null) && (VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Boolean))
    {
      paramskq = VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.b(this.a));
      if ((paramskq != null) && (!paramskq.d())) {
        VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Spn.j();
      }
    }
  }
  
  private void c(skq paramskq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_ENDOF_BUFFERING");
    }
    if ((paramskq != null) && (paramskq.jdField_a_of_type_Sfg != null)) {
      paramskq.jdField_a_of_type_Sfg.h(paramskq);
    }
    Object localObject;
    if ((paramskq != null) && (VideoFeedsPlayManager.a(this.a) != null))
    {
      localObject = VideoFeedsPlayManager.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((sks)((Iterator)localObject).next()).b(VideoFeedsPlayManager.a(this.a), this.a.f());
      }
    }
    if ((paramskq != null) && (paramskq.jdField_a_of_type_Rqa != null))
    {
      localObject = paramskq.jdField_a_of_type_Rqa;
      ((rqa)localObject).f += SystemClock.uptimeMillis() - paramskq.jdField_a_of_type_Rqa.e;
      paramskq = paramskq.jdField_a_of_type_Rqa;
      paramskq.jdField_c_of_type_Int += 1;
    }
    if ((VideoFeedsPlayManager.b(this.a) != null) && (VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Boolean))
    {
      paramskq = VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.b(this.a));
      if ((paramskq != null) && (!paramskq.d())) {
        VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Spn.k();
      }
    }
  }
  
  private void d(skq paramskq)
  {
    int i = 1;
    boolean bool;
    if ((paramskq != null) && (paramskq.jdField_a_of_type_Rqa != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_FIRST_VIDEO_FRAME_RENDERED");
      }
      if (paramskq.jdField_a_of_type_Sfg != null)
      {
        sfg localsfg = paramskq.jdField_a_of_type_Sfg;
        if (paramskq != VideoFeedsPlayManager.b(this.a)) {
          break label122;
        }
        bool = true;
        localsfg.a(paramskq, bool, VideoFeedsPlayManager.d(this.a));
      }
      if (paramskq.jdField_a_of_type_Rqa.jdField_b_of_type_Long <= 0L) {
        break label127;
      }
      label81:
      if (i == 0) {
        break label132;
      }
    }
    label132:
    for (paramskq.jdField_a_of_type_Rqa.v = (SystemClock.uptimeMillis() - paramskq.jdField_a_of_type_Rqa.jdField_b_of_type_Long);; paramskq.jdField_a_of_type_Rqa.v = 0L)
    {
      paramskq.jdField_a_of_type_Rqa.w = (SystemClock.uptimeMillis() - paramskq.jdField_a_of_type_Rqa.jdField_c_of_type_Long);
      return;
      label122:
      bool = false;
      break;
      label127:
      i = 0;
      break label81;
    }
  }
  
  public void a(skq paramskq)
  {
    if ((paramskq == null) || (paramskq.jdField_a_of_type_Rqa == null) || (paramskq.jdField_a_of_type_Rqa.jdField_d_of_type_Long != 0L)) {
      return;
    }
    paramskq.jdField_a_of_type_Rqa.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - paramskq.jdField_a_of_type_Rqa.jdField_b_of_type_Long);
    Object localObject = paramskq.jdField_a_of_type_Rqa;
    ((rqa)localObject).f += paramskq.jdField_a_of_type_Rqa.jdField_d_of_type_Long;
    localObject = paramskq.jdField_a_of_type_Rqa;
    ((rqa)localObject).jdField_c_of_type_Int += 1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doReportOnVideoPrepared: vid=").append(paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString).append(", 预加载状态：").append(paramskq.jdField_a_of_type_Rqa.n).append(", 预下载命中：").append(VideoFeedsPlayManager.a(this.a, paramskq).jdField_b_of_type_Boolean).append(", 首帧耗时：").append(paramskq.jdField_a_of_type_Rqa.jdField_d_of_type_Long);
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, ((StringBuilder)localObject).toString());
    }
    ThreadManager.excute(new VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.3(this, paramskq), 16, null, true);
  }
  
  public void a(spn paramspn)
  {
    super.a(paramspn);
    VideoFeedsPlayManager.a(this.a).removeMessages(-2);
    VideoFeedsPlayManager.a(this.a).sendEmptyMessage(-2);
    if ((VideoFeedsPlayManager.a(this.a) != null) && (VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Spn == paramspn))
    {
      VideoFeedsPlayManager.a(this.a).jdField_a_of_type_AndroidViewView = paramspn.a();
      VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Sfg.b(VideoFeedsPlayManager.a(this.a), true);
    }
  }
  
  public void a(spn paramspn, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "onVideoPrepared(VideoPlayerWrapper player, Object tag) ");
    }
    if (!VideoFeedsPlayManager.a(this.a, paramspn))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "onVideoPrepared checkIsPlayerPlaying false");
      }
      if ((VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.b(this.a)) == paramspn) && (VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Boolean)) {
        b();
      }
    }
    do
    {
      return;
      paramObject = VideoFeedsPlayManager.a(this.a);
      if ((paramObject != null) && (QLog.isColorLevel())) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onVideoPrepared() vid=" + paramObject.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString + ", mIsOpenedVideo = " + VideoFeedsPlayManager.a(this.a));
      }
      if (VideoFeedsPlayManager.a(this.a)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoFeedsPlayManager.preplay", 2, "onVideoPrepared  return isOpenedVideo false");
    return;
    VideoFeedsPlayManager.a(this.a, false);
    a(paramObject);
    d(paramspn);
  }
  
  public void a(spn paramspn, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "onConnectQualityCallback json= " + paramString);
    }
    if (!VideoFeedsPlayManager.a(this.a, paramspn)) {
      if (paramspn == VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.b(this.a)))
      {
        VideoFeedsPlayManager.a(this.a, paramString);
        paramString = (String)localObject1;
        if (VideoFeedsPlayManager.b(this.a) != null) {
          paramString = VideoFeedsPlayManager.b(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        }
        if (paramString != null) {
          srq.a().a(paramspn, paramString.d, paramspn.d());
        }
      }
    }
    do
    {
      return;
      localObject1 = localObject2;
      if (VideoFeedsPlayManager.a(this.a) != null) {
        localObject1 = VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      }
      if (localObject1 != null) {
        srq.a().a(paramspn, ((VideoInfo)localObject1).d, paramspn.d());
      }
    } while ((VideoFeedsPlayManager.a(this.a) == null) || (VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Rqa == null));
    VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Rqa.g = paramString;
  }
  
  public boolean a(spn paramspn, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    Object localObject = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null) {}
    for (paramObject = paramObject.toString();; paramObject = "")
    {
      paramObject = paramObject;
      if (VideoFeedsPlayManager.a(this.a, paramspn)) {
        break;
      }
      if ((VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.b(this.a)) == paramspn) && (paramspn != null))
      {
        paramspn.j();
        VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Boolean = false;
      }
      return false;
    }
    paramspn = VideoFeedsPlayManager.a(this.a);
    if ((paramspn != null) && (paramspn.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (QLog.isColorLevel())) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onError() " + paramObject + ", vid=" + paramspn.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
    }
    paramObject = ssq.a(paramInt1, paramInt2, paramInt3);
    if ((paramspn != null) && (paramspn.jdField_a_of_type_Sfg != null)) {
      paramspn.jdField_a_of_type_Sfg.a(paramspn, paramInt1, paramInt2, paramObject);
    }
    if (VideoFeedsPlayManager.a(this.a) != null)
    {
      localObject = VideoFeedsPlayManager.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((sks)((Iterator)localObject).next()).a(paramspn, paramInt1, paramInt2, paramObject);
      }
    }
    if ((paramspn != null) && (paramspn.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)) {
      uuc.a(paramspn.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, paramspn.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, 1, paramInt2);
    }
    if ((paramspn != null) && (paramspn.jdField_a_of_type_Rqa != null))
    {
      paramspn.jdField_a_of_type_Rqa.jdField_a_of_type_Boolean = false;
      paramspn.jdField_a_of_type_Rqa.jdField_c_of_type_JavaLangString = (paramInt1 + ":" + paramInt2);
      paramspn.jdField_a_of_type_Rqa.jdField_d_of_type_JavaLangString = paramString;
    }
    if ((VideoFeedsPlayManager.c(this.a)) && (VideoFeedsPlayManager.a(this.a) != null))
    {
      paramString = ois.a(VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      if (!uks.a(VideoFeedsPlayManager.a(this.a))) {
        break label534;
      }
    }
    label534:
    for (paramInt1 = 20;; paramInt1 = 0)
    {
      paramObject = ois.a(0, 0, 0, 0, paramInt1, 0, 0, 2, 2, 0, ReportConstants.VideoEndType.OTHER, true);
      ois.a(new ufy().a(VideoFeedsPlayManager.a(this.a)).a(6).b(paramspn.jdField_a_of_type_Rpz.g).a(paramString).a(VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a(paramObject).a());
      uks.a(VideoFeedsPlayManager.a(this.a));
      return false;
    }
  }
  
  public boolean a(spn paramspn, int paramInt, Object paramObject)
  {
    if ((!VideoFeedsPlayManager.a(this.a, paramInt)) && (!VideoFeedsPlayManager.a(this.a, paramspn))) {
      return false;
    }
    skq localskq2 = VideoFeedsPlayManager.a(this.a);
    skq localskq3 = VideoFeedsPlayManager.b(this.a);
    skq localskq1;
    if ((localskq2 != null) && (paramspn == localskq2.jdField_a_of_type_Spn)) {
      localskq1 = localskq2;
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        return false;
      case 105: 
        d(localskq1);
        return false;
        if (localskq3 != null)
        {
          localskq1 = localskq3;
          if (paramspn == localskq3.jdField_a_of_type_Spn) {}
        }
        else
        {
          localskq1 = null;
        }
        break;
      }
    }
    b(localskq2);
    return false;
    c(localskq2);
    return false;
    a(paramObject);
    return false;
    b(paramObject);
    return false;
  }
  
  public void b(spn paramspn)
  {
    if (!VideoFeedsPlayManager.a(this.a, paramspn)) {
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("播放状态回调 onCompletion() vid=");
      if (VideoFeedsPlayManager.a(this.a) == null) {
        break label134;
      }
    }
    label134:
    for (paramspn = VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;; paramspn = "param null")
    {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, paramspn);
      VideoFeedsPlayManager.a(this.a).post(new VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.4(this));
      paramspn = VideoFeedsPlayManager.a(this.a);
      if ((paramspn != null) && (paramspn.jdField_a_of_type_Rqa != null))
      {
        paramspn.jdField_a_of_type_Rqa.jdField_a_of_type_Boolean = true;
        paramspn.jdField_a_of_type_Rqa.jdField_b_of_type_Boolean = true;
      }
      VideoFeedsPlayManager.c(this.a, true);
      return;
    }
  }
  
  public void c(spn paramspn)
  {
    VideoFeedsPlayManager.a(this.a).sendEmptyMessageDelayed(-2, 500L);
  }
  
  public void d(spn paramspn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "startVideoAfterPrepared(VideoPlayerWrapper player) mIsActivityOnResume=" + VideoFeedsPlayManager.b(this.a));
    }
    VideoFeedsPlayManager.a(this.a).removeMessages(-3);
    if (VideoFeedsPlayManager.b(this.a))
    {
      this.a.a();
      return;
    }
    VideoFeedsPlayManager.b(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sko
 * JD-Core Version:    0.7.0.1
 */