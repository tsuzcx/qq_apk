package com.tencent.mobileqq.qwallet.hb.aio.specify.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;

public class RedPacketConfigManager
{
  private static volatile RedPacketConfigManager jdField_a_of_type_ComTencentMobileqqQwalletHbAioSpecifyImplRedPacketConfigManager;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { HardCodeUtil.a(R.string.cv), HardCodeUtil.a(R.string.cm), HardCodeUtil.a(R.string.bY) };
  private static final String[] b = { HardCodeUtil.a(R.string.cr), HardCodeUtil.a(R.string.cn), HardCodeUtil.a(R.string.cc) };
  
  public static RedPacketConfigManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqQwalletHbAioSpecifyImplRedPacketConfigManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqQwalletHbAioSpecifyImplRedPacketConfigManager == null) {
          jdField_a_of_type_ComTencentMobileqqQwalletHbAioSpecifyImplRedPacketConfigManager = new RedPacketConfigManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqQwalletHbAioSpecifyImplRedPacketConfigManager;
  }
  
  public int a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (paramBaseQQAppInterface != null)
    {
      paramBaseQQAppInterface = (IQWalletConfigService)paramBaseQQAppInterface.getRuntimeService(IQWalletConfigService.class, "");
      if (paramBaseQQAppInterface != null) {
        return paramBaseQQAppInterface.getInt("hb_exclusive", 1, new String[] { "ani_queue_max" });
      }
    }
    return 1;
  }
  
  public boolean a()
  {
    Object localObject = QWalletTools.a();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = (IQWalletConfigService)((BaseQQAppInterface)localObject).getRuntimeService(IQWalletConfigService.class, "");
      bool1 = bool2;
      if (localObject != null)
      {
        if (((IQWalletConfigService)localObject).getInt("hb_exclusive", 1, new String[] { "is_display_all" }) == 1) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.specify.impl.RedPacketConfigManager
 * JD-Core Version:    0.7.0.1
 */