package com.tencent.mobileqq.ecshop.widget;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.fragment.CommonHippyFragment;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.ad.EcshopAdHandler;
import com.tencent.mobileqq.ecshop.ad.IEcshopAdHandler.ReportInfo;
import com.tencent.mobileqq.ecshop.ad.api.IEcshopAdApi;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean.MenuConfBean;
import com.tencent.mobileqq.ecshop.conf.EcshopConfProcessor;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopMessageApi;
import com.tencent.mobileqq.ecshop.utils.AppUtils;
import com.tencent.mobileqq.ecshop.utils.EcshopUtils;
import com.tencent.mobileqq.ecshop.view.controller.TitleLayoutController;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/widget/QQShopPAHippyFragment2;", "Lcom/tencent/hippy/qq/fragment/CommonHippyFragment;", "()V", "hasRegist", "", "mExtiReceiver", "Landroid/content/BroadcastReceiver;", "needShowBubble", "redPointNum", "", "reportData", "", "", "titleLayout", "Landroid/widget/LinearLayout;", "titleLayoutController", "Lcom/tencent/mobileqq/ecshop/view/controller/TitleLayoutController;", "doBussinessInitData", "Lorg/json/JSONObject;", "jsInitData", "doReport", "", "getLastMsg", "Lcom/tencent/mobileqq/data/MessageRecord;", "getLayoutResId", "initIntent", "initTitleLayout", "initViews", "isWrapContent", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "updateTitleLayout", "params", "Lcom/tencent/mtt/hippy/common/HippyMap;", "Companion", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class QQShopPAHippyFragment2
  extends CommonHippyFragment
{
  public static final QQShopPAHippyFragment2.Companion a = new QQShopPAHippyFragment2.Companion(null);
  private LinearLayout b;
  private TitleLayoutController c;
  private final Map<String, String> d = (Map)new HashMap();
  private int e;
  private boolean f;
  private boolean g;
  private final BroadcastReceiver h = (BroadcastReceiver)new QQShopPAHippyFragment2.mExtiReceiver.1(this);
  private HashMap i;
  
  private final void b()
  {
    Object localObject = getArguments();
    boolean bool = false;
    int j;
    if (localObject != null) {
      j = ((Bundle)localObject).getInt("red_point_num", 0);
    } else {
      j = 0;
    }
    this.e = j;
    localObject = getArguments();
    if (localObject != null) {
      bool = ((Bundle)localObject).getBoolean("need_show_bubble", false);
    }
    this.f = bool;
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
  
  private final void c()
  {
    Object localObject1 = this.mRootView.findViewById(2131442501);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mRootView.findViewById(R…d.qq_shop_pa_hippy_title)");
    this.b = ((LinearLayout)localObject1);
    localObject1 = EcshopConfProcessor.a();
    if (localObject1 != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "EcshopConfProcessor.loadConfig() ?: return");
      int j = this.e;
      boolean bool2 = false;
      boolean bool1;
      if (j != 0)
      {
        localObject2 = ((EcshopConfBean)localObject1).l.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (EcshopConfBean.MenuConfBean)((Iterator)localObject2).next();
          if (((EcshopConfBean.MenuConfBean)localObject3).b == 1) {
            ((EcshopConfBean.MenuConfBean)localObject3).a = this.e;
          }
        }
        bool1 = true;
      }
      else
      {
        localObject2 = ((EcshopConfBean)localObject1).l.iterator();
        do
        {
          bool1 = bool2;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (EcshopConfBean.MenuConfBean)((Iterator)localObject2).next();
        } while (((EcshopConfBean.MenuConfBean)localObject3).b != 1);
        ((EcshopConfBean.MenuConfBean)localObject3).a = 0;
        bool1 = bool2;
      }
      Object localObject2 = this.b;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
      }
      Object localObject3 = getQBaseActivity();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "qBaseActivity");
      localObject2 = new TitleLayoutController((LinearLayout)localObject2, (Activity)localObject3, this.d);
      localObject1 = ((EcshopConfBean)localObject1).l;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "ecshopConfBean.menuConfs");
      ((TitleLayoutController)localObject2).a((List)localObject1, bool1, this.f);
      this.c = ((TitleLayoutController)localObject2);
    }
  }
  
  private final void d()
  {
    Object localObject1 = e();
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
        ((IEcshopAdHandler.ReportInfo)localObject2).a = 2;
        localObject2 = ((IEcshopAdApi)QRoute.api(IEcshopAdApi.class)).rebuildReportParam((IEcshopAdHandler.ReportInfo)localObject2, (MessageRecord)localObject1);
        localObject3 = AppUtils.a();
        if (localObject3 != null)
        {
          localObject3 = ((AppInterface)localObject3).getBusinessHandler(EcshopAdHandler.class.getName());
          if (localObject3 != null)
          {
            ((EcshopAdHandler)localObject3).a((IEcshopAdHandler.ReportInfo)localObject2, null);
            localObject2 = QRoute.api(IEcshopMessageApi.class);
            Intrinsics.checkExpressionValueIsNotNull(localObject2, "QRoute.api(IEcshopMessageApi::class.java)");
            localObject2 = (IEcshopMessageApi)localObject2;
            if (((IEcshopMessageApi)localObject2).isMessageForStructing((MessageRecord)localObject1)) {
              ((IEcshopMessageApi)localObject2).GdtC2SReportStructMsg((MessageRecord)localObject1, 1);
            } else if (((IEcshopMessageApi)localObject2).isMessageForArkApp((MessageRecord)localObject1)) {
              ((IEcshopMessageApi)localObject2).GdtC2SReportArkMsg((MessageRecord)localObject1, 1);
            }
          }
          else
          {
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.ecshop.ad.EcshopAdHandler");
          }
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        }
      }
    }
    this.d.put("pvsrc", "qqshophippy");
    localObject1 = getParameters();
    if (localObject1 != null)
    {
      localObject2 = (SerializableMap)((Bundle)localObject1).getSerializable("qqshopParams");
      if (localObject2 != null)
      {
        localObject1 = ((SerializableMap)localObject2).getMap().get("_origin");
        localObject3 = ((SerializableMap)localObject2).getMap().get("_source");
        localObject2 = this.d;
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
  
  private final MessageRecord e()
  {
    return ((IMessageFacade)AppUtils.a().getRuntimeService(IMessageFacade.class, "")).getLastMsgForMsgTab("3046055438", 1008);
  }
  
  public void a()
  {
    HashMap localHashMap = this.i;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public final void a(@NotNull HippyMap paramHippyMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    TitleLayoutController localTitleLayoutController = this.c;
    if (localTitleLayoutController != null) {
      localTitleLayoutController.a(paramHippyMap);
    }
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
    return 2131627835;
  }
  
  protected void initViews()
  {
    super.initViews();
    d();
    c();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    b();
    try
    {
      paramBundle = getActivity();
      if ((!this.g) && (paramBundle != null))
      {
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("com.tencent.mobileqq.qqshop.hidemsg");
        paramBundle.registerReceiver(this.h, (IntentFilter)localObject);
        this.g = true;
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
    Object localObject = this.c;
    if (localObject != null) {
      ((TitleLayoutController)localObject).a();
    }
    try
    {
      localObject = getActivity();
      if ((this.g) && (localObject != null))
      {
        ((FragmentActivity)localObject).unregisterReceiver(this.h);
        this.g = false;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.widget.QQShopPAHippyFragment2
 * JD-Core Version:    0.7.0.1
 */