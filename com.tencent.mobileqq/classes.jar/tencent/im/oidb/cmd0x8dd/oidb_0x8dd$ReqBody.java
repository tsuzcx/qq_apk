package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8dd$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field areaStat = PBField.initInt32(0);
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_qq_version = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_recommend_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_req_ad = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field code = PBField.initUInt64(0L);
  public oidb_0x8dd.Filter msg_filter = new oidb_0x8dd.Filter();
  public oidb_0x8dd.LBSInfo msg_lbs_info = new oidb_0x8dd.LBSInfo();
  public oidb_0x8dd.ReqCtrl msg_req_ctrl = new oidb_0x8dd.ReqCtrl();
  public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_client_version = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_source_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 58, 64, 72, 80, 90, 96, 104, 114 }, new String[] { "bytes_cookie", "uint32_source_type", "msg_lbs_info", "msg_filter", "bytes_req_ad", "msg_req_ctrl", "uint32_gender", "uint32_client_version", "uint32_client_type", "bytes_qq_version", "code", "areaStat", "bytes_recommend_cookie" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), null, null, localByteStringMicro2, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro4 }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8dd.oidb_0x8dd.ReqBody
 * JD-Core Version:    0.7.0.1
 */