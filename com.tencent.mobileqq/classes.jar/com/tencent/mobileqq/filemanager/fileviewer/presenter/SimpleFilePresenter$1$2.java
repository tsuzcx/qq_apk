package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import anch;
import ancj;
import android.app.Activity;
import appo;
import appp;
import ayfg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import java.util.List;

public class SimpleFilePresenter$1$2
  implements Runnable
{
  public SimpleFilePresenter$1$2(appp paramappp, anch paramanch, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString1, QQAppInterface paramQQAppInterface, String paramString2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Anch.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.b)) {}
    for (int i = 2;; i = 1)
    {
      localObject = anch.a(ayfg.a(this.jdField_a_of_type_JavaLangString, i, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()));
      if (localObject != null)
      {
        if ((((ancj)localObject).jdField_a_of_type_JavaUtilList != null) && (((ancj)localObject).jdField_a_of_type_JavaUtilList.size() != 0)) {
          break;
        }
        i = ((ancj)localObject).jdField_a_of_type_Int;
        this.jdField_a_of_type_Appp.a.a.runOnUiThread(new SimpleFilePresenter.1.2.1(this, i));
      }
      return;
    }
    Object localObject = ((ancj)localObject).jdField_a_of_type_JavaUtilList;
    this.jdField_a_of_type_Appp.a.a.runOnUiThread(new SimpleFilePresenter.1.2.2(this, (List)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.1.2
 * JD-Core Version:    0.7.0.1
 */