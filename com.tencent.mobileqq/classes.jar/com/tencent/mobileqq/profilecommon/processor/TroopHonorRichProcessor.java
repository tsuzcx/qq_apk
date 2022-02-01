package com.tencent.mobileqq.profilecommon.processor;

import android.os.Bundle;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;

@KeepClassConstructor
public class TroopHonorRichProcessor
  extends AbsProfileCommonProcessor
{
  public TroopHonorRichProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  private void a(oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    paramUdcUinData = paramUdcUinData.uint32_troop_honor_rich_flag;
    if (paramUdcUinData.has())
    {
      Object localObject = (ITroopHonorService)this.appRuntime.getRuntimeService(ITroopHonorService.class, "");
      ((ITroopHonorService)localObject).saveHostHonorListRichTag((short)(byte)paramUdcUinData.get());
      ((ITroopHonorService)localObject).updateHostHonorList(false);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("honor_rich_0x5eb,");
        ((StringBuilder)localObject).append(paramUdcUinData.get());
        QLog.d("TroopHonor", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public String getProcessorKey()
  {
    return "TroopHonorRichProcessor";
  }
  
  public boolean onGetProfileDetailRequestForLogin(oidb_0x5eb.ReqBody paramReqBody)
  {
    paramReqBody.uint32_troop_honor_rich_flag.set(1);
    return true;
  }
  
  public void onGetProfileDetailResponse(Bundle paramBundle, boolean paramBoolean, oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    a(paramUdcUinData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecommon.processor.TroopHonorRichProcessor
 * JD-Core Version:    0.7.0.1
 */