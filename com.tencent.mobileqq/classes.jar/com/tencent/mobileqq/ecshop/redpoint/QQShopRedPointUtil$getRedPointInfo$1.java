package com.tencent.mobileqq.ecshop.redpoint;

import android.os.Bundle;
import com.tencent.mobileqq.ecshop.utils.EcshopUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "type", "", "isSuccess", "", "data", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onReceive"}, k=3, mv={1, 1, 16})
final class QQShopRedPointUtil$getRedPointInfo$1
  implements BusinessObserver
{
  public static final 1 a = new 1();
  
  public final void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isSuccess: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("QQShopRedPointUtil", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt != 1) {
      return;
    }
    Object localObject = new qq_ad.QQAdGetRsp();
    try
    {
      ((qq_ad.QQAdGetRsp)localObject).mergeFrom(paramBundle.getByteArray("data"));
      paramBundle = ((qq_ad.QQAdGetRsp)localObject).red_point.get();
      Intrinsics.checkExpressionValueIsNotNull(paramBundle, "rsp.red_point.get()");
      QQShopRedPointUtil.a(paramBundle);
      if ((((qq_ad.QQAdGetRsp)localObject).qgg_prompt.has()) && (((qq_ad.QQAdGetRsp)localObject).qgg_prompt_id.has()))
      {
        EcshopUtils.a(((qq_ad.QQAdGetRsp)localObject).qgg_prompt.get(), ((qq_ad.QQAdGetRsp)localObject).qgg_prompt_id.get());
        return;
      }
    }
    catch (Exception paramBundle)
    {
      QLog.e("QQShopRedPointUtil", 1, (Throwable)paramBundle, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.redpoint.QQShopRedPointUtil.getRedPointInfo.1
 * JD-Core Version:    0.7.0.1
 */