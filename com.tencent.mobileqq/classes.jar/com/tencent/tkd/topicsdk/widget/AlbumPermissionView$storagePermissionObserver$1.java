package com.tencent.tkd.topicsdk.widget;

import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEventObserver;
import com.tencent.tkd.topicsdk.framework.events.StoragePermissionEvent;
import com.tencent.tkd.topicsdk.interfaces.IPermission.ISimpleCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/widget/AlbumPermissionView$storagePermissionObserver$1", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/IEventObserver;", "Lcom/tencent/tkd/topicsdk/framework/events/StoragePermissionEvent;", "onEvent", "", "event", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class AlbumPermissionView$storagePermissionObserver$1
  implements IEventObserver<StoragePermissionEvent>
{
  public void a(@NotNull StoragePermissionEvent paramStoragePermissionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramStoragePermissionEvent, "event");
    if (paramStoragePermissionEvent.a())
    {
      paramStoragePermissionEvent = this.a.a();
      if (paramStoragePermissionEvent != null) {
        paramStoragePermissionEvent.a();
      }
      TLog.a("AlbumPermissionView", "request storage permissions, grant.");
      return;
    }
    paramStoragePermissionEvent = this.a.a();
    if (paramStoragePermissionEvent != null) {
      paramStoragePermissionEvent.b();
    }
    TLog.a("AlbumPermissionView", "request storage permissions, deny.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.AlbumPermissionView.storagePermissionObserver.1
 * JD-Core Version:    0.7.0.1
 */