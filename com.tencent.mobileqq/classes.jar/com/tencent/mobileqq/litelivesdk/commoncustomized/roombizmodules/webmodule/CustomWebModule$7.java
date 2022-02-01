package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.ilive.audiencepages.room.events.PlayerStateEvent;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerBuilderServiceInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class CustomWebModule$7
  implements Observer<PlayerStateEvent>
{
  CustomWebModule$7(CustomWebModule paramCustomWebModule) {}
  
  public void a(@Nullable PlayerStateEvent paramPlayerStateEvent)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("PlayerStateEvent playerState = ");
    ((StringBuilder)localObject).append(paramPlayerStateEvent.playerState);
    ((StringBuilder)localObject).append(" errCode = ");
    ((StringBuilder)localObject).append(paramPlayerStateEvent.errCode);
    QLog.d("IliveCustomWebModule", 1, ((StringBuilder)localObject).toString());
    int j = CustomWebModule.18.a[paramPlayerStateEvent.playerState.ordinal()];
    int i = 4;
    if ((j != 1) && (j != 2))
    {
      if (j != 3)
      {
        if (j != 4)
        {
          if (j != 5) {
            i = 0;
          }
        }
        else
        {
          i = 12;
          localObject = this.a.getAudienceRoomPager();
          j = ((IAudienceRoomPager)localObject).getCurrentIndex() + 1;
          if (j <= ((IAudienceRoomPager)localObject).getCount() - 1) {
            ((IAudienceRoomPager)localObject).setCurrentItem(j);
          }
          this.a.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.seekTo(0);
          CustomWebModule.a(this.a, 0);
        }
      }
      else {
        i = 9;
      }
    }
    else {
      i = 11;
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("state", String.valueOf(i));
      ((JSONObject)localObject).put("errCode", String.valueOf(paramPlayerStateEvent.errCode));
      paramPlayerStateEvent = new StringBuilder();
      paramPlayerStateEvent.append("javascript:(__WEBVIEW_CLIENTAVSTATE(");
      paramPlayerStateEvent.append(((JSONObject)localObject).toString());
      paramPlayerStateEvent.append("))");
      paramPlayerStateEvent = paramPlayerStateEvent.toString();
      if (this.a.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
      {
        this.a.jdField_a_of_type_ComTencentBizUiTouchWebView.evaluateJavascript(paramPlayerStateEvent, new CustomWebModule.7.1(this));
        return;
      }
    }
    catch (JSONException paramPlayerStateEvent)
    {
      paramPlayerStateEvent.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.CustomWebModule.7
 * JD-Core Version:    0.7.0.1
 */