package com.tencent.mobileqq.vas.treasurecard.api.impl;

import com.tencent.qphone.base.util.QLog;
import com.tencent.treasurecard.net.INetCallBack;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "resultCode", "", "info", "", "kotlin.jvm.PlatformType", "onResponse"}, k=3, mv={1, 1, 16})
final class VasFTManagerImpl$queryTreasureCard$1
  implements INetCallBack
{
  VasFTManagerImpl$queryTreasureCard$1(INetCallBack paramINetCallBack) {}
  
  public final void a(int paramInt, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("query ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(' ');
    localStringBuilder.append(paramObject);
    QLog.d("treasureCard", 2, localStringBuilder.toString());
    this.a.a(paramInt, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.treasurecard.api.impl.VasFTManagerImpl.queryTreasureCard.1
 * JD-Core Version:    0.7.0.1
 */