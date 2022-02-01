package pb.unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import unify.search.UnifySearchCommon.ExtensionRequestInfo;
import unify.search.UnifySearchCommon.RootSearcherRequest;

public final class UnifySearchUnite$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field client_has_people_and_qun = PBField.initUInt32(0);
  public UnifySearchCommon.ExtensionRequestInfo extension_request_info = new UnifySearchCommon.ExtensionRequestInfo();
  public final PBUInt32Field from_action = PBField.initUInt32(0);
  public final PBUInt32Field from_tabbar_index = PBField.initUInt32(0);
  public final PBBytesField key_word = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field locate_result_count = PBField.initUInt32(0);
  public UnifySearchCommon.RootSearcherRequest req_entity = new UnifySearchCommon.RootSearcherRequest();
  public UnifySearchCommon.RootSearcherRequest req_topic = new UnifySearchCommon.RootSearcherRequest();
  public final PBUInt32Field source = PBField.initUInt32(0);
  public final PBUInt32Field use_req_mask_only = PBField.initUInt32(0);
  public final PBBytesField version = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 56, 64, 72, 80, 802 }, new String[] { "key_word", "version", "req_entity", "req_topic", "from_action", "client_has_people_and_qun", "from_tabbar_index", "source", "locate_result_count", "use_req_mask_only", "extension_request_info" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null, null, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, null }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     pb.unify.search.UnifySearchUnite.ReqBody
 * JD-Core Version:    0.7.0.1
 */