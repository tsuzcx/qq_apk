package dov.com.qq.im.ae.camera.ui.watermark;

import com.tencent.common.app.AppInterface;
import dov.com.qq.im.ae.config.CameraPeakServiceObserver;
import dov.com.qq.im.ae.util.AEQLog;

class WatermarkOnlineUserManager$3
  extends CameraPeakServiceObserver
{
  WatermarkOnlineUserManager$3(WatermarkOnlineUserManager paramWatermarkOnlineUserManager, AppInterface paramAppInterface) {}
  
  public void onUpdateOnlineUserNum(boolean paramBoolean, int paramInt)
  {
    AEQLog.b("WatermarkOnlineUserManager", "requestOnlineUserNum---isSuccess=" + paramBoolean + ", num=" + paramInt);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this);
    if (paramBoolean) {
      synchronized (WatermarkOnlineUserManager.a(this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkOnlineUserManager))
      {
        WatermarkOnlineUserManager.a(this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkOnlineUserManager, paramInt);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.watermark.WatermarkOnlineUserManager.3
 * JD-Core Version:    0.7.0.1
 */