package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_short_video_label$RoomState
  extends MessageMicro<RoomState>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_m3u8_path = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sdk_fileid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sdk_json = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sdk_videourl = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_vid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_transcode_result = PBField.initInt32(0);
  public final PBRepeatMessageField<ilive_short_video_label.OpensdkCB> rpt_extra_cb = PBField.initRepeatMessage(ilive_short_video_label.OpensdkCB.class);
  public final PBUInt32Field uint32_callbacktime = PBField.initUInt32(0);
  public final PBUInt32Field uint32_hlsState = PBField.initUInt32(0);
  public final PBUInt32Field uint32_indeletewhitelist = PBField.initUInt32(0);
  public final PBUInt32Field uint32_inuinwhitelist = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_hls = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mp4State = PBField.initUInt32(0);
  public final PBUInt32Field uint32_roomid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sdk_starttime = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sdk_stoptime = PBField.initUInt32(0);
  public final PBUInt32Field uint32_starttime = PBField.initUInt32(0);
  public final PBUInt32Field uint32_state = PBField.initUInt32(0);
  public final PBUInt32Field uint32_stoptime = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subroomid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_viddeletedbyuser = PBField.initUInt32(0);
  public final PBUInt64Field uint64_anchor = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 64, 72, 82, 88, 96, 104, 112, 120, 128, 138, 146, 152, 160, 178, 186 }, new String[] { "uint64_anchor", "uint32_state", "uint32_roomid", "uint32_subroomid", "bytes_vid", "uint32_starttime", "uint32_stoptime", "uint32_callbacktime", "uint32_is_hls", "bytes_m3u8_path", "int32_transcode_result", "uint32_mp4State", "uint32_hlsState", "uint32_inuinwhitelist", "uint32_indeletewhitelist", "uint32_viddeletedbyuser", "bytes_sdk_fileid", "bytes_sdk_videourl", "uint32_sdk_starttime", "uint32_sdk_stoptime", "bytes_sdk_json", "rpt_extra_cb" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro5, null }, RoomState.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.now.ilive_short_video_label.RoomState
 * JD-Core Version:    0.7.0.1
 */