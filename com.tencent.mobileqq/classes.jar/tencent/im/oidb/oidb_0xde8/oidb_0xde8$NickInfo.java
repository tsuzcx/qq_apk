package tencent.im.oidb.oidb_0xde8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xde8$NickInfo
  extends MessageMicro<NickInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_feedid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0xde8.lightCommentInfo msg_light_comment = new oidb_0xde8.lightCommentInfo();
  public final PBRepeatMessageField<oidb_0xde8.CommentItem> rpt_item = PBField.initRepeatMessage(oidb_0xde8.CommentItem.class);
  public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_del_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mod_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 58, 66 }, new String[] { "bytes_feedid", "bytes_nick", "uint32_type", "uint32_create_time", "uint32_mod_time", "uint32_del_time", "rpt_item", "msg_light_comment" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null }, NickInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xde8.oidb_0xde8.NickInfo
 * JD-Core Version:    0.7.0.1
 */