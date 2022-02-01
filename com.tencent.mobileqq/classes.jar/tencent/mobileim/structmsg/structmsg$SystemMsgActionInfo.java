package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class structmsg$SystemMsgActionInfo
  extends MessageMicro<SystemMsgActionInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public structmsg.AddFrdSNInfo addFrdSNInfo = new structmsg.AddFrdSNInfo();
  public final PBBoolField blacklist = PBField.initBool(false);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBUInt32Field group_id = PBField.initUInt32(0);
  public final PBStringField msg = PBField.initString("");
  public final PBStringField remark = PBField.initString("");
  public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField type = PBField.initEnum(1);
  public final PBUInt32Field uint32_req_msg_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 402, 408, 418, 424, 434, 440 }, new String[] { "type", "group_code", "sig", "msg", "group_id", "remark", "blacklist", "addFrdSNInfo", "uint32_req_msg_type" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), localByteStringMicro, "", localInteger, "", Boolean.valueOf(false), null, localInteger }, SystemMsgActionInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo
 * JD-Core Version:    0.7.0.1
 */