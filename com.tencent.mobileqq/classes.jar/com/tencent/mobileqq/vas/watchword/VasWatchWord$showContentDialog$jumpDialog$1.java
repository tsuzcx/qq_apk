package com.tencent.mobileqq.vas.watchword;

import QC.GetWatchWordShareRsp;
import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.share.watchword.RIJWatchWordShareManager;
import com.tencent.biz.pubaccount.readinjoy.share.watchword.RIJWatchWordShareManager.Companion;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "type", "", "invoke", "(Ljava/lang/Integer;)V"}, k=3, mv={1, 1, 16})
final class VasWatchWord$showContentDialog$jumpDialog$1
  extends Lambda
  implements Function1<Integer, Unit>
{
  VasWatchWord$showContentDialog$jumpDialog$1(GetWatchWordShareRsp paramGetWatchWordShareRsp, int paramInt)
  {
    super(1);
  }
  
  public final void invoke(@Nullable Integer paramInteger)
  {
    if (paramInteger == null) {}
    while (paramInteger.intValue() != 1) {
      return;
    }
    paramInteger = VasWatchWord.a;
    Object localObject = BaseActivity.sTopActivity;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseActivity.sTopActivity");
    localObject = (Context)localObject;
    String str = this.$rsp.detailurl;
    Intrinsics.checkExpressionValueIsNotNull(str, "rsp.detailurl");
    paramInteger.b((Context)localObject, str);
    RIJWatchWordShareManager.a.a().a();
    ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800AF7A", this.$bid, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.watchword.VasWatchWord.showContentDialog.jumpDialog.1
 * JD-Core Version:    0.7.0.1
 */