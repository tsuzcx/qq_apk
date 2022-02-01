package com.tencent.mobileqq.intervideo.groupvideo;

import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.mobileqq.intervideo.yiqikan.PushMessageDelegate;
import com.tencent.qphone.base.util.QLog;

class CommunicateWithPluginHandler$1
  implements PushMessageDelegate
{
  CommunicateWithPluginHandler$1(CommunicateWithPluginHandler paramCommunicateWithPluginHandler) {}
  
  public void a(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    QLog.i("GroupVideoManager|Communicate", 2, "receive startWatchTogether: " + paramNewTogetherRoomMessageData.toString());
    CommunicateWithPluginHandler.a(this.a, paramNewTogetherRoomMessageData, 1);
  }
  
  public void b(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    QLog.i("GroupVideoManager|Communicate", 2, "receive switchWatchTogether: " + paramNewTogetherRoomMessageData.toString());
    CommunicateWithPluginHandler.a(this.a, paramNewTogetherRoomMessageData, 3);
  }
  
  public void c(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    QLog.i("GroupVideoManager|Communicate", 2, "receive closeWatchTogether: " + paramNewTogetherRoomMessageData.toString());
    CommunicateWithPluginHandler.a(this.a, paramNewTogetherRoomMessageData, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.CommunicateWithPluginHandler.1
 * JD-Core Version:    0.7.0.1
 */