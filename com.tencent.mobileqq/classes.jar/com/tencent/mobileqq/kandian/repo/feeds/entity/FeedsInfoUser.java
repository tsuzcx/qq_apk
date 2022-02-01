package com.tencent.mobileqq.kandian.repo.feeds.entity;

import com.tencent.mobileqq.kandian.base.ktx.PBFieldUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsInfoUser;

public class FeedsInfoUser
  implements Cloneable
{
  public int a;
  public long a;
  public String a;
  public int b;
  public int c = 1;
  
  public FeedsInfoUser a()
  {
    try
    {
      FeedsInfoUser localFeedsInfoUser = (FeedsInfoUser)super.clone();
      return localFeedsInfoUser;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label10:
      break label10;
    }
    return null;
  }
  
  public void a(articlesummary.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    long l;
    if (paramSocializeFeedsInfo.msg_master_uin.has()) {
      l = PBFieldUtils.a(((articlesummary.SocializeFeedsInfoUser)paramSocializeFeedsInfo.msg_master_uin.get()).uint64_uin);
    } else {
      l = 0L;
    }
    this.jdField_a_of_type_Long = l;
    boolean bool = paramSocializeFeedsInfo.msg_master_uin.has();
    int j = 0;
    if (bool) {
      i = PBFieldUtils.a(((articlesummary.SocializeFeedsInfoUser)paramSocializeFeedsInfo.msg_master_uin.get()).enum_uin_type);
    } else {
      i = 0;
    }
    this.jdField_a_of_type_Int = i;
    int i = j;
    if (paramSocializeFeedsInfo.msg_master_uin.has()) {
      i = PBFieldUtils.a(((articlesummary.SocializeFeedsInfoUser)paramSocializeFeedsInfo.msg_master_uin.get()).uint32_star_style);
    }
    this.b = i;
    bool = paramSocializeFeedsInfo.msg_master_uin.has();
    String str2 = "";
    String str1 = str2;
    if (bool)
    {
      str1 = str2;
      if (paramSocializeFeedsInfo.msg_master_uin.bytes_person_desc.has()) {
        str1 = paramSocializeFeedsInfo.msg_master_uin.bytes_person_desc.get().toStringUtf8();
      }
    }
    this.jdField_a_of_type_JavaLangString = str1;
    if ((paramSocializeFeedsInfo.msg_master_uin.has()) && (paramSocializeFeedsInfo.msg_master_uin.uint32_is_real_user.has())) {
      this.c = paramSocializeFeedsInfo.msg_master_uin.uint32_is_real_user.get();
    }
  }
  
  public boolean a()
  {
    return this.b == 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("type=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser
 * JD-Core Version:    0.7.0.1
 */