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

public class rhh
{
  private int jdField_a_of_type_Int;
  private rhi jdField_a_of_type_Rhi = new rhi();
  private int b;
  
  public feeds_info.NowLiveInfo a()
  {
    feeds_info.NowLiveInfo localNowLiveInfo = new feeds_info.NowLiveInfo();
    localNowLiveInfo.msg_type.set(this.jdField_a_of_type_Int);
    localNowLiveInfo.uint32_timestamp.set(this.b);
    nowlive.MixInfo localMixInfo = new nowlive.MixInfo();
    Object localObject = new nowlive.AnchorInfo();
    ((nowlive.AnchorInfo)localObject).fans.set(rhj.a(rhi.a(this.jdField_a_of_type_Rhi)));
    ((nowlive.AnchorInfo)localObject).status.set(rhj.a(rhi.a(this.jdField_a_of_type_Rhi)));
    ((nowlive.AnchorInfo)localObject).uin.set(rhj.b(rhi.a(this.jdField_a_of_type_Rhi)));
    localMixInfo.anchor_info.set((MessageMicro)localObject);
    localObject = new nowlive.LiveInfo();
    if (rhk.a(rhi.a(this.jdField_a_of_type_Rhi)) != null) {
      ((nowlive.LiveInfo)localObject).live_url.set(rhk.a(rhi.a(this.jdField_a_of_type_Rhi)));
    }
    if (rhk.b(rhi.a(this.jdField_a_of_type_Rhi)) != null) {
      ((nowlive.LiveInfo)localObject).room_name.set(rhk.b(rhi.a(this.jdField_a_of_type_Rhi)));
    }
    if (rhk.c(rhi.a(this.jdField_a_of_type_Rhi)) != null) {
      ((nowlive.LiveInfo)localObject).room_cover.set(rhk.c(rhi.a(this.jdField_a_of_type_Rhi)));
    }
    ((nowlive.LiveInfo)localObject).live_statue.set(rhk.a(rhi.a(this.jdField_a_of_type_Rhi)));
    ((nowlive.LiveInfo)localObject).audience.set(rhk.b(rhi.a(this.jdField_a_of_type_Rhi)));
    if (rhk.d(rhi.a(this.jdField_a_of_type_Rhi)) != null)
    {
      ((nowlive.LiveInfo)localObject).vid.set(ByteStringMicro.copyFromUtf8(rhk.d(rhi.a(this.jdField_a_of_type_Rhi))));
      localMixInfo.live_info.set((MessageMicro)localObject);
      localObject = new nowlive.VideoInfo();
      if (rhl.a(rhi.a(this.jdField_a_of_type_Rhi)) != null) {
        ((nowlive.VideoInfo)localObject).video_url.set(rhl.a(rhi.a(this.jdField_a_of_type_Rhi)));
      }
      if (rhl.b(rhi.a(this.jdField_a_of_type_Rhi)) != null) {
        ((nowlive.VideoInfo)localObject).video_cover_url.set(rhl.b(rhi.a(this.jdField_a_of_type_Rhi)));
      }
      if (rhl.c(rhi.a(this.jdField_a_of_type_Rhi)) == null) {
        break label410;
      }
      ((nowlive.VideoInfo)localObject).vid.set(ByteStringMicro.copyFromUtf8(rhl.c(rhi.a(this.jdField_a_of_type_Rhi))));
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
  
  public void a(rhi paramrhi)
  {
    this.jdField_a_of_type_Rhi = paramrhi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rhh
 * JD-Core Version:    0.7.0.1
 */