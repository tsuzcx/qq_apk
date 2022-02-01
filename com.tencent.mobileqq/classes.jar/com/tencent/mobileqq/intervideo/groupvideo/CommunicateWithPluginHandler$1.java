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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("receive startWatchTogether: ");
    localStringBuilder.append(paramNewTogetherRoomMessageData.toString());
    QLog.i("GroupVideoManager|Communicate", 2, localStringBuilder.toString());
    CommunicateWithPluginHandler.a(this.a, paramNewTogetherRoomMessageData, 1);
  }
  
  public void b(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("receive switchWatchTogether: ");
    localStringBuilder.append(paramNewTogetherRoomMessageData.toString());
    QLog.i("GroupVideoManager|Communicate", 2, localStringBuilder.toString());
    CommunicateWithPluginHandler.a(this.a, paramNewTogetherRoomMessageData, 3);
  }
  
  public void c(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("receive closeWatchTogether: ");
    localStringBuilder.append(paramNewTogetherRoomMessageData.toString());
    QLog.i("GroupVideoManager|Communicate", 2, localStringBuilder.toString());
    CommunicateWithPluginHandler.a(this.a, paramNewTogetherRoomMessageData, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.CommunicateWithPluginHandler.1
 * JD-Core Version:    0.7.0.1
 */