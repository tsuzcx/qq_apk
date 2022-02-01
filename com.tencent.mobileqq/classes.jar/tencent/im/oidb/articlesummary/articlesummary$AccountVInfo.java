package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class articlesummary$AccountVInfo
  extends MessageMicro<AccountVInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_v_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_is_unowned = PBField.initUInt32(0);
  public articlesummary.UserIdentityIcon user_identity_icon = new articlesummary.UserIdentityIcon();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "bytes_v_icon_url", "uint32_is_unowned", "user_identity_icon" }, new Object[] { localByteStringMicro, Integer.valueOf(0), null }, AccountVInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.AccountVInfo
 * JD-Core Version:    0.7.0.1
 */