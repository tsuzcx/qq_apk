package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQGameMakeTeamInfo$PersonalInfo
  extends MessageMicro<PersonalInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field area = PBField.initInt32(0);
  public final PBStringField openid = PBField.initString("");
  public final PBInt32Field partition = PBField.initInt32(0);
  public final PBInt32Field plat_id = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "openid", "plat_id", "area", "partition" }, new Object[] { "", localInteger, localInteger, localInteger }, PersonalInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.qqgame.QQGameMakeTeamInfo.PersonalInfo
 * JD-Core Version:    0.7.0.1
 */