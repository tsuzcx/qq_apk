package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobileqq_mp$GetUserFollowListRequest
  extends MessageMicro<GetUserFollowListRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56 }, new String[] { "follow_seqno", "public_account_seqno", "begin", "limit", "is_increment", "group_info_seqno", "version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0) }, GetUserFollowListRequest.class);
  public final PBUInt32Field begin = PBField.initUInt32(0);
  public final PBUInt32Field follow_seqno = PBField.initUInt32(0);
  public final PBUInt32Field group_info_seqno = PBField.initUInt32(0);
  public final PBBoolField is_increment = PBField.initBool(false);
  public final PBUInt32Field limit = PBField.initUInt32(0);
  public final PBUInt32Field public_account_seqno = PBField.initUInt32(0);
  public final PBUInt32Field version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.GetUserFollowListRequest
 * JD-Core Version:    0.7.0.1
 */