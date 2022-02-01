package com.tencent.mobileqq.intervideo.groupvideo;

import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQGAudioMsgHandler;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.troop.utils.TroopVideoManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

class GroupVideoManager$5
  implements GVideoStateGetListener
{
  GroupVideoManager$5(GroupVideoManager paramGroupVideoManager) {}
  
  public void a(List<VideoStateInfo> paramList)
  {
    if (GroupVideoManager.a(this.a) == null) {
      return;
    }
    Object localObject = new HashMap(GroupVideoManager.a(this.a).getAVNotifyCenter().h);
    QQGAudioMsgHandler localQQGAudioMsgHandler = GroupVideoManager.a(this.a).getGAudioHandler();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VideoStateInfo localVideoStateInfo = (VideoStateInfo)paramList.next();
      long[] arrayOfLong = new long[localVideoStateInfo.f.size()];
      int i = 0;
      while (i < arrayOfLong.length)
      {
        arrayOfLong[i] = ((Long)localVideoStateInfo.f.get(i)).longValue();
        i += 1;
      }
      ((TroopVideoManager)GroupVideoManager.a(this.a).getManager(QQManagerFactory.TROOP_VIDEO_MANAGER)).a(localVideoStateInfo.a);
      localQQGAudioMsgHandler.a(1, String.valueOf(localVideoStateInfo.a), localVideoStateInfo.b, arrayOfLong, 14, localVideoStateInfo.d, localVideoStateInfo.e, localVideoStateInfo.g);
      ((Map)localObject).remove(String.valueOf(localVideoStateInfo.a));
    }
    paramList = ((Map)localObject).entrySet().iterator();
    while (paramList.hasNext())
    {
      localObject = (Map.Entry)paramList.next();
      if (((Integer)((Map.Entry)localObject).getValue()).intValue() == 14) {
        localQQGAudioMsgHandler.a(1, (String)((Map.Entry)localObject).getKey(), 0, null, 14, 0, 0, -1);
      }
    }
    paramList = GroupVideoManager.a(this.a).getHandler(Conversation.class);
    if (paramList != null) {
      paramList.sendEmptyMessage(1009);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager.5
 * JD-Core Version:    0.7.0.1
 */