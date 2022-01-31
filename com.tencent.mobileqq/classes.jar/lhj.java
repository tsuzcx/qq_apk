import android.os.Handler;
import android.os.Message;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class lhj
  implements aysc
{
  public lhj(EffectConfigBase paramEffectConfigBase, long paramLong, lhl paramlhl) {}
  
  public void onResp(aysz paramaysz)
  {
    int i = 0;
    lhl locallhl = (lhl)paramaysz.jdField_a_of_type_Aysy.a();
    String str1 = "";
    if (paramaysz.jdField_a_of_type_Int == 3)
    {
      QLog.w(this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_JavaLangString, 1, "startDownload, onResp, 重复下载, item[" + locallhl + "], seq[" + this.jdField_a_of_type_Long + "]");
      return;
    }
    boolean bool;
    if (paramaysz.jdField_a_of_type_Int != 0)
    {
      str1 = "fail, mErrCode[" + paramaysz.b + "], mErrDesc[" + paramaysz.jdField_a_of_type_JavaLangString + "]";
      bool = false;
    }
    for (;;)
    {
      QLog.w(this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_JavaLangString, 1, "startDownload, onResp, result[" + bool + "], resp.mResult[" + paramaysz.jdField_a_of_type_Int + "], item[" + locallhl + "], seq[" + this.jdField_a_of_type_Long + "], " + str1 + "]");
      locallhl.isDownloading = false;
      paramaysz = this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_AndroidOsHandler;
      if (bool) {
        i = 1;
      }
      paramaysz.obtainMessage(1, i, (int)this.jdField_a_of_type_Long, this.jdField_a_of_type_Lhl).sendToTarget();
      if (!bool) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.a(this.jdField_a_of_type_Lhl);
      return;
      String str3 = SecUtil.getFileMd5(paramaysz.jdField_a_of_type_Aysy.c);
      if (!locallhl.getMd5().equalsIgnoreCase(str3))
      {
        str1 = "fail, md5不匹配, fileMD5[" + str3 + "], configMD5[" + locallhl.getMd5() + "], mOutPath[" + paramaysz.jdField_a_of_type_Aysy.c + "]";
        bool = false;
      }
      else
      {
        try
        {
          bbdx.a(paramaysz.jdField_a_of_type_Aysy.c, this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.b(this.jdField_a_of_type_Lhl), false);
          bool = true;
        }
        catch (IOException localIOException)
        {
          if (QLog.isColorLevel()) {
            QLog.i(this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_JavaLangString, 4, "startDownload, uncompressZip fail.", localIOException);
          }
          String str2 = ajya.a(2131703984);
          bool = false;
        }
      }
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, (int)(100L * paramLong1 / paramLong2), 0, this.jdField_a_of_type_Lhl).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lhj
 * JD-Core Version:    0.7.0.1
 */