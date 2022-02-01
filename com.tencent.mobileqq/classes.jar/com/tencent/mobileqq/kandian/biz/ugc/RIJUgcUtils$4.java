package com.tencent.mobileqq.kandian.biz.ugc;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;

final class RIJUgcUtils$4
  implements DialogInterface.OnClickListener
{
  RIJUgcUtils$4(String paramString, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (TextUtils.isEmpty(this.a)) {
      paramDialogInterface = "https://viola.qq.com/js/ugcLevelProfile.js?_rij_violaUrl=1&v_tid=6&v_bundleName=ugcLevelProfile&hideNav=1&v_nav_immer=1&entry=1";
    } else {
      paramDialogInterface = this.a;
    }
    ReadInJoyUtils.a(this.b, paramDialogInterface);
    ThreadManager.executeOnSubThread(new RIJUgcUtils.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils.4
 * JD-Core Version:    0.7.0.1
 */