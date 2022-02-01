package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.TeamWorkHandler;
import org.json.JSONObject;

class SimpleFilePresenter$InnerTeamWorkFileImportObserver$1
  implements Runnable
{
  SimpleFilePresenter$InnerTeamWorkFileImportObserver$1(SimpleFilePresenter.InnerTeamWorkFileImportObserver paramInnerTeamWorkFileImportObserver, String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    JSONObject localJSONObject = TeamWorkHandler.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterSimpleFilePresenter$InnerTeamWorkFileImportObserver.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.m());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterSimpleFilePresenter$InnerTeamWorkFileImportObserver.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new SimpleFilePresenter.InnerTeamWorkFileImportObserver.1.1(this));
    SimpleFilePresenter.InnerTeamWorkFileImportObserver.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterSimpleFilePresenter$InnerTeamWorkFileImportObserver, localJSONObject, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.InnerTeamWorkFileImportObserver.1
 * JD-Core Version:    0.7.0.1
 */