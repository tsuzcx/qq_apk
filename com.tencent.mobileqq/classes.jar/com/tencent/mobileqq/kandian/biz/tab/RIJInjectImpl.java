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
import com.tencent.mobileqq.activity.home.impl.FrameInitBean;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameFragment.DragViewTouchListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.tab.IRIJTabFrame;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.view.api.impl.KanDianOptUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.push.api.IKanDianMergeManager;
import com.tencent.mobileqq.kandian.biz.xtab.RIJXTabFrame;
import com.tencent.mobileqq.kandian.biz.xtab.api.impl.RIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.kandian.glue.report.RIJKanDianTabReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
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
  public static final String a = FrameControllerUtil.q;
  
  public static void a(FrameFragment paramFrameFragment, FrameInitBean paramFrameInitBean)
  {
    KDBottomTabThemeManager.a(paramFrameInitBean, paramFrameFragment);
    int i;
    int j;
    if (FrameControllerUtil.a())
    {
      i = -1;
      j = -1;
    }
    else
    {
      i = 2130844340;
      j = 2130844341;
    }
    paramFrameInitBean = KanDianOptUtils.INSTANCE.generateTabItem(i, 2130852574, j, 2130852576, 2131891953, 16, 8);
    if (paramFrameInitBean != null)
    {
      paramFrameInitBean.setOnClickListener(new RIJInjectImpl.1(paramFrameFragment));
      paramFrameFragment.z[6] = new RedTouch(paramFrameFragment.C(), paramFrameInitBean).c(49).c(3.0F).d(5).a();
      VideoReport.setElementId(paramFrameInitBean, "tab_button");
      VideoReport.setElementParams(paramFrameInitBean, new RIJDtParamBuilder().a("14").a("tab_id", "kandian").b("tab_bar").c("click_tab").a().c());
      paramFrameFragment.G.put(FrameControllerUtil.q, paramFrameFragment.z[6]);
      HashMap localHashMap = paramFrameFragment.G;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(FrameControllerUtil.q);
      localStringBuilder.append("_num");
      localHashMap.put(localStringBuilder.toString(), paramFrameFragment.z[6].findViewById(2131449076));
      paramFrameInitBean.setContentDescription(paramFrameFragment.getResources().getString(2131891953));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, HashMap<String, View> paramHashMap)
  {
    if (paramHashMap != null) {}
    for (;;)
    {
      try
      {
        if (paramHashMap.get(FrameControllerUtil.q) != null)
        {
          paramHashMap = (BusinessInfoCheckUpdate.RedTypeInfo)((RedTouch)paramHashMap.get(FrameControllerUtil.q)).getTag(2131444330);
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
    ReadInJoyHelper.s();
    ((IKanDianMergeManager)paramQQAppInterface.getRuntimeService(IKanDianMergeManager.class)).tryToShowAppInPush();
    if (RIJShowKanDianTabSp.c())
    {
      if ((paramArrayOfView != null) && (paramArrayOfView.length >= 6) && (paramArrayOfView[6] != null)) {
        VideoReport.reportEvent("imp", ((RedTouch)paramArrayOfView[6]).getTarget(), new RIJDtParamBuilder().a("14").a("tab_id", "kandian").b("tab_bar").a().c());
      }
      paramQQAppInterface = (RedTouch)paramHashMap.get(FrameControllerUtil.q);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = (BusinessInfoCheckUpdate.RedTypeInfo)paramQQAppInterface.getTag(2131444330);
        RIJKanDianTabReport.a((QQAppInterface)RIJQQAppInterfaceUtil.e(), paramQQAppInterface);
      }
      ThreadManager.executeOnSubThread(new RIJInjectImpl.2());
    }
  }
  
  public static void b(FrameFragment paramFrameFragment, int paramInt)
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
    if (!(paramFrameFragment.B.get(FrameControllerUtil.g) instanceof ReadInjoyTabDragAnimationView)) {
      return;
    }
    localObject = (ReadInjoyTabDragAnimationView)paramFrameFragment.B.get(FrameControllerUtil.g);
    paramFrameFragment = (TextView)paramFrameFragment.C.get(FrameControllerUtil.g);
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
      if (((ReadInjoyTabDragAnimationView)localObject).getStyle() != 1)
      {
        ((ReadInjoyTabDragAnimationView)localObject).a(1);
        ((ReadInjoyTabDragAnimationView)localObject).a(true);
      }
      return;
    }
    QLog.d("TabFrameControllerImpl", 2, "iconView is null, give up !");
  }
  
  public static void i(FrameFragment paramFrameFragment)
  {
    RedTouch localRedTouch = (RedTouch)paramFrameFragment.G.get(FrameControllerUtil.q);
    if (localRedTouch != null)
    {
      Frame localFrame = paramFrameFragment.v();
      boolean bool3 = true;
      boolean bool1;
      if ((localFrame != null) && (RIJXTabFrameUtils.INSTANCE.isKandianTabFrame(localFrame))) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      Object localObject1 = (QQAppInterface)RIJQQAppInterfaceUtil.e();
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
            if (((IRIJTabFrame)localFrame).l()) {
              localObject2 = null;
            }
          }
        }
      }
      localRedTouch.setTag(2131444330, localObject2);
      localRedTouch.setUseNewStyle(true);
      ((ITabFrameController)QRoute.api(ITabFrameController.class)).updateRedTouch(paramFrameFragment, 39, localRedTouch, localObject2);
      if (((BaseActivity.sTopActivity instanceof SplashActivity)) && (paramFrameFragment.isVisible()) && (ReadInJoyUtils.a(null)) && (localObject2 != null)) {
        RIJKanDianTabReport.a((QQAppInterface)RIJQQAppInterfaceUtil.e(), localObject2);
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
  
  public void a()
  {
    TabFrameControllerImpl.registerFrameInfo(new FrameInfoBean(ReadinjoyTabFrame.class, true, FrameControllerUtil.g, FrameControllerUtil.q, 2130852574, 2130852576, 2131891953, 16, 8));
    TabFrameControllerImpl.registerFrameInfo(new FrameInfoBean(RIJXTabFrame.class, true, FrameControllerUtil.g, FrameControllerUtil.q, 2130852574, 2130852576, 2131891953, 16, 8));
  }
  
  public void a(FrameFragment paramFrameFragment)
  {
    paramFrameFragment = paramFrameFragment.a(RIJXTabFrameUtils.INSTANCE.getTabFrame());
    if (paramFrameFragment != null) {
      ((IRIJTabFrame)paramFrameFragment).cP_();
    }
    KDBottomTabThemeManager.a();
  }
  
  public void a(FrameFragment paramFrameFragment, int paramInt)
  {
    ReadinjoySPEventReport.e(paramInt);
  }
  
  public void a(FrameFragment paramFrameFragment, int paramInt1, Frame paramFrame, int paramInt2)
  {
    if ((!RIJXTabFrameUtils.INSTANCE.isKandianTabFrame(paramFrame)) && (paramInt2 != FrameControllerUtil.g))
    {
      b(paramFrameFragment, 4);
    }
    else
    {
      IRIJTabFrame localIRIJTabFrame = (IRIJTabFrame)paramFrameFragment.a(RIJXTabFrameUtils.INSTANCE.getTabFrame());
      if (localIRIJTabFrame != null) {
        if (paramInt2 == FrameControllerUtil.g)
        {
          ReadinjoyReportUtils.a(paramFrameFragment.A);
          localIRIJTabFrame.d(true);
          b(paramFrameFragment, 5);
        }
        else
        {
          localIRIJTabFrame.d(false);
          b(paramFrameFragment, 4);
        }
      }
    }
    QQKRPUtil.a((QQAppInterface)paramFrameFragment.A, paramFrameFragment, paramFrame, paramInt2);
  }
  
  public void a(FrameFragment paramFrameFragment, FrameFragment.DragViewTouchListener paramDragViewTouchListener) {}
  
  public void a(FrameFragment paramFrameFragment, String paramString) {}
  
  public void a(RedTouch paramRedTouch, FrameFragment paramFrameFragment, int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, IRedTouchManager paramIRedTouchManager)
  {
    if (paramInt == 39) {
      i(paramFrameFragment);
    }
  }
  
  public void a(HashMap<String, View> paramHashMap, boolean paramBoolean)
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).setSoundEffectsEnableForTab(paramHashMap, paramBoolean, a);
  }
  
  public void a(AppRuntime paramAppRuntime, SparseArray<TabDragAnimationView> paramSparseArray, int paramInt) {}
  
  public void b()
  {
    FrameInfoBean localFrameInfoBean = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByClazz(ReadinjoyTabFrame.class);
    localFrameInfoBean.a(FrameControllerUtil.g);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOnUpdateFrameInfo className: ");
    localStringBuilder.append(localFrameInfoBean.a().getName());
    localStringBuilder.append(" tabIndex: ");
    localStringBuilder.append(localFrameInfoBean.c());
    QLog.d("TabFrameControllerImplBusiness", 1, localStringBuilder.toString());
    localFrameInfoBean = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByClazz(RIJXTabFrame.class);
    localFrameInfoBean.a(FrameControllerUtil.g);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOnUpdateFrameInfo className: ");
    localStringBuilder.append(localFrameInfoBean.a().getName());
    localStringBuilder.append(" tabIndex: ");
    localStringBuilder.append(localFrameInfoBean.c());
    QLog.d("TabFrameControllerImplBusiness", 1, localStringBuilder.toString());
    KDBottomTabThemeManager.a();
  }
  
  public void b(FrameFragment paramFrameFragment)
  {
    paramFrameFragment.a(FrameControllerUtil.g, 2130844340, 2130844341);
    KDBottomTabThemeManager.a();
  }
  
  public void b(FrameFragment paramFrameFragment, String paramString) {}
  
  public void c(FrameFragment paramFrameFragment) {}
  
  public void d(FrameFragment paramFrameFragment) {}
  
  public boolean e(FrameFragment paramFrameFragment)
  {
    KDBottomTabThemeManager.a();
    return false;
  }
  
  public void f(FrameFragment paramFrameFragment) {}
  
  public void g(FrameFragment paramFrameFragment) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.RIJInjectImpl
 * JD-Core Version:    0.7.0.1
 */