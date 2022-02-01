package com.tencent.mobileqq.troop.avatar;

import com.tencent.mobileqq.data.troop.TroopClipPic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TroopUploadingTask
  extends UploadingTask
{
  public void a(Class<? extends Thread> paramClass, ArrayList<TroopClipPic> paramArrayList, HashMap<String, String> paramHashMap, List<String> paramList, BaseUrlAction paramBaseUrlAction)
  {
    if ((this.a == null) || (this.a.getState() == Thread.State.TERMINATED)) {
      this.a = ((TroopUploadingThread)UploadingFactory.b(paramClass));
    }
    if (this.a == null) {
      return;
    }
    this.a.a(paramArrayList, paramHashMap, paramList, this);
    this.a.a(paramBaseUrlAction);
    if (!this.a.isAlive()) {
      this.a.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.TroopUploadingTask
 * JD-Core Version:    0.7.0.1
 */