package com.tencent.mobileqq.filemanageraux.link;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListenerV2;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class WeiyunShareSettingController
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, ActionSheet.OnButtonClickListenerV2
{
  private final IShareRouter a;
  private final boolean b;
  private final IShareRouter.ShareOptions c;
  private final List<String> d;
  private final FormSimpleItem e;
  private final FormSwitchItem f;
  private final FormSimpleItem g;
  private final FormSwitchItem h;
  private ActionSheet i;
  
  WeiyunShareSettingController(IShareRouter paramIShareRouter, View paramView, boolean paramBoolean)
  {
    this.a = paramIShareRouter;
    this.b = paramBoolean;
    this.c = new IShareRouter.ShareOptions();
    paramIShareRouter = BaseApplicationImpl.sApplication;
    this.d = new ArrayList();
    this.d.add(paramIShareRouter.getString(2131896165));
    this.d.add(paramIShareRouter.getString(2131896164));
    this.d.add(paramIShareRouter.getString(2131896166));
    this.e = ((FormSimpleItem)paramView.findViewById(2131445719));
    Object localObject = this.e;
    int j;
    if (this.b) {
      j = 2131896167;
    } else {
      j = 2131896163;
    }
    ((FormSimpleItem)localObject).setLeftText(paramIShareRouter.getString(j));
    this.e.setRightText((CharSequence)this.d.get(c()));
    this.e.setOnClickListener(this);
    this.f = ((FormSwitchItem)paramView.findViewById(2131445718));
    this.g = ((FormSimpleItem)paramView.findViewById(2131445728));
    this.f.setChecked(this.c.b);
    this.f.setOnCheckedChangeListener(this);
    b(false);
    localObject = (TextView)paramView.findViewById(2131445730);
    if (this.b) {
      j = 2131896170;
    } else {
      j = 2131896169;
    }
    ((TextView)localObject).setText(paramIShareRouter.getString(j));
    this.h = ((FormSwitchItem)paramView.findViewById(2131445716));
    this.h.setChecked(this.c.d);
    this.h.setOnCheckedChangeListener(this);
    this.h.setVisibility(8);
    paramView.findViewById(2131445717).setVisibility(8);
    if (this.b)
    {
      this.f.setVisibility(8);
      this.e.setBgType(0);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    FormSimpleItem localFormSimpleItem = this.g;
    IShareRouter.ShareOptions localShareOptions = this.c;
    if (localShareOptions.b) {
      localObject = LinkUtils.b(6);
    } else {
      localObject = "";
    }
    localShareOptions.c = ((String)localObject);
    localFormSimpleItem.setRightText((CharSequence)localObject);
    Object localObject = this.g;
    int j;
    if (this.c.b) {
      j = 0;
    } else {
      j = 8;
    }
    ((FormSimpleItem)localObject).setVisibility(j);
    localObject = this.f;
    if (this.c.b) {
      j = 2;
    } else {
      j = 3;
    }
    ((FormSwitchItem)localObject).setBgType(j);
    if (paramBoolean) {
      this.a.b();
    }
  }
  
  private int c()
  {
    int k = this.c.a;
    int j = 2;
    if (k == 1) {
      return 0;
    }
    if (this.c.a == 2) {
      j = 1;
    }
    return j;
  }
  
  private void d()
  {
    if (this.i == null)
    {
      this.i = ((ActionSheet)ActionSheetHelper.c(this.a.getBaseActivity(), null));
      Object localObject = this.i;
      int j;
      if (this.b) {
        j = 2131896167;
      } else {
        j = 2131896163;
      }
      ((ActionSheet)localObject).setMainTitle(j);
      localObject = this.d.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        this.i.addRadioButton(str, false);
      }
      this.i.addCancelButton(2131887648);
      this.i.setOnButtonClickListenerV2(this);
    }
    this.i.clearAllRadioBtnCheckStatus();
    this.i.setRadioButtonChecked(c());
    if (!this.i.isShowing()) {
      this.i.show();
    }
  }
  
  public void OnClick(View paramView, int paramInt, String paramString)
  {
    paramView = this.i;
    if ((paramView != null) && (paramView.isShowing())) {
      this.i.dismiss();
    }
    int j = 1;
    if (paramInt == 0) {
      paramInt = 1;
    } else if (paramInt == 1) {
      paramInt = 2;
    } else {
      paramInt = 3;
    }
    if (paramInt == this.c.a) {
      j = 0;
    }
    this.c.a = paramInt;
    this.e.setRightText(paramString);
    if (j != 0) {
      this.a.b();
    }
  }
  
  IShareRouter.ShareOptions a()
  {
    return this.c;
  }
  
  void a(boolean paramBoolean)
  {
    Object localObject = this.e;
    if (localObject != null) {
      ((FormSimpleItem)localObject).setEnabled(paramBoolean);
    }
    localObject = this.f;
    if (localObject != null) {
      ((FormSwitchItem)localObject).setEnabled(paramBoolean);
    }
    localObject = this.g;
    if (localObject != null) {
      ((FormSimpleItem)localObject).setEnabled(paramBoolean);
    }
    localObject = this.h;
    if (localObject != null) {
      ((FormSwitchItem)localObject).setEnabled(paramBoolean);
    }
  }
  
  void b()
  {
    ActionSheet localActionSheet = this.i;
    if (localActionSheet != null)
    {
      localActionSheet.superDismiss();
      this.i = null;
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool2 = paramCompoundButton.equals(this.f.getSwitch());
    int j = 1;
    boolean bool1 = true;
    if (bool2)
    {
      if (this.c.b == paramBoolean) {
        bool1 = false;
      }
      this.c.b = paramBoolean;
      b(bool1);
    }
    else if (paramCompoundButton.equals(this.h.getSwitch()))
    {
      if (this.c.d == paramBoolean) {
        j = 0;
      }
      this.c.d = paramBoolean;
      if (j != 0) {
        this.a.b();
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131445719) {
      d();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.link.WeiyunShareSettingController
 * JD-Core Version:    0.7.0.1
 */