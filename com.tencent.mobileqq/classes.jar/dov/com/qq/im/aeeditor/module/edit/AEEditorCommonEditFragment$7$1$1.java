package dov.com.qq.im.aeeditor.module.edit;

import baqw;
import bdcs;
import blen;
import blfg;
import blfu;
import blig;
import java.io.File;
import java.io.IOException;

public class AEEditorCommonEditFragment$7$1$1
  implements Runnable
{
  public AEEditorCommonEditFragment$7$1$1(blig paramblig, baqw parambaqw) {}
  
  public void run()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Baqw != null)
    {
      localObject = blen.a();
      if (this.jdField_a_of_type_Baqw.a == 0) {
        bool = true;
      }
      ((blen)localObject).a(bool, 2, "AEEditorFilterAIAnimation", "", this.jdField_a_of_type_Baqw.b, this.jdField_a_of_type_Baqw.h);
    }
    String str = blfu.e;
    Object localObject = new File(str);
    if (((File)localObject).exists())
    {
      try
      {
        if (!"270bd05f3b639a247bc5c1adf21be6a5".equalsIgnoreCase(bdcs.c(str)))
        {
          ((File)localObject).delete();
          blfg.d(AEEditorCommonEditFragment.d(), "ae editor lottie download md5 check failed.");
          return;
        }
        bdcs.a(str, blfu.d, false);
        bdcs.a(blfu.d + File.separator + ".nomedia");
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
        }
      }
      ((File)localObject).delete();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorCommonEditFragment.7.1.1
 * JD-Core Version:    0.7.0.1
 */