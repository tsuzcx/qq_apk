package com.tencent.mobileqq.filemanager.core;

import atym;
import atyo;
import java.util.LinkedHashMap;
import java.util.List;

public class ThumbDownloadManager$3
  implements Runnable
{
  public ThumbDownloadManager$3(atym paramatym) {}
  
  public void run()
  {
    if (atym.a(this.this$0).size() >= 8) {}
    while (atym.a(this.this$0).size() == 0) {
      return;
    }
    atyo localatyo = (atyo)atym.a(this.this$0).get(0);
    if (localatyo == null)
    {
      atym.a(this.this$0).remove(0);
      atym.a(this.this$0);
      return;
    }
    atym.a(this.this$0).remove(localatyo);
    atym.a(this.this$0, localatyo);
    atym.b(this.this$0, localatyo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.ThumbDownloadManager.3
 * JD-Core Version:    0.7.0.1
 */