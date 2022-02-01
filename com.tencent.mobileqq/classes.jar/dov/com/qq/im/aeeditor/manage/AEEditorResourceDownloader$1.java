package dov.com.qq.im.aeeditor.manage;

import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.io.IOException;

class AEEditorResourceDownloader$1
  implements Runnable
{
  AEEditorResourceDownloader$1(AEEditorResourceDownloader paramAEEditorResourceDownloader) {}
  
  public void run()
  {
    this.this$0.c();
    this.this$0.a();
    String str = this.this$0.b + File.separator + ".nomedia";
    if (!new File(str).exists()) {}
    try
    {
      FileUtils.a(str);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.manage.AEEditorResourceDownloader.1
 * JD-Core Version:    0.7.0.1
 */