package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Bdh_extinfo$ShortVideoRspExtInfo
  extends MessageMicro<ShortVideoRspExtInfo>
{
  public static final int BYTES_ERRINFO_FIELD_NUMBER = 4;
  public static final int INT32_RETCODE_FIELD_NUMBER = 3;
  public static final int MSG_SHORTVIDEO_SURE_RSP_FIELD_NUMBER = 7;
  public static final int MSG_THUMBINFO_FIELD_NUMBER = 5;
  public static final int MSG_VIDEOINFO_FIELD_NUMBER = 6;
  public static final int UINT32_CMD_FIELD_NUMBER = 1;
  public static final int UINT32_RETRY_FLAG_FIELD_NUMBER = 8;
  public static final int UINT64_SESSION_ID_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_errinfo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_retcode = PBField.initInt32(0);
  public Bdh_extinfo.ShortVideoSureRspInfo msg_shortvideo_sure_rsp = new Bdh_extinfo.ShortVideoSureRspInfo();
  public Bdh_extinfo.PicInfo msg_thumbinfo = new Bdh_extinfo.PicInfo();
  public Bdh_extinfo.VideoInfo msg_videoinfo = new Bdh_extinfo.VideoInfo();
  public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
  public final PBUInt32Field uint32_retry_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint64_session_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 64 }, new String[] { "uint32_cmd", "uint64_session_id", "int32_retcode", "bytes_errinfo", "msg_thumbinfo", "msg_videoinfo", "msg_shortvideo_sure_rsp", "uint32_retry_flag" }, new Object[] { localInteger, Long.valueOf(0L), localInteger, localByteStringMicro, null, null, null, localInteger }, ShortVideoRspExtInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.Bdh_extinfo.ShortVideoRspExtInfo
 * JD-Core Version:    0.7.0.1
 */