package com.tencent.mobileqq.ecshop.view.controller;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.abtest.ABTestInfo;
import com.tencent.mobileqq.ecshop.abtest.ABTestUtil;
import com.tencent.mobileqq.ecshop.ad.EcshopAdHandler;
import com.tencent.mobileqq.ecshop.ad.IEcshopAdHandler.ReportInfo;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean;
import com.tencent.mobileqq.ecshop.conf.EcshopConfProcessor;
import com.tencent.mobileqq.ecshop.report.ReportUtil;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopMessageApi;
import com.tencent.mobileqq.ecshop.utils.AppUtils;
import com.tencent.mobileqq.ecshop.utils.EcshopUtils;
import com.tencent.mobileqq.ecshop.view.EcshopAdViewHelper.DeleteMsgListener;
import com.tencent.mobileqq.ecshop.view.adcard.AdCardController;
import com.tencent.mobileqq.ecshop.view.adcard.AdCardModel;
import com.tencent.mobileqq.ecshop.view.adcard.AdCardParseFactory;
import com.tencent.mobileqq.ecshop.view.hippy.QQShopHeaderView;
import com.tencent.mobileqq.ecshop.view.hippy.QQShopHeaderView.OnPageChangeListener;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ListUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/view/controller/AdHeaderController;", "", "headerView", "Lcom/tencent/mobileqq/ecshop/view/hippy/QQShopHeaderView;", "reportData", "", "", "(Lcom/tencent/mobileqq/ecshop/view/hippy/QQShopHeaderView;Ljava/util/Map;)V", "adStyle", "mAdCardList", "", "Landroid/view/View;", "mAdCardModel", "Lcom/tencent/mobileqq/ecshop/view/adcard/AdCardModel;", "mAdMessage", "Lcom/tencent/mobileqq/data/MessageRecord;", "mItemHeight", "", "mItemImageHeight", "mItemWidth", "rootLayout", "Landroid/widget/LinearLayout;", "selectItem", "addAdCardViews", "", "doReportShow", "position", "getItemHeight", "adCardType", "getItemImageHeight", "getItemWidth", "getMsgList", "", "initMsgData", "msgList", "needAddMsg", "", "message", "setViewGone", "updateMsgData", "Companion", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class AdHeaderController
{
  public static final AdHeaderController.Companion a = new AdHeaderController.Companion(null);
  private final LinearLayout b;
  private final String c;
  private final List<View> d;
  private final List<MessageRecord> e;
  private final List<AdCardModel> f;
  private final int g;
  private final int h;
  private final int i;
  private int j;
  private final QQShopHeaderView k;
  private final Map<String, String> l;
  
  public AdHeaderController(@NotNull QQShopHeaderView paramQQShopHeaderView, @NotNull Map<String, String> paramMap)
  {
    this.k = paramQQShopHeaderView;
    this.l = paramMap;
    paramQQShopHeaderView = this.k.findViewById(2131442499);
    Intrinsics.checkExpressionValueIsNotNull(paramQQShopHeaderView, "headerView.findViewById(…op_pa_header_root_layout)");
    this.b = ((LinearLayout)paramQQShopHeaderView);
    paramQQShopHeaderView = ABTestUtil.b("expQQShopPageStyleV2");
    if (paramQQShopHeaderView != null)
    {
      paramQQShopHeaderView = paramQQShopHeaderView.a("adStyle", "big");
      if (paramQQShopHeaderView != null) {}
    }
    else
    {
      paramQQShopHeaderView = "big";
    }
    this.c = paramQQShopHeaderView;
    this.d = ((List)new ArrayList());
    this.e = ((List)new ArrayList());
    this.f = ((List)new ArrayList());
    this.g = f();
    this.h = e();
    this.i = a(this.c);
    paramQQShopHeaderView = d();
    if (ListUtils.a((Collection)paramQQShopHeaderView))
    {
      a();
    }
    else
    {
      paramMap = new StringBuilder();
      paramMap.append("init msgList.size = ");
      paramMap.append(paramQQShopHeaderView.size());
      QLog.d("AdHeaderController", 1, paramMap.toString());
      a(paramQQShopHeaderView);
    }
    this.k.a(this.g + ViewUtils.dip2px(5.0F), (QQShopHeaderView.OnPageChangeListener)new AdHeaderController.1(this));
    paramQQShopHeaderView = this.b;
    if ((this.k.getVisibility() == 0) && ((((Collection)this.d).isEmpty() ^ true)) && ((((Collection)this.e).isEmpty() ^ true)))
    {
      paramMap = paramQQShopHeaderView.getLayoutParams();
      if (paramMap != null) {
        paramMap.height = this.i;
      }
      paramQQShopHeaderView.setPadding(ViewUtils.dip2px(12.5F), 0, ViewUtils.dip2px(12.5F), 0);
      c();
      a(0);
    }
  }
  
  private final int a(String paramString)
  {
    int m = e();
    float f1;
    if (Intrinsics.areEqual("small", paramString)) {
      f1 = 57.0F;
    } else {
      f1 = 124.0F;
    }
    return m + ViewUtils.dip2px(f1);
  }
  
  private final void a()
  {
    this.k.setVisibility(8);
    this.b.setVisibility(8);
    this.b.getContext().sendBroadcast(new Intent("com.tencent.mobileqq.qqshop.hidemsg"));
  }
  
  private final void a(int paramInt)
  {
    Object localObject1 = new IEcshopAdHandler.ReportInfo();
    ((IEcshopAdHandler.ReportInfo)localObject1).a = 10;
    localObject1 = EcshopAdHandler.a((IEcshopAdHandler.ReportInfo)localObject1, (MessageRecord)this.e.get(paramInt));
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "EcshopAdHandler.rebuildR…fo, mAdMessage[position])");
    Object localObject2 = AppUtils.a();
    if (localObject2 != null)
    {
      localObject2 = ((AppInterface)localObject2).getBusinessHandler(EcshopAdHandler.class.getName());
      if (localObject2 != null)
      {
        ((EcshopAdHandler)localObject2).a((IEcshopAdHandler.ReportInfo)localObject1, null);
        String str = ((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).getLastMsgType((MessageRecord)this.e.get(paramInt));
        localObject1 = ((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).getAdInfoByChatMessage((MessageRecord)this.e.get(paramInt));
        if (localObject1 != null)
        {
          localObject1 = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info;
          if (localObject1 != null)
          {
            localObject1 = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).trace_info;
            if (localObject1 != null)
            {
              localObject1 = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject1).aid;
              if (localObject1 != null)
              {
                l1 = ((PBUInt64Field)localObject1).get();
                break label196;
              }
            }
          }
        }
        long l1 = 0L;
        label196:
        if (this.l.get("pvsrc") != null) {
          localObject1 = (String)this.l.get("pvsrc");
        } else {
          localObject1 = "";
        }
        if (this.l.get("ext10") != null) {
          localObject2 = (String)this.l.get("ext10");
        } else {
          localObject2 = "";
        }
        ReportUtil.a("qgg_pushcard_show", String.valueOf(paramInt), String.valueOf(NetConnInfoCenter.getServerTimeMillis()), String.valueOf(l1), (String)localObject1, (String)localObject2, str);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.ecshop.ad.EcshopAdHandler");
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.common.app.AppInterface");
  }
  
  private final void a(List<? extends MessageRecord> paramList)
  {
    this.d.clear();
    this.e.clear();
    this.f.clear();
    Object localObject1 = QRoute.api(IEcshopMessageApi.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "QRoute.api(IEcshopMessageApi::class.java)");
    localObject1 = (IEcshopMessageApi)localObject1;
    Object localObject2 = EcshopConfProcessor.a();
    int m;
    if (localObject2 != null) {
      m = ((EcshopConfBean)localObject2).j;
    } else {
      m = 2;
    }
    int n = paramList.size() - 1;
    while ((n >= 0) && (this.d.size() < m))
    {
      localObject2 = (MessageRecord)paramList.get(n);
      Object localObject3 = ((IEcshopMessageApi)localObject1).getAdInfoByChatMessage((MessageRecord)localObject2);
      if ((localObject2 != null) && (a((MessageRecord)localObject2)))
      {
        localObject3 = AdCardParseFactory.a.a((qq_ad_get.QQAdGetRsp.AdInfo)localObject3, (MessageRecord)localObject2);
        if (!TextUtils.isEmpty((CharSequence)((AdCardModel)localObject3).b()))
        {
          Object localObject4 = new AdCardController((AdCardModel)localObject3, (ViewGroup)this.b, this.g, this.h, this.c, this.d.size(), this.l);
          if (((AdCardModel)localObject3).j())
          {
            ((AdCardModel)localObject3).a((EcshopAdViewHelper.DeleteMsgListener)new AdHeaderController.initMsgData..inlined.apply.lambda.1(this, (AdCardModel)localObject3, paramList, (IEcshopMessageApi)localObject1));
            ((AdCardController)localObject4).a().setVisibility(0);
            ((AdCardController)localObject4).a().setOnClickListener((View.OnClickListener)new AdHeaderController.initMsgData..inlined.apply.lambda.2((AdCardController)localObject4, this, (AdCardModel)localObject3, paramList, (IEcshopMessageApi)localObject1));
          }
          else
          {
            ((AdCardController)localObject4).a().setVisibility(8);
          }
          localObject4 = ((AdCardController)localObject4).b();
          EcshopAdHandler.a((AppInterface)AppUtils.a(), (ChatMessage)localObject2, (View)localObject4);
          this.d.add(localObject4);
          this.e.add(localObject2);
          this.f.add(localObject3);
        }
      }
      n -= 1;
    }
    if (this.d.size() != 0)
    {
      paramList = new MoreCardController((ViewGroup)this.b, this.c, this.g);
      this.d.add(paramList.a());
      return;
    }
    a();
  }
  
  private final boolean a(MessageRecord paramMessageRecord)
  {
    int m;
    try
    {
      String str = ((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).getLastMsgType(paramMessageRecord);
      Intrinsics.checkExpressionValueIsNotNull(str, "QRoute.api(IEcshopMessag…).getLastMsgType(message)");
      m = Integer.parseInt(str);
    }
    catch (Exception localException)
    {
      QLog.e("AdHeaderController", 1, (Throwable)localException, new Object[0]);
      m = 0;
    }
    return (EcshopUtils.d(paramMessageRecord) != 1) && (m < 102);
  }
  
  private final void b()
  {
    List localList = d();
    if (ListUtils.a((Collection)localList))
    {
      a();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("update msgList.size = ");
    localStringBuilder.append(localList.size());
    QLog.d("AdHeaderController", 1, localStringBuilder.toString());
    a(localList);
    this.j = 0;
    this.k.a(this.j);
    c();
    a(0);
  }
  
  private final void c()
  {
    this.b.removeAllViews();
    if (((((Collection)this.e).isEmpty() ^ true)) && ((((Collection)this.d).isEmpty() ^ true)))
    {
      int m = ViewUtils.dip2px(2.5F);
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        View localView = (View)localIterator.next();
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.g, this.i);
        localLayoutParams.setMargins(m, 0, m, 0);
        this.b.addView(localView, (ViewGroup.LayoutParams)localLayoutParams);
      }
      this.k.a();
    }
  }
  
  private final List<MessageRecord> d()
  {
    List localList = ((IMessageFacade)AppUtils.a().getRuntimeService(IMessageFacade.class, "")).getAIOList("3046055438", 1008);
    Intrinsics.checkExpressionValueIsNotNull(localList, "getAppRunTime().getRunti….UIN_TYPE_PUBLIC_ACCOUNT)");
    return localList;
  }
  
  private final int e()
  {
    return (int)(f() * 0.56F);
  }
  
  private final int f()
  {
    Object localObject = this.b.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "rootLayout.context");
    localObject = ((Context)localObject).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "rootLayout.context.resources");
    return ((Resources)localObject).getDisplayMetrics().widthPixels - ViewUtils.dip2px(30.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.controller.AdHeaderController
 * JD-Core Version:    0.7.0.1
 */