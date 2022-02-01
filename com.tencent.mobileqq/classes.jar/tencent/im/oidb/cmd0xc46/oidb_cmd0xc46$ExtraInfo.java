package tencent.im.oidb.cmd0xc46;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xc46$ExtraInfo
  extends MessageMicro<ExtraInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField default_input = PBField.initString("");
  public final PBStringField family_oc_info = PBField.initString("");
  public final PBUInt32Field hidden_comment_count = PBField.initUInt32(0);
  public final PBUInt32Field hot_next = PBField.initUInt32(0);
  public final PBBytesField hot_page_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field is_pgc_author = PBField.initUInt32(0);
  public final PBUInt32Field is_show_follow_button = PBField.initUInt32(0);
  public final PBUInt32Field is_show_label = PBField.initUInt32(0);
  public final PBStringField jump_kva_schema = PBField.initString("");
  public oidb_cmd0xc46.Label label = new oidb_cmd0xc46.Label();
  public final PBUInt32Field show_mask = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50, 56, 66, 72, 88, 98 }, new String[] { "hot_next", "hot_page_cookie", "hidden_comment_count", "show_mask", "jump_kva_schema", "family_oc_info", "is_pgc_author", "label", "is_show_label", "is_show_follow_button", "default_input" }, new Object[] { localInteger, localByteStringMicro, localInteger, localInteger, "", "", localInteger, null, localInteger, localInteger, "" }, ExtraInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ExtraInfo
 * JD-Core Version:    0.7.0.1
 */