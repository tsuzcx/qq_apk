package com.tencent.mobileqq.leba.controller.table;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.mobileqq.leba.business.ILebaDiyIconPart;
import com.tencent.mobileqq.leba.config.LebaConfigApi;
import com.tencent.mobileqq.leba.controller.ILebaController;
import com.tencent.mobileqq.leba.core.LebaUtil;
import com.tencent.mobileqq.leba.entity.InitViewParam;
import com.tencent.mobileqq.leba.entity.LebaItemListener;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.redtouch.LebaRedTouchBase;
import com.tencent.mobileqq.leba.widget.LebaTableLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.List;
import mqq.app.AppRuntime;

public class LebaTabletController
  implements ILebaController
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private View jdField_a_of_type_AndroidViewView;
  private FPSXListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
  public ILebaDiyIconPart a;
  public LebaConfigApi a;
  private LebaBannerLogic jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaBannerLogic;
  private LebaTableLogic jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaTableLogic;
  private LebaRedTouchBase jdField_a_of_type_ComTencentMobileqqLebaRedtouchLebaRedTouchBase = new LebaTabletController.LebaTableRedTouch(null);
  private List<LebaViewItem> jdField_a_of_type_JavaUtilList;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private float b;
  
  public LebaTabletController()
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaConfigLebaConfigApi = new LebaConfigApi();
    e();
  }
  
  private void a(View paramView)
  {
    Object localObject1 = a();
    int i;
    if ((!"1000".equals(localObject1)) && (!"2105".equals(localObject1)) && (!"2101".equals(localObject1)) && (!"1103".equals(localObject1)) && (!"2920".equals(localObject1)) && (!a((String)localObject1))) {
      i = 0;
    } else {
      i = 1;
    }
    Object localObject2;
    if (i != 0)
    {
      localObject1 = paramView.findViewById(2131369913);
      ViewUtils.a((View)localObject1, null);
      localObject2 = (RoundRelativeLayout)((View)localObject1).findViewById(2131376845);
      ((RoundRelativeLayout)localObject2).jdField_a_of_type_Int = ViewUtils.b(16.0F);
      ((RoundRelativeLayout)localObject2).setVisibility(0);
      localObject2 = ((View)localObject1).findViewById(2131376846);
      if (a()) {
        ((View)localObject2).setBackgroundResource(2130850559);
      } else {
        ((View)localObject2).setBackgroundResource(2130850581);
      }
      ViewUtils.a(((View)localObject1).findViewById(2131366333), null);
    }
    else
    {
      localObject1 = paramView.findViewById(2131369913);
      ((View)localObject1).setBackgroundResource(2130850682);
      localObject2 = (RoundRelativeLayout)((View)localObject1).findViewById(2131376845);
      ((RoundRelativeLayout)localObject2).jdField_a_of_type_Int = ViewUtils.b(16.0F);
      ((RoundRelativeLayout)localObject2).setVisibility(8);
      ((View)localObject1).findViewById(2131366333).setBackgroundResource(2130850694);
    }
    paramView.findViewById(2131378254).setVisibility(0);
    ((FrameLayout)paramView.findViewById(2131366904)).setVisibility(0);
  }
  
  private void b(View paramView)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131375397);
    ViewUtils.a(localRelativeLayout, null);
    localRelativeLayout.setPadding(0, 0, 0, 0);
    Object localObject1 = (LinearLayout.LayoutParams)localRelativeLayout.getLayoutParams();
    float f = 16.0F;
    ((LinearLayout.LayoutParams)localObject1).leftMargin = ViewUtils.a(16.0F);
    ((LinearLayout.LayoutParams)localObject1).rightMargin = ViewUtils.a(16.0F);
    if (this.jdField_a_of_type_Int == 1)
    {
      ((LinearLayout.LayoutParams)localObject1).topMargin = ViewUtils.a(4.0F);
      ((LinearLayout.LayoutParams)localObject1).height = ViewUtils.a(72.0F);
    }
    else
    {
      ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
      ((LinearLayout.LayoutParams)localObject1).height = ViewUtils.a(56.0F);
    }
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = (RoundRelativeLayout)localRelativeLayout.findViewById(2131376843);
    ((RoundRelativeLayout)localObject1).jdField_a_of_type_Int = ViewUtils.b(16.0F);
    ((RoundRelativeLayout)localObject1).setVisibility(0);
    localObject1 = localRelativeLayout.findViewById(2131376840);
    if (a()) {
      ((View)localObject1).setBackgroundResource(2130840561);
    } else {
      ((View)localObject1).setBackgroundResource(2130839393);
    }
    localObject1 = (ImageView)localRelativeLayout.findViewById(2131369990);
    Object localObject2 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).width = ViewUtils.b(32.0F);
    ((RelativeLayout.LayoutParams)localObject2).height = ViewUtils.b(32.0F);
    if (this.jdField_a_of_type_Int != 1) {
      f = 12.0F;
    }
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = ViewUtils.a(f);
    paramView = paramView.getResources().getDrawable(2130845501);
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqLebaBusinessILebaDiyIconPart;
    if (localObject2 != null) {
      ((ILebaDiyIconPart)localObject2).addPersonalBackgroundToIcon((ImageView)localObject1, paramView, "skin_leba_haoyoudongtai_bg");
    } else {
      LebaUtil.a("Q.lebatab.LebaTabletController", "initApi", "refreshQzoneUi");
    }
    paramView = (RelativeLayout)localRelativeLayout.findViewById(2131376650);
    localObject1 = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    if (this.jdField_a_of_type_Int == 1) {
      f = 21.0F;
    } else {
      f = 19.0F;
    }
    ((RelativeLayout.LayoutParams)localObject1).width = ViewUtils.a(f);
    paramView = (RelativeLayout.LayoutParams)((ImageView)paramView.findViewById(2131362976)).getLayoutParams();
    paramView.width = ViewUtils.a(9.0F);
    paramView.height = ViewUtils.a(15.0F);
    ((RelativeLayout.LayoutParams)((TextView)localRelativeLayout.findViewById(2131369991)).getLayoutParams()).leftMargin = ViewUtils.a(8.0F);
    ((RelativeLayout.LayoutParams)((TextView)localRelativeLayout.findViewById(2131375609)).getLayoutParams()).leftMargin = ViewUtils.a(4.0F);
  }
  
  private void c(View paramView)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131374379);
    ViewUtils.a(localRelativeLayout, null);
    localRelativeLayout.setPadding(0, 0, 0, 0);
    Object localObject1 = (LinearLayout.LayoutParams)localRelativeLayout.getLayoutParams();
    float f2 = 16.0F;
    ((LinearLayout.LayoutParams)localObject1).leftMargin = ViewUtils.a(16.0F);
    ((LinearLayout.LayoutParams)localObject1).rightMargin = ViewUtils.a(16.0F);
    float f1;
    if (this.jdField_a_of_type_Int == 1) {
      f1 = 11.0F;
    } else {
      f1 = 12.0F;
    }
    ((LinearLayout.LayoutParams)localObject1).topMargin = ViewUtils.a(f1);
    if (this.jdField_a_of_type_Int == 1) {
      f1 = 72.0F;
    } else {
      f1 = 56.0F;
    }
    ((LinearLayout.LayoutParams)localObject1).height = ViewUtils.a(f1);
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = (RoundRelativeLayout)localRelativeLayout.findViewById(2131376843);
    ((RoundRelativeLayout)localObject1).jdField_a_of_type_Int = ViewUtils.b(16.0F);
    ((RoundRelativeLayout)localObject1).setVisibility(0);
    localObject1 = localRelativeLayout.findViewById(2131376840);
    if (a()) {
      ((View)localObject1).setBackgroundResource(2130840561);
    } else {
      ((View)localObject1).setBackgroundResource(2130839393);
    }
    localObject1 = (ImageView)localRelativeLayout.findViewById(2131369990);
    Object localObject2 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).width = ViewUtils.b(32.0F);
    ((RelativeLayout.LayoutParams)localObject2).height = ViewUtils.b(32.0F);
    if (this.jdField_a_of_type_Int == 1) {
      f1 = f2;
    } else {
      f1 = 12.0F;
    }
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = ViewUtils.a(f1);
    localObject2 = paramView.getResources().getDrawable(2130845490);
    ILebaDiyIconPart localILebaDiyIconPart = this.jdField_a_of_type_ComTencentMobileqqLebaBusinessILebaDiyIconPart;
    if ((localILebaDiyIconPart != null) && (localILebaDiyIconPart.addPersonalBackgroundToIcon((ImageView)localObject1, (Drawable)localObject2, "skin_leba_xiaoshijie_bg"))) {
      ((ImageView)localObject1).setImageDrawable(paramView.getResources().getDrawable(2130845492));
    }
    paramView = (RelativeLayout)localRelativeLayout.findViewById(2131376650);
    localObject1 = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    if (this.jdField_a_of_type_Int == 1) {
      f1 = 21.0F;
    } else {
      f1 = 19.0F;
    }
    ((RelativeLayout.LayoutParams)localObject1).width = ViewUtils.a(f1);
    paramView = (RelativeLayout.LayoutParams)((ImageView)paramView.findViewById(2131362976)).getLayoutParams();
    paramView.width = ViewUtils.a(9.0F);
    paramView.height = ViewUtils.a(15.0F);
    ((RelativeLayout.LayoutParams)((TextView)localRelativeLayout.findViewById(2131374384)).getLayoutParams()).leftMargin = ViewUtils.a(8.0F);
    ((RelativeLayout.LayoutParams)((TextView)localRelativeLayout.findViewById(2131374386)).getLayoutParams()).leftMargin = ViewUtils.a(4.0F);
  }
  
  private void f()
  {
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqLebaConfigLebaConfigApi.b()) {
          break label94;
        }
        i = 1;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadQzoneStyle=");
        localStringBuilder.append(i);
        QLog.i("Q.lebatab.LebaTabletController", 1, localStringBuilder.toString());
        if (i != this.jdField_a_of_type_Int)
        {
          this.jdField_a_of_type_Int = i;
          if (this.jdField_a_of_type_AndroidViewView != null)
          {
            b(this.jdField_a_of_type_AndroidViewView);
            c(this.jdField_a_of_type_AndroidViewView);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        QLog.i("Q.lebatab.LebaTabletController", 1, "loadQzoneStyle", localException);
      }
      return;
      label94:
      int i = 0;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return ThemeUtil.getCurrentThemeId();
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null)
    {
      this.jdField_a_of_type_Float = (-((View)localObject).getY());
      this.b = this.jdField_a_of_type_Float;
    }
    f();
    localObject = this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaTableLogic;
    if (localObject != null) {
      ((LebaTableLogic)localObject).a(this.jdField_a_of_type_Int);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaBannerLogic;
    if (localObject != null)
    {
      ((LebaBannerLogic)localObject).a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaBannerLogic.d();
    }
  }
  
  public void a(InitViewParam paramInitViewParam)
  {
    QLog.i("Q.lebatab.LebaTabletController", 1, "init table");
    List localList = paramInitViewParam.jdField_a_of_type_JavaUtilList;
    FPSXListView localFPSXListView = paramInitViewParam.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
    View localView = paramInitViewParam.jdField_a_of_type_AndroidViewView;
    LebaItemListener localLebaItemListener = paramInitViewParam.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaItemListener;
    Context localContext = paramInitViewParam.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_MqqAppAppRuntime = paramInitViewParam.jdField_a_of_type_MqqAppAppRuntime;
    this.jdField_a_of_type_JavaUtilList = localList;
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView = localFPSXListView;
    this.jdField_a_of_type_AndroidViewView = localView;
    if (localFPSXListView == null)
    {
      QLog.i("Q.lebatab.LebaTabletController", 1, "initView lebaSV == null ");
      return;
    }
    try
    {
      if (localFPSXListView.getOverscrollHeader() != null) {
        localFPSXListView.setOverscrollHeader(null);
      }
    }
    catch (Exception paramInitViewParam)
    {
      QLog.i("Q.lebatab.LebaTabletController", 1, "setOverscrollHeader", paramInitViewParam);
    }
    f();
    if (localView != null) {
      try
      {
        if (localFPSXListView.getHeaderViewsCount() <= 0) {
          localFPSXListView.addHeaderView(localView);
        }
        a(localView);
        b(localView);
        c(localView);
      }
      catch (Exception paramInitViewParam)
      {
        QLog.i("Q.lebatab.LebaTabletController", 1, "addHeaderView", paramInitViewParam);
      }
    }
    try
    {
      paramInitViewParam = localFPSXListView.getAdapter();
      if ((paramInitViewParam == null) || (!(paramInitViewParam instanceof LebaTabletController.EmptyAdapter))) {
        localFPSXListView.setAdapter(new LebaTabletController.EmptyAdapter());
      }
    }
    catch (Exception paramInitViewParam)
    {
      QLog.i("Q.lebatab.LebaTabletController", 1, "setAdapter", paramInitViewParam);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaTableLogic == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaTableLogic = new LebaTableLogic(localContext);
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaTableLogic.a(this.jdField_a_of_type_ComTencentMobileqqLebaBusinessILebaDiyIconPart);
    }
    this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaTableLogic.a(this.jdField_a_of_type_Int);
    if ((this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaTableLogic.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout == null) && (localView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaTableLogic.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout = ((LebaTableLayout)localView.findViewById(2131378254));
    }
    paramInitViewParam = this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaTableLogic;
    paramInitViewParam.jdField_a_of_type_MqqAppAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
    paramInitViewParam.jdField_a_of_type_ComTencentMobileqqLebaRedtouchLebaRedTouchBase = this.jdField_a_of_type_ComTencentMobileqqLebaRedtouchLebaRedTouchBase;
    paramInitViewParam.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaItemListener = localLebaItemListener;
    paramInitViewParam.a(this.jdField_a_of_type_JavaUtilList);
    if (this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaBannerLogic == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaBannerLogic = new LebaBannerLogic(localContext);
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaBannerLogic.b();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaBannerLogic.a == null) && (localView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaBannerLogic.a = ((FrameLayout)localView.findViewById(2131366904));
    }
    this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaBannerLogic.a(this.jdField_a_of_type_MqqAppAppRuntime);
    this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaBannerLogic.a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaBannerLogic.d();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    paramAbsListView = this.jdField_a_of_type_AndroidViewView;
    if (paramAbsListView != null)
    {
      float f = -paramAbsListView.getY();
      if (f > this.b) {
        this.b = f;
      }
      if (f < this.jdField_a_of_type_Float) {
        this.jdField_a_of_type_Float = f;
      }
    }
  }
  
  public void a(AppRuntime paramAppRuntime, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaTableLogic;
    if (localObject != null)
    {
      ((LebaTableLogic)localObject).a(this.jdField_a_of_type_Float, this.b, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView, this.jdField_a_of_type_AndroidViewView, paramInt1, this.jdField_a_of_type_Int, paramBoolean, paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaTableLogic.b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaBannerLogic;
    if (localObject != null) {
      ((LebaBannerLogic)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqLebaRedtouchLebaRedTouchBase;
    if (localObject != null) {
      ((LebaRedTouchBase)localObject).a(paramAppRuntime);
    }
  }
  
  public boolean a()
  {
    return ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_MqqAppAppRuntime, false, null);
  }
  
  public boolean a(String paramString)
  {
    return QQTheme.c(paramString);
  }
  
  public void b()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      a(localView);
      b(this.jdField_a_of_type_AndroidViewView);
      c(this.jdField_a_of_type_AndroidViewView);
    }
    c();
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaBannerLogic;
    if (localObject != null) {
      ((LebaBannerLogic)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaTableLogic;
    if (localObject != null) {
      ((LebaTableLogic)localObject).a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaBannerLogic;
    if (localObject != null)
    {
      ((LebaBannerLogic)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaBannerLogic.a = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaTableLogic;
    if (localObject != null)
    {
      ((LebaTableLogic)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaTableLogic.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout = null;
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaBusinessILebaDiyIconPart = ((ILebaDiyIconPart)QRoute.api(ILebaDiyIconPart.class));
    if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessILebaDiyIconPart == null) {
      LebaUtil.a("Q.lebatab.LebaTabletController", "initApi", "DiyIconPart");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.controller.table.LebaTabletController
 * JD-Core Version:    0.7.0.1
 */