package tencent.im.sso.offlinpkg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class OfflinePkg$BidPkg
  extends MessageMicro<BidPkg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_bid", "uint32_pkg_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, BidPkg.class);
  public final PBUInt32Field uint32_bid = PBField.initUInt32(0);
  public final PBRepeatField<Integer> uint32_pkg_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.sso.offlinpkg.OfflinePkg.BidPkg
 * JD-Core Version:    0.7.0.1
 */