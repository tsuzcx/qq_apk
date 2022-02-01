package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import augj;
import aujd;
import auji;
import bebl;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import org.json.JSONObject;

public class SimpleFilePresenter$InnerTeamWorkFileImportObserver$1
  implements Runnable
{
  public SimpleFilePresenter$InnerTeamWorkFileImportObserver$1(auji paramauji, String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    JSONObject localJSONObject = bebl.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Auji.a.jdField_a_of_type_Augj.m());
    this.jdField_a_of_type_Auji.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new SimpleFilePresenter.InnerTeamWorkFileImportObserver.1.1(this));
    auji.a(this.jdField_a_of_type_Auji, localJSONObject, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.InnerTeamWorkFileImportObserver.1
 * JD-Core Version:    0.7.0.1
 */