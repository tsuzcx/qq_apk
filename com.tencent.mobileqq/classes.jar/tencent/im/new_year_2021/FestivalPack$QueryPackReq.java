package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class FestivalPack$QueryPackReq
  extends MessageMicro<QueryPackReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field from_id = PBField.initInt32(0);
  public final PBBytesField pack_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField skey = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "pack_id", "skey", "from_id" }, new Object[] { localByteStringMicro, "", Integer.valueOf(0) }, QueryPackReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.new_year_2021.FestivalPack.QueryPackReq
 * JD-Core Version:    0.7.0.1
 */