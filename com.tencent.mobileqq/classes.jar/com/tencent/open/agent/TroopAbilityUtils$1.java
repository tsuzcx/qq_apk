package com.tencent.open.agent;

import android.app.Activity;
import com.tencent.biz.widgets.ShareAioResultDialog;
import com.tencent.mobileqq.app.HardCodeUtil;

final class TroopAbilityUtils$1
  implements Runnable
{
  TroopAbilityUtils$1(Activity paramActivity, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    ShareAioResultDialog localShareAioResultDialog = new ShareAioResultDialog(this.jdField_a_of_type_AndroidAppActivity);
    TroopAbilityUtils.1.1 local1 = new TroopAbilityUtils.1.1(this);
    String str = HardCodeUtil.a(2131714910);
    localShareAioResultDialog.a(this.d);
    localShareAioResultDialog.a(str, local1);
    localShareAioResultDialog.a(local1);
    localShareAioResultDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.TroopAbilityUtils.1
 * JD-Core Version:    0.7.0.1
 */