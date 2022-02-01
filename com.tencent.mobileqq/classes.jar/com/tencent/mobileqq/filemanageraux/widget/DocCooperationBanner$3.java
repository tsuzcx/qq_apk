package com.tencent.mobileqq.filemanageraux.widget;

import com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class DocCooperationBanner$3
  implements Runnable
{
  DocCooperationBanner$3(DocCooperationBanner paramDocCooperationBanner, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void run()
  {
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_Int == 0)
    {
      str1 = this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString;
      localObject = "";
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString;
      str1 = "";
    }
    String str2 = this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.b;
    String str3 = this.jdField_a_of_type_JavaLangString;
    int i;
    if (this.jdField_a_of_type_Boolean) {
      i = 2;
    } else {
      i = 1;
    }
    Object localObject = TeamWorkHandlerUtils.a(str2, str3, i, (String)localObject, str1, this.b);
    if (localObject != null) {
      QLog.i("DocCooperationBanner", 2, ((JSONObject)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.widget.DocCooperationBanner.3
 * JD-Core Version:    0.7.0.1
 */