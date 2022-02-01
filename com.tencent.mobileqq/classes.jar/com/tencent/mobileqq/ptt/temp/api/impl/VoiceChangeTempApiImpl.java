package com.tencent.mobileqq.ptt.temp.api.impl;

import com.tencent.mobileqq.ptt.temp.api.IVoiceChangeTempApi;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.IndividuationConfigInfo;

public class VoiceChangeTempApiImpl
  implements IVoiceChangeTempApi
{
  public String getContentPicHost()
  {
    return ClubContentJsonTask.b;
  }
  
  public boolean isLaterVersion(String paramString1, String paramString2)
  {
    return IndividuationConfigInfo.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.temp.api.impl.VoiceChangeTempApiImpl
 * JD-Core Version:    0.7.0.1
 */