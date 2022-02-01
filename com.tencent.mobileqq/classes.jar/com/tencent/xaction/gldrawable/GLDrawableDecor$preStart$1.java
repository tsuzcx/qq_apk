package com.tencent.xaction.gldrawable;

import android.content.Context;
import android.view.View;
import com.tencent.android.gldrawable.api.GLDrawableApi;
import com.tencent.android.gldrawable.api.IFactoryStub;
import com.tencent.xaction.api.base.DecorDrawableState;
import com.tencent.xaction.api.util.FileUtil;
import com.tencent.xaction.api.util.FileUtil.Companion;
import com.tencent.xaction.openapi.api.IXAEngine;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class GLDrawableDecor$preStart$1
  implements Runnable
{
  GLDrawableDecor$preStart$1(GLDrawableDecor paramGLDrawableDecor, View paramView) {}
  
  public final void run()
  {
    try
    {
      Object localObject1 = FileUtil.a;
      Context localContext = this.a.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "view.context");
      Object localObject2 = this.this$0.getDecorState();
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      localObject2 = ((DecorDrawableState)localObject2).getPath();
      IXAEngine localIXAEngine = this.this$0.getEngine();
      if (localIXAEngine == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = ((FileUtil.Companion)localObject1).a(localContext, (String)localObject2, "$PARENT_ROOT", localIXAEngine);
      if (!new File((String)localObject1).exists()) {
        return;
      }
      this.this$0.a(GLDrawableApi.factory().fromFile(new File((String)localObject1)));
      this.a.post((Runnable)new GLDrawableDecor.preStart.1.1(this));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.gldrawable.GLDrawableDecor.preStart.1
 * JD-Core Version:    0.7.0.1
 */