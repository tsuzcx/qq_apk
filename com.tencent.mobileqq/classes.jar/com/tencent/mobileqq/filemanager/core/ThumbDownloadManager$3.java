package com.tencent.mobileqq.filemanager.core;

import askw;
import asky;
import java.util.LinkedHashMap;
import java.util.List;

public class ThumbDownloadManager$3
  implements Runnable
{
  public ThumbDownloadManager$3(askw paramaskw) {}
  
  public void run()
  {
    if (askw.a(this.this$0).size() >= 8) {}
    while (askw.a(this.this$0).size() == 0) {
      return;
    }
    asky localasky = (asky)askw.a(this.this$0).get(0);
    if (localasky == null)
    {
      askw.a(this.this$0).remove(0);
      askw.a(this.this$0);
      return;
    }
    askw.a(this.this$0).remove(localasky);
    askw.a(this.this$0, localasky);
    askw.b(this.this$0, localasky);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.ThumbDownloadManager.3
 * JD-Core Version:    0.7.0.1
 */