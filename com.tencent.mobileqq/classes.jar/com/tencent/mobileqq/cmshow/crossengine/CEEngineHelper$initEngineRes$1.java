package com.tencent.mobileqq.cmshow.crossengine;

import com.tencent.mobileqq.apollo.utils.CrossEngineResManager.LoadListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "resultCode", "", "onResult"}, k=3, mv={1, 1, 16})
final class CEEngineHelper$initEngineRes$1
  implements CrossEngineResManager.LoadListener
{
  CEEngineHelper$initEngineRes$1(CrossEngineResManager.LoadListener paramLoadListener) {}
  
  public final void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("loadCrossEngine resultCode : ");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = true;
    QLog.d("[cmshow][CECMShowOffscreenEngine][CEEngineHelper]", 1, (String)localObject);
    localObject = CEEngineHelper.a;
    if (paramInt != 0) {
      bool = false;
    }
    CEEngineHelper.a((CEEngineHelper)localObject, bool);
    localObject = this.a;
    if (localObject != null) {
      ((CrossEngineResManager.LoadListener)localObject).a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CEEngineHelper.initEngineRes.1
 * JD-Core Version:    0.7.0.1
 */