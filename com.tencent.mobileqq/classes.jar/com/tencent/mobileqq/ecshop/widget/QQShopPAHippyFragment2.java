package com.tencent.mobileqq.ecshop.widget;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.fragment.CommonHippyFragment;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.ad.EcshopAdHandler;
import com.tencent.mobileqq.ecshop.ad.IEcshopAdHandler.ReportInfo;
import com.tencent.mobileqq.ecshop.ad.api.IEcshopAdApi;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean;
import com.tencent.mobileqq.ecshop.conf.EcshopConfProcessor;
import com.tencent.mobileqq.ecshop.utils.AppUtils;
import com.tencent.mobileqq.ecshop.utils.EcshopUtils;
import com.tencent.mobileqq.ecshop.view.controller.AdViewPagerController;
import com.tencent.mobileqq.ecshop.view.controller.TitleLayoutController;
import com.tencent.mobileqq.ecshop.view.hippy.QQShopHeaderView;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.views.list.HippyListView;
import com.tencent.mtt.supportui.views.recyclerview.LinearLayoutManager;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/widget/QQShopPAHippyFragment2;", "Lcom/tencent/hippy/qq/fragment/CommonHippyFragment;", "()V", "hasRegist", "", "headPosition", "", "headerView", "Landroid/view/ViewGroup;", "isNeedSetHeadScrollWithHippy", "mExtiReceiver", "Landroid/content/BroadcastReceiver;", "needAddHeight", "reportData", "", "", "titleLayout", "Landroid/widget/LinearLayout;", "titleLayoutController", "Lcom/tencent/mobileqq/ecshop/view/controller/TitleLayoutController;", "trySetHeadTime", "getTrySetHeadTime", "()I", "setTrySetHeadTime", "(I)V", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "doBussinessInitData", "Lorg/json/JSONObject;", "jsInitData", "doHippyScrollWithHead", "", "doReport", "getAllChildViews", "", "Landroid/view/View;", "view", "getLastMsg", "Lcom/tencent/mobileqq/data/MessageRecord;", "getLayoutResId", "getScollYDistance", "listView", "Lcom/tencent/mtt/hippy/views/list/HippyListView;", "position", "getSetHeadDelay", "", "initIntent", "initTitleLayout", "initViewPager", "initViews", "isQQShopHeadAdd", "hippyListView", "isWrapContent", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onLoadHippySuccess", "updateTitleLayout", "params", "Lcom/tencent/mtt/hippy/common/HippyMap;", "Companion", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class QQShopPAHippyFragment2
  extends CommonHippyFragment
{
  public static final QQShopPAHippyFragment2.Companion a;
  private int jdField_a_of_type_Int;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = (BroadcastReceiver)new QQShopPAHippyFragment2.mExtiReceiver.1(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ViewPager jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
  private TitleLayoutController jdField_a_of_type_ComTencentMobileqqEcshopViewControllerTitleLayoutController;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private final Map<String, String> jdField_a_of_type_JavaUtilMap = (Map)new HashMap();
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqEcshopWidgetQQShopPAHippyFragment2$Companion = new QQShopPAHippyFragment2.Companion(null);
  }
  
  private final MessageRecord a()
  {
    return ((IMessageFacade)AppUtils.a().getRuntimeService(IMessageFacade.class, "")).getLastMsgForMsgTab("3046055438", 1008);
  }
  
  private final List<View> a(View paramView)
  {
    List localList = (List)new ArrayList();
    if ((paramView instanceof ViewGroup))
    {
      int i = 0;
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      while (i < j)
      {
        View localView = paramView.getChildAt(i);
        Intrinsics.checkExpressionValueIsNotNull(localView, "viewchild");
        localList.add(localView);
        localList.addAll((Collection)a(localView));
        i += 1;
      }
    }
    return localList;
  }
  
  private final void b()
  {
    Object localObject = LayoutInflater.from((Context)getQBaseActivity()).inflate(2131561478, this.mRootView, false);
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject);
      localObject = this.jdField_a_of_type_AndroidViewViewGroup;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("headerView");
      }
      localObject = ((ViewGroup)localObject).findViewById(2131374336);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "headerView.findViewById(…shop_pa_header_viewpager)");
      this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager = ((ViewPager)localObject);
      localObject = this.jdField_a_of_type_AndroidViewViewGroup;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("headerView");
      }
      new AdViewPagerController((ViewGroup)localObject, this.jdField_a_of_type_JavaUtilMap);
      localObject = this.jdField_a_of_type_AndroidViewViewGroup;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("headerView");
      }
      ((ViewGroup)localObject).setVisibility(8);
      localObject = this.mRootView;
      ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
      if (localViewGroup == null) {
        Intrinsics.throwUninitializedPropertyAccessException("headerView");
      }
      ((ViewGroup)localObject).addView((View)localViewGroup);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
  }
  
  private final void c()
  {
    Object localObject = getArguments();
    boolean bool = true;
    if (localObject != null) {
      bool = ((Bundle)localObject).getBoolean("show_shop_header", true);
    }
    this.jdField_a_of_type_Boolean = bool;
    localObject = AppUtils.a();
    if (localObject != null)
    {
      localObject = (EcshopAdHandler)((AppInterface)localObject).getBusinessHandler(EcshopAdHandler.class.getName());
      if (localObject != null) {
        ((EcshopAdHandler)localObject).a(null, null, false, null, 2);
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.common.app.AppInterface");
  }
  
  private final void d()
  {
    Object localObject1 = this.mRootView.findViewById(2131374338);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mRootView.findViewById(R…d.qq_shop_pa_hippy_title)");
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localObject1);
    localObject1 = EcshopConfProcessor.a();
    if (localObject1 != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "EcshopConfProcessor.loadConfig() ?: return");
      Object localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
      }
      QBaseActivity localQBaseActivity = getQBaseActivity();
      Intrinsics.checkExpressionValueIsNotNull(localQBaseActivity, "qBaseActivity");
      localObject2 = new TitleLayoutController((LinearLayout)localObject2, (Activity)localQBaseActivity, this.jdField_a_of_type_JavaUtilMap);
      localObject1 = ((EcshopConfBean)localObject1).b;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "ecshopConfBean.menuConfs");
      ((TitleLayoutController)localObject2).a((List)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqEcshopViewControllerTitleLayoutController = ((TitleLayoutController)localObject2);
    }
  }
  
  private final void e()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("isSetHeadScrollWithHippy=");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_Boolean);
    ((StringBuilder)localObject1).append(", setHeadTime= ");
    ((StringBuilder)localObject1).append(this.c);
    QLog.d("QQShopPAHippyFragment2", 1, ((StringBuilder)localObject1).toString());
    localObject1 = a(this.mRootView.findViewById(2131368190)).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (View)((Iterator)localObject1).next();
      if ((localObject3 instanceof HippyListView))
      {
        localObject1 = (HippyListView)localObject3;
        if (a((HippyListView)localObject1))
        {
          this.jdField_a_of_type_Boolean = false;
          ((HippyListView)localObject1).setMomentumScrollBeginEventEnable(false);
          ((HippyListView)localObject1).addOnListScrollListener((RecyclerView.OnListScrollListener)new QQShopPAHippyFragment2.doHippyScrollWithHead.1(this, (View)localObject3));
          Object localObject2 = new int[2];
          ((View)localObject3).getLocationInWindow((int[])localObject2);
          localObject3 = this.jdField_a_of_type_AndroidViewViewGroup;
          if (localObject3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerView");
          }
          localObject3 = ((ViewGroup)localObject3).getLayoutParams();
          if (localObject3 != null)
          {
            ((RelativeLayout.LayoutParams)localObject3).setMargins(0, localObject2[1], 0, 0);
            localObject2 = this.jdField_a_of_type_AndroidViewViewGroup;
            if (localObject2 == null) {
              Intrinsics.throwUninitializedPropertyAccessException("headerView");
            }
            ((ViewGroup)localObject2).bringToFront();
            localObject2 = this.jdField_a_of_type_AndroidViewViewGroup;
            if (localObject2 == null) {
              Intrinsics.throwUninitializedPropertyAccessException("headerView");
            }
            ((ViewGroup)localObject2).setVisibility(0);
            int i = a((HippyListView)localObject1, this.jdField_b_of_type_Int);
            localObject1 = this.jdField_a_of_type_AndroidViewViewGroup;
            if (localObject1 == null) {
              Intrinsics.throwUninitializedPropertyAccessException("headerView");
            }
            ((ViewGroup)localObject1).scrollTo(0, i);
            localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
            if (localObject1 == null) {
              Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            }
            ((LinearLayout)localObject1).bringToFront();
          }
          else
          {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          }
        }
      }
    }
    QLog.d("QQShopPAHippyFragment2", 1, "set Head Scrol lWith Hippy");
    if (this.jdField_a_of_type_Boolean)
    {
      long l = a();
      if (l != -1L) {
        ThreadManagerV2.getUIHandlerV2().postDelayed((Runnable)new QQShopPAHippyFragment2.doHippyScrollWithHead.2(this), l);
      }
    }
  }
  
  private final void f()
  {
    Object localObject1 = a();
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = ((MessageRecord)localObject1).getExtInfoFromExtStr("public_account_msg_id");
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "lastMsg.getExtInfoFromEx…(\"public_account_msg_id\")");
      localObject3 = ((MessageRecord)localObject1).getExtInfoFromExtStr("is_AdArrive_Msg");
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "lastMsg.getExtInfoFromExtStr(\"is_AdArrive_Msg\")");
      if (QLog.isColorLevel())
      {
        String str = getTag();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("enter qqgouwu aio msgId = ");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(" hasAdver: ");
        localStringBuilder.append((String)localObject3);
        QLog.i(str, 2, localStringBuilder.toString());
      }
      if (Intrinsics.areEqual("1", localObject3))
      {
        localObject2 = new IEcshopAdHandler.ReportInfo();
        ((IEcshopAdHandler.ReportInfo)localObject2).jdField_a_of_type_Int = 2;
        localObject1 = ((IEcshopAdApi)QRoute.api(IEcshopAdApi.class)).rebuildReportParam((IEcshopAdHandler.ReportInfo)localObject2, (MessageRecord)localObject1);
        localObject2 = AppUtils.a();
        if (localObject2 != null)
        {
          localObject2 = ((AppInterface)localObject2).getBusinessHandler(EcshopAdHandler.class.getName());
          if (localObject2 != null) {
            ((EcshopAdHandler)localObject2).a((IEcshopAdHandler.ReportInfo)localObject1, null);
          } else {
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.ecshop.ad.EcshopAdHandler");
          }
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        }
      }
    }
    this.jdField_a_of_type_JavaUtilMap.put("pvsrc", "qqshophippy");
    localObject1 = getParameters();
    if (localObject1 != null)
    {
      localObject2 = (SerializableMap)((Bundle)localObject1).getSerializable("qqshopParams");
      if (localObject2 != null)
      {
        localObject1 = ((SerializableMap)localObject2).getMap().get("_origin");
        localObject3 = ((SerializableMap)localObject2).getMap().get("_source");
        localObject2 = this.jdField_a_of_type_JavaUtilMap;
        if (localObject1 != null)
        {
          localObject1 = localObject1.toString();
          if (localObject1 != null) {}
        }
        else if (localObject3 != null)
        {
          localObject1 = localObject3.toString();
          if (localObject1 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        ((Map)localObject2).put("ext10", localObject1);
      }
    }
  }
  
  public final int a(@NotNull HippyListView paramHippyListView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyListView, "listView");
    paramHippyListView = paramHippyListView.getLayoutManager();
    if (paramHippyListView != null)
    {
      paramHippyListView = ((LinearLayoutManager)paramHippyListView).findViewByPosition(paramInt);
      if (paramHippyListView != null) {
        paramInt = paramHippyListView.getTop();
      } else {
        paramInt = 0;
      }
      return 0 - paramInt - this.jdField_a_of_type_Int;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mtt.supportui.views.recyclerview.LinearLayoutManager");
  }
  
  public final long a()
  {
    int i = this.c;
    if (i < 10) {
      i = 200;
    } else if (i < 6) {
      i = 500;
    } else if (i < 5) {
      i = 1000;
    } else {
      i = -1;
    }
    this.c += 1;
    return i;
  }
  
  public void a()
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public final void a(@NotNull HippyMap paramHippyMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    TitleLayoutController localTitleLayoutController = this.jdField_a_of_type_ComTencentMobileqqEcshopViewControllerTitleLayoutController;
    if (localTitleLayoutController != null) {
      localTitleLayoutController.a(paramHippyMap);
    }
  }
  
  public final boolean a(@NotNull HippyListView paramHippyListView)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyListView, "hippyListView");
    int j = paramHippyListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_Int = 0;
      View localView = paramHippyListView.getChildAt(i);
      Object localObject = localView;
      if ((localView instanceof QQShopHeaderView))
      {
        this.jdField_a_of_type_Int = ((QQShopHeaderView)localView).getTop();
        this.jdField_b_of_type_Int = i;
        return true;
      }
      while ((localObject instanceof ViewGroup))
      {
        localObject = (ViewGroup)localObject;
        if (((ViewGroup)localObject).getChildCount() != 0)
        {
          this.jdField_a_of_type_Int += ((ViewGroup)localObject).getTop();
          localView = ((ViewGroup)localObject).getChildAt(0);
          localObject = localView;
          if ((localView instanceof QQShopHeaderView))
          {
            this.jdField_a_of_type_Int += ((QQShopHeaderView)localView).getTop();
            this.jdField_b_of_type_Int = i;
            return true;
          }
        }
      }
      i += 1;
    }
    this.jdField_a_of_type_Int = 0;
    return false;
  }
  
  @NotNull
  protected JSONObject doBussinessInitData(@Nullable JSONObject paramJSONObject)
  {
    paramJSONObject = super.doBussinessInitData(paramJSONObject);
    if (paramJSONObject == null) {
      paramJSONObject = new JSONObject();
    }
    Object localObject = getParameters();
    if (localObject != null)
    {
      SerializableMap localSerializableMap = (SerializableMap)((Bundle)localObject).getSerializable("qqshopParams");
      if (localSerializableMap != null)
      {
        localObject = localSerializableMap.getMap();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "map");
        Map localMap = (Map)localObject;
        if (EcshopUtils.a("3046055438")) {
          localObject = "1";
        } else {
          localObject = "0";
        }
        localMap.put("isFollowed", localObject);
        paramJSONObject.put("qqshopParams", ((IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class)).wrapHashMap(null, localSerializableMap.getMap()));
      }
    }
    return paramJSONObject;
  }
  
  protected int getLayoutResId()
  {
    return 2131561477;
  }
  
  protected void initViews()
  {
    super.initViews();
    f();
    d();
    b();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    c();
    try
    {
      paramBundle = getActivity();
      if ((!this.jdField_b_of_type_Boolean) && (paramBundle != null))
      {
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("com.tencent.mobileqq.qqshop.hidemsg");
        paramBundle.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
        this.jdField_b_of_type_Boolean = true;
        return;
      }
    }
    catch (Throwable paramBundle)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onCreate] regist exitreceiver fail ");
      ((StringBuilder)localObject).append(paramBundle);
      QLog.e("QQShopPAHippyFragment2", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      FragmentActivity localFragmentActivity = getActivity();
      if ((this.jdField_b_of_type_Boolean) && (localFragmentActivity != null))
      {
        localFragmentActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_b_of_type_Boolean = false;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  protected void onLoadHippySuccess()
  {
    super.onLoadHippySuccess();
    if (this.jdField_a_of_type_Boolean) {
      ThreadManagerV2.getUIHandlerV2().postDelayed((Runnable)new QQShopPAHippyFragment2.onLoadHippySuccess.1(this), 200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.widget.QQShopPAHippyFragment2
 * JD-Core Version:    0.7.0.1
 */