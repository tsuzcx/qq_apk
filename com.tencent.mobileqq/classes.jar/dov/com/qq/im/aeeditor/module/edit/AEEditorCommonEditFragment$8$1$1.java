package dov.com.qq.im.aeeditor.module.edit;

import bdwt;
import bgmg;
import bnyh;
import bnzb;
import bnzs;
import boei;
import java.io.File;
import java.io.IOException;

public class AEEditorCommonEditFragment$8$1$1
  implements Runnable
{
  public AEEditorCommonEditFragment$8$1$1(boei paramboei, bdwt parambdwt) {}
  
  public void run()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Bdwt != null)
    {
      localObject = bnyh.a();
      if (this.jdField_a_of_type_Bdwt.a == 0) {
        bool = true;
      }
      ((bnyh)localObject).a(bool, 2, "AEEditorFilterAIAnimation", "", this.jdField_a_of_type_Bdwt.b, this.jdField_a_of_type_Bdwt.g);
    }
    Object localObject = bnzs.e;
    File localFile = new File((String)localObject);
    if (localFile.exists()) {
      try
      {
        if (!"b9f8fc550f1535b445b564bfbe0d82c5".equalsIgnoreCase(bgmg.c((String)localObject)))
        {
          localFile.delete();
          bnzb.d(AEEditorCommonEditFragment.d(), "ae editor lottie download md5 check failed.");
          return;
        }
        bgmg.a((String)localObject, bnzs.d, false);
        bgmg.a(bnzs.d + File.separator + ".nomedia");
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