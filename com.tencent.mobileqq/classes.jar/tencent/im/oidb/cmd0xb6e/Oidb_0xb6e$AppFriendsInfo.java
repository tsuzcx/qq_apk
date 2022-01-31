package tencent.im.oidb.cmd0xb6e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class Oidb_0xb6e$AppFriendsInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField figure_url = PBField.initString("");
  public final PBStringField figure_url_1 = PBField.initString("");
  public final PBStringField figure_url_2 = PBField.initString("");
  public final PBStringField figure_url_qq = PBField.initString("");
  public final PBStringField gender = PBField.initString("");
  public final PBBytesField nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField openid = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "openid", "nick", "gender", "figure_url_qq", "figure_url", "figure_url_1", "figure_url_2" }, new Object[] { "", localByteStringMicro, "", "", "", "", "" }, AppFriendsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb6e.Oidb_0xb6e.AppFriendsInfo
 * JD-Core Version:    0.7.0.1
 */