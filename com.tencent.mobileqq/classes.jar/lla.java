import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.List;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.AndroidCameraInfo;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.AudioSwitchPointInfo;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.CmdToClientConfigInfoRspBody;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.MobileQQPttInfo;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.PutinfoHead;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.RspBody;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.SharpTraeInfo;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.TransBuffer;

public class lla
{
  private lkt jdField_a_of_type_Lkt = new lkt(this.jdField_a_of_type_Lkr);
  private hd_video_putinfo.RspBody jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$RspBody = new hd_video_putinfo.RspBody();
  
  public lla(lkr paramlkr) {}
  
  private int a()
  {
    int k = 0;
    int i;
    if (!this.jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$RspBody.msg_to_client_config_info_rsq_body.has()) {
      i = -1;
    }
    Object localObject1;
    boolean bool;
    int j;
    label1260:
    do
    {
      do
      {
        do
        {
          do
          {
            return i;
            localObject1 = (hd_video_putinfo.CmdToClientConfigInfoRspBody)this.jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$RspBody.msg_to_client_config_info_rsq_body.get();
            if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).uint32_log_flag.has())
            {
              i = ((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).uint32_log_flag.get();
              localObject2 = this.jdField_a_of_type_Lkt;
              if (i != 0) {
                break;
              }
              bool = false;
              ((lkt)localObject2).jdField_a_of_type_Boolean = bool;
            }
            if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).bytes_log_report_time.has()) {
              ((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).bytes_log_report_time.get().toStringUtf8();
            }
            if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_android_camera_set.has())
            {
              localObject2 = (hd_video_putinfo.AndroidCameraInfo)((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_android_camera_set.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lku.a = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param1.get());
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lku.b = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param2.get());
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lku.c = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param3.get());
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lku.d = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param4.get());
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lku.e = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param5.get());
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lku.f = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param6.get());
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lku.g = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param7.get());
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lku.h = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param8.get());
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lku.i = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param9.get());
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lku.j = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param10.get());
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lku.k = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param11.get());
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lku.l = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param12.get());
            }
            if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_sharp_trae_info_set.has())
            {
              localObject2 = (hd_video_putinfo.SharpTraeInfo)((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_sharp_trae_info_set.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkx.jdField_a_of_type_Int = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_trae_source.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkx.jdField_b_of_type_Int = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_trae_interface.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkx.c = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_trae_stream_type.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkx.d = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_trae_volume.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkx.e = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_trae_mode.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkx.f = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_arm_flag.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkx.g = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_cpu_hertz.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkx.h = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_audio_set.get();
            }
            if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).uint64_switch.has())
            {
              long l = ((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).uint64_switch.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lky.a = ((byte)(int)(l & 1L));
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lky.b = ((byte)(int)(l >> 1 & 1L));
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lky.c = ((byte)(int)(l >> 2 & 1L));
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lky.d = ((byte)(int)(l >> 3 & 1L));
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lky.e = ((byte)(int)(l >> 4 & 1L));
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lky.f = ((byte)(int)(l >> 5 & 1L));
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lky.g = ((byte)(int)(l >> 6 & 1L));
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lky.h = ((byte)(int)(l >> 7 & 1L));
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lky.i = ((byte)(int)(l >> 13 & 1L));
            }
            if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_qq_ptt_info_set.has())
            {
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkw.jdField_a_of_type_Boolean = true;
              localObject2 = (hd_video_putinfo.MobileQQPttInfo)((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_qq_ptt_info_set.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkw.jdField_a_of_type_Int = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param1.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkw.jdField_b_of_type_Int = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param2.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkw.c = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param3.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkw.d = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param4.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkw.e = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param5.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkw.f = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param6.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkw.g = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param7.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkw.h = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param8.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkw.i = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param9.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkw.j = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param10.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkw.k = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param11.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkw.l = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param12.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkw.m = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param13.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkw.n = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param14.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkw.o = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param15.get();
            }
            if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_audio_quality_set.has())
            {
              localObject2 = (hd_video_putinfo.AudioSwitchPointInfo)((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_audio_quality_set.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkv.jdField_a_of_type_Int = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_wifi_shake.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkv.jdField_b_of_type_Int = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_wifi_time_delay.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkv.c = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_wifi_pack_loss.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkv.d = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_wifi_pack_loss_rate.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkv.jdField_a_of_type_JavaLangString = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).bytes_wifi_words.get().toStringUtf8();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkv.e = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_nowifi_shake.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkv.f = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_nowifi_time_delay.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkv.g = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_nowifi_pack_loss.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkv.h = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_nowifi_pack_loss_rate.get();
              this.jdField_a_of_type_Lkt.jdField_a_of_type_Lkv.jdField_b_of_type_JavaLangString = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).bytes_nowifi_words.get().toStringUtf8();
            }
            i = k;
          } while (!((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).rpt_msg_trans_buffer_list.has());
          localObject1 = ((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).rpt_msg_trans_buffer_list.get();
          i = k;
        } while (localObject1 == null);
        i = k;
      } while (((List)localObject1).size() <= 0);
      j = 0;
      i = k;
    } while (j >= ((List)localObject1).size());
    Object localObject2 = this.jdField_a_of_type_Lkt;
    localObject2.getClass();
    localObject2 = new lkz((lkt)localObject2);
    ((lkz)localObject2).jdField_a_of_type_Int = ((hd_video_putinfo.TransBuffer)((List)localObject1).get(j)).uint32_type.get();
    ((lkz)localObject2).jdField_a_of_type_JavaLangString = ((hd_video_putinfo.TransBuffer)((List)localObject1).get(j)).bytes_content.get().toStringUtf8();
    this.jdField_a_of_type_Lkt.jdField_a_of_type_JavaUtilList.add(localObject2);
    if (((lkz)localObject2).jdField_a_of_type_Int == 1) {
      this.jdField_a_of_type_Lkt.jdField_a_of_type_JavaLangString = ((lkz)localObject2).jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      j += 1;
      break label1260;
      bool = true;
      break;
      if (((lkz)localObject2).jdField_a_of_type_Int == 2) {
        this.jdField_a_of_type_Lkt.jdField_b_of_type_JavaLangString = ((lkz)localObject2).jdField_a_of_type_JavaLangString;
      }
    }
  }
  
  public int a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return -1;
    }
    try
    {
      this.jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$RspBody.mergeFrom(paramArrayOfByte);
      if (!this.jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$RspBody.msg_putinfo_head.has()) {
        return -1;
      }
      paramArrayOfByte = (hd_video_putinfo.PutinfoHead)this.jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$RspBody.msg_putinfo_head.get();
      if ((paramArrayOfByte != null) && (paramArrayOfByte.uint32_error_no.has()) && (paramArrayOfByte.uint32_error_no.get() == 0) && (paramArrayOfByte.enum_body_type.has()) && (paramArrayOfByte.enum_body_type.get() == 2))
      {
        if (paramArrayOfByte.bytes_config_ver.has()) {
          lkr.jdField_a_of_type_JavaLangString = paramArrayOfByte.bytes_config_ver.get().toStringUtf8();
        }
        int i = a();
        return i;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return -1;
  }
  
  public lkt a()
  {
    return this.jdField_a_of_type_Lkt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lla
 * JD-Core Version:    0.7.0.1
 */