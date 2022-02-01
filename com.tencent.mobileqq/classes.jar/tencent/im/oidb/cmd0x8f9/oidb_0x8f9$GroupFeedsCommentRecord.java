package tencent.im.oidb.cmd0x8f9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.trunk.group_feeds.group_feeds.GroupFeedsMessage;

public final class oidb_0x8f9$GroupFeedsCommentRecord
  extends MessageMicro<GroupFeedsCommentRecord>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
  public group_feeds.GroupFeedsMessage msg_comment_content = new group_feeds.GroupFeedsMessage();
  public oidb_0x8f9.SourceID msg_source_id = new oidb_0x8f9.SourceID();
  public final PBUInt32Field uint32_comment_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_comment_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_modify_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56, 66, 74 }, new String[] { "bytes_feeds_id", "msg_source_id", "uint64_from_uin", "uint32_comment_id", "uint32_comment_flag", "uint32_create_time", "uint32_modify_time", "bytes_reserve", "msg_comment_content" }, new Object[] { localByteStringMicro1, null, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, null }, GroupFeedsCommentRecord.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f9.oidb_0x8f9.GroupFeedsCommentRecord
 * JD-Core Version:    0.7.0.1
 */