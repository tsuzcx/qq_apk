package com.tencent.mobileqq.extendfriend.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import com.tencent.biz.ProtoUtils.TroopGiftProtocolObserver;
import com.tencent.mobileqq.extendfriend.bean.StrangerInfo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;

class ExtendFriendProfileEditFragment$5$1
  extends ProtoUtils.TroopGiftProtocolObserver
{
  ExtendFriendProfileEditFragment$5$1(ExtendFriendProfileEditFragment.5 param5, boolean paramBoolean) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    boolean bool = true;
    if (paramInt != 0)
    {
      QLog.e("ExtendFriendHandler", 1, "setShowVipIconSwitch error: " + paramInt);
      ExtendFriendProfileEditFragment.a(this.a.a).setOnCheckedChangeListener(null);
      paramArrayOfByte = ExtendFriendProfileEditFragment.a(this.a.a);
      if (!this.b) {}
      for (bool = true;; bool = false)
      {
        paramArrayOfByte.setChecked(bool);
        ExtendFriendProfileEditFragment.a(this.a.a).setOnCheckedChangeListener(ExtendFriendProfileEditFragment.a(this.a.a));
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandler", 2, "setShowVipIconSwitch(" + this.b + ") success");
    }
    paramArrayOfByte = (StrangerInfo)ExtendFriendProfileEditFragment.a(this.a.a).getTag();
    if (paramArrayOfByte != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendHandler", 2, "StrangerInfo not null");
      }
      if (this.b) {
        break label227;
      }
    }
    for (;;)
    {
      paramArrayOfByte.mVipHide = bool;
      VipUtils.a(paramArrayOfByte, ExtendFriendProfileEditFragment.a(this.a.a));
      paramArrayOfByte = this.a.a.getActivity();
      if (paramArrayOfByte == null) {
        break;
      }
      paramArrayOfByte.setResult(8193);
      return;
      label227:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment.5.1
 * JD-Core Version:    0.7.0.1
 */