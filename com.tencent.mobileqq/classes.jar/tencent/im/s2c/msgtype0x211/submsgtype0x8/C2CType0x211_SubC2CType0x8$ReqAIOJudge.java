package tencent.im.s2c.msgtype0x211.submsgtype0x8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class C2CType0x211_SubC2CType0x8$ReqAIOJudge
  extends MessageMicro<ReqAIOJudge>
{
  public static final int MSG_HEAD_FIELD_NUMBER = 1;
  public static final int MSG_NEARFIELD_INFO_FIELD_NUMBER = 3;
  public static final int UINT64_TO_UIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "msg_head", "uint64_to_uin", "msg_nearfield_info" }, new Object[] { null, Long.valueOf(0L), null }, ReqAIOJudge.class);
  public C2CType0x211_SubC2CType0x8.BusiReqHead msg_head = new C2CType0x211_SubC2CType0x8.BusiReqHead();
  public C2CType0x211_SubC2CType0x8.NearfieldInfo msg_nearfield_info = new C2CType0x211_SubC2CType0x8.NearfieldInfo();
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x8.C2CType0x211_SubC2CType0x8.ReqAIOJudge
 * JD-Core Version:    0.7.0.1
 */