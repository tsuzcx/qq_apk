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
import org.json.JSONObject;

public class rrk
  extends rlt
{
  private rrk(VideoFeedsPlayManager paramVideoFeedsPlayManager) {}
  
  private void a()
  {
    rrm localrrm = VideoFeedsPlayManager.b(this.a);
    if ((VideoFeedsPlayManager.a(this.a) != null) && (localrrm != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "预播放任务 onDownloadFinish title = " + VideoFeedsPlayManager.b(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_JavaLangString);
      }
      int i = localrrm.b;
      VideoFeedsPlayManager.a(this.a).a(i);
      VideoFeedsPlayManager.a(this.a, i);
    }
  }
  
  private void a(Object paramObject)
  {
    if ((VideoFeedsPlayManager.a(this.a) != null) && (VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Qwv != null)) {
      rle.a.a(paramObject, VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Qwv);
    }
  }
  
  private void a(rrm paramrrm, Object paramObject)
  {
    int j = 0;
    try
    {
      paramObject = new JSONObject((String)paramObject);
      i = paramObject.optInt("decoderMode", 0);
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        int k;
        label36:
        int i = 0;
      }
    }
    try
    {
      k = paramObject.optInt("skipFrameCount", 1);
      j = k;
    }
    catch (Exception paramObject)
    {
      break label36;
    }
    if ((paramrrm != null) && (paramrrm.jdField_a_of_type_Qwv != null))
    {
      if (j > 0)
      {
        paramObject = paramrrm.jdField_a_of_type_Qwv;
        paramObject.p += j;
      }
      paramObject = paramrrm.jdField_a_of_type_Qwv;
      paramObject.q += j;
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_SKIP_ONE_FRAME decoderMode = " + i + ", skipFrameCount = " + j + ", totalSkipCount = " + paramrrm.jdField_a_of_type_Qwv.p + ", finalSkipCount = " + paramrrm.jdField_a_of_type_Qwv.q);
      }
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "onPrePlayFinished() vid=" + VideoFeedsPlayManager.b(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
    }
    rwf localrwf = VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.b(this.a));
    if (localrwf != null) {
      localrwf.j();
    }
    if (sac.a.a()) {
      a();
    }
  }
  
  private void b(Object paramObject)
  {
    if ((VideoFeedsPlayManager.a(this.a) != null) && (VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Qwv != null)) {
      VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Qwv.t = ((Long)paramObject).intValue();
    }
  }
  
  private void b(rrm paramrrm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_START_BUFFERING");
    }
    if ((paramrrm != null) && (paramrrm.jdField_a_of_type_Rlr != null)) {
      paramrrm.jdField_a_of_type_Rlr.g(paramrrm);
    }
    if ((paramrrm != null) && (VideoFeedsPlayManager.a(this.a) != null))
    {
      Iterator localIterator = VideoFeedsPlayManager.a(this.a).iterator();
      while (localIterator.hasNext()) {
        ((rro)localIterator.next()).f(VideoFeedsPlayManager.a(this.a));
      }
    }
    if ((paramrrm != null) && (paramrrm.jdField_a_of_type_Qwv != null)) {
      paramrrm.jdField_a_of_type_Qwv.e = SystemClock.uptimeMillis();
    }
    if ((VideoFeedsPlayManager.b(this.a) != null) && (VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Boolean))
    {
      paramrrm = VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.b(this.a));
      if ((paramrrm != null) && (!paramrrm.d())) {
        VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Rwf.j();
      }
    }
  }
  
  private void b(rrm paramrrm, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_HW_DECODE_FAILED");
    }
    if ((paramrrm != null) && (paramrrm.jdField_a_of_type_Qwv != null))
    {
      paramrrm.jdField_a_of_type_Qwv.jdField_f_of_type_Boolean = true;
      if ((paramObject instanceof String)) {
        paramrrm.jdField_a_of_type_Qwv.jdField_f_of_type_JavaLangString = ((String)paramObject);
      }
    }
  }
  
  private void c(rrm paramrrm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_ENDOF_BUFFERING");
    }
    if ((paramrrm != null) && (paramrrm.jdField_a_of_type_Rlr != null)) {
      paramrrm.jdField_a_of_type_Rlr.h(paramrrm);
    }
    Object localObject;
    if ((paramrrm != null) && (VideoFeedsPlayManager.a(this.a) != null))
    {
      localObject = VideoFeedsPlayManager.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((rro)((Iterator)localObject).next()).b(VideoFeedsPlayManager.a(this.a), this.a.e());
      }
    }
    if ((paramrrm != null) && (paramrrm.jdField_a_of_type_Qwv != null))
    {
      localObject = paramrrm.jdField_a_of_type_Qwv;
      ((qwv)localObject).jdField_f_of_type_Long += SystemClock.uptimeMillis() - paramrrm.jdField_a_of_type_Qwv.e;
      paramrrm = paramrrm.jdField_a_of_type_Qwv;
      paramrrm.jdField_c_of_type_Int += 1;
    }
    if ((VideoFeedsPlayManager.b(this.a) != null) && (VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Boolean))
    {
      paramrrm = VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.b(this.a));
      if ((paramrrm != null) && (!paramrrm.d())) {
        VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Rwf.k();
      }
    }
  }
  
  private void c(rrm paramrrm, Object paramObject)
  {
    if (paramObject != null)
    {
      paramObject = ((String)paramObject).split(":", 2);
      if ((paramObject != null) && (paramObject.length == 2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "PERFORMANCE_REPORT method:" + paramObject[0] + "\ntimeJson:" + paramObject[1]);
        }
        if (("prepare".equals(paramObject[0])) && (paramrrm != null) && (paramrrm.jdField_a_of_type_Qwv != null)) {
          paramrrm.jdField_a_of_type_Qwv.l = paramObject[1];
        }
      }
    }
  }
  
  private void d(rrm paramrrm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_DECODER_BLOCK");
    }
    if ((paramrrm != null) && (paramrrm.jdField_a_of_type_Qwv != null))
    {
      paramrrm = paramrrm.jdField_a_of_type_Qwv;
      paramrrm.o += 1;
    }
  }
  
  private void e(rrm paramrrm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_CHANGE_HW_BACKUP_URL");
    }
    if ((paramrrm != null) && (paramrrm.jdField_a_of_type_Qwv != null)) {
      paramrrm.jdField_a_of_type_Qwv.jdField_g_of_type_Boolean = true;
    }
  }
  
  private void f(rrm paramrrm)
  {
    int i = 1;
    boolean bool;
    if ((paramrrm != null) && (paramrrm.jdField_a_of_type_Qwv != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_FIRST_VIDEO_FRAME_RENDERED");
      }
      if (paramrrm.jdField_a_of_type_Rlr != null)
      {
        rlr localrlr = paramrrm.jdField_a_of_type_Rlr;
        if (paramrrm != VideoFeedsPlayManager.b(this.a)) {
          break label123;
        }
        bool = true;
        localrlr.a(paramrrm, bool, VideoFeedsPlayManager.d(this.a));
      }
      if (paramrrm.jdField_a_of_type_Qwv.jdField_b_of_type_Long <= 0L) {
        break label128;
      }
      label82:
      if (i == 0) {
        break label133;
      }
    }
    label128:
    label133:
    for (paramrrm.jdField_a_of_type_Qwv.v = (SystemClock.uptimeMillis() - paramrrm.jdField_a_of_type_Qwv.jdField_b_of_type_Long);; paramrrm.jdField_a_of_type_Qwv.v = 0L)
    {
      paramrrm.jdField_a_of_type_Qwv.w = (SystemClock.uptimeMillis() - paramrrm.jdField_a_of_type_Qwv.jdField_c_of_type_Long);
      return;
      label123:
      bool = false;
      break;
      i = 0;
      break label82;
    }
  }
  
  public void a(rrm paramrrm)
  {
    if ((paramrrm == null) || (paramrrm.jdField_a_of_type_Qwv == null) || (paramrrm.jdField_a_of_type_Qwv.jdField_d_of_type_Long != 0L)) {
      return;
    }
    paramrrm.jdField_a_of_type_Qwv.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - paramrrm.jdField_a_of_type_Qwv.jdField_b_of_type_Long);
    Object localObject = paramrrm.jdField_a_of_type_Qwv;
    ((qwv)localObject).jdField_f_of_type_Long += paramrrm.jdField_a_of_type_Qwv.jdField_d_of_type_Long;
    localObject = paramrrm.jdField_a_of_type_Qwv;
    ((qwv)localObject).jdField_c_of_type_Int += 1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doReportOnVideoPrepared: vid=").append(paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString).append(", 预加载状态：").append(paramrrm.jdField_a_of_type_Qwv.n).append(", 预下载命中：").append(VideoFeedsPlayManager.a(this.a, paramrrm).jdField_b_of_type_Boolean).append(", 首帧耗时：").append(paramrrm.jdField_a_of_type_Qwv.jdField_d_of_type_Long);
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, ((StringBuilder)localObject).toString());
    }
    ThreadManager.excute(new VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.3(this, paramrrm), 16, null, true);
  }
  
  public void a(rwf paramrwf)
  {
    super.a(paramrwf);
    VideoFeedsPlayManager.a(this.a).removeMessages(-2);
    VideoFeedsPlayManager.a(this.a).sendEmptyMessage(-2);
    if ((VideoFeedsPlayManager.a(this.a) != null) && (VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Rwf == paramrwf))
    {
      VideoFeedsPlayManager.a(this.a).jdField_a_of_type_AndroidViewView = paramrwf.a();
      VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Rlr.b(VideoFeedsPlayManager.a(this.a), true);
    }
  }
  
  public void a(rwf paramrwf, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "onVideoPrepared(VideoPlayerWrapper player, Object tag) ");
    }
    if (!VideoFeedsPlayManager.a(this.a, paramrwf))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "onVideoPrepared checkIsPlayerPlaying false");
      }
      if ((VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.b(this.a)) == paramrwf) && (VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Boolean)) {
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
    e(paramrwf);
  }
  
  public void a(rwf paramrwf, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "onConnectQualityCallback json= " + paramString);
    }
    if (!VideoFeedsPlayManager.a(this.a, paramrwf)) {
      if (paramrwf == VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.b(this.a)))
      {
        VideoFeedsPlayManager.a(this.a, paramString);
        if (VideoFeedsPlayManager.b(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) {
          ryh.a().a(paramrwf, VideoFeedsPlayManager.b(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.d, paramrwf.d());
        }
      }
    }
    do
    {
      return;
      if ((VideoFeedsPlayManager.a(this.a) != null) && (VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)) {
        ryh.a().a(paramrwf, VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.d, paramrwf.d());
      }
    } while ((VideoFeedsPlayManager.a(this.a) == null) || (VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Qwv == null));
    VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Qwv.jdField_g_of_type_JavaLangString = paramString;
  }
  
  public boolean a(rwf paramrwf, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    Object localObject = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null) {}
    for (paramObject = paramObject.toString();; paramObject = "")
    {
      paramObject = paramObject;
      if (VideoFeedsPlayManager.a(this.a, paramrwf)) {
        break;
      }
      if ((VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.b(this.a)) == paramrwf) && (paramrwf != null))
      {
        paramrwf.j();
        VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Boolean = false;
      }
      return false;
    }
    paramrwf = VideoFeedsPlayManager.a(this.a);
    if ((paramrwf != null) && (paramrwf.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (QLog.isColorLevel())) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onError() " + paramObject + ", vid=" + paramrwf.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
    }
    paramObject = rzh.a(paramInt1, paramInt2, paramInt3);
    if ((paramrwf != null) && (paramrwf.jdField_a_of_type_Rlr != null)) {
      paramrwf.jdField_a_of_type_Rlr.a(paramrwf, paramInt1, paramInt2, paramObject);
    }
    if (VideoFeedsPlayManager.a(this.a) != null)
    {
      localObject = VideoFeedsPlayManager.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((rro)((Iterator)localObject).next()).a(paramrwf, paramInt1, paramInt2, paramObject);
      }
    }
    if ((paramrwf != null) && (paramrwf.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)) {
      tzq.a(paramrwf.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString, paramrwf.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, 1, paramInt2);
    }
    if ((paramrwf != null) && (paramrwf.jdField_a_of_type_Qwv != null))
    {
      paramrwf.jdField_a_of_type_Qwv.jdField_a_of_type_Boolean = false;
      paramrwf.jdField_a_of_type_Qwv.jdField_c_of_type_JavaLangString = (paramInt1 + ":" + paramInt2);
      paramrwf.jdField_a_of_type_Qwv.jdField_d_of_type_JavaLangString = paramString;
    }
    if ((VideoFeedsPlayManager.c(this.a)) && (VideoFeedsPlayManager.a(this.a) != null))
    {
      paramString = nzq.a(VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      if (!tqa.a(VideoFeedsPlayManager.a(this.a))) {
        break label531;
      }
    }
    label531:
    for (paramInt1 = 20;; paramInt1 = 0)
    {
      paramObject = nzq.a(0, 0, 0, 0, paramInt1, 0, 0, nzq.aO, 2);
      nzq.a(new tlx().a(VideoFeedsPlayManager.a(this.a)).a(nzq.f).b(paramrwf.jdField_a_of_type_Qwu.g).a(paramString).a(VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a(paramObject).a());
      tqa.a(VideoFeedsPlayManager.a(this.a));
      return false;
    }
  }
  
  public boolean a(rwf paramrwf, int paramInt, Object paramObject)
  {
    if ((!VideoFeedsPlayManager.a(this.a, paramInt)) && (!VideoFeedsPlayManager.a(this.a, paramrwf))) {
      return false;
    }
    rrm localrrm2 = VideoFeedsPlayManager.a(this.a);
    rrm localrrm3 = VideoFeedsPlayManager.b(this.a);
    rrm localrrm1;
    if ((localrrm2 != null) && (paramrwf == localrrm2.jdField_a_of_type_Rwf)) {
      localrrm1 = localrrm2;
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        return false;
      case 28: 
        d(localrrm2);
        return false;
        if (localrrm3 != null)
        {
          localrrm1 = localrrm3;
          if (paramrwf == localrrm3.jdField_a_of_type_Rwf) {}
        }
        else
        {
          localrrm1 = null;
        }
        break;
      }
    }
    b(localrrm2);
    return false;
    c(localrrm2);
    return false;
    a(localrrm2, paramObject);
    return false;
    b(localrrm2, paramObject);
    return false;
    e(localrrm2);
    return false;
    a(paramObject);
    return false;
    b(paramObject);
    return false;
    c(localrrm1, paramObject);
    return false;
    f(localrrm1);
    return false;
  }
  
  public void b(rwf paramrwf)
  {
    if (!VideoFeedsPlayManager.a(this.a, paramrwf)) {
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
    for (paramrwf = VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;; paramrwf = "param null")
    {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, paramrwf);
      VideoFeedsPlayManager.a(this.a).post(new VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.4(this));
      paramrwf = VideoFeedsPlayManager.a(this.a);
      if ((paramrwf != null) && (paramrwf.jdField_a_of_type_Qwv != null))
      {
        paramrwf.jdField_a_of_type_Qwv.jdField_a_of_type_Boolean = true;
        paramrwf.jdField_a_of_type_Qwv.jdField_b_of_type_Boolean = true;
      }
      VideoFeedsPlayManager.c(this.a, true);
      return;
    }
  }
  
  public void c(rwf paramrwf)
  {
    VideoFeedsPlayManager.a(this.a).sendEmptyMessageDelayed(-2, 500L);
  }
  
  public void d(rwf paramrwf)
  {
    if ((!VideoFeedsPlayManager.a(this.a, paramrwf)) && (paramrwf == VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.b(this.a)))) {
      a();
    }
  }
  
  public void e(rwf paramrwf)
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
 * Qualified Name:     rrk
 * JD-Core Version:    0.7.0.1
 */