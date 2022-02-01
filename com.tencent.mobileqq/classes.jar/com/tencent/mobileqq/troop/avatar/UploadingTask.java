package com.tencent.mobileqq.troop.avatar;

import com.tencent.mobileqq.data.troop.TroopClipPic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public abstract class UploadingTask
  extends Observable
{
  protected TroopUploadingThread a;
  
  public ArrayList<UploadItem> a()
  {
    TroopUploadingThread localTroopUploadingThread = this.a;
    if (localTroopUploadingThread != null) {
      return localTroopUploadingThread.a();
    }
    return null;
  }
  
  public abstract void a(Class<? extends Thread> paramClass, ArrayList<TroopClipPic> paramArrayList, HashMap<String, String> paramHashMap, List<String> paramList, BaseUrlAction paramBaseUrlAction);
  
  public void a(Observer paramObserver)
  {
    super.deleteObserver(paramObserver);
  }
  
  public void notifyObservers(Object paramObject)
  {
    super.setChanged();
    super.notifyObservers(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.UploadingTask
 * JD-Core Version:    0.7.0.1
 */