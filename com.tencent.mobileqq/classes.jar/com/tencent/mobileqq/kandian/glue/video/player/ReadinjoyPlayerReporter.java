package com.tencent.mobileqq.kandian.glue.video.player;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.bandwidth.BandwidthPredictor;
import com.tencent.mobileqq.kandian.base.bandwidth.VideoBufferRangeController;
import com.tencent.mobileqq.kandian.base.video.player.IPlayerReporter;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.data.ReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager;
import com.tencent.mobileqq.kandian.base.video.player.videourl.VideoUrlInfo;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoPreDownloadMgr;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;

public class ReadinjoyPlayerReporter
  extends IPlayerReporter
{
  public ReadInJoyVideoReportData a;
  private int b;
  private IVideoPreDownloadMgr c;
  private ReadinjoyPlayerReporter.ReportDelegate d;
  private Handler e;
  private boolean f;
  private boolean g;
  private boolean h;
  private SparseArray<ReadinjoyPlayerReporter.ReportInfoAction> i = new SparseArray();
  
  public ReadinjoyPlayerReporter(int paramInt, ReadinjoyPlayerReporter.ReportDelegate paramReportDelegate)
  {
    this.b = paramInt;
    this.e = new Handler(Looper.getMainLooper());
    this.a = new ReadInJoyVideoReportData();
    this.g = false;
    this.d = paramReportDelegate;
    b();
  }
  
  private void a(ReadInJoyVideoReportData paramReadInJoyVideoReportData)
  {
    this.h = true;
    ThreadManager.excute(new ReadinjoyPlayerReporter.1(this, paramReadInJoyVideoReportData), 16, null, true);
  }
  
  private void a(String paramString1, String paramString2)
  {
    IVideoPreDownloadMgr localIVideoPreDownloadMgr = this.c;
    if (localIVideoPreDownloadMgr != null)
    {
      this.g = localIVideoPreDownloadMgr.a(paramString2, paramString1);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("视频预下载: url:");
        paramString2.append(paramString1);
        paramString2.append(" ;isPreDownloadHit: ");
        paramString2.append(this.g);
        QLog.d("ReadinjoyPlayerReporter", 2, paramString2.toString());
      }
      this.c.a(paramString1, this.g);
    }
  }
  
  private void b()
  {
    this.i.put(112, new ReadinjoyPlayerReporter.BufferingStartAction(this));
    this.i.put(113, new ReadinjoyPlayerReporter.BufferingEndAction(this));
    this.i.put(208, new ReadinjoyPlayerReporter.ObjectMediaCodecInfoAction(this));
    this.i.put(105, new ReadinjoyPlayerReporter.FirstVideoFrameRenderedAction(this));
    this.i.put(209, new ReadinjoyPlayerReporter.VideoFrameCheckInfoAction(this));
  }
  
  private void b(String paramString)
  {
    this.a = new ReadInJoyVideoReportData();
    ReadInJoyVideoReportData localReadInJoyVideoReportData = this.a;
    localReadInJoyVideoReportData.f = paramString;
    localReadInJoyVideoReportData.t = this.b;
    localReadInJoyVideoReportData.j = true;
    localReadInJoyVideoReportData.W = 0;
    localReadInJoyVideoReportData.X = 0;
    localReadInJoyVideoReportData.Y = 0;
    localReadInJoyVideoReportData.aa = false;
    localReadInJoyVideoReportData.ab = "";
    localReadInJoyVideoReportData.ai = false;
    localReadInJoyVideoReportData.aj = false;
    paramString = this.d;
    if (paramString != null) {
      paramString.a(localReadInJoyVideoReportData);
    }
  }
  
  public void a()
  {
    this.f = true;
    ReadInJoyVideoReportData localReadInJoyVideoReportData = this.a;
    localReadInJoyVideoReportData.j = true;
    localReadInJoyVideoReportData.D = true;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    ReadInJoyVideoReportData localReadInJoyVideoReportData = this.a;
    localReadInJoyVideoReportData.j = false;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(":");
    localStringBuilder.append(paramInt2);
    localReadInJoyVideoReportData.k = localStringBuilder.toString();
    this.a.l = paramString;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    ReadinjoyPlayerReporter.ReportInfoAction localReportInfoAction = (ReadinjoyPlayerReporter.ReportInfoAction)this.i.get(paramInt);
    if (localReportInfoAction != null) {
      localReportInfoAction.a(paramInt, paramObject);
    }
  }
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    this.a.S = paramVideoPlayerWrapper.G();
    this.a.R = paramVideoPlayerWrapper.F();
  }
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt)
  {
    this.a.h = paramVideoPlayerWrapper.d(this.f);
    this.a.F = paramVideoPlayerWrapper.K();
    this.a.E = paramVideoPlayerWrapper.J();
    this.a.G = paramVideoPlayerWrapper.L();
    this.a.H = paramVideoPlayerWrapper.g;
    this.a.M = paramVideoPlayerWrapper.e;
    this.a.L = paramVideoPlayerWrapper.c;
    this.a.N = paramVideoPlayerWrapper.P();
    if ((this.a.h == 0L) && (this.a.o == 0L))
    {
      this.a.o = (SystemClock.uptimeMillis() - this.a.m);
      localReadInJoyVideoReportData = this.a;
      localReadInJoyVideoReportData.q = localReadInJoyVideoReportData.o;
    }
    this.a.an = BandwidthPredictor.from().getCurrentPrediction();
    this.a.ao = VideoBufferRangeController.a().b();
    ReadInJoyVideoReportData localReadInJoyVideoReportData = this.a;
    localReadInJoyVideoReportData.i = paramInt;
    localReadInJoyVideoReportData.at = paramVideoPlayerWrapper.Z();
    paramVideoPlayerWrapper.a(this.a.b());
    a(this.a);
  }
  
  public void a(VideoUrlInfo paramVideoUrlInfo)
  {
    this.a.x = ThirdVideoManager.a().a.longValue();
    this.a.y = paramVideoUrlInfo.k;
    this.a.T = paramVideoUrlInfo.c;
    this.a.U = paramVideoUrlInfo.e;
    this.a.Z = paramVideoUrlInfo.d;
    Object localObject = this.a;
    int j = 0;
    ((ReadInJoyVideoReportData)localObject).aa = false;
    String str = "";
    ((ReadInJoyVideoReportData)localObject).ab = "";
    ((ReadInJoyVideoReportData)localObject).ag = paramVideoUrlInfo.g;
    this.a.aj = (TextUtils.isEmpty(paramVideoUrlInfo.h) ^ true);
    try
    {
      localObject = new URL(paramVideoUrlInfo.a).getHost();
      paramVideoUrlInfo = InnerDns.getInstance().reqDnsForIpList((String)localObject, 1006);
      ReadInJoyVideoReportData localReadInJoyVideoReportData = this.a;
      if (paramVideoUrlInfo != null) {
        j = paramVideoUrlInfo.size();
      }
      localReadInJoyVideoReportData.ae = j;
      localReadInJoyVideoReportData = this.a;
      if (paramVideoUrlInfo == null) {
        paramVideoUrlInfo = str;
      } else {
        paramVideoUrlInfo = paramVideoUrlInfo.toString();
      }
      localReadInJoyVideoReportData.af = paramVideoUrlInfo;
      this.a.ad = ((String)localObject);
      return;
    }
    catch (Exception paramVideoUrlInfo) {}
  }
  
  public void a(IVideoPreDownloadMgr paramIVideoPreDownloadMgr)
  {
    this.c = paramIVideoPreDownloadMgr;
  }
  
  public void a(String paramString)
  {
    this.a.ac = paramString;
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.f = false;
    this.h = false;
    b(paramString1);
    ReadInJoyVideoReportData localReadInJoyVideoReportData = this.a;
    localReadInJoyVideoReportData.V = 0;
    if (!paramBoolean1) {
      localReadInJoyVideoReportData.m = SystemClock.uptimeMillis();
    }
    this.a.n = SystemClock.uptimeMillis();
    localReadInJoyVideoReportData = this.a;
    localReadInJoyVideoReportData.W = 0;
    localReadInJoyVideoReportData.X = 0;
    localReadInJoyVideoReportData.Y = 0;
    localReadInJoyVideoReportData.ai = false;
    localReadInJoyVideoReportData.aj = false;
    localReadInJoyVideoReportData.al = paramBoolean2;
    a(paramString1, paramString2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.m = SystemClock.uptimeMillis();
    ReadInJoyVideoReportData localReadInJoyVideoReportData = this.a;
    int j;
    if (paramBoolean) {
      j = 2;
    } else {
      j = 1;
    }
    localReadInJoyVideoReportData.V = j;
  }
  
  public void b(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if (this.a.o != 0L) {
      return;
    }
    this.a.o = (SystemClock.uptimeMillis() - this.a.m);
    Object localObject = this.a;
    ((ReadInJoyVideoReportData)localObject).q += this.a.o;
    localObject = this.a;
    ((ReadInJoyVideoReportData)localObject).s += 1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doReportOnVideoPrepared: vid=");
      ((StringBuilder)localObject).append(this.a.f);
      ((StringBuilder)localObject).append(", 预加载状态：");
      ((StringBuilder)localObject).append(this.a.V);
      ((StringBuilder)localObject).append(", 预下载命中：");
      ((StringBuilder)localObject).append(this.g);
      ((StringBuilder)localObject).append(", 首帧耗时：");
      ((StringBuilder)localObject).append(this.a.o);
      QLog.d("ReadinjoyPlayerReporter", 2, ((StringBuilder)localObject).toString());
    }
    ThreadManager.excute(new ReadinjoyPlayerReporter.3(this, paramVideoPlayerWrapper), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.player.ReadinjoyPlayerReporter
 * JD-Core Version:    0.7.0.1
 */