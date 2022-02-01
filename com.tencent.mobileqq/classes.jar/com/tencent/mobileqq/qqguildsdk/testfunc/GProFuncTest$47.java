package com.tencent.mobileqq.qqguildsdk.testfunc;

import com.tencent.mobileqq.qqguildsdk.callback.IFetchNoticeRedPointCallback;
import com.tencent.mobileqq.qqguildsdk.data.GuildNoticeRedPoint;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class GProFuncTest$47
  implements IFetchNoticeRedPointCallback
{
  public void a(int paramInt, String paramString, List<GuildNoticeRedPoint> paramList)
  {
    Object localObject1 = paramList.iterator();
    StringBuilder localStringBuilder;
    for (paramList = ""; ((Iterator)localObject1).hasNext(); paramList = localStringBuilder.toString())
    {
      localObject2 = (GuildNoticeRedPoint)((Iterator)localObject1).next();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramList);
      localStringBuilder.append("{ type:");
      localStringBuilder.append(((GuildNoticeRedPoint)localObject2).a);
      localStringBuilder.append(" count:");
      localStringBuilder.append(((GuildNoticeRedPoint)localObject2).b);
      localStringBuilder.append(" expireTs:");
      localStringBuilder.append(((GuildNoticeRedPoint)localObject2).c);
      localStringBuilder.append("}");
    }
    localObject1 = GProFuncTest.a();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(" onFetchNoticeRedPoint : nResult");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append(" errMsg:");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(" redPoins:");
    ((StringBuilder)localObject2).append(paramList);
    QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.testfunc.GProFuncTest.47
 * JD-Core Version:    0.7.0.1
 */