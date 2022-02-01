package tencent.im.oidb.lbspack;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MqqLbsPack$CFT_AR_INFO
  extends MessageMicro<CFT_AR_INFO>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public MqqLbsPack.LBSSig msg_lbs_sig = new MqqLbsPack.LBSSig();
  public final PBUInt32Field uint32_attempt_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_qa = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 26, 32, 40 }, new String[] { "msg_lbs_sig", "uint32_qa", "uint32_attempt_num" }, new Object[] { null, localInteger, localInteger }, CFT_AR_INFO.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.lbspack.MqqLbsPack.CFT_AR_INFO
 * JD-Core Version:    0.7.0.1
 */