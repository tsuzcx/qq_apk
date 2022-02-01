package com.tencent.mobileqq.profilecard.api;

import android.os.Bundle;
import com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IProfileProtocolService
  extends IProfileProtocolConst, IRuntimeService
{
  public abstract <T extends AbsProfileBusinessProcessor> T getBusinessProcessor(Class<? extends AbsProfileBusinessProcessor> paramClass);
  
  public abstract void getProfileDetail(String paramString, List<Short> paramList, int paramInt, Bundle paramBundle);
  
  public abstract void getProfileDetailForEdit();
  
  public abstract void getProfileDetailForLogin();
  
  public abstract void requestProfileCard(Bundle paramBundle);
  
  public abstract void requestProfileCard(String paramString1, String paramString2, int paramInt1, long paramLong1, byte paramByte1, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, String paramString3, long paramLong4, int paramInt2, byte[] paramArrayOfByte2, byte paramByte2);
  
  public abstract void setProfileDetail(Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.api.IProfileProtocolService
 * JD-Core Version:    0.7.0.1
 */