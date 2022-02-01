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
import bixm;
import bkzi;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ShareActionSheetImplV2
  extends ShareActionSheetImpl
{
  private static final String TAG = "ShareActionSheetImplV2";
  private ShareActionSheetV2 mImpl;
  private bixm mValidator;
  
  public ShareActionSheetImplV2(ShareActionSheetV2 paramShareActionSheetV2)
  {
    this.mImpl = paramShareActionSheetV2;
    this.mValidator = new bixm(paramShareActionSheetV2);
  }
  
  public void dismiss()
  {
    this.mImpl.dismiss();
  }
  
  public void dismissImmediately()
  {
    this.mImpl.dismissImmediately();
  }
  
  public View findViewById(int paramInt)
  {
    return this.mImpl.findViewById(paramInt);
  }
  
  public bkzi getActionSheet()
  {
    throw new IllegalStateException("not impl in ShareActionSheetImplV2");
  }
  
  public int getActionSheetPanelViewHeight()
  {
    return this.mImpl.getActionSheetPanelViewHeight();
  }
  
  public int getIconWidth()
  {
    return this.mImpl.getIconWidth();
  }
  
  public String getOpenSource()
  {
    throw new IllegalStateException("not impl in ShareActionSheetImplV2");
  }
  
  public Window getWindow()
  {
    return this.mImpl.getWindow();
  }
  
  public void hideTitle()
  {
    this.mImpl.hideTitle();
  }
  
  public boolean isShowing()
  {
    return this.mImpl.isShowing();
  }
  
  public void onConfigurationChanged()
  {
    this.mImpl.onConfigurationChanged();
  }
  
  public void refresh()
  {
    this.mImpl.refresh();
  }
  
  public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem> paramList1, List<ShareActionSheetBuilder.ActionSheetItem> paramList2)
  {
    this.mImpl.setActionSheetItems(paramList1, paramList2);
  }
  
  public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem>[] paramArrayOfList)
  {
    this.mImpl.setActionSheetItems(paramArrayOfList);
  }
  
  public void setActionSheetTitle(CharSequence paramCharSequence)
  {
    this.mImpl.setActionSheetTitle(paramCharSequence);
  }
  
  public void setAdvBgColor(int paramInt)
  {
    this.mImpl.setAdvBgColor(paramInt);
  }
  
  public void setAdvView(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    this.mImpl.setAdvView(paramView, paramLayoutParams);
  }
  
  public void setBottomBarInterface(ShareActionSheet.IShareActionSheetV2BottomBar paramIShareActionSheetV2BottomBar)
  {
    this.mImpl.setBottomBarInterface(paramIShareActionSheetV2BottomBar);
  }
  
  public void setCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.mImpl.setCancelListener(paramOnCancelListener);
  }
  
  public void setEnableNotTriggerVirtualNavigationBar(boolean paramBoolean)
  {
    this.mImpl.setEnableNotTriggerVirtualNavigationBar(paramBoolean);
  }
  
  public void setExtras(Bundle paramBundle)
  {
    this.mImpl.setExtras(paramBundle);
  }
  
  public void setIconMarginLeftRight(int paramInt)
  {
    this.mImpl.setIconMarginLeftRight(paramInt);
  }
  
  public void setIntentForStartForwardRecentActivity(Intent paramIntent)
  {
    this.mImpl.setIntentForStartForwardRecentActivity(paramIntent);
  }
  
  public void setItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.mImpl.setItemClickListener(paramOnItemClickListener);
  }
  
  public void setItemClickListenerV2(ShareActionSheet.OnItemClickListener paramOnItemClickListener)
  {
    this.mImpl.setItemClickListenerV2(paramOnItemClickListener);
  }
  
  public void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.mImpl.setOnDismissListener(paramOnDismissListener);
  }
  
  public void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener)
  {
    this.mImpl.setOnShowListener(paramOnShowListener);
  }
  
  public void setOpenSource(String paramString)
  {
    throw new IllegalStateException("not impl in ShareActionSheetImplV2");
  }
  
  public void setRowMarginLeftRight(int paramInt)
  {
    this.mImpl.setRowMarginLeftRight(paramInt);
  }
  
  public void setRowVisibility(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mImpl.setRowVisibility(paramInt1, paramInt2, paramInt3);
  }
  
  public void show()
  {
    if (this.mValidator.a()) {
      this.mImpl.show();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ShareActionSheetImplV2", 2, "show() called 参数无效");
  }
  
  public void updateUI()
  {
    this.mImpl.refresh();
  }
  
  public void updateUIIfShowing()
  {
    this.mImpl.refresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetImplV2
 * JD-Core Version:    0.7.0.1
 */