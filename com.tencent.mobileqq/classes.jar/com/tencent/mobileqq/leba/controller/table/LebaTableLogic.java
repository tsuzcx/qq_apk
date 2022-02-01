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
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130845632);
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
    if (paramView == null) {
      paramStringBuilder1.append(",headView == null");
    }
    int i;
    int j;
    do
    {
      return;
      paramView = paramView.findViewById(2131375881);
      if (paramView == null)
      {
        paramStringBuilder1.append(",qZone == null");
        return;
      }
      i = paramView.getTop();
      j = paramView.getHeight() + i;
      paramStringBuilder1.append(",qZoneTop = ").append(i).append(",qZoneBottom = ").append(j);
    } while (((paramFloat1 >= i) || (i >= paramFloat2)) && ((paramFloat1 >= j) || (j >= paramFloat2)));
    paramStringBuilder2.append(10000L).append("_").append(0).append("_").append(paramInt1).append("_").append(0).append("_").append(LebaConstant.a(paramInt2)).append("_").append(paramString).append(";");
  }
  
  private void a(float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean, String paramString, View paramView, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    if (paramView == null) {
      paramStringBuilder1.append(",headView == null");
    }
    int i;
    int j;
    do
    {
      return;
      paramView = paramView.findViewById(2131374846);
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
      i = paramView.getTop();
      j = paramView.getHeight() + i;
      paramStringBuilder1.append(",qCircleTop = ").append(i).append(",qCircleBottom = ").append(j);
    } while (((paramFloat1 >= i) || (i >= paramFloat2)) && ((paramFloat1 >= j) || (j >= paramFloat2)));
    paramStringBuilder2.append(10004L).append("_").append(0).append("_").append(paramInt).append("_").append(0).append("_").append(0).append("_").append(paramString).append(";");
  }
  
  private void a(float paramFloat1, float paramFloat2, String paramString, View paramView, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    paramView = paramView.findViewById(2131378865);
    if (paramView == null) {
      paramStringBuilder1.append(",tableRoot == null");
    }
    int j;
    int i;
    for (;;)
    {
      return;
      j = paramView.getTop();
      int k = this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.getChildCount();
      paramStringBuilder1.append(", r_top = ").append(j).append(", r_count = ").append(k);
      i = 0;
      while (i < k)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.getChildAt(i);
        if (paramView != null) {
          break label105;
        }
        paramStringBuilder1.append("itemView == null ");
        i += 1;
      }
    }
    label105:
    int m = paramView.getTop() + j;
    int n = m + paramView.getHeight();
    if (((paramFloat1 < m) && (m < paramFloat2)) || ((paramFloat1 < n) && (n < paramFloat2))) {}
    for (boolean bool = true;; bool = false)
    {
      paramStringBuilder1.append(";").append(i).append("v_top=").append(m).append(",v_bottom=").append(n).append(bool);
      if (!bool) {
        break;
      }
      a(paramString, paramStringBuilder1, paramStringBuilder2, paramView);
      break;
    }
  }
  
  private void a(int paramInt, LebaTableLayout paramLebaTableLayout)
  {
    try
    {
      Object localObject = new LebaTableViewHolder(paramLebaTableLayout.getContext(), this.jdField_a_of_type_AndroidViewLayoutInflater, this.d, this.jdField_a_of_type_ComTencentMobileqqLebaBusinessILebaDiyIconPart);
      View localView = ((LebaTableViewHolder)localObject).jdField_a_of_type_AndroidViewView;
      localView.setTag(localObject);
      localView.setId(paramInt);
      localObject = ((LebaTableViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetRoundRelativeLayout;
      if (localObject != null)
      {
        ((RoundRelativeLayout)localObject).jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        ((RoundRelativeLayout)localObject).jdField_b_of_type_Int = a(paramInt);
      }
      for (;;)
      {
        paramLebaTableLayout.addView(localView);
        return;
        QLog.i("Q.lebatab.LebaTableLogic", 1, "rootLayout != null");
      }
      return;
    }
    catch (Exception paramLebaTableLayout)
    {
      QLog.i("Q.lebatab.LebaTableLogic", 1, "addTableItem,index = " + paramInt, paramLebaTableLayout);
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
        localStringBuilder.append(" ").append(i);
        i += 1;
      }
      QLog.i("Q.lebatab.LebaTableLogic", 1, localStringBuilder.toString());
    }
  }
  
  private void a(String paramString, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, View paramView)
  {
    LebaViewItem localLebaViewItem = a(paramView);
    if ((localLebaViewItem == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo == null))
    {
      paramStringBuilder1.append(" item == null ||  item.info == null ");
      return;
    }
    paramStringBuilder1.append(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId);
    long l = localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId;
    int k = paramView.getId();
    int j;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqLebaRedtouchLebaRedTouchBase != null)
    {
      paramStringBuilder1 = (LebaExposureInfo)this.jdField_a_of_type_ComTencentMobileqqLebaRedtouchLebaRedTouchBase.a().get(Long.valueOf(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId));
      if (paramStringBuilder1 != null)
      {
        j = paramStringBuilder1.jdField_a_of_type_Int;
        i = paramStringBuilder1.jdField_b_of_type_Int;
      }
    }
    for (;;)
    {
      paramStringBuilder2.append(l).append("_").append(k + 1).append("_").append(j).append("_").append(i).append("_").append(0).append("_").append(paramString).append(";");
      return;
      i = 0;
      j = 0;
    }
  }
  
  private int b(int paramInt)
  {
    int i = 0;
    int k = 0;
    int j = k;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        j = k;
      }
    }
    else {
      return j;
    }
    int m = this.jdField_a_of_type_JavaUtilList.size();
    if (paramInt == 0) {
      i = 1;
    }
    j = i;
    if (paramInt == m - 1) {
      j = i | 0x4;
    }
    if (this.c > m) {}
    for (k = m - 1;; k = this.c - 1)
    {
      i = j;
      if (paramInt == k) {
        i = j | 0x2;
      }
      j = m % this.c;
      k = j;
      if (j == 0) {
        k = 3;
      }
      j = i;
      if (paramInt != m - k) {
        break;
      }
      return i | 0x8;
    }
  }
  
  private void b(LebaTableLayout paramLebaTableLayout)
  {
    Object localObject1 = a();
    boolean bool1;
    boolean bool3;
    int i;
    if (("1000".equals(localObject1)) || ("2105".equals(localObject1)) || ("1103".equals(localObject1)) || ("2101".equals(localObject1)))
    {
      bool1 = true;
      bool3 = ThemeUtil.a(this.jdField_a_of_type_MqqAppAppRuntime, false, null);
      QLog.i("Q.lebatab.LebaTableLogic", 1, String.format("bindDataToTable themeId %s isNeedWaterMark %b isNight = %b", new Object[] { localObject1, Boolean.valueOf(bool1), Boolean.valueOf(bool3) }));
      i = 0;
      label101:
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        return;
      }
      localObject1 = (LebaViewItem)this.jdField_a_of_type_JavaUtilList.get(i);
      localObject2 = a(paramLebaTableLayout, i);
      if (localObject2 != null) {
        break label177;
      }
      QLog.i("Q.lebatab.LebaTableLogic", 1, String.format("itemView == null %d", new Object[] { Integer.valueOf(i) }));
    }
    for (;;)
    {
      i += 1;
      break label101;
      bool1 = false;
      break;
      label177:
      if (((View)localObject2).getTag() != null) {
        break label211;
      }
      QLog.i("Q.lebatab.LebaTableLogic", 1, String.format("itemView.getTag() == null %d", new Object[] { Integer.valueOf(i) }));
    }
    label211:
    Object localObject2 = (LebaTableViewHolder)((View)localObject2).getTag();
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
    if ((bool1) && (this.d == 1)) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      localBindDataParam.jdField_b_of_type_Boolean = bool2;
      ((LebaTableViewHolder)localObject2).a(localBindDataParam);
      break;
    }
  }
  
  private void b(List<LebaViewItem> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    while (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        LebaViewItem localLebaViewItem = (LebaViewItem)localIterator.next();
        if ((localLebaViewItem != null) && (TextUtils.isEmpty(localLebaViewItem.jdField_a_of_type_JavaLangString))) {
          this.jdField_a_of_type_JavaUtilList.add(localLebaViewItem);
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    LebaUtil.b(paramList, b());
    if ((!this.jdField_a_of_type_JavaUtilList.isEmpty()) && (this.d == 1))
    {
      int j = this.jdField_a_of_type_JavaUtilList.size() % this.c;
      if ((j > 0) && (j < this.c))
      {
        int i = 0;
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
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      a();
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout);
    b(this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout);
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
    return ThemeUtil.a();
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
    if (this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.setPadding(0, 0, 0, 0);
      b();
      this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.removeAllViews();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, View paramView1, View paramView2, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout == null) || (paramView1 == null))
    {
      QLog.i("Q.lebatab.LebaTableLogic", 1, "statExposure mRootLayout == null || lvView == null");
      return;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    String str = a();
    paramFloat2 += paramView1.getHeight() - paramView1.getPaddingBottom() - paramView1.getPaddingTop();
    localStringBuilder1.append("reportExposure, e_top = ").append(paramFloat1).append(", e_bottom = ").append(paramFloat2);
    a(paramFloat1, paramFloat2, paramInt1, paramInt2, str, paramView2, localStringBuilder1, localStringBuilder2);
    a(paramFloat1, paramFloat2, paramInt3, paramBoolean, str, paramView2, localStringBuilder1, localStringBuilder2);
    a(paramFloat1, paramFloat2, str, paramView2, localStringBuilder1, localStringBuilder2);
    paramView2 = LebaReportUtils.a("plugin_exp");
    paramView2.jdField_a_of_type_JavaLangString = localStringBuilder2.toString();
    if (this.d == 1) {}
    for (paramView1 = "2";; paramView1 = "1")
    {
      paramView2.h = paramView1;
      EXReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, paramView2);
      QLog.i("Q.lebatab.LebaTableLogic", 1, localStringBuilder2);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {}
    for (paramInt = 1;; paramInt = 2)
    {
      if (paramInt != this.d)
      {
        this.d = paramInt;
        QLog.i("Q.lebatab.LebaTableLogic", 1, "setStyleByQzoneStyle=" + this.d);
        a(a());
      }
      return;
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
    if (this.jdField_a_of_type_MqqAppAppRuntime != null) {
      return LebaUtil.a(this.jdField_a_of_type_MqqAppAppRuntime, LebaUtil.d(this.jdField_a_of_type_MqqAppAppRuntime));
    }
    return null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout == null)
    {
      QLog.i("Q.lebatab.LebaTableLogic", 1, "stopTableItemAnim mRootLayout == null");
      return;
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.getChildCount();
    int i = 0;
    label27:
    Object localObject;
    if (i < j)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.getChildAt(i);
      if (localObject != null) {
        break label52;
      }
    }
    for (;;)
    {
      i += 1;
      break label27;
      break;
      label52:
      localObject = (LebaTableViewHolder)((View)localObject).getTag();
      if (localObject != null) {
        ((LebaTableViewHolder)localObject).a();
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout == null) {
      QLog.i("Q.lebatab.LebaTableLogic", 1, "initTableByStyle mRootLayout == null");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.jdField_a_of_type_Int == this.d)
      {
        QLog.i("Q.lebatab.LebaTableLogic", 1, "initTableByStyle equals style = " + this.d);
        return;
      }
      if (this.d == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.jdField_a_of_type_Int = this.d;
        this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.jdField_b_of_type_Int = ViewUtils.b(1.0F);
        this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.c = ViewUtils.b(1.0F);
        this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.d = ViewUtils.b(12.0F);
        this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.e = ViewUtils.b(12.0F);
        this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.f = ViewUtils.b(16.0F);
        this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.g = ViewUtils.b(16.0F);
        return;
      }
    } while (this.d != 2);
    this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.jdField_a_of_type_Int = this.d;
    this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.jdField_b_of_type_Int = ViewUtils.b(11.0F);
    this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.c = ViewUtils.b(11.0F);
    this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.d = ViewUtils.b(11.0F);
    this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.e = ViewUtils.b(12.0F);
    this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.f = ViewUtils.b(16.0F);
    this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout.g = ViewUtils.b(16.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.controller.table.LebaTableLogic
 * JD-Core Version:    0.7.0.1
 */