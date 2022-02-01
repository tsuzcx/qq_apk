package com.tencent.mobileqq.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anxv;
import bkzi;
import bkzz;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.IShareActionSheetV2BottomBar;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import zza;

public class ShareActionSheetBuilder
  implements ShareActionSheet
{
  protected static final int CHARS_COUNT_PER_LINE = 5;
  private static final String TAG = "ShareActionSheetBuilder";
  public TextView cancel;
  protected AdapterView.OnItemClickListener clickListener;
  protected CharSequence dialogTitle;
  protected GridView grid_row_view1;
  protected GridView grid_row_view2;
  protected int itemImageSize;
  protected int itemMargin;
  protected int itemTextMargin;
  protected int itemTextWidth;
  protected List<ShareActionSheetBuilder.ActionSheetItem>[] mActionSheetItems;
  public LinearLayout mActionSheetLin;
  protected ShareActionSheetBuilder.AdViewManager mAdViewManager;
  public bkzi mDialog;
  private boolean mEnableNotTriggerVirtualNavigationBar;
  public int mGridView1Length;
  protected int mGridView2Length;
  protected boolean mIsDataChanged;
  protected Context mOutAct;
  private ShareActionSheet mProxy;
  public ElasticHorScrView mScrollView1;
  public ElasticHorScrView mScrollView2;
  protected View mShowView;
  protected TextView mTitleTv;
  private String openSource;
  protected int scrollViewMargin;
  protected boolean showTitle = true;
  protected int textSpacingExtra;
  
  public ShareActionSheetBuilder(Context paramContext)
  {
    this(paramContext, false);
  }
  
  public ShareActionSheetBuilder(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, paramBoolean, 1);
  }
  
  public ShareActionSheetBuilder(Context paramContext, boolean paramBoolean, int paramInt)
  {
    if (paramInt == 2)
    {
      ShareActionSheetV2.Param localParam = new ShareActionSheetV2.Param();
      localParam.context = paramContext;
      localParam.fullScreen = paramBoolean;
      this.mProxy = ShareActionSheetFactory.create(localParam);
      return;
    }
    this.mOutAct = paramContext;
    if (paramBoolean)
    {
      this.mDialog = ((bkzi)bkzz.b(this.mOutAct, null));
      paramContext = this.mOutAct.getResources();
      this.itemImageSize = paramContext.getDimensionPixelSize(2131296796);
      this.itemTextWidth = this.itemImageSize;
      this.itemTextMargin = paramContext.getDimensionPixelOffset(2131296798);
      this.textSpacingExtra = paramContext.getDimensionPixelOffset(2131296799);
      this.mAdViewManager = new ShareActionSheetBuilder.AdViewManager();
      paramInt = paramContext.getDisplayMetrics().widthPixels;
      int i = paramContext.getDisplayMetrics().heightPixels;
      if (paramInt <= i) {
        break label209;
      }
      paramInt = i;
    }
    label209:
    for (;;)
    {
      paramInt = (paramInt - (int)(getIconWidth() * 5.2F)) / (((int)5.2F + 1) * 2);
      setIconMarginLeftRight(paramInt);
      setRowMarginLeftRight((int)(paramInt * 6 / 5.5F));
      return;
      this.mDialog = ((bkzi)bkzz.a(this.mOutAct, null));
      break;
    }
  }
  
  protected static String breakLabel(String paramString, int paramInt)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > paramInt) {
        str = paramString.substring(0, paramInt) + "\n" + paramString.substring(paramInt);
      }
    }
    return str;
  }
  
  protected static String breakLabel2(TextPaint paramTextPaint, float paramFloat, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    String str;
    do
    {
      do
      {
        return paramString;
        i = findMaxCharCntPerLine(paramTextPaint, paramString, paramFloat);
        if (!anxv.a()) {
          break;
        }
        paramInt = Math.min(paramInt, i);
      } while (paramString.length() <= paramInt);
      str = paramString.substring(0, paramInt);
      paramString = paramString.substring(paramInt);
      paramInt = findMaxCharCntPerLine(paramTextPaint, paramString, paramFloat);
      paramTextPaint = paramString;
      if (paramString.length() > paramInt) {
        paramTextPaint = paramString.substring(0, paramInt) + "..";
      }
      return str + "\n" + paramTextPaint;
    } while (paramString.length() <= i);
    paramTextPaint = new StringBuilder();
    paramString = paramString.split(" ");
    int j = paramString.length;
    paramInt = 0;
    for (;;)
    {
      int k;
      if (paramInt < j)
      {
        str = paramString[paramInt];
        k = paramTextPaint.toString().length() + str.length();
        if (k <= i * 2) {}
      }
      else
      {
        paramString = paramTextPaint.toString().trim();
        paramTextPaint = paramString;
        if (paramString.length() > i * 2) {
          paramTextPaint = paramString.substring(0, i) + "..";
        }
        return paramTextPaint;
      }
      if ((!paramTextPaint.toString().contains("\n")) && (k > i)) {
        paramTextPaint.append("\n");
      }
      paramTextPaint.append(str).append(" ");
      paramInt += 1;
    }
  }
  
  private static int findMaxCharCntPerLine(TextPaint paramTextPaint, String paramString, float paramFloat)
  {
    int j;
    if (paramTextPaint.measureText(paramString) < paramFloat)
    {
      j = paramString.length();
      return j;
    }
    int i = 1;
    for (;;)
    {
      if (i > paramString.length()) {
        break label54;
      }
      j = i;
      if (paramTextPaint.measureText(paramString.substring(0, i)) > paramFloat) {
        break;
      }
      i += 1;
    }
    label54:
    return paramString.length();
  }
  
  private void handleScrollView(GridView paramGridView, List<ShareActionSheetBuilder.ActionSheetItem> paramList, StaticLayout paramStaticLayout, int paramInt)
  {
    paramGridView.setOverScrollMode(2);
    Object localObject = paramList.iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject).next()).visibility != 0) {
        break label187;
      }
      i += 1;
    }
    label187:
    for (;;)
    {
      break;
      int j = this.itemMargin + getIconWidth() + this.itemMargin;
      paramGridView.setColumnWidth(j);
      paramGridView.setNumColumns(i);
      localObject = paramGridView.getLayoutParams();
      paramGridView.setPadding(this.scrollViewMargin, paramGridView.getPaddingTop(), this.scrollViewMargin, paramGridView.getPaddingBottom());
      ((ViewGroup.LayoutParams)localObject).width = (j * i + this.scrollViewMargin + this.scrollViewMargin);
      ((ViewGroup.LayoutParams)localObject).height = (this.itemImageSize + this.itemTextMargin + paramStaticLayout.getHeight() + paramInt);
      paramGridView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramGridView.setAdapter(createActionSheetItemAdapter(this.mOutAct, paramList));
      paramGridView.setSelector(new ColorDrawable(0));
      paramGridView.setOnItemClickListener(this.clickListener);
      return;
    }
  }
  
  private void handleScrollViewTwo(View paramView, List<ShareActionSheetBuilder.ActionSheetItem> paramList, StaticLayout paramStaticLayout, int paramInt)
  {
    this.grid_row_view2 = ((GridView)paramView.findViewById(2131367852));
    this.grid_row_view2.setSmoothScrollbarEnabled(false);
    handleScrollView(this.grid_row_view2, paramList, paramStaticLayout, paramInt);
    this.mGridView2Length = this.grid_row_view2.getLayoutParams().width;
  }
  
  protected ShareActionSheetBuilder.ActionSheetItemAdapter createActionSheetItemAdapter(Context paramContext, List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    return new ShareActionSheetBuilder.ActionSheetItemAdapter(paramContext, paramList);
  }
  
  @TargetApi(9)
  protected View createViewFlipper()
  {
    View localView = View.inflate(this.mOutAct, getActionSheetLayoutId(), null);
    this.mAdViewManager.setAdContainer((RelativeLayout)localView.findViewById(2131362221));
    this.mActionSheetLin = ((LinearLayout)localView.findViewById(2131361978));
    this.mTitleTv = ((TextView)localView.findViewById(2131361976));
    Object localObject2;
    Object localObject1;
    if (this.showTitle)
    {
      this.mTitleTv.setVisibility(0);
      if (this.dialogTitle != null) {
        this.mTitleTv.setText(this.dialogTitle);
      }
      this.mScrollView1 = ((ElasticHorScrView)localView.findViewById(2131377144));
      this.mScrollView2 = ((ElasticHorScrView)localView.findViewById(2131377145));
      localObject2 = getActionSheetItems();
      if (localObject2.length <= 0) {
        break label439;
      }
      localObject1 = localObject2[0];
      label143:
      if (!((List)localObject1).isEmpty()) {
        break label477;
      }
    }
    label168:
    label439:
    label472:
    label477:
    for (int i = 0;; i = 1)
    {
      if (localObject2.length > 1)
      {
        localObject2 = localObject2[1];
        if (!((List)localObject2).isEmpty()) {
          break label472;
        }
      }
      for (int j = 0;; j = 1)
      {
        Object localObject4 = new TextPaint();
        ((TextPaint)localObject4).setTextSize(this.mOutAct.getResources().getDimensionPixelSize(2131299008));
        Object localObject3 = new StaticLayout(breakLabel2((TextPaint)localObject4, this.itemTextWidth, getLongestLabel((List)localObject1), 5), (TextPaint)localObject4, this.itemTextWidth, Layout.Alignment.ALIGN_CENTER, 1.0F, this.textSpacingExtra, true);
        localObject4 = new StaticLayout(breakLabel2((TextPaint)localObject4, this.itemTextWidth, getLongestLabel((List)localObject2), 5), (TextPaint)localObject4, this.itemTextWidth, Layout.Alignment.ALIGN_CENTER, 1.0F, this.textSpacingExtra, true);
        if (((StaticLayout)localObject3).getHeight() >= ((StaticLayout)localObject4).getHeight()) {}
        for (;;)
        {
          int k = this.mOutAct.getResources().getDimensionPixelOffset(2131296795);
          if (i != 0) {
            handleScrollViewOne(localView, (List)localObject1, (StaticLayout)localObject3, k);
          }
          if (j != 0) {
            handleScrollViewTwo(localView, (List)localObject2, (StaticLayout)localObject3, k);
          }
          this.cancel = ((TextView)localView.findViewById(2131361968));
          this.cancel.setText(2131692672);
          this.cancel.setOnClickListener(new ShareActionSheetBuilder.1(this));
          if (i == 0) {
            this.mScrollView1.setVisibility(8);
          }
          if (j == 0) {
            this.mScrollView2.setVisibility(8);
          }
          localView.post(new ShareActionSheetBuilder.2(this));
          return localView;
          hideTitle();
          break;
          localObject1 = new ArrayList(0);
          break label143;
          localObject2 = new ArrayList(0);
          break label168;
          localObject3 = localObject4;
        }
      }
    }
  }
  
  public void dismiss()
  {
    if (this.mProxy != null) {
      this.mProxy.dismiss();
    }
    do
    {
      return;
      setOpenSource(null);
    } while (!isShowing());
    try
    {
      this.mDialog.dismiss();
      this.mShowView = null;
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.w("ShareActionSheetBuilder", 2, "Exception while dismiss", localRuntimeException);
    }
  }
  
  public void dismissImmediately()
  {
    if (this.mProxy != null) {
      this.mProxy.dismissImmediately();
    }
  }
  
  public View findViewById(int paramInt)
  {
    if (this.mProxy != null) {
      return this.mProxy.findViewById(paramInt);
    }
    Window localWindow = this.mDialog.getWindow();
    if (localWindow != null) {
      return localWindow.findViewById(paramInt);
    }
    return null;
  }
  
  public bkzi getActionSheet()
  {
    if (this.mProxy != null) {
      return this.mProxy.getActionSheet();
    }
    return this.mDialog;
  }
  
  protected List<ShareActionSheetBuilder.ActionSheetItem>[] getActionSheetItems()
  {
    if (this.mActionSheetItems != null) {
      return this.mActionSheetItems;
    }
    return (List[])new ArrayList[0];
  }
  
  protected int getActionSheetLayoutId()
  {
    return 2131558971;
  }
  
  public int getActionSheetPanelViewHeight()
  {
    if (this.mProxy != null) {
      return this.mProxy.getActionSheetPanelViewHeight();
    }
    return 0;
  }
  
  public int getIconMarginLeftRight()
  {
    return this.itemMargin;
  }
  
  public int getIconWidth()
  {
    if (this.mProxy != null) {
      return this.mProxy.getIconWidth();
    }
    return this.itemImageSize;
  }
  
  protected String getLongestLabel(List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    Object localObject = "";
    int i = 0;
    if (i < paramList.size())
    {
      String str = ((ShareActionSheetBuilder.ActionSheetItem)paramList.get(i)).label;
      if (str.length() <= ((String)localObject).length()) {
        break label55;
      }
      localObject = str;
    }
    label55:
    for (;;)
    {
      i += 1;
      break;
      return localObject;
    }
  }
  
  public String getOpenSource()
  {
    if (this.mProxy != null) {
      return this.mProxy.getOpenSource();
    }
    return this.openSource;
  }
  
  public Window getWindow()
  {
    if (this.mProxy != null) {
      return this.mProxy.getWindow();
    }
    return this.mDialog.getWindow();
  }
  
  protected void handleScrollViewOne(View paramView, List<ShareActionSheetBuilder.ActionSheetItem> paramList, StaticLayout paramStaticLayout, int paramInt)
  {
    this.grid_row_view1 = ((GridView)paramView.findViewById(2131367851));
    handleScrollView(this.grid_row_view1, paramList, paramStaticLayout, paramInt);
    this.mGridView1Length = this.grid_row_view1.getLayoutParams().width;
  }
  
  protected void handleSetMove(ElasticHorScrView paramElasticHorScrView, int paramInt)
  {
    boolean bool = true;
    int i = paramElasticHorScrView.getWidth();
    if (i < paramInt)
    {
      paramElasticHorScrView.setMove(true);
      if (QLog.isColorLevel())
      {
        paramElasticHorScrView = new StringBuilder().append("setMove, scrollViewLength = ").append(i).append("; gridViewLength = ").append(paramInt).append("; move = ");
        if (i >= paramInt) {
          break label87;
        }
      }
    }
    for (;;)
    {
      QLog.d("ShareActionSheetBuilder", 2, bool);
      return;
      paramElasticHorScrView.setMove(false);
      break;
      label87:
      bool = false;
    }
  }
  
  public void hideTitle()
  {
    if (this.mProxy != null) {
      this.mProxy.hideTitle();
    }
    do
    {
      return;
      this.showTitle = false;
    } while ((this.mTitleTv == null) || (this.mTitleTv.getVisibility() == 8));
    this.mTitleTv.setVisibility(8);
  }
  
  public boolean isShowing()
  {
    if (this.mProxy != null) {
      return this.mProxy.isShowing();
    }
    return this.mDialog.isShowing();
  }
  
  public void onConfigurationChanged()
  {
    if (this.mProxy != null) {
      this.mProxy.onConfigurationChanged();
    }
    int i;
    do
    {
      do
      {
        return;
      } while (this.mOutAct == null);
      i = this.mOutAct.getResources().getDisplayMetrics().widthPixels - this.scrollViewMargin;
    } while ((this.mScrollView1 == null) || (this.mScrollView2 == null));
    if (i < this.mGridView1Length) {
      this.mScrollView1.setMove(true);
    }
    while (i < this.mGridView2Length)
    {
      this.mScrollView2.setMove(true);
      return;
      this.mScrollView1.setMove(false);
    }
    this.mScrollView2.setMove(false);
  }
  
  public void refresh()
  {
    if (this.mProxy != null) {
      this.mProxy.refresh();
    }
  }
  
  public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem> paramList1, List<ShareActionSheetBuilder.ActionSheetItem> paramList2) {}
  
  public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem>[] paramArrayOfList)
  {
    if (this.mProxy != null)
    {
      this.mProxy.setActionSheetItems(paramArrayOfList);
      return;
    }
    this.mActionSheetItems = paramArrayOfList;
    this.mIsDataChanged = true;
  }
  
  public void setActionSheetTitle(CharSequence paramCharSequence)
  {
    if (this.mProxy != null) {
      this.mProxy.setActionSheetTitle(paramCharSequence);
    }
    do
    {
      return;
      this.dialogTitle = paramCharSequence;
    } while (this.mTitleTv == null);
    this.mTitleTv.setText(this.dialogTitle);
  }
  
  public void setAdvBgColor(int paramInt)
  {
    if (this.mProxy != null)
    {
      this.mProxy.setAdvBgColor(paramInt);
      return;
    }
    this.mAdViewManager.setBgColor(paramInt);
  }
  
  public void setAdvView(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    if (this.mProxy != null)
    {
      this.mProxy.setAdvView(paramView, paramLayoutParams);
      return;
    }
    this.mAdViewManager.setAdView(paramView, paramLayoutParams);
  }
  
  public void setBottomBarInterface(ShareActionSheet.IShareActionSheetV2BottomBar paramIShareActionSheetV2BottomBar)
  {
    if (this.mProxy != null) {
      this.mProxy.setBottomBarInterface(paramIShareActionSheetV2BottomBar);
    }
  }
  
  public void setCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (this.mProxy != null)
    {
      this.mProxy.setCancelListener(paramOnCancelListener);
      return;
    }
    this.mDialog.setOnCancelListener(paramOnCancelListener);
  }
  
  public void setEnableNotTriggerVirtualNavigationBar(boolean paramBoolean)
  {
    if (this.mProxy != null)
    {
      this.mProxy.setEnableNotTriggerVirtualNavigationBar(paramBoolean);
      return;
    }
    this.mEnableNotTriggerVirtualNavigationBar = paramBoolean;
  }
  
  public void setExtras(Bundle paramBundle)
  {
    if (this.mProxy != null) {
      this.mProxy.setExtras(paramBundle);
    }
  }
  
  public void setIconMarginLeftRight(int paramInt)
  {
    if (this.mProxy != null)
    {
      this.mProxy.setIconMarginLeftRight(paramInt);
      return;
    }
    this.itemMargin = paramInt;
  }
  
  public void setIntentForStartForwardRecentActivity(Intent paramIntent)
  {
    if (this.mProxy != null) {
      this.mProxy.setIntentForStartForwardRecentActivity(paramIntent);
    }
  }
  
  public void setItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    if (this.mProxy != null) {
      this.mProxy.setItemClickListener(paramOnItemClickListener);
    }
    do
    {
      do
      {
        return;
        this.clickListener = paramOnItemClickListener;
        this.mIsDataChanged = true;
      } while (paramOnItemClickListener != null);
      if (this.grid_row_view1 != null) {
        this.grid_row_view1.setOnItemClickListener(null);
      }
    } while (this.grid_row_view2 == null);
    this.grid_row_view2.setOnItemClickListener(null);
  }
  
  public void setItemClickListenerV2(ShareActionSheet.OnItemClickListener paramOnItemClickListener)
  {
    if (this.mProxy != null) {
      this.mProxy.setItemClickListenerV2(paramOnItemClickListener);
    }
  }
  
  public void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (this.mProxy != null) {
      this.mProxy.setOnDismissListener(paramOnDismissListener);
    }
    while (this.mDialog == null) {
      return;
    }
    this.mDialog.setOnDismissListener(paramOnDismissListener);
  }
  
  public void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener)
  {
    if (this.mProxy != null)
    {
      this.mProxy.setOnShowListener(paramOnShowListener);
      return;
    }
    this.mDialog.setOnShowListener(paramOnShowListener);
  }
  
  public void setOpenSource(String paramString)
  {
    if (this.mProxy != null)
    {
      this.mProxy.setOpenSource(paramString);
      return;
    }
    this.openSource = paramString;
  }
  
  public void setRowMarginLeftRight(int paramInt)
  {
    if (this.mProxy != null)
    {
      this.mProxy.setRowMarginLeftRight(paramInt);
      return;
    }
    this.scrollViewMargin = paramInt;
  }
  
  public void setRowVisibility(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mProxy != null) {
      this.mProxy.setRowVisibility(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void setTitlePadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mTitleTv != null) {
      this.mTitleTv.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void show()
  {
    if (this.mProxy != null) {
      this.mProxy.show();
    }
    do
    {
      for (;;)
      {
        return;
        if ((this.mShowView == null) || (this.mIsDataChanged)) {
          this.mShowView = createViewFlipper();
        }
        this.mDialog.a(this.mShowView, null);
        try
        {
          if (!isShowing())
          {
            if (this.mEnableNotTriggerVirtualNavigationBar) {
              zza.b(getWindow());
            }
            this.mDialog.show();
            if (this.mEnableNotTriggerVirtualNavigationBar)
            {
              zza.a(getWindow());
              zza.c(getWindow());
              return;
            }
          }
        }
        catch (Exception localException) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("ShareActionSheetBuilder", 2, "actionSheet.show exception=" + localException);
  }
  
  public void updateUI()
  {
    if (this.mProxy != null) {
      this.mProxy.updateUI();
    }
    while (!this.mDialog.isShowing()) {
      return;
    }
    this.mShowView = createViewFlipper();
    this.mDialog.a(this.mShowView, null);
  }
  
  public void updateUIIfShowing()
  {
    if (this.mProxy != null) {
      this.mProxy.updateUIIfShowing();
    }
    while (!this.mDialog.isShowing()) {
      return;
    }
    this.mShowView = createViewFlipper();
    this.mDialog.a(this.mShowView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShareActionSheetBuilder
 * JD-Core Version:    0.7.0.1
 */