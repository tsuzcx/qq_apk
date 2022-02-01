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
import com.tencent.biz.subscribe.utils.NavigationBarUtil;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.IShareActionSheetV2BottomBar;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShareActionSheetBuilder
  implements ShareActionSheet
{
  protected int a;
  protected Context a;
  protected View a;
  protected AdapterView.OnItemClickListener a;
  protected GridView a;
  public LinearLayout a;
  protected TextView a;
  public ElasticHorScrView a;
  protected ShareActionSheetBuilder.AdViewManager a;
  private ShareActionSheet jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  protected ActionSheet a;
  protected CharSequence a;
  private String jdField_a_of_type_JavaLangString;
  protected boolean a;
  protected List<ShareActionSheetBuilder.ActionSheetItem>[] a;
  protected int b;
  protected GridView b;
  public TextView b;
  public ElasticHorScrView b;
  protected boolean b;
  protected int c;
  private boolean c;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  
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
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    if (paramInt == 2)
    {
      ShareActionSheetV2.Param localParam = new ShareActionSheetV2.Param();
      localParam.context = paramContext;
      localParam.fullScreen = paramBoolean;
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet = ShareActionSheetFactory.create(localParam);
      return;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.b(this.jdField_a_of_type_AndroidContentContext, null));
    } else {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null));
    }
    paramContext = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_c_of_type_Int = paramContext.getDimensionPixelSize(2131296796);
    this.e = this.jdField_c_of_type_Int;
    this.f = paramContext.getDimensionPixelOffset(2131296798);
    this.g = paramContext.getDimensionPixelOffset(2131296799);
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$AdViewManager = new ShareActionSheetBuilder.AdViewManager();
    paramInt = paramContext.getDisplayMetrics().widthPixels;
    int i = paramContext.getDisplayMetrics().heightPixels;
    if (paramInt > i) {
      paramInt = i;
    }
    paramInt = (paramInt - (int)(getIconWidth() * 5.2F)) / (((int)5.2F + 1) * 2);
    setIconMarginLeftRight(paramInt);
    setRowMarginLeftRight((int)(paramInt * 6 / 5.5F));
  }
  
  private static int a(TextPaint paramTextPaint, String paramString, float paramFloat)
  {
    if (paramTextPaint.measureText(paramString) < paramFloat) {
      return paramString.length();
    }
    int i = 1;
    while (i <= paramString.length())
    {
      if (paramTextPaint.measureText(paramString.substring(0, i)) > paramFloat) {
        return i;
      }
      i += 1;
    }
    return paramString.length();
  }
  
  protected static String a(TextPaint paramTextPaint, float paramFloat, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    int i = a(paramTextPaint, paramString, paramFloat);
    String str;
    if (LocaleManager.a())
    {
      paramInt = Math.min(paramInt, i);
      if (paramString.length() <= paramInt) {
        return paramString;
      }
      str = paramString.substring(0, paramInt);
      paramString = paramString.substring(paramInt);
      paramInt = a(paramTextPaint, paramString, paramFloat);
      paramTextPaint = paramString;
      if (paramString.length() > paramInt)
      {
        paramTextPaint = new StringBuilder();
        paramTextPaint.append(paramString.substring(0, paramInt));
        paramTextPaint.append("..");
        paramTextPaint = paramTextPaint.toString();
      }
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append("\n");
      paramString.append(paramTextPaint);
      return paramString.toString();
    }
    if (paramString.length() <= i) {
      return paramString;
    }
    paramTextPaint = new StringBuilder();
    paramString = paramString.split(" ");
    int j = paramString.length;
    paramInt = 0;
    while (paramInt < j)
    {
      str = paramString[paramInt];
      int k = paramTextPaint.toString().length() + str.length();
      if (k > i * 2) {
        break;
      }
      if ((!paramTextPaint.toString().contains("\n")) && (k > i)) {
        paramTextPaint.append("\n");
      }
      paramTextPaint.append(str);
      paramTextPaint.append(" ");
      paramInt += 1;
    }
    paramString = paramTextPaint.toString().trim();
    paramTextPaint = paramString;
    if (paramString.length() > i * 2)
    {
      paramTextPaint = new StringBuilder();
      paramTextPaint.append(paramString.substring(0, i));
      paramTextPaint.append("..");
      paramTextPaint = paramTextPaint.toString();
    }
    return paramTextPaint;
  }
  
  private void a(GridView paramGridView, List<ShareActionSheetBuilder.ActionSheetItem> paramList, StaticLayout paramStaticLayout, int paramInt)
  {
    paramGridView.setOverScrollMode(2);
    Object localObject = paramList.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext()) {
      if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject).next()).visibility == 0) {
        i += 1;
      }
    }
    int j = this.d + getIconWidth() + this.d;
    paramGridView.setColumnWidth(j);
    paramGridView.setNumColumns(i);
    localObject = paramGridView.getLayoutParams();
    paramGridView.setPadding(this.h, paramGridView.getPaddingTop(), this.h, paramGridView.getPaddingBottom());
    int k = this.h;
    ((ViewGroup.LayoutParams)localObject).width = (i * j + k + k);
    ((ViewGroup.LayoutParams)localObject).height = (this.jdField_c_of_type_Int + this.f + paramStaticLayout.getHeight() + paramInt);
    paramGridView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramGridView.setAdapter(a(this.jdField_a_of_type_AndroidContentContext, paramList));
    paramGridView.setSelector(new ColorDrawable(0));
    paramGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
  }
  
  private void b(View paramView, List<ShareActionSheetBuilder.ActionSheetItem> paramList, StaticLayout paramStaticLayout, int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetGridView = ((GridView)paramView.findViewById(2131367812));
    this.jdField_b_of_type_AndroidWidgetGridView.setSmoothScrollbarEnabled(false);
    a(this.jdField_b_of_type_AndroidWidgetGridView, paramList, paramStaticLayout, paramInt);
    this.jdField_b_of_type_Int = this.jdField_b_of_type_AndroidWidgetGridView.getLayoutParams().width;
  }
  
  protected int a()
  {
    return 2131558906;
  }
  
  @TargetApi(9)
  protected View a()
  {
    View localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, a(), null);
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$AdViewManager.a((RelativeLayout)localView.findViewById(2131362261));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131361996));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131361994));
    Object localObject1;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject1 = this.jdField_a_of_type_JavaLangCharSequence;
      if (localObject1 != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
    }
    else
    {
      hideTitle();
    }
    this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131377008));
    this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131377009));
    Object localObject2 = a();
    if (localObject2.length > 0) {
      localObject1 = localObject2[0];
    } else {
      localObject1 = new ArrayList(0);
    }
    boolean bool1 = ((List)localObject1).isEmpty() ^ true;
    if (localObject2.length > 1) {
      localObject2 = localObject2[1];
    } else {
      localObject2 = new ArrayList(0);
    }
    boolean bool2 = ((List)localObject2).isEmpty() ^ true;
    Object localObject3 = new TextPaint();
    ((TextPaint)localObject3).setTextSize(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299101));
    StaticLayout localStaticLayout1 = new StaticLayout(a((TextPaint)localObject3, this.e, a((List)localObject1), 5), (TextPaint)localObject3, this.e, Layout.Alignment.ALIGN_CENTER, 1.0F, this.g, true);
    StaticLayout localStaticLayout2 = new StaticLayout(a((TextPaint)localObject3, this.e, a((List)localObject2), 5), (TextPaint)localObject3, this.e, Layout.Alignment.ALIGN_CENTER, 1.0F, this.g, true);
    localObject3 = localStaticLayout2;
    if (localStaticLayout1.getHeight() >= localStaticLayout2.getHeight()) {
      localObject3 = localStaticLayout1;
    }
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelOffset(2131296795);
    if (bool1) {
      a(localView, (List)localObject1, (StaticLayout)localObject3, i);
    }
    if (bool2) {
      b(localView, (List)localObject2, (StaticLayout)localObject3, i);
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131361986));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131690728);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new ShareActionSheetBuilder.1(this));
    if (!bool1) {
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
    }
    if (!bool2) {
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
    }
    localView.post(new ShareActionSheetBuilder.2(this));
    return localView;
  }
  
  protected ShareActionSheetBuilder.ActionSheetItemAdapter a(Context paramContext, List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    return new ShareActionSheetBuilder.ActionSheetItemAdapter(paramContext, paramList);
  }
  
  protected String a(List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    Object localObject1 = "";
    int i = 0;
    while (i < paramList.size())
    {
      String str = ((ShareActionSheetBuilder.ActionSheetItem)paramList.get(i)).label;
      Object localObject2 = localObject1;
      if (str.length() > ((String)localObject1).length()) {
        localObject2 = str;
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  protected void a(View paramView, List<ShareActionSheetBuilder.ActionSheetItem> paramList, StaticLayout paramStaticLayout, int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)paramView.findViewById(2131367811));
    a(this.jdField_a_of_type_AndroidWidgetGridView, paramList, paramStaticLayout, paramInt);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams().width;
  }
  
  protected void a(ElasticHorScrView paramElasticHorScrView, int paramInt)
  {
    int i = paramElasticHorScrView.getWidth();
    boolean bool = true;
    if (i < paramInt) {
      paramElasticHorScrView.setMove(true);
    } else {
      paramElasticHorScrView.setMove(false);
    }
    if (QLog.isColorLevel())
    {
      paramElasticHorScrView = new StringBuilder();
      paramElasticHorScrView.append("setMove, scrollViewLength = ");
      paramElasticHorScrView.append(i);
      paramElasticHorScrView.append("; gridViewLength = ");
      paramElasticHorScrView.append(paramInt);
      paramElasticHorScrView.append("; move = ");
      if (i >= paramInt) {
        bool = false;
      }
      paramElasticHorScrView.append(bool);
      QLog.d("ShareActionSheetBuilder", 2, paramElasticHorScrView.toString());
    }
  }
  
  protected List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    List[] arrayOfList = this.jdField_a_of_type_ArrayOfJavaUtilList;
    if (arrayOfList != null) {
      return arrayOfList;
    }
    return (List[])new ArrayList[0];
  }
  
  public void dismiss()
  {
    ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localShareActionSheet != null)
    {
      localShareActionSheet.dismiss();
      return;
    }
    setOpenSource(null);
    if (isShowing()) {
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        this.jdField_a_of_type_AndroidViewView = null;
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        QLog.w("ShareActionSheetBuilder", 2, "Exception while dismiss", localRuntimeException);
      }
    }
  }
  
  public void dismissImmediately()
  {
    ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localShareActionSheet != null) {
      localShareActionSheet.dismissImmediately();
    }
  }
  
  public View findViewById(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localObject != null) {
      return ((ShareActionSheet)localObject).findViewById(paramInt);
    }
    localObject = this.jdField_a_of_type_ComTencentWidgetActionSheet.getWindow();
    if (localObject != null) {
      return ((Window)localObject).findViewById(paramInt);
    }
    return null;
  }
  
  public ActionSheet getActionSheet()
  {
    ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localShareActionSheet != null) {
      return localShareActionSheet.getActionSheet();
    }
    return this.jdField_a_of_type_ComTencentWidgetActionSheet;
  }
  
  public int getActionSheetPanelViewHeight()
  {
    ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localShareActionSheet != null) {
      return localShareActionSheet.getActionSheetPanelViewHeight();
    }
    return 0;
  }
  
  public Bundle getExtras()
  {
    ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localShareActionSheet != null) {
      return localShareActionSheet.getExtras();
    }
    return null;
  }
  
  public int getIconMarginLeftRight()
  {
    return this.d;
  }
  
  public int getIconWidth()
  {
    ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localShareActionSheet != null) {
      return localShareActionSheet.getIconWidth();
    }
    return this.jdField_c_of_type_Int;
  }
  
  public String getOpenSource()
  {
    ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localShareActionSheet != null) {
      return localShareActionSheet.getOpenSource();
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public Window getWindow()
  {
    ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localShareActionSheet != null) {
      return localShareActionSheet.getWindow();
    }
    return this.jdField_a_of_type_ComTencentWidgetActionSheet.getWindow();
  }
  
  public void hideTitle()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localObject != null)
    {
      ((ShareActionSheet)localObject).hideTitle();
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if ((localObject != null) && (((TextView)localObject).getVisibility() != 8)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public boolean isShowing()
  {
    ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localShareActionSheet != null) {
      return localShareActionSheet.isShowing();
    }
    return this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing();
  }
  
  public void onConfigurationChanged()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localObject != null)
    {
      ((ShareActionSheet)localObject).onConfigurationChanged();
      return;
    }
    localObject = this.jdField_a_of_type_AndroidContentContext;
    if (localObject == null) {
      return;
    }
    int i = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - this.h;
    localObject = this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView;
    if ((localObject != null) && (this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView != null))
    {
      if (i < this.jdField_a_of_type_Int) {
        ((ElasticHorScrView)localObject).setMove(true);
      } else {
        ((ElasticHorScrView)localObject).setMove(false);
      }
      if (i < this.jdField_b_of_type_Int)
      {
        this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
        return;
      }
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
    }
  }
  
  public void refresh()
  {
    ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localShareActionSheet != null) {
      localShareActionSheet.refresh();
    }
  }
  
  public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem> paramList1, List<ShareActionSheetBuilder.ActionSheetItem> paramList2) {}
  
  public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem>[] paramArrayOfList)
  {
    ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localShareActionSheet != null)
    {
      localShareActionSheet.setActionSheetItems(paramArrayOfList);
      return;
    }
    this.jdField_a_of_type_ArrayOfJavaUtilList = paramArrayOfList;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void setActionSheetTitle(CharSequence paramCharSequence)
  {
    ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localShareActionSheet != null)
    {
      localShareActionSheet.setActionSheetTitle(paramCharSequence);
      return;
    }
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    paramCharSequence = this.jdField_a_of_type_AndroidWidgetTextView;
    if (paramCharSequence != null) {
      paramCharSequence.setText(this.jdField_a_of_type_JavaLangCharSequence);
    }
  }
  
  public void setAdvBgColor(int paramInt)
  {
    ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localShareActionSheet != null)
    {
      localShareActionSheet.setAdvBgColor(paramInt);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$AdViewManager.a(paramInt);
  }
  
  public void setAdvView(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localShareActionSheet != null)
    {
      localShareActionSheet.setAdvView(paramView, paramLayoutParams);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$AdViewManager.a(paramView, paramLayoutParams);
  }
  
  public void setBottomBarInterface(ShareActionSheet.IShareActionSheetV2BottomBar paramIShareActionSheetV2BottomBar)
  {
    ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localShareActionSheet != null) {
      localShareActionSheet.setBottomBarInterface(paramIShareActionSheetV2BottomBar);
    }
  }
  
  public void setCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localShareActionSheet != null)
    {
      localShareActionSheet.setCancelListener(paramOnCancelListener);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnCancelListener(paramOnCancelListener);
  }
  
  public void setEnableNotTriggerVirtualNavigationBar(boolean paramBoolean)
  {
    ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localShareActionSheet != null)
    {
      localShareActionSheet.setEnableNotTriggerVirtualNavigationBar(paramBoolean);
      return;
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setExtras(Bundle paramBundle)
  {
    ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localShareActionSheet != null) {
      localShareActionSheet.setExtras(paramBundle);
    }
  }
  
  public void setIconMarginLeftRight(int paramInt)
  {
    ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localShareActionSheet != null)
    {
      localShareActionSheet.setIconMarginLeftRight(paramInt);
      return;
    }
    this.d = paramInt;
  }
  
  public void setIntentForStartForwardRecentActivity(Intent paramIntent)
  {
    ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localShareActionSheet != null) {
      localShareActionSheet.setIntentForStartForwardRecentActivity(paramIntent);
    }
  }
  
  public void setItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localShareActionSheet != null)
    {
      localShareActionSheet.setItemClickListener(paramOnItemClickListener);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
    this.jdField_a_of_type_Boolean = true;
    if (paramOnItemClickListener == null)
    {
      paramOnItemClickListener = this.jdField_a_of_type_AndroidWidgetGridView;
      if (paramOnItemClickListener != null) {
        paramOnItemClickListener.setOnItemClickListener(null);
      }
      paramOnItemClickListener = this.jdField_b_of_type_AndroidWidgetGridView;
      if (paramOnItemClickListener != null) {
        paramOnItemClickListener.setOnItemClickListener(null);
      }
    }
  }
  
  public void setItemClickListenerV2(ShareActionSheet.OnItemClickListener paramOnItemClickListener)
  {
    ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localShareActionSheet != null) {
      localShareActionSheet.setItemClickListenerV2(paramOnItemClickListener);
    }
  }
  
  public void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localObject != null)
    {
      ((ShareActionSheet)localObject).setOnDismissListener(paramOnDismissListener);
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if (localObject != null) {
      ((ActionSheet)localObject).setOnDismissListener(paramOnDismissListener);
    }
  }
  
  public void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener)
  {
    ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localShareActionSheet != null)
    {
      localShareActionSheet.setOnShowListener(paramOnShowListener);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnShowListener(paramOnShowListener);
  }
  
  public void setOpenSource(String paramString)
  {
    ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localShareActionSheet != null)
    {
      localShareActionSheet.setOpenSource(paramString);
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setRowMarginLeftRight(int paramInt)
  {
    ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localShareActionSheet != null)
    {
      localShareActionSheet.setRowMarginLeftRight(paramInt);
      return;
    }
    this.h = paramInt;
  }
  
  public void setRowVisibility(int paramInt1, int paramInt2, int paramInt3)
  {
    ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localShareActionSheet != null) {
      localShareActionSheet.setRowVisibility(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void setTitlePadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void show()
  {
    ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localShareActionSheet != null)
    {
      localShareActionSheet.show();
      return;
    }
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidViewView = a();
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setActionContentView(this.jdField_a_of_type_AndroidViewView, null);
    try
    {
      if (!isShowing())
      {
        if (this.jdField_c_of_type_Boolean) {
          NavigationBarUtil.b(getWindow());
        }
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
        if (this.jdField_c_of_type_Boolean)
        {
          NavigationBarUtil.a(getWindow());
          NavigationBarUtil.c(getWindow());
          return;
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("actionSheet.show exception=");
        localStringBuilder.append(localException);
        QLog.d("ShareActionSheetBuilder", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void updateUI()
  {
    ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localShareActionSheet != null)
    {
      localShareActionSheet.updateUI();
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.jdField_a_of_type_AndroidViewView = a();
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setActionContentView(this.jdField_a_of_type_AndroidViewView, null);
    }
  }
  
  public void updateUIIfShowing()
  {
    ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localShareActionSheet != null)
    {
      localShareActionSheet.updateUIIfShowing();
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.jdField_a_of_type_AndroidViewView = a();
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setActionContentView(this.jdField_a_of_type_AndroidViewView, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShareActionSheetBuilder
 * JD-Core Version:    0.7.0.1
 */