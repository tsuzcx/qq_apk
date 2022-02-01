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
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class VideoFeedsFirstVideoRecommendationManager
{
  private static final String jdField_a_of_type_JavaLangString = "VideoFeedsFirstVideoRecommendationManager";
  private int jdField_a_of_type_Int;
  private VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstVideoObserver jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsFirstVideoRecommendationManager$VideoFeedsFirstVideoObserver;
  private VideoPlayRecommendHandler jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendHandler;
  private VideoPlayRecommendObserver jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendObserver;
  private ColorBandVideoEntranceButton jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton;
  private VideoInfo.EntranceDownloadInfo jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$EntranceDownloadInfo;
  private VideoInfo jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  private String c;
  
  public VideoFeedsFirstVideoRecommendationManager(ColorBandVideoEntranceButton paramColorBandVideoEntranceButton, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton = paramColorBandVideoEntranceButton;
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr = new VideoPreDownloadMgr(paramContext.getApplicationContext());
    paramColorBandVideoEntranceButton = RIJQQAppInterfaceUtil.a();
    if (paramColorBandVideoEntranceButton != null)
    {
      this.jdField_c_of_type_JavaLangString = paramColorBandVideoEntranceButton.getAccount();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$EntranceDownloadInfo = a();
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$EntranceDownloadInfo != null)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "setEntranceDataSourceAndRefresh mEntranceDownloadInfo");
        c(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$EntranceDownloadInfo);
      }
      else if (ReadInJoyHelper.e() == 2)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "setEntranceDataSourceAndRefresh mRecommendVideo");
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo = a();
        c(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendHandler = ((VideoPlayRecommendHandler)paramColorBandVideoEntranceButton.getBusinessHandler(BusinessHandlerFactory.VIDEOPLAYRECOMMEND_HANDLER));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendObserver = new VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver(this);
      paramColorBandVideoEntranceButton.addObserver(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendObserver);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsFirstVideoRecommendationManager$VideoFeedsFirstVideoObserver = new VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstVideoObserver(this, null);
      ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsFirstVideoRecommendationManager$VideoFeedsFirstVideoObserver);
    }
  }
  
  private VideoInfo.EntranceDownloadInfo a()
  {
    SharedPreferences localSharedPreferences = RIJSPUtils.a(this.jdField_c_of_type_JavaLangString);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localSharedPreferences != null)
    {
      localObject1 = localObject2;
      if (localSharedPreferences.getBoolean("key_has_entrance_download_info", false))
      {
        localObject1 = new VideoInfo.EntranceDownloadInfo();
        ((VideoInfo.EntranceDownloadInfo)localObject1).jdField_a_of_type_JavaLangString = localSharedPreferences.getString("key_icon_url", null);
        ((VideoInfo.EntranceDownloadInfo)localObject1).jdField_b_of_type_JavaLangString = localSharedPreferences.getString("key_small_icon_url", null);
        ((VideoInfo.EntranceDownloadInfo)localObject1).jdField_a_of_type_Boolean = localSharedPreferences.getBoolean("key_is_use_gif", false);
        ((VideoInfo.EntranceDownloadInfo)localObject1).jdField_c_of_type_JavaLangString = localSharedPreferences.getString("key_common_data", null);
        ((VideoInfo.EntranceDownloadInfo)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo = new UrlJumpInfo();
        ((VideoInfo.EntranceDownloadInfo)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_a_of_type_Int = localSharedPreferences.getInt("key_jump_type", 0);
        ((VideoInfo.EntranceDownloadInfo)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_a_of_type_JavaLangString = localSharedPreferences.getString("key_jump_url", null);
        ((VideoInfo.EntranceDownloadInfo)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_b_of_type_JavaLangString = localSharedPreferences.getString("key_jump_bundle", null);
        ((VideoInfo.EntranceDownloadInfo)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_c_of_type_JavaLangString = localSharedPreferences.getString("key_jump_schema", null);
      }
    }
    return localObject1;
  }
  
  private VideoInfo a()
  {
    Object localObject2 = RIJSPUtils.a(this.jdField_c_of_type_JavaLangString);
    String str = null;
    Object localObject1 = str;
    if (localObject2 != null)
    {
      localObject1 = str;
      if (((SharedPreferences)localObject2).getBoolean("key_has_video_info", false))
      {
        localObject1 = new VideoInfo();
        ((VideoInfo)localObject1).jdField_a_of_type_JavaLangString = ((SharedPreferences)localObject2).getString("VIDEO_VID", null);
        ((VideoInfo)localObject1).jdField_g_of_type_JavaLangString = ((SharedPreferences)localObject2).getString("VIDEO_ARTICLE_ID", null);
        ((VideoInfo)localObject1).j = ((SharedPreferences)localObject2).getString("VIDEO_PUB_ACCOUNT_UIN", null);
        ((VideoInfo)localObject1).k = ((SharedPreferences)localObject2).getString("VIDEO_PUB_ACCOUNT_NAME", null);
        ((VideoInfo)localObject1).o = ((SharedPreferences)localObject2).getString("VIDEO_THIRD_ACTION", null);
        ((VideoInfo)localObject1).p = ((SharedPreferences)localObject2).getString("VIDEO_THIRD_ICON", null);
        ((VideoInfo)localObject1).q = ((SharedPreferences)localObject2).getString("VIDEO_THIRD_NAME", null);
        ((VideoInfo)localObject1).jdField_c_of_type_JavaLangString = ((SharedPreferences)localObject2).getString("VIDEO_TITLE", null);
        ((VideoInfo)localObject1).jdField_d_of_type_JavaLangString = ((SharedPreferences)localObject2).getString("VIDEO_SUMMARY", null);
        ((VideoInfo)localObject1).jdField_b_of_type_JavaLangString = ((SharedPreferences)localObject2).getString("VIDEO_COVER", null);
        ((VideoInfo)localObject1).jdField_f_of_type_JavaLangString = ((SharedPreferences)localObject2).getString("VIDEO_H5_URL", null);
        ((VideoInfo)localObject1).r = ((SharedPreferences)localObject2).getString("VIDEO_URL", null);
        ((VideoInfo)localObject1).jdField_b_of_type_Int = ((SharedPreferences)localObject2).getInt("VIDEO_WIDTH", -1);
        ((VideoInfo)localObject1).jdField_c_of_type_Int = ((SharedPreferences)localObject2).getInt("VIDEO_HEIGHT", -1);
        ((VideoInfo)localObject1).jdField_d_of_type_Int = ((SharedPreferences)localObject2).getInt("VIDEO_TIME", -1);
        ((VideoInfo)localObject1).jdField_a_of_type_Int = ((SharedPreferences)localObject2).getInt("VIDEO_ARTICLE_BUSITYPE", -1);
        ((VideoInfo)localObject1).h = ((SharedPreferences)localObject2).getInt("VIDEO_FEED_TYPE", -1);
        ((VideoInfo)localObject1).jdField_d_of_type_Long = ((SharedPreferences)localObject2).getLong("VIDEO_FEED_ID", -1L);
        ((VideoInfo)localObject1).jdField_b_of_type_Long = ((SharedPreferences)localObject2).getLong("VIDEO_XG_FILE_SIZE", 0L);
        ((VideoInfo)localObject1).e = ((SharedPreferences)localObject2).getString("VIDEO_CREATE_TIME", null);
        ((VideoInfo)localObject1).jdField_f_of_type_Boolean = ((SharedPreferences)localObject2).getBoolean("key_is_use_gif", false);
        ((VideoInfo)localObject1).s = ((SharedPreferences)localObject2).getString("key_gif_url", null);
        ((VideoInfo)localObject1).jdField_g_of_type_Boolean = ((SharedPreferences)localObject2).getBoolean("key_is_show_cover", true);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("load video info from local, uin: ");
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      localStringBuilder.append(", video info: ");
      if (localObject1 != null) {
        str = ((VideoInfo)localObject1).e();
      } else {
        str = "null";
      }
      localStringBuilder.append(str);
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
    }
    return localObject1;
  }
  
  private void a(VideoInfo.EntranceDownloadInfo paramEntranceDownloadInfo)
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetEntranceDownloadInfo downloadInfo=");
      localStringBuilder.append(paramEntranceDownloadInfo);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (a(paramEntranceDownloadInfo))
    {
      if (!VideoFeedsHelper.f())
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "onGetEntranceDownloadInfo isVideoEntranceJumpAppEnable == false");
        }
        return;
      }
      int i = EntranceButtonExposureHelper.a().b();
      int j = VideoFeedsHelper.j();
      if ((j > 0) && (i >= j))
      {
        if (QLog.isColorLevel())
        {
          paramEntranceDownloadInfo = jdField_a_of_type_JavaLangString;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onGetEntranceDownloadInfo displayCount=");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(" exceed maxDisplayCount=");
          ((StringBuilder)localObject).append(j);
          QLog.e(paramEntranceDownloadInfo, 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onGetEntranceDownloadInfo displayCount=");
        localStringBuilder.append(i);
        localStringBuilder.append(", maxDisplayCount=");
        localStringBuilder.append(j);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$EntranceDownloadInfo = paramEntranceDownloadInfo;
      c(paramEntranceDownloadInfo);
      g();
      f();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo = null;
      if (this.jdField_a_of_type_Int != 3)
      {
        paramEntranceDownloadInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton;
        if ((paramEntranceDownloadInfo != null) && (paramEntranceDownloadInfo.getVisibility() == 0)) {
          a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$EntranceDownloadInfo);
        }
      }
    }
  }
  
  private void a(VideoInfo paramVideoInfo)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetFirstRecommendVideoInfo videoInfo=");
      localStringBuilder.append(paramVideoInfo);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (paramVideoInfo != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
      if ((localObject != null) && (((VideoInfo)localObject).jdField_g_of_type_Boolean) && (!paramVideoInfo.jdField_g_of_type_Boolean)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo = paramVideoInfo;
      c(paramVideoInfo);
      e();
    }
    if (this.jdField_a_of_type_Int != 3)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton;
      if ((localObject != null) && (((ColorBandVideoEntranceButton)localObject).getVisibility() == 0)) {
        a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo);
      }
    }
    if (paramVideoInfo != null) {
      localObject = paramVideoInfo.e();
    } else {
      localObject = "videoInfo is null!";
    }
    a(paramVideoInfo, (String)localObject);
  }
  
  private static void a(VideoInfo paramVideoInfo, String paramString)
  {
    if ((paramVideoInfo != null) && (QLog.isColorLevel()))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, paramString);
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
          JSONObject localJSONObject = RIJTransMergeKanDianReport.a();
          localJSONObject.put("kandian_mode", 3);
          localJSONObject.put("tab_source", 5);
          if (localVideoInfo == null) {
            break label388;
          }
          i = 2;
          localJSONObject.put("reddot", i);
          paramIEntranceButtonDataSource = (IEntranceButtonDataSource)localObject;
          if (localVideoInfo != null) {
            paramIEntranceButtonDataSource = localVideoInfo.jdField_g_of_type_JavaLangString;
          }
          localJSONObject.put("rowkey", paramIEntranceButtonDataSource);
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80081C6", "0X80081C6", 0, 0, "", "", "", localJSONObject.toString(), false);
          if (QLog.isColorLevel())
          {
            paramIEntranceButtonDataSource = new StringBuilder();
            paramIEntranceButtonDataSource.append("reportForVideoEntranceRedDotExposure has finished, r5: ");
            paramIEntranceButtonDataSource.append(localJSONObject.toString());
            QLog.d("Q.readinjoy.4tab", 2, paramIEntranceButtonDataSource.toString());
          }
          i = ReadInJoyHelper.e();
          if (i == 1)
          {
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009A22", "0X8009A22", 0, 0, "", "", "", RIJVideoReportManager.a(localVideoInfo, i), false);
            return;
          }
          if (i == 2) {
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80094FE", "0X80094FE", 0, 0, "", "", "", RIJVideoReportManager.a(localVideoInfo, i), false);
          }
        }
        else if ((paramIEntranceButtonDataSource instanceof VideoInfo.EntranceDownloadInfo))
        {
          paramIEntranceButtonDataSource = (VideoInfo.EntranceDownloadInfo)paramIEntranceButtonDataSource;
          localObject = new VideoR5.Builder("", "", "", "");
          ((VideoR5.Builder)localObject).V(1).a(paramIEntranceButtonDataSource.jdField_c_of_type_JavaLangString).a(0);
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80094FE", "0X80094FE", 0, 0, "", "", "", ((VideoR5.Builder)localObject).a().a(), false);
          return;
        }
      }
      catch (Exception paramIEntranceButtonDataSource)
      {
        paramIEntranceButtonDataSource.printStackTrace();
      }
      return;
      label388:
      int i = 1;
    }
  }
  
  private static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, paramString);
    }
  }
  
  private boolean a(VideoInfo.EntranceDownloadInfo paramEntranceDownloadInfo)
  {
    if ((paramEntranceDownloadInfo != null) && (!TextUtils.isEmpty(paramEntranceDownloadInfo.jdField_a_of_type_JavaLangString)) && (paramEntranceDownloadInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo != null) && (!TextUtils.isEmpty(paramEntranceDownloadInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_a_of_type_JavaLangString))) {
      return true;
    }
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkIsValidEntranceDownloadInfo failed!:");
      localStringBuilder.append(paramEntranceDownloadInfo);
      QLog.e(str, 2, localStringBuilder.toString());
    }
    return false;
  }
  
  public static void b(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    ThreadManager.excute(new VideoFeedsFirstVideoRecommendationManager.1(paramIEntranceButtonDataSource), 16, null, true);
  }
  
  private void c(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    ColorBandVideoEntranceButton localColorBandVideoEntranceButton = this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton;
    if (localColorBandVideoEntranceButton != null) {
      localColorBandVideoEntranceButton.setDataSource(paramIEntranceButtonDataSource);
    }
    d(paramIEntranceButtonDataSource);
  }
  
  private void d(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    ColorBandVideoEntranceButton localColorBandVideoEntranceButton = this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton;
    if ((localColorBandVideoEntranceButton != null) && (localColorBandVideoEntranceButton.getVisibility() == 0))
    {
      if (paramIEntranceButtonDataSource != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.a(paramIEntranceButtonDataSource);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.setNotMsg();
    }
  }
  
  private void e()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null)
    {
      localObject = RIJSPUtils.a(this.jdField_c_of_type_JavaLangString);
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().putString("VIDEO_VID", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString).putString("VIDEO_ARTICLE_ID", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_g_of_type_JavaLangString).putString("VIDEO_PUB_ACCOUNT_UIN", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.j).putString("VIDEO_PUB_ACCOUNT_NAME", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.k).putString("VIDEO_THIRD_ACTION", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.o).putString("VIDEO_THIRD_ICON", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.p).putString("VIDEO_THIRD_NAME", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.q).putString("VIDEO_TITLE", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_c_of_type_JavaLangString).putString("VIDEO_SUMMARY", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_d_of_type_JavaLangString).putString("VIDEO_COVER", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_b_of_type_JavaLangString).putString("VIDEO_H5_URL", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_f_of_type_JavaLangString).putString("VIDEO_URL", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.r).putInt("VIDEO_WIDTH", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_b_of_type_Int).putInt("VIDEO_HEIGHT", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_c_of_type_Int).putInt("VIDEO_TIME", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_d_of_type_Int).putInt("VIDEO_ARTICLE_BUSITYPE", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_Int).putInt("VIDEO_FEED_TYPE", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.h).putLong("VIDEO_FEED_ID", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_d_of_type_Long).putLong("VIDEO_XG_FILE_SIZE", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_b_of_type_Long).putString("VIDEO_CREATE_TIME", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.e).putBoolean("key_is_use_gif", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_f_of_type_Boolean).putString("key_gif_url", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.s).putBoolean("key_is_show_cover", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_g_of_type_Boolean).putBoolean("key_has_video_info", true).apply();
      }
    }
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start save video info, uin: ");
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      localStringBuilder.append(", ");
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
      if (localObject != null) {
        localObject = ((VideoInfo)localObject).e();
      } else {
        localObject = "video info is null";
      }
      localStringBuilder.append((String)localObject);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  private void f()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null)
    {
      localObject = RIJSPUtils.a(this.jdField_c_of_type_JavaLangString);
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().remove("VIDEO_VID").remove("VIDEO_ARTICLE_ID").remove("VIDEO_PUB_ACCOUNT_UIN").remove("VIDEO_PUB_ACCOUNT_NAME").remove("VIDEO_THIRD_ACTION").remove("VIDEO_THIRD_ICON").remove("VIDEO_THIRD_NAME").remove("VIDEO_TITLE").remove("VIDEO_SUMMARY").remove("VIDEO_COVER").remove("VIDEO_H5_URL").remove("VIDEO_URL").remove("VIDEO_WIDTH").remove("VIDEO_HEIGHT").remove("VIDEO_TIME").remove("VIDEO_ARTICLE_BUSITYPE").remove("VIDEO_FEED_TYPE").remove("VIDEO_FEED_ID").remove("VIDEO_XG_FILE_SIZE").remove("VIDEO_CREATE_TIME").remove("key_is_use_gif").remove("key_gif_url").remove("key_is_show_cover").remove("key_has_video_info").apply();
      }
    }
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("remove video info when click bb circle, uin: ");
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      localStringBuilder.append(", ");
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
      if (localObject != null) {
        localObject = ((VideoInfo)localObject).e();
      } else {
        localObject = "video info is null";
      }
      localStringBuilder.append((String)localObject);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$EntranceDownloadInfo != null)
    {
      SharedPreferences localSharedPreferences = RIJSPUtils.a(this.jdField_c_of_type_JavaLangString);
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putString("key_icon_url", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$EntranceDownloadInfo.jdField_a_of_type_JavaLangString).putString("key_small_icon_url", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$EntranceDownloadInfo.jdField_b_of_type_JavaLangString).putBoolean("key_is_use_gif", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$EntranceDownloadInfo.jdField_a_of_type_Boolean).putString("key_common_data", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$EntranceDownloadInfo.jdField_c_of_type_JavaLangString).putInt("key_jump_type", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$EntranceDownloadInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_a_of_type_Int).putString("key_jump_url", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$EntranceDownloadInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_a_of_type_JavaLangString).putString("key_jump_bundle", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$EntranceDownloadInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_b_of_type_JavaLangString).putString("key_jump_schema", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$EntranceDownloadInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_c_of_type_JavaLangString).putBoolean("key_has_entrance_download_info", true).apply();
      }
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$EntranceDownloadInfo != null)
    {
      SharedPreferences localSharedPreferences = RIJSPUtils.a(this.jdField_c_of_type_JavaLangString);
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().remove("key_icon_url").remove("key_small_icon_url").remove("key_is_use_gif").remove("key_common_data").remove("key_jump_type").remove("key_jump_url").remove("key_jump_schema").remove("key_jump_bundle").remove("key_has_entrance_download_info").apply();
      }
    }
  }
  
  public void a()
  {
    ColorBandVideoEntranceButton localColorBandVideoEntranceButton = this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton;
    if (localColorBandVideoEntranceButton != null) {
      localColorBandVideoEntranceButton.setDataSource(null);
    }
    h();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$EntranceDownloadInfo = null;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendHandler != null)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton;
      if ((localObject1 != null) && (((ColorBandVideoEntranceButton)localObject1).getVisibility() == 0) && (!this.jdField_a_of_type_Boolean))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendHandler;
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendObserver;
        String str = this.jdField_b_of_type_JavaLangString;
        boolean bool;
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null) {
          bool = true;
        } else {
          bool = false;
        }
        ((VideoPlayRecommendHandler)localObject1).a((VideoPlayRecommendObserver)localObject2, str, paramInt, bool);
        if (!QLog.isColorLevel()) {
          break label142;
        }
        localObject1 = jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("start fetch first recommend video, reqType: ");
        ((StringBuilder)localObject2).append(paramInt);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        break label142;
      }
    }
    if ((this.jdField_a_of_type_Boolean) && (QLog.isColorLevel())) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "filter auto refresh");
    }
    label142:
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public boolean a(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
    if (paramBundle != null)
    {
      localBundle.putParcelable("VIDEO_OBJ", paramBundle);
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton;
      if (paramBundle != null) {
        paramBundle.setDataSource(null);
      }
      f();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo = null;
      return true;
    }
    return false;
  }
  
  public void b()
  {
    QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.a();
    if (localQQAppInterface != null)
    {
      VideoPlayRecommendObserver localVideoPlayRecommendObserver = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendObserver;
      if (localVideoPlayRecommendObserver != null) {
        localQQAppInterface.removeObserver(localVideoPlayRecommendObserver);
      }
    }
  }
  
  public void c()
  {
    b();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton = null;
    VideoPreDownloadMgr localVideoPreDownloadMgr = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr;
    if (localVideoPreDownloadMgr != null)
    {
      localVideoPreDownloadMgr.b(false);
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendHandler = null;
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsFirstVideoRecommendationManager$VideoFeedsFirstVideoObserver);
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton;
    if (localObject != null) {
      ((ColorBandVideoEntranceButton)localObject).a();
    }
    localObject = RIJQQAppInterfaceUtil.a();
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendHandler = ((VideoPlayRecommendHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.VIDEOPLAYRECOMMEND_HANDLER));
      ((QQAppInterface)localObject).addObserver(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendObserver);
      this.jdField_c_of_type_JavaLangString = ((QQAppInterface)localObject).getAccount();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo = a();
      c(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo);
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "start change account");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsFirstVideoRecommendationManager
 * JD-Core Version:    0.7.0.1
 */