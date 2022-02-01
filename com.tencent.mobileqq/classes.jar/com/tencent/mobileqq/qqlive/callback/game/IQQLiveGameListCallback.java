package com.tencent.mobileqq.qqlive.callback.game;

import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomGameInfo;
import java.util.ArrayList;

public abstract interface IQQLiveGameListCallback
{
  public abstract void a(int paramInt, String paramString);
  
  public abstract void a(ArrayList<QQLiveAnchorRoomGameInfo> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.callback.game.IQQLiveGameListCallback
 * JD-Core Version:    0.7.0.1
 */