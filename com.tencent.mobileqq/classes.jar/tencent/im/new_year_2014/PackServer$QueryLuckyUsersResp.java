package tencent.im.new_year_2014;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class PackServer$QueryLuckyUsersResp
  extends MessageMicro<QueryLuckyUsersResp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField list = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "list" }, new Object[] { localByteStringMicro }, QueryLuckyUsersResp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.new_year_2014.PackServer.QueryLuckyUsersResp
 * JD-Core Version:    0.7.0.1
 */