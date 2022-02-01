package com.tencent.mobileqq.filemanager.fileassistant.forward;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.fileassistant.util.DatalineDeviceChooseModel.DeviceChooseInterface;
import java.util.ArrayList;

class DatalineForwardHandler$1
  implements DatalineDeviceChooseModel.DeviceChooseInterface
{
  DatalineForwardHandler$1(DatalineForwardHandler paramDatalineForwardHandler, ArrayList paramArrayList) {}
  
  public void a()
  {
    ThreadManagerV2.executeOnSubThread(new DatalineForwardHandler.SendFileTask(this.b, this.a));
  }
  
  public void b()
  {
    ThreadManagerV2.executeOnSubThread(new DatalineForwardHandler.SendFileTask(this.b, this.a));
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.forward.DatalineForwardHandler.1
 * JD-Core Version:    0.7.0.1
 */