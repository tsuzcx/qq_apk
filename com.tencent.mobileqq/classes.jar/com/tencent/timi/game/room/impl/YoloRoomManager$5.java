package com.tencent.timi.game.room.impl;

import com.tencent.timi.game.tim.api.group.IGroupMemberInfo;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.IResultListener;
import java.util.Iterator;
import java.util.List;

class YoloRoomManager$5
  implements IResultListener<List<IGroupMemberInfo>>
{
  YoloRoomManager$5(YoloRoomManager paramYoloRoomManager, String paramString1, String paramString2) {}
  
  public void a(int paramInt, String paramString)
  {
    CustomToastView.a(this.b);
    YoloRoomManager.b(this.c);
  }
  
  public void a(List<IGroupMemberInfo> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext()) {
      if (((IGroupMemberInfo)paramList.next()).a().equals(this.a)) {
        i = 1;
      }
    }
    if (i == 0)
    {
      CustomToastView.a(this.b);
      YoloRoomManager.b(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomManager.5
 * JD-Core Version:    0.7.0.1
 */