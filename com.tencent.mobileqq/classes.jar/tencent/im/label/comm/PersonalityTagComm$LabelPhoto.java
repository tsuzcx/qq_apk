package tencent.im.label.comm;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PersonalityTagComm$LabelPhoto
  extends MessageMicro<LabelPhoto>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_praise_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<PersonalityTagComm.PraiseRec> rpt_msg_praise_rec = PBField.initRepeatMessage(PersonalityTagComm.PraiseRec.class);
  public final PBUInt32Field uint32_file_slot = PBField.initUInt32(0);
  public final PBUInt32Field uint32_praise_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_upload_time = PBField.initUInt32(0);
  public final PBStringField uint32_url = PBField.initString("");
  public final PBUInt64Field uint64_file_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_praise_count = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50, 56, 64 }, new String[] { "uint64_file_id", "uint32_url", "uint32_upload_time", "uint64_praise_count", "rpt_msg_praise_rec", "bytes_praise_cookie", "uint32_file_slot", "uint32_praise_flag" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), Long.valueOf(0L), null, localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, LabelPhoto.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.label.comm.PersonalityTagComm.LabelPhoto
 * JD-Core Version:    0.7.0.1
 */