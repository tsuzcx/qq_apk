package com.tencent.mobileqq.teamwork;

import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONObject;

class TeamWorkFileImportHandler$6
  implements Runnable
{
  TeamWorkFileImportHandler$6(TeamWorkFileImportHandler paramTeamWorkFileImportHandler, JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    if (TeamWorkFileImportHandler.a(this.this$0) == null) {}
    JSONObject localJSONObject;
    do
    {
      return;
      localJSONObject = TeamWorkHandler.a(this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.c, TeamWorkFileImportHandler.a(this.this$0).getCurrentAccountUin());
    } while (localJSONObject == null);
    TeamWorkFileImportHandler.a(this.this$0, localJSONObject, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.6
 * JD-Core Version:    0.7.0.1
 */