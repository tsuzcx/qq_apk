package dov.com.qq.im.ae;

import actj;
import amfv;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import bijd;
import bikl;
import biws;
import dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout;

public class AEPituCameraUnit$17
  implements Runnable
{
  public AEPituCameraUnit$17(bijd parambijd) {}
  
  public void run()
  {
    bijd.a(this.this$0, (AEPituCameraCaptureButtonLayout)bijd.a(this.this$0).findViewById(2131363880));
    bijd.a(this.this$0).a(this.this$0, bijd.a(this.this$0), bijd.a(this.this$0));
    Object localObject = this.this$0.a().getIntent();
    bijd.a(this.this$0).setOriginIntent((Intent)localObject);
    localObject = (RelativeLayout.LayoutParams)bijd.a(this.this$0).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = actj.a(-30.0F, bijd.a(this.this$0).getResources());
    bijd.a(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
    bijd.a(this.this$0).b();
    if (bijd.a(this.this$0))
    {
      bijd.a(this.this$0).l();
      this.this$0.q();
    }
    bijd.a(this.this$0).c();
    bijd.a(this.this$0).a();
    bijd.a(this.this$0, (Button)bijd.a(this.this$0).findViewById(2131364897));
    bijd.a(this.this$0).setOnClickListener(this.this$0);
    bijd.a(this.this$0).setSelected(false);
    bijd.a(this.this$0).setVisibility(8);
    if (bijd.b(this.this$0)) {
      bijd.a(this.this$0, bijd.b(this.this$0));
    }
    bijd.b(this.this$0, (Button)bijd.a(this.this$0).findViewById(2131364029));
    bijd.b(this.this$0).setOnClickListener(this.this$0);
    bijd.b(this.this$0).setContentDescription(bijd.b(this.this$0).getResources().getString(2131718778));
    if (!amfv.d())
    {
      bijd.b(this.this$0).setVisibility(4);
      bijd.b(this.this$0).setEnabled(false);
    }
    if (bijd.a(this.this$0))
    {
      bijd.a(this.this$0).d();
      bijd.a(this.this$0).i();
    }
    bijd.a(this.this$0).setOnTouchListener(this.this$0);
    bijd.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.17
 * JD-Core Version:    0.7.0.1
 */