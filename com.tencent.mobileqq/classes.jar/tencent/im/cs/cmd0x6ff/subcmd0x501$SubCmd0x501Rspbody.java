package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class subcmd0x501$SubCmd0x501Rspbody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_httpconn_sig_session = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_session_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField rpt_msg_httpconn_addrs = PBField.initRepeatMessage(subcmd0x501.SubCmd0x501Rspbody.SrvAddrs.class);
  public final PBUInt32Field uint32_share_channel = PBField.initUInt32(0);
  public final PBUInt32Field uint32_share_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 96, 104 }, new String[] { "bytes_httpconn_sig_session", "bytes_session_key", "rpt_msg_httpconn_addrs", "uint32_share_type", "uint32_share_channel" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null, Integer.valueOf(0), Integer.valueOf(0) }, SubCmd0x501Rspbody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501Rspbody
 * JD-Core Version:    0.7.0.1
 */