package dov.com.qq.im.ae.camera.ui.dashboard;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import eipc.EIPCResult;
import org.light.device.OfflineConfig;

class AEVideoStoryDashboardPart$6$1
  implements Runnable
{
  AEVideoStoryDashboardPart$6$1(AEVideoStoryDashboardPart.6 param6, EIPCResult paramEIPCResult) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_EipcEIPCResult.data.getString("KEY_ENV_INFO") + ", PerfLevel: " + OfflineConfig.getPhonePerfLevel(BaseApplicationImpl.getContext());
    AEVideoStoryDashboardPart.a(this.jdField_a_of_type_DovComQqImAeCameraUiDashboardAEVideoStoryDashboardPart$6.a).setText(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.6.1
 * JD-Core Version:    0.7.0.1
 */