import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.1.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.1.3;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.1.4;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.1.5;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo.DefnInfo;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import org.json.JSONObject;

public class rjh
  extends rjo
{
  rjh(rjg paramrjg) {}
  
  public void a(TVK_NetVideoInfo paramTVK_NetVideoInfo)
  {
    if (rjg.a(this.a) == null) {
      return;
    }
    rjg.a(this.a).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo$DefnInfo = paramTVK_NetVideoInfo.getCurDefinition();
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
            break label212;
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
      nrt.a(null, "", "0X8008AEE", "0X8008AEE", 0, 0, "", "", "", ntd.a(rjg.a(this.a).jdField_c_of_type_JavaLangString, rjg.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID, (int)rjg.a(this.a).jdField_b_of_type_Long, localJSONObject), false);
      return;
      label212:
      i += 1;
    }
  }
  
  public void a(rjn paramrjn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "video play completion!");
    }
    if (rjg.a(this.a) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.readinjoy.video", 2, "onCompletion return for mVideoPlayerWrapper is null");
      }
      return;
    }
    long l = rjg.a(this.a).a(true);
    rjg.a(this.a, rjg.a(this.a));
    rjg.b(this.a, rjg.a(this.a));
    rjk localrjk;
    rkb localrkb;
    int i;
    int j;
    boolean bool;
    if (rjg.a(this.a) != null)
    {
      localrjk = rjg.a(this.a);
      localrkb = rjg.a(this.a);
      localrjk.jdField_a_of_type_Qlq.jdField_a_of_type_Long = l;
      localrjk.jdField_d_of_type_Long = this.a.a();
      if ((localrjk.jdField_a_of_type_Qlq.jdField_a_of_type_Long == 0L) && (localrjk.jdField_a_of_type_Qlq.jdField_c_of_type_Long == 0L) && (localrjk.jdField_a_of_type_Qlq.jdField_b_of_type_Long != 0L)) {
        localrjk.jdField_a_of_type_Qlq.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - localrjk.jdField_a_of_type_Qlq.jdField_b_of_type_Long);
      }
      localrjk.jdField_a_of_type_Qlq.jdField_a_of_type_Float = ((float)localrjk.jdField_a_of_type_Qlq.jdField_a_of_type_Long / localrjk.jdField_b_of_type_Int);
      localrjk.jdField_a_of_type_Qlq.jdField_a_of_type_Boolean = true;
      localrjk.jdField_a_of_type_Qlq.jdField_b_of_type_Boolean = true;
      localrjk.jdField_a_of_type_Qlq.jdField_m_of_type_Long = paramrjn.c();
      localrjk.jdField_a_of_type_Qlq.jdField_e_of_type_Int = paramrjn.c();
      localrjk.jdField_a_of_type_Qlq.jdField_f_of_type_Int = paramrjn.d();
      localrjk.jdField_a_of_type_Qlq.jdField_c_of_type_Boolean = paramrjn.jdField_b_of_type_Boolean;
      localrjk.jdField_a_of_type_Qlq.jdField_p_of_type_Long = paramrjn.jdField_b_of_type_Long;
      localrjk.jdField_a_of_type_Qlq.jdField_o_of_type_Long = paramrjn.jdField_a_of_type_Long;
      localrjk.jdField_a_of_type_Qlq.q = paramrjn.f();
      localrjk.jdField_a_of_type_Qlq.jdField_r_of_type_Long = paramrjn.f();
      localrjk.jdField_a_of_type_Qlq.jdField_f_of_type_JavaLangString = paramrjn.a();
      localrjk.jdField_a_of_type_Qlq.t = paramrjn.h();
      localrjk.jdField_a_of_type_Qlq.u = paramrjn.g();
      localrjk.jdField_a_of_type_Qlq.jdField_k_of_type_Int = this.a.c();
      localrjk.jdField_a_of_type_Qlq.jdField_l_of_type_Int = this.a.d();
      if (rjg.b(this.a) == null) {
        break label902;
      }
      paramrjn = localrjk.jdField_a_of_type_Qlq;
      i = rjg.b(this.a).jdField_a_of_type_Int;
      j = localrjk.jdField_a_of_type_Int;
      if (localrjk.m != 3) {
        break label896;
      }
      bool = true;
    }
    label896:
    label902:
    for (paramrjn.jdField_r_of_type_Int = ors.a(i, j, bool);; localrjk.jdField_a_of_type_Qlq.jdField_r_of_type_Int = -1)
    {
      localrjk.jdField_a_of_type_Qlq.jdField_c_of_type_Int = localrjk.m;
      rjg.a(this.a, localrjk);
      ors.a(rjg.a(this.a).getApplicationContext(), ors.a(), true, localrjk.jdField_a_of_type_Qlq.a());
      nse.a(localrjk.jdField_a_of_type_Qlq);
      ors.a(true, localrjk.jdField_a_of_type_Qlq.jdField_d_of_type_Boolean, localrjk.jdField_a_of_type_Qlq.jdField_f_of_type_Int, localrjk.jdField_a_of_type_Qlq.jdField_a_of_type_Int, localrjk.jdField_a_of_type_Qlq.jdField_c_of_type_Long, 56, localrjk.jdField_a_of_type_Qlq.jdField_c_of_type_JavaLangString, localrjk.jdField_a_of_type_Qlq.jdField_a_of_type_JavaLangString);
      if (localrjk.jdField_a_of_type_Qlq.jdField_a_of_type_Long > 0L)
      {
        new JSONObject();
        ThreadManager.post(new VideoPlayManager.1.3(this, localrjk, localrkb), 5, null, true);
      }
      azmj.b(null, "dc00899", "Pb_account_lifeservice", "", "0X800709B", "0X800709B", 0, 0, "", "", "", localrjk.jdField_c_of_type_JavaLangString);
      paramrjn = localrjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((paramrjn != null) && (oee.a((int)paramrjn.mChannelID)) && (AdvertisementInfo.isAdvertisementInfo(paramrjn)) && (localrjk.jdField_b_of_type_Boolean))
      {
        i = (int)l;
        noy.a(new obk().a(rjg.a(this.a)).a(noy.jdField_f_of_type_Int).b(noy.Q).a((AdvertisementInfo)paramrjn).a(noy.a(((AdvertisementInfo)paramrjn).adbt, i, ((AdvertisementInfo)paramrjn).getAdbf(), 1, ((AdvertisementInfo)paramrjn).adpa, ((AdvertisementInfo)paramrjn).adpb, paramrjn.mVideoDuration, 1, 0)).a());
      }
      paramrjn = localrjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((paramrjn != null) && (paramrjn.mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo(paramrjn))) {
        noy.a(new obk().a(rjg.a(this.a)).a(noy.jdField_f_of_type_Int).b(noy.M).a((AdvertisementInfo)paramrjn).a(noy.a(((AdvertisementInfo)paramrjn).adbt, paramrjn.mVideoDuration * 1000, ((AdvertisementInfo)paramrjn).getAdbf(), 1, ((AdvertisementInfo)paramrjn).adpa, ((AdvertisementInfo)paramrjn).adpb, paramrjn.mVideoDuration, noy.aF, 0)).a());
      }
      rjg.a(this.a).post(new VideoPlayManager.1.4(this));
      return;
      bool = false;
      break;
    }
  }
  
  public void a(rjn paramrjn, Object paramObject)
  {
    long l = 0L;
    paramObject = rjg.a(this.a);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onVideoPrepared() mIsOpenedVideo=" + rjg.a(this.a) + "   mVisable:" + rjg.b(this.a));
    }
    if (!rjg.a(this.a)) {}
    do
    {
      return;
      rjg.a(this.a, false);
      if ((rjg.a(this.a) == paramrjn) && (paramObject != null))
      {
        rjg.a(this.a).a(rjg.a(this.a), paramObject);
        rjg.a(this.a).a(paramObject.jdField_a_of_type_Int, true);
        if ((paramObject.jdField_a_of_type_Qlq != null) && (paramObject.jdField_a_of_type_Qlq.jdField_c_of_type_Long == 0L))
        {
          paramObject.jdField_a_of_type_Qlq.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - paramObject.jdField_a_of_type_Qlq.jdField_b_of_type_Long);
          Object localObject = paramObject.jdField_a_of_type_Qlq;
          ((qlq)localObject).jdField_e_of_type_Long += paramObject.jdField_a_of_type_Qlq.jdField_c_of_type_Long;
          localObject = paramObject.jdField_a_of_type_Qlq;
          ((qlq)localObject).jdField_b_of_type_Int += 1;
          localObject = paramrjn.a().getPlayDetailsTime();
          if ((localObject != null) && (paramObject.jdField_a_of_type_Qlq != null))
          {
            paramObject.jdField_a_of_type_Qlq.jdField_f_of_type_Long = Long.valueOf(((Properties)localObject).getProperty("httpdnsMS")).longValue();
            paramObject.jdField_a_of_type_Qlq.jdField_g_of_type_Long = Long.valueOf(((Properties)localObject).getProperty("httpredirectMS")).longValue();
            paramObject.jdField_a_of_type_Qlq.jdField_h_of_type_Long = Long.valueOf(((Properties)localObject).getProperty("cacheframeMS")).longValue();
            if (1 == paramObject.jdField_f_of_type_Int) {
              paramObject.jdField_a_of_type_Qlq.i = Long.valueOf(((Properties)localObject).getProperty("vidtourlMS")).longValue();
            }
            paramObject.jdField_a_of_type_Qlq.j = Long.valueOf(((Properties)localObject).getProperty("httpfirstrecvMS")).longValue();
            paramObject.jdField_a_of_type_Qlq.jdField_k_of_type_Long = Long.valueOf(((Properties)localObject).getProperty("getmp4headerMS")).longValue();
            paramObject.jdField_a_of_type_Qlq.jdField_l_of_type_Long = Long.valueOf(((Properties)localObject).getProperty("httpconnectMS")).longValue();
          }
          if ((paramObject.jdField_a_of_type_Qlq != null) && (QLog.isColorLevel())) {
            QLog.d("Q.readinjoy.video", 2, "video player ready. from open. prepare cost : " + paramObject.jdField_a_of_type_Qlq.jdField_c_of_type_Long);
          }
        }
        rjg.a(this.a, paramObject, rjg.a(this.a), 2, null);
        if ((rlb.a(rjg.a(this.a))) || (!GesturePWDUtils.isAppOnForeground(rjg.a(this.a))) || (rjg.a(this.a) == null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "onVideoPrepared start,in call stop.background:" + GesturePWDUtils.isAppOnForeground(rjg.a(this.a)));
          }
          rjg.a(this.a).post(new VideoPlayManager.1.1(this));
        }
        for (;;)
        {
          paramrjn = new StringBuilder().append(alpo.a(2131716709)).append(paramrjn.jdField_b_of_type_Boolean).append(alpo.a(2131716726));
          if (paramObject.jdField_a_of_type_Qlq != null) {
            l = paramObject.jdField_a_of_type_Qlq.jdField_c_of_type_Long;
          }
          paramrjn = l;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.readinjoy.video", 2, paramrjn);
          return;
          paramrjn.f();
          rjg.a(this.a, paramObject, rjg.a(this.a), 3, null);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.readinjoy.video", 2, "video player ready,but has error!");
  }
  
  public void a(rjn paramrjn, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if ((rjg.a(this.a) != null) && (rjg.a(this.a).jdField_a_of_type_Qlq != null)) {
      rjg.a(this.a).jdField_a_of_type_Qlq.jdField_h_of_type_JavaLangString = paramString;
    }
    rmc.a().a(paramrjn, rjg.a(this.a).jdField_b_of_type_Int, paramrjn.d());
  }
  
  public void a(rjn paramrjn, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onCaptureImage , id : " + paramInt2 + " succ : " + paramBoolean + " errCode : " + paramInt1);
    }
    if (rjg.a(this.a).size() >= 10)
    {
      paramrjn = (Pair)rjg.a(this.a).remove(0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "Capture Image Pool full ! remove first image, id : " + paramrjn.first);
      }
    }
    if (paramBoolean) {
      rjg.a(this.a).add(new Pair(Integer.valueOf(paramInt2), paramBitmap));
    }
    ((rjn)rjg.a(this.a).get(Integer.valueOf(paramInt2))).m();
  }
  
  public boolean a(rjn paramrjn, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null) {}
    for (paramObject = paramObject.toString();; paramObject = "")
    {
      paramObject = paramObject;
      if (QLog.isColorLevel()) {
        QLog.d(rjg.jdField_a_of_type_JavaLangString, 2, "video play has error ! " + paramObject);
      }
      this.a.jdField_a_of_type_Rjk = rjg.a(this.a);
      if (rjg.a(this.a) != null) {
        syb.a(rjg.a(this.a).j, rjg.a(this.a).jdField_c_of_type_JavaLangString, 1, paramInt2);
      }
      if (paramrjn == rjg.a(this.a)) {
        rjg.a(this.a).post(new VideoPlayManager.1.5(this, paramInt1, paramInt2, paramString, paramrjn));
      }
      return true;
    }
  }
  
  public boolean a(rjn paramrjn, int paramInt, Object paramObject)
  {
    if (paramrjn == rjg.a(this.a))
    {
      if (this.a.a() != 5) {
        break label73;
      }
      if (QLog.isColorLevel()) {
        QLog.d(rjg.jdField_a_of_type_JavaLangString, 2, "onInfo(): what:" + paramInt + ",extra:" + paramObject + ", getCurPlayState == paused, just ignore.");
      }
    }
    label73:
    label609:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
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
                          QLog.d(rjg.jdField_a_of_type_JavaLangString, 2, "onInfo(): video start buffering !");
                        }
                        rjg.a(this.a, rjg.a(this.a), rjg.a(this.a), 4, null);
                      }
                    } while (rjg.a(this.a) == null);
                    rjg.a(this.a).jdField_a_of_type_Qlq.jdField_d_of_type_Long = SystemClock.uptimeMillis();
                    return false;
                    if (QLog.isColorLevel()) {
                      QLog.d(rjg.jdField_a_of_type_JavaLangString, 2, "onInfo(): video end buffering ! isPause=" + this.a.d());
                    }
                    if (!this.a.d()) {
                      rjg.a(this.a, rjg.a(this.a), rjg.a(this.a), 3, null);
                    }
                  } while (rjg.a(this.a) == null);
                  paramrjn = rjg.a(this.a).jdField_a_of_type_Qlq;
                  paramrjn.jdField_e_of_type_Long += SystemClock.uptimeMillis() - rjg.a(this.a).jdField_a_of_type_Qlq.jdField_d_of_type_Long;
                  paramrjn = rjg.a(this.a).jdField_a_of_type_Qlq;
                  paramrjn.jdField_b_of_type_Int += 1;
                  return false;
                  if (QLog.isColorLevel()) {
                    QLog.d(rjg.jdField_a_of_type_JavaLangString, 2, "播放状态回调 onInfo() PLAYER_INFO_DECODER_BLOCK");
                  }
                } while ((rjg.a(this.a) == null) || (rjg.a(this.a).jdField_a_of_type_Qlq == null));
                paramrjn = rjg.a(this.a).jdField_a_of_type_Qlq;
                paramrjn.n += 1;
                return false;
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
                      if ((rjg.a(this.a) == null) || (rjg.a(this.a).jdField_a_of_type_Qlq == null)) {
                        break;
                      }
                      if (i > 0)
                      {
                        paramrjn = rjg.a(this.a).jdField_a_of_type_Qlq;
                        paramrjn.jdField_o_of_type_Int += i;
                      }
                      paramrjn = rjg.a(this.a).jdField_a_of_type_Qlq;
                      paramrjn.jdField_p_of_type_Int += i;
                      if (!QLog.isColorLevel()) {
                        break;
                      }
                      QLog.d(rjg.jdField_a_of_type_JavaLangString, 2, "播放状态回调 onInfo() PLAYER_INFO_SKIP_ONE_FRAME decoderMode = " + paramInt + ", skipFrameCount = " + i + ", totalSkipCount = " + rjg.a(this.a).jdField_a_of_type_Qlq.jdField_o_of_type_Int + ", finalSkipCount = " + rjg.a(this.a).jdField_a_of_type_Qlq.jdField_p_of_type_Int);
                      return false;
                    }
                    catch (Exception paramrjn)
                    {
                      int i;
                      break label609;
                    }
                    paramrjn = paramrjn;
                    paramInt = 0;
                  }
                  i = 0;
                }
                if (QLog.isColorLevel()) {
                  QLog.d(rjg.jdField_a_of_type_JavaLangString, 2, "播放状态回调 onInfo() PLAYER_INFO_HW_DECODE_FAILED");
                }
              } while ((rjg.a(this.a) == null) || (rjg.a(this.a).jdField_a_of_type_Qlq == null));
              rjg.a(this.a).jdField_a_of_type_Qlq.jdField_f_of_type_Boolean = true;
            } while (!(paramObject instanceof String));
            rjg.a(this.a).jdField_a_of_type_Qlq.jdField_g_of_type_JavaLangString = ((String)paramObject);
            return false;
            if (QLog.isColorLevel()) {
              QLog.d(rjg.jdField_a_of_type_JavaLangString, 2, "播放状态回调 onInfo() PLAYER_INFO_CHANGE_HW_BACKUP_URL");
            }
          } while ((rjg.a(this.a) == null) || (rjg.a(this.a).jdField_a_of_type_Qlq == null));
          rjg.a(this.a).jdField_a_of_type_Qlq.jdField_g_of_type_Boolean = true;
          return false;
        } while (paramObject == null);
        paramrjn = ((String)paramObject).split(":", 2);
      } while ((paramrjn == null) || (paramrjn.length != 2));
      if (QLog.isColorLevel()) {
        QLog.d("VideoPlayManager", 2, "Performance PERFORMANCE_REPORT videoPlayVideoParam:" + rjg.a(this.a) + "  method:" + paramrjn[0] + "\ntimeJson:" + paramrjn[1]);
      }
    } while ((!"prepare".equals(paramrjn[0])) || (rjg.a(this.a) == null) || (rjg.a(this.a).jdField_a_of_type_Qlq == null));
    rjg.a(this.a).jdField_a_of_type_Qlq.jdField_m_of_type_JavaLangString = paramrjn[1];
    return false;
  }
  
  public void d(rjn paramrjn)
  {
    if (QLog.isColorLevel()) {
      QLog.d(rjg.jdField_a_of_type_JavaLangString, 2, "onSeekComplete(): video seek complete ! curPlayState:" + rjm.a(this.a.a()));
    }
    if ((paramrjn == rjg.a(this.a)) && (this.a.a() != 5)) {
      rjg.a(this.a).f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rjh
 * JD-Core Version:    0.7.0.1
 */