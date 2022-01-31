import android.os.Handler;
import android.os.Message;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class ljm
  implements baug
{
  public ljm(EffectConfigBase paramEffectConfigBase, long paramLong, ljo paramljo) {}
  
  public void onResp(bavf parambavf)
  {
    int i = 0;
    ljo localljo = (ljo)parambavf.jdField_a_of_type_Bave.a();
    String str1 = "";
    if (parambavf.jdField_a_of_type_Int == 3)
    {
      QLog.w(this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_JavaLangString, 1, "startDownload, onResp, 重复下载, item[" + localljo + "], seq[" + this.jdField_a_of_type_Long + "]");
      return;
    }
    boolean bool;
    if (parambavf.jdField_a_of_type_Int != 0)
    {
      str1 = "fail, mErrCode[" + parambavf.b + "], mErrDesc[" + parambavf.jdField_a_of_type_JavaLangString + "]";
      bool = false;
    }
    for (;;)
    {
      QLog.w(this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_JavaLangString, 1, "startDownload, onResp, result[" + bool + "], resp.mResult[" + parambavf.jdField_a_of_type_Int + "], item[" + localljo + "], seq[" + this.jdField_a_of_type_Long + "], " + str1 + "]");
      localljo.isDownloading = false;
      parambavf = this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_AndroidOsHandler;
      if (bool) {
        i = 1;
      }
      parambavf.obtainMessage(1, i, (int)this.jdField_a_of_type_Long, this.jdField_a_of_type_Ljo).sendToTarget();
      if (!bool) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.a(this.jdField_a_of_type_Ljo);
      return;
      String str3 = SecUtil.getFileMd5(parambavf.jdField_a_of_type_Bave.c);
      if (!localljo.getMd5().equalsIgnoreCase(str3))
      {
        str1 = "fail, md5不匹配, fileMD5[" + str3 + "], configMD5[" + localljo.getMd5() + "], mOutPath[" + parambavf.jdField_a_of_type_Bave.c + "]";
        bool = false;
      }
      else
      {
        try
        {
          bdhb.a(parambavf.jdField_a_of_type_Bave.c, this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.b(this.jdField_a_of_type_Ljo), false);
          bool = true;
        }
        catch (IOException localIOException)
        {
          if (QLog.isColorLevel()) {
            QLog.i(this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_JavaLangString, 4, "startDownload, uncompressZip fail.", localIOException);
          }
          String str2 = alud.a(2131704368);
          bool = false;
        }
      }
    }
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, (int)(100L * paramLong1 / paramLong2), 0, this.jdField_a_of_type_Ljo).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ljm
 * JD-Core Version:    0.7.0.1
 */