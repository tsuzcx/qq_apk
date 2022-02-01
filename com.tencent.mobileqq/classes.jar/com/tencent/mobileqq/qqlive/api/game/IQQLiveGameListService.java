package com.tencent.mobileqq.qqlive.api.game;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.game.IQQLiveGameListCallback;

public abstract interface IQQLiveGameListService
  extends IQQLiveModule
{
  public abstract void getGameList(IQQLiveGameListCallback paramIQQLiveGameListCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.game.IQQLiveGameListService
 * JD-Core Version:    0.7.0.1
 */