import android.os.Handler;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.3;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.4;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class rym
  extends rst
{
  private rym(VideoFeedsPlayManager paramVideoFeedsPlayManager) {}
  
  private void a()
  {
    ryo localryo = VideoFeedsPlayManager.b(this.a);
    if ((VideoFeedsPlayManager.a(this.a) != null) && (localryo != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "预播放任务 onDownloadFinish title = " + localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_JavaLangString);
      }
      int i = localryo.b;
      VideoFeedsPlayManager.a(this.a).a(i);
      VideoFeedsPlayManager.a(this.a, i);
    }
  }
  
  private void a(Object paramObject)
  {
    if ((VideoFeedsPlayManager.a(this.a) != null) && (VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Rdt != null)) {
      rse.a.a(paramObject, VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Rdt);
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
        ((sdj)localObject).j();
      }
      if (shg.a.a()) {
        a();
      }
      return;
    }
  }
  
  private void b(Object paramObject)
  {
    if ((VideoFeedsPlayManager.a(this.a) != null) && (VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Rdt != null)) {
      VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Rdt.t = ((Long)paramObject).intValue();
    }
  }
  
  private void b(ryo paramryo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_START_BUFFERING");
    }
    if ((paramryo != null) && (paramryo.jdField_a_of_type_Rsr != null)) {
      paramryo.jdField_a_of_type_Rsr.g(paramryo);
    }
    if ((paramryo != null) && (VideoFeedsPlayManager.a(this.a) != null))
    {
      Iterator localIterator = VideoFeedsPlayManager.a(this.a).iterator();
      while (localIterator.hasNext()) {
        ((ryq)localIterator.next()).f(VideoFeedsPlayManager.a(this.a));
      }
    }
    if ((paramryo != null) && (paramryo.jdField_a_of_type_Rdt != null)) {
      paramryo.jdField_a_of_type_Rdt.e = SystemClock.uptimeMillis();
    }
    if ((VideoFeedsPlayManager.b(this.a) != null) && (VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Boolean))
    {
      paramryo = VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.b(this.a));
      if ((paramryo != null) && (!paramryo.d())) {
        VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Sdj.j();
      }
    }
  }
  
  private void c(ryo paramryo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_ENDOF_BUFFERING");
    }
    if ((paramryo != null) && (paramryo.jdField_a_of_type_Rsr != null)) {
      paramryo.jdField_a_of_type_Rsr.h(paramryo);
    }
    Object localObject;
    if ((paramryo != null) && (VideoFeedsPlayManager.a(this.a) != null))
    {
      localObject = VideoFeedsPlayManager.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ryq)((Iterator)localObject).next()).b(VideoFeedsPlayManager.a(this.a), this.a.f());
      }
    }
    if ((paramryo != null) && (paramryo.jdField_a_of_type_Rdt != null))
    {
      localObject = paramryo.jdField_a_of_type_Rdt;
      ((rdt)localObject).f += SystemClock.uptimeMillis() - paramryo.jdField_a_of_type_Rdt.e;
      paramryo = paramryo.jdField_a_of_type_Rdt;
      paramryo.jdField_c_of_type_Int += 1;
    }
    if ((VideoFeedsPlayManager.b(this.a) != null) && (VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Boolean))
    {
      paramryo = VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.b(this.a));
      if ((paramryo != null) && (!paramryo.d())) {
        VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Sdj.k();
      }
    }
  }
  
  private void d(ryo paramryo)
  {
    int i = 1;
    boolean bool;
    if ((paramryo != null) && (paramryo.jdField_a_of_type_Rdt != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_FIRST_VIDEO_FRAME_RENDERED");
      }
      if (paramryo.jdField_a_of_type_Rsr != null)
      {
        rsr localrsr = paramryo.jdField_a_of_type_Rsr;
        if (paramryo != VideoFeedsPlayManager.b(this.a)) {
          break label122;
        }
        bool = true;
        localrsr.a(paramryo, bool, VideoFeedsPlayManager.d(this.a));
      }
      if (paramryo.jdField_a_of_type_Rdt.jdField_b_of_type_Long <= 0L) {
        break label127;
      }
      label81:
      if (i == 0) {
        break label132;
      }
    }
    label132:
    for (paramryo.jdField_a_of_type_Rdt.v = (SystemClock.uptimeMillis() - paramryo.jdField_a_of_type_Rdt.jdField_b_of_type_Long);; paramryo.jdField_a_of_type_Rdt.v = 0L)
    {
      paramryo.jdField_a_of_type_Rdt.w = (SystemClock.uptimeMillis() - paramryo.jdField_a_of_type_Rdt.jdField_c_of_type_Long);
      return;
      label122:
      bool = false;
      break;
      label127:
      i = 0;
      break label81;
    }
  }
  
  public void a(ryo paramryo)
  {
    if ((paramryo == null) || (paramryo.jdField_a_of_type_Rdt == null) || (paramryo.jdField_a_of_type_Rdt.jdField_d_of_type_Long != 0L)) {
      return;
    }
    paramryo.jdField_a_of_type_Rdt.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - paramryo.jdField_a_of_type_Rdt.jdField_b_of_type_Long);
    Object localObject = paramryo.jdField_a_of_type_Rdt;
    ((rdt)localObject).f += paramryo.jdField_a_of_type_Rdt.jdField_d_of_type_Long;
    localObject = paramryo.jdField_a_of_type_Rdt;
    ((rdt)localObject).jdField_c_of_type_Int += 1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doReportOnVideoPrepared: vid=").append(paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString).append(", 预加载状态：").append(paramryo.jdField_a_of_type_Rdt.n).append(", 预下载命中：").append(VideoFeedsPlayManager.a(this.a, paramryo).jdField_b_of_type_Boolean).append(", 首帧耗时：").append(paramryo.jdField_a_of_type_Rdt.jdField_d_of_type_Long);
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, ((StringBuilder)localObject).toString());
    }
    ThreadManager.excute(new VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.3(this, paramryo), 16, null, true);
  }
  
  public void a(sdj paramsdj)
  {
    super.a(paramsdj);
    VideoFeedsPlayManager.a(this.a).removeMessages(-2);
    VideoFeedsPlayManager.a(this.a).sendEmptyMessage(-2);
    if ((VideoFeedsPlayManager.a(this.a) != null) && (VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Sdj == paramsdj))
    {
      VideoFeedsPlayManager.a(this.a).jdField_a_of_type_AndroidViewView = paramsdj.a();
      VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Rsr.b(VideoFeedsPlayManager.a(this.a), true);
    }
  }
  
  public void a(sdj paramsdj, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "onVideoPrepared(VideoPlayerWrapper player, Object tag) ");
    }
    if (!VideoFeedsPlayManager.a(this.a, paramsdj))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "onVideoPrepared checkIsPlayerPlaying false");
      }
      if ((VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.b(this.a)) == paramsdj) && (VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Boolean)) {
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
    d(paramsdj);
  }
  
  public void a(sdj paramsdj, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "onConnectQualityCallback json= " + paramString);
    }
    if (!VideoFeedsPlayManager.a(this.a, paramsdj)) {
      if (paramsdj == VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.b(this.a)))
      {
        VideoFeedsPlayManager.a(this.a, paramString);
        paramString = (String)localObject1;
        if (VideoFeedsPlayManager.b(this.a) != null) {
          paramString = VideoFeedsPlayManager.b(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        }
        if (paramString != null) {
          sfl.a().a(paramsdj, paramString.d, paramsdj.d());
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
        sfl.a().a(paramsdj, ((VideoInfo)localObject1).d, paramsdj.d());
      }
    } while ((VideoFeedsPlayManager.a(this.a) == null) || (VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Rdt == null));
    VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Rdt.g = paramString;
  }
  
  public boolean a(sdj paramsdj, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    Object localObject = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null) {}
    for (paramObject = paramObject.toString();; paramObject = "")
    {
      paramObject = paramObject;
      if (VideoFeedsPlayManager.a(this.a, paramsdj)) {
        break;
      }
      if ((VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.b(this.a)) == paramsdj) && (paramsdj != null))
      {
        paramsdj.j();
        VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Boolean = false;
      }
      return false;
    }
    paramsdj = VideoFeedsPlayManager.a(this.a);
    if ((paramsdj != null) && (paramsdj.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (QLog.isColorLevel())) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onError() " + paramObject + ", vid=" + paramsdj.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
    }
    paramObject = sgl.a(paramInt1, paramInt2, paramInt3);
    if ((paramsdj != null) && (paramsdj.jdField_a_of_type_Rsr != null)) {
      paramsdj.jdField_a_of_type_Rsr.a(paramsdj, paramInt1, paramInt2, paramObject);
    }
    if (VideoFeedsPlayManager.a(this.a) != null)
    {
      localObject = VideoFeedsPlayManager.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ryq)((Iterator)localObject).next()).a(paramsdj, paramInt1, paramInt2, paramObject);
      }
    }
    if ((paramsdj != null) && (paramsdj.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)) {
      ugf.a(paramsdj.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, paramsdj.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, 1, paramInt2);
    }
    if ((paramsdj != null) && (paramsdj.jdField_a_of_type_Rdt != null))
    {
      paramsdj.jdField_a_of_type_Rdt.jdField_a_of_type_Boolean = false;
      paramsdj.jdField_a_of_type_Rdt.jdField_c_of_type_JavaLangString = (paramInt1 + ":" + paramInt2);
      paramsdj.jdField_a_of_type_Rdt.jdField_d_of_type_JavaLangString = paramString;
    }
    if ((VideoFeedsPlayManager.c(this.a)) && (VideoFeedsPlayManager.a(this.a) != null))
    {
      paramString = obb.a(VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      if (!twr.a(VideoFeedsPlayManager.a(this.a))) {
        break label532;
      }
    }
    label532:
    for (paramInt1 = 20;; paramInt1 = 0)
    {
      paramObject = obb.a(0, 0, 0, 0, paramInt1, 0, 0, obb.aP, 2);
      obb.a(new trn().a(VideoFeedsPlayManager.a(this.a)).a(obb.f).b(paramsdj.jdField_a_of_type_Rds.g).a(paramString).a(VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a(paramObject).a());
      twr.a(VideoFeedsPlayManager.a(this.a));
      return false;
    }
  }
  
  public boolean a(sdj paramsdj, int paramInt, Object paramObject)
  {
    if ((!VideoFeedsPlayManager.a(this.a, paramInt)) && (!VideoFeedsPlayManager.a(this.a, paramsdj))) {
      return false;
    }
    ryo localryo2 = VideoFeedsPlayManager.a(this.a);
    ryo localryo3 = VideoFeedsPlayManager.b(this.a);
    ryo localryo1;
    if ((localryo2 != null) && (paramsdj == localryo2.jdField_a_of_type_Sdj)) {
      localryo1 = localryo2;
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        return false;
      case 105: 
        d(localryo1);
        return false;
        if (localryo3 != null)
        {
          localryo1 = localryo3;
          if (paramsdj == localryo3.jdField_a_of_type_Sdj) {}
        }
        else
        {
          localryo1 = null;
        }
        break;
      }
    }
    b(localryo2);
    return false;
    c(localryo2);
    return false;
    a(paramObject);
    return false;
    b(paramObject);
    return false;
  }
  
  public void b(sdj paramsdj)
  {
    if (!VideoFeedsPlayManager.a(this.a, paramsdj)) {
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
    for (paramsdj = VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;; paramsdj = "param null")
    {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, paramsdj);
      VideoFeedsPlayManager.a(this.a).post(new VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.4(this));
      paramsdj = VideoFeedsPlayManager.a(this.a);
      if ((paramsdj != null) && (paramsdj.jdField_a_of_type_Rdt != null))
      {
        paramsdj.jdField_a_of_type_Rdt.jdField_a_of_type_Boolean = true;
        paramsdj.jdField_a_of_type_Rdt.jdField_b_of_type_Boolean = true;
      }
      VideoFeedsPlayManager.c(this.a, true);
      return;
    }
  }
  
  public void c(sdj paramsdj)
  {
    VideoFeedsPlayManager.a(this.a).sendEmptyMessageDelayed(-2, 500L);
  }
  
  public void d(sdj paramsdj)
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
 * Qualified Name:     rym
 * JD-Core Version:    0.7.0.1
 */