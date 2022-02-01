package com.tencent.mobileqq.filemanager.fileviewer.model;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IMiniCodeApi;

class FileBrowserModelBase$3
  implements Runnable
{
  FileBrowserModelBase$3(FileBrowserModelBase paramFileBrowserModelBase) {}
  
  public void run()
  {
    ((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).init(this.this$0.a, hashCode(), "MiniCode_FileBrowser");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.3
 * JD-Core Version:    0.7.0.1
 */