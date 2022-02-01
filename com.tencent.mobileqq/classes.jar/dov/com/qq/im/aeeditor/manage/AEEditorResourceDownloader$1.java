package dov.com.qq.im.aeeditor.manage;

import bmfc;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.io.IOException;

public class AEEditorResourceDownloader$1
  implements Runnable
{
  public AEEditorResourceDownloader$1(bmfc parambmfc) {}
  
  public void run()
  {
    this.this$0.b();
    this.this$0.c();
    String str = this.this$0.b + File.separator + ".nomedia";
    if (!new File(str).exists()) {}
    try
    {
      FileUtils.createFile(str);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.manage.AEEditorResourceDownloader.1
 * JD-Core Version:    0.7.0.1
 */