package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import anch;
import ancj;
import android.app.Activity;
import appo;
import appp;
import ayfg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;

public class SimpleFilePresenter$1$3
  implements Runnable
{
  public SimpleFilePresenter$1$3(appp paramappp, boolean paramBoolean, String paramString1, QQAppInterface paramQQAppInterface, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString2) {}
  
  public void run()
  {
    int i;
    if (!this.jdField_a_of_type_Boolean)
    {
      ancj localancj = anch.a(ayfg.a(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
      if (localancj == null) {
        break label81;
      }
      i = localancj.a;
    }
    for (;;)
    {
      if (i != -1) {
        this.jdField_a_of_type_Appp.a.a.runOnUiThread(new SimpleFilePresenter.1.3.1(this, i));
      }
      return;
      i = ayfg.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      continue;
      label81:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.1.3
 * JD-Core Version:    0.7.0.1
 */