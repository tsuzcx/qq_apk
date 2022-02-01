package com.tencent.mobileqq.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class HotChatFragment$2
  extends BroadcastReceiver
{
  HotChatFragment$2(HotChatFragment paramHotChatFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.tencent.mobileqq.get_banner_rect".equals(paramIntent.getAction())))
    {
      paramContext = paramIntent.getStringExtra("content");
      if (TextUtils.isEmpty(paramContext)) {
        return;
      }
      try
      {
        paramContext = new JSONObject(paramContext).getJSONObject("params").getJSONArray("bannerHeight");
        if (paramContext == null) {
          return;
        }
        float f = this.a.ag.getResources().getDisplayMetrics().density;
        int j = paramContext.length();
        this.a.e.clear();
        int i = 0;
        while (i < j)
        {
          paramIntent = paramContext.getJSONObject(i);
          Rect localRect = new Rect();
          localRect.top = ((int)(paramIntent.getInt("top") * f));
          localRect.bottom = ((int)(paramIntent.getInt("bottom") * f));
          this.a.e.add(localRect);
          i += 1;
        }
        this.a.f = true;
        return;
      }
      catch (JSONException paramContext)
      {
        if (QLog.isDevelopLevel()) {
          paramContext.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.HotChatFragment.2
 * JD-Core Version:    0.7.0.1
 */