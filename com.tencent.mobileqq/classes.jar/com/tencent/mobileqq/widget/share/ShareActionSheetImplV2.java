package com.tencent.mobileqq.widget.share;

import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.List;

public class ShareActionSheetImplV2
  extends ShareActionSheetImpl
{
  private ShareActionSheetV2 jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2;
  private Validator jdField_a_of_type_ComTencentMobileqqWidgetShareValidator;
  
  public ShareActionSheetImplV2(ShareActionSheetV2 paramShareActionSheetV2)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2 = paramShareActionSheetV2;
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareValidator = new Validator(paramShareActionSheetV2);
  }
  
  public void dismiss()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.dismiss();
  }
  
  public void dismissImmediately()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.dismissImmediately();
  }
  
  public View findViewById(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.findViewById(paramInt);
  }
  
  public ActionSheet getActionSheet()
  {
    throw new IllegalStateException("not impl in ShareActionSheetImplV2");
  }
  
  public int getActionSheetPanelViewHeight()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.getActionSheetPanelViewHeight();
  }
  
  public int getIconWidth()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.getIconWidth();
  }
  
  public String getOpenSource()
  {
    throw new IllegalStateException("not impl in ShareActionSheetImplV2");
  }
  
  public Window getWindow()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.getWindow();
  }
  
  public void hideTitle()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.hideTitle();
  }
  
  public boolean isShowing()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.isShowing();
  }
  
  public void onConfigurationChanged()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.onConfigurationChanged();
  }
  
  public void refresh()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.refresh();
  }
  
  public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem> paramList1, List<ShareActionSheetBuilder.ActionSheetItem> paramList2)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.setActionSheetItems(paramList1, paramList2);
  }
  
  public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem>[] paramArrayOfList)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.setActionSheetItems(paramArrayOfList);
  }
  
  public void setActionSheetTitle(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.setActionSheetTitle(paramCharSequence);
  }
  
  public void setAdvBgColor(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.setAdvBgColor(paramInt);
  }
  
  public void setAdvView(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.setAdvView(paramView, paramLayoutParams);
  }
  
  public void setBottomBarInterface(ShareActionSheet.IShareActionSheetV2BottomBar paramIShareActionSheetV2BottomBar)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.setBottomBarInterface(paramIShareActionSheetV2BottomBar);
  }
  
  public void setCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.setCancelListener(paramOnCancelListener);
  }
  
  public void setEnableNotTriggerVirtualNavigationBar(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.setEnableNotTriggerVirtualNavigationBar(paramBoolean);
  }
  
  public void setExtras(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.setExtras(paramBundle);
  }
  
  public void setIconMarginLeftRight(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.setIconMarginLeftRight(paramInt);
  }
  
  public void setIntentForStartForwardRecentActivity(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.setIntentForStartForwardRecentActivity(paramIntent);
  }
  
  public void setItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.setItemClickListener(paramOnItemClickListener);
  }
  
  public void setItemClickListenerV2(ShareActionSheet.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.setItemClickListenerV2(paramOnItemClickListener);
  }
  
  public void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.setOnDismissListener(paramOnDismissListener);
  }
  
  public void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.setOnShowListener(paramOnShowListener);
  }
  
  public void setOpenSource(String paramString)
  {
    throw new IllegalStateException("not impl in ShareActionSheetImplV2");
  }
  
  public void setRowMarginLeftRight(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.setRowMarginLeftRight(paramInt);
  }
  
  public void setRowVisibility(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.setRowVisibility(paramInt1, paramInt2, paramInt3);
  }
  
  public void show()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareValidator.a()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.show();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ShareActionSheetImplV2", 2, "show() called 参数无效");
  }
  
  public void updateUI()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.refresh();
  }
  
  public void updateUIIfShowing()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.refresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetImplV2
 * JD-Core Version:    0.7.0.1
 */