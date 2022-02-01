package dov.com.qq.im.ae.camera.ui.dashboard;

import android.os.Bundle;
import android.widget.TextView;
import blrm;
import blrs;
import eipc.EIPCResult;

public class AEVideoStoryDashboardPart$6$1
  implements Runnable
{
  public AEVideoStoryDashboardPart$6$1(blrs paramblrs, EIPCResult paramEIPCResult) {}
  
  public void run()
  {
    blrm.a(this.jdField_a_of_type_Blrs.a).setText(this.jdField_a_of_type_EipcEIPCResult.data.getString("KEY_ENV_INFO"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.6.1
 * JD-Core Version:    0.7.0.1
 */