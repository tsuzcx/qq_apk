package com.tencent.mobileqq.guild.audio.dialog;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/guild/audio/dialog/AudioRoomDialog$mScreenReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class AudioRoomDialog$mScreenReceiver$1
  extends BroadcastReceiver
{
  public void onReceive(@NotNull Context paramContext, @NotNull Intent paramIntent)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    paramContext = paramIntent.getAction();
    paramIntent = paramIntent.getStringExtra("process_name");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceive action: ");
    localStringBuilder.append(paramContext);
    localStringBuilder.append("  process_name:");
    localStringBuilder.append(paramIntent);
    QLog.d("AudioRoomDialog", 4, localStringBuilder.toString());
    if (Intrinsics.areEqual("mqq.intent.action.QQ_BACKGROUND", paramContext))
    {
      AudioRoomDialog.b(this.a, true);
      this.a.dismissAllowingStateLoss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.dialog.AudioRoomDialog.mScreenReceiver.1
 * JD-Core Version:    0.7.0.1
 */