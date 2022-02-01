package com.tencent.mobileqq.filemanager.fileviewer;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel;
import java.util.List;

class TroopFileViewerParamParser$1
  implements FileBrowserManager.IModelCreater
{
  TroopFileViewerParamParser$1(TroopFileViewerParamParser paramTroopFileViewerParamParser, BaseActivity paramBaseActivity) {}
  
  public FileBrowserModelBase a()
  {
    List localList = this.b.b();
    if ((localList != null) && (localList.size() > 0)) {
      return new TroopFileModel(this.b.a, this.a, localList, TroopFileViewerParamParser.a(this.b));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.TroopFileViewerParamParser.1
 * JD-Core Version:    0.7.0.1
 */