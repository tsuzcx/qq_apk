package com.tencent.mobileqq.filemanager.core;

import apcw;
import apcy;
import java.util.LinkedHashMap;
import java.util.List;

public class ThumbDownloadManager$3
  implements Runnable
{
  public ThumbDownloadManager$3(apcw paramapcw) {}
  
  public void run()
  {
    if (apcw.a(this.this$0).size() >= 8) {}
    while (apcw.a(this.this$0).size() == 0) {
      return;
    }
    apcy localapcy = (apcy)apcw.a(this.this$0).get(0);
    if (localapcy == null)
    {
      apcw.a(this.this$0).remove(0);
      apcw.a(this.this$0);
      return;
    }
    apcw.a(this.this$0).remove(localapcy);
    apcw.a(this.this$0, localapcy);
    apcw.b(this.this$0, localapcy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.ThumbDownloadManager.3
 * JD-Core Version:    0.7.0.1
 */