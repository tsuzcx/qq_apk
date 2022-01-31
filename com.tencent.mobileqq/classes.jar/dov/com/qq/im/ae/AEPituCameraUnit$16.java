package dov.com.qq.im.ae;

import aekt;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import anwv;
import bkle;
import bklh;
import bkpa;
import bkwm;
import blbm;
import blfg;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout;

public class AEPituCameraUnit$16
  implements Runnable
{
  public AEPituCameraUnit$16(bkle parambkle) {}
  
  public void run()
  {
    blfg.b("AEPituCameraUnit", "actionAfterFirstFrame--ui run--BEGIN");
    Object localObject = (ViewStub)bkle.a(this.this$0).findViewById(2131377091);
    if (localObject != null)
    {
      ((ViewStub)localObject).inflate();
      blfg.b("AEPituCameraUnit", "AEPartAction--inflate bottom");
    }
    localObject = (ViewStub)bkle.a(this.this$0).findViewById(2131377093);
    if (localObject != null)
    {
      ((ViewStub)localObject).inflate();
      blfg.b("AEPituCameraUnit", "AEPartAction--inflate captureMode");
    }
    bkle.a(this.this$0, (AEPituCameraCaptureButtonLayout)bkle.a(this.this$0).findViewById(2131363938));
    bkle.a(this.this$0).a(this.this$0, bkle.a(this.this$0), bkle.a(this.this$0));
    localObject = this.this$0.a().getIntent();
    bkle.a(this.this$0).setOriginIntent((Intent)localObject);
    localObject = (RelativeLayout.LayoutParams)bkle.a(this.this$0).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = aekt.a(-30.0F, bkle.a(this.this$0).getResources());
    bkle.a(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
    bkle.a(this.this$0).b();
    if (bkle.a(this.this$0))
    {
      bkle.a(this.this$0).l();
      this.this$0.q();
    }
    bkle.a(this.this$0).c();
    if (bkle.a(this.this$0).shouldStartCamera())
    {
      bkle.g(this.this$0);
      bkle.a(this.this$0).a();
    }
    bkle.a(this.this$0, (Button)bkle.a(this.this$0).findViewById(2131364984));
    bkle.a(this.this$0).setOnClickListener(this.this$0);
    bkle.a(this.this$0).setSelected(false);
    bkle.a(this.this$0).setVisibility(8);
    if (bkle.b(this.this$0)) {
      bkle.a(this.this$0, bkle.b(this.this$0));
    }
    bkle.b(this.this$0, (Button)bkle.a(this.this$0).findViewById(2131364090));
    bkle.b(this.this$0).setOnClickListener(this.this$0);
    bkle.b(this.this$0).setContentDescription(bkle.b(this.this$0).getResources().getString(2131719251));
    if (!anwv.d())
    {
      bkle.b(this.this$0).setVisibility(4);
      bkle.b(this.this$0).setEnabled(false);
    }
    if (bkle.a(this.this$0))
    {
      bkle.a(this.this$0).b();
      bkle.a(this.this$0).i();
    }
    bkle.a(this.this$0).setOnTouchListener(this.this$0);
    if (bkle.a(this.this$0) == bkwm.x.a()) {
      bkle.a(this.this$0).setOnClickListener(new bklh(this));
    }
    bkle.a(this.this$0, true);
    blfg.b("AEPituCameraUnit", "actionAfterFirstFrame--ui run--END");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.16
 * JD-Core Version:    0.7.0.1
 */