package com.tencent.mobileqq.flashshow.player;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.view.Surface;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.mobileqq.flashshow.utils.FSProtoUtils;
import com.tencent.mobileqq.flashshow.utils.FSTransUtils;
import com.tencent.mobileqq.flashshow.utils.FSTransUtils._SceneID;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.qcircle.cooperation.config.SharePreferenceUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPCDNURLInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPDownLoadProgressInfo;
import com.tencent.thumbplayer.api.capability.TPCapability;
import com.tencent.thumbplayer.api.capability.TPVCodecCapabilityForGet;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import org.json.JSONException;
import org.json.JSONObject;

public final class FSPlayer
  implements ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnVideoPreparedListener
{
  public static String a = SharePreferenceUtils.a(FSTransUtils.f(), "key_sp_is_support_hevc");
  private static long n;
  private long A;
  private long B;
  private long C;
  private boolean D;
  private long E;
  private String F;
  private String G;
  private Stack<Pair<Long, Long>> H = new Stack();
  private FSQUICStatus I;
  protected boolean b = false;
  public String c = "0";
  protected long d = 0L;
  private ISuperPlayer e;
  private boolean f = true;
  private boolean g = false;
  private ISPlayerVideoView h;
  private volatile FSPlayerCallback i;
  private SuperPlayerVideoInfo j;
  private boolean k;
  private boolean l;
  private long m;
  private int o = 0;
  private int p = 0;
  private long q;
  private long r;
  private int s;
  private int t;
  private boolean u;
  private boolean v;
  private long w;
  private int x;
  private long y;
  private long z;
  
  private List a(List paramList)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    try
    {
      boolean bool = this.f;
      if (!bool) {
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("addToVideoSoloPlayTimeRangeList: [start=");
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append(", end=");
      ((StringBuilder)localObject1).append(paramLong2);
      ((StringBuilder)localObject1).append("]");
      QLog.d("FSPlayer", 1, ((StringBuilder)localObject1).toString());
      localObject1 = this.H.iterator();
      Pair localPair;
      while (((Iterator)localObject1).hasNext())
      {
        localPair = (Pair)((Iterator)localObject1).next();
        if ((((Long)localPair.first).longValue() <= paramLong1) && (((Long)localPair.second).longValue() >= paramLong2))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("addToVideoSoloPlayTimeRangeList: already contained [start=");
          ((StringBuilder)localObject1).append(paramLong1);
          ((StringBuilder)localObject1).append(", end=");
          ((StringBuilder)localObject1).append(paramLong2);
          ((StringBuilder)localObject1).append("]");
          QLog.d("FSPlayer", 1, ((StringBuilder)localObject1).toString());
          return;
        }
      }
      localObject1 = this.H.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localPair = (Pair)((Iterator)localObject1).next();
        if ((paramLong1 <= ((Long)localPair.first).longValue()) && (paramLong2 >= ((Long)localPair.second).longValue()))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("addToVideoSoloPlayTimeRangeList: remove [start=");
          localStringBuilder.append(localPair.first);
          localStringBuilder.append(", end=");
          localStringBuilder.append(localPair.second);
          localStringBuilder.append("]");
          QLog.d("FSPlayer", 1, localStringBuilder.toString());
          ((Iterator)localObject1).remove();
        }
      }
      localObject1 = this.H.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localPair = (Pair)((Iterator)localObject1).next();
        long l1 = paramLong1;
        if (paramLong1 >= ((Long)localPair.first).longValue())
        {
          l1 = paramLong1;
          if (paramLong1 <= ((Long)localPair.second).longValue()) {
            l1 = ((Long)localPair.second).longValue();
          }
        }
        paramLong1 = l1;
        if (paramLong2 >= ((Long)localPair.first).longValue())
        {
          paramLong1 = l1;
          if (paramLong2 <= ((Long)localPair.second).longValue())
          {
            paramLong2 = ((Long)localPair.first).longValue();
            paramLong1 = l1;
          }
        }
      }
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        for (;;)
        {
          throw localObject2;
        }
        if (paramLong1 >= 0L) {
          if (paramLong1 <= paramLong2) {}
        }
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("addToVideoSoloPlayTimeRangeList: already contained after adjustment [start=");
    ((StringBuilder)localObject1).append(paramLong1);
    ((StringBuilder)localObject1).append(", end=");
    ((StringBuilder)localObject1).append(paramLong2);
    ((StringBuilder)localObject1).append("]");
    QLog.d("FSPlayer", 1, ((StringBuilder)localObject1).toString());
    this.H.add(new Pair(Long.valueOf(paramLong1), Long.valueOf(paramLong2)));
    return;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("addToVideoSoloPlayTimeRangeList: already contained after adjustment [start=");
    ((StringBuilder)localObject1).append(paramLong1);
    ((StringBuilder)localObject1).append(", end=");
    ((StringBuilder)localObject1).append(paramLong2);
    ((StringBuilder)localObject1).append("]");
    QLog.d("FSPlayer", 1, ((StringBuilder)localObject1).toString());
  }
  
  private void a(Surface paramSurface)
  {
    if (this.e == null)
    {
      if (paramSurface == null)
      {
        this.h = SuperPlayerFactory.createPlayerVideoView(FSTransUtils.f());
        this.e = SuperPlayerFactory.createMediaPlayer(FSTransUtils.f(), FSTransUtils._SceneID.a(), this.h);
      }
      else
      {
        this.e = SuperPlayerFactory.createMediaPlayer(FSTransUtils.f(), FSTransUtils._SceneID.a(), null);
        this.e.setSurface(paramSurface);
      }
      this.e.setOnVideoPreparedListener(this);
      this.e.setOnErrorListener(this);
      this.e.setOnInfoListener(this);
      this.e.setOnCompletionListener(this);
      this.e.setOnSeekCompleteListener(this);
      this.e.setOnInfoListener(this);
      this.g = (SharePreferenceUtils.a(FSTransUtils.f(), "key_sp_is_detect_hevc").equals("") ^ true);
      if (!this.g)
      {
        try
        {
          a = String.valueOf(TPCapability.getThumbPlayerVCodecTypeMaxCapability(172, 102).getMaxLevel());
        }
        catch (Exception paramSurface)
        {
          QLog.e("FSPlayer", 1, "getThumbPlayerVCodecTypeMaxCapability() error,", paramSurface);
        }
        SharePreferenceUtils.a(FSTransUtils.f(), "key_sp_is_detect_hevc", "1");
        SharePreferenceUtils.a(FSTransUtils.f(), "key_sp_is_support_hevc", a);
        QLog.i("FSPlayer", 1, "this phone is support hevc");
      }
    }
  }
  
  private void a(TPPlayerMsg.TPCDNURLInfo paramTPCDNURLInfo)
  {
    this.F = paramTPCDNURLInfo.cdnIp;
    this.G = paramTPCDNURLInfo.uIp;
  }
  
  private void a(TPPlayerMsg.TPDownLoadProgressInfo paramTPDownLoadProgressInfo)
  {
    int i1 = paramTPDownLoadProgressInfo.downloadSpeedKBps;
    this.q = paramTPDownLoadProgressInfo.totalFileSize;
    if (!this.D)
    {
      this.o = Math.min(i1, this.o);
      this.p = Math.max(i1, this.p);
      this.s += 1;
      this.t += i1;
      b(paramTPDownLoadProgressInfo);
    }
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.I = new FSQUICStatus(paramString);
    this.I.a(new FSPlayer.2(this, paramString));
  }
  
  private void a(String paramString1, String paramString2)
  {
    this.D = FSVideoUtils.b(paramString2, paramString1);
  }
  
  private void a(String paramString, List paramList)
  {
    if (this.i == null)
    {
      QLog.w("FSPlayer", 1, "[report] invalid mPlayerCallback");
      return;
    }
    FSVideoReporter.a().a(this.d, paramString, this.i.getReportData(), a(paramList));
  }
  
  private void b(TPPlayerMsg.TPDownLoadProgressInfo paramTPDownLoadProgressInfo)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramTPDownLoadProgressInfo.extraInfo);
        if (localJSONObject.has("hitDownloaded"))
        {
          int i1 = localJSONObject.getInt("hitDownloaded");
          bool = true;
          if (i1 != 1) {
            break label118;
          }
          this.u = bool;
        }
        this.E = paramTPDownLoadProgressInfo.currentDownloadSize;
        if ((this.E == 0L) && (localJSONObject.has("localCacheSize"))) {
          this.E = localJSONObject.getLong("localCacheSize");
        }
        if (localJSONObject.has("httpAvgSpeedKB"))
        {
          this.r = localJSONObject.getLong("httpAvgSpeedKB");
          return;
        }
      }
      catch (Exception paramTPDownLoadProgressInfo)
      {
        paramTPDownLoadProgressInfo.printStackTrace();
      }
      return;
      label118:
      boolean bool = false;
    }
  }
  
  private void b(String paramString)
  {
    if (this.I == null)
    {
      QLog.d("FSPlayer", 1, "mQUICStatus null ");
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("FSPlayer", 1, "onQUICInfoUpdate np json");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onQUICInfoUpdate:");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("FSPlayer", 1, ((StringBuilder)localObject).toString());
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("isDownloadByQuic")) {
        this.I.e();
      }
      boolean bool = paramString.has("downloadComplete");
      if (bool)
      {
        localObject = paramString.getString("downloadComplete");
        if (TextUtils.equals((CharSequence)localObject, "quic")) {
          this.I.a();
        } else if (TextUtils.equals((CharSequence)localObject, "http")) {
          this.I.b();
        }
      }
      if (paramString.has("downloadFailed"))
      {
        paramString = paramString.getString("downloadFailed");
        if (TextUtils.equals(paramString, "quic"))
        {
          this.I.c();
          return;
        }
        if (TextUtils.equals(paramString, "http"))
        {
          this.I.d();
          return;
        }
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void s()
  {
    ISuperPlayer localISuperPlayer = this.e;
    if ((localISuperPlayer != null) && (localISuperPlayer.isPlaying())) {
      c();
    }
    this.r = 0L;
    this.q = 0L;
    this.u = false;
    this.v = false;
    this.w = 0L;
    this.x = 0;
    this.y = 0L;
    this.c = "0";
    this.D = false;
    this.t = 0;
    this.s = 0;
    this.o = 2147483647;
    this.p = -2147483648;
    this.b = true;
    this.d = 0L;
    this.E = 0L;
    this.F = null;
    this.G = null;
    r();
  }
  
  private void t()
  {
    if (this.A <= 0L) {
      return;
    }
    long l1 = System.currentTimeMillis() - this.A;
    a(this.C, e());
    if (this.i != null) {
      this.i.a(0, 0, j(), o());
    }
    this.A = 0L;
    this.C = 0L;
    Object localObject1 = this.e;
    if (localObject1 != null)
    {
      double d1 = ((ISuperPlayer)localObject1).getDurationMs();
      double d2 = l1;
      Double.isNaN(d2);
      Double.isNaN(d1);
      d1 = Math.min(100.0D, d2 / d1 * 100.0D);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(QCircleReportHelper.newEntry("ret_code", "0"));
      float f1 = (float)l1 / 1000.0F;
      localArrayList.add(QCircleReportHelper.newEntry("time_cost", String.valueOf(f1)));
      localObject1 = "";
      if (!TextUtils.isEmpty(this.F))
      {
        localArrayList.add(QCircleReportHelper.newEntry("server_ip", this.F));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append("cdnIp:");
        ((StringBuilder)localObject1).append(this.F);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      Object localObject2 = localObject1;
      if (!TextUtils.isEmpty(this.G))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(",ip:");
        ((StringBuilder)localObject2).append(this.G);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localArrayList.add(QCircleReportHelper.newEntry("attach_info", (String)localObject2));
      a("video_play_ret", localArrayList);
      if (v()) {
        localObject1 = "1";
      } else {
        localObject1 = "0";
      }
      a("video_play_cache", Collections.singletonList(QCircleReportHelper.newEntry("ret_code", (String)localObject1)));
      localObject1 = String.format("%d|%d|%d|%d", new Object[] { Long.valueOf(u()), Integer.valueOf(this.p), Integer.valueOf(this.o), Long.valueOf(this.r) });
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ReportCurrentAvgSpeed:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("FSPlayer", 1, ((StringBuilder)localObject2).toString());
      a("video_download_avg_speed", Collections.singletonList(QCircleReportHelper.newEntry("attach_info", (String)localObject1)));
      a("video_play_time_duration", Collections.singletonList(QCircleReportHelper.newEntry("time_cost", String.valueOf(f1))));
      a("video_play_complete_rate", Collections.singletonList(QCircleReportHelper.newEntry("rate", String.format("%.2f", new Object[] { Double.valueOf(d1) }))));
      q();
    }
    if (this.x > 0)
    {
      if (!this.b)
      {
        this.y += System.currentTimeMillis() - this.w;
        QLog.i("FSPlayer", 1, String.format("PLAYER_INFO_BUFFERING_HAS_NOT_END mSecondBufferCount:%d, mSecondBufferTime:%d", new Object[] { Integer.valueOf(this.x), Long.valueOf(this.y / 1000L) }));
      }
      QLog.i("FSPlayer", 1, String.format("PLAYER_INFO_BUFFERING_REPORT mSecondBufferCount:%d, mSecondBufferTime:%d", new Object[] { Integer.valueOf(this.x), Long.valueOf(this.y / 1000L) }));
      a("video_play_occur_buffer_times", Collections.singletonList(QCircleReportHelper.newEntry("buffer_count", String.valueOf(this.x))));
      a("video_buffer_time_consuming", Collections.singletonList(QCircleReportHelper.newEntry("time_cost", String.valueOf((float)this.y / 1000.0F))));
    }
    else
    {
      a("video_play_occur_buffer_times", Collections.singletonList(QCircleReportHelper.newEntry("buffer_count", "0")));
    }
    a("video_download_ret", Collections.singletonList(QCircleReportHelper.newEntry("ret_code", this.c)));
    FSVideoReporter.a().e();
  }
  
  private long u()
  {
    int i1 = this.s;
    if (i1 == 0) {
      return 0L;
    }
    return this.t / i1;
  }
  
  private boolean v()
  {
    return this.u;
  }
  
  private void w()
  {
    this.e.reset();
    this.e.setLoopback(this.k);
    this.e.updatePlayerVideoView(this.h);
    this.e.setOutputMute(this.l);
  }
  
  private void x()
  {
    this.D = true;
    if (u() == 0L)
    {
      this.u = true;
    }
    else
    {
      long l1;
      if (u() == 0L) {
        l1 = this.r;
      } else {
        l1 = u();
      }
      n = l1;
    }
    QLog.d("FSPlayer", 1, String.format("DownloadComplete  DownLoadSpeed:%d kb/s", new Object[] { Long.valueOf(u()) }));
  }
  
  private boolean y()
  {
    FSPlayerCallback localFSPlayerCallback = this.i;
    if ((localFSPlayerCallback != null) && (localFSPlayerCallback.getReportData() != null)) {
      return FSProtoUtils.a(localFSPlayerCallback.getReportData());
    }
    QLog.w("FSPlayer", 1, "isQUIC() false? invalid mPlayerCallback");
    return false;
  }
  
  public void a()
  {
    ISuperPlayer localISuperPlayer = this.e;
    if (localISuperPlayer == null)
    {
      QLog.w("FSPlayer", 1, "[start] null mPlayer");
      return;
    }
    if (localISuperPlayer.isPlaying())
    {
      QLog.w("FSPlayer", 1, "[start] mPlayer is playing");
      return;
    }
    if ((m()) && (this.m > 0L))
    {
      this.A += System.currentTimeMillis() - this.m;
      this.m = 0L;
    }
    if (!m())
    {
      this.A = System.currentTimeMillis();
      this.C = this.e.getCurrentPositionMs();
    }
    QLog.d("FSPlayer", 1, "[start] really call");
    this.e.start();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ISuperPlayer localISuperPlayer = this.e;
    if (localISuperPlayer == null)
    {
      QLog.w("FSPlayer", 1, "[onStopTrackingTouch] null mPlayer");
      return;
    }
    paramInt2 = (int)(paramInt1 / (paramInt2 * 1.0F) * (float)localISuperPlayer.getDurationMs());
    long l1 = paramInt2;
    this.C = l1;
    QLog.d("FSPlayer", 1, String.format("seek onStopTrackingTouch seekBar progress:%d, position:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    a(l1);
  }
  
  public void a(long paramLong)
  {
    Object localObject = this.e;
    if (localObject == null)
    {
      QLog.w("FSPlayer", 1, "[seek] null mPlayer");
      return;
    }
    try
    {
      long l2 = ((ISuperPlayer)localObject).getDurationMs();
      long l1 = paramLong;
      if (paramLong > l2)
      {
        l1 = paramLong;
        if (l2 != 0L)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("seek over position=");
          ((StringBuilder)localObject).append(paramLong);
          ((StringBuilder)localObject).append("duration=");
          ((StringBuilder)localObject).append(l2);
          QLog.d("FSPlayer", 1, ((StringBuilder)localObject).toString());
          l1 = l2;
        }
      }
      paramLong = l1;
      if (l1 < 0L)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("seek invalid position=");
        ((StringBuilder)localObject).append(l1);
        ((StringBuilder)localObject).append("duration=");
        ((StringBuilder)localObject).append(this.e.getDurationMs());
        QLog.d("FSPlayer", 1, ((StringBuilder)localObject).toString());
        paramLong = 0L;
      }
      this.e.seekTo((int)paramLong, 3);
      this.v = true;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("seek position=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("duration=");
      ((StringBuilder)localObject).append(this.e.getDurationMs());
      QLog.d("FSPlayer", 1, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("FSPlayer", 1, "[seek]", localException);
    }
  }
  
  @UiThread
  public void a(@Nullable FSPlayerCallback paramFSPlayerCallback, @Nullable Surface paramSurface)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.i = paramFSPlayerCallback;
      if (!QQVideoPlaySDKManager.isSDKReady()) {
        try
        {
          FSTransUtils.a(new FSPlayer.1(this, paramSurface));
          return;
        }
        catch (RuntimeException paramFSPlayerCallback)
        {
          QLog.e("FSPlayer", 1, paramFSPlayerCallback.getMessage());
          paramFSPlayerCallback.printStackTrace();
          return;
        }
      }
      a(paramSurface);
      if (paramFSPlayerCallback != null) {
        paramFSPlayerCallback.a();
      }
      return;
    }
    throw new RuntimeException("FSPlayer must initialized in Main Thread");
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    s();
    FSVideoReporter.b();
    this.d = FSVideoReporter.c();
    this.j = FSVideoUtils.a(paramString1, paramString2);
    a(paramString1, paramString2);
    a(paramString2);
    if ((this.e != null) && (this.j != null))
    {
      w();
      paramString1 = SuperPlayerOption.obtain();
      paramString1.accurateSeekOnOpen = true;
      StringBuilder localStringBuilder;
      if (y())
      {
        paramString1.superPlayerDownOption.quicEnableMode = 2;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setVideoPath us QUIC: true | ");
        localStringBuilder.append(paramString2);
        QLog.d("FSPlayer", 1, localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setVideoPath us QUIC: false | ");
        localStringBuilder.append(paramString2);
        QLog.d("FSPlayer", 1, localStringBuilder.toString());
      }
      this.e.openMediaPlayer(FSTransUtils.f(), this.j, paramInt, paramString1);
      this.z = System.currentTimeMillis();
      if (this.f) {
        a("video_start_play", null);
      }
      a("video_resolution", null);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void b()
  {
    if (this.e == null)
    {
      QLog.w("FSPlayer", 1, "[pause] null mPlayer");
      return;
    }
    QLog.d("FSPlayer", 1, "[pause] really call");
    this.e.pause();
    a(this.C, this.e.getCurrentPositionMs());
    this.m = System.currentTimeMillis();
  }
  
  public void b(boolean paramBoolean)
  {
    this.k = paramBoolean;
    ISuperPlayer localISuperPlayer = this.e;
    if (localISuperPlayer != null) {
      localISuperPlayer.setLoopback(paramBoolean);
    }
  }
  
  public void c()
  {
    if (this.f) {
      t();
    }
    if (this.e != null)
    {
      QLog.d("FSPlayer", 1, "[stop] really call");
      this.e.stop();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.l = paramBoolean;
    ISuperPlayer localISuperPlayer = this.e;
    if (localISuperPlayer != null) {
      localISuperPlayer.setOutputMute(paramBoolean);
    }
  }
  
  public void d()
  {
    Object localObject = this.e;
    if (localObject != null) {
      ((ISuperPlayer)localObject).stop();
    }
    localObject = this.j;
    if (localObject == null)
    {
      QLog.w("FSPlayer", 1, "[replay] no replay data");
      return;
    }
    a(((SuperPlayerVideoInfo)localObject).getVid(), this.j.getPlayUrl(), 0);
  }
  
  public long e()
  {
    ISuperPlayer localISuperPlayer = this.e;
    if (localISuperPlayer == null)
    {
      QLog.w("FSPlayer", 1, "[getCurrentPositionMs] null mPlayer");
      return -1L;
    }
    return localISuperPlayer.getCurrentPositionMs();
  }
  
  public void f()
  {
    if (this.f) {
      t();
    }
    RFThreadManager.execute(new FSPlayer.3(this));
  }
  
  public void g()
  {
    if (this.e == null)
    {
      QLog.w("FSPlayer", 1, "[onStartTrackingTouch] null mPlayer");
      return;
    }
    this.B = System.currentTimeMillis();
    a(this.C, this.e.getCurrentPositionMs());
  }
  
  public boolean h()
  {
    return this.e != null;
  }
  
  public ISuperPlayer i()
  {
    return this.e;
  }
  
  public long j()
  {
    return System.currentTimeMillis() - this.A;
  }
  
  public View k()
  {
    ISPlayerVideoView localISPlayerVideoView = this.h;
    if ((localISPlayerVideoView instanceof View)) {
      return (View)localISPlayerVideoView;
    }
    return new View(FSTransUtils.f());
  }
  
  public boolean l()
  {
    ISuperPlayer localISuperPlayer = this.e;
    if (localISuperPlayer == null) {
      return false;
    }
    return localISuperPlayer.isOutputMute();
  }
  
  public boolean m()
  {
    ISuperPlayer localISuperPlayer = this.e;
    if (localISuperPlayer != null) {
      return localISuperPlayer.isPausing();
    }
    return false;
  }
  
  public boolean n()
  {
    ISuperPlayer localISuperPlayer = this.e;
    if (localISuperPlayer != null) {
      return localISuperPlayer.isPlaying();
    }
    return false;
  }
  
  public long o()
  {
    long l1 = 0L;
    try
    {
      Iterator localIterator = this.H.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        long l2 = ((Long)localPair.second).longValue();
        long l3 = ((Long)localPair.first).longValue();
        l1 += l2 - l3;
      }
      return l1;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    if (this.i != null) {
      this.i.b(paramISuperPlayer);
    }
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    paramString = String.format("module:%d, errorType:%d, errorCode:%d, extraInfo:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    QLog.e("FSPlayer", 1, paramString);
    if (FSTransUtils.d()) {
      RFThreadManager.getUIHandler().post(new FSPlayer.5(this, paramString));
    }
    if (this.i != null) {
      this.i.a(paramInt3, paramInt1, 0L, 0L);
    }
    if ((!String.valueOf(paramInt3).startsWith("140")) && (!String.valueOf(paramInt3).startsWith("160")))
    {
      if (this.f)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(QCircleReportHelper.newEntry("ret_code", String.valueOf(paramInt3)));
        paramISuperPlayer = paramString;
        if (!TextUtils.isEmpty(this.F))
        {
          localArrayList.add(QCircleReportHelper.newEntry("server_ip", this.F));
          paramISuperPlayer = new StringBuilder();
          paramISuperPlayer.append(paramString);
          paramISuperPlayer.append(",cdnIp:");
          paramISuperPlayer.append(this.F);
          paramISuperPlayer = paramISuperPlayer.toString();
        }
        paramString = paramISuperPlayer;
        if (!TextUtils.isEmpty(this.G))
        {
          paramString = new StringBuilder();
          paramString.append(paramISuperPlayer);
          paramString.append(",ip:");
          paramString.append(this.G);
          paramString = paramString.toString();
        }
        localArrayList.add(QCircleReportHelper.newEntry("attach_info", paramString));
        a("video_play_ret", localArrayList);
        return false;
      }
    }
    else {
      this.c = String.valueOf(paramInt3);
    }
    return false;
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    int i1 = hashCode();
    String str2 = FSBaseVideoUtils.a(paramInt);
    String str1 = "";
    if (paramObject == null) {
      paramISuperPlayer = "";
    } else {
      paramISuperPlayer = paramObject.toString();
    }
    SuperPlayerVideoInfo localSuperPlayerVideoInfo = this.j;
    if (localSuperPlayerVideoInfo != null) {
      str1 = localSuperPlayerVideoInfo.getPlayUrl();
    }
    QLog.i("FSPlayer", 1, String.format("onInfo: hashCode:%d, what:%s, extra:%s, url:%s", new Object[] { Integer.valueOf(i1), str2, paramISuperPlayer, str1 }));
    if (paramInt != 105)
    {
      if (paramInt != 201)
      {
        if (paramInt != 204)
        {
          if (paramInt != 207)
          {
            if (paramInt != 250)
            {
              if (paramInt != 107)
              {
                if (paramInt != 108)
                {
                  if (paramInt != 112)
                  {
                    if (paramInt != 113) {
                      return false;
                    }
                    if (!this.v)
                    {
                      this.b = true;
                      this.y += System.currentTimeMillis() - this.w;
                      if ((this.i != null) && (this.j != null)) {
                        this.i.a(this.j);
                      }
                      QLog.i("FSPlayer", 1, String.format("PLAYER_INFO_BUFFERING_END mSecondBufferCount:%d, mSecondBufferTime:%d", new Object[] { Integer.valueOf(this.x), Long.valueOf(this.y) }));
                      return false;
                    }
                  }
                  else
                  {
                    this.w = System.currentTimeMillis();
                    if (!this.v)
                    {
                      this.b = false;
                      this.x += 1;
                      QLog.i("FSPlayer", 1, String.format("PLAYER_INFO_BUFFERING_START mSecondBufferCount:%d, mSecondBufferTime:%d", new Object[] { Integer.valueOf(this.x), Long.valueOf(this.y) }));
                      return false;
                    }
                  }
                }
                else
                {
                  a(this.C, this.e.getDurationMs());
                  return false;
                }
              }
              else
              {
                this.C = 0L;
                return false;
              }
            }
            else if ((paramObject instanceof String))
            {
              b((String)paramObject);
              return false;
            }
          }
          else if ((paramObject instanceof TPPlayerMsg.TPDownLoadProgressInfo))
          {
            a((TPPlayerMsg.TPDownLoadProgressInfo)paramObject);
            return false;
          }
        }
        else if ((paramObject instanceof TPPlayerMsg.TPCDNURLInfo))
        {
          paramISuperPlayer = (TPPlayerMsg.TPCDNURLInfo)paramObject;
          a(paramISuperPlayer);
          QLog.i("FSPlayer", 1, String.format("hashCode:%d,TPPlayerMsg.TPCDNURLInfo:cdnIp:%s, errStr:%s, ip:%s, url:%s", new Object[] { Integer.valueOf(hashCode()), paramISuperPlayer.cdnIp, paramISuperPlayer.errorStr, paramISuperPlayer.uIp, paramISuperPlayer.url }));
          return false;
        }
      }
      else
      {
        x();
        return false;
      }
    }
    else {
      RFThreadManager.getUIHandler().post(new FSPlayer.4(this));
    }
    return false;
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    this.v = false;
    if (this.B > 0L)
    {
      this.A += System.currentTimeMillis() - this.B;
      this.B = 0L;
    }
    if (this.i != null) {
      this.i.c();
    }
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    Object localObject = this.h;
    if (localObject != null) {
      ((ISPlayerVideoView)localObject).setXYaxis(0);
    }
    if (this.f)
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(QCircleReportHelper.newEntry("time_cost", String.valueOf((float)(System.currentTimeMillis() - this.z) / 1000.0F)));
      a("video_first_buffer_time_consuming", (List)localObject);
    }
    if (this.i != null) {
      this.i.a(paramISuperPlayer);
    }
  }
  
  public long p()
  {
    return this.d;
  }
  
  protected void q()
  {
    if (this.i == null)
    {
      QLog.w("FSPlayer", 1, "[reportVideoBufferPercent] invalid mPlayerCallback");
      return;
    }
    Object localObject = this.i.getReportData();
    if ((localObject instanceof FeedCloudMeta.StFeed))
    {
      localObject = (FeedCloudMeta.StFeed)localObject;
      double d2 = 0.0D;
      long l2 = this.q;
      long l1 = l2;
      if (l2 == 0L) {
        l1 = ((FeedCloudMeta.StFeed)localObject).video.fileSize.get();
      }
      ArrayList localArrayList = new ArrayList();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("videoDuration");
      localStringBuilder.append("=");
      localStringBuilder.append(((FeedCloudMeta.StFeed)localObject).video.duration.get());
      localStringBuilder.append("|");
      localStringBuilder.append("fileSize");
      localStringBuilder.append("=");
      localStringBuilder.append(l1);
      if (this.D) {
        this.E = l1;
      }
      l2 = this.E;
      double d1 = d2;
      if (l2 > 0L)
      {
        d1 = d2;
        if (l1 > 0L)
        {
          d1 = l2;
          d2 = l1;
          Double.isNaN(d1);
          Double.isNaN(d2);
          d1 = Math.min(100.0D, d1 / d2 * 100.0D);
          localArrayList.add(QCircleReportHelper.newEntry("rate", String.valueOf(d1)));
          localStringBuilder.append("|");
          localStringBuilder.append("cacheSize");
          localStringBuilder.append("=");
          localStringBuilder.append(this.E);
          localStringBuilder.append("|");
          localStringBuilder.append("bufferRate");
          localStringBuilder.append("=");
          localStringBuilder.append(d1);
        }
      }
      localArrayList.add(QCircleReportHelper.newEntry("attach_info", localStringBuilder.toString()));
      a("video_buffer_percent", localArrayList);
      QLog.d("FSPlayer", 1, new Object[] { "reportVideoBufferPercent localCacheSize:", Long.valueOf(this.E), ",FileSize:", Long.valueOf(l1), ",rate:", Double.valueOf(d1) });
    }
  }
  
  public void r()
  {
    try
    {
      if (this.H != null) {
        this.H.clear();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.player.FSPlayer
 * JD-Core Version:    0.7.0.1
 */