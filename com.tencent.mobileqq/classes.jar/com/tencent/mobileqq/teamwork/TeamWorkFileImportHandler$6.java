package com.tencent.mobileqq.teamwork;

import bagw;
import bahm;
import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONObject;

public class TeamWorkFileImportHandler$6
  implements Runnable
{
  public TeamWorkFileImportHandler$6(bagw parambagw, JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    if (this.this$0.app == null) {}
    JSONObject localJSONObject;
    do
    {
      return;
      localJSONObject = bahm.a(this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.c, this.this$0.app.getCurrentAccountUin());
    } while (localJSONObject == null);
    bagw.a(this.this$0, localJSONObject, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.6
 * JD-Core Version:    0.7.0.1
 */