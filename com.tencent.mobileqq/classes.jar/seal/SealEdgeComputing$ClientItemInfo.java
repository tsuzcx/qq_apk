package seal;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class SealEdgeComputing$ClientItemInfo
  extends MessageMicro<ClientItemInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 25 }, new String[] { "cate_name", "sub_cate_name", "seal_score" }, new Object[] { "", "", Double.valueOf(0.0D) }, ClientItemInfo.class);
  public final PBStringField cate_name = PBField.initString("");
  public final PBDoubleField seal_score = PBField.initDouble(0.0D);
  public final PBStringField sub_cate_name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     seal.SealEdgeComputing.ClientItemInfo
 * JD-Core Version:    0.7.0.1
 */