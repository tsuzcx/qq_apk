package com.tencent.mobileqq.profilecommon.processor;

import android.os.Bundle;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;

@KeepClassConstructor
public class AvatarHistoryNumProcessor
  extends AbsProfileCommonProcessor
{
  public AvatarHistoryNumProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvatarHistoryNumProcessor", 2, "getAvatarHistoryNumFlag");
    }
    oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
    localReqBody.rpt_uint64_uins.add(Long.valueOf(this.appRuntime.getLongAccountUin()));
    localReqBody.int32_history_num_flag.set(1);
    getProfileDetail(localReqBody, null);
  }
  
  public String getProcessorKey()
  {
    return "AvatarHistoryNumProcessor";
  }
  
  public void onGetProfileDetailResponse(Bundle paramBundle, boolean paramBoolean, oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvatarHistoryNumProcessor", 2, String.format("onGetProfileDetailResponse request=%s success=%s", new Object[] { paramBundle, Boolean.valueOf(paramBoolean) }));
    }
    if ((paramUdcUinData != null) && (paramUdcUinData.int32_history_num_flag.has()))
    {
      int i = paramUdcUinData.int32_history_num_flag.get();
      if (QLog.isColorLevel()) {
        QLog.d("AvatarHistoryNumProcessor", 2, String.format("onGetProfileDetailResponse numFlag=%s", new Object[] { Integer.valueOf(i) }));
      }
      SharedPreUtils.F(this.appRuntime.getApplication(), this.appRuntime.getCurrentAccountUin(), i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecommon.processor.AvatarHistoryNumProcessor
 * JD-Core Version:    0.7.0.1
 */