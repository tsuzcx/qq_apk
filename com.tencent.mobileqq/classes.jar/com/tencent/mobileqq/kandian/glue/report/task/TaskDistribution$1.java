package com.tencent.mobileqq.kandian.glue.report.task;

import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.kandian.repo.account.api.IUserOperationModule;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

final class TaskDistribution$1
  implements Runnable
{
  public void run()
  {
    try
    {
      IUserOperationModule localIUserOperationModule = (IUserOperationModule)QRoute.api(IUserOperationModule.class);
      this.jdField_a_of_type_JavaUtilList.addAll(ReadinjoySPEventReport.a().a(this.jdField_a_of_type_Int));
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("KDreportPushEffectEvent info : eventId:");
      ((StringBuilder)localObject).append(Integer.toString(this.jdField_a_of_type_Int));
      ((StringBuilder)localObject).append("; AttributeList:[");
      localObject = ((StringBuilder)localObject).toString();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        oidb_cmd0x80a.AttributeList localAttributeList = (oidb_cmd0x80a.AttributeList)localIterator.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("{ att_id:");
        localStringBuilder.append(Integer.toString(localAttributeList.att_id.get()));
        localStringBuilder.append("; att_name:");
        localStringBuilder.append(localAttributeList.att_name.get());
        localStringBuilder.append("; att_value:");
        localStringBuilder.append(localAttributeList.att_value.get());
        localStringBuilder.append(" },");
        localObject = localStringBuilder.toString();
      }
      if (QLog.isColorLevel()) {
        QLog.d(TaskDistribution.a(), 2, (String)localObject);
      }
      localIUserOperationModule.request0x80aPushEffectEvent(this.jdField_a_of_type_Int, "", this.b, this.jdField_a_of_type_JavaUtilList, "OidbSvc.0xc22", 3106);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(TaskDistribution.a(), 2, "reportPushEffectEvent", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.task.TaskDistribution.1
 * JD-Core Version:    0.7.0.1
 */