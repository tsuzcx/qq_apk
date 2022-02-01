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
    if ((paramHbSkinInfo.f.skin_id != 0) && (paramHbSkinInfo.f.skin_id != -2))
    {
      if (TextUtils.isEmpty(paramHbSkinInfo.f.blessing))
      {
        this.a.l.setHint(HardCodeUtil.a(R.string.L));
        return;
      }
      this.a.l.setHint(paramHbSkinInfo.f.blessing);
      return;
    }
    paramHbSkinInfo = HbBusiUtils.a(this.a.i, this.a.m, this.a.f.getConfigLogic(), paramHbSkinInfo.f.blessing);
    this.a.l.setHint(paramHbSkinInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.UsualHbFragment.2
 * JD-Core Version:    0.7.0.1
 */