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
    Object localObject2;
    if (("1000".equals(localObject1)) || ("2105".equals(localObject1)) || ("2101".equals(localObject1)) || ("1103".equals(localObject1)) || ("2920".equals(localObject1)) || (a((String)localObject1)))
    {
      i = 1;
      if (i == 0) {
        break label174;
      }
      localObject1 = paramView.findViewById(2131370245);
      ViewUtils.a((View)localObject1, null);
      localObject2 = (RoundRelativeLayout)((View)localObject1).findViewById(2131377395);
      ((RoundRelativeLayout)localObject2).jdField_a_of_type_Int = ViewUtils.b(16.0F);
      ((RoundRelativeLayout)localObject2).setVisibility(0);
      localObject2 = ((View)localObject1).findViewById(2131377396);
      if (!a()) {
        break label164;
      }
      ((View)localObject2).setBackgroundResource(2130850633);
      label125:
      ViewUtils.a(((View)localObject1).findViewById(2131366452), null);
    }
    for (;;)
    {
      paramView.findViewById(2131378865).setVisibility(0);
      ((FrameLayout)paramView.findViewById(2131367059)).setVisibility(0);
      return;
      i = 0;
      break;
      label164:
      ((View)localObject2).setBackgroundResource(2130850655);
      break label125;
      label174:
      localObject1 = paramView.findViewById(2131370245);
      ((View)localObject1).setBackgroundResource(2130850756);
      localObject2 = (RoundRelativeLayout)((View)localObject1).findViewById(2131377395);
      ((RoundRelativeLayout)localObject2).jdField_a_of_type_Int = ViewUtils.b(16.0F);
      ((RoundRelativeLayout)localObject2).setVisibility(8);
      ((View)localObject1).findViewById(2131366452).setBackgroundResource(2130850768);
    }
  }
  
  private void b(View paramView)
  {
    float f = 16.0F;
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131375881);
    ViewUtils.a(localRelativeLayout, null);
    localRelativeLayout.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)localRelativeLayout.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = ViewUtils.a(16.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = ViewUtils.a(16.0F);
    if (this.jdField_a_of_type_Int == 1)
    {
      ((LinearLayout.LayoutParams)localObject).topMargin = ViewUtils.a(4.0F);
      ((LinearLayout.LayoutParams)localObject).height = ViewUtils.a(72.0F);
      localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RoundRelativeLayout)localRelativeLayout.findViewById(2131377393);
      ((RoundRelativeLayout)localObject).jdField_a_of_type_Int = ViewUtils.b(16.0F);
      ((RoundRelativeLayout)localObject).setVisibility(0);
      localObject = localRelativeLayout.findViewById(2131377388);
      if (!a()) {
        break label367;
      }
      ((View)localObject).setBackgroundResource(2130840686);
      label138:
      localObject = (ImageView)localRelativeLayout.findViewById(2131370322);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
      localLayoutParams.width = ViewUtils.b(32.0F);
      localLayoutParams.height = ViewUtils.b(32.0F);
      if (this.jdField_a_of_type_Int != 1) {
        break label377;
      }
      label187:
      localLayoutParams.leftMargin = ViewUtils.a(f);
      paramView = paramView.getResources().getDrawable(2130845628);
      if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessILebaDiyIconPart == null) {
        break label383;
      }
      this.jdField_a_of_type_ComTencentMobileqqLebaBusinessILebaDiyIconPart.addPersonalBackgroundToIcon((ImageView)localObject, paramView, "skin_leba_haoyoudongtai_bg");
      label228:
      paramView = (RelativeLayout)localRelativeLayout.findViewById(2131377184);
      localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      if (this.jdField_a_of_type_Int != 1) {
        break label395;
      }
    }
    label395:
    for (f = 21.0F;; f = 19.0F)
    {
      ((RelativeLayout.LayoutParams)localObject).width = ViewUtils.a(f);
      paramView = (RelativeLayout.LayoutParams)((ImageView)paramView.findViewById(2131363028)).getLayoutParams();
      paramView.width = ViewUtils.a(9.0F);
      paramView.height = ViewUtils.a(15.0F);
      ((RelativeLayout.LayoutParams)((TextView)localRelativeLayout.findViewById(2131370323)).getLayoutParams()).leftMargin = ViewUtils.a(8.0F);
      ((RelativeLayout.LayoutParams)((TextView)localRelativeLayout.findViewById(2131376096)).getLayoutParams()).leftMargin = ViewUtils.a(4.0F);
      return;
      ((LinearLayout.LayoutParams)localObject).topMargin = 0;
      ((LinearLayout.LayoutParams)localObject).height = ViewUtils.a(56.0F);
      break;
      label367:
      ((View)localObject).setBackgroundResource(2130839537);
      break label138;
      label377:
      f = 12.0F;
      break label187;
      label383:
      LebaUtil.a("Q.lebatab.LebaTabletController", "initApi", "refreshQzoneUi");
      break label228;
    }
  }
  
  private void c(View paramView)
  {
    float f2 = 12.0F;
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131374846);
    ViewUtils.a(localRelativeLayout, null);
    localRelativeLayout.setPadding(0, 0, 0, 0);
    Object localObject1 = (LinearLayout.LayoutParams)localRelativeLayout.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject1).leftMargin = ViewUtils.a(16.0F);
    ((LinearLayout.LayoutParams)localObject1).rightMargin = ViewUtils.a(16.0F);
    if (this.jdField_a_of_type_Int == 1)
    {
      f1 = 11.0F;
      ((LinearLayout.LayoutParams)localObject1).topMargin = ViewUtils.a(f1);
      if (this.jdField_a_of_type_Int != 1) {
        break label400;
      }
      f1 = 72.0F;
      label90:
      ((LinearLayout.LayoutParams)localObject1).height = ViewUtils.a(f1);
      localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = (RoundRelativeLayout)localRelativeLayout.findViewById(2131377393);
      ((RoundRelativeLayout)localObject1).jdField_a_of_type_Int = ViewUtils.b(16.0F);
      ((RoundRelativeLayout)localObject1).setVisibility(0);
      localObject1 = localRelativeLayout.findViewById(2131377388);
      if (!a()) {
        break label406;
      }
      ((View)localObject1).setBackgroundResource(2130840686);
      label157:
      localObject1 = (ImageView)localRelativeLayout.findViewById(2131370322);
      Object localObject2 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = ViewUtils.b(32.0F);
      ((RelativeLayout.LayoutParams)localObject2).height = ViewUtils.b(32.0F);
      f1 = f2;
      if (this.jdField_a_of_type_Int == 1) {
        f1 = 16.0F;
      }
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = ViewUtils.a(f1);
      localObject2 = paramView.getResources().getDrawable(2130845617);
      if ((this.jdField_a_of_type_ComTencentMobileqqLebaBusinessILebaDiyIconPart != null) && (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessILebaDiyIconPart.addPersonalBackgroundToIcon((ImageView)localObject1, (Drawable)localObject2, "skin_leba_xiaoshijie_bg"))) {
        ((ImageView)localObject1).setImageDrawable(paramView.getResources().getDrawable(2130845619));
      }
      paramView = (RelativeLayout)localRelativeLayout.findViewById(2131377184);
      localObject1 = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      if (this.jdField_a_of_type_Int != 1) {
        break label416;
      }
    }
    label400:
    label406:
    label416:
    for (float f1 = 21.0F;; f1 = 19.0F)
    {
      ((RelativeLayout.LayoutParams)localObject1).width = ViewUtils.a(f1);
      paramView = (RelativeLayout.LayoutParams)((ImageView)paramView.findViewById(2131363028)).getLayoutParams();
      paramView.width = ViewUtils.a(9.0F);
      paramView.height = ViewUtils.a(15.0F);
      ((RelativeLayout.LayoutParams)((TextView)localRelativeLayout.findViewById(2131374851)).getLayoutParams()).leftMargin = ViewUtils.a(8.0F);
      ((RelativeLayout.LayoutParams)((TextView)localRelativeLayout.findViewById(2131374852)).getLayoutParams()).leftMargin = ViewUtils.a(4.0F);
      return;
      f1 = 12.0F;
      break;
      f1 = 56.0F;
      break label90;
      ((View)localObject1).setBackgroundResource(2130839537);
      break label157;
    }
  }
  
  private void f()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqLebaConfigLebaConfigApi.b()) {}
      for (int i = 1;; i = 0)
      {
        QLog.i("Q.lebatab.LebaTabletController", 1, "loadQzoneStyle=" + i);
        if (i != this.jdField_a_of_type_Int)
        {
          this.jdField_a_of_type_Int = i;
          if (this.jdField_a_of_type_AndroidViewView != null)
          {
            b(this.jdField_a_of_type_AndroidViewView);
            c(this.jdField_a_of_type_AndroidViewView);
          }
        }
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.i("Q.lebatab.LebaTabletController", 1, "loadQzoneStyle", localException);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return ThemeUtil.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_Float = (-this.jdField_a_of_type_AndroidViewView.getY());
      this.b = this.jdField_a_of_type_Float;
    }
    f();
    if (this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaTableLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaTableLogic.a(this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaBannerLogic != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaBannerLogic.a(this.jdField_a_of_type_Int);
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
      f();
      if (localView != null) {}
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
        for (;;)
        {
          label157:
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
        break label157;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaTableLogic == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaTableLogic = new LebaTableLogic(localContext);
        this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaTableLogic.a(this.jdField_a_of_type_ComTencentMobileqqLebaBusinessILebaDiyIconPart);
      }
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaTableLogic.a(this.jdField_a_of_type_Int);
      if ((this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaTableLogic.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout == null) && (localView != null)) {
        this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaTableLogic.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout = ((LebaTableLayout)localView.findViewById(2131378865));
      }
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaTableLogic.jdField_a_of_type_MqqAppAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaTableLogic.jdField_a_of_type_ComTencentMobileqqLebaRedtouchLebaRedTouchBase = this.jdField_a_of_type_ComTencentMobileqqLebaRedtouchLebaRedTouchBase;
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaTableLogic.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaItemListener = localLebaItemListener;
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaTableLogic.a(this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaBannerLogic == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaBannerLogic = new LebaBannerLogic(localContext);
        this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaBannerLogic.b();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaBannerLogic.a == null) && (localView != null)) {
        this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaBannerLogic.a = ((FrameLayout)localView.findViewById(2131367059));
      }
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaBannerLogic.a(this.jdField_a_of_type_MqqAppAppRuntime);
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaBannerLogic.a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaBannerLogic.d();
      return;
    }
    catch (Exception paramInitViewParam)
    {
      for (;;)
      {
        QLog.i("Q.lebatab.LebaTabletController", 1, "setOverscrollHeader", paramInitViewParam);
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      float f = -this.jdField_a_of_type_AndroidViewView.getY();
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
    if (this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaTableLogic != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaTableLogic.a(this.jdField_a_of_type_Float, this.b, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView, this.jdField_a_of_type_AndroidViewView, paramInt1, this.jdField_a_of_type_Int, paramBoolean, paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaTableLogic.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaBannerLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaBannerLogic.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLebaRedtouchLebaRedTouchBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaRedtouchLebaRedTouchBase.a(paramAppRuntime);
    }
  }
  
  public boolean a()
  {
    return ThemeUtil.a(this.jdField_a_of_type_MqqAppAppRuntime, false, null);
  }
  
  public boolean a(String paramString)
  {
    return QQTheme.b(paramString);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      a(this.jdField_a_of_type_AndroidViewView);
      b(this.jdField_a_of_type_AndroidViewView);
      c(this.jdField_a_of_type_AndroidViewView);
    }
    c();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaBannerLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaBannerLogic.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaTableLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaTableLogic.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaBannerLogic != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaBannerLogic.a();
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaBannerLogic.a = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaTableLogic != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerTableLebaTableLogic.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.controller.table.LebaTabletController
 * JD-Core Version:    0.7.0.1
 */