import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.EntranceDownloadInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFirstVideoRecommendationManager.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ColorBandVideoEntranceButton;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class sij
{
  private static final String jdField_a_of_type_JavaLangString = sij.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private VideoInfo.EntranceDownloadInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  private ColorBandVideoEntranceButton jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton;
  private omv jdField_a_of_type_Omv;
  private omw jdField_a_of_type_Omw;
  private sim jdField_a_of_type_Sim;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  private String c;
  
  public sij(ColorBandVideoEntranceButton paramColorBandVideoEntranceButton, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton = paramColorBandVideoEntranceButton;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = new VideoPreDownloadMgr(paramContext.getApplicationContext());
    paramColorBandVideoEntranceButton = pnn.a();
    if (paramColorBandVideoEntranceButton != null)
    {
      this.jdField_c_of_type_JavaLangString = paramColorBandVideoEntranceButton.getAccount();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo = a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo == null) {
        break label130;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 1, "setEntranceDataSourceAndRefresh mEntranceDownloadInfo");
      c(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo);
    }
    for (;;)
    {
      this.jdField_a_of_type_Omv = ((omv)paramColorBandVideoEntranceButton.getBusinessHandler(BusinessHandlerFactory.VIDEOPLAYRECOMMEND_HANDLER));
      this.jdField_a_of_type_Omw = new sik(this);
      paramColorBandVideoEntranceButton.addObserver(this.jdField_a_of_type_Omw);
      this.jdField_a_of_type_Sim = new sim(this, null);
      pvm.a().a(this.jdField_a_of_type_Sim);
      return;
      label130:
      if (bmhv.f() == 2)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "setEntranceDataSourceAndRefresh mRecommendVideo");
        this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = a();
        c(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      }
    }
  }
  
  private VideoInfo.EntranceDownloadInfo a()
  {
    SharedPreferences localSharedPreferences = bmhv.a(this.jdField_c_of_type_JavaLangString);
    if ((localSharedPreferences != null) && (localSharedPreferences.getBoolean("key_has_entrance_download_info", false)))
    {
      VideoInfo.EntranceDownloadInfo localEntranceDownloadInfo = new VideoInfo.EntranceDownloadInfo();
      localEntranceDownloadInfo.jdField_a_of_type_JavaLangString = localSharedPreferences.getString("key_icon_url", null);
      localEntranceDownloadInfo.jdField_b_of_type_JavaLangString = localSharedPreferences.getString("key_small_icon_url", null);
      localEntranceDownloadInfo.jdField_a_of_type_Boolean = localSharedPreferences.getBoolean("key_is_use_gif", false);
      localEntranceDownloadInfo.jdField_c_of_type_JavaLangString = localSharedPreferences.getString("key_common_data", null);
      localEntranceDownloadInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = new UrlJumpInfo();
      localEntranceDownloadInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_Int = localSharedPreferences.getInt("key_jump_type", 0);
      localEntranceDownloadInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_JavaLangString = localSharedPreferences.getString("key_jump_url", null);
      localEntranceDownloadInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_b_of_type_JavaLangString = localSharedPreferences.getString("key_jump_bundle", null);
      localEntranceDownloadInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_c_of_type_JavaLangString = localSharedPreferences.getString("key_jump_schema", null);
      return localEntranceDownloadInfo;
    }
    return null;
  }
  
  private VideoInfo a()
  {
    Object localObject = bmhv.a(this.jdField_c_of_type_JavaLangString);
    VideoInfo localVideoInfo;
    if ((localObject != null) && (((SharedPreferences)localObject).getBoolean("key_has_video_info", false)))
    {
      localVideoInfo = new VideoInfo();
      localVideoInfo.jdField_a_of_type_JavaLangString = ((SharedPreferences)localObject).getString("VIDEO_VID", null);
      localVideoInfo.jdField_g_of_type_JavaLangString = ((SharedPreferences)localObject).getString("VIDEO_ARTICLE_ID", null);
      localVideoInfo.j = ((SharedPreferences)localObject).getString("VIDEO_PUB_ACCOUNT_UIN", null);
      localVideoInfo.k = ((SharedPreferences)localObject).getString("VIDEO_PUB_ACCOUNT_NAME", null);
      localVideoInfo.o = ((SharedPreferences)localObject).getString("VIDEO_THIRD_ACTION", null);
      localVideoInfo.p = ((SharedPreferences)localObject).getString("VIDEO_THIRD_ICON", null);
      localVideoInfo.q = ((SharedPreferences)localObject).getString("VIDEO_THIRD_NAME", null);
      localVideoInfo.jdField_c_of_type_JavaLangString = ((SharedPreferences)localObject).getString("VIDEO_TITLE", null);
      localVideoInfo.jdField_d_of_type_JavaLangString = ((SharedPreferences)localObject).getString("VIDEO_SUMMARY", null);
      localVideoInfo.jdField_b_of_type_JavaLangString = ((SharedPreferences)localObject).getString("VIDEO_COVER", null);
      localVideoInfo.f = ((SharedPreferences)localObject).getString("VIDEO_H5_URL", null);
      localVideoInfo.r = ((SharedPreferences)localObject).getString("VIDEO_URL", null);
      localVideoInfo.jdField_b_of_type_Int = ((SharedPreferences)localObject).getInt("VIDEO_WIDTH", -1);
      localVideoInfo.jdField_c_of_type_Int = ((SharedPreferences)localObject).getInt("VIDEO_HEIGHT", -1);
      localVideoInfo.jdField_d_of_type_Int = ((SharedPreferences)localObject).getInt("VIDEO_TIME", -1);
      localVideoInfo.jdField_a_of_type_Int = ((SharedPreferences)localObject).getInt("VIDEO_ARTICLE_BUSITYPE", -1);
      localVideoInfo.jdField_h_of_type_Int = ((SharedPreferences)localObject).getInt("VIDEO_FEED_TYPE", -1);
      localVideoInfo.jdField_d_of_type_Long = ((SharedPreferences)localObject).getLong("VIDEO_FEED_ID", -1L);
      localVideoInfo.jdField_b_of_type_Long = ((SharedPreferences)localObject).getLong("VIDEO_XG_FILE_SIZE", 0L);
      localVideoInfo.e = ((SharedPreferences)localObject).getString("VIDEO_CREATE_TIME", null);
      localVideoInfo.jdField_g_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("key_is_use_gif", false);
      localVideoInfo.s = ((SharedPreferences)localObject).getString("key_gif_url", null);
      localVideoInfo.jdField_h_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("key_is_show_cover", true);
    }
    for (;;)
    {
      String str;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        str = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder().append("load video info from local, uin: ").append(this.jdField_c_of_type_JavaLangString).append(", video info: ");
        if (localVideoInfo == null) {
          break label402;
        }
      }
      label402:
      for (localObject = localVideoInfo.b();; localObject = "null")
      {
        QLog.d(str, 2, (String)localObject);
        return localVideoInfo;
      }
      localVideoInfo = null;
    }
  }
  
  private void a(VideoInfo.EntranceDownloadInfo paramEntranceDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGetEntranceDownloadInfo downloadInfo=" + paramEntranceDownloadInfo);
    }
    if (a(paramEntranceDownloadInfo))
    {
      if (six.g()) {
        break label64;
      }
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onGetEntranceDownloadInfo isVideoEntranceJumpAppEnable == false");
      }
    }
    label64:
    do
    {
      int i;
      int j;
      do
      {
        return;
        i = sez.a().b();
        j = six.j();
        if ((j <= 0) || (i < j)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "onGetEntranceDownloadInfo displayCount=" + i + " exceed maxDisplayCount=" + j);
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onGetEntranceDownloadInfo displayCount=" + i + ", maxDisplayCount=" + j);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo = paramEntranceDownloadInfo;
      c(paramEntranceDownloadInfo);
      g();
      f();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = null;
    } while ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() != 0));
    a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo);
  }
  
  private void a(VideoInfo paramVideoInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGetFirstRecommendVideoInfo videoInfo=" + paramVideoInfo);
    }
    if (paramVideoInfo != null)
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_h_of_type_Boolean) && (!paramVideoInfo.jdField_h_of_type_Boolean)) {
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
      c(paramVideoInfo);
      e();
    }
    if ((this.jdField_a_of_type_Int != 3) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() == 0)) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    }
    if (paramVideoInfo != null) {}
    for (String str = paramVideoInfo.b();; str = "videoInfo is null!")
    {
      a(paramVideoInfo, str);
      return;
    }
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
  
  private static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, paramString);
    }
  }
  
  public static void a(tso paramtso)
  {
    sez.a().a(paramtso);
    if (paramtso == null) {}
    label201:
    label244:
    do
    {
      int i;
      do
      {
        return;
        for (;;)
        {
          try
          {
            if (!(paramtso instanceof VideoInfo)) {
              break label244;
            }
            localObject = (VideoInfo)paramtso;
            JSONObject localJSONObject = pqf.a();
            localJSONObject.put("kandian_mode", 3);
            localJSONObject.put("tab_source", 5);
            if (localObject != null)
            {
              i = 2;
              localJSONObject.put("reddot", i);
              if (localObject == null) {
                break label201;
              }
              paramtso = ((VideoInfo)localObject).jdField_g_of_type_JavaLangString;
              localJSONObject.put("rowkey", paramtso);
              olh.a(null, "CliOper", "", "", "0X80081C6", "0X80081C6", 0, 0, "", "", "", localJSONObject.toString(), false);
              if (QLog.isColorLevel()) {
                QLog.d("Q.readinjoy.4tab", 2, "reportForVideoEntranceRedDotExposure has finished, r5: " + localJSONObject.toString());
              }
              i = bmhv.f();
              if (i != 1) {
                break;
              }
              olh.a(null, "", "0X8009A22", "0X8009A22", 0, 0, "", "", "", psu.a((VideoInfo)localObject, i), false);
              return;
            }
          }
          catch (Exception paramtso)
          {
            paramtso.printStackTrace();
            return;
          }
          i = 1;
          continue;
          paramtso = "";
        }
      } while (i != 2);
      olh.a(null, "", "0X80094FE", "0X80094FE", 0, 0, "", "", "", psu.a((VideoInfo)localObject, i), false);
      return;
    } while (!(paramtso instanceof VideoInfo.EntranceDownloadInfo));
    paramtso = (VideoInfo.EntranceDownloadInfo)paramtso;
    Object localObject = new suu("", "", "", "");
    ((suu)localObject).U(1).a(paramtso.jdField_c_of_type_JavaLangString).a(0);
    olh.a(null, "", "0X80094FE", "0X80094FE", 0, 0, "", "", "", ((suu)localObject).a().a(), false);
  }
  
  private boolean a(VideoInfo.EntranceDownloadInfo paramEntranceDownloadInfo)
  {
    if ((paramEntranceDownloadInfo != null) && (!TextUtils.isEmpty(paramEntranceDownloadInfo.jdField_a_of_type_JavaLangString)) && (paramEntranceDownloadInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) && (!TextUtils.isEmpty(paramEntranceDownloadInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_JavaLangString))) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "checkIsValidEntranceDownloadInfo failed!:" + paramEntranceDownloadInfo);
    }
    return false;
  }
  
  public static void b(tso paramtso)
  {
    ThreadManager.excute(new VideoFeedsFirstVideoRecommendationManager.1(paramtso), 16, null, true);
  }
  
  private void c(tso paramtso)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(paramtso);
    }
    d(paramtso);
  }
  
  private void d(tso paramtso)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() == 0))
    {
      if (paramtso != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a(paramtso);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setNotMsg();
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      localObject = bmhv.a(this.jdField_c_of_type_JavaLangString);
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().putString("VIDEO_VID", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString).putString("VIDEO_ARTICLE_ID", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString).putString("VIDEO_PUB_ACCOUNT_UIN", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.j).putString("VIDEO_PUB_ACCOUNT_NAME", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.k).putString("VIDEO_THIRD_ACTION", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.o).putString("VIDEO_THIRD_ICON", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.p).putString("VIDEO_THIRD_NAME", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.q).putString("VIDEO_TITLE", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_JavaLangString).putString("VIDEO_SUMMARY", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_JavaLangString).putString("VIDEO_COVER", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_JavaLangString).putString("VIDEO_H5_URL", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.f).putString("VIDEO_URL", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.r).putInt("VIDEO_WIDTH", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int).putInt("VIDEO_HEIGHT", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int).putInt("VIDEO_TIME", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int).putInt("VIDEO_ARTICLE_BUSITYPE", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int).putInt("VIDEO_FEED_TYPE", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_h_of_type_Int).putLong("VIDEO_FEED_ID", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Long).putLong("VIDEO_XG_FILE_SIZE", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Long).putString("VIDEO_CREATE_TIME", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.e).putBoolean("key_is_use_gif", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_Boolean).putString("key_gif_url", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.s).putBoolean("key_is_show_cover", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_h_of_type_Boolean).putBoolean("key_has_video_info", true).apply();
      }
    }
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("start save video info, uin: ").append(this.jdField_c_of_type_JavaLangString).append(", ");
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) {
        break label432;
      }
    }
    label432:
    for (Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b();; localObject = "video info is null")
    {
      QLog.d(str, 2, (String)localObject);
      return;
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      localObject = bmhv.a(this.jdField_c_of_type_JavaLangString);
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().remove("VIDEO_VID").remove("VIDEO_ARTICLE_ID").remove("VIDEO_PUB_ACCOUNT_UIN").remove("VIDEO_PUB_ACCOUNT_NAME").remove("VIDEO_THIRD_ACTION").remove("VIDEO_THIRD_ICON").remove("VIDEO_THIRD_NAME").remove("VIDEO_TITLE").remove("VIDEO_SUMMARY").remove("VIDEO_COVER").remove("VIDEO_H5_URL").remove("VIDEO_URL").remove("VIDEO_WIDTH").remove("VIDEO_HEIGHT").remove("VIDEO_TIME").remove("VIDEO_ARTICLE_BUSITYPE").remove("VIDEO_FEED_TYPE").remove("VIDEO_FEED_ID").remove("VIDEO_XG_FILE_SIZE").remove("VIDEO_CREATE_TIME").remove("key_is_use_gif").remove("key_gif_url").remove("key_is_show_cover").remove("key_has_video_info").apply();
      }
    }
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("remove video info when click bb circle, uin: ").append(this.jdField_c_of_type_JavaLangString).append(", ");
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) {
        break label270;
      }
    }
    label270:
    for (Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b();; localObject = "video info is null")
    {
      QLog.d(str, 2, (String)localObject);
      return;
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo != null)
    {
      SharedPreferences localSharedPreferences = bmhv.a(this.jdField_c_of_type_JavaLangString);
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putString("key_icon_url", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo.jdField_a_of_type_JavaLangString).putString("key_small_icon_url", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo.jdField_b_of_type_JavaLangString).putBoolean("key_is_use_gif", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo.jdField_a_of_type_Boolean).putString("key_common_data", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo.jdField_c_of_type_JavaLangString).putInt("key_jump_type", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_Int).putString("key_jump_url", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_JavaLangString).putString("key_jump_bundle", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_b_of_type_JavaLangString).putString("key_jump_schema", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_c_of_type_JavaLangString).putBoolean("key_has_entrance_download_info", true).apply();
      }
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo != null)
    {
      SharedPreferences localSharedPreferences = bmhv.a(this.jdField_c_of_type_JavaLangString);
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().remove("key_icon_url").remove("key_small_icon_url").remove("key_is_use_gif").remove("key_common_data").remove("key_jump_type").remove("key_jump_url").remove("key_jump_schema").remove("key_jump_bundle").remove("key_has_entrance_download_info").apply();
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(null);
    }
    h();
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo = null;
  }
  
  public void a(int paramInt)
  {
    boolean bool;
    if ((this.jdField_a_of_type_Omv != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() == 0) && (!this.jdField_a_of_type_Boolean))
    {
      omv localomv = this.jdField_a_of_type_Omv;
      omw localomw = this.jdField_a_of_type_Omw;
      String str = this.jdField_b_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
      {
        bool = true;
        localomv.a(localomw, str, paramInt, bool);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "start fetch first recommend video, reqType: " + paramInt);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_Boolean = false;
      return;
      bool = false;
      break;
      if ((this.jdField_a_of_type_Boolean) && (QLog.isColorLevel())) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "filter auto refresh");
      }
    }
  }
  
  public boolean a(Bundle paramBundle)
  {
    boolean bool = false;
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      localBundle.putParcelable("VIDEO_OBJ", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      bool = true;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(null);
      }
      f();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = null;
    }
    return bool;
  }
  
  public void b()
  {
    QQAppInterface localQQAppInterface = pnn.a();
    if ((localQQAppInterface != null) && (this.jdField_a_of_type_Omw != null)) {
      localQQAppInterface.removeObserver(this.jdField_a_of_type_Omw);
    }
  }
  
  public void c()
  {
    b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.b(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = null;
    }
    this.jdField_a_of_type_Omv = null;
    pvm.a().b(this.jdField_a_of_type_Sim);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a();
    }
    QQAppInterface localQQAppInterface = pnn.a();
    if (localQQAppInterface != null)
    {
      this.jdField_a_of_type_Omv = ((omv)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VIDEOPLAYRECOMMEND_HANDLER));
      localQQAppInterface.addObserver(this.jdField_a_of_type_Omw);
      this.jdField_c_of_type_JavaLangString = localQQAppInterface.getAccount();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = a();
      c(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "start change account");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sij
 * JD-Core Version:    0.7.0.1
 */