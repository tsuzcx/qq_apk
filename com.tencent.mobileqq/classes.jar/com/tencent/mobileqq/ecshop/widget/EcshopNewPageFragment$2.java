package com.tencent.mobileqq.ecshop.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.ecshop.view.controller.TabLayoutController;
import org.json.JSONException;
import org.json.JSONObject;

class EcshopNewPageFragment$2
  extends BroadcastReceiver
{
  EcshopNewPageFragment$2(EcshopNewPageFragment paramEcshopNewPageFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if ("com.tencent.mobileqq.ecshop.finish".equals(paramContext))
      {
        if (this.a.getActivity() != null) {
          this.a.getActivity().finish();
        }
      }
      else if ("action_notify_view_update".equals(paramContext))
      {
        boolean bool = false;
        int i = paramIntent.getIntExtra("businessId", 0);
        int j = paramIntent.getIntExtra("viewId", 0);
        if ((25 == i) && (j == 1)) {
          try
          {
            paramContext = new JSONObject(paramIntent.getStringExtra("extstr"));
            if (EcshopNewPageFragment.a(this.a) != null)
            {
              paramIntent = EcshopNewPageFragment.a(this.a);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.widget.EcshopNewPageFragment.2
 * JD-Core Version:    0.7.0.1
 */