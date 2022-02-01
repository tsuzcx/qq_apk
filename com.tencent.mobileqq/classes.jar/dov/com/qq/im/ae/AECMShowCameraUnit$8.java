package dov.com.qq.im.ae;

import android.app.Activity;
import android.content.res.Resources;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import dov.com.qq.im.ae.cmshow.AECMShowLoadingView;

class AECMShowCameraUnit$8
  implements Runnable
{
  AECMShowCameraUnit$8(AECMShowCameraUnit paramAECMShowCameraUnit) {}
  
  public void run()
  {
    AECMShowCameraUnit.b(this.this$0).setImageDrawable(this.this$0.a().getResources().getDrawable(2130837675));
    AECMShowCameraUnit.a(this.this$0).setTag(Integer.valueOf(3));
    AECMShowCameraUnit.a(this.this$0).setText(2131690962);
    AECMShowCameraUnit.a(this.this$0).setClickable(true);
    AECMShowCameraUnit.a(this.this$0).setTextColor(-16777216);
    Log.d(this.this$0.b, "switch2CameraUI: 设置为白色背景");
    AECMShowCameraUnit.a(this.this$0).setBackgroundDrawable(this.this$0.a().getResources().getDrawable(2130837671));
    AECMShowCameraUnit.a(this.this$0).setVisibility(0);
    AECMShowCameraUnit.a(this.this$0).setTag(Integer.valueOf(5));
    AECMShowCameraUnit.a(this.this$0).setImageDrawable(this.this$0.a().getResources().getDrawable(2130837669));
    AECMShowCameraUnit.a(this.this$0).setClickable(true);
    AECMShowCameraUnit.a(this.this$0).setVisibility(0);
    AECMShowCameraUnit.a(this.this$0).setVisibility(8);
    AECMShowCameraUnit.a(this.this$0).setText("");
    AECMShowCameraUnit.a(this.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AECMShowCameraUnit.8
 * JD-Core Version:    0.7.0.1
 */