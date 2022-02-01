package com.tencent.mobileqq.vas.watchword;

import QC.GetWatchWordShareRsp;
import android.content.Context;
import android.os.Bundle;
import bglg;
import com.tencent.mobileqq.app.BaseActivity;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class VasWatchWord$addObserver$1$checkWatchWord$1$1
  implements Runnable
{
  public VasWatchWord$addObserver$1$checkWatchWord$1$1(EIPCResult paramEIPCResult, int paramInt) {}
  
  public final void run()
  {
    Object localObject1 = this.jdField_a_of_type_EipcEIPCResult.data.getSerializable("rsp");
    if (localObject1 == null) {
      throw new TypeCastException("null cannot be cast to non-null type QC.GetWatchWordShareRsp");
    }
    localObject1 = (GetWatchWordShareRsp)localObject1;
    if (BaseActivity.sTopActivity == null) {
      return;
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case -2600001: 
      localbglg = bglg.a;
      localObject2 = BaseActivity.sTopActivity;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "BaseActivity.sTopActivity");
      localObject2 = (Context)localObject2;
      localObject1 = ((GetWatchWordShareRsp)localObject1).errmsg;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "rsp.errmsg");
      localbglg.c((Context)localObject2, (String)localObject1);
      return;
    case 0: 
      bglg.a.a((GetWatchWordShareRsp)localObject1);
      return;
    case 2600003: 
      localbglg = bglg.a;
      localObject2 = BaseActivity.sTopActivity;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "BaseActivity.sTopActivity");
      localObject2 = (Context)localObject2;
      localObject1 = ((GetWatchWordShareRsp)localObject1).errmsg;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "rsp.errmsg");
      localbglg.c((Context)localObject2, (String)localObject1);
      return;
    }
    bglg localbglg = bglg.a;
    Object localObject2 = BaseActivity.sTopActivity;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "BaseActivity.sTopActivity");
    localObject2 = (Context)localObject2;
    localObject1 = ((GetWatchWordShareRsp)localObject1).errmsg;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "rsp.errmsg");
    localbglg.c((Context)localObject2, (String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.watchword.VasWatchWord.addObserver.1.checkWatchWord.1.1
 * JD-Core Version:    0.7.0.1
 */