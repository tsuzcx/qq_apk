package com.tencent.qqprotect.singleupdate;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QPSingleUpdateProto$RspBody
  extends MessageMicro<RspBody>
{
  public static final int BYTES_PACKET_HASH_FIELD_NUMBER = 5;
  public static final int BYTES_PACKET_URL_FIELD_NUMBER = 4;
  public static final int RPT_FILE_ITEM_LIST_FIELD_NUMBER = 6;
  public static final int UINT32_DOWNLOAD_TYPE_FIELD_NUMBER = 3;
  public static final int UINT32_FORCE_DOWNLOAD_FIELD_NUMBER = 2;
  public static final int UINT32_GETPHONENUMBER_FLAG_FIELD_NUMBER = 7;
  public static final int UINT32_UPDATE_VAILABLE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_packet_hash = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_packet_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<QPSingleUpdateProto.FileItem> rpt_file_item_list = PBField.initRepeatMessage(QPSingleUpdateProto.FileItem.class);
  public final PBUInt32Field uint32_download_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_force_download = PBField.initUInt32(0);
  public final PBUInt32Field uint32_getphonenumber_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_update_vailable = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 56 }, new String[] { "uint32_update_vailable", "uint32_force_download", "uint32_download_type", "bytes_packet_url", "bytes_packet_hash", "rpt_file_item_list", "uint32_getphonenumber_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, null, Integer.valueOf(0) }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.QPSingleUpdateProto.RspBody
 * JD-Core Version:    0.7.0.1
 */