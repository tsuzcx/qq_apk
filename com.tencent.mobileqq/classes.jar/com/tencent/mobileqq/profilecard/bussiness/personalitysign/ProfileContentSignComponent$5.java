package com.tencent.mobileqq.profilecard.bussiness.personalitysign;

import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.Comparator;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.TopicItem;

class ProfileContentSignComponent$5
  implements Comparator<oidb_0xd9f.TopicItem>
{
  ProfileContentSignComponent$5(ProfileContentSignComponent paramProfileContentSignComponent) {}
  
  public int compare(oidb_0xd9f.TopicItem paramTopicItem1, oidb_0xd9f.TopicItem paramTopicItem2)
  {
    if (paramTopicItem1 == null) {}
    do
    {
      return 1;
      if (paramTopicItem2 == null) {
        return -1;
      }
    } while (paramTopicItem1.uint32_frd_num.get() <= paramTopicItem2.uint32_frd_num.get());
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.personalitysign.ProfileContentSignComponent.5
 * JD-Core Version:    0.7.0.1
 */