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

public class qya
{
  private int jdField_a_of_type_Int;
  private qyb jdField_a_of_type_Qyb = new qyb();
  private int b;
  
  public feeds_info.NowLiveInfo a()
  {
    feeds_info.NowLiveInfo localNowLiveInfo = new feeds_info.NowLiveInfo();
    localNowLiveInfo.msg_type.set(this.jdField_a_of_type_Int);
    localNowLiveInfo.uint32_timestamp.set(this.b);
    nowlive.MixInfo localMixInfo = new nowlive.MixInfo();
    Object localObject = new nowlive.AnchorInfo();
    ((nowlive.AnchorInfo)localObject).fans.set(qyc.a(qyb.a(this.jdField_a_of_type_Qyb)));
    ((nowlive.AnchorInfo)localObject).status.set(qyc.a(qyb.a(this.jdField_a_of_type_Qyb)));
    ((nowlive.AnchorInfo)localObject).uin.set(qyc.b(qyb.a(this.jdField_a_of_type_Qyb)));
    localMixInfo.anchor_info.set((MessageMicro)localObject);
    localObject = new nowlive.LiveInfo();
    if (qyd.a(qyb.a(this.jdField_a_of_type_Qyb)) != null) {
      ((nowlive.LiveInfo)localObject).live_url.set(qyd.a(qyb.a(this.jdField_a_of_type_Qyb)));
    }
    if (qyd.b(qyb.a(this.jdField_a_of_type_Qyb)) != null) {
      ((nowlive.LiveInfo)localObject).room_name.set(qyd.b(qyb.a(this.jdField_a_of_type_Qyb)));
    }
    if (qyd.c(qyb.a(this.jdField_a_of_type_Qyb)) != null) {
      ((nowlive.LiveInfo)localObject).room_cover.set(qyd.c(qyb.a(this.jdField_a_of_type_Qyb)));
    }
    ((nowlive.LiveInfo)localObject).live_statue.set(qyd.a(qyb.a(this.jdField_a_of_type_Qyb)));
    ((nowlive.LiveInfo)localObject).audience.set(qyd.b(qyb.a(this.jdField_a_of_type_Qyb)));
    if (qyd.d(qyb.a(this.jdField_a_of_type_Qyb)) != null)
    {
      ((nowlive.LiveInfo)localObject).vid.set(ByteStringMicro.copyFromUtf8(qyd.d(qyb.a(this.jdField_a_of_type_Qyb))));
      localMixInfo.live_info.set((MessageMicro)localObject);
      localObject = new nowlive.VideoInfo();
      if (qye.a(qyb.a(this.jdField_a_of_type_Qyb)) != null) {
        ((nowlive.VideoInfo)localObject).video_url.set(qye.a(qyb.a(this.jdField_a_of_type_Qyb)));
      }
      if (qye.b(qyb.a(this.jdField_a_of_type_Qyb)) != null) {
        ((nowlive.VideoInfo)localObject).video_cover_url.set(qye.b(qyb.a(this.jdField_a_of_type_Qyb)));
      }
      if (qye.c(qyb.a(this.jdField_a_of_type_Qyb)) == null) {
        break label410;
      }
      ((nowlive.VideoInfo)localObject).vid.set(ByteStringMicro.copyFromUtf8(qye.c(qyb.a(this.jdField_a_of_type_Qyb))));
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
  
  public void a(qyb paramqyb)
  {
    this.jdField_a_of_type_Qyb = paramqyb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qya
 * JD-Core Version:    0.7.0.1
 */