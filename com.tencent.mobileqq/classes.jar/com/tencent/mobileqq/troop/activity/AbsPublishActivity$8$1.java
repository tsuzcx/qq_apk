package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class AbsPublishActivity$8$1
  implements QQPermissionCallback
{
  AbsPublishActivity$8$1(AbsPublishActivity.8 param8) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.a.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = new Intent();
    paramArrayOfString.putExtra("audio_max_length", this.a.a.h);
    if (this.a.a.q != null)
    {
      paramArrayOfString.putExtra("from", "publish");
      paramArrayOfString.putExtra("bid", this.a.a.q);
      paramArrayOfString.putExtra("fromflag", this.a.a.b);
      TroopBarUtils.a(this.a.a.o, this.a.a.p, "Clk_record", this.a.a.q, this.a.a.b, "", "");
    }
    PublicFragmentActivity.Launcher.a(this.a.a.a, paramArrayOfString, PublicTransFragmentActivity.class, AudioRecordFragment.class, 1003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.AbsPublishActivity.8.1
 * JD-Core Version:    0.7.0.1
 */