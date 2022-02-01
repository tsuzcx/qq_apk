package cooperation.vip.ar.util;

import argx;
import bmlm;
import bmmh;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;

public class VipQGLoaderManager$1
  implements Runnable
{
  public VipQGLoaderManager$1(bmmh parambmmh, String paramString1, String paramString2, bmlm parambmlm, argx paramargx) {}
  
  public void run()
  {
    if (FileUtil.isFileExists(this.jdField_a_of_type_JavaLangString))
    {
      QZLog.i("VipARQGLoaderManager", 1, "getQGModelData file exist save to map");
      if (bmmh.a(this.this$0) != null) {
        bmmh.a(this.this$0).put(this.b, this.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_Bmlm != null) {
        this.jdField_a_of_type_Bmlm.a(this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    QZLog.i("VipARQGLoaderManager", 1, "getQGModelData file not exist start to download");
    this.this$0.b(this.jdField_a_of_type_Argx, this.jdField_a_of_type_Bmlm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.ar.util.VipQGLoaderManager.1
 * JD-Core Version:    0.7.0.1
 */