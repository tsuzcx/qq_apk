package com.tencent.mobileqq.kandian.repo.feeds.entity;

import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.articlesummary.feeds_info.VisibleShowInfo;

public class PrivacyShowInfo
  implements Cloneable
{
  public int a;
  public long a;
  public long b = 0L;
  
  public PrivacyShowInfo()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public static PrivacyShowInfo a(feeds_info.VisibleShowInfo paramVisibleShowInfo)
  {
    PrivacyShowInfo localPrivacyShowInfo = new PrivacyShowInfo();
    boolean bool = paramVisibleShowInfo.uint64_feed_id.has();
    long l2 = 0L;
    if (bool) {
      l1 = paramVisibleShowInfo.uint64_feed_id.get();
    } else {
      l1 = 0L;
    }
    localPrivacyShowInfo.b = l1;
    int i;
    if (paramVisibleShowInfo.uint32_visible_type.has()) {
      i = paramVisibleShowInfo.uint32_visible_type.get();
    } else {
      i = 0;
    }
    localPrivacyShowInfo.jdField_a_of_type_Int = i;
    long l1 = l2;
    if (paramVisibleShowInfo.uint64_who.has()) {
      l1 = paramVisibleShowInfo.uint64_who.get();
    }
    localPrivacyShowInfo.jdField_a_of_type_Long = l1;
    paramVisibleShowInfo = new StringBuilder();
    paramVisibleShowInfo.append("feeds privacy | feedsid  ");
    paramVisibleShowInfo.append(localPrivacyShowInfo.b);
    paramVisibleShowInfo.append(" | privacyType ");
    paramVisibleShowInfo.append(localPrivacyShowInfo.jdField_a_of_type_Int);
    paramVisibleShowInfo.append(" | privacySetUin ");
    paramVisibleShowInfo.append(localPrivacyShowInfo.jdField_a_of_type_Long);
    QLog.d("PrivacyShowInfo", 1, paramVisibleShowInfo.toString());
    return localPrivacyShowInfo;
  }
  
  public PrivacyShowInfo a()
  {
    try
    {
      PrivacyShowInfo localPrivacyShowInfo = (PrivacyShowInfo)super.clone();
      return localPrivacyShowInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label10:
      break label10;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.PrivacyShowInfo
 * JD-Core Version:    0.7.0.1
 */