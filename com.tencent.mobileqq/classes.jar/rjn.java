import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper.3;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCaptureImageListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnNetVideoInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnPreAdListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo.DefnInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase.IVideoViewCallBack;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class rjn
  implements TVK_IMediaPlayer.OnCaptureImageListener, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnDownloadCallbackListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnInfoListener, TVK_IMediaPlayer.OnNetVideoInfoListener, TVK_IMediaPlayer.OnPreAdListener, TVK_IMediaPlayer.OnSeekCompleteListener, TVK_IMediaPlayer.OnVideoPreparedListener, IVideoViewBase.IVideoViewCallBack
{
  public int a;
  public long a;
  protected Context a;
  private View jdField_a_of_type_AndroidViewView;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private TVK_NetVideoInfo.DefnInfo jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo$DefnInfo;
  private TVK_NetVideoInfo jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo;
  private TVK_UserInfo jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo;
  private Object jdField_a_of_type_JavaLangObject;
  public String a;
  private volatile ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private rjo jdField_a_of_type_Rjo;
  public boolean a;
  public int b;
  public long b;
  private Object b;
  public boolean b;
  private int jdField_c_of_type_Int = 2;
  public long c;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 0;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private long jdField_f_of_type_Long;
  private boolean jdField_f_of_type_Boolean;
  private long jdField_g_of_type_Long;
  private boolean jdField_g_of_type_Boolean;
  private long h;
  private long i = -1L;
  
  public rjn(Context paramContext)
  {
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_f_of_type_Boolean = rlb.a().a();
    a();
  }
  
  private void a(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo)
  {
    if (paramTVK_PlayerVideoInfo != null)
    {
      paramTVK_PlayerVideoInfo.setConfigMap("ff_probesize", String.valueOf(bkbq.b()));
      paramTVK_PlayerVideoInfo.setConfigMap("is_ff_probelist_switch", String.valueOf(bkbq.r()));
      paramTVK_PlayerVideoInfo.setConfigMap("is_download_async_io", String.valueOf(bkbq.s()));
      paramTVK_PlayerVideoInfo.setConfigMap("httpbuffertime_for_playpreload", String.valueOf(bkbq.f()));
      paramTVK_PlayerVideoInfo.setConfigMap("dynamic_buffer_switch", String.valueOf(bkbq.g()));
      paramTVK_PlayerVideoInfo.setConfigMap("dynamic_buffer_config_json", String.valueOf(bkbq.b()));
    }
  }
  
  private void b(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager playerStartByUrl vid = " + paramString1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "#VideoPlayerWrapper# playerStartByUrl, url:" + paramString2 + ", fileSize:" + paramLong2 + ", videoDuration:" + paramInt2 + "，mState:" + rjm.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
    }
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(0, 1)) && (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(7, 1)) && (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(6, 1)))
    {
      QLog.e("Q.readinjoy.video", 1, "not idle or complete state, should't reopen mediaplayer, vid:" + paramString1 + "，mState:" + rjm.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
      return;
    }
    paramString1 = new TVK_PlayerVideoInfo(paramInt1, paramString1, "");
    paramString1.setPreLoad(paramBoolean3);
    if (paramLong2 > 0L) {
      paramString1.setConfigMap("filesize", String.valueOf(paramLong2));
    }
    if (paramInt2 > 0) {
      paramString1.setConfigMap("duration", String.valueOf(paramInt2));
    }
    if (this.jdField_e_of_type_Boolean) {
      paramString1.setConfigMap("keep_last_frame", "true");
    }
    paramString1.setConfigMap("cache_servers_type", rjm.jdField_a_of_type_JavaLangString);
    if (!paramBoolean1) {
      paramString1.setConfigMap("software_play", "true");
    }
    if ((this.jdField_d_of_type_Boolean) && (paramBoolean3)) {
      paramString1.setConfigMap("enable_cover_frame", "true");
    }
    a(paramString1);
    Object localObject = new HashMap();
    ((Map)localObject).put("shouq_bus_type", "bus_type_kandian_feeds");
    paramString1.setReportInfoMap((Map)localObject);
    paramString1.addExtraParamsMap("shouq_bus_type", "bus_type_kandian_feeds");
    if (paramBoolean2)
    {
      paramString2 = osf.a(paramString2);
      a(paramString2);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(BaseApplicationImpl.getContext(), paramString2, paramLong1, 0L, paramString1, null, paramString3);
    }
    for (;;)
    {
      this.jdField_e_of_type_Long = 0L;
      this.jdField_d_of_type_Long = 0L;
      this.jdField_f_of_type_Long = paramLong1;
      this.jdField_c_of_type_Int = paramInt1;
      return;
      localObject = new String[1];
      localObject[0] = paramString2;
      a((String[])localObject);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(BaseApplicationImpl.getContext(), (String[])localObject, paramLong1, 0L, paramString1, null, paramString3);
    }
  }
  
  private View c()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null)
    {
      a();
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null) {
        return null;
      }
    }
    if (this.jdField_a_of_type_AndroidContentContext == null)
    {
      QLog.d("Q.readinjoy.video", 2, "createVideoView_Scroll: error, mContext null");
      return null;
    }
    if (bhtb.d()) {
      return (View)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView_Scroll(this.jdField_a_of_type_AndroidContentContext);
    }
    return (View)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private void q()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList = null;
      this.jdField_f_of_type_Int = 0;
      this.jdField_c_of_type_Long = 0L;
      this.jdField_b_of_type_Long = 0L;
      this.i = -1L;
      return;
    }
  }
  
  public void OnDownloadCallback(String paramString)
  {
    if (this.jdField_a_of_type_Rjo != null) {
      this.jdField_a_of_type_Rjo.b(this, paramString);
    }
    QLog.d("Q.readinjoy.video", 2, "[TVK_IMediaPlayer] OnDownloadCallback(): s:" + paramString);
    for (;;)
    {
      int n;
      try
      {
        ??? = new JSONObject(paramString);
        int j = ((JSONObject)???).getInt("playID");
        long l = ((JSONObject)???).getLong("fileSize");
        int k = ((JSONObject)???).getInt("speedKBS");
        int m = ((JSONObject)???).getInt("offset");
        n = ((JSONObject)???).getInt("callBackType");
        if (this.jdField_f_of_type_Int != j) {
          q();
        }
        this.jdField_f_of_type_Int = j;
        if (l > 0L) {
          this.jdField_b_of_type_Long = l;
        }
        if ((n != 2) || (this.jdField_a_of_type_JavaUtilArrayList == null)) {}
        synchronized (this.jdField_b_of_type_JavaLangObject)
        {
          if (this.jdField_a_of_type_JavaUtilArrayList == null) {
            this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(k));
          rag.a(j, k);
          if ((n == 1) && (this.jdField_a_of_type_Rjo != null))
          {
            this.jdField_a_of_type_Rjo.a(this, paramString);
            break label263;
            if (this.jdField_a_of_type_Rjo != null) {
              this.jdField_a_of_type_Rjo.b(this);
            }
            if (m > 0) {
              this.jdField_c_of_type_Long = Math.max(this.jdField_c_of_type_Long, m);
            }
            return;
          }
        }
        if (n == 7) {
          continue;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      label263:
      if (n != 50) {}
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getVideoWidth();
    }
    return -1;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
      return 0L;
    }
    return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
  }
  
  public long a(boolean paramBoolean)
  {
    long l2 = this.jdField_e_of_type_Long;
    if (paramBoolean) {}
    for (long l1 = b(); l1 - this.jdField_f_of_type_Long > 0L; l1 = a()) {
      return l1 - this.jdField_f_of_type_Long + l2;
    }
    return l2;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public TVK_IMediaPlayer a()
  {
    return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public String a()
  {
    for (;;)
    {
      int j;
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          Object localObject2 = new StringBuilder();
          int k = this.jdField_a_of_type_JavaUtilArrayList.size();
          j = 0;
          if (j < k)
          {
            ((StringBuilder)localObject2).append(((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(j)).intValue());
            if (j != k - 1) {
              ((StringBuilder)localObject2).append(",");
            }
          }
          else
          {
            localObject2 = ((StringBuilder)localObject2).toString();
            return localObject2;
          }
        }
        else
        {
          return "";
        }
      }
      j += 1;
    }
  }
  
  public void a()
  {
    b();
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "VideoPlayerWrapper initPlayer success!");
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(this.jdField_a_of_type_AndroidContentContext, null);
      c(this.jdField_f_of_type_Boolean);
      d(this.jdField_g_of_type_Boolean);
      e();
    }
  }
  
  public void a(int paramInt)
  {
    ViolaLogUtils.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", "test seekTo aaa" + paramInt + ",state:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 2) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 1) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 4) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 8))
    {
      long l1 = a();
      if (l1 - this.jdField_f_of_type_Long > 0L)
      {
        long l2 = this.jdField_e_of_type_Long;
        this.jdField_e_of_type_Long = (l1 - this.jdField_f_of_type_Long + l2);
      }
      this.jdField_f_of_type_Long = paramInt;
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo(paramInt);
      this.jdField_c_of_type_Boolean = true;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (paramInt1 > 0) && (paramInt2 > 0)) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setHttpBufferRange(paramInt2, paramInt1);
    }
  }
  
  public void a(IVideoViewBase paramIVideoViewBase)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null) {}
    while (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidViewView == null) && ((paramIVideoViewBase instanceof View))) {
      this.jdField_a_of_type_AndroidViewView = ((View)paramIVideoViewBase);
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.updatePlayerVideoView(paramIVideoViewBase);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setXYaxis(this.jdField_d_of_type_Int);
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    a(paramString, paramInt, paramLong, false);
  }
  
  public void a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager playerStart vid = " + paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "#VideoPlayerWrapper# playerStart, vid:" + paramString + ", playType:" + paramInt + ", startPosition:" + paramLong + "，mState:" + rjm.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
    }
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(0, 1)) && (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(7, 1)) && (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(6, 1)))
    {
      QLog.e("Q.readinjoy.video", 1, "not idle or complete state, should't reopen mediaplayer, vid:" + paramString + "，mState:" + rjm.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
      return;
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo = new TVK_UserInfo("", "");
    paramString = new TVK_PlayerVideoInfo(paramInt, paramString, "");
    paramString.setPreLoad(paramBoolean);
    paramString.setPlayMode("cache_video");
    if (this.jdField_e_of_type_Boolean) {
      paramString.setConfigMap("keep_last_frame", "true");
    }
    paramString.setConfigMap("cache_servers_type", rjm.jdField_a_of_type_JavaLangString);
    if ((this.jdField_d_of_type_Boolean) && (paramBoolean)) {
      paramString.setConfigMap("enable_cover_frame", "true");
    }
    a(paramString);
    Object localObject = new HashMap();
    ((Map)localObject).put("shouq_bus_type", "bus_type_kandian_feeds");
    paramString.setReportInfoMap((Map)localObject);
    paramString.addExtraParamsMap("shouq_bus_type", "bus_type_kandian_feeds");
    localObject = rjm.a();
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayer(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo, paramString, (String)localObject, paramLong, 0L);
    }
    this.jdField_e_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_f_of_type_Long = paramLong;
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    b(paramString1, paramString2, paramInt1, paramLong1, paramLong2, paramInt2, true, true, false, null);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean)
  {
    b(paramString1, paramString2, paramInt1, paramLong1, paramLong2, paramInt2, paramBoolean, true, false, null);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    b(paramString1, paramString2, paramInt1, paramLong1, paramLong2, paramInt2, paramBoolean1, true, paramBoolean3, null);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    b(paramString1, paramString2, paramInt1, paramLong1, paramLong2, paramInt2, paramBoolean1, true, paramBoolean3, paramString3);
  }
  
  public void a(rjo paramrjo)
  {
    this.jdField_a_of_type_Rjo = paramrjo;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void a(String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramArrayOfString != null)
    {
      int j = 0;
      while (j < paramArrayOfString.length)
      {
        if (j != 0) {
          localStringBuilder.append(" ,");
        }
        localStringBuilder.append(paramArrayOfString[j]);
        j += 1;
      }
    }
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public void a(String[] paramArrayOfString, String paramString1, int paramInt, String paramString2, long paramLong, boolean paramBoolean, TVK_IMediaPlayer.OnDownloadCallbackListener paramOnDownloadCallbackListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "#VideoPlayerWrapper# playerStartByUrlsForShortVideo, urls:" + Arrays.toString(paramArrayOfString) + ", localVideoPath:" + paramString1 + ", videoMD5:" + paramString2 + "，mState:" + rjm.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
    }
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(0, 1)) && (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(7, 1)) && (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(6, 1)))
    {
      QLog.e("Q.readinjoy.video", 1, "not idle or complete or error state, should't reopen mediaplayer, urls:" + Arrays.toString(paramArrayOfString) + "，mState:" + rjm.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) + ", videoMD5:" + paramString2);
      return;
    }
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
    localTVK_PlayerVideoInfo.setPreLoad(paramBoolean);
    localTVK_PlayerVideoInfo.setConfigMap("file_dir", paramString1);
    localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", rjm.jdField_a_of_type_JavaLangString);
    if (this.jdField_e_of_type_Boolean) {
      localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
    }
    localTVK_PlayerVideoInfo.setConfigMap("duration", String.valueOf(paramInt));
    localTVK_PlayerVideoInfo.setVid(paramString2);
    localTVK_PlayerVideoInfo.setPlayMode("cache_extend_video");
    if ((this.jdField_d_of_type_Boolean) && (paramBoolean)) {
      localTVK_PlayerVideoInfo.setConfigMap("enable_cover_frame", "true");
    }
    a(localTVK_PlayerVideoInfo);
    paramString1 = new HashMap();
    paramString1.put("shouq_bus_type", "bus_type_kandian_feeds");
    localTVK_PlayerVideoInfo.setReportInfoMap(paramString1);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnDownloadCallback(paramOnDownloadCallbackListener);
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      a(paramArrayOfString);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext, paramArrayOfString, paramLong, 0L, localTVK_PlayerVideoInfo, null);
    }
    this.jdField_e_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_f_of_type_Long = paramLong;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getVideoHeight();
    }
    return -1;
  }
  
  public long b()
  {
    if (this.jdField_d_of_type_Long != 0L) {
      return this.jdField_d_of_type_Long;
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
    }
    return -1L;
  }
  
  public long b(boolean paramBoolean)
  {
    if (paramBoolean) {
      return b();
    }
    return a();
  }
  
  public View b()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    try
    {
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = c();
        if (this.jdField_a_of_type_AndroidViewView != null) {
          ((IVideoViewBase)this.jdField_a_of_type_AndroidViewView).addViewCallBack(this);
        }
      }
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getParent() != null))
      {
        ViewParent localViewParent = this.jdField_a_of_type_AndroidViewView.getParent();
        if ((localViewParent instanceof ViewGroup)) {
          ((ViewGroup)localViewParent).removeView(this.jdField_a_of_type_AndroidViewView);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "remove scroll view parents!");
        }
      }
      return this.jdField_a_of_type_AndroidViewView;
    }
    finally {}
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
  }
  
  public void b(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setXYaxis(paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.readinjoy.video", 2, "VideoPlayerWrapper: setXYaxis value:" + paramInt);
    }
  }
  
  /* Error */
  public void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 63	rjn:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   6: invokevirtual 190	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   9: istore_2
    //   10: iload_2
    //   11: bipush 8
    //   13: if_icmpne +6 -> 19
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: getfield 63	rjn:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   23: bipush 8
    //   25: invokevirtual 550	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   28: aload_0
    //   29: getfield 91	rjn:jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer	Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   32: ifnull +18 -> 50
    //   35: new 552	com/tencent/biz/pubaccount/readinjoy/video/VideoPlayerWrapper$2
    //   38: dup
    //   39: aload_0
    //   40: aload_0
    //   41: getfield 91	rjn:jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer	Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   44: invokespecial 555	com/tencent/biz/pubaccount/readinjoy/video/VideoPlayerWrapper$2:<init>	(Lrjn;Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;)V
    //   47: invokestatic 561	com/tencent/mobileqq/app/ThreadManager:executeOnSubThread	(Ljava/lang/Runnable;)V
    //   50: iload_1
    //   51: ifeq +46 -> 97
    //   54: aload_0
    //   55: getfield 386	rjn:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   58: ifnull +39 -> 97
    //   61: aload_0
    //   62: getfield 386	rjn:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   65: invokevirtual 529	android/view/View:getParent	()Landroid/view/ViewParent;
    //   68: ifnull +29 -> 97
    //   71: aload_0
    //   72: getfield 386	rjn:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   75: invokevirtual 529	android/view/View:getParent	()Landroid/view/ViewParent;
    //   78: astore_3
    //   79: aload_3
    //   80: instanceof 531
    //   83: ifeq +14 -> 97
    //   86: aload_3
    //   87: checkcast 531	android/view/ViewGroup
    //   90: aload_0
    //   91: getfield 386	rjn:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   94: invokevirtual 535	android/view/ViewGroup:removeView	(Landroid/view/View;)V
    //   97: aload_0
    //   98: aconst_null
    //   99: putfield 95	rjn:jdField_a_of_type_Rjo	Lrjo;
    //   102: aload_0
    //   103: aconst_null
    //   104: putfield 386	rjn:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   107: aload_0
    //   108: aconst_null
    //   109: putfield 75	rjn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   112: aload_0
    //   113: iconst_1
    //   114: putfield 563	rjn:jdField_a_of_type_Boolean	Z
    //   117: aload_0
    //   118: getfield 67	rjn:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   121: astore_3
    //   122: aload_3
    //   123: monitorenter
    //   124: aload_0
    //   125: aconst_null
    //   126: putfield 302	rjn:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   129: aload_3
    //   130: monitorexit
    //   131: aload_0
    //   132: lconst_0
    //   133: putfield 71	rjn:i	J
    //   136: aload_0
    //   137: lconst_0
    //   138: putfield 306	rjn:jdField_c_of_type_Long	J
    //   141: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   144: ifeq -128 -> 16
    //   147: ldc 173
    //   149: iconst_2
    //   150: ldc_w 565
    //   153: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: goto -140 -> 16
    //   159: astore_3
    //   160: aload_0
    //   161: monitorexit
    //   162: aload_3
    //   163: athrow
    //   164: astore 4
    //   166: aload_3
    //   167: monitorexit
    //   168: aload 4
    //   170: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	rjn
    //   0	171	1	paramBoolean	boolean
    //   9	5	2	j	int
    //   159	8	3	localObject2	Object
    //   164	5	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	159	finally
    //   19	50	159	finally
    //   54	97	159	finally
    //   97	124	159	finally
    //   131	156	159	finally
    //   168	171	159	finally
    //   124	131	164	finally
    //   166	168	164	finally
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getOutputMute();
    }
    return false;
  }
  
  public int c()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public long c()
  {
    return this.h;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_AndroidViewView instanceof IVideoViewBase)) {
      ((IVideoViewBase)this.jdField_a_of_type_AndroidViewView).doCacheSurfaceTexture();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(paramBoolean);
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying();
    }
    return false;
  }
  
  public int d()
  {
    if (this.jdField_c_of_type_Int == 1) {
      return 1;
    }
    return 0;
  }
  
  public long d()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_AndroidViewView instanceof IVideoViewBase)) {
      ((IVideoViewBase)this.jdField_a_of_type_AndroidViewView).doRecoverSurfaceTexture();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      ThreadManager.excute(new VideoPlayerWrapper.3(this, paramBoolean), 16, null, false);
    }
    while ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 6) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 8)) {
      return;
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setLoopback(paramBoolean);
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPauseing();
    }
    return false;
  }
  
  public int e()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public long e()
  {
    return this.jdField_f_of_type_Long;
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnPreAdListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnInfoListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCaptureImageListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnSeekCompleteListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnDownloadCallback(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnNetVideoInfoListener(this);
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2;
  }
  
  public int f()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "getDownloadDuration: mTransferedSize=" + this.jdField_c_of_type_Long + ", mFileSize=" + this.jdField_b_of_type_Long);
      }
      if (this.jdField_b_of_type_Long != 0L)
      {
        float f1 = (float)this.jdField_c_of_type_Long / (float)this.jdField_b_of_type_Long;
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "getDownloadDuration: Duration=" + b() + ", percent=" + f1);
        }
        return Math.round(f1 * (float)b() / 1000.0F);
      }
    }
    return 0;
  }
  
  public long f()
  {
    if (this.i == -1L) {}
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        int m = Math.min(10, this.jdField_a_of_type_JavaUtilArrayList.size());
        int j = 0;
        int k = 0;
        while (j < m)
        {
          k += ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(j)).intValue();
          j += 1;
        }
        if (m != 0) {
          this.i = (k / m);
        }
      }
      return this.i;
    }
  }
  
  public void f()
  {
    for (;;)
    {
      try
      {
        TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
        if (localTVK_IMediaPlayer == null) {
          return;
        }
        if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 8))
        {
          QLog.e("Q.readinjoy.video", 1, "VideoPlayerWrapper: start failed, wrong state:" + rjm.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) + ", just return;");
          continue;
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
      }
      finally {}
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "VideoPlayerWrapper: start");
      }
    }
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1;
  }
  
  public long g()
  {
    long l2 = -1L;
    Object localObject1 = this.jdField_b_of_type_JavaLangObject;
    long l1 = l2;
    label111:
    label118:
    for (;;)
    {
      int j;
      try
      {
        if (this.jdField_a_of_type_JavaUtilArrayList != null)
        {
          l1 = l2;
          if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
          {
            int k = this.jdField_a_of_type_JavaUtilArrayList.size();
            j = 0;
            l1 = -1L;
            if (j >= k) {
              break label118;
            }
            int m = ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(j)).intValue();
            if (j == 0)
            {
              l1 = m;
              break label111;
            }
            l1 = Math.min(m, l1);
            break label111;
          }
        }
        return l1;
      }
      finally {}
      j += 1;
    }
  }
  
  public void g()
  {
    f();
  }
  
  public boolean g()
  {
    return this.jdField_g_of_type_Boolean;
  }
  
  public long h()
  {
    long l2 = -1L;
    Object localObject1 = this.jdField_b_of_type_JavaLangObject;
    long l1 = l2;
    label111:
    label118:
    for (;;)
    {
      int j;
      try
      {
        if (this.jdField_a_of_type_JavaUtilArrayList != null)
        {
          l1 = l2;
          if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
          {
            int k = this.jdField_a_of_type_JavaUtilArrayList.size();
            j = 0;
            l1 = -1L;
            if (j >= k) {
              break label118;
            }
            int m = ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(j)).intValue();
            if (j == 0)
            {
              l1 = m;
              break label111;
            }
            l1 = Math.max(m, l1);
            break label111;
          }
        }
        return l1;
      }
      finally {}
      j += 1;
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(5);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
    }
  }
  
  public boolean h()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void i()
  {
    for (;;)
    {
      try
      {
        TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
        if (localTVK_IMediaPlayer == null) {
          return;
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 8)
        {
          QLog.e("Q.readinjoy.video", 1, "VideoPlayerWrapper: stop failed, because has destoryed, just return;");
          continue;
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      }
      finally {}
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "VideoPlayerWrapper: stop ");
      }
    }
  }
  
  public void j()
  {
    for (;;)
    {
      try
      {
        TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
        if (localTVK_IMediaPlayer == null) {
          return;
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 8)
        {
          QLog.e("Q.readinjoy.video", 1, "VideoPlayerWrapper: release failed, because has destoryed, just return;");
          continue;
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(8);
      }
      finally {}
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pauseDownload();
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.resumeDownload();
    }
  }
  
  public void m()
  {
    b(true);
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.updatePlayerVideoView(null);
    }
  }
  
  public void o()
  {
    this.jdField_e_of_type_Long = 0L;
    this.jdField_f_of_type_Long = 0L;
  }
  
  public void onCaptureImageFailed(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Rjo != null) {
      this.jdField_a_of_type_Rjo.a(this, false, paramInt2, paramInt1, null);
    }
  }
  
  public void onCaptureImageSucceed(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Rjo != null) {
      this.jdField_a_of_type_Rjo.a(this, true, 0, paramInt1, paramBitmap);
    }
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(7);
    if (this.jdField_a_of_type_Rjo != null) {
      this.jdField_a_of_type_Rjo.a(this);
    }
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayerWrapper onError!");
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(6);
    if (this.jdField_a_of_type_Rjo != null) {
      this.jdField_a_of_type_Rjo.a(this, paramInt1, paramInt2, paramInt3, paramString, paramObject);
    }
    return false;
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Rjo != null) {
        this.jdField_a_of_type_Rjo.a(this, paramInt, paramObject);
      }
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "VideoPlayerWrapper onInfo, start buffering ==> isSeeking = " + this.jdField_c_of_type_Boolean);
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 5) {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(4);
      }
      this.jdField_g_of_type_Long = System.currentTimeMillis();
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "VideoPlayerWrapper onInfo, end buffering <== isSeeking = " + this.jdField_c_of_type_Boolean);
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 5) {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
      }
      if (!this.jdField_c_of_type_Boolean)
      {
        this.jdField_e_of_type_Int += 1;
        this.h += System.currentTimeMillis() - this.jdField_g_of_type_Long;
      }
    }
  }
  
  public void onNetVideoInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, TVK_NetVideoInfo paramTVK_NetVideoInfo)
  {
    if (paramTVK_NetVideoInfo != null)
    {
      if (QLog.isColorLevel())
      {
        paramTVK_IMediaPlayer = paramTVK_NetVideoInfo.getDefinitionList().iterator();
        while (paramTVK_IMediaPlayer.hasNext())
        {
          TVK_NetVideoInfo.DefnInfo localDefnInfo = (TVK_NetVideoInfo.DefnInfo)paramTVK_IMediaPlayer.next();
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "[TVK_IMediaPlayer] onNetVideoInfo(): " + localDefnInfo.getmDefn() + ", " + localDefnInfo.getmDefnName() + ", isVip:" + localDefnInfo.isVip());
          }
        }
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo$DefnInfo = paramTVK_NetVideoInfo.getCurDefinition();
        QLog.d("Q.readinjoy.video", 2, "[TVK_IMediaPlayer] onNetVideoInfo(): 当前清晰度:" + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo$DefnInfo.getmDefn() + ", " + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo$DefnInfo.getmDefnName());
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo = paramTVK_NetVideoInfo;
      if (this.jdField_a_of_type_Rjo != null) {
        this.jdField_a_of_type_Rjo.a(paramTVK_NetVideoInfo, this);
      }
    }
  }
  
  public void onPreAdPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer, long paramLong) {}
  
  public void onPreAdPreparing(TVK_IMediaPlayer paramTVK_IMediaPlayer) {}
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayerWrapper: onSeekComplete， isPause=" + d());
    }
    if (this.jdField_a_of_type_Rjo != null) {
      this.jdField_a_of_type_Rjo.d(this);
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void onSurfaceChanged(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onSurfaceChanged: ");
    }
  }
  
  public void onSurfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onSurfaceCreated: ");
    }
  }
  
  public void onSurfaceDestory(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onSurfaceDestory: ");
    }
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if ((QLog.isColorLevel()) && (paramTVK_IMediaPlayer != null)) {
      QLog.d("Q.readinjoy.video", 2, "[TVK_IMediaPlayer] onVideoPrepared(): stremDumpInfo=" + paramTVK_IMediaPlayer.getStreamDumpInfo());
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    if (this.jdField_a_of_type_Rjo != null) {
      this.jdField_a_of_type_Rjo.a(this, this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
    }
    if ((this.jdField_b_of_type_Long > 0L) && (this.jdField_d_of_type_Long > 0L)) {
      this.jdField_a_of_type_Int = ((int)(this.jdField_b_of_type_Long / 1024L * 8L / (this.jdField_d_of_type_Long / 1000L)));
    }
    ThreadManager.post(new VideoPlayerWrapper.1(this, paramTVK_IMediaPlayer), 5, null, false);
  }
  
  public void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "resetVariables: ");
    }
    this.jdField_c_of_type_Int = 2;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_f_of_type_Long = 0L;
    this.jdField_g_of_type_Long = 0L;
    this.h = 0L;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo$DefnInfo = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.i = -1L;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = -1;
    q();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rjn
 * JD-Core Version:    0.7.0.1
 */