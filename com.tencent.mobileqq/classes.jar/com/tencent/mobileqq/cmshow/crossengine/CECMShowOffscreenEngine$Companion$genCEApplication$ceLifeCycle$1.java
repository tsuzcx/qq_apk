package com.tencent.mobileqq.cmshow.crossengine;

import com.tencent.crossengine.CELifeCycle;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine$Companion$genCEApplication$ceLifeCycle$1", "Lcom/tencent/crossengine/CELifeCycle;", "onFirstFrame", "", "onGameEnd", "onInit", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CECMShowOffscreenEngine$Companion$genCEApplication$ceLifeCycle$1
  implements CELifeCycle
{
  public void onFirstFrame()
  {
    QLog.d("[cmshow][CECMShowOffscreenEngine]", 4, "onFirstFrame");
    CECMShowOffscreenEngine.a(true);
    Iterator localIterator = ((Iterable)CECMShowOffscreenEngine.h()).iterator();
    while (localIterator.hasNext()) {
      ((CERenderService)localIterator.next()).c();
    }
  }
  
  public void onGameEnd()
  {
    QLog.d("[cmshow][CECMShowOffscreenEngine]", 4, "onGameEnd");
    CECMShowOffscreenEngine.Companion.b(CECMShowOffscreenEngine.a);
  }
  
  public void onInit()
  {
    QLog.d("[cmshow][CECMShowOffscreenEngine]", 4, "onInit");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CECMShowOffscreenEngine.Companion.genCEApplication.ceLifeCycle.1
 * JD-Core Version:    0.7.0.1
 */