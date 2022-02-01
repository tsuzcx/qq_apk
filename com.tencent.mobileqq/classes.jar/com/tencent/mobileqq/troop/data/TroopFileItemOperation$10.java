package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import mqq.os.MqqHandler;

class TroopFileItemOperation$10
  implements ThreadExcutor.IThreadListener
{
  TroopFileItemOperation$10(TroopFileItemOperation paramTroopFileItemOperation, TroopFileTransferManager paramTroopFileTransferManager, TroopFileInfo paramTroopFileInfo) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    ThreadManager.getUIHandler().post(new TroopFileItemOperation.10.1(this));
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileItemOperation.10
 * JD-Core Version:    0.7.0.1
 */