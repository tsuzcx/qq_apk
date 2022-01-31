package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StUser;

public final class QQCircleProfile$StGetMainPageProfileRsp
  extends MessageMicro<StGetMainPageProfileRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field TempChatBtnStatus = PBField.initInt32(0);
  public final PBBytesField bizData = PBField.initBytes(ByteStringMicro.EMPTY);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public FeedCloudMeta.StUser user = new FeedCloudMeta.StUser();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "extInfo", "user", "bizData", "TempChatBtnStatus" }, new Object[] { null, null, localByteStringMicro, Integer.valueOf(0) }, StGetMainPageProfileRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleProfile.StGetMainPageProfileRsp
 * JD-Core Version:    0.7.0.1
 */