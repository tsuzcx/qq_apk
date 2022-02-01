package dov.com.qq.im.ae;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import bmvk;
import bnqm;
import dov.com.qq.im.ae.view.AECMShowFaceScanView;

public class AECMShowCameraUnit$3
  implements Runnable
{
  public AECMShowCameraUnit$3(bmvk parambmvk) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_Long != -1L) || (!this.this$0.d)) {
      if (!bmvk.b(this.this$0))
      {
        bmvk.a(this.this$0).setClickable(false);
        Log.d(this.this$0.jdField_a_of_type_JavaLangString, "tips: 设置为白色背景 disable");
        bmvk.a(this.this$0).setBackgroundDrawable(this.this$0.a().getResources().getDrawable(2130837668));
        bmvk.a(this.this$0).setTextColor(Color.parseColor("#8F8F91"));
      }
    }
    do
    {
      while (this.this$0.b >= 5000L)
      {
        if (!bmvk.b(this.this$0)) {
          bmvk.a(this.this$0).a(1000, bmvk.a(this.this$0));
        }
        bmvk.a(this.this$0).setText(2131690863);
        bnqm.a().aC();
        return;
        if (!bmvk.b(this.this$0))
        {
          bmvk.a(this.this$0).setClickable(true);
          Log.d(this.this$0.jdField_a_of_type_JavaLangString, "tips: 设置为白色背景");
          bmvk.a(this.this$0).setBackgroundDrawable(this.this$0.a().getResources().getDrawable(2130837667));
          bmvk.a(this.this$0).setTextColor(-16777216);
        }
      }
    } while (bmvk.b(this.this$0));
    bmvk.a(this.this$0).a(1003, null);
    bmvk.a(this.this$0).setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AECMShowCameraUnit.3
 * JD-Core Version:    0.7.0.1
 */