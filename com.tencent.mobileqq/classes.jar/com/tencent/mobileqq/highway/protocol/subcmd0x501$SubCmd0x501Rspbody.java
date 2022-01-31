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
  public static final int BYTES_HTTPCONN_SIG_SESSION_FIELD_NUMBER = 1;
  public static final int BYTES_SESSION_KEY_FIELD_NUMBER = 2;
  public static final int MSG_DOWNLOAD_ENCRYPT_CONF_FIELD_NUMBER = 9;
  public static final int MSG_DYN_TIMEOUT_CONF_FIELD_NUMBER = 7;
  public static final int MSG_IP_LEARN_CONF_FIELD_NUMBER = 6;
  public static final int MSG_OPEN_UP_CONF_FIELD_NUMBER = 8;
  public static final int MSG_PTV_CONF_FIELD_NUMBER = 11;
  public static final int MSG_SHORT_VIDEO_CONF_FIELD_NUMBER = 10;
  public static final int RPT_MSG_HTTPCONN_ADDRS_FIELD_NUMBER = 3;
  public static final int UINT32_CS_CONN_FIELD_NUMBER = 5;
  public static final int UINT32_PRE_CONNECTION_FIELD_NUMBER = 4;
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
  public final PBUInt32Field uint32_cs_conn = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pre_connection = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 50, 58, 66, 74, 82, 90 }, new String[] { "bytes_httpconn_sig_session", "bytes_session_key", "rpt_msg_httpconn_addrs", "uint32_pre_connection", "uint32_cs_conn", "msg_ip_learn_conf", "msg_dyn_timeout_conf", "msg_open_up_conf", "msg_download_encrypt_conf", "msg_short_video_conf", "msg_ptv_conf" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null, Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null, null }, SubCmd0x501Rspbody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody
 * JD-Core Version:    0.7.0.1
 */