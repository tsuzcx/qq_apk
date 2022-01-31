package com.tencent.mobileqq.filemanager.app;

import aowt;
import aoxq;
import java.util.HashMap;

public class QFileMsgForwardManager$3
  implements Runnable
{
  public QFileMsgForwardManager$3(aowt paramaowt, String paramString) {}
  
  public void run()
  {
    aoxq localaoxq = null;
    if (aowt.a(this.this$0).containsKey(this.a)) {
      localaoxq = (aoxq)aowt.a(this.this$0).get(this.a);
    }
    if (localaoxq != null) {
      localaoxq.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.3
 * JD-Core Version:    0.7.0.1
 */