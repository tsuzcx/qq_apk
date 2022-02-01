import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.feeds_info.NowLiveInfo;
import tencent.im.oidb.nowlive.nowlive.AnchorInfo;
import tencent.im.oidb.nowlive.nowlive.LiveInfo;
import tencent.im.oidb.nowlive.nowlive.MixInfo;
import tencent.im.oidb.nowlive.nowlive.VideoInfo;

public class rey
{
  private int jdField_a_of_type_Int;
  private rez jdField_a_of_type_Rez = new rez();
  private int b;
  
  public feeds_info.NowLiveInfo a()
  {
    feeds_info.NowLiveInfo localNowLiveInfo = new feeds_info.NowLiveInfo();
    localNowLiveInfo.msg_type.set(this.jdField_a_of_type_Int);
    localNowLiveInfo.uint32_timestamp.set(this.b);
    nowlive.MixInfo localMixInfo = new nowlive.MixInfo();
    Object localObject = new nowlive.AnchorInfo();
    ((nowlive.AnchorInfo)localObject).fans.set(rfa.a(rez.a(this.jdField_a_of_type_Rez)));
    ((nowlive.AnchorInfo)localObject).status.set(rfa.a(rez.a(this.jdField_a_of_type_Rez)));
    ((nowlive.AnchorInfo)localObject).uin.set(rfa.b(rez.a(this.jdField_a_of_type_Rez)));
    localMixInfo.anchor_info.set((MessageMicro)localObject);
    localObject = new nowlive.LiveInfo();
    if (rfb.a(rez.a(this.jdField_a_of_type_Rez)) != null) {
      ((nowlive.LiveInfo)localObject).live_url.set(rfb.a(rez.a(this.jdField_a_of_type_Rez)));
    }
    if (rfb.b(rez.a(this.jdField_a_of_type_Rez)) != null) {
      ((nowlive.LiveInfo)localObject).room_name.set(rfb.b(rez.a(this.jdField_a_of_type_Rez)));
    }
    if (rfb.c(rez.a(this.jdField_a_of_type_Rez)) != null) {
      ((nowlive.LiveInfo)localObject).room_cover.set(rfb.c(rez.a(this.jdField_a_of_type_Rez)));
    }
    ((nowlive.LiveInfo)localObject).live_statue.set(rfb.a(rez.a(this.jdField_a_of_type_Rez)));
    ((nowlive.LiveInfo)localObject).audience.set(rfb.b(rez.a(this.jdField_a_of_type_Rez)));
    if (rfb.d(rez.a(this.jdField_a_of_type_Rez)) != null)
    {
      ((nowlive.LiveInfo)localObject).vid.set(ByteStringMicro.copyFromUtf8(rfb.d(rez.a(this.jdField_a_of_type_Rez))));
      localMixInfo.live_info.set((MessageMicro)localObject);
      localObject = new nowlive.VideoInfo();
      if (rfc.a(rez.a(this.jdField_a_of_type_Rez)) != null) {
        ((nowlive.VideoInfo)localObject).video_url.set(rfc.a(rez.a(this.jdField_a_of_type_Rez)));
      }
      if (rfc.b(rez.a(this.jdField_a_of_type_Rez)) != null) {
        ((nowlive.VideoInfo)localObject).video_cover_url.set(rfc.b(rez.a(this.jdField_a_of_type_Rez)));
      }
      if (rfc.c(rez.a(this.jdField_a_of_type_Rez)) == null) {
        break label410;
      }
      ((nowlive.VideoInfo)localObject).vid.set(ByteStringMicro.copyFromUtf8(rfc.c(rez.a(this.jdField_a_of_type_Rez))));
    }
    for (;;)
    {
      localMixInfo.video_info.set((MessageMicro)localObject);
      localNowLiveInfo.mix_info.set(localMixInfo);
      return localNowLiveInfo;
      ((nowlive.LiveInfo)localObject).vid.set(ByteStringMicro.EMPTY);
      break;
      label410:
      ((nowlive.VideoInfo)localObject).vid.set(ByteStringMicro.EMPTY);
    }
  }
  
  public void a(rez paramrez)
  {
    this.jdField_a_of_type_Rez = paramrez;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rey
 * JD-Core Version:    0.7.0.1
 */