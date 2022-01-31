import android.os.Handler;
import android.os.Message;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class lho
  implements aysa
{
  public lho(EffectConfigBase paramEffectConfigBase, long paramLong, lhq paramlhq) {}
  
  public void onResp(aysx paramaysx)
  {
    int i = 0;
    lhq locallhq = (lhq)paramaysx.jdField_a_of_type_Aysw.a();
    String str1 = "";
    if (paramaysx.jdField_a_of_type_Int == 3)
    {
      QLog.w(this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_JavaLangString, 1, "startDownload, onResp, 重复下载, item[" + locallhq + "], seq[" + this.jdField_a_of_type_Long + "]");
      return;
    }
    boolean bool;
    if (paramaysx.jdField_a_of_type_Int != 0)
    {
      str1 = "fail, mErrCode[" + paramaysx.b + "], mErrDesc[" + paramaysx.jdField_a_of_type_JavaLangString + "]";
      bool = false;
    }
    for (;;)
    {
      QLog.w(this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_JavaLangString, 1, "startDownload, onResp, result[" + bool + "], resp.mResult[" + paramaysx.jdField_a_of_type_Int + "], item[" + locallhq + "], seq[" + this.jdField_a_of_type_Long + "], " + str1 + "]");
      locallhq.isDownloading = false;
      paramaysx = this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_AndroidOsHandler;
      if (bool) {
        i = 1;
      }
      paramaysx.obtainMessage(1, i, (int)this.jdField_a_of_type_Long, this.jdField_a_of_type_Lhq).sendToTarget();
      if (!bool) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.a(this.jdField_a_of_type_Lhq);
      return;
      String str3 = SecUtil.getFileMd5(paramaysx.jdField_a_of_type_Aysw.c);
      if (!locallhq.getMd5().equalsIgnoreCase(str3))
      {
        str1 = "fail, md5不匹配, fileMD5[" + str3 + "], configMD5[" + locallhq.getMd5() + "], mOutPath[" + paramaysx.jdField_a_of_type_Aysw.c + "]";
        bool = false;
      }
      else
      {
        try
        {
          bbdj.a(paramaysx.jdField_a_of_type_Aysw.c, this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.b(this.jdField_a_of_type_Lhq), false);
          bool = true;
        }
        catch (IOException localIOException)
        {
          if (QLog.isColorLevel()) {
            QLog.i(this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_JavaLangString, 4, "startDownload, uncompressZip fail.", localIOException);
          }
          String str2 = ajyc.a(2131703973);
          bool = false;
        }
      }
    }
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, (int)(100L * paramLong1 / paramLong2), 0, this.jdField_a_of_type_Lhq).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lho
 * JD-Core Version:    0.7.0.1
 */