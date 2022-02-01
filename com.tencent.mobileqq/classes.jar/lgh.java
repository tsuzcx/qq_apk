import android.os.Handler;
import android.os.Message;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class lgh
  implements bdvw
{
  public lgh(EffectConfigBase paramEffectConfigBase, long paramLong, lgj paramlgj) {}
  
  public void onResp(bdwt parambdwt)
  {
    int i = 0;
    lgj locallgj = (lgj)parambdwt.jdField_a_of_type_Bdws.a();
    String str1 = "";
    if (parambdwt.jdField_a_of_type_Int == 3)
    {
      QLog.w(this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_JavaLangString, 1, "startDownload, onResp, 重复下载, item[" + locallgj + "], seq[" + this.jdField_a_of_type_Long + "]");
      return;
    }
    boolean bool;
    if (parambdwt.jdField_a_of_type_Int != 0)
    {
      str1 = "fail, mErrCode[" + parambdwt.b + "], mErrDesc[" + parambdwt.jdField_a_of_type_JavaLangString + "]";
      bool = false;
    }
    for (;;)
    {
      QLog.w(this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_JavaLangString, 1, "startDownload, onResp, result[" + bool + "], resp.mResult[" + parambdwt.jdField_a_of_type_Int + "], item[" + locallgj + "], seq[" + this.jdField_a_of_type_Long + "], " + str1 + "]");
      locallgj.isDownloading = false;
      parambdwt = this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_AndroidOsHandler;
      if (bool) {
        i = 1;
      }
      parambdwt.obtainMessage(1, i, (int)this.jdField_a_of_type_Long, this.jdField_a_of_type_Lgj).sendToTarget();
      if (!bool) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.a(this.jdField_a_of_type_Lgj);
      return;
      String str3 = SecUtil.getFileMd5(parambdwt.jdField_a_of_type_Bdws.c);
      if (!locallgj.getMd5().equalsIgnoreCase(str3))
      {
        str1 = "fail, md5不匹配, fileMD5[" + str3 + "], configMD5[" + locallgj.getMd5() + "], mOutPath[" + parambdwt.jdField_a_of_type_Bdws.c + "]";
        bool = false;
      }
      else
      {
        try
        {
          bgmg.a(parambdwt.jdField_a_of_type_Bdws.c, this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.b(this.jdField_a_of_type_Lgj), false);
          bool = true;
        }
        catch (IOException localIOException)
        {
          if (QLog.isColorLevel()) {
            QLog.i(this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_JavaLangString, 4, "startDownload, uncompressZip fail.", localIOException);
          }
          String str2 = anni.a(2131702765);
          bool = false;
        }
      }
    }
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, (int)(100L * paramLong1 / paramLong2), 0, this.jdField_a_of_type_Lgj).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lgh
 * JD-Core Version:    0.7.0.1
 */