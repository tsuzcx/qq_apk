package com.tencent.mobileqq.now.enter;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager;
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
  
  private boolean a(NowPushMsgList.NowPushMsg paramNowPushMsg)
  {
    if ((paramNowPushMsg.uint32_version.get() == 0L) && (paramNowPushMsg.uint64_start_time.get() == 0L) && (paramNowPushMsg.uint64_end_time.get() == 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.i("NowHongbaoPushManager", 2, "发送wns日志请求");
      }
      ((DynamicNowManager)this.a.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER)).c();
      return true;
    }
    return false;
  }
  
  private void c(NowPushMsgList.NowPushMsg paramNowPushMsg)
  {
    if (a(paramNowPushMsg)) {}
  }
  
  public void a(NowPushMsgList.NowPushMsg paramNowPushMsg)
  {
    QLog.i("NowHongbaoPushManager", 1, "receiveOnLinePush ： type=" + paramNowPushMsg.uint32_type.get() + ", show=" + paramNowPushMsg.uint32_switch.get() + ", startTime=" + paramNowPushMsg.uint64_start_time.get() + ", endTime=" + paramNowPushMsg.uint64_end_time.get() + ",taskId =" + paramNowPushMsg.uint32_task_id.get() + ",version =" + paramNowPushMsg.uint32_version.get());
    c(paramNowPushMsg);
  }
  
  public void b(NowPushMsgList.NowPushMsg paramNowPushMsg)
  {
    QLog.i("NowHongbaoPushManager", 1, "receiveOfflinePush ： type=" + paramNowPushMsg.uint32_type.get() + ", show=" + paramNowPushMsg.uint32_switch.get() + ", startTime=" + paramNowPushMsg.uint64_start_time.get() + ", endTime=" + paramNowPushMsg.uint64_end_time.get() + ",taskId =" + paramNowPushMsg.uint32_task_id.get() + ",version =" + paramNowPushMsg.uint32_version.get());
    c(paramNowPushMsg);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.enter.NowHongbaoPushManager
 * JD-Core Version:    0.7.0.1
 */