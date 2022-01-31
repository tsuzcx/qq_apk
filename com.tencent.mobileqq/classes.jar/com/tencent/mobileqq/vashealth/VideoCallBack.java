package com.tencent.mobileqq.vashealth;

import ahhl;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import baaf;
import basm;
import bbms;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import mqq.app.AppRuntime;
import mqq.app.BaseActivity;

public class VideoCallBack
  implements ahhl
{
  private String a;
  
  static void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("sv_encode_max_bitrate", -1);
    if (i > 0) {
      awje.r = i;
    }
    i = paramIntent.getIntExtra("sv_encode_min_bitrate", -1);
    if (i > 0) {
      awje.s = i;
    }
    i = paramIntent.getIntExtra("sv_encode_qmax", -1);
    if (i > 0) {
      awje.t = i;
    }
    i = paramIntent.getIntExtra("sv_encode_qmin", -1);
    if (i > 0) {
      awje.u = i;
    }
    i = paramIntent.getIntExtra("sv_encode_qmaxdiff", -1);
    if (i > 0) {
      awje.v = i;
    }
    i = paramIntent.getIntExtra("sv_encode_ref_frame", -1);
    if (i > 0) {
      awje.w = i;
    }
    i = paramIntent.getIntExtra("sv_encode_smooth", -1);
    if (i > 0) {
      awje.x = i;
    }
    awje.E = paramIntent.getIntExtra("sv_encode_totaltime_adjust", 0);
    awje.F = paramIntent.getIntExtra("sv_encode_timestamp_fix", 0);
    awje.G = paramIntent.getIntExtra("sv_encode_bless_audio_time_low", 0);
    awje.H = paramIntent.getIntExtra("sv_encode_bless_audio_time_high", 0);
    awje.I = paramIntent.getIntExtra("sv_encode_bless_audio_time_ratio", 65537);
    awje.z = paramIntent.getIntExtra("sv_total_frame_count", 0);
    awje.y = paramIntent.getIntExtra("sv_total_record_time", 0);
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, PhotoListActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 2);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    String str2 = ((BaseActivity)paramActivity).getAppRuntime().getAccount();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localIntent.putExtra("PhotoConst.MY_UIN", str1);
    localIntent.putExtra("health_video", true);
    localIntent.putExtras(paramActivity.getIntent().getExtras());
    paramActivity.startActivityForResult(localIntent, 4097);
    baaf.a(paramActivity, false, true);
  }
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((-1 == paramInt2) && (paramIntent != null))
    {
      paramActivity.setResult(1, paramIntent);
      paramActivity.finish();
    }
    while (!(paramActivity instanceof NewFlowCameraActivity)) {
      return;
    }
    ((NewFlowCameraActivity)paramActivity).A = true;
  }
  
  public void a(Activity paramActivity, Intent paramIntent)
  {
    if (paramActivity == null) {
      return;
    }
    String str = paramIntent.getStringExtra("file_video_source_dir");
    Object localObject = paramIntent.getStringExtra("thumbfile_send_path");
    bbms localbbms = new bbms(paramActivity);
    localObject = new basm(this, localbbms, (String)localObject, paramActivity);
    paramActivity.runOnUiThread(new VideoCallBack.2(this, localbbms));
    a(paramIntent);
    paramActivity = new EncodeThread(paramActivity, (Handler)localObject, str, null, null);
    paramActivity.a(false);
    ThreadManager.post(paramActivity, 5, null, false);
  }
  
  public void c_(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.VideoCallBack
 * JD-Core Version:    0.7.0.1
 */