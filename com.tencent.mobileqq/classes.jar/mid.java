import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper.MediaPlayListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.video.VideoRecommendManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo.DefnInfo;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import org.json.JSONObject;

public class mid
  extends VideoPlayerWrapper.MediaPlayListenerAdapter
{
  public mid(VideoPlayManager paramVideoPlayManager) {}
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "video play completion!");
    }
    if (VideoPlayManager.a(this.a) != null)
    {
      VideoPlayManager.VideoPlayParam localVideoPlayParam = VideoPlayManager.a(this.a);
      VideoRecommendManager localVideoRecommendManager = VideoPlayManager.a(this.a);
      localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long = VideoPlayManager.a(this.a).a(true);
      localVideoPlayParam.jdField_b_of_type_Long = this.a.a();
      if ((localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long == 0L) && (localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_Long == 0L) && (localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Long != 0L)) {
        localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Long);
      }
      localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Float = ((float)localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long / localVideoPlayParam.jdField_a_of_type_Int);
      localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Boolean = true;
      localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Boolean = true;
      localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.m = paramVideoPlayerWrapper.c();
      localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Int = paramVideoPlayerWrapper.a();
      localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_e_of_type_Int = paramVideoPlayerWrapper.b();
      localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_Boolean = paramVideoPlayerWrapper.jdField_b_of_type_Boolean;
      localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.p = paramVideoPlayerWrapper.jdField_b_of_type_Long;
      localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.o = paramVideoPlayerWrapper.jdField_a_of_type_Long;
      localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.q = paramVideoPlayerWrapper.e();
      localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.r = paramVideoPlayerWrapper.h();
      localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_f_of_type_JavaLangString = paramVideoPlayerWrapper.a();
      localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.t = paramVideoPlayerWrapper.g();
      localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.u = paramVideoPlayerWrapper.f();
      ReadInJoyUtils.a(VideoPlayManager.a(this.a).getApplicationContext(), ReadInJoyUtils.a(), true, localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.a());
      if (localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long > 0L) {
        ThreadManager.post(new mif(this, localVideoPlayParam, new JSONObject(), localVideoRecommendManager), 5, null, true);
      }
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X800709B", "0X800709B", 0, 0, "", "", "", localVideoPlayParam.jdField_a_of_type_JavaLangString);
    }
    VideoPlayManager.a(this.a).post(new mig(this));
  }
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper, Object paramObject)
  {
    long l = 0L;
    paramObject = VideoPlayManager.a(this.a);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onVideoPrepared() mIsOpenedVideo=" + VideoPlayManager.a(this.a));
    }
    if (!VideoPlayManager.a(this.a)) {}
    do
    {
      return;
      VideoPlayManager.a(this.a, false);
      if ((VideoPlayManager.a(this.a) == paramVideoPlayerWrapper) && (paramObject != null))
      {
        VideoPlayManager.a(this.a).c(paramObject.jdField_e_of_type_Int);
        VideoPlayManager.a(this.a).a(paramObject.f, true);
        if ((paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null) && (paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_Long == 0L))
        {
          paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Long);
          Object localObject = paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
          ((ReadinjoyVideoReportData)localObject).jdField_e_of_type_Long += paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_Long;
          localObject = paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
          ((ReadinjoyVideoReportData)localObject).jdField_b_of_type_Int += 1;
          localObject = paramVideoPlayerWrapper.a().getPlayDetailsTime();
          if ((localObject != null) && (paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null))
          {
            paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_f_of_type_Long = Long.valueOf(((Properties)localObject).getProperty("httpdnsMS")).longValue();
            paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.g = Long.valueOf(((Properties)localObject).getProperty("httpredirectMS")).longValue();
            paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.h = Long.valueOf(((Properties)localObject).getProperty("cacheframeMS")).longValue();
            if (1 == paramObject.jdField_e_of_type_Int) {
              paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.i = Long.valueOf(((Properties)localObject).getProperty("vidtourlMS")).longValue();
            }
            paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.j = Long.valueOf(((Properties)localObject).getProperty("httpfirstrecvMS")).longValue();
            paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.k = Long.valueOf(((Properties)localObject).getProperty("getmp4headerMS")).longValue();
            paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.l = Long.valueOf(((Properties)localObject).getProperty("httpconnectMS")).longValue();
          }
          if ((paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null) && (QLog.isColorLevel())) {
            QLog.d("Q.readinjoy.video", 2, "video player ready. from open. prepare cost : " + paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_Long);
          }
        }
        VideoPlayManager.a(this.a, paramObject, VideoPlayManager.a(this.a), 2, null);
        if ((VideoVolumeControl.a(VideoPlayManager.a(this.a))) || (!GesturePWDUtils.isAppOnForeground(VideoPlayManager.a(this.a))) || (VideoPlayManager.a(this.a) == null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "onVideoPrepared start,in call stop.background:" + GesturePWDUtils.isAppOnForeground(VideoPlayManager.a(this.a)));
          }
          VideoPlayManager.a(this.a).post(new mie(this));
        }
        for (;;)
        {
          paramVideoPlayerWrapper = new StringBuilder().append("预下载命中：").append(paramVideoPlayerWrapper.jdField_b_of_type_Boolean).append(", 首帧耗时：");
          if (paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null) {
            l = paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_Long;
          }
          paramVideoPlayerWrapper = l;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.readinjoy.video", 2, paramVideoPlayerWrapper);
          return;
          paramVideoPlayerWrapper.d();
          VideoPlayManager.a(this.a, paramObject, VideoPlayManager.a(this.a), 3, null);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.readinjoy.video", 2, "video player ready,but has error!");
  }
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onCaptureImage , id : " + paramInt2 + " succ : " + paramBoolean + " errCode : " + paramInt1);
    }
    if (VideoPlayManager.a(this.a).size() >= 10)
    {
      paramVideoPlayerWrapper = (Pair)VideoPlayManager.a(this.a).remove(0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "Capture Image Pool full ! remove first image, id : " + paramVideoPlayerWrapper.first);
      }
    }
    if (paramBoolean) {
      VideoPlayManager.a(this.a).add(new Pair(Integer.valueOf(paramInt2), paramBitmap));
    }
    ((VideoPlayerWrapper)VideoPlayManager.a(this.a).get(Integer.valueOf(paramInt2))).h();
  }
  
  public void a(TVK_NetVideoInfo paramTVK_NetVideoInfo)
  {
    if (VideoPlayManager.a(this.a) == null) {
      return;
    }
    VideoPlayManager.a(this.a).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo$DefnInfo = paramTVK_NetVideoInfo.getCurDefinition();
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
            break label217;
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
      PublicAccountReportUtils.a(null, "", "0X8008AEE", "0X8008AEE", 0, 0, "", "", "", VideoReporter.a(VideoPlayManager.a(this.a).jdField_a_of_type_JavaLangString, VideoPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID, (int)VideoPlayManager.a(this.a).jdField_e_of_type_Long, localJSONObject), false);
      return;
      label217:
      i += 1;
    }
  }
  
  public boolean a(VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null) {}
    for (paramObject = paramObject.toString();; paramObject = "")
    {
      paramObject = paramObject;
      if (QLog.isColorLevel()) {
        QLog.d(VideoPlayManager.jdField_a_of_type_JavaLangString, 2, "video play has error ! " + paramObject);
      }
      if (VideoPlayManager.a(this.a) != null) {
        PublicAccountUtil.a(VideoPlayManager.a(this.a).i, VideoPlayManager.a(this.a).jdField_a_of_type_JavaLangString, 1, paramInt2);
      }
      if (paramVideoPlayerWrapper == VideoPlayManager.a(this.a)) {
        VideoPlayManager.a(this.a).post(new mih(this, paramInt1, paramInt2, paramString, paramVideoPlayerWrapper));
      }
      return true;
    }
  }
  
  public boolean a(VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt, Object paramObject)
  {
    if (paramVideoPlayerWrapper == VideoPlayManager.a(this.a))
    {
      if (this.a.a() != 5) {
        break label73;
      }
      if (QLog.isColorLevel()) {
        QLog.d(VideoPlayManager.jdField_a_of_type_JavaLangString, 2, "onInfo(): what:" + paramInt + ",extra:" + paramObject + ", getCurPlayState == paused, just ignore.");
      }
    }
    label73:
    do
    {
      do
      {
        return false;
        switch (paramInt)
        {
        default: 
          return false;
        case 21: 
          if (QLog.isColorLevel()) {
            QLog.d(VideoPlayManager.jdField_a_of_type_JavaLangString, 2, "onInfo(): video start buffering !");
          }
          VideoPlayManager.a(this.a, VideoPlayManager.a(this.a), VideoPlayManager.a(this.a), 4, null);
        }
      } while (VideoPlayManager.a(this.a) == null);
      VideoPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long = SystemClock.uptimeMillis();
      return false;
      if (QLog.isColorLevel()) {
        QLog.d(VideoPlayManager.jdField_a_of_type_JavaLangString, 2, "onInfo(): video end buffering ! isPause=" + this.a.c());
      }
      if (!this.a.c()) {
        VideoPlayManager.a(this.a, VideoPlayManager.a(this.a), VideoPlayManager.a(this.a), 3, null);
      }
    } while (VideoPlayManager.a(this.a) == null);
    paramVideoPlayerWrapper = VideoPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
    paramVideoPlayerWrapper.jdField_e_of_type_Long += SystemClock.uptimeMillis() - VideoPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long;
    paramVideoPlayerWrapper = VideoPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
    paramVideoPlayerWrapper.jdField_b_of_type_Int += 1;
    return false;
  }
  
  public void b(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoPlayManager.jdField_a_of_type_JavaLangString, 2, "onSeekComplete(): video seek complete ! curPlayState:" + VideoPlayUtils.a(this.a.a()));
    }
    if ((paramVideoPlayerWrapper == VideoPlayManager.a(this.a)) && (this.a.a() != 5)) {
      VideoPlayManager.a(this.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mid
 * JD-Core Version:    0.7.0.1
 */