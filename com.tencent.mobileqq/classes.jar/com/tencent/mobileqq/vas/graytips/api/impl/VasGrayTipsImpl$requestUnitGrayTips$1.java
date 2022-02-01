package com.tencent.mobileqq.vas.graytips.api.impl;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "type", "", "isSuccess", "", "data", "", "kotlin.jvm.PlatformType", "onUpdate"}, k=3, mv={1, 1, 16})
final class VasGrayTipsImpl$requestUnitGrayTips$1
  implements BusinessObserver
{
  VasGrayTipsImpl$requestUnitGrayTips$1(BusinessObserver paramBusinessObserver) {}
  
  public final void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    BusinessObserver localBusinessObserver = this.a;
    if (localBusinessObserver != null) {
      localBusinessObserver.onUpdate(paramInt, paramBoolean, paramObject);
    }
    paramObject = new StringBuilder();
    paramObject.append("result: ");
    paramObject.append(paramInt);
    paramObject.append(" ; ");
    paramObject.append(paramBoolean);
    QLog.d("VasGrayTipsRequestImpl", 2, paramObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.graytips.api.impl.VasGrayTipsImpl.requestUnitGrayTips.1
 * JD-Core Version:    0.7.0.1
 */