package com.tencent.mobileqq.teamwork.api.impl;

import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class TeamWorkFileImportHandlerImpl$11
  implements Runnable
{
  TeamWorkFileImportHandlerImpl$11(TeamWorkFileImportHandlerImpl paramTeamWorkFileImportHandlerImpl, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, JSONObject paramJSONObject, int paramInt) {}
  
  public void run()
  {
    if (TeamWorkFileImportHandlerImpl.access$000(this.this$0) != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo == null) {
        return;
      }
      long l1 = System.currentTimeMillis();
      Object localObject1 = ((ITeamWorkHttpUtils)QRoute.api(ITeamWorkHttpUtils.class)).uploadFileInfoForH5(this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo, TeamWorkFileImportHandlerImpl.access$000(this.this$0).getCurrentAccountUin());
      long l2 = System.currentTimeMillis();
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_k_of_type_Int != this.jdField_a_of_type_Int)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("this job has dropped ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
        QLog.w("TeamWorkFileImportHandlerImpl", 2, ((StringBuilder)localObject1).toString());
        return;
      }
      boolean bool;
      String str;
      if (localObject1 != null)
      {
        bool = this.this$0.parseFileImportResultForH5((String)localObject1, this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo);
        try
        {
          str = new JSONObject((String)localObject1).getString("url");
        }
        catch (Exception localException)
        {
          QLog.e("TeamWorkFileImportHandlerImpl", 1, localException.toString());
          str = "";
        }
      }
      else
      {
        str = "";
        bool = false;
      }
      Object localObject2 = HardCodeUtil.a(2131714606);
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.e == 3) {
        localObject2 = "word";
      }
      for (;;)
      {
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.e == 6) {
          localObject2 = "excel";
        } else if (this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.e == 7) {
          localObject2 = "ppt";
        } else if (this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.e == 9) {
          localObject2 = "pdf";
        }
      }
      l1 = l2 - l1;
      AppInterface localAppInterface = TeamWorkFileImportHandlerImpl.access$000(this.this$0);
      int i;
      if (bool) {
        i = 1;
      } else {
        i = 2;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(l1);
      localStringBuilder.append("");
      ReportController.b(localAppInterface, "dc00898", "", "", "0X8009958", "0X8009958", 0, i, localStringBuilder.toString(), "", (String)localObject2, str);
      TenDocLogReportHelper.a("TeamWorkFileImportHandlerImpl", "http duration", String.valueOf(l1), this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
      if (!bool)
      {
        if (FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.c))
        {
          this.this$0.removeFileImporting(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo;
          ((TeamWorkFileImportInfo)localObject2).a = false;
          this.this$0.addFileImportJob((TeamWorkFileImportInfo)localObject2);
          return;
        }
        if (TeamWorkFileImportHandlerImpl.access$100(this.this$0) != null)
        {
          localObject2 = TeamWorkFileImportHandlerImpl.access$100(this.this$0).obtainMessage(8002);
          ((Message)localObject2).obj = this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo;
          TeamWorkFileImportHandlerImpl.access$100(this.this$0).sendMessage((Message)localObject2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.TeamWorkFileImportHandlerImpl.11
 * JD-Core Version:    0.7.0.1
 */