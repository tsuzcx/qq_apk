package com.tencent.mobileqq.wink.editor;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.wink.event.ImagePageTouchEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"}, k=3, mv={1, 1, 16})
final class WinkImageAdapter$onBindViewHolder$1$2
  implements View.OnTouchListener
{
  public static final 2 a = new 2();
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 0)
    {
      AEQLog.a("WinkImageAdapter", "[onBindViewHolder][onTouch] down");
      SimpleEventBus.getInstance().dispatchEvent((SimpleBaseEvent)new ImagePageTouchEvent());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkImageAdapter.onBindViewHolder.1.2
 * JD-Core Version:    0.7.0.1
 */