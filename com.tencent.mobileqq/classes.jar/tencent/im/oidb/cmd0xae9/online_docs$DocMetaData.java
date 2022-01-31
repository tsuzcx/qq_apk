package tencent.im.oidb.cmd0xae9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class online_docs$DocMetaData
  extends MessageMicro<DocMetaData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field create_ts = PBField.initUInt32(0);
  public final PBUInt64Field creator_uid = PBField.initUInt64(0L);
  public final PBUInt64Field creator_uin = PBField.initUInt64(0L);
  public final PBStringField doc_icon = PBField.initString("");
  public online_docs.DocId doc_id = new online_docs.DocId();
  public final PBUInt32Field doc_status = PBField.initUInt32(0);
  public final PBStringField doc_thumbnail = PBField.initString("");
  public final PBUInt32Field doc_type = PBField.initUInt32(0);
  public final PBStringField doc_type_desc = PBField.initString("");
  public final PBUInt32Field last_modify_ts = PBField.initUInt32(0);
  public final PBUInt64Field last_modify_uid = PBField.initUInt64(0L);
  public final PBUInt64Field last_modify_uin = PBField.initUInt64(0L);
  public final PBUInt64Field owner_uid = PBField.initUInt64(0L);
  public final PBUInt64Field owner_uin = PBField.initUInt64(0L);
  public final PBStringField short_url = PBField.initString("");
  public final PBUInt32Field status_change_ts = PBField.initUInt32(0);
  public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 114, 122, 130, 138 }, new String[] { "doc_id", "title", "creator_uin", "create_ts", "last_modify_uin", "last_modify_ts", "owner_uin", "doc_type", "creator_uid", "last_modify_uid", "owner_uid", "doc_status", "status_change_ts", "doc_icon", "doc_type_desc", "doc_thumbnail", "short_url" }, new Object[] { null, localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "" }, DocMetaData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xae9.online_docs.DocMetaData
 * JD-Core Version:    0.7.0.1
 */