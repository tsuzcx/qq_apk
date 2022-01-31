package tencent.im.oidb.cmd0xc46;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xc46$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField anchor_id = PBField.initString("");
  public final PBStringField comment_id = PBField.initString("");
  public final PBUInt32Field content_src = PBField.initUInt32(0);
  public final PBStringField feeds_id = PBField.initString("");
  public final PBUInt32Field feeds_type = PBField.initUInt32(0);
  public final PBUInt32Field fixed_page_size = PBField.initUInt32(0);
  public final PBUInt32Field is_share = PBField.initUInt32(0);
  public final PBBytesField page_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field page_size = PBField.initUInt32(0);
  public oidb_cmd0xc46.ReqParam req_param = new oidb_cmd0xc46.ReqParam();
  public final PBStringField rowkey = PBField.initString("");
  public final PBUInt32Field with_activity_data = PBField.initUInt32(0);
  public final PBUInt32Field with_first_comment_detail = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 56, 66, 72, 80, 90, 96, 106 }, new String[] { "rowkey", "comment_id", "page_cookie", "page_size", "content_src", "fixed_page_size", "is_share", "feeds_id", "feeds_type", "with_first_comment_detail", "anchor_id", "with_activity_data", "req_param" }, new Object[] { "", "", localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), null }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ReqBody
 * JD-Core Version:    0.7.0.1
 */