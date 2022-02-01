package com.tencent.mobileqq.msf.core.a;

import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.msf.service.protocol.serverconfig.f;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.log.a.b.a;
import com.tencent.qphone.base.util.log.a.j;
import java.util.concurrent.LinkedBlockingDeque;

class d
  implements Runnable
{
  d(c paramc, f paramf, FromServiceMsg paramFromServiceMsg) {}
  
  public void run()
  {
    Object localObject;
    com.tencent.msf.service.protocol.serverconfig.a locala;
    if ((this.a.b != null) && (this.a.b.length > 0))
    {
      localObject = new JceInputStream(this.a.b);
      locala = new com.tencent.msf.service.protocol.serverconfig.a();
      locala.readFrom((JceInputStream)localObject);
      if (locala.a != 2) {
        break label133;
      }
      QLog.d("MSF.C.SsoListManager", 1, new Object[] { "handleLogPush: _CliLogCfgSetLevel", Byte.valueOf(locala.d) });
      MsfStore.getNativeConfigStore().setConfig("LOGLEVEL_", String.valueOf(locala.d));
      MsfStore.getNativeConfigStore().setConfig("LOGLEVELTIME", String.valueOf(System.currentTimeMillis()));
      QLog.setUIN_REPORTLOG_LEVEL(locala.d);
      MsfCore.initAppProMsg("*", this.b.getAppId());
    }
    label133:
    b.a locala1;
    do
    {
      do
      {
        return;
      } while (locala.a != 1);
      localObject = this.a.c + "&" + System.currentTimeMillis();
      locala1 = new b.a();
      locala1.b = this.a.c;
      com.tencent.qphone.base.util.log.a.a.a(com.tencent.qphone.base.util.log.a.a.j, (String)localObject, locala1);
      if (j.b(this.a.c))
      {
        QLog.i("MSF.C.SsoListManager", 1, "handleLogPush, repeated push ignored");
        locala1.f = true;
        locala1.e = this.a.c;
        com.tencent.qphone.base.util.log.a.a.a(com.tencent.qphone.base.util.log.a.a.j, (String)localObject, 11, locala1);
        return;
      }
      locala.f = this.a.c;
      c.a(this.c).offer(locala);
    } while (c.b(this.c) != null);
    c.a(this.c, new e(this, "LogUploadThread", (String)localObject, locala1));
    c.b(this.c).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.a.d
 * JD-Core Version:    0.7.0.1
 */