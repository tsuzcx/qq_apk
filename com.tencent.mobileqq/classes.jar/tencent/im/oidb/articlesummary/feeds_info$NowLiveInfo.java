package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.nowlive.nowlive.MixInfo;

public final class feeds_info$NowLiveInfo
  extends MessageMicro<NowLiveInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public nowlive.MixInfo mix_info = new nowlive.MixInfo();
  public final PBUInt32Field msg_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "msg_type", "mix_info", "uint32_timestamp" }, new Object[] { localInteger, null, localInteger }, NowLiveInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.feeds_info.NowLiveInfo
 * JD-Core Version:    0.7.0.1
 */