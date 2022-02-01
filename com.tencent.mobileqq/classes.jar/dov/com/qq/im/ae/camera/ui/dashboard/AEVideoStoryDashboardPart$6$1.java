package dov.com.qq.im.ae.camera.ui.dashboard;

import android.os.Bundle;
import android.widget.TextView;
import bnev;
import bnfb;
import com.tencent.ttpic.openapi.offlineset.OfflineConfig;
import eipc.EIPCResult;

public class AEVideoStoryDashboardPart$6$1
  implements Runnable
{
  public AEVideoStoryDashboardPart$6$1(bnfb parambnfb, EIPCResult paramEIPCResult) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_EipcEIPCResult.data.getString("KEY_ENV_INFO") + ", PerfLevel: " + OfflineConfig.getPhonePerfLevel();
    bnev.a(this.jdField_a_of_type_Bnfb.a).setText(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.6.1
 * JD-Core Version:    0.7.0.1
 */