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
import com.tencent.mobileqq.qcircle.api.helper.QCircleObserver;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostConfig;
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
  public TextView e;
  public boolean e;
  
  public LebaQCirclePart()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqQcircleApiHelperQCircleObserver = new LebaQCirclePart.5(this);
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
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if ((localObject != null) && ((((View)localObject).getVisibility() == 0) || (QzoneConfig.isShowQCircleEnter(StudyModeManager.a()))))
    {
      d();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateRefreshFlagForQQCircle ");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("Leba", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, List<String> paramList, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString, QBaseActivity paramQBaseActivity, boolean paramBoolean5)
  {
    a(new LebaQCirclePart.2(this, paramBoolean5, paramInt, paramQBaseActivity, paramBoolean1, paramString, paramList, paramBoolean2, paramBoolean4, paramBoolean3));
  }
  
  public void a(View paramView)
  {
    QQAppInterface localQQAppInterface = a();
    QBaseActivity localQBaseActivity = a();
    if ((localQQAppInterface != null) && (localQBaseActivity != null))
    {
      this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131374379);
      if ((QzoneConfig.isShowQCircleEnter(StudyModeManager.a())) && (!QQTheme.f())) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      } else {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369990));
      paramView = this.jdField_a_of_type_AndroidWidgetImageView;
      if ((paramView instanceof ThemeImageView)) {
        ((ThemeImageView)paramView).setMaskShape(ThemeImageWrapper.MODE_OTHER);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845490);
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839393);
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374384)).setText(2131719438);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374387));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374388));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374386));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374385));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374389));
      this.jdField_b_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.jdField_a_of_type_AndroidViewView.findViewById(2131374381));
      this.jdField_b_of_type_AndroidWidgetImageSwitcher.setFactory(new LebaQCirclePart.3(this, localQBaseActivity));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374383));
      this.jdField_a_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.jdField_a_of_type_AndroidViewView.findViewById(2131374382));
      this.jdField_a_of_type_AndroidWidgetImageSwitcher.setFactory(new LebaQCirclePart.4(this, localQBaseActivity));
      this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper = new LebaQZoneFacePlayHelper(this.jdField_b_of_type_AndroidWidgetImageSwitcher, this.jdField_a_of_type_AndroidWidgetImageSwitcher, this.jdField_b_of_type_AndroidWidgetImageView, localQQAppInterface);
      return;
    }
    QLog.i("LebaQCirclePartImpl", 1, "initLebaQQCircleView app == null || activity == null");
  }
  
  public void a(LeabOnPauseInfo paramLeabOnPauseInfo)
  {
    paramLeabOnPauseInfo.jdField_a_of_type_Boolean = c();
    paramLeabOnPauseInfo.jdField_b_of_type_Int = c();
  }
  
  public void a(String paramString, Context paramContext, List<String> paramList)
  {
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      localTextView.setText(paramString);
      paramString = (ViewGroup.MarginLayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      if ((paramList != null) && (!paramList.isEmpty()) && (paramList.size() > 1)) {
        paramString.rightMargin = ViewUtils.b(80.0F);
      } else if ((paramList != null) && (!paramList.isEmpty()) && (paramList.size() == 1)) {
        paramString.rightMargin = ViewUtils.b(48.0F);
      } else {
        paramString.rightMargin = ViewUtils.b(8.0F);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    CustomWidgetUtil.a(this.jdField_a_of_type_AndroidWidgetTextView, 8, 0, 0);
    paramString = this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    if ((paramString instanceof ViewGroup.MarginLayoutParams))
    {
      paramString = (ViewGroup.MarginLayoutParams)paramString;
      if (b()) {
        paramString.bottomMargin = (paramContext.getResources().getDimensionPixelSize(2131297117) + ViewUtils.b(8.0F));
      } else {
        paramString.bottomMargin = (paramContext.getResources().getDimensionPixelSize(2131297117) + ViewUtils.b(5.0F));
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void a(boolean paramBoolean)
  {
    LebaQZoneFacePlayHelper localLebaQZoneFacePlayHelper = this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper;
    if (localLebaQZoneFacePlayHelper != null) {
      localLebaQZoneFacePlayHelper.c();
    }
  }
  
  public int b()
  {
    int i;
    if ((this.jdField_b_of_type_Int > 0) && (this.jdField_b_of_type_Boolean)) {
      i = 3;
    } else if (this.jdField_b_of_type_Boolean) {
      i = 1;
    } else if (this.jdField_b_of_type_Int > 0) {
      i = 2;
    } else if (this.jdField_d_of_type_Boolean) {
      i = 5;
    } else if (this.jdField_e_of_type_Boolean) {
      i = 6;
    } else {
      i = 4;
    }
    if (QzoneConfig.getQQCircleShowGuideOnLebaEntrance()) {
      i = 7;
    }
    return i;
  }
  
  public int c()
  {
    int i = this.jdField_b_of_type_Int;
    int j = 0;
    if (i > 0) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool1 = this.jdField_b_of_type_Boolean;
    boolean bool2 = this.jdField_c_of_type_Boolean;
    if (i != 0)
    {
      if (bool1) {
        return 7;
      }
      return 4;
    }
    if (bool1) {
      return 5;
    }
    i = j;
    if (bool2) {
      i = 8;
    }
    return i;
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      t();
    }
  }
  
  public boolean c()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    return (localView != null) && (localView.getVisibility() == 0);
  }
  
  public void e()
  {
    Object localObject2 = a();
    Object localObject1 = a();
    if ((localObject2 != null) && (localObject1 != null))
    {
      if ((QzoneConfig.isShowQCircleEnter(StudyModeManager.a())) && (!QQTheme.f()))
      {
        localObject2 = this.jdField_a_of_type_AndroidViewView;
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(0);
        }
        QLog.e("QCircleEeveeRedPoint_LebaQCirclePartImpl", 1, "updateQQCircleRedFlag show");
        ThreadManager.post(new LebaQCirclePart.1(this, (QBaseActivity)localObject1), 5, null, false);
        return;
      }
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      QLog.e("QCircleEeveeRedPoint_LebaQCirclePartImpl", 1, "updateQQCircleRedFlag hide");
      return;
    }
    QLog.i("LebaQCirclePartImpl", 1, "updateQQCircleRedFlag app == null || activity == null");
  }
  
  public void f()
  {
    LebaQZoneFacePlayHelper localLebaQZoneFacePlayHelper = this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper;
    if (localLebaQZoneFacePlayHelper != null) {
      localLebaQZoneFacePlayHelper.d();
    }
  }
  
  public void g()
  {
    QzoneConfig.getInstance().addListener(this);
  }
  
  public void h()
  {
    LebaQZoneFacePlayHelper localLebaQZoneFacePlayHelper = this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper;
    if (localLebaQZoneFacePlayHelper != null) {
      localLebaQZoneFacePlayHelper.b();
    }
    v();
    a(3);
  }
  
  public void i()
  {
    LebaQZoneFacePlayHelper localLebaQZoneFacePlayHelper = this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper;
    if (localLebaQZoneFacePlayHelper != null) {
      localLebaQZoneFacePlayHelper.f();
    }
  }
  
  public void j()
  {
    QCircleUtils.a().onSend(3, null, null);
    a(2);
    if (QzoneConfig.getQQCircleShowGuideOnLebaTab()) {
      QCircleHostConfig.setNeedShowLebaTabGuideNew(false);
    }
  }
  
  public void l()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null)
    {
      QLog.i("LebaQCirclePartImpl", 1, "removeObservers app == null");
      return;
    }
    localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqQcircleApiHelperQCircleObserver);
  }
  
  public void m()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null)
    {
      QLog.i("LebaQCirclePartImpl", 1, "addObservers app == null");
      return;
    }
    localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqQcircleApiHelperQCircleObserver);
  }
  
  public void n()
  {
    LebaQZoneFacePlayHelper localLebaQZoneFacePlayHelper = this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper;
    if (localLebaQZoneFacePlayHelper != null) {
      localLebaQZoneFacePlayHelper.e();
    }
  }
  
  public void o()
  {
    Object localObject1 = a();
    if (localObject1 == null)
    {
      QLog.i("LebaQCirclePartImpl", 1, "onAccountChanged app == null");
      return;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper;
    if (localObject2 != null) {
      ((LebaQZoneFacePlayHelper)localObject2).a((QQAppInterface)localObject1);
    }
    p();
    localObject2 = QCircleUtils.a();
    if (localObject1 != null) {
      localObject1 = ((QQAppInterface)localObject1).getCurrentUin();
    } else {
      localObject1 = "";
    }
    ((IQCirclePreLoaderService)localObject2).requestWhiteList((String)localObject1);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131374379)
    {
      s();
      if (QzoneConfig.getQQCircleShowGuideOnLebaEntrance()) {
        QCircleHostConfig.setNeedShowLebaQCircleEntranceGuideNew(false);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
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
    this.jdField_e_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_c_of_type_Int = 0;
    TextView localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
    localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
    this.jdField_b_of_type_JavaLangString = null;
    QLog.d("QCircleEeveeRedPoint_LebaQCirclePartImpl", 1, "resetQQCircleRedDot redDot");
  }
  
  public void q()
  {
    int i = b();
    if ((!QzoneConfig.getQQCircleEnableNoneRedpointReport()) && (i == 4)) {
      return;
    }
    if ((!QzoneConfig.getQQCircleEnableHasRedpointReport()) && (i != 4)) {
      return;
    }
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
    if ((localQQAppInterface != null) && (localQBaseActivity != null))
    {
      HashMap localHashMap1 = new HashMap();
      HashMap localHashMap2 = new HashMap();
      Object localObject = "1";
      localHashMap1.put("key_enable_splash", "1");
      localHashMap1.put("key_jump_from", "3");
      if (!this.jdField_b_of_type_Boolean) {
        localObject = "0";
      }
      localHashMap1.put("key_show_active_red_dot", localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      ((StringBuilder)localObject).append("");
      localHashMap1.put("key_unread_red_num", ((StringBuilder)localObject).toString());
      localObject = this.jdField_a_of_type_ArrayOfByte;
      if ((localObject != null) && (localObject.length > 0)) {
        localHashMap2.put("key_red_dot_trans_info", localObject);
      }
      if (this.jdField_a_of_type_Int > 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append("");
        localHashMap1.put("key_assign_show_tab_type", ((StringBuilder)localObject).toString());
      }
      u();
      r();
      a(1);
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        localObject = JumpParser.a(localQQAppInterface, localQBaseActivity, this.jdField_b_of_type_JavaLangString);
        if (localObject != null)
        {
          ((JumpAction)localObject).a();
          return;
        }
      }
      localHashMap1.put("xsj_main_entrance", "qq_updates_tab");
      QCircleUtils.a().enterBySchemeAction(localQBaseActivity, "openfolder", localHashMap1, localHashMap2);
      return;
    }
    QLog.i("LebaQCirclePartImpl", 1, "onClickQCircle app == null || activity == null");
  }
  
  public void t()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      localView.setVisibility(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.qcircle.mainbiz.LebaQCirclePart
 * JD-Core Version:    0.7.0.1
 */