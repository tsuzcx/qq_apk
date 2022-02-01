package com.tencent.timi.game.room.impl;

import android.graphics.Bitmap;
import com.tencent.timi.game.live.api.TakeSnapshotCallback;
import com.tencent.trtc.TRTCCloudListener.TRTCSnapshotListener;

class YoloRoomManager$50$1
  implements TRTCCloudListener.TRTCSnapshotListener
{
  public void onSnapshotComplete(Bitmap paramBitmap)
  {
    this.a.a(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomManager.50.1
 * JD-Core Version:    0.7.0.1
 */