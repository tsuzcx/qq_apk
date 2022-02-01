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
import bjgq;
import blir;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import java.util.List;

public abstract interface ShareActionSheet
{
  public abstract void dismiss();
  
  public abstract void dismissImmediately();
  
  public abstract View findViewById(int paramInt);
  
  public abstract blir getActionSheet();
  
  public abstract int getActionSheetPanelViewHeight();
  
  public abstract int getIconWidth();
  
  public abstract String getOpenSource();
  
  public abstract Window getWindow();
  
  public abstract void hideTitle();
  
  public abstract boolean isShowing();
  
  public abstract void onConfigurationChanged();
  
  public abstract void refresh();
  
  public abstract void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem> paramList1, List<ShareActionSheetBuilder.ActionSheetItem> paramList2);
  
  @Deprecated
  public abstract void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem>[] paramArrayOfList);
  
  public abstract void setActionSheetTitle(CharSequence paramCharSequence);
  
  public abstract void setAdvBgColor(int paramInt);
  
  public abstract void setAdvView(View paramView, RelativeLayout.LayoutParams paramLayoutParams);
  
  public abstract void setBottomBarInterface(bjgq parambjgq);
  
  public abstract void setCancelListener(DialogInterface.OnCancelListener paramOnCancelListener);
  
  public abstract void setEnableNotTriggerVirtualNavigationBar(boolean paramBoolean);
  
  public abstract void setExtras(Bundle paramBundle);
  
  public abstract void setIconMarginLeftRight(int paramInt);
  
  public abstract void setIntentForStartForwardRecentActivity(Intent paramIntent);
  
  @Deprecated
  public abstract void setItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener);
  
  public abstract void setItemClickListenerV2(ShareActionSheet.OnItemClickListener paramOnItemClickListener);
  
  public abstract void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener);
  
  public abstract void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener);
  
  public abstract void setOpenSource(String paramString);
  
  public abstract void setRowMarginLeftRight(int paramInt);
  
  public abstract void setRowVisibility(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void show();
  
  @Deprecated
  public abstract void updateUI();
  
  @Deprecated
  public abstract void updateUIIfShowing();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheet
 * JD-Core Version:    0.7.0.1
 */