package cooperation.vip.ar.util;

import aqdq;
import bkzi;
import blad;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;

public class VipQGLoaderManager$1
  implements Runnable
{
  public VipQGLoaderManager$1(blad paramblad, String paramString1, String paramString2, bkzi parambkzi, aqdq paramaqdq) {}
  
  public void run()
  {
    if (FileUtil.isFileExists(this.jdField_a_of_type_JavaLangString))
    {
      QZLog.i("VipARQGLoaderManager", 1, "getQGModelData file exist save to map");
      if (blad.a(this.this$0) != null) {
        blad.a(this.this$0).put(this.b, this.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_Bkzi != null) {
        this.jdField_a_of_type_Bkzi.a(this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    QZLog.i("VipARQGLoaderManager", 1, "getQGModelData file not exist start to download");
    this.this$0.b(this.jdField_a_of_type_Aqdq, this.jdField_a_of_type_Bkzi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.ar.util.VipQGLoaderManager.1
 * JD-Core Version:    0.7.0.1
 */