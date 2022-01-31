package cooperation.weiyun.channel.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class WeiyunPB$LibInfoListGetMsgReq
  extends MessageMicro<LibInfoListGetMsgReq>
{
  public static final int COUNT_FIELD_NUMBER = 40;
  public static final int GROUP_ID_FIELD_NUMBER = 50;
  public static final int LIB_ID_FIELD_NUMBER = 10;
  public static final int LOAD_TYPE_FIELD_NUMBER = 20;
  public static final int LOCAL_VERSION_FIELD_NUMBER = 30;
  public static final int SCENE_ID_FIELD_NUMBER = 60;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 160, 242, 320, 400, 480 }, new String[] { "lib_id", "load_type", "local_version", "count", "group_id", "scene_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, LibInfoListGetMsgReq.class);
  public final PBInt32Field count = PBField.initInt32(0);
  public final PBInt32Field group_id = PBField.initInt32(0);
  public final PBInt32Field lib_id = PBField.initInt32(0);
  public final PBInt32Field load_type = PBField.initInt32(0);
  public final PBStringField local_version = PBField.initString("");
  public final PBInt32Field scene_id = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.weiyun.channel.pb.WeiyunPB.LibInfoListGetMsgReq
 * JD-Core Version:    0.7.0.1
 */