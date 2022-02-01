package cooperation.ilive.lite.module;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveRoomInfo;
import com.tencent.mobileqq.litelivesdk.utils.log.LogFactory;
import com.tencent.mobileqq.litelivesdk.utils.log.LogInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.ilive.lite.event.IliveLiteEventCenter;

class IliveCloseBtnModule$1
  implements View.OnClickListener
{
  IliveCloseBtnModule$1(IliveCloseBtnModule paramIliveCloseBtnModule) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.getRoomBizContext() != null) && (this.a.getRoomBizContext().mLiveInfo != null) && (this.a.getRoomBizContext().mLiveInfo.roomInfo != null))
    {
      long l = this.a.getRoomBizContext().mLiveInfo.roomInfo.roomId;
      Bundle localBundle = new Bundle();
      localBundle.putLong("roomId", l);
      localBundle.putInt("closeFrom", 1003);
      if (!IliveLiteEventCenter.a().a("ACTION_CLOSE_ROOM", localBundle)) {
        IliveCloseBtnModule.a(this.a);
      }
    }
    else
    {
      IliveCloseBtnModule.a(this.a);
    }
    LogFactory.a().c(IliveCloseBtnModule.a(), "mCloseImageView");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveCloseBtnModule.1
 * JD-Core Version:    0.7.0.1
 */