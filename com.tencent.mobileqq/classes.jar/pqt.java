import android.os.Bundle;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0xe1b.oidb_0xe1b.GetFlagInfoRsp;
import tencent.im.oidb.cmd0xe1b.oidb_0xe1b.RspBody;
import tencent.kandian.flaginfo.flag_info.FlagInfo;

class pqt
  extends nkq
{
  pqt(pqs parampqs) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    int i = 0;
    int k = 0;
    if ((paramInt != 0) || (paramArrayOfByte == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        paramBundle = new oidb_0xe1b.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        if ((!paramBundle.msg_get_flag_info_rsp.has()) || (!paramBundle.msg_get_flag_info_rsp.rpt_msg_flag_info_list.has())) {
          break;
        }
        paramArrayOfByte = ((oidb_0xe1b.GetFlagInfoRsp)paramBundle.msg_get_flag_info_rsp.get()).rpt_msg_flag_info_list.get();
        int j = i;
        if (paramArrayOfByte != null)
        {
          j = i;
          if (!paramArrayOfByte.isEmpty())
          {
            i = 0;
            paramInt = k;
            j = paramInt;
            if (i < paramArrayOfByte.size())
            {
              paramBundle = (flag_info.FlagInfo)paramArrayOfByte.get(i);
              if (paramBundle == null) {
                break label178;
              }
              paramInt = paramBundle.uint32_teenager_flag.get();
              break label178;
            }
          }
        }
        if (j != 0) {
          break label168;
        }
        bnrf.a("key_sp_is_readinjoy_youngster", Integer.valueOf(2));
        return;
      }
      catch (Exception paramArrayOfByte) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SelfInfoModule", 2, "updateSelfYoungsterModeSetting failed.");
      return;
      label168:
      bnrf.a("key_sp_is_readinjoy_youngster", Integer.valueOf(1));
      return;
      label178:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pqt
 * JD-Core Version:    0.7.0.1
 */