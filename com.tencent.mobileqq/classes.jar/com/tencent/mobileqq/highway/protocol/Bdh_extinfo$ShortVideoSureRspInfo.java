package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Bdh_extinfo$ShortVideoSureRspInfo
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.Bdh_extinfo.ShortVideoSureRspInfo
 * JD-Core Version:    0.7.0.1
 */