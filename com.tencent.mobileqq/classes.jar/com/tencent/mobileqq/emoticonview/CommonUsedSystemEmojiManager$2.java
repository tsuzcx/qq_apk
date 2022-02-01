package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.emosm.EmosmPb.SmallYellowItem;
import java.util.Comparator;

class CommonUsedSystemEmojiManager$2
  implements Comparator<EmosmPb.SmallYellowItem>
{
  CommonUsedSystemEmojiManager$2(CommonUsedSystemEmojiManager paramCommonUsedSystemEmojiManager) {}
  
  public int compare(EmosmPb.SmallYellowItem paramSmallYellowItem1, EmosmPb.SmallYellowItem paramSmallYellowItem2)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.CommonUsedSystemEmojiManager.2
 * JD-Core Version:    0.7.0.1
 */