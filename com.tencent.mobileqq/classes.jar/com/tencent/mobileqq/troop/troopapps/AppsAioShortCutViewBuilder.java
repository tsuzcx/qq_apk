package com.tencent.mobileqq.troop.troopapps;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
import com.tencent.mobileqq.app.BaseActivity;
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
  private long l = 0L;
  
  AppsAioShortCutViewBuilder(Context paramContext, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, TroopAppShortcutContainer paramTroopAppShortcutContainer, Bundle paramBundle)
  {
    super(paramContext, paramQQAppInterface, paramBaseActivity, paramTroopAppShortcutContainer, paramBundle);
  }
  
  private boolean c()
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.f);
    boolean bool = ((SharedPreferences)localObject).getBoolean(d(), true);
    if (QLog.isColorLevel()) {
      QLog.d("AppsAioShortCutViewBuilder", 2, String.format("needShow guide: %s", new Object[] { String.valueOf(bool) }));
    }
    if (bool)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean(d(), false);
      ((SharedPreferences.Editor)localObject).apply();
    }
    return bool;
  }
  
  private String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troopapp_aio_shortcut_bar_guide");
    localStringBuilder.append(this.g.getCurrentAccountUin());
    return localStringBuilder.toString();
  }
  
  public int a()
  {
    return 0;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = new AppsAioShortCutViewBuilder.ItemViewHolder();
      paramViewGroup = LayoutInflater.from(this.f).inflate(2131625898, paramViewGroup, false);
      paramView.b = ((TextView)paramViewGroup.findViewById(2131437131));
      paramView.c = ((CheckBox)paramViewGroup.findViewById(2131446675));
      paramView.a = paramViewGroup.findViewById(2131446690);
      paramViewGroup.setTag(paramView);
    }
    else
    {
      localObject = (AppsAioShortCutViewBuilder.ItemViewHolder)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    if (this.i) {
      paramView.b.setTextColor(Color.parseColor("#ffffff"));
    }
    if (this.a.b)
    {
      if (this.a.c) {
        paramView.a.setVisibility(0);
      } else {
        paramView.a.setVisibility(8);
      }
    }
    else if ((this.a.d) && (this.a.e.b() == 0)) {
      paramView.a.setVisibility(0);
    } else {
      paramView.a.setVisibility(8);
    }
    if (AppSetting.e) {
      paramView.a.setContentDescription(this.f.getString(2131917380));
    }
    float f = this.f.getResources().getDisplayMetrics().density;
    Object localObject = paramView.c;
    paramInt = (int)(f * 5.0F + 0.5F);
    AIOUtils.a((View)localObject, paramInt, paramInt, paramInt, paramInt);
    paramView.c.setChecked(this.a.a);
    paramView.c.setOnCheckedChangeListener(this);
    return paramViewGroup;
  }
  
  public void a_(Object paramObject)
  {
    if ((paramObject instanceof AppsAioShortCutViewBuilder.AioShortCutInfo)) {
      this.a = ((AppsAioShortCutViewBuilder.AioShortCutInfo)paramObject);
    }
  }
  
  public Object b()
  {
    return this.a;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.l;
    if (((l1 - l2 > 0L) && (l1 - l2 < 800L)) || (!paramCompoundButton.isPressed()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("AppsAioShortCutViewBuilder", 2, "onSetTotalSwitch Click is Fire");
      }
    }
    else
    {
      this.l = l1;
      boolean bool = TroopAppShortcutUtils.a(this.g, this.b);
      int i = paramBoolean ^ true;
      this.a.a = paramBoolean;
      ((TroopShortcutBarHandler)this.g.getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE)).a(this.b, i, bool);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onSetTotalSwitch:");
        localStringBuilder.append(String.valueOf(this.b));
        localStringBuilder.append("isChecked");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append("disabled");
        localStringBuilder.append(i);
        localStringBuilder.append("isAdminOrOwner");
        localStringBuilder.append(bool);
        QLog.e("AppsAioShortCutViewBuilder", 2, localStringBuilder.toString());
      }
      bool = TroopAppShortcutUtils.a(this.g, this.b);
      if ((paramBoolean) && (c()) && (TroopAppShortcutUtils.a(this.g, this.b)) && (this.e != null)) {
        this.e.k();
      }
      if (bool)
      {
        if (paramBoolean) {
          ReportController.b(null, "dc00898", "", String.valueOf(this.b), "0X800AAD9", "0X800AAD9", 0, 0, String.valueOf(this.c), "", "", "");
        } else {
          ReportController.b(null, "dc00898", "", String.valueOf(this.b), "0X800AADA", "0X800AADA", 0, 0, String.valueOf(this.c), "", "", "");
        }
      }
      else if (paramBoolean) {
        ReportController.b(null, "dc00898", "", String.valueOf(this.b), "0X800AFC1", "0X800AFC1", 0, 0, String.valueOf(this.c), "", "", "");
      } else {
        ReportController.b(null, "dc00898", "", String.valueOf(this.b), "0X800AFC2", "0X800AFC2", 0, 0, String.valueOf(this.c), "", "", "");
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.AppsAioShortCutViewBuilder
 * JD-Core Version:    0.7.0.1
 */