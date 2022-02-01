package com.tencent.mobileqq.extendfriend.network;

import android.os.Bundle;
import com.tencent.mobileqq.utils.PkgTools;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

class ExpandCmdHandler$1
  implements Runnable
{
  ExpandCmdHandler$1(ExpandCmdHandler paramExpandCmdHandler, ExpandReqInfo paramExpandReqInfo, ExpandCmdHandler.ICallback paramICallback) {}
  
  public void run()
  {
    int i = ExpandCmdHandler.a.incrementAndGet();
    ExpandCmdHandler.a(this.this$0).put(Integer.valueOf(i), new ExpandCmdHandler.RequestObject(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExpandReqInfo, this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExpandCmdHandler$ICallback));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", ExpandCmdHandler.a(this.this$0).getAccount(), this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExpandReqInfo.a());
    localToServiceMsg.setTimeout(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExpandReqInfo.a());
    localToServiceMsg.extraData.putLong("REQUEST_TIME", System.currentTimeMillis());
    localToServiceMsg.extraData.putInt("FLUTTER_REQUEST_SEQ", i);
    Object localObject;
    if (!this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExpandReqInfo.a())
    {
      long l = this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExpandReqInfo.a().length;
      localObject = new byte[(int)l + 4];
      PkgTools.DWord2Byte((byte[])localObject, 0, 4L + l);
      PkgTools.copyData((byte[])localObject, 4, this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExpandReqInfo.a(), (int)l);
      localToServiceMsg.putWupBuffer((byte[])localObject);
    }
    for (;;)
    {
      localObject = new NewIntent(ExpandCmdHandler.a(this.this$0).getApplication(), ExpandServlet.class);
      ((NewIntent)localObject).putExtra(ToServiceMsg.class.getSimpleName(), localToServiceMsg);
      ExpandCmdHandler.a(this.this$0).startServlet((NewIntent)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("expand.cmd.ExpandCmdHandler", 2, String.format("send request cmd: %s, request seq: %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExpandReqInfo.a(), Integer.valueOf(i) }));
      }
      return;
      localToServiceMsg.putWupBuffer(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExpandReqInfo.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.network.ExpandCmdHandler.1
 * JD-Core Version:    0.7.0.1
 */