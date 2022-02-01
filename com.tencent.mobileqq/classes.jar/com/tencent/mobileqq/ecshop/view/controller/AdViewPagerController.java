package com.tencent.mobileqq.ecshop.view.controller;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
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
import com.tencent.mobileqq.ecshop.view.adcard.AdCardPageAdapter;
import com.tencent.mobileqq.ecshop.view.adcard.AdCardParseFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ListUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/view/controller/AdViewPagerController;", "", "headerView", "Landroid/view/ViewGroup;", "reportData", "", "", "(Landroid/view/ViewGroup;Ljava/util/Map;)V", "adStyle", "headerBack", "Landroid/widget/ImageView;", "mAdCardList", "", "Landroid/view/View;", "mAdCardModel", "Lcom/tencent/mobileqq/ecshop/view/adcard/AdCardModel;", "mAdMessage", "Lcom/tencent/mobileqq/data/MessageRecord;", "mItemHeight", "", "mItemImageHeight", "selectItem", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "doReportShow", "", "position", "getItemHeight", "adCardType", "getItemImageHeight", "getItemImageWidth", "getMsgList", "", "initMsgData", "msgList", "needAddMsg", "", "message", "setViewGone", "updateMsgData", "Companion", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class AdViewPagerController
{
  public static final AdViewPagerController.Companion a;
  private final int jdField_a_of_type_Int;
  private final ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private final ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final ViewPager jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
  private final String jdField_a_of_type_JavaLangString;
  private final List<View> jdField_a_of_type_JavaUtilList;
  private final Map<String, String> jdField_a_of_type_JavaUtilMap;
  private final int jdField_b_of_type_Int;
  private final List<MessageRecord> jdField_b_of_type_JavaUtilList;
  private int jdField_c_of_type_Int;
  private final List<AdCardModel> jdField_c_of_type_JavaUtilList;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqEcshopViewControllerAdViewPagerController$Companion = new AdViewPagerController.Companion(null);
  }
  
  public AdViewPagerController(@NotNull ViewGroup paramViewGroup, @NotNull Map<String, String> paramMap)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    paramViewGroup = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374336);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "headerView.findViewById(…shop_pa_header_viewpager)");
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager = ((ViewPager)paramViewGroup);
    paramViewGroup = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374335);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "headerView.findViewById(R.id.qq_shop_pa_header_bg)");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup);
    paramViewGroup = ABTestUtil.a("expQQShopPageStyle");
    if (paramViewGroup != null)
    {
      paramViewGroup = paramViewGroup.a("adStyle", "big");
      if (paramViewGroup != null) {}
    }
    else
    {
      paramViewGroup = "big";
    }
    this.jdField_a_of_type_JavaLangString = paramViewGroup;
    this.jdField_a_of_type_JavaUtilList = ((List)new ArrayList());
    this.jdField_b_of_type_JavaUtilList = ((List)new ArrayList());
    this.jdField_c_of_type_JavaUtilList = ((List)new ArrayList());
    this.jdField_a_of_type_Int = a();
    this.jdField_b_of_type_Int = a(this.jdField_a_of_type_JavaLangString);
    paramViewGroup = a();
    if (ListUtils.a((Collection)paramViewGroup))
    {
      a();
    }
    else
    {
      paramMap = new StringBuilder();
      paramMap.append("init msgList.size = ");
      paramMap.append(paramViewGroup.size());
      QLog.d("AdViewPagerController", 1, paramMap.toString());
      a(paramViewGroup);
    }
    paramViewGroup = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
    if ((this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0) && ((((Collection)this.jdField_a_of_type_JavaUtilList).isEmpty() ^ true)) && ((((Collection)this.jdField_b_of_type_JavaUtilList).isEmpty() ^ true)))
    {
      paramMap = paramViewGroup.getLayoutParams();
      if (paramMap != null) {
        paramMap.height = this.jdField_b_of_type_Int;
      }
      paramMap = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      if (paramMap != null) {
        paramMap.height = (this.jdField_b_of_type_Int + ViewUtils.a(15.0F));
      }
      paramViewGroup.setPadding(ViewUtils.a(15.0F), 0, ViewUtils.a(15.0F), 0);
      paramViewGroup.setAdapter((PagerAdapter)new AdCardPageAdapter(this.jdField_a_of_type_JavaUtilList));
      paramViewGroup.setPageMargin(ViewUtils.a(5.0F));
      paramViewGroup.addOnPageChangeListener((ViewPager.OnPageChangeListener)new AdViewPagerController..special..inlined.apply.lambda.1(paramViewGroup, this));
      a(0);
    }
  }
  
  private final int a()
  {
    return (int)(b() * 0.56F);
  }
  
  private final int a(String paramString)
  {
    int i = a();
    float f;
    if (Intrinsics.areEqual("small", paramString)) {
      f = 57.0F;
    } else {
      f = 145.0F;
    }
    return i + ViewUtils.a(f);
  }
  
  private final List<MessageRecord> a()
  {
    List localList = ((IMessageFacade)AppUtils.a().getRuntimeService(IMessageFacade.class, "")).getAIOList("3046055438", 1008);
    Intrinsics.checkExpressionValueIsNotNull(localList, "getAppRunTime().getRunti….UIN_TYPE_PUBLIC_ACCOUNT)");
    return localList;
  }
  
  private final void a()
  {
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.getContext().sendBroadcast(new Intent("com.tencent.mobileqq.qqshop.hidemsg"));
  }
  
  private final void a(int paramInt)
  {
    Object localObject1 = new IEcshopAdHandler.ReportInfo();
    ((IEcshopAdHandler.ReportInfo)localObject1).jdField_a_of_type_Int = 10;
    localObject1 = EcshopAdHandler.a((IEcshopAdHandler.ReportInfo)localObject1, (MessageRecord)this.jdField_b_of_type_JavaUtilList.get(paramInt));
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "EcshopAdHandler.rebuildR…fo, mAdMessage[position])");
    Object localObject2 = AppUtils.a();
    if (localObject2 != null)
    {
      localObject2 = ((AppInterface)localObject2).getBusinessHandler(EcshopAdHandler.class.getName());
      if (localObject2 != null)
      {
        ((EcshopAdHandler)localObject2).a((IEcshopAdHandler.ReportInfo)localObject1, null);
        String str = ((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).getLastMsgType((MessageRecord)this.jdField_b_of_type_JavaUtilList.get(paramInt));
        localObject1 = ((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).getAdInfoByChatMessage((MessageRecord)this.jdField_b_of_type_JavaUtilList.get(paramInt));
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
                l = ((PBUInt64Field)localObject1).get();
                break label196;
              }
            }
          }
        }
        long l = 0L;
        label196:
        if (this.jdField_a_of_type_JavaUtilMap.get("pvsrc") != null) {
          localObject1 = (String)this.jdField_a_of_type_JavaUtilMap.get("pvsrc");
        } else {
          localObject1 = "";
        }
        if (this.jdField_a_of_type_JavaUtilMap.get("ext10") != null) {
          localObject2 = (String)this.jdField_a_of_type_JavaUtilMap.get("ext10");
        } else {
          localObject2 = "";
        }
        ReportUtil.a("qgg_pushcard_show", String.valueOf(paramInt), String.valueOf(NetConnInfoCenter.getServerTimeMillis()), String.valueOf(l), (String)localObject1, (String)localObject2, str);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.ecshop.ad.EcshopAdHandler");
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.common.app.AppInterface");
  }
  
  private final void a(List<? extends MessageRecord> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_JavaUtilList.clear();
    Object localObject1 = QRoute.api(IEcshopMessageApi.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "QRoute.api(IEcshopMessageApi::class.java)");
    localObject1 = (IEcshopMessageApi)localObject1;
    Object localObject2 = EcshopConfProcessor.a();
    int i;
    if (localObject2 != null) {
      i = ((EcshopConfBean)localObject2).e;
    } else {
      i = 2;
    }
    int j = paramList.size() - 1;
    while ((j >= 0) && (this.jdField_a_of_type_JavaUtilList.size() < i))
    {
      localObject2 = (MessageRecord)paramList.get(j);
      Object localObject3 = ((IEcshopMessageApi)localObject1).getAdInfoByChatMessage((MessageRecord)localObject2);
      if ((localObject2 != null) && (a((MessageRecord)localObject2)))
      {
        localObject3 = AdCardParseFactory.a.a((qq_ad_get.QQAdGetRsp.AdInfo)localObject3, (MessageRecord)localObject2);
        Object localObject4 = new AdCardController((AdCardModel)localObject3, (ViewGroup)this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList.size(), this.jdField_a_of_type_JavaUtilMap);
        LinearLayout localLinearLayout;
        if (((AdCardModel)localObject3).b())
        {
          ((AdCardModel)localObject3).a((EcshopAdViewHelper.DeleteMsgListener)new AdViewPagerController.initMsgData..inlined.apply.lambda.1(this, (AdCardModel)localObject3, paramList, (IEcshopMessageApi)localObject1));
          localLinearLayout = ((AdCardController)localObject4).a();
          Intrinsics.checkExpressionValueIsNotNull(localLinearLayout, "adCardAdSourceLayout");
          localLinearLayout.setVisibility(0);
          ((AdCardController)localObject4).a().setOnClickListener((View.OnClickListener)new AdViewPagerController.initMsgData..inlined.apply.lambda.2((AdCardController)localObject4, this, (AdCardModel)localObject3, paramList, (IEcshopMessageApi)localObject1));
        }
        else
        {
          localLinearLayout = ((AdCardController)localObject4).a();
          Intrinsics.checkExpressionValueIsNotNull(localLinearLayout, "adCardAdSourceLayout");
          localLinearLayout.setVisibility(8);
        }
        localObject4 = ((AdCardController)localObject4).a();
        EcshopAdHandler.a((AppInterface)AppUtils.a(), (ChatMessage)localObject2, (View)localObject4);
        this.jdField_a_of_type_JavaUtilList.add(localObject4);
        this.jdField_b_of_type_JavaUtilList.add(localObject2);
        this.jdField_c_of_type_JavaUtilList.add(localObject3);
      }
      j -= 1;
    }
    if (this.jdField_a_of_type_JavaUtilList.size() != 0)
    {
      paramList = new MoreCardController((ViewGroup)this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilList.add(paramList.a());
      return;
    }
    a();
  }
  
  private final boolean a(MessageRecord paramMessageRecord)
  {
    int i;
    try
    {
      String str = ((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).getLastMsgType(paramMessageRecord);
      Intrinsics.checkExpressionValueIsNotNull(str, "QRoute.api(IEcshopMessag…).getLastMsgType(message)");
      i = Integer.parseInt(str);
    }
    catch (Exception localException)
    {
      QLog.e("AdViewPagerController", 1, (Throwable)localException, new Object[0]);
      i = 0;
    }
    return (EcshopUtils.a(paramMessageRecord) != 1) && (i < 102);
  }
  
  private final int b()
  {
    Object localObject = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "viewPager.context");
    localObject = ((Context)localObject).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "viewPager.context.resources");
    return ((Resources)localObject).getDisplayMetrics().widthPixels - ViewUtils.a(30.0F);
  }
  
  private final void b()
  {
    Object localObject = a();
    if (ListUtils.a((Collection)localObject))
    {
      a();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("update msgList.size = ");
    localStringBuilder.append(((List)localObject).size());
    QLog.d("AdViewPagerController", 1, localStringBuilder.toString());
    a((List)localObject);
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setCurrentItem(this.jdField_c_of_type_Int, true);
    localObject = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.getAdapter();
    if (localObject != null) {
      ((PagerAdapter)localObject).notifyDataSetChanged();
    }
    if (((((Collection)this.jdField_b_of_type_JavaUtilList).isEmpty() ^ true)) && ((((Collection)this.jdField_a_of_type_JavaUtilList).isEmpty() ^ true))) {
      a(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.controller.AdViewPagerController
 * JD-Core Version:    0.7.0.1
 */