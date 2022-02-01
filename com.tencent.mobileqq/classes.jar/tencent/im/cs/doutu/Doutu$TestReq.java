package tencent.im.cs.doutu;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Doutu$TestReq
  extends MessageMicro<TestReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint64_src_uin", "uint32_src_term", "uint32_age", "uin32_gender", "randomNum" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, TestReq.class);
  public final PBUInt32Field randomNum = PBField.initUInt32(0);
  public final PBUInt32Field uin32_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
  public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.doutu.Doutu.TestReq
 * JD-Core Version:    0.7.0.1
 */