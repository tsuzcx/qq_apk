package dov.com.qq.im.ae;

import agej;
import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.RelativeLayout.LayoutParams;
import aqql;
import bofh;
import bofi;
import bojq;
import born;
import bown;
import bpam;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.view.AECompoundButton;
import dov.com.qq.im.ae.view.AEPituCameraCaptureButtonLayout;

public class AEPituCameraUnit$13
  implements Runnable
{
  public AEPituCameraUnit$13(bofh parambofh) {}
  
  public void run()
  {
    bpam.b("AEPituCameraUnit", "actionAfterFirstFrame--ui run--BEGIN");
    Object localObject = (ViewStub)bofh.b(this.this$0).findViewById(2131378107);
    if (localObject != null)
    {
      ((ViewStub)localObject).inflate();
      bpam.b("AEPituCameraUnit", "AEPartAction--inflate bottom");
    }
    localObject = (ViewStub)bofh.b(this.this$0).findViewById(2131378109);
    if (localObject != null)
    {
      ((ViewStub)localObject).inflate();
      bpam.b("AEPituCameraUnit", "AEPartAction--inflate captureMode");
    }
    bofh.a(this.this$0, (AEPituCameraCaptureButtonLayout)bofh.b(this.this$0).findViewById(2131364184));
    bofh.a(this.this$0).a(this.this$0, bofh.a(this.this$0), bofh.a(this.this$0));
    this.this$0.a().getIntent();
    if (!born.j(this.this$0.a().getIntent()))
    {
      localObject = (RelativeLayout.LayoutParams)bofh.a(this.this$0).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = agej.a(-30.0F, bofh.a(this.this$0).getResources());
      bofh.a(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
      bofh.a(this.this$0).d();
    }
    if (bofh.a(this.this$0))
    {
      bofh.a(this.this$0).k();
      this.this$0.o();
    }
    bofh.a(this.this$0).c();
    if (bofh.a(this.this$0).shouldStartCamera())
    {
      bofh.e(this.this$0);
      bofh.a(this.this$0).a();
    }
    bofh.a(this.this$0, (AECompoundButton)bofh.b(this.this$0).findViewById(2131365266));
    bofh.a(this.this$0).setOnClickListener(this.this$0);
    bofh.a(this.this$0).setSelected(false);
    bofh.a(this.this$0).setVisibility(8);
    if (bofh.b(this.this$0)) {
      bofh.a(this.this$0, bofh.b(this.this$0));
    }
    bofh.b(this.this$0, (AECompoundButton)bofh.b(this.this$0).findViewById(2131364342));
    bofh.b(this.this$0).setOnClickListener(this.this$0);
    bofh.b(this.this$0).setContentDescription(bofh.b(this.this$0).getResources().getString(2131717468));
    if (!aqql.d())
    {
      bofh.b(this.this$0).setVisibility(4);
      bofh.b(this.this$0).setEnabled(false);
    }
    if (bofh.a(this.this$0))
    {
      bofh.a(this.this$0).b();
      bofh.a(this.this$0).i();
    }
    bofh.b(this.this$0).setOnTouchListener(this.this$0);
    if (born.h(bofh.a(this.this$0))) {
      bofh.b(this.this$0).setOnClickListener(new bofi(this));
    }
    bofh.a(this.this$0, true);
    bpam.b("AEPituCameraUnit", "actionAfterFirstFrame--ui run--END");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.13
 * JD-Core Version:    0.7.0.1
 */