package com.tencent.mobileqq.data;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.qphone.base.util.QLog;
import com.trunk.Qworkflow.Qworkflow.ScheduleChangeNotification;
import com.trunk.Qworkflow.Qworkflow.Text;
import cooperation.dingdong.DingdongPluginDataFactory;
import cooperation.dingdong.DingdongPluginDataFactory.ScheduleSummaryData;
import cooperation.dingdong.DingdongPluginHelper;
import mqq.app.MobileQQ;

public class MessageForDingdongSchedule
  extends ChatMessage
{
  @notColumn
  public int notificationType;
  @notColumn
  protected DingdongPluginDataFactory.ScheduleSummaryData summaryData;
  
  private String getTipsByType(int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = localQQAppInterface.getApplication().getString(2131438312);
    if (6 == this.notificationType) {
      return localQQAppInterface.getApplication().getString(2131428066);
    }
    if (4 == this.notificationType) {
      return localQQAppInterface.getApplication().getString(2131428067);
    }
    return str;
  }
  
  public boolean canShowInAIO()
  {
    return (5 == this.notificationType) || (6 == this.notificationType) || (4 == this.notificationType) || (3 == this.notificationType);
  }
  
  protected void doParse()
  {
    Qworkflow.ScheduleChangeNotification localScheduleChangeNotification = new Qworkflow.ScheduleChangeNotification();
    try
    {
      localScheduleChangeNotification.mergeFrom(this.msgData);
      this.notificationType = localScheduleChangeNotification.enum_change_type.get();
      this.summaryData = DingdongPluginDataFactory.a((Qworkflow.Text)localScheduleChangeNotification.msg_summary.get());
      this.summaryData.id = localScheduleChangeNotification.bytes_workflow_id.get().toStringUtf8();
      this.summaryData.authorUin = String.valueOf(localScheduleChangeNotification.uint64_author_uin.get());
      if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
      {
        if (((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin().equals(this.summaryData.authorUin)) {
          this.issend = 1;
        }
        this.msg = (getTipsByType(this.notificationType) + this.summaryData.title);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e(MessageForDingdongSchedule.class.getSimpleName(), 1, "doParse error:" + localException.toString() + ".");
    }
  }
  
  public DingdongPluginDataFactory.ScheduleSummaryData getSummaryData()
  {
    if (!this.mIsParsed) {
      doParse();
    }
    if (this.summaryData == null) {
      this.summaryData = new DingdongPluginDataFactory.ScheduleSummaryData();
    }
    return this.summaryData;
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite() {}
  
  public void scheduleC2CdataReport()
  {
    if (5 == this.notificationType) {
      DingdongPluginHelper.a("0X8006528", 1);
    }
    if (6 == this.notificationType) {
      DingdongPluginHelper.a("0X8006529", 1);
    }
    if (4 == this.notificationType) {
      DingdongPluginHelper.a("0X800652A", 1);
    }
    if (3 == this.notificationType) {
      DingdongPluginHelper.a("0X800652A", 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForDingdongSchedule
 * JD-Core Version:    0.7.0.1
 */