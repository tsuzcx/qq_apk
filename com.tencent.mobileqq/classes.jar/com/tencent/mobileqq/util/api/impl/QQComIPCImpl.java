package com.tencent.mobileqq.util.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.util.api.IQQComIPC;

public class QQComIPCImpl
  implements IQQComIPC
{
  public void cancelAlarmNotifaction(Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 12);
    localBundle.putSerializable("req_param", paramBundle.getSerializable("req_param"));
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtils", localBundle, null);
  }
  
  public void removeMessageRecord(Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 13);
    localBundle.putSerializable("req_param", paramBundle.getSerializable("req_param"));
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtils", localBundle, null);
  }
  
  public void setAlarmNotifaction(Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 11);
    localBundle.putSerializable("req_param", paramBundle.getSerializable("req_param"));
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtils", localBundle, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.api.impl.QQComIPCImpl
 * JD-Core Version:    0.7.0.1
 */