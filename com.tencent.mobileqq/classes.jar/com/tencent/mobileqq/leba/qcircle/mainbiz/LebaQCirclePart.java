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
import com.tencent.mobileqq.leba.LebaConstant;
import com.tencent.mobileqq.leba.business.BaseLebaMainBiz;
import com.tencent.mobileqq.leba.entity.LeabOnPauseInfo;
import com.tencent.mobileqq.leba.entity.LebaClickReportInfo;
import com.tencent.mobileqq.leba.report.LebaDaTong;
import com.tencent.mobileqq.qcircle.api.IQCircleEeveeManangerService;
import com.tencent.mobileqq.qcircle.api.IQCirclePreLoaderService;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qcircle.api.helper.QCircleObserver;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
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
  public String b;
  public byte[] c;
  public int d = -1;
  public String e;
  public View f;
  public TextView g;
  public TextView h;
  public ImageView i;
  public TextView j;
  public TextView k;
  public TextView l;
  public ImageSwitcher m;
  public ImageView n;
  public ImageSwitcher o;
  public volatile boolean p = true;
  public volatile int q;
  public volatile boolean r;
  public volatile boolean s;
  public volatile boolean t;
  public volatile String u;
  public boolean v;
  public volatile int w;
  public LebaQZoneFacePlayHelper x;
  private QCircleObserver y = new LebaQCirclePart.5(this);
  
  public void A()
  {
    View localView = this.f;
    if (localView != null)
    {
      localView.setVisibility(8);
      QLog.d("LebaQCirclePartImpl", 1, "hideQQCircleAfterAccountChanged");
    }
  }
  
  public int B()
  {
    int i1 = this.q;
    int i2 = 0;
    if (i1 > 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    boolean bool1 = this.r;
    boolean bool2 = this.s;
    if (i1 != 0)
    {
      if (bool1) {
        return 7;
      }
      return 4;
    }
    if (bool1) {
      return 5;
    }
    i1 = i2;
    if (bool2) {
      i1 = 8;
    }
    return i1;
  }
  
  public String C()
  {
    int i1;
    if (this.q > 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    boolean bool1 = this.r;
    boolean bool2 = this.s;
    if (i1 != 0) {
      return "num_red_dot";
    }
    if (bool1) {
      return "little_red_dot";
    }
    if (bool2) {
      return "new_red_dot";
    }
    if (this.t) {
      return "recomd_red_dot";
    }
    return "";
  }
  
  public void D()
  {
    LebaClickReportInfo localLebaClickReportInfo = new LebaClickReportInfo();
    localLebaClickReportInfo.d = g();
    localLebaClickReportInfo.a = 10004L;
    localLebaClickReportInfo.b = 0;
    localLebaClickReportInfo.c = B();
    localLebaClickReportInfo.f = 0;
    a(localLebaClickReportInfo);
  }
  
  public boolean E()
  {
    View localView = this.f;
    return (localView != null) && (localView.getVisibility() == 0);
  }
  
  public void F()
  {
    this.p = true;
  }
  
  public QQAppInterface G()
  {
    AppRuntime localAppRuntime = b();
    if (localAppRuntime != null) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.f;
    if ((localObject != null) && ((((View)localObject).getVisibility() == 0) || (QCircleConfigHelper.d(StudyModeManager.h()))))
    {
      i();
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
    QQAppInterface localQQAppInterface = G();
    QBaseActivity localQBaseActivity = d();
    if ((localQQAppInterface != null) && (localQBaseActivity != null))
    {
      this.f = paramView.findViewById(2131442545);
      if (!LebaConstant.a()) {
        this.f.setVisibility(8);
      } else {
        this.f.setVisibility(0);
      }
      this.i = ((ImageView)this.f.findViewById(2131437143));
      paramView = this.i;
      if ((paramView instanceof ThemeImageView)) {
        ((ThemeImageView)paramView).setMaskShape(ThemeImageWrapper.MODE_OTHER);
      }
      this.i.setImageResource(2130846949);
      this.f.setBackgroundResource(2130839577);
      ((TextView)this.f.findViewById(2131442550)).setText(QCircleConfigHelper.bo());
      this.f.setOnClickListener(this);
      LebaDaTong.c(this.f);
      this.g = ((TextView)this.f.findViewById(2131442553));
      this.h = ((TextView)this.f.findViewById(2131442554));
      this.j = ((TextView)this.f.findViewById(2131442552));
      this.k = ((TextView)this.f.findViewById(2131442551));
      this.l = ((TextView)this.f.findViewById(2131442555));
      this.o = ((ImageSwitcher)this.f.findViewById(2131442547));
      this.o.setFactory(new LebaQCirclePart.3(this, localQBaseActivity));
      this.n = ((ImageView)this.f.findViewById(2131442549));
      this.m = ((ImageSwitcher)this.f.findViewById(2131442548));
      this.m.setFactory(new LebaQCirclePart.4(this, localQBaseActivity));
      this.x = new LebaQZoneFacePlayHelper(this.o, this.m, this.n, localQQAppInterface);
      return;
    }
    QLog.i("LebaQCirclePartImpl", 1, "initLebaQQCircleView app == null || activity == null");
  }
  
  public void a(LeabOnPauseInfo paramLeabOnPauseInfo)
  {
    paramLeabOnPauseInfo.b = E();
    paramLeabOnPauseInfo.c = B();
  }
  
  public void a(String paramString, Context paramContext, List<String> paramList)
  {
    TextView localTextView = this.h;
    if (localTextView != null)
    {
      localTextView.setText(paramString);
      paramString = (ViewGroup.MarginLayoutParams)this.h.getLayoutParams();
      if ((paramList != null) && (!paramList.isEmpty()) && (paramList.size() > 1)) {
        paramString.rightMargin = ViewUtils.dpToPx(80.0F);
      } else if ((paramList != null) && (!paramList.isEmpty()) && (paramList.size() == 1)) {
        paramString.rightMargin = ViewUtils.dpToPx(48.0F);
      } else {
        paramString.rightMargin = ViewUtils.dpToPx(8.0F);
      }
      this.h.setVisibility(0);
    }
    CustomWidgetUtil.a(this.g, 8, 0, 0);
    paramString = this.g.getLayoutParams();
    if ((paramString instanceof ViewGroup.MarginLayoutParams))
    {
      paramString = (ViewGroup.MarginLayoutParams)paramString;
      if (k()) {
        paramString.bottomMargin = (paramContext.getResources().getDimensionPixelSize(2131297498) + ViewUtils.dpToPx(8.0F));
      } else {
        paramString.bottomMargin = (paramContext.getResources().getDimensionPixelSize(2131297498) + ViewUtils.dpToPx(5.0F));
      }
    }
    this.g.setVisibility(0);
  }
  
  public void a(boolean paramBoolean)
  {
    LebaQZoneFacePlayHelper localLebaQZoneFacePlayHelper = this.x;
    if (localLebaQZoneFacePlayHelper != null) {
      localLebaQZoneFacePlayHelper.c();
    }
  }
  
  public void b(View paramView)
  {
    QQAppInterface localQQAppInterface = G();
    QBaseActivity localQBaseActivity = d();
    if ((localQQAppInterface != null) && (localQBaseActivity != null))
    {
      HashMap localHashMap1 = new HashMap();
      HashMap localHashMap2 = new HashMap();
      Object localObject = "1";
      localHashMap1.put("key_enable_splash", "1");
      localHashMap1.put("key_jump_from", "3");
      if (!this.r) {
        localObject = "0";
      }
      localHashMap1.put("key_show_active_red_dot", localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.q);
      ((StringBuilder)localObject).append("");
      localHashMap1.put("key_unread_red_num", ((StringBuilder)localObject).toString());
      localObject = this.c;
      if ((localObject != null) && (localObject.length > 0)) {
        localHashMap2.put("key_red_dot_trans_info", localObject);
      }
      if (this.d > 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.d);
        ((StringBuilder)localObject).append("");
        localHashMap1.put("key_assign_show_tab_type", ((StringBuilder)localObject).toString());
      }
      D();
      LebaDaTong.a(paramView, C());
      y();
      a(1);
      if (!TextUtils.isEmpty(this.e))
      {
        paramView = JumpParser.a(localQQAppInterface, localQBaseActivity, this.e);
        if (paramView != null)
        {
          paramView.a();
          return;
        }
      }
      localHashMap1.put("xsj_main_entrance", "qq_updates_tab");
      QCircleUtils.a().enterBySchemeAction(localQBaseActivity, "openfolder", localHashMap1, localHashMap2);
      if (!TextUtils.isEmpty(QCircleHostGlobalInfo.getEntranceGuideTips())) {
        QCircleHostGlobalInfo.setHasShowEntranceGuideTips(true);
      }
      return;
    }
    QLog.i("LebaQCirclePartImpl", 1, "onClickQCircle app == null || activity == null");
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      A();
    }
  }
  
  public void l()
  {
    Object localObject2 = G();
    Object localObject1 = d();
    if ((localObject2 != null) && (localObject1 != null))
    {
      if (!LebaConstant.a())
      {
        localObject1 = this.f;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        QLog.e("QCircleEeveeRedPoint_LebaQCirclePartImpl", 1, "updateQQCircleRedFlag hide");
        return;
      }
      localObject2 = this.f;
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(0);
      }
      QLog.e("QCircleEeveeRedPoint_LebaQCirclePartImpl", 1, "updateQQCircleRedFlag show");
      ThreadManager.post(new LebaQCirclePart.1(this, (QBaseActivity)localObject1), 5, null, false);
      return;
    }
    QLog.i("LebaQCirclePartImpl", 1, "updateQQCircleRedFlag app == null || activity == null");
  }
  
  public void m()
  {
    LebaQZoneFacePlayHelper localLebaQZoneFacePlayHelper = this.x;
    if (localLebaQZoneFacePlayHelper != null) {
      localLebaQZoneFacePlayHelper.d();
    }
  }
  
  public void n()
  {
    QzoneConfig.getInstance().addListener(this);
  }
  
  public void o()
  {
    LebaQZoneFacePlayHelper localLebaQZoneFacePlayHelper = this.x;
    if (localLebaQZoneFacePlayHelper != null) {
      localLebaQZoneFacePlayHelper.b();
    }
    F();
    a(3);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131442545)
    {
      b(paramView);
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
    LebaQZoneFacePlayHelper localLebaQZoneFacePlayHelper = this.x;
    if (localLebaQZoneFacePlayHelper != null) {
      localLebaQZoneFacePlayHelper.g();
    }
  }
  
  public void q()
  {
    QCircleUtils.d().onSend(3, null, null);
    a(2);
    if (QzoneConfig.getQQCircleShowGuideOnLebaTab()) {
      QCircleHostConfig.setNeedShowLebaTabGuideNew(false);
    }
  }
  
  public void s()
  {
    QQAppInterface localQQAppInterface = G();
    if (localQQAppInterface == null)
    {
      QLog.i("LebaQCirclePartImpl", 1, "removeObservers app == null");
      return;
    }
    localQQAppInterface.removeObserver(this.y);
  }
  
  public void t()
  {
    QQAppInterface localQQAppInterface = G();
    if (localQQAppInterface == null)
    {
      QLog.i("LebaQCirclePartImpl", 1, "addObservers app == null");
      return;
    }
    localQQAppInterface.addObserver(this.y);
  }
  
  public void u()
  {
    LebaQZoneFacePlayHelper localLebaQZoneFacePlayHelper = this.x;
    if (localLebaQZoneFacePlayHelper != null) {
      localLebaQZoneFacePlayHelper.e();
    }
  }
  
  public void v()
  {
    Object localObject1 = G();
    if (localObject1 == null)
    {
      QLog.i("LebaQCirclePartImpl", 1, "onAccountChanged app == null");
      return;
    }
    Object localObject2 = this.x;
    if (localObject2 != null) {
      ((LebaQZoneFacePlayHelper)localObject2).a((QQAppInterface)localObject1);
    }
    w();
    localObject2 = QCircleUtils.c();
    if (localObject1 != null) {
      localObject1 = ((QQAppInterface)localObject1).getCurrentUin();
    } else {
      localObject1 = "";
    }
    ((IQCirclePreLoaderService)localObject2).requestWhiteList((String)localObject1);
  }
  
  public void w()
  {
    this.d = -1;
    this.b = null;
    this.c = null;
    this.q = 0;
    this.r = false;
    this.s = false;
    this.t = false;
    this.v = false;
    this.u = null;
    this.w = 0;
    TextView localTextView = this.j;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
    localTextView = this.g;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
    this.e = null;
    QLog.d("QCircleEeveeRedPoint_LebaQCirclePartImpl", 1, "resetQQCircleRedDot redDot");
  }
  
  public void x()
  {
    int i1 = z();
    if ((!QzoneConfig.getQQCircleEnableNoneRedpointReport()) && (i1 == 4)) {
      return;
    }
    if ((!QzoneConfig.getQQCircleEnableHasRedpointReport()) && (i1 != 4)) {
      return;
    }
    if ((i1 != 0) && (this.p))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("ext1", "1");
      localHashMap.put("ext5", this.b);
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(1).setSubActionType(1).setThrActionType(i1).setExtras(localHashMap));
      this.p = false;
    }
  }
  
  public void y()
  {
    int i1 = z();
    if (i1 != 0)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("ext1", "1");
      localHashMap.put("ext5", this.b);
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(1).setSubActionType(2).setThrActionType(i1).setExtras(localHashMap));
    }
  }
  
  public int z()
  {
    int i1;
    if ((this.q > 0) && (this.r)) {
      i1 = 3;
    } else if (this.r) {
      i1 = 1;
    } else if (this.q > 0) {
      i1 = 2;
    } else if (this.t) {
      i1 = 5;
    } else if (this.v) {
      i1 = 6;
    } else {
      i1 = 4;
    }
    if (QzoneConfig.getQQCircleShowGuideOnLebaEntrance()) {
      i1 = 7;
    }
    if (QCircleHostGlobalInfo.needShowEntranceGuideTips()) {
      i1 = 8;
    }
    return i1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.qcircle.mainbiz.LebaQCirclePart
 * JD-Core Version:    0.7.0.1
 */