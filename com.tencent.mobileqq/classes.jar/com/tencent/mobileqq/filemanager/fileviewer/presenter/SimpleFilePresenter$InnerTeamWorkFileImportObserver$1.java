package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import atxa;
import atzu;
import atzz;
import becb;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import org.json.JSONObject;

public class SimpleFilePresenter$InnerTeamWorkFileImportObserver$1
  implements Runnable
{
  public SimpleFilePresenter$InnerTeamWorkFileImportObserver$1(atzz paramatzz, String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    JSONObject localJSONObject = becb.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Atzz.a.jdField_a_of_type_Atxa.m());
    this.jdField_a_of_type_Atzz.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new SimpleFilePresenter.InnerTeamWorkFileImportObserver.1.1(this));
    atzz.a(this.jdField_a_of_type_Atzz, localJSONObject, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.InnerTeamWorkFileImportObserver.1
 * JD-Core Version:    0.7.0.1
 */