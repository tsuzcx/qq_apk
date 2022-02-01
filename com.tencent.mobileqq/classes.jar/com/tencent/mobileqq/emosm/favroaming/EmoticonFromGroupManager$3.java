package com.tencent.mobileqq.emosm.favroaming;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.vas.VasH5PayUtil;

class EmoticonFromGroupManager$3
  implements DialogInterface.OnClickListener
{
  EmoticonFromGroupManager$3(EmoticonFromGroupManager paramEmoticonFromGroupManager, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (paramInt == 1) {
      VasH5PayUtil.a(this.jdField_a_of_type_AndroidAppActivity, "mvip.n.a.bqsc_ql", 3, "1450000516", "CJCLUBT", EmoticonFromGroupManager.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager).getString(2131719393), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager.3
 * JD-Core Version:    0.7.0.1
 */