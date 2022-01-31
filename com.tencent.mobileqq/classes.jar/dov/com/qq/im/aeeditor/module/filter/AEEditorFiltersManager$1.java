package dov.com.qq.im.aeeditor.module.filter;

import bdhb;
import blnt;
import java.io.File;
import java.io.IOException;

public class AEEditorFiltersManager$1
  implements Runnable
{
  public AEEditorFiltersManager$1(blnt paramblnt) {}
  
  public void run()
  {
    blnt.a(this.this$0);
    blnt.b(this.this$0);
    String str = blnt.c() + File.separator + ".nomedia";
    if (!new File(str).exists()) {}
    try
    {
      bdhb.a(str);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.filter.AEEditorFiltersManager.1
 * JD-Core Version:    0.7.0.1
 */