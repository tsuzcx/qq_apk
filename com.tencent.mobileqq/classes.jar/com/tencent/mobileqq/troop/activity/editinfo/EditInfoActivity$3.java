package com.tencent.mobileqq.troop.activity.editinfo;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EditInfoActivity$3
  implements View.OnClickListener
{
  EditInfoActivity$3(EditInfoActivity paramEditInfoActivity) {}
  
  public void onClick(View paramView)
  {
    EditInfoActivity localEditInfoActivity = this.a;
    localEditInfoActivity.mIsShowEmojiboard ^= true;
    if (this.a.mIsShowEmojiboard)
    {
      this.a.hideInputMethod();
      if (this.a.getIntent().getBooleanExtra("key_need_hide_couser_when_emoj", false)) {
        EditInfoActivity.access$000(this.a).setCursorVisible(false);
      }
      this.a.mSwitchButton.setImageResource(2130838075);
      this.a.mSwitchButton.setContentDescription(HardCodeUtil.a(2131901740));
      if (this.a.mEmojLayout != null) {
        this.a.mEmojLayout.setVisibility(0);
      }
    }
    else
    {
      EditInfoActivity.access$000(this.a).setCursorVisible(true);
      if (this.a.mEmojLayout != null) {
        this.a.mEmojLayout.setVisibility(8);
      }
      this.a.mSwitchButton.setImageResource(2130849798);
      this.a.mSwitchButton.setContentDescription(HardCodeUtil.a(2131901730));
      this.a.showInputMethod();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.editinfo.EditInfoActivity.3
 * JD-Core Version:    0.7.0.1
 */