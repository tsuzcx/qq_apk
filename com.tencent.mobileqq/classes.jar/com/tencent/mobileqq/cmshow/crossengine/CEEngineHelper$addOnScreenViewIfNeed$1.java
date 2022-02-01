package com.tencent.mobileqq.cmshow.crossengine;

import android.view.ViewGroup;
import com.tencent.crossengine.CEApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "result", "", "<anonymous parameter 1>", "Lcom/tencent/crossengine/CEApplication;", "invoke"}, k=3, mv={1, 1, 16})
final class CEEngineHelper$addOnScreenViewIfNeed$1
  extends Lambda
  implements Function2<Boolean, CEApplication, Unit>
{
  CEEngineHelper$addOnScreenViewIfNeed$1(ViewGroup paramViewGroup)
  {
    super(2);
  }
  
  public final void invoke(boolean paramBoolean, @Nullable CEApplication paramCEApplication)
  {
    paramCEApplication = new StringBuilder();
    paramCEApplication.append("addOnScreenViewIfNeed tryInitCEApplication result:");
    paramCEApplication.append(paramBoolean);
    QLog.w("[cmshow][CECMShowOffscreenEngine][CEEngineHelper]", 1, paramCEApplication.toString());
    if (paramBoolean) {
      CEEngineHelper.a(CEEngineHelper.a, this.$container);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CEEngineHelper.addOnScreenViewIfNeed.1
 * JD-Core Version:    0.7.0.1
 */