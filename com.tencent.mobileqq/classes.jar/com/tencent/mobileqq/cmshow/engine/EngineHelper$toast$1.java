package com.tencent.mobileqq.cmshow.engine;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
public final class EngineHelper$toast$1
  extends Lambda
  implements Function0<Unit>
{
  public EngineHelper$toast$1(int paramInt, String paramString)
  {
    super(0);
  }
  
  public final void invoke()
  {
    QQAppInterface localQQAppInterface = EngineHelper.a.a();
    if (localQQAppInterface != null) {
      QQToast.makeText((Context)localQQAppInterface.getApplication(), this.$iconType, (CharSequence)this.$message, 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.EngineHelper.toast.1
 * JD-Core Version:    0.7.0.1
 */