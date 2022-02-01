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
  private static String jdField_a_of_type_JavaLangString = "Q.readinjoy.video.VideoPreDownloadMgr";
  private static Set<String> c = new HashSet();
  public Context a;
  private IPlayerPreloader jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerWrapperIPlayerPreloader;
  private PlayerVideoInfo jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerWrapperPlayerVideoInfo = null;
  private VideoPluginInstall jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall;
  private VideoPreDownloadMgr.PreDownloadController jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr$PreDownloadController;
  public VideoPreloadReportData a;
  private List<VideoPreDownloadMgr.VideoPreDownloadParam> jdField_a_of_type_JavaUtilList = null;
  private Set<String> jdField_a_of_type_JavaUtilSet = null;
  private String jdField_b_of_type_JavaLangString = null;
  private Set<String> jdField_b_of_type_JavaUtilSet = null;
  
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
    return new PlayerVideoInfo(paramInt, paramString2, new String[] { paramString1 });
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
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
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerWrapperIPlayerPreloader;
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "innerDoPreDownload() start preload ERROR cacheMgr == null!");
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
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerWrapperPlayerVideoInfo = paramString2;
    localObject1 = SuperPlayerDownOption.obtain();
    ((SuperPlayerDownOption)localObject1).quicEnableMode = QuicConfigHelper.a.a(this.jdField_a_of_type_AndroidContentContext, paramString1);
    ((SuperPlayerDownOption)localObject1).enableQuicPlaintext = QuicConfigHelper.a.a();
    ((SuperPlayerDownOption)localObject1).enableQuicConnectionMigration = QuicConfigHelper.a.b();
    ((SuperPlayerDownOption)localObject1).quicCongestionType = QuicConfigHelper.a.a();
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
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoReportVideoPreloadReportData;
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
  
  private void e()
  {
    IPlayerPreloader localIPlayerPreloader = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerWrapperIPlayerPreloader;
    if (localIPlayerPreloader == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "initSerialPreDownload() 设置mCacheMgr回调");
    }
    localIPlayerPreloader.a(new VideoPreDownloadMgr.2(this));
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "releaseSerialPredownload()");
    }
    IPlayerPreloader localIPlayerPreloader = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerWrapperIPlayerPreloader;
    if (localIPlayerPreloader != null)
    {
      localIPlayerPreloader.a(null);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerWrapperIPlayerPreloader.b();
    }
  }
  
  private void g()
  {
    Object localObject2 = this.jdField_a_of_type_JavaUtilList;
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
        localObject2 = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("preDownloadVideoNotAlreadyList.remove(0) ERROR = ");
        localStringBuilder2.append(localException2.getMessage());
        QLog.e((String)localObject2, 2, localStringBuilder2.toString());
        localObject2 = localObject1;
      }
      if ((localObject2 != null) && (!TextUtils.isEmpty(((VideoPreDownloadMgr.VideoPreDownloadParam)localObject2).jdField_a_of_type_JavaLangString)))
      {
        this.jdField_b_of_type_JavaLangString = ((VideoPreDownloadMgr.VideoPreDownloadParam)localObject2).jdField_a_of_type_JavaLangString;
        int i = ((VideoPreDownloadMgr.VideoPreDownloadParam)localObject2).b;
        if (2 == ((VideoPreDownloadMgr.VideoPreDownloadParam)localObject2).jdField_a_of_type_Int)
        {
          ThirdVideoManager.a().a(((VideoPreDownloadMgr.VideoPreDownloadParam)localObject2).jdField_a_of_type_JavaLangString, new VideoPreDownloadMgr.3(this, i));
          return;
        }
        StringBuilder localStringBuilder1;
        if (5 == ((VideoPreDownloadMgr.VideoPreDownloadParam)localObject2).jdField_a_of_type_Int)
        {
          if (a(((VideoPreDownloadMgr.VideoPreDownloadParam)localObject2).jdField_a_of_type_JavaLangString, ((VideoPreDownloadMgr.VideoPreDownloadParam)localObject2).jdField_a_of_type_JavaLangString))
          {
            if (QLog.isColorLevel())
            {
              localObject1 = jdField_a_of_type_JavaLangString;
              localStringBuilder1 = new StringBuilder();
              localStringBuilder1.append("innerDoPreDownload() 缓冲已存在，跳过, vid=");
              localStringBuilder1.append(((VideoPreDownloadMgr.VideoPreDownloadParam)localObject2).jdField_a_of_type_JavaLangString);
              QLog.i((String)localObject1, 2, localStringBuilder1.toString());
            }
            this.jdField_b_of_type_JavaLangString = null;
            g();
            return;
          }
          b(((VideoPreDownloadMgr.VideoPreDownloadParam)localObject2).jdField_a_of_type_JavaLangString, ((VideoPreDownloadMgr.VideoPreDownloadParam)localObject2).jdField_a_of_type_JavaLangString, 0, i);
          return;
        }
        if (a(null, ((VideoPreDownloadMgr.VideoPreDownloadParam)localObject2).jdField_a_of_type_JavaLangString))
        {
          if (QLog.isColorLevel())
          {
            localObject1 = jdField_a_of_type_JavaLangString;
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("innerDoPreDownload() 缓冲已存在，跳过, vid=");
            localStringBuilder1.append(((VideoPreDownloadMgr.VideoPreDownloadParam)localObject2).jdField_a_of_type_JavaLangString);
            QLog.i((String)localObject1, 2, localStringBuilder1.toString());
          }
          this.jdField_b_of_type_JavaLangString = null;
          g();
          return;
        }
        b(null, ((VideoPreDownloadMgr.VideoPreDownloadParam)localObject2).jdField_a_of_type_JavaLangString, 0, i);
        return;
      }
      g();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "已完成预下载，队列为空");
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr$PreDownloadController;
    if (localObject == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerWrapperIPlayerPreloader != null)
    {
      localObject = ((VideoPreDownloadMgr.PreDownloadController)localObject).a(paramInt, paramBoolean);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        if (QLog.isColorLevel())
        {
          String str = jdField_a_of_type_JavaLangString;
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
      QLog.i(jdField_a_of_type_JavaLangString, 2, "requestPreDownload() is off or mCacheMgr is null, return;");
    }
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall = new VideoPluginInstall();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall.a(this);
    if (!this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall.a();
      return;
    }
    c();
    e();
  }
  
  public void a(VideoPreDownloadMgr.PreDownloadController paramPreDownloadController)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr$PreDownloadController = paramPreDownloadController;
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    a(paramString1, paramString2, paramInt1, paramInt2, false);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    VideoPreloadReportData localVideoPreloadReportData = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoReportVideoPreloadReportData;
    if (localVideoPreloadReportData == null) {
      return;
    }
    if (paramBoolean)
    {
      localVideoPreloadReportData.h += 1;
      Set localSet = this.jdField_a_of_type_JavaUtilSet;
      if ((localSet != null) && (localSet.contains(paramString)))
      {
        localVideoPreloadReportData.k += 1;
        localSet = this.jdField_b_of_type_JavaUtilSet;
        if ((localSet != null) && (!localSet.contains(paramString)))
        {
          this.jdField_b_of_type_JavaUtilSet.add(paramString);
          localVideoPreloadReportData.l += 1;
        }
      }
      if (c.contains(paramString)) {
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
    e();
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerWrapperIPlayerPreloader;
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
    int i;
    try
    {
      i = ((IPlayerPreloader)localObject).a(paramString1);
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel())
      {
        paramString2 = jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(" checkIsVideoCached() cacheMgr.isVideoCached Exception = ");
        ((StringBuilder)localObject).append(paramString1.getMessage());
        QLog.d(paramString2, 2, ((StringBuilder)localObject).toString());
      }
      i = 0;
    }
    if ((i != 2) && (i != 1))
    {
      if (QLog.isColorLevel())
      {
        paramString1 = jdField_a_of_type_JavaLangString;
        paramString2 = new StringBuilder();
        paramString2.append(str);
        paramString2.append(" checkIsVideoCached() return FALSE");
        QLog.d(paramString1, 2, paramString2.toString());
      }
      return false;
    }
    if (QLog.isColorLevel())
    {
      paramString1 = jdField_a_of_type_JavaLangString;
      paramString2 = new StringBuilder();
      paramString2.append(str);
      paramString2.append(" checkIsVideoCached(), cacheStatus = ");
      paramString2.append(i);
      paramString2.append(", return TRUE");
      QLog.d(paramString1, 2, paramString2.toString());
    }
    return true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "resume()");
    }
    c();
    e();
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "destroy()");
    }
    ThreadManager.post(new VideoPreDownloadMgr.1(this), 5, null, true);
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoReportVideoPreloadReportData != null))
    {
      RIJStatisticCollectorReport.b(BaseApplication.getContext(), RIJQQAppInterfaceUtil.a(), true, this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoReportVideoPreloadReportData.a());
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoReportVideoPreloadReportData = null;
    }
    VideoPluginInstall localVideoPluginInstall = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall;
    if (localVideoPluginInstall != null)
    {
      localVideoPluginInstall.b();
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall = null;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerWrapperIPlayerPreloader == null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerWrapperIPlayerPreloader = PlayerHelper.a.a().a();
    }
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VideoPreDownloadController initCacheMgr mCacheMgr=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerWrapperIPlayerPreloader);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerWrapperIPlayerPreloader;
  }
  
  public void d()
  {
    IPlayerPreloader localIPlayerPreloader = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerWrapperIPlayerPreloader;
    if ((localIPlayerPreloader != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerWrapperPlayerVideoInfo != null)) {
      localIPlayerPreloader.a();
    }
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerWrapperPlayerVideoInfo = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr
 * JD-Core Version:    0.7.0.1
 */