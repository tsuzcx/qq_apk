package cooperation.qqlive.api;

import android.content.Context;
import com.tencent.mobileqq.qqlive.data.record.QQLiveSwitchRoom;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"tool"})
public abstract interface IQQLiveAudienceRoomService
  extends QRouteApi
{
  public abstract void enterAudienceRoom(Context paramContext, QQLiveSwitchRoom paramQQLiveSwitchRoom);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqlive.api.IQQLiveAudienceRoomService
 * JD-Core Version:    0.7.0.1
 */