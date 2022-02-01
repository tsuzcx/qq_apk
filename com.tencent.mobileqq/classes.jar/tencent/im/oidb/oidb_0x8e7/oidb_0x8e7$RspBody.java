package tencent.im.oidb.oidb_0x8e7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_0x8e7$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_recharge_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_update_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x8e7.StockRsp msg_stock_rsp = new oidb_0x8e7.StockRsp();
  public oidb_0x8e7.WarnMsg msg_warn = new oidb_0x8e7.WarnMsg();
  public oidb_0x8e7.ZanLimitInfo msg_zan_limit = new oidb_0x8e7.ZanLimitInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "msg_stock_rsp", "msg_zan_limit", "bytes_recharge_url", "msg_warn", "bytes_update_url" }, new Object[] { null, null, localByteStringMicro1, null, localByteStringMicro2 }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.RspBody
 * JD-Core Version:    0.7.0.1
 */