package com.tencent.mobileqq.filemanager.core;

import atpc;
import atpe;
import java.util.LinkedHashMap;
import java.util.List;

public class ThumbDownloadManager$3
  implements Runnable
{
  public ThumbDownloadManager$3(atpc paramatpc) {}
  
  public void run()
  {
    if (atpc.a(this.this$0).size() >= 8) {}
    while (atpc.a(this.this$0).size() == 0) {
      return;
    }
    atpe localatpe = (atpe)atpc.a(this.this$0).get(0);
    if (localatpe == null)
    {
      atpc.a(this.this$0).remove(0);
      atpc.a(this.this$0);
      return;
    }
    atpc.a(this.this$0).remove(localatpe);
    atpc.a(this.this$0, localatpe);
    atpc.b(this.this$0, localatpe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.ThumbDownloadManager.3
 * JD-Core Version:    0.7.0.1
 */