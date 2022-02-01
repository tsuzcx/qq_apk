package com.tencent.timi.game.liveroom.impl.view;

import android.content.res.Resources;
import android.graphics.Matrix;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.ui.pag.TimiGamePAGView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGLayer;
import org.libpag.PAGView.PAGViewListener;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AnchorCountDownView$playCountDown$1
  implements Runnable
{
  AnchorCountDownView$playCountDown$1(AnchorCountDownView paramAnchorCountDownView) {}
  
  public final void run()
  {
    if (((TimiGamePAGView)this.this$0.a(2131431438)).a())
    {
      localObject1 = BaseApplication.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplication.getContext()");
      localObject1 = ((BaseApplication)localObject1).getResources();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplication.getContext().resources");
      localObject1 = PAGFile.Load(((Resources)localObject1).getAssets(), "pag/tg_anchor_count_down.pag");
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "PAGFile.Load(\n          …wn.pag\"\n                )");
      Object localObject2 = ((PAGFile)localObject1).getTotalMatrix();
      TimiGamePAGView localTimiGamePAGView = (TimiGamePAGView)this.this$0.a(2131431438);
      Intrinsics.checkExpressionValueIsNotNull(localTimiGamePAGView, "countDownPag");
      float f = localTimiGamePAGView.getWidth() * 1.0F / ((PAGFile)localObject1).width();
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      ((Matrix)localObject2).setScale(f, f);
      ((PAGFile)localObject1).setMatrix((Matrix)localObject2);
      localObject2 = this.this$0;
      localTimiGamePAGView = (TimiGamePAGView)((AnchorCountDownView)localObject2).a(2131431438);
      Intrinsics.checkExpressionValueIsNotNull(localTimiGamePAGView, "countDownPag");
      int i = localTimiGamePAGView.getWidth();
      localTimiGamePAGView = (TimiGamePAGView)this.this$0.a(2131431438);
      Intrinsics.checkExpressionValueIsNotNull(localTimiGamePAGView, "countDownPag");
      AnchorCountDownView.a((AnchorCountDownView)localObject2, PAGComposition.Make(i, localTimiGamePAGView.getHeight()));
      localObject2 = AnchorCountDownView.a(this.this$0);
      if (localObject2 != null)
      {
        ((PAGComposition)localObject2).addLayer((PAGLayer)localObject1);
        ((TimiGamePAGView)this.this$0.a(2131431438)).setComposition((PAGComposition)localObject2);
        ((TimiGamePAGView)this.this$0.a(2131431438)).setRepeatCount(1);
        ((TimiGamePAGView)this.this$0.a(2131431438)).setProgress(0.0D);
      }
      ((TimiGamePAGView)this.this$0.a(2131431438)).post((Runnable)new AnchorCountDownView.playCountDown.1.2(this));
      ((TimiGamePAGView)this.this$0.a(2131431438)).a((PAGView.PAGViewListener)new AnchorCountDownView.playCountDown.1.3(this));
      return;
    }
    Logger.INSTANCE.i(new String[] { AnchorCountDownView.b(this.this$0), "pag not ready ，skip countdown" });
    Object localObject1 = this.this$0.getCountDownTimerListener();
    if (localObject1 != null) {
      ((AnchorCountDownView.CountdownListener)localObject1).a();
    }
    localObject1 = this.this$0.getCountDownTimerListener();
    if (localObject1 != null) {
      ((AnchorCountDownView.CountdownListener)localObject1).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorCountDownView.playCountDown.1
 * JD-Core Version:    0.7.0.1
 */