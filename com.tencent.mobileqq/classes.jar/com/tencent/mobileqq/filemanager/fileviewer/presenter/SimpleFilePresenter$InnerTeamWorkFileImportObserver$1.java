package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import org.json.JSONObject;

class SimpleFilePresenter$InnerTeamWorkFileImportObserver$1
  implements Runnable
{
  SimpleFilePresenter$InnerTeamWorkFileImportObserver$1(SimpleFilePresenter.InnerTeamWorkFileImportObserver paramInnerTeamWorkFileImportObserver, String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    JSONObject localJSONObject = TeamWorkHandlerUtils.a(this.a, this.c.a.c.ag());
    this.c.a.d.runOnUiThread(new SimpleFilePresenter.InnerTeamWorkFileImportObserver.1.1(this));
    SimpleFilePresenter.InnerTeamWorkFileImportObserver.a(this.c, localJSONObject, this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.InnerTeamWorkFileImportObserver.1
 * JD-Core Version:    0.7.0.1
 */