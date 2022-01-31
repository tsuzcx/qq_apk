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

public class qml
{
  private int jdField_a_of_type_Int;
  private qmm jdField_a_of_type_Qmm = new qmm();
  private int b;
  
  public feeds_info.NowLiveInfo a()
  {
    feeds_info.NowLiveInfo localNowLiveInfo = new feeds_info.NowLiveInfo();
    localNowLiveInfo.msg_type.set(this.jdField_a_of_type_Int);
    localNowLiveInfo.uint32_timestamp.set(this.b);
    nowlive.MixInfo localMixInfo = new nowlive.MixInfo();
    Object localObject = new nowlive.AnchorInfo();
    ((nowlive.AnchorInfo)localObject).fans.set(qmn.a(qmm.a(this.jdField_a_of_type_Qmm)));
    ((nowlive.AnchorInfo)localObject).status.set(qmn.a(qmm.a(this.jdField_a_of_type_Qmm)));
    ((nowlive.AnchorInfo)localObject).uin.set(qmn.b(qmm.a(this.jdField_a_of_type_Qmm)));
    localMixInfo.anchor_info.set((MessageMicro)localObject);
    localObject = new nowlive.LiveInfo();
    if (qmo.a(qmm.a(this.jdField_a_of_type_Qmm)) != null) {
      ((nowlive.LiveInfo)localObject).live_url.set(qmo.a(qmm.a(this.jdField_a_of_type_Qmm)));
    }
    if (qmo.b(qmm.a(this.jdField_a_of_type_Qmm)) != null) {
      ((nowlive.LiveInfo)localObject).room_name.set(qmo.b(qmm.a(this.jdField_a_of_type_Qmm)));
    }
    if (qmo.c(qmm.a(this.jdField_a_of_type_Qmm)) != null) {
      ((nowlive.LiveInfo)localObject).room_cover.set(qmo.c(qmm.a(this.jdField_a_of_type_Qmm)));
    }
    ((nowlive.LiveInfo)localObject).live_statue.set(qmo.a(qmm.a(this.jdField_a_of_type_Qmm)));
    ((nowlive.LiveInfo)localObject).audience.set(qmo.b(qmm.a(this.jdField_a_of_type_Qmm)));
    if (qmo.d(qmm.a(this.jdField_a_of_type_Qmm)) != null)
    {
      ((nowlive.LiveInfo)localObject).vid.set(ByteStringMicro.copyFromUtf8(qmo.d(qmm.a(this.jdField_a_of_type_Qmm))));
      localMixInfo.live_info.set((MessageMicro)localObject);
      localObject = new nowlive.VideoInfo();
      if (qmp.a(qmm.a(this.jdField_a_of_type_Qmm)) != null) {
        ((nowlive.VideoInfo)localObject).video_url.set(qmp.a(qmm.a(this.jdField_a_of_type_Qmm)));
      }
      if (qmp.b(qmm.a(this.jdField_a_of_type_Qmm)) != null) {
        ((nowlive.VideoInfo)localObject).video_cover_url.set(qmp.b(qmm.a(this.jdField_a_of_type_Qmm)));
      }
      if (qmp.c(qmm.a(this.jdField_a_of_type_Qmm)) == null) {
        break label410;
      }
      ((nowlive.VideoInfo)localObject).vid.set(ByteStringMicro.copyFromUtf8(qmp.c(qmm.a(this.jdField_a_of_type_Qmm))));
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
  
  public void a(qmm paramqmm)
  {
    this.jdField_a_of_type_Qmm = paramqmm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qml
 * JD-Core Version:    0.7.0.1
 */