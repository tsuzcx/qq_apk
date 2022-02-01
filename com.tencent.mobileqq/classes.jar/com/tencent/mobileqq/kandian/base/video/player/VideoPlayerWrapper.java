package com.tencent.mobileqq.kandian.base.video.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.tencent.mobileqq.kandian.base.utils.ThreadUtil;
import com.tencent.mobileqq.kandian.base.utils.VideoSessionUtils;
import com.tencent.mobileqq.kandian.base.video.VideoPlayUtils;
import com.tencent.mobileqq.kandian.base.video.player.api.IEventListener;
import com.tencent.mobileqq.kandian.base.video.player.api.IPlayer;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoView;
import com.tencent.mobileqq.kandian.base.video.player.api.MediaPlayListener;
import com.tencent.mobileqq.kandian.base.video.player.config.CodecReuseHelper;
import com.tencent.mobileqq.kandian.base.video.player.config.CodecReuseHelper.OnCodecReuseInfoUpdateCallback;
import com.tencent.mobileqq.kandian.base.video.player.config.ISuperPlayerOptionConfig;
import com.tencent.mobileqq.kandian.base.video.player.config.QuicConfigHelper;
import com.tencent.mobileqq.kandian.base.video.player.config.QuicConfigHelper.Companion;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.IPlayerFactory;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper.Companion;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerVideoInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.seamless.SPSeamlessHelper;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPMediaCodecInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPProtocolInfo;
import com.tencent.util.VersionUtils;
import com.tencent.viola.utils.ViolaLogUtils;
import java.net.URL;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoPlayerWrapper
  implements PlayState, IEventListener, IVideoPlayerWrapper
{
  private static int P = 6;
  private static boolean Q = true;
  private static ISuperPlayerOptionConfig ab;
  private AtomicInteger A;
  private MediaPlayListener B;
  private Object C;
  private int D;
  private long E;
  private long F;
  private long G;
  private long H;
  private long I;
  private long J;
  private int K;
  private final Object L;
  private int M;
  private boolean N;
  private boolean O;
  private boolean R;
  private boolean S;
  private boolean T;
  private CodecReuseHelper U;
  private CodecReuseHelper.OnCodecReuseInfoUpdateCallback V;
  private boolean W;
  private String X;
  private String Y;
  private boolean Z;
  public boolean a;
  private QuicConfigHelper aa;
  protected Context b;
  public long c;
  public int d;
  public long e;
  public long f;
  public boolean g;
  public String h;
  public int i;
  public long j;
  public long k;
  public long l;
  public long m;
  public long n;
  public long o;
  public long p;
  public int q;
  public int r;
  public int s;
  private final String t;
  private int u;
  private boolean v;
  @Nullable
  private IPlayer w;
  @NotNull
  private IPlayerFactory x;
  @Nullable
  private IVideoView y;
  private ViewGroup z;
  
  public VideoPlayerWrapper(Context paramContext)
  {
    this(paramContext, "");
  }
  
  public VideoPlayerWrapper(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.readinjoy.video.VideoPlayerWrapper<");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    localStringBuilder.append(">");
    this.t = localStringBuilder.toString();
    this.u = 101;
    this.a = false;
    this.v = false;
    this.A = new AtomicInteger(0);
    this.D = 0;
    this.L = new Object();
    this.f = 0L;
    this.M = 0;
    this.g = false;
    this.O = false;
    this.S = false;
    this.T = false;
    this.i = -1;
    this.U = new CodecReuseHelper();
    this.V = null;
    this.W = false;
    this.Z = false;
    this.aa = new QuicConfigHelper();
    this.b = paramContext;
    d(paramString);
    this.X = VideoSessionUtils.a();
  }
  
  public static void a(ISuperPlayerOptionConfig paramISuperPlayerOptionConfig)
  {
    ab = paramISuperPlayerOptionConfig;
  }
  
  private void a(PlayerVideoInfo paramPlayerVideoInfo)
  {
    if (paramPlayerVideoInfo != null)
    {
      paramPlayerVideoInfo.c(this.N);
      paramPlayerVideoInfo.b(this.O);
      paramPlayerVideoInfo.a(P);
    }
  }
  
  private IVideoView ab()
  {
    Context localContext = this.b;
    if (localContext == null)
    {
      QLog.d(this.t, 2, "createVideoView_Scroll: error, mContext null");
      return null;
    }
    return this.x.a(localContext, VersionUtils.d());
  }
  
  private boolean ac()
  {
    IPlayer localIPlayer = this.w;
    if (localIPlayer == null) {
      return false;
    }
    if (localIPlayer.e())
    {
      this.A.set(1);
      return true;
    }
    if (this.w.f())
    {
      this.A.set(2);
      return true;
    }
    if (this.w.d())
    {
      this.A.set(4);
      return true;
    }
    if (this.w.c())
    {
      this.A.set(3);
      return true;
    }
    if (this.w.j())
    {
      this.A.set(5);
      return true;
    }
    this.A.set(6);
    if (QLog.isColorLevel()) {
      QLog.d(this.t, 2, "seamlessAttachVideoView: error state");
    }
    return false;
  }
  
  private boolean ad()
  {
    boolean bool2 = this.T;
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (PlayerHelper.a.a()) {
      return this.A.compareAndSet(0, 1);
    }
    if ((this.A.compareAndSet(0, 1)) || (this.A.compareAndSet(7, 1)) || (this.A.compareAndSet(6, 1))) {
      bool1 = true;
    }
    return bool1;
  }
  
  private void ae()
  {
    this.M = 0;
    this.f = 0L;
    this.e = 0L;
    this.j = 0L;
    this.k = 0L;
    this.l = 0L;
    this.m = 0L;
    this.n = 0L;
    this.o = 0L;
  }
  
  private int b(ViewGroup paramViewGroup)
  {
    IVideoView localIVideoView = this.y;
    if ((localIVideoView != null) && ((localIVideoView.a() instanceof ISPlayerVideoView)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.t, 2, "seamlessAttachVideoView: ");
      }
      SPSeamlessHelper.get().attachVideoView(paramViewGroup, (ISPlayerVideoView)this.y.a(), new ViewGroup.LayoutParams(-1, -1));
      if (!this.T) {
        return 1;
      }
      if (!ac()) {
        return 2;
      }
      t();
    }
    return 0;
  }
  
  private void b(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("VideoFeedsPlayManager playerStartByUrl vid = ");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("VideoFeedsPlayManager.preplay", 2, ((StringBuilder)localObject).toString());
    }
    if (QLog.isColorLevel())
    {
      localObject = this.t;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("#VideoPlayerWrapper# playerStartByUrl, url:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", fileSize:");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(", videoDuration:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("，mState:");
      localStringBuilder.append(VideoPlayUtils.a(this.A.get()));
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (!ad())
    {
      paramString2 = this.t;
      paramString3 = new StringBuilder();
      paramString3.append("not idle or complete state, should't reopen mediaplayer, vid:");
      paramString3.append(paramString1);
      paramString3.append("，mState:");
      paramString3.append(VideoPlayUtils.a(this.A.get()));
      paramString3.append(" ,mIsSeamlessPlay:");
      paramString3.append(this.T);
      QLog.e(paramString2, 1, paramString3.toString());
      return;
    }
    T();
    boolean bool = false;
    if (paramBoolean2)
    {
      localObject = ThirdVideoManager.a().c(paramString2);
      a((String[])localObject);
    }
    else
    {
      localObject = new String[1];
      localObject[0] = paramString2;
      a((String[])localObject);
    }
    paramString1 = new PlayerVideoInfo(paramInt1, paramString1, (String[])localObject);
    paramString1.a(paramBoolean3);
    paramString1.a(paramInt2 * 1000);
    paramString1.d(paramBoolean1);
    paramString1.b(paramString3);
    a(paramString1);
    if ((this.b != null) && (this.w != null))
    {
      paramString3 = k(paramBoolean3);
      paramString3.superPlayerDownOption.quicEnableMode = QuicConfigHelper.a.a(this.b, paramString2);
      paramString3.superPlayerDownOption.enableQuicPlaintext = QuicConfigHelper.a.a();
      paramString3.superPlayerDownOption.enableQuicConnectionMigration = QuicConfigHelper.a.b();
      paramString3.superPlayerDownOption.quicCongestionType = QuicConfigHelper.a.c();
      paramString3.bandwidthReportHost = e(paramString2);
      paramString2 = this.aa;
      paramBoolean1 = bool;
      if (paramString3.superPlayerDownOption.quicEnableMode > 0) {
        paramBoolean1 = true;
      }
      paramString2.a(paramBoolean1);
      this.w.a(this.b, paramString1, paramLong1, paramString3);
    }
    this.G = 0L;
    this.F = 0L;
    this.E = 0L;
    this.H = paramLong1;
    this.u = paramInt1;
  }
  
  public static void c(int paramInt)
  {
    P = paramInt;
  }
  
  private void d(String paramString)
  {
    this.x = PlayerHelper.a.b();
    if (this.b != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.t, 2, "VideoPlayerWrapper initPlayer success!");
      }
      boolean bool = TextUtils.isEmpty(paramString) ^ true;
      Object localObject;
      if (bool)
      {
        this.T = c(paramString);
        if (!this.T)
        {
          localObject = this.t;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("SeamlessPlay error for that token(");
          localStringBuilder.append(paramString);
          localStringBuilder.append(") is not validate.");
          QLog.e((String)localObject, 2, localStringBuilder.toString());
        }
      }
      if (!this.T)
      {
        this.R = Q;
        this.w = this.x.a(null);
      }
      this.w.a(this);
      g(this.R);
      h(this.S);
      if (QLog.isColorLevel())
      {
        paramString = this.t;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("new VideoPlayerWrapper, needSeamlessPlay:");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(" ,mIsSeamlessPlay:");
        ((StringBuilder)localObject).append(this.T);
        QLog.d(paramString, 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private String e(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new URL(paramString).getHost();
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public static void j(boolean paramBoolean)
  {
    Q = paramBoolean;
  }
  
  private SuperPlayerOption k(boolean paramBoolean)
  {
    SuperPlayerOption localSuperPlayerOption = SuperPlayerOption.obtain(104);
    localSuperPlayerOption.isPrePlay = paramBoolean;
    Object localObject = ab;
    if (localObject != null) {
      ((ISuperPlayerOptionConfig)localObject).a(localSuperPlayerOption, this.Z);
    }
    if (QLog.isColorLevel())
    {
      localObject = this.t;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("commonPlayerOption: ");
      localStringBuilder.append(localSuperPlayerOption);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    return localSuperPlayerOption;
  }
  
  public void A()
  {
    IPlayer localIPlayer = this.w;
    if (localIPlayer != null) {
      localIPlayer.l();
    }
  }
  
  public void B()
  {
    IPlayer localIPlayer = this.w;
    if (localIPlayer != null) {
      localIPlayer.m();
    }
  }
  
  public long C()
  {
    IPlayer localIPlayer = this.w;
    if (localIPlayer == null) {
      return 0L;
    }
    return localIPlayer.o();
  }
  
  public void D()
  {
    b(this.W ^ true);
  }
  
  public Object E()
  {
    return this.C;
  }
  
  public int F()
  {
    IPlayer localIPlayer = this.w;
    if (localIPlayer != null) {
      return localIPlayer.p();
    }
    return -1;
  }
  
  public int G()
  {
    IPlayer localIPlayer = this.w;
    if (localIPlayer != null) {
      return localIPlayer.q();
    }
    return -1;
  }
  
  public String H()
  {
    return this.X;
  }
  
  public long I()
  {
    long l1 = this.E;
    if (l1 != 0L) {
      return l1;
    }
    IPlayer localIPlayer = this.w;
    if (localIPlayer != null) {
      return localIPlayer.n();
    }
    return -1L;
  }
  
  public long J()
  {
    return this.J;
  }
  
  public int K()
  {
    return this.K;
  }
  
  public int L()
  {
    int i1 = this.u;
    if ((i1 != 104) && (i1 != 102)) {
      return 0;
    }
    return 1;
  }
  
  public long M()
  {
    return this.e;
  }
  
  public void N()
  {
    this.G += d(true);
    this.F = 0L;
    this.H = 0L;
  }
  
  public long O()
  {
    return this.H;
  }
  
  public int P()
  {
    if (this.w != null)
    {
      long l1 = this.e;
      if (l1 != 0L)
      {
        float f1 = (float)this.f / (float)l1;
        return Math.round((float)I() * f1 / 1000.0F);
      }
    }
    return 0;
  }
  
  public boolean Q()
  {
    IPlayer localIPlayer = this.w;
    if (localIPlayer != null) {
      return localIPlayer.b();
    }
    return this.R;
  }
  
  public boolean R()
  {
    return this.S;
  }
  
  public boolean S()
  {
    return this.v;
  }
  
  public void T()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.t, 2, "resetVariables: ");
    }
    this.u = 101;
    this.a = false;
    this.v = false;
    this.E = 0L;
    this.F = 0L;
    this.G = 0L;
    this.H = 0L;
    this.I = 0L;
    this.J = 0L;
    this.K = 0;
    this.c = 0L;
    this.d = 0;
    this.g = false;
    this.i = -1;
    this.T = false;
    this.Z = false;
    ae();
  }
  
  public String U()
  {
    return this.h;
  }
  
  public String V()
  {
    IPlayer localIPlayer = this.w;
    if (localIPlayer != null) {
      return localIPlayer.t();
    }
    return "";
  }
  
  public void W()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.t, 2, "detachVideoPlayer: ");
    }
    this.W = true;
    IPlayer localIPlayer = this.w;
    if (localIPlayer != null) {
      localIPlayer.a(null);
    }
    this.Y = V();
    this.w = null;
  }
  
  public boolean X()
  {
    return c(this.Y);
  }
  
  public void Y()
  {
    IPlayer localIPlayer = this.w;
    if (localIPlayer != null) {
      localIPlayer.v();
    }
  }
  
  public boolean Z()
  {
    return this.T;
  }
  
  public Properties a()
  {
    return new Properties();
  }
  
  public void a(float paramFloat)
  {
    IPlayer localIPlayer = this.w;
    if (localIPlayer != null) {
      localIPlayer.a(paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    String str = this.t;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("test seekTo aaa");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",state:");
    localStringBuilder.append(this.A.get());
    ViolaLogUtils.d(str, localStringBuilder.toString());
    if ((this.w != null) && (this.A.get() != 0) && (this.A.get() != 2) && (this.A.get() != 1) && (this.A.get() != 4) && (this.A.get() != 8))
    {
      long l1 = C();
      long l2 = this.H;
      if (l1 - l2 > 0L) {
        this.F += l1 - l2;
      }
      this.H = paramInt;
      this.w.a(paramInt, 1);
      this.v = true;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    IPlayer localIPlayer = this.w;
    if (localIPlayer != null) {
      localIPlayer.a(10, 20, 3);
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = this.t;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[IPlayer] onDownloadCallback downloadedSizeBytes: ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(", totalSizeBytes=");
      localStringBuilder.append(paramLong2);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.e != paramLong2) {
      ae();
    }
    this.e = paramLong2;
    this.f = Math.max(this.f, paramLong1);
    if (this.d <= 0)
    {
      paramLong1 = this.e;
      if (paramLong1 > 0L)
      {
        paramLong2 = this.E;
        if (paramLong2 > 0L) {
          this.d = ((int)((float)paramLong1 / 1024.0F * 8.0F / ((float)paramLong2 / 1000.0F)));
        }
      }
    }
    try
    {
      paramString = new JSONObject(paramString);
      this.j = Math.max(paramString.optLong("HttpDownloadSize"), this.j);
      this.k = Math.max(paramString.optLong("HttpRepeatedSize"), this.k);
      this.l = Math.max(paramString.optLong("PcdnDownloadSize"), this.l);
      this.m = Math.max(paramString.optLong("PcdnRepeatedSize"), this.m);
      this.n = Math.max(paramString.optLong("P2PDownloadSize"), this.n);
      this.o = Math.max(paramString.optLong("P2PRepeatedSize"), this.o);
      this.p = Math.max(paramString.optLong("pcdnRequestSize"), this.p);
      this.q = Math.max(paramString.optInt("pcdnRequestCount"), this.q);
      this.r = Math.max(paramString.optInt("pcdnDownloadFailCount"), this.r);
      this.s = Math.max(paramString.optInt("pcdnDownloadSuccessCount"), this.s);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    a(paramViewGroup, false, true);
  }
  
  public void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    a(paramViewGroup, paramBoolean, true);
  }
  
  public void a(ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = this.t;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initVideoView parent:");
      ((StringBuilder)localObject2).append(paramViewGroup);
      ((StringBuilder)localObject2).append(" ,reUseVideoView:");
      ((StringBuilder)localObject2).append(paramBoolean1);
      ((StringBuilder)localObject2).append(" ,autoAttachVideoView:");
      ((StringBuilder)localObject2).append(paramBoolean2);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    this.z = paramViewGroup;
    Object localObject1 = null;
    Object localObject2 = this.w;
    if (localObject2 != null) {
      localObject1 = ((IPlayer)localObject2).u();
    }
    int i1;
    if ((paramBoolean1) && (this.T) && (localObject1 != null)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      this.y = ((IVideoView)localObject1);
    } else {
      e();
    }
    if (paramViewGroup != null)
    {
      localObject1 = this.y;
      if ((localObject1 != null) && (((IVideoView)localObject1).a() != null))
      {
        if (i1 != 0)
        {
          if (paramBoolean2) {
            b(paramViewGroup);
          }
          a(this.y);
          return;
        }
        paramViewGroup.addView(this.y.a(), new ViewGroup.LayoutParams(-1, -1));
        a(this.y);
      }
    }
  }
  
  public void a(@NotNull IPlayer paramIPlayer)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.t;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[IPlayer] onVideoPrepared(): stremDumpInfo=");
      localStringBuilder.append(paramIPlayer.r());
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.A.set(2);
    Object localObject = this.B;
    if (localObject != null) {
      ((MediaPlayListener)localObject).a(this, this.C);
    }
    localObject = this.w;
    if (localObject != null) {
      this.E = ((IPlayer)localObject).n();
    }
    long l1 = this.e;
    if (l1 > 0L)
    {
      long l2 = this.E;
      if (l2 > 0L) {
        this.d = ((int)((float)l1 / 1024.0F * 8.0F / ((float)l2 / 1000.0F)));
      }
    }
    com.tencent.mobileqq.app.ThreadManager.post(new VideoPlayerWrapper.1(this, paramIPlayer), 5, null, false);
  }
  
  public void a(@NotNull IPlayer paramIPlayer, int paramInt1, int paramInt2)
  {
    paramIPlayer = this.B;
    if (paramIPlayer != null) {
      paramIPlayer.a(this, false, paramInt2, paramInt1, null);
    }
  }
  
  public void a(@NotNull IPlayer paramIPlayer, int paramInt1, int paramInt2, int paramInt3, @Nullable Bitmap paramBitmap)
  {
    paramIPlayer = this.B;
    if (paramIPlayer != null) {
      paramIPlayer.a(this, true, 0, paramInt1, paramBitmap);
    }
  }
  
  public void a(IVideoView paramIVideoView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.t, 2, "attachVideoView: ");
    }
    IPlayer localIPlayer = this.w;
    if (localIPlayer == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.t, 2, "attachVideoView: videoplayer null");
      }
      return;
    }
    this.y = paramIVideoView;
    localIPlayer.a(this.y);
    this.w.a(this.D);
  }
  
  public void a(MediaPlayListener paramMediaPlayListener)
  {
    this.B = paramMediaPlayListener;
  }
  
  public void a(Object paramObject)
  {
    this.C = paramObject;
  }
  
  public void a(String paramString)
  {
    IPlayer localIPlayer = this.w;
    if (localIPlayer != null) {
      localIPlayer.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    a(paramString, paramInt, paramLong, false);
  }
  
  public void a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("VideoFeedsPlayManager playerStart vid = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("VideoFeedsPlayManager.preplay", 2, ((StringBuilder)localObject).toString());
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = this.t;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("#VideoPlayerWrapper# playerStart, vid:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", playType:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", startPosition:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("，mState:");
      localStringBuilder.append(VideoPlayUtils.a(this.A.get()));
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (!ad())
    {
      localObject = this.t;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("not idle or complete state, should't reopen mediaplayer, vid:");
      localStringBuilder.append(paramString);
      localStringBuilder.append("，mState:");
      localStringBuilder.append(VideoPlayUtils.a(this.A.get()));
      localStringBuilder.append(", mSeamlessPlay:");
      localStringBuilder.append(this.T);
      QLog.e((String)localObject, 1, localStringBuilder.toString());
      return;
    }
    T();
    paramString = new PlayerVideoInfo(paramInt, paramString);
    paramString.a(paramBoolean);
    paramString.a("cache_video");
    a(paramString);
    if ((this.b != null) && (this.w != null))
    {
      k(paramBoolean).bandwidthReportHost = "txvideo";
      this.w.a(this.b, paramString, paramLong, k(paramBoolean));
    }
    this.G = 0L;
    this.F = 0L;
    this.E = 0L;
    this.H = paramLong;
    this.u = paramInt;
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
    b(paramString1, paramString2, paramInt1, paramLong1, paramLong2, paramInt2, paramBoolean1, paramBoolean2, paramBoolean3, null);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    b(paramString1, paramString2, paramInt1, paramLong1, paramLong2, paramInt2, paramBoolean1, paramBoolean2, paramBoolean3, paramString3);
  }
  
  public void a(Map<String, String> paramMap)
  {
    IPlayer localIPlayer = this.w;
    if (localIPlayer != null) {
      localIPlayer.a(paramMap);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.N = paramBoolean;
  }
  
  public void a(String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramArrayOfString != null)
    {
      int i1 = 0;
      while (i1 < paramArrayOfString.length)
      {
        if (i1 != 0) {
          localStringBuilder.append(" ,");
        }
        localStringBuilder.append(paramArrayOfString[i1]);
        i1 += 1;
      }
    }
    this.h = localStringBuilder.toString();
  }
  
  public boolean a(@NotNull IPlayer paramIPlayer, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.t, 2, "VideoPlayerWrapper onError!");
    }
    this.A.set(6);
    paramIPlayer = this.B;
    if (paramIPlayer != null) {
      paramIPlayer.a(this, paramInt2, paramInt3, paramInt1, paramString, null);
    }
    return false;
  }
  
  public boolean a(@NotNull IPlayer paramIPlayer, int paramInt, @Nullable Object paramObject)
  {
    StringBuilder localStringBuilder;
    if (paramInt != 112)
    {
      if (paramInt != 113)
      {
        if (paramInt != 124)
        {
          if (paramInt != 205)
          {
            if (paramInt != 208)
            {
              if (paramInt == 251) {
                boolean bool = paramObject instanceof String;
              }
            }
            else
            {
              if ((paramObject instanceof TPPlayerMsg.TPMediaCodecInfo))
              {
                paramIPlayer = (TPPlayerMsg.TPMediaCodecInfo)paramObject;
                this.U.a(paramIPlayer);
              }
              com.tencent.qav.thread.ThreadManager.c(new VideoPlayerWrapper.2(this));
            }
          }
          else if ((paramObject instanceof TPPlayerMsg.TPProtocolInfo)) {
            this.aa.a((TPPlayerMsg.TPProtocolInfo)paramObject);
          }
        }
        else
        {
          paramIPlayer = this.B;
          if (paramIPlayer != null) {
            paramIPlayer.a(this, "");
          }
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          paramIPlayer = this.t;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("VideoPlayerWrapper onInfo, end buffering <== isSeeking = ");
          localStringBuilder.append(this.v);
          QLog.d(paramIPlayer, 2, localStringBuilder.toString());
        }
        if (this.A.get() != 5) {
          this.A.set(3);
        }
        if (!this.v)
        {
          this.K += 1;
          this.J += System.currentTimeMillis() - this.I;
        }
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramIPlayer = this.t;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("VideoPlayerWrapper onInfo, start buffering ==> isSeeking = ");
        localStringBuilder.append(this.v);
        QLog.d(paramIPlayer, 2, localStringBuilder.toString());
      }
      if (this.A.get() != 5) {
        this.A.set(4);
      }
      this.I = System.currentTimeMillis();
    }
    paramIPlayer = this.B;
    if (paramIPlayer != null) {
      paramIPlayer.a(this, paramInt, paramObject);
    }
    return false;
  }
  
  public boolean aa()
  {
    return this.W;
  }
  
  public View b()
  {
    IVideoView localIVideoView = this.y;
    if (localIVideoView != null) {
      return localIVideoView.a();
    }
    return null;
  }
  
  public void b(int paramInt)
  {
    this.D = paramInt;
    Object localObject = this.w;
    if (localObject != null) {
      ((IPlayer)localObject).a(paramInt);
    }
    if (QLog.isColorLevel())
    {
      localObject = this.t;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VideoPlayerWrapper: setXYaxis value:");
      localStringBuilder.append(paramInt);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
  }
  
  public void b(@NotNull IPlayer paramIPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.t, 2, "onCompletion: ");
    }
    this.A.set(7);
    paramIPlayer = this.B;
    if (paramIPlayer != null) {
      paramIPlayer.a(this);
    }
  }
  
  public void b(String paramString)
  {
    this.X = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.A.get() == 8) {
      return;
    }
    this.A.set(8);
    Object localObject = this.w;
    if (localObject != null) {
      com.tencent.mobileqq.app.ThreadManager.executeOnSubThread(new VideoPlayerWrapper.3(this, (IPlayer)localObject));
    }
    localObject = this.y;
    if (localObject != null) {
      localObject = ((IVideoView)localObject).a();
    } else {
      localObject = null;
    }
    ThreadUtil.a(new VideoPlayerWrapper.4(this, paramBoolean, (View)localObject));
    this.B = null;
    this.y = null;
    this.z = null;
    this.b = null;
    this.a = true;
    this.f = 0L;
    if (QLog.isColorLevel())
    {
      localObject = this.t;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VideoPlayerWrapper: destory removeView=");
      localStringBuilder.append(paramBoolean);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
  }
  
  public IVideoView c()
  {
    return this.y;
  }
  
  public void c(@NotNull IPlayer paramIPlayer)
  {
    if (QLog.isColorLevel())
    {
      paramIPlayer = this.t;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VideoPlayerWrapper: onSeekComplete， isPause=");
      localStringBuilder.append(m());
      QLog.d(paramIPlayer, 2, localStringBuilder.toString());
    }
    paramIPlayer = this.B;
    if (paramIPlayer != null) {
      paramIPlayer.c(this);
    }
    this.v = false;
  }
  
  public void c(boolean paramBoolean)
  {
    this.Z = paramBoolean;
  }
  
  public boolean c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.t, 2, "attachVideoPlayer: ");
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e(this.t, 2, "attachVideoPlayer failed for token is null.");
      return false;
    }
    this.w = this.x.a(paramString);
    paramString = this.w;
    if (paramString != null)
    {
      this.W = false;
      paramString.a(this);
      return ac();
    }
    QLog.e(this.t, 2, "AttachVideoPlayer error for can't obtain player by token.");
    return false;
  }
  
  public int d()
  {
    Object localObject = this.z;
    if ((localObject != null) && (this.T)) {
      return b((ViewGroup)localObject);
    }
    localObject = this.t;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seamlessAttachVideoView failed for parent is null or not seamlessPlay. mIsSeamlessPlay:");
    localStringBuilder.append(this.T);
    QLog.e((String)localObject, 2, localStringBuilder.toString());
    return 1;
  }
  
  public long d(boolean paramBoolean)
  {
    long l3 = this.F;
    long l1;
    if (paramBoolean) {
      l1 = I();
    } else {
      l1 = C();
    }
    long l4 = this.H;
    long l2 = l3;
    if (l1 - l4 > 0L) {
      l2 = l3 + (l1 - l4);
    }
    return l2;
  }
  
  public long e(boolean paramBoolean)
  {
    return this.G + d(paramBoolean);
  }
  
  public View e()
  {
    if (this.y == null) {
      try
      {
        if (this.y == null) {
          this.y = ab();
        }
      }
      finally {}
    }
    Object localObject2 = this.y;
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.t, 2, "createVideoView: null");
      }
      return null;
    }
    localObject2 = ((IVideoView)localObject2).a();
    if ((localObject2 != null) && (((View)localObject2).getParent() != null))
    {
      ViewParent localViewParent = ((View)localObject2).getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView((View)localObject2);
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.t, 2, "remove scroll view parents!");
      }
    }
    return localObject2;
  }
  
  public long f(boolean paramBoolean)
  {
    if (paramBoolean) {
      return I();
    }
    return C();
  }
  
  public void f()
  {
    IVideoView localIVideoView = this.y;
    if (localIVideoView != null) {
      localIVideoView.b();
    }
  }
  
  public void g()
  {
    IVideoView localIVideoView = this.y;
    if (localIVideoView != null) {
      localIVideoView.c();
    }
  }
  
  public void g(boolean paramBoolean)
  {
    this.R = paramBoolean;
    IPlayer localIPlayer = this.w;
    if (localIPlayer != null) {
      localIPlayer.a(paramBoolean);
    }
  }
  
  public int h()
  {
    return this.A.get();
  }
  
  public void h(boolean paramBoolean)
  {
    this.S = paramBoolean;
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      com.tencent.mobileqq.app.ThreadManager.excute(new VideoPlayerWrapper.5(this, paramBoolean), 16, null, false);
      return;
    }
    if ((this.w != null) && (this.A.get() != 6) && (this.A.get() != 8)) {
      this.w.b(paramBoolean);
    }
  }
  
  public void i(boolean paramBoolean)
  {
    this.O = paramBoolean;
  }
  
  public boolean i()
  {
    return this.A.get() == 0;
  }
  
  public boolean j()
  {
    return this.A.get() == 1;
  }
  
  public boolean k()
  {
    return this.A.get() == 2;
  }
  
  public boolean l()
  {
    return this.A.get() == 2;
  }
  
  public boolean m()
  {
    return this.A.get() == 5;
  }
  
  public boolean n()
  {
    return (this.A.get() == 3) || (this.A.get() == 4);
  }
  
  public boolean o()
  {
    return this.A.get() == 4;
  }
  
  public boolean p()
  {
    return this.A.get() == 7;
  }
  
  public boolean q()
  {
    return this.A.get() == 8;
  }
  
  public boolean r()
  {
    int i1 = this.A.get();
    boolean bool3 = PlayerHelper.a.a();
    boolean bool2 = false;
    boolean bool1 = false;
    if (bool3)
    {
      if (i1 == 0) {
        bool1 = true;
      }
      return bool1;
    }
    if ((i1 != 7) && (i1 != 0))
    {
      bool1 = bool2;
      if (i1 != 6) {}
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean s()
  {
    return (this.A.get() != 0) && (this.A.get() != 8) && (this.A.get() != 6) && (this.A.get() != 7);
  }
  
  public void t()
  {
    this.B.b(this);
  }
  
  public void u()
  {
    if (this.w == null) {
      return;
    }
    if (!s())
    {
      String str = this.t;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VideoPlayerWrapper: start failed, wrong state:");
      localStringBuilder.append(VideoPlayUtils.a(this.A.get()));
      localStringBuilder.append(", just return;");
      QLog.e(str, 1, localStringBuilder.toString());
      return;
    }
    this.A.set(3);
    this.w.g();
    if (QLog.isColorLevel()) {
      QLog.d(this.t, 2, "VideoPlayerWrapper: start");
    }
  }
  
  public void v()
  {
    u();
  }
  
  public void w()
  {
    if (this.w != null)
    {
      if (!s())
      {
        String str = this.t;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("VideoPlayerWrapper: pause failed, wrong state:");
        localStringBuilder.append(VideoPlayUtils.a(this.A.get()));
        localStringBuilder.append(", just return;");
        QLog.e(str, 1, localStringBuilder.toString());
        return;
      }
      this.A.set(5);
      this.w.h();
    }
  }
  
  public void x()
  {
    if (this.w == null) {
      return;
    }
    if (this.A.get() == 8)
    {
      QLog.e(this.t, 1, "VideoPlayerWrapper: stop failed, because has destoryed, just return;");
      return;
    }
    this.A.set(0);
    this.w.i();
    T();
    if (QLog.isColorLevel()) {
      QLog.d(this.t, 2, "VideoPlayerWrapper: stop ");
    }
  }
  
  public void y()
  {
    if (this.w == null) {
      return;
    }
    if (this.A.get() == 8)
    {
      QLog.e(this.t, 1, "VideoPlayerWrapper: release failed, because has destoryed, just return;");
      return;
    }
    this.A.set(8);
    this.w.k();
  }
  
  public void z()
  {
    IPlayer localIPlayer = this.w;
    if (localIPlayer != null) {
      localIPlayer.s();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper
 * JD-Core Version:    0.7.0.1
 */