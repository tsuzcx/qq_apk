package com.tencent.mobileqq.hotchat;

import android.support.v4.util.LruCache;

class PttShowRoomMng$1
  extends LruCache<String, PttShowRoomMng.Guest>
{
  PttShowRoomMng$1(PttShowRoomMng paramPttShowRoomMng, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(String paramString, PttShowRoomMng.Guest paramGuest)
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.PttShowRoomMng.1
 * JD-Core Version:    0.7.0.1
 */