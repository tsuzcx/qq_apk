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

public class qtv
  extends quc
{
  qtv(qtu paramqtu) {}
  
  public void a(TVK_NetVideoInfo paramTVK_NetVideoInfo)
  {
    if (qtu.a(this.a) == null) {
      return;
    }
    qtu.a(this.a).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo$DefnInfo = paramTVK_NetVideoInfo.getCurDefinition();
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
      noo.a(null, "", "0X8008AEE", "0X8008AEE", 0, 0, "", "", "", npx.a(qtu.a(this.a).jdField_c_of_type_JavaLangString, qtu.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID, (int)qtu.a(this.a).jdField_b_of_type_Long, localJSONObject), false);
      return;
      label212:
      i += 1;
    }
  }
  
  public void a(qub paramqub)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "video play completion!");
    }
    if (qtu.a(this.a) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.readinjoy.video", 2, "onCompletion return for mVideoPlayerWrapper is null");
      }
      return;
    }
    long l = qtu.a(this.a).a(true);
    qtu.a(this.a, qtu.a(this.a));
    qtu.b(this.a, qtu.a(this.a));
    qty localqty;
    qup localqup;
    int i;
    int j;
    boolean bool;
    if (qtu.a(this.a) != null)
    {
      localqty = qtu.a(this.a);
      localqup = qtu.a(this.a);
      localqty.jdField_a_of_type_Qbx.jdField_a_of_type_Long = l;
      localqty.jdField_d_of_type_Long = this.a.a();
      if ((localqty.jdField_a_of_type_Qbx.jdField_a_of_type_Long == 0L) && (localqty.jdField_a_of_type_Qbx.jdField_c_of_type_Long == 0L) && (localqty.jdField_a_of_type_Qbx.jdField_b_of_type_Long != 0L)) {
        localqty.jdField_a_of_type_Qbx.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - localqty.jdField_a_of_type_Qbx.jdField_b_of_type_Long);
      }
      localqty.jdField_a_of_type_Qbx.jdField_a_of_type_Float = ((float)localqty.jdField_a_of_type_Qbx.jdField_a_of_type_Long / localqty.jdField_b_of_type_Int);
      localqty.jdField_a_of_type_Qbx.jdField_a_of_type_Boolean = true;
      localqty.jdField_a_of_type_Qbx.jdField_b_of_type_Boolean = true;
      localqty.jdField_a_of_type_Qbx.jdField_m_of_type_Long = paramqub.c();
      localqty.jdField_a_of_type_Qbx.jdField_e_of_type_Int = paramqub.c();
      localqty.jdField_a_of_type_Qbx.jdField_f_of_type_Int = paramqub.d();
      localqty.jdField_a_of_type_Qbx.jdField_c_of_type_Boolean = paramqub.jdField_b_of_type_Boolean;
      localqty.jdField_a_of_type_Qbx.jdField_p_of_type_Long = paramqub.jdField_b_of_type_Long;
      localqty.jdField_a_of_type_Qbx.jdField_o_of_type_Long = paramqub.jdField_a_of_type_Long;
      localqty.jdField_a_of_type_Qbx.q = paramqub.f();
      localqty.jdField_a_of_type_Qbx.jdField_r_of_type_Long = paramqub.i();
      localqty.jdField_a_of_type_Qbx.jdField_f_of_type_JavaLangString = paramqub.a();
      localqty.jdField_a_of_type_Qbx.t = paramqub.h();
      localqty.jdField_a_of_type_Qbx.u = paramqub.g();
      localqty.jdField_a_of_type_Qbx.jdField_k_of_type_Int = this.a.c();
      localqty.jdField_a_of_type_Qbx.jdField_l_of_type_Int = this.a.d();
      if (qtu.b(this.a) == null) {
        break label901;
      }
      paramqub = localqty.jdField_a_of_type_Qbx;
      i = qtu.b(this.a).jdField_a_of_type_Int;
      j = localqty.jdField_a_of_type_Int;
      if (localqty.m != 3) {
        break label895;
      }
      bool = true;
    }
    label901:
    for (paramqub.jdField_r_of_type_Int = onk.a(i, j, bool);; localqty.jdField_a_of_type_Qbx.jdField_r_of_type_Int = -1)
    {
      localqty.jdField_a_of_type_Qbx.jdField_c_of_type_Int = localqty.m;
      qtu.a(this.a, localqty);
      onk.a(qtu.a(this.a).getApplicationContext(), onk.a(), true, localqty.jdField_a_of_type_Qbx.a());
      noz.a(localqty.jdField_a_of_type_Qbx);
      onk.a(true, localqty.jdField_a_of_type_Qbx.jdField_d_of_type_Boolean, localqty.jdField_a_of_type_Qbx.jdField_f_of_type_Int, localqty.jdField_a_of_type_Qbx.jdField_a_of_type_Int, localqty.jdField_a_of_type_Qbx.jdField_c_of_type_Long, 56, localqty.jdField_a_of_type_Qbx.jdField_c_of_type_JavaLangString, localqty.jdField_a_of_type_Qbx.jdField_a_of_type_JavaLangString);
      if (localqty.jdField_a_of_type_Qbx.jdField_a_of_type_Long > 0L)
      {
        new JSONObject();
        ThreadManager.post(new VideoPlayManager.1.3(this, localqty, localqup), 5, null, true);
      }
      axqw.b(null, "dc00899", "Pb_account_lifeservice", "", "0X800709B", "0X800709B", 0, 0, "", "", "", localqty.jdField_c_of_type_JavaLangString);
      paramqub = localqty.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((paramqub != null) && (oau.a((int)paramqub.mChannelID)) && (AdvertisementInfo.isAdvertisementInfo(paramqub)) && (localqty.jdField_b_of_type_Boolean))
      {
        i = (int)l;
        nmf.a(new nyg().a(qtu.a(this.a)).a(nmf.jdField_f_of_type_Int).b(nmf.Q).a((AdvertisementInfo)paramqub).a(nmf.a(((AdvertisementInfo)paramqub).adbt, i, ((AdvertisementInfo)paramqub).getAdbf(), 1, ((AdvertisementInfo)paramqub).adpa, ((AdvertisementInfo)paramqub).adpb, paramqub.mVideoDuration, 1, 0)).a());
      }
      paramqub = localqty.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((paramqub != null) && (paramqub.mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo(paramqub))) {
        nmf.a(new nyg().a(qtu.a(this.a)).a(nmf.jdField_f_of_type_Int).b(nmf.M).a((AdvertisementInfo)paramqub).a(nmf.a(((AdvertisementInfo)paramqub).adbt, paramqub.mVideoDuration * 1000, ((AdvertisementInfo)paramqub).getAdbf(), 1, ((AdvertisementInfo)paramqub).adpa, ((AdvertisementInfo)paramqub).adpb, paramqub.mVideoDuration, nmf.aF, 0)).a());
      }
      qtu.a(this.a).post(new VideoPlayManager.1.4(this));
      return;
      label895:
      bool = false;
      break;
    }
  }
  
  public void a(qub paramqub, Object paramObject)
  {
    long l = 0L;
    paramObject = qtu.a(this.a);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onVideoPrepared() mIsOpenedVideo=" + qtu.a(this.a) + "   mVisable:" + qtu.b(this.a));
    }
    if (!qtu.a(this.a)) {}
    do
    {
      return;
      qtu.a(this.a, false);
      if ((qtu.a(this.a) == paramqub) && (paramObject != null))
      {
        qtu.a(this.a).c(paramObject.jdField_f_of_type_Int);
        qtu.a(this.a).a(paramObject.jdField_a_of_type_Int, true);
        if ((paramObject.jdField_a_of_type_Qbx != null) && (paramObject.jdField_a_of_type_Qbx.jdField_c_of_type_Long == 0L))
        {
          paramObject.jdField_a_of_type_Qbx.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - paramObject.jdField_a_of_type_Qbx.jdField_b_of_type_Long);
          Object localObject = paramObject.jdField_a_of_type_Qbx;
          ((qbx)localObject).jdField_e_of_type_Long += paramObject.jdField_a_of_type_Qbx.jdField_c_of_type_Long;
          localObject = paramObject.jdField_a_of_type_Qbx;
          ((qbx)localObject).jdField_b_of_type_Int += 1;
          localObject = paramqub.a().getPlayDetailsTime();
          if ((localObject != null) && (paramObject.jdField_a_of_type_Qbx != null))
          {
            paramObject.jdField_a_of_type_Qbx.jdField_f_of_type_Long = Long.valueOf(((Properties)localObject).getProperty("httpdnsMS")).longValue();
            paramObject.jdField_a_of_type_Qbx.jdField_g_of_type_Long = Long.valueOf(((Properties)localObject).getProperty("httpredirectMS")).longValue();
            paramObject.jdField_a_of_type_Qbx.jdField_h_of_type_Long = Long.valueOf(((Properties)localObject).getProperty("cacheframeMS")).longValue();
            if (1 == paramObject.jdField_f_of_type_Int) {
              paramObject.jdField_a_of_type_Qbx.i = Long.valueOf(((Properties)localObject).getProperty("vidtourlMS")).longValue();
            }
            paramObject.jdField_a_of_type_Qbx.j = Long.valueOf(((Properties)localObject).getProperty("httpfirstrecvMS")).longValue();
            paramObject.jdField_a_of_type_Qbx.jdField_k_of_type_Long = Long.valueOf(((Properties)localObject).getProperty("getmp4headerMS")).longValue();
            paramObject.jdField_a_of_type_Qbx.jdField_l_of_type_Long = Long.valueOf(((Properties)localObject).getProperty("httpconnectMS")).longValue();
          }
          if ((paramObject.jdField_a_of_type_Qbx != null) && (QLog.isColorLevel())) {
            QLog.d("Q.readinjoy.video", 2, "video player ready. from open. prepare cost : " + paramObject.jdField_a_of_type_Qbx.jdField_c_of_type_Long);
          }
        }
        qtu.a(this.a, paramObject, qtu.a(this.a), 2, null);
        if ((qvn.a(qtu.a(this.a))) || (!GesturePWDUtils.isAppOnForeground(qtu.a(this.a))) || (qtu.a(this.a) == null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "onVideoPrepared start,in call stop.background:" + GesturePWDUtils.isAppOnForeground(qtu.a(this.a)));
          }
          qtu.a(this.a).post(new VideoPlayManager.1.1(this));
        }
        for (;;)
        {
          paramqub = new StringBuilder().append(ajyc.a(2131716326)).append(paramqub.jdField_b_of_type_Boolean).append(ajyc.a(2131716343));
          if (paramObject.jdField_a_of_type_Qbx != null) {
            l = paramObject.jdField_a_of_type_Qbx.jdField_c_of_type_Long;
          }
          paramqub = l;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.readinjoy.video", 2, paramqub);
          return;
          paramqub.f();
          qtu.a(this.a, paramObject, qtu.a(this.a), 3, null);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.readinjoy.video", 2, "video player ready,but has error!");
  }
  
  public void a(qub paramqub, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((qtu.a(this.a) == null) || (qtu.a(this.a).jdField_a_of_type_Qbx == null)) {
      return;
    }
    qtu.a(this.a).jdField_a_of_type_Qbx.jdField_h_of_type_JavaLangString = paramString;
  }
  
  public void a(qub paramqub, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onCaptureImage , id : " + paramInt2 + " succ : " + paramBoolean + " errCode : " + paramInt1);
    }
    if (qtu.a(this.a).size() >= 10)
    {
      paramqub = (Pair)qtu.a(this.a).remove(0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "Capture Image Pool full ! remove first image, id : " + paramqub.first);
      }
    }
    if (paramBoolean) {
      qtu.a(this.a).add(new Pair(Integer.valueOf(paramInt2), paramBitmap));
    }
    ((qub)qtu.a(this.a).get(Integer.valueOf(paramInt2))).m();
  }
  
  public boolean a(qub paramqub, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null) {}
    for (paramObject = paramObject.toString();; paramObject = "")
    {
      paramObject = paramObject;
      if (QLog.isColorLevel()) {
        QLog.d(qtu.jdField_a_of_type_JavaLangString, 2, "video play has error ! " + paramObject);
      }
      this.a.jdField_a_of_type_Qty = qtu.a(this.a);
      if (qtu.a(this.a) != null) {
        sgj.a(qtu.a(this.a).j, qtu.a(this.a).jdField_c_of_type_JavaLangString, 1, paramInt2);
      }
      if (paramqub == qtu.a(this.a)) {
        qtu.a(this.a).post(new VideoPlayManager.1.5(this, paramInt1, paramInt2, paramString, paramqub));
      }
      return true;
    }
  }
  
  public boolean a(qub paramqub, int paramInt, Object paramObject)
  {
    if (paramqub == qtu.a(this.a))
    {
      if (this.a.a() != 5) {
        break label73;
      }
      if (QLog.isColorLevel()) {
        QLog.d(qtu.jdField_a_of_type_JavaLangString, 2, "onInfo(): what:" + paramInt + ",extra:" + paramObject + ", getCurPlayState == paused, just ignore.");
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
                          QLog.d(qtu.jdField_a_of_type_JavaLangString, 2, "onInfo(): video start buffering !");
                        }
                        qtu.a(this.a, qtu.a(this.a), qtu.a(this.a), 4, null);
                      }
                    } while (qtu.a(this.a) == null);
                    qtu.a(this.a).jdField_a_of_type_Qbx.jdField_d_of_type_Long = SystemClock.uptimeMillis();
                    return false;
                    if (QLog.isColorLevel()) {
                      QLog.d(qtu.jdField_a_of_type_JavaLangString, 2, "onInfo(): video end buffering ! isPause=" + this.a.d());
                    }
                    if (!this.a.d()) {
                      qtu.a(this.a, qtu.a(this.a), qtu.a(this.a), 3, null);
                    }
                  } while (qtu.a(this.a) == null);
                  paramqub = qtu.a(this.a).jdField_a_of_type_Qbx;
                  paramqub.jdField_e_of_type_Long += SystemClock.uptimeMillis() - qtu.a(this.a).jdField_a_of_type_Qbx.jdField_d_of_type_Long;
                  paramqub = qtu.a(this.a).jdField_a_of_type_Qbx;
                  paramqub.jdField_b_of_type_Int += 1;
                  return false;
                  if (QLog.isColorLevel()) {
                    QLog.d(qtu.jdField_a_of_type_JavaLangString, 2, "播放状态回调 onInfo() PLAYER_INFO_DECODER_BLOCK");
                  }
                } while ((qtu.a(this.a) == null) || (qtu.a(this.a).jdField_a_of_type_Qbx == null));
                paramqub = qtu.a(this.a).jdField_a_of_type_Qbx;
                paramqub.n += 1;
                return false;
                for (;;)
                {
                  try
                  {
                    paramqub = new JSONObject((String)paramObject);
                    paramInt = paramqub.optInt("decoderMode", 0);
                  }
                  catch (Exception paramqub)
                  {
                    try
                    {
                      i = paramqub.optInt("skipFrameCount", 1);
                      if ((qtu.a(this.a) == null) || (qtu.a(this.a).jdField_a_of_type_Qbx == null)) {
                        break;
                      }
                      if (i > 0)
                      {
                        paramqub = qtu.a(this.a).jdField_a_of_type_Qbx;
                        paramqub.jdField_o_of_type_Int += i;
                      }
                      paramqub = qtu.a(this.a).jdField_a_of_type_Qbx;
                      paramqub.jdField_p_of_type_Int += i;
                      if (!QLog.isColorLevel()) {
                        break;
                      }
                      QLog.d(qtu.jdField_a_of_type_JavaLangString, 2, "播放状态回调 onInfo() PLAYER_INFO_SKIP_ONE_FRAME decoderMode = " + paramInt + ", skipFrameCount = " + i + ", totalSkipCount = " + qtu.a(this.a).jdField_a_of_type_Qbx.jdField_o_of_type_Int + ", finalSkipCount = " + qtu.a(this.a).jdField_a_of_type_Qbx.jdField_p_of_type_Int);
                      return false;
                    }
                    catch (Exception paramqub)
                    {
                      int i;
                      break label609;
                    }
                    paramqub = paramqub;
                    paramInt = 0;
                  }
                  i = 0;
                }
                if (QLog.isColorLevel()) {
                  QLog.d(qtu.jdField_a_of_type_JavaLangString, 2, "播放状态回调 onInfo() PLAYER_INFO_HW_DECODE_FAILED");
                }
              } while ((qtu.a(this.a) == null) || (qtu.a(this.a).jdField_a_of_type_Qbx == null));
              qtu.a(this.a).jdField_a_of_type_Qbx.jdField_f_of_type_Boolean = true;
            } while (!(paramObject instanceof String));
            qtu.a(this.a).jdField_a_of_type_Qbx.jdField_g_of_type_JavaLangString = ((String)paramObject);
            return false;
            if (QLog.isColorLevel()) {
              QLog.d(qtu.jdField_a_of_type_JavaLangString, 2, "播放状态回调 onInfo() PLAYER_INFO_CHANGE_HW_BACKUP_URL");
            }
          } while ((qtu.a(this.a) == null) || (qtu.a(this.a).jdField_a_of_type_Qbx == null));
          qtu.a(this.a).jdField_a_of_type_Qbx.jdField_g_of_type_Boolean = true;
          return false;
        } while (paramObject == null);
        paramqub = ((String)paramObject).split(":", 2);
      } while ((paramqub == null) || (paramqub.length != 2));
      if (QLog.isColorLevel()) {
        QLog.d("VideoPlayManager", 2, "Performance PERFORMANCE_REPORT videoPlayVideoParam:" + qtu.a(this.a) + "  method:" + paramqub[0] + "\ntimeJson:" + paramqub[1]);
      }
    } while ((!"prepare".equals(paramqub[0])) || (qtu.a(this.a) == null) || (qtu.a(this.a).jdField_a_of_type_Qbx == null));
    qtu.a(this.a).jdField_a_of_type_Qbx.jdField_m_of_type_JavaLangString = paramqub[1];
    return false;
  }
  
  public void d(qub paramqub)
  {
    if (QLog.isColorLevel()) {
      QLog.d(qtu.jdField_a_of_type_JavaLangString, 2, "onSeekComplete(): video seek complete ! curPlayState:" + qua.a(this.a.a()));
    }
    if ((paramqub == qtu.a(this.a)) && (this.a.a() != 5)) {
      qtu.a(this.a).f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qtv
 * JD-Core Version:    0.7.0.1
 */