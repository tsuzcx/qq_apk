package cooperation.comic;

import android.os.Bundle;
import com.tencent.mobileqq.config.business.QQComicConfBean.BoodoHippyConfig;
import com.tencent.mobileqq.config.business.QQComicConfBean.IPExpressionConfig;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class VipComicConfigHelper$2
  implements EIPCResultCallback
{
  VipComicConfigHelper$2(VipComicConfigHelper.InitIpExpressConfigListener paramInitIpExpressConfigListener) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult == null) || (paramEIPCResult.data == null)) {}
    do
    {
      return;
      VipComicConfigHelper.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$IPExpressionConfig = (QQComicConfBean.IPExpressionConfig)paramEIPCResult.data.getSerializable("ipExpressionConfig");
      if (this.a != null) {
        this.a.a(VipComicConfigHelper.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$IPExpressionConfig);
      }
      VipComicConfigHelper.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$BoodoHippyConfig = (QQComicConfBean.BoodoHippyConfig)paramEIPCResult.data.getSerializable("hippyConfig");
    } while (!QLog.isColorLevel());
    QLog.d("VipComicConfigHelper", 2, " ipExpressionConfig" + VipComicConfigHelper.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$IPExpressionConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.VipComicConfigHelper.2
 * JD-Core Version:    0.7.0.1
 */