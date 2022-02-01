package com.tencent.mobileqq.troop.troopapps;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarHandler;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarInfo;
import com.tencent.mobileqq.troop.utils.TroopAppShortcutUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class AppsAioShortCutViewBuilder
  extends AppsBaseBuilder
  implements CompoundButton.OnCheckedChangeListener
{
  protected AppsAioShortCutViewBuilder.AioShortCutInfo a;
  private long c = 0L;
  
  AppsAioShortCutViewBuilder(Context paramContext, QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, TroopAppShortcutContainer paramTroopAppShortcutContainer, Bundle paramBundle)
  {
    super(paramContext, paramQQAppInterface, paramFragmentActivity, paramTroopAppShortcutContainer, paramBundle);
  }
  
  private String a()
  {
    return "troopapp_aio_shortcut_bar_guide" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
  }
  
  private boolean a()
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext);
    boolean bool = ((SharedPreferences)localObject).getBoolean(a(), true);
    if (QLog.isColorLevel()) {
      QLog.d("AppsAioShortCutViewBuilder", 2, String.format("needShow guide: %s", new Object[] { String.valueOf(bool) }));
    }
    if (bool)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean(a(), false);
      ((SharedPreferences.Editor)localObject).apply();
    }
    return bool;
  }
  
  public int a()
  {
    return 0;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      paramView = new AppsAioShortCutViewBuilder.ItemViewHolder();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559984, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370312));
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131378767));
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131378785);
      localView.setTag(paramView);
      paramViewGroup = paramView;
      if (this.jdField_a_of_type_Boolean) {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffffff"));
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsAioShortCutViewBuilder$AioShortCutInfo.b) {
        break label253;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsAioShortCutViewBuilder$AioShortCutInfo.c) {
        break label241;
      }
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      if (AppSetting.d) {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131720044));
      }
      float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
      AIOUtils.a(paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox, (int)(5.0F * f + 0.5F), (int)(5.0F * f + 0.5F), (int)(5.0F * f + 0.5F), (int)(f * 5.0F + 0.5F));
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsAioShortCutViewBuilder$AioShortCutInfo.jdField_a_of_type_Boolean);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      return localView;
      paramViewGroup = (AppsAioShortCutViewBuilder.ItemViewHolder)paramView.getTag();
      localView = paramView;
      break;
      label241:
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      continue;
      label253:
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsAioShortCutViewBuilder$AioShortCutInfo.d) && (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsAioShortCutViewBuilder$AioShortCutInfo.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopShortcutBarInfo.b() == 0)) {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      } else {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsAioShortCutViewBuilder$AioShortCutInfo;
  }
  
  public void a_(Object paramObject)
  {
    if ((paramObject instanceof AppsAioShortCutViewBuilder.AioShortCutInfo)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsAioShortCutViewBuilder$AioShortCutInfo = ((AppsAioShortCutViewBuilder.AioShortCutInfo)paramObject);
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    if (((l - this.c > 0L) && (l - this.c < 800L)) || (!paramCompoundButton.isPressed())) {
      if (QLog.isColorLevel()) {
        QLog.e("AppsAioShortCutViewBuilder", 2, "onSetTotalSwitch Click is Fire");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      this.c = l;
      boolean bool = TroopAppShortcutUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
      if (paramBoolean) {}
      for (int i = 0;; i = 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsAioShortCutViewBuilder$AioShortCutInfo.jdField_a_of_type_Boolean = paramBoolean;
        ((TroopShortcutBarHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE)).a(this.jdField_a_of_type_Long, i, bool);
        if (QLog.isColorLevel()) {
          QLog.e("AppsAioShortCutViewBuilder", 2, "onSetTotalSwitch:" + String.valueOf(this.jdField_a_of_type_Long) + "isChecked" + paramBoolean + "disabled" + i + "isAdminOrOwner" + bool);
        }
        bool = TroopAppShortcutUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
        if ((paramBoolean) && (a()) && (TroopAppShortcutUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long)) && (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer != null)) {
          this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer.h();
        }
        if (!bool) {
          break label340;
        }
        if (!paramBoolean) {
          break label296;
        }
        ReportController.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800AAD9", "0X800AAD9", 0, 0, String.valueOf(this.b), "", "", "");
        break;
      }
      label296:
      ReportController.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800AADA", "0X800AADA", 0, 0, String.valueOf(this.b), "", "", "");
      continue;
      label340:
      if (paramBoolean) {
        ReportController.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800AFC1", "0X800AFC1", 0, 0, String.valueOf(this.b), "", "", "");
      } else {
        ReportController.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800AFC2", "0X800AFC2", 0, 0, String.valueOf(this.b), "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.AppsAioShortCutViewBuilder
 * JD-Core Version:    0.7.0.1
 */