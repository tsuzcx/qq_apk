package com.tencent.mobileqq.now.enter;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.intervideo.now.dynamic.IDynamicNowManager;
import com.tencent.mobileqq.now.enter.pb.NowPushMsgList.NowPushMsg;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class NowHongbaoPushManager
  implements Manager
{
  private QQAppInterface a;
  
  public NowHongbaoPushManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private boolean c(NowPushMsgList.NowPushMsg paramNowPushMsg)
  {
    if ((paramNowPushMsg.uint32_version.get() == 0L) && (paramNowPushMsg.uint64_start_time.get() == 0L) && (paramNowPushMsg.uint64_end_time.get() == 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.i("NowHongbaoPushManager", 2, "发送wns日志请求");
      }
      ((IDynamicNowManager)this.a.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER)).f();
      return true;
    }
    return false;
  }
  
  private void d(NowPushMsgList.NowPushMsg paramNowPushMsg)
  {
    if (c(paramNowPushMsg)) {}
  }
  
  public void a(NowPushMsgList.NowPushMsg paramNowPushMsg)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("receiveOnLinePush ： type=");
    localStringBuilder.append(paramNowPushMsg.uint32_type.get());
    localStringBuilder.append(", show=");
    localStringBuilder.append(paramNowPushMsg.uint32_switch.get());
    localStringBuilder.append(", startTime=");
    localStringBuilder.append(paramNowPushMsg.uint64_start_time.get());
    localStringBuilder.append(", endTime=");
    localStringBuilder.append(paramNowPushMsg.uint64_end_time.get());
    localStringBuilder.append(",taskId =");
    localStringBuilder.append(paramNowPushMsg.uint32_task_id.get());
    localStringBuilder.append(",version =");
    localStringBuilder.append(paramNowPushMsg.uint32_version.get());
    QLog.i("NowHongbaoPushManager", 1, localStringBuilder.toString());
    d(paramNowPushMsg);
  }
  
  public void b(NowPushMsgList.NowPushMsg paramNowPushMsg)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("receiveOfflinePush ： type=");
    localStringBuilder.append(paramNowPushMsg.uint32_type.get());
    localStringBuilder.append(", show=");
    localStringBuilder.append(paramNowPushMsg.uint32_switch.get());
    localStringBuilder.append(", startTime=");
    localStringBuilder.append(paramNowPushMsg.uint64_start_time.get());
    localStringBuilder.append(", endTime=");
    localStringBuilder.append(paramNowPushMsg.uint64_end_time.get());
    localStringBuilder.append(",taskId =");
    localStringBuilder.append(paramNowPushMsg.uint32_task_id.get());
    localStringBuilder.append(",version =");
    localStringBuilder.append(paramNowPushMsg.uint32_version.get());
    QLog.i("NowHongbaoPushManager", 1, localStringBuilder.toString());
    d(paramNowPushMsg);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.enter.NowHongbaoPushManager
 * JD-Core Version:    0.7.0.1
 */