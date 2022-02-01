package com.tencent.mobileqq.ecshop.view.controller;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean.TabConfBean;
import com.tencent.mobileqq.ecshop.redpoint.QQShopRedPointUtil;
import com.tencent.mobileqq.ecshop.redpoint.RedPointInfo;
import com.tencent.mobileqq.ecshop.report.ReportUtil;
import com.tencent.mobileqq.ecshop.widget.PageSwitchUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/view/controller/TabLayoutController;", "", "customTabLayout", "Landroid/widget/LinearLayout;", "(Landroid/widget/LinearLayout;)V", "TAG", "", "currentTabId", "", "currentTime", "", "hasHippyPage", "", "tabSwitchListeners", "", "Lkotlin/Function1;", "", "viewHolders", "Lcom/tencent/mobileqq/ecshop/view/controller/TabItemController;", "goToTabPage", "tabConfBean", "Lcom/tencent/mobileqq/ecshop/conf/EcshopConfBean$TabConfBean;", "initTabLayout", "tabConfBeans", "", "tabBackground", "setTabLayoutVisibility", "isSelected", "setTabSwitchListener", "tabId", "tabSwitchListener", "showRedPoint", "redPointInfos", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/ecshop/redpoint/RedPointInfo;", "Lkotlin/collections/ArrayList;", "updateAllTabStatus", "initNightTheme", "setOnClickListener", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class TabLayoutController
{
  private final String a;
  private Map<Integer, TabItemController> b;
  private final Map<Integer, Function1<Integer, Unit>> c;
  private int d;
  private long e;
  private boolean f;
  private final LinearLayout g;
  
  public TabLayoutController(@NotNull LinearLayout paramLinearLayout)
  {
    this.g = paramLinearLayout;
    this.a = "TabLayoutController";
    this.b = ((Map)new HashMap());
    this.c = ((Map)new HashMap());
    this.e = NetConnInfoCenter.getServerTime();
  }
  
  private final void a(EcshopConfBean.TabConfBean paramTabConfBean)
  {
    Object localObject1 = this.g.getContext();
    int i = paramTabConfBean.i;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          localObject2 = PageSwitchUtil.a;
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "context");
          ((PageSwitchUtil)localObject2).b((Context)localObject1, paramTabConfBean.b, paramTabConfBean.d);
          return;
        }
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp((Context)localObject1, ReportUtil.a(paramTabConfBean.d, "tab"), 1035, (MiniAppLaunchListener)new TabLayoutController.goToTabPage.1(this));
        return;
      }
      if (paramTabConfBean.b == 1)
      {
        paramTabConfBean = PageSwitchUtil.a;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "context");
        paramTabConfBean.a((Context)localObject1, this.f);
        return;
      }
      localObject1 = this.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("can't match tabId: ");
      ((StringBuilder)localObject2).append(paramTabConfBean.b);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      return;
    }
    Object localObject2 = PageSwitchUtil.a;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "context");
    ((PageSwitchUtil)localObject2).a((Context)localObject1, paramTabConfBean.b, paramTabConfBean.d);
  }
  
  private final void a(@NotNull TabItemController paramTabItemController, EcshopConfBean.TabConfBean paramTabConfBean)
  {
    paramTabItemController.a().setOnClickListener((View.OnClickListener)new TabLayoutController.setOnClickListener.1(this, paramTabItemController, paramTabConfBean));
  }
  
  public final void a(int paramInt)
  {
    Object localObject = this.b.entrySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((TabItemController)((Map.Entry)((Iterator)localObject).next()).getValue()).a(false);
    }
    this.d = paramInt;
    localObject = (TabItemController)this.b.get(Integer.valueOf(paramInt));
    if (localObject != null) {
      ((TabItemController)localObject).a(true);
    }
  }
  
  public final void a(int paramInt, @NotNull Function1<? super Integer, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "tabSwitchListener");
    this.c.put(Integer.valueOf(paramInt), paramFunction1);
  }
  
  public final void a(@Nullable ArrayList<RedPointInfo> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return;
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        RedPointInfo localRedPointInfo = (RedPointInfo)paramArrayList.next();
        Object localObject = QQShopRedPointUtil.a;
        Intrinsics.checkExpressionValueIsNotNull(localRedPointInfo, "redPointInfo");
        if (((QQShopRedPointUtil)localObject).a(localRedPointInfo, this.d, this.e))
        {
          long l = QQShopRedPointUtil.a.a(localRedPointInfo, this.e);
          localObject = (TabItemController)this.b.get(Integer.valueOf(localRedPointInfo.mTabId));
          if (localObject != null) {
            ((TabItemController)localObject).a(localRedPointInfo, l);
          }
        }
      }
    }
  }
  
  public final void a(@NotNull List<? extends EcshopConfBean.TabConfBean> paramList, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "tabConfBeans");
    Intrinsics.checkParameterIsNotNull(paramString, "tabBackground");
    this.g.setBackgroundColor(Color.parseColor(paramString));
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramString = (EcshopConfBean.TabConfBean)paramList.next();
      TabItemController localTabItemController = new TabItemController(paramString, (ViewGroup)this.g);
      ReportUtil.a("gouwu.tab.show", String.valueOf(paramString.b), String.valueOf(NetConnInfoCenter.getServerTimeMillis()), "", this.d);
      ReportUtil.b("gouwu_tab_show", String.valueOf(paramString.b), String.valueOf(NetConnInfoCenter.getServerTimeMillis()), "", this.d);
      a(localTabItemController, paramString);
      this.b.put(Integer.valueOf(paramString.b), localTabItemController);
      this.g.addView(localTabItemController.a());
      if (paramString.i == 3) {
        this.f = true;
      }
    }
    paramList = this.g;
    paramList.setWeightSum(paramList.getChildCount());
  }
  
  public final void a(boolean paramBoolean)
  {
    LinearLayout localLinearLayout = this.g;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localLinearLayout.setVisibility(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.controller.TabLayoutController
 * JD-Core Version:    0.7.0.1
 */