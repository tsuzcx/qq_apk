package com.tencent.mobileqq.ecshop.view.adcard;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.view.EcshopAdViewHelper.DeleteMsgListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/view/adcard/AdCardModel;", "", "()V", "btnText", "", "getBtnText", "()Ljava/lang/String;", "setBtnText", "(Ljava/lang/String;)V", "cardAdInfo", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "getCardAdInfo", "()Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "setCardAdInfo", "(Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;)V", "corporateIconUrl", "getCorporateIconUrl", "setCorporateIconUrl", "corporateName", "getCorporateName", "setCorporateName", "deleteMsgListener", "Lcom/tencent/mobileqq/ecshop/view/EcshopAdViewHelper$DeleteMsgListener;", "getDeleteMsgListener", "()Lcom/tencent/mobileqq/ecshop/view/EcshopAdViewHelper$DeleteMsgListener;", "setDeleteMsgListener", "(Lcom/tencent/mobileqq/ecshop/view/EcshopAdViewHelper$DeleteMsgListener;)V", "disType", "getDisType", "setDisType", "imageUrl", "getImageUrl", "setImageUrl", "isAdMsgType", "", "()Z", "setAdMsgType", "(Z)V", "isReportClick", "setReportClick", "isVideoMsg", "setVideoMsg", "landingUrl", "getLandingUrl", "setLandingUrl", "message", "Lcom/tencent/mobileqq/data/MessageRecord;", "getMessage", "()Lcom/tencent/mobileqq/data/MessageRecord;", "setMessage", "(Lcom/tencent/mobileqq/data/MessageRecord;)V", "title", "getTitle", "setTitle", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class AdCardModel
{
  @Nullable
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  @Nullable
  private EcshopAdViewHelper.DeleteMsgListener jdField_a_of_type_ComTencentMobileqqEcshopViewEcshopAdViewHelper$DeleteMsgListener;
  @NotNull
  private String jdField_a_of_type_JavaLangString = "";
  @Nullable
  private qq_ad_get.QQAdGetRsp.AdInfo jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo;
  private boolean jdField_a_of_type_Boolean;
  @NotNull
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean = true;
  @NotNull
  private String jdField_c_of_type_JavaLangString = "";
  private boolean jdField_c_of_type_Boolean;
  @NotNull
  private String d = "";
  @NotNull
  private String e = "";
  @NotNull
  private String f = "";
  @NotNull
  private String g = "";
  
  @Nullable
  public final MessageRecord a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  @Nullable
  public final EcshopAdViewHelper.DeleteMsgListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEcshopViewEcshopAdViewHelper$DeleteMsgListener;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @Nullable
  public final qq_ad_get.QQAdGetRsp.AdInfo a()
  {
    return this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo;
  }
  
  public final void a(@Nullable MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
  }
  
  public final void a(@Nullable EcshopAdViewHelper.DeleteMsgListener paramDeleteMsgListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqEcshopViewEcshopAdViewHelper$DeleteMsgListener = paramDeleteMsgListener;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public final void a(@Nullable qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo = paramAdInfo;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  @NotNull
  public final String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public final void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public final boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  @NotNull
  public final String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public final void c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public final void c(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public final boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  @NotNull
  public final String d()
  {
    return this.d;
  }
  
  public final void d(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.d = paramString;
  }
  
  @NotNull
  public final String e()
  {
    return this.e;
  }
  
  public final void e(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.e = paramString;
  }
  
  @NotNull
  public final String f()
  {
    return this.f;
  }
  
  public final void f(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.f = paramString;
  }
  
  @NotNull
  public final String g()
  {
    return this.g;
  }
  
  public final void g(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.g = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.adcard.AdCardModel
 * JD-Core Version:    0.7.0.1
 */