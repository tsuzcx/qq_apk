package com.tencent.mobileqq.msgforward;

import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.filemanager.fileassistant.util.DatalineDeviceChooseModel.DeviceChooseInterface;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import java.util.ArrayList;
import java.util.List;

class AIOShareActionSheet$12
  implements DatalineDeviceChooseModel.DeviceChooseInterface
{
  AIOShareActionSheet$12(AIOShareActionSheet paramAIOShareActionSheet, List paramList) {}
  
  public void a()
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_Int = 0;
    localSessionInfo.jdField_a_of_type_JavaLangString = QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet.a);
    localSessionInfo.b = QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet.a);
    localSessionInfo.a(new Bundle());
    MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet.a, localSessionInfo, (ArrayList)this.jdField_a_of_type_JavaUtilList);
  }
  
  public void b()
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_Int = 0;
    localSessionInfo.jdField_a_of_type_JavaLangString = QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet.a);
    localSessionInfo.b = QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet.a);
    localSessionInfo.a(new Bundle());
    MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet.a, localSessionInfo, (ArrayList)this.jdField_a_of_type_JavaUtilList);
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgforward.AIOShareActionSheet.12
 * JD-Core Version:    0.7.0.1
 */