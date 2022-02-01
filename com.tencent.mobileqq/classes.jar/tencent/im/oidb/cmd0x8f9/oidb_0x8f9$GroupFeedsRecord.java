package tencent.im.oidb.cmd0x8f9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.trunk.feeds_inner_define.feeds_inner_define.FaceRecordSet;
import com.trunk.group_feeds.group_feeds.GroupFeedsMessage;

public final class oidb_0x8f9$GroupFeedsRecord
  extends MessageMicro<GroupFeedsRecord>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
  public feeds_inner_define.FaceRecordSet msg_face_record = new feeds_inner_define.FaceRecordSet();
  public group_feeds.GroupFeedsMessage msg_feeds_content = new group_feeds.GroupFeedsMessage();
  public oidb_0x8f9.FeedsState msg_feeds_state = new oidb_0x8f9.FeedsState();
  public oidb_0x8f9.SourceID msg_source_id = new oidb_0x8f9.SourceID();
  public final PBRepeatMessageField<oidb_0x8f9.ConcernUinInfo> rpt_concern_uin_info = PBField.initRepeatMessage(oidb_0x8f9.ConcernUinInfo.class);
  public final PBRepeatMessageField<oidb_0x8f9.GroupFeedsCommentRecord> rpt_msg_comments = PBField.initRepeatMessage(oidb_0x8f9.GroupFeedsCommentRecord.class);
  public final PBUInt32Field uint32_comment_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_feeds_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_feeds_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_modify_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_visit_count = PBField.initUInt32(0);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 48, 56, 64, 72, 82, 90, 98, 106, 114, 122 }, new String[] { "msg_source_id", "uint64_from_uin", "uint32_feeds_type", "bytes_feeds_id", "uint32_feeds_flag", "uint32_create_time", "uint32_modify_time", "uint32_visit_count", "uint32_comment_num", "bytes_reserve", "msg_face_record", "msg_feeds_content", "rpt_msg_comments", "rpt_concern_uin_info", "msg_feeds_state" }, new Object[] { null, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, null, null, null, null, null }, GroupFeedsRecord.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f9.oidb_0x8f9.GroupFeedsRecord
 * JD-Core Version:    0.7.0.1
 */