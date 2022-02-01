package com.tencent.mobileqq.minigame.manager;

import com.tencent.common.app.BaseApplicationImpl;

class GameRuntimeLoaderManager$1
  implements Runnable
{
  GameRuntimeLoaderManager$1(GameRuntimeLoaderManager paramGameRuntimeLoaderManager) {}
  
  public void run()
  {
    this.this$0.prepare(BaseApplicationImpl.getApplication(), GameRuntimeLoaderManager.PREPARE_FROM.AUTO_PREPARE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameRuntimeLoaderManager.1
 * JD-Core Version:    0.7.0.1
 */