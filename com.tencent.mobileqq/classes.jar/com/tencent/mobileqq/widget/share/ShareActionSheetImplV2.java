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
  private ShareActionSheetV2 a;
  private Validator b;
  
  public ShareActionSheetImplV2(ShareActionSheetV2 paramShareActionSheetV2)
  {
    this.a = paramShareActionSheetV2;
    this.b = new Validator(paramShareActionSheetV2);
  }
  
  public void dismiss()
  {
    this.a.dismiss();
  }
  
  public void dismissImmediately()
  {
    this.a.dismissImmediately();
  }
  
  public View findViewById(int paramInt)
  {
    return this.a.findViewById(paramInt);
  }
  
  public ActionSheet getActionSheet()
  {
    throw new IllegalStateException("not impl in ShareActionSheetImplV2");
  }
  
  public int getActionSheetPanelViewHeight()
  {
    return this.a.getActionSheetPanelViewHeight();
  }
  
  public Bundle getExtras()
  {
    return this.a.getExtras();
  }
  
  public int getIconWidth()
  {
    return this.a.getIconWidth();
  }
  
  public String getOpenSource()
  {
    throw new IllegalStateException("not impl in ShareActionSheetImplV2");
  }
  
  public Window getWindow()
  {
    return this.a.getWindow();
  }
  
  public void hideTitle()
  {
    this.a.hideTitle();
  }
  
  public boolean isShowing()
  {
    return this.a.isShowing();
  }
  
  public void onConfigurationChanged()
  {
    this.a.onConfigurationChanged();
  }
  
  public void refresh()
  {
    this.a.refresh();
  }
  
  public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem> paramList1, List<ShareActionSheetBuilder.ActionSheetItem> paramList2)
  {
    this.a.setActionSheetItems(paramList1, paramList2);
  }
  
  public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem>[] paramArrayOfList)
  {
    this.a.setActionSheetItems(paramArrayOfList);
  }
  
  public void setActionSheetTitle(CharSequence paramCharSequence)
  {
    this.a.setActionSheetTitle(paramCharSequence);
  }
  
  public void setAdvBgColor(int paramInt)
  {
    this.a.setAdvBgColor(paramInt);
  }
  
  public void setAdvView(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    this.a.setAdvView(paramView, paramLayoutParams);
  }
  
  public void setBottomBarInterface(ShareActionSheet.IShareActionSheetV2BottomBar paramIShareActionSheetV2BottomBar)
  {
    this.a.setBottomBarInterface(paramIShareActionSheetV2BottomBar);
  }
  
  public void setCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.a.setCancelListener(paramOnCancelListener);
  }
  
  public void setEnableNotTriggerVirtualNavigationBar(boolean paramBoolean)
  {
    this.a.setEnableNotTriggerVirtualNavigationBar(paramBoolean);
  }
  
  public void setExtras(Bundle paramBundle)
  {
    this.a.setExtras(paramBundle);
  }
  
  public void setIconMarginLeftRight(int paramInt)
  {
    this.a.setIconMarginLeftRight(paramInt);
  }
  
  public void setIntentForStartForwardRecentActivity(Intent paramIntent)
  {
    this.a.setIntentForStartForwardRecentActivity(paramIntent);
  }
  
  public void setItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.a.setItemClickListener(paramOnItemClickListener);
  }
  
  public void setItemClickListenerV2(ShareActionSheet.OnItemClickListener paramOnItemClickListener)
  {
    this.a.setItemClickListenerV2(paramOnItemClickListener);
  }
  
  public void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.a.setOnDismissListener(paramOnDismissListener);
  }
  
  public void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener)
  {
    this.a.setOnShowListener(paramOnShowListener);
  }
  
  public void setOpenSource(String paramString)
  {
    throw new IllegalStateException("not impl in ShareActionSheetImplV2");
  }
  
  public void setRowMarginLeftRight(int paramInt)
  {
    this.a.setRowMarginLeftRight(paramInt);
  }
  
  public void setRowVisibility(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.setRowVisibility(paramInt1, paramInt2, paramInt3);
  }
  
  public void show()
  {
    if (this.b.a())
    {
      this.a.show();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetImplV2", 2, "show() called 参数无效");
    }
  }
  
  public void updateUI()
  {
    this.a.refresh();
  }
  
  public void updateUIIfShowing()
  {
    this.a.refresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetImplV2
 * JD-Core Version:    0.7.0.1
 */