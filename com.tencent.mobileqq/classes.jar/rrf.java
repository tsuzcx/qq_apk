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

public class rrf
{
  private int jdField_a_of_type_Int;
  private rrg jdField_a_of_type_Rrg = new rrg();
  private int b;
  
  public feeds_info.NowLiveInfo a()
  {
    feeds_info.NowLiveInfo localNowLiveInfo = new feeds_info.NowLiveInfo();
    localNowLiveInfo.msg_type.set(this.jdField_a_of_type_Int);
    localNowLiveInfo.uint32_timestamp.set(this.b);
    nowlive.MixInfo localMixInfo = new nowlive.MixInfo();
    Object localObject = new nowlive.AnchorInfo();
    ((nowlive.AnchorInfo)localObject).fans.set(rrh.a(rrg.a(this.jdField_a_of_type_Rrg)));
    ((nowlive.AnchorInfo)localObject).status.set(rrh.a(rrg.a(this.jdField_a_of_type_Rrg)));
    ((nowlive.AnchorInfo)localObject).uin.set(rrh.b(rrg.a(this.jdField_a_of_type_Rrg)));
    localMixInfo.anchor_info.set((MessageMicro)localObject);
    localObject = new nowlive.LiveInfo();
    if (rri.a(rrg.a(this.jdField_a_of_type_Rrg)) != null) {
      ((nowlive.LiveInfo)localObject).live_url.set(rri.a(rrg.a(this.jdField_a_of_type_Rrg)));
    }
    if (rri.b(rrg.a(this.jdField_a_of_type_Rrg)) != null) {
      ((nowlive.LiveInfo)localObject).room_name.set(rri.b(rrg.a(this.jdField_a_of_type_Rrg)));
    }
    if (rri.c(rrg.a(this.jdField_a_of_type_Rrg)) != null) {
      ((nowlive.LiveInfo)localObject).room_cover.set(rri.c(rrg.a(this.jdField_a_of_type_Rrg)));
    }
    ((nowlive.LiveInfo)localObject).live_statue.set(rri.a(rrg.a(this.jdField_a_of_type_Rrg)));
    ((nowlive.LiveInfo)localObject).audience.set(rri.b(rrg.a(this.jdField_a_of_type_Rrg)));
    if (rri.d(rrg.a(this.jdField_a_of_type_Rrg)) != null)
    {
      ((nowlive.LiveInfo)localObject).vid.set(ByteStringMicro.copyFromUtf8(rri.d(rrg.a(this.jdField_a_of_type_Rrg))));
      localMixInfo.live_info.set((MessageMicro)localObject);
      localObject = new nowlive.VideoInfo();
      if (rrj.a(rrg.a(this.jdField_a_of_type_Rrg)) != null) {
        ((nowlive.VideoInfo)localObject).video_url.set(rrj.a(rrg.a(this.jdField_a_of_type_Rrg)));
      }
      if (rrj.b(rrg.a(this.jdField_a_of_type_Rrg)) != null) {
        ((nowlive.VideoInfo)localObject).video_cover_url.set(rrj.b(rrg.a(this.jdField_a_of_type_Rrg)));
      }
      if (rrj.c(rrg.a(this.jdField_a_of_type_Rrg)) == null) {
        break label410;
      }
      ((nowlive.VideoInfo)localObject).vid.set(ByteStringMicro.copyFromUtf8(rrj.c(rrg.a(this.jdField_a_of_type_Rrg))));
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
  
  public void a(rrg paramrrg)
  {
    this.jdField_a_of_type_Rrg = paramrrg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rrf
 * JD-Core Version:    0.7.0.1
 */