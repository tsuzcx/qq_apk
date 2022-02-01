package com.tencent.mobileqq.utils;

import aaiz;
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
import anpe;
import bgrx;
import bgry;
import bgsb;
import bifr;
import bkho;
import bkif;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShareActionSheetBuilder
  implements ShareActionSheet
{
  public int a;
  protected Context a;
  protected View a;
  protected AdapterView.OnItemClickListener a;
  protected GridView a;
  public LinearLayout a;
  protected TextView a;
  protected bgsb a;
  public bkho a;
  public ElasticHorScrView a;
  private ShareActionSheet jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
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
    if (paramBoolean)
    {
      this.jdField_a_of_type_Bkho = ((bkho)bkif.b(this.jdField_a_of_type_AndroidContentContext, null));
      paramContext = this.jdField_a_of_type_AndroidContentContext.getResources();
      this.jdField_c_of_type_Int = paramContext.getDimensionPixelSize(2131296728);
      this.e = this.jdField_c_of_type_Int;
      this.f = paramContext.getDimensionPixelOffset(2131296730);
      this.g = paramContext.getDimensionPixelOffset(2131296731);
      this.jdField_a_of_type_Bgsb = new bgsb();
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
      this.jdField_a_of_type_Bkho = ((bkho)bkif.a(this.jdField_a_of_type_AndroidContentContext, null));
      break;
    }
  }
  
  private static int a(TextPaint paramTextPaint, String paramString, float paramFloat)
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
  
  public static String a(TextPaint paramTextPaint, float paramFloat, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    String str;
    do
    {
      do
      {
        return paramString;
        i = a(paramTextPaint, paramString, paramFloat);
        if (!anpe.a()) {
          break;
        }
        paramInt = Math.min(paramInt, i);
      } while (paramString.length() <= paramInt);
      str = paramString.substring(0, paramInt);
      paramString = paramString.substring(paramInt);
      paramInt = a(paramTextPaint, paramString, paramFloat);
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
  
  private void a(GridView paramGridView, List<ShareActionSheetBuilder.ActionSheetItem> paramList, StaticLayout paramStaticLayout, int paramInt)
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
      int j = this.d + getIconWidth() + this.d;
      paramGridView.setColumnWidth(j);
      paramGridView.setNumColumns(i);
      localObject = paramGridView.getLayoutParams();
      paramGridView.setPadding(this.h, paramGridView.getPaddingTop(), this.h, paramGridView.getPaddingBottom());
      ((ViewGroup.LayoutParams)localObject).width = (j * i + this.h + this.h);
      ((ViewGroup.LayoutParams)localObject).height = (this.jdField_c_of_type_Int + this.f + paramStaticLayout.getHeight() + paramInt);
      paramGridView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramGridView.setAdapter(a(this.jdField_a_of_type_AndroidContentContext, paramList));
      paramGridView.setSelector(new ColorDrawable(0));
      paramGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
      return;
    }
  }
  
  private void b(View paramView, List<ShareActionSheetBuilder.ActionSheetItem> paramList, StaticLayout paramStaticLayout, int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetGridView = ((GridView)paramView.findViewById(2131367615));
    this.jdField_b_of_type_AndroidWidgetGridView.setSmoothScrollbarEnabled(false);
    a(this.jdField_b_of_type_AndroidWidgetGridView, paramList, paramStaticLayout, paramInt);
    this.jdField_b_of_type_Int = this.jdField_b_of_type_AndroidWidgetGridView.getLayoutParams().width;
  }
  
  protected int a()
  {
    return 2131558937;
  }
  
  @TargetApi(9)
  protected View a()
  {
    View localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, a(), null);
    this.jdField_a_of_type_Bgsb.a((RelativeLayout)localView.findViewById(2131362205));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131361977));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131361975));
    Object localObject2;
    Object localObject1;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_JavaLangCharSequence != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      }
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131376981));
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131376982));
      localObject2 = a();
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
        ((TextPaint)localObject4).setTextSize(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298926));
        Object localObject3 = new StaticLayout(a((TextPaint)localObject4, this.e, a((List)localObject1), 5), (TextPaint)localObject4, this.e, Layout.Alignment.ALIGN_CENTER, 1.0F, this.g, true);
        localObject4 = new StaticLayout(a((TextPaint)localObject4, this.e, a((List)localObject2), 5), (TextPaint)localObject4, this.e, Layout.Alignment.ALIGN_CENTER, 1.0F, this.g, true);
        if (((StaticLayout)localObject3).getHeight() >= ((StaticLayout)localObject4).getHeight()) {}
        for (;;)
        {
          int k = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelOffset(2131296727);
          if (i != 0) {
            a(localView, (List)localObject1, (StaticLayout)localObject3, k);
          }
          if (j != 0) {
            b(localView, (List)localObject2, (StaticLayout)localObject3, k);
          }
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131361967));
          this.jdField_b_of_type_AndroidWidgetTextView.setText(2131692516);
          this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new bgrx(this));
          if (i == 0) {
            this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
          }
          if (j == 0) {
            this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
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
  
  protected bgry a(Context paramContext, List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    return new bgry(paramContext, paramList);
  }
  
  protected String a(List<ShareActionSheetBuilder.ActionSheetItem> paramList)
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
  
  protected void a(View paramView, List<ShareActionSheetBuilder.ActionSheetItem> paramList, StaticLayout paramStaticLayout, int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)paramView.findViewById(2131367614));
    a(this.jdField_a_of_type_AndroidWidgetGridView, paramList, paramStaticLayout, paramInt);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams().width;
  }
  
  protected void a(ElasticHorScrView paramElasticHorScrView, int paramInt)
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
          break label88;
        }
      }
    }
    for (;;)
    {
      QLog.d("ShareActionSheetBuilder", 2, bool);
      return;
      paramElasticHorScrView.setMove(false);
      break;
      label88:
      bool = false;
    }
  }
  
  protected List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    if (this.jdField_a_of_type_ArrayOfJavaUtilList != null) {
      return this.jdField_a_of_type_ArrayOfJavaUtilList;
    }
    return (List[])new ArrayList[0];
  }
  
  public void dismiss()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
    }
    do
    {
      return;
      setOpenSource(null);
    } while (!isShowing());
    try
    {
      this.jdField_a_of_type_Bkho.dismiss();
      this.jdField_a_of_type_AndroidViewView = null;
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.w("ShareActionSheetBuilder", 2, "Exception while dismiss", localRuntimeException);
    }
  }
  
  public void dismissImmediately()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismissImmediately();
    }
  }
  
  public View findViewById(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      return this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.findViewById(paramInt);
    }
    Window localWindow = this.jdField_a_of_type_Bkho.getWindow();
    if (localWindow != null) {
      return localWindow.findViewById(paramInt);
    }
    return null;
  }
  
  public bkho getActionSheet()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      return this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.getActionSheet();
    }
    return this.jdField_a_of_type_Bkho;
  }
  
  public int getActionSheetPanelViewHeight()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      return this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.getActionSheetPanelViewHeight();
    }
    return 0;
  }
  
  public int getIconMarginLeftRight()
  {
    return this.d;
  }
  
  public int getIconWidth()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      return this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.getIconWidth();
    }
    return this.jdField_c_of_type_Int;
  }
  
  public String getOpenSource()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      return this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.getOpenSource();
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public Window getWindow()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      return this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.getWindow();
    }
    return this.jdField_a_of_type_Bkho.getWindow();
  }
  
  public void hideTitle()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.hideTitle();
    }
    do
    {
      return;
      this.jdField_b_of_type_Boolean = false;
    } while ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 8));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public boolean isShowing()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      return this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.isShowing();
    }
    return this.jdField_a_of_type_Bkho.isShowing();
  }
  
  public void onConfigurationChanged()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.onConfigurationChanged();
    }
    int i;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_AndroidContentContext == null);
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels - this.h;
    } while ((this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView == null) || (this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView == null));
    if (i < this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
    }
    while (i < this.jdField_b_of_type_Int)
    {
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
      return;
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
    }
    this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
  }
  
  public void refresh()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.refresh();
    }
  }
  
  public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem> paramList1, List<ShareActionSheetBuilder.ActionSheetItem> paramList2) {}
  
  public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem>[] paramArrayOfList)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(paramArrayOfList);
      return;
    }
    this.jdField_a_of_type_ArrayOfJavaUtilList = paramArrayOfList;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void setActionSheetTitle(CharSequence paramCharSequence)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetTitle(paramCharSequence);
    }
    do
    {
      return;
      this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    } while (this.jdField_a_of_type_AndroidWidgetTextView == null);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
  }
  
  public void setAdvBgColor(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setAdvBgColor(paramInt);
      return;
    }
    this.jdField_a_of_type_Bgsb.a(paramInt);
  }
  
  public void setAdvView(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setAdvView(paramView, paramLayoutParams);
      return;
    }
    this.jdField_a_of_type_Bgsb.a(paramView, paramLayoutParams);
  }
  
  public void setBottomBarInterface(bifr parambifr)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setBottomBarInterface(parambifr);
    }
  }
  
  public void setCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setCancelListener(paramOnCancelListener);
      return;
    }
    this.jdField_a_of_type_Bkho.setOnCancelListener(paramOnCancelListener);
  }
  
  public void setEnableNotTriggerVirtualNavigationBar(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setEnableNotTriggerVirtualNavigationBar(paramBoolean);
      return;
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setExtras(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setExtras(paramBundle);
    }
  }
  
  public void setIconMarginLeftRight(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIconMarginLeftRight(paramInt);
      return;
    }
    this.d = paramInt;
  }
  
  public void setIntentForStartForwardRecentActivity(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(paramIntent);
    }
  }
  
  public void setItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListener(paramOnItemClickListener);
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
        this.jdField_a_of_type_Boolean = true;
      } while (paramOnItemClickListener != null);
      if (this.jdField_a_of_type_AndroidWidgetGridView != null) {
        this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(null);
      }
    } while (this.jdField_b_of_type_AndroidWidgetGridView == null);
    this.jdField_b_of_type_AndroidWidgetGridView.setOnItemClickListener(null);
  }
  
  public void setItemClickListenerV2(ShareActionSheet.OnItemClickListener paramOnItemClickListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(paramOnItemClickListener);
    }
  }
  
  public void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setOnDismissListener(paramOnDismissListener);
    }
    while (this.jdField_a_of_type_Bkho == null) {
      return;
    }
    this.jdField_a_of_type_Bkho.setOnDismissListener(paramOnDismissListener);
  }
  
  public void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setOnShowListener(paramOnShowListener);
      return;
    }
    this.jdField_a_of_type_Bkho.setOnShowListener(paramOnShowListener);
  }
  
  public void setOpenSource(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setOpenSource(paramString);
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setRowMarginLeftRight(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowMarginLeftRight(paramInt);
      return;
    }
    this.h = paramInt;
  }
  
  public void setRowVisibility(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void setTitlePadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void show()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
    }
    do
    {
      for (;;)
      {
        return;
        if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_Boolean)) {
          this.jdField_a_of_type_AndroidViewView = a();
        }
        this.jdField_a_of_type_Bkho.a(this.jdField_a_of_type_AndroidViewView, null);
        try
        {
          if (!isShowing())
          {
            if (this.jdField_c_of_type_Boolean) {
              aaiz.b(getWindow());
            }
            this.jdField_a_of_type_Bkho.show();
            if (this.jdField_c_of_type_Boolean)
            {
              aaiz.a(getWindow());
              aaiz.c(getWindow());
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
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.updateUI();
    }
    while (!this.jdField_a_of_type_Bkho.isShowing()) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView = a();
    this.jdField_a_of_type_Bkho.a(this.jdField_a_of_type_AndroidViewView, null);
  }
  
  public void updateUIIfShowing()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.updateUIIfShowing();
    }
    while (!this.jdField_a_of_type_Bkho.isShowing()) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView = a();
    this.jdField_a_of_type_Bkho.a(this.jdField_a_of_type_AndroidViewView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShareActionSheetBuilder
 * JD-Core Version:    0.7.0.1
 */