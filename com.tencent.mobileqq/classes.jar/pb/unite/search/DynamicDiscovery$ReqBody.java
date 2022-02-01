package pb.unite.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DynamicDiscovery$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field business = PBField.initUInt32(0);
  public final PBUInt32Field extend_type = PBField.initUInt32(0);
  public final PBUInt32Field from_type = PBField.initUInt32(0);
  public final PBUInt32Field ignore_gender = PBField.initUInt32(0);
  public final PBBytesField jce_req_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField version = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50 }, new String[] { "from_type", "version", "business", "ignore_gender", "extend_type", "jce_req_buffer" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     pb.unite.search.DynamicDiscovery.ReqBody
 * JD-Core Version:    0.7.0.1
 */