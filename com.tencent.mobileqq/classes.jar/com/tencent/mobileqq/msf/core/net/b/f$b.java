package com.tencent.mobileqq.msf.core.net.b;

import com.tencent.mobileqq.msf.core.ag;
import com.tencent.mobileqq.msf.core.t;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

class f$b
  extends Thread
{
  private f$b(f paramf) {}
  
  public void run()
  {
    ToServiceMsg localToServiceMsg;
    String str;
    for (;;)
    {
      if (f.a(this.a).get()) {
        return;
      }
      try
      {
        localToServiceMsg = (ToServiceMsg)f.b(this.a).take();
        str = localToServiceMsg.getServiceCmd();
        localObject = null;
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        byte[] arrayOfByte2;
        label43:
        label90:
        localThrowable.printStackTrace();
        f.d(this.a);
      }
      try
      {
        arrayOfByte2 = ag.b(localToServiceMsg, 0);
        localObject = arrayOfByte2;
      }
      catch (Exception localException)
      {
        QLog.d("ReqAllFailSocket", 1, "", localException);
        break label43;
        if ((595 != CodecWarpper.getSharedObjectVersion()) && (600 != CodecWarpper.getSharedObjectVersion())) {
          break label211;
        }
        byte[] arrayOfByte1 = CodecWarpper.nativeEncodeRequest(localToServiceMsg.getRequestSsoSeq(), t.d(), t.f(), t.g(), "", str, null, localToServiceMsg.getAppId(), 0, localToServiceMsg.getUin(), (byte)0, (byte)0, localThrowable, localToServiceMsg.getWupBuffer(), true);
        break label90;
        arrayOfByte1 = CodecWarpper.nativeEncodeRequest(localToServiceMsg.getRequestSsoSeq(), t.d(), t.f(), t.g(), "", str, null, localToServiceMsg.getAppId(), 0, localToServiceMsg.getUin(), (byte)0, (byte)0, (byte)0, arrayOfByte1, localToServiceMsg.getWupBuffer(), true);
        break label90;
      }
      if (591 != CodecWarpper.getSharedObjectVersion()) {
        break;
      }
      localObject = CodecWarpper.nativeEncodeRequest(localToServiceMsg.getRequestSsoSeq(), t.d(), t.f(), t.g(), "", str, null, localToServiceMsg.getAppId(), 0, localToServiceMsg.getUin(), (byte)0, (byte)0, localToServiceMsg.getWupBuffer(), true);
      if (f.c(this.a).get()) {
        f.a(this.a, localToServiceMsg.getServiceCmd(), localToServiceMsg.getMsfCommand(), (byte[])localObject);
      }
    }
    label211:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.b.f.b
 * JD-Core Version:    0.7.0.1
 */