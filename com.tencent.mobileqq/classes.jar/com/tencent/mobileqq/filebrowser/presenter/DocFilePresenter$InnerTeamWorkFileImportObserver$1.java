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
    JSONObject localJSONObject = TeamWorkHandlerUtils.a(this.a, this.c.a.c.f());
    this.c.a.e.runOnUiThread(new DocFilePresenter.InnerTeamWorkFileImportObserver.1.1(this));
    DocFilePresenter.InnerTeamWorkFileImportObserver.a(this.c, localJSONObject, this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.DocFilePresenter.InnerTeamWorkFileImportObserver.1
 * JD-Core Version:    0.7.0.1
 */