package com.tencent.mobileqq.teamwork;

import alpo;
import android.os.Handler;
import android.os.Message;
import arof;
import azmj;
import bacn;
import badg;
import bafi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class TeamWorkFileImportHandler$11
  implements Runnable
{
  public TeamWorkFileImportHandler$11(bacn parambacn, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, JSONObject paramJSONObject, int paramInt) {}
  
  public void run()
  {
    if ((this.this$0.app == null) || (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo == null)) {
      return;
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = badg.a(this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo, this.this$0.app.getCurrentAccountUin());
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
      localObject1 = alpo.a(2131715188);
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.e == 3)
      {
        localObject1 = "word";
        l1 = l2 - l1;
        localQQAppInterface = this.this$0.app;
        if (!bool) {
          break label364;
        }
        i = 1;
        azmj.b(localQQAppInterface, "dc00898", "", "", "0X8009958", "0X8009958", 0, i, l1 + "", "", (String)localObject1, (String)localObject3);
        bafi.a("TeamWorkFileImportHandler", "http duration", String.valueOf(l1), this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
        if (bool) {
          break;
        }
        if (!arof.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.c)) {
          break label369;
        }
        this.this$0.c(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo;
        ((TeamWorkFileImportInfo)localObject1).a = false;
        this.this$0.a((TeamWorkFileImportInfo)localObject1);
        return;
      }
      label369:
      if (bacn.a(this.this$0) == null) {
        break;
      }
      Object localObject2 = bacn.a(this.this$0).obtainMessage(8002);
      ((Message)localObject2).obj = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo;
      bacn.a(this.this$0).sendMessage((Message)localObject2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.11
 * JD-Core Version:    0.7.0.1
 */