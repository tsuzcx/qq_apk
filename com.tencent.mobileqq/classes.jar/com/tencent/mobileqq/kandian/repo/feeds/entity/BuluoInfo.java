package com.tencent.mobileqq.kandian.repo.feeds.entity;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.articlesummary.BuluoInfo;

public class BuluoInfo
{
  public long a;
  public String a;
  public String b;
  public String c;
  public String d;
  
  public static BuluoInfo a(articlesummary.BuluoInfo paramBuluoInfo)
  {
    BuluoInfo localBuluoInfo = new BuluoInfo();
    boolean bool = paramBuluoInfo.bytes_wording.has();
    String str2 = "";
    if (bool) {
      str1 = paramBuluoInfo.bytes_wording.get().toStringUtf8();
    } else {
      str1 = "";
    }
    localBuluoInfo.jdField_a_of_type_JavaLangString = str1;
    if (paramBuluoInfo.bytes_head_url.has()) {
      str1 = paramBuluoInfo.bytes_head_url.get().toStringUtf8();
    } else {
      str1 = "";
    }
    localBuluoInfo.d = str1;
    localBuluoInfo.jdField_a_of_type_Long = paramBuluoInfo.uint64_buluo_id.get();
    if (paramBuluoInfo.bytes_jump_url.has()) {
      str1 = paramBuluoInfo.bytes_jump_url.get().toStringUtf8();
    } else {
      str1 = "";
    }
    localBuluoInfo.b = str1;
    String str1 = str2;
    if (paramBuluoInfo.bytes_name.has()) {
      str1 = paramBuluoInfo.bytes_name.get().toStringUtf8();
    }
    localBuluoInfo.c = str1;
    return localBuluoInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.BuluoInfo
 * JD-Core Version:    0.7.0.1
 */