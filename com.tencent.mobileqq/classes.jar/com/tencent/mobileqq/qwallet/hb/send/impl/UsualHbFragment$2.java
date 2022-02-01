package com.tencent.mobileqq.qwallet.hb.send.impl;

import Wallet.SkinInfo;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.HbBusiUtils;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.HbSkinInfo;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.HbSkinLogic.ItemSelectListener;

class UsualHbFragment$2
  implements HbSkinLogic.ItemSelectListener
{
  UsualHbFragment$2(UsualHbFragment paramUsualHbFragment) {}
  
  public void a(HbSkinInfo paramHbSkinInfo)
  {
    if ((paramHbSkinInfo.a.skin_id != 0) && (paramHbSkinInfo.a.skin_id != -2))
    {
      if (TextUtils.isEmpty(paramHbSkinInfo.a.blessing))
      {
        this.a.c.setHint(HardCodeUtil.a(R.string.L));
        return;
      }
      this.a.c.setHint(paramHbSkinInfo.a.blessing);
      return;
    }
    paramHbSkinInfo = HbBusiUtils.a(this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqQwalletHbHbInfo$BundleInfo, this.a.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.getConfigLogic(), paramHbSkinInfo.a.blessing);
    this.a.c.setHint(paramHbSkinInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.UsualHbFragment.2
 * JD-Core Version:    0.7.0.1
 */