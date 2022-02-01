package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class ilive_feeds_read$FollowTabRedPointRsp
  extends MessageMicro<FollowTabRedPointRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field err_code = PBField.initInt32(0);
  public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field red = PBField.initInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "err_code", "err_msg", "red" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, FollowTabRedPointRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_read.FollowTabRedPointRsp
 * JD-Core Version:    0.7.0.1
 */