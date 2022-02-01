package com.tencent.mobileqq.ecshop.view.adcard;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.MutiPicTextInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/view/adcard/AdCardMoreImageProcessor;", "Lcom/tencent/mobileqq/ecshop/view/adcard/AdCardBaseProcessor;", "()V", "getImageUrl", "", "adInfo", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "message", "Lcom/tencent/mobileqq/data/MessageRecord;", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class AdCardMoreImageProcessor
  extends AdCardBaseProcessor
{
  @NotNull
  public String a(@Nullable qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, @NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "message");
    if (paramAdInfo != null)
    {
      paramAdInfo = paramAdInfo.display_info.muti_pic_text_info.image.get().get(0);
      Intrinsics.checkExpressionValueIsNotNull(paramAdInfo, "adInfo.display_info.muti…_text_info.image.get()[0]");
      return (String)paramAdInfo;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.adcard.AdCardMoreImageProcessor
 * JD-Core Version:    0.7.0.1
 */