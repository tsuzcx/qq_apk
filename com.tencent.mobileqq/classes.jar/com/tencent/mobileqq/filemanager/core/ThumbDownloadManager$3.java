package com.tencent.mobileqq.filemanager.core;

import aoly;
import aoma;
import java.util.LinkedHashMap;
import java.util.List;

public class ThumbDownloadManager$3
  implements Runnable
{
  public ThumbDownloadManager$3(aoly paramaoly) {}
  
  public void run()
  {
    if (aoly.a(this.this$0).size() >= 8) {}
    while (aoly.a(this.this$0).size() == 0) {
      return;
    }
    aoma localaoma = (aoma)aoly.a(this.this$0).get(0);
    if (localaoma == null)
    {
      aoly.a(this.this$0).remove(0);
      aoly.a(this.this$0);
      return;
    }
    aoly.a(this.this$0).remove(localaoma);
    aoly.a(this.this$0, localaoma);
    aoly.b(this.this$0, localaoma);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.ThumbDownloadManager.3
 * JD-Core Version:    0.7.0.1
 */