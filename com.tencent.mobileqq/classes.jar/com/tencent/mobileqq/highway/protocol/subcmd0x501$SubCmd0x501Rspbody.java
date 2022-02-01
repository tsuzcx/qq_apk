package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class subcmd0x501$SubCmd0x501Rspbody
  extends MessageMicro<SubCmd0x501Rspbody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_httpconn_sig_session = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_session_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf msg_download_encrypt_conf = new subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf();
  public subcmd0x501.SubCmd0x501Rspbody.DynTimeOutConf msg_dyn_timeout_conf = new subcmd0x501.SubCmd0x501Rspbody.DynTimeOutConf();
  public subcmd0x501.SubCmd0x501Rspbody.IpLearnConf msg_ip_learn_conf = new subcmd0x501.SubCmd0x501Rspbody.IpLearnConf();
  public subcmd0x501.SubCmd0x501Rspbody.OpenUpConf msg_open_up_conf = new subcmd0x501.SubCmd0x501Rspbody.OpenUpConf();
  public subcmd0x501.SubCmd0x501Rspbody.PTVConf msg_ptv_conf = new subcmd0x501.SubCmd0x501Rspbody.PTVConf();
  public subcmd0x501.SubCmd0x501Rspbody.ShortVideoConf msg_short_video_conf = new subcmd0x501.SubCmd0x501Rspbody.ShortVideoConf();
  public final PBRepeatMessageField<subcmd0x501.SubCmd0x501Rspbody.SrvAddrs> rpt_msg_httpconn_addrs = PBField.initRepeatMessage(subcmd0x501.SubCmd0x501Rspbody.SrvAddrs.class);
  public final PBUInt32Field uint32_bigdata_policy = PBField.initUInt32(0);
  public final PBUInt32Field uint32_conn_attempt_delay = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cs_conn = PBField.initUInt32(0);
  public final PBUInt32Field uint32_fmt_policy = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pre_connection = PBField.initUInt32(0);
  public final PBUInt32Field uint32_share_channel = PBField.initUInt32(0);
  public final PBUInt32Field uint32_share_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 50, 58, 66, 74, 82, 90, 96, 104, 112, 120, 128 }, new String[] { "bytes_httpconn_sig_session", "bytes_session_key", "rpt_msg_httpconn_addrs", "uint32_pre_connection", "uint32_cs_conn", "msg_ip_learn_conf", "msg_dyn_timeout_conf", "msg_open_up_conf", "msg_download_encrypt_conf", "msg_short_video_conf", "msg_ptv_conf", "uint32_share_type", "uint32_share_channel", "uint32_fmt_policy", "uint32_bigdata_policy", "uint32_conn_attempt_delay" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null, localInteger, localInteger, null, null, null, null, null, null, localInteger, localInteger, localInteger, localInteger, localInteger }, SubCmd0x501Rspbody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody
 * JD-Core Version:    0.7.0.1
 */