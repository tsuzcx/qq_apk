package com.tencent.mobileqq.pushnotice;

import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import com.tencent.qphone.base.util.QLog;

final class PushNoticeUtil$2
  implements OnCompleteListener<Void>
{
  PushNoticeUtil$2(String paramString) {}
  
  public void onComplete(Task<Void> paramTask)
  {
    if (paramTask.isSuccessful())
    {
      PushNoticeUtil.b = this.a;
      paramTask = new StringBuilder();
      paramTask.append("HPush_Huawei Push add profileid sucess : ");
      paramTask.append(PushNoticeUtil.b);
      QLog.d("HPush", 1, paramTask.toString());
    }
    else
    {
      QLog.d("HPush", 1, "HPush_Huawei Push add profileid failed : ");
    }
    PushNoticeUtil.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pushnotice.PushNoticeUtil.2
 * JD-Core Version:    0.7.0.1
 */