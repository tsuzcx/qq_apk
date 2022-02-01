package com.tencent.mobileqq.leba.qcircle.mgr;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.leba.entity.LebaMgrViewItem;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import common.config.service.QzoneConfig;

public class LebaQCircleTableMgrItem$SwitchBtnViewHolder
  extends RecyclerView.ViewHolder
{
  FormSwitchItem a;
  
  public LebaQCircleTableMgrItem$SwitchBtnViewHolder(Context paramContext, View paramView, boolean paramBoolean)
  {
    super(paramView);
    this.a = ((FormSwitchItem)paramView.findViewById(2131370253));
    if (paramBoolean)
    {
      this.a.setBackgroundColor(paramContext.getResources().getColor(2131165773));
      return;
    }
    this.a.setBackgroundColor(paramContext.getResources().getColor(2131165772));
  }
  
  private void a(FormSwitchItem paramFormSwitchItem)
  {
    QzoneConfig.getInstance();
    if (QzoneConfig.isQQCircleShowLebaBySwitchButton(StudyModeManager.a())) {
      paramFormSwitchItem.setChecked(true);
    }
    for (;;)
    {
      paramFormSwitchItem.setOnCheckedChangeListener(new LebaQCircleTableMgrItem.SwitchBtnViewHolder.1(this));
      return;
      paramFormSwitchItem.setChecked(false);
    }
  }
  
  public void a(LebaMgrViewItem paramLebaMgrViewItem, Context paramContext, boolean paramBoolean)
  {
    String str;
    if (!TextUtils.isEmpty(paramLebaMgrViewItem.a))
    {
      this.a.setText(paramLebaMgrViewItem.a);
      this.a.setVisibility(0);
      a(this.a);
      if (AppSetting.d)
      {
        if (!TextUtils.isEmpty(paramLebaMgrViewItem.a)) {
          break label143;
        }
        str = "";
        label57:
        this.a.setFocusable(true);
        AccessibilityUtil.a(this.a, str, Button.class.getName());
      }
      if (paramLebaMgrViewItem.b != 0) {
        this.a.setLeftIcon(paramLebaMgrViewItem.b);
      }
      paramLebaMgrViewItem = this.a.a();
      if (paramLebaMgrViewItem != null) {
        if (!paramBoolean) {
          break label152;
        }
      }
    }
    label143:
    label152:
    for (int i = 2131165775;; i = 2131165774)
    {
      paramLebaMgrViewItem.setTextColor(paramContext.getResources().getColor(i));
      return;
      this.a.setVisibility(8);
      break;
      str = paramLebaMgrViewItem.a;
      break label57;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.qcircle.mgr.LebaQCircleTableMgrItem.SwitchBtnViewHolder
 * JD-Core Version:    0.7.0.1
 */