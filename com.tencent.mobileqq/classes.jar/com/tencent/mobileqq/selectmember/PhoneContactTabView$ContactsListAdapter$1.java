package com.tencent.mobileqq.selectmember;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PhoneContactTabView$ContactsListAdapter$1
  implements View.OnClickListener
{
  PhoneContactTabView$ContactsListAdapter$1(PhoneContactTabView.ContactsListAdapter paramContactsListAdapter) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131431955)
    {
      SelectActivityViewHolder localSelectActivityViewHolder = (SelectActivityViewHolder)paramView.getTag();
      if ((localSelectActivityViewHolder != null) && (localSelectActivityViewHolder.a != null) && (localSelectActivityViewHolder.b != null))
      {
        Object localObject = localSelectActivityViewHolder.b;
        if (localSelectActivityViewHolder.a.isEnabled())
        {
          boolean bool;
          if (localSelectActivityViewHolder.y.startsWith("+")) {
            bool = this.a.b.d.onListViewItemClick(localSelectActivityViewHolder.y, ((PhoneContact)localObject).name, 4, "-1", ((PhoneContact)localObject).mobileNo);
          } else {
            bool = this.a.b.d.onListViewItemClick(localSelectActivityViewHolder.y, ((PhoneContact)localObject).name, 0, "-1", ((PhoneContact)localObject).mobileNo);
          }
          localSelectActivityViewHolder.a.setChecked(bool);
          if (AppSetting.e) {
            if (localSelectActivityViewHolder.a.isChecked())
            {
              if (localSelectActivityViewHolder.d)
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(localSelectActivityViewHolder.i.getText());
                ((StringBuilder)localObject).append(this.a.b.d.getString(2131916221));
                paramView.setContentDescription(((StringBuilder)localObject).toString());
              }
              else
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(localSelectActivityViewHolder.i.getText().toString());
                ((StringBuilder)localObject).append(HardCodeUtil.a(2131905810));
                paramView.setContentDescription(((StringBuilder)localObject).toString());
              }
            }
            else
            {
              int i = 0;
              if (localSelectActivityViewHolder.d) {
                i = this.a.b.d.getCheckPhoneNumberResId(localSelectActivityViewHolder.y);
              }
              if ((localSelectActivityViewHolder.d) && (i != 0))
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(localSelectActivityViewHolder.i.getText());
                ((StringBuilder)localObject).append(this.a.b.d.getString(i));
                paramView.setContentDescription(((StringBuilder)localObject).toString());
              }
              else
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(localSelectActivityViewHolder.i.getText().toString());
                ((StringBuilder)localObject).append(HardCodeUtil.a(2131905807));
                paramView.setContentDescription(((StringBuilder)localObject).toString());
              }
            }
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.PhoneContactTabView.ContactsListAdapter.1
 * JD-Core Version:    0.7.0.1
 */