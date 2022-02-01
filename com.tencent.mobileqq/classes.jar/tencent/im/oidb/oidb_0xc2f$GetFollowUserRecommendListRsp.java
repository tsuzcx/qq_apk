package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xc2f$GetFollowUserRecommendListRsp
  extends MessageMicro<GetFollowUserRecommendListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_0xc2f.RecommendAccountInfo> rpt_msg_recommend_list = PBField.initRepeatMessage(oidb_0xc2f.RecommendAccountInfo.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_msg_recommend_list", "bytes_jump_url" }, new Object[] { null, localByteStringMicro }, GetFollowUserRecommendListRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xc2f.GetFollowUserRecommendListRsp
 * JD-Core Version:    0.7.0.1
 */