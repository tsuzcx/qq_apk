package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class SimpleFileViewer$2
  implements Runnable
{
  public void run()
  {
    if (SimpleFileViewer.a(this.this$0) != null) {
      SimpleFileViewer.a(this.this$0).setVisibility(0);
    }
    do
    {
      do
      {
        return;
      } while ((SimpleFileViewer.a(this.this$0) == null) || (SimpleFileViewer.b(this.this$0) == null));
      localObject = BaseApplicationImpl.sApplication.getRuntime();
    } while (!(localObject instanceof QQAppInterface));
    Object localObject = (QQAppInterface)localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer.2
 * JD-Core Version:    0.7.0.1
 */