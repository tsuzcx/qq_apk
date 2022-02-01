package com.tencent.mobileqq.minigame.ui;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.colornote.smallscreen.IServiceSyncListener;
import com.tencent.mobileqq.qroute.QRoute;

class GameActivity1$4
  implements IServiceSyncListener
{
  GameActivity1$4(GameActivity1 paramGameActivity1) {}
  
  public void onServiceSyncSucc(boolean paramBoolean)
  {
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity1.4
 * JD-Core Version:    0.7.0.1
 */