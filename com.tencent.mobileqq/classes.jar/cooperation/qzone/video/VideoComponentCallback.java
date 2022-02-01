package cooperation.qzone.video;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aelight.camera.struct.editor.FlowComponentInterface;
import com.tencent.biz.qqstory.takevideo.slideshow.QzoneSlideShowPhotoListManager;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class VideoComponentCallback
  implements FlowComponentInterface
{
  public static final int BUSINESS_TYPE = 1;
  public static final String KEY_QZONE_NICKNAME = "nickname";
  public static final String KEY_QZONE_UIN = "qzone_uin";
  public static final int REQUEST_VIDEO_TRIM = 1000;
  public static final String RESULT_FINISH_VIDEO_COMPONENT = "finish_video_component";
  public static final String SP_KEY_SUPPORT_TRIM = "support_trim";
  public static final String TAG = "cooperation.qzone.video.VideoComponentCallback";
  private String mRefer;
  
  public static void launchPublishMoodActivity(Activity paramActivity, int paramInt1, boolean paramBoolean, String paramString1, String paramString2, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt4, Bundle paramBundle, String paramString3, String paramString4, String paramString5)
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
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramString1, localIntent, -1);
  }
  
  private void sendToH5(int paramInt1, boolean paramBoolean1, String paramString1, String paramString2, int paramInt2, int paramInt3, long paramLong1, long paramLong2, Bundle paramBundle, String paramString3, String paramString4, boolean paramBoolean2, int paramInt4, int paramInt5, String paramString5, String paramString6, String paramString7)
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
  
  private void sendVideoMood(int paramInt1, boolean paramBoolean1, String paramString1, String paramString2, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt4, Bundle paramBundle, String paramString3, String paramString4, String paramString5, int paramInt5, String paramString6, ArrayList<String> paramArrayList, String paramString7, boolean paramBoolean2, int paramInt6, int paramInt7, String paramString8, String paramString9, String paramString10, boolean paramBoolean3, boolean paramBoolean4, int paramInt8, String paramString11, QzoneVerticalVideoTopicInfo paramQzoneVerticalVideoTopicInfo, boolean paramBoolean5, boolean paramBoolean6)
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
    paramString3.putParcelable("param.QzoneTopic", paramQzoneVerticalVideoTopicInfo);
    paramString3.putBoolean("param.isUploadOrigin", paramBoolean5);
    paramString3.putBoolean("param.fromAIO", paramBoolean6);
    if (paramQzoneVerticalVideoTopicInfo != null)
    {
      if (paramQzoneVerticalVideoTopicInfo.hasMusic()) {
        paramInt1 = 213;
      } else {
        paramInt1 = 214;
      }
    }
    else {
      paramInt1 = 200;
    }
    paramString3.putInt("param.uploadEntrance", paramInt1);
    paramString3.putInt("param.entranceSource", QzoneSlideShowPhotoListManager.a().d());
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
    RemoteHandleManager.getInstance().sendData("cmd.publishVideoMood", paramString3, false);
  }
  
  public String getRefer()
  {
    return this.mRefer;
  }
  
  public void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onActivityResult");
    }
    if (paramActivity == null) {
      return;
    }
    if (paramIntent == null) {
      return;
    }
    boolean bool = paramIntent.getBooleanExtra("finish_video_component", false);
    if (QLog.isColorLevel())
    {
      paramIntent = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doFinish=");
      localStringBuilder.append(bool);
      QLog.d(paramIntent, 1, localStringBuilder.toString());
    }
    if ((-1 == paramInt2) && (bool)) {
      paramActivity.finish();
    }
  }
  
  public void sendClick(Activity paramActivity, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "sendClick");
    }
    if (paramIntent == null) {
      return;
    }
    String str1 = paramIntent.getStringExtra("file_video_source_dir");
    String str2 = paramIntent.getStringExtra("thumbfile_send_path");
    int k = paramIntent.getIntExtra("thumbfile_send_width", -1);
    int m = paramIntent.getIntExtra("thumbfile_send_height", -1);
    int i = paramIntent.getIntExtra("sv_total_record_time", -1);
    int n = paramIntent.getIntExtra("sv_total_frame_count", -1);
    int i11 = paramIntent.getIntExtra("sv_encode_max_bitrate", -1);
    int i12 = paramIntent.getIntExtra("sv_encode_min_bitrate", -1);
    int i13 = paramIntent.getIntExtra("sv_encode_qmax", -1);
    int i14 = paramIntent.getIntExtra("sv_encode_qmin", -1);
    int i15 = paramIntent.getIntExtra("sv_encode_qmaxdiff", -1);
    int i1 = paramIntent.getIntExtra("sv_encode_ref_frame", -1);
    int i2 = paramIntent.getIntExtra("sv_encode_smooth", -1);
    String str3 = paramIntent.getStringExtra("video_topic_id");
    int j = paramIntent.getIntExtra("extra_key_font_id", -1);
    int i3 = paramIntent.getIntExtra("extra_key_font_format_type", -1);
    String str4 = paramIntent.getStringExtra("extra_key_font_url");
    int i4 = paramIntent.getIntExtra("extra_key_super_font_id", -1);
    String str5 = paramIntent.getStringExtra("extra_key_super_font_info");
    boolean bool1 = paramIntent.getBooleanExtra("video_topic_sync_qzone", false);
    String str6 = paramIntent.getStringExtra("video_new_fake_vid");
    boolean bool2 = paramIntent.getBooleanExtra("video_is_generate_gif", false);
    boolean bool3 = paramIntent.getBooleanExtra("video_mood_timer_delete", false);
    QzoneVerticalVideoTopicInfo localQzoneVerticalVideoTopicInfo = (QzoneVerticalVideoTopicInfo)paramIntent.getParcelableExtra("qzone_video_topic");
    boolean bool4 = paramIntent.getBooleanExtra("param.isUploadOrigin", false);
    boolean bool5 = paramIntent.getBooleanExtra("param.fromAIO", false);
    int i5 = paramIntent.getIntExtra("sv_encode_totaltime_adjust", 0);
    int i6 = paramIntent.getIntExtra("sv_encode_timestamp_fix", 0);
    int i7 = paramIntent.getIntExtra("sv_encode_bless_audio_time_low", 0);
    int i8 = paramIntent.getIntExtra("sv_encode_bless_audio_time_high", 0);
    int i9 = paramIntent.getIntExtra("sv_encode_bless_audio_time_ratio", 65537);
    int i10 = paramIntent.getIntExtra("video_mood_priv", -1);
    Object localObject2 = paramIntent.getStringExtra("video_mood_content");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("video_mood_privUinList");
    boolean bool6 = paramIntent.getBooleanExtra("enable_edit_video", false);
    localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("sv_encode_max_bitrate", i11);
    ((Bundle)localObject2).putInt("sv_encode_min_bitrate", i12);
    ((Bundle)localObject2).putInt("sv_encode_qmax", i13);
    ((Bundle)localObject2).putInt("sv_encode_qmin", i14);
    ((Bundle)localObject2).putInt("sv_encode_qmaxdiff", i15);
    ((Bundle)localObject2).putInt("sv_total_frame_count", n);
    ((Bundle)localObject2).putInt("sv_total_record_time", i);
    ((Bundle)localObject2).putInt("sv_encode_totaltime_adjust", i5);
    ((Bundle)localObject2).putInt("sv_encode_timestamp_fix", i6);
    ((Bundle)localObject2).putInt("sv_encode_bless_audio_time_low", i7);
    ((Bundle)localObject2).putInt("sv_encode_bless_audio_time_high", i8);
    ((Bundle)localObject2).putInt("sv_encode_bless_audio_time_ratio", i9);
    if ("cover_mall_record_video".equals(getRefer()))
    {
      j = i;
      if (i < 0) {
        j = paramIntent.getIntExtra("file_send_duration", -1);
      }
      paramIntent = TAG;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("videoCover,record video open video preview activity.totalDuration=");
      ((StringBuilder)localObject1).append(j);
      QLog.i(paramIntent, 2, ((StringBuilder)localObject1).toString());
      ((Bundle)localObject2).putInt("sv_encode_ref_frame", i1);
      ((Bundle)localObject2).putInt("sv_encode_smooth", i2);
      l = j * 1000;
      QZoneHelper.launchVideoCoverPreviewActivity(paramActivity, 0, null, true, str1, str2, k, m, l, 0L, l, 0L, n, (Bundle)localObject2, "", "", getRefer(), "CustomVideoCover");
      return;
    }
    if ("ref_h5_record_video".equals(getRefer()))
    {
      sendToH5(0, true, str1, str2, k, m, i, 0L, (Bundle)localObject2, (String)localObject1, str3, bool1, j, i3, str4, str6, null);
      return;
    }
    if (bool6)
    {
      paramIntent = paramIntent.getStringExtra("forward_source_to_qzone");
      paramActivity = paramIntent;
      if ("source_from_quick_shoot".equals(paramIntent)) {
        paramActivity = "value.sourceFromQqQuickShoot";
      }
      l = i * 1000;
      sendVideoMood(0, true, str1, str2, k, m, l, 0L, l, 0L, n, (Bundle)localObject2, "", "", "", i10, (String)localObject1, localArrayList, str3, bool1, j, i3, str4, str6, paramActivity, bool2, bool3, i4, str5, localQzoneVerticalVideoTopicInfo, bool4, bool5);
      return;
    }
    long l = i;
    launchPublishMoodActivity(paramActivity, 0, true, str1, str2, k, m, l, 0L, l, 0L, n, (Bundle)localObject2, "", "", "");
  }
  
  public void setRefer(String paramString)
  {
    this.mRefer = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.video.VideoComponentCallback
 * JD-Core Version:    0.7.0.1
 */