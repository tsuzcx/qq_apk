package tencent.im.oidb.cmd0xaea;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0xae9.online_docs.DocId;

public final class Oidb_0xaea$DeleteDocReq
  extends MessageMicro<DeleteDocReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "group_code", "doc_id", "copy" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0) }, DeleteDocReq.class);
  public final PBUInt32Field copy = PBField.initUInt32(0);
  public online_docs.DocId doc_id = new online_docs.DocId();
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xaea.Oidb_0xaea.DeleteDocReq
 * JD-Core Version:    0.7.0.1
 */