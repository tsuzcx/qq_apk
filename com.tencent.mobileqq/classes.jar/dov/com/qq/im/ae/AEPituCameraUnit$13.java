package dov.com.qq.im.ae;

import afur;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.RelativeLayout.LayoutParams;
import aqbj;
import bndy;
import bndz;
import bnii;
import bnqb;
import bnvb;
import bnzb;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.view.AECompoundButton;
import dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout;

public class AEPituCameraUnit$13
  implements Runnable
{
  public AEPituCameraUnit$13(bndy parambndy) {}
  
  public void run()
  {
    bnzb.b("AEPituCameraUnit", "actionAfterFirstFrame--ui run--BEGIN");
    Object localObject = (ViewStub)bndy.b(this.this$0).findViewById(2131377952);
    if (localObject != null)
    {
      ((ViewStub)localObject).inflate();
      bnzb.b("AEPituCameraUnit", "AEPartAction--inflate bottom");
    }
    localObject = (ViewStub)bndy.b(this.this$0).findViewById(2131377954);
    if (localObject != null)
    {
      ((ViewStub)localObject).inflate();
      bnzb.b("AEPituCameraUnit", "AEPartAction--inflate captureMode");
    }
    bndy.a(this.this$0, (AEPituCameraCaptureButtonLayout)bndy.b(this.this$0).findViewById(2131364143));
    bndy.a(this.this$0).a(this.this$0, bndy.a(this.this$0), bndy.a(this.this$0));
    localObject = this.this$0.a().getIntent();
    bndy.a(this.this$0).setOriginIntent((Intent)localObject);
    localObject = (RelativeLayout.LayoutParams)bndy.a(this.this$0).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = afur.a(-30.0F, bndy.a(this.this$0).getResources());
    bndy.a(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (!bnqb.j(this.this$0.a().getIntent())) {
      bndy.a(this.this$0).b();
    }
    if (bndy.a(this.this$0))
    {
      bndy.a(this.this$0).k();
      this.this$0.o();
    }
    bndy.a(this.this$0).c();
    if (bndy.a(this.this$0).shouldStartCamera())
    {
      bndy.e(this.this$0);
      bndy.a(this.this$0).a();
    }
    bndy.a(this.this$0, (AECompoundButton)bndy.b(this.this$0).findViewById(2131365222));
    bndy.a(this.this$0).setOnClickListener(this.this$0);
    bndy.a(this.this$0).setSelected(false);
    bndy.a(this.this$0).setVisibility(8);
    if (bndy.b(this.this$0)) {
      bndy.a(this.this$0, bndy.b(this.this$0));
    }
    bndy.b(this.this$0, (AECompoundButton)bndy.b(this.this$0).findViewById(2131364298));
    bndy.b(this.this$0).setOnClickListener(this.this$0);
    bndy.b(this.this$0).setContentDescription(bndy.b(this.this$0).getResources().getString(2131717340));
    if (!aqbj.d())
    {
      bndy.b(this.this$0).setVisibility(4);
      bndy.b(this.this$0).setEnabled(false);
    }
    if (bndy.a(this.this$0))
    {
      bndy.a(this.this$0).b();
      bndy.a(this.this$0).i();
    }
    bndy.b(this.this$0).setOnTouchListener(this.this$0);
    if (bnqb.h(bndy.a(this.this$0))) {
      bndy.b(this.this$0).setOnClickListener(new bndz(this));
    }
    bndy.a(this.this$0, true);
    bnzb.b("AEPituCameraUnit", "actionAfterFirstFrame--ui run--END");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.13
 * JD-Core Version:    0.7.0.1
 */