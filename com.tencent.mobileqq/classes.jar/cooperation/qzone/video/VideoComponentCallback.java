package cooperation.qzone.video;

import alip;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import blsb;
import blsi;
import bmfd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QzonePluginProxyActivity;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import zfy;
import zgl;

public class VideoComponentCallback
  implements alip
{
  public static final String a = VideoComponentCallback.class.getName();
  private String b;
  
  private void a(int paramInt1, boolean paramBoolean1, String paramString1, String paramString2, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt4, Bundle paramBundle, String paramString3, String paramString4, String paramString5, int paramInt5, String paramString6, ArrayList<String> paramArrayList, String paramString7, boolean paramBoolean2, int paramInt6, int paramInt7, String paramString8, String paramString9, String paramString10, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt8, String paramString11, QzoneVerticalVideoTopicInfo paramQzoneVerticalVideoTopicInfo, boolean paramBoolean6, boolean paramBoolean7)
  {
    paramString3 = new Bundle();
    paramString3.putString("param.content", paramString6);
    paramString3.putInt("param.priv", paramInt5);
    paramString3.putStringArrayList("param.privList", paramArrayList);
    paramString3.putString("param.videoPath", paramString1);
    paramString3.putLong("param.videoSize", paramLong4);
    paramString3.putInt("param.videoType", paramInt1);
    paramString3.putString("param.thumbnailPath", paramString2);
    paramString3.putInt("param.thumbnailHeight", paramInt3);
    paramString3.putInt("param.thumbnailWidth", paramInt2);
    paramString3.putLong("param.startTime", paramLong2);
    paramString3.putLong("param.duration", paramLong1);
    paramString3.putLong("param.totalDuration", paramLong1);
    paramString3.putBoolean("param.needProcess", paramBoolean1);
    paramString3.putBundle("param.extras", paramBundle);
    paramString3.putString("param.topicId", paramString7);
    paramString3.putBoolean("param.topicSyncQzone", paramBoolean2);
    paramString3.putString("param.newFakeVid", paramString9);
    paramString3.putString("param.source", paramString10);
    paramString3.putBoolean("param.isGenerateGif", paramBoolean3);
    paramString3.putBoolean("param.isTimerDelete", paramBoolean4);
    paramString3.putBoolean("param.isSyncToQQStory", paramBoolean5);
    paramString3.putParcelable("param.QzoneTopic", paramQzoneVerticalVideoTopicInfo);
    paramString3.putBoolean("param.isUploadOrigin", paramBoolean6);
    paramString3.putBoolean("param.fromAIO", paramBoolean7);
    paramInt1 = 200;
    if (paramQzoneVerticalVideoTopicInfo != null) {
      if (!paramQzoneVerticalVideoTopicInfo.a()) {
        break label332;
      }
    }
    label332:
    for (paramInt1 = 213;; paramInt1 = 214)
    {
      paramString3.putInt("param.uploadEntrance", paramInt1);
      paramString3.putInt("param.entranceSource", zfy.a().a());
      if (paramInt6 >= 0)
      {
        paramString3.putInt("extra_key_font_id", paramInt6);
        paramString3.putInt("extra_key_font_format_type", paramInt7);
        paramString3.putString("extra_key_font_url", paramString8);
      }
      if (paramInt8 >= 0)
      {
        paramString3.putInt("extra_key_super_font_id", paramInt8);
        paramString3.putString("extra_key_super_font_info", paramString11);
      }
      bmfd.a().a("cmd.publishVideoMood", paramString3, false);
      return;
    }
  }
  
  private void a(int paramInt1, boolean paramBoolean1, String paramString1, String paramString2, int paramInt2, int paramInt3, long paramLong1, long paramLong2, Bundle paramBundle, String paramString3, String paramString4, boolean paramBoolean2, int paramInt4, int paramInt5, String paramString5, String paramString6, String paramString7)
  {
    Intent localIntent = new Intent("com.qzone.h5.video.recordCallback");
    localIntent.putExtra("param.content", paramString3);
    localIntent.putExtra("param.videoPath", paramString1);
    localIntent.putExtra("param.videoSize", paramLong2);
    localIntent.putExtra("param.videoType", paramInt1);
    localIntent.putExtra("param.thumbnailPath", paramString2);
    localIntent.putExtra("param.thumbnailHeight", paramInt3);
    localIntent.putExtra("param.thumbnailWidth", paramInt2);
    localIntent.putExtra("param.duration", paramLong1);
    localIntent.putExtra("param.totalDuration", paramLong1);
    localIntent.putExtra("param.needProcess", paramBoolean1);
    localIntent.putExtra("param.extras", paramBundle);
    localIntent.putExtra("param.topicId", paramString4);
    localIntent.putExtra("param.topicSyncQzone", paramBoolean2);
    localIntent.putExtra("param.newFakeVid", paramString6);
    localIntent.putExtra("param.source", paramString7);
    if (paramInt4 >= 0)
    {
      localIntent.putExtra("extra_key_font_id", paramInt4);
      localIntent.putExtra("extra_key_font_format_type", paramInt5);
      localIntent.putExtra("extra_key_font_url", paramString5);
    }
    BaseApplication.getContext().sendBroadcast(localIntent);
  }
  
  public static void a(Activity paramActivity, int paramInt1, boolean paramBoolean, String paramString1, String paramString2, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt4, Bundle paramBundle, String paramString3, String paramString4, String paramString5)
  {
    Intent localIntent = new Intent("com.tencent.mobileqq.action.publishmood");
    localIntent.putExtra("qzone_plugin_activity_name", "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
    localIntent.putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
    localIntent.putExtra("PhotoConst.VIDEO_TYPE", paramInt1);
    localIntent.putExtra("file_send_path", paramString1);
    localIntent.putExtra("thumbnail_path", paramString2);
    localIntent.putExtra("thumbnail_height", paramInt3);
    localIntent.putExtra("thumbnail_width", paramInt2);
    localIntent.putExtra("need_process", paramBoolean);
    localIntent.putExtra("start_time", paramLong2);
    localIntent.putExtra("total_duration", paramLong1);
    localIntent.putExtra("file_send_duration", paramLong3 - paramLong2);
    localIntent.putExtra("sv_total_frame_count", paramInt4);
    localIntent.putExtra("PhotoConst.VIDEO_SIZE", paramLong4);
    localIntent.putExtra("encode_video_params", paramBundle);
    localIntent.putExtra("defaultText", paramString3);
    if (!TextUtils.isEmpty(paramString4)) {
      localIntent.putExtra("refer", paramString4);
    }
    if (!TextUtils.isEmpty(paramString5)) {
      localIntent.putExtra("video_refer", paramString5);
    }
    localIntent.addFlags(603979776);
    paramString1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    QzonePluginProxyActivity.a(localIntent, "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
    QzonePluginProxyActivity.a(paramActivity, paramString1, localIntent, -1);
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "localVideoClick");
    }
    if (paramActivity == null) {
      return;
    }
    try
    {
      boolean bool = LocalMultiProcConfig.getBool("support_trim", false);
      localObject = blsi.a();
      ((blsi)localObject).a = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      if (!bool) {
        break label296;
      }
      if ("cover_mall_record_video".equals(a()))
      {
        blsb.a(paramActivity, (blsi)localObject, "", 0L, 1000, 2, "", a());
        return;
      }
    }
    catch (Exception paramActivity)
    {
      QLog.w(a, 4, "", paramActivity);
      return;
    }
    Intent localIntent = new Intent(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 2);
    localIntent.putExtra("qzone_uin", ((blsi)localObject).a);
    localIntent.putExtra("nickname", ((blsi)localObject).b);
    Object localObject = QzoneConfig.getInstance().getConfig("MiniVideo", "FileSizeLimit");
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (long l = 1048576000L;; l = Long.valueOf((String)localObject).longValue())
    {
      localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", l);
      localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", QzoneConfig.getInstance().getConfig("MiniVideo", "VideoDurationThreshold", 90000));
      localIntent.putExtra("video_refer", a());
      localIntent.putExtra("PhotoConst.IS_PREVIEW_VIDEO", false);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_CAN_UPLOAD_DURATION", blsb.a());
      paramActivity.startActivity(localIntent);
      return;
    }
    label296:
    if ("cover_mall_record_video".equals(a()))
    {
      int i = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298998);
      localObject = paramActivity.getString(2131716807);
      QQToast.a(paramActivity, (CharSequence)localObject, 0).b(i);
      QLog.i(a, 2, "video cover,not support trim," + (String)localObject);
      return;
    }
    localIntent = new Intent("com.tencent.mobileqq.action.publishmood");
    localIntent.putExtra("qzone_plugin_activity_name", "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
    localIntent.putExtra("key_is_upload_video", true);
    localIntent.putExtra("key_need_load_photo_from_intent", false);
    localIntent.putExtra("key_trim_video_black_list", true);
    localIntent.putExtra("uin", ((blsi)localObject).a);
    blsb.b(paramActivity, (blsi)localObject, localIntent, 1000);
  }
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "onActivityResult");
    }
    if (paramActivity == null) {}
    boolean bool;
    do
    {
      do
      {
        return;
      } while (paramIntent == null);
      bool = paramIntent.getBooleanExtra("finish_video_component", false);
      if (QLog.isColorLevel()) {
        QLog.d(a, 1, "doFinish=" + bool);
      }
    } while ((-1 != paramInt2) || (!bool));
    paramActivity.finish();
  }
  
  public void a(Activity paramActivity, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "sendClick");
    }
    if (paramIntent == null) {
      return;
    }
    String str1 = paramIntent.getStringExtra("file_video_source_dir");
    String str2 = paramIntent.getStringExtra("thumbfile_send_path");
    int k = paramIntent.getIntExtra("thumbfile_send_width", -1);
    int m = paramIntent.getIntExtra("thumbfile_send_height", -1);
    int j = paramIntent.getIntExtra("sv_total_record_time", -1);
    int n = paramIntent.getIntExtra("sv_total_frame_count", -1);
    int i = paramIntent.getIntExtra("sv_encode_max_bitrate", -1);
    int i3 = paramIntent.getIntExtra("sv_encode_min_bitrate", -1);
    int i4 = paramIntent.getIntExtra("sv_encode_qmax", -1);
    int i5 = paramIntent.getIntExtra("sv_encode_qmin", -1);
    int i6 = paramIntent.getIntExtra("sv_encode_qmaxdiff", -1);
    int i1 = paramIntent.getIntExtra("sv_encode_ref_frame", -1);
    int i2 = paramIntent.getIntExtra("sv_encode_smooth", -1);
    String str3 = paramIntent.getStringExtra("video_topic_id");
    int i7 = paramIntent.getIntExtra("extra_key_font_id", -1);
    int i8 = paramIntent.getIntExtra("extra_key_font_format_type", -1);
    String str4 = paramIntent.getStringExtra("extra_key_font_url");
    int i9 = paramIntent.getIntExtra("extra_key_super_font_id", -1);
    String str5 = paramIntent.getStringExtra("extra_key_super_font_info");
    boolean bool1 = paramIntent.getBooleanExtra("video_topic_sync_qzone", false);
    String str6 = paramIntent.getStringExtra("video_new_fake_vid");
    boolean bool2 = paramIntent.getBooleanExtra("video_is_generate_gif", false);
    boolean bool3 = paramIntent.getBooleanExtra("video_mood_timer_delete", false);
    boolean bool4 = paramIntent.getBooleanExtra("qzone_video_sync_to_qqstory", false);
    QzoneVerticalVideoTopicInfo localQzoneVerticalVideoTopicInfo = (QzoneVerticalVideoTopicInfo)paramIntent.getParcelableExtra("qzone_video_topic");
    boolean bool5 = paramIntent.getBooleanExtra("param.isUploadOrigin", false);
    boolean bool6 = paramIntent.getBooleanExtra("param.fromAIO", false);
    int i10 = paramIntent.getIntExtra("sv_encode_totaltime_adjust", 0);
    int i11 = paramIntent.getIntExtra("sv_encode_timestamp_fix", 0);
    int i12 = paramIntent.getIntExtra("sv_encode_bless_audio_time_low", 0);
    int i13 = paramIntent.getIntExtra("sv_encode_bless_audio_time_high", 0);
    int i14 = paramIntent.getIntExtra("sv_encode_bless_audio_time_ratio", 65537);
    int i15 = paramIntent.getIntExtra("video_mood_priv", -1);
    Object localObject2 = paramIntent.getStringExtra("video_mood_content");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = paramIntent.getStringArrayListExtra("video_mood_privUinList");
    boolean bool7 = paramIntent.getBooleanExtra("enable_edit_video", false);
    Bundle localBundle = new Bundle();
    localBundle.putInt("sv_encode_max_bitrate", i);
    localBundle.putInt("sv_encode_min_bitrate", i3);
    localBundle.putInt("sv_encode_qmax", i4);
    localBundle.putInt("sv_encode_qmin", i5);
    localBundle.putInt("sv_encode_qmaxdiff", i6);
    localBundle.putInt("sv_total_frame_count", n);
    localBundle.putInt("sv_total_record_time", j);
    localBundle.putInt("sv_encode_totaltime_adjust", i10);
    localBundle.putInt("sv_encode_timestamp_fix", i11);
    localBundle.putInt("sv_encode_bless_audio_time_low", i12);
    localBundle.putInt("sv_encode_bless_audio_time_high", i13);
    localBundle.putInt("sv_encode_bless_audio_time_ratio", i14);
    if ("cover_mall_record_video".equals(a()))
    {
      i = j;
      if (j < 0) {
        i = paramIntent.getIntExtra("file_send_duration", -1);
      }
      QLog.i(a, 2, "videoCover,record video open video preview activity.totalDuration=" + i);
      localBundle.putInt("sv_encode_ref_frame", i1);
      localBundle.putInt("sv_encode_smooth", i2);
      blsb.a(paramActivity, 0, null, true, str1, str2, k, m, i * 1000, 0L, i * 1000, 0L, n, localBundle, "", "", a(), "CustomVideoCover");
      return;
    }
    if ("ref_h5_record_video".equals(a()))
    {
      a(0, true, str1, str2, k, m, j, 0L, localBundle, (String)localObject1, str3, bool1, i7, i8, str4, str6, null);
      return;
    }
    if (bool7)
    {
      paramIntent = paramIntent.getStringExtra("forward_source_to_qzone");
      paramActivity = paramIntent;
      if ("source_from_quick_shoot".equals(paramIntent)) {
        paramActivity = "value.sourceFromQqQuickShoot";
      }
      a(0, true, str1, str2, k, m, j * 1000, 0L, j * 1000, 0L, n, localBundle, "", "", "", i15, (String)localObject1, (ArrayList)localObject2, str3, bool1, i7, i8, str4, str6, paramActivity, bool2, bool3, bool4, i9, str5, localQzoneVerticalVideoTopicInfo, bool5, bool6);
      return;
    }
    a(paramActivity, 0, true, str1, str2, k, m, j, 0L, j, 0L, n, localBundle, "", "", "");
  }
  
  public void c_(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.video.VideoComponentCallback
 * JD-Core Version:    0.7.0.1
 */