package cooperation.qqlive.bizmodule;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilive.pages.room.bizmodule.RoomBizModule;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.qphone.base.util.QLog;

public class QQLiveBaseRoomBizModule
  extends RoomBizModule
{
  protected long a()
  {
    if ((getRoomBizContext() != null) && (getRoomBizContext().getEnterRoomInfo() != null)) {
      return getRoomBizContext().getEnterRoomInfo().roomId;
    }
    return 0L;
  }
  
  protected long b()
  {
    if ((getRoomBizContext() != null) && (getRoomBizContext().getEnterRoomInfo() != null)) {
      return getRoomBizContext().getEnterRoomInfo().extData.getLong("ext_enter_room_video_source_app_id", 0L);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getVideoSource] get enter room info null! getRoomBizContext():");
    localStringBuilder.append(getRoomBizContext());
    QLog.e("QQLiveBaseRoomBizModule", 1, localStringBuilder.toString());
    return 0L;
  }
  
  protected int c()
  {
    if ((getRoomBizContext() != null) && (getRoomBizContext().getEnterRoomInfo() != null)) {
      return getRoomBizContext().getEnterRoomInfo().extData.getInt("ext_enter_room_game_id", 0);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getGameType] get enter room info null! getRoomBizContext():");
    localStringBuilder.append(getRoomBizContext());
    QLog.e("QQLiveBaseRoomBizModule", 1, localStringBuilder.toString());
    return 0;
  }
  
  protected int d()
  {
    if ((getRoomBizContext() != null) && (getRoomBizContext().getEnterRoomInfo() != null)) {
      return getRoomBizContext().getEnterRoomInfo().extData.getInt("ext_enter_room_game_tag_id", 0);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getGameTagId] get enter room info null! getRoomBizContext():");
    localStringBuilder.append(getRoomBizContext());
    QLog.e("QQLiveBaseRoomBizModule", 1, localStringBuilder.toString());
    return 0;
  }
  
  protected int e()
  {
    if ((getRoomBizContext() != null) && (getRoomBizContext().getEnterRoomInfo() != null)) {
      return getRoomBizContext().getEnterRoomInfo().extData.getInt("ext_enter_room_room_type", 0);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getRoomType] get enter room info null! getRoomBizContext():");
    localStringBuilder.append(getRoomBizContext());
    QLog.e("QQLiveBaseRoomBizModule", 1, localStringBuilder.toString());
    return 0;
  }
  
  protected String f()
  {
    Object localObject = getRoomBizContext();
    String str = "";
    if (localObject == null)
    {
      QLog.e("QQLiveBaseRoomBizModule", 1, "[getSource] get enter room info null!");
      return "";
    }
    localObject = ((RoomBizContext)localObject).getEnterRoomInfo();
    if (localObject == null)
    {
      QLog.e("QQLiveBaseRoomBizModule", 1, "[getSource] get enter room info null!");
      return "";
    }
    if (!TextUtils.isEmpty(((EnterRoomInfo)localObject).source)) {
      return ((EnterRoomInfo)localObject).source;
    }
    if (((EnterRoomInfo)localObject).extData != null) {
      str = ((EnterRoomInfo)localObject).extData.getString("source", "");
    }
    return str;
  }
  
  protected String g()
  {
    if ((getRoomBizContext() != null) && (getRoomBizContext().getEnterRoomInfo() != null)) {
      return getRoomBizContext().getEnterRoomInfo().extData.getString("trace_info");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getTraceInfo] get enter room info null! getRoomBizContext():");
    localStringBuilder.append(getRoomBizContext());
    QLog.e("QQLiveBaseRoomBizModule", 1, localStringBuilder.toString());
    return "";
  }
  
  protected Bundle h()
  {
    if ((getRoomBizContext() != null) && (getRoomBizContext().getEnterRoomInfo() != null)) {
      return getRoomBizContext().getEnterRoomInfo().extData;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqlive.bizmodule.QQLiveBaseRoomBizModule
 * JD-Core Version:    0.7.0.1
 */