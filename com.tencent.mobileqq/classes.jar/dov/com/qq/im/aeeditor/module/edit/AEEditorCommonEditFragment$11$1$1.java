package dov.com.qq.im.aeeditor.module.edit;

import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.AEEditorPath.AISCENE.FILES;
import java.io.File;
import java.io.IOException;

class AEEditorCommonEditFragment$11$1$1
  implements Runnable
{
  AEEditorCommonEditFragment$11$1$1(AEEditorCommonEditFragment.11.1 param1, NetResp paramNetResp) {}
  
  public void run()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp != null)
    {
      localObject = AEBaseDataReporter.a();
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.mResult == 0) {
        bool = true;
      }
      ((AEBaseDataReporter)localObject).a(bool, 2, "AEEditorFilterAIAnimation", "", this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.mErrCode, this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.reqCost);
    }
    Object localObject = AEEditorPath.AISCENE.FILES.e;
    File localFile = new File((String)localObject);
    if (localFile.exists()) {
      try
      {
        if (!"b9f8fc550f1535b445b564bfbe0d82c5".equalsIgnoreCase(FileUtils.c((String)localObject)))
        {
          localFile.delete();
          AEQLog.d(AEEditorCommonEditFragment.c(), "ae editor lottie download md5 check failed.");
          return;
        }
        FileUtils.a((String)localObject, AEEditorPath.AISCENE.FILES.d, false);
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
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorCommonEditFragment.11.1.1
 * JD-Core Version:    0.7.0.1
 */