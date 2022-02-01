package com.tencent.trpcprotocol.gamecenter.trpcproxy;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class ExpeDataAcc$UserActionInfo
  extends MessageMicro<UserActionInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "account_info", "event_info", "device_info", "app_info", "network_info", "expe_info", "task_info", "algorithm_info" }, new Object[] { null, null, null, null, null, null, null, null }, UserActionInfo.class);
  public ExpeDataAcc.AccountInfo account_info = new ExpeDataAcc.AccountInfo();
  public ExpeDataAcc.SvrAlgorithmInfo algorithm_info = new ExpeDataAcc.SvrAlgorithmInfo();
  public ExpeDataAcc.AppInfo app_info = new ExpeDataAcc.AppInfo();
  public ExpeDataAcc.DeviceInfo device_info = new ExpeDataAcc.DeviceInfo();
  public ExpeDataAcc.EventInfo event_info = new ExpeDataAcc.EventInfo();
  public ExpeDataAcc.ExpeInfo expe_info = new ExpeDataAcc.ExpeInfo();
  public ExpeDataAcc.NetworkInfo network_info = new ExpeDataAcc.NetworkInfo();
  public ExpeDataAcc.PushTaskInfo task_info = new ExpeDataAcc.PushTaskInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.gamecenter.trpcproxy.ExpeDataAcc.UserActionInfo
 * JD-Core Version:    0.7.0.1
 */