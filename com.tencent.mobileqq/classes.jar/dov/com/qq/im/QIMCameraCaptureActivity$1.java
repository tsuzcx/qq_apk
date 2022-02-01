package dov.com.qq.im;

import android.content.Intent;
import android.text.TextUtils;
import bdmc;
import bozr;
import com.tencent.common.app.BaseApplicationImpl;
import yup;

class QIMCameraCaptureActivity$1
  implements Runnable
{
  QIMCameraCaptureActivity$1(QIMCameraCaptureActivity paramQIMCameraCaptureActivity, int paramInt) {}
  
  public void run()
  {
    boolean bool = true;
    bdmc.a(BaseApplicationImpl.getContext()).a(null, "enter_story_capture_count", true, 0L, 0L, null, "");
    yup.a("video_shoot_new", "shoot_exp", yup.b(this.a), 0, new String[] { "", "", "", String.valueOf(this.this$0.getIntent().getIntExtra("entrance_type", 0)) });
    if (!TextUtils.isEmpty(this.this$0.getIntent().getStringExtra("KEY_ISENTER_SO_DOWNLOAD"))) {}
    for (;;)
    {
      bozr.a().a(bool);
      bozr.a().Z();
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureActivity.1
 * JD-Core Version:    0.7.0.1
 */