package com.tencent.mobileqq.leba.qcircle.mainbiz;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.LebaQZoneFacePlayHelper;
import com.tencent.mobileqq.activity.qcircle.handler.QCircleObserver;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.leba.business.BaseLebaMainBiz;
import com.tencent.mobileqq.leba.entity.LeabOnPauseInfo;
import com.tencent.mobileqq.leba.entity.LebaClickReportInfo;
import com.tencent.mobileqq.qcircle.api.IQCircleEeveeManangerService;
import com.tencent.mobileqq.qcircle.api.IQCirclePreLoaderService;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;
import common.config.service.QzoneConfig;
import common.config.service.QzoneConfig.QzoneConfigChangeListener;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;

public class LebaQCirclePart
  extends BaseLebaMainBiz
  implements View.OnClickListener, QzoneConfig.QzoneConfigChangeListener
{
  public int a;
  public View a;
  public ImageSwitcher a;
  public ImageView a;
  public TextView a;
  public LebaQZoneFacePlayHelper a;
  private QCircleObserver a;
  public String a;
  public volatile boolean a;
  public byte[] a;
  public volatile int b;
  public ImageSwitcher b;
  public ImageView b;
  public TextView b;
  public String b;
  public volatile boolean b;
  public volatile int c;
  public TextView c;
  public volatile String c;
  public volatile boolean c;
  public TextView d;
  public volatile boolean d;
  public boolean e;
  
  public LebaQCirclePart()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityQcircleHandlerQCircleObserver = new LebaQCirclePart.5(this);
  }
  
  public QQAppInterface a()
  {
    AppRuntime localAppRuntime = a();
    if (localAppRuntime != null) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) || (QzoneConfig.isShowQCircleEnter(StudyModeManager.a()))))
    {
      d();
      if (QLog.isColorLevel()) {
        QLog.d("Leba", 2, "updateRefreshFlagForQQCircle " + paramInt);
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, List<String> paramList, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString, QBaseActivity paramQBaseActivity)
  {
    a(new LebaQCirclePart.2(this, paramInt, paramQBaseActivity, paramBoolean1, paramString, paramList, paramBoolean2, paramBoolean4, paramBoolean3));
  }
  
  public void a(View paramView)
  {
    QQAppInterface localQQAppInterface = a();
    QBaseActivity localQBaseActivity = a();
    if ((localQQAppInterface == null) || (localQBaseActivity == null))
    {
      QLog.i("LebaQCirclePartImpl", 1, "initLebaQQCircleView app == null || activity == null");
      return;
    }
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131374846);
    if ((!QzoneConfig.isShowQCircleEnter(StudyModeManager.a())) || (QQTheme.e())) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370322));
      if ((this.jdField_a_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
        ((ThemeImageView)this.jdField_a_of_type_AndroidWidgetImageView).setMaskShape(ThemeImageWrapper.MODE_OTHER);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845617);
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839537);
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374851)).setText(2131719715);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374853));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374854));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374852));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374855));
      this.jdField_b_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.jdField_a_of_type_AndroidViewView.findViewById(2131374848));
      this.jdField_b_of_type_AndroidWidgetImageSwitcher.setFactory(new LebaQCirclePart.3(this, localQBaseActivity));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374850));
      this.jdField_a_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.jdField_a_of_type_AndroidViewView.findViewById(2131374849));
      this.jdField_a_of_type_AndroidWidgetImageSwitcher.setFactory(new LebaQCirclePart.4(this, localQBaseActivity));
      this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper = new LebaQZoneFacePlayHelper(this.jdField_b_of_type_AndroidWidgetImageSwitcher, this.jdField_a_of_type_AndroidWidgetImageSwitcher, this.jdField_b_of_type_AndroidWidgetImageView, localQQAppInterface);
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void a(LeabOnPauseInfo paramLeabOnPauseInfo)
  {
    paramLeabOnPauseInfo.jdField_a_of_type_Boolean = c();
    paramLeabOnPauseInfo.jdField_b_of_type_Int = c();
  }
  
  public void a(String paramString, Context paramContext, List<String> paramList)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    CustomWidgetUtil.a(this.jdField_a_of_type_AndroidWidgetTextView, 8, 0, 0);
    paramString = this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    if ((paramString instanceof ViewGroup.MarginLayoutParams))
    {
      paramString = (ViewGroup.MarginLayoutParams)paramString;
      if (!b()) {
        break label118;
      }
    }
    label118:
    for (paramString.bottomMargin = (paramContext.getResources().getDimensionPixelSize(2131297135) + ViewUtils.b(8.0F));; paramString.bottomMargin = paramContext.getResources().getDimensionPixelSize(2131297135))
    {
      if ((paramList != null) && (paramList.size() > 0)) {
        paramString.rightMargin += this.jdField_b_of_type_AndroidWidgetTextView.getWidth();
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper.c();
    }
  }
  
  public int b()
  {
    int i = 0;
    if ((this.jdField_b_of_type_Int > 0) && (this.jdField_b_of_type_Boolean)) {
      i = 3;
    }
    do
    {
      return i;
      if (this.jdField_b_of_type_Boolean) {
        return 1;
      }
      if (this.jdField_b_of_type_Int > 0) {
        return 2;
      }
      if (this.jdField_d_of_type_Boolean) {
        return 5;
      }
    } while (!this.e);
    return 6;
  }
  
  public int c()
  {
    int j = 0;
    int i;
    boolean bool1;
    boolean bool2;
    if (this.jdField_b_of_type_Int > 0)
    {
      i = 1;
      bool1 = this.jdField_b_of_type_Boolean;
      bool2 = this.jdField_c_of_type_Boolean;
      if (i == 0) {
        break label42;
      }
      if (!bool1) {
        break label40;
      }
      i = 7;
    }
    label40:
    label42:
    do
    {
      return i;
      i = 0;
      break;
      return 4;
      if (bool1) {
        return 5;
      }
      i = j;
    } while (!bool2);
    return 8;
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      t();
    }
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0);
  }
  
  public void e()
  {
    QQAppInterface localQQAppInterface = a();
    QBaseActivity localQBaseActivity = a();
    if ((localQQAppInterface == null) || (localQBaseActivity == null))
    {
      QLog.i("LebaQCirclePartImpl", 1, "updateQQCircleRedFlag app == null || activity == null");
      return;
    }
    if ((!QzoneConfig.isShowQCircleEnter(StudyModeManager.a())) || (QQTheme.e()))
    {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      QLog.e("QCircleEeveeRedPoint_LebaQCirclePartImpl", 1, "updateQQCircleRedFlag hide");
      return;
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    QLog.e("QCircleEeveeRedPoint_LebaQCirclePartImpl", 1, "updateQQCircleRedFlag show");
    ThreadManager.post(new LebaQCirclePart.1(this, localQBaseActivity), 5, null, false);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper.d();
    }
  }
  
  public void g()
  {
    QzoneConfig.getInstance().addListener(this);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper.b();
    }
    v();
    a(3);
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper.f();
    }
  }
  
  public void j()
  {
    QCircleUtils.a().onSend(3, null, null);
    a(2);
  }
  
  public void l()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null)
    {
      QLog.i("LebaQCirclePartImpl", 1, "removeObservers app == null");
      return;
    }
    localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityQcircleHandlerQCircleObserver);
  }
  
  public void m()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null)
    {
      QLog.i("LebaQCirclePartImpl", 1, "addObservers app == null");
      return;
    }
    localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityQcircleHandlerQCircleObserver);
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper.e();
    }
  }
  
  public void o()
  {
    Object localObject = a();
    if (localObject == null)
    {
      QLog.i("LebaQCirclePartImpl", 1, "onAccountChanged app == null");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper.a((QQAppInterface)localObject);
    }
    p();
    QCircleUtils.a().onSend(4, null, null);
    IQCirclePreLoaderService localIQCirclePreLoaderService = QCircleUtils.a();
    if (localObject != null) {}
    for (localObject = ((QQAppInterface)localObject).getCurrentUin();; localObject = "")
    {
      localIQCirclePreLoaderService.requestWhiteList((String)localObject);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      s();
    }
  }
  
  public void onConfigChange()
  {
    QLog.d("LebaQCirclePartImpl", 1, "onConfigChange");
    a(new LebaQCirclePart.6(this));
  }
  
  public void p()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.e = false;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_c_of_type_Int = 0;
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_b_of_type_JavaLangString = null;
    QLog.d("QCircleEeveeRedPoint_LebaQCirclePartImpl", 1, "resetQQCircleRedDot redDot");
  }
  
  public void q()
  {
    int i = b();
    if ((i != 0) && (this.jdField_a_of_type_Boolean))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("ext1", "1");
      localHashMap.put("ext5", this.jdField_a_of_type_JavaLangString);
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 1, 1, i, localHashMap, null, null);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void r()
  {
    int i = b();
    if (i != 0)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("ext1", "1");
      localHashMap.put("ext5", this.jdField_a_of_type_JavaLangString);
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 1, 2, i, localHashMap, null, null);
    }
  }
  
  public void s()
  {
    QQAppInterface localQQAppInterface = a();
    QBaseActivity localQBaseActivity = a();
    if ((localQQAppInterface == null) || (localQBaseActivity == null))
    {
      QLog.i("LebaQCirclePartImpl", 1, "onClickQCircle app == null || activity == null");
      return;
    }
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localHashMap1.put("key_enable_splash", "1");
    localHashMap1.put("key_jump_from", "3");
    if (this.jdField_b_of_type_Boolean) {}
    for (Object localObject = "1";; localObject = "0")
    {
      localHashMap1.put("key_show_active_red_dot", localObject);
      localHashMap1.put("key_unread_red_num", this.jdField_b_of_type_Int + "");
      if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length > 0)) {
        localHashMap2.put("key_red_dot_trans_info", this.jdField_a_of_type_ArrayOfByte);
      }
      if (this.jdField_a_of_type_Int > 0) {
        localHashMap1.put("key_assign_show_tab_type", this.jdField_a_of_type_Int + "");
      }
      u();
      r();
      a(1);
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        break;
      }
      localObject = JumpParser.a(localQQAppInterface, localQBaseActivity, this.jdField_b_of_type_JavaLangString);
      if (localObject == null) {
        break;
      }
      ((JumpAction)localObject).a();
      return;
    }
    localHashMap1.put("xsj_main_entrance", "qq_updates_tab");
    QCircleUtils.a().enterBySchemeAction(localQBaseActivity, "openfolder", localHashMap1, localHashMap2);
  }
  
  public void t()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      QLog.d("LebaQCirclePartImpl", 1, "hideQQCircleAfterAccountChanged");
    }
  }
  
  public void u()
  {
    LebaClickReportInfo localLebaClickReportInfo = new LebaClickReportInfo();
    localLebaClickReportInfo.jdField_a_of_type_Boolean = a();
    localLebaClickReportInfo.jdField_a_of_type_Long = 10004L;
    localLebaClickReportInfo.jdField_a_of_type_Int = 0;
    localLebaClickReportInfo.jdField_b_of_type_Int = c();
    localLebaClickReportInfo.d = 0;
    a(localLebaClickReportInfo);
  }
  
  public void v()
  {
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.qcircle.mainbiz.LebaQCirclePart
 * JD-Core Version:    0.7.0.1
 */