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

public class qcp
{
  private int jdField_a_of_type_Int;
  private qcq jdField_a_of_type_Qcq = new qcq();
  private int b;
  
  public feeds_info.NowLiveInfo a()
  {
    feeds_info.NowLiveInfo localNowLiveInfo = new feeds_info.NowLiveInfo();
    localNowLiveInfo.msg_type.set(this.jdField_a_of_type_Int);
    localNowLiveInfo.uint32_timestamp.set(this.b);
    nowlive.MixInfo localMixInfo = new nowlive.MixInfo();
    Object localObject = new nowlive.AnchorInfo();
    ((nowlive.AnchorInfo)localObject).fans.set(qcr.a(qcq.a(this.jdField_a_of_type_Qcq)));
    ((nowlive.AnchorInfo)localObject).status.set(qcr.a(qcq.a(this.jdField_a_of_type_Qcq)));
    ((nowlive.AnchorInfo)localObject).uin.set(qcr.b(qcq.a(this.jdField_a_of_type_Qcq)));
    localMixInfo.anchor_info.set((MessageMicro)localObject);
    localObject = new nowlive.LiveInfo();
    if (qcs.a(qcq.a(this.jdField_a_of_type_Qcq)) != null) {
      ((nowlive.LiveInfo)localObject).live_url.set(qcs.a(qcq.a(this.jdField_a_of_type_Qcq)));
    }
    if (qcs.b(qcq.a(this.jdField_a_of_type_Qcq)) != null) {
      ((nowlive.LiveInfo)localObject).room_name.set(qcs.b(qcq.a(this.jdField_a_of_type_Qcq)));
    }
    if (qcs.c(qcq.a(this.jdField_a_of_type_Qcq)) != null) {
      ((nowlive.LiveInfo)localObject).room_cover.set(qcs.c(qcq.a(this.jdField_a_of_type_Qcq)));
    }
    ((nowlive.LiveInfo)localObject).live_statue.set(qcs.a(qcq.a(this.jdField_a_of_type_Qcq)));
    ((nowlive.LiveInfo)localObject).audience.set(qcs.b(qcq.a(this.jdField_a_of_type_Qcq)));
    if (qcs.d(qcq.a(this.jdField_a_of_type_Qcq)) != null)
    {
      ((nowlive.LiveInfo)localObject).vid.set(ByteStringMicro.copyFromUtf8(qcs.d(qcq.a(this.jdField_a_of_type_Qcq))));
      localMixInfo.live_info.set((MessageMicro)localObject);
      localObject = new nowlive.VideoInfo();
      if (qct.a(qcq.a(this.jdField_a_of_type_Qcq)) != null) {
        ((nowlive.VideoInfo)localObject).video_url.set(qct.a(qcq.a(this.jdField_a_of_type_Qcq)));
      }
      if (qct.b(qcq.a(this.jdField_a_of_type_Qcq)) != null) {
        ((nowlive.VideoInfo)localObject).video_cover_url.set(qct.b(qcq.a(this.jdField_a_of_type_Qcq)));
      }
      if (qct.c(qcq.a(this.jdField_a_of_type_Qcq)) == null) {
        break label410;
      }
      ((nowlive.VideoInfo)localObject).vid.set(ByteStringMicro.copyFromUtf8(qct.c(qcq.a(this.jdField_a_of_type_Qcq))));
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
  
  public void a(qcq paramqcq)
  {
    this.jdField_a_of_type_Qcq = paramqcq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qcp
 * JD-Core Version:    0.7.0.1
 */