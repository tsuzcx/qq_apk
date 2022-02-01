package com.tencent.mobileqq.intervideo.yiqikan;

import android.os.Bundle;

public abstract interface IWatchTogetherRoomDelegate
{
  public abstract PushMessageDelegate a();
  
  public abstract void a(NewTogetherRoomMessageData paramNewTogetherRoomMessageData);
  
  public abstract void a(NewTogetherRoomMessageData paramNewTogetherRoomMessageData, Bundle paramBundle, OnOpenCloseRoomCallback paramOnOpenCloseRoomCallback);
  
  public abstract void b(NewTogetherRoomMessageData paramNewTogetherRoomMessageData, Bundle paramBundle, OnOpenCloseRoomCallback paramOnOpenCloseRoomCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.IWatchTogetherRoomDelegate
 * JD-Core Version:    0.7.0.1
 */