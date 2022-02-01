package com.tencent.mobileqq.qwallet.hb.send.busylogic.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.qwallet.hb.aio.elem.IRedPacket.OnGetSkinListener;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfoBase;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter;
import java.util.List;

class HbSkinLogic$2
  implements IRedPacket.OnGetSkinListener
{
  HbSkinLogic$2(HbSkinLogic paramHbSkinLogic) {}
  
  public void onGetSkin(RedPacketInfoBase paramRedPacketInfoBase)
  {
    HbSkinInfo localHbSkinInfo = HbSkinInfo.HbSkinFactory.a(HbSkinLogic.a(this.a), paramRedPacketInfoBase.skinId);
    if (localHbSkinInfo != null)
    {
      List localList = HbSkinLogic.a(this.a).getList();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("redl iscache = ");
        localStringBuilder.append(HbSkinInfo.jdField_a_of_type_Boolean);
        localStringBuilder.append(" info.iscache = ");
        localStringBuilder.append(paramRedPacketInfoBase.isCache);
        QLog.d("HbSkinLogic", 2, localStringBuilder.toString());
      }
      if ((HbSkinInfo.jdField_a_of_type_Boolean == paramRedPacketInfoBase.isCache) && (!localList.contains(localHbSkinInfo)))
      {
        if ((paramRedPacketInfoBase.background == null) && (paramRedPacketInfoBase.animInfo == null)) {
          return;
        }
        if (TextUtils.isEmpty(paramRedPacketInfoBase.title)) {
          paramRedPacketInfoBase.title = HbSkinLogic.a();
        }
        localHbSkinInfo.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemRedPacketInfoBase = paramRedPacketInfoBase;
        if (QLog.isColorLevel()) {
          QLog.d("HbSkinLogic", 2, "redl add to list show!");
        }
        localList.add(localHbSkinInfo);
        HbSkinInfo.a(localList);
        HbSkinLogic.a(this.a).notifyDataSetChanged();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("HbSkinLogic", 2, "no add in list...");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.HbSkinLogic.2
 * JD-Core Version:    0.7.0.1
 */