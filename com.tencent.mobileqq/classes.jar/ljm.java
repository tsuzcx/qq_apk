import android.os.Handler;
import android.os.Message;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class ljm
  implements bapx
{
  public ljm(EffectConfigBase paramEffectConfigBase, long paramLong, ljo paramljo) {}
  
  public void onResp(baqw parambaqw)
  {
    int i = 0;
    ljo localljo = (ljo)parambaqw.jdField_a_of_type_Baqv.a();
    String str1 = "";
    if (parambaqw.jdField_a_of_type_Int == 3)
    {
      QLog.w(this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_JavaLangString, 1, "startDownload, onResp, 重复下载, item[" + localljo + "], seq[" + this.jdField_a_of_type_Long + "]");
      return;
    }
    boolean bool;
    if (parambaqw.jdField_a_of_type_Int != 0)
    {
      str1 = "fail, mErrCode[" + parambaqw.b + "], mErrDesc[" + parambaqw.jdField_a_of_type_JavaLangString + "]";
      bool = false;
    }
    for (;;)
    {
      QLog.w(this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_JavaLangString, 1, "startDownload, onResp, result[" + bool + "], resp.mResult[" + parambaqw.jdField_a_of_type_Int + "], item[" + localljo + "], seq[" + this.jdField_a_of_type_Long + "], " + str1 + "]");
      localljo.isDownloading = false;
      parambaqw = this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_AndroidOsHandler;
      if (bool) {
        i = 1;
      }
      parambaqw.obtainMessage(1, i, (int)this.jdField_a_of_type_Long, this.jdField_a_of_type_Ljo).sendToTarget();
      if (!bool) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.a(this.jdField_a_of_type_Ljo);
      return;
      String str3 = SecUtil.getFileMd5(parambaqw.jdField_a_of_type_Baqv.c);
      if (!localljo.getMd5().equalsIgnoreCase(str3))
      {
        str1 = "fail, md5不匹配, fileMD5[" + str3 + "], configMD5[" + localljo.getMd5() + "], mOutPath[" + parambaqw.jdField_a_of_type_Baqv.c + "]";
        bool = false;
      }
      else
      {
        try
        {
          bdcs.a(parambaqw.jdField_a_of_type_Baqv.c, this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.b(this.jdField_a_of_type_Ljo), false);
          bool = true;
        }
        catch (IOException localIOException)
        {
          if (QLog.isColorLevel()) {
            QLog.i(this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_JavaLangString, 4, "startDownload, uncompressZip fail.", localIOException);
          }
          String str2 = alpo.a(2131704356);
          bool = false;
        }
      }
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, (int)(100L * paramLong1 / paramLong2), 0, this.jdField_a_of_type_Ljo).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ljm
 * JD-Core Version:    0.7.0.1
 */