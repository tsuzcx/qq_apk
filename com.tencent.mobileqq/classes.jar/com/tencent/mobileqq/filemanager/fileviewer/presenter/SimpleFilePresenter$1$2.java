package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import aoto;
import aotq;
import arin;
import ario;
import badd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import java.util.List;

public class SimpleFilePresenter$1$2
  implements Runnable
{
  public SimpleFilePresenter$1$2(ario paramario, aoto paramaoto, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString1, QQAppInterface paramQQAppInterface, String paramString2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Aoto.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.b)) {}
    for (int i = 2;; i = 1)
    {
      localObject = aoto.a(badd.a(this.jdField_a_of_type_JavaLangString, i, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()));
      if (localObject != null)
      {
        if ((((aotq)localObject).jdField_a_of_type_JavaUtilList != null) && (((aotq)localObject).jdField_a_of_type_JavaUtilList.size() != 0)) {
          break;
        }
        i = ((aotq)localObject).jdField_a_of_type_Int;
        this.jdField_a_of_type_Ario.a.a.runOnUiThread(new SimpleFilePresenter.1.2.1(this, i));
      }
      return;
    }
    Object localObject = ((aotq)localObject).jdField_a_of_type_JavaUtilList;
    this.jdField_a_of_type_Ario.a.a.runOnUiThread(new SimpleFilePresenter.1.2.2(this, (List)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.1.2
 * JD-Core Version:    0.7.0.1
 */