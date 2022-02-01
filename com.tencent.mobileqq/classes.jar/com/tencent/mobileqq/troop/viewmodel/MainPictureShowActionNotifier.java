package com.tencent.mobileqq.troop.viewmodel;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/troop/viewmodel/MainPictureShowActionNotifier;", "Lcom/tencent/mobileqq/troop/viewmodel/IPictureShowActionNotifier;", "()V", "notifyAction", "", "callbackId", "", "type", "", "isLiked", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class MainPictureShowActionNotifier
  implements IPictureShowActionNotifier
{
  public void a(@NotNull String paramString, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "callbackId");
    SimpleEventBus.getInstance().dispatchEvent((SimpleBaseEvent)new PictureShowActionEvent(paramString, paramInt, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.viewmodel.MainPictureShowActionNotifier
 * JD-Core Version:    0.7.0.1
 */