package com.tencent.mobileqq.qipc;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.pluginsdk.IPluginAdapterProxy;
import eipc.EIPCServer;
import eipc.EIPCService;

public class QIPCService
  extends EIPCService
  implements Handler.Callback
{
  public static final int MSG_ACCOUNT_CHANGED = 1;
  static final int a = 1;
  public Handler mSubThreadhandler;
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      paramMessage = this.mServer;
      if (paramMessage != null) {
        paramMessage.sendMsgToRemoteModule(1, null);
      }
    }
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    if (this.mSubThreadhandler == null) {
      this.mSubThreadhandler = new Handler(IPluginAdapterProxy.getProxy().getSubThreadLooper(), this);
    }
    this.mSubThreadhandler.sendEmptyMessage(1);
  }
  
  public EIPCServer onCreateSingleServer()
  {
    return QIPCServerHelper.getInstance().getServer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.QIPCService
 * JD-Core Version:    0.7.0.1
 */