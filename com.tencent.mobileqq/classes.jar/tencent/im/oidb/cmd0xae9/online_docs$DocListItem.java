package tencent.im.oidb.cmd0xae9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class online_docs$DocListItem
  extends MessageMicro<DocListItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field browse_del_ts = PBField.initUInt32(0);
  public online_docs.DocId doc_id = new online_docs.DocId();
  public final PBBoolField is_pinned = PBField.initBool(false);
  public final PBUInt32Field order_ts = PBField.initUInt32(0);
  public final PBUInt32Field pin_ts = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40 }, new String[] { "doc_id", "is_pinned", "pin_ts", "order_ts", "browse_del_ts" }, new Object[] { null, Boolean.valueOf(false), localInteger, localInteger, localInteger }, DocListItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xae9.online_docs.DocListItem
 * JD-Core Version:    0.7.0.1
 */