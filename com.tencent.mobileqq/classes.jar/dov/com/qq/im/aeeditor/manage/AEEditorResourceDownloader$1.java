package dov.com.qq.im.aeeditor.manage;

import bhmi;
import bpds;
import java.io.File;
import java.io.IOException;

public class AEEditorResourceDownloader$1
  implements Runnable
{
  public AEEditorResourceDownloader$1(bpds parambpds) {}
  
  public void run()
  {
    this.this$0.b();
    this.this$0.c();
    String str = this.this$0.b + File.separator + ".nomedia";
    if (!new File(str).exists()) {}
    try
    {
      bhmi.a(str);
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