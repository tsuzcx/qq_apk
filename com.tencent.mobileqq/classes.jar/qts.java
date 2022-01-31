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

public class qts
  extends qtz
{
  qts(qtr paramqtr) {}
  
  public void a(TVK_NetVideoInfo paramTVK_NetVideoInfo)
  {
    if (qtr.a(this.a) == null) {
      return;
    }
    qtr.a(this.a).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo$DefnInfo = paramTVK_NetVideoInfo.getCurDefinition();
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
      nol.a(null, "", "0X8008AEE", "0X8008AEE", 0, 0, "", "", "", npu.a(qtr.a(this.a).jdField_c_of_type_JavaLangString, qtr.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID, (int)qtr.a(this.a).jdField_b_of_type_Long, localJSONObject), false);
      return;
      label212:
      i += 1;
    }
  }
  
  public void a(qty paramqty)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "video play completion!");
    }
    if (qtr.a(this.a) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.readinjoy.video", 2, "onCompletion return for mVideoPlayerWrapper is null");
      }
      return;
    }
    long l = qtr.a(this.a).a(true);
    qtr.a(this.a, qtr.a(this.a));
    qtr.b(this.a, qtr.a(this.a));
    qtv localqtv;
    qum localqum;
    int i;
    int j;
    boolean bool;
    if (qtr.a(this.a) != null)
    {
      localqtv = qtr.a(this.a);
      localqum = qtr.a(this.a);
      localqtv.jdField_a_of_type_Qbu.jdField_a_of_type_Long = l;
      localqtv.jdField_d_of_type_Long = this.a.a();
      if ((localqtv.jdField_a_of_type_Qbu.jdField_a_of_type_Long == 0L) && (localqtv.jdField_a_of_type_Qbu.jdField_c_of_type_Long == 0L) && (localqtv.jdField_a_of_type_Qbu.jdField_b_of_type_Long != 0L)) {
        localqtv.jdField_a_of_type_Qbu.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - localqtv.jdField_a_of_type_Qbu.jdField_b_of_type_Long);
      }
      localqtv.jdField_a_of_type_Qbu.jdField_a_of_type_Float = ((float)localqtv.jdField_a_of_type_Qbu.jdField_a_of_type_Long / localqtv.jdField_b_of_type_Int);
      localqtv.jdField_a_of_type_Qbu.jdField_a_of_type_Boolean = true;
      localqtv.jdField_a_of_type_Qbu.jdField_b_of_type_Boolean = true;
      localqtv.jdField_a_of_type_Qbu.jdField_m_of_type_Long = paramqty.c();
      localqtv.jdField_a_of_type_Qbu.jdField_e_of_type_Int = paramqty.c();
      localqtv.jdField_a_of_type_Qbu.jdField_f_of_type_Int = paramqty.d();
      localqtv.jdField_a_of_type_Qbu.jdField_c_of_type_Boolean = paramqty.jdField_b_of_type_Boolean;
      localqtv.jdField_a_of_type_Qbu.jdField_p_of_type_Long = paramqty.jdField_b_of_type_Long;
      localqtv.jdField_a_of_type_Qbu.jdField_o_of_type_Long = paramqty.jdField_a_of_type_Long;
      localqtv.jdField_a_of_type_Qbu.q = paramqty.f();
      localqtv.jdField_a_of_type_Qbu.jdField_r_of_type_Long = paramqty.i();
      localqtv.jdField_a_of_type_Qbu.jdField_f_of_type_JavaLangString = paramqty.a();
      localqtv.jdField_a_of_type_Qbu.t = paramqty.h();
      localqtv.jdField_a_of_type_Qbu.u = paramqty.g();
      localqtv.jdField_a_of_type_Qbu.jdField_k_of_type_Int = this.a.c();
      localqtv.jdField_a_of_type_Qbu.jdField_l_of_type_Int = this.a.d();
      if (qtr.b(this.a) == null) {
        break label901;
      }
      paramqty = localqtv.jdField_a_of_type_Qbu;
      i = qtr.b(this.a).jdField_a_of_type_Int;
      j = localqtv.jdField_a_of_type_Int;
      if (localqtv.m != 3) {
        break label895;
      }
      bool = true;
    }
    label901:
    for (paramqty.jdField_r_of_type_Int = onh.a(i, j, bool);; localqtv.jdField_a_of_type_Qbu.jdField_r_of_type_Int = -1)
    {
      localqtv.jdField_a_of_type_Qbu.jdField_c_of_type_Int = localqtv.m;
      qtr.a(this.a, localqtv);
      onh.a(qtr.a(this.a).getApplicationContext(), onh.a(), true, localqtv.jdField_a_of_type_Qbu.a());
      now.a(localqtv.jdField_a_of_type_Qbu);
      onh.a(true, localqtv.jdField_a_of_type_Qbu.jdField_d_of_type_Boolean, localqtv.jdField_a_of_type_Qbu.jdField_f_of_type_Int, localqtv.jdField_a_of_type_Qbu.jdField_a_of_type_Int, localqtv.jdField_a_of_type_Qbu.jdField_c_of_type_Long, 56, localqtv.jdField_a_of_type_Qbu.jdField_c_of_type_JavaLangString, localqtv.jdField_a_of_type_Qbu.jdField_a_of_type_JavaLangString);
      if (localqtv.jdField_a_of_type_Qbu.jdField_a_of_type_Long > 0L)
      {
        new JSONObject();
        ThreadManager.post(new VideoPlayManager.1.3(this, localqtv, localqum), 5, null, true);
      }
      axqy.b(null, "dc00899", "Pb_account_lifeservice", "", "0X800709B", "0X800709B", 0, 0, "", "", "", localqtv.jdField_c_of_type_JavaLangString);
      paramqty = localqtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((paramqty != null) && (oar.a((int)paramqty.mChannelID)) && (AdvertisementInfo.isAdvertisementInfo(paramqty)) && (localqtv.jdField_b_of_type_Boolean))
      {
        i = (int)l;
        nmc.a(new nyd().a(qtr.a(this.a)).a(nmc.jdField_f_of_type_Int).b(nmc.Q).a((AdvertisementInfo)paramqty).a(nmc.a(((AdvertisementInfo)paramqty).adbt, i, ((AdvertisementInfo)paramqty).getAdbf(), 1, ((AdvertisementInfo)paramqty).adpa, ((AdvertisementInfo)paramqty).adpb, paramqty.mVideoDuration, 1, 0)).a());
      }
      paramqty = localqtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((paramqty != null) && (paramqty.mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo(paramqty))) {
        nmc.a(new nyd().a(qtr.a(this.a)).a(nmc.jdField_f_of_type_Int).b(nmc.M).a((AdvertisementInfo)paramqty).a(nmc.a(((AdvertisementInfo)paramqty).adbt, paramqty.mVideoDuration * 1000, ((AdvertisementInfo)paramqty).getAdbf(), 1, ((AdvertisementInfo)paramqty).adpa, ((AdvertisementInfo)paramqty).adpb, paramqty.mVideoDuration, nmc.aF, 0)).a());
      }
      qtr.a(this.a).post(new VideoPlayManager.1.4(this));
      return;
      label895:
      bool = false;
      break;
    }
  }
  
  public void a(qty paramqty, Object paramObject)
  {
    long l = 0L;
    paramObject = qtr.a(this.a);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onVideoPrepared() mIsOpenedVideo=" + qtr.a(this.a) + "   mVisable:" + qtr.b(this.a));
    }
    if (!qtr.a(this.a)) {}
    do
    {
      return;
      qtr.a(this.a, false);
      if ((qtr.a(this.a) == paramqty) && (paramObject != null))
      {
        qtr.a(this.a).c(paramObject.jdField_f_of_type_Int);
        qtr.a(this.a).a(paramObject.jdField_a_of_type_Int, true);
        if ((paramObject.jdField_a_of_type_Qbu != null) && (paramObject.jdField_a_of_type_Qbu.jdField_c_of_type_Long == 0L))
        {
          paramObject.jdField_a_of_type_Qbu.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - paramObject.jdField_a_of_type_Qbu.jdField_b_of_type_Long);
          Object localObject = paramObject.jdField_a_of_type_Qbu;
          ((qbu)localObject).jdField_e_of_type_Long += paramObject.jdField_a_of_type_Qbu.jdField_c_of_type_Long;
          localObject = paramObject.jdField_a_of_type_Qbu;
          ((qbu)localObject).jdField_b_of_type_Int += 1;
          localObject = paramqty.a().getPlayDetailsTime();
          if ((localObject != null) && (paramObject.jdField_a_of_type_Qbu != null))
          {
            paramObject.jdField_a_of_type_Qbu.jdField_f_of_type_Long = Long.valueOf(((Properties)localObject).getProperty("httpdnsMS")).longValue();
            paramObject.jdField_a_of_type_Qbu.jdField_g_of_type_Long = Long.valueOf(((Properties)localObject).getProperty("httpredirectMS")).longValue();
            paramObject.jdField_a_of_type_Qbu.jdField_h_of_type_Long = Long.valueOf(((Properties)localObject).getProperty("cacheframeMS")).longValue();
            if (1 == paramObject.jdField_f_of_type_Int) {
              paramObject.jdField_a_of_type_Qbu.i = Long.valueOf(((Properties)localObject).getProperty("vidtourlMS")).longValue();
            }
            paramObject.jdField_a_of_type_Qbu.j = Long.valueOf(((Properties)localObject).getProperty("httpfirstrecvMS")).longValue();
            paramObject.jdField_a_of_type_Qbu.jdField_k_of_type_Long = Long.valueOf(((Properties)localObject).getProperty("getmp4headerMS")).longValue();
            paramObject.jdField_a_of_type_Qbu.jdField_l_of_type_Long = Long.valueOf(((Properties)localObject).getProperty("httpconnectMS")).longValue();
          }
          if ((paramObject.jdField_a_of_type_Qbu != null) && (QLog.isColorLevel())) {
            QLog.d("Q.readinjoy.video", 2, "video player ready. from open. prepare cost : " + paramObject.jdField_a_of_type_Qbu.jdField_c_of_type_Long);
          }
        }
        qtr.a(this.a, paramObject, qtr.a(this.a), 2, null);
        if ((qvk.a(qtr.a(this.a))) || (!GesturePWDUtils.isAppOnForeground(qtr.a(this.a))) || (qtr.a(this.a) == null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "onVideoPrepared start,in call stop.background:" + GesturePWDUtils.isAppOnForeground(qtr.a(this.a)));
          }
          qtr.a(this.a).post(new VideoPlayManager.1.1(this));
        }
        for (;;)
        {
          paramqty = new StringBuilder().append(ajya.a(2131716337)).append(paramqty.jdField_b_of_type_Boolean).append(ajya.a(2131716354));
          if (paramObject.jdField_a_of_type_Qbu != null) {
            l = paramObject.jdField_a_of_type_Qbu.jdField_c_of_type_Long;
          }
          paramqty = l;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.readinjoy.video", 2, paramqty);
          return;
          paramqty.f();
          qtr.a(this.a, paramObject, qtr.a(this.a), 3, null);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.readinjoy.video", 2, "video player ready,but has error!");
  }
  
  public void a(qty paramqty, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((qtr.a(this.a) == null) || (qtr.a(this.a).jdField_a_of_type_Qbu == null)) {
      return;
    }
    qtr.a(this.a).jdField_a_of_type_Qbu.jdField_h_of_type_JavaLangString = paramString;
  }
  
  public void a(qty paramqty, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onCaptureImage , id : " + paramInt2 + " succ : " + paramBoolean + " errCode : " + paramInt1);
    }
    if (qtr.a(this.a).size() >= 10)
    {
      paramqty = (Pair)qtr.a(this.a).remove(0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "Capture Image Pool full ! remove first image, id : " + paramqty.first);
      }
    }
    if (paramBoolean) {
      qtr.a(this.a).add(new Pair(Integer.valueOf(paramInt2), paramBitmap));
    }
    ((qty)qtr.a(this.a).get(Integer.valueOf(paramInt2))).m();
  }
  
  public boolean a(qty paramqty, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null) {}
    for (paramObject = paramObject.toString();; paramObject = "")
    {
      paramObject = paramObject;
      if (QLog.isColorLevel()) {
        QLog.d(qtr.jdField_a_of_type_JavaLangString, 2, "video play has error ! " + paramObject);
      }
      this.a.jdField_a_of_type_Qtv = qtr.a(this.a);
      if (qtr.a(this.a) != null) {
        sgg.a(qtr.a(this.a).j, qtr.a(this.a).jdField_c_of_type_JavaLangString, 1, paramInt2);
      }
      if (paramqty == qtr.a(this.a)) {
        qtr.a(this.a).post(new VideoPlayManager.1.5(this, paramInt1, paramInt2, paramString, paramqty));
      }
      return true;
    }
  }
  
  public boolean a(qty paramqty, int paramInt, Object paramObject)
  {
    if (paramqty == qtr.a(this.a))
    {
      if (this.a.a() != 5) {
        break label73;
      }
      if (QLog.isColorLevel()) {
        QLog.d(qtr.jdField_a_of_type_JavaLangString, 2, "onInfo(): what:" + paramInt + ",extra:" + paramObject + ", getCurPlayState == paused, just ignore.");
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
                          QLog.d(qtr.jdField_a_of_type_JavaLangString, 2, "onInfo(): video start buffering !");
                        }
                        qtr.a(this.a, qtr.a(this.a), qtr.a(this.a), 4, null);
                      }
                    } while (qtr.a(this.a) == null);
                    qtr.a(this.a).jdField_a_of_type_Qbu.jdField_d_of_type_Long = SystemClock.uptimeMillis();
                    return false;
                    if (QLog.isColorLevel()) {
                      QLog.d(qtr.jdField_a_of_type_JavaLangString, 2, "onInfo(): video end buffering ! isPause=" + this.a.d());
                    }
                    if (!this.a.d()) {
                      qtr.a(this.a, qtr.a(this.a), qtr.a(this.a), 3, null);
                    }
                  } while (qtr.a(this.a) == null);
                  paramqty = qtr.a(this.a).jdField_a_of_type_Qbu;
                  paramqty.jdField_e_of_type_Long += SystemClock.uptimeMillis() - qtr.a(this.a).jdField_a_of_type_Qbu.jdField_d_of_type_Long;
                  paramqty = qtr.a(this.a).jdField_a_of_type_Qbu;
                  paramqty.jdField_b_of_type_Int += 1;
                  return false;
                  if (QLog.isColorLevel()) {
                    QLog.d(qtr.jdField_a_of_type_JavaLangString, 2, "播放状态回调 onInfo() PLAYER_INFO_DECODER_BLOCK");
                  }
                } while ((qtr.a(this.a) == null) || (qtr.a(this.a).jdField_a_of_type_Qbu == null));
                paramqty = qtr.a(this.a).jdField_a_of_type_Qbu;
                paramqty.n += 1;
                return false;
                for (;;)
                {
                  try
                  {
                    paramqty = new JSONObject((String)paramObject);
                    paramInt = paramqty.optInt("decoderMode", 0);
                  }
                  catch (Exception paramqty)
                  {
                    try
                    {
                      i = paramqty.optInt("skipFrameCount", 1);
                      if ((qtr.a(this.a) == null) || (qtr.a(this.a).jdField_a_of_type_Qbu == null)) {
                        break;
                      }
                      if (i > 0)
                      {
                        paramqty = qtr.a(this.a).jdField_a_of_type_Qbu;
                        paramqty.jdField_o_of_type_Int += i;
                      }
                      paramqty = qtr.a(this.a).jdField_a_of_type_Qbu;
                      paramqty.jdField_p_of_type_Int += i;
                      if (!QLog.isColorLevel()) {
                        break;
                      }
                      QLog.d(qtr.jdField_a_of_type_JavaLangString, 2, "播放状态回调 onInfo() PLAYER_INFO_SKIP_ONE_FRAME decoderMode = " + paramInt + ", skipFrameCount = " + i + ", totalSkipCount = " + qtr.a(this.a).jdField_a_of_type_Qbu.jdField_o_of_type_Int + ", finalSkipCount = " + qtr.a(this.a).jdField_a_of_type_Qbu.jdField_p_of_type_Int);
                      return false;
                    }
                    catch (Exception paramqty)
                    {
                      int i;
                      break label609;
                    }
                    paramqty = paramqty;
                    paramInt = 0;
                  }
                  i = 0;
                }
                if (QLog.isColorLevel()) {
                  QLog.d(qtr.jdField_a_of_type_JavaLangString, 2, "播放状态回调 onInfo() PLAYER_INFO_HW_DECODE_FAILED");
                }
              } while ((qtr.a(this.a) == null) || (qtr.a(this.a).jdField_a_of_type_Qbu == null));
              qtr.a(this.a).jdField_a_of_type_Qbu.jdField_f_of_type_Boolean = true;
            } while (!(paramObject instanceof String));
            qtr.a(this.a).jdField_a_of_type_Qbu.jdField_g_of_type_JavaLangString = ((String)paramObject);
            return false;
            if (QLog.isColorLevel()) {
              QLog.d(qtr.jdField_a_of_type_JavaLangString, 2, "播放状态回调 onInfo() PLAYER_INFO_CHANGE_HW_BACKUP_URL");
            }
          } while ((qtr.a(this.a) == null) || (qtr.a(this.a).jdField_a_of_type_Qbu == null));
          qtr.a(this.a).jdField_a_of_type_Qbu.jdField_g_of_type_Boolean = true;
          return false;
        } while (paramObject == null);
        paramqty = ((String)paramObject).split(":", 2);
      } while ((paramqty == null) || (paramqty.length != 2));
      if (QLog.isColorLevel()) {
        QLog.d("VideoPlayManager", 2, "Performance PERFORMANCE_REPORT videoPlayVideoParam:" + qtr.a(this.a) + "  method:" + paramqty[0] + "\ntimeJson:" + paramqty[1]);
      }
    } while ((!"prepare".equals(paramqty[0])) || (qtr.a(this.a) == null) || (qtr.a(this.a).jdField_a_of_type_Qbu == null));
    qtr.a(this.a).jdField_a_of_type_Qbu.jdField_m_of_type_JavaLangString = paramqty[1];
    return false;
  }
  
  public void d(qty paramqty)
  {
    if (QLog.isColorLevel()) {
      QLog.d(qtr.jdField_a_of_type_JavaLangString, 2, "onSeekComplete(): video seek complete ! curPlayState:" + qtx.a(this.a.a()));
    }
    if ((paramqty == qtr.a(this.a)) && (this.a.a() != 5)) {
      qtr.a(this.a).f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qts
 * JD-Core Version:    0.7.0.1
 */