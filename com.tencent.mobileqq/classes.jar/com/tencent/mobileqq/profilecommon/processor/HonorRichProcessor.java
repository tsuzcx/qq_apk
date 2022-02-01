package com.tencent.mobileqq.profilecommon.processor;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.troop.handler.TroopListHandler;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorHandler;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class HonorRichProcessor
  extends AbsProfileCommonProcessor
{
  long a;
  
  public HonorRichProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  public String getProcessorKey()
  {
    return "HonorRichProcessor";
  }
  
  public boolean interceptProfileModifyPush(int paramInt)
  {
    return paramInt == 42511;
  }
  
  public void onProcessProfileModifyPush(int paramInt, ByteStringMicro paramByteStringMicro)
  {
    if (paramInt == 42511) {}
    try
    {
      if ((this.appRuntime instanceof QQAppInterface))
      {
        if (TroopListHandler.a())
        {
          ((ITroopHonorService)this.appRuntime.getRuntimeService(ITroopHonorService.class, "")).saveHostHonorListRichTag(ByteBuffer.wrap(paramByteStringMicro.toByteArray()).asShortBuffer().get());
          ITroopHonorHandler localITroopHonorHandler = (ITroopHonorHandler)this.appRuntime.getRuntimeService(ITroopHonorHandler.class, "");
          if (localITroopHonorHandler != null) {
            localITroopHonorHandler.getHostTroopHonorList(true);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopHonor", 2, "honor_rich_push ok：" + paramByteStringMicro.byteAt(1));
        }
      }
      return;
    }
    catch (Exception paramByteStringMicro)
    {
      QLog.d("TroopHonor", 1, "honor_rich_push error：" + paramByteStringMicro.getMessage());
    }
  }
  
  public void onProcessProfileModifyPushBegin(long paramLong)
  {
    this.a = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecommon.processor.HonorRichProcessor
 * JD-Core Version:    0.7.0.1
 */