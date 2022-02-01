package com.tencent.mobileqq.utils;

import java.util.Observable;

public class AIOAnimationControlManager$DownloadGiftResStateObservable
  extends Observable
{
  private static DownloadGiftResStateObservable a;
  
  public static DownloadGiftResStateObservable a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new DownloadGiftResStateObservable();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void setChanged()
  {
    super.setChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AIOAnimationControlManager.DownloadGiftResStateObservable
 * JD-Core Version:    0.7.0.1
 */