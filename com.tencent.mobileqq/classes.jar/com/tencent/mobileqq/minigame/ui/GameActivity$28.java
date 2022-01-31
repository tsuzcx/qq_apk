package com.tencent.mobileqq.minigame.ui;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoaderManager;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoaderManager.PREPARE_FROM;

class GameActivity$28
  implements Runnable
{
  GameActivity$28(GameActivity paramGameActivity) {}
  
  public void run()
  {
    GameRuntimeLoaderManager.g().prepare(BaseApplicationImpl.getApplication(), GameRuntimeLoaderManager.PREPARE_FROM.FIRST_FRAME);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.28
 * JD-Core Version:    0.7.0.1
 */