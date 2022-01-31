import android.os.Handler;
import android.os.Message;
import com.tencent.av.AVLog;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.business.manager.EffectConfigBase.ItemBase;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

public class jhf
  implements INetEngine.INetEngineListener
{
  public jhf(EffectConfigBase paramEffectConfigBase, EffectConfigBase.ItemBase paramItemBase) {}
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.a.obtainMessage(2, (int)(100L * paramLong1 / paramLong2), 0, this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase$ItemBase).sendToTarget();
  }
  
  public void a(NetResp paramNetResp)
  {
    EffectConfigBase.ItemBase localItemBase = (EffectConfigBase.ItemBase)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.a();
    AVLog.c("EffectConfigBase", "download file call back. file = " + localItemBase.getResurl());
    int i;
    if (paramNetResp.jdField_a_of_type_Int != 0)
    {
      AVLog.c("EffectConfigBase", "download file faild. errcode = " + paramNetResp.b + "|" + paramNetResp.jdField_a_of_type_JavaLangString);
      i = 0;
      paramNetResp = this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.a;
      if (i == 0) {
        break label227;
      }
    }
    label227:
    for (int j = 1;; j = 0)
    {
      for (;;)
      {
        paramNetResp.obtainMessage(1, j, 0, this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase$ItemBase).sendToTarget();
        if (i != 0) {
          this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.b(this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase$ItemBase);
        }
        return;
        if (!localItemBase.getMd5().equalsIgnoreCase(SecUtil.getFileMd5(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c)))
        {
          AVLog.c("EffectConfigBase", "download file faild : md5 is not match.");
          FileUtils.d(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c);
          i = 0;
          break;
        }
        AVLog.c("EffectConfigBase", "download file successed.");
        try
        {
          FileUtils.a(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c, this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.b(this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase$ItemBase), false);
          i = 1;
        }
        catch (IOException paramNetResp)
        {
          paramNetResp.printStackTrace();
          AVLog.c("EffectConfigBase", "unzip file faild.");
          i = 0;
        }
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jhf
 * JD-Core Version:    0.7.0.1
 */