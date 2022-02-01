package com.tencent.mobileqq.vashealth;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.richmedia.FlowComponentInterface;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import mqq.app.AppRuntime;
import mqq.app.BaseActivity;

public class VideoCallBack
  implements FlowComponentInterface
{
  private String a;
  
  static void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("sv_encode_max_bitrate", -1);
    if (i > 0) {
      com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.mMaxrate = i;
    }
    i = paramIntent.getIntExtra("sv_encode_min_bitrate", -1);
    if (i > 0) {
      com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.mMinrate = i;
    }
    i = paramIntent.getIntExtra("sv_encode_qmax", -1);
    if (i > 0) {
      com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.mQmax = i;
    }
    i = paramIntent.getIntExtra("sv_encode_qmin", -1);
    if (i > 0) {
      com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.mQmin = i;
    }
    i = paramIntent.getIntExtra("sv_encode_qmaxdiff", -1);
    if (i > 0) {
      com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.mMaxQdiff = i;
    }
    i = paramIntent.getIntExtra("sv_encode_ref_frame", -1);
    if (i > 0) {
      com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.mRefframe = i;
    }
    i = paramIntent.getIntExtra("sv_encode_smooth", -1);
    if (i > 0) {
      com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.mIsSmooth = i;
    }
    com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.mEnableTotalTimeAdjust = paramIntent.getIntExtra("sv_encode_totaltime_adjust", 0);
    com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.mEnableTimestampFix = paramIntent.getIntExtra("sv_encode_timestamp_fix", 0);
    com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.mAudioTimestampLow = paramIntent.getIntExtra("sv_encode_bless_audio_time_low", 0);
    com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.mAudioTimestampHigh = paramIntent.getIntExtra("sv_encode_bless_audio_time_high", 0);
    com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.mAudioTimeRatio = paramIntent.getIntExtra("sv_encode_bless_audio_time_ratio", 65537);
    com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.mRecordFrames = paramIntent.getIntExtra("sv_total_frame_count", 0);
    com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.mRecordTime = paramIntent.getIntExtra("sv_total_record_time", 0);
  }
  
  public String getRefer()
  {
    return this.a;
  }
  
  public void localVideoClick(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 2);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    String str2 = ((BaseActivity)paramActivity).getAppRuntime().getAccount();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localIntent.putExtra("PhotoConst.MY_UIN", str1);
    localIntent.putExtra("from_health", true);
    localIntent.putExtra("enter_from", 46);
    localIntent.putExtras(paramActivity.getIntent().getExtras());
    paramActivity.startActivityForResult(localIntent, 4097);
    AlbumUtil.anim(paramActivity, false, true);
  }
  
  public void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((-1 == paramInt2) && (paramIntent != null))
    {
      paramActivity.setResult(1, paramIntent);
      paramActivity.finish();
    }
    while (!(paramActivity instanceof NewFlowCameraActivity)) {
      return;
    }
    ((NewFlowCameraActivity)paramActivity).z = true;
  }
  
  public void sendClick(Activity paramActivity, Intent paramIntent)
  {
    if (paramActivity == null) {
      return;
    }
    String str = paramIntent.getStringExtra("file_video_source_dir");
    Object localObject = paramIntent.getStringExtra("thumbfile_send_path");
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(paramActivity);
    localObject = new VideoCallBack.1(this, localQQProgressDialog, (String)localObject, paramActivity);
    paramActivity.runOnUiThread(new VideoCallBack.2(this, localQQProgressDialog));
    a(paramIntent);
    paramActivity = new EncodeThread(paramActivity, (Handler)localObject, str, null, null);
    paramActivity.setEnableHardEncode(false);
    ThreadManager.post(paramActivity, 5, null, false);
  }
  
  public void setRefer(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.VideoCallBack
 * JD-Core Version:    0.7.0.1
 */