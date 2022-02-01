package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import atoo;
import atri;
import atrn;
import bdiq;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import org.json.JSONObject;

public class SimpleFilePresenter$InnerTeamWorkFileImportObserver$1
  implements Runnable
{
  public SimpleFilePresenter$InnerTeamWorkFileImportObserver$1(atrn paramatrn, String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    JSONObject localJSONObject = bdiq.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Atrn.a.jdField_a_of_type_Atoo.m());
    this.jdField_a_of_type_Atrn.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new SimpleFilePresenter.InnerTeamWorkFileImportObserver.1.1(this));
    atrn.a(this.jdField_a_of_type_Atrn, localJSONObject, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.InnerTeamWorkFileImportObserver.1
 * JD-Core Version:    0.7.0.1
 */