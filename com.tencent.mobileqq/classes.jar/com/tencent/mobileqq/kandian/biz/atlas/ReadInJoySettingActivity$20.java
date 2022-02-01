package com.tencent.mobileqq.kandian.biz.atlas;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.Switch;

class ReadInJoySettingActivity$20
  implements DialogInterface.OnKeyListener
{
  ReadInJoySettingActivity$20(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      ReadInJoySettingActivity.a(this.a, true);
      ReadInJoySettingActivity.b(this.a).setChecked(true ^ ReadInJoySettingActivity.a(this.a));
      ReadInJoySettingActivity.f(this.a).cancel();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.ReadInJoySettingActivity.20
 * JD-Core Version:    0.7.0.1
 */