package com.tencent.mobileqq.leba.controller.table;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.leba.LebaConstant;
import com.tencent.mobileqq.leba.business.ILebaDiyIconPart;
import com.tencent.mobileqq.leba.core.LebaUtil;
import com.tencent.mobileqq.leba.entity.LebaExposureInfo;
import com.tencent.mobileqq.leba.entity.LebaItemListener;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.redtouch.LebaRedTouchBase;
import com.tencent.mobileqq.leba.report.EXReportController;
import com.tencent.mobileqq.leba.report.LebaReportUtils;
import com.tencent.mobileqq.leba.widget.LebaTableLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class LebaTableLogic
{
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  protected ILebaDiyIconPart a;
  public LebaItemListener a;
  public LebaRedTouchBase a;
  public LebaTableLayout a;
  private List<LebaViewItem> jdField_a_of_type_JavaUtilList;
  public AppRuntime a;
  private int b;
  private int c = 3;
  private int d = 1;
  
  public LebaTableLogic(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130845505);
    this.jdField_a_of_type_Int = paramContext.getResources().getDisplayMetrics().densityDpi;
    this.jdField_b_of_type_Int = ViewUtils.b(16.0F);
  }
  
  private int a(int paramInt)
  {
    if (this.d == 1) {
      return b(paramInt);
    }
    return 15;
  }
  
  private int a(LebaTableLayout paramLebaTableLayout)
  {
    return paramLebaTableLayout.getChildCount();
  }
  
  private View a(LebaTableLayout paramLebaTableLayout, int paramInt)
  {
    try
    {
      paramLebaTableLayout = paramLebaTableLayout.getChildAt(paramInt);
      return paramLebaTableLayout;
    }
    catch (Exception paramLebaTableLayout)
    {
      QLog.i("Q.lebatab.LebaTableLogic", 1, String.format("findViewByIndex,index = ", new Object[] { Integer.valueOf(paramInt) }), paramLebaTableLayout);
    }
    return null;
  }
  
  private void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, String paramString, View paramView, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    if (paramView == null)
    {
      paramStringBuilder1.append(",headView == null");
      return;
    }
    paramView = paramView.findViewById(2131375397);
    if (paramView == null)
    {
      paramStringBuilder1.append(",qZone == null");
      return;
    }
    int i = paramView.getTop();
    int j = paramView.getHeight() + i;
    paramStringBuilder1.append(",qZoneTop = ");
    paramStringBuilder1.append(i);
    paramStringBuilder1.append(",qZoneBottom = ");
    paramStringBuilder1.append(j);
    float f = i;
    if ((paramFloat1 >= f) || (f >= paramFloat2))
    {
      f = j;
      if ((paramFloat1 >= f) || (f >= paramFloat2)) {}
    }
    else
    {
      paramStringBuilder2.append(10000L);
      paramStringBuilder2.append("_");
      paramStringBuilder2.append(0);
      paramStringBuilder2.append("_");
      paramStringBuilder2.append(paramInt1);
      paramStringBuilder2.append("_");
      paramStringBuilder2.append(0);
      paramStringBuilder2.append("_");
      paramStringBuilder2.append(LebaConstant.a(paramInt2));
      paramStringBuilder2.append("_");
      paramStringBuilder2.append(paramString);
      paramStringBuilder2.append(";");
    }
  }
  
  private void a(float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean, String paramString, View paramView, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    if (paramView == null)
    {
      paramStringBuilder1.append(",headView == null");
      return;
    }
    paramView = paramView.findViewById(2131374379);
    if (paramView == null)
    {
      paramStringBuilder1.append(",qcircle == null");
      return;
    }
    if (!paramBoolean)
    {
      paramStringBuilder1.append(",no ShowQQCirle");
      return;
    }
    int i = paramView.getTop();
    int j = paramView.getHeight() + i;
    paramStringBuilder1.append(",qCircleTop = ");
    paramStringBuilder1.append(i);
    paramStringBuilder1.append(",qCircleBottom = ");
    paramStringBuilder1.append(j);
    float f = i;
    if ((paramFloat1 >= f) || (f >= paramFloat2))
    {
      f = j;
      if ((paramFloat1 >= f) || (f >= paramFloat2)) {}
    }
    else
    {
      paramStringBuilder2.append(10004L);
      paramStringBuilder2.append("_");
      paramStringBuilder2.append(0);
      paramStringBuilder2.append("_");
      paramStringBuilder2.append(paramInt);
      paramStringBuilder2.append("_");
      paramStringBuilder2.append(0);
      paramStringBuilder2.append("_");
      paramStringBuilder2.append(0);
      paramStringBuilder2.append("_");
      paramStringBuilder2.append(paramString);
      paramStringBuilder2.append(";");
    }
  }
  
  private void a(float paramFloat1, float paramFloat2, String paramString, View paramView, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    paramView = paramView.findViewById(2131378254);
    if (paramView == null)
    {
      paramStringBuilder1.append(",tableRoot == null");
      return;
    }
    int j = paramView.getTop();
    int k = this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.getChildCount();
    paramStringBuilder1.append(", r_top = ");
    paramStringBuilder1.append(j);
    paramStringBuilder1.append(", r_count = ");
    paramStringBuilder1.append(k);
    int i = 0;
    while (i < k)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.getChildAt(i);
      if (paramView == null)
      {
        paramStringBuilder1.append("itemView == null ");
      }
      else
      {
        int m = paramView.getTop() + j;
        int n = paramView.getHeight() + m;
        float f = m;
        if ((paramFloat1 >= f) || (f >= paramFloat2))
        {
          f = n;
          if ((paramFloat1 >= f) || (f >= paramFloat2)) {}
        }
        else
        {
          bool = true;
          break label175;
        }
        boolean bool = false;
        label175:
        paramStringBuilder1.append(";");
        paramStringBuilder1.append(i);
        paramStringBuilder1.append("v_top=");
        paramStringBuilder1.append(m);
        paramStringBuilder1.append(",v_bottom=");
        paramStringBuilder1.append(n);
        paramStringBuilder1.append(bool);
        if (bool) {
          a(paramString, paramStringBuilder1, paramStringBuilder2, paramView);
        }
      }
      i += 1;
    }
  }
  
  private void a(int paramInt, LebaTableLayout paramLebaTableLayout)
  {
    try
    {
      Object localObject2 = new LebaTableViewHolder(paramLebaTableLayout.getContext(), this.jdField_a_of_type_AndroidViewLayoutInflater, this.d, this.jdField_a_of_type_ComTencentMobileqqLebaBusinessILebaDiyIconPart);
      localObject1 = ((LebaTableViewHolder)localObject2).jdField_a_of_type_AndroidViewView;
      ((View)localObject1).setTag(localObject2);
      ((View)localObject1).setId(paramInt);
      localObject2 = ((LebaTableViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetRoundRelativeLayout;
      if (localObject2 != null)
      {
        ((RoundRelativeLayout)localObject2).jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        ((RoundRelativeLayout)localObject2).jdField_b_of_type_Int = a(paramInt);
      }
      else
      {
        QLog.i("Q.lebatab.LebaTableLogic", 1, "rootLayout != null");
      }
      paramLebaTableLayout.addView((View)localObject1);
      return;
    }
    catch (Exception paramLebaTableLayout)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("addTableItem,index = ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.i("Q.lebatab.LebaTableLogic", 1, ((StringBuilder)localObject1).toString(), paramLebaTableLayout);
    }
  }
  
  private void a(LebaTableLayout paramLebaTableLayout)
  {
    int i = a(paramLebaTableLayout);
    int j = this.jdField_a_of_type_JavaUtilList.size();
    if ((i != j) || (this.d != this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.jdField_a_of_type_Int))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      c();
      b();
      this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.removeAllViews();
      localStringBuilder.append("removeAllViews");
      i = 0;
      while (i < j)
      {
        a(i, paramLebaTableLayout);
        localStringBuilder.append(" ");
        localStringBuilder.append(i);
        i += 1;
      }
      QLog.i("Q.lebatab.LebaTableLogic", 1, localStringBuilder.toString());
    }
  }
  
  private void a(String paramString, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, View paramView)
  {
    LebaViewItem localLebaViewItem = a(paramView);
    if ((localLebaViewItem != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo != null))
    {
      paramStringBuilder1.append(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId);
      long l = localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId;
      int k = paramView.getId();
      paramStringBuilder1 = this.jdField_a_of_type_ComTencentMobileqqLebaRedtouchLebaRedTouchBase;
      if (paramStringBuilder1 != null)
      {
        paramStringBuilder1 = (LebaExposureInfo)paramStringBuilder1.a().get(Long.valueOf(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId));
        if (paramStringBuilder1 != null)
        {
          i = paramStringBuilder1.jdField_a_of_type_Int;
          j = paramStringBuilder1.jdField_b_of_type_Int;
          break label112;
        }
      }
      int j = 0;
      int i = 0;
      label112:
      paramStringBuilder2.append(l);
      paramStringBuilder2.append("_");
      paramStringBuilder2.append(k + 1);
      paramStringBuilder2.append("_");
      paramStringBuilder2.append(i);
      paramStringBuilder2.append("_");
      paramStringBuilder2.append(j);
      paramStringBuilder2.append("_");
      paramStringBuilder2.append(0);
      paramStringBuilder2.append("_");
      paramStringBuilder2.append(paramString);
      paramStringBuilder2.append(";");
      return;
    }
    paramStringBuilder1.append(" item == null ||  item.info == null ");
  }
  
  private int b(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    int i = 0;
    int j = 0;
    if (localList != null)
    {
      if (localList.isEmpty()) {
        return 0;
      }
      int m = this.jdField_a_of_type_JavaUtilList.size();
      if (paramInt == 0) {
        j = 1;
      }
      int k = m - 1;
      i = j;
      if (paramInt == k) {
        i = j | 0x4;
      }
      j = this.c;
      if (j <= m) {
        k = j - 1;
      }
      j = i;
      if (paramInt == k) {
        j = i | 0x2;
      }
      i = m % this.c;
      k = i;
      if (i == 0) {
        k = 3;
      }
      i = j;
      if (paramInt == m - k) {
        i = j | 0x8;
      }
    }
    return i;
  }
  
  private void b(LebaTableLayout paramLebaTableLayout)
  {
    Object localObject1 = a();
    boolean bool1;
    if ((!"1000".equals(localObject1)) && (!"2105".equals(localObject1)) && (!"1103".equals(localObject1)) && (!"2101".equals(localObject1))) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    boolean bool3 = ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_MqqAppAppRuntime, false, null);
    QLog.i("Q.lebatab.LebaTableLogic", 1, String.format("bindDataToTable themeId %s isNeedWaterMark %b isNight = %b", new Object[] { localObject1, Boolean.valueOf(bool1), Boolean.valueOf(bool3) }));
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject1 = (LebaViewItem)this.jdField_a_of_type_JavaUtilList.get(i);
      Object localObject2 = a(paramLebaTableLayout, i);
      if (localObject2 == null)
      {
        QLog.i("Q.lebatab.LebaTableLogic", 1, String.format("itemView == null %d", new Object[] { Integer.valueOf(i) }));
      }
      else if (((View)localObject2).getTag() == null)
      {
        QLog.i("Q.lebatab.LebaTableLogic", 1, String.format("itemView.getTag() == null %d", new Object[] { Integer.valueOf(i) }));
      }
      else
      {
        localObject2 = (LebaTableViewHolder)((View)localObject2).getTag();
        LebaTableViewHolder.BindDataParam localBindDataParam = new LebaTableViewHolder.BindDataParam();
        localBindDataParam.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem = ((LebaViewItem)localObject1);
        localBindDataParam.jdField_a_of_type_MqqAppAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
        localBindDataParam.jdField_a_of_type_AndroidContentContext = paramLebaTableLayout.getContext();
        localBindDataParam.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localBindDataParam.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        localBindDataParam.jdField_a_of_type_AndroidViewView$OnClickListener = new LebaTableLogic.ItemClickListener(this);
        localBindDataParam.jdField_a_of_type_ComTencentMobileqqLebaRedtouchLebaRedTouchBase = this.jdField_a_of_type_ComTencentMobileqqLebaRedtouchLebaRedTouchBase;
        localBindDataParam.jdField_a_of_type_Boolean = bool3;
        localBindDataParam.jdField_b_of_type_Int = i;
        boolean bool2;
        if ((bool1) && (this.d == 1)) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        localBindDataParam.jdField_b_of_type_Boolean = bool2;
        ((LebaTableViewHolder)localObject2).a(localBindDataParam);
      }
      i += 1;
    }
  }
  
  private void b(List<LebaViewItem> paramList)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    } else {
      ((List)localObject).clear();
    }
    if (paramList != null)
    {
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        LebaViewItem localLebaViewItem = (LebaViewItem)((Iterator)localObject).next();
        if ((localLebaViewItem != null) && (TextUtils.isEmpty(localLebaViewItem.jdField_a_of_type_JavaLangString))) {
          this.jdField_a_of_type_JavaUtilList.add(localLebaViewItem);
        }
      }
    }
    LebaUtil.b(paramList, b());
    if ((!this.jdField_a_of_type_JavaUtilList.isEmpty()) && (this.d == 1))
    {
      int j = this.jdField_a_of_type_JavaUtilList.size();
      int i = this.c;
      j %= i;
      if ((j > 0) && (j < i))
      {
        i = 0;
        while (i < this.c - j)
        {
          this.jdField_a_of_type_JavaUtilList.add(new LebaViewItem());
          i += 1;
        }
      }
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout == null)
    {
      QLog.i("Q.lebatab.LebaTableLogic", 1, "notifyDataSetChanged mRootLayout == null");
      return;
    }
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (!localList.isEmpty()))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout);
      b(this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout);
      return;
    }
    a();
  }
  
  protected LebaViewItem a(View paramView)
  {
    int i = paramView.getId();
    if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilList.size())) {
      return (LebaViewItem)this.jdField_a_of_type_JavaUtilList.get(i);
    }
    return null;
  }
  
  public String a()
  {
    return ThemeUtil.getCurrentThemeId();
  }
  
  public List<LebaViewItem> a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      LebaViewItem localLebaViewItem = (LebaViewItem)localIterator.next();
      if ((localLebaViewItem != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo != null)) {
        localArrayList.add(localLebaViewItem);
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    LebaTableLayout localLebaTableLayout = this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout;
    if (localLebaTableLayout != null)
    {
      localLebaTableLayout.setPadding(0, 0, 0, 0);
      b();
      this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.removeAllViews();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, View paramView1, View paramView2, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout != null) && (paramView1 != null))
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      String str = a();
      paramFloat2 += paramView1.getHeight() - paramView1.getPaddingBottom() - paramView1.getPaddingTop();
      localStringBuilder1.append("reportExposure, e_top = ");
      localStringBuilder1.append(paramFloat1);
      localStringBuilder1.append(", e_bottom = ");
      localStringBuilder1.append(paramFloat2);
      a(paramFloat1, paramFloat2, paramInt1, paramInt2, str, paramView2, localStringBuilder1, localStringBuilder2);
      a(paramFloat1, paramFloat2, paramInt3, paramBoolean, str, paramView2, localStringBuilder1, localStringBuilder2);
      a(paramFloat1, paramFloat2, str, paramView2, localStringBuilder1, localStringBuilder2);
      paramView2 = LebaReportUtils.a("plugin_exp");
      paramView2.jdField_a_of_type_JavaLangString = localStringBuilder2.toString();
      if (this.d == 1) {
        paramView1 = "2";
      } else {
        paramView1 = "1";
      }
      paramView2.h = paramView1;
      EXReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, paramView2);
      localStringBuilder1.append(localStringBuilder2);
      QLog.i("Q.lebatab.LebaTableLogic", 1, localStringBuilder1.toString());
      return;
    }
    QLog.i("Q.lebatab.LebaTableLogic", 1, "statExposure mRootLayout == null || lvView == null");
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {
      paramInt = 1;
    } else {
      paramInt = 2;
    }
    if (paramInt != this.d)
    {
      this.d = paramInt;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setStyleByQzoneStyle=");
      localStringBuilder.append(this.d);
      QLog.i("Q.lebatab.LebaTableLogic", 1, localStringBuilder.toString());
      a(a());
    }
  }
  
  public void a(ILebaDiyIconPart paramILebaDiyIconPart)
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaBusinessILebaDiyIconPart = paramILebaDiyIconPart;
  }
  
  public void a(List<LebaViewItem> paramList)
  {
    b(paramList);
    d();
  }
  
  public List<Integer> b()
  {
    AppRuntime localAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
    if (localAppRuntime != null) {
      return LebaUtil.a(localAppRuntime, LebaUtil.d(localAppRuntime));
    }
    return null;
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout;
    if (localObject == null)
    {
      QLog.i("Q.lebatab.LebaTableLogic", 1, "stopTableItemAnim mRootLayout == null");
      return;
    }
    int j = ((LebaTableLayout)localObject).getChildCount();
    int i = 0;
    while (i < j)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.getChildAt(i);
      if (localObject != null)
      {
        localObject = (LebaTableViewHolder)((View)localObject).getTag();
        if (localObject != null) {
          ((LebaTableViewHolder)localObject).a();
        }
      }
      i += 1;
    }
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout;
    if (localObject == null)
    {
      QLog.i("Q.lebatab.LebaTableLogic", 1, "initTableByStyle mRootLayout == null");
      return;
    }
    int i = ((LebaTableLayout)localObject).jdField_a_of_type_Int;
    int j = this.d;
    if (i == j)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initTableByStyle equals style = ");
      ((StringBuilder)localObject).append(this.d);
      QLog.i("Q.lebatab.LebaTableLogic", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (j == 1)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout;
      ((LebaTableLayout)localObject).jdField_a_of_type_Int = j;
      ((LebaTableLayout)localObject).jdField_b_of_type_Int = ViewUtils.b(1.0F);
      this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.c = ViewUtils.b(1.0F);
      this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.d = ViewUtils.b(12.0F);
      this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.e = ViewUtils.b(12.0F);
      this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.f = ViewUtils.b(16.0F);
      this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.g = ViewUtils.b(16.0F);
      return;
    }
    if (j == 2)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout;
      ((LebaTableLayout)localObject).jdField_a_of_type_Int = j;
      ((LebaTableLayout)localObject).jdField_b_of_type_Int = ViewUtils.b(11.0F);
      this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.c = ViewUtils.b(11.0F);
      this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.d = ViewUtils.b(11.0F);
      this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.e = ViewUtils.b(12.0F);
      this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.f = ViewUtils.b(16.0F);
      this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.g = ViewUtils.b(16.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.controller.table.LebaTableLogic
 * JD-Core Version:    0.7.0.1
 */