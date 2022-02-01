package com.tencent.xaction.impl;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.xaction.api.util.FileUtil;
import com.tencent.xaction.api.util.FileUtil.Companion;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class XAEngine$initFromFileAsync$1
  implements Runnable
{
  XAEngine$initFromFileAsync$1(XAEngine paramXAEngine, String paramString, Function0 paramFunction0) {}
  
  public final void run()
  {
    Object localObject1 = FileUtil.a;
    String str = this.a;
    Object localObject2 = XAEngine.access$getContext$p(this.this$0);
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    localObject2 = ((Context)localObject2).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context!!.resources");
    localObject1 = ((FileUtil.Companion)localObject1).c(str, (Resources)localObject2);
    if (localObject1 != null) {
      this.this$0.initAsync((String)localObject1, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.impl.XAEngine.initFromFileAsync.1
 * JD-Core Version:    0.7.0.1
 */