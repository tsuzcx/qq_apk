package com.tencent.mobileqq.filemanager.core;

import apcs;
import apcu;
import java.util.LinkedHashMap;
import java.util.List;

public class ThumbDownloadManager$3
  implements Runnable
{
  public ThumbDownloadManager$3(apcs paramapcs) {}
  
  public void run()
  {
    if (apcs.a(this.this$0).size() >= 8) {}
    while (apcs.a(this.this$0).size() == 0) {
      return;
    }
    apcu localapcu = (apcu)apcs.a(this.this$0).get(0);
    if (localapcu == null)
    {
      apcs.a(this.this$0).remove(0);
      apcs.a(this.this$0);
      return;
    }
    apcs.a(this.this$0).remove(localapcu);
    apcs.a(this.this$0, localapcu);
    apcs.b(this.this$0, localapcu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.ThumbDownloadManager.3
 * JD-Core Version:    0.7.0.1
 */