package com.tencent.mobileqq.triton.view;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/triton/view/GameView$Companion$from$1$1", "Landroid/view/SurfaceHolder$Callback;", "surfaceChanged", "", "holder", "Landroid/view/SurfaceHolder;", "format", "", "width", "height", "surfaceCreated", "surfaceDestroyed", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public final class GameView$Companion$from$1$1
  implements SurfaceHolder.Callback
{
  public void surfaceChanged(@NotNull SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramSurfaceHolder, "holder");
    GameView.Companion.from.1.access$set_format$p(this.this$0, paramInt1);
    GameView.Companion.from.1.access$set_width$p(this.this$0, paramInt2);
    GameView.Companion.from.1.access$set_height$p(this.this$0, paramInt3);
    GameView.SurfaceCallback localSurfaceCallback = GameView.Companion.from.1.access$getSurfaceCallback$p(this.this$0);
    if (localSurfaceCallback != null)
    {
      paramSurfaceHolder = paramSurfaceHolder.getSurface();
      Intrinsics.checkExpressionValueIsNotNull(paramSurfaceHolder, "holder.surface");
      localSurfaceCallback.onSurfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void surfaceCreated(@NotNull SurfaceHolder paramSurfaceHolder)
  {
    Intrinsics.checkParameterIsNotNull(paramSurfaceHolder, "holder");
    Object localObject = this.this$0;
    GameView.Companion.from.1.access$set_width$p((GameView.Companion.from.1)localObject, ((GameView.Companion.from.1)localObject).$surfaceView.getWidth());
    localObject = this.this$0;
    GameView.Companion.from.1.access$set_height$p((GameView.Companion.from.1)localObject, ((GameView.Companion.from.1)localObject).$surfaceView.getHeight());
    localObject = GameView.Companion.from.1.access$getSurfaceCallback$p(this.this$0);
    if (localObject != null)
    {
      paramSurfaceHolder = paramSurfaceHolder.getSurface();
      Intrinsics.checkExpressionValueIsNotNull(paramSurfaceHolder, "holder.surface");
      ((GameView.SurfaceCallback)localObject).onSurfaceCreated(paramSurfaceHolder);
    }
  }
  
  public void surfaceDestroyed(@NotNull SurfaceHolder paramSurfaceHolder)
  {
    Intrinsics.checkParameterIsNotNull(paramSurfaceHolder, "holder");
    paramSurfaceHolder = GameView.Companion.from.1.access$getSurfaceCallback$p(this.this$0);
    if (paramSurfaceHolder != null) {
      paramSurfaceHolder.onSurfaceDestroyed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.view.GameView.Companion.from.1.1
 * JD-Core Version:    0.7.0.1
 */