package com.tencent.mobileqq.teamwork;

import beav;
import bebl;
import becr;
import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONObject;

public class TeamWorkFileImportHandler$4
  implements Runnable
{
  public TeamWorkFileImportHandler$4(beav parambeav, JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    if (this.this$0.app == null) {
      return;
    }
    Object localObject = bebl.a(this.jdField_a_of_type_OrgJsonJSONObject, this.this$0.app.getCurrentAccountUin());
    if (localObject != null)
    {
      localObject = becr.a((JSONObject)localObject);
      if ((localObject != null) && (((becr)localObject).jdField_a_of_type_JavaLangString != null) && (((becr)localObject).jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.l = ((becr)localObject).b;
        this.this$0.notifyUI(6, true, new Object[] { ((becr)localObject).jdField_a_of_type_JavaLangString, ((becr)localObject).d, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo });
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