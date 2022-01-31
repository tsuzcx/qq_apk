package dov.com.tencent.mobileqq.activity.shortvideo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import aork;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import mqq.os.MqqHandler;

public class SendVideoActivity
  extends BaseActivity
  implements Handler.Callback
{
  private static MqqWeakReferenceHandler a;
  
  public static void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("sv_encode_max_bitrate", -1);
    if (i > 0) {
      CodecParam.r = i;
    }
    i = paramIntent.getIntExtra("sv_encode_min_bitrate", -1);
    if (i > 0) {
      CodecParam.s = i;
    }
    i = paramIntent.getIntExtra("sv_encode_qmax", -1);
    if (i > 0) {
      CodecParam.t = i;
    }
    i = paramIntent.getIntExtra("sv_encode_qmin", -1);
    if (i > 0) {
      CodecParam.u = i;
    }
    i = paramIntent.getIntExtra("sv_encode_qmaxdiff", -1);
    if (i > 0) {
      CodecParam.v = i;
    }
    i = paramIntent.getIntExtra("sv_encode_ref_frame", -1);
    if (i > 0) {
      CodecParam.w = i;
    }
    i = paramIntent.getIntExtra("sv_encode_smooth", -1);
    if (i > 0) {
      CodecParam.x = i;
    }
    CodecParam.E = paramIntent.getIntExtra("sv_encode_totaltime_adjust", 0);
    CodecParam.F = paramIntent.getIntExtra("sv_encode_timestamp_fix", 0);
    CodecParam.G = paramIntent.getIntExtra("sv_encode_bless_audio_time_low", 0);
    CodecParam.H = paramIntent.getIntExtra("sv_encode_bless_audio_time_high", 0);
    CodecParam.I = paramIntent.getIntExtra("sv_encode_bless_audio_time_ratio", 65537);
    CodecParam.a(paramIntent.getBooleanExtra("sv_encode_baseline_mp4", false));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    int i = getIntent().getIntExtra("file_send_business_type", 0);
    if (QLog.isColorLevel()) {
      QLog.d("SendVideoActivity", 2, "doOnCreate(), ===>> busiType=" + i + ",VideoFileDir = " + getIntent().getStringExtra("file_video_source_dir"));
    }
    switch (i)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendVideoActivity", 2, "doOnCreate(), <<===");
      }
      return true;
      new SendVideoActivity.SendVideoTask(this, null).execute(new Void[0]);
      continue;
      paramBundle = getIntent().getStringExtra("activity_before_enter_send_video");
      if ((paramBundle != null) && (ShortVideoPreviewActivity.class.getName().equals(paramBundle)))
      {
        new SendVideoActivity.SendAppShortVideoTask(this).execute(new Void[0]);
      }
      else
      {
        ThreadManager.getSubThreadHandler().post(new aork(this, null));
        continue;
        paramBundle = getIntent().getStringExtra("uin");
        if (QLog.isColorLevel()) {
          QLog.d("SendVideoActivity", 2, "doOnCreate, uin= " + paramBundle);
        }
        if ((paramBundle != null) && (paramBundle.equals("0")))
        {
          int j = getIntent().getIntExtra("uintype", -1);
          if (j != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("SendVideoActivity", 2, "doOnCreate error, uinType= " + j + " busiType= " + i);
            }
            finish();
          }
          else
          {
            a = new MqqWeakReferenceHandler(this);
            a.sendEmptyMessageDelayed(1, 45000L);
          }
        }
        else
        {
          ThreadManager.getSubThreadHandler().post(new aork(this, null));
          continue;
          ThreadManager.getSubThreadHandler().post(new aork(this, null));
        }
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (a != null) {
      a.removeMessages(1);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.shortvideo.SendVideoActivity
 * JD-Core Version:    0.7.0.1
 */