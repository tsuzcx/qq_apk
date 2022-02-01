package com.tencent.mobileqq.vas.watchword;

import QC.GetWatchWordShareRsp;
import android.content.Context;
import bdla;
import bhvq;
import com.tencent.mobileqq.app.BaseActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import rlt;
import rlu;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "type", "", "invoke", "(Ljava/lang/Integer;)V"}, k=3, mv={1, 1, 16})
public final class VasWatchWord$showContentDialog$jumpDialog$1
  extends Lambda
  implements Function1<Integer, Unit>
{
  public VasWatchWord$showContentDialog$jumpDialog$1(GetWatchWordShareRsp paramGetWatchWordShareRsp, int paramInt)
  {
    super(1);
  }
  
  public final void invoke(@Nullable Integer paramInteger)
  {
    if (paramInteger == null) {}
    while (paramInteger.intValue() != 1) {
      return;
    }
    paramInteger = bhvq.a;
    Object localObject = BaseActivity.sTopActivity;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseActivity.sTopActivity");
    localObject = (Context)localObject;
    String str = this.$rsp.detailurl;
    Intrinsics.checkExpressionValueIsNotNull(str, "rsp.detailurl");
    paramInteger.b((Context)localObject, str);
    rlt.a.a().a();
    bdla.b(null, "dc00898", "", "", "qq_vip", "0X800AF7A", this.$bid, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.watchword.VasWatchWord.showContentDialog.jumpDialog.1
 * JD-Core Version:    0.7.0.1
 */