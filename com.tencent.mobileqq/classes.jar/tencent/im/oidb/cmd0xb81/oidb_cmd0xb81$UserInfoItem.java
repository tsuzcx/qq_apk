package tencent.im.oidb.cmd0xb81;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_cmd0xb81$UserInfoItem
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0xb81.AccountInfo msg_account_info = new oidb_cmd0xb81.AccountInfo();
  public oidb_cmd0xb81.HeadInfo msg_head_info = new oidb_cmd0xb81.HeadInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_account_info", "bytes_nick", "msg_head_info" }, new Object[] { null, localByteStringMicro, null }, UserInfoItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.UserInfoItem
 * JD-Core Version:    0.7.0.1
 */