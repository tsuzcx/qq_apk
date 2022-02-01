package com.tencent.mobileqq.vas.gldrawable;

import android.graphics.drawable.Drawable;
import bibn;
import bibo;
import bica;
import bicb;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class DynamicDrawable$build$1
  implements Runnable
{
  public DynamicDrawable$build$1(bibn parambibn, bica parambica) {}
  
  public final void run()
  {
    Object localObject = this.a;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "loader");
    if (!((bica)localObject).a()) {
      this.a.a((bicb)new bibo(this));
    }
    for (;;)
    {
      bibn.a(this.this$0);
      return;
      localObject = (Drawable)bibn.a(this.this$0).invoke();
      if (localObject != null) {
        bibn.a(this.this$0, (Drawable)localObject);
      }
      if (this.this$0.a() == null) {
        bibn.a(this.this$0, (Drawable)bibn.b(this.this$0).invoke());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.gldrawable.DynamicDrawable.build.1
 * JD-Core Version:    0.7.0.1
 */