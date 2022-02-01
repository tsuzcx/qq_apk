package com.tencent.mobileqq.teamwork.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.bean.ImportFormData;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import org.json.JSONObject;

class TeamWorkFileImportHandlerImpl$4
  implements Runnable
{
  TeamWorkFileImportHandlerImpl$4(TeamWorkFileImportHandlerImpl paramTeamWorkFileImportHandlerImpl, JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    if (TeamWorkFileImportHandlerImpl.access$000(this.this$0) == null) {
      return;
    }
    Object localObject = ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).checkFormCache(this.jdField_a_of_type_OrgJsonJSONObject, TeamWorkFileImportHandlerImpl.access$000(this.this$0).getCurrentAccountUin());
    if (localObject != null)
    {
      localObject = ImportFormData.a((JSONObject)localObject);
      if ((localObject != null) && (((ImportFormData)localObject).jdField_a_of_type_JavaLangString != null) && (((ImportFormData)localObject).jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.l = ((ImportFormData)localObject).b;
        this.this$0.notifyUI(6, true, new Object[] { ((ImportFormData)localObject).jdField_a_of_type_JavaLangString, ((ImportFormData)localObject).d, this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo });
        return;
      }
      this.this$0.notifyUI(7, false, new Object[] { this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo });
      return;
    }
    this.this$0.notifyUIError(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.TeamWorkFileImportHandlerImpl.4
 * JD-Core Version:    0.7.0.1
 */