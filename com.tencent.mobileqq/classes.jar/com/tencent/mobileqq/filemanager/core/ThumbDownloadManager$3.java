package com.tencent.mobileqq.filemanager.core;

import java.util.LinkedHashMap;
import java.util.List;

class ThumbDownloadManager$3
  implements Runnable
{
  ThumbDownloadManager$3(ThumbDownloadManager paramThumbDownloadManager) {}
  
  public void run()
  {
    if (ThumbDownloadManager.b(this.this$0).size() >= 8) {
      return;
    }
    if (ThumbDownloadManager.c(this.this$0).size() == 0) {
      return;
    }
    ThumbDownloadManager.ThumbTask localThumbTask = (ThumbDownloadManager.ThumbTask)ThumbDownloadManager.c(this.this$0).get(0);
    if (localThumbTask == null)
    {
      ThumbDownloadManager.c(this.this$0).remove(0);
      ThumbDownloadManager.a(this.this$0);
      return;
    }
    ThumbDownloadManager.c(this.this$0).remove(localThumbTask);
    ThumbDownloadManager.a(this.this$0, localThumbTask);
    ThumbDownloadManager.b(this.this$0, localThumbTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.ThumbDownloadManager.3
 * JD-Core Version:    0.7.0.1
 */