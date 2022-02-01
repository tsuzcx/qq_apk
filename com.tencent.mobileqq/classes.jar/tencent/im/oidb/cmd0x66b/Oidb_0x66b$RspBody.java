package tencent.im.oidb.cmd0x66b;

import appoint.define.appoint_define.PublisherInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class Oidb_0x66b$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_rspbody_5eb = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_rspbody_gift = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<appoint_define.PublisherInfo> rpt_msg_vistor_info = PBField.initRepeatMessage(appoint_define.PublisherInfo.class);
  public final PBRepeatMessageField<Oidb_0x66b.RspConfigItem> stConfigList = PBField.initRepeatMessage(Oidb_0x66b.RspConfigItem.class);
  public Oidb_0x66b.RspLikeInfo stLikeInfo = new Oidb_0x66b.RspLikeInfo();
  public Oidb_0x66b.RspPansocialInfo stPansocialInfo = new Oidb_0x66b.RspPansocialInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 480802, 481602, 482402, 483202, 484002, 484802 }, new String[] { "bytes_rspbody_5eb", "stLikeInfo", "stPansocialInfo", "bytes_rspbody_gift", "stConfigList", "rpt_msg_vistor_info" }, new Object[] { localByteStringMicro1, null, null, localByteStringMicro2, null, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x66b.Oidb_0x66b.RspBody
 * JD-Core Version:    0.7.0.1
 */