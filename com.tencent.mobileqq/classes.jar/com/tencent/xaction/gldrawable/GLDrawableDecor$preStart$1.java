package com.tencent.xaction.gldrawable;

import android.view.View;
import com.tencent.android.gldrawable.api.GLDrawableApi;
import com.tencent.android.gldrawable.api.IFactoryStub;
import com.tencent.android.gldrawable.api.IGLDrawable;
import com.tencent.xaction.api.base.DecorDrawableState;
import com.tencent.xaction.api.util.FilePathUtil;
import com.tencent.xaction.api.util.FilePathUtil.Companion;
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
      Object localObject1 = FilePathUtil.a;
      Object localObject2 = this.this$0.getDecorState();
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      localObject2 = ((DecorDrawableState)localObject2).getPath();
      Object localObject3 = this.this$0.getDecorState();
      if (localObject3 == null) {
        Intrinsics.throwNpe();
      }
      localObject3 = ((DecorDrawableState)localObject3).getRoot();
      IXAEngine localIXAEngine = this.this$0.getEngine();
      if (localIXAEngine == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = ((FilePathUtil.Companion)localObject1).a((String)localObject2, (String)localObject3, localIXAEngine);
      if (!new File((String)localObject1).exists()) {
        return;
      }
      localObject1 = GLDrawableApi.factory().fromFile(new File((String)localObject1));
      this.a.post((Runnable)new GLDrawableDecor.preStart.1.1(this, (IGLDrawable)localObject1));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.gldrawable.GLDrawableDecor.preStart.1
 * JD-Core Version:    0.7.0.1
 */