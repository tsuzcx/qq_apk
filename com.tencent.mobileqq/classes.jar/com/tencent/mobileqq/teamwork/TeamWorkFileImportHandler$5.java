package com.tencent.mobileqq.teamwork;

import beav;
import bebl;
import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONObject;

public class TeamWorkFileImportHandler$5
  implements Runnable
{
  public TeamWorkFileImportHandler$5(beav parambeav, JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    if (this.this$0.app == null) {}
    JSONObject localJSONObject;
    do
    {
      return;
      localJSONObject = bebl.b(this.jdField_a_of_type_OrgJsonJSONObject, this.this$0.app.getCurrentAccountUin());
    } while (localJSONObject == null);
    beav.a(this.this$0, localJSONObject, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.5
 * JD-Core Version:    0.7.0.1
 */