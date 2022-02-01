package com.tencent.mobileqq.qqlive.prepare;

import com.tencent.mobileqq.qqlive.callback.game.IQQLiveGameListCallback;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomGameInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class PrepareDataRepository$1
  implements IQQLiveGameListCallback
{
  PrepareDataRepository$1(PrepareDataRepository paramPrepareDataRepository, GameListCallback paramGameListCallback) {}
  
  public void a(int paramInt, String paramString)
  {
    this.a.onFailed(paramInt, paramString);
  }
  
  public void a(ArrayList<QQLiveAnchorRoomGameInfo> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      QQLiveAnchorRoomGameInfo localQQLiveAnchorRoomGameInfo = (QQLiveAnchorRoomGameInfo)paramArrayList.next();
      GameItem localGameItem = new GameItem();
      localGameItem.a(localQQLiveAnchorRoomGameInfo.id);
      localGameItem.a(localQQLiveAnchorRoomGameInfo.name);
      localGameItem.b(localQQLiveAnchorRoomGameInfo.icon);
      localGameItem.b(localQQLiveAnchorRoomGameInfo.secondTagId);
      localArrayList.add(localGameItem);
    }
    this.a.a(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.PrepareDataRepository.1
 * JD-Core Version:    0.7.0.1
 */