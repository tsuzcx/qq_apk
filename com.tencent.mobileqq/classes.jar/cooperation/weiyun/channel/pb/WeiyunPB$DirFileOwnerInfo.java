package cooperation.weiyun.channel.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WeiyunPB$DirFileOwnerInfo
  extends MessageMicro<DirFileOwnerInfo>
{
  public static final int OWNER_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "owner_uin" }, new Object[] { Long.valueOf(0L) }, DirFileOwnerInfo.class);
  public final PBUInt64Field owner_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.weiyun.channel.pb.WeiyunPB.DirFileOwnerInfo
 * JD-Core Version:    0.7.0.1
 */