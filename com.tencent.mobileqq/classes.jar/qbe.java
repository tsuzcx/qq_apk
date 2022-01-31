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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class qbe
{
  private static final String jdField_a_of_type_JavaLangString = qbe.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private VideoInfo.EntranceDownloadInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  private ColorBandVideoEntranceButton jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton;
  private neu jdField_a_of_type_Neu;
  private nev jdField_a_of_type_Nev;
  private qbh jdField_a_of_type_Qbh;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  private String c;
  
  public qbe(ColorBandVideoEntranceButton paramColorBandVideoEntranceButton, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton = paramColorBandVideoEntranceButton;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = new VideoPreDownloadMgr(paramContext.getApplicationContext());
    paramColorBandVideoEntranceButton = obz.a();
    if (paramColorBandVideoEntranceButton != null)
    {
      this.jdField_c_of_type_JavaLangString = paramColorBandVideoEntranceButton.getAccount();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo = a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo == null) {
        break label121;
      }
      c(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo);
    }
    for (;;)
    {
      this.jdField_a_of_type_Neu = ((neu)paramColorBandVideoEntranceButton.a(90));
      this.jdField_a_of_type_Nev = new qbf(this, null);
      paramColorBandVideoEntranceButton.addObserver(this.jdField_a_of_type_Nev);
      this.jdField_a_of_type_Qbh = new qbh(this, null);
      ohb.a().a(this.jdField_a_of_type_Qbh);
      return;
      label121:
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = a();
      c(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    }
  }
  
  private VideoInfo.EntranceDownloadInfo a()
  {
    SharedPreferences localSharedPreferences = bgmq.a(this.jdField_c_of_type_JavaLangString);
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
    Object localObject = bgmq.a(this.jdField_c_of_type_JavaLangString);
    VideoInfo localVideoInfo;
    if ((localObject != null) && (((SharedPreferences)localObject).getBoolean("key_has_video_info", false)))
    {
      localVideoInfo = new VideoInfo();
      localVideoInfo.jdField_a_of_type_JavaLangString = ((SharedPreferences)localObject).getString("VIDEO_VID", null);
      localVideoInfo.jdField_g_of_type_JavaLangString = ((SharedPreferences)localObject).getString("VIDEO_ARTICLE_ID", null);
      localVideoInfo.j = ((SharedPreferences)localObject).getString("VIDEO_PUB_ACCOUNT_UIN", null);
      localVideoInfo.jdField_k_of_type_JavaLangString = ((SharedPreferences)localObject).getString("VIDEO_PUB_ACCOUNT_NAME", null);
      localVideoInfo.D = ((SharedPreferences)localObject).getString("VIDEO_THIRD_ACTION", null);
      localVideoInfo.E = ((SharedPreferences)localObject).getString("VIDEO_THIRD_ICON", null);
      localVideoInfo.F = ((SharedPreferences)localObject).getString("VIDEO_THIRD_NAME", null);
      localVideoInfo.jdField_c_of_type_JavaLangString = ((SharedPreferences)localObject).getString("VIDEO_TITLE", null);
      localVideoInfo.jdField_d_of_type_JavaLangString = ((SharedPreferences)localObject).getString("VIDEO_SUMMARY", null);
      localVideoInfo.jdField_b_of_type_JavaLangString = ((SharedPreferences)localObject).getString("VIDEO_COVER", null);
      localVideoInfo.f = ((SharedPreferences)localObject).getString("VIDEO_H5_URL", null);
      localVideoInfo.G = ((SharedPreferences)localObject).getString("VIDEO_URL", null);
      localVideoInfo.jdField_b_of_type_Int = ((SharedPreferences)localObject).getInt("VIDEO_WIDTH", -1);
      localVideoInfo.jdField_c_of_type_Int = ((SharedPreferences)localObject).getInt("VIDEO_HEIGHT", -1);
      localVideoInfo.jdField_d_of_type_Int = ((SharedPreferences)localObject).getInt("VIDEO_TIME", -1);
      localVideoInfo.jdField_a_of_type_Int = ((SharedPreferences)localObject).getInt("VIDEO_ARTICLE_BUSITYPE", -1);
      localVideoInfo.jdField_k_of_type_Int = ((SharedPreferences)localObject).getInt("VIDEO_FEED_TYPE", -1);
      localVideoInfo.jdField_d_of_type_Long = ((SharedPreferences)localObject).getLong("VIDEO_FEED_ID", -1L);
      localVideoInfo.jdField_b_of_type_Long = ((SharedPreferences)localObject).getLong("VIDEO_XG_FILE_SIZE", 0L);
      localVideoInfo.e = ((SharedPreferences)localObject).getString("VIDEO_CREATE_TIME", null);
      localVideoInfo.jdField_g_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("key_is_use_gif", false);
      localVideoInfo.H = ((SharedPreferences)localObject).getString("key_gif_url", null);
      localVideoInfo.h = ((SharedPreferences)localObject).getBoolean("key_is_show_cover", true);
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
          break label398;
        }
      }
      label398:
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
      if (qcn.d()) {
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
        i = pxp.a().b();
        j = qcn.f();
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
      if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.h) && (!paramVideoInfo.h)) {
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
  
  public static void a(rik paramrik)
  {
    pxp.a().a(paramrik);
    if (paramrik == null) {}
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
            if (!(paramrik instanceof VideoInfo)) {
              break label244;
            }
            localObject = (VideoInfo)paramrik;
            JSONObject localJSONObject = obz.a();
            localJSONObject.put("kandian_mode", 3);
            localJSONObject.put("tab_source", 5);
            if (localObject != null)
            {
              i = 2;
              localJSONObject.put("reddot", i);
              if (localObject == null) {
                break label201;
              }
              paramrik = ((VideoInfo)localObject).jdField_g_of_type_JavaLangString;
              localJSONObject.put("rowkey", paramrik);
              ndn.a(null, "CliOper", "", "", "0X80081C6", "0X80081C6", 0, 0, "", "", "", localJSONObject.toString(), false);
              if (QLog.isColorLevel()) {
                QLog.d("Q.readinjoy.4tab", 2, "reportForVideoEntranceRedDotExposure has finished, r5: " + localJSONObject.toString());
              }
              i = bgmq.e();
              if (i != 1) {
                break;
              }
              ndn.a(null, "", "0X8009A22", "0X8009A22", 0, 0, "", "", "", obz.a((VideoInfo)localObject, i), false);
              return;
            }
          }
          catch (Exception paramrik)
          {
            paramrik.printStackTrace();
            return;
          }
          i = 1;
          continue;
          paramrik = "";
        }
      } while (i != 2);
      ndn.a(null, "", "0X80094FE", "0X80094FE", 0, 0, "", "", "", obz.a((VideoInfo)localObject, i), false);
      return;
    } while (!(paramrik instanceof VideoInfo.EntranceDownloadInfo));
    paramrik = (VideoInfo.EntranceDownloadInfo)paramrik;
    Object localObject = new qmv("", "", "", "");
    ((qmv)localObject).V(1).a(paramrik.jdField_c_of_type_JavaLangString).a(0);
    ndn.a(null, "", "0X80094FE", "0X80094FE", 0, 0, "", "", "", ((qmv)localObject).a().a(), false);
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
  
  public static void b(rik paramrik)
  {
    ThreadManager.excute(new VideoFeedsFirstVideoRecommendationManager.1(paramrik), 16, null, true);
  }
  
  private void c(rik paramrik)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(paramrik);
    }
    d(paramrik);
  }
  
  private void d(rik paramrik)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() == 0))
    {
      if (paramrik != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a(paramrik);
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
      localObject = bgmq.a(this.jdField_c_of_type_JavaLangString);
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().putString("VIDEO_VID", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString).putString("VIDEO_ARTICLE_ID", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString).putString("VIDEO_PUB_ACCOUNT_UIN", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.j).putString("VIDEO_PUB_ACCOUNT_NAME", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_k_of_type_JavaLangString).putString("VIDEO_THIRD_ACTION", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.D).putString("VIDEO_THIRD_ICON", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.E).putString("VIDEO_THIRD_NAME", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.F).putString("VIDEO_TITLE", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_JavaLangString).putString("VIDEO_SUMMARY", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_JavaLangString).putString("VIDEO_COVER", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_JavaLangString).putString("VIDEO_H5_URL", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.f).putString("VIDEO_URL", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.G).putInt("VIDEO_WIDTH", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int).putInt("VIDEO_HEIGHT", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int).putInt("VIDEO_TIME", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int).putInt("VIDEO_ARTICLE_BUSITYPE", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int).putInt("VIDEO_FEED_TYPE", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_k_of_type_Int).putLong("VIDEO_FEED_ID", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Long).putLong("VIDEO_XG_FILE_SIZE", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Long).putString("VIDEO_CREATE_TIME", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.e).putBoolean("key_is_use_gif", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_Boolean).putString("key_gif_url", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.H).putBoolean("key_is_show_cover", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.h).putBoolean("key_has_video_info", true).apply();
      }
    }
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("start save video info, uin: ").append(this.jdField_c_of_type_JavaLangString).append(", ");
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) {
        break label428;
      }
    }
    label428:
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
      localObject = bgmq.a(this.jdField_c_of_type_JavaLangString);
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
        break label266;
      }
    }
    label266:
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
      SharedPreferences localSharedPreferences = bgmq.a(this.jdField_c_of_type_JavaLangString);
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putString("key_icon_url", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo.jdField_a_of_type_JavaLangString).putString("key_small_icon_url", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo.jdField_b_of_type_JavaLangString).putBoolean("key_is_use_gif", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo.jdField_a_of_type_Boolean).putString("key_common_data", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo.jdField_c_of_type_JavaLangString).putInt("key_jump_type", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_Int).putString("key_jump_url", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_JavaLangString).putString("key_jump_bundle", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_b_of_type_JavaLangString).putString("key_jump_schema", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_c_of_type_JavaLangString).putBoolean("key_has_entrance_download_info", true).apply();
      }
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$EntranceDownloadInfo != null)
    {
      SharedPreferences localSharedPreferences = bgmq.a(this.jdField_c_of_type_JavaLangString);
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
    if ((this.jdField_a_of_type_Neu != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() == 0) && (!this.jdField_a_of_type_Boolean))
    {
      neu localneu = this.jdField_a_of_type_Neu;
      nev localnev = this.jdField_a_of_type_Nev;
      String str = this.jdField_b_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
      {
        bool = true;
        localneu.a(localnev, str, paramInt, bool);
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
    QQAppInterface localQQAppInterface = obz.a();
    if ((localQQAppInterface != null) && (this.jdField_a_of_type_Nev != null)) {
      localQQAppInterface.removeObserver(this.jdField_a_of_type_Nev);
    }
  }
  
  public void c()
  {
    b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = null;
    }
    this.jdField_a_of_type_Neu = null;
    ohb.a().b(this.jdField_a_of_type_Qbh);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a();
    }
    QQAppInterface localQQAppInterface = obz.a();
    if (localQQAppInterface != null)
    {
      this.jdField_a_of_type_Neu = ((neu)localQQAppInterface.a(90));
      localQQAppInterface.addObserver(this.jdField_a_of_type_Nev);
      this.jdField_c_of_type_JavaLangString = localQQAppInterface.getAccount();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = a();
      c(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "start change account");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qbe
 * JD-Core Version:    0.7.0.1
 */