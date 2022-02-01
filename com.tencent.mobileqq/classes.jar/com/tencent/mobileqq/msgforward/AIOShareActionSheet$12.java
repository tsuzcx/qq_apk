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
    localSessionInfo.a = 0;
    localSessionInfo.b = QFileAssistantUtils.b(this.b.a);
    localSessionInfo.c = QFileAssistantUtils.b(this.b.a);
    localSessionInfo.a(new Bundle());
    MultiMsgManager.a().a(this.b.a, localSessionInfo, (ArrayList)this.a);
  }
  
  public void b()
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.a = 0;
    localSessionInfo.b = QFileAssistantUtils.b(this.b.a);
    localSessionInfo.c = QFileAssistantUtils.b(this.b.a);
    localSessionInfo.a(new Bundle());
    MultiMsgManager.a().a(this.b.a, localSessionInfo, (ArrayList)this.a);
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgforward.AIOShareActionSheet.12
 * JD-Core Version:    0.7.0.1
 */