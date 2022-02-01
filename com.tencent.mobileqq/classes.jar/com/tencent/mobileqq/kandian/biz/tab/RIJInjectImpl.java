package com.tencent.mobileqq.kandian.biz.tab;

import android.content.res.Resources;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.framebusiness.BaseFrameBusiness;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.home.impl.FrameInfoBean;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameFragment.DragViewTouchListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.tab.IRIJTabFrame;
import com.tencent.mobileqq.kandian.base.utils.api.IRIJRuntimeUtils;
import com.tencent.mobileqq.kandian.base.view.api.IKanDianOptUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IRIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.push.api.IKanDianMergeManager;
import com.tencent.mobileqq.kandian.biz.xtab.RIJXTabFrame;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.kandian.glue.report.api.IReadInJoyReportUtils;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.util.QQKRPUtil;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class RIJInjectImpl
  extends BaseFrameBusiness
{
  public static final String a = FrameControllerUtil.f;
  
  public static void a(FrameFragment paramFrameFragment, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("update kandian tab, type : ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("TabFrameControllerImpl", 2, ((StringBuilder)localObject).toString());
    if (paramInt == 0)
    {
      ((ITabFrameController)QRoute.api(ITabFrameController.class)).setFrames(paramFrameFragment, false);
      return;
    }
    if (!(paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.get(FrameControllerUtil.g) instanceof ReadInjoyTabDragAnimationView)) {
      return;
    }
    localObject = (ReadInjoyTabDragAnimationView)paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.get(FrameControllerUtil.g);
    paramFrameFragment = (TextView)paramFrameFragment.b.get(FrameControllerUtil.g);
    if ((localObject != null) && (paramFrameFragment != null))
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                return;
              }
              ((ReadInjoyTabDragAnimationView)localObject).setIsSelect(true);
              return;
            }
            ((ReadInjoyTabDragAnimationView)localObject).setIsSelect(false);
            return;
          }
          ((ReadInjoyTabDragAnimationView)localObject).a(0);
          return;
        }
        ((ReadInjoyTabDragAnimationView)localObject).a(false);
        return;
      }
      if (((ReadInjoyTabDragAnimationView)localObject).a() != 1)
      {
        ((ReadInjoyTabDragAnimationView)localObject).a(1);
        ((ReadInjoyTabDragAnimationView)localObject).a(true);
      }
      return;
    }
    QLog.d("TabFrameControllerImpl", 2, "iconView is null, give up !");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, HashMap<String, View> paramHashMap)
  {
    if (paramHashMap != null) {}
    for (;;)
    {
      try
      {
        if (paramHashMap.get(FrameControllerUtil.f) != null)
        {
          paramHashMap = (BusinessInfoCheckUpdate.RedTypeInfo)((RedTouch)paramHashMap.get(FrameControllerUtil.f)).getTag(2131376127);
          if (paramHashMap == null) {
            break label168;
          }
          j = FrameControllerUtil.b(paramHashMap.red_type.get());
          if (j != 1) {
            break label163;
          }
          i = Integer.parseInt(paramHashMap.red_content.get());
          paramHashMap = new StringBuilder();
          paramHashMap.append("");
          paramHashMap.append(j);
          paramHashMap = paramHashMap.toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(i);
          ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X80098E1", "0X80098E1", 0, 0, paramHashMap, localStringBuilder.toString(), "", "");
          return;
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TabFrameControllerImplBusiness", 2, paramQQAppInterface, new Object[0]);
        }
      }
      return;
      label163:
      int i = 1;
      continue;
      label168:
      i = 0;
      int j = 0;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, HashMap<String, View> paramHashMap, View[] paramArrayOfView)
  {
    ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).synSwitchCache();
    ((IKanDianMergeManager)paramQQAppInterface.getRuntimeService(IKanDianMergeManager.class)).tryToShowAppInPush();
    if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isShowKandianTab())
    {
      if ((paramArrayOfView != null) && (paramArrayOfView.length >= 6) && (paramArrayOfView[6] != null)) {
        VideoReport.reportEvent("imp", ((RedTouch)paramArrayOfView[6]).a(), new RIJDtParamBuilder().a("14").a("tab_id", "kandian").b("tab_bar").a().a());
      }
      paramQQAppInterface = (RedTouch)paramHashMap.get(FrameControllerUtil.f);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = (BusinessInfoCheckUpdate.RedTypeInfo)paramQQAppInterface.getTag(2131376127);
        ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).reportForReadInJoyTabExposure(paramQQAppInterface);
      }
      ThreadManager.executeOnSubThread(new RIJInjectImpl.2());
    }
  }
  
  public static void h(FrameFragment paramFrameFragment)
  {
    RedTouch localRedTouch = (RedTouch)paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.get(FrameControllerUtil.f);
    if (localRedTouch != null)
    {
      Frame localFrame = paramFrameFragment.a();
      boolean bool3 = true;
      boolean bool1;
      if ((localFrame != null) && (((IRIJXTabFrameUtils)QRoute.api(IRIJXTabFrameUtils.class)).isKandianTabFrame(localFrame))) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      Object localObject1 = (QQAppInterface)((IRIJRuntimeUtils)QRoute.api(IRIJRuntimeUtils.class)).getAppRuntime();
      if (localObject1 != null) {
        localObject1 = ((IKanDianMergeManager)((QQAppInterface)localObject1).getRuntimeService(IKanDianMergeManager.class)).getReadInJoyTabRedInfo();
      } else {
        localObject1 = null;
      }
      boolean bool2;
      if ((localObject1 != null) && (((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.get() == 5)) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      Object localObject2 = localObject1;
      if (bool1)
      {
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.get() == 0)
          {
            localObject2 = localObject1;
            if (((IRIJTabFrame)localFrame).m_()) {
              localObject2 = null;
            }
          }
        }
      }
      localRedTouch.setTag(2131376127, localObject2);
      ((ITabFrameController)QRoute.api(ITabFrameController.class)).updateRedTouch(paramFrameFragment, 39, localRedTouch, localObject2);
      if (((BaseActivity.sTopActivity instanceof SplashActivity)) && (paramFrameFragment.isVisible()) && (((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).isAppOnForeground(null)) && (localObject2 != null)) {
        ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).reportForReadInJoyTabExposure(localObject2);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("updateKandianTabRedPoint isInTabFrame : ");
        ((StringBuilder)localObject1).append(bool1);
        ((StringBuilder)localObject1).append(", isRemoveRedPoint : ");
        if (localObject2 == null) {
          bool1 = bool3;
        } else {
          bool1 = false;
        }
        ((StringBuilder)localObject1).append(bool1);
        ((StringBuilder)localObject1).append(", isNumRedPoint : ");
        ((StringBuilder)localObject1).append(bool2);
        ((StringBuilder)localObject1).append(", cnt : ");
        if (localObject2 != null) {
          paramFrameFragment = localObject2.red_content.get();
        } else {
          paramFrameFragment = Integer.valueOf(0);
        }
        ((StringBuilder)localObject1).append(paramFrameFragment);
        QLog.d("Q.readinjoy.4tab", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public static void i(FrameFragment paramFrameFragment)
  {
    int i;
    int j;
    if (FrameControllerUtil.a())
    {
      i = -1;
      j = -1;
    }
    else
    {
      i = 2130843386;
      j = 2130843387;
    }
    View localView = ((IKanDianOptUtils)QRoute.api(IKanDianOptUtils.class)).generateTabItem(i, 2130850756, j, 2130850757, 2131694315, 16, 8);
    if (localView != null)
    {
      localView.setOnClickListener(new RIJInjectImpl.1(paramFrameFragment));
      paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[6] = new RedTouch(paramFrameFragment.a(), localView).b(49).e(3).c(5).a();
      VideoReport.setElementId(localView, "tab_button");
      VideoReport.setElementParams(localView, new RIJDtParamBuilder().a("14").a("tab_id", "kandian").b("tab_bar").c("click_tab").a().a());
      paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.put(FrameControllerUtil.f, paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[6]);
      HashMap localHashMap = paramFrameFragment.jdField_a_of_type_JavaUtilHashMap;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(FrameControllerUtil.f);
      localStringBuilder.append("_num");
      localHashMap.put(localStringBuilder.toString(), paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[6].findViewById(2131380161));
      localView.setContentDescription(paramFrameFragment.getResources().getString(2131694315));
    }
  }
  
  public void a()
  {
    TabFrameControllerImpl.registerFrameInfo(new FrameInfoBean(ReadinjoyTabFrame.class, true, FrameControllerUtil.g, "", 2130850756, 2130850757, 2131694315, 16, 8));
    TabFrameControllerImpl.registerFrameInfo(new FrameInfoBean(RIJXTabFrame.class, true, FrameControllerUtil.g, "", 2130850756, 2130850757, 2131694315, 16, 8));
  }
  
  public void a(int paramInt)
  {
    ReadinjoySPEventReport.c(paramInt);
  }
  
  public void a(FrameFragment paramFrameFragment)
  {
    paramFrameFragment = paramFrameFragment.a(((IRIJXTabFrameUtils)QRoute.api(IRIJXTabFrameUtils.class)).getTabFrame());
    if (paramFrameFragment != null) {
      ((IRIJTabFrame)paramFrameFragment).au_();
    }
  }
  
  public void a(FrameFragment paramFrameFragment, int paramInt1, Frame paramFrame, int paramInt2)
  {
    if ((!((IRIJXTabFrameUtils)QRoute.api(IRIJXTabFrameUtils.class)).isKandianTabFrame(paramFrame)) && (paramInt2 != FrameControllerUtil.g))
    {
      a(paramFrameFragment, 4);
    }
    else
    {
      IRIJTabFrame localIRIJTabFrame = (IRIJTabFrame)paramFrameFragment.a(((IRIJXTabFrameUtils)QRoute.api(IRIJXTabFrameUtils.class)).getTabFrame());
      if (localIRIJTabFrame != null) {
        if (paramInt2 == FrameControllerUtil.g)
        {
          ((IReadInJoyReportUtils)QRoute.api(IReadInJoyReportUtils.class)).reset68bRespArticlePosReportInfo(paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime);
          localIRIJTabFrame.d(true);
          a(paramFrameFragment, 5);
        }
        else
        {
          localIRIJTabFrame.d(false);
          a(paramFrameFragment, 4);
        }
      }
    }
    QQKRPUtil.a((QQAppInterface)paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime, paramFrameFragment, paramFrame, paramInt2);
  }
  
  public void a(FrameFragment paramFrameFragment, FrameFragment.DragViewTouchListener paramDragViewTouchListener) {}
  
  public void a(FrameFragment paramFrameFragment, String paramString) {}
  
  public void a(RedTouch paramRedTouch, FrameFragment paramFrameFragment, int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, IRedTouchManager paramIRedTouchManager)
  {
    if (paramInt == 39) {
      h(paramFrameFragment);
    }
  }
  
  public void a(HashMap<String, View> paramHashMap, boolean paramBoolean)
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).setSoundEffectsEnableForTab(paramHashMap, paramBoolean, a);
  }
  
  public void a(AppRuntime paramAppRuntime, SparseArray<TabDragAnimationView> paramSparseArray, int paramInt) {}
  
  public boolean a(FrameFragment paramFrameFragment)
  {
    return false;
  }
  
  public void b()
  {
    FrameInfoBean localFrameInfoBean = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByClazz(ReadinjoyTabFrame.class);
    localFrameInfoBean.a(FrameControllerUtil.g);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOnUpdateFrameInfo className: ");
    localStringBuilder.append(localFrameInfoBean.a().getName());
    localStringBuilder.append(" tabIndex: ");
    localStringBuilder.append(localFrameInfoBean.a());
    QLog.d("TabFrameControllerImplBusiness", 1, localStringBuilder.toString());
    localFrameInfoBean = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByClazz(RIJXTabFrame.class);
    localFrameInfoBean.a(FrameControllerUtil.g);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOnUpdateFrameInfo className: ");
    localStringBuilder.append(localFrameInfoBean.a().getName());
    localStringBuilder.append(" tabIndex: ");
    localStringBuilder.append(localFrameInfoBean.a());
    QLog.d("TabFrameControllerImplBusiness", 1, localStringBuilder.toString());
  }
  
  public void b(FrameFragment paramFrameFragment)
  {
    paramFrameFragment.a(FrameControllerUtil.g, 2130843386, 2130843387);
  }
  
  public void b(FrameFragment paramFrameFragment, String paramString) {}
  
  public void c(FrameFragment paramFrameFragment) {}
  
  public void d(FrameFragment paramFrameFragment) {}
  
  public void e(FrameFragment paramFrameFragment) {}
  
  public void f(FrameFragment paramFrameFragment) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.RIJInjectImpl
 * JD-Core Version:    0.7.0.1
 */