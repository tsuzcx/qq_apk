package dov.com.qq.im.aeeditor.module.edit;

import bavf;
import bdhb;
import bliu;
import bljn;
import blkb;
import blmq;
import java.io.File;
import java.io.IOException;

public class AEEditorCommonEditFragment$8$1$1
  implements Runnable
{
  public AEEditorCommonEditFragment$8$1$1(blmq paramblmq, bavf parambavf) {}
  
  public void run()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Bavf != null)
    {
      localObject = bliu.a();
      if (this.jdField_a_of_type_Bavf.a == 0) {
        bool = true;
      }
      ((bliu)localObject).a(bool, 2, "AEEditorFilterAIAnimation", "", this.jdField_a_of_type_Bavf.b, this.jdField_a_of_type_Bavf.h);
    }
    Object localObject = blkb.e;
    File localFile = new File((String)localObject);
    if (localFile.exists()) {
      try
      {
        if (!"b9f8fc550f1535b445b564bfbe0d82c5".equalsIgnoreCase(bdhb.c((String)localObject)))
        {
          localFile.delete();
          bljn.d(AEEditorCommonEditFragment.d(), "ae editor lottie download md5 check failed.");
          return;
        }
        bdhb.a((String)localObject, blkb.d, false);
        bdhb.a(blkb.d + File.separator + ".nomedia");
        return;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorCommonEditFragment.8.1.1
 * JD-Core Version:    0.7.0.1
 */