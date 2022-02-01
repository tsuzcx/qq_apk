package com.tencent.mobileqq.teamwork.spread;

import android.content.Context;
import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.config.business.tendoc.TencentDocDataLineTipsConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocDataLineTipsConfigBean.TeamworkKeyWords;
import com.tencent.mobileqq.config.business.tendoc.TencentDocDataLineTipsConfigProcessor;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class DataLineMessageSpreadManager
  implements Manager
{
  private int jdField_a_of_type_Int = -1;
  long jdField_a_of_type_Long = 0L;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BaseTimDataLineTipsProcessor jdField_a_of_type_ComTencentMobileqqTeamworkSpreadBaseTimDataLineTipsProcessor = null;
  private ConfigSettingForDataLine jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSettingForDataLine;
  private List<MessageRecord> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public DataLineMessageSpreadManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSettingForDataLine = new ConfigSettingForDataLine(paramQQAppInterface);
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord, String paramString1, String paramString2, String paramString3, TencentDocDataLineTipsConfigBean.TeamworkKeyWords paramTeamworkKeyWords)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSettingForDataLine.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("DataLineMessageSpreadManager", 1, "last insert time less");
      }
      return;
    }
    if (QLog.isDebugVersion())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("insertGaryTips:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" link:");
      localStringBuilder.append(paramString2);
      QLog.i("DataLineMessageSpreadManager", 1, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSettingForDataLine.a(paramDataLineMsgRecord);
    new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new DataLineMessageSpreadManager.2(this, paramDataLineMsgRecord, paramString1, paramTeamworkKeyWords, paramString2, paramString3), 1000L);
  }
  
  private boolean a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSettingForDataLine.a();
    int j = TencentDocDataLineTipsConfigProcessor.a().a();
    if (j == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DataLineMessageSpreadManager", 1, "config is max: 0, return");
      }
      return false;
    }
    if (i > j)
    {
      if (QLog.isColorLevel())
      {
        paramDataLineMsgRecord = new StringBuilder();
        paramDataLineMsgRecord.append("file count over[");
        paramDataLineMsgRecord.append(i);
        paramDataLineMsgRecord.append("], return");
        QLog.i("DataLineMessageSpreadManager", 1, paramDataLineMsgRecord.toString());
      }
      return false;
    }
    return true;
  }
  
  public void a(TencentDocDataLineTipsConfigBean paramTencentDocDataLineTipsConfigBean)
  {
    this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSettingForDataLine.a(paramTencentDocDataLineTipsConfigBean);
  }
  
  public void a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (QLog.isDebugVersion())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ready to post to SubThread Process， msgUid[");
      localStringBuilder.append(paramDataLineMsgRecord.msgUid);
      localStringBuilder.append("], hashCode:");
      localStringBuilder.append(paramDataLineMsgRecord.hashCode());
      QLog.i("DataLineMessageSpreadManager", 4, localStringBuilder.toString());
      if (paramDataLineMsgRecord.msgUid == 0L) {
        FileManagerUtil.a();
      }
    }
    ThreadManager.executeOnSubThread(new DataLineMessageSpreadManager.1(this, paramDataLineMsgRecord));
  }
  
  public void a(DataLineMsgRecord paramDataLineMsgRecord, Context paramContext)
  {
    paramDataLineMsgRecord = paramDataLineMsgRecord.getExtInfoFromExtStr("tim_aio_file_msg_uiniseq");
    long l;
    try
    {
      l = Long.parseLong(paramDataLineMsgRecord);
    }
    catch (Exception paramDataLineMsgRecord)
    {
      QLog.e("DataLineMessageSpreadManager", 1, paramDataLineMsgRecord.toString());
      l = 0L;
    }
    int i = DataLineMsgRecord.getDevTypeBySeId(l);
    paramDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).a(l);
    if (paramDataLineMsgRecord == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DataLineMessageSpreadManager", 1, "garyTips not find fileMsg");
      }
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80098F8", "0X80098F8", 0, 0, "", "", "", "");
    paramDataLineMsgRecord = paramDataLineMsgRecord.trans2Entity();
    if (paramDataLineMsgRecord == null)
    {
      paramDataLineMsgRecord = new StringBuilder();
      paramDataLineMsgRecord.append("query Entity is nyll!!!, uniseq[");
      paramDataLineMsgRecord.append(l);
      paramDataLineMsgRecord.append("]");
      QLog.e("DataLineMessageSpreadManager", 1, paramDataLineMsgRecord.toString());
      return;
    }
    TeamWorkConvertUtils.a(paramDataLineMsgRecord, paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, i);
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramMessageRecord == null)
    {
      QLog.e("DataLineMessageSpreadManager", 1, FileManagerUtil.a());
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("send file:");
      localStringBuilder.append(paramMessageRecord.msgUid);
      QLog.i("DataLineMessageSpreadManager", 1, localStringBuilder.toString());
    }
    ThreadManager.getUIHandler().postDelayed(new DataLineMessageSpreadManager.3(this), 1000L);
    try
    {
      this.jdField_a_of_type_JavaUtilList.add(paramMessageRecord);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        paramMessageRecord = new StringBuilder();
        paramMessageRecord.append("lastInsertTime[");
        paramMessageRecord.append(this.jdField_a_of_type_Long);
        paramMessageRecord.append("],lstCache size[");
        paramMessageRecord.append(this.jdField_a_of_type_JavaUtilList.size());
        paramMessageRecord.append("]");
        QLog.i("DataLineMessageSpreadManager", 1, paramMessageRecord.toString());
      }
      return;
    }
    finally {}
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.DataLineMessageSpreadManager
 * JD-Core Version:    0.7.0.1
 */