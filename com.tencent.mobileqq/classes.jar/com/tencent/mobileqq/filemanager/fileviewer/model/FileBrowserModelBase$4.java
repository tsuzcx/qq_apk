package com.tencent.mobileqq.filemanager.fileviewer.model;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IMiniCodeApi;

class FileBrowserModelBase$4
  implements Runnable
{
  FileBrowserModelBase$4(FileBrowserModelBase paramFileBrowserModelBase) {}
  
  public void run()
  {
    ((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).unInit(hashCode(), "MiniCode_FileBrowser");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.4
 * JD-Core Version:    0.7.0.1
 */