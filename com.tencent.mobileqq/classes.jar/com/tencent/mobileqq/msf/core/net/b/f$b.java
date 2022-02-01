package com.tencent.mobileqq.msf.core.net.b;

import com.tencent.mobileqq.msf.core.ac;
import com.tencent.mobileqq.msf.core.o;
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
    while (!f.a(this.a).get()) {
      try
      {
        ToServiceMsg localToServiceMsg = (ToServiceMsg)f.b(this.a).take();
        String str = localToServiceMsg.getServiceCmd();
        byte[] arrayOfByte2;
        try
        {
          byte[] arrayOfByte1 = ac.b(localToServiceMsg, 0);
        }
        catch (Exception localException)
        {
          QLog.d("ReqAllFailSocket", 1, "", localException);
          arrayOfByte2 = null;
        }
        if (591 == CodecWarpper.getSharedObjectVersion()) {
          arrayOfByte2 = CodecWarpper.nativeEncodeRequest(localToServiceMsg.getRequestSsoSeq(), o.d(), o.f(), o.g(), "", str, null, localToServiceMsg.getAppId(), 0, localToServiceMsg.getUin(), (byte)0, (byte)0, localToServiceMsg.getWupBuffer(), true);
        } else if ((595 != CodecWarpper.getSharedObjectVersion()) && (600 != CodecWarpper.getSharedObjectVersion())) {
          arrayOfByte2 = CodecWarpper.nativeEncodeRequest(localToServiceMsg.getRequestSsoSeq(), o.d(), o.f(), o.g(), "", str, null, localToServiceMsg.getAppId(), 0, localToServiceMsg.getUin(), (byte)0, (byte)0, (byte)0, arrayOfByte2, null, localToServiceMsg.getWupBuffer(), true);
        } else {
          arrayOfByte2 = CodecWarpper.nativeEncodeRequest(localToServiceMsg.getRequestSsoSeq(), o.d(), o.f(), o.g(), "", str, null, localToServiceMsg.getAppId(), 0, localToServiceMsg.getUin(), (byte)0, (byte)0, arrayOfByte2, null, localToServiceMsg.getWupBuffer(), true);
        }
        if (f.c(this.a).get()) {
          f.a(this.a, localToServiceMsg.getServiceCmd(), localToServiceMsg.getMsfCommand(), arrayOfByte2);
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        f.d(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.b.f.b
 * JD-Core Version:    0.7.0.1
 */