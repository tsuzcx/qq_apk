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

public class qql
  extends quc
{
  private qql(VideoFeedsPlayManager paramVideoFeedsPlayManager) {}
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "onPrePlayFinished()");
    }
    VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.a(this.a)).k();
    if (VideoFeedsPlayManager.a(this.a) != null) {
      VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Qjv.b(VideoFeedsPlayManager.a(this.a), VideoFeedsPlayManager.b(this.a));
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
      noo.a(null, "", "0X8008AEE", "0X8008AEE", 0, 0, "", "", "", npx.a(paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.jdField_g_of_type_JavaLangString, 409409, localJSONObject), false);
      return;
      label167:
      i += 1;
    }
  }
  
  public void a(TVK_NetVideoInfo paramTVK_NetVideoInfo, qub paramqub)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "onTencentVideoDefnInfo(TVK_NetVideoInfo videoInfo, VideoPlayerWrapper videoPLayer) ");
    }
    if (!VideoFeedsPlayManager.a(this.a, paramqub)) {
      if (paramqub == VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.a(this.a))) {
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
  
  public void a(qqo paramqqo)
  {
    if ((paramqqo == null) || (paramqqo.jdField_a_of_type_Qbx == null) || (paramqqo.jdField_a_of_type_Qbx.jdField_c_of_type_Long != 0L)) {
      return;
    }
    paramqqo.jdField_a_of_type_Qbx.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - paramqqo.jdField_a_of_type_Qbx.jdField_b_of_type_Long);
    Object localObject = paramqqo.jdField_a_of_type_Qbx;
    ((qbx)localObject).e += paramqqo.jdField_a_of_type_Qbx.jdField_c_of_type_Long;
    localObject = paramqqo.jdField_a_of_type_Qbx;
    ((qbx)localObject).jdField_b_of_type_Int += 1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doReportOnVideoPrepared: vid=").append(paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString).append(", 预加载状态：").append(paramqqo.jdField_a_of_type_Qbx.jdField_m_of_type_Int).append(", 预下载命中：").append(VideoFeedsPlayManager.a(this.a, paramqqo).jdField_b_of_type_Boolean).append(", 首帧耗时：").append(paramqqo.jdField_a_of_type_Qbx.jdField_c_of_type_Long);
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, ((StringBuilder)localObject).toString());
    }
    ThreadManager.excute(new VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.4(this, paramqqo), 16, null, true);
  }
  
  public void a(qub paramqub)
  {
    if (!VideoFeedsPlayManager.a(this.a, paramqub)) {
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
    for (paramqub = VideoFeedsPlayManager.b(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;; paramqub = "param null")
    {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, paramqub);
      VideoFeedsPlayManager.a(this.a).post(new VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.5(this));
      paramqub = VideoFeedsPlayManager.b(this.a);
      if ((paramqub != null) && (paramqub.jdField_a_of_type_Qbx != null))
      {
        paramqub.jdField_a_of_type_Qbx.jdField_a_of_type_Boolean = true;
        paramqub.jdField_a_of_type_Qbx.jdField_b_of_type_Boolean = true;
      }
      VideoFeedsPlayManager.c(this.a, true);
      return;
    }
  }
  
  public void a(qub paramqub, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "onVideoPrepared(VideoPlayerWrapper player, Object tag) ");
    }
    paramObject = VideoFeedsPlayManager.b(this.a);
    if ((paramObject != null) && (QLog.isColorLevel())) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onVideoPrepared() vid=" + paramObject.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString + ", mIsOpenedVideo = " + VideoFeedsPlayManager.a(this.a));
    }
    if (!VideoFeedsPlayManager.a(this.a, paramqub))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "onVideoPrepared  checkIsPlayerPlaying false");
      }
      if ((VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.a(this.a)) == paramqub) && (VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Boolean)) {
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
    c(paramqub);
  }
  
  public void a(qub paramqub, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "onConnectQualityCallback json= " + paramString);
    }
    if (!VideoFeedsPlayManager.a(this.a, paramqub)) {
      if (paramqub == VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.a(this.a))) {
        this.a.jdField_a_of_type_JavaLangString = paramString;
      }
    }
    while ((VideoFeedsPlayManager.b(this.a) == null) || (VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Qbx == null)) {
      return;
    }
    VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Qbx.h = paramString;
  }
  
  public boolean a(qub paramqub, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    Object localObject = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null) {}
    for (paramObject = paramObject.toString();; paramObject = "")
    {
      localObject = paramObject;
      if (VideoFeedsPlayManager.a(this.a, paramqub)) {
        break;
      }
      if ((VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.a(this.a)) == paramqub) && (paramqub != null))
      {
        paramqub.k();
        VideoFeedsPlayManager.a(this.a).jdField_a_of_type_Boolean = false;
      }
      return false;
    }
    paramObject = VideoFeedsPlayManager.b(this.a);
    if ((paramObject != null) && (paramObject.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (QLog.isColorLevel())) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onError() " + (String)localObject + ", vid=" + paramObject.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
    }
    ajyc.a(2131716239);
    if (paramInt1 == 123) {
      if (paramInt2 == 103) {
        paramqub = ajyc.a(2131716235) + paramInt1 + "-" + paramInt2 + ")";
      }
    }
    for (;;)
    {
      if ((paramObject != null) && (paramObject.jdField_a_of_type_Qjv != null)) {
        paramObject.jdField_a_of_type_Qjv.a(paramObject, paramInt1, paramInt2, paramqub);
      }
      if (VideoFeedsPlayManager.a(this.a) == null) {
        break;
      }
      localObject = VideoFeedsPlayManager.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((qqq)((Iterator)localObject).next()).a(paramObject, paramInt1, paramInt2, paramqub);
      }
      paramqub = ajyc.a(2131716222) + paramInt1 + "-" + paramInt2 + ")";
      continue;
      if (paramInt1 == 122)
      {
        if (paramInt2 == 204) {
          paramqub = ajyc.a(2131716199) + paramInt1 + "-" + paramInt2 + ")";
        } else if (paramInt2 == 202) {
          paramqub = ajyc.a(2131716139) + paramInt1 + "-" + paramInt2 + ")";
        } else {
          paramqub = ajyc.a(2131716237) + paramInt1 + "-" + paramInt2 + ")";
        }
      }
      else if (paramInt1 == 101)
      {
        if (paramInt2 == 80) {
          paramqub = ajyc.a(2131716166) + paramInt1 + "-" + paramInt2 + ")";
        } else {
          paramqub = ajyc.a(2131716168) + paramInt1 + "-" + paramInt2 + ")";
        }
      }
      else {
        paramqub = ajyc.a(2131716192) + paramInt1 + "-" + paramInt2 + ")";
      }
    }
    if ((paramObject != null) && (paramObject.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)) {
      sgj.a(paramObject.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString, paramObject.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, 1, paramInt2);
    }
    if ((paramObject != null) && (paramObject.jdField_a_of_type_Qbx != null))
    {
      paramObject.jdField_a_of_type_Qbx.jdField_a_of_type_Boolean = false;
      paramObject.jdField_a_of_type_Qbx.jdField_c_of_type_JavaLangString = (paramInt1 + ":" + paramInt2);
      paramObject.jdField_a_of_type_Qbx.jdField_d_of_type_JavaLangString = paramString;
    }
    if ((VideoFeedsPlayManager.d(this.a)) && (VideoFeedsPlayManager.a(this.a) != null))
    {
      paramqub = nmf.a(VideoFeedsPlayManager.b(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      if (!oau.a(VideoFeedsPlayManager.b(this.a))) {
        break label929;
      }
    }
    label929:
    for (paramInt1 = 20;; paramInt1 = 0)
    {
      paramString = nmf.a(0, 0, 0, 0, paramInt1, 0, 0, nmf.aE, 2);
      nmf.a(new nyg().a(VideoFeedsPlayManager.a(this.a)).a(nmf.f).b(paramObject.jdField_a_of_type_Qbw.g).a(paramqub).a(VideoFeedsPlayManager.b(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a(paramString).a());
      oau.a(VideoFeedsPlayManager.b(this.a));
      return false;
    }
  }
  
  /* Error */
  public boolean a(qub paramqub, int paramInt, Object paramObject)
  {
    // Byte code:
    //   0: iload_2
    //   1: bipush 42
    //   3: if_icmpeq +16 -> 19
    //   6: aload_0
    //   7: getfield 10	qql:a	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
    //   10: aload_1
    //   11: invokestatic 145	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;Lqub;)Z
    //   14: ifne +5 -> 19
    //   17: iconst_0
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 10	qql:a	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
    //   23: invokestatic 150	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lqqo;
    //   26: astore 5
    //   28: iload_2
    //   29: lookupswitch	default:+67->96, 21:+69->98, 22:+197->226, 28:+357->386, 39:+574->603, 40:+403->432, 41:+632->661, 42:+671->700
    //   97: ireturn
    //   98: invokestatic 23	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   101: ifeq +12 -> 113
    //   104: ldc 222
    //   106: iconst_2
    //   107: ldc_w 417
    //   110: invokestatic 31	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aload 5
    //   115: ifnull +23 -> 138
    //   118: aload 5
    //   120: getfield 49	qqo:jdField_a_of_type_Qjv	Lqjv;
    //   123: ifnull +15 -> 138
    //   126: aload 5
    //   128: getfield 49	qqo:jdField_a_of_type_Qjv	Lqjv;
    //   131: aload 5
    //   133: invokeinterface 419 2 0
    //   138: aload 5
    //   140: ifnull +22 -> 162
    //   143: aload 5
    //   145: getfield 177	qqo:jdField_a_of_type_Qbx	Lqbx;
    //   148: ifnull +14 -> 162
    //   151: aload 5
    //   153: getfield 177	qqo:jdField_a_of_type_Qbx	Lqbx;
    //   156: invokestatic 189	android/os/SystemClock:uptimeMillis	()J
    //   159: putfield 421	qbx:jdField_d_of_type_Long	J
    //   162: aload_0
    //   163: getfield 10	qql:a	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
    //   166: invokestatic 36	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lqqo;
    //   169: ifnull -152 -> 17
    //   172: aload_0
    //   173: getfield 10	qql:a	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
    //   176: invokestatic 36	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lqqo;
    //   179: getfield 264	qqo:jdField_a_of_type_Boolean	Z
    //   182: ifeq -165 -> 17
    //   185: aload_0
    //   186: getfield 10	qql:a	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
    //   189: aload_0
    //   190: getfield 10	qql:a	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
    //   193: invokestatic 36	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lqqo;
    //   196: invokestatic 39	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;Lqqo;)Lqub;
    //   199: astore_1
    //   200: aload_1
    //   201: ifnull -184 -> 17
    //   204: aload_1
    //   205: invokevirtual 423	qub:e	()Z
    //   208: ifne -191 -> 17
    //   211: aload_0
    //   212: getfield 10	qql:a	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
    //   215: invokestatic 36	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lqqo;
    //   218: getfield 426	qqo:jdField_a_of_type_Qub	Lqub;
    //   221: invokevirtual 44	qub:k	()V
    //   224: iconst_0
    //   225: ireturn
    //   226: invokestatic 23	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq +12 -> 241
    //   232: ldc 222
    //   234: iconst_2
    //   235: ldc_w 428
    //   238: invokestatic 31	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   241: aload 5
    //   243: ifnull +23 -> 266
    //   246: aload 5
    //   248: getfield 49	qqo:jdField_a_of_type_Qjv	Lqjv;
    //   251: ifnull +15 -> 266
    //   254: aload 5
    //   256: getfield 49	qqo:jdField_a_of_type_Qjv	Lqjv;
    //   259: aload 5
    //   261: invokeinterface 431 2 0
    //   266: aload 5
    //   268: ifnull +54 -> 322
    //   271: aload 5
    //   273: getfield 177	qqo:jdField_a_of_type_Qbx	Lqbx;
    //   276: ifnull +46 -> 322
    //   279: aload 5
    //   281: getfield 177	qqo:jdField_a_of_type_Qbx	Lqbx;
    //   284: astore_1
    //   285: aload_1
    //   286: aload_1
    //   287: getfield 194	qbx:e	J
    //   290: invokestatic 189	android/os/SystemClock:uptimeMillis	()J
    //   293: aload 5
    //   295: getfield 177	qqo:jdField_a_of_type_Qbx	Lqbx;
    //   298: getfield 421	qbx:jdField_d_of_type_Long	J
    //   301: lsub
    //   302: ladd
    //   303: putfield 194	qbx:e	J
    //   306: aload 5
    //   308: getfield 177	qqo:jdField_a_of_type_Qbx	Lqbx;
    //   311: astore_1
    //   312: aload_1
    //   313: aload_1
    //   314: getfield 197	qbx:jdField_b_of_type_Int	I
    //   317: iconst_1
    //   318: iadd
    //   319: putfield 197	qbx:jdField_b_of_type_Int	I
    //   322: aload_0
    //   323: getfield 10	qql:a	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
    //   326: invokestatic 36	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lqqo;
    //   329: ifnull -312 -> 17
    //   332: aload_0
    //   333: getfield 10	qql:a	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
    //   336: invokestatic 36	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lqqo;
    //   339: getfield 264	qqo:jdField_a_of_type_Boolean	Z
    //   342: ifeq -325 -> 17
    //   345: aload_0
    //   346: getfield 10	qql:a	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
    //   349: aload_0
    //   350: getfield 10	qql:a	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
    //   353: invokestatic 36	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lqqo;
    //   356: invokestatic 39	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;Lqqo;)Lqub;
    //   359: astore_1
    //   360: aload_1
    //   361: ifnull -344 -> 17
    //   364: aload_1
    //   365: invokevirtual 423	qub:e	()Z
    //   368: ifne -351 -> 17
    //   371: aload_0
    //   372: getfield 10	qql:a	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
    //   375: invokestatic 36	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lqqo;
    //   378: getfield 426	qqo:jdField_a_of_type_Qub	Lqub;
    //   381: invokevirtual 434	qub:l	()V
    //   384: iconst_0
    //   385: ireturn
    //   386: invokestatic 23	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   389: ifeq +12 -> 401
    //   392: ldc 222
    //   394: iconst_2
    //   395: ldc_w 436
    //   398: invokestatic 31	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   401: aload 5
    //   403: ifnull -386 -> 17
    //   406: aload 5
    //   408: getfield 177	qqo:jdField_a_of_type_Qbx	Lqbx;
    //   411: ifnull -394 -> 17
    //   414: aload 5
    //   416: getfield 177	qqo:jdField_a_of_type_Qbx	Lqbx;
    //   419: astore_1
    //   420: aload_1
    //   421: aload_1
    //   422: getfield 439	qbx:n	I
    //   425: iconst_1
    //   426: iadd
    //   427: putfield 439	qbx:n	I
    //   430: iconst_0
    //   431: ireturn
    //   432: new 63	org/json/JSONObject
    //   435: dup
    //   436: aload_3
    //   437: checkcast 441	java/lang/String
    //   440: invokespecial 444	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   443: astore_1
    //   444: aload_1
    //   445: ldc_w 446
    //   448: iconst_0
    //   449: invokevirtual 450	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   452: istore_2
    //   453: aload_1
    //   454: ldc_w 452
    //   457: iconst_1
    //   458: invokevirtual 450	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   461: istore 4
    //   463: aload 5
    //   465: ifnull -448 -> 17
    //   468: aload 5
    //   470: getfield 177	qqo:jdField_a_of_type_Qbx	Lqbx;
    //   473: ifnull -456 -> 17
    //   476: iload 4
    //   478: ifle +20 -> 498
    //   481: aload 5
    //   483: getfield 177	qqo:jdField_a_of_type_Qbx	Lqbx;
    //   486: astore_1
    //   487: aload_1
    //   488: aload_1
    //   489: getfield 455	qbx:o	I
    //   492: iload 4
    //   494: iadd
    //   495: putfield 455	qbx:o	I
    //   498: aload 5
    //   500: getfield 177	qqo:jdField_a_of_type_Qbx	Lqbx;
    //   503: astore_1
    //   504: aload_1
    //   505: aload_1
    //   506: getfield 458	qbx:p	I
    //   509: iload 4
    //   511: iadd
    //   512: putfield 458	qbx:p	I
    //   515: invokestatic 23	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   518: ifeq -501 -> 17
    //   521: ldc 222
    //   523: iconst_2
    //   524: new 84	java/lang/StringBuilder
    //   527: dup
    //   528: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   531: ldc_w 460
    //   534: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: iload_2
    //   538: invokevirtual 207	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   541: ldc_w 462
    //   544: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: iload 4
    //   549: invokevirtual 207	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   552: ldc_w 464
    //   555: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: aload 5
    //   560: getfield 177	qqo:jdField_a_of_type_Qbx	Lqbx;
    //   563: getfield 455	qbx:o	I
    //   566: invokevirtual 207	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   569: ldc_w 466
    //   572: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: aload 5
    //   577: getfield 177	qqo:jdField_a_of_type_Qbx	Lqbx;
    //   580: getfield 458	qbx:p	I
    //   583: invokevirtual 207	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   586: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: invokestatic 31	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   592: iconst_0
    //   593: ireturn
    //   594: astore_1
    //   595: iconst_0
    //   596: istore_2
    //   597: iconst_0
    //   598: istore 4
    //   600: goto -137 -> 463
    //   603: invokestatic 23	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   606: ifeq +12 -> 618
    //   609: ldc 222
    //   611: iconst_2
    //   612: ldc_w 468
    //   615: invokestatic 31	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   618: aload 5
    //   620: ifnull -603 -> 17
    //   623: aload 5
    //   625: getfield 177	qqo:jdField_a_of_type_Qbx	Lqbx;
    //   628: ifnull -611 -> 17
    //   631: aload 5
    //   633: getfield 177	qqo:jdField_a_of_type_Qbx	Lqbx;
    //   636: iconst_1
    //   637: putfield 470	qbx:f	Z
    //   640: aload_3
    //   641: instanceof 441
    //   644: ifeq -627 -> 17
    //   647: aload 5
    //   649: getfield 177	qqo:jdField_a_of_type_Qbx	Lqbx;
    //   652: aload_3
    //   653: checkcast 441	java/lang/String
    //   656: putfield 471	qbx:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   659: iconst_0
    //   660: ireturn
    //   661: invokestatic 23	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   664: ifeq +12 -> 676
    //   667: ldc 222
    //   669: iconst_2
    //   670: ldc_w 473
    //   673: invokestatic 31	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   676: aload 5
    //   678: ifnull -661 -> 17
    //   681: aload 5
    //   683: getfield 177	qqo:jdField_a_of_type_Qbx	Lqbx;
    //   686: ifnull -669 -> 17
    //   689: aload 5
    //   691: getfield 177	qqo:jdField_a_of_type_Qbx	Lqbx;
    //   694: iconst_1
    //   695: putfield 475	qbx:jdField_g_of_type_Boolean	Z
    //   698: iconst_0
    //   699: ireturn
    //   700: aload_1
    //   701: ifnull -684 -> 17
    //   704: aload_0
    //   705: getfield 10	qql:a	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
    //   708: invokestatic 150	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lqqo;
    //   711: ifnull +132 -> 843
    //   714: aload_1
    //   715: aload_0
    //   716: getfield 10	qql:a	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
    //   719: invokestatic 150	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lqqo;
    //   722: getfield 426	qqo:jdField_a_of_type_Qub	Lqub;
    //   725: if_acmpne +118 -> 843
    //   728: aload_0
    //   729: getfield 10	qql:a	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
    //   732: invokestatic 150	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lqqo;
    //   735: astore_1
    //   736: aload_3
    //   737: ifnull -720 -> 17
    //   740: aload_3
    //   741: checkcast 441	java/lang/String
    //   744: ldc_w 346
    //   747: iconst_2
    //   748: invokevirtual 479	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   751: astore_3
    //   752: aload_3
    //   753: ifnull -736 -> 17
    //   756: aload_3
    //   757: arraylength
    //   758: iconst_2
    //   759: if_icmpne -742 -> 17
    //   762: invokestatic 23	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   765: ifeq +43 -> 808
    //   768: ldc 222
    //   770: iconst_2
    //   771: new 84	java/lang/StringBuilder
    //   774: dup
    //   775: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   778: ldc_w 481
    //   781: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   784: aload_3
    //   785: iconst_0
    //   786: aaload
    //   787: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: ldc_w 483
    //   793: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: aload_3
    //   797: iconst_1
    //   798: aaload
    //   799: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   805: invokestatic 31	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   808: ldc_w 485
    //   811: aload_3
    //   812: iconst_0
    //   813: aaload
    //   814: invokevirtual 489	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   817: ifeq -800 -> 17
    //   820: aload_1
    //   821: ifnull -804 -> 17
    //   824: aload_1
    //   825: getfield 177	qqo:jdField_a_of_type_Qbx	Lqbx;
    //   828: ifnull -811 -> 17
    //   831: aload_1
    //   832: getfield 177	qqo:jdField_a_of_type_Qbx	Lqbx;
    //   835: aload_3
    //   836: iconst_1
    //   837: aaload
    //   838: putfield 491	qbx:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   841: iconst_0
    //   842: ireturn
    //   843: aload_0
    //   844: getfield 10	qql:a	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
    //   847: invokestatic 36	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lqqo;
    //   850: ifnull +28 -> 878
    //   853: aload_1
    //   854: aload_0
    //   855: getfield 10	qql:a	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
    //   858: invokestatic 36	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lqqo;
    //   861: getfield 426	qqo:jdField_a_of_type_Qub	Lqub;
    //   864: if_acmpne +14 -> 878
    //   867: aload_0
    //   868: getfield 10	qql:a	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
    //   871: invokestatic 36	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lqqo;
    //   874: astore_1
    //   875: goto -139 -> 736
    //   878: aconst_null
    //   879: astore_1
    //   880: goto -144 -> 736
    //   883: astore_1
    //   884: goto -287 -> 597
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	887	0	this	qql
    //   0	887	1	paramqub	qub
    //   0	887	2	paramInt	int
    //   0	887	3	paramObject	Object
    //   461	138	4	i	int
    //   26	664	5	localqqo	qqo
    // Exception table:
    //   from	to	target	type
    //   432	453	594	java/lang/Exception
    //   453	463	883	java/lang/Exception
  }
  
  public void b(qub paramqub)
  {
    if ((!VideoFeedsPlayManager.a(this.a, paramqub)) && (paramqub == VideoFeedsPlayManager.a(this.a, VideoFeedsPlayManager.a(this.a))))
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
  
  public void c(qub paramqub)
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
  
  public void d(qub paramqub)
  {
    VideoFeedsPlayManager.a(this.a).sendEmptyMessageDelayed(-2, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qql
 * JD-Core Version:    0.7.0.1
 */