package com.tencent.mobileqq.intervideo.now.dynamic;

import android.os.Bundle;
import com.tencent.intervideo.nowproxy.NowLive;
import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.mobileqq.intervideo.yiqikan.PushMessageDelegate;

class DynamicNowManager$12
  implements PushMessageDelegate
{
  DynamicNowManager$12(DynamicNowManager paramDynamicNowManager) {}
  
  public void a(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("ctrl_cmd", 101);
    NowLive.sendServerPushMessage(DynamicNowManager.a(this.a, localBundle, paramNewTogetherRoomMessageData));
  }
  
  public void b(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("ctrl_cmd", 102);
    NowLive.sendServerPushMessage(DynamicNowManager.a(this.a, localBundle, paramNewTogetherRoomMessageData));
  }
  
  public void c(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("ctrl_cmd", 103);
    NowLive.sendServerPushMessage(DynamicNowManager.a(this.a, localBundle, paramNewTogetherRoomMessageData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager.12
 * JD-Core Version:    0.7.0.1
 */