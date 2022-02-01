package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FestivalPack$SetPackUsedReq
  extends MessageMicro<SetPackUsedReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField external = PBField.initBool(false);
  public final PBBytesField pack_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField skey = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "pack_id", "external", "skey" }, new Object[] { localByteStringMicro, Boolean.valueOf(false), "" }, SetPackUsedReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.new_year_2021.FestivalPack.SetPackUsedReq
 * JD-Core Version:    0.7.0.1
 */