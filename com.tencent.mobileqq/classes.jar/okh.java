import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import java.util.List;
import tencent.im.oidb.cmd0xe1b.oidb_0xe1b.RspBody;
import tencent.im.oidb.cmd0xe1b.oidb_0xe1b.SetFlagInfoRsp;
import tencent.kandian.flaginfo.flag_info.FlagInfo;

public class okh
  extends niv
{
  private boolean b;
  
  public okh(ReadInJoySettingActivity paramReadInJoySettingActivity, boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    if ((paramInt != 0) || (paramArrayOfByte == null)) {}
    label72:
    int i;
    label151:
    int j;
    try
    {
      QQToast.a(this.a.getApplicationContext(), 2131717259, 0).a();
      paramArrayOfByte = this.a;
      if (this.b) {
        break label492;
      }
      bool1 = true;
      ReadInJoySettingActivity.d(paramArrayOfByte, bool1);
      paramArrayOfByte = ReadInJoySettingActivity.b(this.a);
      if (this.b) {
        break label498;
      }
      bool1 = bool2;
      paramArrayOfByte.setChecked(bool1);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      if (!QLog.isColorLevel()) {
        break label491;
      }
    }
    paramBundle = new oidb_0xe1b.RspBody();
    paramBundle.mergeFrom(paramArrayOfByte);
    if ((paramBundle.msg_set_flag_info_rsp.has()) && (paramBundle.msg_set_flag_info_rsp.rpt_msg_flag_info_list.has()))
    {
      paramArrayOfByte = ((oidb_0xe1b.SetFlagInfoRsp)paramBundle.msg_set_flag_info_rsp.get()).rpt_msg_flag_info_list.get();
      if ((paramArrayOfByte == null) || (paramArrayOfByte.isEmpty())) {
        break label513;
      }
      i = 0;
      paramInt = 0;
      j = paramInt;
      if (i < paramArrayOfByte.size())
      {
        paramBundle = (flag_info.FlagInfo)paramArrayOfByte.get(i);
        if (paramBundle == null) {
          break label488;
        }
        paramInt = paramBundle.uint32_teenager_flag.get();
        break label504;
      }
      label192:
      if ((this.b) && (j == 1))
      {
        QQToast.a(this.a.getApplicationContext(), 2131717261, 0).a();
        bmqa.a("key_sp_is_readinjoy_youngster", Integer.valueOf(1));
        ReadInJoySettingActivity.d(this.a, true);
        return;
        QLog.d("ReadInJoySettingActivity", 2, "requestChangeYoungsterMode, value = " + this.b + "failed.");
        return;
      }
      if ((!this.b) && (j == 0))
      {
        QQToast.a(this.a.getApplicationContext(), 2131717260, 0).a();
        bmqa.a("key_sp_is_readinjoy_youngster", Integer.valueOf(2));
        ReadInJoySettingActivity.d(this.a, false);
        return;
      }
      QQToast.a(this.a.getApplicationContext(), 2131717259, 0).a();
      paramArrayOfByte = this.a;
      if (j != 1) {
        break label519;
      }
    }
    for (;;)
    {
      ReadInJoySettingActivity.d(paramArrayOfByte, bool1);
      ReadInJoySettingActivity.b(this.a).setChecked(ReadInJoySettingActivity.c(this.a));
      if (ReadInJoySettingActivity.c(this.a))
      {
        bmqa.a("key_sp_is_readinjoy_youngster", Integer.valueOf(1));
        return;
      }
      bmqa.a("key_sp_is_readinjoy_youngster", Integer.valueOf(2));
      return;
      QQToast.a(this.a.getApplicationContext(), 2131717259, 0).a();
      paramArrayOfByte = this.a;
      if (!this.b)
      {
        bool1 = true;
        ReadInJoySettingActivity.d(paramArrayOfByte, bool1);
        paramArrayOfByte = ReadInJoySettingActivity.b(this.a);
        if (this.b) {
          break label482;
        }
      }
      label482:
      for (bool1 = true;; bool1 = false)
      {
        paramArrayOfByte.setChecked(bool1);
        return;
        bool1 = false;
        break;
      }
      label488:
      break label504;
      label491:
      return;
      label492:
      bool1 = false;
      break;
      label498:
      bool1 = false;
      break label72;
      label504:
      i += 1;
      break label151;
      label513:
      j = 0;
      break label192;
      label519:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okh
 * JD-Core Version:    0.7.0.1
 */