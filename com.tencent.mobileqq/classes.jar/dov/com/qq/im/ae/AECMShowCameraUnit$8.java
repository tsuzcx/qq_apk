package dov.com.qq.im.ae;

import android.app.Activity;
import android.content.res.Resources;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import bmvk;
import dov.com.qq.im.ae.cmshow.AECMShowLoadingView;

public class AECMShowCameraUnit$8
  implements Runnable
{
  public AECMShowCameraUnit$8(bmvk parambmvk) {}
  
  public void run()
  {
    bmvk.b(this.this$0).setImageDrawable(this.this$0.a().getResources().getDrawable(2130837671));
    bmvk.a(this.this$0).setTag(Integer.valueOf(3));
    bmvk.a(this.this$0).setText(2131690861);
    bmvk.a(this.this$0).setClickable(true);
    bmvk.a(this.this$0).setTextColor(-16777216);
    Log.d(this.this$0.a, "switch2CameraUI: 设置为白色背景");
    bmvk.a(this.this$0).setBackgroundDrawable(this.this$0.a().getResources().getDrawable(2130837667));
    bmvk.a(this.this$0).setVisibility(0);
    bmvk.a(this.this$0).setTag(Integer.valueOf(5));
    bmvk.a(this.this$0).setImageDrawable(this.this$0.a().getResources().getDrawable(2130837665));
    bmvk.a(this.this$0).setClickable(true);
    bmvk.a(this.this$0).setVisibility(0);
    bmvk.a(this.this$0).setVisibility(8);
    bmvk.a(this.this$0).setText("");
    bmvk.a(this.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AECMShowCameraUnit.8
 * JD-Core Version:    0.7.0.1
 */