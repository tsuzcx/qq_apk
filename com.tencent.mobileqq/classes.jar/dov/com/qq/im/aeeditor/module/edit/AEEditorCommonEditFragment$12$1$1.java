package dov.com.qq.im.aeeditor.module.edit;

import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import dov.com.qq.im.aeeditor.AEEditorPath.AISCENE.FILES;
import java.io.File;
import java.io.IOException;

class AEEditorCommonEditFragment$12$1$1
  implements Runnable
{
  AEEditorCommonEditFragment$12$1$1(AEEditorCommonEditFragment.12.1 param1, NetResp paramNetResp) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp != null) {}
    String str = AEEditorPath.AISCENE.FILES.f;
    File localFile = new File(str);
    if (localFile.exists()) {
      try
      {
        if (!"af390e47be752494ceec242e3108ba3b".equalsIgnoreCase(FileUtils.c(str)))
        {
          localFile.delete();
          return;
        }
        FileUtils.a(str, AEEditorPath.AISCENE.FILES.d, false);
        FileUtils.a(AEEditorPath.AISCENE.FILES.d + File.separator + ".nomedia");
        return;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorCommonEditFragment.12.1.1
 * JD-Core Version:    0.7.0.1
 */