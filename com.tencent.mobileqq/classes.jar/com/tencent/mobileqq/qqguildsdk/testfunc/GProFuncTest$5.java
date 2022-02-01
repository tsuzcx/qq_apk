package com.tencent.mobileqq.qqguildsdk.testfunc;

import com.tencent.mobileqq.qqguildsdk.callback.IGetAudioChannelMemberInfosListCallback;
import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class GProFuncTest$5
  implements IGetAudioChannelMemberInfosListCallback
{
  public void a(int paramInt, String paramString, List<IAudioChannelMemberInfos> paramList)
  {
    String str = GProFuncTest.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("result： ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errMsg:");
    localStringBuilder.append(paramString);
    QLog.d(str, 2, localStringBuilder.toString());
    if (paramList != null)
    {
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        paramList = (IAudioChannelMemberInfos)paramString.next();
        GProFuncTest.a(this.a, paramList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.testfunc.GProFuncTest.5
 * JD-Core Version:    0.7.0.1
 */