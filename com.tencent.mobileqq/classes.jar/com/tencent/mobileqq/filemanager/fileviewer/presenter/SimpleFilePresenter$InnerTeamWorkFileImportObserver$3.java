package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import arax;
import araz;
import atri;
import atrn;
import bdiq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import java.util.List;

public class SimpleFilePresenter$InnerTeamWorkFileImportObserver$3
  implements Runnable
{
  public SimpleFilePresenter$InnerTeamWorkFileImportObserver$3(atrn paramatrn, arax paramarax, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString1, QQAppInterface paramQQAppInterface, String paramString2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Arax.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.b)) {}
    for (int i = 2;; i = 1)
    {
      localObject = arax.a(bdiq.a(this.jdField_a_of_type_JavaLangString, i, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()));
      if (localObject == null) {
        break label122;
      }
      if ((((araz)localObject).jdField_a_of_type_JavaUtilList != null) && (((araz)localObject).jdField_a_of_type_JavaUtilList.size() != 0)) {
        break;
      }
      i = ((araz)localObject).jdField_a_of_type_Int;
      this.jdField_a_of_type_Atrn.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new SimpleFilePresenter.InnerTeamWorkFileImportObserver.3.1(this, i));
      return;
    }
    Object localObject = ((araz)localObject).jdField_a_of_type_JavaUtilList;
    this.jdField_a_of_type_Atrn.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new SimpleFilePresenter.InnerTeamWorkFileImportObserver.3.2(this, (List)localObject));
    return;
    label122:
    this.jdField_a_of_type_Atrn.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.InnerTeamWorkFileImportObserver.3
 * JD-Core Version:    0.7.0.1
 */