package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import arax;
import araz;
import atri;
import atrn;
import bdiq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;

public class SimpleFilePresenter$InnerTeamWorkFileImportObserver$4
  implements Runnable
{
  public SimpleFilePresenter$InnerTeamWorkFileImportObserver$4(atrn paramatrn, boolean paramBoolean, String paramString1, QQAppInterface paramQQAppInterface, String paramString2) {}
  
  public void run()
  {
    int i;
    if (!this.jdField_a_of_type_Boolean)
    {
      araz localaraz = arax.a(bdiq.a(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
      if (localaraz == null) {
        break label96;
      }
      i = localaraz.a;
    }
    for (;;)
    {
      if (i != -1)
      {
        this.jdField_a_of_type_Atrn.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new SimpleFilePresenter.InnerTeamWorkFileImportObserver.4.1(this, i));
        return;
        i = bdiq.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
      else
      {
        this.jdField_a_of_type_Atrn.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(3);
        return;
        label96:
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.InnerTeamWorkFileImportObserver.4
 * JD-Core Version:    0.7.0.1
 */