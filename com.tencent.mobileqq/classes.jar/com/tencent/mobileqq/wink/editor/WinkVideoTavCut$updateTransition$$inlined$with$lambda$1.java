package com.tencent.mobileqq.wink.editor;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.videocut.model.TransitionModel;
import kotlin.Metadata;
import mqq.os.MqqHandler;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "com/tencent/mobileqq/wink/editor/WinkVideoTavCut$updateTransition$1$1"}, k=3, mv={1, 1, 16})
final class WinkVideoTavCut$updateTransition$$inlined$with$lambda$1
  implements Runnable
{
  WinkVideoTavCut$updateTransition$$inlined$with$lambda$1(WinkEditData paramWinkEditData, WinkVideoTavCut paramWinkVideoTavCut, TransitionModel paramTransitionModel, Context paramContext) {}
  
  public final void run()
  {
    ThreadManager.getUIHandler().post((Runnable)new WinkVideoTavCut.updateTransition..inlined.with.lambda.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkVideoTavCut.updateTransition..inlined.with.lambda.1
 * JD-Core Version:    0.7.0.1
 */