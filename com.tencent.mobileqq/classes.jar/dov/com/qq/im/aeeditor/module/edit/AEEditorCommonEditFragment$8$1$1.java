package dov.com.qq.im.aeeditor.module.edit;

import bevm;
import bhmi;
import bozr;
import bpam;
import bpbn;
import bpgd;
import java.io.File;
import java.io.IOException;

public class AEEditorCommonEditFragment$8$1$1
  implements Runnable
{
  public AEEditorCommonEditFragment$8$1$1(bpgd parambpgd, bevm parambevm) {}
  
  public void run()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Bevm != null)
    {
      localObject = bozr.a();
      if (this.jdField_a_of_type_Bevm.a == 0) {
        bool = true;
      }
      ((bozr)localObject).a(bool, 2, "AEEditorFilterAIAnimation", "", this.jdField_a_of_type_Bevm.b, this.jdField_a_of_type_Bevm.g);
    }
    Object localObject = bpbn.e;
    File localFile = new File((String)localObject);
    if (localFile.exists()) {
      try
      {
        if (!"b9f8fc550f1535b445b564bfbe0d82c5".equalsIgnoreCase(bhmi.c((String)localObject)))
        {
          localFile.delete();
          bpam.d(AEEditorCommonEditFragment.d(), "ae editor lottie download md5 check failed.");
          return;
        }
        bhmi.a((String)localObject, bpbn.d, false);
        bhmi.a(bpbn.d + File.separator + ".nomedia");
        return;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorCommonEditFragment.8.1.1
 * JD-Core Version:    0.7.0.1
 */