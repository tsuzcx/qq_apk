package dov.com.qq.im.aeeditor.module.edit;

import bmbc;
import bmbx;
import bmcx;
import bmht;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.io.IOException;

public class AEEditorCommonEditFragment$8$1$1
  implements Runnable
{
  public AEEditorCommonEditFragment$8$1$1(bmht parambmht, NetResp paramNetResp) {}
  
  public void run()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp != null)
    {
      localObject = bmbc.a();
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.mResult == 0) {
        bool = true;
      }
      ((bmbc)localObject).a(bool, 2, "AEEditorFilterAIAnimation", "", this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.mErrCode, this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.reqCost);
    }
    Object localObject = bmcx.e;
    File localFile = new File((String)localObject);
    if (localFile.exists()) {
      try
      {
        if (!"b9f8fc550f1535b445b564bfbe0d82c5".equalsIgnoreCase(FileUtils.calcMd5((String)localObject)))
        {
          localFile.delete();
          bmbx.d(AEEditorCommonEditFragment.c(), "ae editor lottie download md5 check failed.");
          return;
        }
        FileUtils.uncompressZip((String)localObject, bmcx.d, false);
        FileUtils.createFile(bmcx.d + File.separator + ".nomedia");
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