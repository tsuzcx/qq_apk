package com.tencent.mobileqq.filemanager.core;

import arad;
import araf;
import java.util.LinkedHashMap;
import java.util.List;

public class ThumbDownloadManager$3
  implements Runnable
{
  public ThumbDownloadManager$3(arad paramarad) {}
  
  public void run()
  {
    if (arad.a(this.this$0).size() >= 8) {}
    while (arad.a(this.this$0).size() == 0) {
      return;
    }
    araf localaraf = (araf)arad.a(this.this$0).get(0);
    if (localaraf == null)
    {
      arad.a(this.this$0).remove(0);
      arad.a(this.this$0);
      return;
    }
    arad.a(this.this$0).remove(localaraf);
    arad.a(this.this$0, localaraf);
    arad.b(this.this$0, localaraf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.ThumbDownloadManager.3
 * JD-Core Version:    0.7.0.1
 */