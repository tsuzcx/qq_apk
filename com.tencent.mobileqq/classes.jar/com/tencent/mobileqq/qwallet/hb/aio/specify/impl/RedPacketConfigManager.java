package com.tencent.mobileqq.qwallet.hb.aio.specify.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;

public class RedPacketConfigManager
{
  private static volatile RedPacketConfigManager a;
  private static final String[] b = { HardCodeUtil.a(R.string.cy), HardCodeUtil.a(R.string.cp), HardCodeUtil.a(R.string.cb) };
  private static final String[] c = { HardCodeUtil.a(R.string.cu), HardCodeUtil.a(R.string.cq), HardCodeUtil.a(R.string.cf) };
  
  public static RedPacketConfigManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new RedPacketConfigManager();
        }
      }
      finally {}
    }
    return a;
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
  
  public boolean b()
  {
    Object localObject = QWalletTools.b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.specify.impl.RedPacketConfigManager
 * JD-Core Version:    0.7.0.1
 */