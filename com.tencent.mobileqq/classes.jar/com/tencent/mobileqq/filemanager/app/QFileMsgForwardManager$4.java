package com.tencent.mobileqq.filemanager.app;

import aowt;
import aoxq;
import java.util.HashMap;

public class QFileMsgForwardManager$4
  implements Runnable
{
  public void run()
  {
    aoxq localaoxq = null;
    if (aowt.a(this.this$0).containsKey(Long.valueOf(this.a))) {
      localaoxq = (aoxq)aowt.a(this.this$0).get(Long.valueOf(this.a));
    }
    if (localaoxq != null)
    {
      localaoxq.b();
      localaoxq.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.4
 * JD-Core Version:    0.7.0.1
 */