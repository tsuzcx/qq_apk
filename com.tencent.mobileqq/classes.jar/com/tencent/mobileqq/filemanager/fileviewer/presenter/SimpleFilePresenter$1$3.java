package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import aoto;
import aotq;
import arin;
import ario;
import badd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;

public class SimpleFilePresenter$1$3
  implements Runnable
{
  public SimpleFilePresenter$1$3(ario paramario, boolean paramBoolean, String paramString1, QQAppInterface paramQQAppInterface, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString2) {}
  
  public void run()
  {
    int i;
    if (!this.jdField_a_of_type_Boolean)
    {
      aotq localaotq = aoto.a(badd.a(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
      if (localaotq == null) {
        break label81;
      }
      i = localaotq.a;
    }
    for (;;)
    {
      if (i != -1) {
        this.jdField_a_of_type_Ario.a.a.runOnUiThread(new SimpleFilePresenter.1.3.1(this, i));
      }
      return;
      i = badd.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      continue;
      label81:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.1.3
 * JD-Core Version:    0.7.0.1
 */