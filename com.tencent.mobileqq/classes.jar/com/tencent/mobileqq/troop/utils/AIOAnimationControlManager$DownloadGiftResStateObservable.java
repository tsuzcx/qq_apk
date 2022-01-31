package com.tencent.mobileqq.troop.utils;

import java.util.Observable;

public class AIOAnimationControlManager$DownloadGiftResStateObservable
  extends Observable
{
  private static DownloadGiftResStateObservable a;
  
  public static DownloadGiftResStateObservable a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new DownloadGiftResStateObservable();
      }
      return a;
    }
    finally {}
  }
  
  public void setChanged()
  {
    super.setChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.DownloadGiftResStateObservable
 * JD-Core Version:    0.7.0.1
 */