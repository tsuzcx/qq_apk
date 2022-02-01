package com.tencent.mobileqq.filemanageraux.widget;

import aulr;
import becb;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class DocCooperationBanner$2
  implements Runnable
{
  public DocCooperationBanner$2(aulr paramaulr, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void run()
  {
    Object localObject = "";
    String str1 = "";
    String str2;
    String str3;
    if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Int == 0)
    {
      str1 = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString;
      str2 = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.b;
      str3 = this.jdField_a_of_type_JavaLangString;
      if (!this.jdField_a_of_type_Boolean) {
        break label89;
      }
    }
    label89:
    for (int i = 2;; i = 1)
    {
      localObject = becb.a(str2, str3, i, (String)localObject, str1, this.b);
      if (localObject != null) {
        QLog.i("DocCooperationBanner", 2, ((JSONObject)localObject).toString());
      }
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.widget.DocCooperationBanner.2
 * JD-Core Version:    0.7.0.1
 */