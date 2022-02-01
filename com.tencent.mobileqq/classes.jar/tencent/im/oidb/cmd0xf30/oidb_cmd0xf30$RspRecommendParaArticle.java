package tencent.im.oidb.cmd0xf30;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xf30$RspRecommendParaArticle
  extends MessageMicro<RspRecommendParaArticle>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<oidb_cmd0xf30.InsertArticle> insert_list = PBField.initRepeatMessage(oidb_cmd0xf30.InsertArticle.class);
  public final PBBytesField seq_no = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "seq_no", "insert_list" }, new Object[] { localByteStringMicro, null }, RspRecommendParaArticle.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf30.oidb_cmd0xf30.RspRecommendParaArticle
 * JD-Core Version:    0.7.0.1
 */