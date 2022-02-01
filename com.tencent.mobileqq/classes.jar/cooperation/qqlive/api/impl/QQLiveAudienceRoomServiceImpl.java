package cooperation.qqlive.api.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.qqlive.data.record.QQLiveSwitchRoom;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqlive.api.IQQLiveAudienceRoomService;

public class QQLiveAudienceRoomServiceImpl
  implements IQQLiveAudienceRoomService
{
  private static final String TAG = "QQLiveAudienceRoomServiceImpl";
  
  public static String addSchemeParams(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null) {
      return "";
    }
    if (paramString1.contains("?"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("&");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("=");
      localStringBuilder.append(paramString3);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("?");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("=");
    localStringBuilder.append(paramString3);
    return localStringBuilder.toString();
  }
  
  public void enterAudienceRoom(Context paramContext, QQLiveSwitchRoom paramQQLiveSwitchRoom)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enterAudienceRoom room:");
      ((StringBuilder)localObject).append(paramQQLiveSwitchRoom);
      QLog.d("QQLiveAudienceRoomServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    paramQQLiveSwitchRoom = addSchemeParams(addSchemeParams(addSchemeParams(addSchemeParams(addSchemeParams("mqqapi://vaslive/watch?roomid={roomid}".replace("{roomid}", String.valueOf(paramQQLiveSwitchRoom.roomId)), "from", "99"), "room_type", String.valueOf(paramQQLiveSwitchRoom.roomType)), "video_source", String.valueOf(paramQQLiveSwitchRoom.videoSource)), "game_id", String.valueOf(paramQQLiveSwitchRoom.gameId)), "game_tag_id", String.valueOf(paramQQLiveSwitchRoom.gameTagId));
    Object localObject = new Intent(paramContext, JumpActivity.class);
    ((Intent)localObject).setData(Uri.parse(paramQQLiveSwitchRoom));
    paramContext.startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqlive.api.impl.QQLiveAudienceRoomServiceImpl
 * JD-Core Version:    0.7.0.1
 */