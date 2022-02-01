package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.emosm.EmosmPb.SmallYellowItem;
import java.util.Comparator;

class CommonUsedSystemEmojiManagerServiceImpl$2
  implements Comparator<EmosmPb.SmallYellowItem>
{
  CommonUsedSystemEmojiManagerServiceImpl$2(CommonUsedSystemEmojiManagerServiceImpl paramCommonUsedSystemEmojiManagerServiceImpl) {}
  
  public int a(EmosmPb.SmallYellowItem paramSmallYellowItem1, EmosmPb.SmallYellowItem paramSmallYellowItem2)
  {
    if (paramSmallYellowItem2.ts.get() > paramSmallYellowItem1.ts.get()) {
      return 1;
    }
    if (paramSmallYellowItem2.ts.get() == paramSmallYellowItem1.ts.get()) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.CommonUsedSystemEmojiManagerServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */