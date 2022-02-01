package pb.unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UnifyTabSearch$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public UnifySearchCommon.ExtensionRequestInfo extension_request_info = new UnifySearchCommon.ExtensionRequestInfo();
  public final PBUInt32Field from_sub_hot_word_id = PBField.initUInt32(0);
  public final PBUInt32Field from_tabbar_index = PBField.initUInt32(0);
  public final PBBytesField key_word = PBField.initBytes(ByteStringMicro.EMPTY);
  public UnifySearchCommon.RootSearcherRequest search_request = new UnifySearchCommon.RootSearcherRequest();
  public final PBBytesField version = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 802, 808, 816 }, new String[] { "key_word", "version", "search_request", "extension_request_info", "from_sub_hot_word_id", "from_tabbar_index" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null, null, Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     pb.unify.search.UnifyTabSearch.ReqBody
 * JD-Core Version:    0.7.0.1
 */