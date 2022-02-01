package com.tencent.mobileqq.teamwork;

import bebl;
import becb;
import bedh;
import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONObject;

public class TeamWorkFileImportHandler$4
  implements Runnable
{
  public TeamWorkFileImportHandler$4(bebl parambebl, JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    if (this.this$0.app == null) {
      return;
    }
    Object localObject = becb.a(this.jdField_a_of_type_OrgJsonJSONObject, this.this$0.app.getCurrentAccountUin());
    if (localObject != null)
    {
      localObject = bedh.a((JSONObject)localObject);
      if ((localObject != null) && (((bedh)localObject).jdField_a_of_type_JavaLangString != null) && (((bedh)localObject).jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.l = ((bedh)localObject).b;
        this.this$0.notifyUI(6, true, new Object[] { ((bedh)localObject).jdField_a_of_type_JavaLangString, ((bedh)localObject).d, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo });
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