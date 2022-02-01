package com.tencent.mobileqq.troop.viewmodel;

import android.os.Bundle;
import com.tencent.mobileqq.app.ViewActionObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/troop/viewmodel/ToolPictureShowActionNotifier;", "Lcom/tencent/mobileqq/troop/viewmodel/IPictureShowActionNotifier;", "appRuntime", "Lmqq/app/AppRuntime;", "(Lmqq/app/AppRuntime;)V", "getAppRuntime", "()Lmqq/app/AppRuntime;", "notifyAction", "", "callbackId", "", "type", "", "isLiked", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ToolPictureShowActionNotifier
  implements IPictureShowActionNotifier
{
  @NotNull
  private final AppRuntime a;
  
  public ToolPictureShowActionNotifier(@NotNull AppRuntime paramAppRuntime)
  {
    this.a = paramAppRuntime;
  }
  
  public void a(@NotNull String paramString, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "callbackId");
    Bundle localBundle = new Bundle();
    paramString = StringsKt.toIntOrNull(paramString);
    int i;
    if (paramString != null) {
      i = paramString.intValue();
    } else {
      i = 0;
    }
    localBundle.putInt("seq", i);
    localBundle.putInt("click_view_type", paramInt);
    localBundle.putBoolean("like_state", paramBoolean);
    this.a.notifyObservers(ViewActionObserver.class, 0, true, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.viewmodel.ToolPictureShowActionNotifier
 * JD-Core Version:    0.7.0.1
 */