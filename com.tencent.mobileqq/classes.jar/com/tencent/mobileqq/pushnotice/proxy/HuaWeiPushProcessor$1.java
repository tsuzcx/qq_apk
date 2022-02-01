package com.tencent.mobileqq.pushnotice.proxy;

import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import com.tencent.qphone.base.util.QLog;

class HuaWeiPushProcessor$1
  implements OnCompleteListener<Void>
{
  HuaWeiPushProcessor$1(HuaWeiPushProcessor paramHuaWeiPushProcessor, String paramString) {}
  
  public void onComplete(Task<Void> paramTask)
  {
    if (paramTask.isSuccessful())
    {
      this.b.b = this.a;
      paramTask = new StringBuilder();
      paramTask.append("add profileid sucess : ");
      paramTask.append(this.b.b);
      QLog.d("HPush", 1, paramTask.toString());
    }
    else
    {
      QLog.d("HPush", 1, "add profileid failed : ");
    }
    HuaWeiPushProcessor.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.pushnotice.proxy.HuaWeiPushProcessor.1
 * JD-Core Version:    0.7.0.1
 */