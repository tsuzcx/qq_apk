package com.tencent.mobileqq.filebrowser.presenter;

import android.app.Activity;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import org.json.JSONObject;

class DocFilePresenter$InnerTeamWorkFileImportObserver$1
  implements Runnable
{
  DocFilePresenter$InnerTeamWorkFileImportObserver$1(DocFilePresenter.InnerTeamWorkFileImportObserver paramInnerTeamWorkFileImportObserver, String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    JSONObject localJSONObject = TeamWorkHandlerUtils.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilebrowserPresenterDocFilePresenter$InnerTeamWorkFileImportObserver.a.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a());
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserPresenterDocFilePresenter$InnerTeamWorkFileImportObserver.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new DocFilePresenter.InnerTeamWorkFileImportObserver.1.1(this));
    DocFilePresenter.InnerTeamWorkFileImportObserver.a(this.jdField_a_of_type_ComTencentMobileqqFilebrowserPresenterDocFilePresenter$InnerTeamWorkFileImportObserver, localJSONObject, this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.DocFilePresenter.InnerTeamWorkFileImportObserver.1
 * JD-Core Version:    0.7.0.1
 */