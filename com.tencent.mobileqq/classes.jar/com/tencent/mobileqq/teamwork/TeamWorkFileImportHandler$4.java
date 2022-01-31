package com.tencent.mobileqq.teamwork;

import bacn;
import badd;
import baej;
import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONObject;

public class TeamWorkFileImportHandler$4
  implements Runnable
{
  public TeamWorkFileImportHandler$4(bacn parambacn, JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    if (this.this$0.app == null) {}
    do
    {
      return;
      localObject = badd.a(this.jdField_a_of_type_OrgJsonJSONObject, this.this$0.app.getCurrentAccountUin());
    } while (localObject == null);
    Object localObject = baej.a((JSONObject)localObject);
    if ((localObject != null) && (((baej)localObject).jdField_a_of_type_JavaLangString != null) && (((baej)localObject).jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.l = ((baej)localObject).b;
      this.this$0.notifyUI(6, true, new Object[] { ((baej)localObject).jdField_a_of_type_JavaLangString, ((baej)localObject).d, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo });
      return;
    }
    this.this$0.notifyUI(7, false, new Object[] { this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.4
 * JD-Core Version:    0.7.0.1
 */