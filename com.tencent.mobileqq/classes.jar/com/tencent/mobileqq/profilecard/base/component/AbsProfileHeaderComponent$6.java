package com.tencent.mobileqq.profilecard.base.component;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.ZanDoubleDialog.BtnClickListener;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class AbsProfileHeaderComponent$6
  implements ZanDoubleDialog.BtnClickListener
{
  AbsProfileHeaderComponent$6(AbsProfileHeaderComponent paramAbsProfileHeaderComponent) {}
  
  public void onLeftClick()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsProfileHeaderComponent", 2, "ZanDoubleDialog: onLeftClick: ");
    }
    if (AbsProfileHeaderComponent.access$1600(this.this$0).getIntent().hasExtra("troopUin")) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    VasWebviewUtil.a(AbsProfileHeaderComponent.access$1700(this.this$0).getCurrentAccountUin(), "thumbup", "click_getit", "", 1, 0, 0, "", (String)localObject, "");
    Object localObject = new Intent(AbsProfileHeaderComponent.access$1800(this.this$0), QQBrowserActivity.class);
    ((Intent)localObject).putExtra("fragmentStyle", 3);
    ((Intent)localObject).putExtra("url", "https://m.vip.qq.com/freedom/dbzan.html?_nav_alpha=0");
    ((Intent)localObject).putExtra("isTransparentTitle", true);
    ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
    AbsProfileHeaderComponent.access$1900(this.this$0).startActivity((Intent)localObject);
  }
  
  public void onRightClick()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsProfileHeaderComponent", 2, "ZanDoubleDialog: onRightClick: ");
    }
    String str;
    if (AbsProfileHeaderComponent.access$2000(this.this$0).getIntent().hasExtra("troopUin")) {
      str = "1";
    } else {
      str = "0";
    }
    VasWebviewUtil.a(AbsProfileHeaderComponent.access$2100(this.this$0).getCurrentAccountUin(), "thumbup", "click_pay", "", 1, 0, 0, "", str, "");
    VasH5PayUtil.a(AbsProfileHeaderComponent.access$2200(this.this$0), "mvip.n.a.dbzan_dbzan", "CJCLUBT", 3, false, true);
    AbsProfileHeaderComponent.access$200(this.this$0).set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent.6
 * JD-Core Version:    0.7.0.1
 */