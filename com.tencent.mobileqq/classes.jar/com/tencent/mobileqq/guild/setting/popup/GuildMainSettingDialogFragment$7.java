package com.tencent.mobileqq.guild.setting.popup;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class GuildMainSettingDialogFragment$7
  implements ActionSheet.OnButtonClickListener
{
  GuildMainSettingDialogFragment$7(GuildMainSettingDialogFragment paramGuildMainSettingDialogFragment, boolean paramBoolean) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 2131434725) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0)
    {
      if (this.a) {
        GuildMainSettingDialogFragment.b(this.b);
      } else {
        GuildMainSettingDialogFragment.c(this.b);
      }
      GuildMainSettingDialogFragment.d(this.b).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.popup.GuildMainSettingDialogFragment.7
 * JD-Core Version:    0.7.0.1
 */