package com.tencent.mobileqq.leba.mgr.table;

import com.tencent.mobileqq.leba.core.CommPluginHandlerApi;
import com.tencent.mobileqq.leba.core.LebaUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;

class LebaMgrDataLogic$2
  implements Runnable
{
  LebaMgrDataLogic$2(LebaMgrDataLogic paramLebaMgrDataLogic, List paramList) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_MqqAppAppRuntime == null)
    {
      QLog.i("LebaMgrDataLogic", 1, "handlePluginSort AppRuntime error ");
      return;
    }
    long l = NetConnInfoCenter.getServerTime();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("saveUserSortInfo ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", time");
    localStringBuilder.append(l);
    localStringBuilder.append(", type");
    localStringBuilder.append(this.this$0.jdField_a_of_type_Int);
    QLog.i("LebaMgrDataLogic", 1, localStringBuilder.toString());
    LebaUtil.a(this.this$0.jdField_a_of_type_MqqAppAppRuntime.getPreferences(), this.a, Long.valueOf(l), this.this$0.jdField_a_of_type_Int);
    CommPluginHandlerApi.a(this.this$0.jdField_a_of_type_MqqAppAppRuntime, this.a, l, this.this$0.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.mgr.table.LebaMgrDataLogic.2
 * JD-Core Version:    0.7.0.1
 */