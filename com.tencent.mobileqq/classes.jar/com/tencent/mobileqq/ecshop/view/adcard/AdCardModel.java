package com.tencent.mobileqq.ecshop.view.adcard;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.view.EcshopAdViewHelper.DeleteMsgListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/view/adcard/AdCardModel;", "", "()V", "btnText", "", "getBtnText", "()Ljava/lang/String;", "setBtnText", "(Ljava/lang/String;)V", "cardAdInfo", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "getCardAdInfo", "()Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "setCardAdInfo", "(Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;)V", "corporateIconUrl", "getCorporateIconUrl", "setCorporateIconUrl", "corporateName", "getCorporateName", "setCorporateName", "deleteMsgListener", "Lcom/tencent/mobileqq/ecshop/view/EcshopAdViewHelper$DeleteMsgListener;", "getDeleteMsgListener", "()Lcom/tencent/mobileqq/ecshop/view/EcshopAdViewHelper$DeleteMsgListener;", "setDeleteMsgListener", "(Lcom/tencent/mobileqq/ecshop/view/EcshopAdViewHelper$DeleteMsgListener;)V", "disType", "getDisType", "setDisType", "imageUrl", "getImageUrl", "setImageUrl", "isAdMsgType", "", "()Z", "setAdMsgType", "(Z)V", "isReportClick", "setReportClick", "isVideoMsg", "setVideoMsg", "labelList", "", "getLabelList", "()Ljava/util/List;", "setLabelList", "(Ljava/util/List;)V", "landingUrl", "getLandingUrl", "setLandingUrl", "message", "Lcom/tencent/mobileqq/data/MessageRecord;", "getMessage", "()Lcom/tencent/mobileqq/data/MessageRecord;", "setMessage", "(Lcom/tencent/mobileqq/data/MessageRecord;)V", "title", "getTitle", "setTitle", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class AdCardModel
{
  @Nullable
  private qq_ad_get.QQAdGetRsp.AdInfo a;
  @NotNull
  private String b = "";
  @NotNull
  private String c = "";
  @NotNull
  private String d = "";
  @NotNull
  private String e = "";
  @NotNull
  private String f = "";
  @NotNull
  private String g = "";
  @Nullable
  private MessageRecord h;
  private boolean i;
  private boolean j = true;
  private boolean k;
  @NotNull
  private String l = "";
  @NotNull
  private List<String> m = (List)new ArrayList();
  @Nullable
  private EcshopAdViewHelper.DeleteMsgListener n;
  
  @Nullable
  public final qq_ad_get.QQAdGetRsp.AdInfo a()
  {
    return this.a;
  }
  
  public final void a(@Nullable MessageRecord paramMessageRecord)
  {
    this.h = paramMessageRecord;
  }
  
  public final void a(@Nullable EcshopAdViewHelper.DeleteMsgListener paramDeleteMsgListener)
  {
    this.n = paramDeleteMsgListener;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.b = paramString;
  }
  
  public final void a(@Nullable qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    this.a = paramAdInfo;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
  
  public final void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.c = paramString;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  @NotNull
  public final String c()
  {
    return this.c;
  }
  
  public final void c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.d = paramString;
  }
  
  public final void c(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  @NotNull
  public final String d()
  {
    return this.d;
  }
  
  public final void d(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.e = paramString;
  }
  
  @NotNull
  public final String e()
  {
    return this.e;
  }
  
  public final void e(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.f = paramString;
  }
  
  @NotNull
  public final String f()
  {
    return this.f;
  }
  
  public final void f(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.g = paramString;
  }
  
  @NotNull
  public final String g()
  {
    return this.g;
  }
  
  public final void g(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.l = paramString;
  }
  
  @Nullable
  public final MessageRecord h()
  {
    return this.h;
  }
  
  public final boolean i()
  {
    return this.i;
  }
  
  public final boolean j()
  {
    return this.j;
  }
  
  public final boolean k()
  {
    return this.k;
  }
  
  @NotNull
  public final String l()
  {
    return this.l;
  }
  
  @NotNull
  public final List<String> m()
  {
    return this.m;
  }
  
  @Nullable
  public final EcshopAdViewHelper.DeleteMsgListener n()
  {
    return this.n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.adcard.AdCardModel
 * JD-Core Version:    0.7.0.1
 */