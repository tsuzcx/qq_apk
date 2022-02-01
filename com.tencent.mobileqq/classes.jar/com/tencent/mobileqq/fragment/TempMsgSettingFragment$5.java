package com.tencent.mobileqq.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.Map;

class TempMsgSettingFragment$5
  implements View.OnClickListener
{
  TempMsgSettingFragment$5(TempMsgSettingFragment paramTempMsgSettingFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject1;
    if (paramView == null) {
      localObject1 = null;
    } else {
      localObject1 = paramView.getTag();
    }
    if ((localObject1 instanceof Short))
    {
      short s = ((Short)localObject1).shortValue();
      localObject1 = (ActionSheet)ActionSheetHelper.a(this.a.getContext(), null);
      Object localObject2 = this.a;
      ((ActionSheet)localObject1).setMainTitle(((TempMsgSettingFragment)localObject2).getString(2131719584, new Object[] { TempMsgSettingFragment.a((TempMsgSettingFragment)localObject2, s) }));
      ((ActionSheet)localObject1).addRadioButton(this.a.getString(2131719590), false);
      ((ActionSheet)localObject1).addRadioButton(this.a.getString(2131719589), false);
      ((ActionSheet)localObject1).addRadioButton(this.a.getString(2131719591), false);
      localObject2 = (TempMsgManager)this.a.a.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER);
      boolean bool1 = ((TempMsgManager)localObject2).a(s);
      boolean bool2 = ((TempMsgManager)localObject2).b(s);
      int i = ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getTempSettingStatus(bool1, bool2);
      if (TempMsgSettingFragment.a(this.a).containsKey(Integer.valueOf(i)))
      {
        ((ActionSheet)localObject1).setRadioButtonChecked(i);
        ((ActionSheet)localObject1).addCancelButton(2131690728);
        ((ActionSheet)localObject1).setOnButtonClickListener(new TempMsgSettingFragment.5.1(this, (TempMsgManager)localObject2, s, i, paramView, (ActionSheet)localObject1));
        ReportController.b(this.a.a, "dc00898", "", "", "0X800BB8A", "0X800BB8A", ((TempMsgManager)localObject2).b(s), 0, "", "", "", "");
        ((ActionSheet)localObject1).show();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.TempMsgSettingFragment.5
 * JD-Core Version:    0.7.0.1
 */