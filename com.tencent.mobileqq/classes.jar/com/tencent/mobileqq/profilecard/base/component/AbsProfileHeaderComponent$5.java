package com.tencent.mobileqq.profilecard.base.component;

import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.ZanDoubleDialog.BtnClickListener;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class AbsProfileHeaderComponent$5
  implements ZanDoubleDialog.BtnClickListener
{
  AbsProfileHeaderComponent$5(AbsProfileHeaderComponent paramAbsProfileHeaderComponent) {}
  
  public void onLeftClick()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsProfileHeaderComponent", 2, "ZanDoubleDialog: onLeftClick: ");
    }
    if (AbsProfileHeaderComponent.access$1200(this.this$0).getIntent().hasExtra("troopUin")) {}
    for (Object localObject = "1";; localObject = "0")
    {
      VasWebviewUtil.reportCommercialDrainage(AbsProfileHeaderComponent.access$1300(this.this$0).getCurrentAccountUin(), "thumbup", "click_getit", "", 1, 0, 0, "", (String)localObject, "");
      localObject = new Intent(AbsProfileHeaderComponent.access$1400(this.this$0), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("fragmentStyle", 3);
      ((Intent)localObject).putExtra("url", "https://m.vip.qq.com/freedom/dbzan.html?_nav_alpha=0");
      ((Intent)localObject).putExtra("isTransparentTitle", true);
      ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
      AbsProfileHeaderComponent.access$1500(this.this$0).startActivity((Intent)localObject);
      return;
    }
  }
  
  public void onRightClick()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsProfileHeaderComponent", 2, "ZanDoubleDialog: onRightClick: ");
    }
    if (AbsProfileHeaderComponent.access$1600(this.this$0).getIntent().hasExtra("troopUin")) {}
    for (String str = "1";; str = "0")
    {
      VasWebviewUtil.reportCommercialDrainage(AbsProfileHeaderComponent.access$1700(this.this$0).getCurrentAccountUin(), "thumbup", "click_pay", "", 1, 0, 0, "", str, "");
      VasH5PayUtil.a(AbsProfileHeaderComponent.access$1800(this.this$0), "mvip.n.a.dbzan_dbzan", "CJCLUBT", 3, false, true);
      AbsProfileHeaderComponent.access$200(this.this$0).set(true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent.5
 * JD-Core Version:    0.7.0.1
 */