package dov.com.qq.im.story;

import com.tencent.mobileqq.vip.DownloaderFactory;
import dov.com.qq.im.capture.IQIMManager;

public class QQStoryForShotManager
  extends IQIMManager
{
  private DownloaderFactory a;
  
  public void onDestroy()
  {
    if (this.a != null) {
      this.a.onDestroy();
    }
  }
  
  public void onInit() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.qq.im.story.QQStoryForShotManager
 * JD-Core Version:    0.7.0.1
 */