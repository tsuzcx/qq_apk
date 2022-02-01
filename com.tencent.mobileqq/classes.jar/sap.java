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

public class sap
  extends rux
{
  private sap(VideoFeedsPlayManager paramVideoFeedsPlayManager) {}
  
  private void a()
  {
    if ((VideoFeedsPlayManager.a(this.a) != null) && (VideoFeedsPlayManager.b(this.a) != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "预播放任务 onDownloadFinish title = " + VideoFeedsPlayManager.b(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_JavaLangString);
      }
      int i = VideoFeedsPlayManager.b(this.a).b;
      VideoFeedsPlayManager.a(this.a).a(i);
      VideoFeedsPlayManager.a(this.a, i);
    }
  }
  
  private void a(Object paramObject)
  {
    if ((VideoFeedsPlayManager.a(this.a) != null) && (VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Rgc != null)) {
      rui.a.a(paramObject, VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Rgc);
    }
  }
  
  private void a(sar paramsar, Object paramObject)
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
    if ((paramsar != null) && (paramsar.jdField_a_of_type_Rgc != null))
    {
      if (j > 0)
      {
        paramObject = paramsar.jdField_a_of_type_Rgc;
        paramObject.p += j;
      }
      paramObject = paramsar.jdField_a_of_type_Rgc;
      paramObject.q += j;
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_SKIP_ONE_FRAME decoderMode = " + i + ", skipFrameCount = " + j + ", totalSkipCount = " + paramsar.jdField_a_of_type_Rgc.p + ", finalSkipCount = " + paramsar.jdField_a_of_type_Rgc.q);
      }
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "onPrePlayFinished() vid=" + VideoFeedsPlayManager.b(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
    }
    VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.b(this.a)).j();
    if (siy.a.a()) {
      a();
    }
  }
  
  private void b(Object paramObject)
  {
    if ((VideoFeedsPlayManager.a(this.a) != null) && (VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Rgc != null)) {
      VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Rgc.t = ((Long)paramObject).intValue();
    }
  }
  
  private void b(sar paramsar)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_START_BUFFERING");
    }
    if ((paramsar != null) && (paramsar.jdField_a_of_type_Ruv != null)) {
      paramsar.jdField_a_of_type_Ruv.g(paramsar);
    }
    if ((paramsar != null) && (VideoFeedsPlayManager.a(this.a) != null))
    {
      Iterator localIterator = VideoFeedsPlayManager.a(this.a).iterator();
      while (localIterator.hasNext()) {
        ((sat)localIterator.next()).f(VideoFeedsPlayManager.a(this.a));
      }
    }
    if ((paramsar != null) && (paramsar.jdField_a_of_type_Rgc != null)) {
      paramsar.jdField_a_of_type_Rgc.e = SystemClock.uptimeMillis();
    }
    if ((VideoFeedsPlayManager.b(this.a) != null) && (VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Boolean))
    {
      paramsar = VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.b(this.a));
      if ((paramsar != null) && (!paramsar.d())) {
        VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Sfb.j();
      }
    }
  }
  
  private void b(sar paramsar, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_HW_DECODE_FAILED");
    }
    if ((paramsar != null) && (paramsar.jdField_a_of_type_Rgc != null))
    {
      paramsar.jdField_a_of_type_Rgc.jdField_f_of_type_Boolean = true;
      if ((paramObject instanceof String)) {
        paramsar.jdField_a_of_type_Rgc.jdField_f_of_type_JavaLangString = ((String)paramObject);
      }
    }
  }
  
  private void c(sar paramsar)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_ENDOF_BUFFERING");
    }
    if ((paramsar != null) && (paramsar.jdField_a_of_type_Ruv != null)) {
      paramsar.jdField_a_of_type_Ruv.h(paramsar);
    }
    Object localObject;
    if ((paramsar != null) && (VideoFeedsPlayManager.a(this.a) != null))
    {
      localObject = VideoFeedsPlayManager.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((sat)((Iterator)localObject).next()).b(VideoFeedsPlayManager.a(this.a), this.a.e());
      }
    }
    if ((paramsar != null) && (paramsar.jdField_a_of_type_Rgc != null))
    {
      localObject = paramsar.jdField_a_of_type_Rgc;
      ((rgc)localObject).jdField_f_of_type_Long += SystemClock.uptimeMillis() - paramsar.jdField_a_of_type_Rgc.e;
      paramsar = paramsar.jdField_a_of_type_Rgc;
      paramsar.jdField_c_of_type_Int += 1;
    }
    if ((VideoFeedsPlayManager.b(this.a) != null) && (VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Boolean))
    {
      paramsar = VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.b(this.a));
      if ((paramsar != null) && (!paramsar.d())) {
        VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Sfb.k();
      }
    }
  }
  
  private void c(sar paramsar, Object paramObject)
  {
    if (paramObject != null)
    {
      paramObject = ((String)paramObject).split(":", 2);
      if ((paramObject != null) && (paramObject.length == 2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "PERFORMANCE_REPORT method:" + paramObject[0] + "\ntimeJson:" + paramObject[1]);
        }
        if (("prepare".equals(paramObject[0])) && (paramsar != null) && (paramsar.jdField_a_of_type_Rgc != null)) {
          paramsar.jdField_a_of_type_Rgc.l = paramObject[1];
        }
      }
    }
  }
  
  private void d(sar paramsar)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_DECODER_BLOCK");
    }
    if ((paramsar != null) && (paramsar.jdField_a_of_type_Rgc != null))
    {
      paramsar = paramsar.jdField_a_of_type_Rgc;
      paramsar.o += 1;
    }
  }
  
  private void e(sar paramsar)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_CHANGE_HW_BACKUP_URL");
    }
    if ((paramsar != null) && (paramsar.jdField_a_of_type_Rgc != null)) {
      paramsar.jdField_a_of_type_Rgc.jdField_g_of_type_Boolean = true;
    }
  }
  
  private void f(sar paramsar)
  {
    int i = 1;
    boolean bool;
    if ((paramsar != null) && (paramsar.jdField_a_of_type_Rgc != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_FIRST_VIDEO_FRAME_RENDERED");
      }
      if (paramsar.jdField_a_of_type_Ruv != null)
      {
        ruv localruv = paramsar.jdField_a_of_type_Ruv;
        if (paramsar != VideoFeedsPlayManager.b(this.a)) {
          break label123;
        }
        bool = true;
        localruv.a(paramsar, bool, VideoFeedsPlayManager.d(this.a));
      }
      if (paramsar.jdField_a_of_type_Rgc.jdField_b_of_type_Long <= 0L) {
        break label128;
      }
      label82:
      if (i == 0) {
        break label133;
      }
    }
    label128:
    label133:
    for (paramsar.jdField_a_of_type_Rgc.v = (SystemClock.uptimeMillis() - paramsar.jdField_a_of_type_Rgc.jdField_b_of_type_Long);; paramsar.jdField_a_of_type_Rgc.v = 0L)
    {
      paramsar.jdField_a_of_type_Rgc.w = (SystemClock.uptimeMillis() - paramsar.jdField_a_of_type_Rgc.jdField_c_of_type_Long);
      return;
      label123:
      bool = false;
      break;
      i = 0;
      break label82;
    }
  }
  
  public void a(sar paramsar)
  {
    if ((paramsar == null) || (paramsar.jdField_a_of_type_Rgc == null) || (paramsar.jdField_a_of_type_Rgc.jdField_d_of_type_Long != 0L)) {
      return;
    }
    paramsar.jdField_a_of_type_Rgc.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - paramsar.jdField_a_of_type_Rgc.jdField_b_of_type_Long);
    Object localObject = paramsar.jdField_a_of_type_Rgc;
    ((rgc)localObject).jdField_f_of_type_Long += paramsar.jdField_a_of_type_Rgc.jdField_d_of_type_Long;
    localObject = paramsar.jdField_a_of_type_Rgc;
    ((rgc)localObject).jdField_c_of_type_Int += 1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doReportOnVideoPrepared: vid=").append(paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString).append(", 预加载状态：").append(paramsar.jdField_a_of_type_Rgc.n).append(", 预下载命中：").append(VideoFeedsPlayManager.a(this.a, paramsar).jdField_b_of_type_Boolean).append(", 首帧耗时：").append(paramsar.jdField_a_of_type_Rgc.jdField_d_of_type_Long);
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, ((StringBuilder)localObject).toString());
    }
    ThreadManager.excute(new VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.3(this, paramsar), 16, null, true);
  }
  
  public void a(sfb paramsfb)
  {
    if (!VideoFeedsPlayManager.a(this.a, paramsfb)) {
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
    for (paramsfb = VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;; paramsfb = "param null")
    {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, paramsfb);
      VideoFeedsPlayManager.a(this.a).post(new VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.4(this));
      paramsfb = VideoFeedsPlayManager.a(this.a);
      if ((paramsfb != null) && (paramsfb.jdField_a_of_type_Rgc != null))
      {
        paramsfb.jdField_a_of_type_Rgc.jdField_a_of_type_Boolean = true;
        paramsfb.jdField_a_of_type_Rgc.jdField_b_of_type_Boolean = true;
      }
      VideoFeedsPlayManager.c(this.a, true);
      return;
    }
  }
  
  public void a(sfb paramsfb, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "onVideoPrepared(VideoPlayerWrapper player, Object tag) ");
    }
    if (!VideoFeedsPlayManager.a(this.a, paramsfb))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "onVideoPrepared checkIsPlayerPlaying false");
      }
      if ((VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.b(this.a)) == paramsfb) && (VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Boolean)) {
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
    e(paramsfb);
  }
  
  public void a(sfb paramsfb, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "onConnectQualityCallback json= " + paramString);
    }
    if (!VideoFeedsPlayManager.a(this.a, paramsfb)) {
      if (paramsfb == VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.b(this.a)))
      {
        VideoFeedsPlayManager.a(this.a, paramString);
        shd.a().a(paramsfb, VideoFeedsPlayManager.b(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.d, paramsfb.d());
      }
    }
    do
    {
      return;
      shd.a().a(paramsfb, VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.d, paramsfb.d());
    } while ((VideoFeedsPlayManager.a(this.a) == null) || (VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Rgc == null));
    VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Rgc.jdField_g_of_type_JavaLangString = paramString;
  }
  
  public boolean a(sfb paramsfb, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    Object localObject = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null) {}
    for (paramObject = paramObject.toString();; paramObject = "")
    {
      paramObject = paramObject;
      if (VideoFeedsPlayManager.a(this.a, paramsfb)) {
        break;
      }
      if ((VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.b(this.a)) == paramsfb) && (paramsfb != null))
      {
        paramsfb.j();
        VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Boolean = false;
      }
      return false;
    }
    paramsfb = VideoFeedsPlayManager.a(this.a);
    if ((paramsfb != null) && (paramsfb.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (QLog.isColorLevel())) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onError() " + paramObject + ", vid=" + paramsfb.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
    }
    paramObject = sid.a(paramInt1, paramInt2, paramInt3);
    if ((paramsfb != null) && (paramsfb.jdField_a_of_type_Ruv != null)) {
      paramsfb.jdField_a_of_type_Ruv.a(paramsfb, paramInt1, paramInt2, paramObject);
    }
    if (VideoFeedsPlayManager.a(this.a) != null)
    {
      localObject = VideoFeedsPlayManager.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((sat)((Iterator)localObject).next()).a(paramsfb, paramInt1, paramInt2, paramObject);
      }
    }
    if ((paramsfb != null) && (paramsfb.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)) {
      tzo.a(paramsfb.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString, paramsfb.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, 1, paramInt2);
    }
    if ((paramsfb != null) && (paramsfb.jdField_a_of_type_Rgc != null))
    {
      paramsfb.jdField_a_of_type_Rgc.jdField_a_of_type_Boolean = false;
      paramsfb.jdField_a_of_type_Rgc.jdField_c_of_type_JavaLangString = (paramInt1 + ":" + paramInt2);
      paramsfb.jdField_a_of_type_Rgc.jdField_d_of_type_JavaLangString = paramString;
    }
    if ((VideoFeedsPlayManager.c(this.a)) && (VideoFeedsPlayManager.a(this.a) != null))
    {
      paramString = nxw.a(VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      if (!oqj.a(VideoFeedsPlayManager.a(this.a))) {
        break label531;
      }
    }
    label531:
    for (paramInt1 = 20;; paramInt1 = 0)
    {
      paramObject = nxw.a(0, 0, 0, 0, paramInt1, 0, 0, nxw.aI, 2);
      nxw.a(new omp().a(VideoFeedsPlayManager.a(this.a)).a(nxw.f).b(paramsfb.jdField_a_of_type_Rgb.g).a(paramString).a(VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a(paramObject).a());
      oqj.a(VideoFeedsPlayManager.a(this.a));
      return false;
    }
  }
  
  public boolean a(sfb paramsfb, int paramInt, Object paramObject)
  {
    if ((!VideoFeedsPlayManager.a(this.a, paramInt)) && (!VideoFeedsPlayManager.a(this.a, paramsfb))) {
      return false;
    }
    sar localsar = VideoFeedsPlayManager.a(this.a);
    if ((VideoFeedsPlayManager.a(this.a) != null) && (paramsfb == VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Sfb)) {
      paramsfb = VideoFeedsPlayManager.a(this.a);
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        return false;
      case 28: 
        d(localsar);
        return false;
        if ((VideoFeedsPlayManager.b(this.a) != null) && (paramsfb == VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Sfb)) {
          paramsfb = VideoFeedsPlayManager.b(this.a);
        } else {
          paramsfb = null;
        }
        break;
      }
    }
    b(localsar);
    return false;
    c(localsar);
    return false;
    a(localsar, paramObject);
    return false;
    b(localsar, paramObject);
    return false;
    e(localsar);
    return false;
    a(paramObject);
    return false;
    b(paramObject);
    return false;
    c(paramsfb, paramObject);
    return false;
    f(paramsfb);
    return false;
  }
  
  public void b(sfb paramsfb)
  {
    super.b(paramsfb);
    VideoFeedsPlayManager.a(this.a).removeMessages(-2);
    VideoFeedsPlayManager.a(this.a).sendEmptyMessage(-2);
    if ((VideoFeedsPlayManager.a(this.a) != null) && (VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Sfb == paramsfb))
    {
      VideoFeedsPlayManager.a(this.a).jdField_a_of_type_AndroidViewView = paramsfb.a();
      VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Ruv.b(VideoFeedsPlayManager.a(this.a), true);
    }
  }
  
  public void c(sfb paramsfb)
  {
    VideoFeedsPlayManager.a(this.a).sendEmptyMessageDelayed(-2, 500L);
  }
  
  public void d(sfb paramsfb)
  {
    if ((!VideoFeedsPlayManager.a(this.a, paramsfb)) && (paramsfb == VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.b(this.a)))) {
      a();
    }
  }
  
  public void e(sfb paramsfb)
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
 * Qualified Name:     sap
 * JD-Core Version:    0.7.0.1
 */