package tencent.im.oidb.cmd0x95a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x95a$JoinWorldCupReq
  extends MessageMicro<JoinWorldCupReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_t_req_recommend_nick" }, new Object[] { Integer.valueOf(0) }, JoinWorldCupReq.class);
  public final PBUInt32Field uint32_t_req_recommend_nick = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x95a.cmd0x95a.JoinWorldCupReq
 * JD-Core Version:    0.7.0.1
 */