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
  private ShareActionSheet A;
  protected Context a;
  protected AdapterView.OnItemClickListener b;
  protected ActionSheet c;
  protected View d;
  public ElasticHorScrView e;
  public ElasticHorScrView f;
  protected TextView g;
  public LinearLayout h;
  public TextView i;
  protected int j;
  protected int k;
  protected CharSequence l;
  protected List<ShareActionSheetBuilder.ActionSheetItem>[] m;
  protected boolean n = false;
  protected int o;
  protected int p;
  protected int q;
  protected int r;
  protected int s;
  protected int t;
  protected ShareActionSheetBuilder.AdViewManager u;
  protected boolean v = true;
  protected GridView w;
  protected GridView x;
  private boolean y;
  private String z;
  
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
      this.A = ShareActionSheetFactory.create(localParam);
      return;
    }
    this.a = paramContext;
    if (paramBoolean) {
      this.c = ((ActionSheet)ActionSheetHelper.c(this.a, null));
    } else {
      this.c = ((ActionSheet)ActionSheetHelper.b(this.a, null));
    }
    paramContext = this.a.getResources();
    this.o = paramContext.getDimensionPixelSize(2131297127);
    this.q = this.o;
    this.r = paramContext.getDimensionPixelOffset(2131297129);
    this.s = paramContext.getDimensionPixelOffset(2131297130);
    this.u = new ShareActionSheetBuilder.AdViewManager();
    paramInt = paramContext.getDisplayMetrics().widthPixels;
    int i1 = paramContext.getDisplayMetrics().heightPixels;
    if (paramInt > i1) {
      paramInt = i1;
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
    int i1 = 1;
    while (i1 <= paramString.length())
    {
      if (paramTextPaint.measureText(paramString.substring(0, i1)) > paramFloat) {
        return i1;
      }
      i1 += 1;
    }
    return paramString.length();
  }
  
  protected static String a(TextPaint paramTextPaint, float paramFloat, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    int i1 = a(paramTextPaint, paramString, paramFloat);
    String str;
    if (LocaleManager.a())
    {
      paramInt = Math.min(paramInt, i1);
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
    if (paramString.length() <= i1) {
      return paramString;
    }
    paramTextPaint = new StringBuilder();
    paramString = paramString.split(" ");
    int i2 = paramString.length;
    paramInt = 0;
    while (paramInt < i2)
    {
      str = paramString[paramInt];
      int i3 = paramTextPaint.toString().length() + str.length();
      if (i3 > i1 * 2) {
        break;
      }
      if ((!paramTextPaint.toString().contains("\n")) && (i3 > i1)) {
        paramTextPaint.append("\n");
      }
      paramTextPaint.append(str);
      paramTextPaint.append(" ");
      paramInt += 1;
    }
    paramString = paramTextPaint.toString().trim();
    paramTextPaint = paramString;
    if (paramString.length() > i1 * 2)
    {
      paramTextPaint = new StringBuilder();
      paramTextPaint.append(paramString.substring(0, i1));
      paramTextPaint.append("..");
      paramTextPaint = paramTextPaint.toString();
    }
    return paramTextPaint;
  }
  
  private void a(GridView paramGridView, List<ShareActionSheetBuilder.ActionSheetItem> paramList, StaticLayout paramStaticLayout, int paramInt)
  {
    paramGridView.setOverScrollMode(2);
    Object localObject = paramList.iterator();
    int i1 = 0;
    while (((Iterator)localObject).hasNext()) {
      if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject).next()).visibility == 0) {
        i1 += 1;
      }
    }
    int i2 = this.p + getIconWidth() + this.p;
    paramGridView.setColumnWidth(i2);
    paramGridView.setNumColumns(i1);
    localObject = paramGridView.getLayoutParams();
    paramGridView.setPadding(this.t, paramGridView.getPaddingTop(), this.t, paramGridView.getPaddingBottom());
    int i3 = this.t;
    ((ViewGroup.LayoutParams)localObject).width = (i1 * i2 + i3 + i3);
    ((ViewGroup.LayoutParams)localObject).height = (this.o + this.r + paramStaticLayout.getHeight() + paramInt);
    paramGridView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramGridView.setAdapter(a(this.a, paramList));
    paramGridView.setSelector(new ColorDrawable(0));
    paramGridView.setOnItemClickListener(this.b);
  }
  
  private void b(View paramView, List<ShareActionSheetBuilder.ActionSheetItem> paramList, StaticLayout paramStaticLayout, int paramInt)
  {
    this.x = ((GridView)paramView.findViewById(2131434387));
    this.x.setSmoothScrollbarEnabled(false);
    a(this.x, paramList, paramStaticLayout, paramInt);
    this.k = this.x.getLayoutParams().width;
  }
  
  @TargetApi(9)
  protected View a()
  {
    View localView = View.inflate(this.a, c(), null);
    this.u.a((RelativeLayout)localView.findViewById(2131427848));
    this.h = ((LinearLayout)localView.findViewById(2131427556));
    this.g = ((TextView)localView.findViewById(2131427554));
    Object localObject1;
    if (this.v)
    {
      this.g.setVisibility(0);
      localObject1 = this.l;
      if (localObject1 != null) {
        this.g.setText((CharSequence)localObject1);
      }
    }
    else
    {
      hideTitle();
    }
    this.e = ((ElasticHorScrView)localView.findViewById(2131445372));
    this.f = ((ElasticHorScrView)localView.findViewById(2131445373));
    Object localObject2 = d();
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
    ((TextPaint)localObject3).setTextSize(this.a.getResources().getDimensionPixelSize(2131299838));
    StaticLayout localStaticLayout1 = new StaticLayout(a((TextPaint)localObject3, this.q, a((List)localObject1), 5), (TextPaint)localObject3, this.q, Layout.Alignment.ALIGN_CENTER, 1.0F, this.s, true);
    StaticLayout localStaticLayout2 = new StaticLayout(a((TextPaint)localObject3, this.q, a((List)localObject2), 5), (TextPaint)localObject3, this.q, Layout.Alignment.ALIGN_CENTER, 1.0F, this.s, true);
    localObject3 = localStaticLayout2;
    if (localStaticLayout1.getHeight() >= localStaticLayout2.getHeight()) {
      localObject3 = localStaticLayout1;
    }
    int i1 = this.a.getResources().getDimensionPixelOffset(2131297126);
    if (bool1) {
      a(localView, (List)localObject1, (StaticLayout)localObject3, i1);
    }
    if (bool2) {
      b(localView, (List)localObject2, (StaticLayout)localObject3, i1);
    }
    this.i = ((TextView)localView.findViewById(2131427546));
    this.i.setText(2131887648);
    this.i.setOnClickListener(new ShareActionSheetBuilder.1(this));
    if (!bool1) {
      this.e.setVisibility(8);
    }
    if (!bool2) {
      this.f.setVisibility(8);
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
    int i1 = 0;
    while (i1 < paramList.size())
    {
      String str = ((ShareActionSheetBuilder.ActionSheetItem)paramList.get(i1)).label;
      Object localObject2 = localObject1;
      if (str.length() > ((String)localObject1).length()) {
        localObject2 = str;
      }
      i1 += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  protected void a(View paramView, List<ShareActionSheetBuilder.ActionSheetItem> paramList, StaticLayout paramStaticLayout, int paramInt)
  {
    this.w = ((GridView)paramView.findViewById(2131434386));
    a(this.w, paramList, paramStaticLayout, paramInt);
    this.j = this.w.getLayoutParams().width;
  }
  
  protected void a(ElasticHorScrView paramElasticHorScrView, int paramInt)
  {
    int i1 = paramElasticHorScrView.getWidth();
    boolean bool = true;
    if (i1 < paramInt) {
      paramElasticHorScrView.setMove(true);
    } else {
      paramElasticHorScrView.setMove(false);
    }
    if (QLog.isColorLevel())
    {
      paramElasticHorScrView = new StringBuilder();
      paramElasticHorScrView.append("setMove, scrollViewLength = ");
      paramElasticHorScrView.append(i1);
      paramElasticHorScrView.append("; gridViewLength = ");
      paramElasticHorScrView.append(paramInt);
      paramElasticHorScrView.append("; move = ");
      if (i1 >= paramInt) {
        bool = false;
      }
      paramElasticHorScrView.append(bool);
      QLog.d("ShareActionSheetBuilder", 2, paramElasticHorScrView.toString());
    }
  }
  
  protected int c()
  {
    return 2131624528;
  }
  
  protected List<ShareActionSheetBuilder.ActionSheetItem>[] d()
  {
    List[] arrayOfList = this.m;
    if (arrayOfList != null) {
      return arrayOfList;
    }
    return (List[])new ArrayList[0];
  }
  
  public void dismiss()
  {
    ShareActionSheet localShareActionSheet = this.A;
    if (localShareActionSheet != null)
    {
      localShareActionSheet.dismiss();
      return;
    }
    setOpenSource(null);
    if (isShowing()) {
      try
      {
        this.c.dismiss();
        this.d = null;
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
    ShareActionSheet localShareActionSheet = this.A;
    if (localShareActionSheet != null) {
      localShareActionSheet.dismissImmediately();
    }
  }
  
  public View findViewById(int paramInt)
  {
    Object localObject = this.A;
    if (localObject != null) {
      return ((ShareActionSheet)localObject).findViewById(paramInt);
    }
    localObject = this.c.getWindow();
    if (localObject != null) {
      return ((Window)localObject).findViewById(paramInt);
    }
    return null;
  }
  
  public ActionSheet getActionSheet()
  {
    ShareActionSheet localShareActionSheet = this.A;
    if (localShareActionSheet != null) {
      return localShareActionSheet.getActionSheet();
    }
    return this.c;
  }
  
  public int getActionSheetPanelViewHeight()
  {
    ShareActionSheet localShareActionSheet = this.A;
    if (localShareActionSheet != null) {
      return localShareActionSheet.getActionSheetPanelViewHeight();
    }
    return 0;
  }
  
  public Bundle getExtras()
  {
    ShareActionSheet localShareActionSheet = this.A;
    if (localShareActionSheet != null) {
      return localShareActionSheet.getExtras();
    }
    return null;
  }
  
  public int getIconMarginLeftRight()
  {
    return this.p;
  }
  
  public int getIconWidth()
  {
    ShareActionSheet localShareActionSheet = this.A;
    if (localShareActionSheet != null) {
      return localShareActionSheet.getIconWidth();
    }
    return this.o;
  }
  
  public String getOpenSource()
  {
    ShareActionSheet localShareActionSheet = this.A;
    if (localShareActionSheet != null) {
      return localShareActionSheet.getOpenSource();
    }
    return this.z;
  }
  
  public Window getWindow()
  {
    ShareActionSheet localShareActionSheet = this.A;
    if (localShareActionSheet != null) {
      return localShareActionSheet.getWindow();
    }
    return this.c.getWindow();
  }
  
  public void hideTitle()
  {
    Object localObject = this.A;
    if (localObject != null)
    {
      ((ShareActionSheet)localObject).hideTitle();
      return;
    }
    this.v = false;
    localObject = this.g;
    if ((localObject != null) && (((TextView)localObject).getVisibility() != 8)) {
      this.g.setVisibility(8);
    }
  }
  
  public boolean isShowing()
  {
    ShareActionSheet localShareActionSheet = this.A;
    if (localShareActionSheet != null) {
      return localShareActionSheet.isShowing();
    }
    return this.c.isShowing();
  }
  
  public void onConfigurationChanged()
  {
    Object localObject = this.A;
    if (localObject != null)
    {
      ((ShareActionSheet)localObject).onConfigurationChanged();
      return;
    }
    localObject = this.a;
    if (localObject == null) {
      return;
    }
    int i1 = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - this.t;
    localObject = this.e;
    if ((localObject != null) && (this.f != null))
    {
      if (i1 < this.j) {
        ((ElasticHorScrView)localObject).setMove(true);
      } else {
        ((ElasticHorScrView)localObject).setMove(false);
      }
      if (i1 < this.k)
      {
        this.f.setMove(true);
        return;
      }
      this.f.setMove(false);
    }
  }
  
  public void refresh()
  {
    ShareActionSheet localShareActionSheet = this.A;
    if (localShareActionSheet != null) {
      localShareActionSheet.refresh();
    }
  }
  
  public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem> paramList1, List<ShareActionSheetBuilder.ActionSheetItem> paramList2) {}
  
  public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem>[] paramArrayOfList)
  {
    ShareActionSheet localShareActionSheet = this.A;
    if (localShareActionSheet != null)
    {
      localShareActionSheet.setActionSheetItems(paramArrayOfList);
      return;
    }
    this.m = paramArrayOfList;
    this.n = true;
  }
  
  public void setActionSheetTitle(CharSequence paramCharSequence)
  {
    ShareActionSheet localShareActionSheet = this.A;
    if (localShareActionSheet != null)
    {
      localShareActionSheet.setActionSheetTitle(paramCharSequence);
      return;
    }
    this.l = paramCharSequence;
    paramCharSequence = this.g;
    if (paramCharSequence != null) {
      paramCharSequence.setText(this.l);
    }
  }
  
  public void setAdvBgColor(int paramInt)
  {
    ShareActionSheet localShareActionSheet = this.A;
    if (localShareActionSheet != null)
    {
      localShareActionSheet.setAdvBgColor(paramInt);
      return;
    }
    this.u.a(paramInt);
  }
  
  public void setAdvView(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    ShareActionSheet localShareActionSheet = this.A;
    if (localShareActionSheet != null)
    {
      localShareActionSheet.setAdvView(paramView, paramLayoutParams);
      return;
    }
    this.u.a(paramView, paramLayoutParams);
  }
  
  public void setBottomBarInterface(ShareActionSheet.IShareActionSheetV2BottomBar paramIShareActionSheetV2BottomBar)
  {
    ShareActionSheet localShareActionSheet = this.A;
    if (localShareActionSheet != null) {
      localShareActionSheet.setBottomBarInterface(paramIShareActionSheetV2BottomBar);
    }
  }
  
  public void setCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    ShareActionSheet localShareActionSheet = this.A;
    if (localShareActionSheet != null)
    {
      localShareActionSheet.setCancelListener(paramOnCancelListener);
      return;
    }
    this.c.setOnCancelListener(paramOnCancelListener);
  }
  
  public void setEnableNotTriggerVirtualNavigationBar(boolean paramBoolean)
  {
    ShareActionSheet localShareActionSheet = this.A;
    if (localShareActionSheet != null)
    {
      localShareActionSheet.setEnableNotTriggerVirtualNavigationBar(paramBoolean);
      return;
    }
    this.y = paramBoolean;
  }
  
  public void setExtras(Bundle paramBundle)
  {
    ShareActionSheet localShareActionSheet = this.A;
    if (localShareActionSheet != null) {
      localShareActionSheet.setExtras(paramBundle);
    }
  }
  
  public void setIconMarginLeftRight(int paramInt)
  {
    ShareActionSheet localShareActionSheet = this.A;
    if (localShareActionSheet != null)
    {
      localShareActionSheet.setIconMarginLeftRight(paramInt);
      return;
    }
    this.p = paramInt;
  }
  
  public void setIntentForStartForwardRecentActivity(Intent paramIntent)
  {
    ShareActionSheet localShareActionSheet = this.A;
    if (localShareActionSheet != null) {
      localShareActionSheet.setIntentForStartForwardRecentActivity(paramIntent);
    }
  }
  
  public void setItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    ShareActionSheet localShareActionSheet = this.A;
    if (localShareActionSheet != null)
    {
      localShareActionSheet.setItemClickListener(paramOnItemClickListener);
      return;
    }
    this.b = paramOnItemClickListener;
    this.n = true;
    if (paramOnItemClickListener == null)
    {
      paramOnItemClickListener = this.w;
      if (paramOnItemClickListener != null) {
        paramOnItemClickListener.setOnItemClickListener(null);
      }
      paramOnItemClickListener = this.x;
      if (paramOnItemClickListener != null) {
        paramOnItemClickListener.setOnItemClickListener(null);
      }
    }
  }
  
  public void setItemClickListenerV2(ShareActionSheet.OnItemClickListener paramOnItemClickListener)
  {
    ShareActionSheet localShareActionSheet = this.A;
    if (localShareActionSheet != null) {
      localShareActionSheet.setItemClickListenerV2(paramOnItemClickListener);
    }
  }
  
  public void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Object localObject = this.A;
    if (localObject != null)
    {
      ((ShareActionSheet)localObject).setOnDismissListener(paramOnDismissListener);
      return;
    }
    localObject = this.c;
    if (localObject != null) {
      ((ActionSheet)localObject).setOnDismissListener(paramOnDismissListener);
    }
  }
  
  public void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener)
  {
    ShareActionSheet localShareActionSheet = this.A;
    if (localShareActionSheet != null)
    {
      localShareActionSheet.setOnShowListener(paramOnShowListener);
      return;
    }
    this.c.setOnShowListener(paramOnShowListener);
  }
  
  public void setOpenSource(String paramString)
  {
    ShareActionSheet localShareActionSheet = this.A;
    if (localShareActionSheet != null)
    {
      localShareActionSheet.setOpenSource(paramString);
      return;
    }
    this.z = paramString;
  }
  
  public void setRowMarginLeftRight(int paramInt)
  {
    ShareActionSheet localShareActionSheet = this.A;
    if (localShareActionSheet != null)
    {
      localShareActionSheet.setRowMarginLeftRight(paramInt);
      return;
    }
    this.t = paramInt;
  }
  
  public void setRowVisibility(int paramInt1, int paramInt2, int paramInt3)
  {
    ShareActionSheet localShareActionSheet = this.A;
    if (localShareActionSheet != null) {
      localShareActionSheet.setRowVisibility(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void setTitlePadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    TextView localTextView = this.g;
    if (localTextView != null) {
      localTextView.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void show()
  {
    ShareActionSheet localShareActionSheet = this.A;
    if (localShareActionSheet != null)
    {
      localShareActionSheet.show();
      return;
    }
    if ((this.d == null) || (this.n)) {
      this.d = a();
    }
    this.c.setActionContentView(this.d, null);
    try
    {
      if (!isShowing())
      {
        if (this.y) {
          NavigationBarUtil.b(getWindow());
        }
        this.c.show();
        if (this.y)
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
    ShareActionSheet localShareActionSheet = this.A;
    if (localShareActionSheet != null)
    {
      localShareActionSheet.updateUI();
      return;
    }
    if (this.c.isShowing())
    {
      this.d = a();
      this.c.setActionContentView(this.d, null);
    }
  }
  
  public void updateUIIfShowing()
  {
    ShareActionSheet localShareActionSheet = this.A;
    if (localShareActionSheet != null)
    {
      localShareActionSheet.updateUIIfShowing();
      return;
    }
    if (this.c.isShowing())
    {
      this.d = a();
      this.c.setActionContentView(this.d, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShareActionSheetBuilder
 * JD-Core Version:    0.7.0.1
 */