package com.tencent.timi.game.component.qqlive.impl;

import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.timi.game.component.qqlive.api.TgCheckPermissionCallback;
import com.tencent.timi.game.component.qqlive.api.TgLiveAnchorStartListener;

class TgLiveRoomServiceImpl$1
  implements TgCheckPermissionCallback
{
  TgLiveRoomServiceImpl$1(TgLiveRoomServiceImpl paramTgLiveRoomServiceImpl, TgLiveAnchorStartListener paramTgLiveAnchorStartListener, QQLiveAnchorStreamRecordType paramQQLiveAnchorStreamRecordType, boolean paramBoolean) {}
  
  public void a()
  {
    this.d.b(new TgLiveRoomServiceImpl.1.1(this));
  }
  
  public void a(int paramInt, String paramString)
  {
    TgLiveAnchorStartListener localTgLiveAnchorStartListener = this.a;
    if (localTgLiveAnchorStartListener != null)
    {
      localTgLiveAnchorStartListener.a(paramInt, paramString);
      this.a.a(1, paramInt, paramString);
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    paramArrayOfString = this.a;
    if (paramArrayOfString != null)
    {
      paramArrayOfString.a(-1000, "需要确认授权才能正常开播哦");
      this.a.a(1, -1000, "需要确认授权才能正常开播哦");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.qqlive.impl.TgLiveRoomServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */