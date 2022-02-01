import android.os.Handler;
import android.os.Message;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class lgj
  implements INetEngine.INetEngineListener
{
  public lgj(EffectConfigBase paramEffectConfigBase, long paramLong, lgl paramlgl) {}
  
  public void onResp(NetResp paramNetResp)
  {
    int i = 0;
    lgl locallgl = (lgl)paramNetResp.mReq.getUserData();
    String str1 = "";
    if (paramNetResp.mResult == 3)
    {
      QLog.w(this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_JavaLangString, 1, "startDownload, onResp, 重复下载, item[" + locallgl + "], seq[" + this.jdField_a_of_type_Long + "]");
      return;
    }
    boolean bool;
    if (paramNetResp.mResult != 0)
    {
      str1 = "fail, mErrCode[" + paramNetResp.mErrCode + "], mErrDesc[" + paramNetResp.mErrDesc + "]";
      bool = false;
    }
    for (;;)
    {
      QLog.w(this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_JavaLangString, 1, "startDownload, onResp, result[" + bool + "], resp.mResult[" + paramNetResp.mResult + "], item[" + locallgl + "], seq[" + this.jdField_a_of_type_Long + "], " + str1 + "]");
      locallgl.isDownloading = false;
      paramNetResp = this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_AndroidOsHandler;
      if (bool) {
        i = 1;
      }
      paramNetResp.obtainMessage(1, i, (int)this.jdField_a_of_type_Long, this.jdField_a_of_type_Lgl).sendToTarget();
      if (!bool) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.a(this.jdField_a_of_type_Lgl);
      return;
      String str3 = SecUtil.getFileMd5(paramNetResp.mReq.mOutPath);
      if (!locallgl.getMd5().equalsIgnoreCase(str3))
      {
        str1 = "fail, md5不匹配, fileMD5[" + str3 + "], configMD5[" + locallgl.getMd5() + "], mOutPath[" + paramNetResp.mReq.mOutPath + "]";
        bool = false;
      }
      else
      {
        try
        {
          FileUtils.uncompressZip(paramNetResp.mReq.mOutPath, this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.b(this.jdField_a_of_type_Lgl), false);
          bool = true;
        }
        catch (IOException localIOException)
        {
          if (QLog.isColorLevel()) {
            QLog.i(this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_JavaLangString, 4, "startDownload, uncompressZip fail.", localIOException);
          }
          String str2 = amtj.a(2131703102);
          bool = false;
        }
      }
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, (int)(100L * paramLong1 / paramLong2), 0, this.jdField_a_of_type_Lgl).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lgj
 * JD-Core Version:    0.7.0.1
 */