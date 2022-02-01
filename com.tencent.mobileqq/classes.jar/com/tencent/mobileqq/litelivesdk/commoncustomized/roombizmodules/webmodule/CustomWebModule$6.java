package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.ilive.audiencepages.room.events.PlayerStateEvent;
import com.tencent.ilive.commonpages.room.VerticalViewPager;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerBuilderServiceInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class CustomWebModule$6
  implements Observer<PlayerStateEvent>
{
  CustomWebModule$6(CustomWebModule paramCustomWebModule) {}
  
  public void a(@Nullable PlayerStateEvent paramPlayerStateEvent)
  {
    QLog.d("IliveCustomWebModule", 1, "PlayerStateEvent playerState = " + paramPlayerStateEvent.playerState + " errCode = " + paramPlayerStateEvent.errCode);
    int i;
    switch (CustomWebModule.17.a[paramPlayerStateEvent.playerState.ordinal()])
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("state", String.valueOf(i));
        ((JSONObject)localObject).put("errCode", String.valueOf(paramPlayerStateEvent.errCode));
        paramPlayerStateEvent = "javascript:(__WEBVIEW_CLIENTAVSTATE(" + ((JSONObject)localObject).toString() + "))";
        if (this.a.a != null) {
          this.a.a.evaluateJavascript(paramPlayerStateEvent, new CustomWebModule.6.1(this));
        }
        return;
      }
      catch (JSONException paramPlayerStateEvent)
      {
        Object localObject;
        int j;
        paramPlayerStateEvent.printStackTrace();
      }
      i = 11;
      continue;
      i = 9;
      continue;
      i = 12;
      localObject = this.a.getAudienceRoomPager().getViewPager();
      j = ((VerticalViewPager)localObject).getCurrentItem() + 1;
      if (j <= ((VerticalViewPager)localObject).getAdapter().getCount() - 1) {
        ((VerticalViewPager)localObject).setCurrentItem(j);
      }
      CustomWebModule.a(this.a).seekTo(0);
      CustomWebModule.b(this.a, 0);
      continue;
      i = 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.CustomWebModule.6
 * JD-Core Version:    0.7.0.1
 */