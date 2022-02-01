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
  private final IShareRouter.ShareOptions jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter$ShareOptions;
  private final IShareRouter jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter;
  private final FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private final FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private final List<String> jdField_a_of_type_JavaUtilList;
  private final boolean jdField_a_of_type_Boolean;
  private final FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private final FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  
  WeiyunShareSettingController(IShareRouter paramIShareRouter, View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter = paramIShareRouter;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter$ShareOptions = new IShareRouter.ShareOptions();
    paramIShareRouter = BaseApplicationImpl.sApplication;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(paramIShareRouter.getString(2131698200));
    this.jdField_a_of_type_JavaUtilList.add(paramIShareRouter.getString(2131698199));
    this.jdField_a_of_type_JavaUtilList.add(paramIShareRouter.getString(2131698201));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)paramView.findViewById(2131377904));
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 2131698202;
      ((FormSimpleItem)localObject).setLeftText(paramIShareRouter.getString(i));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)this.jdField_a_of_type_JavaUtilList.get(a()));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)paramView.findViewById(2131377903));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)paramView.findViewById(2131377913));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter$ShareOptions.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      b(false);
      localObject = (TextView)paramView.findViewById(2131377915);
      if (!this.jdField_a_of_type_Boolean) {
        break label333;
      }
    }
    label333:
    for (int i = 2131698205;; i = 2131698204)
    {
      ((TextView)localObject).setText(paramIShareRouter.getString(i));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)paramView.findViewById(2131377901));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter$ShareOptions.b);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      paramView.findViewById(2131377902).setVisibility(8);
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(0);
      }
      return;
      i = 2131698198;
      break;
    }
  }
  
  private int a()
  {
    int i = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter$ShareOptions.jdField_a_of_type_Int == 1) {
      i = 0;
    }
    while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter$ShareOptions.jdField_a_of_type_Int == 2) {
      return i;
    }
    return 2;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.a(), null));
      Object localObject = this.jdField_a_of_type_ComTencentWidgetActionSheet;
      if (this.jdField_a_of_type_Boolean) {}
      for (int i = 2131698202;; i = 2131698198)
      {
        ((ActionSheet)localObject).setMainTitle(i);
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          this.jdField_a_of_type_ComTencentWidgetActionSheet.addRadioButton(str, false);
        }
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690800);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListenerV2(this);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.clearAllRadioBtnCheckStatus();
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setRadioButtonChecked(a());
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  private void b(boolean paramBoolean)
  {
    FormSimpleItem localFormSimpleItem = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    IShareRouter.ShareOptions localShareOptions = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter$ShareOptions;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter$ShareOptions.jdField_a_of_type_Boolean)
    {
      localObject = LinkUtils.a(6);
      localShareOptions.jdField_a_of_type_JavaLangString = ((String)localObject);
      localFormSimpleItem.setRightText((CharSequence)localObject);
      localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter$ShareOptions.jdField_a_of_type_Boolean) {
        break label104;
      }
      i = 0;
      label57:
      ((FormSimpleItem)localObject).setVisibility(i);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter$ShareOptions.jdField_a_of_type_Boolean) {
        break label110;
      }
    }
    label104:
    label110:
    for (int i = 2;; i = 3)
    {
      ((FormSwitchItem)localObject).setBgType(i);
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.a();
      }
      return;
      localObject = "";
      break;
      i = 8;
      break label57;
    }
  }
  
  public void OnClick(View paramView, int paramInt, String paramString)
  {
    int i = 1;
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    if (paramInt == 0)
    {
      paramInt = 1;
      if (paramInt == this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter$ShareOptions.jdField_a_of_type_Int) {
        break label90;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter$ShareOptions.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(paramString);
      if (i != 0) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.a();
      }
      return;
      if (paramInt == 1)
      {
        paramInt = 2;
        break;
      }
      paramInt = 3;
      break;
      label90:
      i = 0;
    }
  }
  
  IShareRouter.ShareOptions a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter$ShareOptions;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.superDismiss();
      this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    }
  }
  
  void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(paramBoolean);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(paramBoolean);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(paramBoolean);
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    boolean bool = true;
    if (paramCompoundButton.equals(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())) {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter$ShareOptions.jdField_a_of_type_Boolean != paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter$ShareOptions.jdField_a_of_type_Boolean = paramBoolean;
        b(bool);
      }
    }
    while (!paramCompoundButton.equals(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())) {
      for (;;)
      {
        EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
        return;
        bool = false;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter$ShareOptions.b != paramBoolean) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter$ShareOptions.b = paramBoolean;
      if (i == 0) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.a();
      break;
      i = 0;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.link.WeiyunShareSettingController
 * JD-Core Version:    0.7.0.1
 */