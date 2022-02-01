package com.tencent.mobileqq.fragment;

import android.widget.CompoundButton;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.AppletsHandler;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class AppletsSettingFragment$4
  implements AppletsSettingFragment.OnChangeSwitchListener
{
  AppletsSettingFragment$4(AppletsSettingFragment paramAppletsSettingFragment) {}
  
  public void a(CompoundButton paramCompoundButton, boolean paramBoolean, AppletItem paramAppletItem)
  {
    int i = 1;
    ArrayList localArrayList;
    if (paramAppletItem != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppletsSettingFragment", 2, "OnChangeSwitchListener onChangeSwitchListener " + paramAppletItem.toString() + ",  isChecked:" + paramBoolean);
      }
      this.a.a(true);
      paramCompoundButton.setChecked(paramBoolean);
      paramCompoundButton = (AppletsHandler)AppletsSettingFragment.a(this.a).getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER);
      localArrayList = new ArrayList();
      if (!paramBoolean) {
        break label113;
      }
    }
    for (;;)
    {
      paramAppletItem.a(i);
      localArrayList.add(paramAppletItem);
      paramCompoundButton.a(localArrayList);
      return;
      label113:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.AppletsSettingFragment.4
 * JD-Core Version:    0.7.0.1
 */