package com.tencent.mobileqq.teamwork;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.bean.ImportFormData;
import org.json.JSONObject;

class TeamWorkFileImportHandler$4
  implements Runnable
{
  TeamWorkFileImportHandler$4(TeamWorkFileImportHandler paramTeamWorkFileImportHandler, JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    if (TeamWorkFileImportHandler.a(this.this$0) == null) {
      return;
    }
    Object localObject = TeamWorkHandler.a(this.jdField_a_of_type_OrgJsonJSONObject, TeamWorkFileImportHandler.a(this.this$0).getCurrentAccountUin());
    if (localObject != null)
    {
      localObject = ImportFormData.a((JSONObject)localObject);
      if ((localObject != null) && (((ImportFormData)localObject).jdField_a_of_type_JavaLangString != null) && (((ImportFormData)localObject).jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.l = ((ImportFormData)localObject).b;
        this.this$0.notifyUI(6, true, new Object[] { ((ImportFormData)localObject).jdField_a_of_type_JavaLangString, ((ImportFormData)localObject).d, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo });
        return;
      }
      this.this$0.notifyUI(7, false, new Object[] { this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo });
      return;
    }
    this.this$0.d(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.4
 * JD-Core Version:    0.7.0.1
 */