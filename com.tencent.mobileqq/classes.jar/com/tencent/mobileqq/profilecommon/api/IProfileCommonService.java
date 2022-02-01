package com.tencent.mobileqq.profilecommon.api;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IProfileCommonService
  extends IRuntimeService
{
  public abstract <T extends AbsProfileCommonProcessor> T getProcessor(Class<? extends AbsProfileCommonProcessor> paramClass);
  
  public abstract void getProfileDetailForLogin();
  
  public abstract void notifyProcessProfileModifyPush(int paramInt, ByteStringMicro paramByteStringMicro);
  
  public abstract void notifyProfileModifyPushBegin(long paramLong);
  
  public abstract void notifyProfileModifyPushEnd();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecommon.api.IProfileCommonService
 * JD-Core Version:    0.7.0.1
 */