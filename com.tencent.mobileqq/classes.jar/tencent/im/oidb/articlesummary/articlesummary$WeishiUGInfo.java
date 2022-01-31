package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class articlesummary$WeishiUGInfo
  extends MessageMicro<WeishiUGInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_back_off_group = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_click_h5_report_tail = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_click_report_tail = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_click_schema_report_tail = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_exposure_report_tail = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_report_base_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public articlesummary.UrlJumpInfo msg_url_jump_info = new articlesummary.UrlJumpInfo();
  public final PBRepeatField<ByteStringMicro> rpt_bytes_report_base_url = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBUInt32Field uint32_auto_play = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_with_angle_sign = PBField.initUInt32(0);
  public final PBUInt32Field uint32_residence_threshold = PBField.initUInt32(0);
  public final PBUInt32Field uint32_use_ug = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64, 74, 80, 88, 96 }, new String[] { "bytes_report_base_url", "bytes_exposure_report_tail", "bytes_click_report_tail", "bytes_click_schema_report_tail", "bytes_click_h5_report_tail", "rpt_bytes_report_base_url", "msg_url_jump_info", "uint32_auto_play", "bytes_back_off_group", "uint32_use_ug", "uint32_is_with_angle_sign", "uint32_residence_threshold" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, null, Integer.valueOf(0), localByteStringMicro7, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, WeishiUGInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.WeishiUGInfo
 * JD-Core Version:    0.7.0.1
 */