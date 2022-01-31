package dov.com.qq.im.ae.camera.ui.dashboard;

import android.os.Bundle;
import android.widget.TextView;
import bimz;
import binf;
import eipc.EIPCResult;

public class AEVideoStoryDashboardPart$6$1
  implements Runnable
{
  public AEVideoStoryDashboardPart$6$1(binf parambinf, EIPCResult paramEIPCResult) {}
  
  public void run()
  {
    bimz.a(this.jdField_a_of_type_Binf.a).setText(this.jdField_a_of_type_EipcEIPCResult.data.getString("KEY_ENV_INFO"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.6.1
 * JD-Core Version:    0.7.0.1
 */