package dov.com.qq.im.ae;

import aepi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import aobe;
import bkpl;
import bkpo;
import bkth;
import blat;
import blft;
import bljn;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout;

public class AEPituCameraUnit$16
  implements Runnable
{
  public AEPituCameraUnit$16(bkpl parambkpl) {}
  
  public void run()
  {
    bljn.b("AEPituCameraUnit", "actionAfterFirstFrame--ui run--BEGIN");
    Object localObject = (ViewStub)bkpl.a(this.this$0).findViewById(2131377145);
    if (localObject != null)
    {
      ((ViewStub)localObject).inflate();
      bljn.b("AEPituCameraUnit", "AEPartAction--inflate bottom");
    }
    localObject = (ViewStub)bkpl.a(this.this$0).findViewById(2131377147);
    if (localObject != null)
    {
      ((ViewStub)localObject).inflate();
      bljn.b("AEPituCameraUnit", "AEPartAction--inflate captureMode");
    }
    bkpl.a(this.this$0, (AEPituCameraCaptureButtonLayout)bkpl.a(this.this$0).findViewById(2131363940));
    bkpl.a(this.this$0).a(this.this$0, bkpl.a(this.this$0), bkpl.a(this.this$0));
    localObject = this.this$0.a().getIntent();
    bkpl.a(this.this$0).setOriginIntent((Intent)localObject);
    localObject = (RelativeLayout.LayoutParams)bkpl.a(this.this$0).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = aepi.a(-30.0F, bkpl.a(this.this$0).getResources());
    bkpl.a(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
    bkpl.a(this.this$0).b();
    if (bkpl.a(this.this$0))
    {
      bkpl.a(this.this$0).l();
      this.this$0.q();
    }
    bkpl.a(this.this$0).c();
    if (bkpl.a(this.this$0).shouldStartCamera())
    {
      bkpl.g(this.this$0);
      bkpl.a(this.this$0).a();
    }
    bkpl.a(this.this$0, (Button)bkpl.a(this.this$0).findViewById(2131364986));
    bkpl.a(this.this$0).setOnClickListener(this.this$0);
    bkpl.a(this.this$0).setSelected(false);
    bkpl.a(this.this$0).setVisibility(8);
    if (bkpl.b(this.this$0)) {
      bkpl.a(this.this$0, bkpl.b(this.this$0));
    }
    bkpl.b(this.this$0, (Button)bkpl.a(this.this$0).findViewById(2131364092));
    bkpl.b(this.this$0).setOnClickListener(this.this$0);
    bkpl.b(this.this$0).setContentDescription(bkpl.b(this.this$0).getResources().getString(2131719263));
    if (!aobe.d())
    {
      bkpl.b(this.this$0).setVisibility(4);
      bkpl.b(this.this$0).setEnabled(false);
    }
    if (bkpl.a(this.this$0))
    {
      bkpl.a(this.this$0).b();
      bkpl.a(this.this$0).i();
    }
    bkpl.a(this.this$0).setOnTouchListener(this.this$0);
    if (blat.h(bkpl.a(this.this$0))) {
      bkpl.a(this.this$0).setOnClickListener(new bkpo(this));
    }
    bkpl.a(this.this$0, true);
    bljn.b("AEPituCameraUnit", "actionAfterFirstFrame--ui run--END");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.16
 * JD-Core Version:    0.7.0.1
 */