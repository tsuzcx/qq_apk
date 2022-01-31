package tencent.im.group.nearbybanner;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearbybanner$BannerInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_img_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public nearbybanner.CreateGroupBanner msg_create_banner = new nearbybanner.CreateGroupBanner();
  public nearbybanner.RecommGroupBanner msg_recomm_banner = new nearbybanner.RecommGroupBanner();
  public nearbybanner.SearchBanner msg_search_banner = new nearbybanner.SearchBanner();
  public nearbybanner.SetGroupBanner msg_set_banner = new nearbybanner.SetGroupBanner();
  public nearbybanner.WebBanner msg_web_banner = new nearbybanner.WebBanner();
  public final PBUInt32Field uint32_jump_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58 }, new String[] { "uint32_jump_type", "bytes_img_url", "msg_web_banner", "msg_recomm_banner", "msg_set_banner", "msg_search_banner", "msg_create_banner" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, null, null, null, null }, BannerInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.group.nearbybanner.nearbybanner.BannerInfo
 * JD-Core Version:    0.7.0.1
 */