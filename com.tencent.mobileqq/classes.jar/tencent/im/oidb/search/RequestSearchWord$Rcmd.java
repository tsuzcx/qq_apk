package tencent.im.oidb.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class RequestSearchWord$Rcmd
  extends MessageMicro<Rcmd>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField jmp_url = PBField.initString("");
  public final PBUInt32Field modle_id = PBField.initUInt32(0);
  public final PBStringField modle_name = PBField.initString("");
  public final PBFloatField score = PBField.initFloat(0.0F);
  public final PBBytesField word = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 29, 34, 40 }, new String[] { "word", "jmp_url", "score", "modle_name", "modle_id" }, new Object[] { localByteStringMicro, "", Float.valueOf(0.0F), "", Integer.valueOf(0) }, Rcmd.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.search.RequestSearchWord.Rcmd
 * JD-Core Version:    0.7.0.1
 */