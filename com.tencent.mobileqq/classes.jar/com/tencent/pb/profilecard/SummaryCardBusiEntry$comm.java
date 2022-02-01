package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SummaryCardBusiEntry$comm
  extends MessageMicro<comm>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field build = PBField.initInt32(0);
  public final PBUInt32Field client_ip = PBField.initUInt32(0);
  public SummaryCardBusiEntry.ui display = new SummaryCardBusiEntry.ui();
  public final PBStringField err_msg = PBField.initString("");
  public final PBUInt64Field fromuin = PBField.initUInt64(0L);
  public SummaryCardBusiEntry.LoginSig msg_login_sig = new SummaryCardBusiEntry.LoginSig();
  public SummaryCardBusiEntry.rich_ui msg_rich_display = new SummaryCardBusiEntry.rich_ui();
  public SummaryCardBusiEntry.uin_info msg_uin_info = new SummaryCardBusiEntry.uin_info();
  public final PBUInt32Field platform = PBField.initUInt32(0);
  public final PBStringField qqver = PBField.initString("");
  public final PBInt32Field result = PBField.initInt32(0);
  public final PBUInt32Field seq = PBField.initUInt32(0);
  public final PBUInt32Field service = PBField.initUInt32(0);
  public final PBBytesField session_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field session_type = PBField.initUInt32(0);
  public final PBUInt64Field touin = PBField.initUInt64(0L);
  public final PBUInt32Field uint32_version = PBField.initUInt32(0);
  public final PBUInt32Field ver = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 64, 74, 80, 90, 96, 106, 112, 122, 136, 146, 154 }, new String[] { "ver", "seq", "fromuin", "touin", "service", "session_type", "session_key", "client_ip", "display", "result", "err_msg", "platform", "qqver", "build", "msg_login_sig", "uint32_version", "msg_uin_info", "msg_rich_display" }, new Object[] { localInteger, localInteger, Long.valueOf(0L), Long.valueOf(0L), localInteger, localInteger, localByteStringMicro, localInteger, null, localInteger, "", localInteger, "", localInteger, null, localInteger, null, null }, comm.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.profilecard.SummaryCardBusiEntry.comm
 * JD-Core Version:    0.7.0.1
 */