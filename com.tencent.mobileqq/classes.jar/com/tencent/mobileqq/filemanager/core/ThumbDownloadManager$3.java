package com.tencent.mobileqq.filemanager.core;

import atgs;
import atgu;
import java.util.LinkedHashMap;
import java.util.List;

public class ThumbDownloadManager$3
  implements Runnable
{
  public ThumbDownloadManager$3(atgs paramatgs) {}
  
  public void run()
  {
    if (atgs.a(this.this$0).size() >= 8) {}
    while (atgs.a(this.this$0).size() == 0) {
      return;
    }
    atgu localatgu = (atgu)atgs.a(this.this$0).get(0);
    if (localatgu == null)
    {
      atgs.a(this.this$0).remove(0);
      atgs.a(this.this$0);
      return;
    }
    atgs.a(this.this$0).remove(localatgu);
    atgs.a(this.this$0, localatgu);
    atgs.b(this.this$0, localatgu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.ThumbDownloadManager.3
 * JD-Core Version:    0.7.0.1
 */