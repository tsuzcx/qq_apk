package com.tencent.mobileqq.wink.editor;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.wink.event.ImagePageClickEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class WinkImageAdapter$onBindViewHolder$1$1
  implements View.OnClickListener
{
  public static final 1 a = new 1();
  
  public final void onClick(View paramView)
  {
    AEQLog.a("WinkImageAdapter", "[onBindViewHolder][onClick]");
    SimpleEventBus.getInstance().dispatchEvent((SimpleBaseEvent)new ImagePageClickEvent());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkImageAdapter.onBindViewHolder.1.1
 * JD-Core Version:    0.7.0.1
 */