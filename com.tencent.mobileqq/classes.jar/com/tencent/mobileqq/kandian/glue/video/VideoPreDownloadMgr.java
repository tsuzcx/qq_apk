package com.tencent.mobileqq.kandian.glue.video;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.video.player.config.QuicConfigHelper;
import com.tencent.mobileqq.kandian.base.video.player.config.QuicConfigHelper.Companion;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.IPlayerFactory;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.IPlayerPreloader;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper.Companion;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerVideoInfo;
import com.tencent.mobileqq.kandian.base.video.plugin.OnVideoPluginInstallListener;
import com.tencent.mobileqq.kandian.base.video.plugin.VideoPluginInstall;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoPreDownloadMgr;
import com.tencent.mobileqq.kandian.glue.report.RIJStatisticCollectorReport;
import com.tencent.mobileqq.kandian.glue.video.report.VideoPreloadReportData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VideoPreDownloadMgr
  implements OnVideoPluginInstallListener, IVideoPreDownloadMgr
{
  private static String c = "Q.readinjoy.video.VideoPreDownloadMgr";
  private static Set<String> l = new HashSet();
  public Context a;
  public VideoPreloadReportData b;
  private IPlayerPreloader d;
  private VideoPluginInstall e;
  private VideoPreDownloadMgr.PreDownloadController f;
  private String g = null;
  private PlayerVideoInfo h = null;
  private Set<String> i = null;
  private Set<String> j = null;
  private List<VideoPreDownloadMgr.VideoPreDownloadParam> k = null;
  
  public VideoPreDownloadMgr() {}
  
  public VideoPreDownloadMgr(Context paramContext)
  {
    this();
    a(paramContext);
  }
  
  private PlayerVideoInfo a(String paramString1, String paramString2, int paramInt)
  {
    if (paramString1 == null) {
      return new PlayerVideoInfo(1, paramString2);
    }
    if (1 == paramInt) {
      paramInt = 104;
    } else {
      paramInt = 101;
    }
    return new PlayerVideoInfo(paramInt, paramString2, new String[] { VideoFeedsHelper.c(paramString1) });
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = c;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("innerDoPreDownload() 正式开始预下载 vid=");
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append(", url=");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(", urlType=");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(", duration=");
      ((StringBuilder)localObject2).append(paramInt2);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = this.d;
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(c, 2, "innerDoPreDownload() start preload ERROR cacheMgr == null!");
      }
      return;
    }
    Object localObject1 = paramString2;
    if (paramString1 != null) {
      if (paramString2 != null)
      {
        localObject1 = paramString2;
        if (!paramString1.equals(paramString2)) {}
      }
      else
      {
        localObject1 = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).generateVid(paramString1);
      }
    }
    paramString2 = a(paramString1, (String)localObject1, paramInt1);
    this.h = paramString2;
    localObject1 = SuperPlayerDownOption.obtain();
    ((SuperPlayerDownOption)localObject1).quicEnableMode = QuicConfigHelper.a.a(this.a, paramString1);
    ((SuperPlayerDownOption)localObject1).enableQuicPlaintext = QuicConfigHelper.a.a();
    ((SuperPlayerDownOption)localObject1).enableQuicConnectionMigration = QuicConfigHelper.a.b();
    ((SuperPlayerDownOption)localObject1).quicCongestionType = QuicConfigHelper.a.c();
    paramString1 = Aladdin.getConfig(392);
    boolean bool2 = false;
    if (paramString1.getIntegerFromString("enable_p2p", 0) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((SuperPlayerDownOption)localObject1).enableP2P = bool1;
    boolean bool1 = bool2;
    if (Aladdin.getConfig(392).getIntegerFromString("enable_pcdn", 0) == 1) {
      bool1 = true;
    }
    ((SuperPlayerDownOption)localObject1).enablePcdn = bool1;
    ((IPlayerPreloader)localObject2).a(paramString2, paramInt2 * 1000L, 2000L, (SuperPlayerDownOption)localObject1);
    if (paramBoolean)
    {
      paramString1 = this.b;
      if (paramString1 != null) {
        paramString1.j += 1;
      }
    }
  }
  
  private void a(List<VideoPreDownloadMgr.VideoPreDownloadParam> paramList)
  {
    ThreadManager.post(new VideoPreDownloadMgr.PreDownloadSerialTask(this, paramList), 5, null, true);
  }
  
  private void b(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    a(paramString1, paramString2, paramInt1, paramInt2, true);
  }
  
  private void g()
  {
    IPlayerPreloader localIPlayerPreloader = this.d;
    if (localIPlayerPreloader == null) {
      return;
    }
    this.i = new HashSet();
    this.k = new ArrayList();
    this.j = new HashSet();
    if (QLog.isColorLevel()) {
      QLog.i(c, 2, "initSerialPreDownload() 设置mCacheMgr回调");
    }
    localIPlayerPreloader.a(new VideoPreDownloadMgr.2(this));
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.i(c, 2, "releaseSerialPredownload()");
    }
    IPlayerPreloader localIPlayerPreloader = this.d;
    if (localIPlayerPreloader != null)
    {
      localIPlayerPreloader.a(null);
      this.d.b();
    }
  }
  
  private void i()
  {
    Object localObject2 = this.k;
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      Object localObject1;
      try
      {
        localObject1 = (VideoPreDownloadMgr.VideoPreDownloadParam)((List)localObject2).get(0);
        try
        {
          ((List)localObject2).remove(0);
          localObject2 = localObject1;
        }
        catch (Exception localException1) {}
        localObject2 = localObject1;
      }
      catch (Exception localException2)
      {
        localObject1 = null;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = c;
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("preDownloadVideoNotAlreadyList.remove(0) ERROR = ");
        localStringBuilder2.append(localException2.getMessage());
        QLog.e((String)localObject2, 2, localStringBuilder2.toString());
        localObject2 = localObject1;
      }
      if ((localObject2 != null) && (!TextUtils.isEmpty(((VideoPreDownloadMgr.VideoPreDownloadParam)localObject2).a)))
      {
        this.g = ((VideoPreDownloadMgr.VideoPreDownloadParam)localObject2).a;
        int m = ((VideoPreDownloadMgr.VideoPreDownloadParam)localObject2).d;
        if (2 == ((VideoPreDownloadMgr.VideoPreDownloadParam)localObject2).c)
        {
          ThirdVideoManager.a().a(((VideoPreDownloadMgr.VideoPreDownloadParam)localObject2).a, new VideoPreDownloadMgr.3(this, m));
          return;
        }
        StringBuilder localStringBuilder1;
        if (5 == ((VideoPreDownloadMgr.VideoPreDownloadParam)localObject2).c)
        {
          if (a(((VideoPreDownloadMgr.VideoPreDownloadParam)localObject2).a, ((VideoPreDownloadMgr.VideoPreDownloadParam)localObject2).a))
          {
            if (QLog.isColorLevel())
            {
              localObject1 = c;
              localStringBuilder1 = new StringBuilder();
              localStringBuilder1.append("innerDoPreDownload() 缓冲已存在，跳过, vid=");
              localStringBuilder1.append(((VideoPreDownloadMgr.VideoPreDownloadParam)localObject2).a);
              QLog.i((String)localObject1, 2, localStringBuilder1.toString());
            }
            this.g = null;
            i();
            return;
          }
          b(((VideoPreDownloadMgr.VideoPreDownloadParam)localObject2).a, ((VideoPreDownloadMgr.VideoPreDownloadParam)localObject2).a, 0, m);
          return;
        }
        if (a(null, ((VideoPreDownloadMgr.VideoPreDownloadParam)localObject2).a))
        {
          if (QLog.isColorLevel())
          {
            localObject1 = c;
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("innerDoPreDownload() 缓冲已存在，跳过, vid=");
            localStringBuilder1.append(((VideoPreDownloadMgr.VideoPreDownloadParam)localObject2).a);
            QLog.i((String)localObject1, 2, localStringBuilder1.toString());
          }
          this.g = null;
          i();
          return;
        }
        b(null, ((VideoPreDownloadMgr.VideoPreDownloadParam)localObject2).a, 0, m);
        return;
      }
      i();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(c, 2, "已完成预下载，队列为空");
    }
  }
  
  public void a()
  {
    b(true);
  }
  
  public void a(int paramInt)
  {
    a(paramInt, true);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.f;
    if (localObject == null) {
      return;
    }
    if (this.d != null)
    {
      localObject = ((VideoPreDownloadMgr.PreDownloadController)localObject).a(paramInt, paramBoolean);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        if (QLog.isColorLevel())
        {
          String str = c;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("requestPreDownload() 外部触发预下载逻辑 size = ");
          localStringBuilder.append(((List)localObject).size());
          QLog.i(str, 2, localStringBuilder.toString());
        }
        a((List)localObject);
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.i(c, 2, "requestPreDownload() is off or mCacheMgr is null, return;");
    }
  }
  
  public void a(Context paramContext)
  {
    this.a = paramContext;
    this.e = new VideoPluginInstall();
    this.e.a(this);
    if (!this.e.b())
    {
      this.e.a();
      return;
    }
    c();
    g();
  }
  
  public void a(VideoPreDownloadMgr.PreDownloadController paramPreDownloadController)
  {
    this.f = paramPreDownloadController;
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    a(paramString1, paramString2, paramInt1, paramInt2, false);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    VideoPreloadReportData localVideoPreloadReportData = this.b;
    if (localVideoPreloadReportData == null) {
      return;
    }
    if (paramBoolean)
    {
      localVideoPreloadReportData.h += 1;
      Set localSet = this.i;
      if ((localSet != null) && (localSet.contains(paramString)))
      {
        localVideoPreloadReportData.k += 1;
        localSet = this.j;
        if ((localSet != null) && (!localSet.contains(paramString)))
        {
          this.j.add(paramString);
          localVideoPreloadReportData.l += 1;
        }
      }
      if (l.contains(paramString)) {
        localVideoPreloadReportData.m += 1;
      }
    }
    else
    {
      localVideoPreloadReportData.i += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    c();
    g();
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    Object localObject = this.d;
    if (localObject == null) {
      return false;
    }
    String str = paramString2;
    if (paramString1 != null) {
      if (paramString2 != null)
      {
        str = paramString2;
        if (!paramString1.equals(paramString2)) {}
      }
      else
      {
        str = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).generateVid(paramString1);
      }
    }
    paramString1 = a(paramString1, str, 101);
    int m;
    try
    {
      m = ((IPlayerPreloader)localObject).a(paramString1);
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel())
      {
        paramString2 = c;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(" checkIsVideoCached() cacheMgr.isVideoCached Exception = ");
        ((StringBuilder)localObject).append(paramString1.getMessage());
        QLog.d(paramString2, 2, ((StringBuilder)localObject).toString());
      }
      m = 0;
    }
    if ((m != 2) && (m != 1))
    {
      if (QLog.isColorLevel())
      {
        paramString1 = c;
        paramString2 = new StringBuilder();
        paramString2.append(str);
        paramString2.append(" checkIsVideoCached() return FALSE");
        QLog.d(paramString1, 2, paramString2.toString());
      }
      return false;
    }
    if (QLog.isColorLevel())
    {
      paramString1 = c;
      paramString2 = new StringBuilder();
      paramString2.append(str);
      paramString2.append(" checkIsVideoCached(), cacheStatus = ");
      paramString2.append(m);
      paramString2.append(", return TRUE");
      QLog.d(paramString1, 2, paramString2.toString());
    }
    return true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, "resume()");
    }
    c();
    g();
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, "destroy()");
    }
    ThreadManager.post(new VideoPreDownloadMgr.1(this), 5, null, true);
    if ((paramBoolean) && (this.b != null))
    {
      RIJStatisticCollectorReport.b(BaseApplication.getContext(), RIJQQAppInterfaceUtil.d(), true, this.b.a());
      this.b = null;
    }
    VideoPluginInstall localVideoPluginInstall = this.e;
    if (localVideoPluginInstall != null)
    {
      localVideoPluginInstall.c();
      this.e = null;
    }
  }
  
  public void c()
  {
    if (this.d == null) {
      this.d = PlayerHelper.a.b().a();
    }
    if (QLog.isColorLevel())
    {
      localObject = c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VideoPreDownloadController initCacheMgr mCacheMgr=");
      localStringBuilder.append(this.d);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = this.d;
  }
  
  public void d()
  {
    IPlayerPreloader localIPlayerPreloader = this.d;
    if ((localIPlayerPreloader != null) && (this.h != null)) {
      localIPlayerPreloader.a();
    }
    this.g = null;
    this.h = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr
 * JD-Core Version:    0.7.0.1
 */