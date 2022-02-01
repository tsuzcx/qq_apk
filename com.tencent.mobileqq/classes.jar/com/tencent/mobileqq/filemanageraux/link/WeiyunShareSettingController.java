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
    this.jdField_a_of_type_JavaUtilList.add(paramIShareRouter.getString(2131698264));
    this.jdField_a_of_type_JavaUtilList.add(paramIShareRouter.getString(2131698263));
    this.jdField_a_of_type_JavaUtilList.add(paramIShareRouter.getString(2131698265));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)paramView.findViewById(2131377330));
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    int i;
    if (this.jdField_a_of_type_Boolean) {
      i = 2131698266;
    } else {
      i = 2131698262;
    }
    ((FormSimpleItem)localObject).setLeftText(paramIShareRouter.getString(i));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)this.jdField_a_of_type_JavaUtilList.get(a()));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)paramView.findViewById(2131377329));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)paramView.findViewById(2131377339));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter$ShareOptions.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    b(false);
    localObject = (TextView)paramView.findViewById(2131377341);
    if (this.jdField_a_of_type_Boolean) {
      i = 2131698269;
    } else {
      i = 2131698268;
    }
    ((TextView)localObject).setText(paramIShareRouter.getString(i));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)paramView.findViewById(2131377327));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter$ShareOptions.b);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    paramView.findViewById(2131377328).setVisibility(8);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(0);
    }
  }
  
  private int a()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter$ShareOptions.jdField_a_of_type_Int;
    int i = 2;
    if (j == 1) {
      return 0;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter$ShareOptions.jdField_a_of_type_Int == 2) {
      i = 1;
    }
    return i;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.getBaseActivity(), null));
      Object localObject = this.jdField_a_of_type_ComTencentWidgetActionSheet;
      int i;
      if (this.jdField_a_of_type_Boolean) {
        i = 2131698266;
      } else {
        i = 2131698262;
      }
      ((ActionSheet)localObject).setMainTitle(i);
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        this.jdField_a_of_type_ComTencentWidgetActionSheet.addRadioButton(str, false);
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690728);
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
    if (localShareOptions.jdField_a_of_type_Boolean) {
      localObject = LinkUtils.a(6);
    } else {
      localObject = "";
    }
    localShareOptions.jdField_a_of_type_JavaLangString = ((String)localObject);
    localFormSimpleItem.setRightText((CharSequence)localObject);
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter$ShareOptions.jdField_a_of_type_Boolean) {
      i = 0;
    } else {
      i = 8;
    }
    ((FormSimpleItem)localObject).setVisibility(i);
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter$ShareOptions.jdField_a_of_type_Boolean) {
      i = 2;
    } else {
      i = 3;
    }
    ((FormSwitchItem)localObject).setBgType(i);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.a();
    }
  }
  
  public void OnClick(View paramView, int paramInt, String paramString)
  {
    paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if ((paramView != null) && (paramView.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    int i = 1;
    if (paramInt == 0) {
      paramInt = 1;
    } else if (paramInt == 1) {
      paramInt = 2;
    } else {
      paramInt = 3;
    }
    if (paramInt == this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter$ShareOptions.jdField_a_of_type_Int) {
      i = 0;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter$ShareOptions.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(paramString);
    if (i != 0) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.a();
    }
  }
  
  IShareRouter.ShareOptions a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter$ShareOptions;
  }
  
  void a()
  {
    ActionSheet localActionSheet = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if (localActionSheet != null)
    {
      localActionSheet.superDismiss();
      this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    }
  }
  
  void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    if (localObject != null) {
      ((FormSimpleItem)localObject).setEnabled(paramBoolean);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (localObject != null) {
      ((FormSwitchItem)localObject).setEnabled(paramBoolean);
    }
    localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    if (localObject != null) {
      ((FormSimpleItem)localObject).setEnabled(paramBoolean);
    }
    localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (localObject != null) {
      ((FormSwitchItem)localObject).setEnabled(paramBoolean);
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool2 = paramCompoundButton.equals(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a());
    int i = 1;
    boolean bool1 = true;
    if (bool2)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter$ShareOptions.jdField_a_of_type_Boolean == paramBoolean) {
        bool1 = false;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter$ShareOptions.jdField_a_of_type_Boolean = paramBoolean;
      b(bool1);
    }
    else if (paramCompoundButton.equals(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter$ShareOptions.b == paramBoolean) {
        i = 0;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter$ShareOptions.b = paramBoolean;
      if (i != 0) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.a();
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131377330) {
      b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.link.WeiyunShareSettingController
 * JD-Core Version:    0.7.0.1
 */