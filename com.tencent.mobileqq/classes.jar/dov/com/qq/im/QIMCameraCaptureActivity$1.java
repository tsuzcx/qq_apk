package dov.com.qq.im;

import android.content.Intent;
import android.text.TextUtils;
import axrn;
import bizt;
import com.tencent.common.app.BaseApplicationImpl;
import vei;

class QIMCameraCaptureActivity$1
  implements Runnable
{
  QIMCameraCaptureActivity$1(QIMCameraCaptureActivity paramQIMCameraCaptureActivity, int paramInt) {}
  
  public void run()
  {
    boolean bool = true;
    axrn.a(BaseApplicationImpl.getContext()).a(null, "enter_story_capture_count", true, 0L, 0L, null, "");
    vei.a("video_shoot_new", "shoot_exp", vei.b(this.a), 0, new String[] { "", "", "", String.valueOf(this.this$0.getIntent().getIntExtra("entrance_type", 0)) });
    if (!TextUtils.isEmpty(this.this$0.getIntent().getStringExtra("KEY_ISENTER_SO_DOWNLOAD"))) {}
    for (;;)
    {
      bizt.a().a(bool);
      bizt.a().E();
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureActivity.1
 * JD-Core Version:    0.7.0.1
 */