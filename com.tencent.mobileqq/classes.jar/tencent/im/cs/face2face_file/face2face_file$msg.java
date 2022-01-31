package tencent.im.cs.face2face_file;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class face2face_file$msg
  extends MessageMicro<msg>
{
  public static final int RESULT_FIELD_NUMBER = 2;
  public static final int VERSION_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "version", "result" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, msg.class);
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBUInt32Field version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.cs.face2face_file.face2face_file.msg
 * JD-Core Version:    0.7.0.1
 */