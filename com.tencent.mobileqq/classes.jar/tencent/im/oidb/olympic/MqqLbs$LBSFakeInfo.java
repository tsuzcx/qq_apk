package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MqqLbs$LBSFakeInfo
  extends MessageMicro<LBSFakeInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_fake_type", "uint32_fake_times" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, LBSFakeInfo.class);
  public final PBUInt32Field uint32_fake_times = PBField.initUInt32(0);
  public final PBUInt32Field uint32_fake_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.olympic.MqqLbs.LBSFakeInfo
 * JD-Core Version:    0.7.0.1
 */