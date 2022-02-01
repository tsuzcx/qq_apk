package com.tencent.mobileqq.kandian.base.msf;

import android.os.Bundle;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

class ReadInJoyMSFService$2
  implements Runnable
{
  ReadInJoyMSFService$2(ReadInJoyMSFService paramReadInJoyMSFService, ToServiceMsg paramToServiceMsg) {}
  
  public void run()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("req cmd: ");
      ((StringBuilder)localObject).append(this.a.getServiceCmd());
      QLog.d("ReadInJoyMSFService", 2, ((StringBuilder)localObject).toString());
    }
    int i;
    boolean bool;
    try
    {
      if ((!this.a.extraData.getBoolean("req_pb_protocol_flag", false)) || (this.a.getWupBuffer() == null)) {
        break label469;
      }
      if (!ReadInJoyMSFService.access$200(this.this$0, this.a))
      {
        l = this.a.getWupBuffer().length;
        i = (int)l;
        localObject = new byte[i + 4];
        PkgTools.dWord2Byte((byte[])localObject, 0, l + 4L);
        PkgTools.copyData((byte[])localObject, 4, this.a.getWupBuffer(), i);
        this.a.putWupBuffer((byte[])localObject);
      }
      else
      {
        QLog.d("ReadInJoyMSFService", 1, "handleRequest | isRetryRequest ");
      }
      if (!QLog.isColorLevel()) {
        break label464;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PB cmd: req cmd: ");
      ((StringBuilder)localObject).append(this.a.getServiceCmd());
      QLog.d("ReadInJoyMSFService", 2, ((StringBuilder)localObject).toString());
    }
    catch (Exception localException)
    {
      long l;
      localException.printStackTrace();
      if (!QLog.isColorLevel()) {
        break label419;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleRequest Exception. cmd=");
      localObject = this.a;
      if (localObject == null) {
        break label394;
      }
      localObject = ((ToServiceMsg)localObject).getServiceCmd();
      break label398;
      localObject = "";
      localStringBuilder.append((String)localObject);
      QLog.e("ReadInJoyMSFService", 2, localStringBuilder.toString(), localException);
      localObject = new FromServiceMsg(this.a.getUin(), this.a.getServiceCmd());
      ((FromServiceMsg)localObject).setMsgFail();
      this.this$0.handleResponse(false, this.a, (FromServiceMsg)localObject, localException);
    }
    if (i != 0)
    {
      localObject = new NewIntent(RIJQQAppInterfaceUtil.a().getApplication(), ReadInJoyMSFServlet.class);
      ((NewIntent)localObject).putExtra(ToServiceMsg.class.getSimpleName(), this.a);
      if (this.a.getAttributes().get("req_enable_msf_retry") == null) {
        break label474;
      }
      bool = ((Boolean)this.a.getAttributes().get("req_enable_msf_retry")).booleanValue();
    }
    for (;;)
    {
      if (bool)
      {
        this.a.setTimeout(360000L);
        ((NewIntent)localObject).putExtra("quickSendEnable", true);
        ((NewIntent)localObject).putExtra("quickSendStrategy", 0);
        QLog.d("ReadInJoyMSFService", 2, "handleRequest | MSF retry enabled");
      }
      RIJQQAppInterfaceUtil.a().startServlet((NewIntent)localObject);
      l = System.currentTimeMillis();
      this.a.extraData.putLong("sendtimekey", l);
      return;
      StringBuilder localStringBuilder;
      label394:
      label398:
      label419:
      return;
      label464:
      i = 1;
      break;
      label469:
      i = 0;
      break;
      label474:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService.2
 * JD-Core Version:    0.7.0.1
 */