package com.tencent.mobileqq.teamwork;

import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONObject;

class TeamWorkFileImportHandler$5
  implements Runnable
{
  TeamWorkFileImportHandler$5(TeamWorkFileImportHandler paramTeamWorkFileImportHandler, JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    if (TeamWorkFileImportHandler.a(this.this$0) == null) {}
    JSONObject localJSONObject;
    do
    {
      return;
      localJSONObject = TeamWorkHandler.b(this.jdField_a_of_type_OrgJsonJSONObject, TeamWorkFileImportHandler.a(this.this$0).getCurrentAccountUin());
    } while (localJSONObject == null);
    TeamWorkFileImportHandler.a(this.this$0, localJSONObject, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.5
 * JD-Core Version:    0.7.0.1
 */