package com.tencent.mobileqq.cmshow.crossengine;

import com.tencent.crossengine.CEApplication;
import com.tencent.crossengine.CELifeCycle;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/cmshow/crossengine/CECMShowEngine$initEngine$ceLifeCycle$1", "Lcom/tencent/crossengine/CELifeCycle;", "onFirstFrame", "", "onGameEnd", "onInit", "evaluateScript", "", "", "ceApp", "Lcom/tencent/crossengine/CEApplication;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CECMShowEngine$initEngine$ceLifeCycle$1
  implements CELifeCycle
{
  private final void a(@NotNull List<String> paramList, CEApplication paramCEApplication)
  {
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext()) {
      paramCEApplication.runScriptFile((String)paramList.next());
    }
  }
  
  public void onFirstFrame()
  {
    QLog.d(CECMShowEngine.a(this.a), 4, "onFirstFrame");
    Object localObject = CECMShowEngine.a(this.a).preloadScripts$cmshow_impl_release();
    if (localObject != null)
    {
      CEApplication localCEApplication = CECMShowEngine.a(this.a);
      if (localCEApplication == null) {
        Intrinsics.throwNpe();
      }
      a((List)localObject, localCEApplication);
    }
    localObject = CECMShowEngine.a(this.a);
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    ((CEEngineContext)localObject).a(true);
    localObject = CECMShowEngine.a(this.a);
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    ((CEScriptService)localObject).a();
  }
  
  public void onGameEnd()
  {
    QLog.d(CECMShowEngine.a(this.a), 4, "onGameEnd");
  }
  
  public void onInit()
  {
    QLog.d(CECMShowEngine.a(this.a), 4, "onInit");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CECMShowEngine.initEngine.ceLifeCycle.1
 * JD-Core Version:    0.7.0.1
 */