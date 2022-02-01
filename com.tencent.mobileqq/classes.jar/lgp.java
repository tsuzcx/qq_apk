import android.os.Handler;
import android.os.Message;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class lgp
  implements beuq
{
  public lgp(EffectConfigBase paramEffectConfigBase, long paramLong, lgr paramlgr) {}
  
  public void onResp(bevm parambevm)
  {
    int i = 0;
    lgr locallgr = (lgr)parambevm.jdField_a_of_type_Bevl.a();
    String str1 = "";
    if (parambevm.jdField_a_of_type_Int == 3)
    {
      QLog.w(this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_JavaLangString, 1, "startDownload, onResp, 重复下载, item[" + locallgr + "], seq[" + this.jdField_a_of_type_Long + "]");
      return;
    }
    boolean bool;
    if (parambevm.jdField_a_of_type_Int != 0)
    {
      str1 = "fail, mErrCode[" + parambevm.b + "], mErrDesc[" + parambevm.jdField_a_of_type_JavaLangString + "]";
      bool = false;
    }
    for (;;)
    {
      QLog.w(this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_JavaLangString, 1, "startDownload, onResp, result[" + bool + "], resp.mResult[" + parambevm.jdField_a_of_type_Int + "], item[" + locallgr + "], seq[" + this.jdField_a_of_type_Long + "], " + str1 + "]");
      locallgr.isDownloading = false;
      parambevm = this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_AndroidOsHandler;
      if (bool) {
        i = 1;
      }
      parambevm.obtainMessage(1, i, (int)this.jdField_a_of_type_Long, this.jdField_a_of_type_Lgr).sendToTarget();
      if (!bool) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.a(this.jdField_a_of_type_Lgr);
      return;
      String str3 = SecUtil.getFileMd5(parambevm.jdField_a_of_type_Bevl.c);
      if (!locallgr.getMd5().equalsIgnoreCase(str3))
      {
        str1 = "fail, md5不匹配, fileMD5[" + str3 + "], configMD5[" + locallgr.getMd5() + "], mOutPath[" + parambevm.jdField_a_of_type_Bevl.c + "]";
        bool = false;
      }
      else
      {
        try
        {
          bhmi.a(parambevm.jdField_a_of_type_Bevl.c, this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.b(this.jdField_a_of_type_Lgr), false);
          bool = true;
        }
        catch (IOException localIOException)
        {
          if (QLog.isColorLevel()) {
            QLog.i(this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_JavaLangString, 4, "startDownload, uncompressZip fail.", localIOException);
          }
          String str2 = anzj.a(2131702872);
          bool = false;
        }
      }
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, (int)(100L * paramLong1 / paramLong2), 0, this.jdField_a_of_type_Lgr).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lgp
 * JD-Core Version:    0.7.0.1
 */