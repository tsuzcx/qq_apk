import android.os.Handler;
import android.os.Message;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class kwz
  implements axrt
{
  public kwz(EffectConfigBase paramEffectConfigBase, long paramLong, kxb paramkxb) {}
  
  public void onResp(axsq paramaxsq)
  {
    int i = 0;
    kxb localkxb = (kxb)paramaxsq.jdField_a_of_type_Axsp.a();
    String str1 = "";
    if (paramaxsq.jdField_a_of_type_Int == 3)
    {
      QLog.w(this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_JavaLangString, 1, "startDownload, onResp, 重复下载, item[" + localkxb + "], seq[" + this.jdField_a_of_type_Long + "]");
      return;
    }
    boolean bool;
    if (paramaxsq.jdField_a_of_type_Int != 0)
    {
      str1 = "fail, mErrCode[" + paramaxsq.b + "], mErrDesc[" + paramaxsq.jdField_a_of_type_JavaLangString + "]";
      bool = false;
    }
    for (;;)
    {
      QLog.w(this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_JavaLangString, 1, "startDownload, onResp, result[" + bool + "], resp.mResult[" + paramaxsq.jdField_a_of_type_Int + "], item[" + localkxb + "], seq[" + this.jdField_a_of_type_Long + "], " + str1 + "]");
      localkxb.isDownloading = false;
      paramaxsq = this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_AndroidOsHandler;
      if (bool) {
        i = 1;
      }
      paramaxsq.obtainMessage(1, i, (int)this.jdField_a_of_type_Long, this.jdField_a_of_type_Kxb).sendToTarget();
      if (!bool) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.a(this.jdField_a_of_type_Kxb);
      return;
      String str3 = SecUtil.getFileMd5(paramaxsq.jdField_a_of_type_Axsp.c);
      if (!localkxb.getMd5().equalsIgnoreCase(str3))
      {
        str1 = "fail, md5不匹配, fileMD5[" + str3 + "], configMD5[" + localkxb.getMd5() + "], mOutPath[" + paramaxsq.jdField_a_of_type_Axsp.c + "]";
        bool = false;
      }
      else
      {
        try
        {
          bace.a(paramaxsq.jdField_a_of_type_Axsp.c, this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.b(this.jdField_a_of_type_Kxb), false);
          bool = true;
        }
        catch (IOException localIOException)
        {
          if (QLog.isColorLevel()) {
            QLog.i(this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_JavaLangString, 4, "startDownload, uncompressZip fail.", localIOException);
          }
          String str2 = ajjy.a(2131638188);
          bool = false;
        }
      }
    }
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, (int)(100L * paramLong1 / paramLong2), 0, this.jdField_a_of_type_Kxb).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kwz
 * JD-Core Version:    0.7.0.1
 */