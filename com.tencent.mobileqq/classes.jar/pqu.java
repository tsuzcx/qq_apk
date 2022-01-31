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

public class pqu
{
  private int jdField_a_of_type_Int;
  private pqv jdField_a_of_type_Pqv = new pqv();
  private int b;
  
  public feeds_info.NowLiveInfo a()
  {
    feeds_info.NowLiveInfo localNowLiveInfo = new feeds_info.NowLiveInfo();
    localNowLiveInfo.msg_type.set(this.jdField_a_of_type_Int);
    localNowLiveInfo.uint32_timestamp.set(this.b);
    nowlive.MixInfo localMixInfo = new nowlive.MixInfo();
    Object localObject = new nowlive.AnchorInfo();
    ((nowlive.AnchorInfo)localObject).fans.set(pqw.a(pqv.a(this.jdField_a_of_type_Pqv)));
    ((nowlive.AnchorInfo)localObject).status.set(pqw.a(pqv.a(this.jdField_a_of_type_Pqv)));
    ((nowlive.AnchorInfo)localObject).uin.set(pqw.b(pqv.a(this.jdField_a_of_type_Pqv)));
    localMixInfo.anchor_info.set((MessageMicro)localObject);
    localObject = new nowlive.LiveInfo();
    if (pqx.a(pqv.a(this.jdField_a_of_type_Pqv)) != null) {
      ((nowlive.LiveInfo)localObject).live_url.set(pqx.a(pqv.a(this.jdField_a_of_type_Pqv)));
    }
    if (pqx.b(pqv.a(this.jdField_a_of_type_Pqv)) != null) {
      ((nowlive.LiveInfo)localObject).room_name.set(pqx.b(pqv.a(this.jdField_a_of_type_Pqv)));
    }
    if (pqx.c(pqv.a(this.jdField_a_of_type_Pqv)) != null) {
      ((nowlive.LiveInfo)localObject).room_cover.set(pqx.c(pqv.a(this.jdField_a_of_type_Pqv)));
    }
    ((nowlive.LiveInfo)localObject).live_statue.set(pqx.a(pqv.a(this.jdField_a_of_type_Pqv)));
    ((nowlive.LiveInfo)localObject).audience.set(pqx.b(pqv.a(this.jdField_a_of_type_Pqv)));
    if (pqx.d(pqv.a(this.jdField_a_of_type_Pqv)) != null)
    {
      ((nowlive.LiveInfo)localObject).vid.set(ByteStringMicro.copyFromUtf8(pqx.d(pqv.a(this.jdField_a_of_type_Pqv))));
      localMixInfo.live_info.set((MessageMicro)localObject);
      localObject = new nowlive.VideoInfo();
      if (pqy.a(pqv.a(this.jdField_a_of_type_Pqv)) != null) {
        ((nowlive.VideoInfo)localObject).video_url.set(pqy.a(pqv.a(this.jdField_a_of_type_Pqv)));
      }
      if (pqy.b(pqv.a(this.jdField_a_of_type_Pqv)) != null) {
        ((nowlive.VideoInfo)localObject).video_cover_url.set(pqy.b(pqv.a(this.jdField_a_of_type_Pqv)));
      }
      if (pqy.c(pqv.a(this.jdField_a_of_type_Pqv)) == null) {
        break label410;
      }
      ((nowlive.VideoInfo)localObject).vid.set(ByteStringMicro.copyFromUtf8(pqy.c(pqv.a(this.jdField_a_of_type_Pqv))));
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
  
  public void a(pqv parampqv)
  {
    this.jdField_a_of_type_Pqv = parampqv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pqu
 * JD-Core Version:    0.7.0.1
 */