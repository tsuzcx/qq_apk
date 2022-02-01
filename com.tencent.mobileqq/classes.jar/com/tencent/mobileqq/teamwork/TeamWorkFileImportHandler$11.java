package com.tencent.mobileqq.teamwork;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class TeamWorkFileImportHandler$11
  implements Runnable
{
  TeamWorkFileImportHandler$11(TeamWorkFileImportHandler paramTeamWorkFileImportHandler, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, JSONObject paramJSONObject, int paramInt) {}
  
  public void run()
  {
    if ((TeamWorkFileImportHandler.a(this.this$0) == null) || (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo == null)) {
      return;
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = TeamWorkHttpUtils.a(this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo, TeamWorkFileImportHandler.a(this.this$0).getCurrentAccountUin());
    long l2 = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_k_of_type_Int != this.jdField_a_of_type_Int)
    {
      QLog.w("TeamWorkFileImportHandler", 2, "this job has dropped " + this.jdField_a_of_type_Int);
      return;
    }
    Object localObject3 = "";
    if (localObject1 != null) {}
    for (boolean bool = this.this$0.a((String)localObject1, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);; bool = false)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1).getString("url");
        localObject3 = localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QQAppInterface localQQAppInterface;
          int i;
          QLog.e("TeamWorkFileImportHandler", 1, localException.toString());
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.e == 6)
          {
            localObject2 = "excel";
          }
          else if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.e == 7)
          {
            localObject2 = "ppt";
          }
          else if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.e == 9)
          {
            localObject2 = "pdf";
            continue;
            label364:
            i = 2;
          }
        }
      }
      localObject1 = HardCodeUtil.a(2131714684);
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.e == 3)
      {
        localObject1 = "word";
        l1 = l2 - l1;
        localQQAppInterface = TeamWorkFileImportHandler.a(this.this$0);
        if (!bool) {
          break label364;
        }
        i = 1;
        ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8009958", "0X8009958", 0, i, l1 + "", "", (String)localObject1, (String)localObject3);
        TenDocLogReportHelper.a("TeamWorkFileImportHandler", "http duration", String.valueOf(l1), this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
        if (bool) {
          break;
        }
        if (!FileUtil.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.c)) {
          break label369;
        }
        this.this$0.c(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo;
        ((TeamWorkFileImportInfo)localObject1).a = false;
        this.this$0.a((TeamWorkFileImportInfo)localObject1);
        return;
      }
      label369:
      if (TeamWorkFileImportHandler.a(this.this$0) == null) {
        break;
      }
      Object localObject2 = TeamWorkFileImportHandler.a(this.this$0).obtainMessage(8002);
      ((Message)localObject2).obj = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo;
      TeamWorkFileImportHandler.a(this.this$0).sendMessage((Message)localObject2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.11
 * JD-Core Version:    0.7.0.1
 */