package com.tencent.mobileqq.hotchat;

import java.util.Comparator;

class HotChatSCMng$1
  implements Comparator<HotChatNote>
{
  HotChatSCMng$1(HotChatSCMng paramHotChatSCMng) {}
  
  public int a(HotChatNote paramHotChatNote1, HotChatNote paramHotChatNote2)
  {
    if (paramHotChatNote1 != null)
    {
      if (paramHotChatNote2 == null) {
        return 0;
      }
      if (paramHotChatNote1.e > paramHotChatNote2.e) {
        return 1;
      }
      if (paramHotChatNote1.e < paramHotChatNote2.e) {
        return -1;
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.HotChatSCMng.1
 * JD-Core Version:    0.7.0.1
 */