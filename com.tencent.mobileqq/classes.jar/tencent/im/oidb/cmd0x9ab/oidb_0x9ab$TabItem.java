package tencent.im.oidb.cmd0x9ab;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x9ab$TabItem
  extends MessageMicro<TabItem>
{
  public static final int BYT_TAB_URL_FIELD_NUMBER = 3;
  public static final int BYT_TAB_WORDING_FIELD_NUMBER = 2;
  public static final int UINT32_STATUS_FLAG_FIELD_NUMBER = 4;
  public static final int UINT32_TAB_ID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField byt_tab_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField byt_tab_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_status_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tab_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uint32_tab_id", "byt_tab_wording", "byt_tab_url", "uint32_status_flag" }, new Object[] { localInteger, localByteStringMicro1, localByteStringMicro2, localInteger }, TabItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9ab.oidb_0x9ab.TabItem
 * JD-Core Version:    0.7.0.1
 */