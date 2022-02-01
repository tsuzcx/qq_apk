package com.tencent.mobileqq.ecshop;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ecshop.utils.AppUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;

public class EcshopNewServlet
  extends MSFServlet
{
  public static void a(byte[] paramArrayOfByte, String paramString, BusinessObserver paramBusinessObserver)
  {
    AppRuntime localAppRuntime = AppUtils.a();
    if (localAppRuntime == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(localAppRuntime.getApplication(), EcshopNewServlet.class);
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("data", paramArrayOfByte);
    localNewIntent.putExtra("timeout", 30000);
    localNewIntent.setObserver(paramBusinessObserver);
    localAppRuntime.startServlet(localNewIntent);
  }
  
  public void notifyObserver(Intent paramIntent, int paramInt, boolean paramBoolean, Bundle paramBundle, Class<? extends BusinessObserver> paramClass)
  {
    if (paramIntent.getIntExtra("callback_thread_type", 0) == 0)
    {
      super.notifyObserver(paramIntent, paramInt, paramBoolean, paramBundle, paramClass);
      return;
    }
    if ((paramIntent instanceof NewIntent))
    {
      paramIntent = ((NewIntent)paramIntent).getObserver();
      if (paramIntent != null) {
        ThreadManager.post(new EcshopNewServlet.1(this, paramIntent, paramInt, paramBoolean, paramBundle), 5, null, true);
      }
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceive cmd=");
      ((StringBuilder)localObject).append(paramIntent.getStringExtra("cmd"));
      ((StringBuilder)localObject).append(",success=");
      ((StringBuilder)localObject).append(paramFromServiceMsg.isSuccess());
      QLog.d("EcshopNewServlet", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = null;
    if (paramFromServiceMsg.isSuccess())
    {
      int i = paramFromServiceMsg.getWupBuffer().length - 4;
      localObject = new byte[i];
      PkgTools.copyData((byte[])localObject, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    }
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("data", (byte[])localObject);
    notifyObserver(paramIntent, 1, paramFromServiceMsg.isSuccess(), localBundle, null);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    String str = paramIntent.getStringExtra("cmd");
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    long l = paramIntent.getLongExtra("timeout", 30000L);
    if (!TextUtils.isEmpty(str))
    {
      paramPacket.setSSOCommand(str);
      paramPacket.setTimeout(l);
      if (arrayOfByte != null)
      {
        paramIntent = new byte[arrayOfByte.length + 4];
        PkgTools.dWord2Byte(paramIntent, 0, arrayOfByte.length + 4);
        PkgTools.copyData(paramIntent, 4, arrayOfByte, arrayOfByte.length);
        paramPacket.putSendData(paramIntent);
      }
      else
      {
        paramIntent = new byte[4];
        PkgTools.dWord2Byte(paramIntent, 0, 4L);
        paramPacket.putSendData(paramIntent);
      }
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onSend exit cmd=");
      paramIntent.append(str);
      QLog.d("EcshopNewServlet", 2, paramIntent.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.EcshopNewServlet
 * JD-Core Version:    0.7.0.1
 */