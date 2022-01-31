package dov.com.qq.im.ae;

import actn;
import amfw;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import biim;
import biju;
import biwb;
import dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout;

public class AEPituCameraUnit$17
  implements Runnable
{
  public AEPituCameraUnit$17(biim parambiim) {}
  
  public void run()
  {
    biim.a(this.this$0, (AEPituCameraCaptureButtonLayout)biim.a(this.this$0).findViewById(2131363881));
    biim.a(this.this$0).a(this.this$0, biim.a(this.this$0), biim.a(this.this$0));
    Object localObject = this.this$0.a().getIntent();
    biim.a(this.this$0).setOriginIntent((Intent)localObject);
    localObject = (RelativeLayout.LayoutParams)biim.a(this.this$0).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = actn.a(-30.0F, biim.a(this.this$0).getResources());
    biim.a(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
    biim.a(this.this$0).b();
    if (biim.a(this.this$0))
    {
      biim.a(this.this$0).l();
      this.this$0.q();
    }
    biim.a(this.this$0).c();
    biim.a(this.this$0).a();
    biim.a(this.this$0, (Button)biim.a(this.this$0).findViewById(2131364898));
    biim.a(this.this$0).setOnClickListener(this.this$0);
    biim.a(this.this$0).setSelected(false);
    biim.a(this.this$0).setVisibility(8);
    if (biim.b(this.this$0)) {
      biim.a(this.this$0, biim.b(this.this$0));
    }
    biim.b(this.this$0, (Button)biim.a(this.this$0).findViewById(2131364030));
    biim.b(this.this$0).setOnClickListener(this.this$0);
    biim.b(this.this$0).setContentDescription(biim.b(this.this$0).getResources().getString(2131718767));
    if (!amfw.d())
    {
      biim.b(this.this$0).setVisibility(4);
      biim.b(this.this$0).setEnabled(false);
    }
    if (biim.a(this.this$0))
    {
      biim.a(this.this$0).d();
      biim.a(this.this$0).i();
    }
    biim.a(this.this$0).setOnTouchListener(this.this$0);
    biim.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.17
 * JD-Core Version:    0.7.0.1
 */