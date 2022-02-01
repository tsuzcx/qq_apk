package com.tencent.mobileqq.kandian.biz.atlas;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import java.util.List;
import tencent.im.oidb.cmd0xe1b.oidb_0xe1b.RspBody;
import tencent.im.oidb.cmd0xe1b.oidb_0xe1b.SetFlagInfoRsp;
import tencent.kandian.flaginfo.flag_info.FlagInfo;

class ReadInJoySettingActivity$ChangeYoungsterModeCallback
  extends ProtoUtils.TroopProtocolObserver
{
  private boolean b;
  
  ReadInJoySettingActivity$ChangeYoungsterModeCallback(ReadInJoySettingActivity paramReadInJoySettingActivity, boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    boolean bool3 = true;
    boolean bool2 = true;
    bool1 = false;
    if ((paramInt == 0) && (paramArrayOfByte != null)) {}
    try
    {
      paramBundle = new oidb_0xe1b.RspBody();
      paramBundle.mergeFrom(paramArrayOfByte);
      if ((!paramBundle.msg_set_flag_info_rsp.has()) || (!paramBundle.msg_set_flag_info_rsp.rpt_msg_flag_info_list.has())) {
        break label319;
      }
      paramArrayOfByte = ((oidb_0xe1b.SetFlagInfoRsp)paramBundle.msg_set_flag_info_rsp.get()).rpt_msg_flag_info_list.get();
      if ((paramArrayOfByte == null) || (paramArrayOfByte.isEmpty())) {
        break label522;
      }
      i = 0;
      paramInt = 0;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        int i;
        continue;
        i += 1;
        continue;
        int j = 0;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
      }
    }
    j = paramInt;
    if (i < paramArrayOfByte.size())
    {
      paramBundle = (flag_info.FlagInfo)paramArrayOfByte.get(i);
      if (paramBundle != null) {
        paramInt = paramBundle.uint32_teenager_flag.get();
      }
    }
    else
    {
      bool2 = this.b;
      if ((bool2) && (j == 1))
      {
        QQToast.makeText(this.a.getApplicationContext(), 2131915609, 0).show();
        RIJSPUtils.a("key_sp_is_readinjoy_youngster", Integer.valueOf(1));
        ReadInJoySettingActivity.h(this.a, true);
        return;
      }
      if ((!this.b) && (j == 0))
      {
        QQToast.makeText(this.a.getApplicationContext(), 2131915608, 0).show();
        RIJSPUtils.a("key_sp_is_readinjoy_youngster", Integer.valueOf(2));
        ReadInJoySettingActivity.h(this.a, false);
        return;
      }
      QQToast.makeText(this.a.getApplicationContext(), 2131915607, 0).show();
      paramArrayOfByte = this.a;
      if (j == 1) {
        bool1 = true;
      }
      ReadInJoySettingActivity.h(paramArrayOfByte, bool1);
      ReadInJoySettingActivity.g(this.a).setChecked(ReadInJoySettingActivity.h(this.a));
      if (ReadInJoySettingActivity.h(this.a))
      {
        RIJSPUtils.a("key_sp_is_readinjoy_youngster", Integer.valueOf(1));
        return;
      }
      RIJSPUtils.a("key_sp_is_readinjoy_youngster", Integer.valueOf(2));
      return;
      label319:
      QQToast.makeText(this.a.getApplicationContext(), 2131915607, 0).show();
      paramArrayOfByte = this.a;
      if (this.b) {
        break label528;
      }
      bool1 = true;
      ReadInJoySettingActivity.h(paramArrayOfByte, bool1);
      paramArrayOfByte = ReadInJoySettingActivity.g(this.a);
      if (this.b) {
        break label534;
      }
      bool1 = bool2;
      paramArrayOfByte.setChecked(bool1);
      return;
      QQToast.makeText(this.a.getApplicationContext(), 2131915607, 0).show();
      paramArrayOfByte = this.a;
      if (this.b) {
        break label540;
      }
      bool1 = true;
      ReadInJoySettingActivity.h(paramArrayOfByte, bool1);
      paramArrayOfByte = ReadInJoySettingActivity.g(this.a);
      if (this.b) {
        break label546;
      }
      bool1 = bool3;
      paramArrayOfByte.setChecked(bool1);
      return;
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("requestChangeYoungsterMode, value = ");
        paramArrayOfByte.append(this.b);
        paramArrayOfByte.append("failed.");
        QLog.d("ReadInJoySettingActivity", 2, paramArrayOfByte.toString());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.ReadInJoySettingActivity.ChangeYoungsterModeCallback
 * JD-Core Version:    0.7.0.1
 */