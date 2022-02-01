package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.f;
import com.tencent.liteav.h;
import com.tencent.liteav.j;
import com.tencent.liteav.n;
import com.tencent.liteav.p;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;
import org.json.JSONObject;

public class a
  implements com.tencent.liteav.basic.b.b
{
  private String A;
  private int B = -1;
  private long C = 0L;
  private TXLivePlayer.ITXAudioVolumeEvaluationListener D = null;
  private int E = 0;
  private long F;
  private String G;
  private int H;
  private a.a I = null;
  private TXLivePlayer.ITXAudioRawDataListener J;
  private TXCloudVideoView a;
  private Surface b;
  private int c;
  private int d;
  private ITXLivePlayListener e = null;
  private TXLivePlayConfig f;
  private boolean g = false;
  private boolean h = true;
  private int i;
  private int j;
  private String k = "";
  private boolean l = false;
  private int m = 100;
  private TXLivePlayer.ITXVideoRawDataListener n = null;
  private byte[] o = null;
  private Object p = null;
  private TXLivePlayer.ITXLivePlayVideoRenderListener q = null;
  private Context r;
  private Handler s;
  private n t;
  private boolean u = true;
  private float v = 1.0F;
  private boolean w = false;
  private j x;
  private boolean y;
  private long z;
  
  public a(Context paramContext)
  {
    this.r = paramContext.getApplicationContext();
    TXCCommonUtil.setAppContext(this.r);
    TXCLog.init();
    this.s = new Handler(Looper.getMainLooper());
    TXCCommonUtil.setAppContext(this.r);
    TXCLog.init();
  }
  
  private String a(Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" IP:");
    localStringBuilder.append(paramBundle.getString("SERVER_IP"));
    localStringBuilder.append(" RES:");
    localStringBuilder.append(paramBundle.getInt("VIDEO_WIDTH"));
    localStringBuilder.append("*");
    localStringBuilder.append(paramBundle.getInt("VIDEO_HEIGHT"));
    localStringBuilder.append(" FPS:");
    localStringBuilder.append(paramBundle.getInt("VIDEO_FPS"));
    localStringBuilder.append(" GOP:");
    localStringBuilder.append(paramBundle.getInt("VIDEO_GOP"));
    localStringBuilder.append("s Speed:");
    localStringBuilder.append(paramBundle.getInt("NET_SPEED"));
    localStringBuilder.append("Kbps AudioSpeed:");
    localStringBuilder.append(paramBundle.getInt("AUDIO_BITRATE"));
    localStringBuilder.append("Kbps VideoSpeed:");
    localStringBuilder.append(paramBundle.getInt("VIDEO_BITRATE"));
    localStringBuilder.append("Kbps AudioCache:");
    localStringBuilder.append(paramBundle.getInt("AUDIO_CACHE"));
    localStringBuilder.append(" VideoCache:");
    localStringBuilder.append(paramBundle.getInt("VIDEO_CACHE"));
    localStringBuilder.append(" VideoCacheFrameCount:");
    localStringBuilder.append(paramBundle.getInt("V_SUM_CACHE_SIZE"));
    localStringBuilder.append(" VideoDecoderCacheFrameCount:");
    localStringBuilder.append(paramBundle.getInt("V_DEC_CACHE_SIZE"));
    localStringBuilder.append(" AVJitterSync:");
    localStringBuilder.append(paramBundle.getInt("AV_RECV_INTERVAL"));
    localStringBuilder.append(" AVPlaySync:");
    localStringBuilder.append(paramBundle.getInt("AV_PLAY_INTERVAL"));
    localStringBuilder.append(" AudioParamsInfo:");
    localStringBuilder.append(paramBundle.getString("AUDIO_PLAY_INFO"));
    return localStringBuilder.toString();
  }
  
  private void a(int paramInt, Bundle paramBundle)
  {
    Object localObject;
    if ((paramInt == 15001) && (paramBundle != null))
    {
      localObject = this.k;
      if (localObject == null) {
        return;
      }
      boolean bool = ((String)localObject).startsWith("room://");
      this.G = a(paramBundle);
      paramInt = paramBundle.getInt("AUDIO_CACHE", 0);
      int i1 = paramBundle.getInt("NET_SPEED", 0);
      int i2 = paramBundle.getInt("VIDEO_FPS", 0);
      int i3 = paramBundle.getInt("AV_RECV_INTERVAL");
      int i4 = paramBundle.getInt("AV_PLAY_INTERVAL");
      if (((!bool) && (this.H > paramInt)) || (i1 < 10) || ((i2 != 0) && (i2 < 5)) || (Math.abs(i3) > 5000) || (Math.abs(i4) > 5000)) {
        h();
      }
    }
    else if ((paramInt == 2007) || (paramInt == 2105))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[Event]code:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" param:");
      ((StringBuilder)localObject).append(paramBundle);
      TXCLog.i("TXLivePlayer", ((StringBuilder)localObject).toString());
      h();
    }
  }
  
  private void a(TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener, Bitmap paramBitmap)
  {
    if (paramITXSnapshotListener == null) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new a.5(this, paramITXSnapshotListener, paramBitmap));
  }
  
  private String c(String paramString, int paramInt)
  {
    Object localObject = paramString;
    if (paramInt != 6) {}
    for (;;)
    {
      String str;
      try
      {
        localObject = paramString.getBytes("UTF-8");
        StringBuilder localStringBuilder = new StringBuilder(localObject.length);
        paramInt = 0;
        if (paramInt < localObject.length)
        {
          if (localObject[paramInt] >= 0) {
            break label127;
          }
          i1 = localObject[paramInt] + 256;
          break label132;
          localStringBuilder.append((char)i1);
          break label219;
          localStringBuilder.append(String.format("%%%02X", new Object[] { Integer.valueOf(i1) }));
          break label219;
        }
        localObject = localStringBuilder.toString();
      }
      catch (Exception localException)
      {
        TXCLog.e("TXLivePlayer", "check play url failed.", localException);
        str = paramString;
      }
      return str.trim();
      label127:
      int i1 = str[paramInt];
      label132:
      if ((i1 > 32) && (i1 < 127) && (i1 != 34) && (i1 != 37) && (i1 != 60) && (i1 != 62) && (i1 != 91) && (i1 != 125) && (i1 != 92) && (i1 != 93) && (i1 != 94) && (i1 != 96) && (i1 != 123)) {
        if (i1 == 124)
        {
          continue;
          label219:
          paramInt += 1;
        }
      }
    }
  }
  
  private void f()
  {
    Object localObject = this.t;
    if (localObject != null)
    {
      boolean bool;
      if (this.E > 0) {
        bool = true;
      } else {
        bool = false;
      }
      ((n)localObject).a(bool, this.E);
      if (this.E > 0)
      {
        if (this.I == null) {
          this.I = new a.a(this, null);
        }
        this.I.a(this.E);
        localObject = this.s;
        if (localObject != null)
        {
          ((Handler)localObject).removeCallbacks(this.I);
          this.s.postDelayed(this.I, this.E);
        }
      }
    }
  }
  
  private void g()
  {
    Object localObject = this.t;
    if (localObject != null) {
      ((n)localObject).a(false, 0);
    }
    localObject = this.s;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacks(this.I);
    }
    this.I = null;
    this.E = 0;
  }
  
  private void h()
  {
    long l1 = System.currentTimeMillis();
    if (l1 - this.F > 3000L)
    {
      this.F = l1;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("statistics:");
      localStringBuilder.append(this.G);
      a("[Statistics] logStatisticsStr", localStringBuilder.toString());
    }
  }
  
  private boolean i()
  {
    return (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) && (Build.MODEL.equalsIgnoreCase("Che2-TL00"));
  }
  
  public int a(TXLivePlayer.ITXLivePlayVideoRenderListener paramITXLivePlayVideoRenderListener, Object paramObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("listener:");
    ((StringBuilder)localObject).append(paramITXLivePlayVideoRenderListener);
    ((StringBuilder)localObject).append(" context:");
    ((StringBuilder)localObject).append(paramObject);
    a("[API] setVideoRenderListener", ((StringBuilder)localObject).toString());
    if (paramObject != null) {
      if (Build.VERSION.SDK_INT >= 17)
      {
        if ((!(paramObject instanceof javax.microedition.khronos.egl.EGLContext)) && (!(paramObject instanceof android.opengl.EGLContext)))
        {
          paramITXLivePlayVideoRenderListener = new StringBuilder();
          paramITXLivePlayVideoRenderListener.append("[API] setVideoRenderListener error when glContext error ");
          paramITXLivePlayVideoRenderListener.append(paramObject);
          TXCLog.w("TXLivePlayer", paramITXLivePlayVideoRenderListener.toString());
          return -1;
        }
      }
      else if (!(paramObject instanceof javax.microedition.khronos.egl.EGLContext))
      {
        paramITXLivePlayVideoRenderListener = new StringBuilder();
        paramITXLivePlayVideoRenderListener.append("[API] setVideoRenderListener error when glContext error ");
        paramITXLivePlayVideoRenderListener.append(paramObject);
        TXCLog.w("TXLivePlayer", paramITXLivePlayVideoRenderListener.toString());
        return -1;
      }
    }
    this.p = paramObject;
    this.q = paramITXLivePlayVideoRenderListener;
    localObject = this.t;
    if (localObject != null) {
      if (paramITXLivePlayVideoRenderListener != null) {
        ((n)localObject).a(new a.2(this), com.tencent.liteav.basic.a.b.c, paramObject);
      } else {
        ((n)localObject).a(null, com.tencent.liteav.basic.a.b.a, null);
      }
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("url:");
    ((StringBuilder)localObject).append(paramString);
    a("[SwitchStream][API] switchStream", ((StringBuilder)localObject).toString());
    localObject = this.t;
    if (localObject != null) {
      return ((n)localObject).a(paramString);
    }
    return -1;
  }
  
  public int a(String paramString, int paramInt)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int i1 = -1;
    if (bool)
    {
      paramString = new StringBuilder();
      paramString.append("start play error when url is empty ");
      paramString.append(this);
      TXCLog.e("TXLivePlayer", paramString.toString());
      return -1;
    }
    if (!TextUtils.isEmpty(this.k))
    {
      if ((this.k.equalsIgnoreCase(paramString)) && (a()))
      {
        paramString = new StringBuilder();
        paramString.append("start play error when new url is the same with old url  ");
        paramString.append(this);
        TXCLog.e("TXLivePlayer", paramString.toString());
        if (this.y) {
          onNotifyEvent(2004, new Bundle());
        }
        paramInt = i1;
        if (this.y) {
          paramInt = 0;
        }
        return paramInt;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" stop old play when new url is not the same with old url  ");
      ((StringBuilder)localObject).append(this);
      TXCLog.w("TXLivePlayer", ((StringBuilder)localObject).toString());
      localObject = this.t;
      if (localObject != null) {
        ((n)localObject).a(false);
      }
      this.k = "";
    }
    TXCDRApi.initCrashReport(this.r);
    TXCLog.i("TXLivePlayer", "[API] ===========================================================================================================================================================");
    TXCLog.i("TXLivePlayer", "[API] ===========================================================================================================================================================");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[API] =====  StartPlay url = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" playType = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" DeviceName = ");
    ((StringBuilder)localObject).append(f.c());
    ((StringBuilder)localObject).append(" SDKVersion = ");
    ((StringBuilder)localObject).append(TXCCommonUtil.getSDKID());
    ((StringBuilder)localObject).append(" , ");
    ((StringBuilder)localObject).append(TXCCommonUtil.getSDKVersionStr());
    ((StringBuilder)localObject).append("    ======");
    TXCLog.i("TXLivePlayer", ((StringBuilder)localObject).toString());
    TXCLog.i("TXLivePlayer", "[API] ===========================================================================================================================================================");
    TXCLog.i("TXLivePlayer", "[API] ===========================================================================================================================================================");
    i1 = this.B;
    if ((i1 == -1) || (i1 != paramInt)) {
      this.t = p.a(this.r, paramInt);
    }
    this.B = paramInt;
    if (this.t == null) {
      return -2;
    }
    this.k = c(paramString, paramInt);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" url:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" type:");
    ((StringBuilder)localObject).append(paramInt);
    a("[API] startPlay", ((StringBuilder)localObject).toString());
    a(this.f);
    paramString = this.a;
    if (paramString != null)
    {
      paramString.clearLog();
      this.a.setVisibility(0);
    }
    this.t.a(this.a);
    this.t.a(this);
    this.t.d(this.u);
    paramString = this.b;
    if (paramString != null)
    {
      this.t.a(paramString);
      this.t.a(this.c, this.d);
    }
    this.t.a(this.k, paramInt);
    this.t.b(this.l);
    this.t.c(this.m);
    this.t.a(this.v);
    this.t.b(this.j);
    this.t.a(this.i);
    this.t.a(this.J);
    paramString = this.n;
    if (paramString != null) {
      a(paramString);
    }
    paramString = this.q;
    if (paramString != null) {
      a(paramString, this.p);
    }
    if (this.t.e())
    {
      this.A = this.k;
      paramString = this.x;
      long l1;
      if (paramString != null) {
        l1 = paramString.a();
      } else {
        l1 = 0L;
      }
      this.z = l1;
      if (this.z > 0L) {
        this.t.f();
      }
    }
    f();
    return 0;
  }
  
  public int a(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("need clear:");
    ((StringBuilder)localObject).append(paramBoolean);
    a("[API] stopPlay", ((StringBuilder)localObject).toString());
    if (paramBoolean)
    {
      localObject = this.a;
      if (localObject != null) {
        ((TXCloudVideoView)localObject).setVisibility(8);
      }
    }
    g();
    localObject = this.t;
    if (localObject != null) {
      ((n)localObject).a(paramBoolean);
    }
    this.k = "";
    this.z = 0L;
    this.x = null;
    this.y = false;
    return 0;
  }
  
  @Deprecated
  public void a(float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[API] setRate ");
    ((StringBuilder)localObject).append(paramFloat);
    TXCLog.i("TXLivePlayer", ((StringBuilder)localObject).toString());
    this.v = paramFloat;
    localObject = this.t;
    if (localObject != null) {
      ((n)localObject).a(paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mode:");
    ((StringBuilder)localObject).append(paramInt);
    a("[API] setRenderMode", ((StringBuilder)localObject).toString());
    this.i = paramInt;
    localObject = this.t;
    if (localObject != null) {
      ((n)localObject).a(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("width:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" height:");
    ((StringBuilder)localObject).append(paramInt2);
    a("[API] setSurfaceSize", ((StringBuilder)localObject).toString());
    this.c = paramInt1;
    this.d = paramInt2;
    localObject = this.t;
    if (localObject != null) {
      ((n)localObject).a(paramInt1, paramInt2);
    }
  }
  
  public void a(Surface paramSurface)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("old:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" new:");
    localStringBuilder.append(paramSurface);
    a("[API] setSurface", localStringBuilder.toString());
    this.b = paramSurface;
    paramSurface = this.t;
    if (paramSurface != null) {
      paramSurface.a(this.b);
    }
  }
  
  public void a(ITXLivePlayListener paramITXLivePlayListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("listener:");
    localStringBuilder.append(paramITXLivePlayListener);
    a("[API] setPlayListener", localStringBuilder.toString());
    this.e = paramITXLivePlayListener;
  }
  
  public void a(TXLivePlayConfig paramTXLivePlayConfig)
  {
    Object localObject;
    if (paramTXLivePlayConfig != null) {
      localObject = paramTXLivePlayConfig.toString();
    } else {
      localObject = null;
    }
    a("[API] setConfig", (String)localObject);
    this.f = paramTXLivePlayConfig;
    if (this.f == null) {
      this.f = new TXLivePlayConfig();
    }
    paramTXLivePlayConfig = this.t;
    if (paramTXLivePlayConfig != null)
    {
      localObject = paramTXLivePlayConfig.i();
      paramTXLivePlayConfig = (TXLivePlayConfig)localObject;
      if (localObject == null) {
        paramTXLivePlayConfig = new h();
      }
      this.H = ((int)(this.f.mMinAutoAdjustCacheTime * 1000.0F));
      paramTXLivePlayConfig.a = this.f.mCacheTime;
      paramTXLivePlayConfig.g = this.f.mAutoAdjustCacheTime;
      paramTXLivePlayConfig.c = this.f.mMinAutoAdjustCacheTime;
      paramTXLivePlayConfig.b = this.f.mMaxAutoAdjustCacheTime;
      paramTXLivePlayConfig.d = this.f.mVideoBlockThreshold;
      paramTXLivePlayConfig.e = this.f.mConnectRetryCount;
      paramTXLivePlayConfig.f = this.f.mConnectRetryInterval;
      paramTXLivePlayConfig.i = this.f.mEnableNearestIP;
      paramTXLivePlayConfig.m = this.f.mRtmpChannelType;
      paramTXLivePlayConfig.h = this.g;
      paramTXLivePlayConfig.n = this.f.mCacheFolderPath;
      paramTXLivePlayConfig.o = this.f.mMaxCacheItems;
      paramTXLivePlayConfig.j = this.f.mEnableMessage;
      paramTXLivePlayConfig.k = this.f.mEnableMetaData;
      paramTXLivePlayConfig.l = this.f.mFlvSessionKey;
      paramTXLivePlayConfig.p = this.f.mHeaders;
      this.t.a(paramTXLivePlayConfig);
    }
  }
  
  public void a(TXLivePlayer.ITXAudioRawDataListener paramITXAudioRawDataListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("listener:");
    ((StringBuilder)localObject).append(paramITXAudioRawDataListener);
    a("[API] setAudioRawDataListener", ((StringBuilder)localObject).toString());
    this.J = paramITXAudioRawDataListener;
    localObject = this.t;
    if (localObject != null) {
      ((n)localObject).a(paramITXAudioRawDataListener);
    }
  }
  
  public void a(TXLivePlayer.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    this.D = paramITXAudioVolumeEvaluationListener;
  }
  
  public void a(TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    a("[API] snapshot", "");
    if (!this.w)
    {
      if (paramITXSnapshotListener == null) {
        return;
      }
      this.w = true;
      n localn = this.t;
      if (localn != null)
      {
        localn.a(new a.1(this, paramITXSnapshotListener));
        return;
      }
      this.w = false;
    }
  }
  
  public void a(TXLivePlayer.ITXVideoRawDataListener paramITXVideoRawDataListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("listener:");
    ((StringBuilder)localObject).append(paramITXVideoRawDataListener);
    a("[API] setVideoRawDataListener", ((StringBuilder)localObject).toString());
    this.n = paramITXVideoRawDataListener;
    localObject = this.t;
    if (localObject == null) {
      return;
    }
    if (paramITXVideoRawDataListener != null)
    {
      ((n)localObject).a(new a.3(this), com.tencent.liteav.basic.a.b.b, null);
      return;
    }
    ((n)localObject).a(null, com.tencent.liteav.basic.a.b.a, null);
  }
  
  public void a(TXCloudVideoView paramTXCloudVideoView)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("old:");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(" new:");
    ((StringBuilder)localObject).append(paramTXCloudVideoView);
    a("[API] setPlayerView", ((StringBuilder)localObject).toString());
    this.a = paramTXCloudVideoView;
    localObject = this.t;
    if (localObject != null) {
      ((n)localObject).a(paramTXCloudVideoView);
    }
  }
  
  public void a(TXRecordCommon.ITXVideoRecordListener paramITXVideoRecordListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("listener:");
    ((StringBuilder)localObject).append(paramITXVideoRecordListener);
    a("[API] setVideoRecordListener", ((StringBuilder)localObject).toString());
    localObject = this.t;
    if (localObject != null) {
      ((n)localObject).a(paramITXVideoRecordListener);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject = paramString1;
    if (paramString1 == null) {
      localObject = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    paramString2 = new StringBuilder();
    paramString2.append("tx_liveplayer(");
    paramString2.append(hashCode());
    paramString2.append(") ");
    paramString2.append((String)localObject);
    paramString2 = paramString2.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(paramString1);
    TXCLog.i("TXLivePlayer", ((StringBuilder)localObject).toString());
  }
  
  public boolean a()
  {
    n localn = this.t;
    if (localn != null) {
      return localn.c();
    }
    return false;
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    String str = this.k;
    if (str != null)
    {
      if (str.isEmpty()) {
        return false;
      }
      if (this.g)
      {
        TXLog.e("TXLivePlayer", "can not addVideoRawData because of hw decode has set!");
        return false;
      }
      if (this.t == null)
      {
        TXCLog.e("TXLivePlayer", "player hasn't created or not instanceof live player");
        return false;
      }
      this.o = paramArrayOfByte;
      return true;
    }
    return false;
  }
  
  public int b(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("domain:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" bizid:");
    ((StringBuilder)localObject).append(paramInt);
    a("[API] prepareLiveSeek", ((StringBuilder)localObject).toString());
    if (this.x == null) {
      this.x = new j();
    }
    localObject = this.x;
    if (localObject != null) {
      return ((j)localObject).a(this.k, paramString, paramInt, new a.4(this));
    }
    return -1;
  }
  
  public void b()
  {
    a("[API] pause", "");
    if (this.t != null)
    {
      TXCLog.w("TXLivePlayer", "pause play");
      this.t.a();
    }
  }
  
  public void b(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("rotation:");
    ((StringBuilder)localObject).append(paramInt);
    a("[API] setRenderRotation", ((StringBuilder)localObject).toString());
    this.j = paramInt;
    localObject = this.t;
    if (localObject != null) {
      ((n)localObject).b(paramInt);
    }
  }
  
  public void b(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("json:");
    ((StringBuilder)localObject).append(paramString);
    a("[API] callExperimentalAPI", ((StringBuilder)localObject).toString());
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (!localJSONObject.has("api"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("callExperimentalAPI[lack api or illegal type]: ");
        ((StringBuilder)localObject).append(paramString);
        TXCLog.e("TXLivePlayer", ((StringBuilder)localObject).toString());
        return;
      }
      str = localJSONObject.getString("api");
      localObject = null;
      if (localJSONObject.has("params")) {
        localObject = localJSONObject.getJSONObject("params");
      }
      if (!str.equals("muteRemoteAudioInSpeaker")) {
        break label215;
      }
      if (localObject == null)
      {
        TXCLog.e("TXLivePlayer", "muteRemoteAudioInSpeaker[lack parameter]");
        return;
      }
      if (!((JSONObject)localObject).has("enable"))
      {
        TXCLog.e("TXLivePlayer", "muteRemoteAudioInSpeaker[lack parameter]: enable");
        return;
      }
      int i1 = ((JSONObject)localObject).getInt("enable");
      if (this.t == null) {
        break label289;
      }
      localObject = this.t;
      bool = true;
      if (i1 != 1) {
        break label295;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str;
        continue;
        boolean bool = false;
      }
    }
    ((n)localObject).c(bool);
    return;
    label215:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("callExperimentalAPI[illegal api]: ");
    ((StringBuilder)localObject).append(str);
    TXCLog.e("TXLivePlayer", ((StringBuilder)localObject).toString());
    return;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("callExperimentalAPI[failed]: ");
    ((StringBuilder)localObject).append(paramString);
    TXCLog.e("TXLivePlayer", ((StringBuilder)localObject).toString());
    label289:
  }
  
  public boolean b(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enable:");
    ((StringBuilder)localObject).append(paramBoolean);
    a("[API] enableHardwareDecode", ((StringBuilder)localObject).toString());
    if (paramBoolean)
    {
      if (Build.VERSION.SDK_INT < 18)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("enableHardwareDecode failed, android system build.version = ");
        ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
        ((StringBuilder)localObject).append(", the minimum build.version should be 18(android 4.3 or later)");
        TXCLog.e("HardwareDecode", ((StringBuilder)localObject).toString());
        return false;
      }
      if (i())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("enableHardwareDecode failed, MANUFACTURER = ");
        ((StringBuilder)localObject).append(Build.MANUFACTURER);
        ((StringBuilder)localObject).append(", MODEL");
        ((StringBuilder)localObject).append(Build.MODEL);
        TXCLog.e("HardwareDecode", ((StringBuilder)localObject).toString());
        return false;
      }
    }
    this.g = paramBoolean;
    localObject = this.t;
    if (localObject != null)
    {
      h localh = ((n)localObject).i();
      localObject = localh;
      if (localh == null) {
        localObject = new h();
      }
      ((h)localObject).h = this.g;
      this.t.a((h)localObject);
    }
    return true;
  }
  
  public void c()
  {
    a("[API] resume", "");
    Object localObject = this.t;
    if (localObject != null)
    {
      ((n)localObject).b();
      if (this.t.e())
      {
        localObject = this.x;
        long l1;
        if (localObject != null) {
          l1 = ((j)localObject).a();
        } else {
          l1 = 0L;
        }
        this.z = l1;
        if (this.z > 0L) {
          this.t.f();
        }
      }
    }
  }
  
  public void c(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 0) {
      i1 = 0;
    }
    paramInt = i1;
    if (i1 > 100) {
      paramInt = 100;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("volume:");
    ((StringBuilder)localObject).append(paramInt);
    a("[API] setVolume", ((StringBuilder)localObject).toString());
    this.m = paramInt;
    localObject = this.t;
    if (localObject != null) {
      ((n)localObject).c(paramInt);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mute:");
    ((StringBuilder)localObject).append(paramBoolean);
    a("[API] setMute", ((StringBuilder)localObject).toString());
    this.l = paramBoolean;
    localObject = this.t;
    if (localObject != null) {
      ((n)localObject).b(paramBoolean);
    }
  }
  
  public int d()
  {
    a("[API] stopRecord", "");
    n localn = this.t;
    if (localn != null) {
      return localn.d();
    }
    return -1;
  }
  
  public void d(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("route:");
    localStringBuilder.append(paramInt);
    a("[API] setAudioRoute", localStringBuilder.toString());
    TXCAudioEngine.setAudioRoute(paramInt);
  }
  
  @Deprecated
  public void d(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[API] setAutoPlay ");
    localStringBuilder.append(paramBoolean);
    TXCLog.i("TXLivePlayer", localStringBuilder.toString());
    this.u = paramBoolean;
  }
  
  public int e()
  {
    a("[API] resumeLive", "");
    if (this.y)
    {
      this.y = false;
      return a(this.A, 1);
    }
    return -1;
  }
  
  public void e(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("intervalMs:");
    localStringBuilder.append(paramInt);
    a("[API] enableAudioVolumeEvaluation", localStringBuilder.toString());
    if (paramInt > 0)
    {
      int i1 = paramInt;
      if (paramInt < 100) {
        i1 = 100;
      }
      this.E = i1;
      f();
      return;
    }
    this.E = 0;
    g();
  }
  
  public int f(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("type:");
    ((StringBuilder)localObject).append(paramInt);
    a("[API] startRecord", ((StringBuilder)localObject).toString());
    if (Build.VERSION.SDK_INT < 18)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("API levl is too low (record need 18, current is");
      ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
      ((StringBuilder)localObject).append(")");
      TXCLog.e("TXLivePlayer", ((StringBuilder)localObject).toString());
      return -3;
    }
    if (!a())
    {
      TXCLog.e("TXLivePlayer", "startRecord: there is no playing stream");
      return -1;
    }
    localObject = this.t;
    if (localObject != null) {
      return ((n)localObject).d(paramInt);
    }
    return -1;
  }
  
  public void g(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("time:");
    ((StringBuilder)localObject).append(paramInt);
    a("[API] seek", ((StringBuilder)localObject).toString());
    localObject = this.t;
    if (localObject != null)
    {
      if ((!((n)localObject).e()) && (!this.y))
      {
        this.t.e(paramInt);
        return;
      }
      localObject = this.x;
      if (localObject != null) {
        localObject = ((j)localObject).a(paramInt);
      } else {
        localObject = "";
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        boolean bool;
        if (a((String)localObject, 3) == 0) {
          bool = true;
        } else {
          bool = false;
        }
        this.y = bool;
        if (this.y) {
          this.z = (paramInt * 1000);
        }
      }
      else
      {
        localObject = this.e;
        if (localObject != null) {
          ((ITXLivePlayListener)localObject).onPlayEvent(-2301, new Bundle());
        }
      }
    }
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    int i1 = paramInt;
    a(paramInt, paramBundle);
    Object localObject;
    if (i1 == 15001)
    {
      localObject = this.a;
      if (localObject != null) {
        ((TXCloudVideoView)localObject).setLogText(paramBundle, null, 0);
      }
      localObject = this.e;
      if (localObject != null) {
        ((ITXLivePlayListener)localObject).onNetStatus(paramBundle);
      }
    }
    else
    {
      long l1;
      if (i1 == 2005)
      {
        l1 = paramBundle.getInt("EVT_PLAY_PROGRESS_MS") + this.z;
        if (l1 > 0L)
        {
          paramBundle.putInt("EVT_PLAY_PROGRESS", (int)(l1 / 1000L));
          paramBundle.putInt("EVT_PLAY_PROGRESS_MS", (int)l1);
          localObject = this.e;
          if (localObject != null) {
            ((ITXLivePlayListener)localObject).onPlayEvent(i1, paramBundle);
          }
        }
      }
      else
      {
        if (i1 == 2026) {
          return;
        }
        l1 = System.currentTimeMillis();
        if (i1 == 2101)
        {
          if (l1 - this.C < 5000L) {
            return;
          }
          this.C = l1;
        }
        if ((i1 != 2005) && (i1 != 2012))
        {
          localObject = this.k;
          if ((localObject != null) && (((String)localObject).length() > 0))
          {
            localObject = paramBundle.getString("EVT_MSG");
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("event:");
            localStringBuilder.append(i1);
            localStringBuilder.append(" msg:");
            localStringBuilder.append((String)localObject);
            a("onNotifyEvent", localStringBuilder.toString());
          }
        }
        if (i1 != -2309) {
          if (i1 != -2307) {
            if (i1 != -2304) {
              if (i1 != 2015) {
                if (i1 != 2028) {
                  if (i1 != 2031) {
                    if (i1 != 2101) {
                      if (i1 != 2103) {
                        if (i1 != 2109) {
                          if (i1 != 3003) {
                            if (i1 != -2302)
                            {
                              if (i1 == -2301) {
                                break label637;
                              }
                              if (i1 != 2012) {
                                if (i1 != 2013) {
                                  if ((i1 != 2021) && (i1 != 2022))
                                  {
                                    paramInt = i1;
                                    if (i1 == 2105) {
                                      break label641;
                                    }
                                    if (i1 != 2106) {
                                      if ((i1 != 3006) && (i1 != 3007)) {
                                        if ((i1 != 3009) && (i1 != 3010)) {
                                          paramInt = i1;
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        switch (i1)
        {
        default: 
          switch (i1)
          {
          default: 
            return;
          case 2009: 
            paramInt = 2009;
            break;
          case 2007: 
            paramInt = 2007;
          }
          break;
        case 2005: 
          paramInt = 2005;
          break;
        case 2004: 
          paramInt = 2004;
          break;
        case 2002: 
          paramInt = 2002;
          break;
        case 2001: 
          paramInt = 2001;
          break;
          paramInt = 3002;
          break;
          paramInt = 3005;
          break;
          paramInt = 2106;
          break;
          paramInt = 2008;
          break;
          paramInt = 2013;
          break;
          paramInt = 2012;
          break;
          paramInt = -2302;
          break;
          paramInt = 3003;
          break;
          return;
          paramInt = 2103;
          break;
          paramInt = 2101;
          break;
          paramInt = 2031;
          break;
          paramInt = 2028;
          break;
          paramInt = 2015;
          break;
          paramInt = -2304;
          break;
          paramInt = -2307;
          break;
          label637:
          paramInt = -2301;
        }
        label641:
        localObject = this.a;
        if (localObject != null) {
          ((TXCloudVideoView)localObject).setLogText(null, paramBundle, paramInt);
        }
        localObject = this.e;
        if (localObject != null) {
          ((ITXLivePlayListener)localObject).onPlayEvent(paramInt, paramBundle);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.rtmp.a
 * JD-Core Version:    0.7.0.1
 */