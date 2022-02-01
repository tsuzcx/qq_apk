package tencent.im.oidb.cmd0x977;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x977$RspFollowData
  extends MessageMicro<RspFollowData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0x977.FollowListInfo msg_follow_list = new oidb_cmd0x977.FollowListInfo();
  public final PBEnumField op_type = PBField.initEnum(1);
  public final PBUInt32Field uint32_is_no_more_data = PBField.initUInt32(0);
  public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_total_count = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 90, 96, 106 }, new String[] { "op_type", "uint32_is_no_more_data", "uint64_total_count", "bytes_cookie", "uint64_dst_uin", "msg_follow_list" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro, Long.valueOf(0L), null }, RspFollowData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x977.oidb_cmd0x977.RspFollowData
 * JD-Core Version:    0.7.0.1
 */