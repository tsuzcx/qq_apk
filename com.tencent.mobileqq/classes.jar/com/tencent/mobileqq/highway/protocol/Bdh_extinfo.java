package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Bdh_extinfo
{
  public static final class PicInfo
    extends MessageMicro<PicInfo>
  {
    public static final int BYTES_BIN_MD5_FIELD_NUMBER = 3;
    public static final int UINT32_IDX_FIELD_NUMBER = 1;
    public static final int UINT32_SIZE_FIELD_NUMBER = 2;
    public static final int UINT32_TYPE_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_bin_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_idx = PBField.initUInt32(0);
    public final PBUInt32Field uint32_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint32_idx", "uint32_size", "bytes_bin_md5", "uint32_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, PicInfo.class);
    }
  }
  
  public static final class QQVoiceExtReq
    extends MessageMicro<QQVoiceExtReq>
  {
    public static final int BYTES_QID_FIELD_NUMBER = 1;
    public static final int UINT32_BITS_FIELD_NUMBER = 4;
    public static final int UINT32_CHANNEL_FIELD_NUMBER = 5;
    public static final int UINT32_FMT_FIELD_NUMBER = 2;
    public static final int UINT32_PINYIN_FIELD_NUMBER = 6;
    public static final int UINT32_RATE_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_qid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_bits = PBField.initUInt32(0);
    public final PBUInt32Field uint32_channel = PBField.initUInt32(0);
    public final PBUInt32Field uint32_fmt = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pinyin = PBField.initUInt32(0);
    public final PBUInt32Field uint32_rate = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48 }, new String[] { "bytes_qid", "uint32_fmt", "uint32_rate", "uint32_bits", "uint32_channel", "uint32_pinyin" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, QQVoiceExtReq.class);
    }
  }
  
  public static final class QQVoiceExtRsp
    extends MessageMicro<QQVoiceExtRsp>
  {
    public static final int BYTES_QID_FIELD_NUMBER = 1;
    public static final int INT32_RETCODE_FIELD_NUMBER = 2;
    public static final int MSG_RESULT_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_qid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_retcode = PBField.initInt32(0);
    public final PBRepeatMessageField<Bdh_extinfo.QQVoiceResult> msg_result = PBField.initRepeatMessage(Bdh_extinfo.QQVoiceResult.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "bytes_qid", "int32_retcode", "msg_result" }, new Object[] { localByteStringMicro, Integer.valueOf(0), null }, QQVoiceExtRsp.class);
    }
  }
  
  public static final class QQVoiceResult
    extends MessageMicro<QQVoiceResult>
  {
    public static final int BYTES_PINYIN_FIELD_NUMBER = 2;
    public static final int BYTES_TEXT_FIELD_NUMBER = 1;
    public static final int UINT32_SOURCE_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pinyin = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "bytes_text", "bytes_pinyin", "uint32_source" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, QQVoiceResult.class);
    }
  }
  
  public static final class ShortVideoReqExtInfo
    extends MessageMicro<ShortVideoReqExtInfo>
  {
    public static final int BOOL_IS_MERGE_CMD_BEFORE_DATA_FIELD_NUMBER = 6;
    public static final int MSG_SHORTVIDEO_SURE_REQ_FIELD_NUMBER = 5;
    public static final int MSG_THUMBINFO_FIELD_NUMBER = 3;
    public static final int MSG_VIDEOINFO_FIELD_NUMBER = 4;
    public static final int UINT32_CMD_FIELD_NUMBER = 1;
    public static final int UINT64_SESSION_ID_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48 }, new String[] { "uint32_cmd", "uint64_session_id", "msg_thumbinfo", "msg_videoinfo", "msg_shortvideo_sure_req", "bool_is_merge_cmd_before_data" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, null, null, Boolean.valueOf(false) }, ShortVideoReqExtInfo.class);
    public final PBBoolField bool_is_merge_cmd_before_data = PBField.initBool(false);
    public Bdh_extinfo.ShortVideoSureReqInfo msg_shortvideo_sure_req = new Bdh_extinfo.ShortVideoSureReqInfo();
    public Bdh_extinfo.PicInfo msg_thumbinfo = new Bdh_extinfo.PicInfo();
    public Bdh_extinfo.VideoInfo msg_videoinfo = new Bdh_extinfo.VideoInfo();
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public final PBUInt64Field uint64_session_id = PBField.initUInt64(0L);
  }
  
  public static final class ShortVideoRspExtInfo
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
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 64 }, new String[] { "uint32_cmd", "uint64_session_id", "int32_retcode", "bytes_errinfo", "msg_thumbinfo", "msg_videoinfo", "msg_shortvideo_sure_rsp", "uint32_retry_flag" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, null, null, null, Integer.valueOf(0) }, ShortVideoRspExtInfo.class);
    }
  }
  
  public static final class ShortVideoSureReqInfo
    extends MessageMicro<ShortVideoSureReqInfo>
  {
    public static final int MSG_THUMBINFO_FIELD_NUMBER = 6;
    public static final int RPT_MSG_DROP_VIDEOINFO_FIELD_NUMBER = 8;
    public static final int RPT_MSG_MERGE_VIDEOINFO_FIELD_NUMBER = 7;
    public static final int UINT32_BUSINESS_TYPE_FIELD_NUMBER = 9;
    public static final int UINT32_CHAT_TYPE_FIELD_NUMBER = 2;
    public static final int UINT32_CLIENT_TYPE_FIELD_NUMBER = 5;
    public static final int UINT64_FROMUIN_FIELD_NUMBER = 1;
    public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 4;
    public static final int UINT64_TOUIN_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 66, 72 }, new String[] { "uint64_fromuin", "uint32_chat_type", "uint64_touin", "uint64_group_code", "uint32_client_type", "msg_thumbinfo", "rpt_msg_merge_videoinfo", "rpt_msg_drop_videoinfo", "uint32_business_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), null, null, null, Integer.valueOf(0) }, ShortVideoSureReqInfo.class);
    public Bdh_extinfo.PicInfo msg_thumbinfo = new Bdh_extinfo.PicInfo();
    public final PBRepeatMessageField<Bdh_extinfo.VideoInfo> rpt_msg_drop_videoinfo = PBField.initRepeatMessage(Bdh_extinfo.VideoInfo.class);
    public final PBRepeatMessageField<Bdh_extinfo.VideoInfo> rpt_msg_merge_videoinfo = PBField.initRepeatMessage(Bdh_extinfo.VideoInfo.class);
    public final PBUInt32Field uint32_business_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_chat_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_fromuin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_touin = PBField.initUInt64(0L);
  }
  
  public static final class ShortVideoSureRspInfo
    extends MessageMicro<ShortVideoSureRspInfo>
  {
    public static final int BYTES_FILEID_FIELD_NUMBER = 1;
    public static final int BYTES_UKEY_FIELD_NUMBER = 2;
    public static final int MSG_VIDEOINFO_FIELD_NUMBER = 3;
    public static final int UINT32_MERGE_COST_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_fileid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_ukey = PBField.initBytes(ByteStringMicro.EMPTY);
    public Bdh_extinfo.VideoInfo msg_videoinfo = new Bdh_extinfo.VideoInfo();
    public final PBUInt32Field uint32_merge_cost = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "bytes_fileid", "bytes_ukey", "msg_videoinfo", "uint32_merge_cost" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null, Integer.valueOf(0) }, ShortVideoSureRspInfo.class);
    }
  }
  
  public static final class UploadPicExtInfo
    extends MessageMicro<UploadPicExtInfo>
  {
    public static final int BYTES_DOWNLOAD_URL_FIELD_NUMBER = 2;
    public static final int BYTES_FILE_RESID_FIELD_NUMBER = 1;
    public static final int BYTES_THUMB_DOWNLOAD_URL_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_download_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_resid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_thumb_download_url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "bytes_file_resid", "bytes_download_url", "bytes_thumb_download_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, UploadPicExtInfo.class);
    }
  }
  
  public static final class VideoInfo
    extends MessageMicro<VideoInfo>
  {
    public static final int BYTES_BIN_MD5_FIELD_NUMBER = 3;
    public static final int UINT32_FORMAT_FIELD_NUMBER = 4;
    public static final int UINT32_IDX_FIELD_NUMBER = 1;
    public static final int UINT32_RES_LEN_FIELD_NUMBER = 5;
    public static final int UINT32_RES_WIDTH_FIELD_NUMBER = 6;
    public static final int UINT32_SIZE_FIELD_NUMBER = 2;
    public static final int UINT32_TIME_FIELD_NUMBER = 7;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_bin_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_format = PBField.initUInt32(0);
    public final PBUInt32Field uint32_idx = PBField.initUInt32(0);
    public final PBUInt32Field uint32_res_len = PBField.initUInt32(0);
    public final PBUInt32Field uint32_res_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 56 }, new String[] { "uint32_idx", "uint32_size", "bytes_bin_md5", "uint32_format", "uint32_res_len", "uint32_res_width", "uint32_time" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, VideoInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.Bdh_extinfo
 * JD-Core Version:    0.7.0.1
 */