package tencent.im.oidb.cmd0xdc4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FavEmotionOcr$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_rsp_other = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_result = PBField.initInt32(0);
  public final PBRepeatMessageField<FavEmotionOcr.ModifyRsp> list_modify_rsp = PBField.initRepeatMessage(FavEmotionOcr.ModifyRsp.class);
  public final PBRepeatMessageField<FavEmotionOcr.OcrInfo> list_ocr_info = PBField.initRepeatMessage(FavEmotionOcr.OcrInfo.class);
  public final PBStringField string_fail_msg = PBField.initString("");
  public final PBUInt32Field uint32_cmd_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50 }, new String[] { "int32_result", "string_fail_msg", "uint32_cmd_type", "list_ocr_info", "list_modify_rsp", "bytes_rsp_other" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), null, null, localByteStringMicro }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdc4.FavEmotionOcr.RspBody
 * JD-Core Version:    0.7.0.1
 */