package tencent.im.group.broadcast;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class BroadcastMsgCtr$Ex2tlvGroupInfo
  extends MessageMicro<Ex2tlvGroupInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_tribe_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public BroadcastMsgCtr.ConfInfo conf_info = new BroadcastMsgCtr.ConfInfo();
  public BroadcastMsgCtr.ExtGroupKeyInfo ext_group_key_info = new BroadcastMsgCtr.ExtGroupKeyInfo();
  public final PBUInt32Field uint32_disable_fetch_remark = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 1018 }, new String[] { "bytes_group_name", "uint32_disable_fetch_remark", "bytes_tribe_info", "ext_group_key_info", "conf_info" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, null, null }, Ex2tlvGroupInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.group.broadcast.BroadcastMsgCtr.Ex2tlvGroupInfo
 * JD-Core Version:    0.7.0.1
 */