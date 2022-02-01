package tencent.im.oidb.cmd0xae9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class group_online_docs$DocInfo
  extends MessageMicro<DocInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50 }, new String[] { "doc_meta_data", "creator_nick", "owner_nick", "last_modify_nick", "top", "doc_url" }, new Object[] { null, "", "", "", Integer.valueOf(0), "" }, DocInfo.class);
  public final PBStringField creator_nick = PBField.initString("");
  public online_docs.DocMetaData doc_meta_data = new online_docs.DocMetaData();
  public final PBStringField doc_url = PBField.initString("");
  public final PBStringField last_modify_nick = PBField.initString("");
  public final PBStringField owner_nick = PBField.initString("");
  public final PBUInt32Field top = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xae9.group_online_docs.DocInfo
 * JD-Core Version:    0.7.0.1
 */