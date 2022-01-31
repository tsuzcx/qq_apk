package tencent.im.group;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class group_member_info$InfoCardVideoInfo
  extends MessageMicro<InfoCardVideoInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField cover = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField feed_id = PBField.initString("");
  public final PBStringField vid = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "cover", "vid", "feed_id" }, new Object[] { localByteStringMicro, "", "" }, InfoCardVideoInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.group.group_member_info.InfoCardVideoInfo
 * JD-Core Version:    0.7.0.1
 */