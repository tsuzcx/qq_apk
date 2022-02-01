package com.tencent.mobileqq.nearby.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.nearby.FaceScoreConfig;
import com.tencent.mobileqq.nearby.api.FaceScoreUtils;
import com.tencent.mobileqq.nearby.api.IFaceScoreUtils;

public class FaceScoreUtilsImpl
  implements IFaceScoreUtils
{
  public Object getConfig(AppInterface paramAppInterface)
  {
    return FaceScoreUtils.a(paramAppInterface);
  }
  
  public boolean getFaceScoreFlag(MessageRecord paramMessageRecord, String paramString)
  {
    return FaceScoreUtils.a(paramMessageRecord, paramString);
  }
  
  public String getFromArray(int paramInt, String... paramVarArgs)
  {
    return FaceScoreUtils.a(paramInt, paramVarArgs);
  }
  
  public boolean getHasInsertMsgFlag(AppInterface paramAppInterface, String paramString)
  {
    return FaceScoreUtils.a(paramAppInterface, paramString);
  }
  
  public void report(String paramString1, String paramString2, String... paramVarArgs)
  {
    FaceScoreUtils.a(paramString1, paramString2, paramVarArgs);
  }
  
  public void saveConfig(AppInterface paramAppInterface, Object paramObject)
  {
    FaceScoreUtils.a(paramAppInterface, (FaceScoreConfig)paramObject);
  }
  
  public void setFaceScoreFlag(MessageRecord paramMessageRecord, String paramString, boolean paramBoolean)
  {
    FaceScoreUtils.a(paramMessageRecord, paramString, paramBoolean);
  }
  
  public void setHasInsertMsgFlag(AppInterface paramAppInterface, String paramString)
  {
    FaceScoreUtils.a(paramAppInterface, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.impl.FaceScoreUtilsImpl
 * JD-Core Version:    0.7.0.1
 */