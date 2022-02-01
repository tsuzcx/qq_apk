package com.tencent.mobileqq.ecshop.view.adcard;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.ecshop.report.ReportUtil;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopMessageApi;
import com.tencent.mobileqq.ecshop.utils.QQShopPicUtil;
import com.tencent.mobileqq.ecshop.view.controller.CardController;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/view/adcard/AdCardController;", "Lcom/tencent/mobileqq/ecshop/view/controller/CardController;", "adCardModel", "Lcom/tencent/mobileqq/ecshop/view/adcard/AdCardModel;", "parent", "Landroid/view/ViewGroup;", "imageWidth", "", "imageHeight", "adStyle", "", "position", "reportData", "", "(Lcom/tencent/mobileqq/ecshop/view/adcard/AdCardModel;Landroid/view/ViewGroup;IILjava/lang/String;ILjava/util/Map;)V", "adCardAdSourceLayout", "Landroid/widget/LinearLayout;", "getAdCardAdSourceLayout", "()Landroid/widget/LinearLayout;", "adCardBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "adCardCorporateImage", "Landroid/widget/ImageView;", "adCardCorporateImageBg", "Landroid/widget/FrameLayout;", "adCardCorporateLayout", "adCardCorporateName", "adCardImage", "adCardTitle", "adCardVideoPlayImg", "itemView", "Landroid/view/View;", "doReportClick", "", "getItemView", "getLayoutId", "type", "Companion", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class AdCardController
  implements CardController
{
  public static final AdCardController.Companion a = new AdCardController.Companion(null);
  private final View b;
  private final ImageView c;
  private final TextView d;
  private final TextView e;
  private final LinearLayout f;
  private final ImageView g;
  private final FrameLayout h;
  private final TextView i;
  private final ImageView j;
  @NotNull
  private final LinearLayout k;
  private final AdCardModel l;
  private final int m;
  private final Map<String, String> n;
  
  public AdCardController(@NotNull AdCardModel paramAdCardModel, @NotNull ViewGroup paramViewGroup, int paramInt1, int paramInt2, @NotNull String paramString, int paramInt3, @NotNull Map<String, String> paramMap)
  {
    this.l = paramAdCardModel;
    this.m = paramInt3;
    this.n = paramMap;
    paramAdCardModel = LayoutInflater.from(paramViewGroup.getContext()).inflate(a(paramString), paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramAdCardModel, "LayoutInflater.from(pare…(adStyle), parent, false)");
    this.b = paramAdCardModel;
    this.c = ((ImageView)this.b.findViewById(2131427654));
    this.d = ((TextView)this.b.findViewById(2131427657));
    this.e = ((TextView)this.b.findViewById(2131427648));
    this.f = ((LinearLayout)this.b.findViewById(2131427652));
    this.g = ((ImageView)this.b.findViewById(2131427650));
    this.h = ((FrameLayout)this.b.findViewById(2131427651));
    this.i = ((TextView)this.b.findViewById(2131427653));
    this.j = ((ImageView)this.b.findViewById(2131427658));
    paramAdCardModel = (LinearLayout)this.b.findViewById(2131427647);
    Intrinsics.checkExpressionValueIsNotNull(paramAdCardModel, "itemView.ad_card_ad_source_layout");
    this.k = paramAdCardModel;
    paramAdCardModel = paramViewGroup.getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramAdCardModel, "parent.context");
    paramAdCardModel = paramAdCardModel.getResources().getDrawable(2130847755);
    this.c.setImageDrawable((Drawable)QQShopPicUtil.a(this.l.b(), paramAdCardModel));
    paramAdCardModel = this.c;
    Intrinsics.checkExpressionValueIsNotNull(paramAdCardModel, "adCardImage");
    paramAdCardModel = paramAdCardModel.getLayoutParams();
    if (paramAdCardModel != null) {
      paramAdCardModel.height = paramInt2;
    }
    paramAdCardModel = this.b.getLayoutParams();
    if (paramAdCardModel != null) {
      paramAdCardModel.width = paramInt1;
    }
    paramAdCardModel = this.d;
    Intrinsics.checkExpressionValueIsNotNull(paramAdCardModel, "adCardTitle");
    paramAdCardModel.setText((CharSequence)this.l.d());
    paramViewGroup = this.e;
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "adCardBtn");
    if (TextUtils.isEmpty((CharSequence)this.l.e())) {
      paramAdCardModel = "去看看";
    } else {
      paramAdCardModel = this.l.e();
    }
    paramViewGroup.setText((CharSequence)paramAdCardModel);
    paramInt2 = paramInt1 - ViewUtils.dip2px(40.0F);
    paramInt1 = paramInt2;
    if (!TextUtils.isEmpty((CharSequence)this.l.f()))
    {
      paramAdCardModel = this.i;
      Intrinsics.checkExpressionValueIsNotNull(paramAdCardModel, "adCardCorporateName");
      paramAdCardModel.setText((CharSequence)this.l.f());
      paramAdCardModel = this.i;
      Intrinsics.checkExpressionValueIsNotNull(paramAdCardModel, "adCardCorporateName");
      paramInt1 = paramInt2 - (int)paramAdCardModel.getPaint().measureText(this.l.f());
    }
    if (TextUtils.isEmpty((CharSequence)this.l.g()))
    {
      paramAdCardModel = this.h;
      Intrinsics.checkExpressionValueIsNotNull(paramAdCardModel, "adCardCorporateImageBg");
      paramAdCardModel.setVisibility(8);
    }
    else
    {
      paramAdCardModel = this.h;
      Intrinsics.checkExpressionValueIsNotNull(paramAdCardModel, "adCardCorporateImageBg");
      paramAdCardModel.setVisibility(0);
      this.g.setImageDrawable((Drawable)QQShopPicUtil.a(this.l.g(), (Drawable)new ColorDrawable(Color.parseColor("#FFFBFBFC"))));
      paramInt1 -= ViewUtils.dip2px(23.0F);
    }
    paramAdCardModel = this.l.m().iterator();
    while (paramAdCardModel.hasNext())
    {
      paramViewGroup = (String)paramAdCardModel.next();
      paramString = (CharSequence)paramViewGroup;
      if (!TextUtils.isEmpty(paramString))
      {
        paramMap = LayoutInflater.from(this.b.getContext()).inflate(2131627831, (ViewGroup)this.f, false);
        if (paramMap != null)
        {
          paramMap = (TextView)paramMap;
          paramMap.setText(paramString);
          paramMap.setTextSize(1, 10.0F);
          paramString = new LinearLayout.LayoutParams(-2, ViewUtils.dip2px(15.0F));
          paramString.setMargins(ViewUtils.dip2px(4.5F), 0, 0, 0);
          paramInt2 = (int)paramMap.getPaint().measureText(paramViewGroup) + ViewUtils.dip2px(9.5F);
          if (paramInt1 > paramInt2)
          {
            this.f.addView((View)paramMap, (ViewGroup.LayoutParams)paramString);
            paramInt1 -= paramInt2;
          }
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }
      }
    }
    if (this.l.k())
    {
      paramAdCardModel = this.j;
      Intrinsics.checkExpressionValueIsNotNull(paramAdCardModel, "adCardVideoPlayImg");
      paramAdCardModel.setVisibility(0);
    }
    else
    {
      paramAdCardModel = this.j;
      Intrinsics.checkExpressionValueIsNotNull(paramAdCardModel, "adCardVideoPlayImg");
      paramAdCardModel.setVisibility(8);
    }
    this.g.post((Runnable)new AdCardController.1(this));
    QQShopPicUtil.a(this.b, 30.0F);
    QQShopPicUtil.a((View)this.k, 5.0F);
    this.b.setOnClickListener((View.OnClickListener)new AdCardController.2(this));
    if (Intrinsics.areEqual("3", this.l.l())) {
      this.c.setOnClickListener((View.OnClickListener)new AdCardController.3(this));
    }
  }
  
  private final void c()
  {
    String str2 = ((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).getLastMsgType(this.l.h());
    Object localObject = this.l.a();
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
            l1 = ((PBUInt64Field)localObject).get();
            break label72;
          }
        }
      }
    }
    long l1 = 0L;
    label72:
    if (this.n.get("pvsrc") != null) {
      localObject = (String)this.n.get("pvsrc");
    } else {
      localObject = "";
    }
    String str1;
    if (this.n.get("ext10") != null) {
      str1 = (String)this.n.get("ext10");
    } else {
      str1 = "";
    }
    ReportUtil.a("qgg_pushcard_click", String.valueOf(this.m), String.valueOf(NetConnInfoCenter.getServerTimeMillis()), String.valueOf(l1), (String)localObject, str1, str2);
  }
  
  public int a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "type");
    if (Intrinsics.areEqual("small", paramString)) {
      return 2131627832;
    }
    return 2131627830;
  }
  
  @NotNull
  public final LinearLayout a()
  {
    return this.k;
  }
  
  @NotNull
  public View b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.adcard.AdCardController
 * JD-Core Version:    0.7.0.1
 */