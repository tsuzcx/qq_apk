package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import ancc;
import ance;
import android.app.Activity;
import appk;
import appl;
import ayfe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import java.util.List;

public class SimpleFilePresenter$1$2
  implements Runnable
{
  public SimpleFilePresenter$1$2(appl paramappl, ancc paramancc, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString1, QQAppInterface paramQQAppInterface, String paramString2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Ancc.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.b)) {}
    for (int i = 2;; i = 1)
    {
      localObject = ancc.a(ayfe.a(this.jdField_a_of_type_JavaLangString, i, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()));
      if (localObject != null)
      {
        if ((((ance)localObject).jdField_a_of_type_JavaUtilList != null) && (((ance)localObject).jdField_a_of_type_JavaUtilList.size() != 0)) {
          break;
        }
        i = ((ance)localObject).jdField_a_of_type_Int;
        this.jdField_a_of_type_Appl.a.a.runOnUiThread(new SimpleFilePresenter.1.2.1(this, i));
      }
      return;
    }
    Object localObject = ((ance)localObject).jdField_a_of_type_JavaUtilList;
    this.jdField_a_of_type_Appl.a.a.runOnUiThread(new SimpleFilePresenter.1.2.2(this, (List)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.1.2
 * JD-Core Version:    0.7.0.1
 */