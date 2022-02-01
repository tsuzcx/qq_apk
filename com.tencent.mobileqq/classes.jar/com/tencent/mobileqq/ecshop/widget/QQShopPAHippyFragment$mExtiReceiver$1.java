package com.tencent.mobileqq.ecshop.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.ecshop.view.controller.TabLayoutController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/ecshop/widget/QQShopPAHippyFragment$mExtiReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class QQShopPAHippyFragment$mExtiReceiver$1
  extends BroadcastReceiver
{
  public void onReceive(@NotNull Context paramContext, @NotNull Intent paramIntent)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    paramContext = paramIntent.getAction();
    if (Intrinsics.areEqual("com.tencent.mobileqq.ecshop.finish", paramContext))
    {
      paramContext = this.a.getActivity();
      if (paramContext != null) {
        paramContext.finish();
      }
    }
    else if (Intrinsics.areEqual("action_notify_view_update", paramContext))
    {
      boolean bool = false;
      int i = paramIntent.getIntExtra("businessId", 0);
      int j = paramIntent.getIntExtra("viewId", 0);
      if ((25 == i) && (j == 1)) {
        try
        {
          paramContext = new JSONObject(paramIntent.getStringExtra("extstr"));
          paramIntent = QQShopPAHippyFragment.b(this.a);
          if (paramIntent != null)
          {
            if (paramContext.optInt("isShow") == 1) {
              bool = true;
            }
            paramIntent.a(bool);
            return;
          }
        }
        catch (JSONException paramContext)
        {
          paramContext.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.widget.QQShopPAHippyFragment.mExtiReceiver.1
 * JD-Core Version:    0.7.0.1
 */