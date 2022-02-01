package com.tencent.mobileqq.troop.activity.editinfo;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EditInfoActivity$4
  implements View.OnClickListener
{
  EditInfoActivity$4(EditInfoActivity paramEditInfoActivity) {}
  
  public void onClick(View paramView)
  {
    EditInfoActivity.access$000(this.a).setCursorVisible(true);
    this.a.mEmojLayout.setVisibility(8);
    this.a.mSwitchButton.setImageResource(2130848134);
    this.a.mSwitchButton.setContentDescription(HardCodeUtil.a(2131703789));
    this.a.mIsShowEmojiboard = false;
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.editinfo.EditInfoActivity.4
 * JD-Core Version:    0.7.0.1
 */