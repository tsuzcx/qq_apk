package com.tencent.mobileqq.filemanager.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SendBottomBar$3
  implements View.OnClickListener
{
  SendBottomBar$3(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131698205));
    ((StringBuilder)localObject).append(FMDataCache.b());
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131698206));
    localObject = ((StringBuilder)localObject).toString();
    String str2 = HardCodeUtil.a(2131698177);
    String str1;
    if (SendBottomBar.a(this.a).g() != -1)
    {
      localObject = HardCodeUtil.a(2131698178);
      str1 = HardCodeUtil.a(2131698180);
      str2 = HardCodeUtil.a(2131698179);
    }
    else
    {
      str1 = null;
    }
    SendBottomBar localSendBottomBar = this.a;
    localSendBottomBar.a = DialogUtil.a(SendBottomBar.a(localSendBottomBar), 230, str1, (CharSequence)localObject, HardCodeUtil.a(2131690728), str2, new SendBottomBar.3.1(this), new SendBottomBar.3.2(this));
    this.a.a.show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.SendBottomBar.3
 * JD-Core Version:    0.7.0.1
 */