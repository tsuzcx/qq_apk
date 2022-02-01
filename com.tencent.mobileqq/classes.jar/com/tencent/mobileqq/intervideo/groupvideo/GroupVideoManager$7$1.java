package com.tencent.mobileqq.intervideo.groupvideo;

import java.util.List;

class GroupVideoManager$7$1
  implements Runnable
{
  GroupVideoManager$7$1(GroupVideoManager.7 param7, List paramList) {}
  
  public void run()
  {
    IGroupVideoManager.CheckListener localCheckListener = this.this$0.a;
    List localList = this.a;
    boolean bool;
    if ((localList != null) && (localList.size() > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    localCheckListener.a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager.7.1
 * JD-Core Version:    0.7.0.1
 */