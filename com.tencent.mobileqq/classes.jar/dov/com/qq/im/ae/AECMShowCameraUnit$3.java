package dov.com.qq.im.ae;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.view.AECMShowFaceScanView;

class AECMShowCameraUnit$3
  implements Runnable
{
  AECMShowCameraUnit$3(AECMShowCameraUnit paramAECMShowCameraUnit) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_Long != -1L) || (!this.this$0.jdField_a_of_type_Boolean)) {
      if (!AECMShowCameraUnit.b(this.this$0))
      {
        AECMShowCameraUnit.a(this.this$0).setClickable(false);
        Log.d(this.this$0.jdField_b_of_type_JavaLangString, "tips: 设置为白色背景 disable");
        AECMShowCameraUnit.a(this.this$0).setBackgroundDrawable(this.this$0.a().getResources().getDrawable(2130837672));
        AECMShowCameraUnit.a(this.this$0).setTextColor(Color.parseColor("#8F8F91"));
      }
    }
    do
    {
      while (this.this$0.jdField_b_of_type_Long >= 5000L)
      {
        if (!AECMShowCameraUnit.b(this.this$0)) {
          AECMShowCameraUnit.a(this.this$0).a(1000, AECMShowCameraUnit.a(this.this$0));
        }
        AECMShowCameraUnit.a(this.this$0).setText(2131690964);
        AEBaseDataReporter.a().aA();
        return;
        if (!AECMShowCameraUnit.b(this.this$0))
        {
          AECMShowCameraUnit.a(this.this$0).setClickable(true);
          Log.d(this.this$0.jdField_b_of_type_JavaLangString, "tips: 设置为白色背景");
          AECMShowCameraUnit.a(this.this$0).setBackgroundDrawable(this.this$0.a().getResources().getDrawable(2130837671));
          AECMShowCameraUnit.a(this.this$0).setTextColor(-16777216);
        }
      }
    } while (AECMShowCameraUnit.b(this.this$0));
    AECMShowCameraUnit.a(this.this$0).a(1003, null);
    AECMShowCameraUnit.a(this.this$0).setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AECMShowCameraUnit.3
 * JD-Core Version:    0.7.0.1
 */