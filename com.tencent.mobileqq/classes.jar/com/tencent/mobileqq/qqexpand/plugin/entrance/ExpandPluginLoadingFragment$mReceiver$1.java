package com.tencent.mobileqq.qqexpand.plugin.entrance;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import cooperation.plugin.HighPluginCrashException;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/qqexpand/plugin/entrance/ExpandPluginLoadingFragment$mReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandPluginLoadingFragment$mReceiver$1
  extends BroadcastReceiver
{
  public void onReceive(@NotNull Context paramContext, @NotNull Intent paramIntent)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    if ((Intrinsics.areEqual("com.tencent.mobileqq.qshadow.ACTION_PLUGIN_CRASH", paramIntent.getAction())) && (Intrinsics.areEqual(paramIntent.getStringExtra("qshadow_plugin_id"), "expand")))
    {
      QLog.d("ExpandPluginLoadingFragment", 2, "receive CRASH_ACTION");
      int i = paramIntent.getIntExtra("qshadow_plugin_error_code", 0);
      ExpandPluginLoadingFragment.a(this.a, i);
      try
      {
        paramContext = paramIntent.getSerializableExtra("qshadow_plugin_throwable");
        if (paramContext != null)
        {
          Object localObject = (Throwable)paramContext;
          paramContext = paramIntent.getStringExtra("qshadow_plugin_id");
          QLog.e("ExpandPluginLoadingFragment", 2, (Throwable)localObject, new Object[0]);
          paramIntent = new StringBuilder();
          paramIntent.append(paramContext);
          paramIntent.append(" 插件运行异常, errorCode: ");
          paramIntent.append(i);
          paramIntent = (Throwable)new HighPluginCrashException(paramIntent.toString(), (Throwable)localObject);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramContext);
          ((StringBuilder)localObject).append(" catch Exception");
          CaughtExceptionReport.a(paramIntent, ((StringBuilder)localObject).toString());
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type kotlin.Throwable");
        }
      }
      catch (Exception paramContext)
      {
        QLog.e("ExpandPluginLoadingFragment", 2, paramContext.getMessage());
        this.a.a(LoadingStatus.LOADING_ERROR, 1, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.plugin.entrance.ExpandPluginLoadingFragment.mReceiver.1
 * JD-Core Version:    0.7.0.1
 */