package pb.unite.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DynamicTabSearch$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public DynamicSearch.ExtensionRequestInfo extension_request_info = new DynamicSearch.ExtensionRequestInfo();
  public final PBUInt32Field from_sub_hot_word_id = PBField.initUInt32(0);
  public final PBBytesField key_word = PBField.initBytes(ByteStringMicro.EMPTY);
  public DynamicSearch.RootSearcherRequest search_request = new DynamicSearch.RootSearcherRequest();
  public final PBBytesField version = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 802, 808 }, new String[] { "key_word", "version", "search_request", "extension_request_info", "from_sub_hot_word_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null, null, Integer.valueOf(0) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     pb.unite.search.DynamicTabSearch.ReqBody
 * JD-Core Version:    0.7.0.1
 */