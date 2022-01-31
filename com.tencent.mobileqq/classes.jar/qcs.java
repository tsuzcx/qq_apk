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

public class qcs
{
  private int jdField_a_of_type_Int;
  private qct jdField_a_of_type_Qct = new qct();
  private int b;
  
  public feeds_info.NowLiveInfo a()
  {
    feeds_info.NowLiveInfo localNowLiveInfo = new feeds_info.NowLiveInfo();
    localNowLiveInfo.msg_type.set(this.jdField_a_of_type_Int);
    localNowLiveInfo.uint32_timestamp.set(this.b);
    nowlive.MixInfo localMixInfo = new nowlive.MixInfo();
    Object localObject = new nowlive.AnchorInfo();
    ((nowlive.AnchorInfo)localObject).fans.set(qcu.a(qct.a(this.jdField_a_of_type_Qct)));
    ((nowlive.AnchorInfo)localObject).status.set(qcu.a(qct.a(this.jdField_a_of_type_Qct)));
    ((nowlive.AnchorInfo)localObject).uin.set(qcu.b(qct.a(this.jdField_a_of_type_Qct)));
    localMixInfo.anchor_info.set((MessageMicro)localObject);
    localObject = new nowlive.LiveInfo();
    if (qcv.a(qct.a(this.jdField_a_of_type_Qct)) != null) {
      ((nowlive.LiveInfo)localObject).live_url.set(qcv.a(qct.a(this.jdField_a_of_type_Qct)));
    }
    if (qcv.b(qct.a(this.jdField_a_of_type_Qct)) != null) {
      ((nowlive.LiveInfo)localObject).room_name.set(qcv.b(qct.a(this.jdField_a_of_type_Qct)));
    }
    if (qcv.c(qct.a(this.jdField_a_of_type_Qct)) != null) {
      ((nowlive.LiveInfo)localObject).room_cover.set(qcv.c(qct.a(this.jdField_a_of_type_Qct)));
    }
    ((nowlive.LiveInfo)localObject).live_statue.set(qcv.a(qct.a(this.jdField_a_of_type_Qct)));
    ((nowlive.LiveInfo)localObject).audience.set(qcv.b(qct.a(this.jdField_a_of_type_Qct)));
    if (qcv.d(qct.a(this.jdField_a_of_type_Qct)) != null)
    {
      ((nowlive.LiveInfo)localObject).vid.set(ByteStringMicro.copyFromUtf8(qcv.d(qct.a(this.jdField_a_of_type_Qct))));
      localMixInfo.live_info.set((MessageMicro)localObject);
      localObject = new nowlive.VideoInfo();
      if (qcw.a(qct.a(this.jdField_a_of_type_Qct)) != null) {
        ((nowlive.VideoInfo)localObject).video_url.set(qcw.a(qct.a(this.jdField_a_of_type_Qct)));
      }
      if (qcw.b(qct.a(this.jdField_a_of_type_Qct)) != null) {
        ((nowlive.VideoInfo)localObject).video_cover_url.set(qcw.b(qct.a(this.jdField_a_of_type_Qct)));
      }
      if (qcw.c(qct.a(this.jdField_a_of_type_Qct)) == null) {
        break label410;
      }
      ((nowlive.VideoInfo)localObject).vid.set(ByteStringMicro.copyFromUtf8(qcw.c(qct.a(this.jdField_a_of_type_Qct))));
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
  
  public void a(qct paramqct)
  {
    this.jdField_a_of_type_Qct = paramqct;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qcs
 * JD-Core Version:    0.7.0.1
 */