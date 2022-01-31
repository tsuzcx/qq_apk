import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.4;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.5;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo.DefnInfo;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class rfp
  extends rjo
{
  private rfp(VideoFeedsPlayManager paramVideoFeedsPlayManager) {}
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "onPrePlayFinished()");
    }
    VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.a(this.a)).k();
    if (VideoFeedsPlayManager.a(this.a) != null) {
      VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Qyz.b(VideoFeedsPlayManager.a(this.a), VideoFeedsPlayManager.b(this.a));
    }
  }
  
  private void a(TVK_NetVideoInfo paramTVK_NetVideoInfo, VideoInfo paramVideoInfo)
  {
    for (;;)
    {
      JSONObject localJSONObject;
      StringBuilder localStringBuilder;
      int i;
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("cur_defn", paramTVK_NetVideoInfo.getCurDefinition().getmDefn());
        localStringBuilder = new StringBuilder();
        paramTVK_NetVideoInfo = paramTVK_NetVideoInfo.getDefinitionList();
        i = 0;
        if (i < paramTVK_NetVideoInfo.size())
        {
          TVK_NetVideoInfo.DefnInfo localDefnInfo = (TVK_NetVideoInfo.DefnInfo)paramTVK_NetVideoInfo.get(i);
          if (localDefnInfo == null) {
            break label167;
          }
          if (i == 0) {
            localStringBuilder.append(localDefnInfo.getmDefn());
          } else {
            localStringBuilder.append("_" + localDefnInfo.getmDefn());
          }
        }
      }
      catch (Exception paramTVK_NetVideoInfo)
      {
        paramTVK_NetVideoInfo.printStackTrace();
        return;
      }
      localJSONObject.put("defn_list", localStringBuilder.toString());
      nrt.a(null, "", "0X8008AEE", "0X8008AEE", 0, 0, "", "", "", ntd.a(paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.jdField_g_of_type_JavaLangString, 409409, localJSONObject), false);
      return;
      label167:
      i += 1;
    }
  }
  
  public void a(TVK_NetVideoInfo paramTVK_NetVideoInfo, rjn paramrjn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "onTencentVideoDefnInfo(TVK_NetVideoInfo videoInfo, VideoPlayerWrapper videoPLayer) ");
    }
    if (!VideoFeedsPlayManager.a(this.a, paramrjn)) {
      if (paramrjn == VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.a(this.a))) {
        this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo = paramTVK_NetVideoInfo;
      }
    }
    while (VideoFeedsPlayManager.b(this.a) == null) {
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ThreadManager.excute(new VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.1(this, paramTVK_NetVideoInfo), 16, null, true);
      return;
    }
    a(paramTVK_NetVideoInfo, VideoFeedsPlayManager.b(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
  }
  
  public void a(rfs paramrfs)
  {
    if ((paramrfs == null) || (paramrfs.jdField_a_of_type_Qlq == null) || (paramrfs.jdField_a_of_type_Qlq.jdField_c_of_type_Long != 0L)) {
      return;
    }
    paramrfs.jdField_a_of_type_Qlq.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - paramrfs.jdField_a_of_type_Qlq.jdField_b_of_type_Long);
    Object localObject = paramrfs.jdField_a_of_type_Qlq;
    ((qlq)localObject).e += paramrfs.jdField_a_of_type_Qlq.jdField_c_of_type_Long;
    localObject = paramrfs.jdField_a_of_type_Qlq;
    ((qlq)localObject).jdField_b_of_type_Int += 1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doReportOnVideoPrepared: vid=").append(paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString).append(", 预加载状态：").append(paramrfs.jdField_a_of_type_Qlq.jdField_m_of_type_Int).append(", 预下载命中：").append(VideoFeedsPlayManager.a(this.a, paramrfs).jdField_b_of_type_Boolean).append(", 首帧耗时：").append(paramrfs.jdField_a_of_type_Qlq.jdField_c_of_type_Long);
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, ((StringBuilder)localObject).toString());
    }
    ThreadManager.excute(new VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.4(this, paramrfs), 16, null, true);
  }
  
  public void a(rjn paramrjn)
  {
    if (!VideoFeedsPlayManager.a(this.a, paramrjn)) {
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("播放状态回调 onCompletion() vid=");
      if (VideoFeedsPlayManager.b(this.a) == null) {
        break label133;
      }
    }
    label133:
    for (paramrjn = VideoFeedsPlayManager.b(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;; paramrjn = "param null")
    {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, paramrjn);
      VideoFeedsPlayManager.a(this.a).post(new VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.5(this));
      paramrjn = VideoFeedsPlayManager.b(this.a);
      if ((paramrjn != null) && (paramrjn.jdField_a_of_type_Qlq != null))
      {
        paramrjn.jdField_a_of_type_Qlq.jdField_a_of_type_Boolean = true;
        paramrjn.jdField_a_of_type_Qlq.jdField_b_of_type_Boolean = true;
      }
      VideoFeedsPlayManager.c(this.a, true);
      return;
    }
  }
  
  public void a(rjn paramrjn, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "onVideoPrepared(VideoPlayerWrapper player, Object tag) ");
    }
    paramObject = VideoFeedsPlayManager.b(this.a);
    if ((paramObject != null) && (QLog.isColorLevel())) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onVideoPrepared() vid=" + paramObject.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString + ", mIsOpenedVideo = " + VideoFeedsPlayManager.a(this.a));
    }
    if (!VideoFeedsPlayManager.a(this.a, paramrjn))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "onVideoPrepared  checkIsPlayerPlaying false");
      }
      if ((VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.a(this.a)) == paramrjn) && (VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Boolean)) {
        a();
      }
    }
    do
    {
      return;
      if (VideoFeedsPlayManager.a(this.a)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoFeedsPlayManager.preplay", 2, "onVideoPrepared  return isOpenedVideo false");
    return;
    VideoFeedsPlayManager.a(this.a, false);
    a(paramObject);
    c(paramrjn);
  }
  
  public void a(rjn paramrjn, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "onConnectQualityCallback json= " + paramString);
    }
    if (!VideoFeedsPlayManager.a(this.a, paramrjn)) {
      if (paramrjn == VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.a(this.a)))
      {
        this.a.jdField_a_of_type_JavaLangString = paramString;
        rmc.a().a(paramrjn, VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.d, paramrjn.d());
      }
    }
    do
    {
      return;
      rmc.a().a(paramrjn, VideoFeedsPlayManager.b(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.d, paramrjn.d());
    } while ((VideoFeedsPlayManager.b(this.a) == null) || (VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Qlq == null));
    VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Qlq.h = paramString;
  }
  
  public boolean a(rjn paramrjn, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    Object localObject = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null) {}
    for (paramObject = paramObject.toString();; paramObject = "")
    {
      localObject = paramObject;
      if (VideoFeedsPlayManager.a(this.a, paramrjn)) {
        break;
      }
      if ((VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.a(this.a)) == paramrjn) && (paramrjn != null))
      {
        paramrjn.k();
        VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Boolean = false;
      }
      return false;
    }
    paramObject = VideoFeedsPlayManager.b(this.a);
    if ((paramObject != null) && (paramObject.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (QLog.isColorLevel())) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onError() " + (String)localObject + ", vid=" + paramObject.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
    }
    alpo.a(2131716622);
    if (paramInt1 == 123) {
      if (paramInt2 == 103) {
        paramrjn = alpo.a(2131716618) + paramInt1 + "-" + paramInt2 + ")";
      }
    }
    for (;;)
    {
      if ((paramObject != null) && (paramObject.jdField_a_of_type_Qyz != null)) {
        paramObject.jdField_a_of_type_Qyz.a(paramObject, paramInt1, paramInt2, paramrjn);
      }
      if (VideoFeedsPlayManager.a(this.a) == null) {
        break;
      }
      localObject = VideoFeedsPlayManager.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((rfu)((Iterator)localObject).next()).a(paramObject, paramInt1, paramInt2, paramrjn);
      }
      paramrjn = alpo.a(2131716605) + paramInt1 + "-" + paramInt2 + ")";
      continue;
      if (paramInt1 == 122)
      {
        if (paramInt2 == 204) {
          paramrjn = alpo.a(2131716582) + paramInt1 + "-" + paramInt2 + ")";
        } else if (paramInt2 == 202) {
          paramrjn = alpo.a(2131716522) + paramInt1 + "-" + paramInt2 + ")";
        } else {
          paramrjn = alpo.a(2131716620) + paramInt1 + "-" + paramInt2 + ")";
        }
      }
      else if (paramInt1 == 101)
      {
        if (paramInt2 == 80) {
          paramrjn = alpo.a(2131716549) + paramInt1 + "-" + paramInt2 + ")";
        } else {
          paramrjn = alpo.a(2131716551) + paramInt1 + "-" + paramInt2 + ")";
        }
      }
      else {
        paramrjn = alpo.a(2131716575) + paramInt1 + "-" + paramInt2 + ")";
      }
    }
    if ((paramObject != null) && (paramObject.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)) {
      syb.a(paramObject.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString, paramObject.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, 1, paramInt2);
    }
    if ((paramObject != null) && (paramObject.jdField_a_of_type_Qlq != null))
    {
      paramObject.jdField_a_of_type_Qlq.jdField_a_of_type_Boolean = false;
      paramObject.jdField_a_of_type_Qlq.jdField_c_of_type_JavaLangString = (paramInt1 + ":" + paramInt2);
      paramObject.jdField_a_of_type_Qlq.jdField_d_of_type_JavaLangString = paramString;
    }
    if ((VideoFeedsPlayManager.d(this.a)) && (VideoFeedsPlayManager.a(this.a) != null))
    {
      paramrjn = noy.a(VideoFeedsPlayManager.b(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      if (!oee.a(VideoFeedsPlayManager.b(this.a))) {
        break label929;
      }
    }
    label929:
    for (paramInt1 = 20;; paramInt1 = 0)
    {
      paramString = noy.a(0, 0, 0, 0, paramInt1, 0, 0, noy.aE, 2);
      noy.a(new obk().a(VideoFeedsPlayManager.a(this.a)).a(noy.f).b(paramObject.jdField_a_of_type_Qlp.g).a(paramrjn).a(VideoFeedsPlayManager.b(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a(paramString).a());
      oee.a(VideoFeedsPlayManager.b(this.a));
      return false;
    }
  }
  
  public boolean a(rjn paramrjn, int paramInt, Object paramObject)
  {
    if ((paramInt != 42) && (!VideoFeedsPlayManager.a(this.a, paramrjn))) {}
    label722:
    label1006:
    for (;;)
    {
      return false;
      rfs localrfs = VideoFeedsPlayManager.b(this.a);
      switch (paramInt)
      {
      default: 
        return false;
      case 21: 
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_START_BUFFERING");
        }
        if ((localrfs != null) && (localrfs.jdField_a_of_type_Qyz != null)) {
          localrfs.jdField_a_of_type_Qyz.h(localrfs);
        }
        if ((localrfs != null) && (VideoFeedsPlayManager.a(this.a) != null))
        {
          paramrjn = VideoFeedsPlayManager.a(this.a).iterator();
          while (paramrjn.hasNext()) {
            ((rfu)paramrjn.next()).f(VideoFeedsPlayManager.b(this.a));
          }
        }
        if ((localrfs != null) && (localrfs.jdField_a_of_type_Qlq != null)) {
          localrfs.jdField_a_of_type_Qlq.jdField_d_of_type_Long = SystemClock.uptimeMillis();
        }
        if ((VideoFeedsPlayManager.a(this.a) != null) && (VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Boolean))
        {
          paramrjn = VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.a(this.a));
          if ((paramrjn != null) && (!paramrjn.e()))
          {
            VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Rjn.k();
            return false;
          }
        }
        break;
      case 22: 
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_ENDOF_BUFFERING");
        }
        if ((localrfs != null) && (localrfs.jdField_a_of_type_Qyz != null)) {
          localrfs.jdField_a_of_type_Qyz.i(localrfs);
        }
        if ((localrfs != null) && (VideoFeedsPlayManager.a(this.a) != null))
        {
          paramrjn = VideoFeedsPlayManager.a(this.a).iterator();
          while (paramrjn.hasNext()) {
            ((rfu)paramrjn.next()).b(VideoFeedsPlayManager.b(this.a), this.a.g());
          }
        }
        if ((localrfs != null) && (localrfs.jdField_a_of_type_Qlq != null))
        {
          paramrjn = localrfs.jdField_a_of_type_Qlq;
          paramrjn.e += SystemClock.uptimeMillis() - localrfs.jdField_a_of_type_Qlq.jdField_d_of_type_Long;
          paramrjn = localrfs.jdField_a_of_type_Qlq;
          paramrjn.jdField_b_of_type_Int += 1;
        }
        if ((VideoFeedsPlayManager.a(this.a) != null) && (VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Boolean))
        {
          paramrjn = VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.a(this.a));
          if ((paramrjn != null) && (!paramrjn.e()))
          {
            VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Rjn.l();
            return false;
          }
        }
        break;
      case 28: 
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_DECODER_BLOCK");
        }
        if ((localrfs != null) && (localrfs.jdField_a_of_type_Qlq != null))
        {
          paramrjn = localrfs.jdField_a_of_type_Qlq;
          paramrjn.n += 1;
          return false;
        }
        break;
      case 40: 
        for (;;)
        {
          try
          {
            paramrjn = new JSONObject((String)paramObject);
            paramInt = paramrjn.optInt("decoderMode", 0);
          }
          catch (Exception paramrjn)
          {
            try
            {
              i = paramrjn.optInt("skipFrameCount", 1);
              if ((localrfs == null) || (localrfs.jdField_a_of_type_Qlq == null)) {
                break;
              }
              if (i > 0)
              {
                paramrjn = localrfs.jdField_a_of_type_Qlq;
                paramrjn.o += i;
              }
              paramrjn = localrfs.jdField_a_of_type_Qlq;
              paramrjn.p += i;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_SKIP_ONE_FRAME decoderMode = " + paramInt + ", skipFrameCount = " + i + ", totalSkipCount = " + localrfs.jdField_a_of_type_Qlq.o + ", finalSkipCount = " + localrfs.jdField_a_of_type_Qlq.p);
              return false;
            }
            catch (Exception paramrjn)
            {
              int i;
              break label722;
            }
            paramrjn = paramrjn;
            paramInt = 0;
          }
          i = 0;
        }
      case 39: 
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_HW_DECODE_FAILED");
        }
        if ((localrfs != null) && (localrfs.jdField_a_of_type_Qlq != null))
        {
          localrfs.jdField_a_of_type_Qlq.f = true;
          if ((paramObject instanceof String))
          {
            localrfs.jdField_a_of_type_Qlq.jdField_g_of_type_JavaLangString = ((String)paramObject);
            return false;
          }
        }
        break;
      case 41: 
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_CHANGE_HW_BACKUP_URL");
        }
        if ((localrfs != null) && (localrfs.jdField_a_of_type_Qlq != null))
        {
          localrfs.jdField_a_of_type_Qlq.jdField_g_of_type_Boolean = true;
          return false;
        }
        break;
      case 42: 
        if (paramrjn != null)
        {
          if ((VideoFeedsPlayManager.b(this.a) != null) && (paramrjn == VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Rjn)) {
            paramrjn = VideoFeedsPlayManager.b(this.a);
          }
          for (;;)
          {
            if (paramObject == null) {
              break label1006;
            }
            paramObject = ((String)paramObject).split(":", 2);
            if ((paramObject == null) || (paramObject.length != 2)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "PERFORMANCE_REPORT method:" + paramObject[0] + "\ntimeJson:" + paramObject[1]);
            }
            if ((!"prepare".equals(paramObject[0])) || (paramrjn == null) || (paramrjn.jdField_a_of_type_Qlq == null)) {
              break;
            }
            paramrjn.jdField_a_of_type_Qlq.jdField_m_of_type_JavaLangString = paramObject[1];
            return false;
            if ((VideoFeedsPlayManager.a(this.a) != null) && (paramrjn == VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Rjn)) {
              paramrjn = VideoFeedsPlayManager.a(this.a);
            } else {
              paramrjn = null;
            }
          }
        }
        break;
      }
    }
  }
  
  public void b(rjn paramrjn)
  {
    if ((!VideoFeedsPlayManager.a(this.a, paramrjn)) && (paramrjn == VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.a(this.a))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "预播放任务 onDownloadFinish title = " + VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_JavaLangString);
      }
      if (VideoFeedsPlayManager.a(this.a) != null)
      {
        VideoFeedsPlayManager.a(this.a).a(VideoFeedsPlayManager.a(this.a).jdField_b_of_type_Int);
        VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.a(this.a).jdField_b_of_type_Int);
      }
    }
  }
  
  public void c(rjn paramrjn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "startVideoAfterPrepared(VideoPlayerWrapper player) mIsActivityOnResume=" + VideoFeedsPlayManager.c(this.a));
    }
    VideoFeedsPlayManager.a(this.a).removeMessages(-3);
    if (VideoFeedsPlayManager.c(this.a))
    {
      this.a.a();
      return;
    }
    VideoFeedsPlayManager.b(this.a, true);
  }
  
  public void d(rjn paramrjn)
  {
    VideoFeedsPlayManager.a(this.a).sendEmptyMessageDelayed(-2, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rfp
 * JD-Core Version:    0.7.0.1
 */