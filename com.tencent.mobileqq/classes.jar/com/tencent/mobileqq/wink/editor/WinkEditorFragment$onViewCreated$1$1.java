package com.tencent.mobileqq.wink.editor;

import android.app.Activity;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart;
import com.tencent.mobileqq.wink.event.ReceiveSchemaEvent;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class WinkEditorFragment$onViewCreated$1$1
  implements Runnable
{
  WinkEditorFragment$onViewCreated$1$1(WinkEditorFragment.onViewCreated.1 param1) {}
  
  public final void run()
  {
    SimpleEventBus localSimpleEventBus = SimpleEventBus.getInstance();
    HashMap localHashMap = WinkEditorMenuPart.a((Activity)this.this$0.a.getActivity());
    Intrinsics.checkExpressionValueIsNotNull(localHashMap, "WinkEditorMenuPart.getAttrs(activity)");
    localSimpleEventBus.dispatchEvent((SimpleBaseEvent)new ReceiveSchemaEvent((Map)localHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkEditorFragment.onViewCreated.1.1
 * JD-Core Version:    0.7.0.1
 */