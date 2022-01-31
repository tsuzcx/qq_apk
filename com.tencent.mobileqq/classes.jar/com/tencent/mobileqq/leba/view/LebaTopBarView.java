package com.tencent.mobileqq.leba.view;

import aejy;
import aejz;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.qwallet.widget.ImmersionBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.leba.LebaTopBarAdapter;
import com.tencent.mobileqq.leba.QZoneEntryController;
import com.tencent.mobileqq.leba.header.LebaGridMenuAdapter;
import com.tencent.mobileqq.leba.header.LebaGridShowManager;
import com.tencent.mobileqq.leba.header.PluginActionFactory.PluginPool;
import com.tencent.mobileqq.leba.model.LebaGridItemInfo;
import com.tencent.mobileqq.leba.model.PluginInfo;
import com.tencent.mobileqq.statistics.EXReportController;
import com.tencent.mobileqq.statistics.exreportitem.DC03309ReportItem;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class LebaTopBarView
  extends RelativeLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = Color.parseColor("#0A182D");
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ImmersionBar jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetImmersionBar;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private LebaTopBarAdapter jdField_a_of_type_ComTencentMobileqqLebaLebaTopBarAdapter;
  QZoneEntryController jdField_a_of_type_ComTencentMobileqqLebaQZoneEntryController;
  private LebaGridMenuAdapter jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridMenuAdapter;
  protected LebaFPSXListView.Listener a;
  private LebaGridMenuView jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = Color.parseColor("#F9F9FB");
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  private int jdField_e_of_type_Int = 300;
  private View jdField_e_of_type_AndroidViewView;
  private int jdField_f_of_type_Int = 500;
  private View jdField_f_of_type_AndroidViewView;
  private View g;
  private View h;
  private View i;
  
  public LebaTopBarView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public LebaTopBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(View paramView, float paramFloat1, float paramFloat2)
  {
    paramView = ObjectAnimator.ofFloat(paramView, "rotation", new float[] { paramFloat1, paramFloat2 });
    paramView.setDuration(this.jdField_e_of_type_Int);
    paramView.start();
  }
  
  private void a(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { paramFloat1, paramFloat2 });
    localObjectAnimator.setDuration(this.jdField_f_of_type_Int);
    localObjectAnimator.addUpdateListener(new aejz(this, paramFloat2, paramBoolean, paramView));
    localObjectAnimator.start();
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt1, paramInt2 });
    localValueAnimator.addUpdateListener(new aejy(this, paramView));
    localValueAnimator.setDuration(this.jdField_e_of_type_Int);
    localValueAnimator.start();
  }
  
  public LebaGridMenuView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView;
  }
  
  public HorizontalListView a()
  {
    return this.jdField_a_of_type_ComTencentWidgetHorizontalListView;
  }
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    if ((this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null) && (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getVisibility() == 0))
    {
      int j = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
      int k = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition();
      if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaTopBarAdapter != null)
      {
        List localList = this.jdField_a_of_type_ComTencentMobileqqLebaLebaTopBarAdapter.a();
        for (;;)
        {
          if ((localList != null) && (j < k)) {
            try
            {
              if ((localList.get(j) != null) && (((LebaGridItemInfo)localList.get(j)).a != null)) {
                localJSONObject.put("p" + Integer.toString(j + 1), Integer.toString(((LebaGridItemInfo)localList.get(j)).a.pluginId));
              }
              j += 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                QLog.e("LebaTopBarView", 1, localException, new Object[0]);
              }
            }
          }
        }
      }
    }
    return localJSONObject.toString();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime(), false, null);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetImmersionBar = new ImmersionBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_Int);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      this.jdField_f_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView.b();
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetImmersionBar = new ImmersionBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetImmersionBar.statusBarDarkFont(isShown());
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_b_of_type_Int);
      this.g.setBackgroundColor(this.jdField_b_of_type_Int);
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt == 1) && (a())) {
      b(true);
    }
  }
  
  public void a(Context paramContext)
  {
    inflate(paramContext, 2130970408, this);
  }
  
  public void a(View paramView, int paramInt, LebaGridMenuView paramLebaGridMenuView)
  {
    if (paramView == null) {}
    do
    {
      do
      {
        return;
        if (paramInt < paramView.getHeight() - getHeight()) {
          break;
        }
      } while (getVisibility() == 0);
      setVisibility(0);
      paramInt = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
      int j = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition();
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaTopBarAdapter.a(paramInt, j);
      c(1);
      return;
    } while (getVisibility() != 0);
    if (a()) {
      b(false);
    }
    setVisibility(4);
    a(paramLebaGridMenuView);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaQZoneEntryController != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaQZoneEntryController.a(paramQQAppInterface);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b(false);
    setVisibility(4);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131370356));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131370355);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131370359);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131362846);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370348));
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView = ((LebaGridMenuView)findViewById(2131370349));
    paramBaseActivity = LebaGridShowManager.a().b(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqLebaLebaTopBarAdapter = new LebaTopBarAdapter(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqLebaLebaTopBarAdapter.a(paramBaseActivity);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqLebaLebaTopBarAdapter);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131370360);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidViewView = findViewById(2131370357);
    this.jdField_f_of_type_AndroidViewView = findViewById(2131362374);
    this.g = findViewById(2131370358);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)findViewById(2131370354));
    a();
    paramBaseActivity = LebaGridShowManager.a().a().iterator();
    while (paramBaseActivity.hasNext()) {
      if (((LebaGridItemInfo)paramBaseActivity.next()).a.pluginId == 10000)
      {
        this.jdField_a_of_type_ComTencentMobileqqLebaQZoneEntryController = new QZoneEntryController(paramQQAppInterface, getContext());
        LebaTopEntryView localLebaTopEntryView = (LebaTopEntryView)this.jdField_a_of_type_ComTencentMobileqqLebaQZoneEntryController.a();
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localLebaTopEntryView);
      }
    }
    setVisibility(8);
  }
  
  public void a(LebaGridMenuView paramLebaGridMenuView)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramLebaGridMenuView != null)
    {
      localObject1 = localObject2;
      if ((paramLebaGridMenuView.jdField_a_of_type_ComTencentMobileqqLebaHeaderGridMenuAdapter instanceof LebaGridMenuAdapter)) {
        localObject1 = (LebaGridMenuAdapter)paramLebaGridMenuView.jdField_a_of_type_ComTencentMobileqqLebaHeaderGridMenuAdapter;
      }
    }
    int j;
    boolean bool;
    if ((paramLebaGridMenuView != null) && (localObject1 != null))
    {
      j = paramLebaGridMenuView.a() + 1;
      bool = paramLebaGridMenuView.a();
      if (j - 1 >= paramLebaGridMenuView.jdField_a_of_type_ArrayOfBoolean.length) {
        break label87;
      }
      if (paramLebaGridMenuView.jdField_a_of_type_ArrayOfBoolean[(j - 1)] == 0) {
        break label78;
      }
    }
    label78:
    label87:
    do
    {
      return;
      paramLebaGridMenuView.jdField_a_of_type_ArrayOfBoolean[(j - 1)] = true;
      localObject1 = ((LebaGridMenuAdapter)localObject1).a(paramLebaGridMenuView.a(), bool);
      paramLebaGridMenuView.jdField_a_of_type_ArrayOfBoolean[(j - 1)] = true;
      paramLebaGridMenuView = new DC03309ReportItem();
      paramLebaGridMenuView.i = "trends_tab";
      paramLebaGridMenuView.j = "trends_plugin";
      paramLebaGridMenuView.k = "plugin_exp";
      paramLebaGridMenuView.jdField_a_of_type_Int = 1;
      paramLebaGridMenuView.jdField_b_of_type_Int = j;
      paramLebaGridMenuView.jdField_c_of_type_Int = 1;
      paramLebaGridMenuView.jdField_a_of_type_Long = 0L;
      paramLebaGridMenuView.jdField_a_of_type_JavaLangString = ((String)localObject1);
      EXReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLebaGridMenuView);
    } while (!QLog.isColorLevel());
    QLog.d("raymondguo", 2, "grid report is " + paramLebaGridMenuView);
  }
  
  public void a(List paramList)
  {
    paramList = new ArrayList(paramList);
    paramList.addAll(0, LebaGridShowManager.a().a());
    if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaTopBarAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaTopBarAdapter.a(paramList);
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaTopBarAdapter.notifyDataSetChanged();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridMenuAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridMenuAdapter.a();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams()).setMargins(0, AIOUtils.a(-30.0F, getResources()), 0, 0);
    this.jdField_b_of_type_AndroidViewView.requestLayout();
    if (paramBoolean)
    {
      if (this.jdField_c_of_type_Int == 0) {
        this.jdField_c_of_type_Int = this.jdField_c_of_type_AndroidViewView.getHeight();
      }
      this.jdField_d_of_type_Int = (this.h.getHeight() + this.i.getHeight() + AIOUtils.a(10.0F, getResources()));
      a(this.jdField_a_of_type_AndroidViewView, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
      a(this.jdField_d_of_type_AndroidViewView, 0.0F, 1.0F, false);
      a(this.jdField_c_of_type_AndroidViewView, 1.0F, 0.0F, true);
      a(this.jdField_b_of_type_AndroidViewView, 0.0F, 180.0F);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqLebaQZoneEntryController != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqLebaQZoneEntryController.a();
        this.jdField_a_of_type_ComTencentMobileqqLebaQZoneEntryController.e();
        this.jdField_a_of_type_ComTencentMobileqqLebaQZoneEntryController.j();
      }
      c(1);
      LebaGridShowManager.a().jdField_a_of_type_Int = 2;
      return;
      this.jdField_d_of_type_AndroidViewView.setAlpha(1.0F);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.getLayoutParams().height = this.jdField_d_of_type_Int;
      this.jdField_a_of_type_AndroidViewView.requestLayout();
      this.jdField_b_of_type_AndroidViewView.setRotation(180.0F);
    }
  }
  
  public boolean a()
  {
    if (getVisibility() != 0) {}
    while ((this.jdField_d_of_type_AndroidViewView == null) || (this.jdField_d_of_type_AndroidViewView.getVisibility() != 0)) {
      return false;
    }
    return true;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqLebaQZoneEntryController != null) && (this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaQZoneEntryController.a();
      this.jdField_a_of_type_ComTencentMobileqqLebaQZoneEntryController.e();
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView.a(paramInt);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams()).setMargins(0, AIOUtils.a(-52.0F, getResources()), 0, 0);
    this.jdField_b_of_type_AndroidViewView.requestLayout();
    if (this.jdField_c_of_type_Int == 0) {
      this.jdField_c_of_type_Int = this.jdField_c_of_type_AndroidViewView.getHeight();
    }
    if (paramBoolean)
    {
      a(this.jdField_a_of_type_AndroidViewView, this.jdField_d_of_type_Int, this.jdField_c_of_type_Int);
      a(this.jdField_d_of_type_AndroidViewView, 1.0F, 0.0F, true);
      a(this.jdField_c_of_type_AndroidViewView, 0.0F, 1.0F, false);
      a(this.jdField_b_of_type_AndroidViewView, 180.0F, 0.0F);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqLebaQZoneEntryController != null) {
        this.jdField_a_of_type_ComTencentMobileqqLebaQZoneEntryController.g();
      }
      c(1);
      LebaGridShowManager.a().jdField_a_of_type_Int = 1;
      return;
      this.jdField_c_of_type_AndroidViewView.setAlpha(1.0F);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.getLayoutParams().height = this.jdField_c_of_type_Int;
      this.jdField_a_of_type_AndroidViewView.requestLayout();
      this.jdField_b_of_type_AndroidViewView.setRotation(0.0F);
    }
  }
  
  public void c(int paramInt)
  {
    String str;
    int j;
    if (getVisibility() == 0)
    {
      str = "";
      if (!a()) {
        break label243;
      }
      j = this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView.a() + 1;
      if (this.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridMenuAdapter != null) {
        str = this.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridMenuAdapter.a(j - 1, this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView.a());
      }
      if ((j - 1 >= this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView.jdField_a_of_type_ArrayOfBoolean.length) || (paramInt != 1)) {
        break label99;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView.jdField_a_of_type_ArrayOfBoolean[(j - 1)] == 0) {
        break label87;
      }
    }
    label258:
    for (;;)
    {
      return;
      label87:
      this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView.jdField_a_of_type_ArrayOfBoolean[(j - 1)] = true;
      label99:
      if (j - 1 < this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView.jdField_a_of_type_ArrayOfBoolean.length)
      {
        this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView.jdField_a_of_type_ArrayOfBoolean[(j - 1)] = true;
        paramInt = 2;
      }
      for (;;)
      {
        if (str.equals("")) {
          break label258;
        }
        DC03309ReportItem localDC03309ReportItem = new DC03309ReportItem();
        localDC03309ReportItem.i = "trends_tab";
        localDC03309ReportItem.j = "trends_plugin";
        localDC03309ReportItem.k = "plugin_exp";
        localDC03309ReportItem.jdField_a_of_type_Int = paramInt;
        localDC03309ReportItem.jdField_b_of_type_Int = j;
        localDC03309ReportItem.jdField_c_of_type_Int = 1;
        localDC03309ReportItem.jdField_a_of_type_Long = 0L;
        localDC03309ReportItem.jdField_a_of_type_JavaLangString = str;
        EXReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localDC03309ReportItem);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("LebaTopBarView", 2, "grid report is " + localDC03309ReportItem);
        return;
        label243:
        paramInt = 3;
        j = 0;
        str = a();
        continue;
        paramInt = 2;
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0)
    {
      a(true);
      this.jdField_b_of_type_AndroidViewView.setContentDescription("点击收起九宫格");
      return;
    }
    b(true);
    this.jdField_b_of_type_AndroidViewView.setContentDescription("点击展开九宫格");
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView$Listener != null) {
      return (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView$Listener.a(paramMotionEvent)) || (super.onInterceptTouchEvent(paramMotionEvent));
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetImmersionBar != null) && (!this.jdField_a_of_type_Boolean))
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetImmersionBar;
      if ((paramInt != 0) || (!isShown())) {
        break label38;
      }
    }
    label38:
    for (boolean bool = true;; bool = false)
    {
      paramView.statusBarDarkFont(bool);
      return;
    }
  }
  
  public void setGridMenuAdapter(LebaGridMenuAdapter paramLebaGridMenuAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridMenuAdapter = paramLebaGridMenuAdapter;
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridMenuView.setAdapter(paramLebaGridMenuAdapter, "topBar");
  }
  
  public void setGridMenuHeigh(View paramView1, View paramView2)
  {
    this.h = paramView1;
    this.i = paramView2;
  }
  
  public void setListener(LebaFPSXListView.Listener paramListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView$Listener = paramListener;
  }
  
  public void setPluginPool(PluginActionFactory.PluginPool paramPluginPool)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaTopBarAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaTopBarAdapter.a(paramPluginPool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.leba.view.LebaTopBarView
 * JD-Core Version:    0.7.0.1
 */