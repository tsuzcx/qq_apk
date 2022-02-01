package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.reddot.ColorBandVideoEntranceButton;
import com.tencent.mobileqq.kandian.biz.video.EntranceButtonExposureHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.EntranceDownloadInfo;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr;
import com.tencent.mobileqq.kandian.glue.video.report.RIJVideoReportManager;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.diandian.IEntranceButtonDataSource;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class VideoFeedsFirstVideoRecommendationManager
{
  private static final String a = "VideoFeedsFirstVideoRecommendationManager";
  private VideoInfo b;
  private VideoInfo.EntranceDownloadInfo c;
  private ColorBandVideoEntranceButton d;
  private VideoPlayRecommendHandler e;
  private VideoPlayRecommendObserver f;
  private VideoPreDownloadMgr g;
  private VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstVideoObserver h;
  private String i;
  private boolean j;
  private int k;
  private String l;
  
  public VideoFeedsFirstVideoRecommendationManager(ColorBandVideoEntranceButton paramColorBandVideoEntranceButton, Context paramContext)
  {
    this.d = paramColorBandVideoEntranceButton;
    this.g = new VideoPreDownloadMgr(paramContext.getApplicationContext());
    paramColorBandVideoEntranceButton = RIJQQAppInterfaceUtil.a();
    if (paramColorBandVideoEntranceButton != null)
    {
      this.l = paramColorBandVideoEntranceButton.getAccount();
      this.c = j();
      if (this.c != null)
      {
        QLog.d(a, 1, "setEntranceDataSourceAndRefresh mEntranceDownloadInfo");
        c(this.c);
      }
      else if (ReadInJoyHelper.K() == 2)
      {
        QLog.d(a, 1, "setEntranceDataSourceAndRefresh mRecommendVideo");
        this.b = g();
        c(this.b);
      }
      this.e = ((VideoPlayRecommendHandler)paramColorBandVideoEntranceButton.getBusinessHandler(BusinessHandlerFactory.VIDEOPLAYRECOMMEND_HANDLER));
      this.f = new VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver(this);
      paramColorBandVideoEntranceButton.addObserver(this.f);
      this.h = new VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstVideoObserver(this, null);
      ReadInJoyLogicEngineEventDispatcher.a().a(this.h);
    }
  }
  
  private void a(VideoInfo.EntranceDownloadInfo paramEntranceDownloadInfo)
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetEntranceDownloadInfo downloadInfo=");
      localStringBuilder.append(paramEntranceDownloadInfo);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (b(paramEntranceDownloadInfo))
    {
      if (!VideoFeedsHelper.o())
      {
        if (QLog.isColorLevel()) {
          QLog.e(a, 2, "onGetEntranceDownloadInfo isVideoEntranceJumpAppEnable == false");
        }
        return;
      }
      int m = EntranceButtonExposureHelper.a().c();
      int n = VideoFeedsHelper.p();
      if ((n > 0) && (m >= n))
      {
        if (QLog.isColorLevel())
        {
          paramEntranceDownloadInfo = a;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onGetEntranceDownloadInfo displayCount=");
          ((StringBuilder)localObject).append(m);
          ((StringBuilder)localObject).append(" exceed maxDisplayCount=");
          ((StringBuilder)localObject).append(n);
          QLog.e(paramEntranceDownloadInfo, 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onGetEntranceDownloadInfo displayCount=");
        localStringBuilder.append(m);
        localStringBuilder.append(", maxDisplayCount=");
        localStringBuilder.append(n);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      this.c = paramEntranceDownloadInfo;
      c(paramEntranceDownloadInfo);
      i();
      h();
      this.b = null;
      if (this.k != 3)
      {
        paramEntranceDownloadInfo = this.d;
        if ((paramEntranceDownloadInfo != null) && (paramEntranceDownloadInfo.getVisibility() == 0)) {
          a(this.c);
        }
      }
    }
  }
  
  private void a(VideoInfo paramVideoInfo)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetFirstRecommendVideoInfo videoInfo=");
      localStringBuilder.append(paramVideoInfo);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (paramVideoInfo != null)
    {
      localObject = this.b;
      if ((localObject != null) && (((VideoInfo)localObject).R) && (!paramVideoInfo.R)) {
        return;
      }
      this.b = paramVideoInfo;
      c(paramVideoInfo);
      f();
    }
    if (this.k != 3)
    {
      localObject = this.d;
      if ((localObject != null) && (((ColorBandVideoEntranceButton)localObject).getVisibility() == 0)) {
        a(this.b);
      }
    }
    if (paramVideoInfo != null) {
      localObject = paramVideoInfo.q();
    } else {
      localObject = "videoInfo is null!";
    }
    a(paramVideoInfo, (String)localObject);
  }
  
  private static void a(VideoInfo paramVideoInfo, String paramString)
  {
    if ((paramVideoInfo != null) && (QLog.isColorLevel()))
    {
      QLog.d(a, 2, paramString);
      return;
    }
    a(paramString);
  }
  
  public static void a(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    EntranceButtonExposureHelper.a().a(paramIEntranceButtonDataSource);
    if (paramIEntranceButtonDataSource == null) {
      return;
    }
    for (;;)
    {
      try
      {
        boolean bool = paramIEntranceButtonDataSource instanceof VideoInfo;
        Object localObject = "";
        if (bool)
        {
          VideoInfo localVideoInfo = (VideoInfo)paramIEntranceButtonDataSource;
          JSONObject localJSONObject = RIJTransMergeKanDianReport.d();
          localJSONObject.put("kandian_mode", 3);
          localJSONObject.put("tab_source", 5);
          if (localVideoInfo == null) {
            break label318;
          }
          m = 2;
          localJSONObject.put("reddot", m);
          paramIEntranceButtonDataSource = (IEntranceButtonDataSource)localObject;
          if (localVideoInfo != null) {
            paramIEntranceButtonDataSource = localVideoInfo.l;
          }
          localJSONObject.put("rowkey", paramIEntranceButtonDataSource);
          PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80081C6", "0X80081C6", 0, 0, "", "", "", localJSONObject.toString(), false);
          if (QLog.isColorLevel())
          {
            paramIEntranceButtonDataSource = new StringBuilder();
            paramIEntranceButtonDataSource.append("reportForVideoEntranceRedDotExposure has finished, r5: ");
            paramIEntranceButtonDataSource.append(localJSONObject.toString());
            QLog.d("Q.readinjoy.4tab", 2, paramIEntranceButtonDataSource.toString());
          }
          m = ReadInJoyHelper.K();
          if (m == 1)
          {
            PublicAccountReportUtils.a(null, "", "0X8009A22", "0X8009A22", 0, 0, "", "", "", RIJVideoReportManager.a(localVideoInfo, m), false);
            return;
          }
          if (m == 2) {
            PublicAccountReportUtils.a(null, "", "0X80094FE", "0X80094FE", 0, 0, "", "", "", RIJVideoReportManager.a(localVideoInfo, m), false);
          }
        }
        else if ((paramIEntranceButtonDataSource instanceof VideoInfo.EntranceDownloadInfo))
        {
          paramIEntranceButtonDataSource = (VideoInfo.EntranceDownloadInfo)paramIEntranceButtonDataSource;
          localObject = new VideoR5.Builder("", "", "", "");
          ((VideoR5.Builder)localObject).W(1).b(paramIEntranceButtonDataSource.d).a(0);
          PublicAccountReportUtils.a(null, "", "0X80094FE", "0X80094FE", 0, 0, "", "", "", ((VideoR5.Builder)localObject).b().a(), false);
          return;
        }
      }
      catch (Exception paramIEntranceButtonDataSource)
      {
        paramIEntranceButtonDataSource.printStackTrace();
      }
      return;
      label318:
      int m = 1;
    }
  }
  
  private static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, paramString);
    }
  }
  
  public static void b(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    ThreadManager.excute(new VideoFeedsFirstVideoRecommendationManager.1(paramIEntranceButtonDataSource), 16, null, true);
  }
  
  private boolean b(VideoInfo.EntranceDownloadInfo paramEntranceDownloadInfo)
  {
    if ((paramEntranceDownloadInfo != null) && (!TextUtils.isEmpty(paramEntranceDownloadInfo.a)) && (paramEntranceDownloadInfo.e != null) && (!TextUtils.isEmpty(paramEntranceDownloadInfo.e.b))) {
      return true;
    }
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkIsValidEntranceDownloadInfo failed!:");
      localStringBuilder.append(paramEntranceDownloadInfo);
      QLog.e(str, 2, localStringBuilder.toString());
    }
    return false;
  }
  
  private void c(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    ColorBandVideoEntranceButton localColorBandVideoEntranceButton = this.d;
    if (localColorBandVideoEntranceButton != null) {
      localColorBandVideoEntranceButton.setDataSource(paramIEntranceButtonDataSource);
    }
    d(paramIEntranceButtonDataSource);
  }
  
  private void d(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    ColorBandVideoEntranceButton localColorBandVideoEntranceButton = this.d;
    if ((localColorBandVideoEntranceButton != null) && (localColorBandVideoEntranceButton.getVisibility() == 0))
    {
      if (paramIEntranceButtonDataSource != null)
      {
        this.d.a(paramIEntranceButtonDataSource);
        return;
      }
      this.d.setNotMsg();
    }
  }
  
  private void f()
  {
    Object localObject;
    if (this.b != null)
    {
      localObject = RIJSPUtils.a(this.l);
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().putString("VIDEO_VID", this.b.b).putString("VIDEO_ARTICLE_ID", this.b.l).putString("VIDEO_PUB_ACCOUNT_UIN", this.b.q).putString("VIDEO_PUB_ACCOUNT_NAME", this.b.r).putString("VIDEO_THIRD_ACTION", this.b.A).putString("VIDEO_THIRD_ICON", this.b.B).putString("VIDEO_THIRD_NAME", this.b.C).putString("VIDEO_TITLE", this.b.g).putString("VIDEO_SUMMARY", this.b.h).putString("VIDEO_COVER", this.b.f).putString("VIDEO_H5_URL", this.b.k).putString("VIDEO_URL", this.b.D).putInt("VIDEO_WIDTH", this.b.c).putInt("VIDEO_HEIGHT", this.b.d).putInt("VIDEO_TIME", this.b.e).putInt("VIDEO_ARTICLE_BUSITYPE", this.b.a).putInt("VIDEO_FEED_TYPE", this.b.F).putLong("VIDEO_FEED_ID", this.b.E).putLong("VIDEO_XG_FILE_SIZE", this.b.n).putString("VIDEO_CREATE_TIME", this.b.i).putBoolean("key_is_use_gif", this.b.P).putString("key_gif_url", this.b.Q).putBoolean("key_is_show_cover", this.b.R).putBoolean("key_has_video_info", true).apply();
      }
    }
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start save video info, uin: ");
      localStringBuilder.append(this.l);
      localStringBuilder.append(", ");
      localObject = this.b;
      if (localObject != null) {
        localObject = ((VideoInfo)localObject).q();
      } else {
        localObject = "video info is null";
      }
      localStringBuilder.append((String)localObject);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  private VideoInfo g()
  {
    Object localObject2 = RIJSPUtils.a(this.l);
    String str = null;
    Object localObject1 = str;
    if (localObject2 != null)
    {
      localObject1 = str;
      if (((SharedPreferences)localObject2).getBoolean("key_has_video_info", false))
      {
        localObject1 = new VideoInfo();
        ((VideoInfo)localObject1).b = ((SharedPreferences)localObject2).getString("VIDEO_VID", null);
        ((VideoInfo)localObject1).l = ((SharedPreferences)localObject2).getString("VIDEO_ARTICLE_ID", null);
        ((VideoInfo)localObject1).q = ((SharedPreferences)localObject2).getString("VIDEO_PUB_ACCOUNT_UIN", null);
        ((VideoInfo)localObject1).r = ((SharedPreferences)localObject2).getString("VIDEO_PUB_ACCOUNT_NAME", null);
        ((VideoInfo)localObject1).A = ((SharedPreferences)localObject2).getString("VIDEO_THIRD_ACTION", null);
        ((VideoInfo)localObject1).B = ((SharedPreferences)localObject2).getString("VIDEO_THIRD_ICON", null);
        ((VideoInfo)localObject1).C = ((SharedPreferences)localObject2).getString("VIDEO_THIRD_NAME", null);
        ((VideoInfo)localObject1).g = ((SharedPreferences)localObject2).getString("VIDEO_TITLE", null);
        ((VideoInfo)localObject1).h = ((SharedPreferences)localObject2).getString("VIDEO_SUMMARY", null);
        ((VideoInfo)localObject1).f = ((SharedPreferences)localObject2).getString("VIDEO_COVER", null);
        ((VideoInfo)localObject1).k = ((SharedPreferences)localObject2).getString("VIDEO_H5_URL", null);
        ((VideoInfo)localObject1).D = ((SharedPreferences)localObject2).getString("VIDEO_URL", null);
        ((VideoInfo)localObject1).c = ((SharedPreferences)localObject2).getInt("VIDEO_WIDTH", -1);
        ((VideoInfo)localObject1).d = ((SharedPreferences)localObject2).getInt("VIDEO_HEIGHT", -1);
        ((VideoInfo)localObject1).e = ((SharedPreferences)localObject2).getInt("VIDEO_TIME", -1);
        ((VideoInfo)localObject1).a = ((SharedPreferences)localObject2).getInt("VIDEO_ARTICLE_BUSITYPE", -1);
        ((VideoInfo)localObject1).F = ((SharedPreferences)localObject2).getInt("VIDEO_FEED_TYPE", -1);
        ((VideoInfo)localObject1).E = ((SharedPreferences)localObject2).getLong("VIDEO_FEED_ID", -1L);
        ((VideoInfo)localObject1).n = ((SharedPreferences)localObject2).getLong("VIDEO_XG_FILE_SIZE", 0L);
        ((VideoInfo)localObject1).i = ((SharedPreferences)localObject2).getString("VIDEO_CREATE_TIME", null);
        ((VideoInfo)localObject1).P = ((SharedPreferences)localObject2).getBoolean("key_is_use_gif", false);
        ((VideoInfo)localObject1).Q = ((SharedPreferences)localObject2).getString("key_gif_url", null);
        ((VideoInfo)localObject1).R = ((SharedPreferences)localObject2).getBoolean("key_is_show_cover", true);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("load video info from local, uin: ");
      localStringBuilder.append(this.l);
      localStringBuilder.append(", video info: ");
      if (localObject1 != null) {
        str = ((VideoInfo)localObject1).q();
      } else {
        str = "null";
      }
      localStringBuilder.append(str);
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
    }
    return localObject1;
  }
  
  private void h()
  {
    Object localObject;
    if (this.b != null)
    {
      localObject = RIJSPUtils.a(this.l);
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().remove("VIDEO_VID").remove("VIDEO_ARTICLE_ID").remove("VIDEO_PUB_ACCOUNT_UIN").remove("VIDEO_PUB_ACCOUNT_NAME").remove("VIDEO_THIRD_ACTION").remove("VIDEO_THIRD_ICON").remove("VIDEO_THIRD_NAME").remove("VIDEO_TITLE").remove("VIDEO_SUMMARY").remove("VIDEO_COVER").remove("VIDEO_H5_URL").remove("VIDEO_URL").remove("VIDEO_WIDTH").remove("VIDEO_HEIGHT").remove("VIDEO_TIME").remove("VIDEO_ARTICLE_BUSITYPE").remove("VIDEO_FEED_TYPE").remove("VIDEO_FEED_ID").remove("VIDEO_XG_FILE_SIZE").remove("VIDEO_CREATE_TIME").remove("key_is_use_gif").remove("key_gif_url").remove("key_is_show_cover").remove("key_has_video_info").apply();
      }
    }
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("remove video info when click bb circle, uin: ");
      localStringBuilder.append(this.l);
      localStringBuilder.append(", ");
      localObject = this.b;
      if (localObject != null) {
        localObject = ((VideoInfo)localObject).q();
      } else {
        localObject = "video info is null";
      }
      localStringBuilder.append((String)localObject);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  private void i()
  {
    if (this.c != null)
    {
      SharedPreferences localSharedPreferences = RIJSPUtils.a(this.l);
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putString("key_icon_url", this.c.a).putString("key_small_icon_url", this.c.b).putBoolean("key_is_use_gif", this.c.c).putString("key_common_data", this.c.d).putInt("key_jump_type", this.c.e.a).putString("key_jump_url", this.c.e.b).putString("key_jump_bundle", this.c.e.c).putString("key_jump_schema", this.c.e.d).putBoolean("key_has_entrance_download_info", true).apply();
      }
    }
  }
  
  private VideoInfo.EntranceDownloadInfo j()
  {
    SharedPreferences localSharedPreferences = RIJSPUtils.a(this.l);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localSharedPreferences != null)
    {
      localObject1 = localObject2;
      if (localSharedPreferences.getBoolean("key_has_entrance_download_info", false))
      {
        localObject1 = new VideoInfo.EntranceDownloadInfo();
        ((VideoInfo.EntranceDownloadInfo)localObject1).a = localSharedPreferences.getString("key_icon_url", null);
        ((VideoInfo.EntranceDownloadInfo)localObject1).b = localSharedPreferences.getString("key_small_icon_url", null);
        ((VideoInfo.EntranceDownloadInfo)localObject1).c = localSharedPreferences.getBoolean("key_is_use_gif", false);
        ((VideoInfo.EntranceDownloadInfo)localObject1).d = localSharedPreferences.getString("key_common_data", null);
        ((VideoInfo.EntranceDownloadInfo)localObject1).e = new UrlJumpInfo();
        ((VideoInfo.EntranceDownloadInfo)localObject1).e.a = localSharedPreferences.getInt("key_jump_type", 0);
        ((VideoInfo.EntranceDownloadInfo)localObject1).e.b = localSharedPreferences.getString("key_jump_url", null);
        ((VideoInfo.EntranceDownloadInfo)localObject1).e.c = localSharedPreferences.getString("key_jump_bundle", null);
        ((VideoInfo.EntranceDownloadInfo)localObject1).e.d = localSharedPreferences.getString("key_jump_schema", null);
      }
    }
    return localObject1;
  }
  
  private void k()
  {
    if (this.c != null)
    {
      SharedPreferences localSharedPreferences = RIJSPUtils.a(this.l);
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().remove("key_icon_url").remove("key_small_icon_url").remove("key_is_use_gif").remove("key_common_data").remove("key_jump_type").remove("key_jump_url").remove("key_jump_schema").remove("key_jump_bundle").remove("key_has_entrance_download_info").apply();
      }
    }
  }
  
  public void a()
  {
    ColorBandVideoEntranceButton localColorBandVideoEntranceButton = this.d;
    if (localColorBandVideoEntranceButton != null) {
      localColorBandVideoEntranceButton.setDataSource(null);
    }
    k();
    this.c = null;
  }
  
  public void a(int paramInt)
  {
    if (this.e != null)
    {
      Object localObject1 = this.d;
      if ((localObject1 != null) && (((ColorBandVideoEntranceButton)localObject1).getVisibility() == 0) && (!this.j))
      {
        localObject1 = this.e;
        Object localObject2 = this.f;
        String str = this.i;
        boolean bool;
        if (this.b != null) {
          bool = true;
        } else {
          bool = false;
        }
        ((VideoPlayRecommendHandler)localObject1).a((VideoPlayRecommendObserver)localObject2, str, paramInt, bool);
        if (!QLog.isColorLevel()) {
          break label142;
        }
        localObject1 = a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("start fetch first recommend video, reqType: ");
        ((StringBuilder)localObject2).append(paramInt);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        break label142;
      }
    }
    if ((this.j) && (QLog.isColorLevel())) {
      QLog.d(a, 2, "filter auto refresh");
    }
    label142:
    this.k = paramInt;
    this.j = false;
  }
  
  public boolean a(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = this.b;
    if (paramBundle != null)
    {
      localBundle.putParcelable("VIDEO_OBJ", paramBundle);
      paramBundle = this.d;
      if (paramBundle != null) {
        paramBundle.setDataSource(null);
      }
      h();
      this.b = null;
      return true;
    }
    return false;
  }
  
  public void b()
  {
    QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.a();
    if (localQQAppInterface != null)
    {
      VideoPlayRecommendObserver localVideoPlayRecommendObserver = this.f;
      if (localVideoPlayRecommendObserver != null) {
        localQQAppInterface.removeObserver(localVideoPlayRecommendObserver);
      }
    }
  }
  
  public void c()
  {
    b();
    this.d = null;
    VideoPreDownloadMgr localVideoPreDownloadMgr = this.g;
    if (localVideoPreDownloadMgr != null)
    {
      localVideoPreDownloadMgr.b(false);
      this.g = null;
    }
    this.e = null;
    ReadInJoyLogicEngineEventDispatcher.a().b(this.h);
  }
  
  public void d()
  {
    Object localObject = this.d;
    if (localObject != null) {
      ((ColorBandVideoEntranceButton)localObject).a();
    }
    localObject = RIJQQAppInterfaceUtil.a();
    if (localObject != null)
    {
      this.e = ((VideoPlayRecommendHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.VIDEOPLAYRECOMMEND_HANDLER));
      ((QQAppInterface)localObject).addObserver(this.f);
      this.l = ((QQAppInterface)localObject).getAccount();
      this.b = g();
      c(this.b);
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "start change account");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsFirstVideoRecommendationManager
 * JD-Core Version:    0.7.0.1
 */