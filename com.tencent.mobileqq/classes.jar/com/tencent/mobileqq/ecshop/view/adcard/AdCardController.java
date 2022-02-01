package com.tencent.mobileqq.ecshop.view.adcard;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.ecshop.report.ReportUtil;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopMessageApi;
import com.tencent.mobileqq.ecshop.utils.QQShopPicUtil;
import com.tencent.mobileqq.ecshop.view.controller.CardController;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/view/adcard/AdCardController;", "Lcom/tencent/mobileqq/ecshop/view/controller/CardController;", "adCardModel", "Lcom/tencent/mobileqq/ecshop/view/adcard/AdCardModel;", "parent", "Landroid/view/ViewGroup;", "imageHeight", "", "adStyle", "", "position", "reportData", "", "(Lcom/tencent/mobileqq/ecshop/view/adcard/AdCardModel;Landroid/view/ViewGroup;ILjava/lang/String;ILjava/util/Map;)V", "adCardAdSourceLayout", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getAdCardAdSourceLayout", "()Landroid/widget/LinearLayout;", "adCardBtn", "Landroid/widget/TextView;", "adCardCorporateImage", "Landroid/widget/ImageView;", "adCardCorporateName", "adCardImage", "adCardTitle", "adCardVideoPlayImg", "itemView", "Landroid/view/View;", "doReportClick", "", "getItemView", "getLayoutId", "type", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class AdCardController
  implements CardController
{
  private final int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private final AdCardModel jdField_a_of_type_ComTencentMobileqqEcshopViewAdcardAdCardModel;
  private final Map<String, String> jdField_a_of_type_JavaUtilMap;
  private final ImageView jdField_b_of_type_AndroidWidgetImageView;
  private final TextView jdField_b_of_type_AndroidWidgetTextView;
  private final ImageView jdField_c_of_type_AndroidWidgetImageView;
  private final TextView jdField_c_of_type_AndroidWidgetTextView;
  
  public AdCardController(@NotNull AdCardModel paramAdCardModel, @NotNull ViewGroup paramViewGroup, int paramInt1, @NotNull String paramString, int paramInt2, @NotNull Map<String, String> paramMap)
  {
    this.jdField_a_of_type_ComTencentMobileqqEcshopViewAdcardAdCardModel = paramAdCardModel;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    paramAdCardModel = LayoutInflater.from(paramViewGroup.getContext()).inflate(a(paramString), paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramAdCardModel, "LayoutInflater.from(pare…(adStyle), parent, false)");
    this.jdField_a_of_type_AndroidViewView = paramAdCardModel;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362075));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362078));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362070));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362072));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362074));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362079));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131362069));
    paramAdCardModel = paramViewGroup.getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramAdCardModel, "parent.context");
    paramAdCardModel = paramAdCardModel.getResources().getDrawable(2130846285);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)QQShopPicUtil.a(this.jdField_a_of_type_ComTencentMobileqqEcshopViewAdcardAdCardModel.a(), paramAdCardModel));
    paramAdCardModel = this.jdField_a_of_type_AndroidWidgetImageView;
    Intrinsics.checkExpressionValueIsNotNull(paramAdCardModel, "adCardImage");
    paramAdCardModel = paramAdCardModel.getLayoutParams();
    if (paramAdCardModel != null) {
      paramAdCardModel.height = paramInt1;
    }
    paramAdCardModel = this.jdField_a_of_type_AndroidWidgetTextView;
    Intrinsics.checkExpressionValueIsNotNull(paramAdCardModel, "adCardTitle");
    paramAdCardModel.setText((CharSequence)this.jdField_a_of_type_ComTencentMobileqqEcshopViewAdcardAdCardModel.c());
    paramViewGroup = this.jdField_b_of_type_AndroidWidgetTextView;
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "adCardBtn");
    if (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentMobileqqEcshopViewAdcardAdCardModel.d())) {
      paramAdCardModel = "去看看";
    } else {
      paramAdCardModel = this.jdField_a_of_type_ComTencentMobileqqEcshopViewAdcardAdCardModel.d();
    }
    paramViewGroup.setText((CharSequence)paramAdCardModel);
    paramAdCardModel = this.jdField_c_of_type_AndroidWidgetTextView;
    Intrinsics.checkExpressionValueIsNotNull(paramAdCardModel, "adCardCorporateName");
    paramAdCardModel.setText((CharSequence)this.jdField_a_of_type_ComTencentMobileqqEcshopViewAdcardAdCardModel.e());
    if (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentMobileqqEcshopViewAdcardAdCardModel.f()))
    {
      paramAdCardModel = this.jdField_b_of_type_AndroidWidgetImageView;
      Intrinsics.checkExpressionValueIsNotNull(paramAdCardModel, "adCardCorporateImage");
      paramAdCardModel.setVisibility(8);
    }
    else
    {
      paramAdCardModel = this.jdField_b_of_type_AndroidWidgetImageView;
      Intrinsics.checkExpressionValueIsNotNull(paramAdCardModel, "adCardCorporateImage");
      paramAdCardModel.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)QQShopPicUtil.a(this.jdField_a_of_type_ComTencentMobileqqEcshopViewAdcardAdCardModel.f(), (Drawable)new ColorDrawable(Color.parseColor("#FFFBFBFC"))));
    }
    paramAdCardModel = QQShopPicUtil.a;
    paramViewGroup = this.jdField_b_of_type_AndroidWidgetImageView;
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "adCardCorporateImage");
    paramAdCardModel.a((View)paramViewGroup, 50.0F);
    QQShopPicUtil.a.a(this.jdField_a_of_type_AndroidViewView, 30.0F);
    paramAdCardModel = QQShopPicUtil.a;
    paramViewGroup = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "adCardAdSourceLayout");
    paramAdCardModel.a((View)paramViewGroup, 5.0F);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener((View.OnClickListener)new AdCardController.1(this));
    if (this.jdField_a_of_type_ComTencentMobileqqEcshopViewAdcardAdCardModel.c())
    {
      paramAdCardModel = this.jdField_c_of_type_AndroidWidgetImageView;
      Intrinsics.checkExpressionValueIsNotNull(paramAdCardModel, "adCardVideoPlayImg");
      paramAdCardModel.setVisibility(0);
    }
    else
    {
      paramAdCardModel = this.jdField_c_of_type_AndroidWidgetImageView;
      Intrinsics.checkExpressionValueIsNotNull(paramAdCardModel, "adCardVideoPlayImg");
      paramAdCardModel.setVisibility(8);
    }
    if (Intrinsics.areEqual("3", this.jdField_a_of_type_ComTencentMobileqqEcshopViewAdcardAdCardModel.g())) {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener((View.OnClickListener)new AdCardController.2(this));
    }
  }
  
  private final void a()
  {
    String str2 = ((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).getLastMsgType(this.jdField_a_of_type_ComTencentMobileqqEcshopViewAdcardAdCardModel.a());
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEcshopViewAdcardAdCardModel.a();
    if (localObject != null)
    {
      localObject = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).report_info;
      if (localObject != null)
      {
        localObject = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject).trace_info;
        if (localObject != null)
        {
          localObject = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).aid;
          if (localObject != null)
          {
            l = ((PBUInt64Field)localObject).get();
            break label72;
          }
        }
      }
    }
    long l = 0L;
    label72:
    if (this.jdField_a_of_type_JavaUtilMap.get("pvsrc") != null) {
      localObject = (String)this.jdField_a_of_type_JavaUtilMap.get("pvsrc");
    } else {
      localObject = "";
    }
    String str1;
    if (this.jdField_a_of_type_JavaUtilMap.get("ext10") != null) {
      str1 = (String)this.jdField_a_of_type_JavaUtilMap.get("ext10");
    } else {
      str1 = "";
    }
    ReportUtil.a("qgg_pushcard_click", String.valueOf(this.jdField_a_of_type_Int), String.valueOf(NetConnInfoCenter.getServerTimeMillis()), String.valueOf(l), (String)localObject, str1, str2);
  }
  
  public int a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "type");
    if (Intrinsics.areEqual("small", paramString)) {
      return 2131561474;
    }
    return 2131561473;
  }
  
  @NotNull
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public final LinearLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.adcard.AdCardController
 * JD-Core Version:    0.7.0.1
 */