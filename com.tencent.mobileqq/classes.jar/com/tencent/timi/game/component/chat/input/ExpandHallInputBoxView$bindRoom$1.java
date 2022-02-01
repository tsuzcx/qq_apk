package com.tencent.timi.game.component.chat.input;

import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.lifecycle.LiveData;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomMediaEnvCheckCallback;
import com.tencent.timi.game.room.api.wrapper.IRoomAudioService;
import com.tencent.timi.game.router.ServiceCenter;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "onMediaEnvCheckFinish"}, k=3, mv={1, 1, 16})
final class ExpandHallInputBoxView$bindRoom$1
  implements YoloRoomInterface.YoloRoomMediaEnvCheckCallback
{
  ExpandHallInputBoxView$bindRoom$1(ExpandHallInputBoxView paramExpandHallInputBoxView, long paramLong) {}
  
  public final void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    Object localObject = ((IRoomService)ServiceCenter.a(IRoomService.class)).d(this.b);
    ExpandHallInputBoxView.a(this.a, ((IRoomAudioService)localObject).c());
    ExpandHallInputBoxView.b(this.a, ((IRoomAudioService)localObject).d());
    LiveData localLiveData = ((IRoomAudioService)localObject).c();
    if (localLiveData != null) {
      localLiveData.observeForever(ExpandHallInputBoxView.a(this.a));
    }
    localObject = ((IRoomAudioService)localObject).d();
    if (localObject != null) {
      ((LiveData)localObject).observeForever(ExpandHallInputBoxView.b(this.a));
    }
    localObject = ExpandHallInputBoxView.c(this.a);
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)new ExpandHallInputBoxView.bindRoom.1..special..inlined.apply.lambda.1(this));
    }
    localObject = ExpandHallInputBoxView.d(this.a);
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)new ExpandHallInputBoxView.bindRoom.1..special..inlined.apply.lambda.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.input.ExpandHallInputBoxView.bindRoom.1
 * JD-Core Version:    0.7.0.1
 */