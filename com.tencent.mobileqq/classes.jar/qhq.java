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

public class qhq
  extends qhx
{
  qhq(qhp paramqhp) {}
  
  public void a(TVK_NetVideoInfo paramTVK_NetVideoInfo)
  {
    if (qhp.a(this.a) == null) {
      return;
    }
    qhp.a(this.a).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo$DefnInfo = paramTVK_NetVideoInfo.getCurDefinition();
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
      ndn.a(null, "", "0X8008AEE", "0X8008AEE", 0, 0, "", "", "", new.a(qhp.a(this.a).jdField_c_of_type_JavaLangString, qhp.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID, (int)qhp.a(this.a).jdField_b_of_type_Long, localJSONObject), false);
      return;
      label212:
      i += 1;
    }
  }
  
  public void a(qhw paramqhw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "video play completion!");
    }
    if (qhp.a(this.a) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.readinjoy.video", 2, "onCompletion return for mVideoPlayerWrapper is null");
      }
      return;
    }
    long l = qhp.a(this.a).a(true);
    qhp.a(this.a, qhp.a(this.a));
    qhp.b(this.a, qhp.a(this.a));
    qht localqht;
    qik localqik;
    int i;
    int j;
    boolean bool;
    if (qhp.a(this.a) != null)
    {
      localqht = qhp.a(this.a);
      localqik = qhp.a(this.a);
      localqht.jdField_a_of_type_Pqb.jdField_a_of_type_Long = l;
      localqht.jdField_d_of_type_Long = this.a.a();
      if ((localqht.jdField_a_of_type_Pqb.jdField_a_of_type_Long == 0L) && (localqht.jdField_a_of_type_Pqb.jdField_c_of_type_Long == 0L) && (localqht.jdField_a_of_type_Pqb.jdField_b_of_type_Long != 0L)) {
        localqht.jdField_a_of_type_Pqb.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - localqht.jdField_a_of_type_Pqb.jdField_b_of_type_Long);
      }
      localqht.jdField_a_of_type_Pqb.jdField_a_of_type_Float = ((float)localqht.jdField_a_of_type_Pqb.jdField_a_of_type_Long / localqht.jdField_b_of_type_Int);
      localqht.jdField_a_of_type_Pqb.jdField_a_of_type_Boolean = true;
      localqht.jdField_a_of_type_Pqb.jdField_b_of_type_Boolean = true;
      localqht.jdField_a_of_type_Pqb.jdField_m_of_type_Long = paramqhw.c();
      localqht.jdField_a_of_type_Pqb.jdField_e_of_type_Int = paramqhw.c();
      localqht.jdField_a_of_type_Pqb.jdField_f_of_type_Int = paramqhw.d();
      localqht.jdField_a_of_type_Pqb.jdField_c_of_type_Boolean = paramqhw.jdField_b_of_type_Boolean;
      localqht.jdField_a_of_type_Pqb.jdField_p_of_type_Long = paramqhw.jdField_b_of_type_Long;
      localqht.jdField_a_of_type_Pqb.jdField_o_of_type_Long = paramqhw.jdField_a_of_type_Long;
      localqht.jdField_a_of_type_Pqb.q = paramqhw.e();
      localqht.jdField_a_of_type_Pqb.jdField_r_of_type_Long = paramqhw.h();
      localqht.jdField_a_of_type_Pqb.jdField_f_of_type_JavaLangString = paramqhw.a();
      localqht.jdField_a_of_type_Pqb.t = paramqhw.g();
      localqht.jdField_a_of_type_Pqb.u = paramqhw.f();
      localqht.jdField_a_of_type_Pqb.jdField_k_of_type_Int = this.a.c();
      localqht.jdField_a_of_type_Pqb.jdField_l_of_type_Int = this.a.d();
      if (qhp.b(this.a) == null) {
        break label901;
      }
      paramqhw = localqht.jdField_a_of_type_Pqb;
      i = qhp.b(this.a).jdField_a_of_type_Int;
      j = localqht.jdField_a_of_type_Int;
      if (localqht.m != 3) {
        break label895;
      }
      bool = true;
    }
    label901:
    for (paramqhw.jdField_r_of_type_Int = obz.a(i, j, bool);; localqht.jdField_a_of_type_Pqb.jdField_r_of_type_Int = -1)
    {
      localqht.jdField_a_of_type_Pqb.jdField_c_of_type_Int = localqht.m;
      qhp.a(this.a, localqht);
      obz.a(qhp.a(this.a).getApplicationContext(), obz.a(), true, localqht.jdField_a_of_type_Pqb.a());
      ndy.a(localqht.jdField_a_of_type_Pqb);
      obz.a(true, localqht.jdField_a_of_type_Pqb.jdField_d_of_type_Boolean, localqht.jdField_a_of_type_Pqb.jdField_f_of_type_Int, localqht.jdField_a_of_type_Pqb.jdField_a_of_type_Int, localqht.jdField_a_of_type_Pqb.jdField_c_of_type_Long, 56, localqht.jdField_a_of_type_Pqb.jdField_c_of_type_JavaLangString, localqht.jdField_a_of_type_Pqb.jdField_a_of_type_JavaLangString);
      if (localqht.jdField_a_of_type_Pqb.jdField_a_of_type_Long > 0L)
      {
        new JSONObject();
        ThreadManager.post(new VideoPlayManager.1.3(this, localqht, localqik), 5, null, true);
      }
      awqx.b(null, "dc00899", "Pb_account_lifeservice", "", "0X800709B", "0X800709B", 0, 0, "", "", "", localqht.jdField_c_of_type_JavaLangString);
      paramqhw = localqht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((paramqhw != null) && (npj.a((int)paramqhw.mChannelID)) && (AdvertisementInfo.isAdvertisementInfo(paramqhw)) && (localqht.jdField_b_of_type_Boolean))
      {
        i = (int)l;
        nbe.a(new nmv().a(qhp.a(this.a)).a(nbe.jdField_f_of_type_Int).b(nbe.Q).a((AdvertisementInfo)paramqhw).a(nbe.a(((AdvertisementInfo)paramqhw).adbt, i, ((AdvertisementInfo)paramqhw).getAdbf(), 1, ((AdvertisementInfo)paramqhw).adpa, ((AdvertisementInfo)paramqhw).adpb, paramqhw.mVideoDuration, 1, 0)).a());
      }
      paramqhw = localqht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((paramqhw != null) && (paramqhw.mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo(paramqhw))) {
        nbe.a(new nmv().a(qhp.a(this.a)).a(nbe.jdField_f_of_type_Int).b(nbe.M).a((AdvertisementInfo)paramqhw).a(nbe.a(((AdvertisementInfo)paramqhw).adbt, paramqhw.mVideoDuration * 1000, ((AdvertisementInfo)paramqhw).getAdbf(), 1, ((AdvertisementInfo)paramqhw).adpa, ((AdvertisementInfo)paramqhw).adpb, paramqhw.mVideoDuration, nbe.aE, 0)).a());
      }
      qhp.a(this.a).post(new VideoPlayManager.1.4(this));
      return;
      label895:
      bool = false;
      break;
    }
  }
  
  public void a(qhw paramqhw, Object paramObject)
  {
    long l = 0L;
    paramObject = qhp.a(this.a);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onVideoPrepared() mIsOpenedVideo=" + qhp.a(this.a) + "   mVisable:" + qhp.b(this.a));
    }
    if (!qhp.a(this.a)) {}
    do
    {
      return;
      qhp.a(this.a, false);
      if ((qhp.a(this.a) == paramqhw) && (paramObject != null))
      {
        qhp.a(this.a).c(paramObject.jdField_f_of_type_Int);
        qhp.a(this.a).a(paramObject.jdField_a_of_type_Int, true);
        if ((paramObject.jdField_a_of_type_Pqb != null) && (paramObject.jdField_a_of_type_Pqb.jdField_c_of_type_Long == 0L))
        {
          paramObject.jdField_a_of_type_Pqb.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - paramObject.jdField_a_of_type_Pqb.jdField_b_of_type_Long);
          Object localObject = paramObject.jdField_a_of_type_Pqb;
          ((pqb)localObject).jdField_e_of_type_Long += paramObject.jdField_a_of_type_Pqb.jdField_c_of_type_Long;
          localObject = paramObject.jdField_a_of_type_Pqb;
          ((pqb)localObject).jdField_b_of_type_Int += 1;
          localObject = paramqhw.a().getPlayDetailsTime();
          if ((localObject != null) && (paramObject.jdField_a_of_type_Pqb != null))
          {
            paramObject.jdField_a_of_type_Pqb.jdField_f_of_type_Long = Long.valueOf(((Properties)localObject).getProperty("httpdnsMS")).longValue();
            paramObject.jdField_a_of_type_Pqb.jdField_g_of_type_Long = Long.valueOf(((Properties)localObject).getProperty("httpredirectMS")).longValue();
            paramObject.jdField_a_of_type_Pqb.jdField_h_of_type_Long = Long.valueOf(((Properties)localObject).getProperty("cacheframeMS")).longValue();
            if (1 == paramObject.jdField_f_of_type_Int) {
              paramObject.jdField_a_of_type_Pqb.i = Long.valueOf(((Properties)localObject).getProperty("vidtourlMS")).longValue();
            }
            paramObject.jdField_a_of_type_Pqb.j = Long.valueOf(((Properties)localObject).getProperty("httpfirstrecvMS")).longValue();
            paramObject.jdField_a_of_type_Pqb.jdField_k_of_type_Long = Long.valueOf(((Properties)localObject).getProperty("getmp4headerMS")).longValue();
            paramObject.jdField_a_of_type_Pqb.jdField_l_of_type_Long = Long.valueOf(((Properties)localObject).getProperty("httpconnectMS")).longValue();
          }
          if ((paramObject.jdField_a_of_type_Pqb != null) && (QLog.isColorLevel())) {
            QLog.d("Q.readinjoy.video", 2, "video player ready. from open. prepare cost : " + paramObject.jdField_a_of_type_Pqb.jdField_c_of_type_Long);
          }
        }
        qhp.a(this.a, paramObject, qhp.a(this.a), 2, null);
        if ((qji.a(qhp.a(this.a))) || (!GesturePWDUtils.isAppOnForeground(qhp.a(this.a))) || (qhp.a(this.a) == null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "onVideoPrepared start,in call stop.background:" + GesturePWDUtils.isAppOnForeground(qhp.a(this.a)));
          }
          qhp.a(this.a).post(new VideoPlayManager.1.1(this));
        }
        for (;;)
        {
          paramqhw = new StringBuilder().append(ajjy.a(2131650535)).append(paramqhw.jdField_b_of_type_Boolean).append(ajjy.a(2131650552));
          if (paramObject.jdField_a_of_type_Pqb != null) {
            l = paramObject.jdField_a_of_type_Pqb.jdField_c_of_type_Long;
          }
          paramqhw = l;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.readinjoy.video", 2, paramqhw);
          return;
          paramqhw.f();
          qhp.a(this.a, paramObject, qhp.a(this.a), 3, null);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.readinjoy.video", 2, "video player ready,but has error!");
  }
  
  public void a(qhw paramqhw, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((qhp.a(this.a) == null) || (qhp.a(this.a).jdField_a_of_type_Pqb == null)) {
      return;
    }
    qhp.a(this.a).jdField_a_of_type_Pqb.jdField_h_of_type_JavaLangString = paramString;
  }
  
  public void a(qhw paramqhw, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onCaptureImage , id : " + paramInt2 + " succ : " + paramBoolean + " errCode : " + paramInt1);
    }
    if (qhp.a(this.a).size() >= 10)
    {
      paramqhw = (Pair)qhp.a(this.a).remove(0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "Capture Image Pool full ! remove first image, id : " + paramqhw.first);
      }
    }
    if (paramBoolean) {
      qhp.a(this.a).add(new Pair(Integer.valueOf(paramInt2), paramBitmap));
    }
    ((qhw)qhp.a(this.a).get(Integer.valueOf(paramInt2))).m();
  }
  
  public boolean a(qhw paramqhw, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null) {}
    for (paramObject = paramObject.toString();; paramObject = "")
    {
      paramObject = paramObject;
      if (QLog.isColorLevel()) {
        QLog.d(qhp.jdField_a_of_type_JavaLangString, 2, "video play has error ! " + paramObject);
      }
      if (qhp.a(this.a) != null) {
        rtr.a(qhp.a(this.a).j, qhp.a(this.a).jdField_c_of_type_JavaLangString, 1, paramInt2);
      }
      if (paramqhw == qhp.a(this.a)) {
        qhp.a(this.a).post(new VideoPlayManager.1.5(this, paramInt1, paramInt2, paramString, paramqhw));
      }
      return true;
    }
  }
  
  public boolean a(qhw paramqhw, int paramInt, Object paramObject)
  {
    if (paramqhw == qhp.a(this.a))
    {
      if (this.a.a() != 5) {
        break label73;
      }
      if (QLog.isColorLevel()) {
        QLog.d(qhp.jdField_a_of_type_JavaLangString, 2, "onInfo(): what:" + paramInt + ",extra:" + paramObject + ", getCurPlayState == paused, just ignore.");
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
                          QLog.d(qhp.jdField_a_of_type_JavaLangString, 2, "onInfo(): video start buffering !");
                        }
                        qhp.a(this.a, qhp.a(this.a), qhp.a(this.a), 4, null);
                      }
                    } while (qhp.a(this.a) == null);
                    qhp.a(this.a).jdField_a_of_type_Pqb.jdField_d_of_type_Long = SystemClock.uptimeMillis();
                    return false;
                    if (QLog.isColorLevel()) {
                      QLog.d(qhp.jdField_a_of_type_JavaLangString, 2, "onInfo(): video end buffering ! isPause=" + this.a.c());
                    }
                    if (!this.a.c()) {
                      qhp.a(this.a, qhp.a(this.a), qhp.a(this.a), 3, null);
                    }
                  } while (qhp.a(this.a) == null);
                  paramqhw = qhp.a(this.a).jdField_a_of_type_Pqb;
                  paramqhw.jdField_e_of_type_Long += SystemClock.uptimeMillis() - qhp.a(this.a).jdField_a_of_type_Pqb.jdField_d_of_type_Long;
                  paramqhw = qhp.a(this.a).jdField_a_of_type_Pqb;
                  paramqhw.jdField_b_of_type_Int += 1;
                  return false;
                  if (QLog.isColorLevel()) {
                    QLog.d(qhp.jdField_a_of_type_JavaLangString, 2, "播放状态回调 onInfo() PLAYER_INFO_DECODER_BLOCK");
                  }
                } while ((qhp.a(this.a) == null) || (qhp.a(this.a).jdField_a_of_type_Pqb == null));
                paramqhw = qhp.a(this.a).jdField_a_of_type_Pqb;
                paramqhw.n += 1;
                return false;
                for (;;)
                {
                  try
                  {
                    paramqhw = new JSONObject((String)paramObject);
                    paramInt = paramqhw.optInt("decoderMode", 0);
                  }
                  catch (Exception paramqhw)
                  {
                    try
                    {
                      i = paramqhw.optInt("skipFrameCount", 1);
                      if ((qhp.a(this.a) == null) || (qhp.a(this.a).jdField_a_of_type_Pqb == null)) {
                        break;
                      }
                      if (i > 0)
                      {
                        paramqhw = qhp.a(this.a).jdField_a_of_type_Pqb;
                        paramqhw.jdField_o_of_type_Int += i;
                      }
                      paramqhw = qhp.a(this.a).jdField_a_of_type_Pqb;
                      paramqhw.jdField_p_of_type_Int += i;
                      if (!QLog.isColorLevel()) {
                        break;
                      }
                      QLog.d(qhp.jdField_a_of_type_JavaLangString, 2, "播放状态回调 onInfo() PLAYER_INFO_SKIP_ONE_FRAME decoderMode = " + paramInt + ", skipFrameCount = " + i + ", totalSkipCount = " + qhp.a(this.a).jdField_a_of_type_Pqb.jdField_o_of_type_Int + ", finalSkipCount = " + qhp.a(this.a).jdField_a_of_type_Pqb.jdField_p_of_type_Int);
                      return false;
                    }
                    catch (Exception paramqhw)
                    {
                      int i;
                      break label609;
                    }
                    paramqhw = paramqhw;
                    paramInt = 0;
                  }
                  i = 0;
                }
                if (QLog.isColorLevel()) {
                  QLog.d(qhp.jdField_a_of_type_JavaLangString, 2, "播放状态回调 onInfo() PLAYER_INFO_HW_DECODE_FAILED");
                }
              } while ((qhp.a(this.a) == null) || (qhp.a(this.a).jdField_a_of_type_Pqb == null));
              qhp.a(this.a).jdField_a_of_type_Pqb.jdField_f_of_type_Boolean = true;
            } while (!(paramObject instanceof String));
            qhp.a(this.a).jdField_a_of_type_Pqb.jdField_g_of_type_JavaLangString = ((String)paramObject);
            return false;
            if (QLog.isColorLevel()) {
              QLog.d(qhp.jdField_a_of_type_JavaLangString, 2, "播放状态回调 onInfo() PLAYER_INFO_CHANGE_HW_BACKUP_URL");
            }
          } while ((qhp.a(this.a) == null) || (qhp.a(this.a).jdField_a_of_type_Pqb == null));
          qhp.a(this.a).jdField_a_of_type_Pqb.jdField_g_of_type_Boolean = true;
          return false;
        } while (paramObject == null);
        paramqhw = ((String)paramObject).split(":", 2);
      } while ((paramqhw == null) || (paramqhw.length != 2));
      if (QLog.isColorLevel()) {
        QLog.d("VideoPlayManager", 2, "Performance PERFORMANCE_REPORT videoPlayVideoParam:" + qhp.a(this.a) + "  method:" + paramqhw[0] + "\ntimeJson:" + paramqhw[1]);
      }
    } while ((!"prepare".equals(paramqhw[0])) || (qhp.a(this.a) == null) || (qhp.a(this.a).jdField_a_of_type_Pqb == null));
    qhp.a(this.a).jdField_a_of_type_Pqb.jdField_m_of_type_JavaLangString = paramqhw[1];
    return false;
  }
  
  public void d(qhw paramqhw)
  {
    if (QLog.isColorLevel()) {
      QLog.d(qhp.jdField_a_of_type_JavaLangString, 2, "onSeekComplete(): video seek complete ! curPlayState:" + qhv.a(this.a.a()));
    }
    if ((paramqhw == qhp.a(this.a)) && (this.a.a() != 5)) {
      qhp.a(this.a).f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qhq
 * JD-Core Version:    0.7.0.1
 */