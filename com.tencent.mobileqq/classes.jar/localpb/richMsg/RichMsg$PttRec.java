package localpb.richMsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class RichMsg$PttRec
  extends MessageMicro<PttRec>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 58, 64, 72, 80, 88, 98, 104, 112, 122, 128, 136, 144, 152, 160, 170, 176, 186, 192, 200, 208 }, new String[] { "localPath", "size", "type", "isRead", "uuid", "md5", "serverStorageSource", "version", "isReport", "pttFlag", "groupFileID", "sttText", "longPttVipFlag", "expandStt", "group_file_key", "msgRecTime", "msgTime", "voiceType", "voiceLength", "voiceChangeFlag", "directUrl", "busiType", "fullLocalPath", "extFlag", "redpack_type", "autototext_voice" }, new Object[] { "", Long.valueOf(0L), Integer.valueOf(0), Boolean.valueOf(false), "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", Integer.valueOf(0), Boolean.valueOf(false), "", Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "", Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, PttRec.class);
  public final PBUInt32Field autototext_voice = PBField.initUInt32(0);
  public final PBUInt32Field busiType = PBField.initUInt32(0);
  public final PBStringField directUrl = PBField.initString("");
  public final PBBoolField expandStt = PBField.initBool(false);
  public final PBUInt64Field extFlag = PBField.initUInt64(0L);
  public final PBStringField fullLocalPath = PBField.initString("");
  public final PBUInt64Field groupFileID = PBField.initUInt64(0L);
  public final PBStringField group_file_key = PBField.initString("");
  public final PBBoolField isRead = PBField.initBool(false);
  public final PBInt32Field isReport = PBField.initInt32(0);
  public final PBStringField localPath = PBField.initString("");
  public final PBInt32Field longPttVipFlag = PBField.initInt32(0);
  public final PBStringField md5 = PBField.initString("");
  public final PBUInt64Field msgRecTime = PBField.initUInt64(0L);
  public final PBUInt64Field msgTime = PBField.initUInt64(0L);
  public final PBInt32Field pttFlag = PBField.initInt32(0);
  public final PBUInt32Field redpack_type = PBField.initUInt32(0);
  public final PBStringField serverStorageSource = PBField.initString("");
  public final PBUInt64Field size = PBField.initUInt64(0L);
  public final PBStringField sttText = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBStringField uuid = PBField.initString("");
  public final PBInt32Field version = PBField.initInt32(0);
  public final PBUInt32Field voiceChangeFlag = PBField.initUInt32(0);
  public final PBUInt32Field voiceLength = PBField.initUInt32(0);
  public final PBUInt32Field voiceType = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     localpb.richMsg.RichMsg.PttRec
 * JD-Core Version:    0.7.0.1
 */