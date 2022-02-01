package com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice;

import android.widget.TextView;
import com.tencent.falco.base.libapi.network.OnNetworkListener;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "closed", "", "<anonymous parameter 1>", "onNetWorkChange"}, k=3, mv={1, 1, 16})
final class MultiVoiceFloatingWindowModule$onNetworkListener$1
  implements OnNetworkListener
{
  MultiVoiceFloatingWindowModule$onNetworkListener$1(MultiVoiceFloatingWindowModule paramMultiVoiceFloatingWindowModule) {}
  
  public final void onNetWorkChange(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (MultiVoiceFloatingWindowModule.k(this.a) == null) {
      return;
    }
    if (!MultiVoiceFloatingWindowModule.n(this.a)) {
      return;
    }
    Object localObject = MultiVoiceFloatingWindowModule.b(this.a);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "roomBizContext");
    int i = ((RoomBizContext)localObject).getEnterRoomInfo().bootModulesIndex;
    localObject = this.a.getAudienceRoomPager();
    if (localObject != null)
    {
      if (i != ((IAudienceRoomPager)localObject).getCurrentIndex()) {
        return;
      }
      if (paramBoolean1)
      {
        localObject = MultiVoiceFloatingWindowModule.i(this.a);
        if (localObject != null)
        {
          ((TextView)localObject).setText(2131892224);
          ((TextView)localObject).postDelayed((Runnable)new MultiVoiceFloatingWindowModule.onNetworkListener.1.1.1((TextView)localObject), 5000L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.MultiVoiceFloatingWindowModule.onNetworkListener.1
 * JD-Core Version:    0.7.0.1
 */